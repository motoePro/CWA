// @SOURCE:/Users/woon/Documents/workspace/CWA/conf/routes
// @HASH:b85ea6645b7319a3e60f33ceb697c4cf2257a9dc
// @DATE:Wed Jun 24 14:16:58 JST 2015


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:10
private[this] lazy val controllers_Application_index2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("index"))))
        

// @LINE:11
private[this] lazy val controllers_Application_call3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call"))))
        

// @LINE:12
private[this] lazy val controllers_Application_edit_menu4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_menu"))))
        

// @LINE:13
private[this] lazy val controllers_Application_edit_page5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_page"))))
        

// @LINE:16
private[this] lazy val controllers_Application_login6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:17
private[this] lazy val controllers_Application_authenticate7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate"))))
        

// @LINE:18
private[this] lazy val controllers_Application_logout8 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:20
private[this] lazy val controllers_Application_register9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:21
private[this] lazy val controllers_Application_create10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("create"))))
        

// @LINE:22
private[this] lazy val controllers_Application_userPage11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("username", """[^/]+""",true))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index""","""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call""","""controllers.Application.call()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_menu""","""controllers.Application.edit_menu()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_page""","""controllers.Application.edit_page()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """create""","""controllers.Application.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$username<[^/]+>""","""controllers.Application.userPage(username:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:9
case controllers_Assets_at1(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:10
case controllers_Application_index2(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """""", Routes.prefix + """index"""))
   }
}
        

// @LINE:11
case controllers_Application_call3(params) => {
   call { 
        invokeHandler(controllers.Application.call(), HandlerDef(this, "controllers.Application", "call", Nil,"GET", """""", Routes.prefix + """edit_call"""))
   }
}
        

// @LINE:12
case controllers_Application_edit_menu4(params) => {
   call { 
        invokeHandler(controllers.Application.edit_menu(), HandlerDef(this, "controllers.Application", "edit_menu", Nil,"GET", """""", Routes.prefix + """edit_menu"""))
   }
}
        

// @LINE:13
case controllers_Application_edit_page5(params) => {
   call { 
        invokeHandler(controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Nil,"GET", """""", Routes.prefix + """edit_page"""))
   }
}
        

// @LINE:16
case controllers_Application_login6(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ログイン関連""", Routes.prefix + """login"""))
   }
}
        

// @LINE:17
case controllers_Application_authenticate7(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """authenticate"""))
   }
}
        

// @LINE:18
case controllers_Application_logout8(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:20
case controllers_Application_register9(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"GET", """""", Routes.prefix + """register"""))
   }
}
        

// @LINE:21
case controllers_Application_create10(params) => {
   call { 
        invokeHandler(controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Nil,"POST", """""", Routes.prefix + """create"""))
   }
}
        

// @LINE:22
case controllers_Application_userPage11(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        invokeHandler(controllers.Application.userPage(username), HandlerDef(this, "controllers.Application", "userPage", Seq(classOf[String]),"GET", """""", Routes.prefix + """$username<[^/]+>"""))
   }
}
        
}

}
     