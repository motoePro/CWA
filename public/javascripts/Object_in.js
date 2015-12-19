var ElementID = 1;
var target = "";

//背景画像を設定
function addBg(src) {
	// var body = parent.main.document.getElementsByTagName("body")[0];
	// body.setAttribute("background",src);
	var v = "url(\""+src+"\")";
	console.log(v);
	// $('#container').style.background = v;
	var container = parent.main.document.getElementById('container');
	container.style.backgroundImage = v;
	// container.css('background-image','url('+src+')');
	// parent.main.$('#container').css('background-image',v);
	// $('#container').css('background-color','red');
	// $('#container').css('background-image', 'none');
}





//画像をページに追加
function addImg(src) {
	var body = parent.main.document.getElementById('container');
	var img = document.createElement("img");
	img.setAttribute("class","img_chan context");
	img.setAttribute("src",src);
	body.appendChild(img);
	img.id = ElementID;
	parent.main.pctmv();
	parent.main.context();
	ElementID++;
}

function addBtn(){ 
	var body = parent.main.document.getElementById('body_main');
	var tag = document.createElement('div');
	tag.id = ElementID;
	tag.className = "context";
	tag.style.width =  "60px";
	tag.style.height = "30px";
	
	var btn_tag = document.createElement('input');
	btn_tag.type = "button";
	btn_tag.id = "btn_id";
	btn_tag.value = "Sample";
	
	body.appendChild(tag);
	tag.appendChild(btn_tag);
	
	ElementID++;
	parent.main.context();
}

function addTxt(){
	var body = parent.main.document.getElementById('container');
	var txt_tag = document.createElement('div');
	txt_tag.id = ElementID;
	txt_tag.className = "pchan context edit text";
	txt_tag.innerHTML = "タイトル";
	txt_tag.style = "background-color: transparent; margin:0; padding:0; position:absolute; left:0px; top:0px";
	body.appendChild(txt_tag);
	parent.main.txtmv();
	ElementID++;
	parent.main.context();
}

function addTxb(){
	var body = parent.main.document.getElementById('body_main');
	var txt_tag = document.createElement('a');
	txt_tag.id = ElementID;
	txt_tag.className = "pchan context";
	txt_tag.href = "ddfasfasd";
	txt_tag.innerHTML = "タイトル";
	txt_tag.style = "background-color:red; margin:0; padding:0; position:absolute; left:0px; top:0px";
	// txt_tag.id = "txt_chan";
	// body.appendChild(tag);
	// tag.appendChild(txt_tag);
	body.appendChild(txt_tag);
	parent.main.txtmv();
	
	ElementID++;
	parent.main.context();
	// var body = parent.main.document.getElementById('body_main');
	// var tag = document.createElement('div');
	// tag.id = ElementID;
	// tag.className = "context";
	// // tag.style.width =  "130px";
	
	// var txb_tag = document.createElement('input');
	// txb_tag.type = "text";
	// txb_tag.value = "Sample";
	// txb_tag.className = "pchan";
	
	// body.appendChild(tag);
	// tag.appendChild(txb_tag);
	// parent.main.txtmv();
	// //parent.main.drg();

	// ElementID++;
	// parent.main.context();
}

function addPct(){
	var body = parent.main.document.getElementById('body_main');
	var tag = document.createElement('div');
	tag.id = ElementID;
	tag.className = "context";
	tag.style.width =  "100%";
	
	var pct_tag = document.createElement('img');
	pct_tag.src = "/assets/images/senshu-u.png";
	pct_tag.className = "img_chan";
	
	body.appendChild(tag);
	tag.appendChild(pct_tag);
	parent.main.pctmv();

	ElementID++;
	parent.main.context();
}

