<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Linhvucvanban"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="init.jsp" %>

<portlet:defineObjects/>
<liferay-ui:success key="save-successfully" message="Đã lưu thành công ! Sẽ có hiệu lực sau khi Refresh trang"></liferay-ui:success>
<style>
.portlet-configuration-setup{
	padding: 15px;
}
</style>
<form action="<liferay-portlet:actionURL portletConfiguration="true"/>" method="post" name='<portlet:namespace/>fm'>
 <input name='<portlet:namespace/><%=Constants.CMD%>' type="hidden" value="<%=Constants.UPDATE%>"/>
 <fieldset>
 	<legend>Cấu hình Văn bản pháp quy</legend>
<table class="fr_tbcore tbcoreadmin table table-bordered">
	<tr>
		    <th class="keycolor">Giao diện</th>
		     <td colspan="3">
		     	<select name='<portlet:namespace/>giaodien'>
		     		<option value="-1">--Chọn giao diện--</option>
		     		<option value="home" <%=giaodien.equals("home")?"selected":""%>>Trang chủ</option>
		     		<option value="list" <%=giaodien.equals("list")?"selected":""%>>Danh sách - Tìm kiếm</option>
		     	</select>
		     </td>
		    </tr>
	<tr>
		<td>Chọn kiểu văn bản cần hiển thị</td>
		<td colspan="3">
		<%
		String check_vbqppl= "";
		String check_vbcddh= "";
		String check_vbmoi= "";
		String check_vbbaucu= "";
		String check_vbkhac= "";
		if(vbqppl.equals("1")){
			check_vbqppl = "checked";
		}
		if(vbcddh.equals("1")){
			check_vbcddh = "checked";
		}
		if(vbmoi.equals("1")){
			check_vbmoi = "checked";
		}
		if(vbbaucu.equals("1")){
			check_vbbaucu = "checked";
		}
		if(vbkhac.equals("1")){
			check_vbkhac = "checked";
		}
		%>
			<input type="checkbox" name="<portlet:namespace/>vbqppl" <%=check_vbqppl%>>&nbsp;Văn bản quy phạm pháp luật<br>
			<input type="checkbox" name="<portlet:namespace/>vbcddh" <%=check_vbcddh%>>&nbsp;Văn bản chỉ đạo điều hành<br>
			<input type="checkbox" name="<portlet:namespace/>vbmoi" <%=check_vbmoi%>>&nbsp;Văn bản mới<br>
			<input type="checkbox" name="<portlet:namespace/>vbbaucu" <%=check_vbbaucu%>>&nbsp;Văn bản bầu cử<br>
			<input type="checkbox" name="<portlet:namespace/>vbkhac" <%=check_vbkhac%>>&nbsp;Văn bản khác<br>			
		</td>
	</tr>
	<tr>
		<td>Hiển thị chức năng xem PDF</td>
		<td colspan="3">
			<select name="<portlet:namespace/>hienthipdf">
				<option value="1" <%=hienthipdf.equals("1")?"selected":""%>>Hiển thị chức năng xem PDF</option>
				<option value="0" <%=hienthipdf.equals("0")?"selected":""%>>Không hiển thị chức năng xem PDF</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>Lĩnh vực hiển thị</td>
		<td colspan="3">
			<select name="<portlet:namespace/>linhvucvanban">
				<option value="0">-Chọn lĩnh vực-</option>
				<%
				 List<Linhvucvanban> listlvvb = VanbanphapquyAdminUtil.getLinhvucvanbanByStatus(renderRequest,1); 
				for(int i=0;i<listlvvb.size();i++){
					String selected="";
					if(listlvvb.get(i).getId()==Long.valueOf(linhvucvanban)){
						selected ="selected";
					}
				%>
				<option value="<%=listlvvb.get(i).getId()%>" <%=selected%>><%=listlvvb.get(i).getName()%></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td>Chọn cấp ban hành</td>
		<td colspan="3">
			<select name="<portlet:namespace/>capbanhanh">
				<option value="0">-Chọn cấp ban hành-</option>
				<%
				List<Capbanhanh> listcbh = VanbanphapquyAdminUtil.getCapbanhanhByStatus(renderRequest, 1);
				for(int i=0;i<listcbh.size();i++){
					String selected="";
					if(listcbh.get(i).getId()==Long.valueOf(capbanhanh)){
						selected ="selected";
					}
				%>
				<option value="<%=listcbh.get(i).getId()%>" <%=selected%>><%=listcbh.get(i).getName()%></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="4">
			Văn bản liên quan
			<select name="<portlet:namespace/>vanbanlienquan">
				<option value="yes" <%=prefs_vanbanlienquan.equals("yes")?"selected":""%>>Hiển thị</option>
				<option value="no" <%=prefs_vanbanlienquan.equals("no")?"selected":""%>>Không hiển thị</option>
			</select>
			&nbsp;
			Liên quan theo
			<select name="<portlet:namespace/>lienquantheo">
				<option value="lvvb" <%=prefs_lienquantheo.equals("lvvb")?"selected":""%>>Lĩnh vực văn bản</option>
				<option value="lvb" <%=prefs_lienquantheo.equals("lvb")?"selected":""%>>Loại văn bản</option>
				<option value="cqbh" <%=prefs_lienquantheo.equals("cqbh")?"selected":""%>>Cơ quan ban hành</option>
				<option value="cbh" <%=prefs_lienquantheo.equals("cbh")?"selected":""%>>Cấp ban hành</option>
			</select>
			&nbsp;
			Cho phép <input type="text" name="<portlet:namespace/>limit_vblq" size="5" value="<%=prefs_limit_vblq%>"/> văn bản liên quan
		</td>
	</tr>
	<tr>
		 <td colspan="4">Số hiệu liên kết: <%=themeDisplay.getPlid()%></td>
	</tr>
	<tr>
     <td colspan="4">Tin trên trang: <input type="text" name="<portlet:namespace/>limit_row" value="<%=limit_row%>"/></td>
	</tr>
	<tr>
	<td>nhập số hiệu liên kết: <input type="text" size="15" name='<portlet:namespace/>vbpq_portletid' value="<%=vbpq_portletid%>">
		nhập tên liên kết: <input type="text" size="15" name='<portlet:namespace/>vbpq_portletname' value="<%= vbpq_portletname%>">
	</td>
	</tr>
	<tr>
		<td colspan="4">
			<input type="button" value="<liferay-ui:message key="save" />"
				onClick="submitForm(document.<portlet:namespace />fm);" />
		</td>
	</tr>
</table> 	
</fieldset>
</form>