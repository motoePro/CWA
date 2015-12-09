
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
object edit_menu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(name: String, value: String, ele_type: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.49*/("""

"""),format.raw/*4.1*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>メニュー</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*9.54*/routes/*9.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*9.104*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*10.54*/routes/*10.60*/.Assets.at("/public","stylesheets/menu.css"))),format.raw/*10.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*11.59*/routes/*11.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*11.107*/("""">
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        <script src=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*16.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("/public","javascripts/jquery-ui.min.js"))),format.raw/*17.81*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*18.23*/routes/*18.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*18.77*/("""" type="text/javascript"></script>
        
        <script src=""""),_display_(Seq[Any](/*20.23*/routes/*20.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*20.89*/("""" type="text/javascript"></script>
        
        <script type="text/javascript">
        	function append_button_link(name,value)"""),format.raw/*23.49*/("""{"""),format.raw/*23.50*/("""
        		var link = name;
        		var dir = value;
        		if(link != "")"""),format.raw/*26.25*/("""{"""),format.raw/*26.26*/("""
        			var body = parent.main.document.getElementById('body_main');
        			var tag = document.createElement('div');
					tag.id = ElementID;
					tag.className = "context";
					tag.style.width =  "60px";
					tag.style.height = "30px";
        			
        			var btn_tag = document.createElement('input');
					btn_tag.type = "button";
					btn_tag.id = "btn_id";
					btn_tag.value = link+"へ移動";
					var f = "location.href='" + dir + "'";
					btn_tag.setAttribute('onclick', f);
					
					body.appendChild(tag);
					tag.appendChild(btn_tag);
					
					ElementID++;
					parent.main.context();
					
					parent.menu.document.getElementById('title01').innerHTML = "";
        		"""),format.raw/*48.11*/("""}"""),format.raw/*48.12*/("""
        	"""),format.raw/*49.10*/("""}"""),format.raw/*49.11*/("""
        
        	$(function()"""),format.raw/*51.22*/("""{"""),format.raw/*51.23*/("""
        		var name = """"),_display_(Seq[Any](/*52.24*/name)),format.raw/*52.28*/("""";
        		var value = """"),_display_(Seq[Any](/*53.25*/value)),format.raw/*53.30*/("""";
        		var type = """"),_display_(Seq[Any](/*54.24*/ele_type)),format.raw/*54.32*/("""";
        		if(name!="" && value!="")"""),format.raw/*55.36*/("""{"""),format.raw/*55.37*/("""
        			if(type == "button")"""),format.raw/*56.32*/("""{"""),format.raw/*56.33*/("""
      					append_button_link(name,value);
      				"""),format.raw/*58.11*/("""}"""),format.raw/*58.12*/("""
        		"""),format.raw/*59.11*/("""}"""),format.raw/*59.12*/("""
 			"""),format.raw/*60.5*/("""}"""),format.raw/*60.6*/(""")
        </script>
    </head>
    <body>
        <div id="menu" class="demo1">
			<div><button onclick="addBtn()">ボタン</button></div>
			<div><button onclick="addTxt()">テキスト</button></div>
			<div><button onclick="addTxb()">テキストボックス</button></div>
			
			<div><button onclick="addPct()">画像</button></div>
	
			<div><button onclick="addTwt()">Twitter</button></div>
			<div><button onclick="addLine()">Line</button></div>
			<div><button onclick="addFace()">Facebook</button></div>
			<div><button onclick="Window_YouTube()">YouTube</button></div>
			<br>
			<div>
				<form id="FileUpload" name="upload" method="post" action="/upload" target="upload-image" onChange="sendImage()" enctype="multipart/form-data">
    				"""),_display_(Seq[Any](/*78.10*/CSRF/*78.14*/.formField)),format.raw/*78.24*/("""
    				<input type="file" name="image"/>
    				<input type="submit" id="submit" name="submit" style="display:none;" value="送信"/>
    				<input type="reset" id="reset" name="reset" style="display:none;"/>
				</form>
				<iframe id="FileUploadIframe" name="upload-image" ></iframe>
			</div>
			
			<input type="button" value="背景画像設定" onClick="toSelectBg()" />
			
			<input type="button" value="背景リセット" onClick="resetBg()"/>
			
			<br>
			<input type="button" value="リンク" onclick="window.open('/edit_call/link','ucreatepage_link','width=640,height=480,location=0');return false;">
			
			
			<!--画像送信スクリプト-->
			<script>
				function sendImage() """),format.raw/*96.26*/("""{"""),format.raw/*96.27*/("""
					$("#submit").trigger('click');
					$("#reset").trigger('click');
				"""),format.raw/*99.5*/("""}"""),format.raw/*99.6*/("""
				<!--背景画像選択ウィンドウの表示-->
				function toSelectBg() """),format.raw/*101.27*/("""{"""),format.raw/*101.28*/("""
					window.open("/edit_call/selectbg","selectbg","width=600,height=450,menubar=no,toolbar=no,location=no,status=no");return false;
				"""),format.raw/*103.5*/("""}"""),format.raw/*103.6*/("""
				
			</script>
    </body>
</html>
"""))}
    }
    
    def render(name:String,value:String,ele_type:String): play.api.templates.HtmlFormat.Appendable = apply(name,value,ele_type)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (name,value,ele_type) => apply(name,value,ele_type)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 04 11:41:25 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_menu.scala.html
                    HASH: 1160c276c52f48ac30e92fae775653e73a0898fc
                    MATRIX: 792->1|949->48|977->67|1128->183|1142->189|1208->233|1300->289|1315->295|1382->339|1479->400|1494->406|1559->448|1837->690|1852->696|1929->751|2022->808|2037->814|2111->866|2204->923|2219->929|2289->977|2391->1043|2406->1049|2488->1109|2648->1241|2677->1242|2784->1321|2813->1322|3534->2015|3563->2016|3601->2026|3630->2027|3689->2058|3718->2059|3778->2083|3804->2087|3867->2114|3894->2119|3956->2145|3986->2153|4052->2191|4081->2192|4141->2224|4170->2225|4252->2279|4281->2280|4320->2291|4349->2292|4381->2297|4409->2298|5166->3019|5179->3023|5211->3033|5891->3685|5920->3686|6023->3762|6051->3763|6133->3816|6163->3817|6328->3954|6357->3955
                    LINES: 26->1|30->1|32->4|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|48->20|48->20|48->20|51->23|51->23|54->26|54->26|76->48|76->48|77->49|77->49|79->51|79->51|80->52|80->52|81->53|81->53|82->54|82->54|83->55|83->55|84->56|84->56|86->58|86->58|87->59|87->59|88->60|88->60|106->78|106->78|106->78|124->96|124->96|127->99|127->99|129->101|129->101|131->103|131->103
                    -- GENERATED --
                */
            