package controllers;

import java.security.NoSuchAlgorithmException;

import play.*;
import play.mvc.*;
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
		return ok(edit_menu.render());
	}

    public static Result edit_page() {
        /* ユーザディレクトリ　チェック*/
        String[] nullLine = new String[1];
        nullLine[0] = "";
        return ok(edit_page.render("edit",nullLine,nullLine,"null"));
    }
    
    public static Result edit_head(String target_name) {
    	if(target_name.equals("null")) target_name = "初期ページ";
    	String user_name = session("username");
        return ok(edit_head.render(target_name,user_name));
    }
	
//	追加分
	@AddCSRFToken
	public static Result register() {
		Form<Account> f = new Form(Account.class);
		return ok(views.html.register.render("register",f));
	}
	
	@RequireCSRFCheck
	public static Result create() throws NoSuchAlgorithmException {
		Form<Account> f = new Form(Account.class).bindFromRequest();
		if (!f.hasErrors()) {
			Account data = new Account();
			data = f.get();
			data.password = models.Login.sha512(f.data().get("password"));
			data.save();
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
        File userdir = new File(dir + "/user/" + session("username") + "/");
        /* ディレクトリ作成 */
        if(userdir.exists()){
            //System.out.println("Found User " + session("username"));
        }else{
            //System.out.println("Not Found User " + session("username"));
            userdir.mkdir();
        }
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
            pw.println("<h1>" + name + "</h1>");
            pw.println("<p>これはcreate_pageにて作成されました。</p>");
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
        File userdir = new File(dir + "/user/" + session("username") + "/");
        /* ディレクトリ作成 */
        if(userdir.exists()){
            //System.out.println("Found User " + session("username"));
        }else{
            //System.out.println("Not Found User " + session("username"));
            userdir.mkdir();
        }
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
        return redirect("/edit_head?target_name="+name+"&user_name="+session("username"));
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
    	edit_head(fileName);
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
}
