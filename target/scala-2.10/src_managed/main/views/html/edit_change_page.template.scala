
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
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("stylesheets/main.css"))),format.raw/*8.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*12.79*/("""" type="text/javascript"></script>
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
                    DATE: Mon Sep 07 09:07:19 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_change_page.scala.html
                    HASH: edf55993e26456974c0be303f9ed0150e8610b28
                    MATRIX: 792->1|915->30|1071->151|1085->157|1140->191|1236->252|1250->258|1303->290|1364->315|1379->321|1439->359|1532->416|1547->422|1614->467|1707->524|1722->530|1794->580|1922->673|1967->702|2007->704|2116->777|2146->785|2193->796|2224->804|2263->812
                    LINES: 26->1|29->1|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|45->17|45->17|45->17|46->18|46->18|46->18|46->18|47->19
                    -- GENERATED --
                */
            