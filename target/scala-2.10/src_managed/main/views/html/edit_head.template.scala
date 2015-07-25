
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
object edit_head extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>ヘッダ</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*5.54*/routes/*5.60*/.Assets.at("stylesheets/main.css"))),format.raw/*5.94*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*6.54*/routes/*6.60*/.Assets.at("stylesheets/menu.css"))),format.raw/*6.94*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*7.59*/routes/*7.65*/.Assets.at("images/favicon.png"))),format.raw/*7.97*/("""">
        <script src=""""),_display_(Seq[Any](/*8.23*/routes/*8.29*/.Assets.at("javascripts/Object_in.js"))),format.raw/*8.67*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/jquery.contextmenu.r2.js"))),format.raw/*10.79*/("""" type="text/javascript"></script>
        <script type='text/javascript'>
		$(function() """),format.raw/*12.16*/("""{"""),format.raw/*12.17*/("""
    		$('.demo1').contextMenu('myMenu',
        		"""),format.raw/*14.11*/("""{"""),format.raw/*14.12*/("""
            		bindings: """),format.raw/*15.25*/("""{"""),format.raw/*15.26*/("""
                	'open': function(t) """),format.raw/*16.38*/("""{"""),format.raw/*16.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*18.15*/("""}"""),format.raw/*18.16*/(""",
            		'email': function(t) """),format.raw/*19.36*/("""{"""),format.raw/*19.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*21.15*/("""}"""),format.raw/*21.16*/(""",
            		'save': function(t) """),format.raw/*22.35*/("""{"""),format.raw/*22.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*24.15*/("""}"""),format.raw/*24.16*/(""",
            		'delete': function(t) """),format.raw/*25.37*/("""{"""),format.raw/*25.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*27.15*/("""}"""),format.raw/*27.16*/("""
        		"""),format.raw/*28.11*/("""}"""),format.raw/*28.12*/("""
    		"""),format.raw/*29.7*/("""}"""),format.raw/*29.8*/(""");
		"""),format.raw/*30.3*/("""}"""),format.raw/*30.4*/(""");
		</script>
    </head>
    <body>
        <div class="head_menu">
			<div class="head"><button onclick="call_dicition_name()">新規作成</button></div>
			<div class="head">
				<input type="file" >
					<button onclick="change_page()">ページの変更</button>
			</div>
			<div class="head">
				<form action="/edit_call/save">
					<p><button type="submit">保存</button></p>
				</form>
			</div>
		</div>
		<div class='contextMenu' id='myMenu'>
    		<ul>
        		<li id='open'>Open</li>
        		<li id='email'>Email</li>
        		<li id='save'>Save</li>
        		<li id='close'>Close</li>
    		</ul>
		</div>
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
                    DATE: Fri Jul 10 11:23:42 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_head.scala.html
                    HASH: 79b56ac745770b607caa9134e65becb39d08619f
                    MATRIX: 859->0|1008->114|1022->120|1077->154|1168->210|1182->216|1237->250|1333->311|1347->317|1400->349|1460->374|1474->380|1533->418|1625->475|1639->481|1705->526|1798->583|1813->589|1885->639|2003->729|2032->730|2111->781|2140->782|2193->807|2222->808|2288->846|2317->847|2426->928|2455->929|2520->966|2549->967|2659->1049|2688->1050|2752->1086|2781->1087|2890->1168|2919->1169|2985->1207|3014->1208|3125->1291|3154->1292|3193->1303|3222->1304|3256->1311|3284->1312|3316->1317|3344->1318
                    LINES: 29->1|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|40->12|40->12|42->14|42->14|43->15|43->15|44->16|44->16|46->18|46->18|47->19|47->19|49->21|49->21|50->22|50->22|52->24|52->24|53->25|53->25|55->27|55->27|56->28|56->28|57->29|57->29|58->30|58->30
                    -- GENERATED --
                */
            