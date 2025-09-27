<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.model.News_Activity"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
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
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chỉnh sửa tin video</title>
</head>
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
	#manhung {
    	width: 100%;
        box-sizing: border-box;
        overflow: hidden;
        resize: none; /* Ngăn người dùng thay đổi kích thước thủ công */
        height: 38px;
    }
</style>
<body>
<%
String tabDangtin = TinTucAdminField.value_tabdangtin;
String idnewsvideo = ParamUtil.getString(request, "id");
News_Article objNewsVideo = (News_Article) News_ArticleLocalServiceUtil.fetchNews_Article(Long.valueOf(idnewsvideo));
News_Activity objectActivity  = null;
String noidung = "";
String noidungfirst ="";
String noidunglast ="";
/* String check="";
String check_flipbook = ""; */
String tenbai 	 = ParamUtil.getString(request, "tenbai");
String dinhdanh  = ParamUtil.getString(request, "dinhdanh");
String chuyenmuc = ParamUtil.getString(request, "chuyenmuc");
String theloaibaiviet = ParamUtil.getString(request, "theloaibaiviet","-1");
String tacgia = ParamUtil.getString(request, "tacgia","0");
String userdangbai    = ParamUtil.getString(request, "userdangbai","-1");
String search_check   = ParamUtil.getString(request, "search_check");
String searchStatus   = ParamUtil.getString(request, "trangthai");

tenbai = HtmlUtil.unescape(objNewsVideo.getTitle());

boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser  = false;
if(objNewsVideo.getContent() != null){
		noidung  = objNewsVideo.getContent();
		Document doc 	= Jsoup.parse(noidung);
		Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
		
		Element contentDivtwo = doc.select("div[class=contentlast]").first();
		if(Validator.isNotNull(contentDiv)){
			noidungfirst = contentDiv.html();	
		}
		if(Validator.isNotNull(contentDivtwo)){
			noidunglast  = contentDivtwo.html();								
		}
		checkYeucauHieuChinh = TinTucAdminUtil.checkYeuCauHieuChinhByUserIdAnd(themeDisplay.getUserId(), objNewsVideo.getId());
		checkCategoryOfUser  = TinTucAdminUtil.checkCategoryOfUser(themeDisplay.getUserId(), objNewsVideo.getId());
		objectActivity 		 = TinTucAdminUtil.getNewAtivityById(themeDisplay.getUserId(), objNewsVideo.getId());
}
%>
<liferay-ui:success key="delete-successfully" message="Xoá thành công!"/>
<liferay-ui:success key="update-successfully" message="Lưu thành công!"/>
<portlet:actionURL name="updateNewsArticleVideo" var="updateNewsArticleVideoURL">
</portlet:actionURL>
<!--<portlet:actionURL name="saveXuatBan" var="saveXuatBanURL">-->

</portlet:actionURL>
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNewsVideo.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/chondanhmucedit.jsp" />
</portlet:renderURL>

<portlet:renderURL var="yeucauhieuchinhURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNewsVideo.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/yeucauhieuchinh.jsp" />
</portlet:renderURL>

