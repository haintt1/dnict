<%@page import="java.util.Arrays"%>
<%@page import="vn.dnict.vanbanphapquy.utils.DocumentUpload"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.dnict.vanbanphapquy.model.dinhkemfile"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="vn.dnict.vanbanphapquy.model.Vanbanphapquy"%>
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="vn.dnict.vanbanphapquy.model.Loaivanban"%>
<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.model.Linhvucvanban"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@page import="java.util.List"%>

<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<portlet:defineObjects />
<body>
<%
String tabQuanLyVanBan = VanbanphapquyAdminField.value_tabQuanLyVanBan;
List<Linhvucvanban> listlvvb = VanbanphapquyAdminUtil.countLinhvucByKeyword(renderRequest,"",1, 0,0); 
List<Capbanhanh> listcbh = VanbanphapquyAdminUtil.countCapbanhanhByKeyword(renderRequest,"",1, 0,0);
List<Coquanbanhanh> listcqbh = VanbanphapquyAdminUtil.countCoquanbanhanhByKeyword(renderRequest,"",1, 0,0);
List<Loaivanban> listlvb = VanbanphapquyAdminUtil.countLoaivanbanByKeyword(renderRequest, "", 1, 0, 0);
Vanbanphapquy editVanbanphapquy = (Vanbanphapquy) request.getAttribute("editVanbanphapquy");
Calendar calendar = Calendar.getInstance();
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

String ngay_banhanh = "";
String ngay_hieuluc = "";
String ngay_hethieuluc = "";
String ngay_xuatban = "";
String noidungchitiet = "";
String link_hienthifilepdf = "";
String result_split[] = null;
int type = 0;
if(Validator.isNumber(editVanbanphapquy.getType())){
	 type = Integer.parseInt(editVanbanphapquy.getType());
}
if(Validator.isNotNull(editVanbanphapquy.getNgay_banhanh())){
	 ngay_banhanh = df.format(editVanbanphapquy.getNgay_banhanh()); 
}
if(Validator.isNotNull(editVanbanphapquy.getNgay_hieuluc())){
	ngay_hieuluc = df.format(editVanbanphapquy.getNgay_hieuluc()); 
}
if(Validator.isNotNull(editVanbanphapquy.getNgay_hethieuluc())){
	ngay_hethieuluc = df.format(editVanbanphapquy.getNgay_hethieuluc()); 
}
if(Validator.isNotNull(editVanbanphapquy.getNgay_xuatban())){
	ngay_xuatban = df.format(editVanbanphapquy.getNgay_xuatban()); 
}
if(!editVanbanphapquy.getNoidung().equals("") && Validator.isNotNull(editVanbanphapquy.getNoidung())){
 	result_split = editVanbanphapquy.getNoidung().split("&&_phancach_&&");
 }
 if(Validator.isNotNull(result_split) && result_split.length >0){
	 if(Validator.isNotNull(result_split[0])){
		 noidungchitiet = result_split[0];
	 }
 }
%>
<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/view.jsp"/>
	<portlet:param name="tabs" value="<%=tabQuanLyVanBan %>"/>
</portlet:renderURL>
<portlet:actionURL var="updateVanbanphapquyURL" name="updateVanbanphapquy">
	<portlet:param name="tabs" value="<%=tabQuanLyVanBan %>"/>
</portlet:actionURL>
<portlet:renderURL var="addLinhvucvanbanURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/linhvuc/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addLoaivanbanURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/loaivanban/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addCapbanhanhURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/capbanhanh/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addCoquanbanhanhURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/coquanbanhanh/add.jsp"/>
</portlet:renderURL>


