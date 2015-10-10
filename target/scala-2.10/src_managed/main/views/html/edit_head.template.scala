
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
object edit_head extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(target_name: String)(user_name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""
<!DOCTYPE html>
<html>
    <head>
        <title>ヘッダ</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*6.104*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("/public","stylesheets/menu.css"))),format.raw/*7.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*8.107*/("""">
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*9.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/Object_in.js"))),format.raw/*10.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*11.89*/("""" type="text/javascript"></script>  
    </head>
    <body>
    	<form action="#" name="name" class="head_menu">
    		<input type="hidden" name="edit_page_name" value=""""),_display_(Seq[Any](/*15.58*/target_name)),format.raw/*15.69*/("""">
    	</form>
    	<div class="head_menu">
    		<p>現在、[ """),_display_(Seq[Any](/*18.16*/target_name)),format.raw/*18.27*/(""" ]を操作しています。<br>
    		<a href="/"""),_display_(Seq[Any](/*19.18*/user_name)),format.raw/*19.27*/("""" target="_top">ユーザページに戻る</a></p>
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
    
    def render(target_name:String,user_name:String): play.api.templates.HtmlFormat.Appendable = apply(target_name)(user_name)
    
    def f:((String) => (String) => play.api.templates.HtmlFormat.Appendable) = (target_name) => (user_name) => apply(target_name)(user_name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Oct 09 19:32:27 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_head.scala.html
                    HASH: b0b005a34ef8012c93d74ede17e454c68118211e
                    MATRIX: 785->1|919->41|1069->156|1083->162|1149->206|1240->262|1254->268|1320->312|1416->373|1430->379|1494->421|1554->446|1568->452|1644->507|1737->564|1752->570|1822->618|1915->675|1930->681|2012->741|2218->911|2251->922|2347->982|2380->993|2449->1026|2480->1035|2817->1337|2832->1343|2869->1358
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|43->15|43->15|46->18|46->18|47->19|47->19|57->29|57->29|57->29
                    -- GENERATED --
                */
            