<%@page import="qlanphamdb.service.AnPham_DeCuongLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_DeCuong"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="java.util.List"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%
	String tabDeCuong = QlanphamAdminField.value_tabdecuong;
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
	String dmLoai = ParamUtil.getString(request, "dmLoai", "-1");
	PortletURL actionURL = renderResponse.createRenderURL();
	actionURL.setParameter("tabs", tabDeCuong);
	actionURL.setParameter("ten", ten);
	actionURL.setParameter("dmLoai", dmLoai);
	actionURL.setParameter("status", String.valueOf(status));
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("jspPage", "/html/admin/decuong/view.jsp");
	iteratorUrl.setParameter("ten",ten);
	iteratorUrl.setParameter("dmLoai",dmLoai);
	iteratorUrl.setParameter("tabs", tabDeCuong);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("tabs", tabDeCuong);
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
	List<AnPham_DeCuong> listDeCuong = QlanphamAdminUtil.listDeCuong(ten, dmLoai, status, searchContainer1.getStart(), searchContainer1.getEnd());
%>
	<portlet:renderURL var="addURL">
		<portlet:param name="jspPage" value="/html/admin/decuong/add.jsp" />
		<portlet:param name="tabs" value="<%=tabDeCuong %>" />
	</portlet:renderURL>
	<portlet:actionURL var="deleteDeCuongURL" name="deleteDeCuong">
		<portlet:param name="tabs" value="<%=tabDeCuong %>" />
	</portlet:actionURL>
	<portlet:renderURL var="searchDeCuongURL">
		<portlet:param name="tabs" value="<%=tabDeCuong %>" />
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
	<form action="${searchDeCuongURL }" method="post">
	<table class="tbcoreadmin">
		<tr>
			<td class="key label3">Tên đề cương</td>
			<td><input class="form-control input-group-inset-after" placeholder="Tìm kiếm" type="text" size="30" name="<portlet:namespace />ten" value="<%=ten%>"></td>
			<td class="key label3">Loại ấn phẩm</td>
			<td>
				<select class="form-control" name='<portlet:namespace/>dmLoai'>
					<option value="-1">--Chọn loại ấn phẩm--</option>
					<%
					List<AnPham_Loai> objDmLoai = QlanphamAdminUtil.listDmLoai(renderRequest, "", 1, 0, 0);
					if(objDmLoai.size()>0) {
						for(int i=0; i<objDmLoai.size();i++){
							String selected ="";
							if(objDmLoai.get(i).getId() == Long.valueOf(dmLoai)) {
								selected = "selected";
							}
					%>
					<option value="<%=objDmLoai.get(i).getId()%>" <%=selected%>><%=objDmLoai.get(i).getTen()%></option>
					<%
						}
					}
					%>
					
				</select>
			</td>
		</tr>
		<tr>	
			<td class="key label3">Trạng thái</td>
			<td>
				<select class="form-control" name="<portlet:namespace />status">
					<option value="-1">-Chọn trạng thái-</option>
					<option value="0" <%=status==0?"selected":""%>>Lưu nháp</option>
					<option value="1" <%=status==1?"selected":""%>>Chờ biên tập và phê duyệt</option>
					<option value="2" <%=status==2?"selected":""%>>Chờ phê duyệt</option>
					<option value="3" <%=status==3?"selected":""%>>Xuất bản</option>
				</select>
			</td>
			<td></td>
			<td>
			<input class="btn  btn-primary btn-default" type="submit" value="Tìm kiếm">
			<a class="float-btn-input" href="<%=addURL.toString()%>"><aui:button value="Thêm mới"/></a>
			</td>
		</tr>
	</table>
	</form>
	</fieldset><br>
	<table>
		<liferay-ui:search-container delta="20" total="<%=QlanphamAdminUtil.listDeCuong(ten, dmLoai, status, 0, 0).size() %>" 
		emptyResultsMessage="Chưa có đề cương nào" 
		iteratorURL="<%=actionURL%>">
			<liferay-ui:search-container-results results="<%=QlanphamAdminUtil.listDeCuong(ten, dmLoai, status, searchContainer1.getStart(), searchContainer1.getEnd()) %>" />
			<liferay-ui:search-container-row className="qlanphamdb.model.AnPham_DeCuong" modelVar="deCuong" keyProperty="id" cssClass="table-columns">
				<liferay-ui:search-container-column-text name="STT" align="center"><%=stt++ %></liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="Tên đề cương" property="ten"/>
				<%
				AnPham_Loai listLoai = AnPham_LoaiLocalServiceUtil.fetchAnPham_Loai(deCuong.getLoaiId());
				%>
				<liferay-ui:search-container-column-text name="Loại ấn phẩm" value="<%=listLoai.getTen() %>"/>
				<liferay-ui:search-container-column-text name="Thứ tự" property="orders" align="center"/>
				<%
				String trangthai = "";
				if(deCuong.getStatus()== 0){ trangthai = "Lưu nháp"; }
				else if (deCuong.getStatus()== 1){ trangthai = "Chờ biên tập"; }
				else if (deCuong.getStatus()== 2){ trangthai = "Chờ phê duyệt"; }
				else if (deCuong.getStatus()== 3){ trangthai = "Xuất bản"; }
				else if (deCuong.getStatus()== 5){ trangthai = "Đề cương đang được hiệu chỉnh"; }
				%>
				<liferay-ui:search-container-column-text name="Tình trạng" value="<%=trangthai %>" align="center"/>
				<liferay-ui:search-container-column-jsp path="/html/admin/decuong/action.jsp" name="Thao tác" align="center" cssClass="thaotac"/>
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