
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
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("stylesheets/jquery-ui.css"))),format.raw/*7.99*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery-ui.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/jquery.min.js"))),format.raw/*15.68*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("javascripts/jquery.fittext.js"))),format.raw/*16.72*/("""" type="text/javascript"></script>
        
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*18.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*19.23*/routes/*19.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*19.79*/("""" type="text/javascript"></script>
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
                    DATE: Wed Sep 30 12:56:55 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_page.scala.html
                    HASH: 8c47c6f7dea25b838dff10632c1a48e5cbe1a64f
                    MATRIX: 813->1|991->85|1078->137|1104->142|1201->204|1215->210|1275->249|1366->305|1380->311|1435->345|1531->406|1545->412|1598->444|1854->664|1869->670|1933->712|2026->769|2041->775|2102->814|2195->871|2210->877|2275->920|2377->986|2392->992|2452->1030|2545->1087|2560->1093|2632->1143|2754->1237|2783->1238|2877->1296|2908->1305|2941->1311|2969->1312|3063->1378|3092->1379|3174->1433|3203->1434|3258->1461|3287->1462|3345->1492|3374->1493|3429->1520|3458->1521|3524->1560|3552->1561|3603->1584|3632->1585|3689->1614|3718->1615|3773->1642|3802->1643|3868->1682|3896->1683|3969->1728|3998->1729|4057->1761|4085->1762|4180->1829|4209->1830|4290->1883|4319->1884|4372->1909|4401->1910|4466->1947|4495->1948|4730->2155|4759->2156|4798->2167|4827->2168|4861->2175|4889->2176|4921->2181|4949->2182|5026->2223|5063->2244|5111->2246|5148->2257|5243->2316|5280->2337|5328->2339|5365->2350
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|50->22|50->22|51->23|51->23|52->24|52->24|55->27|55->27|57->29|57->29|57->29|57->29|58->30|58->30|58->30|58->30|59->31|59->31|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|66->38|66->38|68->40|68->40|71->43|71->43|73->45|73->45|74->46|74->46|75->47|75->47|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|85->57|85->57|85->57|85->57|88->60|88->60|88->60|88->60
                    -- GENERATED --
                */
            