
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
object edit_text extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(id: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.14*/("""
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
			"""),format.raw/*22.4*/("""}"""),format.raw/*22.5*/("""
			
			function save()"""),format.raw/*24.19*/("""{"""),format.raw/*24.20*/("""
				window.opener.parent.main.txtmvdestroy();
				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
				var obj = window.opener.parent.main.document.getElementById(object_id);
				obj.innerHTML = doc.body.innerHTML;
				window.opener.parent.main.txtmv();
				window.close();
			"""),format.raw/*31.4*/("""}"""),format.raw/*31.5*/("""
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
			"""),_display_(Seq[Any](/*42.5*/CSRF/*42.9*/.formField)),format.raw/*42.19*/("""
			<iframe id="edit" width="100px" height="100px" scrolling="on"></iframe>
			<input type="button" onclick="save()" value="送信">
		</form>
    </body>
</html>"""))}
    }
    
    def render(id:String): play.api.templates.HtmlFormat.Appendable = apply(id)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (id) => apply(id)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_text.scala.html
                    HASH: 10614bd6acc6764b0d06b4b61d4bc3e3e51c26c5
                    MATRIX: 778->1|900->13|927->31|1080->149|1094->155|1165->204|1261->265|1275->271|1339->313|1399->338|1413->344|1489->399|1582->456|1597->462|1679->522|1772->579|1787->585|1854->630|2016->764|2045->765|2158->842|2182->844|2514->1149|2542->1150|2593->1173|2622->1174|2955->1480|2983->1481|3235->1698|3247->1702|3279->1712
                    LINES: 26->1|30->1|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|42->14|42->14|44->16|44->16|50->22|50->22|52->24|52->24|59->31|59->31|70->42|70->42|70->42
                    -- GENERATED --
                */
            