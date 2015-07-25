
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
object edit_change_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(optFileNames: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>編集ページ選択</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.79*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*14.16*/("""{"""),format.raw/*14.17*/("""
    		$('.hover').contextMenu('myMenu',
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
		<h2>変更先のページを指定してください。</h2>
		
		"""),_display_(Seq[Any](/*38.4*/for(fileName <- optFileNames) yield /*38.33*/ {_display_(Seq[Any](format.raw/*38.35*/("""
			<input type="button" onclick="location.href='/edit_call/input_file/"""),_display_(Seq[Any](/*39.72*/fileName)),format.raw/*39.80*/("""'" value=""""),_display_(Seq[Any](/*39.91*/fileName)),format.raw/*39.99*/("""" />
		""")))})),format.raw/*40.4*/("""
		
		<p>
			<input type="button" onclick="location.href='/edit_page'" value="編集画面に戻る" />
		</p>
		<div class='contextMenu' id='myMenu'>
    		<ul>
        		<li id='open'>Open</li>
        		<li id='email'>Email</li>
        		<li id='save'>Save</li>
        		<li id='close'>Close</li>
    		</ul>
		</div>
    </body>
</html>"""))}
    }
    
    def render(optFileNames:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(optFileNames)
    
    def f:((Array[String]) => play.api.templates.HtmlFormat.Appendable) = (optFileNames) => apply(optFileNames)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 25 12:38:14 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/aaa/CWA/app/views/edit_change_page.scala.html
                    HASH: 6c90b8f79157a8322a1f1ff4024cf06d5d0856a4
                    MATRIX: 792->1|915->30|1071->151|1085->157|1140->191|1236->252|1250->258|1303->290|1364->315|1379->321|1439->359|1532->416|1547->422|1614->467|1707->524|1722->530|1794->580|1912->670|1941->671|2020->722|2049->723|2102->748|2131->749|2197->787|2226->788|2335->869|2364->870|2429->907|2458->908|2568->990|2597->991|2661->1027|2690->1028|2799->1109|2828->1110|2894->1148|2923->1149|3034->1232|3063->1233|3102->1244|3131->1245|3165->1252|3193->1253|3225->1258|3253->1259|3361->1332|3406->1361|3446->1363|3554->1435|3584->1443|3631->1454|3661->1462|3700->1470
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|45->17|45->17|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|52->24|52->24|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|66->38|66->38|66->38|67->39|67->39|67->39|67->39|68->40
                    -- GENERATED --
                */
            