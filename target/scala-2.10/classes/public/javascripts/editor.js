// コンストラクタ
function Editor(id)
{
  var myObj = this;

  // プロパティ(メンバ変数)
  this.doc;
  this.win;
  this.iframeid = id;

  // メンバ関数(関数ポインタをメンバ変数に登録しておくイメージ)
  this.bold      = Editor_bold;
  this.italic    = Editor_italic;
  this.underline = Editor_underline;
  this.indent    = Editor_indent;
  this.outdent   = Editor_outdent;
  this.justifyleft   = Editor_justifyleft;
  this.justifycenter = Editor_justifycenter;
  this.justifyright  = Editor_justifyright;
  this.insertorderedlist = Editor_insertorderedlist;
  this.insertunorderedlist = Editor_insertunorderedlist;
  this.createlink = Editor_createlink;
  this.insertimage = Editor_insertimage;
  this.createtable = Editor_createtable;
  this.forecolor = Editor_forecolor;
  this.backcolor = Editor_backcolor;
  this.fontsize  = Editor_fontsize;
  this.formatblock = Editor_formatblock;
  this.undo      = Editor_undo;
  this.redo      = Editor_redo;
  if (document.all) {
    this.insertHTML = Editor_insertHTMLforIE;
  } else {
    this.insertHTML = Editor_insertHTML;
  }
  this.setStyle  = Editor_setStyle;

  ////////////////////////////
  // 初期化処理

  // iframe領域にリッチ編集モードを指定
  if (document.all) {
    // IE
    this.win = document.getElementById(id).contentWindow;
    this.doc = frames[0].document;
  } else {
    this.win = document.getElementById(id).contentWindow;
    this.doc = document.getElementById(id).contentDocument;
    document.getElementById(id).scrolling = "on";
    this.doc.addEventListener('keypress', function () {Editor_onKeyPress(myObj)},true);
  }
  this.doc.designMode = "On";

  this.mousemng = new MouseMng(document);
  this.mousemng.addIframeHandler(id);
  this.menumng = new MenuMng(document);

  this.commandmenu = new CommandMenu(this);
  this.commandmenu.showMenu();

  this.linkmenu =  new LinkMenu(this);
  this.imagemenu = new ImageMenu(this);
  this.tablemenu = new TableMenu(this);
  this.forecolormenu = new ForeColorMenu(this);
  this.backcolormenu = new BackColorMenu(this);

  setTimeout(function () {Editor_onTimer(myObj)}, 10);

  window.onresize = function () {Editor_resizeIFRAME(myObj);}
  Editor_resizeIFRAME(myObj);
}

function Editor_bold()
{
  this.doc.execCommand("bold", false, null);
}

function Editor_italic()
{
  this.doc.execCommand("italic", false, null);
}

function Editor_underline()
{
  this.doc.execCommand("underline", false, null);
}

function Editor_indent()
{
  this.doc.execCommand("indent", false, null);
}

function Editor_outdent()
{
  this.doc.execCommand("outdent", false, null);
}

function Editor_justifyleft()
{
  this.doc.execCommand("justifyleft", false, null);
}

function Editor_justifycenter()
{
  this.doc.execCommand("justifycenter", false, null);
}

function Editor_justifyright()
{
  this.doc.execCommand("justifyright", false, null);
}

function Editor_insertorderedlist()
{
  this.doc.execCommand("insertorderedlist", false, null);
}

function Editor_insertunorderedlist()
{
  this.doc.execCommand("insertunorderedlist", false, null);
}

function Editor_justifyleftustifyright()
{
  this.doc.execCommand("justifyright", false, null);
}

function Editor_createlink(url)
{
  this.doc.execCommand("createlink", false, url);
}

function Editor_insertimage(url)
{
  this.doc.execCommand("insertimage", false, url);
}

function Editor_createtable(table)
{
  this.insertHTML(table);
}

function Editor_forecolor(color)
{
  this.doc.execCommand("forecolor", false, color);
}

function Editor_backcolor(color)
{
  if (document.all) {
    this.doc.execCommand("backcolor", false, color);
  } else {
    this.doc.execCommand("hilitecolor", false, color);
  }
  /*
  var style_func = function (node)
    {
      node.style.backgroundColor = color;
    }

    this.setStyle(style_func);
  */
}

function Editor_fontsize(size)
{
  this.doc.execCommand("fontsize", false, size);
}

function Editor_formatblock(format)
{
  this.doc.execCommand("formatblock", false, format);
}

function Editor_undo()
{
  this.doc.execCommand("undo", false, null);
}

function Editor_redo()
{
  this.doc.execCommand("redo", false, null);
}

