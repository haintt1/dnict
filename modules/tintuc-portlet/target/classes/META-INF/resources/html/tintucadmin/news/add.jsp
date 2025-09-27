
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
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
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-tagsinput/bootstrap-tagsinput.css"/>
<script src="<%=request.getContextPath() %>/js/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>
<meta charset="ISO-8859-1">
<title>Thêm mới tin tức</title>
</head>
<body>
<%
String tabDangtin = TinTucAdminField.value_tabdangtin;
String contents = ParamUtil.getString(request, "contents");
boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser = false;
//System.out.print(ParamUtil.getString(request, "theloai"))
%>
<portlet:actionURL name="saveNewsArticle" var="saveNewsArticleURL"></portlet:actionURL>
<!--<portlet:actionURL name="saveXuatban" var="saveXuatbanURL"></portlet:actionURL>-->
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/chondanhmuc.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/view.jsp"/>
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
							<aui:form name="frmAddNews" action="<%=saveNewsArticleURL%>"method="post" enctype="multipart/form-data" autocomplete="off">
								<aui:input type="hidden" name="id" />
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Tiêu đề</label>
											<aui:input name="title" label="" type="input">
												<aui:validator name="required" errorMessage="Tên tiêu đề không được đề trống !!!"></aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<%
											News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());											
											String isnoibat_checked = "";
											if(role.getRole_edit() == 1 || role.getRole_public() == 1){
										%>
										<td colspan="100" style="padding-bottom: 20px;">												
											<input id="isnoibat" class="check_isnoibat" name="<portlet:namespace/>isnoibat" type="checkbox" <%=isnoibat_checked%>> 
											<label class="control-label">Là tin nổi bật</label>
										</td>
										<%} %>
									</tr>
									<tr>
										<td colspan="100">
											<label class="control-label">Đường dẫn đến hình ảnh</label>
											<aui:input name="urlsmallimage" label="" type="input" value="" cssClass="linkimage">	
											</aui:input>
											<div class="small-img">
												<img alt="" src=""/>
											</div>
										</td>	
									</tr>
									<tr>
										<td colspan="100">
											<label class="control-label">Tóm tắt bài viết</label>
											<aui:input name="tomtat" label="" type="textarea" cssClass="">	
											</aui:input>
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
											<label class="control-label">Nội dung</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents" cssClass="scrollBar" resizable="true"  initMethod="initEditor"></liferay-ui:input-editor>
											<aui:input type="hidden" id="noiDungHidden" name="noiDung"></aui:input>
										</td>
									</tr>
									<tr>
										<td>
											<label class="control-label">Từ khóa</label>
												<input name="<portlet:namespace/>tuKhoa" type="text" id="tags" class="form-control"/>
										</td>
									</tr>
									<tr>
										<td>
											<div class="twocolumn1">											
												<aui:select name="soluonganh" label="Số lượng ảnh trong tin">
													<aui:option value="">--Chọn số lượng--</aui:option>
													<%
														for(int sl = 1; sl <= 20; sl++ ) {
													%>
													<aui:option value="<%=sl %>"><%=sl %></aui:option>
													<% } %>
												</aui:select>
											</div>
											<div class="twocolumn2">
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
											</div>
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
												<option value="0">--- Chọn Nguồn tin ---</option>
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
								</table>
								<div class="d-flex justify-content-center">
									<aui:button-row>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>	
										<aui:button type="button" name="preview" cssClass="btn btn-success" value="Xem trước" onClick="addAndPreview(event);"/>
										<% if(role.getRole_add() == 1) { %>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
		   									<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>																
										<% } else if(role.getRole_edit() == 1) { %>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>									
										<% } else if(role.getRole_public() == 1) { %>
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
											<aui:button type="submit" name="luuvaxuatban" value="Lưu và xuất bản" label=""></aui:button>
										<% } %> 	
										<aui:button href="<%=cancelURL.toString()%>" type="cancel" value="Quay lại"></aui:button>
										<a class="btn btn-primary" id="xemQuyTrinh" href="#">Xem tiến trình bài viết</a>				
									</aui:button-row>
								</div>
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
function <portlet:namespace />initEditor() {	    
    //document.getElementById('cke_1_contents').style.height  = "400px";
	//document.getElementsByTagName('iframe').style.maxHeight  = "400px";
}

function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}
$('#ngayxuatban').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	timepickerScrollbar:true
});

$('#ngayketthuc').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	timepickerScrollbar:true
});

$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
});
//CKEDITOR.config.toolbar_slimmed = "";
CKEDITOR.config.removeButtons = 'Source';
CKEDITOR.config.autoGrow_maxHeight = 500;

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

	
	var btnluu = $("#<portlet:namespace/>luu");
	btnluu.on('click',function(event){
    		setTypeAction("luu");
    		
  
    });
    
    var btnGuibientapvien = $("#<portlet:namespace/>guibientapvien");
	btnGuibientapvien.on('click',function(event){
    		setTypeAction("guibientapvien");
 
  
    });
    
    var btnLuuvatrinhpheduyet = $("#<portlet:namespace/>luuvatrinhpheduyet");
	btnLuuvatrinhpheduyet.on('click',function(event){
    		setTypeAction("luuvatrinhpheduyet");
 
  
    });
	
	var btnluuvaxuatban = $("#<portlet:namespace/>luuvaxuatban");
	btnluuvaxuatban.on('click',function(event){
    		setTypeAction("xuatban");
  
    });
});
</aui:script>
<script>
	function addAndPreview(event) {
	    event.preventDefault(); // Ngăn form submit ngay lập tức
	    var editorInstance = CKEDITOR.instances["<portlet:namespace />contents"];
	    if (editorInstance) {
	        var editorContent = editorInstance.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden").val(editorContent); // Gán vào input ẩn
	    }
	    var form = jQuery("form[name='<portlet:namespace />frmAddNews']");
	    var formData = new FormData(form[0]);
	
	    jQuery.ajax({
	        url: "<%=saveNewsArticleURL %>",
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


