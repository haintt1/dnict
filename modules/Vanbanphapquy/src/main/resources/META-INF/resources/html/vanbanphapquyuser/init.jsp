<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery-ui.custom.min.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery.filer.min.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery.maskedinput.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery.maskMoney.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery.ui.datepicker-vi.min.js"></script>
<script src="/o/vn.dnict.vanbanphapquy.actions/js/jquery-confirm.js"></script>
<link rel="stylesheet" href="/o/vn.dnict.vanbanphapquy.actions/css/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="/o/vn.dnict.vanbanphapquy.actions/css/jquery.ui.theme.css" type="text/css" />
<link href="/o/vn.dnict.vanbanphapquy.actions/css/jquery.filer.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="/o/vn.dnict.vanbanphapquy.actions/css/jquery-confirm.css" />
<link href="/o/vn.dnict.vanbanphapquy.actions/css/jquery.filer-dragdropbox-theme.css" type="text/css" rel="stylesheet" />

<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
String currentURL = PortalUtil.getCurrentURL(request);
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String giaodien  = prefs.getValue("giaodien",StringPool.BLANK);
String capbanhanh = prefs.getValue("capbanhanh","0");
String linhvucvanban = prefs.getValue("linhvucvanban","0");
String vbcddh = prefs.getValue("vbcddh", "0");
String vbmoi = prefs.getValue("vbmoi", "0");
String vbbaucu = prefs.getValue("vbbaucu", "0");
String vbkhac = prefs.getValue("vbkhac", "0");
String vbqppl = prefs.getValue("vbqppl", "0");
String hienthipdf = prefs.getValue("hienthipdf", "0");
String vbpq_portletid = prefs.getValue("vbpq_portletid", "0");
String vbpq_portletname= prefs.getValue("vbpq_portletname", "chitiet");
String prefs_vanbanlienquan = prefs.getValue("vanbanlienquan",StringPool.BLANK);
String prefs_lienquantheo = prefs.getValue("lienquantheo",StringPool.BLANK);
String prefs_limit_vblq = prefs.getValue("limit_vblq",StringPool.BLANK);
String limit_row = prefs.getValue("limit_row","20");

if(prefs_vanbanlienquan.equals("")){
	prefs_vanbanlienquan ="yes";
}
if(vbpq_portletname.equals(""))
{
	vbpq_portletname="chitiet";	
}
if(vbpq_portletid.equals("")){
	vbpq_portletid="0";
}
if(prefs_lienquantheo.equals("")){
	prefs_lienquantheo ="lvvb";
}
if(prefs_limit_vblq.equals("") || !Validator.isNumber(prefs_limit_vblq)){
	prefs_limit_vblq = "5";
}
%>
