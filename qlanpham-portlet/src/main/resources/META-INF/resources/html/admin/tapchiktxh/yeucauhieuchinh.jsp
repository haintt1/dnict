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
String status = ParamUtil.getString(request, "statusOK");
System.out.println(status);
long id = 0;
id = ParamUtil.getLong(request, "id");
String contents = "";
AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(id);
%>
<portlet:actionURL var="saveYeuCauHieuChinhURL" name="saveYeuCauHieuChinh">
	<portlet:param name="idTapChi" value="<%=String.valueOf(id) %>"/>
</portlet:actionURL>
<portlet:renderURL var="successURL">
	<portlet:param name="jspPage" value="/html/admin/tapchiktxh/demo.jsp"/>
</portlet:renderURL>
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
 		<aui:button type="submit" id="saveButton" cssClass="btn-pm btn-submit-pm"  value="Lưu hiệu chỉnh"></aui:button>
 		<aui:button name="closeDialog" type="button" value="Đóng" />
</aui:form>

</body>
</html>
<script>
function <portlet:namespace />initEditor() {
   return "<%=UnicodeFormatter.toString(contents) %>";
}
</script>


<aui:script use="aui-base,aui-io-request">
	A.one('#<portlet:namespace/>saveButton').on('click', function(event){
		var A = AUI();
		var url = '';
		A.io.request(
	    url,
	      {
	      	method: 'POST',
	        on: {  
	          success: function() {	
	          	alert("Gửi yêu cầu hiệu chỉnh thành công");                 		  		
	            var opener = Liferay.Util.getOpener();
            	opener.location.reload(); // Refresh lại trang cha
            	Liferay.Util.getWindow().destroy(); // Đóng modal
	          	}
	        }
	      }
	    )
	});
</aui:script>


<aui:script use="aui-base">
    A.one('#<portlet:namespace/>closeDialog').on('click', function(event) {
        Liferay.Util.getWindow().destroy(); // Close the current modal
    });
</aui:script>