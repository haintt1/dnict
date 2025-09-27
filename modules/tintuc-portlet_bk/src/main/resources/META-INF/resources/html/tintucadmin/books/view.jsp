<%@page import="vn.dnict.tintuc.service.News_TypeLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/news.css" type="text/css"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-confirm.js"></script>

<title>Quản lý sách</title>
</head>
<style>
.jconfirm-box-container {

	max-width: 100% !important;
    flex: auto;
}
.title{
font-weight: bold;

}
.ten{
width: 15%;
}
</style>
<body>
<%

DateFormat dfs = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
String usdangbaicheck  = "";
String userdangbai    = ParamUtil.getString(request, "userdangbai","-1");
String ngaytao_tungay = "";
String ngaytao_denngay = "";
String ngayhieuchinh_tungay = "";
String ngayhieuchinh_denngay = ""; 
String search_check   = ParamUtil.getString(request, "search_check");

if(Validator.isNotNull(ParamUtil.getString(request, "ngaytao_tungay"))){
	ngaytao_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_tungay"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngaytao_denngay"))){
	ngaytao_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_denngay"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngayhieuchinh_tungay"))){
	ngayhieuchinh_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngayhieuchinh_tungay"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngayhieuchinh_denngay"))){
	ngayhieuchinh_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngayhieuchinh_denngay"));
}
String keyword = ParamUtil.getString(request,"title","");


String tenbai    = ParamUtil.getString(request, "tenbai");
String dinhdanh  = ParamUtil.getString(request, "dinhdanh");
String chuyenmuc = ParamUtil.getString(request, "categoriesId"); 

String trangthaitinbai = ParamUtil.getString(request, "trangthaitinbai"); 

//System.out.println("Trạng thái: "+trangthaitinbai);
String category = ParamUtil.getString(request, "chuyenmuc");
String status = ParamUtil.getString(request, "trangthai");
//String loaitintuc = ParamUtil.getString(request, "loaitintuc","4");

String theloaibaiviet = ParamUtil.getString(request, "theloaibaiviet", "-1");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/tintucadmin/books/view.jsp");
iteratorUrl.setParameter("tabs", "Đăng tin");
iteratorUrl.setParameter("trangthaitinbai", trangthaitinbai);
iteratorUrl.setParameter("search_check", search_check);
iteratorUrl.setParameter("tenbai",tenbai);
iteratorUrl.setParameter("ngaytao_tungay",ngaytao_tungay);
iteratorUrl.setParameter("ngaytao_denngay",ngaytao_denngay);
iteratorUrl.setParameter("ngayhieuchinh_tungay",ngayhieuchinh_tungay);
iteratorUrl.setParameter("ngayhieuchinh_denngay",ngayhieuchinh_denngay);
iteratorUrl.setParameter("dinhdanh",dinhdanh);
iteratorUrl.setParameter("chuyenmuc",chuyenmuc);
iteratorUrl.setParameter("userdangbai", userdangbai);
//iteratorUrl.setParameter("loaitintuc", loaitintuc);

int cur = ParamUtil.getInteger(request,"cur");
int delta = ParamUtil.getInteger(request, "delta",10);
int total= 0;
SearchContainer searchContainer = null;

if (cur > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, delta,
			iteratorUrl, null, null);
}
int stt = searchContainer.getStart() + 1;
int start = searchContainer.getStart();
int end = searchContainer.getEnd();


List<News_Article> listNews_Articles = TinTucAdminUtil.listSachAdmin(checkLangNews, usdangbaicheck, tenbai, dinhdanh, chuyenmuc, trangthaitinbai, theloaibaiviet, userdangbai, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, start, end);

total = (int) TinTucAdminUtil.listSachAdmin(checkLangNews, usdangbaicheck, tenbai, dinhdanh, chuyenmuc, trangthaitinbai, theloaibaiviet ,userdangbai, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, 0, 0).size();
searchContainer.setTotal(total);
searchContainer.setResults(listNews_Articles);
News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());

