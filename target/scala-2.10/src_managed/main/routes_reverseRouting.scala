// @SOURCE:/Users/woon/Documents/workspace/CWA/conf/routes
// @HASH:e1326c9b979963aac562f61a7d7ce0b1a51bd896
// @DATE:Fri Dec 18 00:28:38 JST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:57
// @LINE:55
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:55
// @LINE:9
class ReverseAssets {
    

// @LINE:55
// @LINE:9
def at(path:String, file:String): Call = {
   (path: @unchecked, file: @unchecked) match {
// @LINE:9
case (path, file) if path == "/public" => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
// @LINE:55
case (path, file) if path == "/user" => Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:57
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def selectBg(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/selectbg")
}
                                                

// @LINE:35
def choose_link(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/choose_link")
}
                                                

// @LINE:21
def change(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/change")
}
                                                

// @LINE:17
def edit_head(target_name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_head/target/" + implicitly[PathBindable[String]].unbind("target_name", dynamicString(target_name)))
}
                                                

// @LINE:57
def upload(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "upload")
}
                                                

// @LINE:50
def userPage(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
}
                                                

// @LINE:16
def edit_page(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_page")
}
                                                

// @LINE:49
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "create")
}
                                                

// @LINE:37
def put_link(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/put_link")
}
                                                

// @LINE:15
def edit_menu(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_menu")
}
                                                

// @LINE:14
def call(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call")
}
                                                

// @LINE:18
def dicition_name(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/call_dicition_name")
}
                                                

// @LINE:27
def setBg(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/setbg")
}
                                                

// @LINE:31
def blog_data_edit(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/edit_blog_edit")
}
                                                

// @LINE:32
def data_add(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/data_add")
}
                                                

// @LINE:30
def blog_data_read(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/blog_data_read")
}
                                                

// @LINE:46
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:48
def register(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:34
def link(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/link")
}
                                                

// @LINE:22
def render_file(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/render_file/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                                                

// @LINE:20
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/save")
}
                                                

// @LINE:36
def addlink(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/addlink")
}
                                                

// @LINE:38
def edit_text(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/edit_text")
}
                                                

// @LINE:45
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "authenticate")
}
                                                

// @LINE:10
// @LINE:6
def index(): Call = {
   () match {
// @LINE:6
case () if true => Call("GET", _prefix)
                                                        
// @LINE:10
case () if true => Call("GET", _prefix + { _defaultPrefix } + "index")
                                                        
   }
}
                                                

// @LINE:23
def deletePage(target:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/delete_page/" + implicitly[PathBindable[String]].unbind("target", dynamicString(target)))
}
                                                

// @LINE:11
def view(user_name:String, file_name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "cwa/" + implicitly[PathBindable[String]].unbind("user_name", dynamicString(user_name)) + "/" + implicitly[PathBindable[String]].unbind("file_name", dynamicString(file_name)))
}
                                                

// @LINE:19
def new_page(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/new")
}
                                                

// @LINE:33
def edit_blog(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_blog")
}
                                                

// @LINE:39
def edit_text_save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/edit_text_save")
}
                                                

// @LINE:44
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:57
// @LINE:55
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:55
// @LINE:9
class ReverseAssets {
    

// @LINE:55
// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(path, file) {
      if (path == """ + implicitly[JavascriptLitteral[String]].to("/public") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      if (path == """ + implicitly[JavascriptLitteral[String]].to("/user") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "user/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
      }
   """
)
                        
    
}
              

// @LINE:57
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def selectBg : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.selectBg",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/selectbg"})
      }
   """
)
                        

// @LINE:35
def choose_link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.choose_link",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/choose_link"})
      }
   """
)
                        

// @LINE:21
def change : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.change",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/change"})
      }
   """
)
                        

// @LINE:17
def edit_head : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_head",
   """
      function(target_name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_head/target/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("target_name", encodeURIComponent(target_name))})
      }
   """
)
                        

// @LINE:57
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upload"})
      }
   """
)
                        

// @LINE:50
def userPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.userPage",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username))})
      }
   """
)
                        

// @LINE:16
def edit_page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_page",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_page"})
      }
   """
)
                        

// @LINE:49
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
      }
   """
)
                        

// @LINE:37
def put_link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.put_link",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/put_link"})
      }
   """
)
                        

// @LINE:15
def edit_menu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_menu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_menu"})
      }
   """
)
                        

// @LINE:14
def call : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.call",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call"})
      }
   """
)
                        

// @LINE:18
def dicition_name : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dicition_name",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/call_dicition_name"})
      }
   """
)
                        

// @LINE:27
def setBg : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.setBg",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/setbg"})
      }
   """
)
                        

// @LINE:31
def blog_data_edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.blog_data_edit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/edit_blog_edit"})
      }
   """
)
                        

// @LINE:32
def data_add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.data_add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/data_add"})
      }
   """
)
                        

// @LINE:30
def blog_data_read : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.blog_data_read",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/blog_data_read"})
      }
   """
)
                        

// @LINE:46
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:48
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:34
def link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.link",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/link"})
      }
   """
)
                        

// @LINE:22
def render_file : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.render_file",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/render_file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:20
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/save"})
      }
   """
)
                        

// @LINE:36
def addlink : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addlink",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/addlink"})
      }
   """
)
                        

// @LINE:38
def edit_text : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_text",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/edit_text"})
      }
   """
)
                        

// @LINE:45
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate"})
      }
   """
)
                        

// @LINE:10
// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "index"})
      }
      }
   """
)
                        

// @LINE:23
def deletePage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deletePage",
   """
      function(target) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/delete_page/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("target", encodeURIComponent(target))})
      }
   """
)
                        