function Editor_insertHTML(html)
{
  var fragment = document.createDocumentFragment();
  var div = document.createElement("div");
  div.innerHTML = html;

  // div配下のNodeをfragmentに移動
  while (div.firstChild) {
    fragment.appendChild(div.firstChild);
  }

  // iframe内のselection(選択文字列)を取得
  // window.getSelection()だと上位のウィンドウになってしまう。
  selection = this.win.getSelection();
  this.win.focus();

  range = selection.getRangeAt(0);

  range.deleteContents();

  // Ref to http://www.w3.org/TR/DOM-Level-2-Traversal-Range/ranges.html
  var container = range.startContainer;
  var offset = range.startOffset;

  switch (container.nodeType) {
  case 1:
    // Element node
    container.insertBefore(fragment, container.childNodes[offset]);
    break;
  case 3:
    // Text node
    var node = container.splitText(offset);
    node.parentNode.insertBefore(fragment, node);
    break;
  }
}

function Editor_insertHTMLforIE(html)
{
  // これをやっとかないと、フレームの外にオブジェクトが入ってしまう
  this.win.focus();

  range = this.doc.selection.createRange();
  try {
    range.pasteHTML(html);
  } catch (e) {
    alert(e);
  }
}


function Editor_setStyle(style_func)
{
  var selection = this.win.getSelection();
  this.win.focus();
  var rangecount = selection.rangeCount;
  for (var i = 0 ; i < rangecount ; i++) {
    var range = selection.getRangeAt(i);

    if (range.startContainer == range.endContainer &&
	range.startContainer.nodeType == 3) {
      // 選択範囲が同じText Node内の場合
      var node3 = range.startContainer.splitText(range.endOffset);
      var node2 = range.startContainer.splitText(range.startOffset);
      var node1 = range.startContainer;
      // 選択範囲(node2)をspan配下に移動(appendすればremoveは自動でやってくれるみたい。)
      var span = document.createElement("span");
      style_func(span);
      span.appendChild(node2);
      node1.parentNode.insertBefore(span, node3);
    } else {
      var start,end;
      // 選択範囲がNodeを跨ぐ
      if (range.startContainer.nodeType == 3) {
	start = range.startContainer.splitText(range.startOffset);
      } else {
	start = range.startContainer.childNodes[range.startOffset];
      }

      if (range.endContainer.nodeType == 3) {
	end =  range.endContainer;
	end.splitText(range.endOffset);
      } else {
	end = range.endContainer.childNodes[range.endOffset - 1];
	if (start == end) {
	  style_func(start);
	  continue;
	}
      }

      args = Array();
      args['endnode'] = end;
      args['style_func'] = style_func;
      walkDOMTree(start, style_walk, args);
    }
  }
}

function style_walk(node, args)
{
  if (!isContain(node, args['endnode']) ||
      node == args['endnode']) {
    // 配下にendnodeがいないので、本ノード以下にstyle指定

    if (node.nodeType == 3) {
      // スタイルを設定したspan nodeで括る
      var span = document.createElement("span");
      args['style_func'](span);
      var parent = node.parentNode;
      parent.insertBefore(span, node);
      span.appendChild(node);
    } else {
      // エレメントに直接style指定
      if (node.nodeName != "BR")
	args['style_func'](node);
    }

    if (node == args['endnode'])
      return 1;	// finish

    return 2;	// これより下はWalkしない
  }

  // 配下にendnodeがいるのでまだtagで括らない
  return 0;
}

function isContain(node1, node2)
{
  if (node1 == node2)
    return true;

  while(node2.parentNode) {
    node2 = node2.parentNode;
    if (node1 == node2)
      return true;
  }
  return false;
}


function Editor_onTimer(editor)
{
  var height;

  // ドキュメントの高さに合わせてiframeをリサイズ
  if (document.all) {
    // IEではメニューのfixedができないため、
    // ドキュメントの高さには合わせずiframeのスクロールで対応する。
  } else {
    height = editor.doc.height;
    document.getElementById(editor.iframeid).height = height + 40 + "px";
  }

  setTimeout(function () {Editor_onTimer(editor)}, 1000);
}

function Editor_onKeyPress(editor)
{
  height = editor.doc.height;
  document.getElementById(editor.iframeid).height = height + 40 + "px";
}

function Editor_resizeIFRAME(editor)
{
  var width;

  // Window表示領域の横幅
  if (document.all) {
    width = document.body.clientWidth;
  } else {
    width = window.innerWidth;
  }
  document.getElementById(editor.iframeid).width = width - 40 + "px";

  if (document.all) {
    // IEではiframeの高さをドキュメントの高さではなくWindowの高さに合わせる
    document.getElementById(editor.iframeid).height =
      document.body.clientHeight - 40 + "px";
  }

}

