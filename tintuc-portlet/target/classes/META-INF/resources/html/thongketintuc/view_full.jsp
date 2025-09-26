<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String tabValues = "";
String tabNames = "";
if(Validator.isNotNull(td)){
	tabValues = TinTucAdminField.value_tabtkbaiviet + ","
			+ TinTucAdminField.value_tabtkchuyenmuc + ","
			+ TinTucAdminField.value_tabtktheloai + ","
			+ TinTucAdminField.value_tabtktacgia;
			
	tabNames = TinTucAdminField.tabtkbaiviet + ","
			+ TinTucAdminField.tabtkchuyenmuc + ","
			+ TinTucAdminField.tabtktheloai + ","
			+ TinTucAdminField.tabtktacgia;
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
	//System.out.println(currentTab);
%>
<liferay-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabValues %>"  url="<%= portletURL.toString() %>" value="<%=currentTab %>"/>
	<%if(currentTab.equals(TinTucAdminField.value_tabtkbaiviet)){%>
	<liferay-util:include page="/html/thongketintuc/baiviet/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabtkchuyenmuc)){%>
	<liferay-util:include page="/html/thongketintuc/chuyenmuc/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabtktheloai)){%>
	<liferay-util:include page="/html/thongketintuc/theloai/list.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}else if(currentTab.equals(TinTucAdminField.value_tabtktacgia)){%>
	<liferay-util:include page="/html/thongketintuc/tacgia/list.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}}%>
