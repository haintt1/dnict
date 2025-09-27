<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="com.liferay.calendar.model.Calendar"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="vn.dnict.tintuc.utils.DocumentUpload"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="vn.dnict.tintuc.model.News_AttachFile"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.datetimepicker.css"/>
<script src="<%=request.getContextPath() %>/js/jquery1.10.2.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.datetimepicker.full.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-tagsinput/bootstrap-tagsinput.css"/>
<script src="<%=request.getContextPath() %>/js/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>

<meta charset="ISO-8859-1">
<title>Thêm tin PDF</title>
</head>
<body>
<%
String currentURL = PortalUtil.getCurrentURL(request);
String tabDangtin = TinTucAdminField.value_tabdangtin;
String noidung = "";
String noidungfirst ="";
String noidunglast ="";
String check="";
String check_flipbook = "";
String tenbai 	 = ParamUtil.getString(request, "tenbai");
String dinhdanh  = ParamUtil.getString(request, "dinhdanh");
String chuyenmuc = ParamUtil.getString(request, "chuyenmuc");
String theloaibaiviet = ParamUtil.getString(request, "theloaibaiviet","-1");
String tacgia = ParamUtil.getString(request, "tacgia","0");
String userdangbai    = ParamUtil.getString(request, "userdangbai","-1");
String search_check   = ParamUtil.getString(request, "search_check");
String searchStatus   = ParamUtil.getString(request, "trangthai");
News_Article object = null;

boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser  = false;
if(Validator.isNotNull(request.getAttribute("tintucobject"))){
	object = (News_Article)request.getAttribute("tintucobject");
	//System.out.print(object);
		noidung  = object.getContent();
		Document doc 	= Jsoup.parse(noidung);
		Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
		Element contentDivtwo = doc.select("div[class=contentlast]").first();
		if(Validator.isNotNull(contentDiv)){
			noidungfirst = contentDiv.html();								
		}
		if(Validator.isNotNull(contentDivtwo)){
			noidunglast  = contentDivtwo.html();								
		}
}
%>
<portlet:actionURL name="saveNewsArticlePDF" var="saveNewsArticlePDFURL">
</portlet:actionURL>
<!--<portlet:actionURL name="saveXuatBan" var="saveXuatBanURL">
</portlet:actionURL>-->
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/chondanhmuc.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/view.jsp" />
	<portlet:param name="tabs" value="<%=tabDangtin %>"/>
</portlet:renderURL>

