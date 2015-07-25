
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
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.79*/("""" type="text/javascript"></script>
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
                    DATE: Sat Jul 25 12:38:15 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/aaa/CWA/app/views/main_edit_page.scala.html
                    HASH: 7a9726429b5b2830176e292fe8eddc74ffe624a9
                    MATRIX: 788->1|912->31|1000->84|1026->89|1123->151|1137->157|1192->191|1288->252|1302->258|1355->290|1416->315|1431->321|1491->359|1584->416|1599->422|1666->467|1759->524|1774->530|1846->580|1964->670|1993->671|2072->722|2101->723|2154->748|2183->749|2249->787|2278->788|2387->869|2416->870|2481->907|2510->908|2620->990|2649->991|2713->1027|2742->1028|2851->1109|2880->1110|2946->1148|2975->1149|3086->1232|3115->1233|3154->1244|3183->1245|3217->1252|3245->1253|3277->1258|3305->1259|3388->1306|3417->1313
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|45->17|45->17|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|52->24|52->24|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|64->36|64->36
                    -- GENERATED --
                */
            