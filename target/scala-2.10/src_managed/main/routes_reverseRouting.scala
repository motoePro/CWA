// @SOURCE:/Users/hasegawakazuya/CWA/conf/routes
// @HASH:24de6acbf6184f560abc10f046df262f31a253c9
// @DATE:Wed Jun 17 01:20:27 JST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:13
// @LINE:12
// @LINE:11
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
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def edit_menu(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_menu")
}
                                                

// @LINE:13
def edit_page(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_page")
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
                                                

// @LINE:11
def call(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "edit_call")
}
                                                
    
}
                          
}
                  


// @LINE:13
// @LINE:12
// @LINE:11
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
              

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def edit_menu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_menu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_menu"})
      }
   """
)
                        

// @LINE:13
def edit_page : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.edit_page",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_page"})
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
                        

// @LINE:11
def call : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.call",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "edit_call"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:13
// @LINE:12
// @LINE:11
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
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:6
class ReverseApplication {
    

// @LINE:12
def edit_menu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_menu(), HandlerDef(this, "controllers.Application", "edit_menu", Seq(), "GET", """""", _prefix + """edit_menu""")
)
                      

// @LINE:13
def edit_page(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.edit_page(), HandlerDef(this, "controllers.Application", "edit_page", Seq(), "GET", """""", _prefix + """edit_page""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:11
def call(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.call(), HandlerDef(this, "controllers.Application", "call", Seq(), "GET", """""", _prefix + """edit_call""")
)
                      
    
}
                          
}
        
    