
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
object edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template4[String,Array[String],Array[String],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(headLine: Array[String])(httpLine: Array[String])(edit_page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.86*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>"""),_display_(Seq[Any](/*6.17*/title)),format.raw/*6.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("/public","stylesheets/jquery-ui.css"))),format.raw/*7.109*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("/public","javascripts/jquery-ui.min.js"))),format.raw/*14.81*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("/public","javascripts/jquery.min.js"))),format.raw/*15.78*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("/public","javascripts/jquery.fittext.js"))),format.raw/*16.82*/("""" type="text/javascript"></script>
        
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*18.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*19.89*/("""" type="text/javascript"></script>
        <script type="text/javascript">
 		
 		$(function()"""),format.raw/*22.16*/("""{"""),format.raw/*22.17*/("""
 			parent.edit_head.location.href = "/edit_head/target/"""),_display_(Seq[Any](/*23.58*/edit_page)),format.raw/*23.67*/("""";
 		"""),format.raw/*24.4*/("""}"""),format.raw/*24.5*/(""")
 		
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*27.20*/("""{"""),format.raw/*27.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*29.26*/("""{"""),format.raw/*29.27*/("""stop: fix(), handles: "all""""),format.raw/*29.54*/("""}"""),format.raw/*29.55*/(""");
			//$('.pchan').resizable("""),format.raw/*30.28*/("""{"""),format.raw/*30.29*/("""stop: fix(), handles: "all""""),format.raw/*30.56*/("""}"""),format.raw/*30.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*31.3*/("""}"""),format.raw/*31.4*/("""
		
		function pctmv() """),format.raw/*33.20*/("""{"""),format.raw/*33.21*/("""
			$('.img_chan').resizable("""),format.raw/*34.29*/("""{"""),format.raw/*34.30*/("""stop: fix(), handles: "all""""),format.raw/*34.57*/("""}"""),format.raw/*34.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*35.3*/("""}"""),format.raw/*35.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*38.18*/("""{"""),format.raw/*38.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*40.3*/("""}"""),format.raw/*40.4*/("""
		</script>
        <script type='text/javascript'>
		$(function()"""),format.raw/*43.15*/("""{"""),format.raw/*43.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*45.11*/("""{"""),format.raw/*45.12*/("""
            		bindings: """),format.raw/*46.25*/("""{"""),format.raw/*46.26*/("""
            		'delete': function(t) """),format.raw/*47.37*/("""{"""),format.raw/*47.38*/("""
                		var body = parent.main.document.getElementById('body_main');
                		console.log(body.childNodes[t.id]);
                		body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*51.15*/("""}"""),format.raw/*51.16*/("""
        		"""),format.raw/*52.11*/("""}"""),format.raw/*52.12*/("""
    		"""),format.raw/*53.7*/("""}"""),format.raw/*53.8*/(""");
		"""),format.raw/*54.3*/("""}"""),format.raw/*54.4*/(""");
		
		</script>
		<div id='head_main'>"""),_display_(Seq[Any](/*57.24*/for(line <- headLine) yield /*57.45*/{_display_(Seq[Any](_display_(Seq[Any](/*57.47*/Html(line)))))})),format.raw/*57.58*/("""</div>
    </head>
    <body>
        <div id='body_main'>"""),_display_(Seq[Any](/*60.30*/for(line <- httpLine) yield /*60.51*/{_display_(Seq[Any](_display_(Seq[Any](/*60.53*/Html(line)))))})),format.raw/*60.64*/("""</div>
        
        <div class='contextMenu' id='myMenu'>
    		<ul>
        		<li id='delete'>Close</li>
    		</ul>
		</div>
    </body>
</html>"""))}
    }
    
    def render(title:String,headLine:Array[String],httpLine:Array[String],edit_page:String): play.api.templates.HtmlFormat.Appendable = apply(title)(headLine)(httpLine)(edit_page)
    
    def f:((String) => (Array[String]) => (Array[String]) => (String) => play.api.templates.HtmlFormat.Appendable) = (title) => (headLine) => (httpLine) => (edit_page) => apply(title)(headLine)(httpLine)(edit_page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 09 19:32:27 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: e4077f920fee7fb977d862bbebe1f5b94cc1085b
                    MATRIX: 813->1|991->85|1078->137|1104->142|1201->204|1215->210|1286->259|1377->315|1391->321|1457->365|1553->426|1567->432|1631->474|1887->694|1902->700|1976->752|2069->809|2084->815|2155->864|2248->921|2263->927|2338->980|2440->1046|2455->1052|2525->1100|2618->1157|2633->1163|2715->1223|2837->1317|2866->1318|2960->1376|2991->1385|3024->1391|3052->1392|3146->1458|3175->1459|3257->1513|3286->1514|3341->1541|3370->1542|3428->1572|3457->1573|3512->1600|3541->1601|3607->1640|3635->1641|3686->1664|3715->1665|3772->1694|3801->1695|3856->1722|3885->1723|3951->1762|3979->1763|4052->1808|4081->1809|4140->1841|4168->1842|4263->1909|4292->1910|4373->1963|4402->1964|4455->1989|4484->1990|4549->2027|4578->2028|4813->2235|4842->2236|4881->2247|4910->2248|4944->2255|4972->2256|5004->2261|5032->2262|5109->2303|5146->2324|5194->2326|5231->2337|5326->2396|5363->2417|5411->2419|5448->2430
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|50->22|50->22|51->23|51->23|52->24|52->24|55->27|55->27|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|66->38|66->38|68->40|68->40|71->43|71->43|73->45|73->45|74->46|74->46|75->47|75->47|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|85->57|85->57|85->57|85->57|88->60|88->60|88->60|88->60
                    -- GENERATED --
                */
            