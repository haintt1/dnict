<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<liferay-theme:defineObjects />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<portlet:defineObjects />
<%
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource   = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String sotinhienthi      = prefs.getValue("sotinhienthi","10");
String trangchitiet      = prefs.getValue("trangchitiet", "/chi-tiet-tin-tuc");
String sotinhienthilienquan     = prefs.getValue("sotinhienthilienquan","10");
String rating 			 = prefs.getValue("rating",StringPool.BLANK);
String textToSpeechHT	 = prefs.getValue("textToSpeechHT", "0");
String langcheck		 = prefs.getValue("ngonngu", "vi_VN");
String dinhdanh 		 = prefs.getValue("dinhdanh",StringPool.BLANK);
String searchNew 		 = prefs.getValue("searchNew",StringPool.BLANK);
String order_article	 = prefs.getValue("order_article", "");
String idarticle	 	 = prefs.getValue("data_aricle", StringPool.BLANK);

%>
