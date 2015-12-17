
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
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*10.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*11.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.89*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<p>作成するリンクのリンク先を選択してください</p>
    	"""),_display_(Seq[Any](/*16.7*/for(fileName <- optFileNames) yield /*16.36*/ {_display_(Seq[Any](format.raw/*16.38*/("""
			<input type="button" onclick="choose_link('"""),_display_(Seq[Any](/*17.48*/fileName)),format.raw/*17.56*/("""')" value=""""),_display_(Seq[Any](/*17.68*/fileName)),format.raw/*17.76*/("""" />
		""")))})),format.raw/*18.4*/("""
		<p>
		<input type="button" value="閉じる" onclick="window.open('about:blank','_self').close();">
		</p>
		<form id="link_form" action="/edit_call/choose_link" method="POST" target="menu" style="display:none">
			"""),_display_(Seq[Any](/*23.5*/CSRF/*23.9*/.formField)),format.raw/*23.19*/("""
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
                    DATE: Thu Dec 17 13:31:27 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/choose_link.scala.html
                    HASH: 9671ad72d406356dd2b4f39697bfc0c6e81ceae3
                    MATRIX: 787->1|926->30|953->48|1105->165|1119->171|1185->215|1281->276|1295->282|1359->324|1420->349|1435->355|1505->403|1598->460|1613->466|1690->521|1783->578|1798->584|1880->644|2013->742|2058->771|2098->773|2182->821|2212->829|2260->841|2290->849|2329->857|2577->1070|2589->1074|2621->1084
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|44->16|44->16|44->16|45->17|45->17|45->17|45->17|46->18|51->23|51->23|51->23
                    -- GENERATED --
                */
            