var SelectAll = function(selobj,childobj){
	var arr = document.getElementsByName(childobj+"[]");
	for(var i=0;i<arr.length;i++){
		if(arr[i].getAttribute('readonly')==null){
			arr[i].checked = selobj.checked;
		}
	}
};

function SelectAllClassName(obj,klass){
	jQuery('.'+klass).prop('checked',jQuery(obj).is(':checked'));
}

function TestSelectOneCheck(objValue)
{
	var objradio = document.getElementsByName(objValue);
	var one_selected=false;
	for(var r=0;r < objradio.length;r++)
	{
	  if(objradio[r].checked)
	  {
	  	one_selected=true;
		break;
	  }
	}
	if(false == one_selected)
	{
			return false;
	}
    return true;
}

var Pagination = function($innerHtml,total,currentPage,totalPage,limit,portletNameSpace){
	  var arrLimit = [5,10,20,50,100];
	  var sel ="";
	  var html = "";
	  html += '<div id="pagination">';
	  html += '&nbsp;&nbsp; Tá»•ng cá»™ng: '+ total + ' káº¿t quáº£ &nbsp; Hiá»ƒn thá»‹ <select name="'+portletNameSpace+'limit" id="limit" style="width:65px;margin-top: 5px;">';
	  for ( var j = 0; j < arrLimit.length; j++) {
		    if(parseInt(arrLimit[j])==limit)
		    	sel ="selected";
		    else
		    	sel = "";
			html += '<option value="'+arrLimit[j]+'" '+sel+'>'+arrLimit[j]+'</option>';
	  }
	  html += '</select>';
	  
	  html += '&nbsp;Trang <select name="'+portletNameSpace+'currentPage" id="currentPage" style="width:65px;margin-top: 5px;">';
	  for(var k=1; k<=totalPage; k++){
	  		if(parseInt(k)==parseInt(currentPage))
		    	sel ="selected";
		    else
		    	sel = "";
	  		html +='<option value="'+k+'" '+sel+' >'+k+'</option>';
	  }		
	  html +='</select>';
	  html +='&nbsp; cá»§a '+totalPage+' <span class="page-links">';
	  if(currentPage>1){
		html += '<a href="#" onclick="return false;" class="navigator page-link first" title="1">Ä�áº§u</a>';
	    html += '<a href="#" onclick="return false;" class="navigator page-link prev" title="'+(parseInt(currentPage)-1)+'">TrÆ°á»›c</a>';
	  }else{
		html += '<a href="#" onclick="return false;" class="page-link first disabled">Ä�áº§u</a>';
		html += '<a href="#" onclick="return false;" class="page-link prev disabled">TrÆ°á»›c</a>';
	  }
	  if(parseInt(currentPage)<parseInt(totalPage)){
		html += '<a href="#" onclick="return false;" class="navigator page-link next" title="'+(parseInt(currentPage)+1)+'">Tiáº¿p</a>';
		html += '<a href="#" onclick="return false;" class="navigator page-link last" title="'+(totalPage)+'">Cuá»‘i</a>';
	  }else{
		html += '<a href="#" onclick="return false;" class="page-link next disabled">Tiáº¿p</a>';
		html += '<a href="#" onclick="return false;" class="page-link last disabled">Cuá»‘i</a>';
	  }
	  html += '</span>';
	  html += '</div>';
	  $innerHtml.empty().append(html);
};

var PaginationPopup = function($innerHtml,total,currentPage,totalPage,limit,portletNameSpace){
	  var arrLimit = [5,10,20,50,100];
	  var sel ="";
	  var html = "";
	  html += '<div id="pagination">';
	  html += '&nbsp;&nbsp; Tá»•ng cá»™ng: '+ total + ' káº¿t quáº£ &nbsp; Hiá»ƒn thá»‹ <select name="'+portletNameSpace+'limitpopup" id="limitpopup" style="width:65px;margin-top: 5px;">';
	  for ( var j = 0; j < arrLimit.length; j++) {
		    if(parseInt(arrLimit[j])==limit)
		    	sel ="selected";
		    else
		    	sel = "";
			html += '<option value="'+arrLimit[j]+'" '+sel+'>'+arrLimit[j]+'</option>';
	  }
	  html += '</select>';
	  
	  html += '&nbsp;Trang <select name="'+portletNameSpace+'currentPagepopup" id="currentPagepopup" style="width:65px;margin-top: 5px;">';
	  for(var k=1; k<=totalPage; k++){
	  		if(parseInt(k)==parseInt(currentPage))
		    	sel ="selected";
		    else
		    	sel = "";
	  		html +='<option value="'+k+'" '+sel+' >'+k+'</option>';
	  }		
	  html +='</select>';
	  html +='&nbsp; cá»§a '+totalPage+' <span class="page-links">';
	  if(currentPage>1){
		html += '<a href="#" onclick="return false;" class="navigatorpopup page-link first" title="1">Ä�áº§u</a>';
	    html += '<a href="#" onclick="return false;" class="navigatorpopup page-link prev" title="'+(parseInt(currentPage)-1)+'">TrÆ°á»›c</a>';
	  }else{
		html += '<a href="#" onclick="return false;" class="page-link first disabled">Ä�áº§u</a>';
		html += '<a href="#" onclick="return false;" class="page-link prev disabled">TrÆ°á»›c</a>';
	  }
	  if(parseInt(currentPage)<parseInt(totalPage)){
		html += '<a href="#" onclick="return false;" class="navigatorpopup page-link next" title="'+(parseInt(currentPage)+1)+'">Tiáº¿p</a>';
		html += '<a href="#" onclick="return false;" class="navigatorpopup page-link last" title="'+(totalPage)+'">Cuá»‘i</a>';
	  }else{
		html += '<a href="#" onclick="return false;" class="page-link next disabled">Tiáº¿p</a>';
		html += '<a href="#" onclick="return false;" class="page-link last disabled">Cuá»‘i</a>';
	  }
	  html += '</span>';
	  html += '</div>';
	  $innerHtml.empty().append(html);
};
var hoverMessage = function($htmlMessage) {
	$htmlMessage.hover(function(){
		$htmlMessage.html('');
	});
};
var errorMessage = function(xhr) {
	var strMsg = "Ä�Ã£ xáº£y ra lá»—i: "+xhr.status+" "+xhr.statusText;
	$error(strMsg);
};
var $error = function(msg){
	$.gritter.add({
		title: 'Lá»—i',
		text: msg,
		class_name: 'gritter-error gritter-light gritter-center'
	});
};
var $success = function(msg){
	$.gritter.add({
		title: "ThÃ´ng bÃ¡o",
		text: '<i class="icon-ok"></i> '+msg,
		class_name: 'gritter-success gritter-light'
	});
};
var $alert = function(title,msg){
	$.gritter.add({
		title: title,
		text: msg,
		class_name: 'gritter-error gritter-light'
	});
};


