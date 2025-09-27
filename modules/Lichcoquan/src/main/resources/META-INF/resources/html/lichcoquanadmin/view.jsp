<%@page import="vn.dnict.lichcoquan.portlet.LichcoquanAdminField"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
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
<title>Lịch cơ quan</title>
</head>

<body>
<%
Portlet portlet = layoutTypePortlet.getAllPortlets().get(0);
portlet.setDisplayName("Lịch cơ quan");
String tabValues = "";
String tabNames = "";
ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
if(Validator.isNotNull(td)){
		tabValues = LichcoquanAdminField.value_tabDanhSachLichCoQuan + ","
				+ LichcoquanAdminField.value_tabCauHinhMaDonVi;
				
		tabNames = LichcoquanAdminField.tabDanhSachLichCoQuan + ","
				+ LichcoquanAdminField.tabCauHinhMaDonVi;
}
String[] arrTabs = null;
arrTabs = tabValues.split(",");	
if(tabValues.length()>0 && Validator.isNotNull(arrTabs)){
	String currentTab = ParamUtil.getString(request, "tabs1", arrTabs[0]);
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
	<%if(currentTab.equals(LichcoquanAdminField.value_tabDanhSachLichCoQuan)){%>
	<liferay-util:include page="/html/lichcoquanadmin/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(LichcoquanAdminField.value_tabCauHinhMaDonVi)){%>
	<liferay-util:include page="/html/lichcoquanadmin/config.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}}%>
</body>
</html>