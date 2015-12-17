
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
					
					//parent.menu.document.getElementById('title01').innerHTML = "";
        		"""),format.raw/*47.11*/("""}"""),format.raw/*47.12*/("""
        	"""),format.raw/*48.10*/("""}"""),format.raw/*48.11*/("""
        
        	function append_text_link(name,value)"""),format.raw/*50.47*/("""{"""),format.raw/*50.48*/("""
        		var link = name;
        		var dir = value;
        		if(link != "")"""),format.raw/*53.25*/("""{"""),format.raw/*53.26*/("""
        			var body = parent.main.document.getElementById('body_main');
        			var tag = document.createElement('div');
					tag.id = ElementID;
					tag.className = "context";
					tag.style.width =  "60px";
					tag.style.height = "30px";
        			
        			var txt_tag = document.createElement('a');
					txt_tag.id = "txt_id";
					txt_tag.href = dir;
					txt_tag.innerHTML = link;
					
					body.appendChild(tag);
					tag.appendChild(txt_tag);
					
					ElementID++;
					parent.main.context();
					
					parent.menu.document.getElementById('title01').innerHTML = "";
        		"""),format.raw/*73.11*/("""}"""),format.raw/*73.12*/("""
        		
        	"""),format.raw/*75.10*/("""}"""),format.raw/*75.11*/("""
        	
        	$(function()"""),format.raw/*77.22*/("""{"""),format.raw/*77.23*/("""
        		var name = """"),_display_(Seq[Any](/*78.24*/name)),format.raw/*78.28*/("""";
        		var value = """"),_display_(Seq[Any](/*79.25*/value)),format.raw/*79.30*/("""";
        		var type = """"),_display_(Seq[Any](/*80.24*/ele_type)),format.raw/*80.32*/("""";
        		if(name!="" && value!="")"""),format.raw/*81.36*/("""{"""),format.raw/*81.37*/("""
        			if(type == "button")"""),format.raw/*82.32*/("""{"""),format.raw/*82.33*/("""
      					append_button_link(name,value);
      				"""),format.raw/*84.11*/("""}"""),format.raw/*84.12*/("""else if(type == "text")"""),format.raw/*84.35*/("""{"""),format.raw/*84.36*/("""
      					append_text_link(name,value);
      				"""),format.raw/*86.11*/("""}"""),format.raw/*86.12*/("""
        		"""),format.raw/*87.11*/("""}"""),format.raw/*87.12*/("""
 			"""),format.raw/*88.5*/("""}"""),format.raw/*88.6*/(""")
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
    				"""),_display_(Seq[Any](/*106.10*/CSRF/*106.14*/.formField)),format.raw/*106.24*/("""
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
			
			<br>
			<input type="button" value="外部リンク" onclick="window.open('/edit_call/addlink','ucreatepage_addlink','width=640,height=480,location=0');return false;">
			<!--画像送信スクリプト-->
			<script>
				function sendImage() """),format.raw/*125.26*/("""{"""),format.raw/*125.27*/("""
					$("#submit").trigger('click');
					$("#reset").trigger('click');
				"""),format.raw/*128.5*/("""}"""),format.raw/*128.6*/("""
				<!--背景画像選択ウィンドウの表示-->
				function toSelectBg() """),format.raw/*130.27*/("""{"""),format.raw/*130.28*/("""
					window.open("/edit_call/selectbg","selectbg","width=600,height=450,menubar=no,toolbar=no,location=no,status=no");return false;
				"""),format.raw/*132.5*/("""}"""),format.raw/*132.6*/("""
				
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
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_menu.scala.html
                    HASH: 08f12ba99028bc5cfd3a103d67dbc3c182235f79
                    MATRIX: 792->1|949->48|977->67|1128->183|1142->189|1208->233|1300->289|1315->295|1382->339|1479->400|1494->406|1559->448|1837->690|1852->696|1929->751|2022->808|2037->814|2111->866|2204->923|2219->929|2289->977|2391->1043|2406->1049|2488->1109|2648->1241|2677->1242|2784->1321|2813->1322|3530->2011|3559->2012|3597->2022|3626->2023|3710->2079|3739->2080|3846->2159|3875->2160|4500->2757|4529->2758|4578->2779|4607->2780|4667->2812|4696->2813|4756->2837|4782->2841|4845->2868|4872->2873|4934->2899|4964->2907|5030->2945|5059->2946|5119->2978|5148->2979|5230->3033|5259->3034|5310->3057|5339->3058|5419->3110|5448->3111|5487->3122|5516->3123|5548->3128|5576->3129|6334->3850|6348->3854|6381->3864|7219->4673|7249->4674|7353->4750|7382->4751|7464->4804|7494->4805|7659->4942|7688->4943
                    LINES: 26->1|30->1|32->4|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|48->20|48->20|48->20|51->23|51->23|54->26|54->26|75->47|75->47|76->48|76->48|78->50|78->50|81->53|81->53|101->73|101->73|103->75|103->75|105->77|105->77|106->78|106->78|107->79|107->79|108->80|108->80|109->81|109->81|110->82|110->82|112->84|112->84|112->84|112->84|114->86|114->86|115->87|115->87|116->88|116->88|134->106|134->106|134->106|153->125|153->125|156->128|156->128|158->130|158->130|160->132|160->132
                    -- GENERATED --
                */
            