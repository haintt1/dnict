<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<liferay-ui:success key="save-successfully" message="Đã lưu ! Sẽ có hiệu lực sau khi Refresh trang"></liferay-ui:success>
<form action="<liferay-portlet:actionURL portletConfiguration="true"/>" method="post" name='<portlet:namespace/>fm'>
 	<input name='<portlet:namespace/><%=Constants.CMD%>' type="hidden" value="<%=Constants.UPDATE%>"/>
	<table class="table table-bordered">		
		<tr>
		    <th class="keycolor">Số lượng lịch liên quan</th>
		     <td>
		     	<input type="text" name="<portlet:namespace/>soluonghienthi" value="<%=soluonghienthi%>">
		    </td>		   
		</tr>		
		<tr>
			<td colspan="2">
				<input type="button" value="save" onClick="submitForm(document.<portlet:namespace />fm);" />
			</td>
		</tr>
	</table>
</form>
