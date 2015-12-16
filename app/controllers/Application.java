package controllers;

import controllers.Xml_edit;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import play.*;
import play.mvc.*;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import views.html.*;
import models.Account;
import models.Login;
import play.data.Form;
import static play.data.Form.form;
import play.filters.csrf.AddCSRFToken;
import play.filters.csrf.RequireCSRFCheck;

import java.net.URL;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Application extends Controller {
	public static Result index() {
		return ok(index.render("TOP"));
	}

	@AddCSRFToken
	public static Result call() {
		return ok(edit_call.render());
	}

	public static Result edit_menu() {
		return ok(edit_menu.render("","",""));
	}

	public static Result edit_page() {
		/* ユーザディレクトリ　チェック*/
		String[] nullLine = new String[1];
		nullLine[0] = "";
		return ok(edit_page.render("edit",nullLine,nullLine,"null"));
	}

	public static Result edit_head(String target_name) {
		if(target_name.equals("null")){target_name = "初期ページ";}
		String user_name = session("username");
		return ok(edit_head.render(target_name,user_name));
	}

	//	追加分
	@AddCSRFToken
	public static Result register() {
		Form<Account> f = new Form(Account.class);
		return ok(views.html.register.render("register",f));
	}

	/**
	 * 会員の新規作成
	 */
	
	@RequireCSRFCheck
	public static Result create() throws NoSuchAlgorithmException, IOException {
		Form<Account> f = new Form(Account.class).bindFromRequest();
		if (!f.hasErrors()) {
			Account data = new Account();
			data = f.get();
			data.password = models.Login.sha512(f.data().get("password"));
			data.save();
			
			//DB接続設定
			String dir = System.getProperty("user.dir");
			String username = f.data().get("username");
			
			File udir = new File(dir+"/user/"+username);
			File imgdir = new File(dir+"/user/"+username+"/images");//ユーザ下の画像用ディレクトリ
			udir.mkdir();
			imgdir.mkdir();
			File file = new File(dir+"/conf/application.conf");
			FileWriter fw = new FileWriter(file,true);
			fw.write("db."+username+".driver=org.h2.Driver\n");
			fw.write("db."+username+".url="+'"'+"jdbc:h2:file:"+username+'"'+"\n");			
			fw.close();
			
			//スクリプト生成
			String n = dir+"/conf/evolutions/"+username;
			File evo = new File(n);
			evo.mkdir();
			File sql = new File(n+"/1.sql");
			PrintWriter pw = new PrintWriter(sql);
			pw.println("# articles");
			pw.println("# --- !Ups");
			pw.println("create table articles (");
			pw.println("	id	bigint not null,");
			pw.println("	title	varchar(255) not null,");
			pw.println("	body	text not null,");
			pw.println("	release	date not null,");
			pw.println("	primary key(id),");
			pw.println(");");
			pw.println("create sequence articles_seq;");
			pw.println("# --- !Downs");
			pw.println("drop table articles");
			pw.close();
			
			
			return redirect("/");
			
		} else {
			return badRequest(views.html.register.render("ERROR", f));
		}
	}



	/**
	 * ログインフォーム
	 * @return
	 */
	@AddCSRFToken
	public static Result login() {
		return ok(login.render(form(Login.class)));
	}

	/**
	 * 認証アクション
	 * @return
	 */
	@RequireCSRFCheck
	public static Result authenticate() {
		Form<Login> loginForm = form(Login.class).bindFromRequest();
		String Username = (String)loginForm.get().getUsername();
		if (loginForm.hasErrors()) {
			return badRequest(views.html.login.render(loginForm));
		} else {
			session("username", Username);
			String returnUrl = ctx().session().get("returnUrl");
			if(returnUrl == null || returnUrl.equals("") || returnUrl.equals(routes.Application.login().absoluteURL(request()))) {
				returnUrl = routes.Application.index().url();
				returnUrl+=Username;
			}
			return redirect(returnUrl);
		}
	}

	/**
	 * ログアウトアクション
	 * @return
	 */
	@play.mvc.Security.Authenticated(models.Secured.class)
	public static Result logout() {
		session().clear();
		return redirect(routes.Application.index());
	}


	//アカウントページ
	public static Result userPage(String name) {
		//System.out.println(name.equals(session("username")));
		if(name.equals(session("username"))) {
			//System.out.println("seikou!:)");
			return ok(user_page.render(name));
		} else {
			//System.out.println("name:        "+name);
			//System.out.println("sessionname: "+session("username"));
			//System.out.println("sippai...X(");
			return redirect(routes.Application.index());
		}
	}
	/**
	 * ページ新規作成アクション
	 */
	public static Result dicition_name(){
		return ok(edit_new_page.render(""));
	}

	@RequireCSRFCheck
	public static Result new_page(){
		String name = Form.form().bindFromRequest().get("name");
		String type = Form.form().bindFromRequest().get("type");
		create_page(name,type);
		String[] headLine = get_headLine(name);
		String[] htmlLine = input_file(name);
		return ok(edit_page.render("edit",headLine,htmlLine,name));
	}

	public static void create_page(String name,String type){
		if("standard".equals(type)){
			create_standard_page(name);
		}else if("blog".equals(type)){
			create_blog_page(name);
		}
	}

	public static void create_standard_page(String name){
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + name + ".html");
		PrintWriter pw = null;
		try {
			// 出力ストリームを生成します。
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream(file)));
			// ここでファイルに文字を書き込みます。
			pw.println("<!DOCTYPE html>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>" + name + "</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div id='0' class='pchan context text edit'><h1>"+name+"</h1></div>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	public static void create_blog_page(String name){
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + name + ".html");
		PrintWriter pw = null;
		try {
			// 出力ストリームを生成します。
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream(file)));
			pw.println("<!DOCTYPE html>");
			pw.println("<meta charset='utf-8'>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>" + name + "</title>");
			pw.println("<style type='text/css'>");
			pw.println("html,body{margin:0;padding:0;height:100%;width:100%;}");
			pw.println("div#contents{background-color:#999;position:relative;min-height:100%;}");
			pw.println("#header-bk{background-color:rgb(255,0,0);padding:10px 0px 0px;height:120px;width:100%;}");
			pw.println("#header{height:120px;margin:auto;}");
			pw.println("#left-sidebar-bk{float:left;background-color:rgb(0,255,0);width:200px;height:600px;overflow:scroll;}");
			pw.println("#left-sidebar{}");
			pw.println("#right-sidebar-bk{float:right;background-color:rgb(0,0,255);width:200px;height:600px;overflow:scroll;}");
			pw.println("#right-sidebar{}");
			pw.println("#body-bk{background-color:rgb(126,126,126);height:600px;overflow:scroll;}");
			pw.println("#body{}");
			pw.println("#footer-bk{background-color:rgb(255,255,153);width:100%;height:50px;position:absolute;bottom:0px;padding:10px 0;}");
			pw.println("#footer{height:50px;margin:auto;}");
			pw.println("</style>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<div id='contents'>");
			pw.println("<div id='header-bk'>");
			pw.println("<div id='header'>");
			pw.println("<h1>ブログ</h1>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("<div id='left-sidebar-bk'>");
			pw.println("<div id='left-sidebar'>");
			pw.println("<h2>左メニュー</h2>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("<div id='right-sidebar-bk'>");
			pw.println("<div id='right-sidebar'>");
			pw.println("<h2>右メニュー</h2>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("<div id='body-bk'>");
			pw.println("<div id='body'>");
			pw.println("<h2>ボディ</h2>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("<div id='footer-bk'>");
			pw.println("<div id='footer'>");
			pw.println("<p>copyright (c) oooo.com All right reserved. </p>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("</div>");
			pw.println("</body>");
			pw.println("</html>");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
	/**
	 * ディレクトリ作成アクション (現状は動いていません。)
	 */
	/*
     File newdir = new File("c:¥¥tmp¥¥sub");
     newdir.mkdir();
	 */

	/**
	 * 保存アクション
	 */
    static public final String DATE_PATTERN ="yyyy/MM/dd HH:mm:ss";
	@RequireCSRFCheck
	public static Result save(){
		String name = Form.form().bindFromRequest().get("name");
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + name + ".html");
		PrintWriter pw = null;
		String[] source = null;
		String Head = Form.form().bindFromRequest().get("head");
		String Html = Form.form().bindFromRequest().get("html");
        Date date = new Date();
        int start_comment_index = Html.indexOf("<div id=\"comments\">");
        if(start_comment_index != -1){
            start_comment_index += 19;
            //System.out.println(start_comment_index);
            String remove_start_comment_HTML = Html.substring(start_comment_index,Html.length());
            //System.out.println(remove_start_comment_HTML);
            int end_comment_index = remove_start_comment_HTML.indexOf("</div>")+start_comment_index;
            //System.out.println(end_comment_index);
            Html = Html.substring(0,start_comment_index)+Html.substring(end_comment_index,Html.length());
            System.out.println(Html);
            Html.replaceAll("<div id=\"comments\">", "<div id=\"comments\"></div>");
        }
        int start_blog_index = Html.indexOf("<div id=\"article\">");
        if(start_blog_index != -1){
            //System.out.println("start_blog_index:"+start_blog_index);
        }
        
		try {
			// 出力ストリームを生成します。
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream(file)));

			pw.println("<!DOCTYPE html>");
			pw.println("<html>");
			pw.println("<head>");
			pw.println(Head);
			pw.println("</head>");
			pw.println("<body>");
			pw.println(Html);
			pw.println("</body>");
			pw.println("</html>");

			//            for(int i = 0; i < source.length; i++){
			//            	pw.println(source[i]);
			//            } 
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
        if(Html.matches(".*comments.*")){
            File xmlfile = new File(dir + "/user/" + session("username") + "/" + name + ".xml");
            if(xmlfile.exists()){
                System.out.println("既に指定のxmlファイルは存在しています。 :"+xmlfile);
            }else{
                pw = null;
                try {
                    pw = new PrintWriter(
                                         new OutputStreamWriter(
                                                                new FileOutputStream(xmlfile)));
                    pw.println("<?xml version='1.0' encoding='utf-8' standalone='no'?><list></list>");
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    if (pw != null) {
                        pw.close();
                    }
                }
            }
        }
        String str;
        if(start_blog_index != -1){
            File xmlfile = new File(dir + "/user/" + session("username") + "/" + name + "_articles.xml");
            str = new SimpleDateFormat(DATE_PATTERN).format(date);
            if(xmlfile.exists()){
                System.out.println("既に指定のxmlファイルは存在しています。: "+xmlfile);
            }else{
                pw = null;
                try {
                    pw = new PrintWriter(
                                         new OutputStreamWriter(
                                                                new FileOutputStream(xmlfile)));
                    pw.println("<?xml version='1.0' encoding='utf-8' standalone='no'?><articles>");
                    pw.println("<article><id>1</id><date>"+ str +"</date><title>サンプル</title><maintext>サンプル文章です。</maintext></article></articles>");
                    
                } catch (IOException e) {
                    System.out.println(e);
                } finally {
                    if (pw != null) {
                        pw.close();
                    }
                }
            }
        }
		return redirect("/edit_head/target/null");
	}

	public static Result change(){
		String dir = System.getProperty("user.dir");
		File filedir = new File(dir + "/user/" + session("username"));
		int files_length = 0;
		int files_pointer = 0;
		File[] files = filedir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if(file.getName().indexOf(".html") != -1){
				files_length++;
			}
		}
		String[] fileNames = new String[files_length];
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if(file.getName().indexOf(".html") != -1){
				fileNames[files_pointer] = file.getName().replace(".html","");
				files_pointer++;
			}
		}

		String[] optFileNames = optimization(fileNames);

		//    	System.out.println("");
		//    	System.out.println("---出力開始---");
		//    	for (int i = 0; i < optFileNames.length; i++) {
		//    		System.out.println(optFileNames[i]);
		//    	}
		//    	System.out.println("---出力完了---");
		//    	System.out.println("");

		return ok(edit_change_page.render(optFileNames));
	}

	/**
	 * 配列の最適化アクション
	 */
	public static String[] optimization(String[] nameArray){
		int length = nameArray.length;
		for(int i = 0; i < nameArray.length; i++){
			if(nameArray[i].startsWith(".")){
				for(int j = i; j < nameArray.length - 1; j++){
					nameArray[j] = nameArray[j+1];
				}
				length--;
			}
		}
		String[] optFileArray = new String[length];
		for(int i = 0; i < length; i++){
			optFileArray[i] = nameArray[i];
		}
		return optFileArray;
	}

	public static Result render_file(String fileName) {
		String[] headLine = get_headLine(fileName);
		String[] htmlLine = input_file(fileName);
		return ok(edit_page.render("edit",headLine,htmlLine,fileName));
	}

	public static String[] get_headLine(String fileName) {
		int lineLength = 0;
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + fileName + ".html");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			while(str != null){
				str = br.readLine();
				if(str.startsWith("<head>")){
					lineLength--;
					while(str != null){
						lineLength++;
						str = br.readLine();
						if(str.startsWith("</head>")){
							lineLength--;
							br.close();
						}
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		String[] headLine = new String[lineLength];
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			int linePosition = 0;
			while(str != null){
				str = br.readLine();
				if(str.startsWith("<head>")){
					while(str != null){
						str = br.readLine();
						if(str.startsWith("</head>")){
							br.close();
						}else{
							headLine[linePosition] = str;
							linePosition++;
						}
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		return headLine;
	}

	public static String[] input_file(String fileName) {
		int lineLength = 0;
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + fileName + ".html");
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			while(str != null){
				str = br.readLine();
				if(str.startsWith("<body>")){
					lineLength--;
					while(str != null){
						lineLength++;
						str = br.readLine();
						if(str.startsWith("</body>")){
							lineLength--;
							br.close();
						}
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		String[] htmlLine = new String[lineLength];
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			int linePosition = 0;
			while(str != null){
				str = br.readLine();
				if(str.startsWith("<body>")){
					while(str != null){
						str = br.readLine();
						if(str.startsWith("</body>")){
							br.close();
						}else{
							htmlLine[linePosition] = str;
							linePosition++;
						}
					}
				}
			}
			br.close();
		}catch(FileNotFoundException e){
		}catch(IOException e){
		}
		return htmlLine;
	}

	public static String[] getSourceText(URL url) throws IOException{
		int lineLength = 0;
		InputStream in = url.openStream();
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			String s;
			while ((s=bf.readLine())!=null) {
				lineLength++;
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
		System.out.println(lineLength);
		System.out.println();
		String[] sb = new String[lineLength];
		int linePossition = 0;
		try {
			in = url.openStream();
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			String s;
			while ((s=bf.readLine())!=null) {
				sb[linePossition] = s;
				linePossition++;
			}
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			in.close();
		}
		for(int i = 0; i < sb.length; i++){
			System.out.println(sb[i]);
		}
		return sb;
	}
	
	public static Result link(){
		String dir = System.getProperty("user.dir");
		File filedir = new File(dir + "/user/" + session("username"));
		int files_length = 0;
		int files_pointer = 0;
		File[] files = filedir.listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if(file.getName().indexOf(".html") != -1){
				files_length++;
			}
		}
		String[] fileNames = new String[files_length];
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if(file.getName().indexOf(".html") != -1){
				fileNames[files_pointer] = file.getName().replace(".html","");
				files_pointer++;
			}
		}
		String[] optFileNames = optimization(fileNames);
		return ok(choose_link.render(optFileNames));
	}
	
	
	public static Result choose_link(){
		String name = Form.form().bindFromRequest().get("name");
		String dir = System.getProperty("user.dir");
		String filedir = dir + "/user/" + session("username") + "/" + name + ".html";
		String type = "button";
		return ok(edit_menu.render(name,filedir,type));
	}
	
	public static Result addlink(){
		return ok(put_link.render());
	}
	
	public static Result put_link(){
		String text = Form.form().bindFromRequest().get("TEXT");
		String url = Form.form().bindFromRequest().get("URL");
		String type = "text";
		System.out.println(text+" "+url+" "+type);
		return ok(edit_menu.render(text,url,type));
	}
	
	
	/*
	 * 画像ファイルのアップロード
	 */
	public static Result upload() {
		String udir = System.getProperty("user.dir");
		String name = session("username");
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart img = body.getFile("image");
			//ファイル受け取り成功時
		  if (img != null) {
		    String fileName = img.getFilename();
		    String contentType = img.getContentType(); //ファイルの種類
		    System.out.println("ファイル名："+fileName);
		    System.out.println("ファイルタイプ："+contentType);
		    File file = img.getFile();
		    String toPath = udir+"/user/"+name+"/images/";
		    System.out.println(toPath);
		    if(file.renameTo(new File(toPath, fileName))){
		    	System.out.println("成功");
		    } else {
		    	System.out.println("失敗");
		    }
		    String uri =toPath+fileName;
		    return ok(sendimage.render(fileName,name));
		  } else {
			  //ファイル受け取り失敗時
		    return ok("file upload failed..");    
		  }
	}
    
    /*
     * テキストに対してコンテキストメニューでのリンク付与
     */
    
    @RequireCSRFCheck
    public static Result edit_text(){
        String id = Form.form().bindFromRequest().get("id");
        return ok(edit_text.render(id));/*,textbox,result*/
    }
    
    @RequireCSRFCheck
    public static Result edit_text_save(){
        String id = Form.form().bindFromRequest().get("ID");
        String innerHTML = Form.form().bindFromRequest().get("text");
        String url_count = Form.form().bindFromRequest().get("url_count");
        int length = new Integer(url_count).intValue();
        String url[] = new String[length];
        for(int i=0; i<length; i++){
            url[i] = Form.form().bindFromRequest().get("url0"+String.valueOf(i));
        }
        String innerText = innerHTML.replaceAll("\r\n", "#BR#");
        innerText = innerText.replaceAll("\r\n", "#BR#");
        innerText = innerText.replaceAll("\r\n", "#BR#");
        return ok(edit_text_save.render(id,innerText,url));
    }
    @RequireCSRFCheck
    public static Result data_add(){
        String user_name = Form.form().bindFromRequest().get("un");
        String file_name = Form.form().bindFromRequest().get("fn");
        String name = Form.form().bindFromRequest().get("name");
        String comment = Form.form().bindFromRequest().get("comment");
        System.out.println(file_name);
        String xmlFileDir = "user/"+user_name+"/"+file_name+".xml";
        Xml_edit xml = new Xml_edit();
        try {
            xml.domCommentAdd(xmlFileDir,name,comment);
            System.out.println("OK: xml.domCommentAdd()");
        } catch (TransformerException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
        } catch (ParserConfigurationException e) {
        }
        String url = "/cwa/"+user_name+"/"+file_name;
        System.out.println("Url: "+url);
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return redirect(url);
    }
    public static Result view(String user_name, String file_name){
        String dir = System.getProperty("user.dir");
        String file_dir = dir+"/user/"+user_name+"/"+file_name+".html";
        int lineLength = 0;
        String[] sub_strings = new String[50000];
        try{
            File file = new File(file_dir);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while((str = br.readLine()) != null){
                sub_strings[lineLength] = str;
                lineLength++;
            }
            br.close();
        }catch(FileNotFoundException e){
            System.out.println("view: "+e);
        }catch(IOException e){
            System.out.println("view: "+e);
        }
        String[] strings = new String[lineLength];
        for(int i=0;i<lineLength;i++){
            if(strings[i] != "null"){
                strings[i] = sub_strings[i];
            }
        }
        return ok(file_view.render(strings));
    }
    
    public static Result blog_data_read(){
        List<String> blog_list = null;
        String user_name = session("username");
        String page_name = Form.form().bindFromRequest().get("page_name");
        System.out.println(page_name+" "+user_name);
        String file_name = page_name+"_articles";
        String xmlFileDir = "user/"+user_name+"/"+file_name+".xml";
        Xml_edit xml = new Xml_edit();
        try {
            blog_list = xml.domBlogRead(xmlFileDir);
            System.out.println("OK: xml.domBlogRead()");
        } catch (SAXException e) {
        } catch (IOException e) {
        } catch (ParserConfigurationException e) {
        }
        String[] blog_id = new String[blog_list.size()/3];
        String[] blog_title = new String[blog_list.size()/3];
        String[] blog_value = new String[blog_list.size()/3];
        for(int i = 0; i < blog_list.size()/3; i++){
            blog_id[i] = blog_list.get(i*3+0);
            blog_title[i] = blog_list.get(i*3+1);
            blog_value[i] = blog_list.get(i*3+2);
        }
        System.out.println("id:");
        for(int i = 0; i < blog_id.length; i++){
            System.out.println(blog_id[i]);
        }
        System.out.println("title:");
        for(int i = 0; i < blog_title.length; i++){
            System.out.println(blog_title[i]);
        }
        System.out.println("value:");
        for(int i = 0; i < blog_value.length; i++){
            System.out.println(blog_value[i]);
        }
        /*
         String url = "/cwa/"+user_name+"/"+file_name;
         System.out.println("Url: "+url);
         try {
	        Thread.sleep(3 * 1000);
         } catch (InterruptedException e) {
	        e.printStackTrace();
         }
         */
        return ok(edit_blog.render(blog_id,blog_title,blog_value,user_name,page_name));
    }
    
    public static Result blog_data_edit(){
        List<String> blog_list = null;
        String user_name = session("username");
        String id = Form.form().bindFromRequest().get("id");
        String title = Form.form().bindFromRequest().get("title");
        String main_text = Form.form().bindFromRequest().get("main_text");
        String page_name = Form.form().bindFromRequest().get("page_name");
        String file_name = page_name+"_articles";
        String xmlFileDir = "user/"+user_name+"/"+file_name+".xml";
        String type = Form.form().bindFromRequest().get("save_type");
        System.out.println("blog_data_save() start:");
        System.out.println("id:"+id);
        System.out.println("title:"+title);
        System.out.println("main_text:"+main_text);
        System.out.println("xmlFileDir:"+xmlFileDir);
        System.out.println("page_name:"+page_name+", user_name:"+user_name);
        System.out.println("type:"+type);
        Xml_edit xml = new Xml_edit();
        try {
            if(type.equals("change")){
                xml.domBlogChange(xmlFileDir,id,title,main_text);
                System.out.println("OK: xml.domBlogChange()");
            }else if(type.equals("add")){
                xml.domBlogAdd(xmlFileDir);
                System.out.println("OK: xml.domBlogAdd()");
            }else if(type.equals("delete")){
                xml.domBlogDelete(xmlFileDir,id);
                System.out.println("OK: xml.domBlogDelete()");
            }
            blog_list = xml.domBlogRead(xmlFileDir);
            System.out.println("OK: xml.domBlogRead()");
        } catch (TransformerException e) {
        } catch (SAXException e) {
        } catch (IOException e) {
        } catch (ParserConfigurationException e) {
        }
        String[] blog_id = new String[blog_list.size()/3];
        String[] blog_title = new String[blog_list.size()/3];
        String[] blog_value = new String[blog_list.size()/3];
        for(int i = 0; i < blog_list.size()/3; i++){
            blog_id[i] = blog_list.get(i*3+0);
            blog_title[i] = blog_list.get(i*3+1);
            blog_value[i] = blog_list.get(i*3+2);
        }
        System.out.println("id:");
        for(int i = 0; i < blog_id.length; i++){
            System.out.println(blog_id[i]);
        }
        System.out.println("title:");
        for(int i = 0; i < blog_title.length; i++){
            System.out.println(blog_title[i]);
        }
        System.out.println("value:");
        for(int i = 0; i < blog_value.length; i++){
            System.out.println(blog_value[i]);
        }
        
        return ok(edit_blog.render(blog_id,blog_title,blog_value,user_name,page_name));
    }
    public static Result edit_blog(){
        String dir = System.getProperty("user.dir");
        String user = session("username");
        File filedir = new File(dir + "/user/" + session("username"));
        int files_length = 0;
        int files_pointer = 0;
        File[] files = filedir.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if(file.getName().indexOf("_articles.xml") != -1){
                files_length++;
            }
        }
        String[] fileNames = new String[files_length];
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if(file.getName().indexOf("_articles.xml") != -1){
                fileNames[files_pointer] = file.getName().replace("_articles.xml","");
                files_pointer++;
            }
        }
        String[] optFileNames = optimization(fileNames);
        for (int i = 0; i < optFileNames.length; i++) {
            System.out.println(optFileNames[i]);
        }
        return ok(edit_blog_home.render(user,optFileNames));
    }
}