
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
        			/*
            		bindings: """),format.raw/*18.25*/("""{"""),format.raw/*18.26*/("""
                	'open': function(t) """),format.raw/*19.38*/("""{"""),format.raw/*19.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*21.15*/("""}"""),format.raw/*21.16*/(""",
            		'email': function(t) """),format.raw/*22.36*/("""{"""),format.raw/*22.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*24.15*/("""}"""),format.raw/*24.16*/(""",
            		'save': function(t) """),format.raw/*25.35*/("""{"""),format.raw/*25.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*27.15*/("""}"""),format.raw/*27.16*/(""",
            		*/
            		'delete': function(t) """),format.raw/*29.37*/("""{"""),format.raw/*29.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*31.15*/("""}"""),format.raw/*31.16*/("""
        		"""),format.raw/*32.11*/("""}"""),format.raw/*32.12*/("""
    		"""),format.raw/*33.7*/("""}"""),format.raw/*33.8*/(""");
		"""),format.raw/*34.3*/("""}"""),format.raw/*34.4*/(""");
		</script>
    </head>
    <body>
        """),_display_(Seq[Any](/*38.10*/content)),format.raw/*38.17*/("""
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
                    DATE: Fri Jun 19 11:49:05 JST 2015
                    SOURCE: /Users/hasegawakazuya/CWA/app/views/main_edit_page.scala.html
                    HASH: 7db652a7672220e88a3eabac581f8e77efedba9b
                    MATRIX: 788->1|912->31|1000->84|1026->89|1123->151|1137->157|1192->191|1288->252|1302->258|1355->290|1416->315|1431->321|1491->359|1584->416|1599->422|1666->467|1759->524|1774->530|1846->580|1964->670|1993->671|2072->722|2101->723|2168->762|2197->763|2263->801|2292->802|2401->883|2430->884|2495->921|2524->922|2634->1004|2663->1005|2727->1041|2756->1042|2865->1123|2894->1124|2977->1179|3006->1180|3117->1263|3146->1264|3185->1275|3214->1276|3248->1283|3276->1284|3308->1289|3336->1290|3419->1337|3448->1344
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|46->18|46->18|47->19|47->19|49->21|49->21|50->22|50->22|52->24|52->24|53->25|53->25|55->27|55->27|57->29|57->29|59->31|59->31|60->32|60->32|61->33|61->33|62->34|62->34|66->38|66->38
                    -- GENERATED --
                */
            