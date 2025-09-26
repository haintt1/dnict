<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nội dung chuyên mục</title>
</head>
<body>
<!-- 
<portlet:renderURL var="addHtmlURL">
	<portlet:param name="jspPage" value="/html/contenthtmladmin/addhtml.jsp"/>
</portlet:renderURL>
 -->
<portlet:actionURL var="addCategoryURL" name="addCategory"/>
<portlet:actionURL var="addSubCategoryURL" name="addSubCategory"/>
	<nav class="management-bar management-bar-light navbar navbar-expand-md">
	<div class="container-fluid container-fluid-max-xl">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="btn btn-primary nav-btn nav-btn-monospaced" href="<%=addSubCategoryURL%>">Thêm thư viện chứa danh mục</a>
			</li>
			<li class="nav-item">
				<a class="btn btn-primary nav-btn nav-btn-monospaced" href="<%=addCategoryURL%>">Thêm danh mục</a>
			</li>
		</ul>	
	</div>
	</nav>
	
	<div class="container-fluid container-fluid-max-xl main-content-body">
		<div class="sheet taglib-empty-result-message" style="padding-bottom: 24px;">
			<% 
				String name ="";
				List<News_Subcategories> listSubCategory = TinTucAdminUtil.countNews_SubCategories(renderRequest, name, 0, 0);
				if(listSubCategory.size() == 0){
			%>
			
			<div class="taglib-empty-result-message-header">
				<div class="sheet-text text-center"></div>
			</div>	
			<%	
				}else {
					for(int i = 0;i< listSubCategory.size(); i++){	
			%>
					<div><%=listSubCategory.get(i).getName() %></div>
					<%} %>
			
			<%} %>
			
		</div>
	</div>
	
</body>
</html>
<style>
.formhtml{width: 95%;}
.mb-3{
	margin: 0 !important;
}
.buttonthml{
	background-color: #f1f2f5;
}
a{
	}
</style>