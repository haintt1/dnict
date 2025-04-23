<%@page import="qlanphamdb.service.AnPham_TapChiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="qlanphamdb.model.AnPham_BinhLuan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="qlanpham.portlet.utils.ThongKeAdminUtil"%>
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
	String noiDung = ParamUtil.getString(request, "noiDung");
	String ngaybatdau = ParamUtil.getString(request, "ngaybatdau");
	String ngayketthuc = ParamUtil.getString(request, "ngayketthuc");
	String trangThai = ParamUtil.getString(request, "trangThai");
	
	List<String> listinput = Arrays.asList(noiDung, ngaybatdau, ngayketthuc, trangThai);
	
	PortletURL iteratorUrl = renderResponse.createRenderURL();
	iteratorUrl.setParameter("noiDung", noiDung);
	iteratorUrl.setParameter("ngaybatdau", ngaybatdau);
	iteratorUrl.setParameter("ngayketthuc", ngayketthuc);
	iteratorUrl.setParameter("status", trangThai);

	
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
    List<AnPham_BinhLuan> binhLuanList = QlanphamAdminUtil.listBinhLuanAnPham(noiDung, ngaybatdau, ngayketthuc, trangThai, start, end);
 	int total = QlanphamAdminUtil.listBinhLuanAnPham(noiDung, ngaybatdau, ngayketthuc, trangThai, 0, 0).size();

	// Gửi dữ liệu xuống JSP
    searchContainer.setTotal(total);;
    searchContainer.setResults(binhLuanList);
  	
%>
<portlet:renderURL var="searchURL"/>
<portlet:renderURL var="resetURL"/>
<portlet:actionURL var="deleteBinhLuanURL" name="deleteBinhLuan"/>
<portlet:actionURL var="publishBinhLuanURL" name="publishBinhLuan"/>
<portlet:actionURL var="nopublishBinhLuanURL" name="nopublishBinhLuan"/>
<div class="container mt-4">
	<div class="card">
		<div class="card-body">
			<aui:form action="<%=searchURL.toString() %>">
				<aui:input name="noiDung" label="Nội dung" type="text"></aui:input>
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
						<aui:select name="trangThai" label="Trạng thái">
							<aui:option value="">--Chọn trạng thái--</aui:option>
							<aui:option value="0" selected="<%=trangThai.equals("0")%>">Chưa xác nhận</aui:option>
							<aui:option value="1" selected="<%=trangThai.equals("1")%>">Không duyệt</aui:option>
							<aui:option value="2" selected="<%=trangThai.equals("2")%>">Đã duyệt</aui:option>
						</aui:select>
					</aui:col>
				</aui:row>
				<!-- Nút tìm kiếm -->
				<div class="d-flex justify-content-center">
					<aui:button-row>
						<aui:button type="submit" value="Tìm kiếm"/>
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
	<% if(!binhLuanList.isEmpty()) { %>
	<div class="card">
		<div class="card-body">
			<form method="post" id="frmAction">
			<div class="d-flex justify-content-end align-items-center mb-3">
				<div>
					<a href="#" onClick="confirmPublish();" class="btn btn-success"><i class="icon-trash"></i>Duyệt</a>
					<a href="#" onClick="confirmNoPublish();" class="btn btn-info"><i class="icon-trash"></i>Không duyệt</a>
					<a href="#" onClick="confirmDelete();" class="btn btn-danger"><i class="icon-trash"></i>Xóa</a>
				</div>
			</div>
			
			<table class="table table-bordered table-hover" id="thongkeluotxem">
				<thead>
					<tr>
						<th style="width:10px; text-align:center"><input type="checkbox" id="ckbCheckAll"></input><span class="lbl"></span></th>
						<th scope="col">#</th>
						<th scope="col">Nội dung</th>
						<th scope="col">Họ tên</th>
						<th scope="col">Tên ấn phẩm</th>
						<th scope="col">Ngày bình luận</th>
						<th scope="col">Trạng thái</th>
						<th scope="col">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<%
						int i = 0;
						for (AnPham_BinhLuan bl : binhLuanList) {
							i++;
					%>
					<tr>
						<td><input name="<portlet:namespace/>check[]" class="checkBoxClass" type="checkbox" value="<%=bl.getId()%>"></input></td>
				      	<th scope="row"><%=i %></th>
				      	<td><%=bl.getNoiDung() %></td>
				      	<td><%=bl.getHoTen() %></td>
				      	<%
				      		AnPham_TapChi tapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(bl.getAnPhamId());
				      	%>
				      	<td><a target="_blank" href="<%="/chi-tiet-tap-chi?dinhdanh=" + tapChi.getId() %>"><%=tapChi.getTen() %></a></td>
				      	<td><%=df.format(bl.getNgayBinhLuan()) %></td>
					    <%
					      	String status = "";
					      	if(bl.getStatus() == 0) {
					      		status = "Chưa xác nhận";
					      	} else if(bl.getStatus() == 1) {
					      		status = "Không duyệt";
					      	} else if(bl.getStatus() == 2) {
					      		status = "Đã duyệt";
					      	}
					    %>
				      	<td><%=status %></td>
				      	<portlet:actionURL var="publishSingleBinhLuanURL" name="publishBinhLuan">
				      		<portlet:param name="anPhamId" value="<%= String.valueOf(bl.getId()) %>" />
				      	</portlet:actionURL>
						<portlet:actionURL var="nopublishSingleBinhLuanURL" name="nopublishBinhLuan">
							<portlet:param name="anPhamId" value="<%= String.valueOf(bl.getId()) %>" />
						</portlet:actionURL>
						<portlet:actionURL var="deleteSingleBinhLuanURL" name="deleteBinhLuan">
							<portlet:param name="anPhamId" value="<%= String.valueOf(bl.getId()) %>" />
						</portlet:actionURL>
				      	<td align="center">
				      		<liferay-ui:icon-delete url="<%=publishSingleBinhLuanURL %>" image="activate" confirmation="Bạn chắc chắn muốn duyệt bình luận này?" message="Phê duyệt"></liferay-ui:icon-delete>
				      		<liferay-ui:icon-delete url="<%=nopublishSingleBinhLuanURL %>" image="deactivate" confirmation="Bạn chắc chắn muốn không duyệt bình luận này?" message="Không duyệt"></liferay-ui:icon-delete>
				      		<liferay-ui:icon-delete url="<%=deleteSingleBinhLuanURL %>" image="delete" confirmation="Bạn chắc chắn muốn xóa bình luận này?" message="Xóa"></liferay-ui:icon-delete>
				      	</td>
				    </tr>
				    <% } %>
				</tbody>
			</table>
			</form>
		</div>
		<div class="paginator">
			<liferay-ui:search-paginator markupView="lexicon" searchContainer="<%= searchContainer %>" />
		</div>
	</div>
	<% } %>
