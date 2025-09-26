<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.service.News_ActivityLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
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
//contents = ParamUtil.getString(request, "noidung");
//System.out.println(contents);
News_Article objNews = News_ArticleLocalServiceUtil.fetchNews_Article(id);
%>
<portlet:actionURL var="saveYeuCauHieuChinhURL" name="saveYeuCauHieuChinh">
	<portlet:param name="idNews" value="<%=String.valueOf(id) %>"/>
</portlet:actionURL>
<portlet:renderURL var="successURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/categories/view.jsp"/>
</portlet:renderURL>
<aui:form name="frmRequestModified" cssClass="hue_css" action="<%=saveYeuCauHieuChinhURL %>" method="post">
	<aui:input name="redirect" type="hidden" value="<%=successURL %>" />
	<div class="form-content" style="">
		<div class="form-group-pm span12 row-fluid">
			<h4>Tiêu đề bài viết: <%=objNews.getTitle() %></h4>
			<label for="noidung">Nhập nội dung yêu cầu hiệu chỉnh</label>
			<aui:fieldset>
		       <aui:field-wrapper>
		               <liferay-ui:input-editor  name="noidung" initMethod="initEditor"></liferay-ui:input-editor>
		       </aui:field-wrapper>
			</aui:fieldset>
		</div>
		<br>
    </div>

    	<input name="<portlet:namespace/>typeaction" type="hidden" value="yeucauhieuchinh"></input>
 		<aui:button type="submit" id="saveButton"   cssClass="btn-pm btn-submit-pm"  value=" Lưu hiệu chỉnh" label=""></aui:button>
 		<input type="button" id="closeButton" style="text-decoration: none; margin-top: 10px; height: 35px !important; line-height: 10px; font-size: 11pt;" value="Quay lại"></input>	
</aui:form>

</body>
</html>
<script>
function <portlet:namespace />initEditor() {
   return "<%=UnicodeFormatter.toString(contents) %>";
}
var check = "";
/* $('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

$('#saveButton').click(function(){
	submitForm(document.<portlet:namespace />frmRequestModified);
}); */

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
	            	Liferay.Util.getOpener().yeucauhieuchinh();
	          }
	        }
	      }
	    )
	});
</aui:script>


<aui:script>

$('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});
</aui:script>