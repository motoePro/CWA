
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
	<p>ようこそ。</p>
	
	<p>
	"""),_display_(Seq[Any](/*8.3*/if(session.get("username") == null )/*8.39*/ {_display_(Seq[Any](format.raw/*8.41*/("""
			<a href=""""),_display_(Seq[Any](/*9.14*/routes/*9.20*/.Application.register())),format.raw/*9.43*/("""">会員登録</a>
			<a href=""""),_display_(Seq[Any](/*10.14*/routes/*10.20*/.Application.login())),format.raw/*10.40*/("""">ログインはこちら</a>
		""")))}/*11.5*/else/*11.10*/{_display_(Seq[Any](format.raw/*11.11*/("""
			<a href=""""),_display_(Seq[Any](/*12.14*/routes/*12.20*/.Application.userPage(session.get("username")))),format.raw/*12.66*/("""">ユーザページへ</a>
		""")))})),format.raw/*13.4*/("""
	<p>
""")))})),format.raw/*15.2*/("""
"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/index.scala.html
                    HASH: acb0be8157fe83eaa8ce37dcaf46d67f83047a96
                    MATRIX: 774->1|885->18|922->21|941->32|980->34|1055->75|1099->111|1138->113|1187->127|1201->133|1245->156|1305->180|1320->186|1362->206|1398->225|1411->230|1450->231|1500->245|1515->251|1583->297|1631->314|1669->321
                    LINES: 26->1|29->1|31->3|31->3|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|43->15
                    -- GENERATED --
                */
            