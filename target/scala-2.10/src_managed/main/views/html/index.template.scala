
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("TOP")/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""
	<h1>トップページ</h1>
	<p>ようこそ。
		<a href=""""),_display_(Seq[Any](/*6.13*/routes/*6.19*/.Application.register())),format.raw/*6.42*/("""">会員登録</a>
		<a href=""""),_display_(Seq[Any](/*7.13*/routes/*7.19*/.Application.login())),format.raw/*7.39*/("""">ログインはこちら</a>
	</p>
""")))})),format.raw/*9.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Sep 18 11:24:54 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/index.scala.html
                    HASH: 62689a0bccf950f8ff3a9c3dcadd639bb8a139d8
                    MATRIX: 774->1|885->18|922->21|941->32|980->34|1055->74|1069->80|1113->103|1171->126|1185->132|1226->152|1278->174
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|35->7|35->7|35->7|37->9
                    -- GENERATED --
                */
            