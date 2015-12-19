
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
 			pctmv();
 			mvmv();
 		"""),format.raw/*43.4*/("""}"""),format.raw/*43.5*/(""")
 		
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*46.20*/("""{"""),format.raw/*46.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*48.26*/("""{"""),format.raw/*48.27*/("""stop: fix(), handles: "all""""),format.raw/*48.54*/("""}"""),format.raw/*48.55*/(""");
			//$('.pchan').resizable("""),format.raw/*49.28*/("""{"""),format.raw/*49.29*/("""stop: fix(), handles: "all""""),format.raw/*49.56*/("""}"""),format.raw/*49.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*50.3*/("""}"""),format.raw/*50.4*/("""
		function mv() """),format.raw/*51.17*/("""{"""),format.raw/*51.18*/("""
			$('.mv').draggable();
		"""),format.raw/*53.3*/("""}"""),format.raw/*53.4*/("""
		
		//要素のdraggable,resizable属性を削除(テキストのみ)
		function txtmvdestroy() """),format.raw/*56.27*/("""{"""),format.raw/*56.28*/("""
			$('.pchan').draggable( 'destroy' );
			$('.pchan').resizable( 'destroy' );
			//$('.pchan').resizable("""),format.raw/*59.28*/("""{"""),format.raw/*59.29*/("""stop: fix(), handles: "all""""),format.raw/*59.56*/("""}"""),format.raw/*59.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*60.3*/("""}"""),format.raw/*60.4*/("""
		function pctmvdestroy() """),format.raw/*61.27*/("""{"""),format.raw/*61.28*/("""
			$('.img_chan').resizable("""),format.raw/*62.29*/("""{"""),format.raw/*62.30*/("""stop: fix(), handles: "all""""),format.raw/*62.57*/("""}"""),format.raw/*62.58*/(""").parent(".ui-wrapper").draggable( 'destroy' );
			$('.img_chan').resizable( 'destroy' );
		"""),format.raw/*64.3*/("""}"""),format.raw/*64.4*/("""
		function mvmvdestroy() """),format.raw/*65.26*/("""{"""),format.raw/*65.27*/("""
			$('.mv_chan').draggable( 'destroy' );
			$('.mv_chan').resizable( 'destroy' );
		"""),format.raw/*68.3*/("""}"""),format.raw/*68.4*/("""
		
		
		function btnmv() """),format.raw/*71.20*/("""{"""),format.raw/*71.21*/("""
			$('.btnmv').draggable();
		"""),format.raw/*73.3*/("""}"""),format.raw/*73.4*/("""
		function pctmv() """),format.raw/*74.20*/("""{"""),format.raw/*74.21*/("""
			$('.img_chan').resizable("""),format.raw/*75.29*/("""{"""),format.raw/*75.30*/("""stop: fix(), handles: "all""""),format.raw/*75.57*/("""}"""),format.raw/*75.58*/(""").parent(".ui-wrapper").addClass("context");
			$('.img_chan').resizable("""),format.raw/*76.29*/("""{"""),format.raw/*76.30*/("""stop: fix(), handles: "all""""),format.raw/*76.57*/("""}"""),format.raw/*76.58*/(""").parent(".ui-wrapper").draggable();
			
		"""),format.raw/*78.3*/("""}"""),format.raw/*78.4*/("""
		
		//youtubeにdraggable,resizable属性を加える
		function mvmv() """),format.raw/*81.19*/("""{"""),format.raw/*81.20*/("""
			$('.mv_chan').draggable();
			$('.mv_chan').resizable();
		"""),format.raw/*84.3*/("""}"""),format.raw/*84.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*87.18*/("""{"""),format.raw/*87.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*89.3*/("""}"""),format.raw/*89.4*/("""

	
		$(function()"""),format.raw/*92.15*/("""{"""),format.raw/*92.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*94.11*/("""{"""),format.raw/*94.12*/("""
            		bindings: """),format.raw/*95.25*/("""{"""),format.raw/*95.26*/("""
            		'delete': function(t) """),format.raw/*96.37*/("""{"""),format.raw/*96.38*/("""
            			parent.main.pctmvdestroy();
                		var body = parent.main.document.getElementById('container');
                		var elm = document.getElementById(t.id);
                		console.log(elm);
                		body.removeChild(elm);
                		
                		//console.log(body.childNodes[t.id]);
                		//body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*105.15*/("""}"""),format.raw/*105.16*/("""
        		"""),format.raw/*106.11*/("""}"""),format.raw/*106.12*/("""
    		"""),format.raw/*107.7*/("""}"""),format.raw/*107.8*/(""");
		"""),format.raw/*108.3*/("""}"""),format.raw/*108.4*/(""");
		
		</script>
			<span id='head_main'>"""),_display_(Seq[Any](/*111.26*/for(line <- headLine) yield /*111.47*/{_display_(Seq[Any](_display_(Seq[Any](/*111.49*/Html(line)))))})),format.raw/*111.60*/("""</span>
    </head>
    <body style="width:100%;height:100%;">
        <div id='body_main' style="width:100%;height:100%;">
        	"""),_display_(Seq[Any](/*115.11*/for(line <- httpLine) yield /*115.32*/{_display_(Seq[Any](_display_(Seq[Any](/*115.34*/Html(line)))))})),format.raw/*115.45*/("""
        	"""),_display_(Seq[Any](/*116.11*/if("@httpLine[0]"=="")/*116.33*/ {_display_(Seq[Any](format.raw/*116.35*/("""<p>右上の「新規作成」「ページの変更」ボタンを押して、編集するページを選択してください。</p>""")))})),format.raw/*116.85*/("""
        	<script>console.log(if(""""),_display_(Seq[Any](/*117.35*/httpLine)),format.raw/*117.43*/(""""==""));</script>
        </div>
        <form id="t_edit" method="post">
        	"""),_display_(Seq[Any](/*120.11*/CSRF/*120.15*/.formField)),format.raw/*120.25*/("""
        </form>
        <div class='contextMenu' id='myMenu'>
    		<ul>
			<li id='edit'>Edit</li>
        		<li id='delete'>Close</li>
        		<li id='link'>Link</li>
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
                    DATE: Sun Dec 20 06:04:30 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: 213bfe945c103bfb26a426de9fe3cf0882fdc5e0
                    MATRIX: 813->1|1007->85|1034->103|1151->185|1177->190|1274->252|1288->258|1359->307|1450->363|1464->369|1530->413|1626->474|1640->480|1704->522|1960->742|1975->748|2049->800|2142->857|2157->863|2228->912|2321->969|2336->975|2411->1028|2513->1094|2528->1100|2598->1148|2691->1205|2706->1211|2788->1271|2945->1400|2974->1401|3152->1551|3181->1552|3241->1584|3270->1585|3330->1618|3358->1619|3387->1621|3415->1622|3457->1637|3485->1638|3540->1665|3569->1666|3663->1724|3694->1733|3760->1763|3791->1772|3888->1842|3916->1843|4010->1909|4039->1910|4121->1964|4150->1965|4205->1992|4234->1993|4292->2023|4321->2024|4376->2051|4405->2052|4471->2091|4499->2092|4544->2109|4573->2110|4628->2138|4656->2139|4754->2209|4783->2210|4917->2316|4946->2317|5001->2344|5030->2345|5096->2384|5124->2385|5179->2412|5208->2413|5265->2442|5294->2443|5349->2470|5378->2471|5497->2563|5525->2564|5579->2590|5608->2591|5720->2676|5748->2677|5802->2703|5831->2704|5889->2735|5917->2736|5965->2756|5994->2757|6051->2786|6080->2787|6135->2814|6164->2815|6265->2888|6294->2889|6349->2916|6378->2917|6448->2960|6476->2961|6564->3021|6593->3022|6683->3085|6711->3086|6784->3131|6813->3132|6872->3164|6900->3165|6946->3183|6975->3184|7056->3237|7085->3238|7138->3263|7167->3264|7232->3301|7261->3302|7699->3711|7729->3712|7769->3723|7799->3724|7834->3731|7863->3732|7896->3737|7925->3738|8005->3781|8043->3802|8092->3804|8130->3815|8301->3949|8339->3970|8388->3972|8426->3983|8474->3994|8506->4016|8547->4018|8630->4068|8702->4103|8733->4111|8854->4195|8868->4199|8901->4209
                    LINES: 26->1|30->1|31->3|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|51->23|51->23|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|60->32|60->32|63->35|63->35|64->36|64->36|65->37|65->37|71->43|71->43|74->46|74->46|76->48|76->48|76->48|76->48|77->49|77->49|77->49|77->49|78->50|78->50|79->51|79->51|81->53|81->53|84->56|84->56|87->59|87->59|87->59|87->59|88->60|88->60|89->61|89->61|90->62|90->62|90->62|90->62|92->64|92->64|93->65|93->65|96->68|96->68|99->71|99->71|101->73|101->73|102->74|102->74|103->75|103->75|103->75|103->75|104->76|104->76|104->76|104->76|106->78|106->78|109->81|109->81|112->84|112->84|115->87|115->87|117->89|117->89|120->92|120->92|122->94|122->94|123->95|123->95|124->96|124->96|133->105|133->105|134->106|134->106|135->107|135->107|136->108|136->108|139->111|139->111|139->111|139->111|143->115|143->115|143->115|143->115|144->116|144->116|144->116|144->116|145->117|145->117|148->120|148->120|148->120
                    -- GENERATED --
                */
            