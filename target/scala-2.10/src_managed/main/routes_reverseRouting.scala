// @SOURCE:/Users/woon/Documents/workspace/CWA/conf/routes
// @HASH:0302da53fbae4509a2ee691164c35b5b6f8601fe
// @DATE:Wed Oct 21 11:35:15 JST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:43
// @LINE:41
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:41
// @LINE:9
class ReverseAssets {
    

// @LINE:41
// @LINE:9
def at(path:String, file:String): Call = {
   (path: @unchecked, file: @unchecked) match {
// @LINE:9
case (path, file) if path == "/public" => Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
// @LINE:41
case (path, file) if path == "/user" => Call("GET", _prefix + { _defaultPrefix } + "user/" + implicitly[PathBindable[String]].unbind("file", file))
                                                        
   }
}
                                                
    
}
                          

// @LINE:43
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:25
def selectBg(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/selectbg")
}
                                                

// @LINE:23
def choose_link(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/choose_link")
}
                                                

// @LINE:20
def change(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/change")
}
                                                

// @LINE:16
def edit_head(target_name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_head/target/" + implicitly[PathBindable[String]].unbind("target_name", dynamicString(target_name)))
}
                                                

// @LINE:43
def upload(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "upload")
}
                                                

// @LINE:37
def userPage(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
}
                                                

// @LINE:15
def edit_page(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_page")
}
                                                

// @LINE:36
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "create")
}
                                                

// @LINE:14
def edit_menu(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_menu")
}
                                                

// @LINE:13
def call(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call")
}
                                                

// @LINE:17
def dicition_name(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/call_dicition_name")
}
                                                

// @LINE:26
def setBg(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/setbg")
}
                                                

// @LINE:33
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:35
def register(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:22
def link(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/link")
}
                                                

// @LINE:21
def render_file(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/render_file/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                                                

// @LINE:19
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/save")
}
                                                

// @LINE:32
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
                                                

// @LINE:18
def new_page(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/new")
}
                                                

// @LINE:31
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:43
// @LINE:41
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:41
// @LINE:9
class ReverseAssets {
    

// @LINE:41
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
              

// @LINE:43
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:25
def selectBg : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.selectBg",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/selectbg"})
      }
   """
)
                        

// @LINE:23
def choose_link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.choose_link",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/choose_link"})
      }
   """
)
                        

// @LINE:20
def change : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.change",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/change"})
      }
   """
)
                        

// @LINE:16
def edit_head : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_head",
   """
      function(target_name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_head/target/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("target_name", encodeURIComponent(target_name))})
      }
   """
)
                        

// @LINE:43
def upload : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.upload",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "upload"})
      }
   """
)
                        

// @LINE:37
def userPage : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.userPage",
   """
      function(username) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("username", encodeURIComponent(username))})
      }
   """
)
                        

// @LINE:15
def edit_page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_page",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_page"})
      }
   """
)
                        

// @LINE:36
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
      }
   """
)
                        

// @LINE:14
def edit_menu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_menu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_menu"})
      }
   """
)
                        

// @LINE:13
def call : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.call",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call"})
      }
   """
)
                        

// @LINE:17
def dicition_name : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dicition_name",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/call_dicition_name"})
      }
   """
)
                        

// @LINE:26
def setBg : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.setBg",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/setbg"})
      }
   """
)
                        

// @LINE:33
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:35
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
      }
   """
)
                        

// @LINE:22
def link : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.link",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/link"})
      }
   """
)
                        

// @LINE:21
def render_file : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.render_file",
   """
      function(name) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/render_file/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("name", encodeURIComponent(name))})
      }
   """
)
                        

// @LINE:19
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/save"})
      }
   """
)
                        

// @LINE:32
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
                        

// @LINE:18
def new_page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.new_page",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call/new"})
      }
   """
)
                        

// @LINE:31
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
        


// @LINE:43
// @LINE:41
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {


// @LINE:41
// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:43
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:26
// @LINE:25
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
// @LINE:13
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:25
def selectBg(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.selectBg(), HandlerDef(this, "controllers.Application", "selectBg", Seq(), "GET", """背景画像指定""", _prefix + """edit_call/selectbg""")
)
                      

// @LINE:23
def choose_link(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.choose_link(), HandlerDef(this, "controllers.Application", "choose_link", Seq(), "POST", """""", _prefix + """edit_call/choose_link""")
)
                      

// @LINE:20
def change(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.change(), HandlerDef(this, "controllers.Application", "change", Seq(), "GET", """""", _prefix + """edit_call/change""")
)
                      

// @LINE:16
def edit_head(target_name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_head(target_name), HandlerDef(this, "controllers.Application", "edit_head", Seq(classOf[String]), "GET", """""", _prefix + """edit_head/target/$target_name<[^/]+>""")
)
                      

// @LINE:43
def upload(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.upload(), HandlerDef(this, "controllers.Application", "upload", Seq(), "POST", """ページに画像を追加""", _prefix + """upload""")
)
                      

// @LINE:37
def userPage(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.userPage(username), HandlerDef(this, "controllers.Application", "userPage", Seq(classOf[String]), "GET", """""", _prefix + """$username<[^/]+>""")
)
                      

// @LINE:15
def edit_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Seq(), "GET", """""", _prefix + """edit_page""")
)
                      

// @LINE:36
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Seq(), "POST", """""", _prefix + """create""")
)
                      

// @LINE:14
def edit_menu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_menu(), HandlerDef(this, "controllers.Application", "edit_menu", Seq(), "GET", """""", _prefix + """edit_menu""")
)
                      

// @LINE:13
def call(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.call(), HandlerDef(this, "controllers.Application", "call", Seq(), "GET", """編集ページ関係""", _prefix + """edit_call""")
)
                      

// @LINE:17
def dicition_name(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dicition_name(), HandlerDef(this, "controllers.Application", "dicition_name", Seq(), "GET", """""", _prefix + """edit_call/call_dicition_name""")
)
                      

// @LINE:26
def setBg(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.setBg(), HandlerDef(this, "controllers.Application", "setBg", Seq(), "POST", """""", _prefix + """edit_call/setbg""")
)
                      

// @LINE:33
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:35
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:22
def link(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.link(), HandlerDef(this, "controllers.Application", "link", Seq(), "GET", """""", _prefix + """edit_call/link""")
)
                      

// @LINE:21
def render_file(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.render_file(name), HandlerDef(this, "controllers.Application", "render_file", Seq(classOf[String]), "GET", """""", _prefix + """edit_call/render_file/$name<[^/]+>""")
)
                      

// @LINE:19
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq(), "POST", """""", _prefix + """edit_call/save""")
)
                      

// @LINE:32
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.authenticate(), HandlerDef(this, "controllers.Application", "authenticate", Seq(), "POST", """""", _prefix + """authenticate""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:18
def new_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.new_page(), HandlerDef(this, "controllers.Application", "new_page", Seq(), "POST", """""", _prefix + """edit_call/new""")
)
                      

// @LINE:31
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ログイン関連""", _prefix + """login""")
)
                      
    
}
                          
}
        
    