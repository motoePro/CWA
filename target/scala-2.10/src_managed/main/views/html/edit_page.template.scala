
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
object edit_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
    		$('.demo1').contextMenu('myMenu',
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
    </body>
</html>"""))}
    }
    
    def render(title:String): play.api.templates.HtmlFormat.Appendable = apply(title)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (title) => apply(title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jun 20 19:07:32 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_page.scala.html
                    HASH: ef96893a8c5df99af61d8ec5ad1bd886904c36f2
                    MATRIX: 778->1|887->16|975->69|1001->74|1098->136|1112->142|1167->176|1263->237|1277->243|1330->275|1391->300|1406->306|1466->344|1559->401|1574->407|1641->452|1734->509|1749->515|1821->565|1939->655|1968->656|2047->707|2076->708|2129->733|2158->734|2224->772|2253->773|2362->854|2391->855|2456->892|2485->893|2595->975|2624->976|2688->1012|2717->1013|2826->1094|2855->1095|2921->1133|2950->1134|3061->1217|3090->1218|3129->1229|3158->1230|3192->1237|3220->1238|3252->1243|3280->1244
                    LINES: 26->1|29->1|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|42->14|42->14|44->16|44->16|45->17|45->17|46->18|46->18|48->20|48->20|49->21|49->21|51->23|51->23|52->24|52->24|54->26|54->26|55->27|55->27|57->29|57->29|58->30|58->30|59->31|59->31|60->32|60->32
                    -- GENERATED --
                */
            