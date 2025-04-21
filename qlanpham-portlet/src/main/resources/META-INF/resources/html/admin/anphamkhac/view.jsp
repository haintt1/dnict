<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="qlanphamdb.service.AnPham_DeCuongLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_DeCuong"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="qlanphamdb.service.AnPham_TapChiLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="java.util.List"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String currentURL = PortalUtil.getCurrentURL(request);
    String itemSelectorURL = (String) request.getAttribute("itemSelectorURL");
%>
<portlet:renderURL var="addURL">
	<portlet:param name="jspPage" value="/html/admin/anphamkhac/add.jsp" />
	<portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>" />
</portlet:renderURL>
<portlet:renderURL var="softDeleteURL">
	<portlet:param name="jspPage" value="/html/admin/anphamkhac/trash.jsp" />
	<portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>" />
</portlet:renderURL>
<portlet:renderURL var="searchBaivietURL"/>
<portlet:renderURL var="resetURL">
	<portlet:param name="reset" value="<%= currentURL %>" />
</portlet:renderURL>

<%
	String tenBaiViet = HtmlUtil.escape(ParamUtil.getString(request, "tenBaiViet"));
	String dinhDanh = HtmlUtil.escape(ParamUtil.getString(request, "dinhDanh"));
	
	String anPhamDB = "";
	List<AnPham_Loai> getLoaiID = QlanphamAdminUtil.getDmLoai(renderRequest, 1);
	for(AnPham_Loai g:getLoaiID){
		if(g.getOrders() == 4) {
			anPhamDB = String.valueOf(g.getId());
		}
	}
	String anPhamRequest = ParamUtil.getString(request, "anPham");
	if(Validator.isNotNull(anPhamRequest)) {
		anPhamRequest = ParamUtil.getString(request, "anPham");
	} else {
		anPhamRequest = anPhamDB;
	}
	
//	String anPham = ParamUtil.getString(request, "anPham");
	String deCuong = ParamUtil.getString(request, "deCuong");
	String ngaytao_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_tungay"));
	String ngaytao_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_denngay"));
	String ngayhieuchinh_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngayhieuchinh_tungay"));
	String ngayhieuchinh_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngayhieuchinh_denngay"));
	String trangThaiTinBai = ParamUtil.getString(request, "trangThaiTinBai");
	
	List<String> listinput = Arrays.asList(tenBaiViet, dinhDanh, anPhamRequest, deCuong, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, trangThaiTinBai);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("tenBaiViet", tenBaiViet);
	iteratorUrl.setParameter("dinhDanh", dinhDanh);
	iteratorUrl.setParameter("anPham", anPhamRequest);
	iteratorUrl.setParameter("deCuong", deCuong);
	iteratorUrl.setParameter("ngaytao_tungay", ngaytao_tungay);
	iteratorUrl.setParameter("ngaytao_denngay", ngaytao_denngay);
	iteratorUrl.setParameter("ngayhieuchinh_tungay", ngayhieuchinh_tungay);
	iteratorUrl.setParameter("ngayhieuchinh_denngay", ngayhieuchinh_denngay);
	iteratorUrl.setParameter("trangThaiTinBai", trangThaiTinBai);
	
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
  	List<AnPham_TapChi> listTapChi = QlanphamAdminUtil.listTapChiAdmin(tenBaiViet, dinhDanh, anPhamRequest, deCuong, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, trangThaiTinBai, start, end);
 	int total = QlanphamAdminUtil.listTapChiAdmin(tenBaiViet, dinhDanh, anPhamRequest, deCuong, ngaytao_tungay, ngaytao_denngay, ngayhieuchinh_tungay, ngayhieuchinh_denngay, trangThaiTinBai, 0, 0).size();

	 // Gửi dữ liệu xuống JSP
    searchContainer.setTotal(total);;
    searchContainer.setResults(listTapChi);
   
