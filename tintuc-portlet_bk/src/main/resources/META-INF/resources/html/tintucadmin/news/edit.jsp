<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.model.News_Activity"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@ taglib prefix="liferay-editor" uri="http://liferay.com/tld/editor" %>
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

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String tabDangtin = TinTucAdminField.value_tabdangtin;
String noidungchitiet = "";
String tieude = "";
String theloaibaiviet = ParamUtil.getString(request, "theloai", "-1");
String tacgia = ParamUtil.getString(request, "tacgia", "0");
String id = ParamUtil.getString(request, "id");
News_Activity objectActivity  = null;
News_Article objNews = (News_Article) News_ArticleLocalServiceUtil.fetchNews_Article(Long.valueOf(id));
tieude = HtmlUtil.unescape(objNews.getTitle());
noidungchitiet = objNews.getContent();
//System.out.println(noidungchitiet);
boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser = false;
if(Validator.isNotNull(objNews)){
checkYeucauHieuChinh= TinTucAdminUtil.checkYeuCauHieuChinhByUserIdAnd(themeDisplay.getUserId(), objNews.getId());
//System.out.println(checkYeucauHieuChinh);

checkCategoryOfUser = TinTucAdminUtil.checkCategoryOfUser(themeDisplay.getUserId(), objNews.getId());
objectActivity 		= TinTucAdminUtil.getNewAtivityById(themeDisplay.getUserId(), objNews.getId());
}
//System.out.print(ParamUtil.getString(httpServletRequest, ""))
%>
<portlet:actionURL name="updateTintuc" var="updateTintucURL"></portlet:actionURL>
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNews.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/chondanhmucedit.jsp" />
</portlet:renderURL>
<portlet:renderURL var="yeucauhieuchinhURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNews.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/yeucauhieuchinh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="xemQuyTrinhURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNews.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/xemtientrinh.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/view.jsp" />
	<portlet:param name="tabs" value="<%=tabDangtin %>" />
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
							<aui:form name="frmAddNews" action="<%=updateTintucURL%>" method="post" enctype="multipart/form-data" autocomplete="off">
																<%
								if(objNews.getStatus() == 5){
								%>
								<h4 class="title-pm">Bài viết này đã được yêu cầu hiệu chỉnh</h4>
								<%if(objectActivity!= null){ %>
									<div class="row-fluid">
										<img style="width: 25px; float: left" alt="" src="<%=request.getContextPath()+"/images/noticeArticle.png"%>">
										<p style="color: red; margin-left: 30px;"><%=objectActivity.getContentrequest()%></p>
									</div>
									<%} %>
								<%}else { %>
								<h3 class="title-pm">Đăng tin, bài viết bt</h3>
								<%} %>
								
								<table class="tbcoreadmin" style="width: 100%">
									<div class="row-fluid" style="width: 100%; display: flex;">
										<div class="span7" style="width: 70%; margin-right: 10px;">
													<label class="control-label">Tiêu đề</label>
													<aui:input type="hidden" name="id" value="<%=objNews.getId() %>"/>
													<input type="hidden" name="<portlet:namespace/>idNews" value="<%=objNews.getId() %>"/>
													<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
													<aui:input name="title" value="<%=tieude %>" label="" type="input">
														<aui:validator name="required"></aui:validator>
													</aui:input>
													
															
													<%
														News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());	
													
														String isnoibat_checked = "";
														if(role.getRole_edit() == 1 || role.getRole_public() == 1){
															if(objNews.getIsnoibat() == 1){
																isnoibat_checked = "checked";
															
															}																							
													%>
																						
													<input id="isnoibat" <%=isnoibat_checked %> class="check_isnoibat" name="<portlet:namespace/>isnoibat" type="checkbox">
													<label class="control-label">Là tin nổi bật</label>
													<%}%>
													<div class="tinnoibat">
														<label class="control-label">Tóm tắt bài viết</label>
														<aui:input  name="mota" label="" type="textarea" value="<%=objNews.getInfo() %>" cssClass="mota">	
														</aui:input>
													</div>	
													
										</div>
										<div class="span5" style="width: 30%">
														<label class="control-label">Đường dẫn đến hình ảnh</label>
														<aui:input name="urlsmallimage" label="" type="input" value="<%=objNews.getUrlimagesmall()%>" cssClass="linkimage"></aui:input>
													<div  class="small-img" style="width: 100%; height: 189px;">
														<img style="width: 100%" alt="" src="<%=objNews.getUrlimagesmall()%>"/>
													</div>
										</div>
									</div>
									<div style="width: 70%">
																	
									
	
									</div>
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">
												
												<label for="danhmuc-multiple-selected">Danh mục tin tức</label>
												<a class="btn btn-primary" id="btnChuyenmuc"><i class="icon-plus"></i> Chọn danh mục</a>
												<span class="listdanhmuc">
													<%
													String data_category = "";
													News_Categories cats=null;
													List<News_Article2Category> listart2Cat = TinTucAdminUtil.getListArticle2CategoryByArticleId(objNews.getId());
													
													if(listart2Cat.size() > 0){
														String listname = "";
														for(int c = 0; c < listart2Cat.size(); c++){
															News_Categories cat = News_CategoriesLocalServiceUtil.fetchNews_Categories(listart2Cat.get(c).getNewcategoryId());
															if(Validator.isNull(cat)){
																cat = cats;
															}
															data_category = data_category+"_"+cat.getId();
															if(listname.equals("")){
																listname = listname+cat.getName();
															}else{
																listname = listname+", "+cat.getName();;
															}
														}%>
														<div style="background: rgba(179,225,249,0.47); padding: 10px;margin-top: 5px;">
														<%=listname%>
														</div>	
													<%}else{%>
														Chưa chọn chuyên mục
													<%}%>
												</span>
												<input class="data_category" type="hidden" name="<portlet:namespace/>danhmuc-selected" value="<%=data_category%>"/>
										</td>	
									</tr>
									 
									<tr>
										<td>
											<label class="control-label">Nội dung</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents" initMethod="initEditor"/>
											<aui:input type="hidden" id="noiDungHidden" name="noiDung"></aui:input>
										</td>
									</tr> 
									 
									<tr>
										<td style="padding-top: 10px">
											<label class="control-label">Từ khóa</label>
											<input name="<portlet:namespace/>tuKhoa" value="<%=objNews.getTukhoa() %>" type="text" id="tags" class="form-control"/>
										</td>
									</tr>
									<tr>
										<td>
											<div class="twocolumn1">											
												<aui:select name="soluonganh" label="Số lượng ảnh trong tin">
													<aui:option value="">--Chọn số lượng--</aui:option>
													<%
													for(int sl = 1; sl <= 20; sl++ ) {
													    int sotinanh = objNews.getSotinanh();
													    boolean isCheckSL = (sotinanh == sl);
													%>
													<aui:option value="<%=sl %>" selected="<%=isCheckSL %>"><%=sl %></aui:option>
													<% } %>
												</aui:select>
											</div>
											<div class="twocolumn2">
												<label class="control-label">Thể loại bài viết</label>
												<select class="form-control"  id="theloai" name='<portlet:namespace/>theloai'>
													<option value="-1">---Chọn thể loại---</option>
										     		<%
										     			List<News_Type> objType = TinTucAdminUtil.listTheLoai("", 0, 0, 0);
										     			if(objType.size() > 0){
										     				for(int s=0; s < objType.size(); s++){
										     					String selected = "";
										     					if(objNews.getTypeid() == objType.get(s).getId()){
										     						selected = "selected";
										     					}
										     		%>
										     		<option value="<%=objType.get(s).getId()%>" <%=selected %>><%=objType.get(s).getName()%></option>
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
											<%DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
											<input name='<portlet:namespace/>ngayxuatban' id="ngayxuatban" value="<%=df.format(objNews.getNgayxuatban())  %>"  type="text" class="form-control"></input>	
										</div>
										<div class="twocolumn2">					
											<label class="control-label">Ngày kết thúc</label>
											<input name='<portlet:namespace/>ngayketthuc' id="ngayketthuc" 
										       value="<%= (objNews.getNgayketthuc() != null) ? df.format(objNews.getNgayketthuc()) : "" %>" 
										       type="text" class="form-control">
										</div>
										</td>	
									</tr> 
									 
									<tr>
										<td>
										<div class="twocolumn1">											
												<label class="control-label">Nguồn tin</label>
												<select class="form-control"  id="tacgia" name='<portlet:namespace/>tacgia'>
												<option value="-1">--- Chọn Nguồn tin ---</option>
									     		<%
									     		List<News_NguonTin> objTacGia = TinTucAdminUtil.listTacGia("", 0, 0, 0); 
									     			if(objTacGia.size() > 0){
									     				for(int s=0; s < objTacGia.size(); s++){
									     					String selected = "";
									     					if(objNews.getNguontin() == objTacGia.get(s).getId()){
									     						selected = "selected";
									     					}
									     		%>
									     		<option value="<%=objTacGia.get(s).getId()%>" <%=selected %>><%=objTacGia.get(s).getName()%></option>
									     		<%
									     				}
									     			}
									     		%>
												</select>
											
										</div>
										<div class="twocolumn2">
											<label class="control-label">Tác giả</label>
											<input name='<portlet:namespace/>congtacvien' id="congtacvien"  value="<%=objNews.getCongtacvien() %>" type="text" class="form-control"></input>											
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
									     	String isformbinhluan_checked = "";
									     	String isviewbinhluan_checked = "";
											if(role.getRole_edit() == 1 || role.getRole_public() == 1){
												if(objNews.getIsformbinhluan() == 1){
													isformbinhluan_checked = "checked";															
												}
												if(objNews.getIsviewbinhluan() == 1){
													isviewbinhluan_checked = "checked";															
												}
									     %>
									     	<div class="twocolumn2">
									     		<div class="twocolumn1" style="margin-top: 32px;">
									     			<input id="isformbinhluan" <%=isformbinhluan_checked %> class="check_isformbinhluan" name="<portlet:namespace/>isformbinhluan" type="checkbox">
													<label class="control-label">Hiển thị form bình luận</label>
												</div>
												<div class="twocolumn2" style="margin-top: 32px;">
									     			<input id="isviewbinhluan" <%=isviewbinhluan_checked %> class="check_isviewbinhluan" name="<portlet:namespace/>isviewbinhluan" type="checkbox">
													<label class="control-label">Hiển thị dữ liệu bình luận</label>
												</div>
											</div>
										<%}%>
										</td>
									</tr>
									<tr style="margin-top: 5px !important;display: grid;">
										<td colspan="2" class="key" style="text-align: center; margin-top: 5px;">
										<aui:button type="button" name="preview" cssClass="btn btn-success" value="Xem trước" onClick="updateAndPreview(event);"/>
									<%
										if(objNews.getStatus() != 5){ 
											if(role.getRole_add() == 1){
												if(objNews.getStatus() == 0){
													
									%>				
													<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
	    											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>
									<%				
												}
											}else if(role.getRole_edit() == 1){	
									%>			
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
												<%if(objNews.getId() != 0){
														if(objNews.getStatus() == 1){
												%>
						
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>
					    						<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
					    						<%												
														}
													//}												
													
												} %>
											<%			
											}else if(role.getRole_public() == 1){
											%>
											
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinh" value="Lưu bài viết" label=""></aui:button>
												<a class="btn btn-primary" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a> 
													<aui:button cssClass="btn-pm btn-submit-pm" name="pheduyet" type="submit" value="Xuất bản" label=""></aui:button>
											<%	
											}
											%>
																													
																					
									<%	}else{
										if(checkYeucauHieuChinh){											
									%>
										<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinh" value="Lưu hiệu chỉnh" label=""></aui:button>
											<%
								    		if(role.getRole_edit()==1){
								    		%>
 												<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
 	    										<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhxuatban" value="Lưu hiệu chỉnh và trình xuất bản" label=""></aui:button>
													  
								    		<%}
								    		
								    		 if(role.getRole_add() == 1){ 
								    		%>
								    			<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhpheduyet" value="Lưu hiệu chỉnh và trình phê duyệt" label=""></aui:button>
								    		<%} %>
										<%} %>
									<%} %>
										<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>
										<a class="btn btn-primary" id="xemQuyTrinh" href="#xemtientrinh">Xem tiến trình bài viết</a>
										
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
#languages option:nth-child(3) {
    background: url(/o/vn.dnict.tintuc/images/flag/ja_JP.png) no-repeat right center;  
}
#languages option:nth-child(4) {
    background: url(/o/vn.dnict.tintuc/images/flag/ko_KR.png) no-repeat right center;  
}
.mota{height: 125px !important;}
.tinnoibat{
	margin-top: 15px !important;
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
    return "<%=UnicodeFormatter.toString(noidungchitiet) %>";
}
</script>
<script type="text/javascript">
function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}
</script>
<script type="text/javascript">
$('#ngayxuatban').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y/m/d',
	timepickerScrollbar:true
});
$('#ngayketthuc').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y/m/d',
	timepickerScrollbar:true
});
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
});
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
	
