// function PrintElem(elem,title)
// {
//     Popup($(elem).html(),title);
// }
//
// function Popup(data,title) 
// {
//     var mywindow = window.open('',title, 'height=400,width=600');
//     mywindow.document.write('<html><head><title>'+title+'</title>');
//     mywindow.document.write('</head><body >');
//     mywindow.document.write(data);
//     mywindow.document.write('</body></html>');
//     mywindow.print();
//     mywindow.close();
//     return true;
// }
 
// function changeFont(multiplier) {
//	if (multiplier==0){
//		jQuery('#detail_content_middle').find("span,p,div,strong").css('font-size','13px');
//	}else{
// 		var font_size_ht = parseFloat(jQuery('#detail_content_middle').find("span,p,div").css('font-size'));
// 		font_size_ht = font_size_ht +  (multiplier * 2);
// 		jQuery('#detail_content_middle').find("span,p,div,strong").css('font-size',font_size_ht+'px');
//	}
//}
 
//function submitSearch(){
//	var s = document.getElementById("s").value;
//	if(s!=""){
//		document.frmSearch.submit();
//	}else{
//		alert("Vui lòng nhập nội dung tìm kiếm !");
//	}
//}
//
//function submitSearch1(){
//	var s = document.getElementById("s1").value;
//	var searchDM =document.getElementById("categoryId").value;
//	if(s!="" || categoryId !=""){
//		document.frmSearch1.submit();
//	}else{
//		alert("Vui lòng nhập nội dung tìm kiếm !");
//	}
//}