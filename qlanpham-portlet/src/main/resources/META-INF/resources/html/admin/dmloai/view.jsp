<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="java.util.List"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String tabDmLoai = QlanphamAdminField.value_tabdmloai;
	String ten = "";
	int status = -1;
	if(Validator.isNotNull(ParamUtil.getString(request, "ten"))){
		ten = ParamUtil.getString(request, "ten");
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
		if(Validator.isNumber(ParamUtil.getString(request, "status"))){
			status = ParamUtil.getInteger(request, "status");
		}
	}
	PortletURL actionURL = renderResponse.createRenderURL();
	actionURL.setParameter("tabs", tabDmLoai);
	actionURL.setParameter("ten", ten);
	actionURL.setParameter("status", String.valueOf(status));
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/anphamadmin/dmloai/view.jsp");
	iteratorUrl.setParameter("ten",ten);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("tabs", tabDmLoai);
	int cur = ParamUtil.getInteger(request,"cur");
	int delta = ParamUtil.getInteger(request, "delta", 20);
	SearchContainer searchContainer1 = null;
	if (cur > 0) {
		searchContainer1 = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM,
				cur, delta, iteratorUrl, null, null);
	} else {
		searchContainer1 = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, delta,
				iteratorUrl, null, null);
	}
	int stt = searchContainer1.getStart() + 1;
%>
	<portlet:renderURL var="addURL">
		<portlet:param name="jspPage" value="/html/admin/dmloai/add.jsp" />
		<portlet:param name="tabs" value="<%=tabDmLoai %>" />
	</portlet:renderURL>
	<portlet:actionURL var="deleteDmLoaiURL" name="deleteDmLoai">
		<portlet:param name="tabs" value="<%=tabDmLoai %>" />
	</portlet:actionURL>
	<portlet:renderURL var="searchDmLoaiURL">
		<portlet:param name="tabs" value="<%=tabDmLoai %>" />
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
	<fieldset class="fs-admin">
	<form action="${searchDmLoaiURL }" method="post">
	<table class="tbcoreadmin">
		<tr>
			<td class="key label3">Tên</td>
			<td><input class="form-control input-group-inset-after" placeholder="Tìm kiếm" type="text" size="30" name="<portlet:namespace />ten" value="<%=ten%>"></td>
			<td class="key label3">Trạng thái</td>
			<td>
				<select class="form-control" name="<portlet:namespace />status">
					<option value="-1">-Chọn trạng thái-</option>
					<option value="1" <%=status==1?"selected":""%>>Sử dụng</option>
					<option value="0" <%=status==0?"selected":""%>>Chưa sử dụng</option>
				</select>
			</td>
			<td class="key input_2">
			<input class="btn  btn-primary btn-default" type="submit" value="Tìm kiếm">
			<a class="float-btn-input" href="<%=addURL.toString()%>"><aui:button value="Thêm mới"/></a>
			</td>
		</tr>
	</table>
	</form>
	</fieldset><br>
	<table>
		<liferay-ui:search-container delta="20" total="<%=QlanphamAdminUtil.listDmLoai(renderRequest, ten, status, 0, 0).size() %>" 
		emptyResultsMessage="Chưa có loại ấn phẩm nào" 
		iteratorURL="<%=actionURL%>">
			<liferay-ui:search-container-results results="<%=QlanphamAdminUtil.listDmLoai(renderRequest, ten, status, searchContainer1.getStart(), searchContainer1.getEnd()) %>" />
			<liferay-ui:search-container-row className="qlanphamdb.model.AnPham_Loai" modelVar="dmLoai" keyProperty="id" cssClass="table-columns">
				<liferay-ui:search-container-column-text name="STT" align="center"><%=stt++ %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="Tên loại ấn phẩm" property="ten"/>
				<liferay-ui:search-container-column-text name="Thứ tự" property="orders" align="center"/>
				<%
				String trangthai = "";
				if(dmLoai.getStatus()== 0){
					trangthai = "<img src=\""+ request.getContextPath()+"/images/publish_x.png\"/>";
			       }else{	
			        trangthai = "<img src=\""+ request.getContextPath()+"/images/tick.png\"/>";
		        }
				%>
				<liferay-ui:search-container-column-text name="Sử dụng" value="<%=trangthai %>" align="center"/>
				<liferay-ui:search-container-column-jsp path="/html/admin/dmloai/action.jsp" name="Thao tác" align="center" cssClass="thaotac"/>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</table>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</div>
	</nav>
	</body>