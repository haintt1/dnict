<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
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

<title>Danh sách tin tức</title>
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
String tabDangtin = TinTucAdminField.value_tabdangtin;

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
String keyword = HtmlUtil.escape(ParamUtil.getString(request,"title",""));

String tenbai    = HtmlUtil.escape(ParamUtil.getString(request, "tenbai"));
String dinhdanh  = HtmlUtil.escape(ParamUtil.getString(request, "dinhdanh"));
String chuyenmuc = ParamUtil.getString(request, "chuyenmuc"); 
String theloaibaiviet = ParamUtil.getString(request, "theloaibaiviet", "-1");
String tacgia = ParamUtil.getString(request, "tacgia", "0");
String trangthaitinbai = ParamUtil.getString(request, "trangthaitinbai"); 
String status = ParamUtil.getString(request, "trangthai");

PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/tintucadmin/news/view.jsp");
iteratorUrl.setParameter("tabs", "Đăng tin");
iteratorUrl.setParameter("trangthaitinbai", trangthaitinbai);
iteratorUrl.setParameter("theloaibaiviet", theloaibaiviet);
iteratorUrl.setParameter("tacgia", tacgia);
iteratorUrl.setParameter("search_check", search_check);
iteratorUrl.setParameter("tenbai",tenbai);
iteratorUrl.setParameter("ngaytao_tungay",ngaytao_tungay);
iteratorUrl.setParameter("ngaytao_denngay",ngaytao_denngay);
iteratorUrl.setParameter("ngayhieuchinh_tungay",ngayhieuchinh_tungay);
iteratorUrl.setParameter("ngayhieuchinh_denngay",ngayhieuchinh_denngay);
iteratorUrl.setParameter("dinhdanh",dinhdanh);
iteratorUrl.setParameter("chuyenmuc",chuyenmuc);
iteratorUrl.setParameter("userdangbai", userdangbai);


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


/* List<News_Article> listNews_Articles = TinTucAdminUtil.listTintucAdmin(start, end); */
List<News_Article> listNews_Articles = TinTucAdminUtil.listTintucAdmin(checkLangNews, usdangbaicheck, tenbai, dinhdanh, chuyenmuc, trangthaitinbai, theloaibaiviet, tacgia, userdangbai, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, start, end);


/* total = (int) TinTucAdminUtil.listTintucAdmin(0, 0).size(); */
total = (int) TinTucAdminUtil.listTintucAdmin(checkLangNews, usdangbaicheck, tenbai, dinhdanh, chuyenmuc, trangthaitinbai, theloaibaiviet, tacgia, userdangbai, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, 0, 0).size();

searchContainer.setTotal(total);
searchContainer.setResults(listNews_Articles);
News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());

%>
<liferay-ui:success key="save-successfully" message="Chuyển trang thành công"></liferay-ui:success>
<portlet:renderURL var="addNewsURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addNewsPDFURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/addpdf.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addNewsVideoURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/addvideo.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchBaivietURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/view.jsp"/>
	<portlet:param name="tabs" value="Đăng tin"/>
</portlet:renderURL>
<portlet:renderURL var="thungRacURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/news/trash.jsp"/>
	<portlet:param name="tabs" value="Đăng tin"/>
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

