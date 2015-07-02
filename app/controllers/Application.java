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

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;

import org.w3c.dom.*;


public class Application extends Controller {
	public static Result index() {
		return ok(index.render("TOP"));
	}

	public static Result call() {
		return ok(edit_call.render(""));
	}

	public static Result edit_menu() {
		return ok(edit_menu.render());
	}

	public static Result edit_page() {
		return ok(edit_page.render("edit"));
	}
    public static Result edit_head() {
        return ok(edit_head.render());
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
    
    public static Result new_page(){
        String name = Form.form().bindFromRequest().get("name");
        System.out.println(name);
        create_page(name);
        return redirect("/edit_page");
    }
    
    public static void create_page(String name){
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        File file = new File(dir + "/user/" + name + ".html");
        PrintWriter pw = null;
        try {
            // 出力ストリームを生成します。
            pw = new PrintWriter(
                                 new OutputStreamWriter(
                                                        new FileOutputStream(file)));
            // ここでファイルに文字を書き込みます。
            pw.println("<!DOCTYPE html>");
            pw.println("<html>");
            pw.println("<head><title>新規作成</title></head>");
            pw.println("<body>");
            pw.println("<h1>新規ページ</h1>");
            pw.println("<p>これはcreate_pageにて作成されました。</p>");
            pw.println("</body>");
            pw.println("</html>");
            
            System.out.println("ファイルの作成に成功しました!"); //作成後に、特定のファイルを呼び出す場合の処理が未実装
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
    public static Result save(){
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/user/" + "test.html");  //どのファイルを変更するかの定義が未実装
        PrintWriter pw = null;
        try {
            // 出力ストリームを生成します。
            pw = new PrintWriter(
                                 new OutputStreamWriter(
                                                        new FileOutputStream(file)));
            
            
            // ここでファイルに文字を書き込みます。
            pw.println("stringその1");
            pw.println("stringその2");
            
            
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
        return redirect("/edit_head");
    }
    
    /**
     * 構文解析アクション
     */
    /*
     public static Result analysis() throws SAXException, IOException{
     // DOMを解釈するパーサを準備
     DOMParser parser = new DOMParser();
     parser.setFeature("http://xml.org/sax/features/namespaces", false);
     
     // 引数があれば第１引数をurlStrにセット、なければ"test.html"をセット
     // String urlStr = args.length>0 ? args[0] : "test.html";
     String urlStr =  "/edit_page";
     System.out.println("SOURCE URL: " + urlStr); //urlStrを表示
     
     // 出力ファイル名を生成
     //$は一番最後のという正規表現
     String dir = System.getProperty("user.dir");
     System.out.println(dir);
     File file = new File(dir + "/test.txt");
     //String resultFileName = urlStr.replaceAll("../data", "../result").replaceAll("html$", "image_and_text");
     String resultFileName = dir + "/test.txt";
     System.out.println(resultFileName);
     
     // 出力ファイルをオープン
     FileOutputStream fos = new FileOutputStream(resultFileName);
     OutputStreamWriter osw = new OutputStreamWriter(fos , "UTF-8");
     BufferedWriter bw = new BufferedWriter(osw);
     
     // urlStrのファイルをパーサで読み込み、parserにDOMツリーを生成
     parser.parse(urlStr);
     // parser内のDOMツリーのドキュメントノードをdocumentにセットする
     Document document =parser.getDocument();
     // 指定したタグ名にもつ要素を全て取得する
     NodeList nodeList = document.getElementsByTagName("title");
     // 各要素を出力ファイルに出力する
     for(int i=0; i < nodeList.getLength(); i++){
     Element element = (Element)nodeList.item(i);
     System.out.println(element.getTextContent());
     
     // outTextを出力ファイルに出力
     // bw.write(outText);
     }
     
     // 出力が完了したら出力ファイルを閉じる
     bw.close();
     osw.close();
     fos.close();
     return redirect("/edit_menu");
     
     }
     */

}
