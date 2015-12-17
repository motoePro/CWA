
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
object selectbg extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*2.1*/("""
<!DOCTYPE html>
<html>
<head>
<title>背景画像の設定</title>
<script src=""""),_display_(Seq[Any](/*7.15*/routes/*7.21*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*7.76*/("""" type="text/javascript"></script>
<script>
<!--メニューから呼び出されていない場合はTOPへリダイレクト-->
window.onload = function() """),format.raw/*10.28*/("""{"""),format.raw/*10.29*/("""if(!window.opener) """),format.raw/*10.48*/("""{"""),format.raw/*10.49*/(""" location.href='http://localhost:9000/'"""),format.raw/*10.88*/("""}"""),format.raw/*10.89*/("""}"""),format.raw/*10.90*/("""
function checkFile() """),format.raw/*11.22*/("""{"""),format.raw/*11.23*/("""
	if($(name = bgimage) == null) """),format.raw/*12.32*/("""{"""),format.raw/*12.33*/("""alert("背景にする画像を指定してください。") return false;"""),format.raw/*12.73*/("""}"""),format.raw/*12.74*/("""
"""),format.raw/*13.1*/("""}"""),format.raw/*13.2*/("""
</script>
</head>
<body>
<form name="bgselect" id="bgselect" method="post" action="/edit_call/setbg" target="upload-image" enctype="multipart/form-data" onSubmit="window.close()">
"""),_display_(Seq[Any](/*18.2*/CSRF/*18.6*/.formField)),format.raw/*18.16*/("""
<p>背景に設定する画像を指定してください</p>
<input type="file" name="bgimage"/>
<p><input type="checkbox" name="setAll" checked="checked" value="setAll" >全てのページに適応する</p>
<div>
<input type=button value="取り消し" onClick="window.close()"/>
<input type="submit" value="決定" onClick=checkFile() />
</div>
</form>
</body>
</html>"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/selectbg.scala.html
                    HASH: b3822f43026c5e3d4eebbf338bed66a0be99c1e6
                    MATRIX: 874->17|977->85|991->91|1067->146|1202->253|1231->254|1278->273|1307->274|1374->313|1403->314|1432->315|1482->337|1511->338|1571->370|1600->371|1668->411|1697->412|1725->413|1753->414|1970->596|1982->600|2014->610
                    LINES: 30->2|35->7|35->7|35->7|38->10|38->10|38->10|38->10|38->10|38->10|38->10|39->11|39->11|40->12|40->12|40->12|40->12|41->13|41->13|46->18|46->18|46->18
                    -- GENERATED --
                */
            