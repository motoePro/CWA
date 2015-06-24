
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
        <script src=""""),_display_(Seq[Any](/*8.23*/routes/*8.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*8.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*10.79*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*12.16*/("""{"""),format.raw/*12.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*14.11*/("""{"""),format.raw/*14.12*/("""
            		bindings: """),format.raw/*15.25*/("""{"""),format.raw/*15.26*/("""
                	'open': function(t) """),format.raw/*16.38*/("""{"""),format.raw/*16.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*18.15*/("""}"""),format.raw/*18.16*/(""",
            		'email': function(t) """),format.raw/*19.36*/("""{"""),format.raw/*19.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*21.15*/("""}"""),format.raw/*21.16*/(""",
            		'save': function(t) """),format.raw/*22.35*/("""{"""),format.raw/*22.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*24.15*/("""}"""),format.raw/*24.16*/(""",
            		'delete': function(t) """),format.raw/*25.37*/("""{"""),format.raw/*25.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*27.15*/("""}"""),format.raw/*27.16*/("""
        		"""),format.raw/*28.11*/("""}"""),format.raw/*28.12*/("""
    		"""),format.raw/*29.7*/("""}"""),format.raw/*29.8*/(""");
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");
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
                    DATE: Sat Jun 20 19:07:32 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_menu.scala.html
                    HASH: 67f5794ab79ceb4855c46f9f4bc12f0f84ef80b2
                    MATRIX: 859->0|1009->115|1023->121|1078->155|1169->211|1183->217|1238->251|1334->312|1348->318|1401->350|1461->375|1475->381|1534->419|1626->476|1640->482|1706->527|1799->584|1814->590|1886->640|2004->730|2033->731|2112->782|2141->783|2194->808|2223->809|2289->847|2318->848|2427->929|2456->930|2521->967|2550->968|2660->1050|2689->1051|2753->1087|2782->1088|2891->1169|2920->1170|2986->1208|3015->1209|3126->1292|3155->1293|3194->1304|3223->1305|3257->1312|3285->1313|3317->1318|3345->1319
                    LINES: 29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|42->14|42->14|43->15|43->15|44->16|44->16|46->18|46->18|47->19|47->19|49->21|49->21|50->22|50->22|52->24|52->24|53->25|53->25|55->27|55->27|56->28|56->28|57->29|57->29|58->30|58->30
                    -- GENERATED --
                */
            