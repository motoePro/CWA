
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
<html style="width:100%;height:100%;">
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
 		$(function()"""),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""
 			parent.edit_head.location.href = "/edit_head/target/"""),_display_(Seq[Any](/*22.58*/edit_page)),format.raw/*22.67*/("""";
 		"""),format.raw/*23.4*/("""}"""),format.raw/*23.5*/(""")
 		
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*26.20*/("""{"""),format.raw/*26.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*28.26*/("""{"""),format.raw/*28.27*/("""stop: fix(), handles: "all""""),format.raw/*28.54*/("""}"""),format.raw/*28.55*/(""");
			//$('.pchan').resizable("""),format.raw/*29.28*/("""{"""),format.raw/*29.29*/("""stop: fix(), handles: "all""""),format.raw/*29.56*/("""}"""),format.raw/*29.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/("""
		
		function pctmv() """),format.raw/*32.20*/("""{"""),format.raw/*32.21*/("""
			$('.img_chan').resizable("""),format.raw/*33.29*/("""{"""),format.raw/*33.30*/("""stop: fix(), handles: "all""""),format.raw/*33.57*/("""}"""),format.raw/*33.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*34.3*/("""}"""),format.raw/*34.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*37.18*/("""{"""),format.raw/*37.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*39.3*/("""}"""),format.raw/*39.4*/("""

		$(function()"""),format.raw/*41.15*/("""{"""),format.raw/*41.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*43.11*/("""{"""),format.raw/*43.12*/("""
            		bindings: """),format.raw/*44.25*/("""{"""),format.raw/*44.26*/("""
            		'delete': function(t) """),format.raw/*45.37*/("""{"""),format.raw/*45.38*/("""
                		var body = parent.main.document.getElementById('body_main');
                		console.log(body.childNodes[t.id]);
                		body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*49.15*/("""}"""),format.raw/*49.16*/("""
        		"""),format.raw/*50.11*/("""}"""),format.raw/*50.12*/("""
    		"""),format.raw/*51.7*/("""}"""),format.raw/*51.8*/(""");
		"""),format.raw/*52.3*/("""}"""),format.raw/*52.4*/(""");
		
		</script>
			<span id='head_main'>"""),_display_(Seq[Any](/*55.26*/for(line <- headLine) yield /*55.47*/{_display_(Seq[Any](_display_(Seq[Any](/*55.49*/Html(line)))))})),format.raw/*55.60*/("""</span>
    </head>
    <body style="width:100%;height:100%;">
        <div id='body_main' style="width:100%;height:100%;">"""),_display_(Seq[Any](/*58.62*/for(line <- httpLine) yield /*58.83*/{_display_(Seq[Any](_display_(Seq[Any](/*58.85*/Html(line)))))})),format.raw/*58.96*/("""</div>
        
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
                    DATE: Thu Nov 26 09:25:50 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: 80be92c8a5d56049458858beac71c0385bce8eb6
                    MATRIX: 813->1|991->85|1110->169|1136->174|1233->236|1247->242|1318->291|1409->347|1423->353|1489->397|1585->458|1599->464|1663->506|1919->726|1934->732|2008->784|2101->841|2116->847|2187->896|2280->953|2295->959|2370->1012|2472->1078|2487->1084|2557->1132|2650->1189|2665->1195|2747->1255|2865->1345|2894->1346|2988->1404|3019->1413|3052->1419|3080->1420|3174->1486|3203->1487|3285->1541|3314->1542|3369->1569|3398->1570|3456->1600|3485->1601|3540->1628|3569->1629|3635->1668|3663->1669|3714->1692|3743->1693|3800->1722|3829->1723|3884->1750|3913->1751|3979->1790|4007->1791|4080->1836|4109->1837|4168->1869|4196->1870|4240->1886|4269->1887|4350->1940|4379->1941|4432->1966|4461->1967|4526->2004|4555->2005|4790->2212|4819->2213|4858->2224|4887->2225|4921->2232|4949->2233|4981->2238|5009->2239|5088->2282|5125->2303|5173->2305|5210->2316|5370->2440|5407->2461|5455->2463|5492->2474
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|50->22|50->22|51->23|51->23|54->26|54->26|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|60->32|60->32|61->33|61->33|61->33|61->33|62->34|62->34|65->37|65->37|67->39|67->39|69->41|69->41|71->43|71->43|72->44|72->44|73->45|73->45|77->49|77->49|78->50|78->50|79->51|79->51|80->52|80->52|83->55|83->55|83->55|83->55|86->58|86->58|86->58|86->58
                    -- GENERATED --
                */
            