%>
<div class="container mt-4">
	<div class="card">
		<div class="card-body">
			<div class="d-flex justify-content-between align-items-center mb-3">
				<div>
					<img src="<%=request.getContextPath()%>/images/flag/vi_VN.png"
						alt="Vietnamese" class="me-2" style="height: 24px;"> <span>Tiếng
						Việt</span> <img
						src="<%=request.getContextPath()%>/images/flag/en_US.png"
						alt="English" class="ms-3 me-2" style="height: 24px;"> <span>Tiếng
						Anh</span>
				</div>
				<div>
					<aui:a href="<%=addURL.toString() %>" label="Thêm mới"
						cssClass="btn btn-primary" />
					<aui:button href="<%=softDeleteURL.toString() %>" type="reset"
						value="Thùng rác"></aui:button>
				</div>
			</div>
			<aui:form action="<%=searchBaivietURL.toString() %>">
				<div class="row g-3">
					<!-- Tên bài viết và Định danh -->
					<div class="col-md-6">
						<aui:input name="tenBaiViet" label="Tên bài viết"
							placeholder="Nhập tên bài viết" />
					</div>
					<div class="col-md-6">
						<aui:input name="dinhDanh" label="Định danh"
							placeholder="Nhập định danh" />
					</div>

					<!-- Danh mục và Thể loại -->
					<div class="col-md-6">
						<aui:select name="anPham" label="Ấn phẩm" id="selectLoai">
							<aui:option>--Chọn ấn phẩm--</aui:option>
							<%
								List<AnPham_Loai> listDmLoai = QlanphamAdminUtil.getDmLoai(renderRequest, 1);
								for(AnPham_Loai listLoai:listDmLoai){
								%>
							<aui:option value="<%=listLoai.getId()%>" selected="<%=listLoai.getOrders() == 4 %>"><%=listLoai.getTen()%></aui:option>
							<% } %>
						</aui:select>
					</div>
					<div class="col-md-6">
						<label>Đề cương</label>
						<select name="<portlet:namespace />deCuong" class="form-control" id="selectDeCuong">
							<option value="">--Chọn đề cương--</option>
						</select>
					</div>
					<!-- Ngày tạo và ngày hiệu chỉnh -->
					<div class="col-md-6">
						<div class="row">
					        <div class="col-md-6">
					        	<aui:input name="ngaytao_tungay" type="text" cssClass="auiDate" placeholder="dd/mm/yyyy" label="Từ ngày tạo"></aui:input>
					        </div>
					        <div class="col-md-6">
					        	<aui:input name="ngaytao_denngay" type="text" cssClass="auiDate" placeholder="dd/mm/yyyy" label="Đến ngày tạo"></aui:input>
					        </div>
					    </div>
					</div>
					<div class="col-md-6">
						<div class="row">
					        <div class="col-md-6">
					        	<aui:input name="ngayhieuchinh_tungay" type="text" cssClass="auiDate" placeholder="dd/mm/yyyy" label="Từ ngày hiệu chỉnh"></aui:input>
					        </div>
					        <div class="col-md-6">
					        	<aui:input name="ngayhieuchinh_denngay" type="text" cssClass="auiDate" placeholder="dd/mm/yyyy" label="Đến ngày hiệu chỉnh"></aui:input>
					        </div>
					    </div>
					</div>
				</div>
				<div class="form-group">
					<aui:select name="trangThaiTinBai" label="Trạng thái">
						<aui:option value="-1"
							selected="<%=trangThaiTinBai.equals("-1")%>">--Chọn trạng thái--</aui:option>
						<aui:option value="0" selected="<%=trangThaiTinBai.equals("0")%>">Lưu nháp</aui:option>
						<aui:option value="1" selected="<%=trangThaiTinBai.equals("1")%>">Chờ biên tập và phê duyệt</aui:option>
						<aui:option value="2" selected="<%=trangThaiTinBai.equals("2")%>">Chờ phê duyệt</aui:option>
						<aui:option value="3" selected="<%=trangThaiTinBai.equals("3")%>">Đã xuất bản</aui:option>
						<aui:option value="4" selected="<%=trangThaiTinBai.equals("4")%>">Ngừng xuất bản-</aui:option>
					</aui:select>
				</div>
				<!-- Nút tìm kiếm -->
				<div class="d-flex justify-content-center mt-4">
					<aui:button-row>
						<aui:button type="submit" value="Tìm kiếm"/>
						<%
							boolean isKiemTraTK = listinput.stream().anyMatch(value -> !value.isEmpty());
							if(isKiemTraTK) {
						%>
						<aui:button type="reset" href="<%=resetURL %>" value="Xóa tìm kiếm"/>
						<% } %>
					</aui:button-row>
				</div>
			</aui:form>
			<hr>
			<%
				if(listTapChi.size() > 0){
					for(int a = 0; a < listTapChi.size(); a++){
				%>
			<div class="new-container-pm ">
				<portlet:renderURL var="editAnPhamKhacURL">
					<portlet:param name="id" value="<%=String.valueOf(listTapChi.get(a).getId())%>" />
					<portlet:param name="jspPage" value="/html/admin/anphamkhac/edit.jsp" />
					<portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>" />
				</portlet:renderURL>
				<portlet:renderURL var="xemPhienBanURL">
					<portlet:param name="id" value="<%=String.valueOf(listTapChi.get(a).getId())%>" />
					<portlet:param name="jspPage" value="/html/admin/anphamkhac/xemphienban.jsp" />
				</portlet:renderURL>
				<portlet:actionURL name="deleteAnPhamKhac" var="deleteAnPhamKhacURL">
					<portlet:param name="id" value="<%=String.valueOf(listTapChi.get(a).getId())%>" />
					<portlet:param name="jspPage" value="/html/admin/anphamkhac/view.jsp" />
				</portlet:actionURL>
				<div class="dropdown">
					<button onclick="myFunction(<%=listTapChi.get(a).getId()%>)"
						class="dropbtn">
						<i class="caret"></i>
					</button>
					<div id="myDropdown_<%=listTapChi.get(a).getId()%>"
						class="dropdown-content">
						<%
							String chonLoaiTin = "";
					  		String deleteTin = "";
							if(listTapChi.get(a).getLoaiTin()==0){
								chonLoaiTin = editAnPhamKhacURL;
								deleteTin = deleteAnPhamKhacURL.toString();
							} else {
								chonLoaiTin = editAnPhamKhacURL;
								deleteTin = deleteAnPhamKhacURL.toString();
							}
						%>
						<a href="<%=chonLoaiTin %>" class="edit-item"><i class="icon-file-text"></i>Hiệu chỉnh bài viết</a>
						<a href="<%=xemPhienBanURL.toString() %>" class="xemPhienBan">Xem các phiên bản</a>
						<a href="javascript:void(0)" data-url="<%=deleteTin%>" class="recycle-item"><i class="icon-trash"></i> Xóa bài viết</a>
					</div>
				</div>
				<div class="small-img-pm">
					<%if(listTapChi.get(a).getStatus() == 0){%>
					<span class="lable-nhap">Tin mới đăng (Bản nháp)</span>
					<%}else if( listTapChi.get(a).getStatus() == 1){%>
					<span class="lable-chopheduyet">Chờ biên tập</span>
					<%}else if(listTapChi.get(a).getStatus() == 2){%>
					<span class="lable-xuatban">Chờ phê duyệt và xuất bản</span>
					<%}else if(listTapChi.get(a).getStatus() == 3){%>
					<span class="lable-daxuatban">Đã xuất bản</span>
					<%}else if(listTapChi.get(a).getStatus() == 4){%>
					<span class="lable-ngungxuatban">Ngừng xuất bản</span>
					<%}else if(listTapChi.get(a).getStatus() == 5){%>
					<span class="lable-yeucauhieuchinh">Tin được yêu cầu hiệu
						chỉnh</span>
					<%}%>
					<%
						String url = listTapChi.get(a).getAnhDaiDien();
							if(!url.equals("")){
					%>
					<img style="height: 90px;" alt="" src="<%=url%>">
					<%}else{%>
					<img style="height: 90px;" alt=""
						src="<%=request.getContextPath()%>/images/no_image.png">
					<%}%>
				</div>
				<div class="new-name-info-content-pm">
					<a class="title-link-new-pm" href="<%=chonLoaiTin %>"><span
						class="new-name-pm"><%=listTapChi.get(a).getTen()%></span></a>
					<p class="new-info-pm">
						<%
						if(listTapChi.get(a).getMoTa().length()>151){
							out.print(listTapChi.get(a).getMoTa().substring(0, 149)+"...");
						}else {
							out.print(listTapChi.get(a).getMoTa());
						}
					%>
					</p>
					<span class="new-version-pm"><b class="title-pm">Phiên
							bản: </b><%=listTapChi.get(a).getPhienBan()%></span>
					<%
						String ngayTao = "";
						if(Validator.isNotNull(listTapChi.get(a)) && Validator.isNotNull(listTapChi.get(a).getNgayTao())){
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							ngayTao = df.format(listTapChi.get(a).getNgayTao());
						}
					%>
					<span class="new-public-pm"><b class="title-pm">Ngày
							đăng tin: </b><%=ngayTao%></span> <span class="new-public-pm"><b
						class="title-pm">Định danh: </b><%=listTapChi.get(a).getId()%></span> <span
						class="author"><b class="title-pm">Lượt xem: </b><%=listTapChi.get(a).getLuotXem()%></span>
					<span class="author"><b class="title-pm">Thứ tự: </b><%=listTapChi.get(a).getOrders()%></span>

					<span class="new-category-pm"><b class="title-pm">Chuyên
							mục: </b> <%
							AnPham_Loai objLoaiAnPham = AnPham_LoaiLocalServiceUtil.fetchAnPham_Loai(listTapChi.get(a).getLoaiId());
							String tenAnPham = "";
							if(Validator.isNull(objLoaiAnPham)){
								tenAnPham = "";
							}else{
								tenAnPham = objLoaiAnPham.getTen();
							}
						%> <span class="category-info-pm"><%=tenAnPham%></span> </span> <span
						class="author"> <%
							AnPham_DeCuong objDeCuong = AnPham_DeCuongLocalServiceUtil.fetchAnPham_DeCuong(listTapChi.get(a).getDeCuongId());
							String tenDeCuong = "";
							if(Validator.isNull(objDeCuong)){
								tenDeCuong = "";
							}else{
								tenDeCuong = objDeCuong.getTen();
							}
						%> <b class="title-pm">Đề cương: </b><%=tenDeCuong%>
					</span> <span class="author"> <b class="title-pm">Từ khóa: </b><%=listTapChi.get(a).getTuKhoa()%>
					</span> <span class="author"> <% 
							User usercreate = UserLocalServiceUtil.fetchUser(listTapChi.get(a).getNguoiTao());
							String fullname = "";
							if(Validator.isNotNull(usercreate)){
								fullname = usercreate.getFullName();
							}
						%> <b class="title-pm">Người đăng bài: </b><%=fullname%>
					</span>
				</div>
			</div>
			<%}}%>
			<div class="paginator">
				<liferay-ui:search-paginator markupView="lexicon"
					searchContainer="<%= searchContainer %>" />
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function myFunction(id) {
		 document.getElementById("myDropdown_"+id).classList.toggle("show");
	}
