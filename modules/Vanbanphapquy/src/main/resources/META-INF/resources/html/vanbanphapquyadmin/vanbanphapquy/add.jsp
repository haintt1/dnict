
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

<style>
.text-error{
	color: red;
}
</style>

<%
String tabQuanLyVanBan = VanbanphapquyAdminField.value_tabQuanLyVanBan;
List<Linhvucvanban> listlvvb = VanbanphapquyAdminUtil.countLinhvucByKeyword(renderRequest,"",1, 0,0); 
List<Capbanhanh> listcbh = VanbanphapquyAdminUtil.countCapbanhanhByKeyword(renderRequest,"",1, 0,0);
List<Coquanbanhanh> listcqbh = VanbanphapquyAdminUtil.countCoquanbanhanhByKeyword(renderRequest,"",1, 0,0);
List<Loaivanban> listlvb = VanbanphapquyAdminUtil.countLoaivanbanByKeyword(renderRequest, "", 1, 0, 0);
Calendar calendar = Calendar.getInstance();
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/view.jsp"/>
	<portlet:param name="tabs" value="<%=tabQuanLyVanBan %>"/>
</portlet:renderURL>
<portlet:actionURL var="addVanbanphapquyURL" name="addVanbanphapquy">
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
								<aui:form action="${addVanbanphapquyURL }" name="linkForm" method="POST" enctype='multipart/form-data'>
									<table class="tbcoreadmin table table-bordered">
										 <tr>
									  		<th class="key label2">Chọn kiểu văn bản</th>
									  		<td colspan="3">
									  			<select name='<portlet:namespace/>kieuvanban' id="kieuvanban">
									  			<option value="4">Văn bản khác</option>
									  			<option value="0">Văn bản quy phạm pháp luật</option>
									  			<option value="1">Văn bản chỉ đạo điều hành</option>
									  			<option value="2">Văn bản mới</option>
									  			<option value="3">Văn bản bầu cử</option>
									  			</select>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Trích yếu<span class="text-error">*</span></th>
									  		<td colspan="3">
										  		<aui:input name="trichyeu" type="textarea" cols="120" rows="3" label="">
										  			<aui:validator name="required"></aui:validator>
												</aui:input>
											</td>
									  	</tr>
									  	<tr>
											<th class="key label2">Nội dung</th>
											<td colspan="3">
												<aui:fieldset>
											       <aui:field-wrapper>
											               <liferay-ui:input-editor width="100%" name="noidung"/>
											       </aui:field-wrapper>
												</aui:fieldset>
											</td>
										</tr>  	
									  	<tr>
									  		<th class="key label2">Số hiệu<span class="text-error">*</span></th>
									  		<td>
									  			<aui:input name="sohieu" label="">
									  				<aui:validator name="required"></aui:validator>
									  			</aui:input>
									  		</td>
									  		<th class="key label2">Người ký</th>
									  		<td>
									  			<aui:input name="nguoiky" label="">
									  				<aui:validator name="maxLength">100</aui:validator>
									  			</aui:input>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Ngày ban hành</th>
									  		<td>
									  			<aui:input name="ngay_banhanh" size="20" label=""></aui:input>
									  		</td>
									  		<th class="key label2">Ngày xuất bản</th>
									  		<td><aui:input name="ngay_xuatban" size="20" label="" value="<%=df.format(calendar.getTime())%>"></aui:input></td>
									  	</tr>
									  	<tr>
											<th class="key label2">Ngày hiệu lực</th>
											<td><aui:input name="ngay_hieuluc" size="20" label=""></aui:input></td>
											<th class="key label2">Ngày hết hiệu lực</th>
											<td><aui:input name="ngay_hethieuluc" size="20" label=""></aui:input></td>
									  	</tr>
									  	<tr>
									  		<th class="key label2">Lĩnh vực</th>
									  		<td>
									  			<aui:select name="id_linhvuc" label="">									  			  
									  			  <c:forEach items="<%=listlvvb%>" var="lvvb">
													<aui:option value="${lvvb.id}">${lvvb.name}</aui:option>
												  </c:forEach>
												</aui:select>
												<a href="<%=addLinhvucvanbanURL%>"><aui:button  value="Thêm lĩnh vực"/></a>
									  		</td>
									  		<th class="key label2">Loại văn bản</th>
									  		<td>
									  			<aui:select name="id_loaivanban" label="">
									  			  <c:forEach items="<%=listlvb%>" var="lvb">
													<aui:option value="${lvb.id}">${lvb.name}</aui:option>
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
													<aui:option value="${cbh.id}">${cbh.name}</aui:option>
												   </c:forEach>
												</aui:select>
												<a href="<%=addCapbanhanhURL%>"><aui:button  value="Thêm cấp ban hành"/></a>
									  		</td>
									  		<th class="key label2">Cơ quan ban hành</th>
									  		<td>
									  			<aui:select name="id_coquanbanhanh" label="">
									  			  <c:forEach items="<%=listcqbh%>" var="cqbh">
													<aui:option value="${cqbh.id}">${cqbh.name}</aui:option>
												  </c:forEach>
												</aui:select>
												<a href="<%=addCoquanbanhanhURL%>"><aui:button  value="Thêm cơ quan ban hành"/></a>
									  		</td>
									  	</tr>
									  	<tr>
									  		<th class="key">Link hiển thị file PDF</th>
									  		<td><input type="file" name="<portlet:namespace/>filePDF" id="filePDF" onchange="ValidateSingleInputPDF(this);"/></td>
									  		<th class="key">Hiển thị</th>
									  		<td><aui:input name="status" type="checkbox" label="" checked="true"/></td>
									  	</tr>
									  	<tr>
									  		<th>File đính kèm</th>
									  		<td colspan="3">
												<input type="file" name="<portlet:namespace/>files[]" id="filer_input" multiple="multiple" onchange="validateSingleInput(this);"/>
									  		</td>
									  	</tr>
									  	<tr>
									  		<td colspan="4" style="text-align: center" class="key">
												<aui:button type="submit" value="Lưu"/>
												<a href="<%=backURL%>"><aui:button value="Quaylại"/></a>
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
<script type="text/javascript">
jQuery(function($){
	$('#<portlet:namespace/>ngay_banhanh').datepicker();
	$('#<portlet:namespace/>ngay_hieuluc').datepicker();
	$('#<portlet:namespace/>ngay_hethieuluc').datepicker();
	$('#<portlet:namespace/>ngay_xuatban').datepicker();
	$('#filer_input').filer({
  		itemAppendToEnd: false,
		showThumbs: true,
		addMore: true
    });
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