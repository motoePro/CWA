
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
object edit_blog extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[Array[String],Array[String],Array[String],String,String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(blog_id: Array[String],blog_title: Array[String],blog_value: Array[String],user_name:String,page_name: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*1.113*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
    <head>
        <title>テキストの編集</title>
        <link rel="stylesheet" media="screen" href=""""),_display_(Seq[Any](/*7.54*/routes/*7.60*/.Assets.at("/public","stylesheets/jquery-ui.css"))),format.raw/*7.109*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*8.59*/routes/*8.65*/.Assets.at("/public","images/favicon.png"))),format.raw/*8.107*/("""">
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("/public","javascripts/jquery-1.9.0.min.js"))),format.raw/*9.84*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("/public","javascripts/jquery.contextmenu.r2.js"))),format.raw/*10.89*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*11.23*/routes/*11.29*/.Assets.at("/public","javascripts/editor.js"))),format.raw/*11.74*/("""" type="text/javascript"></script>
        <script type="text/javascript">
        	var object_id;
        	var blog_value = new Array();
        	var pointer = 0;
        	var load_flag = 0;
        	var HttpObject = null;
        	window.onload = function()"""),format.raw/*18.36*/("""{"""),format.raw/*18.37*/("""
        		var titles = document.getElementsByName("title");
        		var ids = new Array(0);
        		"""),_display_(Seq[Any](/*21.12*/for(id <- blog_id) yield /*21.30*/{_display_(Seq[Any](format.raw/*21.31*/("""
					ids.push("""),_display_(Seq[Any](/*22.16*/id)),format.raw/*22.18*/(""");
				""")))})),format.raw/*23.6*/("""
        		for(var i = 0; i < titles.length; i++)"""),format.raw/*24.49*/("""{"""),format.raw/*24.50*/("""
        			var element = titles[i];
        			element.value = i;
        			element.id = ids[i];
        			if(i == 0)"""),format.raw/*28.22*/("""{"""),format.raw/*28.23*/("""
        				element.selected = true;
        			"""),format.raw/*30.12*/("""}"""),format.raw/*30.13*/("""
        		"""),format.raw/*31.11*/("""}"""),format.raw/*31.12*/("""
        		timerID = setInterval(function()"""),format.raw/*32.43*/("""{"""),format.raw/*32.44*/("""
        			if(load_flag == 0)"""),format.raw/*33.30*/("""{"""),format.raw/*33.31*/("""
                		requestFile(null,"GET","/user/"+""""),_display_(Seq[Any](/*34.53*/user_name)),format.raw/*34.62*/(""""+"/"+""""),_display_(Seq[Any](/*34.70*/page_name)),format.raw/*34.79*/(""""+"_articles.xml",true);
                	"""),format.raw/*35.18*/("""}"""),format.raw/*35.19*/("""
                	if(load_flag == 1)"""),format.raw/*36.36*/("""{"""),format.raw/*36.37*/("""
                		object_id = pointer*2+1;
        				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
        				doc.body.innerHTML = blog_value[object_id];
        				var ED = new Editor('edit');
                        clearInterval(timerID);
                        timerID = null;
                        document.input.input_title.value = blog_value[object_id-1];
                    """),format.raw/*44.21*/("""}"""),format.raw/*44.22*/("""
                """),format.raw/*45.17*/("""}"""),format.raw/*45.18*/(""",1000);
			"""),format.raw/*46.4*/("""}"""),format.raw/*46.5*/("""
			$(document).ready(function()"""),format.raw/*47.32*/("""{"""),format.raw/*47.33*/("""
				$("select").change(function()"""),format.raw/*48.34*/("""{"""),format.raw/*48.35*/("""
					if(load_flag == 1)"""),format.raw/*49.24*/("""{"""),format.raw/*49.25*/("""
	       				pointer = $(this).val();
	       				object_id = pointer*2+1;
   	    				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
    	    			doc.body.innerHTML = blog_value[object_id];
        				var ED = new Editor('edit');
        				document.input.input_title.value = blog_value[object_id-1];
        			"""),format.raw/*56.12*/("""}"""),format.raw/*56.13*/("""
				"""),format.raw/*57.5*/("""}"""),format.raw/*57.6*/(""").change();
			"""),format.raw/*58.4*/("""}"""),format.raw/*58.5*/(""");
        	function creHR()"""),format.raw/*59.26*/("""{"""),format.raw/*59.27*/("""
        		return new window.XMLHttpRequest();
        	"""),format.raw/*61.10*/("""}"""),format.raw/*61.11*/("""
        	function requestFile(data, method, fname, async) """),format.raw/*62.59*/("""{"""),format.raw/*62.60*/("""
        		HttpObject = creHR();
        		HttpObject.open(method, fname, async);
        		HttpObject.onreadystatechange = function()"""),format.raw/*65.53*/("""{"""),format.raw/*65.54*/("""
        			if(HttpObject.readyState == 4)"""),format.raw/*66.42*/("""{"""),format.raw/*66.43*/("""
        				CB(HttpObject);
        			"""),format.raw/*68.12*/("""}"""),format.raw/*68.13*/("""
        		"""),format.raw/*69.11*/("""}"""),format.raw/*69.12*/("""
        		HttpObject.send(data);
        	"""),format.raw/*71.10*/("""}"""),format.raw/*71.11*/("""
       		function CB(HttpObj)"""),format.raw/*72.30*/("""{"""),format.raw/*72.31*/("""
       			var resHTTP = HttpObj.responseXML.documentElement;
       			articleList = resHTTP.getElementsByTagName("article");
       			articleTitle = resHTTP.getElementsByTagName("title");
       			articleMaintext = resHTTP.getElementsByTagName("maintext");
       			articleDate = resHTTP.getElementsByTagName("date");
       			var cnt = 0;
       			for(i = 0; i < articleList.length; i++) """),format.raw/*79.51*/("""{"""),format.raw/*79.52*/("""
       				blog_value[cnt] = articleTitle[i].childNodes[0].nodeValue;
       				blog_value[cnt+1] = articleMaintext[i].childNodes[0].nodeValue;
       				cnt+=2;
       			"""),format.raw/*83.11*/("""}"""),format.raw/*83.12*/("""
       			load_flag = 1;
       		"""),format.raw/*85.10*/("""}"""),format.raw/*85.11*/("""
			function blog_save()"""),format.raw/*86.24*/("""{"""),format.raw/*86.25*/("""
				var titles = document.getElementsByName("title");
				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
				var form = document.getElementById("link_form");
				var target_point = String(parseInt(pointer));
				var element_id = titles[target_point].id;
				// = doc.body.innerHTML;
				var id = document.createElement("input");
				id.name = "id";
				id.value = element_id;
				id.setAttribute("type", "hidden");
				var title = document.createElement("input");
				title.name = "title";
				title.value = document.input.input_title.value;
				title.setAttribute("type", "hidden");
				var main_text = document.createElement("input");
				main_text.name = "main_text";
				main_text.value = doc.body.innerHTML;
				main_text.setAttribute("type", "hidden");
				var page_name = """"),_display_(Seq[Any](/*105.23*/page_name)),format.raw/*105.32*/("""";
				//var page_name = window.opener.parent.edit_head.document.name.edit_page_name.value;
				var page = document.createElement("input");
				page.setAttribute("name", "page_name");
				page.setAttribute("type", "hidden");
				page.setAttribute("value", page_name);
				var type = document.createElement("input");
				type.setAttribute("name", "save_type");
				type.setAttribute("type", "hidden");
				type.setAttribute("value", "change");
				form.appendChild(id);
				form.appendChild(title);
				form.appendChild(main_text);
				form.appendChild(page);
				form.appendChild(type);
				form.submit();
			"""),format.raw/*121.4*/("""}"""),format.raw/*121.5*/("""
			function blog_add()"""),format.raw/*122.23*/("""{"""),format.raw/*122.24*/("""
				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
				var form = document.getElementById("link_form");
				var id = document.createElement("input");
				id.name = "id";
				id.value = "0";
				id.setAttribute("type", "hidden");
				var title = document.createElement("input");
				title.name = "title";
				title.value = "0";
				title.setAttribute("type", "hidden");
				var main_text = document.createElement("input");
				main_text.name = "main_text";
				main_text.value = "0";
				main_text.setAttribute("type", "hidden");
				var page_name = """"),_display_(Seq[Any](/*137.23*/page_name)),format.raw/*137.32*/("""";
				//var page_name = window.opener.parent.edit_head.document.name.edit_page_name.value;
				var page = document.createElement("input");
				page.setAttribute("name", "page_name");
				page.setAttribute("type", "hidden");
				page.setAttribute("value", page_name);
				var type = document.createElement("input");
				type.setAttribute("name", "save_type");
				type.setAttribute("type", "hidden");
				type.setAttribute("value", "add");
				form.appendChild(id);
				form.appendChild(title);
				form.appendChild(main_text);
				form.appendChild(page);
				form.appendChild(type);
				form.submit();
			"""),format.raw/*153.4*/("""}"""),format.raw/*153.5*/("""
			function blog_delete()"""),format.raw/*154.26*/("""{"""),format.raw/*154.27*/("""
				var doc = document.getElementsByTagName("iframe")[0].contentWindow.document;
				var form = document.getElementById("link_form");
				var target_point = String(parseInt(pointer)+1);
				var id = document.createElement("input");
				id.name = "id";
				id.value = target_point;
				id.setAttribute("type", "hidden");
				var title = document.createElement("input");
				title.name = "title";
				title.value = "0";
				title.setAttribute("type", "hidden");
				var main_text = document.createElement("input");
				main_text.name = "main_text";
				main_text.value = "0";
				main_text.setAttribute("type", "hidden");
				var page_name = """"),_display_(Seq[Any](/*170.23*/page_name)),format.raw/*170.32*/("""";
				//var page_name = window.opener.parent.edit_head.document.name.edit_page_name.value;
				var page = document.createElement("input");
				page.setAttribute("name", "page_name");
				page.setAttribute("type", "hidden");
				page.setAttribute("value", page_name);
				var type = document.createElement("input");
				type.setAttribute("name", "save_type");
				type.setAttribute("type", "hidden");
				type.setAttribute("value", "delete");
				form.appendChild(id);
				form.appendChild(title);
				form.appendChild(main_text);
				form.appendChild(page);
				form.appendChild(type);
				form.submit();
			"""),format.raw/*186.4*/("""}"""),format.raw/*186.5*/("""
			function closeCurrentWindow()"""),format.raw/*187.33*/("""{"""),format.raw/*187.34*/("""
				if(!window.opener || window.opener.closed)"""),format.raw/*188.47*/("""{"""),format.raw/*188.48*/(""" // メインウィンドウの存在をチェック
					// 存在しない場合
					document.location = "/edit_blog";
				"""),format.raw/*191.5*/("""}"""),format.raw/*191.6*/("""
				else"""),format.raw/*192.9*/("""{"""),format.raw/*192.10*/("""
					// 存在する場合
					window.close();
				"""),format.raw/*195.5*/("""}"""),format.raw/*195.6*/("""
			"""),format.raw/*196.4*/("""}"""),format.raw/*196.5*/("""
        </script>
    </head>
    <body>
    	<div id="menuroot"></div>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	<br>
    	<form name="input">
    		タイトル名: <input name="input_title" type='text' value=''/>
    		<select name="titles">
				"""),_display_(Seq[Any](/*210.6*/for(title <- blog_title) yield /*210.30*/{_display_(Seq[Any](format.raw/*210.31*/("""
					<option name="title">"""),_display_(Seq[Any](/*211.28*/title)),format.raw/*211.33*/("""</option>
				""")))})),format.raw/*212.6*/("""
			</select>
			<input type='button' onclick='blog_add()' value='新規作成'/>
			<input type='button' onclick='blog_delete()' value='削除'/>
    	</form>
    	<iframe id="edit" width="100px" height="100px" scrolling="on"></iframe>
		<form id="link_form" name="link_form" action="/edit_call/edit_blog_edit" method="POST">
			"""),_display_(Seq[Any](/*219.5*/CSRF/*219.9*/.formField)),format.raw/*219.19*/("""
		</form>
		<button onclick="blog_save()">更新</button>
		<button onclick="closeCurrentWindow()">閉じる</button>
    </body>
</html>"""))}
    }
    
    def render(blog_id:Array[String],blog_title:Array[String],blog_value:Array[String],user_name:String,page_name:String): play.api.templates.HtmlFormat.Appendable = apply(blog_id,blog_title,blog_value,user_name,page_name)
    
    def f:((Array[String],Array[String],Array[String],String,String) => play.api.templates.HtmlFormat.Appendable) = (blog_id,blog_title,blog_value,user_name,page_name) => apply(blog_id,blog_title,blog_value,user_name,page_name)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 17 13:31:28 JST 2015
                    SOURCE: /Users/woon/Documents/workspace/CWA/app/views/edit_blog.scala.html
                    HASH: 383bd1eec266fb6538f4e218bed3ecb3138b2105
                    MATRIX: 827->1|1049->112|1076->130|1229->248|1243->254|1314->303|1410->364|1424->370|1488->412|1548->437|1562->443|1638->498|1731->555|1746->561|1828->621|1921->678|1936->684|2003->729|2290->988|2319->989|2461->1095|2495->1113|2534->1114|2586->1130|2610->1132|2649->1140|2726->1189|2755->1190|2903->1310|2932->1311|3009->1360|3038->1361|3077->1372|3106->1373|3177->1416|3206->1417|3264->1447|3293->1448|3382->1501|3413->1510|3457->1518|3488->1527|3558->1569|3587->1570|3651->1606|3680->1607|4130->2029|4159->2030|4204->2047|4233->2048|4271->2059|4299->2060|4359->2092|4388->2093|4450->2127|4479->2128|4531->2152|4560->2153|4932->2497|4961->2498|4993->2503|5021->2504|5063->2519|5091->2520|5147->2548|5176->2549|5260->2605|5289->2606|5376->2665|5405->2666|5567->2800|5596->2801|5666->2843|5695->2844|5763->2884|5792->2885|5831->2896|5860->2897|5931->2940|5960->2941|6018->2971|6047->2972|6471->3368|6500->3369|6703->3544|6732->3545|6795->3580|6824->3581|6876->3605|6905->3606|7754->4418|7786->4427|8423->5036|8452->5037|8504->5060|8534->5061|9153->5643|9185->5652|9819->6258|9848->6259|9903->6285|9933->6286|10613->6929|10645->6938|11282->7547|11311->7548|11373->7581|11403->7582|11479->7629|11509->7630|11617->7710|11646->7711|11683->7720|11713->7721|11782->7762|11811->7763|11843->7767|11872->7768|12162->8022|12203->8046|12243->8047|12308->8075|12336->8080|12383->8095|12738->8414|12751->8418|12784->8428
                    LINES: 26->1|30->1|31->3|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|46->18|46->18|49->21|49->21|49->21|50->22|50->22|51->23|52->24|52->24|56->28|56->28|58->30|58->30|59->31|59->31|60->32|60->32|61->33|61->33|62->34|62->34|62->34|62->34|63->35|63->35|64->36|64->36|72->44|72->44|73->45|73->45|74->46|74->46|75->47|75->47|76->48|76->48|77->49|77->49|84->56|84->56|85->57|85->57|86->58|86->58|87->59|87->59|89->61|89->61|90->62|90->62|93->65|93->65|94->66|94->66|96->68|96->68|97->69|97->69|99->71|99->71|100->72|100->72|107->79|107->79|111->83|111->83|113->85|113->85|114->86|114->86|133->105|133->105|149->121|149->121|150->122|150->122|165->137|165->137|181->153|181->153|182->154|182->154|198->170|198->170|214->186|214->186|215->187|215->187|216->188|216->188|219->191|219->191|220->192|220->192|223->195|223->195|224->196|224->196|238->210|238->210|238->210|239->211|239->211|240->212|247->219|247->219|247->219
                    -- GENERATED --
                */
            