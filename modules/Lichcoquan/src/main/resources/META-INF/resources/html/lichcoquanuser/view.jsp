
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="lichcoquan.service.service.LichcoquanLocalServiceUtil"%>
<%@page import="vn.dnict.lichcoquan.utils.LichcoquanUtils"%>
<%@page import="lichcoquan.service.model.Lichcoquan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<portlet:defineObjects />

<div id="contentlichcoquan">
	<%
		DateFormat dfnam  = new SimpleDateFormat("yyyy");
		DateFormat df  = new SimpleDateFormat("dd/MM/yyyy");

		Lichcoquan lcq = LichcoquanUtils.getLastLichcoquanBanHanh(0);
		if(Validator.isNull(lcq)){
			lcq = LichcoquanLocalServiceUtil.createLichcoquan(0);		
		}
		String result = lcq.getContent();
		String tuanlabel = "";
		String namlabel  = "";
		tuanlabel = String.valueOf(lcq.getTuan());
		namlabel  = String.valueOf(lcq.getNam());
// 		}
	%>
	<%
		int currentWeek = ParamUtil.getInteger(request, "tuan");
		int lichcoquanid = ParamUtil.getInteger(request, "lichcoquanid");
		if(Validator.isNotNull(lichcoquanid) && lichcoquanid > 0){
			Lichcoquan lcqthem = LichcoquanLocalServiceUtil.fetchLichcoquan(lichcoquanid);
			if(Validator.isNull(lcqthem)){
				lcqthem = LichcoquanLocalServiceUtil.createLichcoquan(0);
			}
			result = lcqthem.getContent();
			tuanlabel = String.valueOf(lcqthem.getTuan());
			namlabel  = String.valueOf(lcqthem.getNam());
		}
		long lichcoquanidcheck = lcq.getLichCongtacId();
		if(lichcoquanid > 0){
			lichcoquanidcheck = (long) lichcoquanid;
		}
// 		if(currentWeek == 0){
// 			currentWeek = Week;
// 		}
	%>
	<div class="lichcongtaccoquan">
		<h3 style="text-align: center;">LỊCH CƠ QUAN TUẦN <%=tuanlabel %>  NĂM <%=namlabel%></h3>
	</div>
	<%=result%>
	<h4>Lịch công tác khác</h4>
	<div class="lichlienquan">
	<%
		List<Lichcoquan> listcqthem = LichcoquanUtils.listLichLienQuan(lichcoquanidcheck, 0, Integer.valueOf(soluonghienthi));
		if(listcqthem.size()<0){
			listcqthem = new ArrayList<Lichcoquan>();
		}
		for(Lichcoquan lcqt : listcqthem){
			if(lcqt.getLichCongtacId() != lichcoquanid){
	%>
		<portlet:renderURL var="lichcongtacxemthemURL">
			<portlet:param name="jspPage" value="/html/lichcoquanuser/view.jsp"/>
			<portlet:param name="lichcoquanid" value="<%=String.valueOf(lcqt.getLichCongtacId())%>"/>
			<portlet:param name="tuan" value="<%=String.valueOf(lcqt.getTuan())%>"/>
			<portlet:param name="nam" value="<%=String.valueOf(lcqt.getNam())%>"/>
		</portlet:renderURL>
		<span style="display: block;" class="<%="lct"+lcqt.getLichCongtacId()%>"><a href="<%=lichcongtacxemthemURL%>">Lịch cơ quan tuần <%=lcqt.getTuan()%> năm <%=lcqt.getNam()%></a></span>
	<%}}%>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function(){
	$('table').addClass('table table-bordered');
});
</script>