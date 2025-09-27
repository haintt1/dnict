<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-duallistbox.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/datepicker.css" />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootbox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskMoney.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/table-edits.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/ckeditor/ckeditor.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.bootstrap-duallistbox.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker-vi.min.js"></script>


<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
String currentURL = PortalUtil.getCurrentURL(request);
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
//String kieulich = prefs.getValue("kieulich",StringPool.BLANK);
//String macoquan = prefs.getValue("macoquan",StringPool.BLANK);
//String tudongdongboUser = prefs.getValue("tudongdongboUser",StringPool.BLANK);
//String macoquanadmin = prefs.getValue("macoquanadmin", StringPool.BLANK);
//String dongbo = prefs.getValue("dongbo","");
//String tudongdongbo = prefs.getValue("tudongdongbo", "");
String soluonghienthi = prefs.getValue("soluonghienthi","10");
//String speed = prefs.getValue("speed",StringPool.BLANK);
//String frameRate = prefs.getValue("frameRate",StringPool.BLANK);
//String timeout = prefs.getValue("timeout",StringPool.BLANK);
//String height = prefs.getValue("height",StringPool.BLANK);
/*
if(speed.equals("") || !Validator.isNumber(speed)){
	speed = "1";
}
if(frameRate.equals("") || !Validator.isNumber(frameRate)){
	frameRate = "24";
}
if(timeout.equals("") || !Validator.isNumber(timeout)){
	timeout = "300000";
}
if(height.equals("") || !Validator.isNumber(height)){
	height = "700";
}
*/
%>