function addTwt(){
	var body = parent.main.document.getElementsByTagName('body')[0];
	
	var tag = document.createElement("div");
	tag.id = "twt";
	tag.style.width =  "68px";
	tag.style.height = "22px";
	tag.style.float =  "left";
    body.appendChild(tag);
    
    var div_twt = parent.main.document.getElementsByTagName('div')[0];
    var tag = document.createElement("iframe");
    tag.src = "//twitter.com/share";
    tag.class="twitter-share-button";
    tag['data-via'] = "aaaaa";
    tag['data-lang'] = "ja";
    tag['data-hashtags'] = "bbbbb";
    tag['data-count'] = "none";
    tag.value = "ツイート";
    div_twt.appendChild(tag);

	/*
	var twt_script = parent.main.document.getElementsByTagName('div')[0];
            !function(d,s,id){
                var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';
                if(!d.getElementById(id)){
                    js=d.createElement(s);
                    js.id=id;js.src=p+'://platform.twitter.com/widgets.js';
                    fjs.parentNode.insertBefore(js,fjs);
                }
            }
            (document, 'script', 'twitter-wjs');
    */
}

function addLine() {
	var body = parent.main.document.getElementsByTagName('body')[0];
	var tag = document.createElement("div");
	tag.style.width = "86px";
	tag.style.height = "22px";
	tag.style.float = "left";
	
	var span_tag = document.createElement("span");
	
	var ele1 = document.createElement("script");
	ele1.type = "text/javascript";
	ele1.src="//media.line.me/js/line-button.js?v=20140411"
	
	var ele2 = document.createElement("script");
	ele2.type = "text/javascript";
	ele2.innerHTML = 'new media_line_me.LineButton({"pc":true,"lang":"ja","type":"a"});';
	
	body.appendChild(tag);
	tag.appendChild(span_tag);
	span_tag.appendChild(ele1);
	span_tag.appendChild(ele2);
}

function addFace(){
	var body = parent.main.document.getElementById('body_main');
	var tag = document.createElement("div");
	tag.id = "face";
	tag.className = "demo1";
	tag.style.width = "120px";
	tag.style.height = "22px";
	tag.style.float = "left";
    
    var div_face = document.createElement("iframe");
    div_face.src = "//www.facebook.com/v2.0/plugins/like.php?href=http%3A%2F%2Fwww.senshu-u.jp&amp;width&amp;layout=button&amp;action=like&amp;show_faces=false&amp;share=true&amp;height=30&amp;appId=nnnnnnnnnn";
    div_face.scrolling = "no";
    div_face.frameborder = "0";
    div_face.style.border = "none";
    div_face.style.overflow = "hidden";
    div_face.style.height = "30px";
    div_face.style.allowTransparency = "true";
    
    body.appendChild(tag);
    tag.appendChild(div_face);
}
function Window_YouTube(){
	//https://www.youtube.com/watch?v=TiOWI1dBPcA
	var Url;
	Url = prompt("Urlを入力してください。","");
	if(Url.match(/www.youtube.com/)){
		var body = parent.main.document.getElementById('container');
		var tag = document.createElement('div');
		tag.id = ElementID;
		tag.className = "hover context mv_chan ui-draggable";
		tag.style.width =  "644px";
		tag.style.height = "364px";
		
		var div_youtube = document.createElement("iframe");
		Url = Url.replace("https://www.youtube.com/watch?v=","https://www.youtube.com/embed/")+"?rel=0&amp;showinfo=0";
		div_youtube.src = Url;
    	div_youtube.frameborder = "0";
    	div_youtube.style.width  = "640px";
    	div_youtube.style.height = "360px";
    	div_youtube.allowfullscreen;
    	

    	body.appendChild(tag);
    	tag.appendChild(div_youtube);
    	//parent.main.pctmv();
    	parent.main.mvmv();
    	
		ElementID++;
		parent.main.context();
	}
}

