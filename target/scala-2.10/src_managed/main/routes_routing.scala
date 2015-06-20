// @SOURCE:/Users/hasegawakazuya/CWA/conf/routes
// @HASH:24de6acbf6184f560abc10f046df262f31a253c9
// @DATE:Wed Jun 17 01:20:27 JST 2015


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
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index""","""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call""","""controllers.Application.call()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_menu""","""controllers.Application.edit_menu()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_page""","""controllers.Application.edit_page()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        
}

}
     