%>
<liferay-ui:success key="save-successfully" message="Chuyển trang thành công"></liferay-ui:success>
<portlet:renderURL var="addNewsURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addNewsPDFURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/addpdf.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchBaivietURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/view.jsp"/>
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
<div style="margin-bottom: 15px;">
<table class="table table-bordered" style="margin-top: 10px;">
	<tr>
		<!--<th style="width: 10%; color: black; vertical-align: inherit; text-align: center;">
		  Ngôn ngữ  
	</th>-->
	<td>
		    <portlet:actionURL var="langCheckNewsUrl_vn" name="langCheckNews">
				<portlet:param name="checklangnews" value="vi_VN"/>
				<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>"/>
			</portlet:actionURL>
			<portlet:actionURL var="langCheckNewsUrl_en" name="langCheckNews">
				<portlet:param name="checklangnews" value="en_US"/>
				<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>"/>
			</portlet:actionURL>
			<ul class="flag-search-ul" style="visibility: hidden;">
				<li class="flag-item">
					<a id="flag-vn" class="flag-item-a <%=checkLangNews.equals("vi_VN")?"active":""%>" href="<%=langCheckNewsUrl_vn.toString()%>">
						<img alt="" src="<%=request.getContextPath()+"/images/flag/vi_VN.png"%>" style="width: 50px; height: 30px; margin-bottom: 5px;">			
						<span class="btn-section">Tiếng Việt</span>
					</a>
				</li>	
				<li class="flag-item">
					<a id="flag-en" class="flag-item-a <%=checkLangNews.equals("en_US")?"active":""%>" href="<%=langCheckNewsUrl_en.toString()%>">
						<img alt="" src="<%=request.getContextPath()+"/images/flag/en_US.png"%>" style="width: 50px; height: 30px; margin-bottom: 5px;">				
						<span class="btn-section">Tiếng Anh</span>
					</a>
				</li>
			</ul>	
		</td>
			<td>
			<a style="float: right;" class="btn btn-primary" id="btnThemthuvien" href="<%=addNewsURL %>" ><i class="icon-plus"></i>Sách</a>	
			<a style="float: right;margin-right: 10px;" class="btn btn-primary" id="btnNewPDF" href="<%=addNewsPDFURL %>" ><i class="icon-plus"></i> Sách điện tử</a>
			
			</td>
	</tr>