$(document).ready(function(){
	
	function getTopDeclStr()
	{
	    var retStr= ''
	    , dt = document.doctype
	    , htmlStr = document.documentElement.outerHTML;
	    
	    if (dt) {
	        
	        retStr += '<!DOCTYPE';
	        
	        if (dt.name.length) {
	            retStr += ' ' + dt.name;
	        }
	        
	        if (dt.publicId.length) {
	            retStr += ' PUBLIC "' + dt.publicId + '"';
	        }
	        
	        if (dt.systemId.length) {
	            retStr += ' "' + dt.systemId + '"';
	        }
	        
	        retStr += '>';
	    }
		
		retStr += htmlStr.substring(0, htmlStr.indexOf("<head>"));
	    
	    return retStr;
	}
	
	$.fn.print = function print(cssURLArr, printDocReadyCallback, isLandspace) {
		var $srcDiv = this.eq(0)
		, newWin, newDoc, printed = false;
		
		newWin = open(
			'',
			'',
			'height=' + screen.height + ',' +
			'width='+ screen.width + ',', +
			'top=0,' +
			'resizable=no,' +
			'scrollbars=yes,' +
			'location=no,' +
			'status=no,' +
			'titlebar=no,' +
			'toolbar=no,' +
			'menubar=yes'
		);
		newDoc = newWin.document;
		newDoc.open();
		newDoc.write(getTopDeclStr());
		newDoc.write('<head>');
		newDoc.write('<meta http-equiv="Content-Type" content="text/html; charset=utf-8">');
		
		// XÃ³a ?v=Math.random() khi release sáº£n pháº©m
		for (var i = 0; i < cssURLArr.length; i++) {
			newDoc.write('<link type="text/css" rel="stylesheet" href="'
				+ cssURLArr[i] + '?v=' + Math.random() + '">');
		}
		newDoc.write('</head><body>');
		newDoc.write($srcDiv.html());
		newDoc.write('<div id="_hint" style="position: fixed; z-index:10000; width: 100%; top: 20%; padding: 20px 0 ; opacity: 0.9; filter: alpha(opacity=90); text-align: center; font-size: 50px; font-weight:bold; box-shadow: 0 0 3px #CCCCCC; -moz-box-shadow: 0 0 3px #CCCCCC; -webkit-box-shadow: 0 0 3px #CCCCCC; border: 1px solid #CCCCCC; background-color: #FAFFCD;">');
		newDoc.write('Báº¥m Ctrl + P Ä‘á»ƒ in');
		newDoc.write('</div>');
		newDoc.write('</body></html>');
		newDoc.close();
		
		if ($.isFunction(printDocReadyCallback)) {
			printDocReadyCallback.apply(newDoc)
		}
		
		$(newDoc.body)
			.bind('click keydown', function() {
				$(newDoc.getElementById('_hint')).remove();
			});
		
		if (Liferay.Browser.isChrome()) {
			$(newWin)
				.bind('keydown', function(ev) {
					printed = (ev.which === 80 && ev.ctrlKey);
				})
				.bind('focus', function() {
					if (printed) {
						newWin.close();
					}
				});
		} else {
			$(newWin).bind('keydown', function(ev) {
				if (ev.which === 80 && ev.ctrlKey) {
					setTimeout(
						function() {
							newWin.close();
						},
						5
					);
				}
			});
		}
			
		newDoc.body.style.display = 'block';
		newDoc.body.style.overflow = 'visible';
		newWin.focus();
	};
	
	$.fn.showLoading = function(flag) {
		if(flag){
			var html = '<div class="pleasewait" style="display: none;">';
			html +='<span style="top: 53%;left: 44%;position: absolute;text-align: center;">';
			html +='Ä�ang xá»­ lÃ½ dá»¯ liá»‡u...<br>Vui lÃ²ng chá»� trong giÃ¢y lÃ¡t !</span></div>';
			$(this.selector).append(html);
			$('.pleasewait').show();
		}else{
			$('.pleasewait').remove();
		}
	};
	
});
