
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
object edit_menu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>メニュー</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*5.54*/routes/*5.60*/.Assets.at("stylesheets/main.css"))),format.raw/*5.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("stylesheets/menu.css"))),format.raw/*6.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*7.59*/routes/*7.65*/.Assets.at("images/favicon.png"))),format.raw/*7.97*/("""">
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*13.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery-ui.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*15.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*16.79*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*18.16*/("""{"""),format.raw/*18.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*20.11*/("""{"""),format.raw/*20.12*/("""
            		bindings: """),format.raw/*21.25*/("""{"""),format.raw/*21.26*/("""
                	'open': function(t) """),format.raw/*22.38*/("""{"""),format.raw/*22.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*24.15*/("""}"""),format.raw/*24.16*/(""",
            		'email': function(t) """),format.raw/*25.36*/("""{"""),format.raw/*25.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*27.15*/("""}"""),format.raw/*27.16*/(""",
            		'save': function(t) """),format.raw/*28.35*/("""{"""),format.raw/*28.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*30.15*/("""}"""),format.raw/*30.16*/(""",
            		'delete': function(t) """),format.raw/*31.37*/("""{"""),format.raw/*31.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*33.15*/("""}"""),format.raw/*33.16*/("""
        		"""),format.raw/*34.11*/("""}"""),format.raw/*34.12*/("""
    		"""),format.raw/*35.7*/("""}"""),format.raw/*35.8*/(""");
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/(""");
		</script>
    </head>
    <body>
        <div id="menu" class="demo1">
			<div><button onclick="addBtn()">ボタン</button></div>
			<div><button onclick="addTxt()">テキスト</button></div>
			<div><button onclick="addTxb()">テキストボックス</button></div>
			<div><button onclick="addPct()">画像</button></div>
	
			<div><button onclick="addTwt()">Twitter</button></div>
			<div><button onclick="addLine()">Line</button></div>
			<div><button onclick="addFace()">Facebook</button></div>
			<div><button onclick="Window_YouTube()">YouTube</button></div>
		</div>
		
		<div class='contextMenu' id='myMenu'>
    		<ul>
        		<li id='open'>Open</li>
        		<li id='email'>Email</li>
        		<li id='save'>Save</li>
        		<li id='close'>Close</li>
    		</ul>
		</div>
    </body>
</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 25 12:38:15 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/aaa/CWA/app/views/edit_menu.scala.html
                    HASH: 4fa655e273fe61f6172d52b704339584722c816e
                    MATRIX: 859->0|1009->115|1023->121|1078->155|1169->211|1183->217|1238->251|1334->312|1348->318|1401->350|1688->601|1703->607|1770->652|1863->709|1878->715|1942->757|2035->814|2050->820|2110->858|2203->915|2218->921|2290->971|2408->1061|2437->1062|2516->1113|2545->1114|2598->1139|2627->1140|2693->1178|2722->1179|2831->1260|2860->1261|2925->1298|2954->1299|3064->1381|3093->1382|3157->1418|3186->1419|3295->1500|3324->1501|3390->1539|3419->1540|3530->1623|3559->1624|3598->1635|3627->1636|3661->1643|3689->1644|3721->1649|3749->1650
                    LINES: 29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|48->20|48->20|49->21|49->21|50->22|50->22|52->24|52->24|53->25|53->25|55->27|55->27|56->28|56->28|58->30|58->30|59->31|59->31|61->33|61->33|62->34|62->34|63->35|63->35|64->36|64->36
                    -- GENERATED --
                */
            