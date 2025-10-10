
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="init.jsp" %>

<portlet:defineObjects />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý văn bản</title>
</head>

<body>
<%
Portlet portlet = layoutTypePortlet.getAllPortlets().get(0);
portlet.setDisplayName("Quản lý văn bản");
String tabValues = "";
String tabNames = "";
ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
if(Validator.isNotNull(td)){
		tabValues = VanbanphapquyAdminField.value_tabCapBanHanh + ","
				+ VanbanphapquyAdminField.value_tabCoQuanBanHanh + ","
				+ VanbanphapquyAdminField.value_tabQuanLyVanBan + ","
				+ VanbanphapquyAdminField.value_tabLoaiVanBan + ","
				+ VanbanphapquyAdminField.value_tabLinhVuc;
				
		tabNames = VanbanphapquyAdminField.tabCapBanHanh + ","
				+ VanbanphapquyAdminField.tabCoQuanBanHanh + ","
				+ VanbanphapquyAdminField.tabQuanLyVanBan + ","
				+ VanbanphapquyAdminField.tabLoaiVanBan + ","
				+ VanbanphapquyAdminField.tabLinhVuc;
}
String[] arrTabs = null;
arrTabs = tabValues.split(",");	
if(tabValues.length()>0 && Validator.isNotNull(arrTabs)){
	String currentTab = ParamUtil.getString(request, "tabs1", arrTabs[2]);
	if(Validator.isNotNull(request.getAttribute("tabs"))){
		currentTab = request.getAttribute("tabs").toString();
	}
	if(Validator.isNotNull(session.getAttribute("tabs"))){
		currentTab = session.getAttribute("tabs").toString();
	}

	if(Validator.isNotNull(ParamUtil.getString(request, "tabs"))){
		currentTab = ParamUtil.getString(request, "tabs");
	}
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("tabs1", currentTab);	
%>
<liferay-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabValues %>"  url="<%= portletURL.toString() %>" value="<%=currentTab %>"/>
	<%if(currentTab.equals(VanbanphapquyAdminField.value_tabCapBanHanh)){%>
	<liferay-util:include page="/html/vanbanphapquyadmin/capbanhanh/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(VanbanphapquyAdminField.value_tabCoQuanBanHanh)){%>
	<liferay-util:include page="/html/vanbanphapquyadmin/coquanbanhanh/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(VanbanphapquyAdminField.value_tabQuanLyVanBan)){%>
	<liferay-util:include page="/html/vanbanphapquyadmin/vanbanphapquy/list.jsp" servletContext="<%=this.getServletContext()%>"/>	
	<%}else if(currentTab.equals(VanbanphapquyAdminField.value_tabLinhVuc)){%>
	<liferay-util:include page="/html/vanbanphapquyadmin/linhvuc/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(VanbanphapquyAdminField.value_tabLoaiVanBan)){%>
	<liferay-util:include page="/html/vanbanphapquyadmin/loaivanban/list.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}}%>
</body>
</html>