//////////////////
////domtree

// handlerの返り値
// 0 - Walkを続ける
// 1 - Walkを終了
// 2 - このノードより下はWalkしない。(親に戻る)

function walkDOMTree(start, handler, work)
{
  var node = start;
  var index = 0;

  var ret = handler(node, work);
  if (ret == 1)
    return;	// finish
  if (ret == 2) {
    // これより下はWalkしない
    index = node.childNodes.length;
  }

  while(node.parentNode) {

    if (index >= node.childNodes.length) {
      // 子がないか子を全てwalkしたので上へ
      var oldnode = node;
      node = node.parentNode;
      for (var i = 0 ; i < node.childNodes.length ; i++) {
	if (node.childNodes[i] == oldnode) {
	  index = i + 1;	// 次の兄弟から継続
	  break;
	}
      }
      if (i == node.childNodes.length) {
	alert("Not found child node.");	// さっきWalkした子がみつからない。
	return ;
      }
      continue;
    }

    // 下る
    node = node.childNodes[index];
    index = 0;

    ret = handler(node, work);
    if (ret == 1)
      return;	// finish
    if (ret == 2) {
      // これより下はWalkしない
      index = node.childNodes.length;
      continue;
    }

  }
}

//////////////
////mouse
function MouseMng(doc)
{
  this.doc = doc;
  this.iframeid = null;

  this.downL = false;
  this.mouseX = 0;
  this.mouseY = 0;
  this.listen = null;

  var myObj = this;

  this.ondown = function (e)
    {
      if (e.which == 1) {
	myObj.downL = true;
      }

      if (myObj.listen) {
	myObj.listen(e);
      }
    }

  this.onup = function (e)
    {
      if (e.which == 1) {
	myObj.downL = false;
      }

      if (myObj.listen) {
	myObj.listen(e);
      }
    }

  this.onmove = function (e)
    {
      myObj.mouseX = e.pageX;
      myObj.mouseY = e.pageY;

      if (myObj.listen) {
	myObj.listen(e);
      }
    }
  this.onmoveIframe = function (e)
    {
      // Iframeの座標系をDocumentの座標系に修正
      e.pageX += document.getElementById(this.iframeid).offsetLeft;
      e.pageY += document.getElementById(this.iframeid).offsetTop;

      this.onmove(e);
    }

  this.addListenHandler = function (handler)
    {
      this.listen = handler;
    }

  this.deleteListenHandler = function ()
    {
      this.listen = null;
    }

  if (document.all) {
    doc.onmouseup = function () {myObj.onup(new Event(window.event));}
    doc.onmousedown = function () {myObj.ondown(new Event(window.event));}
    doc.onmousemove = function () {myObj.onmove(new Event(window.event));}
  } else {
    doc.onmouseup = function (event) {myObj.onup(new Event(event));}
    doc.onmousedown = function (event) {myObj.ondown(new Event(event));}
    doc.onmousemove = function (event) {myObj.onmove(new Event(event));}
  }

  /*
   * iframe内のイベントも取るようにすると多少メニューの移動が快適になる
   * iframe内のイベントはちゃんとaddEventListener()しないと取れないみたい。
   */
  this.addIframeHandler = function (id)
    {
      this.iframeid = id;

      if (document.all) {
	var iframedoc = frames[id].document;

	// ここだけwindow.eventではないので注意 
	iframedoc.onmouseup = function () {
	  myObj.onup(new Event(document.getElementById(id).contentWindow.event));}
	iframedoc.onmousedown =	function () {
	  myObj.ondown(new Event(document.getElementById(id).contentWindow.event));}
	iframedoc.onmousemove = function () {
	  myObj.onmoveIframe(new Event(document.getElementById(id).contentWindow.event));}
      } else {
	var iframedoc = document.getElementById(id).contentDocument;

	iframedoc.addEventListener('mouseup',
				   function (event) {myObj.onup(new Event(event));},
				   true);
	iframedoc.addEventListener('mousedown',
				   function (event) {myObj.ondown(new Event(event));},
				   true);
	iframedoc.addEventListener('mousemove',
				   function (event) {myObj.onmoveIframe(new Event(event));},
				   true);
      }
    }
}

//////////////
////menu
//--------------------------
// メニュー管理管理クラス
// 現在は表示座標と、ZIndexの管理のみ

