
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_BinhLuan"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String dinhdanh = "";
	String hoten = "";
	String tungay = "";
	String denngay = "";
	String noidung = "";
	int status = -2;
	int total = 0;
	if(Validator.isNotNull(ParamUtil.getString(request, "dinhdanh"))){
		dinhdanh = ParamUtil.getString(request, "dinhdanh");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "hoten"))){
		hoten = ParamUtil.getString(request, "hoten");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "tungay"))){
		tungay = ParamUtil.getString(request, "tungay");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "denngay"))){
		denngay = ParamUtil.getString(request, "denngay");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "noidung"))){
		noidung = ParamUtil.getString(request, "noidung");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
		if(Validator.isNumber(ParamUtil.getString(request, "status"))){
			status = ParamUtil.getInteger(request, "status");
		}
	}
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/quanlybinhluan/view.jsp");
	iteratorUrl.setParameter("dinhdanh", dinhdanh);
	iteratorUrl.setParameter("hoten", hoten);
	iteratorUrl.setParameter("tungay", tungay);
	iteratorUrl.setParameter("denngay", denngay);
	iteratorUrl.setParameter("noidung", noidung);
	iteratorUrl.setParameter("status", String.valueOf(status));
	
	PortletURL searchURL = renderResponse.createRenderURL();
	SearchContainer searchContainer = null;
	int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
	if (currentTransPage > 0) {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM,
				currentTransPage, 10, iteratorUrl, null, null);
	} else {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, 10,
				iteratorUrl, null, null);
	}
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	
	List<News_BinhLuan> listBinhLuan = TinTucAdminUtil.listBinhLuans(dinhdanh,hoten,tungay,denngay,noidung,status,start,end);
	total = TinTucAdminUtil.listBinhLuans(dinhdanh, hoten, tungay, denngay, noidung, status, 0, 0).size();
	searchContainer.setTotal(total);
//	searchContainer.setResults(listBinhLuan);
	String baseURL = request.getScheme() + "://" +   // Protocol (http or https)
            request.getServerName() +      // Server name (domain or IP, e.g., localhost)
            (request.getServerPort() == 80 ? "" : ":" + request.getServerPort()); // Server port
            
%>
	<portlet:actionURL var="deleteBinhLuanURL" name="deleteBinhLuan">
		<portlet:param name="jspPage" value="/html/quanlybinhluan/view.jsp" />
	</portlet:actionURL>
	<portlet:actionURL var="publishBinhLuanURL" name="publishBinhLuan">
		<portlet:param name="jspPage" value="/html/quanlybinhluan/view.jsp" />
	</portlet:actionURL>
	<portlet:actionURL var="nopublishBinhLuanURL" name="nopublishBinhLuan">
		<portlet:param name="jspPage" value="/html/quanlybinhluan/view.jsp" />
	</portlet:actionURL>
	<portlet:renderURL var="searchBinhLuanURL">
		<portlet:param name="jspPage" value="/html/quanlybinhluan/view.jsp" />
	</portlet:renderURL>
<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
							<div class="panel-body">
								<div style="margin-bottom: 15px;">
<liferay-ui:success key="delete-successfully" message="Xoá thành công!"/>
<liferay-ui:success key="save-successfully" message="Lưu thành công!"/>
<liferay-ui:error key="delete-unsuccessfully" message="Xoá không thành công!"/>
<h3 class="row-fluid header smaller lighter blue" style="position: relative;overflow: hidden;">
		<span style="width: 50%!important; display: block;float: left;">Quản lý danh sách bình luận</span>
		<span style="width: 50%!important;display: block; float: left;text-align: right;">
			<span class="btn-group pull-right inline">										
				<a href="#" onClick="confirmPublish();" class="btn btn-success"><i class="icon-trash"></i>Duyệt</a>
			</span>
			<span class="btn-group pull-right inline">										
				<a href="#" onClick="confirmNoPublish();" class="btn btn-info"><i class="icon-trash"></i>Không duyệt</a>
			</span>
			<span class="btn-group pull-right inline">										
				<a href="#" onClick="confirmDelete();" class="btn btn-danger"><i class="icon-trash"></i>Xóa</a>
			</span>
		</span>
	</h3><br>
