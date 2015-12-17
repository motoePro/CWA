
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

		//画像にdraggable,resizable属性を加える(画像)		
		function pctmv() """),format.raw/*33.20*/("""{"""),format.raw/*33.21*/("""
			$('.img_chan').resizable("""),format.raw/*34.29*/("""{"""),format.raw/*34.30*/("""stop: fix(), handles: "all""""),format.raw/*34.57*/("""}"""),format.raw/*34.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*35.3*/("""}"""),format.raw/*35.4*/("""
		
		//youtubeにdraggable,resizable属性を加える
		function mvmv() """),format.raw/*38.19*/("""{"""),format.raw/*38.20*/("""
			$('.mv_chan').draggable();
			$('.mv_chan').resizable();
		"""),format.raw/*41.3*/("""}"""),format.raw/*41.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*44.18*/("""{"""),format.raw/*44.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*46.3*/("""}"""),format.raw/*46.4*/("""


	
		$(function()"""),format.raw/*50.15*/("""{"""),format.raw/*50.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*52.11*/("""{"""),format.raw/*52.12*/("""
            		bindings: """),format.raw/*53.25*/("""{"""),format.raw/*53.26*/("""
            		'delete': function(t) """),format.raw/*54.37*/("""{"""),format.raw/*54.38*/("""
                		var body = parent.main.document.getElementById('body_main');
                		console.log(body.childNodes[t.id]);
                		body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*58.15*/("""}"""),format.raw/*58.16*/("""
        		"""),format.raw/*59.11*/("""}"""),format.raw/*59.12*/("""
    		"""),format.raw/*60.7*/("""}"""),format.raw/*60.8*/(""");
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/(""");
		
		</script>
			<span id='head_main'>"""),_display_(Seq[Any](/*64.26*/for(line <- headLine) yield /*64.47*/{_display_(Seq[Any](_display_(Seq[Any](/*64.49*/Html(line)))))})),format.raw/*64.60*/("""</span>
    </head>
    <body style="width:100%;height:100%;">
        <div id='body_main' style="width:100%;height:100%;">
        	"""),_display_(Seq[Any](/*68.11*/for(line <- httpLine) yield /*68.32*/{_display_(Seq[Any](_display_(Seq[Any](/*68.34*/Html(line)))))})),format.raw/*68.45*/("""
        	"""),_display_(Seq[Any](/*69.11*/if(httpLine==null)/*69.29*/ {_display_(Seq[Any](format.raw/*69.31*/("""
        		<p>右上の「新規作成」「ページの変更」ボタンを押して、編集するページを選択してください。</p>
        	""")))})),format.raw/*71.11*/("""
        </div>
        
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
                    DATE: Wed Dec 16 16:07:16 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: 01db7c009706e17404e421421c54f2c30ba7a256
                    MATRIX: 813->1|991->85|1110->169|1136->174|1233->236|1247->242|1318->291|1409->347|1423->353|1489->397|1585->458|1599->464|1663->506|1919->726|1934->732|2008->784|2101->841|2116->847|2187->896|2280->953|2295->959|2370->1012|2472->1078|2487->1084|2557->1132|2650->1189|2665->1195|2747->1255|2865->1345|2894->1346|2988->1404|3019->1413|3052->1419|3080->1420|3174->1486|3203->1487|3285->1541|3314->1542|3369->1569|3398->1570|3456->1600|3485->1601|3540->1628|3569->1629|3635->1668|3663->1669|3751->1729|3780->1730|3837->1759|3866->1760|3921->1787|3950->1788|4016->1827|4044->1828|4132->1888|4161->1889|4251->1952|4279->1953|4352->1998|4381->1999|4440->2031|4468->2032|4515->2051|4544->2052|4625->2105|4654->2106|4707->2131|4736->2132|4801->2169|4830->2170|5065->2377|5094->2378|5133->2389|5162->2390|5196->2397|5224->2398|5256->2403|5284->2404|5363->2447|5400->2468|5448->2470|5485->2481|5655->2615|5692->2636|5740->2638|5777->2649|5824->2660|5851->2678|5891->2680|5994->2751
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|50->22|50->22|51->23|51->23|54->26|54->26|56->28|56->28|56->28|56->28|57->29|57->29|57->29|57->29|58->30|58->30|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|66->38|66->38|69->41|69->41|72->44|72->44|74->46|74->46|78->50|78->50|80->52|80->52|81->53|81->53|82->54|82->54|86->58|86->58|87->59|87->59|88->60|88->60|89->61|89->61|92->64|92->64|92->64|92->64|96->68|96->68|96->68|96->68|97->69|97->69|97->69|99->71
                    -- GENERATED --
                */
            