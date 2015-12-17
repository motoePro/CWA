
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
object user_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(UserName: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""

"""),_display_(Seq[Any](/*3.2*/main("ユーザページ")/*3.16*/ {_display_(Seq[Any](format.raw/*3.18*/("""
	<h1>ユーザのページ</h1>
	<p>ようこそ。"""),_display_(Seq[Any](/*5.11*/UserName)),format.raw/*5.19*/(""" さん</p>
	</br>
	<a href="/edit_call">編集ページへ</a>

	<a href="/logout">ログアウト</a>

	<a href="/edit_blog">ブログの編集</a>

""")))})))}
    }
    
    def render(UserName:String): play.api.templates.HtmlFormat.Appendable = apply(UserName)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (UserName) => apply(UserName)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 14:23:32 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/user_page.scala.html
                    HASH: cfc571fe8a90a4a09d7efc91ca495632473e410d
                    MATRIX: 778->1|890->19|927->22|949->36|988->38|1052->67|1081->75
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5
                    -- GENERATED --
                */
            