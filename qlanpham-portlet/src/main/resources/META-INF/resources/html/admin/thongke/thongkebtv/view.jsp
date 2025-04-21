<%@page import="qlanpham.portlet.utils.ThongKeAdminUtil"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String currentURL = PortalUtil.getCurrentURL(request);
	
	String ngaybatdau = ParamUtil.getString(request, "ngaybatdau");
	String ngayketthuc = ParamUtil.getString(request, "ngayketthuc");
	String trangThaiTinBai = ParamUtil.getString(request, "trangThaiTinBai");
	
	List<String> listinput = Arrays.asList(ngaybatdau, ngayketthuc, trangThaiTinBai);
  	
%>
<portlet:renderURL var="searchURL"/>
<portlet:renderURL var="resetURL">
	<portlet:param name="reset" value="<%= currentURL %>" />
</portlet:renderURL>
<div class="container mt-4">
	<div class="card">
		<div class="card-body">
			<aui:form action="<%=searchURL.toString() %>">
				<aui:row>
					<aui:col width="50">
						<aui:row>
							<aui:col width="50">
								<aui:input label="Từ ngày" name="ngaybatdau" cssClass="ngaybatdau auiDate" type="text" readonly="true"/>
							</aui:col>
							<aui:col width="50">
								<aui:input label="Đến ngày" name="ngayketthuc" cssClass="ngayketthuc auiDate" type="text" readonly="true"/>
							</aui:col>
						</aui:row>
					</aui:col>
					<aui:col width="50">
						<aui:row>
							<aui:col width="50">
								<aui:select name="" cssClass="quy-thongke" label="Quý">
									<aui:option value="-1">--Chọn quý--</aui:option>
									<% for (int i = 1; i <= 4; i++) { %>
									<aui:option value="<%=i%>">Quý <%=i%></aui:option>
									<% } %>
								</aui:select>
							</aui:col>
							<aui:col width="50">
								<aui:select name="" cssClass="nam-thongke" label="Năm">
									<aui:option value="-1">--Chọn năm--</aui:option>
									<% 
										int begin = 2015;
										for (int i = begin; i <= 2100; i++) { 
									%>
									<aui:option value="<%=i%>">Năm <%=i%></aui:option>
									<% } %>
								</aui:select>
							</aui:col>
						</aui:row>
					</aui:col>
				</aui:row>
				<aui:select name="trangThaiTinBai" label="Trạng thái">
					<aui:option value="">--Chọn trạng thái--</aui:option>
					<aui:option value="0" selected="<%=trangThaiTinBai.equals("0")%>">Lưu nháp</aui:option>
					<aui:option value="1" selected="<%=trangThaiTinBai.equals("1")%>">Chờ biên tập và phê duyệt</aui:option>
					<aui:option value="2" selected="<%=trangThaiTinBai.equals("2")%>">Chờ phê duyệt</aui:option>
					<aui:option value="3" selected="<%=trangThaiTinBai.equals("3")%>">Đã xuất bản</aui:option>
					<aui:option value="4" selected="<%=trangThaiTinBai.equals("4")%>">Ngừng xuất bản</aui:option>
				</aui:select>
				<!-- Nút tìm kiếm -->
				<div class="d-flex justify-content-center">
					<aui:button-row>
						<aui:button type="submit" value="Tìm kiếm"/>
						<aui:button type="button" cssClass="btn btn-success" id="btnReportSoLuongBTV" value="Xuất Excel"/>
						<%
							boolean isKiemTraTK = listinput.stream().anyMatch(value -> !value.isEmpty());
							if(isKiemTraTK) {
						%>
						<aui:button type="reset" href="<%=resetURL.toString() %>" value="Xóa tìm kiếm"/>
						<% } %>
					</aui:button-row>
				</div>
			</aui:form>
		</div>
	</div>

	<div class="card">
		<div class="card-body">
			<table class="table table-bordered table-hover" id="thongkebtv">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Người đăng tin</th>
						<th scope="col">Ấn phẩm</th>
					</tr>
				</thead>
				<tbody>
					<%
					List<News_role> objRole = ThongKeAdminUtil.listPhanquyen();
					int i = 0;
					for(News_role r : objRole) {
						List<User> objUser = ThongKeAdminUtil.getUsersByID(r.getUserid());
						for (User u : objUser) {
							i++;
							List<AnPham_TapChi> anPhamList = ThongKeAdminUtil.thongKeAnPhamByBTV(r.getUserid(), ngaybatdau, ngayketthuc, trangThaiTinBai);
					%>
					<tr>
				      	<th scope="row"><%=i %></th>
				      	<td><%=u.getFullName() %></td>
				      	<td><%=anPhamList.size() %></td>
				      	<%
							int currentQuarter = (java.util.Calendar.getInstance().get(java.util.Calendar.MONTH) / 3) + 1;
						    String startDate = "";
						    String endDate = "";
						
						    switch (currentQuarter) {
						        case 1:
						            startDate = "01/01/" + java.time.Year.now();
						            endDate = "31/03/" + java.time.Year.now();
						            break;
						        case 2:
						            startDate = "01/04/" + java.time.Year.now();
						            endDate = "30/06/" + java.time.Year.now();
						            break;
						        case 3:
						            startDate = "01/07/" + java.time.Year.now();
						            endDate = "30/09/" + java.time.Year.now();
						            break;
						        case 4:
						            startDate = "01/10/" + java.time.Year.now();
						            endDate = "31/12/" + java.time.Year.now();
						            break;
						    }
						%>
				      	
				      	<portlet:renderURL var="chitietURL">
							<portlet:param name="userId" value="<%=String.valueOf(r.getUserid()) %>"/>
							<portlet:param name="ngaybatdau" value="<%= startDate %>"/>
    						<portlet:param name="ngayketthuc" value="<%= endDate %>"/>
							<portlet:param name="jspPage" value="/html/admin/thongke/thongkebtv/detail.jsp" />
						</portlet:renderURL>
				      	<td><a href="<%=chitietURL%>">Xem chi tiết</a></td>
				    </tr>
				    <% }} %>
				</tbody>
			</table>
		</div>
	</div>
</div>

<script>
    $(document).ready(function () {
        $("#<portlet:namespace />btnReportSoLuongBTV").click(function () {
            $("#thongkebtv").tableExport({
	            type: "xls",               
	            fileName: "ThongKeBTV",         
	            ignoreColumn: [3], // Bỏ qua cột thứ 6 (5)
            });
        });
    });
</script>