function MenuMng()
{
  this.newX = 0;
  this.newY = 0;

  this.menu_MaxZIndex = 0;

  this.visiblemenulist = Array();

  this.showMenuNotify = function (menu)
    {
      if (this.visiblemenulist.length >= 1 &&
	  this.visiblemenulist[this.visiblemenulist.length - 1] != menu) {
	this.visiblemenulist[this.visiblemenulist.length - 1].onLower();
      }

      for (var i = 0 ; i < this.visiblemenulist.length ; i++) {
	if (this.visiblemenulist[i] == menu) {
	  this.visiblemenulist.splice(i,1);
	  break;
	}
      }
      this.visiblemenulist[this.visiblemenulist.length] = menu;
      menu.menuobj.style.zIndex = ++this.menu_MaxZIndex;
      menu.onRaise();

      if (this.newX > window.innerWidth - 200)
	this.newX = 10;
      if (this.newY > window.innerHeight - 200)
	this.newY = 100;

      menu.menuobj.style.left = this.newX + "px";
      menu.menuobj.style.top = this.newY + "px";

      this.newX += 20;
      this.newY += 20;
    }

  this.hideMenuNotify = function (menu)
    {
      for (var i = 0 ; i < this.visiblemenulist.length ; i++) {
	if (this.visiblemenulist[i] == menu) {
	this.visiblemenulist.splice(i,1);
	  break;
	}
      }
      if (this.visiblemenulist.length >= 1) {
	this.visiblemenulist[this.visiblemenulist.length - 1].onRaise();
      }

      this.newX = parseInt(menu.menuobj.style.left) + 20;
      this.newY = parseInt(menu.menuobj.style.top) + 20;
    }

  this.raiseMenu = function (menu)
    {
      if (this.visiblemenulist.length >= 1 &&
	  this.visiblemenulist[this.visiblemenulist.length - 1] != menu) {
	this.visiblemenulist[this.visiblemenulist.length - 1].onLower();
      }

      for (var i = 0 ; i < this.visiblemenulist.length ; i++) {
	if (this.visiblemenulist[i] == menu) {
	  this.visiblemenulist.splice(i,1);
	  break;
	}
      }
      this.visiblemenulist[this.visiblemenulist.length] = menu;

      if (menu.menuobj.style.zIndex < this.menu_MaxZIndex) {
	menu.menuobj.style.zIndex = ++this.menu_MaxZIndex;
	menu.onRaise();
      }
    }
}

//----------------------------
// メニュー基底クラス

function Menu(editor)
{
  var myObj = this;

  this.editor = editor;

  this.visible = false;
  this.menuobj = null;	// メニューの大元のdiv

  this.offsetX = 0;
  this.offsetY = 0;

  // メニューの大元のdiv作成
  this.menuobj = document.createElement("div");
  if (document.all) {
    this.menuobj.style.position  = "absolute";
  } else {
    this.menuobj.style.position  = "fixed";
  }
  this.menuobj.style.top  = "0px";
  this.menuobj.style.left = "0px";


  this.menuobj.onmousedown = function () {
    // メニューを前面へ
    myObj.editor.menumng.raiseMenu(myObj);
  }

  // メニューが最前面に出た時のハンドラ
  this.onRaise = function(){
  }
  // メニューが最前面でなくなった時のハンドラ
  this.onLower = function(){
  }

  this.showMenu = function()
  {
      if(this.visible) {
          this.editor.menumng.raiseMenu(myObj);
	      return ;
      }

      this.visible = true;

      // DOM Treeに追加
      var root = document.getElementById('menuroot');
      root.appendChild(this.menuobj);


      this.editor.menumng.showMenuNotify(this);
  }

  this.hideMenu = function ()
    {
      if (this.visible == false)
	return ;

      this.visible = false;

      // DOM Treeから削除
      var root = document.getElementById('menuroot');
      root.removeChild(this.menuobj);


      this.editor.menumng.hideMenuNotify(this);
    }

  this.onGrab = function (e)
    {
      var x,y;

      // マウスイベント取得開始
      this.editor.mousemng.addListenHandler(this.mouseListener);

      if (document.all) {
	x = e.pageX;
	y = e.pageY;
      } else {
	// fixedで動作している場合はWindow左上が原点なので座標系を変換
	this.winTop  = window.scrollY;
	this.winLeft = window.scrollX;
	x = e.pageX - this.winLeft;
	y = e.pageY - this.winTop;
      }
      this.offsetX = x - parseInt(this.menuobj.style.left);
      this.offsetY = y - parseInt(this.menuobj.style.top);
    }

  this.mouseListener = function (e)
    {
      var x,y;

      switch(e.type) {
      case 'mousemove':
        // メニューの移動
      if (document.all) {
        x = e.pageX - myObj.offsetX;
        y = e.pageY - myObj.offsetY;

	if (x < 0)
	  x = 0;
	if (x > document.body.clientWidth - 200)
	  x = document.body.clientWidth - 200;
	if (y < 0)
	  y = 0;
	if (y > document.body.clientHeight - 50)
	  y = document.body.clientHeight - 50;
      } else {
        x = e.pageX - myObj.offsetX - myObj.winLeft;
        y = e.pageY - myObj.offsetY - myObj.winTop;

	if (x < 0)
	  x = 0;
	if (x > window.innerWidth - 200)
	  x = window.innerWidth - 200;
	if (y < 0)
	  y = 0;
	if (y > window.innerHeight - 50)
	  y = window.innerHeight - 50;
      }


	myObj.menuobj.style.left = x + "px";
        myObj.menuobj.style.top = y + "px";
	break;
      case 'mouseup':
        myObj.editor.mousemng.deleteListenHandler();
	break;
      }
    }
}

