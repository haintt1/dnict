<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="lichcoquan.service.service.LichcoquanLocalServiceUtil"%>
<%@page import="lichcoquan.service.model.Lichcoquan"%>
<%@page import="vn.dnict.lichcoquan.utils.LichcoquanUtils"%>
<%@page import="vn.dnict.lichcoquan.portlet.LichcoquanAdminField"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="init.jsp" %>
  
  
  
<style>
.table-columns tr th {
	text-align: center !important
}
.tbcoreadmin tr td .input-prepend{
	display: inline-flex;
}
.tbcoreadmin tr td .input-prepend input{
	width: 70% !important;
	margin-left: 6px
}
</style>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Cấp ban hành</title>
	</head>
<body>
<%
if(tudongdongbo.equals("")){
	LichcoquanUtils.checkDongbo(macoquanadmin);
}

String tabListLichCoQuan = LichcoquanAdminField.value_tabDanhSachLichCoQuan;
String tungay = ParamUtil.getString(request, "tungay");
String denngay = ParamUtil.getString(request, "denngay");

PortletURL actionURL = renderResponse.createRenderURL();
actionURL.setParameter("tabs", tabListLichCoQuan);
actionURL.setParameter("tungay", tungay);
actionURL.setParameter("denngay", denngay);

PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("tabs", tabListLichCoQuan);



PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/vanbanphapquyadmin/capbanhanh/list.jsp");
actionURL.setParameter("tungay", tungay);
actionURL.setParameter("denngay", denngay);


int cur = ParamUtil.getInteger(request,"cur");
int delta = ParamUtil.getInteger(request, "delta", 20);
//int total= 0;
SearchContainer searchContainer1 = null;
if (cur > 0) {
	searchContainer1 = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
} else {
	searchContainer1 = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, delta,
			iteratorUrl, null, null);
}

int stt = searchContainer1.getStart() + 1;
%>
<fieldset class="fs-admin">
	<form action="<%=searchURL.toString()%>" method="post">
		<table class="tbcoreadmin table table-bordered">
				<tr>
					<th class="key label2">Ngày cập nhật</th>
					<td colspan="3">
						<div class="input-prepend">
							<span class="add-on" style="float: left;">Từ ngày</span> <input
								type="text" name="<portlet:namespace/>tungay" id="tungay"
								style="width: 85px" value="<%=tungay%>" />
						</div>
						<div class="input-prepend">
							<span class="add-on" style="float: left;">Đến ngày</span> <input
								type="text" name="<portlet:namespace/>denngay" id="denngay"
								style="width: 85px" value="<%=denngay%>" />
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="4" class="key input_2" style="text-align: center">
						<input class="btn  btn-primary btn-default" type="submit" value="Tìm kiếm">
					</td>
				</tr>
		</table>
	</form>
</fieldset><br>

<table>
<liferay-ui:search-container delta="20" total="<%= LichcoquanUtils.listCoquan(tungay, denngay, 0, 0).size() %>" 
	emptyResultsMessage="Chưa có liên kết nào" 
	iteratorURL="<%=actionURL%>">
	<liferay-ui:search-container-results
		results="<%= LichcoquanUtils.listCoquan(tungay, denngay, searchContainer1.getStart(), searchContainer1.getEnd())%>"
	/>

	<liferay-ui:search-container-row
		className="lichcoquan.service.model.Lichcoquan"
		modelVar="varLichcoquan"
		keyProperty="id"
	>
		<%
			Lichcoquan lcq = LichcoquanLocalServiceUtil.fetchLichcoquan(varLichcoquan.getLichCongtacId());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String ngayCapNhat = "";
			 if(Validator.isNotNull(lcq.getCreateDate())){
				 ngayCapNhat = df.format(lcq.getCreateDate());
		        }
		%>
		<portlet:renderURL var="editLichcoquan">
			<portlet:param name="id" value="<%=String.valueOf(varLichcoquan.getLichCongtacId())%>" />
			<portlet:param name="jspPage" value="/html/lichcoquanadmin/edit.jsp"/>
		</portlet:renderURL>
		<portlet:actionURL var="deleteURL" name="deleteAction">
			<portlet:param name="Lichcoquanid" value="<%=String.valueOf(varLichcoquan.getLichCongtacId())%>"/>
		</portlet:actionURL>
		<liferay-ui:search-container-column-text name="STT" align="center"><%=stt++ %></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Tuần"><a href="<%=editLichcoquan.toString() %>">Lịch Cơ quan tuần <%=lcq.getTuan()%> năm <%=lcq.getNam() %></a> </liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Ngày cập nhật" value="<%=ngayCapNhat %>"/>
		<%
			String trangthai = "";
			if(varLichcoquan.getTrangthai()== 0){
				trangthai = "Đã ban hành";
		       }else{	
		        trangthai = "Chưa ban hành";
	        }
		%>
		<liferay-ui:search-container-column-text name="Trạng thái ban hành" value="<%=trangthai %>" align="center"/>
		<liferay-ui:search-container-column-text name="Thao Tác" align="center"><a href= "<%=deleteURL %>" class = "dongbo-btn btn btn-danger"> Xóa</a></liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</table>
</body>
</html>
<script type="text/javascript">
jQuery(function($){
	$("#tungay").datepicker();
	$("#denngay").datepicker();
});
</script>
