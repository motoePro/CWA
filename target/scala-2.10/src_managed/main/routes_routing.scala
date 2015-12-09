// @SOURCE:/Users/woon/Documents/workspace/CWA/conf/routes
// @HASH:0302da53fbae4509a2ee691164c35b5b6f8601fe
// @DATE:Wed Oct 21 11:35:15 JST 2015


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
        

// @LINE:13
private[this] lazy val controllers_Application_call3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call"))))
        

// @LINE:14
private[this] lazy val controllers_Application_edit_menu4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_menu"))))
        

// @LINE:15
private[this] lazy val controllers_Application_edit_page5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_page"))))
        

// @LINE:16
private[this] lazy val controllers_Application_edit_head6 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_head/target/"),DynamicPart("target_name", """[^/]+""",true))))
        

// @LINE:17
private[this] lazy val controllers_Application_dicition_name7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/call_dicition_name"))))
        

// @LINE:18
private[this] lazy val controllers_Application_new_page8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/new"))))
        

// @LINE:19
private[this] lazy val controllers_Application_save9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/save"))))
        

// @LINE:20
private[this] lazy val controllers_Application_change10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/change"))))
        

// @LINE:21
private[this] lazy val controllers_Application_render_file11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/render_file/"),DynamicPart("name", """[^/]+""",true))))
        

// @LINE:22
private[this] lazy val controllers_Application_link12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/link"))))
        

// @LINE:23
private[this] lazy val controllers_Application_choose_link13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/choose_link"))))
        

// @LINE:25
private[this] lazy val controllers_Application_selectBg14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/selectbg"))))
        

// @LINE:26
private[this] lazy val controllers_Application_setBg15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("edit_call/setbg"))))
        

// @LINE:31
private[this] lazy val controllers_Application_login16 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
        

// @LINE:32
private[this] lazy val controllers_Application_authenticate17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate"))))
        

// @LINE:33
private[this] lazy val controllers_Application_logout18 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:35
private[this] lazy val controllers_Application_register19 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("register"))))
        

// @LINE:36
private[this] lazy val controllers_Application_create20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("create"))))
        

// @LINE:37
private[this] lazy val controllers_Application_userPage21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("username", """[^/]+""",true))))
        

// @LINE:41
private[this] lazy val controllers_Assets_at22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("user/"),DynamicPart("file", """.+""",false))))
        

// @LINE:43
private[this] lazy val controllers_Application_upload23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("upload"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """index""","""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call""","""controllers.Application.call()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_menu""","""controllers.Application.edit_menu()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_page""","""controllers.Application.edit_page()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_head/target/$target_name<[^/]+>""","""controllers.Application.edit_head(target_name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/call_dicition_name""","""controllers.Application.dicition_name()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/new""","""controllers.Application.new_page()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/save""","""controllers.Application.save()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/change""","""controllers.Application.change()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/render_file/$name<[^/]+>""","""controllers.Application.render_file(name:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/link""","""controllers.Application.link()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/choose_link""","""controllers.Application.choose_link()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/selectbg""","""controllers.Application.selectBg()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """edit_call/setbg""","""controllers.Application.setBg()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate""","""controllers.Application.authenticate()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """register""","""controllers.Application.register()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """create""","""controllers.Application.create()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$username<[^/]+>""","""controllers.Application.userPage(username:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """user/$file<.+>""","""controllers.Assets.at(path:String = "/user", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """upload""","""controllers.Application.upload()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:13
case controllers_Application_call3(params) => {
   call { 
        invokeHandler(controllers.Application.call(), HandlerDef(this, "controllers.Application", "call", Nil,"GET", """編集ページ関係""", Routes.prefix + """edit_call"""))
   }
}
        

// @LINE:14
case controllers_Application_edit_menu4(params) => {
   call { 
        invokeHandler(controllers.Application.edit_menu(), HandlerDef(this, "controllers.Application", "edit_menu", Nil,"GET", """""", Routes.prefix + """edit_menu"""))
   }
}
        

// @LINE:15
case controllers_Application_edit_page5(params) => {
   call { 
        invokeHandler(controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Nil,"GET", """""", Routes.prefix + """edit_page"""))
   }
}
        

// @LINE:16
case controllers_Application_edit_head6(params) => {
   call(params.fromPath[String]("target_name", None)) { (target_name) =>
        invokeHandler(controllers.Application.edit_head(target_name), HandlerDef(this, "controllers.Application", "edit_head", Seq(classOf[String]),"GET", """""", Routes.prefix + """edit_head/target/$target_name<[^/]+>"""))
   }
}
        

// @LINE:17
case controllers_Application_dicition_name7(params) => {
   call { 
        invokeHandler(controllers.Application.dicition_name(), HandlerDef(this, "controllers.Application", "dicition_name", Nil,"GET", """""", Routes.prefix + """edit_call/call_dicition_name"""))
   }
}
        

// @LINE:18
case controllers_Application_new_page8(params) => {
   call { 
        invokeHandler(controllers.Application.new_page(), HandlerDef(this, "controllers.Application", "new_page", Nil,"POST", """""", Routes.prefix + """edit_call/new"""))
   }
}
        

// @LINE:19
case controllers_Application_save9(params) => {
   call { 
        invokeHandler(controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Nil,"POST", """""", Routes.prefix + """edit_call/save"""))
   }
}
        

// @LINE:20
case controllers_Application_change10(params) => {
   call { 
        invokeHandler(controllers.Application.change(), HandlerDef(this, "controllers.Application", "change", Nil,"GET", """""", Routes.prefix + """edit_call/change"""))
   }
}
        

// @LINE:21
case controllers_Application_render_file11(params) => {
   call(params.fromPath[String]("name", None)) { (name) =>
        invokeHandler(controllers.Application.render_file(name), HandlerDef(this, "controllers.Application", "render_file", Seq(classOf[String]),"GET", """""", Routes.prefix + """edit_call/render_file/$name<[^/]+>"""))
   }
}
        

// @LINE:22
case controllers_Application_link12(params) => {
   call { 
        invokeHandler(controllers.Application.link(), HandlerDef(this, "controllers.Application", "link", Nil,"GET", """""", Routes.prefix + """edit_call/link"""))
   }
}
        

// @LINE:23
case controllers_Application_choose_link13(params) => {
   call { 
        invokeHandler(controllers.Application.choose_link(), HandlerDef(this, "controllers.Application", "choose_link", Nil,"POST", """""", Routes.prefix + """edit_call/choose_link"""))
   }
}
        

// @LINE:25
case controllers_Application_selectBg14(params) => {
   call { 
        invokeHandler(controllers.Application.selectBg(), HandlerDef(this, "controllers.Application", "selectBg", Nil,"GET", """背景画像指定""", Routes.prefix + """edit_call/selectbg"""))
   }
}
        

// @LINE:26
case controllers_Application_setBg15(params) => {
   call { 
        invokeHandler(controllers.Application.setBg(), HandlerDef(this, "controllers.Application", "setBg", Nil,"POST", """""", Routes.prefix + """edit_call/setbg"""))
   }
}
        

// @LINE:31
case controllers_Application_login16(params) => {
   call { 
        invokeHandler(controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Nil,"GET", """ログイン関連""", Routes.prefix + """login"""))
   }
}
        

// @LINE:32
case controllers_Application_authenticate17(params) => {
   call { 
        invokeHandler(controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Nil,"POST", """""", Routes.prefix + """authenticate"""))
   }
}
        

// @LINE:33
case controllers_Application_logout18(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:35
case controllers_Application_register19(params) => {
   call { 
        invokeHandler(controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Nil,"GET", """""", Routes.prefix + """register"""))
   }
}
        

// @LINE:36
case controllers_Application_create20(params) => {
   call { 
        invokeHandler(controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Nil,"POST", """""", Routes.prefix + """create"""))
   }
}
        

// @LINE:37
case controllers_Application_userPage21(params) => {
   call(params.fromPath[String]("username", None)) { (username) =>
        invokeHandler(controllers.Application.userPage(username), HandlerDef(this, "controllers.Application", "userPage", Seq(classOf[String]),"GET", """""", Routes.prefix + """$username<[^/]+>"""))
   }
}
        

// @LINE:41
case controllers_Assets_at22(params) => {
   call(Param[String]("path", Right("/user")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """#画像関連""", Routes.prefix + """user/$file<.+>"""))
   }
}
        

// @LINE:43
case controllers_Application_upload23(params) => {
   call { 
        invokeHandler(controllers.Application.upload(), HandlerDef(this, "controllers.Application", "upload", Nil,"POST", """ページに画像を追加""", Routes.prefix + """upload"""))
   }
}
        
}

}
     