<%
if(listNews_Articles.size() > 0){
	for(int a = 0; a < listNews_Articles.size(); a++){
		//System.out.println(listNews_Articles.get(a).getId());
%>
<div class="new-container-pm ">
<portlet:renderURL  var="editTintucURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		
	    <portlet:param name="jspPage" value="/html/tintucadmin/news/edit.jsp"/>
</portlet:renderURL>
<portlet:renderURL  var="editTintucpdfURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
	    <portlet:param name="jspPage" value="/html/tintucadmin/news/editpdf.jsp"/>
</portlet:renderURL>
<portlet:renderURL  var="editTintucvideoURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
	    <portlet:param name="jspPage" value="/html/tintucadmin/news/editvideo.jsp"/>
</portlet:renderURL>
<portlet:actionURL name="softdeleteTintucVideo" var="softdeleteTintucVideoURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="jspPage" value="/html/tintucadmin/news/view.jsp"/>
		<portlet:param name="tabs" value="Đăng tin"/>
</portlet:actionURL>	
<portlet:actionURL name="softdeleteTintucPDF" var="softdeleteTintucPDFURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="jspPage" value="/html/tintucadmin/news/view.jsp"/>
		<portlet:param name="tabs" value="Đăng tin"/>
</portlet:actionURL>	
<portlet:actionURL name="softdeleteTintuc"  var="softdeleteTintucURL" >
		<portlet:param name="id" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>"/>
		<portlet:param name="jspPage" value="/html/tintucadmin/news/view.jsp"/>
		<portlet:param name="tabs" value="Đăng tin"/>
</portlet:actionURL>
<portlet:renderURL var="xemThoiGianURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="timeId" value="<%=String.valueOf(listNews_Articles.get(a).getId())%>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/news/xemthoigian.jsp" />
</portlet:renderURL>
<div class="dropdown">
	  <button onclick="myFunction(<%=listNews_Articles.get(a).getId()%>)" class="dropbtn"><i class="caret"></i></button>
	  <div id="myDropdown_<%=listNews_Articles.get(a).getId()%>" class="dropdown-content">
	  	<%
			String chonLoaiTinTuc = "";
	  		String softdeleteTinTuc = "";
			if(listNews_Articles.get(a).getLoaitintuc()==0){
				chonLoaiTinTuc = editTintucURL;
				softdeleteTinTuc = softdeleteTintucURL.toString();
			} else if(listNews_Articles.get(a).getLoaitintuc()==1) {
				chonLoaiTinTuc = editTintucpdfURL;
				softdeleteTinTuc = softdeleteTintucPDFURL.toString();
			} else {
				chonLoaiTinTuc = editTintucvideoURL;
				softdeleteTinTuc = softdeleteTintucVideoURL.toString();
			}
		%>
		<a href="<%=chonLoaiTinTuc %>" class="edit-item"><i class="icon-file-text"></i>Hiệu chỉnh bài viết</a>
		
	    <a href="javascript:void(0)" data="<%=softdeleteTinTuc%>" class="del-item"><i class="icon-trash"></i> Xóa bài viết</a>
	  </div>
</div>
<div class="small-img-pm">
	<%if(listNews_Articles.get(a).getStatus() == 0){%>
		<span class="lable-nhap">Tin mới đăng (Bản nháp)</span>
		<%}else if( listNews_Articles.get(a).getStatus() == 1){%>
		<span class="lable-chopheduyet">Chờ biên tập</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 2){%>
		<span class="lable-xuatban">Chờ phê duyệt</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 3){%>
		<span class="lable-daxuatban">Đã xuất bản</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 4){%>
		<span class="lable-ngungxuatban">Ngừng xuất bản</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 5){%>
		<span class="lable-yeucauhieuchinh">Tin được yêu cầu hiệu chỉnh</span>
		<%}else if(listNews_Articles.get(a).getStatus() == 6){%>
		<span class="lable-choxuatban">Chờ xuất bản</span>
	<%}%>
	<%
		String url = listNews_Articles.get(a).getUrlimagesmall();
			if(!url.equals("")){
	%>
		<img style="height: 90px;" alt="" src="<%=url%>">
	<%}else{%>
		<img alt="" src="<%=request.getContextPath()%>/images/no_image.gif">
	<%}%>
</div>
<div class="new-name-info-content-pm">
		<a class="title-link-new-pm" href="<%=chonLoaiTinTuc %>"><span class="new-name-pm"><%=listNews_Articles.get(a).getTitle()%></span></a> 
		<%
			Date date = new Date();
			SimpleDateFormat dformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = dformat.format(date)+":00";
			SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dfGMT.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
			dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
			Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
			if(listNews_Articles.get(a).getStatus() == 6 ) {
			//	long countdownTime = listNews_Articles.get(a).getNgayxuatban().getTime();
				long countdownTimeXB = listNews_Articles.get(a).getNgayxuatban().getTime() - (7 * 60 * 60 * 1000);
				
		%>
		 - <span class="timerXB" data-time="<%= countdownTimeXB %>">00:20</span>
		<% } else if(listNews_Articles.get(a).getNgayxuatban() != null && 
				listNews_Articles.get(a).getNgayketthuc() != null && 
				listNews_Articles.get(a).getStatus() == 3) {
			long countdownTimeKT = listNews_Articles.get(a).getNgayketthuc().getTime() - (7 * 60 * 60 * 1000);
		%>
		 - <span class="timerKT" data-time="<%= countdownTimeKT %>">00:20</span>
		<% } %>
		<%-- <p class="new-info-pm">
		<%
			if(listNews_Articles.get(a).getInfo().length()>151){
				out.print(listNews_Articles.get(a).getInfo().substring(0, 149)+"...");
			}else {
				out.print(listNews_Articles.get(a).getInfo());
			}
		%>
		</p> --%>
		<span class="new-version-pm"><b class="title-pm">Phiên bản: </b><%=listNews_Articles.get(a).getVersion()%></span>
		<%
			String ngaytao = "";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if(Validator.isNotNull(listNews_Articles.get(a)) && Validator.isNotNull(listNews_Articles.get(a).getCreatedtime())){
				ngaytao = df.format(listNews_Articles.get(a).getCreatedtime());
			}
		%>
		<span class="new-public-pm"><b class="title-pm">Định danh: </b><%=listNews_Articles.get(a).getId()%></span>
		<span class="author"><b class="title-pm">Lượt xem: </b><%=listNews_Articles.get(a).getLuotxem()%></span>
		<span class="author"><b class="title-pm">Tác giả: </b><%=listNews_Articles.get(a).getCongtacvien()%></span>
		<span class="new-public-pm"><b class="title-pm">Ngày xuất bản: </b><%=df.format(listNews_Articles.get(a).getNgayxuatban())%></span>
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
				String loaitintuc = "Tin tức mặc định ";
//				if(listNews_Articles.get(a).getLoaitintuc() == 1 || listNews_Articles.get(a).getLoaitintuc() == 2 || listNews_Articles.get(a).getLoaitintuc() == 3){
//					loaitintuc = "Tin tức PDF";
//				}
				if(listNews_Articles.get(a).getLoaitintuc() == 0) {
					loaitintuc = "Tin tức";
				} else if(listNews_Articles.get(a).getLoaitintuc() == 1) {
					loaitintuc = "Tin tức PDF";
				} else {
					loaitintuc = "Tin tức video";
				}
			%>
			<b class="title-pm">Loại tin tức: </b><%=loaitintuc%>
		</span>
		
		<span class="author">
			<% 
				User usercreate = UserLocalServiceUtil.fetchUser(listNews_Articles.get(a).getCreatedby());
				String fullname = "";
				if(Validator.isNotNull(usercreate)){
					fullname = usercreate.getFullName();
				}
			%>
			<b class="title-pm">Người đăng bài: </b><%=fullname%>
		</span>		
		<span class="author">
			<%
				News_Type objTheLoai = News_TypeLocalServiceUtil.fetchNews_Type(listNews_Articles.get(a).getTypeid());
				//System.out.println("The loai:"+objTheLoai);
				String theloaibv = "";
				if(Validator.isNull(objTheLoai)){
					theloaibv = "";
				}else{
					theloaibv = objTheLoai.getName();
				}
			%>
			<b class="title-pm">Thể loại: </b><%=theloaibv%>

		</span>
		<span class="author">
			<%
				News_NguonTin objTacGia = News_NguonTinLocalServiceUtil.fetchNews_NguonTin(listNews_Articles.get(a).getNguontin());		
				String tacgiant = "";
				if(Validator.isNull(objTacGia)){
					tacgiant = "";
				}else{
					tacgiant = objTacGia.getName();
				}
			%>
			<b class="title-pm">Nguồn tin: </b><%=tacgiant%>
		</span>
		<%if(listNews_Articles.get(a).getIsnoibat() == 1){%>
			<span class="author"><b>Tin nổi bật: </b>Có</span>
		<%}%>
		<div class="tag-checktime">
			<span class="author">
				<b class="title-pm">Từ khóa: </b><%=listNews_Articles.get(a).getTukhoa()%>
			</span>
			<span class="author"><b class="title-pm">Thời gian xuất bản/ngừng xuất bản: </b><a class="xemThoiGian" href="javascript:void(0)" data-url="<%=xemThoiGianURL.toString()%>">Kiểm tra</a></span>
		</div>
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
        	    content: 'Khi xóa, bài viết sẽ ở trong thùng rác. Bạn có chắc chắn không !!!',
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
};
</script>

<script>
	$('.xemThoiGian').click(function(){
		var url = $(this).data('url');
		Liferay.Util.openWindow(
		{
			dialog: {
	           centered: true,
	           height: 200,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Hoạt động',
	        uri: url
		});
	});	
</script>

<script>
	function updateCountdown() {
	    let timers = document.querySelectorAll(".timerXB, .timerKT");
	    let reloadNeeded = false;
	
	    timers.forEach(timer => {
	        let targetTime = parseInt(timer.getAttribute("data-time"), 10);
	        let now = new Date().getTime();
	        let remaining = targetTime - now;
	
	        if (remaining > 0) {
	            let seconds = Math.floor((remaining / 1000) % 60);
	            let minutes = Math.floor((remaining / 1000 / 60) % 60);
	            let hours = Math.floor((remaining / 1000 / 60 / 60) % 24);
	            let days = Math.floor(remaining / 1000 / 60 / 60 / 24);
	
	            let formattedTime = 
	                (days > 0 ? days + "d " : "") + 
	                (hours > 0 ? hours.toString().padStart(2, "0") + ":" : "") + 
	                minutes.toString().padStart(2, "0") + ":" + 
	                seconds.toString().padStart(2, "0");
	
	            timer.textContent = formattedTime;
	        } else {
	        	timer.textContent = "00:00";
                reloadNeeded = true; // Đánh dấu cần reload
	        }
	    });
	
	    if (reloadNeeded) {
	        setTimeout(() => {
	            location.reload();
	        }, 1000);
	    }
	}
	
	document.addEventListener("DOMContentLoaded", function () {
	    updateCountdown(); // Chạy ngay khi trang load
	    setInterval(updateCountdown, 1000); // Cập nhật mỗi giây
	});
</script>




