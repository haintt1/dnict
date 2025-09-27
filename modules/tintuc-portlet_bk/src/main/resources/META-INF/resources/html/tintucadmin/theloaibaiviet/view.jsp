<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="javax.swing.text.View"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String tabTheLoai = TinTucAdminField.value_tabtheloai;
	String name = "";int status = -1; int total = 0;
	if(Validator.isNotNull(ParamUtil.getString(request, "tentheloai"))){
		name = ParamUtil.getString(request, "tentheloai");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
		if(Validator.isNumber(ParamUtil.getString(request, "status"))){
			status = ParamUtil.getInteger(request, "status");
		}
	}
	//System.out.print(status);
	PortletURL pagingUrl = renderResponse.createRenderURL();
	pagingUrl.setParameter("name", name);
	pagingUrl.setParameter("status", String.valueOf(status) );
	pagingUrl.setParameter("jspPage", "/html/tintucadmin/theloaibaiviet/view.jsp");
	pagingUrl.setParameter("tabs", tabTheLoai);

	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("tabs", tabTheLoai);
	SearchContainer searchContainer = null;
	int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
	if (currentTransPage > 0) {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM,
				currentTransPage, 10, pagingUrl, null, null);
	} else {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, 10,
				pagingUrl, null, null);
	}
	int start = searchContainer.getStart();
	int end = searchContainer.getEnd();
	List<News_Type> listObj = TinTucAdminUtil.listTheLoai(name, status, start, end);
	total = TinTucAdminUtil.listTheLoai(name, status, 0, 0).size();
	searchContainer.setTotal(total);
	searchContainer.setResults(listObj);
%>
<portlet:renderURL var="addURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/theloaibaiviet/add.jsp" />
	<portlet:param name="tabs" value="<%=tabTheLoai %>" />
</portlet:renderURL>

<portlet:actionURL var="deleteTheLoaiURL" name="deleteTheLoai">
	<portlet:param name="jspPage" value="/html/tintucadmin/theloaibaiviet/view.jsp" />
	<portlet:param name="tabs" value="<%=tabTheLoai %>" />
</portlet:actionURL>

<portlet:renderURL var="searchTheLoaiURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/theloaibaiviet/view.jsp" />
	<portlet:param name="tabs" value="<%=tabTheLoai %>" />
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
<form  action="" method="post" id="frmAction">
	<h3 class="row-fluid header smaller lighter blue" style="position: relative;overflow: hidden;">
		<span style="width: 55%!important; display: block;float: left;">Quản lý danh sách thể loại</span>
		<span style="width: 45%!important;display: block; float: left;text-align: right;">
			<span class="btn-group pull-right inline">	
				<a class="btn btn-primary" href="<%=addURL%>" id="btnThemMoi"><i class="icon-plus"></i> Thêm mới</a>						
				<a href="#" onClick="confirmDelete();" class="btn btn-danger">
					<i class="icon-trash"></i> Xóa
				</a>
			</span>
		</span>
	</h3><br>
	
<table class="table table-striped table-bordered table-hover">
	<thead>
		<tr>
			<th style="width:10px; text-align:center"><input type="checkbox" id="ckbCheckAll"></input><span class="lbl"></span></th>
			<th style="text-align: center; width:15px">#</th>
			<th style="text-align: center; width:90%">Tên</th>
		</tr>
	</thead>
	<tbody>
	<%
		int stt = 1;
		News_Type object = null;
		for(int i=0; i<listObj.size(); i++){
			object = listObj.get(i);			
	%>
	<tr>
	    <portlet:renderURL  var="editURL">
	      <portlet:param name="theloaiid" value="<%= String.valueOf(object.getId()) %>" />
	      <portlet:param name="jspPage" value="/html/tintucadmin/theloaibaiviet/edit.jsp"/>
	      <portlet:param name="tabs" value="<%=tabTheLoai %>" />
	    </portlet:renderURL>
		<td><input name="<portlet:namespace/>check[]" class="checkBoxClass" type="checkbox" value="<%=object.getId()%>"></input><span class="lbl"></span></td>
		<td style="text-align: center;"><%=stt+searchContainer.getStart() %></td>
		<td><a href="<%=editURL %>" title="Chỉnh sửa"><%=object.getName() %></a></td>
	</tr>
	<%
			stt++;
		}
		if(listObj.size()==0){
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
<script>
$("#ckbCheckAll").click(function () {
    $(".checkBoxClass").prop('checked', $(this).prop('checked'));
});
function confirmDelete(){
	var count = $(".checkBoxClass:checked").length;
	if(count>0){
		if(confirm("Bạn chắc chắn muốn xóa những đối tượng này?")){
			$("#frmAction").attr('action','<%=deleteTheLoaiURL%>');
			$("#frmAction").submit();
		}
	}else{
		alert("Bạn cần chọn ít nhất một đối tượng!");
	}
}

</script>
<script>
$("#btnThemMoi").click(function () {
	$("#frmAction").attr('action','<%=addURL%>');
	$("#frmAction").submit();
})
</script>