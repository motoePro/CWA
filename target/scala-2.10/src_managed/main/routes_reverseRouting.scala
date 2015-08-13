// @SOURCE:/Users/hasegawakazuya/Desktop/CWA/conf/routes
// @HASH:f1fbec5c454665f97887aaf125d69de706246a06
// @DATE:Tue Aug 11 22:15:53 JST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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
    

// @LINE:20
def change(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/change")
}
                                                

// @LINE:16
def edit_head(target_name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_head/target/" + implicitly[PathBindable[String]].unbind("target_name", dynamicString(target_name)))
}
                                                

// @LINE:30
def userPage(username:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("username", dynamicString(username)))
}
                                                

// @LINE:15
def edit_page(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_page")
}
                                                

// @LINE:29
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
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:28
def register(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "register")
}
                                                

// @LINE:21
def render_file(name:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call/render_file/" + implicitly[PathBindable[String]].unbind("name", dynamicString(name)))
}
                                                

// @LINE:19
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "edit_call/save")
}
                                                

// @LINE:25
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
                                                

// @LINE:24
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          
}
                  


// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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

// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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
                        

// @LINE:30
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
                        

// @LINE:29
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
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:28
def register : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.register",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
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
                        

// @LINE:25
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
                        

// @LINE:24
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
        


// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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


// @LINE:9
class ReverseAssets {
    

// @LINE:9
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
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
    

// @LINE:20
def change(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.change(), HandlerDef(this, "controllers.Application", "change", Seq(), "GET", """""", _prefix + """edit_call/change""")
)
                      

// @LINE:16
def edit_head(target_name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_head(target_name), HandlerDef(this, "controllers.Application", "edit_head", Seq(classOf[String]), "GET", """""", _prefix + """edit_head/target/$target_name<[^/]+>""")
)
                      

// @LINE:30
def userPage(username:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.userPage(username), HandlerDef(this, "controllers.Application", "userPage", Seq(classOf[String]), "GET", """""", _prefix + """$username<[^/]+>""")
)
                      

// @LINE:15
def edit_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Seq(), "GET", """""", _prefix + """edit_page""")
)
                      

// @LINE:29
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
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:28
def register(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.register(), HandlerDef(this, "controllers.Application", "register", Seq(), "GET", """""", _prefix + """register""")
)
                      

// @LINE:21
def render_file(name:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.render_file(name), HandlerDef(this, "controllers.Application", "render_file", Seq(classOf[String]), "GET", """""", _prefix + """edit_call/render_file/$name<[^/]+>""")
)
                      

// @LINE:19
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq(), "POST", """""", _prefix + """edit_call/save""")
)
                      

// @LINE:25
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
                      

// @LINE:24
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this, "controllers.Application", "login", Seq(), "GET", """ログイン関連""", _prefix + """login""")
)
                      
    
}
                          
}
        
    