</table>
</div>
<div>
	<aui:form action="<%=searchBaivietURL.toString() %>">
	<table class="table table-bordered" style="margin-top: 10px;">
		<tr>
			<th class="ten">Tên sách</th>
			<td><input name="<portlet:namespace/>tenbai" class="form-control" value="<%=tenbai%>" type="text"></input></td>
 			<th class="ten">Định danh</th>	
			<td><input name="<portlet:namespace/>dinhdanh" class="form-control" value="<%=dinhdanh%>" type="text"></input></td>
		</tr>
		<tr>
			<th class="ten">Danh mục</th>	
			<td>
				<select class="form-control" name='<portlet:namespace/>categoriesId'>
					<option value="0">--Chọn chuyên mục--</option>
					<%
						long idsubcat = 1;
						List<News_Categories> listCategory = TinTucAdminUtil.searchNewCategory("", 0,checkLangNews,idsubcat, 0, 0);
						if(chuyenmuc.equals("")){
							chuyenmuc = "0";
						}
						if(listCategory.size() > 0){
							for(int i=0;i<listCategory.size();i++){
								String selected ="";
								if(listCategory.get(i).getId() == Long.valueOf(chuyenmuc)){
									selected = "selected";
						
								}
					%>
						<option value="<%=listCategory.get(i).getId()%>" <%=selected %>><%=listCategory.get(i).getName()%></option>
					<%}}%>
				</select>
			</td>
			<th>Thể loại</th>	
			<td>
				<select class="form-control" name='<portlet:namespace/>theloaibaiviet'>
	     		<option value="-1">--Chọn thể loại--</option>
	     		<%
	     		List<News_Type> objType = TinTucAdminUtil.listTheLoai("", 0, 0, 0);
	     			//System.out.println(objType);
	     			if(objType.size()>0){
	     				for(int hh = 0; hh < objType.size(); hh++){
	     					String selected ="";
							if(objType.get(hh).getId() == Long.valueOf(theloaibaiviet)){
								selected = "selected";
							}
	     		%>
	     		<option value="<%=objType.get(hh).getId()%>" <%=selected%>><%=objType.get(hh).getName()%></option>
	     		<%
	     				}
	     			}
	     		%>
	     	</select>
			</td>
		</tr>
		 
		<tr>
			<th>User đăng tin</th>	
			<td>
				<select class="form-control" name="<portlet:namespace/>userdangbai">
		     		<option value="-1">--Chọn User đăng tin--</option>
		     		<%
		     			List<News_role> listrole2 = PhanQuyenAdminUtil.listPhanquyen();
		     			if(listrole2.size()>0){
		     				for(int a = 0; a < listrole2.size(); a++){
		     					User us = UserLocalServiceUtil.fetchUser(listrole2.get(a).getUserid());
		     					String selected ="";
		     					if(Validator.isNotNull(us)){
									if(us.getUserId() == Long.valueOf(userdangbai)){
										selected = "selected";
									}
		     		%>
		     			<option value="<%=us.getUserId()%>" <%=selected%>><%=us.getFullName()%></option>
		     		<%}}}%>
				</select>
			</td>
			<th>Trạng thái</th>	
			<td>
				<select class="form-control" name="<portlet:namespace/>trangthaitinbai">
					<option value="-1" <%if(trangthaitinbai.equals("") || status.equals("-1"))out.print("selected");%>>--Chọn trạng thái--</option>
					<option value="0" <%if(trangthaitinbai.equals("0"))out.print("selected");%>>Lưu nháp</option>
				<!-- <option value="1" <%if(trangthaitinbai.equals("1"))out.print("selected");%>>Chờ biên tập và phê duyệt</option>
					<option value="2" <%if(trangthaitinbai.equals("2"))out.print("selected");%>>Chờ phê duyệt</option> -->
					<option value="3" <%if(trangthaitinbai.equals("3"))out.print("selected");%>>Đã xuất bản</option>
					<option value="4" <%if(trangthaitinbai.equals("4"))out.print("selected");%>>Ngừng xuất bản</option>
				</select>
			</td>
		</tr>
		<tr>
			<th class="keycolor" style="vertical-align: middle;">Ngày tạo</th>
			<td>
				<div class="input-prepend">
					<!-- <span class="add-on">Từ ngày</span> -->
					<input type="text" placeholder="Từ ngày" class="datepicker form-control" name="<portlet:namespace/>ngaytao_tungay" id="ngay_banhanh_tungay" style="margin-bottom: 10px;"  value=""/>
				</div>
				<div class="input-prepend">
					<!-- <span class="add-on">Đến ngày</span> -->
					<input type="text" placeholder="Đến ngày" class="datepicker form-control" name="<portlet:namespace/>ngaytao_denngay" id="ngay_banhanh_denngay"  value=""/>
				</div>
			</td>
			<th class="keycolor" style="vertical-align: middle;">Ngày hiệu chỉnh</th>
			<td>
				<div class="input-prepend">
					<!-- <span class="add-on">Từ ngày</span> -->
					<input type="text" placeholder="Từ ngày" class="datepicker form-control" name="<portlet:namespace/>ngayhieuchinh_tungay" id="ngay_hieuluc_tungay" style="margin-bottom: 10px;"  value=""/>
				</div>
				<div class="input-prepend" >
					<!-- <span class="add-on">Đến ngày</span> -->
					<input type="text" placeholder="Đến ngày" class="datepicker form-control" name="<portlet:namespace/>ngayhieuchinh_denngay" id="ngay_hieuluc_denngay"  value=""/>
				</div>
			</td>
		</tr>
		<tr>
			<th>Chỉ hiển thị tin tức của user đăng nhập</th>	
			<td colspan="3">
				<%
					String search_chk ="";
					if(search_check.equals("on")){
						search_chk = "checked";
					}
				%>
				<input name="<portlet:namespace/>search_check" type="checkbox" <%=search_chk%>>
				<input name="<portlet:namespace/>loaitintuc" type="hidden" />
			</td>
		</tr>
		
		<tr>
			<td style="text-align: center;" colspan="4">
				<aui:button cssClass="btn-small btn" name="dongy" type="submit" value="Tìm kiếm" label=""></aui:button>
			</td>
		</tr> 
	</table>
	</aui:form>
