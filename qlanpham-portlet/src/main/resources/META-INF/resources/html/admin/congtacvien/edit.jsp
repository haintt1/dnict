<%@page import="qlanphamdb.model.AnPham_CongTacVien"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String tabCongTacVien = QlanphamAdminField.value_tabcongtacvien;
	AnPham_CongTacVien congTacVien = (AnPham_CongTacVien) request.getAttribute("congTacVien");
	boolean status = congTacVien.getStatus()==1?true:false;
	
%>
<portlet:actionURL name="updateCTV" var="updateCTVURL">
	<portlet:param name="tabs" value="<%=tabCongTacVien %>" />
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="tabs" value="<%=tabCongTacVien %>" />
</portlet:renderURL>

<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
							<aui:form name="formAddThongTin" action="<%=updateCTVURL.toString() %>"
								method="post">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td >
											<label class="control-label">Họ tên</label>
											<aui:input name="id" type="hidden" value="<%=congTacVien.getId()%>"></aui:input>
											<aui:input name="hoTen" label="" value="<%=congTacVien.getHoTen() %>" type="input">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">500</aui:validator>
											</aui:input>
										</td>	
										<td>
											<label class="control-label">Email</label>
											<aui:input name="email" label="" type="input" value="<%=congTacVien.getEmail() %>">
												<aui:validator name="required"></aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<td colspan="2">
											<label class="control-label">Thông tin</label>
											<aui:input name="thongTin" label="" type="textarea"  value="<%=congTacVien.getThongTin() %>" />
										</td>	
									</tr>
									<tr>
										<td>
											<label class="control-label">Thứ tự</label>
											<aui:input name="orders" value="<%=congTacVien.getOrders() %>" label="" type="input">
												<aui:validator name="number"></aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<td>
											<label class="control-label">Sử dụng</label>
											<aui:input name="status" type="checkbox" label="" checked="<%=status %>"/>
										</td>
									</tr>
									<tr>
										<td colspan="2" class="key" style="text-align: center;"><aui:button-row>
											<aui:button type="submit" value="Lưu thông tin" />
												<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>
											</aui:button-row>
										</td>
									</tr>
								</table>
							</aui:form>
							</div>
						</div>
					</fieldset>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
</nav>	

</body>



