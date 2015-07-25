
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
	<p>ようこそ。"""),_display_(Seq[Any](/*5.11*/session)),format.raw/*5.18*/(""" さん</p>
	<p><a href=""""),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Application.register())),format.raw/*6.44*/("""">会員登録</a></p>
	<p><a href=""""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Application.login())),format.raw/*7.41*/("""">ログインはこちら</a></p>
""")))})),format.raw/*8.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Wed Jul 22 12:09:02 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/index.scala.html
                    HASH: c75f35af67185cad8491c6114373fc1bf246707b
                    MATRIX: 774->1|885->18|922->21|941->32|980->34|1043->62|1071->69|1128->91|1142->97|1186->120|1250->149|1264->155|1305->175|1355->195
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8
                    -- GENERATED --
                */
            