<div class="portlet-content-container">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
								<aui:form action="${updateVanbanphapquyURL }" name="linkForm" method="POST" enctype='multipart/form-data'>
									<table class="tbcoreadmin table table-bordered">
										 <tr>
									  		<th class="key label2">Chọn kiểu văn bản</th>
									  		<td colspan="3">
									  			<select name='<portlet:namespace/>kieuvanban' id="kieuvanban">
										  			<aui:option value="4" selected="<%=type==4?true:false%>">Văn bản khác</aui:option>
										  			<aui:option value="0" selected="<%=type==0?true:false%>">Văn bản quy phạm pháp luật</aui:option>
										  			<aui:option value="1" selected="<%=type==1?true:false%>">Văn bản chỉ đạo điều hành</aui:option>
										  			<aui:option value="2" selected="<%=type==2?true:false%>">Văn bản mới</aui:option>
										  			<aui:option value="3" selected="<%=type==3?true:false%>">Văn bản bầu cử</aui:option>
									  			</select>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Trích yếu<span class="text-error">*</span></th>
									  		<td colspan="3">
										  		<aui:input name="trichyeu" type="textarea" cols="120" rows="3" label="" value="<%=editVanbanphapquy.getTrichyeu()%>">
										  			<aui:validator name="required"></aui:validator>
												</aui:input>
												<aui:input name="id" type="hidden" value="<%=editVanbanphapquy.getId() %>"/>
											</td>
									  	</tr>
									  	<tr>
											<th class="key label2">Nội dung</th>
											<td colspan="3">
												<aui:fieldset>
											       <aui:field-wrapper>
											               <liferay-ui:input-editor width="100%" name="noidung" initMethod="initEditor"/>
											       </aui:field-wrapper>
												</aui:fieldset>
											</td>
										</tr>  	
									  	<tr>
									  		<th class="key label2">Số hiệu</th>
									  		<td>
									  			<aui:input name="sohieu" label="" value="<%=editVanbanphapquy.getSohieu()%>"></aui:input>
									  		</td>
									  		<th class="key label2">Người ký</th>
									  		<td>
									  			<aui:input name="nguoiky" label="" value="<%=editVanbanphapquy.getNguoiky()%>">
									  				<aui:validator name="maxLength">100</aui:validator>
									  			</aui:input>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Ngày ban hành</th>
									  		<td>
									  			<aui:input name="ngay_banhanh" size="20" label="" value="<%=ngay_banhanh%>"></aui:input>
									  		</td>
									  		<th class="key label2">Ngày xuất bản</th>
									  		<td><aui:input name="ngay_xuatban" size="20" label="" value="<%=ngay_xuatban%>"></aui:input></td>
									  	</tr>
									  	<tr>
											<th class="key label2">Ngày hiệu lực</th>
											<td><aui:input name="ngay_hieuluc" size="20" label="" value="<%=ngay_hieuluc%>"></aui:input></td>
											<th class="key label2">Ngày hết hiệu lực</th>
											<td><aui:input name="ngay_hethieuluc" size="20" label="" value="<%=ngay_hethieuluc%>"></aui:input></td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Lĩnh vực</th>
									  		<td>
									  			<aui:select name="id_linhvuc" label="">
									  			 <aui:option value="-1">----</aui:option>
									  			  <c:forEach items="<%=listlvvb%>" var="lvvb">
													<aui:option value="${lvvb.id}" selected="${lvvb.id==editVanbanphapquy.id_linhvuc?true:false}">${lvvb.name}</aui:option>
												  </c:forEach>
												</aui:select>
												<a href="<%=addLinhvucvanbanURL%>"><aui:button  value="Thêm lĩnh vực"/></a>
									  		</td>
									  		<th class="key label2">Loại văn bản</th>
									  		<td>
									  			<aui:select name="id_loaivanban" label="">
									  			  <c:forEach items="<%=listlvb%>" var="lvb">
													<aui:option value="${lvb.id}" selected="${lvb.id==editVanbanphapquy.id_loaivanban?true:false}">${lvb.name}</aui:option>
												  </c:forEach>
												</aui:select>
												<a href="<%=addLoaivanbanURL%>"><aui:button  value="Thêm loại văn bản"/></a>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Cấp ban hành</th>
									  		<td>
									  			<aui:select name="id_capbanhanh" label="">
									  			   <c:forEach items="<%=listcbh%>" var="cbh">
													<aui:option value="${cbh.id}" selected="${cbh.id==editVanbanphapquy.id_capbanhanh?true:false}">${cbh.name}</aui:option>
												   </c:forEach>
												</aui:select>
												<a href="<%=addCapbanhanhURL%>"><aui:button  value="Thêm cấp ban hành"/></a>
									  		</td>
									  		<th class="key label2">Cơ quan ban hành</th>
									  		<td>
												<aui:select name="id_coquanbanhanh" label="">
									  			  <c:forEach items="<%=listcqbh%>" var="cqbh">
													<aui:option value="${cqbh.id}" selected="${cqbh.id==editVanbanphapquy.id_coquanbanhanh?true:false}">${cqbh.name}</aui:option>
												  </c:forEach>
												</aui:select>
												<a href="<%=addCoquanbanhanhURL%>"><aui:button  value="Thêm cơ quan ban hành"/></a>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key">File PDF hiển thị</th>
									  		<td class="pdflinktd" colspan="3">
									<%--   		<aui:input name="link_hienthifile_pdf" size="20" label="" value="<%=link_hienthifilepdf%>"></aui:input> --%>
											<%if(!link_hienthifilepdf.equals("")){%>
												<a href="<%=link_hienthifilepdf%>">File PDF</a> - <a href="javascript:void(0);" class="del-item">Xóa file</a>
											<%}else{%>
									  			<input type="file" name="<portlet:namespace/>filePDF" id="filePDF" multiple="multiple" onchange="ValidateSingleInputPDF(this);"/>
									  		<%}%>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key">Hiển thị</th>
									  		<td><aui:input name="status" type="checkbox" label="" checked="<%=editVanbanphapquy.getStatus()==1?true:false%>"/></td>
									  		<th class="key">File đính kèm khác</th>
									  		<td>
									  				<%
														List<dinhkemfile> listfileDinhkem = new ArrayList<dinhkemfile>();
														listfileDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(editVanbanphapquy.getId(), 1, themeDisplay);
														if(listfileDinhkem.size() > 0){
															int dem = 1;
															for(dinhkemfile file: listfileDinhkem){
													%>
														<portlet:actionURL name="deleteFileAtt" var="deleteFileAttURL">
															<portlet:param name="id" value="<%= String.valueOf(file.getId()) %>" />
															<portlet:param name="idvbpq" value="<%= String.valueOf(editVanbanphapquy.getId()) %>" />
														</portlet:actionURL>
														<a class="link_dow" href="<%=file.getUrl()%>" target="blank"><%=dem%>. <%=file.getTen()%></a> - <a class="del-item" data="<%=deleteFileAttURL%>"  href="<%=deleteFileAttURL%>">Xóa file</a><br/>
													<%
													dem++;
													}}else{%>
														<input type="file" name="files[]" id="filer_input" multiple="multiple" onchange="validateSingleInput(this);"/>
													<%}%>
									  		</td>
									  	</tr>
									  	<tr>
									  		<td colspan="4" style="text-align: center" class="key">
												<aui:button type="submit" value="Lưu"/>
												<a href="<%=backURL%>"><aui:button value="Quay lại"/></a>
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
<script type="text/javascript">
function <portlet:namespace />initEditor() {
    return "<%= UnicodeFormatter.toString(noidungchitiet) %>";
}