</div>
<script>
	$("#ckbCheckAll").click(function () {
	    $(".checkBoxClass").prop('checked', $(this).prop('checked'));
	});
	function confirmDelete(){
		var count = $(".checkBoxClass:checked").length;
		if(count>0){
			if(confirm("Bạn chắc chắn muốn xóa những bình luận này?")){
			/*	let values = $(".checkBoxClass:checked").map(function(){
					return $(this).val();
				}).get();
				console.log("Đã chọn: ", values); */
				$("#frmAction").attr('action','<%=deleteBinhLuanURL%>');
				$("#frmAction").submit();
			}
		}else{
			alert("Bạn cần chọn ít nhất một bình luận!");
		}
	}
	
	function confirmPublish(){
		var count = $(".checkBoxClass:checked").length;
		if(count>0){
			if(confirm("Bạn chắc chắn muốn duyệt những bình luận này?")){
				$("#frmAction").attr('action','<%=publishBinhLuanURL%>');
				$("#frmAction").submit();
			}
		}else{
			alert("Bạn cần chọn ít nhất một bình luận!");
		}
	}
	
	function confirmNoPublish(){
		var count = $(".checkBoxClass:checked").length;
		if(count>0){
			if(confirm("Bạn chắc chắn muốn không duyệt những bình luận này?")){
				$("#frmAction").attr('action','<%=nopublishBinhLuanURL%>');
				$("#frmAction").submit();
			}
		}else{
			alert("Bạn cần chọn ít nhất một bình luận!");
		}
	}
</script>