<%@page import="qlanpham.portlet.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="java.util.List"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String tabDeCuong = QlanphamAdminField.value_tabdecuong;
%>
<portlet:actionURL name="saveDeCuong" var="saveDeCuongURL">
	<portlet:param name="tabs" value="<%=tabDeCuong %>" />
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="tabs" value="<%=tabDeCuong %>" />
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
							<aui:form name="formAddThongTin" action="<%=saveDeCuongURL %>" enctype="multipart/form-data" method="post">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td>
											<label class="control-label">Loại ấn phẩm</label>
											<aui:select name="loaiId" label="">
											<%
											List<AnPham_Loai> listDmLoai = QlanphamAdminUtil.getDmLoai(renderRequest, 1);
											for(AnPham_Loai listLoai:listDmLoai){
											%>
											<aui:option value="<%=listLoai.getId()%>"><%=listLoai.getTen()%></aui:option>
											<% } %>
											</aui:select>
										</td>
										<td></td>
									</tr>
									<tr>
										<td>
											<label class="control-label">Tên đề cương</label>
											<aui:input name="ten" label="" type="input">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">500</aui:validator>
											</aui:input>
										</td>
										<td>
											<label class="control-label">Mô tả</label>
											<aui:input name="moTa" label="" type="input" />
										</td>										
									</tr>
									<tr>
										<td colspan="2">
											<label class="control-label">Nội dung tạp chí</label>
											<liferay-ui:input-editor toolbarSet="slimmed" name="noiDung" cssClass="scrollBar" resizable="true"  initMethod="initEditor"></liferay-ui:input-editor>
										</td>	
									</tr>
									<tr>
										<td>
											<label class="control-label">Thứ tự</label>
											<aui:input name="orders" label="" type="input" value="1">
												<aui:validator name="number"></aui:validator>
											</aui:input>
										</td>	
										<td>
											<label class="control-label">Ngày tạo</label>
											<aui:input name='<portlet:namespace/>ngaytao' id="ngaytao"  type="text" class="form-control datepicker" label=""></aui:input>
										</td>
									</tr>
									
								</table>
								<%
									News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());
								%>
								<div class="d-flex justify-content-center">
									<aui:button-row>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>	
										<% if(role.getRole_add() == 1) { %>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu nháp" label=""></aui:button>
		   									<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>																
										<% } else if(role.getRole_edit() == 1) { %>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu nháp" label=""></aui:button>	
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>									
										<% } else if(role.getRole_public() == 1) { %>
											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu nháp" label=""></aui:button>
											<aui:button type="submit" name="xuatban" value="Lưu và xuất bản" label=""></aui:button>
										<% } %> 	
										<aui:button href="<%=cancelURL.toString()%>" type="cancel" value="Quay lại"></aui:button>			
									</aui:button-row>
								</div>
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
<script type="text/javascript">
function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}
	var btnluu = $("#<portlet:namespace/>luu");
		btnluu.on('click',function(event){
		setTypeAction("luu");
	});
		
	var btnGuibientapvien = $("#<portlet:namespace/>guibientapvien");
		btnGuibientapvien.on('click',function(event){
		setTypeAction("guibientapvien");
	});
		
	var btnLuuvatrinhpheduyet = $("#<portlet:namespace/>luuvatrinhpheduyet");
		btnLuuvatrinhpheduyet.on('click',function(event){
		setTypeAction("luuvatrinhpheduyet");
	});
		
	var btnxuatban = $("#<portlet:namespace/>xuatban");
		btnxuatban.on('click',function(event){
    	setTypeAction("xuatban");  
    });
$('#<portlet:namespace/>ngaytao').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	timepickerScrollbar:true
});

</script>