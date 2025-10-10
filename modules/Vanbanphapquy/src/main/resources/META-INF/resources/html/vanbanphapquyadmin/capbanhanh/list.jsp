
<%@page import="vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="../init.jsp" %>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cấp ban hành</title>
	</head>
<body>
<style>
.table-columns tr th {
	text-align: center !important
}
</style>
<%
String tabCapbanhanh = VanbanphapquyAdminField.value_tabCapBanHanh;
String name = "";
int status= -1;
if(Validator.isNotNull(HtmlUtil.escape(ParamUtil.getString(request, "name")))){
	 name = HtmlUtil.escape(ParamUtil.getString(request, "name"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
	if(Validator.isNumber(ParamUtil.getString(request, "status"))){
		status = ParamUtil.getInteger(request, "status");
	}
}

PortletURL actionURL = renderResponse.createRenderURL();
actionURL.setParameter("tabs", tabCapbanhanh);
actionURL.setParameter("name", name);
actionURL.setParameter("status", String.valueOf(status));

PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("tabs", tabCapbanhanh);



PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/vanbanphapquyadmin/capbanhanh/list.jsp");
iteratorUrl.setParameter("name",name);


int cur = ParamUtil.getInteger(request,"cur");
int delta = ParamUtil.getInteger(request, "delta", 20);
//int total= 0;
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
<portlet:renderURL var="addCapbanhanhnURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/capbanhanh/add.jsp"/>
</portlet:renderURL>
<fieldset class="fs-admin">
	<form action="<%=searchURL.toString()%>" method="post">
	<table class="tbcoreadmin">
		<tr>
			<td class="key label3">Tên</td>
			<td><input class="form-control input-group-inset-after" placeholder="Tìm kiếm" type="text" size="30" name="<portlet:namespace />name" value="<%=name%>"></td>
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
			<a class="float-btn-input" href="${ addCapbanhanhnURL}"><aui:button value="Thêm cấp ban hành"/></a>
			</td>
		</tr>
	</table>
	</form>
</fieldset><br>

<table>
<liferay-ui:search-container delta="20" total="<%= VanbanphapquyAdminUtil.countCapbanhanhByKeyword(renderRequest, name, status, 0, 0).size() %>" 
	emptyResultsMessage="Chưa có liên kết nào" 
	iteratorURL="<%=actionURL%>">
	<liferay-ui:search-container-results
		results="<%= VanbanphapquyAdminUtil.countCapbanhanhByKeyword(renderRequest, name, status, searchContainer1.getStart(), searchContainer1.getEnd())%>"
	/>

	<liferay-ui:search-container-row
		className="vn.dnict.vanbanphapquy.model.Capbanhanh"
		modelVar="varCapbanhanh"
		keyProperty="id"
	>
		<liferay-ui:search-container-column-text name="STT" align="center"><%=stt++ %></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tên cấp ban hành" property="name"/>
		<liferay-ui:search-container-column-text name="Mã cấp ban hành" property="code"/>
		<%
			Capbanhanh cbh = CapbanhanhLocalServiceUtil.fetchCapbanhanh(varCapbanhanh.getId());
			String trangthai = "";
			if(varCapbanhanh.getStatus()== 0){
				trangthai = "<img src=\""+ request.getContextPath()+"/icon/icon_active/publish_x.png\"/>";
		       }else{	
		        trangthai = "<img src=\""+ request.getContextPath()+"/icon/icon_active/tick.png\"/>";
	        }
		%>
		<liferay-ui:search-container-column-text name="Sử dụng" value="<%=trangthai %>" align="center"/>
		<liferay-ui:search-container-column-jsp path="/html/vanbanphapquyadmin/capbanhanh/actions.jsp" name="Thao tác" align="center" cssClass="thaotac"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>

</table>

</body>
</html>