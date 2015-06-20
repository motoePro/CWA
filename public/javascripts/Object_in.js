Object_no = 0;

function addBtn(){ 
	var body = parent.main.document.getElementsByTagName('body')[0];
	var tag = document.createElement('div');
	tag.id = "btn_id";
	tag.className = "demo1";
	tag.style.width =  "60px";
	tag.style.height = "30px";
	
	var btn_tag = document.createElement('input');
	btn_tag.type = "button";
	btn_tag.id = "btn_id";
	btn_tag.value = "Sample";
	
	body.appendChild(tag);
	tag.appendChild(btn_tag);
} 

function addTxt(){
	var body = parent.main.document.getElementsByTagName('body')[0];
	var tag = document.createElement('div');
	tag.id = "txt_id";
	tag.class = "demo1";
	tag.style.width =  "130px";
	
	var txt_tag = document.createElement('p');
	txt_tag.innerHTML = "Sample";
	
	body.appendChild(tag);
	tag.appendChild(txt_tag);
}

function addTxb(){
	var body = parent.main.document.getElementsByTagName('body')[0];
	var tag = document.createElement('div');
	tag.id = "txb_id";
	tag.class = "demo1";
	tag.style.width =  "130px";
	
	var txb_tag = document.createElement('input');
	txb_tag.type = "text";
	txb_tag.id = "txb_id";
	txb_tag.value = "Sample";
	
	body.appendChild(tag);
	tag.appendChild(txb_tag);
}

function addPct(){
	var body = parent.main.document.getElementsByTagName('body')[0];
	var tag = document.createElement('div');
	tag.id = "pct_id";
	tag.class = "demo1";
	tag.style.width =  "25%";
	
	var pct_tag = document.createElement('img');
	pct_tag.src = "/assets/images/senshu-u.png";
	
	body.appendChild(tag);
	tag.appendChild(pct_tag);
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
	var body = parent.main.document.getElementsByTagName('body')[0];
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

function start(){
	alert("OK");
}