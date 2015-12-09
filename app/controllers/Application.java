package controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

import org.w3c.dom.*;


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
			pw.println("<html style=\"width:100%;height:100%;\">");
			pw.println("<head>");
			pw.println("<title>" + name + "</title>");
			pw.println("</head>");
			pw.println("<body　style=\"width:100%;height:100%;\">");
			pw.println("<div id="+'"'+"container"+'"'+" style="+'"'+"width:100%;height:100%;"+'"'+">");
			pw.println("<h1>"+name+"</h1>");
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
	@RequireCSRFCheck
	public static Result save(){
		String name = Form.form().bindFromRequest().get("name");
		String dir = System.getProperty("user.dir");
		File file = new File(dir + "/user/" + session("username") + "/" + name + ".html");
		PrintWriter pw = null;
		String[] source = null;
		String Head = Form.form().bindFromRequest().get("head");
		String Html = Form.form().bindFromRequest().get("html");

		try {
			// 出力ストリームを生成します。
			pw = new PrintWriter(
					new OutputStreamWriter(
							new FileOutputStream(file)));

			pw.println("<!DOCTYPE html>");
			pw.println("<html style=\"width:100%;height:100%;\">");
			pw.println("<head>");
			pw.println(Head);
			pw.println("</head>");
			pw.println("<body style=\"width:100%;height:100%;\">");
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
		return redirect("/edit_head/target/null");
	}

	public static Result change(){
		String dir = System.getProperty("user.dir");
		File filedir = new File(dir + "/user/" + session("username"));
		File[] files = filedir.listFiles();
		String[] fileNames = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			fileNames[i] = file.getName().replace(".html","");
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
				if(str.startsWith("<body")){
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
				if(str.startsWith("<body")){
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
		File[] files = filedir.listFiles();
		String[] fileNames = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			fileNames[i] = file.getName().replace(".html","");
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


	//背景設定画面
	public static Result selectBg() {
		return ok(selectbg.render());
	}

	//背景画像追加(アップロード＋現在の編集ページに適応)
	public static Result setBg() {
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart img = body.getFile("bgimage");
		//ファイル受け取り成功時
		if (img != null) {
			String udir = System.getProperty("user.dir");
			String fileName = img.getFilename();
			String contentType = img.getContentType(); //ファイルの種類
			String name = session("username");
			System.out.println("ファイル名："+fileName);
			System.out.println("ファイルタイプ："+contentType);
			File file = img.getFile();
			//ファイルの保存
			String toPath = udir+"/user/"+name+"/images/";
			System.out.println(toPath);
			if(file.renameTo(new File(toPath, fileName))){
				System.out.println("画像保存成功");
			} else {
				System.out.println("画像保存失敗");
			}
			//現在ページに背景を適応
			System.out.println("全画面に適応?:"+form().bindFromRequest().data().get("setAll"));
			if(form().bindFromRequest().data().get("setAll") != null) {
				//全てのページに背景を適応
				File[] pages = getPages(name);//ページの配列
				
			
				System.out.println("持ってるページ一覧");
				
				for(File p: pages) {
					System.out.println(p);
					try {
						BufferedReader br = new BufferedReader(new FileReader(p));
						StringBuffer sb = new StringBuffer();
						String str;
						//String regex = "<div id="+'"'+"container"+'"'+",style="+'"'+"width:100%;height:100%"+'"'+",background-image="+'"'+routes.Assets.at("/user", name+"/images/"+fileName)+'"'+">";
						String regex = "<div id=\"container\" style=\"background-image:url("+routes.Assets.at("/user", name+"/images/"+fileName)+");width:100%;height:100%;\">";
						String oldChar = "<div id=\"container\".*;\">";
						System.out.println("挿入予定の文章");
						System.out.println(regex);
						System.out.println("置換対象");
						System.out.println(oldChar);
						//<div id="container",style="width:100%;height:100%">
						try {
							
							while((str = br.readLine()) != null) {
								Pattern pat = Pattern.compile(oldChar);
								//System.out.println("pat::::"+pat);
								Matcher m = pat.matcher(str);
								str = m.replaceFirst(regex);
								//"<div id="+'"'+"container"+'"'+",style="+'"'+"width:100%;height:100%;"+'"'+">"
								
								sb.append(str+"\n");
								System.out.println(str);
							
							}
							System.out.println();
							br.close();
							PrintWriter pw = new PrintWriter(p);
							pw.print(sb);
							pw.close();
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					} catch (FileNotFoundException e) {//fileが見つからないよ
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				return ok("checked");
			} else {
				//現在のページにのみ背景を追加
				System.out.println("このぺーじにだけ背景を設定するよ!");
				return ok(setbg.render(fileName,name));
			}

		} else {//ファイルが選択されていない
			return ok("Set Background Image Failed...");
		}	
	}

	//ユーザの持っているファイル(ディレクトリ)一覧の取得
	static File[] getPages(String name){
		String udir = System.getProperty("user.dir");
		File fdir = new File(udir + "/user/" + name);
		File[] pages = fdir.listFiles();
		//ページ(htmlファイル)のみ出力
		int pcnt = 0;
		System.out.println("--ページ一覧--");
		for(File p: pages) {
			if(p.isFile() && p.getPath().endsWith(".html")) {System.out.println(p);pcnt++;}
		}
		System.out.println("---ファイル数"+pcnt+"----");
		File[] html = new File[pcnt];
		int i =0;
		for(File p: pages) {
			if(p.isFile() && p.getPath().endsWith(".html")) {html[i] = p;System.out.println(html[i]);i++;}
		}
		
		return html;

	}

}