jQuery(function($){
	$('#<portlet:namespace/>ngay_banhanh').datepicker();
	$('#<portlet:namespace/>ngay_hieuluc').datepicker();
	$('#<portlet:namespace/>ngay_hethieuluc').datepicker();
	$('#<portlet:namespace/>ngay_xuatban').datepicker();
});

function ValidateSingleInputPDF(oInput) {
	const _validFileExtensionsPdf = ["pdf"];
    if (oInput.type == "file") {
        var sFileName = oInput.value;
         if (sFileName.length > 0) {
        	 const extensionPdf = sFileName.substring(sFileName.lastIndexOf('.') + 1).toLowerCase()
        	 let blnValids = _validFileExtensionsPdf.includes(extensionPdf)            
        	 if (!blnValids) {
                 alert("Xin lỗi, " + sFileName + " bị lỗi, tập tin phải là : " + _validFileExtensionsPdf);
                 oInput.value = "";
                 return false;
             }
        }
    }
    return true;
}

function validateSingleInput(input) {
    const _validFileExtensions = ["pdf", "doc", "docx", "xls", "xlsx", "rar", "zip", "ppt", "pptx"];
    if (input.type === "file") {
        const sFileName = input.value;
        if (sFileName.length > 0) {
            const extension = sFileName.substring(sFileName.lastIndexOf('.') + 1).toLowerCase()
            let blnValid = _validFileExtensions.includes(extension)
            if (!blnValid) {
                alert("Xin lỗi, " + sFileName + " bị lỗi, tập tin phải là : " + _validFileExtensions);
                input.value = "";
                return false;
            }
        }
    }
    return true;
}

</script>