
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
object user_page extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(UserName: String,pages: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

"""),_display_(Seq[Any](/*3.2*/main("ユーザページ")/*3.16*/ {_display_(Seq[Any](format.raw/*3.18*/("""
	<h1>ユーザのページ</h1>
	<p>ようこそ。"""),_display_(Seq[Any](/*5.11*/UserName)),format.raw/*5.19*/(""" さん</p>
	<fieldset>
	<legend>作成したページ</legend>
	<ul>
	"""),_display_(Seq[Any](/*9.3*/for(p <- pages) yield /*9.18*/ {_display_(Seq[Any](format.raw/*9.20*/("""
	<li><a href=""""),_display_(Seq[Any](/*10.16*/routes/*10.22*/.Assets.at("/user",UserName+"/"+p))),format.raw/*10.56*/("""">"""),_display_(Seq[Any](/*10.59*/p)),format.raw/*10.60*/("""</a></li>
	""")))})),format.raw/*11.3*/("""
	</ul>
	</fieldset>
	
	</br>
	<a href="/edit_call">編集ページへ</a>

	<a href="/logout">ログアウト</a>

	<a href="/edit_blog">ブログの編集</a>

""")))})))}
    }
    
    def render(UserName:String,pages:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(UserName,pages)
    
    def f:((String,Array[String]) => play.api.templates.HtmlFormat.Appendable) = (UserName,pages) => apply(UserName,pages)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 18 01:42:57 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/user_page.scala.html
                    HASH: 263a057d893eb5a406cdbdab4758699341abb6ae
                    MATRIX: 792->1|925->40|962->43|984->57|1023->59|1087->88|1116->96|1204->150|1234->165|1273->167|1325->183|1340->189|1396->223|1435->226|1458->227|1501->239
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|37->9|37->9|37->9|38->10|38->10|38->10|38->10|38->10|39->11
                    -- GENERATED --
                */
            