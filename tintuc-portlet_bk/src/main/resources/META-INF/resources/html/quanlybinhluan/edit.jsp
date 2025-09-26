<%@page import="vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_BinhLuan"%>
<%@page import="vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_NguonTin"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="vn.dnict.tintuc.service.News_TypeLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="java.util.List"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<portlet:actionURL name="updateBinhLuan" var="updateBinhLuanURL" />
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/quanlybinhluan/view.jsp" />
</portlet:renderURL>
<%
String id = ParamUtil.getString(request, "binhluanid");
News_BinhLuan objBinhLuan = News_BinhLuanLocalServiceUtil.fetchNews_BinhLuan(Long.valueOf(id));
%>

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
							<aui:form name="formAddThongTin" action="<%=updateBinhLuanURL %>"
								method="post">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Nội dung bình luận</label>
											<aui:input name="binhluanid" type="hidden" value="<%=Long.valueOf(id)%>"></aui:input>
											<aui:input name="noiDung" label="" value="<%=objBinhLuan.getNoiDung() %>" type="textarea">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">500</aui:validator>
											</aui:input>
										</td>	
									</tr>
									<tr>
										<td colspan="1">
											<label class="control-label">Duyệt hiển thị (Kích chọn nếu cho phép hiển thị)</label>
											<input id="status" name="status" label="" type="checkbox" style="margin-top: 26px;margin-left: 12px;" checked="<%=objBinhLuan.getStatus() == 0?true:false %>" />
										</td>
									</tr>
									<tr>
										<td colspan="2" class="key" style="text-align: center;"><aui:button-row>
												<aui:button type="submit" value="Lưu thông tin" />
												<a href="<%=cancelURL.toString()%>"><aui:button type="cancel"
														value="Quay lại" /></a>
											</aui:button-row></td>
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




