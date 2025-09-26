<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource   = ParamUtil.getString(request, "portletResource");
//String idaricle = request.getParameter("idarticle");
//System.out.println("INI" + idaricle);
if(Validator.isNotNull(portletResource)){
	prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
//cấu hình chi tiết tin tức
String ungdung  = prefs.getValue("ungdung",StringPool.BLANK);
long category           = Long.valueOf(prefs.getValue("category","0"));
String sotinhienthi      = prefs.getValue("sotinhienthi","10");
String sotinlienquan     = prefs.getValue("sotinlienquan","10");
String dodaitieude       = prefs.getValue("dodaitieude","150");
String dodaimota         = prefs.getValue("dodaimota","200");
String khoangcachslide   = prefs.getValue("khoangcachslide","20");
String thoigianchuyenslide   = prefs.getValue("thoigianchuyenslide","3500");
String tocdoslide		 = prefs.getValue("tocdoslide", "2000");
String hienthixemthem    = prefs.getValue("hienthixemthem", "0");
String langcheck			 = prefs.getValue("ngonngu", "vi_VN");
String category_active   = prefs.getValue("category_active", StringPool.BLANK);
String category_hide     = prefs.getValue("category_hide", "0");
String readmore_hide	= prefs.getValue("readmore_hide", "0");
String des_hide_dt		 = prefs.getValue("des_hide_dt", "0");
String newimg			 = prefs.getValue("newimg", "0");
String trangchitiet      = prefs.getValue("trangchitiet", "/chi-tiet-tin-tuc");
String trangchitietmoi   = prefs.getValue("trangchitietmoi", "/chi-tiet-tin-tuc");
String hienthitintuc      = prefs.getValue("hienthitintuc", "/chi-tiet-tin-tuc");
String sotinhienthilienquan     = prefs.getValue("sotinhienthilienquan","10");
String sotinlienquanhienthi     = prefs.getValue("sotinlienquanhienthi","10");
String dodaitieudetinlienquan = prefs.getValue("dodaitieudetinlienquan", "150");
String dodaimotatinlienquan   = prefs.getValue("dodaimotatinlienquan","200");
String search_page_iframe  = prefs.getValue("search_page_iframe", "/ket-qua");
String search_text       = prefs.getValue("search_text", "Tìm kiếm");
String donvisudung		 = prefs.getValue("donvisudung", "");
String iconnew 			 = prefs.getValue("iconnew", "0");
String textToSpeech		 = prefs.getValue("textToSpeech", "0");
String ctv		 = prefs.getValue("ctv", "0");
String binhluan		 = prefs.getValue("binhluan", "0");
String banquyen		 = prefs.getValue("banquyen", "0");
String linkbanquyen      = prefs.getValue("linkbanquyen", "");
String tukhoa		 = prefs.getValue("tukhoa", "0");
String tieudetintuc		 = prefs.getValue("tieudetintuc", StringPool.BLANK);//code 2/1/2017
String chieucaokhungnoibat = prefs.getValue("chieucaokhungnoibat", "350");
String kieuhienthipdf	   = prefs.getValue("kieuhienthipdf", "0");
String order_category	   = prefs.getValue("order_category", "");
kieuhienthipdf	   = prefs.getValue("kieuhienthipdf", "default");
String checkChuKy	   = prefs.getValue("checkChuKy", StringPool.BLANK);
String noiDungChKy	   = prefs.getValue("noiDungChKy", "");
String tenclass	   = prefs.getValue("tenclass", "");


//System.out.print("xem" + hienthixemthem);
//String idarticle = prefs.getValue("idarticle",request.getParameter("idarticle"));
//String textToSpeechHT		 = prefs.getValue("textToSpeechHT", "0");
%>
