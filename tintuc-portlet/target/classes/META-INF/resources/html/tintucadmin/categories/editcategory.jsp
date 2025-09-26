<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@page import="vn.dnict.tintuc.service.News_SubcategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="../../../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Chỉnh sửa Danh mục</title>
</head>
<body>
<%
	String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
%>
<portlet:actionURL name="updateCategory" var="updateCategoryURL">
</portlet:actionURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/subcategories/view.jsp" />
	<portlet:param name="tabs" value="<%=tabChuyenMuc %>" />
</portlet:renderURL>
<%
String id = ParamUtil.getString(request, "catid");
//System.out.println("Trang edit: "+id);
News_Categories objectCat = (News_Categories)News_CategoriesLocalServiceUtil.fetchNews_Categories(Long.valueOf(id));

%>
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
							<aui:form name="formAddThongTin" action="<%=updateCategoryURL.toString() %>"
								method="post">
								<table class="tbcoreadmin" style="width: 100%">
									<tr>
										<td colspan="100">
											<label class="control-label">Name</label>
											<aui:input name="name" value="<%=objectCat.getName() %>" label="" type="input">
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
								 	     		<option value="ko_KR" <%=checkLanguageSubCategory.equals("ko_KR")?"selected":""%>>Tiếng Han</option> -->
								 	     	</select>
											
										</td>	
									</tr>
									
									 <tr>
										<td>
											<label class="control-label">Tên thư mục chứa</label>
											<aui:select name="thuvien" label="" required="true">
											<%
												long idlibcat = objectCat.getIdlibcat();
												//System.out.print("subcat" + idlibcat);
												List<News_Subcategories> res = TinTucAdminUtil.getSubCatByLanguage(renderRequest, checkLanguageSubCategory, "", 0, 0, 0);
												
												for(int i = 0; i < res.size(); i++){
													boolean selected = false;
													if(objectCat.getIdlibcat() == res.get(i).getId()){
														selected = true;
													}
											%>
											<aui:option value="<%=res.get(i).getId()%>" selected="<%=selected%>">- <%=res.get(i).getName()%></aui:option>
											<%}%>
											</aui:select>
										</td>	
									</tr>
									 
									 
									<tr>
										<td colspan="1">
											<label class="control-label">Sử dụng</label>
											<input name="status" label="" type="checkbox" style="margin-top: 26px;margin-left: 12px;" checked="<%=objectCat.getStatus() == 0?true:false %>" />
										</td>
									</tr>
									<tr>
										<td colspan="2" class="key" style="text-align: center;">
											<aui:input name="catid" type="hidden" value="<%=Long.valueOf(id)%>"></aui:input>
											<aui:button id="update" name="update" cssClass="btnupdate btn btn-small btn-info" value="Lưu thông tin" label=""></aui:button>  														
 											<button id="closeButton" class="btn btn-small btn-danger" value="Đóng" style="height:40px !important; margin: 5px;"/>Đóng		
										</div>
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
</div>
</nav>	
<%//System.out.print(request.getContextPath()); %>
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
<script>
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
	$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
	});
</script>
<aui:script use="aui-base,aui-io-request">
	A.one('#<portlet:namespace/>update').on('click', function(event){
		var A = AUI();
		var id = A.one('#<portlet:namespace/>catid>').val();		
		var name = A.one('#<portlet:namespace/>name>').val();		
		var language = A.one('#language').val();
		var idlibcat = A.one('#<portlet:namespace/>thuvien>').val();	
		var status =  "";
		var checkBoxStatus = A.all(':checked');
		if(checkBoxStatus.attr('checked') == 'true') {
			status = '0';
		}
		else if(checkBoxStatus.attr('checked') == ''){
			status = '1' ;
		}
		
		var url = '<%=updateCategoryURL.toString() %>';
		A.io.request(
	    url,
	      {
	      	method: 'POST',
<%-- 			form: {id: '<portlet:namespace />formAddThongTin'}, --%>
			data: {
				<portlet:namespace/>catid: id, 
                <portlet:namespace/>name: name, 
                <portlet:namespace/>language: language,
                <portlet:namespace/>thuvien: idlibcat,
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
