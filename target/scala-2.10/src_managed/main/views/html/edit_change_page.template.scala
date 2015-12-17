
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
object edit_change_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(optFileNames: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""

<!DOCTYPE html>

<html>
    <head>
        <title>編集ページ選択</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*10.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*11.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.89*/("""" type="text/javascript"></script>
    </head>
    <body>
		<h2>変更先のページを指定してください。</h2>
		
		"""),_display_(Seq[Any](/*17.4*/for(fileName <- optFileNames) yield /*17.33*/ {_display_(Seq[Any](format.raw/*17.35*/("""
			<input type="button" onclick="location.href='/edit_call/render_file/"""),_display_(Seq[Any](/*18.73*/fileName)),format.raw/*18.81*/("""'" value=""""),_display_(Seq[Any](/*18.92*/fileName)),format.raw/*18.100*/("""" />
		""")))})),format.raw/*19.4*/("""
		
		<p>
			<input type="button" onclick="location.href='/edit_page'" value="編集画面に戻る" />
		</p>
    </body>
</html>"""))}
    }
    
    def render(optFileNames:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(optFileNames)
    
    def f:((Array[String]) => play.api.templates.HtmlFormat.Appendable) = (optFileNames) => apply(optFileNames)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_change_page.scala.html
                    HASH: d670806fa37778123049cc55273cb36d9fb1aa29
                    MATRIX: 792->1|915->30|1071->151|1085->157|1151->201|1247->262|1261->268|1325->310|1386->335|1401->341|1471->389|1564->446|1579->452|1656->507|1749->564|1764->570|1846->630|1974->723|2019->752|2059->754|2168->827|2198->835|2245->846|2276->854|2315->862
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|45->17|45->17|45->17|46->18|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            