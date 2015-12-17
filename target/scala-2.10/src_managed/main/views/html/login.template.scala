
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[models.Login],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(form: play.data.Form[models.Login]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.38*/("""

<html>
    <head>
        <title>Login</title>
        <style type="text/css">
            body """),format.raw/*7.18*/("""{"""),format.raw/*7.19*/(""" background-color: #ccc; padding: 20px; """),format.raw/*7.59*/("""}"""),format.raw/*7.60*/("""
            h1 """),format.raw/*8.16*/("""{"""),format.raw/*8.17*/(""" color: #fff; """),format.raw/*8.31*/("""}"""),format.raw/*8.32*/("""
            input, button """),format.raw/*9.27*/("""{"""),format.raw/*9.28*/(""" padding: 4px 8px; height: 3em; """),format.raw/*9.60*/("""}"""),format.raw/*9.61*/("""
            .error """),format.raw/*10.20*/("""{"""),format.raw/*10.21*/(""" color: #933; """),format.raw/*10.35*/("""}"""),format.raw/*10.36*/("""
            .login """),format.raw/*11.20*/("""{"""),format.raw/*11.21*/("""
                border: 1px solid #aaa;
                padding: 10px 14px;
                margin-top: 10px;
                background-color: #fff;
                width: 300px
            """),format.raw/*17.13*/("""}"""),format.raw/*17.14*/("""
        </style>
    </head>
    <body>
        <header><h1>Login</h1></header>
        """),_display_(Seq[Any](/*22.10*/helper/*22.16*/.form(action = routes.Application.authenticate())/*22.65*/ {_display_(Seq[Any](format.raw/*22.67*/("""
            """),_display_(Seq[Any](/*23.14*/helper/*23.20*/.CSRF.formField)),format.raw/*23.35*/("""
            """),_display_(Seq[Any](/*24.14*/if(form.hasGlobalErrors)/*24.38*/ {_display_(Seq[Any](format.raw/*24.40*/(""" 
                <p class="error">"""),_display_(Seq[Any](/*25.35*/form/*25.39*/.globalError.message)),format.raw/*25.59*/("""</p>
            """)))})),format.raw/*26.14*/("""
            <div class="login">
            <p><input type="text" name="username" placeholder="Username" value=""""),_display_(Seq[Any](/*28.82*/form("username")/*28.98*/.value)),format.raw/*28.104*/(""""></p>
            <p><input type="password" name="password" placeholder="Password"></p>
            <p><button type="submit">Login</button></p>
            </div>
        """)))})),format.raw/*32.10*/("""
    </body>
</html>
    


"""))}
    }
    
    def render(form:play.data.Form[models.Login]): play.api.templates.HtmlFormat.Appendable = apply(form)
    
    def f:((play.data.Form[models.Login]) => play.api.templates.HtmlFormat.Appendable) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/login.scala.html
                    HASH: 7f0d0c81c3c9d1b5137710d84fe90fdbe9a9c430
                    MATRIX: 796->1|926->37|1051->135|1079->136|1146->176|1174->177|1217->193|1245->194|1286->208|1314->209|1368->236|1396->237|1455->269|1483->270|1531->290|1560->291|1602->305|1631->306|1679->326|1708->327|1928->519|1957->520|2083->610|2098->616|2156->665|2196->667|2246->681|2261->687|2298->702|2348->716|2381->740|2421->742|2493->778|2506->782|2548->802|2598->820|2748->934|2773->950|2802->956|3007->1129
                    LINES: 26->1|29->1|35->7|35->7|35->7|35->7|36->8|36->8|36->8|36->8|37->9|37->9|37->9|37->9|38->10|38->10|38->10|38->10|39->11|39->11|45->17|45->17|50->22|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|54->26|56->28|56->28|56->28|60->32
                    -- GENERATED --
                */
            