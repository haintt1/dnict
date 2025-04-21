<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="qlanpham.portlet.utils.ThongKeAdminUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="qlanpham.portlet.utils.AnPhamConfig"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String tabThongKeLoaiAnPham = ParamUtil.getString(request, "tabs1", AnPhamConfig.tabThongKeLoaiAnPham);
	String ngaybatdau = ParamUtil.getString(request, "ngaybatdau");
	String ngayketthuc = ParamUtil.getString(request, "ngayketthuc");
	String trangThaiTinBai = ParamUtil.getString(request, "trangThaiTinBai");
	
	List<String> listinput = Arrays.asList(ngaybatdau, ngayketthuc, trangThaiTinBai);
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	long loaiId = ParamUtil.getLong(request, "loaiId");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("loaiId", String.valueOf(loaiId));
	portletURL.setParameter("ngaybatdau", ngaybatdau);
	portletURL.setParameter("ngayketthuc",ngayketthuc);
	portletURL.setParameter("status",trangThaiTinBai);
	portletURL.setParameter("jspPage", "/html/admin/thongke/thongkeanpham/detail.jsp");
	
	List<AnPham_TapChi> anPhamList = ThongKeAdminUtil.thongKeChiTietByLoaiAnPham(loaiId, ngaybatdau, ngayketthuc, trangThaiTinBai);
%>
<portlet:renderURL var="searchURL">
	<portlet:param name="jspPage" value="/html/admin/thongke/thongkeloaiap/detail.jsp" />
	<portlet:param name="loaiId" value="<%=String.valueOf(loaiId)%>" />
</portlet:renderURL>
<portlet:renderURL var="resetURL">
	<portlet:param name="jspPage" value="/html/admin/thongke/thongkeloaiap/detail.jsp" />
	<portlet:param name="loaiId" value="<%=String.valueOf(loaiId)%>" />
</portlet:renderURL>
<portlet:renderURL var="backURL">
	<portlet:param name="tabs1" value="<%= tabThongKeLoaiAnPham %>" />
</portlet:renderURL>

<div class="container-fluid mt-4">
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
						<aui:button type="button" cssClass="btn btn-success" id="btnXuatThongKeLoaiAP" value="Xuất Excel"/>
						<aui:button type="cancel" href="<%=backURL.toString() %>" value="Quay lại"/>
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
	
	
	<% if(anPhamList.size() > 0) { %>
    <div class="card">
        <div class="card-body">
        	<div style="margin-bottom: 10px;">
	            Có tổng cộng <span style="color: red"><%=anPhamList.size() %></span> ấn phẩm
	        </div>
			<table class="table table-bordered table-hover" id="thongkechitietloaiap">
				<thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Tên ấn phẩm</th>
				      <th scope="col">Tác giả</th>
				      <th scope="col">Lượt xem</th>
				      <th scope="col">Ngày xuất bản</th>
				      <th scope="col">Trạng thái</th>
				    </tr>
			  	</thead>
				<tbody>
					<%
						int i = 0;
						for(AnPham_TapChi ap : anPhamList) {
							List<User> objUser = ThongKeAdminUtil.getUsersByID(ap.getNguoiTao());
							for (User u : objUser) {
								i++;
					%>
					<tr>
				      <td scope="row"><%=i %></td>
				      <td><%=ap.getTen() %></td>
				      <td><%=u.getFullName() %></td>
				      <td><%=ap.getLuotXem() %></td>
				      <td><%=df.format(ap.getNgayTao()) %></td>
				      <%
				      	String status = "";
				      	if(ap.getStatus() == 0) {
				      		status = "Lưu nháp";
				      	} else if(ap.getStatus() == 1) {
				      		status = "Chờ biên tập và phê duyệt";
				      	} else if(ap.getStatus() == 2) {
				      		status = "Chờ phê duyệt";
				      	} else if(ap.getStatus() == 3) {
				      		status = "Đã xuất bản";
				      	}else if(ap.getStatus() == 4) {
				      		status = "Ngừng xuất bản";
				      	}
				      %>
				      <td><%=status %></td>
				    </tr>
				    <% }} %>
				</tbody>
			</table>
        </div>
    </div>
    <% } %>
</div>


<script>
    $(document).ready(function () {
        $("#<portlet:namespace />btnXuatThongKeLoaiAP").click(function () {
            $("#thongkechitietloaiap").tableExport({
	            type: "xls",               
	            fileName: "ThongKeChiTietLoaiAnPham",         
            });
        });
    });
</script>





