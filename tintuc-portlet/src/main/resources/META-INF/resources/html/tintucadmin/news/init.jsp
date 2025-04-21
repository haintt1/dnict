<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.datetimepicker.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-confirm.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap-tagsinput/bootstrap-tagsinput.css"/>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-confirm.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.datetimepicker.full.min.js"></script>
<script src="<%=request.getContextPath() %>/js/bootstrap-tagsinput/bootstrap-tagsinput.js"></script>
<%
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String chondanhmuc = prefs.getValue("chondanhmuc","");
String key = user.getUserId()+"_checklangnews";
String checkLangNews   = prefs.getValue(key,"vi_VN");
String keySubCat = user.getUserId()+"_checklangcategory";
String checkLanguageSubCategory   = prefs.getValue(keySubCat,"vi_VN");

%>