<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
							<aui:form name="frmAddNewsPDF" action="<%=saveNewsArticlePDFURL.toString() %>"method="post" enctype="multipart/form-data" autocomplete="off">
								<aui:input type="hidden" name="id" />
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Tiêu đề</label>
											<aui:input name="title" label="" type="input">
												<aui:validator name="required"></aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<%
											News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());
											if(role.getRole_edit() == 1 || role.getRole_public() ==1){
											String isnoibat_checked = "";
											if(isnoibat_checked == "check"){
												isnoibat_checked = "1";
											}else{
												isnoibat_checked = "0";			
											}
											
											
										%>
										<td colspan="100">
												<input id="isnoibat" class="check_isnoibat" name="<portlet:namespace/>isnoibat" type="checkbox" <%=isnoibat_checked%>> 
												<label class="control-label">Là tin nổi bật</label>												
										</td>
										<%} %>
									</tr>
									<!--  
									<tr>									
										<%										
										if(check == "checked" ){
											 check = "1";
										}
										if(check_flipbook == "checked"){
											check_flipbook = "3";
										}
										%>										
										<td colspan="100" style="padding-bottom: 15px;">									
											<div class="form-group-pm">
												<input id="flipbook" class="check_flipbook"  name="<portlet:namespace/>flipbook" type="checkbox" <%=check_flipbook%> />
												<label class="flipbook" style="display: initial;" for="flipbook">Đăng tin PDF dạng lật sách</label>
											</div>
										</td>
									</tr>
									-->
									<tr>
										<td colspan="100">
											<label class="control-label">Đường dẫn đến hình ảnh</label>
											<aui:input name="urlsmallimage" label="" cssClass="linkimage"></aui:input>
										</td>	
									</tr>
									<tr>
										<td colspan="100">
											<label class="control-label">Tóm tắt bài viết</label>
											<aui:input name="tomtat" label ="" type="textarea" cssClass=""></aui:input>
										</td>	
									</tr>
									
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">												
											<label for="danhmuc-multiple-selected">Danh mục tin tức</label>
											<a class="btn btn-primary" id="btnChuyenmuc"><i class="icon-plus"></i> Chọn danh mục</a>
											<span class="listdanhmuc">
												<%
												String data_category = "";
												String listname = "";
												%>
												<%=listname%>
											</span>
											<input class="data_category" type="hidden" name="<portlet:namespace/>danhmuc-selected" value="<%=data_category%>"/>
										</td>	
									</tr>
																		 
									<tr>
										<td>
											<label class="control-label">Nội dung I</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents1" initMethod="initEditor"></liferay-ui:input-editor>
											<aui:input type="hidden" id="noiDungHidden1" name="noiDung1"></aui:input>
										</td>
									</tr> 									 
									<%									
										String  idpdf = "";
										String urlDomain="";
									%>	
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">
											<label class="control-label">Tập tin đính kèm PDF</label>
											<input type="file" name="<portlet:namespace/>filePDF" id="filePDF" multiple="multiple" onchange="ValidateSingleInputPDF(this);"/>
										</td>	
									</tr>
									
									<input type="hidden" name="<portlet:namespace/>pdfcheck" value="<%=idpdf%>"/>
									
									<tr>
										<td>
											<label class="control-label">Nội dung II</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents2" initMethod="initEditorLast"></liferay-ui:input-editor>
											<aui:input type="hidden" id="noiDungHidden2" name="noiDung2"></aui:input>
										</td>
									</tr> 
									<tr>
										<td style="padding-top: 10px">
											<label class="control-label">Từ khóa</label>
											<input name="<portlet:namespace/>tuKhoa" type="text" id="tags" class="form-control"/>
										</td>
									</tr>
									<tr>
										<td>
											<label class="control-label">Thể loại bài viết</label>
											<select class="form-control"  id="theloai" name='<portlet:namespace/>theloai'>
												<option value="0">---Chọn Thể loại---</option>
									     		<%
									     			List<News_Type> objType = TinTucAdminUtil.listTheLoai("", 0, 0, 0); 
									     			if(objType.size() > 0){
									     				for(int s=0; s < objType.size(); s++){									     													     					
									     		%>
									     		<option value="<%=objType.get(s).getId()%>" ><%=objType.get(s).getName()%></option>
									     		<%
									     				}
									     			}
									     		%>
											</select>
										</td>	
									</tr> 
									<tr>
										<td>
										<div class="twocolumn1">											
											<label class="control-label">Ngày xuất bản</label>											
											<input name='<portlet:namespace/>ngayxuatban' id="ngayxuatban" type="text" class="form-control"></input>
										</div>
										<div class="twocolumn2">					
											<label class="control-label">Ngày kết thúc</label>											
											<input name='<portlet:namespace/>ngayketthuc' id="ngayketthuc" type="text" class="form-control"></input>
										</div>
										</td>	
									</tr> 
									<tr>
										<td>
										<div class="twocolumn1">											
												<label class="control-label">Nguồn tin</label>
												<select class="form-control"  id="tacgia" name='<portlet:namespace/>tacgia'>
												<option value="0">--- Chọn nguồn tin ---</option>
									     		<%
									     			List<News_NguonTin> objTacGia = TinTucAdminUtil.listTacGia("", 0, 0, 0); 
									     			if(objTacGia.size() > 0){
									     				for(int s=0; s < objTacGia.size(); s++){									     													     					
									     		%>
									     		<option value="<%=objTacGia.get(s).getId()%>" ><%=objTacGia.get(s).getName()%></option>
									     		<%
									     				}
									     			}
									     		%>
												</select>
											
										</div>
										<div class="twocolumn2">
											<label class="control-label">Tác giả</label>
											<input name='<portlet:namespace/>congtacvien' id="congtacvien"  type="text" class="form-control"></input>											
										</div>
										</td>	
									</tr>
									<!-- Thêm checkbox bình luận -->
									<tr colspan="100">
										<td>
										<div class="twocolumn1">
											<label class="control-label">Ngôn ngữ</label>
											<select class="form-control"  id="languages" name='<portlet:namespace/>languages'>
									     		<option value="vi_VN" <%=checkLangNews.equals("vi_VN")?"selected":""%>>Tiếng việt (Mặc định)</option>
									     		<option value="en_US" <%=checkLangNews.equals("en_US")?"selected":""%>>Tiếng Anh</option>
									     	</select>
									     </div>
									     <%
									     if(role.getRole_edit() == 1 || role.getRole_public() == 1){
									     String isformbinhluan_checked = "";
									     String isviewbinhluan_checked = "";
									     %>
									     <div class="twocolumn2">
									     	<div class="twocolumn1" style="margin-top: 32px;">
									     		<input id="isformbinhluan" class="check_isformbinhluan" name="<portlet:namespace/>isformbinhluan" type="checkbox" <%=isformbinhluan_checked%>> 
												<label class="control-label">Hiện ô nhập bình luận</label>
									     	</div>
									     	<div class="twocolumn2" style="margin-top: 32px;">
									     		<input id="isviewbinhluan" class="check_isviewbinhluan" name="<portlet:namespace/>isviewbinhluan" type="checkbox" <%=isviewbinhluan_checked%>> 
												<label class="control-label">Hiện dữ liệu bình luận</label>
									     	</div>
									     </div>
									     <%} %>
										</td>
									</tr>
									<tr>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
										<td colspan="2" class="key" style="text-align: center;">
										<aui:button type="button" name="preview" cssClass="btn btn-success" value="Xem trước" onClick="addAndPreview(event);"/>
										<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
									<%
										if(role.getRole_add() == 1){
									%>		
	    									<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>																
									<%
										}else if(role.getRole_edit() == 1){
									%>		
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>									
									<%		
										}else if(role.getRole_public() == 1){
									%>
											<aui:button type="submit" name="xuatban" value="Lưu và xuất bản" label=""></aui:button>
									<%
										}
									%> 			
										<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>
										<a class="btn btn-primary" id="xemQuyTrinh" href="#">Xem tiến trình bài viết</a>				
										</td>
									</tr>
									
								</table>
							</aui:form>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</nav>	
