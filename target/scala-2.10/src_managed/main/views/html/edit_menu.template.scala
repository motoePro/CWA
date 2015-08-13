
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
        
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*17.79*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*19.16*/("""{"""),format.raw/*19.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*21.11*/("""{"""),format.raw/*21.12*/("""
            		bindings: """),format.raw/*22.25*/("""{"""),format.raw/*22.26*/("""
                	'open': function(t) """),format.raw/*23.38*/("""{"""),format.raw/*23.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*25.15*/("""}"""),format.raw/*25.16*/(""",
            		'email': function(t) """),format.raw/*26.36*/("""{"""),format.raw/*26.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*28.15*/("""}"""),format.raw/*28.16*/(""",
            		'save': function(t) """),format.raw/*29.35*/("""{"""),format.raw/*29.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*31.15*/("""}"""),format.raw/*31.16*/(""",
            		'delete': function(t) """),format.raw/*32.37*/("""{"""),format.raw/*32.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*34.15*/("""}"""),format.raw/*34.16*/("""
        		"""),format.raw/*35.11*/("""}"""),format.raw/*35.12*/("""
    		"""),format.raw/*36.7*/("""}"""),format.raw/*36.8*/(""");
		"""),format.raw/*37.3*/("""}"""),format.raw/*37.4*/(""");
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
                    DATE: Fri Aug 07 04:53:25 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_menu.scala.html
                    HASH: 8fe8fe5201be5b108b459626ec8e069e21f212fe
                    MATRIX: 859->0|1009->115|1023->121|1078->155|1169->211|1183->217|1238->251|1334->312|1348->318|1401->350|1688->601|1703->607|1770->652|1863->709|1878->715|1942->757|2035->814|2050->820|2110->858|2212->924|2227->930|2299->980|2417->1070|2446->1071|2525->1122|2554->1123|2607->1148|2636->1149|2702->1187|2731->1188|2840->1269|2869->1270|2934->1307|2963->1308|3073->1390|3102->1391|3166->1427|3195->1428|3304->1509|3333->1510|3399->1548|3428->1549|3539->1632|3568->1633|3607->1644|3636->1645|3670->1652|3698->1653|3730->1658|3758->1659
                    LINES: 29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|47->19|47->19|49->21|49->21|50->22|50->22|51->23|51->23|53->25|53->25|54->26|54->26|56->28|56->28|57->29|57->29|59->31|59->31|60->32|60->32|62->34|62->34|63->35|63->35|64->36|64->36|65->37|65->37
                    -- GENERATED --
                */
            