<form action="<%=searchBinhLuanURL.toString() %>" method="post" id="frmAction">	
	<aui:form action="<%=searchBinhLuanURL.toString() %>">
		<table class="table table-bordered" style="margin-top: 10px;">
		<tr>
			<th class="ten">Nội dung bình luận</th>
			<td><input name="<portlet:namespace/>noidung" class="form-control" value="<%=noidung%>" type="text"></input></td>
 			<th class="ten">Định danh</th>	
			<td><input name="<portlet:namespace/>dinhdanh" class="form-control" value="<%=dinhdanh%>" type="text"></input></td>
			<th class="ten">Họ tên</th>	
			<td><input name="<portlet:namespace/>hoten" class="form-control" value="<%=hoten%>" type="text"></input></td>
		</tr>
		<tr>
			<th class="keycolor" style="vertical-align: middle;">Ngày bình luận</th>
			<td colspan="3">
				<div class="input-prepend" style="width:49%;float: left; margin-right: 2%;">
					<input type="text" placeholder="Từ ngày" class="datepicker form-control" name="<portlet:namespace/>tungay" id="tungay" value=""/>
				</div>
				<div class="input-prepend" style="width:49%;float: left;">
					<input type="text" placeholder="Đến ngày" class="datepicker form-control" name="<portlet:namespace/>denngay" id="denngay"  value=""/>
				</div>
			</td>
			<th class="ten">Trạng thái</th>	
			<td>
				<select class="form-control" name="<portlet:namespace/>status">
					<option value="-2" <%if(status==-2)out.print("selected");%>>--Chọn trạng thái--</option>
					<option value="-1" <%if(status==-1)out.print("selected");%>>Chưa xác nhận</option>
					<option value="0" <%if(status==0)out.print("selected");%>>Không duyệt</option>
					<option value="1" <%if(status==1)out.print("selected");%>>Đã duyệt</option>
				</select>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="6">
				<aui:button cssClass="btn-small btn" name="submit" type="submit" value="Tìm kiếm" label=""></aui:button>				
				<input class=" btn-small btn" id="reload" value="Reset" />	
			</td>
		</tr> 
		</table>
	</aui:form>
	
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:10px; text-align:center"><input type="checkbox" id="ckbCheckAll"></input><span class="lbl"></span></th>
			<th style="text-align: center; width:5%">#</th>
			<th style="text-align: center; width:35%">Nội dung bình luận</th>
			<th style="text-align: center; width:15%">Họ tên</th>
			<th style="text-align: center; width:25%">Tiêu đề bài viết</th>
			<th style="text-align: center; width:10%">Ngày bình luận</th>
			<th style="text-align: center; width:10%">Trạng thái</th>
		</tr>
	</thead>
	<tbody>
	<%
		int stt = 1;
		News_BinhLuan objBinhLuan = null;
		for(int i=0; i<listBinhLuan.size(); i++){
			objBinhLuan = listBinhLuan.get(i);		
			News_Article objTieude = News_ArticleLocalServiceUtil.fetchNews_Article(objBinhLuan.getNewarticleId());
			String tieude = "";
			if(Validator.isNull(objTieude)){
				tieude = "";
			} else {
				tieude = objTieude.getTitle();
			}	
	%>
	<tr>
		<td><input name="<portlet:namespace/>check[]" class="checkBoxClass" type="checkbox" value="<%=objBinhLuan.getId()%>"></input><span class="lbl"></span></td>
		<td style="text-align: center;"><%=stt+searchContainer.getStart() %></td>
		<td><%=objBinhLuan.getNoiDung() %></td>
		<td><%=objBinhLuan.getHoTen() %></td>
		<td><a href="<%=baseURL + "/chi-tiet-tin-tuc?dinhdanh=" + objBinhLuan.getNewarticleId() %>"><%=tieude %></a></td>
		<td><%=objBinhLuan.getNgayBinhLuan() %></td>
		<%
			String trangthai = "";
			if (objBinhLuan.getStatus() == 1) {
				trangthai = "Đã duyệt";
			} else if (objBinhLuan.getStatus() == 0) {
				trangthai = "Không duyệt";
			} else trangthai = "Chưa xác nhận";
		%>
		<td><%=trangthai %></td>
	</tr>
	<%
			stt++;
		}
		if(listBinhLuan.size()==0){
	%>
	<tr>
		<td colspan="7"><h2>Không có kết quả nào được tìm thấy!</h2></td>
	</tr>
	<%}%>
	</tbody>
</table>
<div>
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />
</div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
</nav>
</body>
<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){
	const reloadButton = document.querySelector("input#reload");
	reloadButton.addEventListener("click", () => {
	    // Replace the current page with the same page, but with the new JavaScript files.
	  window.location.replace(window.location.href);
	});
	$j(".datepicker").datepicker({
		yearRange: '-80:+10',
		dateFormat: 'dd/mm/yy'
	});  
})


$("#ckbCheckAll").click(function () {
    $(".checkBoxClass").prop('checked', $(this).prop('checked'));
});
function confirmDelete(){
	var count = $(".checkBoxClass:checked").length;
	if(count>0){
		if(confirm("Bạn chắc chắn muốn xóa những bình luận này?")){
			$("#frmAction").attr('action','<%=deleteBinhLuanURL%>');
			$("#frmAction").submit();
		}
	}else{
		alert("Bạn cần chọn ít nhất một bình luận!");
	}
}

function confirmPublish(){
	var count = $(".checkBoxClass:checked").length;
	if(count>0){
		if(confirm("Bạn chắc chắn muốn duyệt những bình luận này?")){
			$("#frmAction").attr('action','<%=publishBinhLuanURL%>');
			$("#frmAction").submit();
		}
	}else{
		alert("Bạn cần chọn ít nhất một bình luận!");
	}
}

function confirmNoPublish(){
	var count = $(".checkBoxClass:checked").length;
	if(count>0){
		if(confirm("Bạn chắc chắn muốn không duyệt những bình luận này?")){
			$("#frmAction").attr('action','<%=nopublishBinhLuanURL%>');
			$("#frmAction").submit();
		}
	}else{
		alert("Bạn cần chọn ít nhất một bình luận!");
	}
}


</script>