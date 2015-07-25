
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
        <script type='text/javascript'>
		$(function() """),format.raw/*14.16*/("""{"""),format.raw/*14.17*/("""
    		$('.hover').contextMenu('myMenu',
        		"""),format.raw/*16.11*/("""{"""),format.raw/*16.12*/("""
            		bindings: """),format.raw/*17.25*/("""{"""),format.raw/*17.26*/("""
                	'open': function(t) """),format.raw/*18.38*/("""{"""),format.raw/*18.39*/("""
                		alert('Trigger was '+t.id+'\nAction was Open');
            		"""),format.raw/*20.15*/("""}"""),format.raw/*20.16*/(""",
            		'email': function(t) """),format.raw/*21.36*/("""{"""),format.raw/*21.37*/("""
                		alert('Trigger was '+t.id+'\nAction was Email');
            		"""),format.raw/*23.15*/("""}"""),format.raw/*23.16*/(""",
            		'save': function(t) """),format.raw/*24.35*/("""{"""),format.raw/*24.36*/("""
                		alert('Trigger was '+t.id+'\nAction was Save');
            		"""),format.raw/*26.15*/("""}"""),format.raw/*26.16*/(""",
            		'delete': function(t) """),format.raw/*27.37*/("""{"""),format.raw/*27.38*/("""
                		alert('Trigger was '+t.id+'\nAction was Delete');
            		"""),format.raw/*29.15*/("""}"""),format.raw/*29.16*/("""
        		"""),format.raw/*30.11*/("""}"""),format.raw/*30.12*/("""
    		"""),format.raw/*31.7*/("""}"""),format.raw/*31.8*/(""");
		"""),format.raw/*32.3*/("""}"""),format.raw/*32.4*/(""");
		</script>
    </head>
    <body>
    	<div class='contextMenu' id='myMenu'>
    		<ul>
        		<li id='open'>Open</li>
        		<li id='email'>Email</li>
        		<li id='save'>Save</li>
        		<li id='close'>Close</li>
    		</ul>
		</div>
		<h2>新たに作成するページの名前を指定してください。</h2>
		
        """),_display_(Seq[Any](/*46.10*/helper/*46.16*/.form(action = routes.Application.new_page())/*46.61*/ {_display_(Seq[Any](format.raw/*46.63*/("""
        """),_display_(Seq[Any](/*47.10*/helper/*47.16*/.CSRF.formField)),format.raw/*47.31*/("""
        <input name="name" type="text"></input>.html</br>
        <input type="submit" value="決定"/>
        """)))})),format.raw/*50.10*/("""
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
                    DATE: Sat Jul 25 12:38:15 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/aaa/CWA/app/views/edit_new_page.scala.html
                    HASH: 29aa41192e6e11741ff8394978f22bbb80675ce9
                    MATRIX: 782->1|891->16|979->69|1005->74|1102->136|1116->142|1171->176|1267->237|1281->243|1334->275|1395->300|1410->306|1470->344|1563->401|1578->407|1645->452|1738->509|1753->515|1825->565|1943->655|1972->656|2051->707|2080->708|2133->733|2162->734|2228->772|2257->773|2366->854|2395->855|2460->892|2489->893|2599->975|2628->976|2692->1012|2721->1013|2830->1094|2859->1095|2925->1133|2954->1134|3065->1217|3094->1218|3133->1229|3162->1230|3196->1237|3224->1238|3256->1243|3284->1244|3620->1544|3635->1550|3689->1595|3729->1597|3775->1607|3790->1613|3827->1628|3969->1738
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|45->17|45->17|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|52->24|52->24|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32|74->46|74->46|74->46|74->46|75->47|75->47|75->47|78->50
                    -- GENERATED --
                */
            