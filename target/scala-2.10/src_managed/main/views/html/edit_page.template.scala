
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
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/jquery-ui.css"))),format.raw/*8.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("stylesheets/main.css"))),format.raw/*9.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*10.59*/routes/*10.65*/.Assets.at("images/favicon.png"))),format.raw/*10.97*/("""">
        
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/jquery-ui.min.js"))),format.raw/*15.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/jquery.min.js"))),format.raw/*16.68*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/jquery.fittext.js"))),format.raw/*17.72*/("""" type="text/javascript"></script>
        
        <script src=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*19.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*20.79*/("""" type="text/javascript"></script>
        <script type="text/javascript">
        
       	$(function()"""),format.raw/*23.21*/("""{"""),format.raw/*23.22*/("""
       		parent.edit_head.location.href = "/edit_head?target_name="""),_display_(Seq[Any](/*24.68*/edit_page)),format.raw/*24.77*/("""";
       	"""),format.raw/*25.9*/("""}"""),format.raw/*25.10*/(""");
 
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*28.20*/("""{"""),format.raw/*28.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*30.26*/("""{"""),format.raw/*30.27*/("""stop: fix(), handles: "all""""),format.raw/*30.54*/("""}"""),format.raw/*30.55*/(""");
			//$('.pchan').resizable("""),format.raw/*31.28*/("""{"""),format.raw/*31.29*/("""stop: fix(), handles: "all""""),format.raw/*31.56*/("""}"""),format.raw/*31.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*32.3*/("""}"""),format.raw/*32.4*/("""
		
		function pctmv() """),format.raw/*34.20*/("""{"""),format.raw/*34.21*/("""
			$('.img_chan').resizable("""),format.raw/*35.29*/("""{"""),format.raw/*35.30*/("""stop: fix(), handles: "all""""),format.raw/*35.57*/("""}"""),format.raw/*35.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*36.3*/("""}"""),format.raw/*36.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*39.18*/("""{"""),format.raw/*39.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*41.3*/("""}"""),format.raw/*41.4*/("""
		</script>
        <script type='text/javascript'>
		$(function()"""),format.raw/*44.15*/("""{"""),format.raw/*44.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*46.11*/("""{"""),format.raw/*46.12*/("""
            		bindings: """),format.raw/*47.25*/("""{"""),format.raw/*47.26*/("""
            		'delete': function(t) """),format.raw/*48.37*/("""{"""),format.raw/*48.38*/("""
                		var body = parent.main.document.getElementById('body_main');
                		console.log(body.childNodes[t.id]);
                		body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*52.15*/("""}"""),format.raw/*52.16*/("""
        		"""),format.raw/*53.11*/("""}"""),format.raw/*53.12*/("""
    		"""),format.raw/*54.7*/("""}"""),format.raw/*54.8*/(""");
		"""),format.raw/*55.3*/("""}"""),format.raw/*55.4*/(""");
		
		</script>
		<div id='head_main'>"""),_display_(Seq[Any](/*58.24*/for(line <- headLine) yield /*58.45*/{_display_(Seq[Any](_display_(Seq[Any](/*58.47*/Html(line)))))})),format.raw/*58.58*/("""</div>
    </head>
    <body>
        <div id='body_main'>"""),_display_(Seq[Any](/*61.30*/for(line <- httpLine) yield /*61.51*/{_display_(Seq[Any](_display_(Seq[Any](/*61.53*/Html(line)))))})),format.raw/*61.64*/("""</div>
        
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
                    DATE: Thu Sep 03 05:19:14 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_page.scala.html
                    HASH: d19fa30d0f306e8d87759d625371eecc553210b4
                    MATRIX: 813->1|991->85|1079->138|1105->143|1202->205|1216->211|1276->250|1367->306|1381->312|1436->346|1533->407|1548->413|1602->445|1858->665|1873->671|1937->713|2030->770|2045->776|2106->815|2199->872|2214->878|2279->921|2381->987|2396->993|2456->1031|2549->1088|2564->1094|2636->1144|2768->1248|2797->1249|2901->1317|2932->1326|2970->1337|2999->1338|3092->1403|3121->1404|3203->1458|3232->1459|3287->1486|3316->1487|3374->1517|3403->1518|3458->1545|3487->1546|3553->1585|3581->1586|3632->1609|3661->1610|3718->1639|3747->1640|3802->1667|3831->1668|3897->1707|3925->1708|3998->1753|4027->1754|4086->1786|4114->1787|4209->1854|4238->1855|4319->1908|4348->1909|4401->1934|4430->1935|4495->1972|4524->1973|4759->2180|4788->2181|4827->2192|4856->2193|4890->2200|4918->2201|4950->2206|4978->2207|5055->2248|5092->2269|5140->2271|5177->2282|5272->2341|5309->2362|5357->2364|5394->2375
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|51->23|51->23|52->24|52->24|53->25|53->25|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|62->34|62->34|63->35|63->35|63->35|63->35|64->36|64->36|67->39|67->39|69->41|69->41|72->44|72->44|74->46|74->46|75->47|75->47|76->48|76->48|80->52|80->52|81->53|81->53|82->54|82->54|83->55|83->55|86->58|86->58|86->58|86->58|89->61|89->61|89->61|89->61
                    -- GENERATED --
                */
            