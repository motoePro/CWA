
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
object main_edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*10.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*11.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.89*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*14.16*/("""{"""),format.raw/*14.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*16.11*/("""{"""),format.raw/*16.12*/("""
            		bindings: """),format.raw/*17.25*/("""{"""),format.raw/*17.26*/("""
                	'open': function(t) """),format.raw/*18.38*/("""{"""),format.raw/*18.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*20.15*/("""}"""),format.raw/*20.16*/(""",
            		'email': function(t) """),format.raw/*21.36*/("""{"""),format.raw/*21.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*23.15*/("""}"""),format.raw/*23.16*/(""",
            		'save': function(t) """),format.raw/*24.35*/("""{"""),format.raw/*24.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*26.15*/("""}"""),format.raw/*26.16*/(""",
            		'delete': function(t) """),format.raw/*27.37*/("""{"""),format.raw/*27.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*29.15*/("""}"""),format.raw/*29.16*/("""
        		"""),format.raw/*30.11*/("""}"""),format.raw/*30.12*/("""
    		"""),format.raw/*31.7*/("""}"""),format.raw/*31.8*/(""");
		"""),format.raw/*32.3*/("""}"""),format.raw/*32.4*/(""");
		</script>
    </head>
    <body>
        """),_display_(Seq[Any](/*36.10*/content)),format.raw/*36.17*/("""
    </body>
</html>
"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/main_edit_page.scala.html
                    HASH: 0d2e0615b9d60fbe9c84b693558e9d53c2d050bc
                    MATRIX: 788->1|912->31|1000->84|1026->89|1123->151|1137->157|1203->201|1299->262|1313->268|1377->310|1438->335|1453->341|1523->389|1616->446|1631->452|1708->507|1801->564|1816->570|1898->630|2016->720|2045->721|2124->772|2153->773|2206->798|2235->799|2301->837|2330->838|2439->919|2468->920|2533->957|2562->958|2672->1040|2701->1041|2765->1077|2794->1078|2903->1159|2932->1160|2998->1198|3027->1199|3138->1282|3167->1283|3206->1294|3235->1295|3269->1302|3297->1303|3329->1308|3357->1309|3440->1356|3469->1363
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|45->17|45->17|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|52->24|52->24|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|64->36|64->36
                    -- GENERATED --
                */
            