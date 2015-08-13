
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
object edit_head extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(target_name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.23*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>ヘッダ</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("stylesheets/main.css"))),format.raw/*6.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("stylesheets/menu.css"))),format.raw/*7.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("images/favicon.png"))),format.raw/*8.97*/("""">
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*10.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*11.79*/("""" type="text/javascript"></script>
        
    </head>
    <body>
    	<form action="#" name="name" class="head_menu">
    		<input type="hidden" name="edit_page_name" value=""""),_display_(Seq[Any](/*16.58*/target_name)),format.raw/*16.69*/("""">
    	</form>
    	<div class="head_menu">
    		<p>現在、[ """),_display_(Seq[Any](/*19.16*/target_name)),format.raw/*19.27*/(""" ]を操作しています。</p>
    	</div>
        <div class="head_menu">
			<div class="head">
				<button onclick="call_dicition_name()">新規作成</button>
			</div>
			<div class="head">
				<button onclick="change_page()">ページの変更</button>
			</div>
			<form action="#" name="save" class="head">
				"""),_display_(Seq[Any](/*29.6*/helper/*29.12*/.CSRF.formField)),format.raw/*29.27*/("""
				<button  onclick="save_page()">保存</button>
			</form>
		</div>
    </body>
</html>
"""))}
    }
    
    def render(target_name:String): play.api.templates.HtmlFormat.Appendable = apply(target_name)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (target_name) => apply(target_name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Aug 11 22:50:31 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_head.scala.html
                    HASH: 1b8627149eb36f9456b2f7e0124436a5901d68b9
                    MATRIX: 778->1|893->22|1043->137|1057->143|1112->177|1203->233|1217->239|1272->273|1368->334|1382->340|1435->372|1495->397|1509->403|1575->448|1668->505|1683->511|1743->549|1836->606|1851->612|1923->662|2136->839|2169->850|2265->910|2298->921|2617->1205|2632->1211|2669->1226
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|47->19|47->19|57->29|57->29|57->29
                    -- GENERATED --
                */
            