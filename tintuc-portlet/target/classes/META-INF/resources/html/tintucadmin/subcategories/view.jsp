<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="init.jsp"%>
<link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome/css/font-awesome.min.css">
<liferay-ui:success key="save-successfully" message="Chuyển trang thành công"></liferay-ui:success>
<liferay-ui:success key="delete-successfully" message="Xoá thành công!"/>
<liferay-ui:success key="update-successfully" message="Lưu thành công!"/>
<liferay-ui:error key="cochuadanhmuccon" message="Còn chứa Chuyên mục" />
<liferay-ui:error key="error" message="Xóa không thành công" />
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5; margin: 0px;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal" style="ma">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
<fieldset aria-labelledby="Title" class="container-fluid container-fluid-max-xl container-fluid-1280 panel-body portlet-content-container" style="background: white" role="group">
<h3 class="row-fluid header smaller lighter blue" style="display: contents">Quản lý danh sách chuyên mục</h3>

<portlet:renderURL var="addSubCategoryURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/subcategories/add.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="addCategoryURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/categories/addcategory.jsp"/>
</portlet:renderURL>


<a style="float: right;" class="btn btn-primary" id="btnThemthuvien" href="<%=addSubCategoryURL %>" ><i class="icon-plus"></i> Thêm Thư viện chứa danh mục</a>	
<a style="float: right; margin-right: 10px" class="btn btn-primary" id="btnDanhmuc" href="<%=addCategoryURL %>" ><i class="icon-plus"></i> Thêm Danh mục</a>
</fieldset>
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
<style>
.containerlibcat {
    margin-top: 10px;
}
ul.libdanhmuc {
    margin: 0;
    padding: 0;
}
ul.libdanhmuc li {
    list-style: none !important;
    margin-bottom: 10px !important;
}
.danhmuc > li {
    display: inline-block;
}
.lib-item {
    padding: 2px 15px 2px 22px;
    background: rgba(96, 191, 239, 0.26);
    color: #444;
    border-radius: 45px;
    font-size: 12px;
    box-sizing: border-box;
    position: relative;
}
.lib-item:hover {
    background: #b1dcf4;
}
.danhmuc {
    margin-top: 10px !important;
    margin-bottom: 0px !important;
}
.lib-item:before {
    content: "";
    width: 5px;
    height: 5px;
    background: #ecac4b;
    display: block;
    position: absolute;
    border-radius: 20px;
	left: 8px;
    top: 12px;
}
.lib-item i {
    color: #444;
    margin: 0 0 0 5px;
    text-decoration: none !important;
    font-size: 16px;
}
.lib-item i:hover {
    color: #e7b72d;
    text-decoration: none !important;
}
ul.flag-thuviencategory-ul {
    margin: 0;
    margin-top: 10px;
}
.flag-item-category {
    display: inline-block;
    margin-right: 10px;
}
.flag-item-category a img {
    width: 25px;
}
.flag-item-category a {
    font-size: 12px;
    display: block;
    text-align: center;
}
.flag-item-category a span {
    display: block;
}
.flag-item-category a.active {
    color: #da251d !important;
  	font-weight: bold !important;
}
.flag-item-category  li {
	display: block;
    border: 1px !important;
    border-radius: 8px !important;
    border: solid !important;
    color: darkgray !important;
    border-block-color: red;
    padding: 6px !important;
}
.popup_id{
display: contents;

}
.jconfirm-box-container {

	max-width: 100% !important;
    flex: auto;
}
.title{
font-weight: bold;

}
</style>
<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5; margin: 0px;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal" style="ma">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">


<table class="table table-bordered" style="margin-top: 10px;">
	<tr>
		<th style="width: 10%; color: black; vertical-align: inherit; text-align: center;">
		Ngôn ngữ
	</th>
	<td>
		    <portlet:actionURL var="LangUrl_vn" name="LangCheckCategory">
				<portlet:param name="checklangcategory" value="vi_VN"/>
				<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>"/>
			</portlet:actionURL>
			<portlet:actionURL var="LangUrl_en" name="LangCheckCategory">
				<portlet:param name="checklangcategory" value="en_US"/>
				<portlet:param name="userId" value="<%=String.valueOf(user.getUserId())%>"/>
			</portlet:actionURL>			
			<ul class="flag-thuviencategory-ul">
				<li class="flag-item-category">
					<a id="flag-vn" class="flag-item-a <%=checkLanguageSubCategory.equals("vi_VN")?"active":""%>" href="<%=LangUrl_vn.toString()%>">
						<img alt="" src="<%=request.getContextPath()+"/images/flag/vi_VN.png"%>" style="width: 50px; height: 30px; margin-bottom: 5px;">			
						<span class="btn-section">Tiếng Việt</span>
					</a>
				</li>	
				<li class="flag-item-category">
					<a id="flag-en" class="flag-item-a <%=checkLanguageSubCategory.equals("en_US")?"active":""%>" href="<%=LangUrl_en.toString()%>">
						<img alt="" src="<%=request.getContextPath()+"/images/flag/en_US.png"%>" style="width: 50px; height: 30px; margin-bottom: 5px;">				
						<span class="btn-section">Tiếng Anh</span>
					</a>
				</li>
			</ul>
		</td>
	</tr>