//---------------------
// コマンドメニュー

function pressButton(node)
{
  node.style.paddingLeft = "1px";
  node.style.paddingRight = "0px";
  node.style.paddingTop = "1px";
  node.style.paddingBottom = "0px";
}

function releaseButton(node)
{
  node.style.paddingLeft = "0px";
  node.style.paddingRight = "1px";
  node.style.paddingTop = "0px";
  node.style.paddingBottom = "1px";
  node.style.position = "";
}

function createButton(imagesrc, exec)
{
  td = document.createElement("td");
  div = document.createElement("div");
  img = document.createElement("img");

  td.appendChild(div);
  div.appendChild(img);

  div.onclick = exec;
  div.onmouseout = function () {this.style.border="1px solid white";releaseButton(this);}
  div.onmouseover = function () {this.style.border="1px solid gray";}
  div.onmousedown = function () {pressButton(this);}
  div.onmouseup = function () {releaseButton(this);}
  div.style.border = "1px solid white";
  releaseButton(div);

  img.src = imagesrc;

  return td;
}

function createOption(val, text)
{
  opt = document.createElement("option");
  opt.setAttribute("value", val)
  opt.innerHTML = text;

  return opt;
}

function createSelecter(editor)
{
  selecter = document.createElement("div");
  heading = document.createElement("select");
  text = document.createElement("text");
  text.innerHTML = "見出しレベル&nbsp;";

  heading.id = "heading_selecter";
  heading.onchange = function () {editor.formatblock(this.childNodes[this.selectedIndex].getAttribute("value"));}
  heading.onblur = function () {this.selectedIndex=0}
  heading.appendChild(createOption("", "-"));
  heading.appendChild(createOption("<p>", "標準"));
  heading.appendChild(createOption("<h1>", "見出し1"));
  heading.appendChild(createOption("<h2>", "見出し2"));
  heading.appendChild(createOption("<h3>", "見出し3"));

  text2 = document.createElement("text");
  text2.innerHTML = "&nbsp;&nbsp;文字の大きさ&nbsp;";

  fontsize = document.createElement("select");
  fontsize.id = "fontsize_selecter";
  fontsize.onchange = function () {editor.fontsize(this.childNodes[this.selectedIndex].getAttribute("value"))}
  fontsize.onblur = function () {this.selectedIndex=0}
  fontsize.appendChild(createOption("3", "-"));
  fontsize.appendChild(createOption("1", "-2"));
  fontsize.appendChild(createOption("2", "-1"));
  fontsize.appendChild(createOption("3", "通常"));
  fontsize.appendChild(createOption("4", "+1"));
  fontsize.appendChild(createOption("5", "+2"));
  fontsize.appendChild(createOption("6", "+3"));
  fontsize.appendChild(createOption("7", "+4"));

  selecter.appendChild(text);
  selecter.appendChild(heading);
  selecter.appendChild(text2);
  selecter.appendChild(fontsize);

  return selecter;
}

function createCommandButtons(editor)
{
  var button = Array();

  var command = document.createElement("div");
  var table = document.createElement("table");
  var tbody = document.createElement("tbody");
  command.appendChild(table);
  table.appendChild(tbody);

  button[button.length] = createButton('../assets/images/bold.png', function () {editor.bold()});
  button[button.length] = createButton('../assets/images/italic.png', function () {editor.italic()});
  button[button.length] = createButton('../assets/images/underline.png', function () {editor.underline()});
  button[button.length] = createButton('../assets/images/indent.png', function () {editor.indent()});
  button[button.length] = createButton('../assets/images/outdent.png', function () {editor.outdent()});
  button[button.length] = createButton('../assets/images/justifyleft.png', function () {editor.justifyleft()});
  button[button.length] = createButton('../assets/images/justifycenter.png', function () {editor.justifycenter()});
  button[button.length] = createButton('../assets/images/justifyright.png', function () {editor.justifyright()});
  button[button.length] = createButton('../assets/images/orderlist.png', function () {editor.insertorderedlist()});
  button[button.length] = createButton('../assets/images/unorderlist.png', function () {editor.insertunorderedlist()});
  button[button.length] = createButton('../assets/images/link.png', function () {editor.linkmenu.showMenu('link')});
  //button[button.length] = createButton('images/image.gif', function () {editor.imagemenu.showMenu('image')});
  //button[button.length] = createButton('images/table.gif', function () {editor.tablemenu.showMenu('table')});
  button[button.length] = createButton('../assets/images/forecolor.png', function () {editor.forecolormenu.showMenu('forecolor')});
  button[button.length] = createButton('../assets/images/backcolor.png', function () {editor.backcolormenu.showMenu('backcolor')});
  var tr = document.createElement("tr");
  for(var i = 0 ; i < button.length ; i++)
    tr.appendChild(button[i]);
  tbody.appendChild(tr);

  button = Array();
  button[button.length] = createButton('../assets/images/undo.png',
				       function () {editor.undo()});
  button[button.length] = createButton('../assets/images/redo.png',
				       function () {editor.redo()});
  var tr = document.createElement("tr");
  for(var i = 0 ; i < button.length ; i++)
    tr.appendChild(button[i]);
  tbody.appendChild(tr);

  return command;
}

