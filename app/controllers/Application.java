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
		return ok(edit_call.render(""));
	}

	public static Result edit_menu() {
		return ok(edit_menu.render());
	}

    public static Result edit_page() {
        /* ユーザディレクトリ　チェック*/
        String[] nullLine = new String[1];
        nullLine[0] = "";
        return ok(edit_page.render("edit",nullLine,"null"));
    }
    
    public static Result edit_head(String target_name) {
    	if(target_name.equals("null")) target_name = "初期ページ";
        return ok(edit_head.render(target_name));
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
		if (loginForm.hasErrors()) {
			return badRequest(views.html.login.render(loginForm));
		} else {
			session("username", loginForm.get().getUsername());
			String returnUrl = ctx().session().get("returnUrl");
			if(returnUrl == null || returnUrl.equals("") || returnUrl.equals(routes.Application.login().absoluteURL(request()))) {
				returnUrl = routes.Application.index().url();
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
		System.out.println(name.equals(session("username")));
		if(name.equals(session("username"))) {
			System.out.println("seikou!:)");
			return ok(user_page.render(""));
		} else {
			System.out.println("name:        "+name);
			System.out.println("sessionname: "+session("username"));
			System.out.println("sippai...X(");
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
        create_page(name);
        String[] htmlLine = input_file(name);
        return ok(edit_page.render("edit",htmlLine,name));
    }
    
    public static void create_page(String name){
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
            pw.println("<html>");
            pw.println("<head><title>" + name + "</title></head>");
            pw.println("<body>");
            pw.println("<h1>" + name + "</h1>");
            pw.println("<p>これはcreate_pageにて作成されました。</p>");
            pw.println("</body>");
            pw.println("</html>");
            
            //System.out.println("ファイルの作成に成功しました!"); //作成後に、特定のファイルを呼び出す場合の処理が未実装
            //制作時は、サーバから表示するページのデータを取得し、1行ずつ読む工程で描画する必要性あり。
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // クローズ処理（成功・失敗に関わらず必ずクローズします。）
            // クローズ漏れはバグのもとになります。必ずfinally句でクローズしましょう。
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
    	System.out.println(name);
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/user/" + session("username") + "/" + name + ".html");  //どのファイルを変更するかの定義が未実装
        PrintWriter pw = null;
        String[] source = null;
        String Html = Form.form().bindFromRequest().get("html");
        
        try {
            // 出力ストリームを生成します。
            pw = new PrintWriter(
                                 new OutputStreamWriter(
                                                        new FileOutputStream(file)));
            
            
            // ここでファイルに文字を書き込みます。
            
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head><title>" + name + "</title></head>");
            pw.println("<body>");
            pw.println(Html);
            pw.println("</body>");
            pw.println("</html>");
            
//            for(int i = 0; i < source.length; i++){
//            	pw.println(source[i]);
//            } 
            
            System.out.println("ファイルの書き込みに成功しました!");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            // クローズ処理（成功・失敗に関わらず必ずクローズします。）
            // クローズ漏れはバグのもとになります。必ずfinally句でクローズしましょう。
            if (pw != null) {
                pw.close();
            }
        }
        return redirect("/edit_head/null");
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
    	String[] htmlLine = input_file(fileName);
        return ok(edit_page.render("edit",htmlLine,fileName));
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
