
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
object edit_text extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: String, pages: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.36*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>テキストの編集</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("/public","stylesheets/jquery-ui.css"))),format.raw/*7.109*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*8.107*/("""">
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*9.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*10.89*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/editor.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script type="text/javascript">
        	var object_id;
        	window.onload = function()"""),format.raw/*14.36*/("""{"""),format.raw/*14.37*/("""
        		window.opener.parent.main.txtmvdestroy();
        		object_id = """"),_display_(Seq[Any](/*16.25*/id)),format.raw/*16.27*/("""";
        		var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
        		var obj = window.opener.parent.main.document.getElementById(object_id);
        		doc.body.innerHTML = obj.innerHTML;
        		window.opener.parent.main.txtmv();
        		var ED = new Editor('edit');
        		
			"""),format.raw/*23.4*/("""}"""),format.raw/*23.5*/("""
			
			function save()"""),format.raw/*25.19*/("""{"""),format.raw/*25.20*/("""
				window.opener.parent.main.txtmvdestroy();
				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
				var obj = window.opener.parent.main.document.getElementById(object_id);
				obj.innerHTML = doc.body.innerHTML;
				window.opener.parent.main.txtmv();
				window.close();
			"""),format.raw/*32.4*/("""}"""),format.raw/*32.5*/("""
        </script>
    </head>
    <body>
    	<div id="menuroot"></div>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
		<form id="link_form" name="link_form" action="/edit_call/edit_text_save" method="POST">
			"""),_display_(Seq[Any](/*43.5*/CSRF/*43.9*/.formField)),format.raw/*43.19*/("""
			<iframe id="edit" width="100px" height="100px" scrolling="on"></iframe>
			<input type="button" onclick="save()" value="送信">
		</form>
    </body>
</html>"""))}
    }
    
    def render(id:String,pages:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(id,pages)
    
    def f:((String,Array[String]) => play.api.templates.HtmlFormat.Appendable) = (id,pages) => apply(id,pages)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sun Dec 20 05:58:40 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_text.scala.html
                    HASH: 8aa601f634cffeebf59bd2ab3e2dd306c2a3a0bc
                    MATRIX: 792->1|936->35|963->53|1116->171|1130->177|1201->226|1297->287|1311->293|1375->335|1435->360|1449->366|1525->421|1618->478|1633->484|1715->544|1808->601|1823->607|1890->652|2052->786|2081->787|2194->864|2218->866|2561->1182|2589->1183|2640->1206|2669->1207|3002->1513|3030->1514|3282->1731|3294->1735|3326->1745
                    LINES: 26->1|30->1|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|42->14|42->14|44->16|44->16|51->23|51->23|53->25|53->25|60->32|60->32|71->43|71->43|71->43
                    -- GENERATED --
                */
            