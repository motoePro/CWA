
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
object edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Array[String],String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(httpLine: Array[String])(edit_page: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.61*/("""

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
       		parent.edit_head.location.href = "/edit_head/target/"""),_display_(Seq[Any](/*24.63*/edit_page)),format.raw/*24.72*/("""";
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
    
    def render(title:String,httpLine:Array[String],edit_page:String): play.api.templates.HtmlFormat.Appendable = apply(title)(httpLine)(edit_page)
    
    def f:((String) => (Array[String]) => (String) => play.api.templates.HtmlFormat.Appendable) = (title) => (httpLine) => (edit_page) => apply(title)(httpLine)(edit_page)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 11 22:34:51 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_page.scala.html
                    HASH: f3c63ea31bf104e7f780f4ce16f56cf7469613c6
                    MATRIX: 799->1|952->60|1040->113|1066->118|1163->180|1177->186|1237->225|1328->281|1342->287|1397->321|1494->382|1509->388|1563->420|1819->640|1834->646|1898->688|1991->745|2006->751|2067->790|2160->847|2175->853|2240->896|2342->962|2357->968|2417->1006|2510->1063|2525->1069|2597->1119|2729->1223|2758->1224|2857->1287|2888->1296|2926->1307|2955->1308|3048->1373|3077->1374|3159->1428|3188->1429|3243->1456|3272->1457|3330->1487|3359->1488|3414->1515|3443->1516|3509->1555|3537->1556|3588->1579|3617->1580|3674->1609|3703->1610|3758->1637|3787->1638|3853->1677|3881->1678|3954->1723|3983->1724|4042->1756|4070->1757|4165->1824|4194->1825|4275->1878|4304->1879|4357->1904|4386->1905|4451->1942|4480->1943|4715->2150|4744->2151|4783->2162|4812->2163|4846->2170|4874->2171|4906->2176|4934->2177|5040->2247|5077->2268|5125->2270|5162->2281
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|51->23|51->23|52->24|52->24|53->25|53->25|56->28|56->28|58->30|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|62->34|62->34|63->35|63->35|63->35|63->35|64->36|64->36|67->39|67->39|69->41|69->41|72->44|72->44|74->46|74->46|75->47|75->47|76->48|76->48|80->52|80->52|81->53|81->53|82->54|82->54|83->55|83->55|88->60|88->60|88->60|88->60
                    -- GENERATED --
                */
            