// @LINE:11
def view : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.view",
   """
      function(user_name,file_name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cwa/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user_name", encodeURIComponent(user_name)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file_name", encodeURIComponent(file_name))})
      }
   """
)
                        

// @LINE:19
def new_page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.new_page",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/new"})
      }
   """
)
                        

// @LINE:33
def edit_blog : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_blog",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_blog"})
      }
   """
)
                        

// @LINE:39
def edit_text_save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_text_save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/edit_text_save"})
      }
   """
)
                        

// @LINE:44
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:57
// @LINE:55
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:55
// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:57
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:27
// @LINE:26
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:26
def selectBg(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.selectBg(), HandlerDef(this, "controllers.Application", "selectBg", Seq(), "GET", """背景画像指定""", _prefix + """edit_call/selectbg""")
)
                      

// @LINE:35
def choose_link(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.choose_link(), HandlerDef(this, "controllers.Application", "choose_link", Seq(), "POST", """""", _prefix + """edit_call/choose_link""")
)
                      

// @LINE:21
def change(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.change(), HandlerDef(this, "controllers.Application", "change", Seq(), "GET", """""", _prefix + """edit_call/change""")
)
                      

// @LINE:17
def edit_head(target_name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_head(target_name), HandlerDef(this, "controllers.Application", "edit_head", Seq(classOf[String]), "GET", """""", _prefix + """edit_head/target/$target_name<[^/]+>""")
)
                      

// @LINE:57
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.upload(), HandlerDef(this, "controllers.Application", "upload", Seq(), "POST", """ページに画像を追加""", _prefix + """upload""")
)
                      

// @LINE:50
def userPage(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.userPage(username), HandlerDef(this, "controllers.Application", "userPage", Seq(classOf[String]), "GET", """""", _prefix + """$username<[^/]+>""")
)
                      

// @LINE:16
def edit_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Seq(), "GET", """""", _prefix + """edit_page""")
)
                      

// @LINE:49
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Seq(), "POST", """""", _prefix + """create""")
)
                      

// @LINE:37
def put_link(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.put_link(), HandlerDef(this, "controllers.Application", "put_link", Seq(), "POST", """""", _prefix + """edit_call/put_link""")
)
                      

// @LINE:15
def edit_menu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_menu(), HandlerDef(this, "controllers.Application", "edit_menu", Seq(), "GET", """""", _prefix + """edit_menu""")
)
                      

// @LINE:14
def call(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.call(), HandlerDef(this, "controllers.Application", "call", Seq(), "GET", """編集ページ関係""", _prefix + """edit_call""")
)
                      

// @LINE:18
def dicition_name(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dicition_name(), HandlerDef(this, "controllers.Application", "dicition_name", Seq(), "GET", """""", _prefix + """edit_call/call_dicition_name""")
)
                      

// @LINE:27
def setBg(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.setBg(), HandlerDef(this, "controllers.Application", "setBg", Seq(), "POST", """""", _prefix + """edit_call/setbg""")
)
                      

// @LINE:31
def blog_data_edit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.blog_data_edit(), HandlerDef(this, "controllers.Application", "blog_data_edit", Seq(), "POST", """""", _prefix + """edit_call/edit_blog_edit""")
)
                      

// @LINE:32
def data_add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.data_add(), HandlerDef(this, "controllers.Application", "data_add", Seq(), "POST", """""", _prefix + """edit_call/data_add""")
)
                      

// @LINE:30
def blog_data_read(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.blog_data_read(), HandlerDef(this, "controllers.Application", "blog_data_read", Seq(), "POST", """リンク""", _prefix + """edit_call/blog_data_read""")
)
                      

// @LINE:46
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:48
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:34
def link(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.link(), HandlerDef(this, "controllers.Application", "link", Seq(), "GET", """""", _prefix + """edit_call/link""")
)
                      

// @LINE:22
def render_file(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.render_file(name), HandlerDef(this, "controllers.Application", "render_file", Seq(classOf[String]), "GET", """""", _prefix + """edit_call/render_file/$name<[^/]+>""")
)
                      

// @LINE:20
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq(), "POST", """""", _prefix + """edit_call/save""")
)
                      

// @LINE:36
def addlink(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addlink(), HandlerDef(this, "controllers.Application", "addlink", Seq(), "GET", """""", _prefix + """edit_call/addlink""")
)
                      

// @LINE:38
def edit_text(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_text(), HandlerDef(this, "controllers.Application", "edit_text", Seq(), "POST", """""", _prefix + """edit_call/edit_text""")
)
                      

// @LINE:45
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """authenticate""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:23
def deletePage(target:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deletePage(target), HandlerDef(this, "controllers.Application", "deletePage", Seq(classOf[String]), "GET", """""", _prefix + """edit_call/delete_page/$target<[^/]+>""")
)
                      

// @LINE:11
def view(user_name:String, file_name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.view(user_name, file_name), HandlerDef(this, "controllers.Application", "view", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """cwa/$user_name<[^/]+>/$file_name<[^/]+>""")
)
                      

// @LINE:19
def new_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.new_page(), HandlerDef(this, "controllers.Application", "new_page", Seq(), "POST", """""", _prefix + """edit_call/new""")
)
                      

// @LINE:33
def edit_blog(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_blog(), HandlerDef(this, "controllers.Application", "edit_blog", Seq(), "GET", """""", _prefix + """edit_blog""")
)
                      

// @LINE:39
def edit_text_save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_text_save(), HandlerDef(this, "controllers.Application", "edit_text_save", Seq(), "POST", """""", _prefix + """edit_call/edit_text_save""")
)
                      

// @LINE:44
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ログイン関連""", _prefix + """login""")
)
                      
    
}
                          
}
        
    