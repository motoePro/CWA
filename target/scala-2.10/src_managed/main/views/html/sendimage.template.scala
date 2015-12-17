
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
object sendimage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(fileName: String, name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""
<!DOCTYPE html>
<html>
<head>
<script>
	var uri  = """"),_display_(Seq[Any](/*6.15*/routes/*6.21*/.Assets.at("/user", name+"/images/"+fileName))),format.raw/*6.66*/("""";
	console.log(uri);
	parent.addImg(uri);
</script>
</head>
<body>
	
</body>
</html>"""))}
    }
    
    def render(fileName:String,name:String): play.api.templates.HtmlFormat.Appendable = apply(fileName,name)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (fileName,name) => apply(fileName,name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/sendimage.scala.html
                    HASH: 8bfe10261328dd705d188a62f4ce1c94d8e138af
                    MATRIX: 785->1|911->33|1000->87|1014->93|1080->138
                    LINES: 26->1|29->1|34->6|34->6|34->6
                    -- GENERATED --
                */
            