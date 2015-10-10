
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
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*10.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*11.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.89*/("""" type="text/javascript"></script>
    </head>
    <body>
		<h2>新たに作成するページの名前を指定してください。</h2>
		
        """),_display_(Seq[Any](/*17.10*/helper/*17.16*/.form(action = routes.Application.new_page())/*17.61*/{_display_(Seq[Any](format.raw/*17.62*/("""
        """),_display_(Seq[Any](/*18.10*/helper/*18.16*/.CSRF.formField)),format.raw/*18.31*/("""
        <input name="name" type="text"></input>.html</br>
        </br>
        <input type="radio" name="type" value="standard" checked="checked">スタンダード
        <input type="radio" name="type" value="blog">ブログ
        </br>
        </br>
        <input type="submit" value="決定"/>
        """)))})),format.raw/*26.10*/("""
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
                    DATE: Fri Oct 09 19:32:27 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_new_page.scala.html
                    HASH: c1e1717d276d4284f17c39dd617f22a106027831
                    MATRIX: 782->1|891->16|979->69|1005->74|1102->136|1116->142|1182->186|1278->247|1292->253|1356->295|1417->320|1432->326|1502->374|1595->431|1610->437|1687->492|1780->549|1795->555|1877->615|2018->720|2033->726|2087->771|2126->772|2172->782|2187->788|2224->803|2547->1094
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|45->17|45->17|45->17|45->17|46->18|46->18|46->18|54->26
                    -- GENERATED --
                */
            