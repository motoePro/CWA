
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
object setbg extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(fileName: String, name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""


<!DOCTYPE html>
<head>
<script>
	var uri  = """"),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("/user", name+"/images/"+fileName))),format.raw/*7.66*/("""";
	console.log(uri);
	parent.addBg(uri);
</script>
</head>
<body></body>
</html>"""))}
    }
    
    def render(fileName:String,name:String): play.api.templates.HtmlFormat.Appendable = apply(fileName,name)
    
    def f:((String,String) => play.api.templates.HtmlFormat.Appendable) = (fileName,name) => apply(fileName,name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 12:00:15 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/setbg.scala.html
                    HASH: af48c933e97411d35069b56c58ba17a4f47604c3
                    MATRIX: 781->1|907->33|991->82|1005->88|1071->133
                    LINES: 26->1|29->1|35->7|35->7|35->7
                    -- GENERATED --
                */
            