
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
    def apply/*1.2*/(name: String, value: String, e_type: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>メニュー</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("stylesheets/main.css"))),format.raw/*6.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("stylesheets/menu.css"))),format.raw/*7.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("images/favicon.png"))),format.raw/*8.97*/("""">
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.0/jquery-ui.min.js"></script>
        
        <script src=""""),_display_(Seq[Any](/*13.23*/routes/*13.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*13.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*14.23*/routes/*14.29*/.Assets.at("javascripts/jquery-ui.min.js"))),format.raw/*14.71*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*15.23*/routes/*15.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*15.67*/("""" type="text/javascript"></script>
        
        <script src=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*17.79*/("""" type="text/javascript"></script>
        
        <script type="text/javascript">
        	function append_button_link(name,value)"""),format.raw/*20.49*/("""{"""),format.raw/*20.50*/("""
        		var link = name;
        		var dir = value;
        		if(link != "")"""),format.raw/*23.25*/("""{"""),format.raw/*23.26*/("""
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
        		"""),format.raw/*45.11*/("""}"""),format.raw/*45.12*/("""
        	"""),format.raw/*46.10*/("""}"""),format.raw/*46.11*/("""
        
        	$(function()"""),format.raw/*48.22*/("""{"""),format.raw/*48.23*/("""
        		var name = """"),_display_(Seq[Any](/*49.24*/name)),format.raw/*49.28*/("""";
        		var value = """"),_display_(Seq[Any](/*50.25*/value)),format.raw/*50.30*/("""";
        		var type = """"),_display_(Seq[Any](/*51.24*/e_type)),format.raw/*51.30*/("""";
        		if(name!="" && value!="")"""),format.raw/*52.36*/("""{"""),format.raw/*52.37*/("""
        			if(type == "button")"""),format.raw/*53.32*/("""{"""),format.raw/*53.33*/("""
      					append_button_link(name,value);
      				"""),format.raw/*55.11*/("""}"""),format.raw/*55.12*/("""
        		"""),format.raw/*56.11*/("""}"""),format.raw/*56.12*/("""
 			"""),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""")
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
				<form id="FileUpload" name="upload" method="post" action="/api/upload" target="upload-image" enctype="multipart/form-data">
    				<input type="file" name="image"/>
    				<input type="submit" name="submit" value="送信"/>
				</form>
				<iframe id="FileUploadIframe" name="upload-image" style="display: none;"></iframe>
			</div>
			<br>
			<input type="button" value="リンク" onclick="window.open('/edit_call/link','ucreatepage_link','width=640,height=480,location=0');return false;">
    </body>
</html>
"""))}
    }
    
    def render(name:String,value:String,e_type:String): play.api.templates.HtmlFormat.Appendable = apply(name,value,e_type)
    
    def f:((String,String,String) => play.api.templates.HtmlFormat.Appendable) = (name,value,e_type) => apply(name,value,e_type)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 02 12:26:02 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_menu.scala.html
                    HASH: 2effc3ff720e03c44d9edc5ba83db430dc3a82e0
                    MATRIX: 792->1|931->46|1082->162|1096->168|1151->202|1242->258|1256->264|1311->298|1407->359|1421->365|1474->397|1752->639|1767->645|1834->690|1927->747|1942->753|2006->795|2099->852|2114->858|2174->896|2276->962|2291->968|2363->1018|2523->1150|2552->1151|2659->1230|2688->1231|3409->1924|3438->1925|3476->1935|3505->1936|3564->1967|3593->1968|3653->1992|3679->1996|3742->2023|3769->2028|3831->2054|3859->2060|3925->2098|3954->2099|4014->2131|4043->2132|4125->2186|4154->2187|4193->2198|4222->2199|4254->2204|4282->2205
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|48->20|48->20|51->23|51->23|73->45|73->45|74->46|74->46|76->48|76->48|77->49|77->49|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|83->55|83->55|84->56|84->56|85->57|85->57
                    -- GENERATED --
                */
            