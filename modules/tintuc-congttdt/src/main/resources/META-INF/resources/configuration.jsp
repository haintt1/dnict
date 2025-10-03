<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<!--<liferay-portlet:renderURL portletConfiguration="<%= true %>"
    var="configurationRenderURL" />-->
<liferay-ui:success key="save-successfully" message="Đã lưu ! Sẽ có hiệu lực sau khi Refresh trang"></liferay-ui:success>
<form action="<%= configurationActionURL %>" name="fm" method="post" autocomplete="off">
	<input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<!--<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>" />-->
	<div style="padding: 20px">
		<table class="table table-bordered">
		<tr>
		    <th class="keycolor">Ứng dụng</th>
		     <td colspan="3">
		     	<select name='<portlet:namespace/>ungdung'>
		     		<option value="">--Chọn ứng dụng--</option>
		     		<option value="vanbandieuhanh" <%=ungdung.equals("vanbandieuhanh")?"selected":""%>>Văn bản điều hành</option>
		     		<option value="tinchidaodieuhanh" <%=ungdung.equals("tinchidaodieuhanh")?"selected":""%>>Tin chỉ đạo điều hành</option>
		     		<option value=tinhoatdonglanhdao <%=ungdung.equals("tinhoatdonglanhdao")?"selected":""%>>Tin hoạt động lãnh đạo</option>
		     	</select>
		    </td>
		</tr>
		<tr>
			<th class="keycolor">Đường dẫn tích hợp</th>
		    <td colspan="3">
		    	<input type="text" name="<portlet:namespace/>url_api" value="<%=url_api%>"/>
		    </td>
		</tr>
		<tr>
			<th class="keycolor">Token</th>
		    <td colspan="3">
		    	<input type="text" name="<portlet:namespace/>token" value="<%=token%>"/>
		    </td>
		</tr>
		<tr>
			<td colspan="4">
				<button type="submit" onclick="submitForm(document.<portlet:namespace />fm);">Lưu</button>
			</td>
		</tr>
	</table>
	</div>
</form>    
    