function CommandMenu(editor)
{
  var myObj = this;

  this.parent = Menu;  
  this.parent(editor);	// Call super class's constructor

  // MenuWindowのデザイン設定
  this.menuobj.style.padding = "5px";
  this.menuobj.style.backgroundColor = "white";
  this.menuobj.style.border = "solid";
  this.menuobj.style.borderWidth = "1px";
  this.menuobj.style.borderColor = "gray";
  this.menuobj.style.top = "60px";
  this.menuobj.style.left = "20px";

  // 中身作成
  var selecter = createSelecter(editor);
  var command = createCommandButtons(editor);
  grip = document.createElement("div");
  grip.style.backgroundColor   = "#dddddd";
  grip.style.border = "solid";
  grip.style.borderWidth = "1px";
  grip.style.borderTopColor    = "#eeeeee";
  grip.style.borderLeftColor   = "#eeeeee";
  grip.style.borderRightColor  = "#888888";
  grip.style.borderBottomColor = "#888888";
  grip.style.width = "20px";
  grip.style.height = "120px";
  grip.style.cursor = "move";
  /*
  if (document.all) {
    grip.onmousedown = function () {myObj.onGrab(new Event(window.event));};
  } else {
    grip.onmousedown = function (event) {myObj.onGrab(new Event(event));};
  }
  */
  var table = document.createElement("table");
  var tbody = document.createElement("tbody");
  var tr = document.createElement("tr");
  var td1 = document.createElement("td");
  var td2 = document.createElement("td");

  this.menuobj.appendChild(table);
  table.appendChild(tbody);
  tbody.appendChild(tr);
  tr.appendChild(td1);
  tr.appendChild(td2);
  //td1.appendChild(grip);
  td2.appendChild(selecter);
  td2.appendChild(command);

  this.onRaise = function () {
    document.getElementById('heading_selecter').style.visibility = "visible";
    document.getElementById('fontsize_selecter').style.visibility = "visible";
  }
  this.onLower = function () {
    document.getElementById('heading_selecter').style.visibility = "hidden";
    document.getElementById('fontsize_selecter').style.visibility = "hidden";
  }

}


//----------------------
// SubMenu

