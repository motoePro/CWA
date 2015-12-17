
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
object edit_blog_home extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(user: String, blog_title: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.43*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>編集するブログの選択ポージ</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*8.54*/routes/*8.60*/.Assets.at("/public","stylesheets/main.css"))),format.raw/*8.104*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*9.107*/("""">
        <script>
        	function go_to_edit(page_name)"""),format.raw/*11.40*/("""{"""),format.raw/*11.41*/("""
        		//window.open('/','text_edit','width=720,height=480,location=0');
				var form = document.getElementById('t_edit');
           		form.setAttribute("action", "/edit_call/blog_data_read");
				//form.setAttribute("target", "text_edit");
				var page = document.createElement("input");
				page.setAttribute("name", "page_name");
				page.setAttribute("type", "hidden");
				page.setAttribute("value", page_name);
				form.appendChild(page);
				form.submit();
				form.removeChild(page);
				form.setAttribute("action", "");
				form.setAttribute("target", "");
        	"""),format.raw/*25.10*/("""}"""),format.raw/*25.11*/("""
        </script>
    </head>
    <body>
        <h1>編集するブログを選択してください</h1>
		"""),_display_(Seq[Any](/*30.4*/for(title <- blog_title) yield /*30.28*/{_display_(Seq[Any](format.raw/*30.29*/("""
			<a href="javascript:void(0)" onclick="go_to_edit('"""),_display_(Seq[Any](/*31.55*/title)),format.raw/*31.60*/("""')">"""),_display_(Seq[Any](/*31.65*/title)),format.raw/*31.70*/("""</a>
		""")))})),format.raw/*32.4*/("""
		<form id="t_edit" method="post">
        	"""),_display_(Seq[Any](/*34.11*/CSRF/*34.15*/.formField)),format.raw/*34.25*/("""
        </form>
        <a href="/"""),_display_(Seq[Any](/*36.20*/user)),format.raw/*36.24*/("""">ユーザページに戻る</a>
    </body>
</html>"""))}
    }
    
    def render(user:String,blog_title:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(user,blog_title)
    
    def f:((String,Array[String]) => play.api.templates.HtmlFormat.Appendable) = (user,blog_title) => apply(user,blog_title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_blog_home.scala.html
                    HASH: b0b997d7e3bc1ebf99d9c6096e359fc378073287
                    MATRIX: 797->1|948->42|975->60|1135->185|1149->191|1215->235|1311->296|1325->302|1389->344|1476->403|1505->404|2113->984|2142->985|2256->1064|2296->1088|2335->1089|2426->1144|2453->1149|2494->1154|2521->1159|2560->1167|2642->1213|2655->1217|2687->1227|2759->1263|2785->1267
                    LINES: 26->1|30->1|31->3|36->8|36->8|36->8|37->9|37->9|37->9|39->11|39->11|53->25|53->25|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|62->34|62->34|62->34|64->36|64->36
                    -- GENERATED --
                */
            