function comment(){
	if(parent.main.document.getElementById('comments')){
		alert("コメント欄は1ページで1個しか設置できません。");
	}else{
		var title = parent.main.document.getElementsByTagName('title');
		var user_name = parent.edit_head.document.getElementById('userName');
		var body = parent.main.document.getElementById('container');
		var tag = document.createElement('div');
		tag.id = ElementID;
		tag.className = "pchan context";
		var h2 = document.createElement('h2');
		h2.innerHTML = "コメント";
		var all_cmnt = document.createElement('div');
		all_cmnt.id = "comments";
		var form = document.createElement('form');
		form.id="post_comment";
		var un = document.createElement('input');
		un.type="hidden";
		un.name="un";
		un.value=user_name.innerHTML;
		var fn = document.createElement('input');
		fn.type="hidden";
		fn.name="fn";
		fn.value=title[1].innerHTML;
		var name = document.createElement('input');
		name.type = "text";
		name.placeholder = "名前";
		name.name="name";
		var cmnt = document.createElement('input');
		cmnt.type = "text";
		cmnt.placeholder = "コメント";
		cmnt.name="comment";
		var script = document.createElement('script');
		var scriptcode = 'window.onload = function(){requestFile(null,"GET","/user/'+user_name.innerHTML+'/'+title[1].innerHTML+'.xml",true);};';
		scriptcode += 'function send_comment(){var form = document.getElementById("post");var un = document.getElementsByName("un")[0];var fn = document.getElementsByName("fn")[0];var name = document.getElementsByName("name")[0];';
		scriptcode += 'var comment=document.getElementsByName("comment")[0];form.appendChild(un);form.appendChild(fn);form.appendChild(name);form.appendChild(comment);form.setAttribute("action","/edit_call/data_add");form.setAttribute("method","POST");form.submit();};';
		scriptcode += 'function creHR() {return new window.XMLHttpRequest();};';
		scriptcode += 'function requestFile(data, method, fname, async) {var HttpObject = creHR();HttpObject.open(method, fname, async);';
		scriptcode += 'HttpObject.onreadystatechange = function(){if (HttpObject.readyState == 4){CB(HttpObject);};};';
		scriptcode += 'HttpObject.send(data);};';
		scriptcode += 'function CB(HttpObj){var resHTTP = HttpObj.responseXML.documentElement;memberList = resHTTP.getElementsByTagName("comment");memberName = resHTTP.getElementsByTagName("name");memberPersonal = resHTTP.getElementsByTagName("value");memberDate = resHTTP.getElementsByTagName("date");';
		scriptcode += 'for(i = 0; i < memberList.length; i++) {document.getElementById("comments").innerHTML += memberName[i].childNodes[0].nodeValue + " / ";document.getElementById("comments").innerHTML += memberPersonal[i].childNodes[0].nodeValue +" / "+ memberDate[i].childNodes[0].nodeValue +"<br />";document.getElementById("comments").innerHTML += "<hr />";};};';
		script.innerHTML = scriptcode;
		var submit = document.createElement('input');
		submit.type = "button";
		submit.setAttribute("onclick", 'send_comment()');
		submit.value = "送信";
	
		body.appendChild(tag);
		tag.appendChild(script);
		tag.appendChild(h2);
		tag.appendChild(all_cmnt);
		tag.appendChild(form);
		form.appendChild(un);
		form.appendChild(fn);
		form.appendChild(name);
		form.appendChild(cmnt);
    	form.appendChild(submit);
		ElementID++;
		parent.main.txtmv();
		parent.main.context();
	}
}

