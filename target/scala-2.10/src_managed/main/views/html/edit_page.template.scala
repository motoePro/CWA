
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
        _display_ {import helper._


Seq[Any](format.raw/*1.86*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
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
        
        
        window.onload = $(function()"""),format.raw/*23.37*/("""{"""),format.raw/*23.38*/("""
	var context = parent.main.document.getElementsByClassName("context");
	var context_length = context.length;
	for(var i = 0; i < context_length; i++)"""),format.raw/*26.41*/("""{"""),format.raw/*26.42*/("""
		if(ElementID < context[i].id)"""),format.raw/*27.32*/("""{"""),format.raw/*27.33*/("""
			ElementID = context[i].id;
		"""),format.raw/*29.3*/("""}"""),format.raw/*29.4*/("""
	"""),format.raw/*30.2*/("""}"""),format.raw/*30.3*/("""
	ElementID++;
"""),format.raw/*32.1*/("""}"""),format.raw/*32.2*/(""")

        
 		$(function()"""),format.raw/*35.16*/("""{"""),format.raw/*35.17*/("""
 			parent.edit_head.location.href = "/edit_head/target/"""),_display_(Seq[Any](/*36.58*/edit_page)),format.raw/*36.67*/("""";
 			parent.menu.target = """"),_display_(Seq[Any](/*37.28*/edit_page)),format.raw/*37.37*/("""";
			context();
			txtmv();
 			btnmv();
 		"""),format.raw/*41.4*/("""}"""),format.raw/*41.5*/(""")
 		
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*44.20*/("""{"""),format.raw/*44.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*46.26*/("""{"""),format.raw/*46.27*/("""stop: fix(), handles: "all""""),format.raw/*46.54*/("""}"""),format.raw/*46.55*/(""");
			//$('.pchan').resizable("""),format.raw/*47.28*/("""{"""),format.raw/*47.29*/("""stop: fix(), handles: "all""""),format.raw/*47.56*/("""}"""),format.raw/*47.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*48.3*/("""}"""),format.raw/*48.4*/("""
		function mv() """),format.raw/*49.17*/("""{"""),format.raw/*49.18*/("""
			$('.mv').draggable();
		"""),format.raw/*51.3*/("""}"""),format.raw/*51.4*/("""
		
		//要素のdraggable,resizable属性を削除(テキストのみ)
		function txtmvdestroy() """),format.raw/*54.27*/("""{"""),format.raw/*54.28*/("""
			$('.pchan').draggable( 'destroy' );
			$('.pchan').resizable( 'destroy' );
			//$('.pchan').resizable("""),format.raw/*57.28*/("""{"""),format.raw/*57.29*/("""stop: fix(), handles: "all""""),format.raw/*57.56*/("""}"""),format.raw/*57.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/("""
		function btnmv() """),format.raw/*59.20*/("""{"""),format.raw/*59.21*/("""
			$('.btnmv').draggable();
		"""),format.raw/*61.3*/("""}"""),format.raw/*61.4*/("""
		function pctmv() """),format.raw/*62.20*/("""{"""),format.raw/*62.21*/("""
			$('.img_chan').resizable("""),format.raw/*63.29*/("""{"""),format.raw/*63.30*/("""stop: fix(), handles: "all""""),format.raw/*63.57*/("""}"""),format.raw/*63.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/("""
		
		//youtubeにdraggable,resizable属性を加える
		function mvmv() """),format.raw/*67.19*/("""{"""),format.raw/*67.20*/("""
			$('.mv_chan').draggable();
			$('.mv_chan').resizable();
		"""),format.raw/*70.3*/("""}"""),format.raw/*70.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*73.18*/("""{"""),format.raw/*73.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*75.3*/("""}"""),format.raw/*75.4*/("""

	
		$(function()"""),format.raw/*78.15*/("""{"""),format.raw/*78.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*80.11*/("""{"""),format.raw/*80.12*/("""
            		bindings: """),format.raw/*81.25*/("""{"""),format.raw/*81.26*/("""
            		'delete': function(t) """),format.raw/*82.37*/("""{"""),format.raw/*82.38*/("""
                		var body = parent.main.document.getElementById('container');
                		var elm = document.getElementById(t.id);
                		console.log(elm);
                		body.removeChild(elm);
                		
                		//console.log(body.childNodes[t.id]);
                		//body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*90.15*/("""}"""),format.raw/*90.16*/("""
        		"""),format.raw/*91.11*/("""}"""),format.raw/*91.12*/("""
    		"""),format.raw/*92.7*/("""}"""),format.raw/*92.8*/(""");
		"""),format.raw/*93.3*/("""}"""),format.raw/*93.4*/(""");
		
		</script>
			<span id='head_main'>"""),_display_(Seq[Any](/*96.26*/for(line <- headLine) yield /*96.47*/{_display_(Seq[Any](_display_(Seq[Any](/*96.49*/Html(line)))))})),format.raw/*96.60*/("""</span>
    </head>
    <body style="width:100%;height:100%;">
        <div id='body_main' style="width:100%;height:100%;">
        	"""),_display_(Seq[Any](/*100.11*/for(line <- httpLine) yield /*100.32*/{_display_(Seq[Any](_display_(Seq[Any](/*100.34*/Html(line)))))})),format.raw/*100.45*/("""
        	"""),_display_(Seq[Any](/*101.11*/if("@httpLine[0]"=="")/*101.33*/ {_display_(Seq[Any](format.raw/*101.35*/("""<p>右上の「新規作成」「ページの変更」ボタンを押して、編集するページを選択してください。</p>""")))})),format.raw/*101.85*/("""
        	<script>console.log(if(""""),_display_(Seq[Any](/*102.35*/httpLine)),format.raw/*102.43*/(""""==""));</script>
        </div>
        <form id="t_edit" method="post">
        	"""),_display_(Seq[Any](/*105.11*/CSRF/*105.15*/.formField)),format.raw/*105.25*/("""
        </form>
        <div class='contextMenu' id='myMenu'>
    		<ul>
			<li id='edit'>Edit</li>
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
                    DATE: Fri Dec 18 00:14:56 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: 7c575806d33af95894dc6418ba82937b293b1fe1
                    MATRIX: 813->1|1007->85|1034->103|1151->185|1177->190|1274->252|1288->258|1359->307|1450->363|1464->369|1530->413|1626->474|1640->480|1704->522|1960->742|1975->748|2049->800|2142->857|2157->863|2228->912|2321->969|2336->975|2411->1028|2513->1094|2528->1100|2598->1148|2691->1205|2706->1211|2788->1271|2945->1400|2974->1401|3152->1551|3181->1552|3241->1584|3270->1585|3330->1618|3358->1619|3387->1621|3415->1622|3457->1637|3485->1638|3540->1665|3569->1666|3663->1724|3694->1733|3760->1763|3791->1772|3863->1817|3891->1818|3985->1884|4014->1885|4096->1939|4125->1940|4180->1967|4209->1968|4267->1998|4296->1999|4351->2026|4380->2027|4446->2066|4474->2067|4519->2084|4548->2085|4603->2113|4631->2114|4729->2184|4758->2185|4892->2291|4921->2292|4976->2319|5005->2320|5071->2359|5099->2360|5147->2380|5176->2381|5234->2412|5262->2413|5310->2433|5339->2434|5396->2463|5425->2464|5480->2491|5509->2492|5575->2531|5603->2532|5691->2592|5720->2593|5810->2656|5838->2657|5911->2702|5940->2703|5999->2735|6027->2736|6073->2754|6102->2755|6183->2808|6212->2809|6265->2834|6294->2835|6359->2872|6388->2873|6782->3239|6811->3240|6850->3251|6879->3252|6913->3259|6941->3260|6973->3265|7001->3266|7080->3309|7117->3330|7165->3332|7202->3343|7373->3477|7411->3498|7460->3500|7498->3511|7546->3522|7578->3544|7619->3546|7702->3596|7774->3631|7805->3639|7926->3723|7940->3727|7973->3737
                    LINES: 26->1|30->1|31->3|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|51->23|51->23|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|60->32|60->32|63->35|63->35|64->36|64->36|65->37|65->37|69->41|69->41|72->44|72->44|74->46|74->46|74->46|74->46|75->47|75->47|75->47|75->47|76->48|76->48|77->49|77->49|79->51|79->51|82->54|82->54|85->57|85->57|85->57|85->57|86->58|86->58|87->59|87->59|89->61|89->61|90->62|90->62|91->63|91->63|91->63|91->63|92->64|92->64|95->67|95->67|98->70|98->70|101->73|101->73|103->75|103->75|106->78|106->78|108->80|108->80|109->81|109->81|110->82|110->82|118->90|118->90|119->91|119->91|120->92|120->92|121->93|121->93|124->96|124->96|124->96|124->96|128->100|128->100|128->100|128->100|129->101|129->101|129->101|129->101|130->102|130->102|133->105|133->105|133->105
                    -- GENERATED --
                */
            