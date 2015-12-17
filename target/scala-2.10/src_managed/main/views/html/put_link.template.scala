
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
object put_link extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.1*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>任意のリンクを指定</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*7.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*8.107*/("""">
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*9.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*10.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*11.89*/("""" type="text/javascript"></script>
    </head>
    <body>
    	<form id="link_form" action="/edit_call/put_link" method="POST" target="menu">
			"""),_display_(Seq[Any](/*15.5*/CSRF/*15.9*/.formField)),format.raw/*15.19*/("""
			<p>テキスト：<input type="text" name="TEXT"></p>
        	<p>リンク先：<input type="text" name="URL"></p>
        	<input type="submit" value="送信">
		</form>
        <input type="button" value="閉じる" onclick="window.open('about:blank','_self').close();">
    
    <!-- 2015/10/16
		<form id="link_form" action="/edit_call/choose_link" method="POST" target="menu" style="display:none">
			"""),_display_(Seq[Any](/*24.5*/CSRF/*24.9*/.formField)),format.raw/*24.19*/("""
			<input type="text" id="link_name" name="name" value="">
		</form>
        <p>テキスト：<input type="text" name="TEXT"></p>
        <p>リンク先：<input type="text" name="URL"></p>
        <input type="button" value="送信" onclick="window.open('about:blank','_self').close();">
        
        <form id="link_form" action="/edit_call/choose_addlink" method="POST" target="menu" style="display:none">
		    """),_display_(Seq[Any](/*32.8*/CSRF/*32.12*/.formField)),format.raw/*32.22*/("""
		    <input type="text" id="link_name" name="name" value="">
		</form>
        
        -->
        
    </body>
</html>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/put_link.scala.html
                    HASH: 827fbc94357fe147a6e5391fd5e9b48dd90ffce4
                    MATRIX: 874->17|1030->138|1044->144|1110->188|1206->249|1220->255|1284->297|1344->322|1358->328|1427->376|1520->433|1535->439|1612->494|1705->551|1720->557|1802->617|1983->763|1995->767|2027->777|2444->1159|2456->1163|2488->1173|2921->1571|2934->1575|2966->1585
                    LINES: 30->2|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15|43->15|52->24|52->24|52->24|60->32|60->32|60->32
                    -- GENERATED --
                */
            