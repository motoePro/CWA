
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
object edit_menu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(name: String, value: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""
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
        		if(name!="" && value!="")"""),format.raw/*51.36*/("""{"""),format.raw/*51.37*/("""
      				append_button_link(name,value);
        		"""),format.raw/*53.11*/("""}"""),format.raw/*53.12*/("""
 			"""),format.raw/*54.5*/("""}"""),format.raw/*54.6*/(""")
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
    
    def render(name:String,value:String): play.api.templates.HtmlFormat.Appendable = apply(name,value)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (name,value) => apply(name,value)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 02 12:20:59 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_menu.scala.html
                    HASH: f75d433e4cff910a2e77e9d415586d7301a2b3ae
                    MATRIX: 785->1|908->30|1059->146|1073->152|1128->186|1219->242|1233->248|1288->282|1384->343|1398->349|1451->381|1729->623|1744->629|1811->674|1904->731|1919->737|1983->779|2076->836|2091->842|2151->880|2253->946|2268->952|2340->1002|2500->1134|2529->1135|2636->1214|2665->1215|3386->1908|3415->1909|3453->1919|3482->1920|3541->1951|3570->1952|3630->1976|3656->1980|3719->2007|3746->2012|3812->2050|3841->2051|3922->2104|3951->2105|3983->2110|4011->2111
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|48->20|48->20|51->23|51->23|73->45|73->45|74->46|74->46|76->48|76->48|77->49|77->49|78->50|78->50|79->51|79->51|81->53|81->53|82->54|82->54
                    -- GENERATED --
                */
            