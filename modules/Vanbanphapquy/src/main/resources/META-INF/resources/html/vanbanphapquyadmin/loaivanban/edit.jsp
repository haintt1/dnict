
<%@page import="vn.dnict.vanbanphapquy.model.Loaivanban"%>
<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletPreferences" %>

<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../init.jsp" %>
<portlet:defineObjects />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%
	String tabLoaivanban = VanbanphapquyAdminField.value_tabLoaiVanBan;
	Loaivanban editLoaivanban = (Loaivanban) request.getAttribute("editLoaivanban");
%>
<portlet:actionURL var="updateLoaivanbanURL" name="updateLoaivanban">
	<portlet:param name="tabs" value="<%=tabLoaivanban %>"/>
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/view.jsp"/>
	<portlet:param name="tabs" value="<%=tabLoaivanban %>"/>
</portlet:renderURL>

<div class="portlet-content-container">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
								<aui:form action="<%=updateLoaivanbanURL.toString() %>" name="" method="POST">
									<table class="tbcoreadmin">
										<tr>
											<td class="key label2">Tên</td>
											<td>
												<aui:input name="id" type="hidden" value="<%=editLoaivanban.getId() %>"/>
												<aui:input name="name" size="40" label="" value="<%=editLoaivanban.getName() %>">
													<aui:validator name="required"></aui:validator>
												</aui:input>
											</td>
										</tr>
										<tr>
											<td class="key label2">Mã</td>
											<td>
												<aui:input name="code" size="40" label="" value="<%=editLoaivanban.getCode() %>">
													<aui:validator name="required"></aui:validator>
												</aui:input>
											</td>
										</tr>
										<tr>
											<td class="key label2">Hiển thị</td>
											<td><aui:input name="status" checked="<%=editLoaivanban.getStatus()==1?true:false%>" type="checkbox" label="Hiển thị"/></td>
										</tr>
										<tr>
											<td class="key label2">
												<aui:button type="submit" value="Lưu"/>
												<a  href="<%=cancelURL%>"><aui:button value="Quay lại"/></a>
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
</body>
</html>