<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="vn.dnict.tintuc.service.News_SubcategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<liferay-ui:success key="delete-successfully" message="Xoá thành công!"/>
<liferay-ui:success key="update-successfully" message="Lưu thành công!"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chỉnh sửa thư viện</title>
</head>
<%
	String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
%>
<!-- 
<portlet:actionURL  var="upSubCategoryURL" name="upSubCategory" />
<portlet:actionURL name="updateSubCategory" var="updateSubCategoryURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/subcategories/edit.jsp"/>
	<portlet:param name="tabs" value="<%=tabChuyenMuc %>"/>
</portlet:actionURL> -->
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/subcategories/view.jsp" />
	<portlet:param name="tabs" value="<%=tabChuyenMuc %>"/>
</portlet:renderURL>
<%
String saveStatus = ParamUtil.getString(request, "action");
%>


<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;padding-top: 20px;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
							<form  id="formAddThongTin" name="formAddThongTin"  method="POST">
								<aui:input id="action" name="action" type="hidden" value="<%=saveStatus %>"></aui:input>
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											
											
											<%
												String idSubCat = ParamUtil.getString(request, "subcatid");
												//System.out.println("Trang edit: "+idSubCat);
												News_Subcategories subCat = (News_Subcategories) News_SubcategoriesLocalServiceUtil.fetchNews_Subcategories(Long.valueOf(idSubCat));
													
													
											%>
											
											<label class="control-label">Tên thư viện</label>
											<aui:input id="name" name="name" value="<%=subCat.getName() %>" label="" type="input">
												<aui:validator name="required"></aui:validator>
												<aui:validator name="maxLength">500</aui:validator>
											</aui:input>
										</td>	
									</tr>
									
									<tr>
										<td>
											<label class="control-label">Ngôn ngữ</label>
											<select class="form-control"  id="language" name='<portlet:namespace/>language'>
							 	     			<option value="vi_VN" <%=checkLanguageSubCategory.equals("vi_VN")?"selected":""%>>Việt Nam</option>
							 	     			<option value="en_US" <%=checkLanguageSubCategory.equals("en_US")?"selected":""%>>Tiếng Anh</option>
							 	     <!-- 		<option value="ja_JP" <%=checkLanguageSubCategory.equals("ja_JP")?"selected":""%>>Nhật Bản</option>								 	     		
								 	     		<option value="ko_KR" <%=checkLanguageSubCategory.equals("ko_KR")?"selected":""%>>Tiếng Hàn</option> -->
								 	     	</select>
											
										</td>	
									</tr>
											
									<tr>
										<td colspan="1">
											<label class="control-label">Sử dụng</label>
											<input id="status" name="status" label="" type="checkbox" style="margin-top: 26px;margin-left: 12px;" checked="<%=subCat.getStatus() == 0?true:false %>" />
										</td>
									</tr>	
									<tr>
										<td colspan="2" class="key" style="text-align: center;">
											<div style="display:center;">
											<aui:input name="subcatid" type="hidden" value="<%=Long.valueOf(idSubCat)%>"></aui:input>
											<aui:button id="update" name="update" cssClass="btnupdate btn btn-small btn-info" value="Lưu thông tin" label=""></aui:button>  														
 											<button id="closeButton" class="btn btn-small btn-danger" value="Đóng" style="height:40px !important; margin: 5px;"/>Đóng		
											</div>
										</td>
									</tr>
								</table>
							<form>
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

</html>
<style>
	.addhtml{background: }
	.dropbtn{margin: 0; padding: 0}
	.dropdown-content{margin: 0; padding: 0}

#languages {
    background-repeat: no-repeat;
    background-image: url("/o/vn.dnict.tintuc/images/flag/vi_VN.png");
    padding-right: 20px;
}
#languages option:nth-child(1) {
    background: url(/o/vn.dnict.tintuc/images/flag/vi_VN.png) no-repeat right center;  
}
#languages option:nth-child(2) {
    background: url(/o/vn.dnict.tintuc/images/flag/en_US.png) no-repeat right center;  
}
#languages option:nth-child(3) {
    background: url(/o/vn.dnict.tintuc/images/flag/ja_JP.png) no-repeat right center;  
}
#languages option:nth-child(4) {
    background: url(/o/vn.dnict.tintuc/images/flag/ko_KR.png) no-repeat right center;  
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<srcript src="<%=request.getContextPath() %>/js/jquery.js"></srcript>
<!-- <script language="javascript" type="text/javascript">
    function submitDetailsForm() {
       $("#formAddThongTin").submit();
    }
</script> -->
<aui:script use="aui-base,aui-io-request">
	A.one('#<portlet:namespace/>update').on('click', function(event){
		var A = AUI();
		var id = A.one('#<portlet:namespace/>subcatid>').val();		
		var name = A.one('#<portlet:namespace/>name>').val();		
		var language = A.one('#language').val();		
		var status =  "";
		var checkBoxStatus = A.all(':checked');
		if(checkBoxStatus.attr('checked') == 'true') {
			status = '0';
		}
		else if(checkBoxStatus.attr('checked') == ''){
			status = '1' ;
		}
		
		var url = '<%=upSubCategoryURL.toString() %>';
		A.io.request(
	    url,
	      {
	      	method: 'POST',
<%-- 			form: {id: '<portlet:namespace />formAddThongTin'}, --%>
			data: {
				<portlet:namespace/>subcatid: id, 
                <portlet:namespace/>name: name, 
                <portlet:namespace/>language: language,
                <portlet:namespace/>status: status,
            },
	        on: {  
	          success: function() {	          		
	          		var data = this.get('responseData');
	          		Liferay.Util.getOpener().<portlet:namespace/>refreshPortlet();
	            	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
					
	          }
	        }
	      }
	    )
	});
</aui:script>
<aui:script>
$('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

</aui:script>