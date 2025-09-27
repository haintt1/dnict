<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util" %>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <portlet:defineObjects />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý tin tức</title>
</head>
<body>
<%
Portlet portlet = layoutTypePortlet.getAllPortlets().get(0);
portlet.setDisplayName("Quản lý tin bài");
ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String tabValues = "";
String tabNames = "";
if(Validator.isNotNull(td)){
	tabValues = TinTucAdminField.value_tabdangtin + ","
			+ TinTucAdminField.value_tabchuyenmuc + ","
			+ TinTucAdminField.value_tabtheloai + ","
			+ TinTucAdminField.value_tabtacgia;
			//+ TinTucAdminField.value_tabrss;
			
	tabNames = TinTucAdminField.tabdangtin + ","
			+ TinTucAdminField.tabchuyenmuc + ","
			+ TinTucAdminField.tabtheloai + ","
			+ TinTucAdminField.tabtacgia;
			//+ TinTucAdminField.tabrss;
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
	//System.out.println(currentTab + " = " + TinTucAdminField.value_tabdangtin);
%>
<liferay-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabValues %>"  url="<%= portletURL.toString() %>" value="<%=currentTab %>"/>
	<%if(currentTab.equals(TinTucAdminField.value_tabdangtin)){%>
	<liferay-util:include page="/html/tintucadmin/news/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabchuyenmuc)){%>
	<liferay-util:include page="/html/tintucadmin/subcategories/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabtheloai)){%>
	<liferay-util:include page="/html/tintucadmin/theloaibaiviet/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabtacgia)){%>
	<liferay-util:include page="/html/tintucadmin/tacgia/view.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}}%>
</body>
</html>