</div>

<%
if(listNews_Articles.size() > 0){
	for(int a = 0; a < listNews_Articles.size(); a++){
		//System.out.println(listNews_Articles.get(a).getId());
%>
<div class="new-container-pm ">
<portlet:renderURL  var="editBooksURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="tenbai" value="<%=tenbai%>"/>
		<portlet:param name="dinhdanh" value="<%=dinhdanh%>"/>
		<portlet:param name="chuyenmuc" value="<%=category%>"/>
		<portlet:param name="trangthai" value="<%=status%>"/>
	    <portlet:param name="jspPage" value="/html/tintucadmin/books/edit.jsp"/>
</portlet:renderURL>
<portlet:renderURL  var="editBooksPDFURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
	    <portlet:param name="jspPage" value="/html/tintucadmin/books/editpdf.jsp"/>
</portlet:renderURL>	
<portlet:actionURL name="deleteBooksPDF" var="deleteBooksPDFURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="jspPage" value="/html/tintucadmin/books/view.jsp"/>
		<portlet:param name="tabs" value="Đăng tin"/>
</portlet:actionURL>	
<portlet:actionURL name="deleteBooks"  var="deleteBooksURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="jspPage" value="/html/tintucadmin/books/view.jsp"/>
		<portlet:param name="tabs" value="Đăng tin"/>
</portlet:actionURL>	
<div class="dropdown">
	  <button onclick="myFunction(<%=listNews_Articles.get(a).getId()%>)" class="dropbtn"><i class="caret"></i></button>
	  <div id="myDropdown_<%=listNews_Articles.get(a).getId()%>" class="dropdown-content">
	  <%
	  	String editlink = "";
	  	String deletelink = "";
	  	if (listNews_Articles.get(a).getLoaitintuc()==0 || listNews_Articles.get(a).getLoaitintuc()==4){
	  		editlink = editBooksURL;
	  		deletelink = deleteBooksURL;
	  	}else {
	  		editlink = editBooksPDFURL;
	  		deletelink = deleteBooksPDFURL;
	  	}
	  %>
		<a href="<%=editlink%>" class="edit-item"><i class="icon-file-text"></i>Hiệu chỉnh bài viết</a>
	    <a href="javascript:void(0)" data="<%=deletelink.toString()%>" class="del-item"><i class="icon-trash"></i> Xóa bài viết</a>
	  </div>
</div>
<% //System.out.println(deleteBooksURL.toString()); %>
<div class="small-img-pm">
	<%if(listNews_Articles.get(a).getStatus() == 0){%>
		<span class="lable-nhap">Tin mới đăng (Bản nháp)</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 3){%>
		<span class="lable-daxuatban">Đã xuất bản</span>
		<%}
	
		String url = listNews_Articles.get(a).getUrlimagesmall();
			if(!url.equals("")){
	%>
		<img style="height: 90px;" alt="" src="<%=url%>">
	<%}else{%>
		<img alt="" src="<%=request.getContextPath()%>/images/no_image.gif">
	<%}%>
</div>
<div class="new-name-info-content-pm">
		<a class="title-link-new-pm" href="<%=editlink%>"><span class="new-name-pm"><%=listNews_Articles.get(a).getTitle()%></span></a>
		<p class="new-info-pm">
		<%
			if(listNews_Articles.get(a).getInfo().length()>151){
				out.print(listNews_Articles.get(a).getInfo().substring(0, 149)+"...");
			}else {
				out.print(listNews_Articles.get(a).getInfo());
			}
		%>
		</p>
		<span class="new-version-pm"><b class="title-pm">Phiên bản: </b><%=listNews_Articles.get(a).getVersion()%></span>
		<%
			String ngaytao = "";
			if(Validator.isNotNull(listNews_Articles.get(a)) && Validator.isNotNull(listNews_Articles.get(a).getCreatedtime())){
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				ngaytao = df.format(listNews_Articles.get(a).getCreatedtime());
			}
		%>
		<span class="new-public-pm"><b class="title-pm">Ngày đăng: </b><%=ngaytao%></span>
		<span class="new-public-pm"><b class="title-pm">Định danh: </b><%=listNews_Articles.get(a).getId()%></span>
		<span class="new-category-pm"><b class="title-pm">Chuyên mục: </b>
			<%
				List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(listNews_Articles.get(a).getId());
				for(int ab = 0;ab<listarticle2Category.size();ab++){
					News_Categories new_category = null;
					if(listarticle2Category.get(ab).getNewcategoryId() >0){
						if(listarticle2Category.get(ab).getNewcategoryId()>0){
							new_category = News_CategoriesLocalServiceUtil.fetchNews_Categories(listarticle2Category.get(ab).getNewcategoryId());
						}
						if(Validator.isNull(new_category) || new_category.getId()==0){
							new_category = null;
						}
					}
					
			%>
				<span class="category-info-pm" title="id chuyên mục: <%=new_category.getId()%>"><%=new_category.getName()%></span>
			<%}%>
		</span>
		
		<span class="author">
			<% 
				String loaitintuc = "Sách ";
				if(listNews_Articles.get(a).getLoaitintuc() == 5 || listNews_Articles.get(a).getLoaitintuc() == 6 || listNews_Articles.get(a).getLoaitintuc() == 7){
					loaitintuc = "Sách điện tử";
				}
			%>
			<b class="title-pm">Loại sách: </b><%=loaitintuc%>
		</span>
		
		<span class="author">
			<% 
				User usercreate = UserLocalServiceUtil.fetchUser(listNews_Articles.get(a).getCreatedby());
				String fullname = "";
				if(Validator.isNotNull(usercreate)){
					fullname = usercreate.getFullName();
				}
			%>
			<b class="title-pm">Người đăng: </b><%=fullname%>
		</span>
		<span class="author">
			<b class="title-pm">Lượt xem: </b><%=listNews_Articles.get(a).getLuotxem()%>
		</span>
		<span class="author">
			<%
				News_Type objTheLoai = News_TypeLocalServiceUtil.fetchNews_Type(listNews_Articles.get(a).getTypeid());
				String theloai = "";
				if(Validator.isNull(objTheLoai)){
					theloai = "";
				}else{
					theloai = objTheLoai.getName();
				}
			%>
			<b class="title-pm">Thể loại: </b><%=theloai%>

		</span>
	</div>
</div>

<% }%>

<% } %>
<div class="paginator"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></div>	
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
<script>
$(document).ready(function(){
	$('.del-item').on('click', function () {
		 var href = $(this).attr('data');
		 //alert(href);
         window.b = $.confirm({
        	    title: 'Xóa bài viết!!!',
        	    content: 'Khi xóa sẽ không khôi phục lại dữ liệu được. Bạn có chắc chắn không !!!',
        	    confirm: function(){
        	        location.href = href;
        	    },
        	    cancel: function(){}
        	});
         return false;
     });
	$(".datepicker").datepicker({
		yearRange: '-80:+10',
		dateFormat: 'dd/mm/yy'
	});
});
</script>
<script>

function myFunction(id) {
	 document.getElementById("myDropdown_"+id).classList.toggle("show");
}

</script>