function SubMenu(editor)
{
  var myObj = this;

  this.parent = Menu;  
  this.parent(editor);	// Call super class's constructor

  // 実行、閉じるボタン作成
  this.do_btn = document.createElement('img');
  this.do_btn.src = "../assets/images/exec.png";
  this.do_btn.onmouseout = function () {releaseButton(this);}
  this.do_btn.onmousedown = function () {pressButton(this);}
  this.do_btn.onmouseup = function () {releaseButton(this);}
  this.do_btn.style.border = "1px";
  releaseButton(this.do_btn);

  this.close_btn = document.createElement('img');
  this.close_btn.src = "../assets/images/cancel.png";
  this.close_btn.onmouseout = function () {releaseButton(this);}
  this.close_btn.onmousedown = function () {pressButton(this);}
  this.close_btn.onmouseup = function () {releaseButton(this);}
  this.close_btn.onclick = function () {myObj.hideMenu();};
  //this.close_btn.addEventListener('mousedown', close,true);
  releaseButton(this.close_btn);

  // MenuWindowのデザイン設定
  this.menuobj.style.width = "400px";
  this.menuobj.style.backgroundColor = "#ddffdd";
  this.menuobj.style.border = "solid";
  this.menuobj.style.borderWidth = "1px";
  this.menuobj.style.borderTopColor = "#eeeeee";
  this.menuobj.style.borderLeftColor = "#eeeeee";
  this.menuobj.style.borderBottomColor = "#888888";
  this.menuobj.style.borderRightColor = "#888888";
  this.menuobj.style.marginTop    = "4px";
  this.menuobj.style.marginBottom = "4px";
  this.menuobj.style.marginLeft   = "4px";
  this.menuobj.style.marginRight  = "4px";
  this.menuobj.style.paddingTop    = "4px";
  this.menuobj.style.paddingBottom = "4px";
  this.menuobj.style.paddingLeft   = "4px";
  this.menuobj.style.paddingRight  = "4px";

  // タイトルバー作成
  var menutitle = document.createElement("div");
  menutitle.innerHTML = "Title";
  menutitle.style.padding = "3px";
  menutitle.style.marginBottom = "3px";
  menutitle.style.backgroundColor = "#aaffaa";
  menutitle.style.cursor = "move";
  // イベントハンドラ内から自クラスのメソッド、プロパティを
  // 参照する場合はthisを別変数にコピーして参照する。
  // this ポインタはElementの方を指しているので使えない。
  if (document.all) {
    menutitle.onmousedown = function () {myObj.onGrab(new Event(window.event));};
  } else {
    menutitle.onmousedown = function (event) {myObj.onGrab(new Event(event));};
  }
  this.menuobj.appendChild(menutitle);

  this.setTitle = function (title)
    {
      // 現状一番最初のNodeがtitle DIV
      this.menuobj.firstChild.innerHTML = title;
    }
}



function LinkMenu(editor)
{
  var myObj = this;

  this.parent = SubMenu;  
  this.parent(editor);	// Call super class's constructor

  this.createMenu = function ()
    {
      this.setTitle("リンクの作成")
      console.log(parent.p);

      var menu = document.createElement("div");
      menu.innerHTML = "1. URLを指定してください。 <br/>";
      menu.innerHTML +=  "<form name='linkmenu'><input name='url' type='text' size=50 /></form>" +
        "2. リンク化したい文字列を選択後、実行ボタンを押してください。<br>";

      menu.appendChild(this.do_btn);
      menu.appendChild(this.close_btn);
      return menu;
    }

  this.onExec = function ()
    {
      myObj.editor.createlink(document.linkmenu.url.value);
    }

  this.do_btn.onclick = this.onExec;

  // Menuの中身を作成
  this.menuobj.appendChild(this.createMenu());
}

function ImageMenu(editor)
{
  var myObj = this;

  this.parent = SubMenu;  
  this.parent(editor);	// Call super class's constructor

  this.createMenu = function ()
    {
      this.setTitle("画像の貼り付け")

      var menu = document.createElement("div");

      menu.innerHTML =
	"URLを指定してください。<br>" + 
	"<form name='imgmenu'><input name='url' type='text' size=50 /></form>";

      menu.appendChild(this.do_btn);
      menu.appendChild(this.close_btn);

      return menu;
    }

  this.onExec = function ()
    {
      myObj.editor.insertimage(document.imgmenu.url.value);
    }

  this.do_btn.onclick = this.onExec;

  // Menuの中身を作成
  this.menuobj.appendChild(this.createMenu());
}

function TableMenu(editor)
{
  var myObj = this;

  this.parent = SubMenu;  
  this.parent(editor);	// Call super class's constructor

  this.createMenu = function ()
    {
      this.setTitle("表の作成")

      var menu = document.createElement("div");

      menu.innerHTML =
	"<form name='tablemenu'>" +
	"行数 <input name='rows' type='text' size=10 />&nbsp;&nbsp;" +
	"列数 <input name='columns' type='text' size=10 />" +
	"</form>";

      menu.appendChild(this.do_btn);
      menu.appendChild(this.close_btn);

      return menu;
    }

  this.onExec = function ()
    {
      var rows = document.tablemenu.rows.value;
      var columns = document.tablemenu.columns.value;

      var table = "<table border='1'>";
      for (var i = 0 ; i < rows ; i++) {
	table += "<tr>";
	for (var j = 0 ; j < columns ; j++) {
	  table += "<td>item</td>";
	}
	table += "</tr>";
      }
      table += "</table>";

      myObj.editor.createtable(table);
    }

  this.do_btn.onclick = this.onExec;

  // Menuの中身を作成
  this.menuobj.appendChild(this.createMenu());
}