$('#btnyeucauhieuchinh').click(function(){
		setTypeAction("yeucauhieuchinh");
		Liferay.Util.openWindow(
			{
			dialog: {
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870,
	           on: {
                	success: function() { 
                        	window.location.reload();                   
                	}
               }
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Yêu cầu hiệu chỉnh bài viết',
	        uri: '<%= yeucauhieuchinhURL.toString()%>'
			});
	});	
	
$('#xemQuyTrinh').click(function(){
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
	        uri: '<%=xemQuyTrinhURL.toString()%>'
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

Liferay.provide(window, 'yeucauhieuchinh', function() {
		window.location.href = '<%=cancelURL%>'		
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
    
    var btnLuuHieuChinh = $("#<portlet:namespace/>luuhieuchinh");
	btnLuuHieuChinh.on('click',function(event){
    		setTypeAction("luuhieuchinh");
  
    });
    
    var btnLuuvatrinhpheduyet = $("#<portlet:namespace/>luuhieuchinhpheduyet");
	btnLuuvatrinhpheduyet.on('click',function(event){
    		setTypeAction("luuhieuchinhpheduyet");
  
    });
    
    var btnPheduyet = $("#<portlet:namespace/>pheduyet");
	btnPheduyet.on('click',function(event){
    		setTypeAction("xuatban");
    });
    
	var btnLuuvatrinhpheduyet = $('#<portlet:namespace/>luuvatrinhpheduyet');
	btnLuuvatrinhpheduyet.on('click',function(event){
    		setTypeAction("luuvatrinhpheduyet");
  
    });
    
    var btnLuuHieuChinhXuatBan = $("#<portlet:namespace/>luuhieuchinhxuatban");
	btnLuuHieuChinhXuatBan.on('click',function(event){
    		setTypeAction("luuhieuchinhxuatban");
  
    });    

	
var btnluuvaxuatban = $("#<portlet:namespace/>luuvaxuatban");
	btnluuvaxuatban.on('click',function(event){
    		setTypeAction("pheduyet");
    });
	

});
Liferay.on('form:registered', function(event) {
	window.validator<portlet:namespace /> = event.form.formValidator;});
</aui:script>
<script>
	function updateAndPreview(event) {
	    event.preventDefault(); // Ngăn form submit ngay lập tức
		
	    var editorInstance = CKEDITOR.instances["<portlet:namespace />contents"];
	    if (editorInstance) {
	        var editorContent = editorInstance.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden").val(editorContent); // Gán vào input ẩn
	    }
	    
	    var form = jQuery("form[name='<portlet:namespace />frmAddNews']");
	    var formData = new FormData(form[0]);
	
	    jQuery.ajax({
	        url: "<%=updateTintucURL %>",
	        type: "POST",
	        data: formData,
	        processData: false,
	        contentType: false,
	        dataType: "json", // Đảm bảo jQuery mong đợi JSON
	        success: function(data) {
	            if (data) {
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