<portlet:renderURL var="xemQuyTrinhURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNewsVideo.getId()) %>" />
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
							<aui:form name="frmAddNewsVideo" action="<%=updateNewsArticleVideoURL.toString() %>"method="post" enctype="multipart/form-data" autocomplete="off">
								<%
								if(objNewsVideo.getStatus() == 5){
								%>
								<h4 class="title-pm">Bài viết này đã được yêu cầu hiệu chỉnh</h4>
								<%if(objectActivity!= null){ %>
									<div class="row-fluid">
										<img style="width: 25px; float: left" alt="" src="<%=request.getContextPath()+"/images/noticeArticle.png"%>">
										<p style="color: red; margin-left: 30px;"><%=objectActivity.getContentrequest()%></p>
									</div>
									<%} %>
								<%}else { %>
								<h3 class="title-pm">Đăng tin, bài viết</h3>
								<%} %>
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Tiêu đề</label>
											<aui:input type="hidden" name="id" value="<%=objNewsVideo.getId() %>"/>
											<aui:input name="title" label="" value="<%=tenbai %>" type="input">
												<aui:validator name="required"></aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<%
											News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());	
											String isnoibat_checked = "";
											if(objNewsVideo.getIsnoibat() == 1){
												isnoibat_checked = "checked";
											}
											
										%>
										<td colspan="100">
											<input id="isnoibat" class="check_isnoibat" name="<portlet:namespace/>isnoibat" type="checkbox" <%=isnoibat_checked%>> 
											<label class="control-label">Là tin nổi bật</label>
												
										</td>
									</tr>
									<!--  
									<tr>
										<%
											String check = "";
											String check_flipbook = "";
											if(objNewsVideo.getLoaitintuc() == 1 ){
												check = "checked";
											}
											if(objNewsVideo.getLoaitintuc() == 3){
												check_flipbook =  "checked";
											}else{
												check_flipbook = "";
											}
										
										%>
										<td colspan="100">	
												<div class="form-group-pm" style="padding-bottom: 15px;">
													<input id="flipbook" class="check_flipbook"  name="<portlet:namespace/>flipbook" type="checkbox" <%=check_flipbook%>> </input><label class="flipbook" style="display: initial;" for="flipbook">Đăng tin PDF dạng lật sách</label>
											</div>
										</td>
									</tr>
									-->
									<tr>
										<td colspan="100">
											<label class="control-label">Đường dẫn đến hình ảnh</label>
											<aui:input name="urlsmallimage" value="<%=objNewsVideo.getUrlimagesmall() %>" label="" type="input" cssClass="linkimage">	
											</aui:input>
										</td>	
									</tr>
									<tr>
										<td colspan="100">
											<label class="control-label">Tóm tắt bài viết</label>
											<aui:input name="tomtat" value="<%=objNewsVideo.getInfo() %>" label="" type="textarea" cssClass="">	
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
													List<News_Article2Category> listart2Cat = TinTucAdminUtil.getListArticle2CategoryByArticleId(objNewsVideo.getId());
													
													if(listart2Cat.size() > 0){
														String listname = "";
														for(int c = 0; c < listart2Cat.size(); c++){
															News_Categories cat = News_CategoriesLocalServiceUtil.fetchNews_Categories(listart2Cat.get(c).getNewcategoryId());
														
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
											<label class="control-label">Nội dung I</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents1" initMethod="initEditor"></liferay-ui:input-editor>
											<aui:input type="hidden" id="noiDungHidden1" name="noiDung1"></aui:input>
										</td>
									</tr>
									
									<%
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(objNewsVideo.getId(), 9);
									String  idvideo = "";
									String urlDomain="";
									if(listDinhkem.size() > 0){
									 	for(int i = 0; i< listDinhkem.size(); i++){
									 		idvideo = String.valueOf(listDinhkem.get(i).getId());
									 		/////////
									 		String duoiFile = listDinhkem.get(i).getTen();
									 		boolean isDuoiFile = duoiFile.contains(".");
									 		//////////
									 		String[] arStr = listDinhkem.get(i).getUrl().split("documents");
									 		if(arStr[0].toString().length()<3){
										 		urlDomain=themeDisplay.getPortalURL() + themeDisplay.getPathContext() + listDinhkem.get(i).getUrl();
									 		}else if (listDinhkem.get(i).getUrl().contains("https://")){
									 			urlDomain = listDinhkem.get(i).getUrl();
									 		} else {
									 			urlDomain = request.getContextPath() + "/html/tintucadmin/news/xemvideo.html?id="+listDinhkem.get(i).getId();
									 		}
									 		
									 		
									%>
											<portlet:actionURL name="deleteFileVideo" var="deleteFileVideoURL">
													<portlet:param name="id" value="<%=String.valueOf(listDinhkem.get(i).getId()) %>"/>
													<portlet:param name="idNews" value="<%=String.valueOf(objNewsVideo.getId()) %>"/>
													<portlet:param name="ten" value="<%=listDinhkem.get(i).getTen() %>"/>
											</portlet:actionURL>
											<tr>
												<td colspan="100">
													<label class="control-label">Tập tin đính kèm Video:</label>
													<div id="loading">
													<aui:input name="idfile" type="hidden" value="<%=listDinhkem.get(i).getId()%>"></aui:input>
													<aui:input name="idnews" type="hidden" value="<%=objNewsVideo.getId()%>"></aui:input>
													<aui:input name="flag" type="hidden" value="<%=request.getAttribute("flag")%>"></aui:input>
													<span class="filedinhkem" style="color: blue"><%=listDinhkem.get(i).getTen()%></span>
													- <a id="btndelete" href="javascript:void(0)" att-url="<%=deleteFileVideoURL %>" class="fa fa-delete"><img style="width: 14px;" alt="" src="<%= request.getContextPath()%>/images/delete.ico"/></a>
													<aui-spinner size="small"></aui-spinner>
													<!-- <a class="filedinhkem" href="<%= urlDomain%> " target="_blank"><%=listDinhkem.get(i).getTen()%></a>
													- <a id="btndelete" href="javascript:void(0)" att-url="<%=deleteFileVideoURL %>" class="fa fa-delete"><img style="width: 14px;" alt="" src="<%= request.getContextPath()%>/images/delete.ico"/></a>
													<aui-spinner size="small"></aui-spinner> -->
													</div>							
												</td>
											</tr>
											
									<%}}else{%>
									<tr>
										<td style="padding-top: 10px">
											<div class="twocolumn1">
												<input name="option" type="radio" value="uploadFile" onchange="toggleInput('upload')"> 
												<label class="control-label">Upload file từ máy</label>											
											</div>
											<div class="twocolumn2">
												<input name="option" type="radio" value="linkNhung" onchange="toggleInput('link')"> 
												<label class="control-label">Nhập link nhúng</label>										
											</div>
										</td>	
									</tr>
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">
											<div id="formInput">
												<label class="control-label">Tập tin đính kèm video</label>
												<input type="file" name="<portlet:namespace/>fileVideo" id="fileVideo" multiple="multiple" onchange="ValidateSingleInputVideo(this);"/>
											</div>
										</td>
										
									</tr>
							<%}%>
									<input type="hidden" name="<portlet:namespace/>videocheck" value="<%=idvideo%>"/>
								
									<tr>
										<td>
											<label class="control-label">Nội dung II</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="contents2" initMethod="initEditor"></liferay-ui:input-editor>
											<aui:input type="hidden" id="noiDungHidden2" name="noiDung2"></aui:input>
										</td>
									</tr>
									
									<tr>
										<td style="padding-top: 10px">
											<label class="control-label">Từ khóa</label>
											<input name="<portlet:namespace/>tuKhoa" value="<%=objNewsVideo.getTukhoa() %>" type="text" id="tags" class="form-control"/>
										</td>
									</tr>
									
									<tr>
										<td>
											<div class="twocolumn1">											
												<aui:select name="soluonganh" label="Số lượng ảnh trong tin">
													<aui:option value="">--Chọn số lượng--</aui:option>
													<%
													for(int sl = 1; sl <= 20; sl++ ) {
													    int sotinanh = objNewsVideo.getSotinanh();
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
										     					if(objNewsVideo.getTypeid() == objType.get(s).getId()){
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
											<input name='<portlet:namespace/>ngayxuatban' id="ngayxuatban" value="<%=df.format(objNewsVideo.getNgayxuatban())  %>"  type="text" class="form-control"></input>	
										</div>
										<div class="twocolumn2">					
											<label class="control-label">Ngày kết thúc</label>
											<input name='<portlet:namespace/>ngayketthuc' id="ngayketthuc" 
										       value="<%= (objNewsVideo.getNgayketthuc() != null) ? df.format(objNewsVideo.getNgayketthuc()) : "" %>" 
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
									     					if(objNewsVideo.getNguontin() == objTacGia.get(s).getId()){
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
											<input name='<portlet:namespace/>congtacvien' id="congtacvien"  value="<%=objNewsVideo.getCongtacvien() %>" type="text" class="form-control"></input>											
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
												if(objNewsVideo.getIsformbinhluan() == 1){
													isformbinhluan_checked = "checked";															
												}
												if(objNewsVideo.getIsviewbinhluan() == 1){
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
										if(objNewsVideo.getStatus() != 5){ 
											if(role.getRole_add() == 1){
												if(objNewsVideo.getStatus() == 0){
													
									%>				
													<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
	    											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>
									<%				
												}
											}else if(role.getRole_edit() == 1){	
									%>			
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu bài viết" label=""></aui:button>
												<%if(objNewsVideo.getId() != 0){
														if(objNewsVideo.getStatus() == 1){
												%>
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>
					    						<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
												<%												
														}
													//}												
													
												} %>
											<%			
											}
											
											
											else if(role.getRole_public() == 1){
											%>
											
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinh" value="Lưu bài viết" label=""></aui:button>
												<a class="btn btn-primary" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a> 
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="pheduyet" value="Xuất bản" label=""></aui:button>
											
											<%	
											}
											%>
																													
																					
									<%	}else{
										if(checkYeucauHieuChinh){											
									%>
										<aui:button cssClass="btn-pm btn-submit-pm" name="luuhieuchinh" value="Lưu hiệu chỉnh" label=""></aui:button>
											<%
								    		if(role.getRole_edit()==1){
								    		%>
 -->  												<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
 	    											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhxuatban" value="Lưu hiệu chỉnh và trình xuất bản" label=""></aui:button>
													  
								    		<%}else if(role.getRole_add()==1){ %>
								    			<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhpheduyet" value="Lưu hiệu chỉnh và trình phê duyệt" label=""></aui:button>
								    		<%} %>
										<%} %>
									<%} %>
										<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>
										<a class="btn btn-primary" id="xemQuyTrinh">Xem tiến trình bài viết</a>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
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
<script>
$(document).ready(function(){
	 $('.delete-buton').on('click', function () {
		 var href = $(this).attr('data');
       window.b = $.confirm({
      	    title: 'Xóa dữ liệu !!!',
      	    content: 'Khi xóa sẽ không khôi phục lại dữ liệu được. Bạn có chắc chắn không !!!',
      	    confirmButtonClass: 'btn-info',
      	    cancelButtonClass: 'btn-danger',
      	    confirm: function(){
      	        location.href = href;
      	        
      	    },
      	});
   });
});

</script>
<script type="text/javascript">
function <portlet:namespace />initEditor(){
    return "<%=UnicodeFormatter.toString(noidungfirst)%>";
}
function <portlet:namespace />initEditorLast(){
    return "<%=UnicodeFormatter.toString(noidunglast)%>";
}

function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}

function ValidateSingleInputVideo(oInput) {
	const _validFileExtensionsVideo = ["mp4"];
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
        	 const extensionVideo = sFileName.substring(sFileName.lastIndexOf('.') + 1).toLowerCase()
        	 let blnValids = _validFileExtensionsVideo.includes(extensionVideo)            
        	 if (!blnValids) {
                 alert("Xin lỗi, " + sFileName + " bị lỗi, tập tin phải là : " + _validFileExtensionsVideo);
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
	        uri: '<%=checkchuyenmucURL.toString()%>'
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
    
    var btnPheduyet = $("#<portlet:namespace/>pheduyet");
	btnPheduyet.on('click',function(event){
    		setTypeAction("pheduyet");
    });
    
    var btnLuuHieuChinhPheDuyet = $("#<portlet:namespace/>luuhieuchinhpheduyet");
	btnLuuHieuChinhPheDuyet.on('click',function(event){
    		setTypeAction("luuhieuchinhpheduyet");
    });
    
    var btnLuuHieuChinhXuatBan = $("#<portlet:namespace/>luuhieuchinhxuatban");
	btnLuuHieuChinhXuatBan.on('click',function(event){
    		setTypeAction("luuhieuchinhxuatban");
    });
	

});

</aui:script>
<aui:script>
$('#btndelete').click(function(){
	var A = AUI();
	
	var url = $(this).attr('att-url')
	AUI().use('aui-io-request','aui-loading-mask-deprecated', function(A){
		var loadingMask = new A.LoadingMask({
				'strings.loading' : 'This is my custom loading message',
				target : A.getBody()
		});
		loadingMask.show();	
		alert("Xóa file đính kèm. Hệ thống sẽ hiển thị thông báo nếu xóa thành công");
		A.io.request(
	    url,
	      {
	        on: {  
	          success: function() {
	          		loadingMask.hide();
	          		alert("Xóa thành công");
	          		Liferay.Util.getOpener().<portlet:namespace/>refreshPortlet();
	          }
	        }
	      }
	    )
	});
});
</aui:script>
<script>
	//Tự động auto size textarea
	function autoResizeTextarea(id) {
		var $textarea = $('#' + id);
		if ($textarea.length) {
			$textarea.on('input', function () {
				$(this).css('height', 'auto');
				$(this).css('height', this.scrollHeight + 'px');
			});
		}
	}
	function toggleInput(option) {
		var formInput = document.getElementById('formInput');
		formInput.innerHTML = '';
	    // Thay đổi nội dung dựa trên lựa chọn
        if (option === 'link') {
            formInput.innerHTML = `
            	<label>Nhập mã nhúng hoặc đường dẫn</label>
            	<textarea name="<portlet:namespace/>linkVideo" rows="1" id="manhung" class="form-control"></textarea>
            `;
            setTimeout(function() {
            	autoResizeTextarea('manhung');
            }, 0);
        } else if (option === 'upload') {
            formInput.innerHTML = `
                <label class="control-label">Tập tin đính kèm video</label>
				<input type="file" name="<portlet:namespace/>fileVideo" id="fileVideo" multiple="multiple" onchange="ValidateSingleInputVideo(this);"/>
            `;
        }
	}
</script>
<script>
	function updateAndPreview(event) {
	    event.preventDefault(); // Ngăn form submit ngay lập tức
		
	    var editorInstance1 = CKEDITOR.instances["<portlet:namespace />contents1"];
	    var editorInstance2 = CKEDITOR.instances["<portlet:namespace />contents2"];
	    if (editorInstance1 || editorInstance2 ) {
	        var editorContent1 = editorInstance1.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden1").val(editorContent1); // Gán vào input ẩn
	        var editorContent2 = editorInstance2.getData(); // Lấy nội dung từ CKEditor
	        jQuery("#<portlet:namespace />noiDungHidden2").val(editorContent2); // Gán vào input ẩn
	    }
	    
	    var form = jQuery("form[name='<portlet:namespace />frmAddNewsVideo']");
	    var formData = new FormData(form[0]);
	
	    jQuery.ajax({
	        url: "<%=updateNewsArticleVideoURL %>",
	        type: "POST",
	        data: formData,
	        processData: false,
	        contentType: false,
	        dataType: "json", // Đảm bảo jQuery mong đợi JSON
	        success: function(data) {
	            if (data) {
	            	window.open("/preview-news?dinhdanh=" + data.id, "_blank");
	            	setTimeout(function() {
	            	    location.reload();
	            	}, 1000);
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
<style>
/* Center the loader */
#loader {
  position: absolute;
  left: 50%;
  top: 50%;
  z-index: 1;
  width: 120px;
  height: 120px;
  margin: -76px 0 0 -76px;
  border: 16px solid #f3f3f3;
  border-radius: 50%;
  border-top: 16px solid #3498db;
  -webkit-animation: spin 2s linear infinite;
  animation: spin 2s linear infinite;
}

@-webkit-keyframes spin {
  0% { -webkit-transform: rotate(0deg); }
  100% { -webkit-transform: rotate(360deg); }
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

/* Add animation to "page content" */
.animate-bottom {
  position: relative;
  -webkit-animation-name: animatebottom;
  -webkit-animation-duration: 1s;
  animation-name: animatebottom;
  animation-duration: 1s
}

@-webkit-keyframes animatebottom {
  from { bottom:-100px; opacity:0 } 
  to { bottom:0px; opacity:1 }
}

@keyframes animatebottom { 
  from{ bottom:-100px; opacity:0 } 
  to{ bottom:0; opacity:1 }
}

#myDiv {
  display: none;
  text-align: center;
}
</style>
</html>