</body>
<style>
	.dropbtn{margin: 0; padding: 0}
	.dropdown-content{margin: 0; padding: 0;}
	
#languages {
    background-repeat: no-repeat;
    background-image: url("/o/vn.dnict.tintuc/images/flag/vi_VN.png");
    padding-right: 20px;
}
#languages option:nth-child(1) {
    background: url(/o/vn.dnict.tintuc/images/flag/vi_VN.png) no-repeat right center;  
}
#languages option:nth-child(2) {
    background: url(/o/vn.dnict.tintuc/images/flag/en_US.png) no-repeat right center;  
}
#languages option:nth-child(3) {
    background: url(/o/vn.dnict.tintuc/images/flag/ja_JP.png) no-repeat right center;  
}
#languages option:nth-child(4) {
    background: url(/o/vn.dnict.tintuc/images/flag/ko_KR.png) no-repeat right center;  
}
a.cke_combo_button{
margin: 0px !important;
padding: 0px !important;
padding-top: 8px !important;
    margin-left: 10px !important;
}
.twocolumn1{
	width: 50%;
	display: block;
	float: left;
	padding-right: 5px;
}
.twocolumn2{
	width: 50%;
	display: block;
	float: left;
	padding-left: 5px;
}
</style>
<script type="text/javascript">

function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}

function ValidateSingleInputPDF(oInput) {
	const _validFileExtensionsPdf = ["pdf"];
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
        	 const extensionPdf = sFileName.substring(sFileName.lastIndexOf('.') + 1).toLowerCase()
        	 let blnValids = _validFileExtensionsPdf.includes(extensionPdf)            
        	 if (!blnValids) {
                 alert("Xin lỗi, " + sFileName + " bị lỗi, tập tin phải là : " + _validFileExtensionsPdf);
                 oInput.value = "";
                 return false;
             }
        }
    }
    return true;
}

$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
});
$('#ngayxuatban').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y/m/d',
	timepickerScrollbar:true
});
$('#ngayketthuc').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	timepickerScrollbar:true
});
CKEDITOR.config.removeButtons = 'Source';
CKEDITOR.config.autoGrow_maxHeight = 200;

