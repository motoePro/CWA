
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
object edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(httpLine: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

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
 
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*24.20*/("""{"""),format.raw/*24.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*26.26*/("""{"""),format.raw/*26.27*/("""stop: fix(), handles: "all""""),format.raw/*26.54*/("""}"""),format.raw/*26.55*/(""");
			//$('.pchan').resizable("""),format.raw/*27.28*/("""{"""),format.raw/*27.29*/("""stop: fix(), handles: "all""""),format.raw/*27.56*/("""}"""),format.raw/*27.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*28.3*/("""}"""),format.raw/*28.4*/("""
		
		function pctmv() """),format.raw/*30.20*/("""{"""),format.raw/*30.21*/("""
			$('.img_chan').resizable("""),format.raw/*31.29*/("""{"""),format.raw/*31.30*/("""stop: fix(), handles: "all""""),format.raw/*31.57*/("""}"""),format.raw/*31.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*32.3*/("""}"""),format.raw/*32.4*/("""
		
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*36.18*/("""{"""),format.raw/*36.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*38.3*/("""}"""),format.raw/*38.4*/("""
		</script>
        <script type='text/javascript'>
		$(function() """),format.raw/*41.16*/("""{"""),format.raw/*41.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*43.11*/("""{"""),format.raw/*43.12*/("""
            		bindings: """),format.raw/*44.25*/("""{"""),format.raw/*44.26*/("""
                	'open': function(t) """),format.raw/*45.38*/("""{"""),format.raw/*45.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*47.15*/("""}"""),format.raw/*47.16*/(""",
            		'email': function(t) """),format.raw/*48.36*/("""{"""),format.raw/*48.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*50.15*/("""}"""),format.raw/*50.16*/(""",
            		'save': function(t) """),format.raw/*51.35*/("""{"""),format.raw/*51.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*53.15*/("""}"""),format.raw/*53.16*/(""",
            		'delete': function(t) """),format.raw/*54.37*/("""{"""),format.raw/*54.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*56.15*/("""}"""),format.raw/*56.16*/("""
        		"""),format.raw/*57.11*/("""}"""),format.raw/*57.12*/("""
    		"""),format.raw/*58.7*/("""}"""),format.raw/*58.8*/(""");
		"""),format.raw/*59.3*/("""}"""),format.raw/*59.4*/(""");
		</script>
    </head>
    <body>
        <div>
            """),_display_(Seq[Any](/*64.14*/for(line <- httpLine) yield /*64.35*/ {_display_(Seq[Any](format.raw/*64.37*/("""
                """),_display_(Seq[Any](/*65.18*/line)),format.raw/*65.22*/("""<br>
            """)))})),format.raw/*66.14*/("""
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
</html>"""))}
    }
    
    def render(title:String,httpLine:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(title)(httpLine)
    
    def f:((String) => (Array[String]) => play.api.templates.HtmlFormat.Appendable) = (title) => (httpLine) => apply(title)(httpLine)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 25 12:38:15 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/aaa/CWA/app/views/edit_page.scala.html
                    HASH: bd05ffb1f79564e44ea1213350a1936b74491d6c
                    MATRIX: 792->1|926->41|1014->94|1040->99|1137->161|1151->167|1211->206|1302->262|1316->268|1371->302|1468->363|1483->369|1537->401|1793->621|1808->627|1872->669|1965->726|1980->732|2041->771|2134->828|2149->834|2214->877|2316->943|2331->949|2391->987|2484->1044|2499->1050|2571->1100|2736->1237|2765->1238|2847->1292|2876->1293|2931->1320|2960->1321|3018->1351|3047->1352|3102->1379|3131->1380|3197->1419|3225->1420|3276->1443|3305->1444|3362->1473|3391->1474|3446->1501|3475->1502|3541->1541|3569->1542|3645->1590|3674->1591|3733->1623|3761->1624|3857->1692|3886->1693|3965->1744|3994->1745|4047->1770|4076->1771|4142->1809|4171->1810|4280->1891|4309->1892|4374->1929|4403->1930|4513->2012|4542->2013|4606->2049|4635->2050|4744->2131|4773->2132|4839->2170|4868->2171|4979->2254|5008->2255|5047->2266|5076->2267|5110->2274|5138->2275|5170->2280|5198->2281|5299->2346|5336->2367|5376->2369|5430->2387|5456->2391|5506->2409
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|52->24|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|64->36|64->36|66->38|66->38|69->41|69->41|71->43|71->43|72->44|72->44|73->45|73->45|75->47|75->47|76->48|76->48|78->50|78->50|79->51|79->51|81->53|81->53|82->54|82->54|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|92->64|92->64|92->64|93->65|93->65|94->66
                    -- GENERATED --
                */
            