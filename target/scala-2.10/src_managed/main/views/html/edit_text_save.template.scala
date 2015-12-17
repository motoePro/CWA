
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
object edit_text_save extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,String,Array[String],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(ID: String, text: String, url_params: Array[String]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.55*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>リンク指定</title>
        <script src=""""),_display_(Seq[Any](/*7.23*/routes/*7.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*7.84*/("""" type="text/javascript"></script>
        <script type="text/javascript">
        $(function()"""),format.raw/*9.21*/("""{"""),format.raw/*9.22*/("""
        	if(!window.opener || window.opener.closed)"""),format.raw/*10.52*/("""{"""),format.raw/*10.53*/("""
				window.alert('メインウィンドウがありません');
			"""),format.raw/*12.4*/("""}"""),format.raw/*12.5*/("""else"""),format.raw/*12.9*/("""{"""),format.raw/*12.10*/("""
				var obj = window.opener.parent.main.document.getElementById(""""),_display_(Seq[Any](/*13.67*/ID)),format.raw/*13.69*/("""");
				window.opener.parent.main.txtmvdestroy();
				var result = """"),_display_(Seq[Any](/*15.20*/text)),format.raw/*15.24*/("""";
				var url = new Array();
				var url_start = new Array();
				var cnt = 0;
				var target,target_split;
				var start_index,end_index,html,text;
    			"""),_display_(Seq[Any](/*21.9*/for(param <- url_params) yield /*21.33*/{_display_(Seq[Any](format.raw/*21.34*/("""
    				url[cnt] = """"),_display_(Seq[Any](/*22.22*/param)),format.raw/*22.27*/("""";
    				target_split = url[cnt].split(" ");
    				url_start[cnt] = parseInt(target_split[0]);
    				var url_end = parseInt(target_split[1]);
    				if(url_start[cnt] == 0 && url_end == 0)"""),format.raw/*26.48*/("""{"""),format.raw/*26.49*/("""
    					alert("hit");
    					cnt--;
    				"""),format.raw/*29.9*/("""}"""),format.raw/*29.10*/("""
    				cnt++;
    			""")))})),format.raw/*31.9*/("""
    			var index = new Array();
    			var i,j,tmp,urls,idx;
    			for(var b=0;b<cnt;b++)"""),format.raw/*34.30*/("""{"""),format.raw/*34.31*/("""
    				index[b]=b;
    			"""),format.raw/*36.8*/("""}"""),format.raw/*36.9*/("""
        		for(i=index.length-1;0<=i;i--)"""),format.raw/*37.41*/("""{"""),format.raw/*37.42*/("""
            		for(j=index.length-i-1;0<j;j--)"""),format.raw/*38.46*/("""{"""),format.raw/*38.47*/("""
            			//alert("if url[j-1]: "+url_start[j-1]+" < url[j]: "+url_start[j]);
                		if(url_start[j-1] < url_start[j])"""),format.raw/*40.52*/("""{"""),format.raw/*40.53*/("""
                    		urls = url_start[j-1];
                    		idx = index[j-1];
                    		tmp = url[j-1];
                    		url_start[j-1] = url_start[j];
                    		index[j-1] = index[j];
                    		url[j-1] = url[j]
                    		url_start[j] = urls;
                    		index[j] = idx;
                    		url[j] = tmp;
                    		//alert("change");
                		"""),format.raw/*51.19*/("""}"""),format.raw/*51.20*/("""
           		 	"""),format.raw/*52.16*/("""}"""),format.raw/*52.17*/("""
       		 	"""),format.raw/*53.12*/("""}"""),format.raw/*53.13*/("""
       		 	//alert("index:["+index+"] url:["+url+"]");
       		 	result = result.replace(/#BR#/g, "\n");
       		 	//alert(url[1]);
       		 	for(var i=0; i<cnt; i++)"""),format.raw/*57.36*/("""{"""),format.raw/*57.37*/("""
    				target = url[i];
    				//alert(target);
    				target_split = target.split(" ");
    				start_index = target_split[0];
    				end_index = target_split[1];
    				html =  target_split[2];
    				text = target_split[3];
    				//alert("s_i: "+start_index+" e_i: "+end_index+" html: "+html+" text: "+text);
    				var tag = result.substring(start_index,end_index);
    				//alert("tag: "+tag+" text: "+text);
    				if(result.substring(start_index,end_index) == target_split[3])"""),format.raw/*68.71*/("""{"""),format.raw/*68.72*/("""
    					tag = "<a id='link0"+String(i)+"' href='"+ html +"'>"+result.substring(start_index,end_index)+"</a>";
    				"""),format.raw/*70.9*/("""}"""),format.raw/*70.10*/("""
    				result = result.substring(0,start_index)+tag+result.substring(end_index,result.length);
    				//alert(result);
    			"""),format.raw/*73.8*/("""}"""),format.raw/*73.9*/("""
    			var result = result.replace(/[\n]/g, "<br>");
    			//alert(result);
				obj.innerHTML = result;
				window.opener.parent.main.txtmv();
				window.close();
			"""),format.raw/*79.4*/("""}"""),format.raw/*79.5*/("""
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""")
        </script>
    </head>
    <body>
    </body>
</html>"""))}
    }
    
    def render(ID:String,text:String,url_params:Array[String]): play.api.templates.HtmlFormat.Appendable = apply(ID,text,url_params)
    
    def f:((String,String,Array[String]) => play.api.templates.HtmlFormat.Appendable) = (ID,text,url_params) => apply(ID,text,url_params)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_text_save.scala.html
                    HASH: e0a045434323985200d0f9f30fdcf54c96c42ca1
                    MATRIX: 804->1|967->54|994->72|1114->157|1128->163|1204->218|1326->313|1354->314|1434->366|1463->367|1530->407|1558->408|1589->412|1618->413|1721->480|1745->482|1850->551|1876->555|2069->713|2109->737|2148->738|2206->760|2233->765|2456->960|2485->961|2560->1009|2589->1010|2644->1034|2763->1125|2792->1126|2847->1154|2875->1155|2944->1196|2973->1197|3047->1243|3076->1244|3239->1379|3268->1380|3734->1818|3763->1819|3807->1835|3836->1836|3876->1848|3905->1849|4103->2019|4132->2020|4655->2515|4684->2516|4831->2636|4860->2637|5016->2766|5044->2767|5239->2935|5267->2936|5303->2945|5332->2946
                    LINES: 26->1|30->1|31->3|35->7|35->7|35->7|37->9|37->9|38->10|38->10|40->12|40->12|40->12|40->12|41->13|41->13|43->15|43->15|49->21|49->21|49->21|50->22|50->22|54->26|54->26|57->29|57->29|59->31|62->34|62->34|64->36|64->36|65->37|65->37|66->38|66->38|68->40|68->40|79->51|79->51|80->52|80->52|81->53|81->53|85->57|85->57|96->68|96->68|98->70|98->70|101->73|101->73|107->79|107->79|108->80|108->80
                    -- GENERATED --
                */
            