</table>

<div class="containerlibcat">
<%
List<News_Subcategories> listsubcat = TinTucAdminUtil.getSubCatByLang(renderRequest, "", "", 0, 0, 0);

if(listsubcat.size() > 0){
%>
<ul class="libdanhmuc">
<%for(int i = 0;i< listsubcat.size(); i++){
	
%>
	
	<li>
		<portlet:renderURL  var="editSubCatagoriesURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="action" value="success" />
	      	<portlet:param name="subcatid" value="<%= String.valueOf(listsubcat.get(i).getId()) %>" />
	      	<portlet:param name="jspPage" value="/html/tintucadmin/subcategories/edit.jsp"/>
	    </portlet:renderURL>
	    <portlet:actionURL var="deleteSubCatURL" name="deleteSubCat">
			<portlet:param name="subcatid" value="<%=String.valueOf(listsubcat.get(i).getId())%>" />
		</portlet:actionURL>
		<h5 class="thuvien-item">
			<%=listsubcat.get(i).getName()%>
			<a href="javascript:void(0)" att-url="<%=editSubCatagoriesURL %>" class="btnEditSubCat"><img alt="" src="<%= request.getContextPath()%>/images/edit.png"/></a>
			<a class="delete-buton" href="javascript:void(0)" data="<%=deleteSubCatURL.toString()%>"><img style="width:16px;" alt="" src="<%= request.getContextPath()%>/images/delete.ico"/></a>
		</h5>
		
		<%
			List<News_Categories> listcategory = TinTucAdminUtil.getNews_CategoriesByIdSubCat(renderRequest, listsubcat.get(i).getId(), "", 0, 0);
			if(listcategory.size() > 0){
		%>
			<ul class="danhmuc">
				<%for(int a = 0; a < listcategory.size(); a++){%>
					<li>
						<div class="lib-item">
							<portlet:renderURL  var="editCategoriesURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
						      	<portlet:param name="catid" value="<%= String.valueOf(listcategory.get(a).getId()) %>" />
						      	<portlet:param name="jspPage" value="/html/tintucadmin/categories/editcategory.jsp"/>
						    </portlet:renderURL>
						    <portlet:actionURL var="deleteCategoriesURL" name="deleteCategories">
								<portlet:param name="catid" value="<%=String.valueOf(listcategory.get(a).getId())%>" />
							</portlet:actionURL>
							<%=listcategory.get(a).getName()%> 
							<a href="#edit" att-url="<%=editCategoriesURL%>" class="btnEditCategories" title="Chỉnh sửa"><i class="fa fa-cog"></i></a> 
							<a class="delete-buton" href="javascript:void(0)" data="<%=deleteCategoriesURL.toString()%>"><i class="fa fa-remove"></i></a>
						</div>
					</li>
				<%}%>
			</ul>
		
		
		<%} %>
	</li>
	
<%}%>
</ul>
<%}%>
</div>

</div>
</div>
</div>
</div>
</div>
</div>
</nav>

</body>
<aui:script position="inline">
$('.btnEditSubCat').click(function(){
		var url = $(this).attr('att-url')
		Liferay.Util.openWindow(
			{
			dialog: {
			   cache: false,
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Chỉnh sửa thư mục chứa',
	        uri: url
			});
});

$('.btnEditCategories').click(function(){
		var url = $(this).attr('att-url')
		Liferay.Util.openWindow(
			{
			dialog: {
			   cache: false,
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Chỉnh sửa danh mục',
	        uri: url
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
</aui:script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/jquery-confirm.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-confirm.js"></script>
<script>
$(document).ready(function(){
	 $('.delete-buton').on('click', function () {
		 var href = $(this).attr('data');
         window.b = $.confirm({
        	    title: 'Xóa dữ liệu !!!',
        	    content: 'Khi xóa sẽ không khôi phục lại dữ liệu được. Bạn có chắc chắn không !!!',
        	    confirmButtonClass: 'btn-info',
        	    cancelButtonClass: 'btn-danger',
        	    confirm: function(){
        	        location.href = href;
        	        
        	    },
/*         	    cancel: function () {
                    $.alert('you clicked on cancel');
                }, */
        	});
     });
});
</script>