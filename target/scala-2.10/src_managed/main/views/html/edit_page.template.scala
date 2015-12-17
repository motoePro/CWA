
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
 		$(function()"""),format.raw/*21.16*/("""{"""),format.raw/*21.17*/("""
 			parent.edit_head.location.href = "/edit_head/target/"""),_display_(Seq[Any](/*22.58*/edit_page)),format.raw/*22.67*/("""";
			context();
			txtmv();
 			btnmv();
 		"""),format.raw/*26.4*/("""}"""),format.raw/*26.5*/(""")
 		
		//要素にdraggable,resizable属性を加える(テキストのみ)
		function txtmv() """),format.raw/*29.20*/("""{"""),format.raw/*29.21*/("""
			$('.pchan').draggable();
			$('.pchan').resizable("""),format.raw/*31.26*/("""{"""),format.raw/*31.27*/("""stop: fix(), handles: "all""""),format.raw/*31.54*/("""}"""),format.raw/*31.55*/(""");
			//$('.pchan').resizable("""),format.raw/*32.28*/("""{"""),format.raw/*32.29*/("""stop: fix(), handles: "all""""),format.raw/*32.56*/("""}"""),format.raw/*32.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*33.3*/("""}"""),format.raw/*33.4*/("""



		function mv() """),format.raw/*37.17*/("""{"""),format.raw/*37.18*/("""
			$('.mv').draggable();
		"""),format.raw/*39.3*/("""}"""),format.raw/*39.4*/("""
		
		//要素のdraggable,resizable属性を削除(テキストのみ)
		function txtmvdestroy() """),format.raw/*42.27*/("""{"""),format.raw/*42.28*/("""
			$('.pchan').draggable( 'destroy' );
			$('.pchan').resizable( 'destroy' );
			//$('.pchan').resizable("""),format.raw/*45.28*/("""{"""),format.raw/*45.29*/("""stop: fix(), handles: "all""""),format.raw/*45.56*/("""}"""),format.raw/*45.57*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*46.3*/("""}"""),format.raw/*46.4*/("""
		function btnmv() """),format.raw/*47.20*/("""{"""),format.raw/*47.21*/("""
			$('.btnmv').draggable();
		"""),format.raw/*49.3*/("""}"""),format.raw/*49.4*/("""
		function pctmv() """),format.raw/*50.20*/("""{"""),format.raw/*50.21*/("""
			$('.img_chan').resizable("""),format.raw/*51.29*/("""{"""),format.raw/*51.30*/("""stop: fix(), handles: "all""""),format.raw/*51.57*/("""}"""),format.raw/*51.58*/(""").parent(".ui-wrapper").draggable();
		"""),format.raw/*52.3*/("""}"""),format.raw/*52.4*/("""
		
		//youtubeにdraggable,resizable属性を加える
		function mvmv() """),format.raw/*55.19*/("""{"""),format.raw/*55.20*/("""
			$('.mv_chan').draggable();
			$('.mv_chan').resizable();
		"""),format.raw/*58.3*/("""}"""),format.raw/*58.4*/("""
		
		//要素の横幅に併せて文字サイズを変更する
		function fix() """),format.raw/*61.18*/("""{"""),format.raw/*61.19*/("""
			$('#txt_chan').fitText();
		"""),format.raw/*63.3*/("""}"""),format.raw/*63.4*/("""

	
		$(function()"""),format.raw/*66.15*/("""{"""),format.raw/*66.16*/("""
    		$('.context').contextMenu('myMenu',
        		"""),format.raw/*68.11*/("""{"""),format.raw/*68.12*/("""
            		bindings: """),format.raw/*69.25*/("""{"""),format.raw/*69.26*/("""
            		'delete': function(t) """),format.raw/*70.37*/("""{"""),format.raw/*70.38*/("""
                		var body = parent.main.document.getElementById('body_main');
                		console.log(body.childNodes[t.id]);
                		body.removeChild(body.childNodes[t.id]);
            		"""),format.raw/*74.15*/("""}"""),format.raw/*74.16*/("""
        		"""),format.raw/*75.11*/("""}"""),format.raw/*75.12*/("""
    		"""),format.raw/*76.7*/("""}"""),format.raw/*76.8*/(""");
		"""),format.raw/*77.3*/("""}"""),format.raw/*77.4*/(""");
		
		</script>
			<span id='head_main'>"""),_display_(Seq[Any](/*80.26*/for(line <- headLine) yield /*80.47*/{_display_(Seq[Any](_display_(Seq[Any](/*80.49*/Html(line)))))})),format.raw/*80.60*/("""</span>
    </head>
    <body style="width:100%;height:100%;">
        <div id='body_main' style="width:100%;height:100%;">
        	"""),_display_(Seq[Any](/*84.11*/for(line <- httpLine) yield /*84.32*/{_display_(Seq[Any](_display_(Seq[Any](/*84.34*/Html(line)))))})),format.raw/*84.45*/("""
        	"""),_display_(Seq[Any](/*85.11*/if(httpLine==null)/*85.29*/ {_display_(Seq[Any](format.raw/*85.31*/("""
        		<p>右上の「新規作成」「ページの変更」ボタンを押して、編集するページを選択してください。</p>
        	""")))})),format.raw/*87.11*/("""
        </div>

		</script>
		<div id='head_main'>"""),_display_(Seq[Any](/*91.24*/for(line <- headLine) yield /*91.45*/{_display_(Seq[Any](_display_(Seq[Any](/*91.47*/Html(line)))))})),format.raw/*91.58*/("""</div>
    </head>
    <body>
        <div id='body_main'>"""),_display_(Seq[Any](/*94.30*/for(line <- httpLine) yield /*94.51*/{_display_(Seq[Any](_display_(Seq[Any](/*94.53*/Html(line)))))})),format.raw/*94.64*/("""</div>
        <form id="t_edit" method="post">
        	"""),_display_(Seq[Any](/*96.11*/CSRF/*96.15*/.formField)),format.raw/*96.25*/("""
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
                    DATE: Thu Dec 17 14:23:32 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: b6876bf952231594799992eb206ad1c04f2d35f9
                    MATRIX: 813->1|1007->85|1034->103|1151->185|1177->190|1274->252|1288->258|1359->307|1450->363|1464->369|1530->413|1626->474|1640->480|1704->522|1960->742|1975->748|2049->800|2142->857|2157->863|2228->912|2321->969|2336->975|2411->1028|2513->1094|2528->1100|2598->1148|2691->1205|2706->1211|2788->1271|2906->1361|2935->1362|3029->1420|3060->1429|3132->1474|3160->1475|3254->1541|3283->1542|3365->1596|3394->1597|3449->1624|3478->1625|3536->1655|3565->1656|3620->1683|3649->1684|3715->1723|3743->1724|3791->1744|3820->1745|3875->1773|3903->1774|4001->1844|4030->1845|4164->1951|4193->1952|4248->1979|4277->1980|4343->2019|4371->2020|4419->2040|4448->2041|4506->2072|4534->2073|4582->2093|4611->2094|4668->2123|4697->2124|4752->2151|4781->2152|4847->2191|4875->2192|4963->2252|4992->2253|5082->2316|5110->2317|5183->2362|5212->2363|5271->2395|5299->2396|5345->2414|5374->2415|5455->2468|5484->2469|5537->2494|5566->2495|5631->2532|5660->2533|5895->2740|5924->2741|5963->2752|5992->2753|6026->2760|6054->2761|6086->2766|6114->2767|6193->2810|6230->2831|6278->2833|6315->2844|6485->2978|6522->2999|6570->3001|6607->3012|6654->3023|6681->3041|6721->3043|6824->3114|6912->3166|6949->3187|6997->3189|7034->3200|7129->3259|7166->3280|7214->3282|7251->3293|7345->3351|7358->3355|7390->3365
                    LINES: 26->1|30->1|31->3|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|46->18|46->18|46->18|47->19|47->19|47->19|49->21|49->21|50->22|50->22|54->26|54->26|57->29|57->29|59->31|59->31|59->31|59->31|60->32|60->32|60->32|60->32|61->33|61->33|65->37|65->37|67->39|67->39|70->42|70->42|73->45|73->45|73->45|73->45|74->46|74->46|75->47|75->47|77->49|77->49|78->50|78->50|79->51|79->51|79->51|79->51|80->52|80->52|83->55|83->55|86->58|86->58|89->61|89->61|91->63|91->63|94->66|94->66|96->68|96->68|97->69|97->69|98->70|98->70|102->74|102->74|103->75|103->75|104->76|104->76|105->77|105->77|108->80|108->80|108->80|108->80|112->84|112->84|112->84|112->84|113->85|113->85|113->85|115->87|119->91|119->91|119->91|119->91|122->94|122->94|122->94|122->94|124->96|124->96|124->96
                    -- GENERATED --
                */
            