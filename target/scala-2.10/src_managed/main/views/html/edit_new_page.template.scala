
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
object edit_new_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(Seq[Any](/*7.17*/title)),format.raw/*7.22*/("""</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.79*/("""" type="text/javascript"></script>
    </head>
    <body>
		<h2>新たに作成するページの名前を指定してください。</h2>
		
        """),_display_(Seq[Any](/*17.10*/helper/*17.16*/.form(action = routes.Application.new_page())/*17.61*/{_display_(Seq[Any](format.raw/*17.62*/("""
        """),_display_(Seq[Any](/*18.10*/helper/*18.16*/.CSRF.formField)),format.raw/*18.31*/("""
        <input name="name" type="text"></input>.html</br>
        <input type="submit" value="決定"/>
        """)))})),format.raw/*21.10*/("""
		<input type="button" onclick="location.href='/edit_page'" value="編集画面に戻る" />
    </body>
</html>"""))}
    }
    
    def render(title:String): play.api.templates.HtmlFormat.Appendable = apply(title)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (title) => apply(title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Aug 07 04:53:25 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_new_page.scala.html
                    HASH: 4eaec635cf94f8b0395cef1ab474e04016b93a95
                    MATRIX: 782->1|891->16|979->69|1005->74|1102->136|1116->142|1171->176|1267->237|1281->243|1334->275|1395->300|1410->306|1470->344|1563->401|1578->407|1645->452|1738->509|1753->515|1825->565|1966->670|1981->676|2035->721|2074->722|2120->732|2135->738|2172->753|2314->863
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|45->17|45->17|45->17|45->17|46->18|46->18|46->18|49->21
                    -- GENERATED --
                */
            