function createColorTable(handler)
{
      var table = document.createElement("table");
      var tbody = document.createElement("tbody");
      var tr = document.createElement("tr");
      table.appendChild(tbody);
      tbody.appendChild(tr);
      var columns = 0;
      for (var r = 0 ; r < 16 ; r += 5) {
	for (var g = 0 ; g < 16 ; g += 5) {
	  for (var b = 0 ; b < 16 ; b += 5) {
	    if (columns >= 18) {
	      // New row
	      tr = document.createElement("tr");
	      tbody.appendChild(tr);
	      columns = 0;
	    }

	    td = document.createElement("td");
	    col = document.createElement("div");
	    col.style.width = "16px";
	    col.style.height = "16px";
	    col.style.backgroundColor = "#" + r.toString(16)+ r.toString(16)+ g.toString(16)+ g.toString(16)+ b.toString(16)+ b.toString(16);
	    col.style.border = "solid";
	    col.style.borderWidth = "1px";
	    col.style.borderColor = "#222222";
	    col.onmouseover = function () {this.style.borderColor = "#ffffff"}
	    col.onmouseout  = function () {this.style.borderColor = "#222222"}
	    col.onmousedown = function ()
	      {
		handler(this);
	      }

	    td.appendChild(col);
	    tr.appendChild(td);
	    columns++;
	  }
	}
      }
      return table;
}

function ForeColorMenu(editor)
{
  var myObj = this;

  this.parent = SubMenu;  
  this.parent(editor);	// Call super class's constructor

  this.createMenu = function ()
    {
      this.setTitle("文字色の指定")

      var menu = document.createElement("div");
      menu.innerHTML =
        "文字の色を選択してください。<br>";

      menu.appendChild(createColorTable(this.onExec));

      menu.appendChild(this.close_btn);
      return menu;
    }

  this.onExec = function (div)
    {
      var color = div.style.backgroundColor.replace("rgb(", "").replace(")", "").replace(/ /g, "");
      var rgb = color.split(",");
      rgb[0] = parseInt(rgb[0]).toString(16);
      rgb[1] = parseInt(rgb[1]).toString(16);
      rgb[2] = parseInt(rgb[2]).toString(16);
      var setColor = "#"+rgb[0]+rgb[1]+rgb[2];
      myObj.editor.forecolor(setColor);
    }

  // Menuの中身を作成
  this.menuobj.appendChild(this.createMenu());
}

function BackColorMenu(editor)
{
  var myObj = this;

  this.parent = SubMenu;  
  this.parent(editor);	// Call super class's constructor

  this.createMenu = function ()
    {
      this.setTitle("背景色の指定")

      var menu = document.createElement("div");
      menu.innerHTML =
        "背景の色を選択してください。<br>";

      var myObj = this;
      menu.appendChild(createColorTable(this.onExec));

      menu.appendChild(this.close_btn);
      return menu;
    }

  this.onExec = function (div)
    {
      myObj.editor.backcolor(div.style.backgroundColor);
    }

  // Menuの中身を作成
  this.menuobj.appendChild(this.createMenu());
}

//////////////
////event

function Event(eve)
{
  this.type  = null;
  this.which = null;
  this.pageX = null;
  this.pageY = null;

  if (document.all) {
    this.type  = eve.type;
    this.which = eve.button;
    this.pageX = eve.clientX;
    this.pageY = eve.clientY;
  } else {
    this.type  = eve.type;
    this.which = eve.which;
    this.pageX = eve.pageX;
    this.pageY = eve.pageY;
  }
}

//////////////
////httpreq

function sendRequest(url, data, callback) {
  var req = false;
  var type_formdata = true;

  if(window.ActiveXObject){
    // IE
    try {
      req = new ActiveXObject("Msxml2.XMLHTTP") ;
    } catch (e) {
      try {
	req = new ActiveXObject("Microsoft.XMLHTTP") ;
      } catch (e2) {
	req = false;
      }
    }
  }
  if(window.XMLHttpRequest) {
    try {
      req = new XMLHttpRequest();
    } catch(e) {
      req = false;
    }
  }
  if(req) {
    req.onreadystatechange = function () {callback(req);}
    req.open("POST", url, true);
    // content-typeを設定
    // これをやらないと、受信側のPHPで$_POST[]で読めない。
    if (type_formdata) {
      boundary = "-----hoge";
      req.setRequestHeader("content-type",
			   "multipart/form-data; boundary="+boundary);

      var senddata = "";
      for (name in data) {
	senddata += "--"+boundary+"\r\n"+
	  "Content-Disposition: form-data; name=\""+name+"\"\r\n\r\n"+
	  data[name]+"\r\n";
      }
      senddata += "--"+boundary+"--\r\n";
      req.send(senddata);		// Sending Request
    } else {
      req.setRequestHeader("content-type",
			   "application/x-www-form-urlencoded;charset=UTF-8");

      var senddata = "";
      for (name in data) {
	if (senddata != "")
	  senddata += "&";
	senddata += name+"="+escape(data[name]);
      }
      req.send(senddata);		// Sending Request
    }
  }
}