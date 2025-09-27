
<%@page import="lichcoquan.service.service.LichcoquanLocalServiceUtil"%>
<%@page import="lichcoquan.service.model.Lichcoquan"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="init.jsp"%>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap-datetimepicker.min.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/moment.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/bootstrap-datetimepicker.min.js"></script>
<portlet:defineObjects />

<liferay-ui:success key="update-successfully"
	message="Chỉnh sửa lịch thành công" />
</head>
<body>
	<%
		long id = ParamUtil.getLong(request, "id");
		if(Validator.isNull(id)){
			Lichcoquan lich = LichcoquanLocalServiceUtil.createLichcoquan(id);
		}
		Lichcoquan lich = LichcoquanLocalServiceUtil.fetchLichcoquan(id);
		
	%>
	<portlet:actionURL var="saveURL" name="editLichcoquan">
		<portlet:param name="id" value="<%=String.valueOf(lich.getLichCongtacId())%>" />
		<portlet:param name="tuan" value="<%=String.valueOf(lich.getTuan())%>" />
		<portlet:param name="nam" value="<%=String.valueOf(lich.getNam())%>" />
	</portlet:actionURL>
	<portlet:renderURL var="backURL">
		<portlet:param name="jspPage" value="/html/lichcoquanadmin/view.jsp"></portlet:param>
	</portlet:renderURL>
	<p>
		Chỉnh sửa lịch tuần
		<%=lich.getTuan()%>
		năm
		<%=lich.getNam()%></p>
<form action="<%=saveURL%>" id="lichCoQuan" method="POST" name="">
	<table class="table table-bordered">
		<tr>
			<td align="left">
			<div style="float: right;">
				<button class="btn btn-info" type="submit" >Lưu</button> 
				<a href="<%=backURL.toString()%>" class="save-row btn">Quay lại</a>
				</div>	
			</td>
		</tr>
		<tr>
			<td>
				<textarea name='<portlet:namespace/>content' id="editor1" rows="10" cols="80">
                	<%=lich.getContent()%>
				</textarea>
			</td>
		</tr>
	</table>
</form>
<script>
 CKEDITOR.replace( 'editor1' );
</script>
