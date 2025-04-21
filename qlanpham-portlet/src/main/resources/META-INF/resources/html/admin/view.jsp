<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.model.Portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="init.jsp" %>
<body>
<%
	Portlet portlet = layoutTypePortlet.getAllPortlets().get(0);
	portlet.setDisplayName("Quản lý đề cương");
	ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	String tabValues = "";
	String tabNames = "";
	if(Validator.isNotNull(td)){
		tabValues = QlanphamAdminField.value_tabdecuong + ","
				+ QlanphamAdminField.value_tabphancong + ","
				+ QlanphamAdminField.value_tabcongtacvien + ","
				+ QlanphamAdminField.value_tabdmloai;
				
		tabNames = QlanphamAdminField.tabdecuong + ","
				+ QlanphamAdminField.tabphancong + ","
				+ QlanphamAdminField.tabcongtacvien + ","
				+ QlanphamAdminField.tabdmloai;
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
		//System.out.println(currentTab + " = ");
	%>
	<div class="container-fluid container-fluid-max-xl">
	<div class="portlet-content-container" style="width: 100%">
	<liferay-ui:tabs names="<%=tabNames%>" tabsValues="<%=tabValues %>"  url="<%= portletURL.toString() %>" value="<%=currentTab %>"/>
		<%if(currentTab.equals(QlanphamAdminField.value_tabdecuong)){%>
		<liferay-util:include page="/html/admin/decuong/view.jsp" servletContext="<%=this.getServletContext()%>"/>
		<%}else if(currentTab.equals(QlanphamAdminField.value_tabphancong)){%>
		<liferay-util:include page="/html/admin/phancong/view.jsp" servletContext="<%=this.getServletContext()%>"/>
		<%}else if(currentTab.equals(QlanphamAdminField.value_tabcongtacvien)){%>
		<liferay-util:include page="/html/admin/congtacvien/view.jsp" servletContext="<%=this.getServletContext()%>"/>
		<%}else if(currentTab.equals(QlanphamAdminField.value_tabdmloai)){%>
		<liferay-util:include page="/html/admin/dmloai/view.jsp" servletContext="<%=this.getServletContext()%>"/>
	<%}}%>
	</div>
	</div>
</body>