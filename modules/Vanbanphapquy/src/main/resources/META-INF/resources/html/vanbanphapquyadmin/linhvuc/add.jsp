
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@page import="java.util.List"%>

<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<portlet:defineObjects />
<body>
<%
	String tabLinhvucvanban = VanbanphapquyAdminField.value_tabLinhVuc;
%>
<portlet:actionURL var="addLinhvucvanbanURL" name="addLinhvucvanban">
	<portlet:param name="tabs" value="<%=tabLinhvucvanban %>"/>
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/view.jsp"/>
	<portlet:param name="tabs" value="<%=tabLinhvucvanban %>"/>
</portlet:renderURL>
<div class="portlet-content-container">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
								<aui:form action="${addLinhvucvanbanURL }" name="linkForm" method="POST">
									<table class="tbcoreadmin">
										<tr>
											<td class="key label2">Tên lĩnh vực văn bản</td>
											<td>
												<aui:input name="name" size="40" label="">
													<aui:validator name="required"></aui:validator>
												</aui:input>
											</td>
										</tr>
										<tr>
											<td class="key label2">Mã</td>
											<td>
												<aui:input name="code" size="40" label="">
													<aui:validator name="required"></aui:validator>
												</aui:input>
											</td>
										</tr>
										<tr>
											<td class="key label2">Hiển thị</td>
											<td><aui:input name="status" type="checkbox" label="" checked="true"/></td>
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