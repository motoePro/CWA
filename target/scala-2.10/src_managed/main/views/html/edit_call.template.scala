
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
object edit_call extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](_display_(Seq[Any](/*1.2*/edit_main("編集ページ")/*1.20*/{_display_(Seq[Any](format.raw/*1.21*/("""

""")))})),format.raw/*3.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Sep 03 05:12:19 JST 2015
                    SOURCE: /Users/hasegawakazuya/Desktop/CWA/app/views/edit_call.scala.html
                    HASH: 34e10c9c121159cce9dac484e68b5a0fed189ae1
                    MATRIX: 868->1|894->19|932->20|965->23
                    LINES: 29->1|29->1|29->1|31->3
                    -- GENERATED --
                */
            