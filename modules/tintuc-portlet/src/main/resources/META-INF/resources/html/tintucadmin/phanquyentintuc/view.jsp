<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.service.News_roleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Phân quyền tin tức</title>
</head>


<%
int stt = 1;
List<User> users = PhanQuyenAdminUtil.getUsers();
%>

<portlet:actionURL var="saveNewsRoleURL" name="saveNewsRole">
	<portlet:param name="jspPage" value="/html/tintucadmin/phanquyentintuc/view.jsp" />
</portlet:actionURL>
<liferay-ui:success key="save-successfully" message="Lưu thành công!"/>

<body style="background: #f1f2f5;">

<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;">
<div class="container-fluid container-fluid-max-xl">
		<div class="portlet-content-container" style="width: 100%">
		
			<div class="portlet-body">
					<span class="breadcrumb-text-truncate" style="margin-top: 10px;">Trang chủ</span>				
					<div class="card-horizontal main-content-card">
						<div aria-multiselectable="true" class="panel-group" role="tablist">
							<fieldset aria-labelledby="Title" class=" " role="group">
								<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
									<div class="">
									<aui:form cssClass="formAddThongTin" name="formAddThongTin"  action="<%=saveNewsRoleURL %>" method="post">																				
										<h3 class="row-fluid header smaller lighter blue">
											<span class="span1" style="float:right;margin-right: 8px;margin-bottom: 8px;">
												<span class="btn-group pull-right inline">			
													<a type="button" class="btn btn-info" id="btn-submit">Lưu phân quyền</a>
													<!-- <button class="btn btn-info" type="submit">Lưu phân quyền</button> -->
												</span>
											</span>
										</h3>
										<table class="show-quick-actions-on-hover table table-autofit table-heading-nowrap table-list">
																						
											<tr>
												<th class="lfr-checkbox-column" style="text-align: center;">#</th>
												<th class="lfr-name-column table-title">Tên</th>
												<th class="lfr-document-type-column table-cell-expand-smaller">Chuyên mục</th>
												<th class="lfr-status-column table-cell-expand-smallest" style="text-align: center;">Đăng tin</th>
												<th class="lfr-status-column table-cell-expand-smallest" style="text-align: center;">Biên tập viên</th>
												<th class="lfr-status-column table-cell-expand-smallest" style="text-align: center;">Xuất bản</th>
											</tr>
											<%
												//System.out.print(users);
												if(users.size() > 0){
													for(int i = 0; i < users.size(); i++){
														
													News_role objRole = null;
													objRole = PhanQuyenAdminUtil.getUserById(users.get(i).getUserId());
													String checked_add = "";
													String checked_edit = "";
													String checked_public = "";
													if(Validator.isNotNull(objRole)){
														if(objRole.getRole_add()== 1){
															checked_add = "checked";
														}
														if(objRole.getRole_edit()== 1){
															checked_edit = "checked";
														}													
														if(objRole.getRole_public()== 1){
															checked_public= "checked";
														}
													}
													
													
											%>
											<tr>
												
												<td><%=stt++ %></td>
												<td class="lfr-name-column table-title"><%=users.get(i).getFullName() %></td>													
												<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
													<portlet:param name="iduser" value="<%= String.valueOf(users.get(i).getUserId())%>" />
													<portlet:param name="jspPage" value="/html/tintucadmin/phanquyentintuc/checkdanhmuc.jsp" />
												</portlet:renderURL>
												<%
													
												String data_category = objRole.getCategory_active_role();
  												if(data_category != ""){
 													data_category = objRole.getCategory_active_role();
 												} 
												String listname = "";
												String nameStringurl = "";
												String[] category_id = null;
												if(!data_category.equals("")){
													category_id = data_category.split("_");
													
												}
												if(category_id != null){
													for(int v = 0; v< category_id.length; v++){
														if(!category_id[v].equals("")){
															//New_Category cat = New_CategoryLocalServiceUtil.fetchNew_Category(Long.valueOf(category_id[v]));
															News_Categories cat = News_CategoriesLocalServiceUtil.fetchNews_Categories(Long.valueOf(category_id[v]));
															if(Validator.isNull(cat)){
																cat = null;
															}
															if(nameStringurl.equals("")){
																nameStringurl = nameStringurl+cat.getName();
															}else{
																nameStringurl = nameStringurl+", "+cat.getName();;
															}
														}
													}	
												}
												%>
												<td>
													<a class="btn btn-primary btnChuyenmuc" att-url="<%=checkchuyenmucURL%>" id="btnChuyenmuc"><i class="icon-plus"></i> Chọn danh mục</a>
													<div><span class="listdanhmuc" id="listdanhmuc_<%=users.get(i).getUserId()%>"><%=nameStringurl%></span></div>
													<input id="<portlet:namespace/>danhmuc-<%=users.get(i).getUserId()%>" class="data_category" type="hidden" name="<portlet:namespace/>danhmuc-<%=users.get(i).getUserId()%>" value="<%=data_category%>"/>
													
																										
												</td>
										
												<td style="text-align: center;"><input name="<portlet:namespace/>role_quyen_<%=users.get(i).getUserId()%>" <%=checked_add %> type="radio" value="dangtin" /></td>
												<td style="text-align: center;"><input name="<portlet:namespace/>role_quyen_<%=users.get(i).getUserId()%>" <%=checked_edit %> type="radio" value="bientap" /></td>
												<td style="text-align: center;"><input name="<portlet:namespace/>role_quyen_<%=users.get(i).getUserId()%>" <%=checked_public %> type="radio" value="pheduyet"/></td>
											</tr>

											<%			
													}
												}
											%>
										</table>
										
									</aui:form>
								</div>
							</fieldset>
						</div>
					</div>
				
			</div>
		</div>
	</div>
</nav>											
</body>
<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//$('.chuyenmuc-multiple-selected').multiselect();
	$('#btn-submit').click(function(event){
		//alert("aaaa");		
		//var els = $('.chuyenmuc-multiple-selected');
		//$.each(els,function(i,el){
			//var that = $(el); 
			//if(that.val()!=null){
				//$('input[name="'+that.attr("data-categoryrole")+'"]').val(that.val());
				//$(el).attr("data-categoryrole");
			//}
		//});
	
		$('.formAddThongTin').submit();
	});
	
})
</script>
</html>
<aui:script position="inline">
$('.btnChuyenmuc').click(function(){		
		var checkchuyenmucURL = $(this).attr('att-url');
		Liferay.Util.openWindow(
			{
			dialog: {
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Chọn chuyên mục hiển thị',
	        uri: checkchuyenmucURL
			});
	});
	
Liferay.provide(window, '<portlet:namespace/>refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },['aui-dialog','aui-dialog-iframe']);
    
Liferay.provide(window, '<portlet:namespace/>closePopup', function(dialogId) {
		var A = AUI();
		var dialog = Liferay.Util.Window.getById(dialogId);
			dialog.destroy();
	},['liferay-util-window']);	
	<!-- Truyen bien tu popup sang view chinh -->
Liferay.provide(window, 'listchonnhieudanhmuc', function(data, userId,name) {
        $("#listdanhmuc_"+userId).html(name);
        $("#<portlet:namespace/>danhmuc-"+userId).val(data);
	},['liferay-util-window']);



</aui:script>