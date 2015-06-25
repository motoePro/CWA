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
	
}
