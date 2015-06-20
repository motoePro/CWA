package controllers;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
    public static Result index() {
        return ok(index.render(""));
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
}
