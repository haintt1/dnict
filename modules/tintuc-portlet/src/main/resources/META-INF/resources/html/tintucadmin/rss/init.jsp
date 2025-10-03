<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
<%
String baseURL = request.getContextPath();
//String nameSpace = renderResponse.getNamespace();
String currentURL = PortalUtil.getCurrentURL(request);
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String[] multicategory = prefs.getValues("multicategory", null);
if(Validator.isNotNull(multicategory)){
	for(int i=0; i<multicategory.length;i++){
		System.out.print("multi"+multicategory[i]);
	}
}

String trangchitiet = prefs.getValue("trangchitiet", "/chi-tiet-tin-tuc");
%>

<script src="<%=baseURL%>/js/jquery.js"></script>
<script src="<%=baseURL%>/js/jquery-ui.min.js"></script>
<script src="<%=baseURL%>/js/bootstrap.min.js"></script>