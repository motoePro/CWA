
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
object edit_menu extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,<error>,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(name: String, value: String, type: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""
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
        	function append_link(name,value)"""),format.raw/*20.42*/("""{"""),format.raw/*20.43*/("""
        		var link = name;
        		var dir = value;
        		console.log(link);
        		if(link != "")"""),format.raw/*24.25*/("""{"""),format.raw/*24.26*/("""
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
        		"""),format.raw/*46.11*/("""}"""),format.raw/*46.12*/("""
        	"""),format.raw/*47.10*/("""}"""),format.raw/*47.11*/("""
        
        	$(function()"""),format.raw/*49.22*/("""{"""),format.raw/*49.23*/("""
        		var name = """"),_display_(Seq[Any](/*50.24*/name)),format.raw/*50.28*/("""";
        		var value = """"),_display_(Seq[Any](/*51.25*/value)),format.raw/*51.30*/("""";
        		if(name!="" && value!="")"""),format.raw/*52.36*/("""{"""),format.raw/*52.37*/("""
        			if(type == "button")"""),format.raw/*53.32*/("""{"""),format.raw/*53.33*/("""
        				append_link(name,value);
        			"""),format.raw/*55.12*/("""}"""),format.raw/*55.13*/("""
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
    
    def render(name:String,value:String,<error>:<error>): play.api.templates.HtmlFormat.Appendable = apply(name,value,<error>)
    
    def f:((String,String,<error>) => play.api.templates.HtmlFormat.Appendable) = (name,value,<error>) => apply(name,value,<error>)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 02 12:15:24 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_menu.scala.html
                    HASH: 70c6d88038cb1963fcd4074540964fdb70bd62b5
                    MATRIX: 793->1|930->44|1081->160|1095->166|1150->200|1241->256|1255->262|1310->296|1406->357|1420->363|1473->395|1751->637|1766->643|1833->688|1926->745|1941->751|2005->793|2098->850|2113->856|2173->894|2275->960|2290->966|2362->1016|2515->1141|2544->1142|2680->1250|2709->1251|3430->1944|3459->1945|3497->1955|3526->1956|3585->1987|3614->1988|3674->2012|3700->2016|3763->2043|3790->2048|3856->2086|3885->2087|3945->2119|3974->2120|4051->2169|4080->2170|4119->2181|4148->2182|4180->2187|4208->2188
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|41->13|41->13|41->13|42->14|42->14|42->14|43->15|43->15|43->15|45->17|45->17|45->17|48->20|48->20|52->24|52->24|74->46|74->46|75->47|75->47|77->49|77->49|78->50|78->50|79->51|79->51|80->52|80->52|81->53|81->53|83->55|83->55|84->56|84->56|85->57|85->57
                    -- GENERATED --
                */
            