//Xử lý logic tags
$("#tags").tagsinput({
    // limit 5 tag
    maxTags: 5,
    // give tags same
    allowDuplicates: true,
    cancelConfirmKeysOnEmpty: false,
});

</script>

<aui:script position="inline">
$('#btnChuyenmuc').click(function(){
		Liferay.Util.openWindow(
			{
			dialog: {
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Chọn chuyên mục hiển thị',
	        uri: '<%= checkchuyenmucURL.toString()%>'
			});
	});
	
Liferay.provide(window, '<portlet:namespace/>refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },['aui-dialog','aui-dialog-iframe']);
    
Liferay.provide(window, '<portlet:namespace/>closePopup', function(dialogId) {
		var A = AUI();
		var dialog = Liferay.Util.Window.getById(dialogId);
			dialog.destroy();
	},['liferay-util-window']);	
	<!-- Truyen bien tu popup sang view chinh -->
Liferay.provide(window, 'listchonnhieudanhmuc', function(data, name) {
        $(".data_category").val(data);
        $(".listdanhmuc").html(name);
	},['liferay-util-window']);

AUI().ready('aui-form-validator', 'aui-overlay-context-panel','aui-node', function(A) {
	var validator2 = new A.FormValidator({
	        boundingBox: document.<portlet:namespace/>frmAddNewsPDF,
	        on: {
	            submitError: function(event) {
	                var formEvent = event.validator.formEvent;
	                var errors = event.validator.errors;
	            },
	
	            submit: function(event) {
	                var formEvent = event.validator.formEvent;
	            }
	        }
	});
});

</aui:script>
<aui:script>
    var btnluu = $("#<portlet:namespace/>luu");
	btnluu.on('click',function(event){
    		setTypeAction("luu");
    		
  
    });	
    
     var btnGuibientapvien = $("#<portlet:namespace/>guibientapvien");
	btnGuibientapvien.on('click',function(event){
    		setTypeAction("guibientapvien");
    		
  
    });
    
    var btnxuatban = $("#<portlet:namespace/>xuatban");
	btnxuatban.on('click',function(event){
    		setTypeAction("xuatban");
    });
    
    var btnLuuHieuChinh = $("#<portlet:namespace/>luuhieuchinh");
	btnLuuHieuChinh.on('click',function(event){
    		setTypeAction("luuhieuchinh");
    		
  
    });
    
    var btnLuuvatrinhpheduyet = $("#<portlet:namespace/>luuvatrinhpheduyet");
	btnLuuvatrinhpheduyet.on('click',function(event){
    		setTypeAction("luuvatrinhpheduyet");
    		
  
    });
</aui:script>
<script>
	function addAndPreview(event) {
	    event.preventDefault(); // Ngăn form submit ngay lập tức
	    var editorInstance1 = CKEDITOR.instances["<portlet:namespace />contents1"];
	    var editorInstance2 = CKEDITOR.instances["<portlet:namespace />contents2"];
	    if (editorInstance1 || editorInstance2 ) {
	        var editorContent1 = editorInstance1.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden1").val(editorContent1); // Gán vào input ẩn
	        var editorContent2 = editorInstance2.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden2").val(editorContent2); // Gán vào input ẩn
	    }
	    var form = jQuery("form[name='<portlet:namespace />frmAddNewsPDF']");
	    var formData = new FormData(form[0]);
	
	    jQuery.ajax({
	        url: "<%=saveNewsArticlePDFURL %>",
	        type: "POST",
	        data: formData,
	        processData: false,
	        contentType: false,
	        dataType: "json", // Đảm bảo jQuery mong đợi JSON
	        success: function(data) {
	            if (data) {
	            	jQuery("#<portlet:namespace />id").val(data.id);
	                window.open("/preview-news?dinhdanh=" + data.id, "_blank");
	            } else {
	                alert("Không thể xem trước, vui lòng thử lại!");
	            }
	        },
	        error: function(xhr, status, error) {
	            console.error("Lỗi khi lưu dữ liệu:", error);
	            console.log("Phản hồi lỗi:", xhr.responseText); // Kiểm tra response có phải HTML không
	        }
	    });
	}
</script>
</html>




