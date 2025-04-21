<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="qlanpham.portlet.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="qlanphamdb.service.AnPham_DeCuongLocalServiceUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="qlanphamdb.model.AnPham_DeCuong"%>
<%@page import="qlanphamdb.service.AnPham_LoaiLocalServiceUtil"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String tabDeCuong = QlanphamAdminField.value_tabdecuong;
	AnPham_DeCuong deCuong = (AnPham_DeCuong) request.getAttribute("deCuong");
	String noidung = "";
	noidung = deCuong.getNoiDung();
	boolean checkYeucauHieuChinh = false;
	checkYeucauHieuChinh= QlanphamAdminUtil.checkYeuCauHieuChinhByUserIdAnd(themeDisplay.getUserId(), deCuong.getId(), 0);
	
%>
<portlet:actionURL name="updateDeCuong" var="updateDeCuongURL">
	<portlet:param name="tabs" value="<%=tabDeCuong %>" />
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="tabs" value="<%=tabDeCuong %>" />
</portlet:renderURL>
<portlet:renderURL var="yeucauhieuchinhURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(deCuong.getId()) %>" />
	<portlet:param name="jspPage" value="/html/admin/decuong/yeucauhieuchinh.jsp" />
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
							<aui:form name="formAddThongTin" action="<%=updateDeCuongURL.toString() %>"
								method="post">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td>
											<label class="control-label">Loại ấn phẩm</label>
											<aui:select name="loaiId" label="">
											<%
											List<AnPham_Loai> listDmLoai = QlanphamAdminUtil.getDmLoai(renderRequest, 1);
											for(AnPham_Loai listLoai:listDmLoai){
												String selected = "";
												if (deCuong.getLoaiId() == listLoai.getId()) { 
											%>
											<aui:option value="<%=deCuong.getLoaiId()%>"><%=listLoai.getTen()%></aui:option>
											<% } } %>
											</aui:select>
										</td>
										<td></td>
									</tr>
									<tr>
										<td >
											<label class="control-label">Tên đề cương</label>
											<aui:input name="id" type="hidden" value="<%=deCuong.getId()%>"></aui:input>
											<aui:input name="ten" label="" value="<%=deCuong.getTen() %>" type="input">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">500</aui:validator>
											</aui:input>
										</td>	
										<td>
											<label class="control-label">Mô tả</label>
											<aui:input name="moTa" label="" type="input" value="<%=deCuong.getMoTa() %>" />
										</td>	
									</tr>
									<tr>
										<td colspan="2">
											<label class="control-label">Nội dung đề cương</label>
										
											<liferay-ui:input-editor toolbarSet="slimmed" name="noiDung" initMethod="initEditor"/>
										</td>	
									</tr>
									<tr>
										<td>
											<label class="control-label">Thứ tự</label>
											<aui:input name="orders" value="<%=deCuong.getOrders() %>" label="" type="input">
												<aui:validator name="number"></aui:validator>
											</aui:input>
										</td>	
										<td>
											<label class="control-label">Ngày tạo</label>
											<%DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
											<aui:input name='<portlet:namespace/>ngaytao' id="ngaytao"  type="text" class="form-control datepicker" value="<%=df.format(deCuong.getNgayTao()) %>"  label=""></aui:input>
										</td>
									</tr>
								</table>
								
								<%
									News_role role = PhanQuyenAdminUtil.getUserById(user.getUserId());
								%>
								
								<div class="d-flex justify-content-center">
									<aui:button-row>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
										<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luu" value="Lưu nháp"></aui:button>
										<%
											if(deCuong.getStatus() != 5) {
												if(role.getRole_add() == 1) {	
										%>				
	    											<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="guibientapvien" value="Lưu và gửi biên tập viên" label=""></aui:button>
											<%			
												} else if(role.getRole_edit() == 1) {
											%>			
												<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuvatrinhpheduyet" value="Lưu và trình phê duyệt" label=""></aui:button>
					    						<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
					    						
											<%			
												}else if(role.getRole_public() == 1){
											%>
												<a class="btn btn-primary" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a> 
												<aui:button cssClass="btn-pm btn-submit-pm" name="pheduyet" type="submit" value="Xuất bản" label=""></aui:button>
											<% } %>
																													
																					
									<%	} else {
											if(checkYeucauHieuChinh){									
									%>
											<%
								    		if(role.getRole_edit()==1){
								    		%>
 												<a class="btn btn-primary" name="yeucauhieuchinh" id="btnyeucauhieuchinh"><i class="icon-plus"></i> Yêu cầu hiệu chỉnh</a>
 	    										<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhxuatban" value="Lưu hiệu chỉnh và trình xuất bản" label=""></aui:button>
								    		<%}
								    		
								    		 if(role.getRole_add() == 1){
								    		%>
								    			<aui:button type="submit" cssClass="btn-pm btn-submit-pm" name="luuhieuchinhpheduyet" value="Lưu hiệu chỉnh và trình phê duyệt" label=""></aui:button>
								    		<%} %>
										<%} %>
									<%} %>
										<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>
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
function <portlet:namespace />initEditor() {
    return "<%=UnicodeFormatter.toString(noidung) %>";
}
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
			
	var btnLuuHieuChinh = $("#<portlet:namespace/>luuhieuchinh");
		btnLuuHieuChinh.on('click',function(event){
		setTypeAction("luuhieuchinh");
	
	});
	
	var btnPheduyet = $("#<portlet:namespace/>pheduyet");
		btnPheduyet.on('click',function(event){
		setTypeAction("xuatban");
	});
		
	var btnLuuHieuChinhXuatBan = $("#<portlet:namespace/>luuhieuchinhxuatban");
		btnLuuHieuChinhXuatBan.on('click',function(event){
		setTypeAction("luuhieuchinhxuatban");
	
	});
	
	var btnLuuvatrinhpheduyet = $("#<portlet:namespace/>luuhieuchinhpheduyet");
		btnLuuvatrinhpheduyet.on('click',function(event){
		setTypeAction("luuhieuchinhpheduyet");
	
	});    
	
$('#<portlet:namespace/>ngaytao').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y.m.d',
	timepickerScrollbar:true
});
</script>

<script>
	$('#btnyeucauhieuchinh').click(function(){
		setTypeAction("yeucauhieuchinh");
		Liferay.Util.openWindow(
			{
			dialog: {
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870,
	           on: {
	            	success: function() { 
	                    	window.location.reload();                   
	            	}
	           }
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Yêu cầu hiệu chỉnh bài viết',
	        uri: '<%= yeucauhieuchinhURL.toString()%>'
			});
	});	
</script>


