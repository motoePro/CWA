
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
object file_view extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(htmlLine: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.27*/("""
"""),_display_(Seq[Any](/*3.2*/for(line <- htmlLine) yield /*3.23*/{_display_(Seq[Any](format.raw/*3.24*/("""
	"""),_display_(Seq[Any](/*4.3*/Html(line))),format.raw/*4.13*/("""
""")))})),format.raw/*5.2*/("""
<form id="post">
	"""),_display_(Seq[Any](/*7.3*/CSRF/*7.7*/.formField)),format.raw/*7.17*/("""
</form>"""))}
    }
    
    def render(htmlLine:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(htmlLine)
    
    def f:((Array[String]) => play.api.templates.HtmlFormat.Appendable) = (htmlLine) => apply(htmlLine)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/file_view.scala.html
                    HASH: bff89872bfc158a4788ee41975db655d733c6e1e
                    MATRIX: 785->1|920->26|956->45|992->66|1030->67|1067->70|1098->80|1130->82|1184->102|1195->106|1226->116
                    LINES: 26->1|30->1|31->3|31->3|31->3|32->4|32->4|33->5|35->7|35->7|35->7
                    -- GENERATED --
                */
            