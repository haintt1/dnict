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
		    <th class="keycolor">Số lượng tin hiển thị (danh sách tin tức)</th>
		     <td>
		     	<input type="text" name="<portlet:namespace/>sotinhienthi" value="<%=sotinhienthi%>">
		    </td>
		</tr>
		<tr>
			<th class="keycolor">Trang hiển thị chi tiết</th>
			<td colspan="3"><input type="text" name="<portlet:namespace/>trangchitiet" value="<%=trangchitiet%>"></td>
		</tr>
		<tr>
			 <th class="keycolor">Số tin liên quan hiển thị (Chi tiết tin tức)<br/>(Sẽ là số tin hiển thị trên từng view nếu là kiểu tin chuyển động)</th>
		     <td><input type="text" name="<portlet:namespace/>sotinhienthilienquan" value="<%=sotinhienthilienquan%>"></td>
		</tr>
		<tr>
			 <th class="keycolor">Rating</th>
		     <td>
		     	<input type="checkbox" name="<portlet:namespace/>rating" <%=rating.equals("")?"":"checked"%>>
		    </td>
		</tr>
		<tr>
			<th class="keycolor">Text to speech</th>
			<%
				String hide_texttospeech= "";
				if(textToSpeechHT.equals("1")){
					hide_texttospeech = "checked";
				}
			%>
			<td>
				<input name ="<portlet:namespace/>textToSpeechHT" type="checkbox"  <%=hide_texttospeech%>/>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<input type="button" value="save" onClick="submitForm(document.<portlet:namespace />fm);" />
			</td>
		</tr>
	</table>
</form>
