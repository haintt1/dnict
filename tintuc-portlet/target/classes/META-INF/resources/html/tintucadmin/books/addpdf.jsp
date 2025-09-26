
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="init.jsp" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Thêm mới sách</title>
</head>
<body>
<%
String contents = ParamUtil.getString(request, "contents");
//boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser = false;
String noidung = "";
String noidungfirst ="";
String noidunglast ="";
String check="";
String check_flipbook = "";
//System.out.print(contents);
%>
<portlet:actionURL name="saveBooksPDF" var="saveBooksPDFURL"></portlet:actionURL>
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/chondanhmuc.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/view.jsp" />
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
							<aui:form name="frmAddNews" action="<%=saveBooksPDFURL.toString()%>" method="post" enctype="multipart/form-data">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Tiêu đề sách</label>
											<aui:input name="title" label="" type="input">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">1000</aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
									
										<%
										
										if(check == "checked" ){
											 check = "5";
										}
										if(check_flipbook == "checked"){
											check_flipbook = "7";
										}
										//System.out.print(check + check_flipbook);
										%>
										
										<td colspan="100">
									<!-- 	<div class="form-group-pm">
												<input id="chukyso" class="check_chukyso"  name="<portlet:namespace/>loaitintuc" type="checkbox" <%=check%>> <label class="chukyso" style="display: initial;" for="chukyso">PDF ký số</label>
												</div> -->
												<div class="form-group-pm">
													<input id="flipbook" class="check_flipbook"  name="<portlet:namespace/>flipbook" type="checkbox" <%=check_flipbook%> > </input><label class="flipbook" style="display: initial;" for="flipbook">Đăng file dạng lật sách</label>
											</div>
										</td>
									</tr>
									<% String  idimage = ""; %>
									<tr>
										<td colspan="100" style="padding-top:10px">
											<label class="control-label">Ảnh đại diện của sách</label>
											<input type="file" name="<portlet:namespace/>fileimage" id="fileimage" onchange="ValidateImage(this);"/>
											<input type="hidden" name="<portlet:namespace/>imagecheck" value="<%=idimage%>"/>
											<div class="small-img">
												<img alt="" src=""/>
											</div>
										</td>	
									</tr>
									<tr>
										<td colspan="100">
										<div class="twocolumn1">
											<label class="control-label">Tác giả</label>
											<aui:input name="tacgia" label="" type="input"></aui:input>
										</div>
										<div class="twocolumn2">
											<label class="control-label">Nhà xuất bản</label>
											<aui:input name="xuatban" label="" type="input"></aui:input>
										</div>										
										</td>	
									</tr>
									
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">												
												<label for="danhmuc-multiple-selected">Danh mục sách</label>
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
											<label class="control-label">Giới thiệu về sách</label>
											<liferay-ui:input-editor toolbarSet="slimmed" editorImpl="editor.wysiwyg.default" name="noidung" initMethod="initEditor"></liferay-ui:input-editor>
										</td>
									</tr>
									<%									
										String  idpdf = "";
										String urlDomainPDF="";
									%> 
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">
										<label class="control-label">Đính kèm sách điện tử (file PDF)</label>
										<input type="file" name="<portlet:namespace/>filePDF" id="filePDF" multiple="multiple" onchange="ValidateSingleInputPDF(this);"/>
										</td>	
									</tr>									
									<input type="hidden" name="<portlet:namespace/>pdfcheck" value="<%=idpdf%>"/>
									<tr>
										<td>
											<label class="control-label">Giới thiệu thêm về sách</label>
											<liferay-ui:input-editor toolbarSet="slimmed" editorImpl="editor.wysiwyg.default" name="noidunglast" initMethod="initEditorLast"></liferay-ui:input-editor>
										</td>
									</tr> 
									<tr>
										<td>
										<div class="twocolumn1">											
												<label class="control-label">Thể loại</label>
												<select class="form-control"  id="theloai" name='<portlet:namespace/>theloai'>
												<option value="0">---Chọn thể loại---</option>
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
											
										</div>
										<div class="twocolumn2">					
											<label class="control-label">Ngày đăng</label>
											<input name='<portlet:namespace/>ngayxuatban' id="ngayxuatban"  type="text" class="form-control"></input>
											<!-- <input type="text" id="datepicker"></p> -->
										</div>
										</td>	
									</tr> 
									<tr>
										<td>
											<label class="control-label">Ngôn ngữ</label>
											<select class="form-control"  id="languages" name='<portlet:namespace/>languages'>
									     		<option value="vi_VN" <%=checkLangNews.equals("vi_VN")?"selected":""%>>Tiếng việt (Mặc định)</option>
									     		<option value="en_US" <%=checkLangNews.equals("en_US")?"selected":""%>>Tiếng Anh</option>
									  		</select>
											
										</td>	
									</tr>
									<tr>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
										<td colspan="2" class="key" style="text-align: center;">
											<aui:button type="submit" name="luu" value="Lưu nháp" label=""></aui:button>
											<aui:button type="submit" name="luuvaxuatban" value="Lưu và xuất bản" label=""></aui:button>
												
										<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>		
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
</html>
<style>
	.addhtml{background: }
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
function <portlet:namespace />initEditor(){
    return "<%=UnicodeFormatter.toString(noidungfirst)%>";
}
function <portlet:namespace />initEditorLast(){
    return "<%=UnicodeFormatter.toString(noidunglast)%>";
}
CKEDITOR.config.toolbar_slimmed = "";
CKEDITOR.config.removeButtons = 'Styles,Image,Video,cke_58,Audio';

function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}
$('#ngayxuatban').datetimepicker({
	formatTime:'H:i',
	//formatDate:'d.m.Y',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	//defaultDate:'+03.01.1970', // it's my birthday
	//defaultTime:'10:00',
	timepickerScrollbar:true
});

var _validFileExtensions = [".PDF", ".pdf"];
function ValidateSingleInputPDF(oInput) {
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
            var blnValid = true;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j];
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() != sCurExtension.toLowerCase()) {
                    blnValid = false;
                    break;
                }
            }
             
            if (!blnValid) {
                alert("File đính kèm chưa đúng định dạng, tập tin phải là : " + _validFileExtensions);
                oInput.value = "";
                return false;
            }
        }
    }
    return true;
}
/*
var _validFileExtensions = [".jpg", ".jpeg", ".bmp", ".gif", ".png", ".PNG", "JPG", ".JPEG", ".GIF", ".BMP"];
function ValidateImage(oInput) {
    if (oInput.type == "file") {
    	
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
            var blnValid = true;
            for (var j = 0; j < _validFileExtensions.length; j++) {
                var sCurExtension = _validFileExtensions[j]; 
                if (sFileName.substr(sFileName.length - sCurExtension.length, sCurExtension.length).toLowerCase() == sCurExtension.toLowerCase()) {
                    blnValid = false;
                    break;
                }
            }
             
            if (!blnValid) {
                alert("Ảnh chưa đúng định dạng, tập tin phải là : " + _validFileExtensions);
                oInput.value = "";
                return false;
            }
        }
    }
    return true;
}
*/
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
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
	
	var btnluu = $("#<portlet:namespace/>luu");
	btnluu.on('click',function(event){
    		setTypeAction("luu");
    		submitForm(document.frmAddNews);
  
    });
	var btnluuvaxuatban = $("#<portlet:namespace/>luuvaxuatban");
	btnluuvaxuatban.on('click',function(event){
    		setTypeAction("xuatban");
  
    });
});
</aui:script>