function blog(target){
	console.log(target);
	//var title = parent.main.document.getElementsByTagName('title');
	var title = target;
	//alert(title[1].innerHTML);
	var user_name = parent.edit_head.document.getElementById('userName');
	var body = parent.main.document.getElementById('container');
	var tag = document.createElement('div');
	tag.id = ElementID;
	tag.className = "pchan context edit blog";
	var articles_body = document.createElement("div");
	articles_body.id = "article";
	var article_sample = document.createElement("p");
	article_sample.innerHTML = "<hr>編集するためには保存をする必要があります。<br><hr>";
	var button_div = document.createElement("div");
	var button01 = document.createElement("input");
	button01.id = "page_back_button";
	button01.className = "back";
	button01.type = "button";
	button01.value = "前へ";
	button01.setAttribute("onclick", 'back()');
	button01.disabled = "";
	var button02 = document.createElement("input");
	button02.id = "page_next_button";
	button02.className = "next";
	button02.type = "button";
	button02.value = "次へ";
	button02.setAttribute("onclick", 'next()');
	button02.disabled = "";
	
	var script = document.createElement('script');
	var scriptcode = '';
	scriptcode+= 'var pageMax = 0;var page = 0;var page_in_articles = 5;var target_page;var back_button;var next_button;';
	scriptcode+= 'function back(){if(page > 0){page--;if(page <= 0){back_button.disabled = true;}if(page < pageMax){next_button.disabled = false;}}requestFile(null,"GET","/user/'+user_name.innerHTML+'/'+title+'_articles.xml",true);window.scrollTo(0,0);}';
	scriptcode+= 'function next(){if(page < pageMax){page++;if(page > 0){back_button.disabled = false;}if(page >= pageMax){next_button.disabled = true;}}requestFile(null,"GET","/user/'+user_name.innerHTML+'/'+title+'_articles.xml",true);window.scrollTo(0,0);}';
	scriptcode+= 'window.onload=function(){back_button = document.getElementById("page_back_button");next_button = document.getElementById("page_next_button");back_button.disabled = true;requestFile(null,"GET","/user/'+user_name.innerHTML+'/'+title+'_articles.xml",true);};';
	scriptcode+= 'function creHR(){return new window.XMLHttpRequest();}';
	scriptcode+= 'function requestFile(data, method, fname, async) {var HttpObject = creHR();HttpObject.open(method, fname, async);HttpObject.onreadystatechange = function(){if(HttpObject.readyState == 4){CB(HttpObject);}};HttpObject.send(data);}';
	scriptcode+= 'function CB(HttpObj){var resHTTP = HttpObj.responseXML.documentElement;articleList = resHTTP.getElementsByTagName("article");articleTitle = resHTTP.getElementsByTagName("title");articleMaintext = resHTTP.getElementsByTagName("maintext");';
	scriptcode+= 'articleDate = resHTTP.getElementsByTagName("date");pageMax = (articleList.length / 5) - 1;document.getElementById("article").innerHTML = "";for(i = 0; i < page_in_articles; i++) {';
	scriptcode+= 'if (page * page_in_articles + i < articleList.length) {target_page = page*page_in_articles+i;document.getElementById("article").innerHTML += "<hr><h1>"+articleTitle[target_page].childNodes[0].nodeValue+"</h1>";';
	scriptcode+= 'document.getElementById("article").innerHTML += "<div style=\'text-align: right;\'>"+articleDate[target_page].childNodes[0].nodeValue+"</div>";var mainText = articleMaintext[target_page].childNodes[0].nodeValue;mainText.replace(/&lt;/g,"<");';
	scriptcode+= 'mainText.replace(/&gt;/g,">");document.getElementById("article").innerHTML += "<p>"+mainText+"</p>";document.getElementById("article").innerHTML += "<hr />";}}}';
	script.innerHTML = scriptcode;
	
	body.appendChild(tag);
	tag.appendChild(script);
	tag.appendChild(articles_body);
	articles_body.appendChild(article_sample);
	tag.appendChild(button_div);
	button_div.appendChild(button01);
	button_div.appendChild(button02);
	ElementID++;
	parent.main.txtmv();
	parent.main.context();
}

function call_dicition_name(){
	parent.main.location.href = "/edit_call/call_dicition_name";
}

function change_page(){
	parent.main.location.href = "/edit_call/change";
}

function save_page(){
	parent.main.pctmvdestroy();
	parent.main.mvmvdestroy();
	var head = parent.main.document.getElementById('head_main');
	var headLine = head.innerHTML;

	var body = parent.main.document.getElementById('body_main');
	var HtmlLine = body.innerHTML;

	console.log(HtmlLine);
	
	var form = document.createElement("form");
	
    document.body.appendChild(form);
    
    var Token = document.createElement("input");
    Token.type = "hidden";
    Token.name = "csrfToken";
    Token.value = parent.edit_head.document.save.csrfToken.value;
    form.appendChild(Token);
    
    var name = document.createElement("input");
    name.type = "text";
    name.name = "name";
    name.value = parent.edit_head.document.name.edit_page_name.value;
    form.appendChild(name);
    
    var input = document.createElement("input");
    input.type = "text";
    input.name = "head";
    input.value = headLine;
    form.appendChild(input);
    
    var input = document.createElement("input");
    input.type = "text";
    input.name = "html";
    input.value = HtmlLine;
    form.appendChild(input);
    
    form.setAttribute("action","/edit_call/save");
    form.setAttribute("method", "POST");
    form.submit();
	parent.main.pctmv();
	parent.main.mvmv();
}

