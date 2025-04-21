<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="qlanphamdb.service.AnPham_TapChiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yêu cầu hiệu chỉnh bài viết</title>
</head>
<style>
	.hue_css {
	    margin-top: 40px;
	    margin-bottom: 0px !important;
	    margin-left: 30px;
	    margin-right: 30px;
	}
</style>
<body style="margin: 10px;">
<%
long id = ParamUtil.getLong(request, "id");
String contents = "";
AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(id);
%>
<portlet:actionURL var="saveYeuCauHieuChinhURL" name="saveYeuCauHieuChinh">
	<portlet:param name="idTapChi" value="<%=String.valueOf(id) %>"/>
	<portlet:param name="jspPage" value="/html/admin/tapchiktxh/view.jsp" />
</portlet:actionURL>
<portlet:resourceURL var="resourceURL3" id="ajaxAction3"></portlet:resourceURL>
<aui:form name="frmRequestModified" cssClass="hue_css" action="<%=saveYeuCauHieuChinhURL %>" method="post">
	<div class="form-content" style="">
		<div class="form-group-pm span12 row-fluid">
			<h4>Tiêu đề: <%=objTapChi.getTen() %></h4>
			<label for="noidung">Nhập nội dung yêu cầu hiệu chỉnh</label>
			<aui:fieldset>
		       <aui:field-wrapper>
		               <liferay-ui:input-editor  name="noidung" initMethod="initEditor"></liferay-ui:input-editor>
		       </aui:field-wrapper>
			</aui:fieldset>
		</div>
		<br>
    </div>
 	<aui:button type="submit" id="saveButton" value="Lưu hiệu chỉnh" onClick="hieuChinh(event)"></aui:button>
 	<aui:button type="button" id="closeButton" value="Đóng"/>	
</aui:form>
</body>
</html>
<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("jspPage", "/html/admin/tapchiktxh/view.jsp");
%>

<script>
	function <portlet:namespace />initEditor() {
		return "<%=UnicodeFormatter.toString(contents) %>";
	}
	function hieuChinh() {
		event.preventDefault();
		var editorInstance = CKEDITOR.instances["<portlet:namespace />noidung"];
		var editorContent = editorInstance.getData();
		$.ajax({
			 url: '<%=saveYeuCauHieuChinhURL %>',
			 type: 'POST',
			 data:
			 	{
				 	<portlet:namespace />noidung:editorContent,
				 	<portlet:namespace />anPhamId:<%=id%>
				},
			 success: function () {
				alert("Gửi yêu cầu hiệu chỉnh thành công");
      			var opener = Liferay.Util.getOpener();
      	        opener.location.reload(true); // Refresh lại trang cha
      	      	Liferay.Util.getWindow().destroy(); // Đóng modal
			 },
			 error: function (data) {
			 	alert("Lỗi dữ liệu từ server");
			 }
		})
	}
</script>

