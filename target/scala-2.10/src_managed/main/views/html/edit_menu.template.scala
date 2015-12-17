
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
		
        	function append_button_link(name,value)"""),format.raw/*24.49*/("""{"""),format.raw/*24.50*/("""
        		var link = name;
        		var dir = value;
        		if(link != "")"""),format.raw/*27.25*/("""{"""),format.raw/*27.26*/("""
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
        		"""),format.raw/*48.11*/("""}"""),format.raw/*48.12*/("""
        	"""),format.raw/*49.10*/("""}"""),format.raw/*49.11*/("""
        
        	function append_text_link(name,value)"""),format.raw/*51.47*/("""{"""),format.raw/*51.48*/("""
        		var link = name;
        		var dir = value;
        		if(link != "")"""),format.raw/*54.25*/("""{"""),format.raw/*54.26*/("""
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
        		"""),format.raw/*74.11*/("""}"""),format.raw/*74.12*/("""
        		
        	"""),format.raw/*76.10*/("""}"""),format.raw/*76.11*/("""
        	window.onload = function()"""),format.raw/*77.36*/("""{"""),format.raw/*77.37*/("""
			var user_name = parent.edit_head.document.getElementById('userName');
			var user_link = document.getElementById("user_link");
			user_link.value = "リンク("+user_name.innerHTML+"さんが作成したページ)";
		"""),format.raw/*81.3*/("""}"""),format.raw/*81.4*/("""
        	$(function()"""),format.raw/*82.22*/("""{"""),format.raw/*82.23*/("""
        		var name = """"),_display_(Seq[Any](/*83.24*/name)),format.raw/*83.28*/("""";
        		var value = """"),_display_(Seq[Any](/*84.25*/value)),format.raw/*84.30*/("""";
        		var type = """"),_display_(Seq[Any](/*85.24*/ele_type)),format.raw/*85.32*/("""";
        		if(name!="" && value!="")"""),format.raw/*86.36*/("""{"""),format.raw/*86.37*/("""
        			if(type == "button")"""),format.raw/*87.32*/("""{"""),format.raw/*87.33*/("""
      					append_button_link(name,value);
      				"""),format.raw/*89.11*/("""}"""),format.raw/*89.12*/("""else if(type == "text")"""),format.raw/*89.35*/("""{"""),format.raw/*89.36*/("""
      					append_text_link(name,value);
      				"""),format.raw/*91.11*/("""}"""),format.raw/*91.12*/("""
        		"""),format.raw/*92.11*/("""}"""),format.raw/*92.12*/("""
 			"""),format.raw/*93.5*/("""}"""),format.raw/*93.6*/(""")
        </script>
    </head>
    <body>
        <div id="menu" class="demo1">
			<div><button onclick="addTxt()">テキスト</button></div>
			<div><button onclick="Window_YouTube()">YouTube</button></div>
			<br>
			<div>
				<span>画像</span>
				<form id="FileUpload" name="upload" method="post" action="/upload" target="upload-image" onChange="sendImage()" enctype="multipart/form-data">
    				"""),_display_(Seq[Any](/*104.10*/CSRF/*104.14*/.formField)),format.raw/*104.24*/("""
    				<input type="file" name="image"/>
    				<input type="submit" id="submit" name="submit" style="display:none;" value="送信"/>
    				<input type="reset" id="reset" name="reset" style="display:none;"/>
				</form>
				<iframe id="FileUploadIframe" name="upload-image" style="display:none;"></iframe>


			</div>
			
			<input type="button" value="背景画像設定" onClick="toSelectBg()" />
			
			<input type="button" value="背景リセット" onClick="resetBg()"/>
			
			<br>
			<input type="button" id="user_link" value="リンク(あなたが作成したページ)" onclick="window.open('/edit_call/link','ucreatepage_link','width=640,height=480,location=0');return false;">
			
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
			<div><button onclick="comment()">コメント</button></div>
			<div><button onclick="blog()">ブログ</button></div>
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
                    DATE: Thu Dec 17 14:23:31 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_menu.scala.html
                    HASH: 6209e5d985c3db087a2ea8c357c0f0a23e38b27c
                    MATRIX: 792->1|949->48|977->67|1128->183|1142->189|1208->233|1300->289|1315->295|1382->339|1479->400|1494->406|1559->448|1837->690|1852->696|1929->751|2022->808|2037->814|2111->866|2204->923|2219->929|2289->977|2391->1043|2406->1049|2488->1109|2651->1244|2680->1245|2787->1324|2816->1325|3533->2014|3562->2015|3600->2025|3629->2026|3713->2082|3742->2083|3849->2162|3878->2163|4503->2760|4532->2761|4581->2782|4610->2783|4674->2819|4703->2820|4926->3016|4954->3017|5004->3039|5033->3040|5093->3064|5119->3068|5182->3095|5209->3100|5271->3126|5301->3134|5367->3172|5396->3173|5456->3205|5485->3206|5567->3260|5596->3261|5647->3284|5676->3285|5756->3337|5785->3338|5824->3349|5853->3350|5885->3355|5913->3356|6345->3751|6359->3755|6392->3765|7281->4625|7311->4626|7415->4702|7444->4703|7526->4756|7556->4757|7721->4894|7750->4895
                    LINES: 26->1|30->1|32->4|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|48->20|48->20|48->20|52->24|52->24|55->27|55->27|76->48|76->48|77->49|77->49|79->51|79->51|82->54|82->54|102->74|102->74|104->76|104->76|105->77|105->77|109->81|109->81|110->82|110->82|111->83|111->83|112->84|112->84|113->85|113->85|114->86|114->86|115->87|115->87|117->89|117->89|117->89|117->89|119->91|119->91|120->92|120->92|121->93|121->93|132->104|132->104|132->104|153->125|153->125|156->128|156->128|158->130|158->130|160->132|160->132
                    -- GENERATED --
                */
            