function read_directory(){
	var fs = new ActiveXObject( "Scripting.FileSystemObject" );
	//  Folderオブジェクトを取得
	var folder = fs.GetFolder( "C:/TEST" );
	//  EnumeratorオブジェクトにFolderオブジェクトに
	//  含まれている全てのFileオブジェクトを格納
	var em = new Enumerator( folder.Files );
	//  格納したFileオブジェクトのファイル名を全て表示
	for( em.moveFirst(); !em.atEnd(); em.moveNext() )
	    WScript.Echo( em.item().Name );
	//  オブジェクトを解放
	fs = null;
	WScript.Echo( "終了" );
}

function context() {
	$('.context').contextMenu('myMenu',
    {
           	bindings: {
			'edit': function(t) {
           			var flag = $(t).hasClass("edit");
           			var text = $(t).hasClass("text");
           			var blog = $(t).hasClass("blog");
           			if(flag == true){
           				if(text == true){
           					parent.main.txtmvdestroy();
           					window.open('/','text_edit','width=720,height=480,location=0');
							var form = parent.main.document.getElementById('t_edit');
							form.setAttribute("action", "/edit_call/edit_text");
							form.setAttribute("target", "text_edit");
							var object_id = document.createElement("input");
							object_id.setAttribute("name", "id");
							object_id.setAttribute("type", "hidden");
							object_id.setAttribute("value", t.id);
							form.appendChild(object_id);
							form.submit();
							form.removeChild(object_id);
							parent.main.txtmv();
							form.setAttribute("action", "");
							form.setAttribute("target", "");
           				}else if(blog == true){
           					window.open('/','text_edit','width=720,height=480,location=0');
							var form = parent.main.document.getElementById('t_edit');
           					form.setAttribute("action", "/edit_call/blog_data_read");
							form.setAttribute("target", "text_edit");
							var page_name = parent.edit_head.document.name.edit_page_name.value;
							var page = document.createElement("input");
							page.setAttribute("name", "page_name");
							page.setAttribute("type", "hidden");
							page.setAttribute("value", page_name);
							form.appendChild(page);
							form.submit();
							form.removeChild(page);
							form.setAttribute("action", "");
							form.setAttribute("target", "");
							parent.main.txtmv();
           				}else{
           					alert("このパーツには編集機能は付いていません。");
           				}
           			}else{
           				alert("このパーツには編集機能は付いていません。");
           			}
           		},
          		'delete': function(t) {
          			parent.main.mvmvdestroy();
          			parent.main.pctmvdestroy();
    				var body = parent.main.document.getElementById('container');
    				var asset = parent.main.document.getElementById(t.id);
    				console.log("削除対象→"+t);
    				body.removeChild(asset);
    				parent.main.mvmv();
    				parent.main.pctmv();
				},
          	'link': function(t){
          		if($(t).hasClass("img_chan")){
          			console.log(t);
          			var res = prompt("URLを入力してください","");
          			if(res){
          				parent.main.pctmvdestroy();
          				var pct = parent.main.document.getElementById(t.id);
          				var body = parent.main.document.getElementById('container');
          				var link = document.createElement("a");
          				link.href=res;
          				link.className="pchan";
          				link.appendChild(pct);
          				body.appendChild(link);
          				parent.main.pctmv();

          			} else {console.log("リンクの追加：キャンセる")}

          		} else { alert("この要素には対応してません。");
          		}
          	}
          	}
    });
}

function choose_link(val){
	var form = document.getElementById('link_form');
	var link_name = document.getElementById('link_name');
	link_name.value = val;
    form.submit();
    window.close();
}


function resetBg() {
	var container = parent.main.document.getElementById('container');
	container.style.backgroundImage = null;
	console.log(container);
}