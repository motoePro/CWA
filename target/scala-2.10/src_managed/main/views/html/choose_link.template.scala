
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
object choose_link extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(optFileNames: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.31*/("""
"""),format.raw/*3.1*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>リンク指定</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.79*/("""" type="text/javascript"></script>
    </head>
    <body>
    	"""),_display_(Seq[Any](/*15.7*/for(fileName <- optFileNames) yield /*15.36*/ {_display_(Seq[Any](format.raw/*15.38*/("""
			<input type="button" onclick="choose_link('"""),_display_(Seq[Any](/*16.48*/fileName)),format.raw/*16.56*/("""')" value=""""),_display_(Seq[Any](/*16.68*/fileName)),format.raw/*16.76*/("""" />
		""")))})),format.raw/*17.4*/("""
		<input type="button" value="閉じる" onclick="window.open('about:blank','_self').close();">
		
		<form id="link_form" action="/edit_call/choose_link" method="POST" target="menu" style="display:none">
			"""),_display_(Seq[Any](/*21.5*/CSRF/*21.9*/.formField)),format.raw/*21.19*/("""
			<input type="text" id="link_name" name="name" value="">
		</form>
    </body>
</html>"""))}
    }
    
    def render(optFileNames:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(optFileNames)
    
    def f:((Array[String]) => play.api.templates.HtmlFormat.Appendable) = (optFileNames) => apply(optFileNames)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 02 01:54:19 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/choose_link.scala.html
                    HASH: 0435cce8ad8803ba64dc7d64df4a712d491f01cd
                    MATRIX: 787->1|926->30|953->48|1105->165|1119->171|1174->205|1270->266|1284->272|1337->304|1398->329|1413->335|1473->373|1566->430|1581->436|1648->481|1741->538|1756->544|1828->594|1927->658|1972->687|2012->689|2096->737|2126->745|2174->757|2204->765|2243->773|2481->976|2493->980|2525->990
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|43->15|43->15|43->15|44->16|44->16|44->16|44->16|45->17|49->21|49->21|49->21
                    -- GENERATED --
                */
            