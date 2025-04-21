<%@page import="java.text.SimpleDateFormat"%>
<%@page import="qlanpham.portlet.utils.AnPhamGuestUtil"%>
<%@page import="qlanphamdb.model.AnPham_DinhKemFile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="qlanpham.portlet.utils.AnPhamConfig"%>
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
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String tabThongKeLuotXemVaLuotTai = ParamUtil.getString(request, "tabs1", AnPhamConfig.tabThongKeLuotXemVaLuotTai);
	String ngaybatdau = ParamUtil.getString(request, "ngaybatdau");
	String ngayketthuc = ParamUtil.getString(request, "ngayketthuc");
	String trangThaiTinBai = ParamUtil.getString(request, "trangThaiTinBai");
	
	List<String> listinput = Arrays.asList(ngaybatdau, ngayketthuc, trangThaiTinBai);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("tabs1", tabThongKeLuotXemVaLuotTai);
	iteratorUrl.setParameter("ngaybatdau", ngaybatdau);
	iteratorUrl.setParameter("ngayketthuc", ngayketthuc);
	iteratorUrl.setParameter("status", trangThaiTinBai);

	
	int cur = ParamUtil.getInteger(request,"cur",1);
	int delta = ParamUtil.getInteger(request, "delta",10);
	SearchContainer searchContainer = null;
	if (cur > 0) {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM,
				cur, delta, iteratorUrl, null, null);
	} else {
		searchContainer = new SearchContainer(renderRequest, null,
				null, SearchContainer.DEFAULT_CUR_PARAM, delta,
				iteratorUrl, null, null);
	}
	int start = (cur - 1) * delta;
    int end = start + delta;
    List<AnPham_TapChi> anPhamList = ThongKeAdminUtil.thongKeAnPhamByViews(ngaybatdau, ngayketthuc, trangThaiTinBai, start, end);
 	int total = ThongKeAdminUtil.thongKeAnPhamByViews(ngaybatdau, ngayketthuc, trangThaiTinBai, 0, 0).size();

	// Gửi dữ liệu xuống JSP
    searchContainer.setTotal(total);;
    searchContainer.setResults(anPhamList);
  	
%>
<portlet:renderURL var="searchURL">
	<portlet:param name="tabs1" value="<%= tabThongKeLuotXemVaLuotTai %>" />
</portlet:renderURL>
<portlet:renderURL var="resetURL">
	<portlet:param name="tabs1" value="<%= tabThongKeLuotXemVaLuotTai %>" />
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
						<aui:button type="button" cssClass="btn btn-success" id="btnReportSoLuongViews" value="Xuất Excel"/>
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
	<% if(!anPhamList.isEmpty()) { %>
	<div class="card">
		<div class="card-body">
			<div style="display: flex; justify-content: center;">
				<div id="myChart" style="width:100%; max-width:600px; height:500px;"></div>
			</div>
			<table class="table table-bordered table-hover" id="thongkeluotxem">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Tên ấn phẩm</th>
						<th scope="col">Ngày xuất bản</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Lượt xem</th>
						<th scope="col">Lượt tải</th>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 0;
						for (AnPham_TapChi ap : anPhamList) {
							List<AnPham_DinhKemFile> fileDinhKem = AnPhamGuestUtil.getFileByAnPhamId(ap.getId());
								for(AnPham_DinhKemFile f : fileDinhKem) {
									i++;
					%>
					<tr>
				      	<th scope="row"><%=i %></th>
				      	<td><%=ap.getTen() %></td>
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
				      	<td><%=ap.getLuotXem() %></td>
				      	<td><%=f.getLuotTai() %></td>		
				    </tr>
				    <% }} %>
				</tbody>
			</table>
		</div>
		<div class="paginator">
			<liferay-ui:search-paginator markupView="lexicon" searchContainer="<%= searchContainer %>" />
		</div>
	</div>
	<% } %>
</div>
<script>
    $(document).ready(function () {
        $("#<portlet:namespace />btnReportSoLuongViews").click(function () {
            $("#thongkeluotxem").tableExport({
	            type: "xls",               
	            fileName: "thongKeLuotXem",         
            });
        });
    });
</script>

<% if(!anPhamList.isEmpty()) { %>

<script>
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChartLuotXemVaLuotTai);
	
	function drawChartLuotXemVaLuotTai() {
	
	// Set Data
	const data = google.visualization.arrayToDataTable([
	  ['Ấn phẩm', 'Lượt xem', 'Lượt tải'],
	  <% 
	  	for (AnPham_TapChi ap : anPhamList) {
	  		List<AnPham_DinhKemFile> fileDinhKem = AnPhamGuestUtil.getFileByAnPhamId(ap.getId());
			for(AnPham_DinhKemFile f : fileDinhKem) {
	  %>
      	['<%= ap.getTen().replace("'", "\\'") %>', <%= ap.getLuotXem() %>, <%= f.getLuotTai() %>],
      <% }} %>
	]);
	
	// Set Options
	const labels = {
	  title:'Thống kê lượt xem và lượt tải'
	};
	
	// Draw
	const myChart = new google.visualization.BarChart(document.getElementById('myChart'));
	myChart.draw(data, labels);
	}
</script>
<% } %>