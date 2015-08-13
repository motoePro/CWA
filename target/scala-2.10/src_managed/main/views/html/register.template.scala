
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
object register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Form[models.Account],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String, form: Form[models.Account]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/main("会員登録")/*3.14*/ {_display_(Seq[Any](format.raw/*3.16*/("""
	<h1>会員登録</h1>
	<p>名前とパスワードを入れてね</p>
	"""),_display_(Seq[Any](/*6.3*/helper/*6.9*/.form(action = routes.Application.create)/*6.50*/ {_display_(Seq[Any](format.raw/*6.52*/("""
		"""),_display_(Seq[Any](/*7.4*/helper/*7.10*/.CSRF.formField)),format.raw/*7.25*/("""
		"""),_display_(Seq[Any](/*8.4*/(helper.inputText(
			field = form("username")
		)))),format.raw/*10.5*/("""
		
		"""),_display_(Seq[Any](/*12.4*/(helper.inputPassword(
			field = form("password")
		)))),format.raw/*14.5*/("""
		
		<input type="submit">
	""")))})),format.raw/*17.3*/("""
""")))})),format.raw/*18.2*/("""
"""))}
    }
    
    def render(message:String,form:Form[models.Account]): play.api.templates.HtmlFormat.Appendable = apply(message,form)
    
    def f:((String,Form[models.Account]) => play.api.templates.HtmlFormat.Appendable) = (message,form) => apply(message,form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Aug 07 04:53:25 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/register.scala.html
                    HASH: 63da549ba3fb0c9603f50a89db05551e62e38743
                    MATRIX: 798->1|937->46|974->49|994->61|1033->63|1107->103|1120->109|1169->150|1208->152|1246->156|1260->162|1296->177|1334->181|1406->232|1448->239|1524->294|1585->324|1618->326
                    LINES: 26->1|29->1|31->3|31->3|31->3|34->6|34->6|34->6|34->6|35->7|35->7|35->7|36->8|38->10|40->12|42->14|45->17|46->18
                    -- GENERATED --
                */
            