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

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.ui.theme.css" type="text/css" />
<link href="<%=request.getContextPath()%>/css/jquery.filer.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-confirm.css" />
<link href="<%=request.getContextPath()%>/css/jquery.filer-dragdropbox-theme.css" type="text/css" rel="stylesheet" />

<script>window.jQuery || document.write('<script src="<%=request.getContextPath()%>/js/jquery.js"><\/script>')</script>
<script src="<%=request.getContextPath()%>/js/jquery-ui.custom.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.filer.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.maskedinput.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.maskMoney.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker-vi.min.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery-confirm.js"></script>

<script>
    jQuery(document).ready(function($){
    	$.datepicker.setDefaults({
 	       changeMonth: true,
 	       changeYear: true       
 	    });
    });
</script>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
String currentURL = PortalUtil.getCurrentURL(request);
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String prefs_cauhinh = prefs.getValue("cauhinh",StringPool.BLANK);
String capbanhanh = prefs.getValue("capbanhanh","0");
String linhvucvanban = prefs.getValue("linhvucvanban","0");
String loaivanban = prefs.getValue("loaivanban","0");
String kieuhienthi = prefs.getValue("kieuhienthi","1");
if(prefs_cauhinh.equals("")){
	prefs_cauhinh ="default";
}
//van ban phap quy
String vbpq_portletid = prefs.getValue("vbpq_portletid", "0");
String vbpq_portletname= prefs.getValue("vbpq_portletname", "chitiet");
String prefs_stt = prefs.getValue("stt",StringPool.BLANK);
String prefs_groupId= prefs.getValue("groupId", StringPool.BLANK);
String prefs_companyId = prefs.getValue("companyId", StringPool.BLANK);
String prefs_sohieu = prefs.getValue("sohieu",StringPool.BLANK);
String prefs_cqbh = prefs.getValue("cqbh",StringPool.BLANK);
String prefs_lvb = prefs.getValue("lvb",StringPool.BLANK);
String prefs_lvvb = prefs.getValue("lvvb",StringPool.BLANK);
String prefs_trichyeu = prefs.getValue("trichyeu",StringPool.BLANK);
String prefs_nbh = prefs.getValue("nbh",StringPool.BLANK);
String prefs_filedk = prefs.getValue("filedk",StringPool.BLANK);
String prefs_luottai = prefs.getValue("luottai",StringPool.BLANK);
String prefs_sort = prefs.getValue("sortable", StringPool.BLANK);
String vbdi = prefs.getValue("vbdi", StringPool.BLANK);
String vbden = prefs.getValue("vbden", StringPool.BLANK);
String vbbaucu = prefs.getValue("vbbaucu", StringPool.BLANK);
String vbkhac = prefs.getValue("vbkhac", StringPool.BLANK);
String vbqppl = prefs.getValue("vbqppl", StringPool.BLANK);
String giaodien = prefs.getValue("giaodien", "giaodien1");
String hienthipdf = prefs.getValue("hienthipdf", "0");
String cauhinhrieng = prefs.getValue("cauhinhrieng","0");
// String checkview = prefs.getValue("checkview", StringPool.BLANK);
String checkview ="view1";
String limit_row = prefs.getValue("limit_row","20");
//van ban chi dao dieu hanh
//Config file extends
String fileext = prefs.getValue("fileext",StringPool.BLANK);
String filemaxlength = prefs.getValue("filemaxlength",StringPool.BLANK);

if(fileext.equals("")){
	fileext = "doc|docx|xls|xlsx|pdf";
}
if(filemaxlength.equals("") || !Validator.isNumber(filemaxlength)){
	filemaxlength = "1";
}
//Config category
String cat_loaivanban = prefs.getValue("loaivanban",StringPool.BLANK);
String cat_linhvucvanban = prefs.getValue("linhvucvanban",StringPool.BLANK);
String cat_capbanhanh = prefs.getValue("capbanhanh",StringPool.BLANK);
String cat_coquanbanhanh = prefs.getValue("coquanbanhanh",StringPool.BLANK);
//Config van ban lien quan
String prefs_vanbanlienquan = prefs.getValue("vanbanlienquan",StringPool.BLANK);
String prefs_lienquantheo = prefs.getValue("lienquantheo",StringPool.BLANK);
String prefs_limit_vblq = prefs.getValue("limit_vblq",StringPool.BLANK);
/*String prefs_kieuvanban = prefs.getValue("kieuvanban", StringPool.BLANK);
if(prefs_kieuvanban.equals("")){
	prefs_kieuvanban="vbpq";
}*/
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
