
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
    def apply/*1.2*/(target_name: String, user_name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""
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
    		<p>現在、[ """),_display_(Seq[Any](/*19.16*/target_name)),format.raw/*19.27*/(""" ]を操作しています。</br>
    		<a href="/"""),_display_(Seq[Any](/*20.18*/user_name)),format.raw/*20.27*/("""" target="_top">ユーザページに戻る</a></p>
    	</div>
        <div class="head_menu">
			<div class="head">
				<button onclick="call_dicition_name()">新規作成</button>
			</div>
			<div class="head">
				<button onclick="change_page()">ページの変更</button>
			</div>
			<form action="#" name="save" class="head">
				"""),_display_(Seq[Any](/*30.6*/helper/*30.12*/.CSRF.formField)),format.raw/*30.27*/("""
				<button  onclick="save_page()">保存</button>
			</form>
		</div>
    </body>
</html>
"""))}
    }
    
    def render(target_name:String,user_name:String): play.api.templates.HtmlFormat.Appendable = apply(target_name,user_name)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (target_name,user_name) => apply(target_name,user_name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Sep 03 05:20:28 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_head.scala.html
                    HASH: b137d03fe535e82a3bbce2a3e3ea86c85f7f8ab5
                    MATRIX: 785->1|919->41|1069->156|1083->162|1138->196|1229->252|1243->258|1298->292|1394->353|1408->359|1461->391|1521->416|1535->422|1601->467|1694->524|1709->530|1769->568|1862->625|1877->631|1949->681|2162->858|2195->869|2291->929|2324->940|2394->974|2425->983|2762->1285|2777->1291|2814->1306
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|44->16|44->16|47->19|47->19|48->20|48->20|58->30|58->30|58->30
                    -- GENERATED --
                */
            