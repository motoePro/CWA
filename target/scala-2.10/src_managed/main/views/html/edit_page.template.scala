
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
object edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

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
    
    def render(title:String): play.api.templates.HtmlFormat.Appendable = apply(title)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (title) => apply(title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 25 11:47:03 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: 086f29ef60b21f67daaa1ac5a6ab80201373f5d2
                    MATRIX: 778->1|887->16|975->69|1001->74|1098->136|1112->142|1172->181|1263->237|1277->243|1332->277|1429->338|1444->344|1498->376|1754->596|1769->602|1833->644|1926->701|1941->707|2002->746|2095->803|2110->809|2175->852|2277->918|2292->924|2352->962|2445->1019|2460->1025|2532->1075|2697->1212|2726->1213|2808->1267|2837->1268|2892->1295|2921->1296|2979->1326|3008->1327|3063->1354|3092->1355|3158->1394|3186->1395|3237->1418|3266->1419|3323->1448|3352->1449|3407->1476|3436->1477|3502->1516|3530->1517|3606->1565|3635->1566|3694->1598|3722->1599|3818->1667|3847->1668|3926->1719|3955->1720|4008->1745|4037->1746|4103->1784|4132->1785|4241->1866|4270->1867|4335->1904|4364->1905|4474->1987|4503->1988|4567->2024|4596->2025|4705->2106|4734->2107|4800->2145|4829->2146|4940->2229|4969->2230|5008->2241|5037->2242|5071->2249|5099->2250|5131->2255|5159->2256
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|43->15|43->15|43->15|44->16|44->16|44->16|45->17|45->17|45->17|47->19|47->19|47->19|48->20|48->20|48->20|52->24|52->24|54->26|54->26|54->26|54->26|55->27|55->27|55->27|55->27|56->28|56->28|58->30|58->30|59->31|59->31|59->31|59->31|60->32|60->32|64->36|64->36|66->38|66->38|69->41|69->41|71->43|71->43|72->44|72->44|73->45|73->45|75->47|75->47|76->48|76->48|78->50|78->50|79->51|79->51|81->53|81->53|82->54|82->54|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59
                    -- GENERATED --
                */
            