</script>

<portlet:resourceURL var="resourceURL1" id="ajaxAction1"></portlet:resourceURL>
<portlet:resourceURL var="resourceURL2" id="ajaxAction2"></portlet:resourceURL>
<script>
	$(document).ready(function () {
		// Khi không select
		var selectedDeCuong = '<%= deCuong %>';
		var loaiId = $("#<portlet:namespace />selectLoai").val();
		if(loaiId) {
			$.ajax({
				 url: '<%=resourceURL1 %>',
				 type: 'POST',
				 data:{<portlet:namespace />loaiId:loaiId},
				 success: function (data) {
					 var deCuongList = JSON.parse(data);
	                 deCuongList.forEach(function (deCuong) {
	                	var selected = (deCuong.id === selectedDeCuong) ? 'selected' : '';
		                $("#selectDeCuong").append('<option value="' + deCuong.id + '" ' + selected + '>' + deCuong.ten + '</option>');
	                 });
				 },
				 error: function (data) {
				 	alert("Lỗi dữ liệu từ server");
				 }
			})
		}
		// Khi select
		 $("#<portlet:namespace />selectLoai").change(function () {
			 var loaiIdChange = $(this).val();
			 $("#selectDeCuong").html('<option value="">--Chọn đề cương--</option>'); // Reset select đề cương
			 
			 if(loaiId) {
				 $.ajax({
					 url: '<%=resourceURL2 %>',
					 type: 'POST',
					 data:{<portlet:namespace />loaiId:loaiIdChange},
					 success: function (data) {
						 var deCuongList = JSON.parse(data);
		                 deCuongList.forEach(function (deCuong) {
		                 	$("#selectDeCuong").append('<option value="' + deCuong.id + '">' + deCuong.ten + '</option>');
		                 });
					 },
					 error: function (data) {
					 	alert("Lỗi dữ liệu từ server");
					 }
				})
			 }
		 });
	});
</script>
