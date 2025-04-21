<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int total = 0;
String dinhdanhs = ParamUtil.getString(request, "dinhdanh");
String searchNews = ParamUtil.getString(request, "searchNew");
//System.out.println("aaaa"+dinhdanh);

PortletURL pagingUrl = renderResponse.createRenderURL();
pagingUrl.setParameter("jspPage","/html/tintucguest/hienthitintuc/searchNews.jsp");
pagingUrl.setParameter("searchNew",searchNew);
pagingUrl.setParameter("dinhdanh",dinhdanh);
SearchContainer searchContainer = null;
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 10, pagingUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 10,
			pagingUrl, null, null);
}
int start = searchContainer.getStart();
int end = searchContainer.getEnd();
//System.out.print("a"+start);
List<News_Article> listTintuc = TinTucAdminUtil.listTintuc(searchNews, dinhdanhs, "", start, end);
total = TinTucAdminUtil.listTintuc(searchNews, dinhdanhs, "", langcheck, 0, 0).size();
searchContainer.setTotal(total);
searchContainer.setResults(listTintuc);
%>
<portlet:renderURL var="searchBaivietURL">
	<portlet:param name="jspPage" value="/html/tintucguest/hienthitintuc/searchNews.jsp"/>
</portlet:renderURL>
<%-- <portlet:actionURL name="searchBaiviet" var="searchBaivietURLs">
	<portlet:param name="idarticle" value="<%=actionRequest.getParameter("idarticle") %>"/>
	<portlet:param name="jspPage" value="/html/tintucguest/hienthitintuc/configuration.jsp"/>
</portlet:actionURL> --%>
<form action="<%=searchBaivietURL %>" method="post" id="frmAction">
	<table class="table table-bordered">
		<tr>
			<th>Tên hoặc định danh bài viết</th>
			<td><input type="text" name="<portlet:namespace/>searchNew" id="searchNew" value="<%=searchNew%>"></td>
		</tr>
		<tr>
			<th>Định danh</th>	
			<td><input name="<portlet:namespace/>dinhdanh" value="<%=dinhdanh%>" type="text"></input></td>
		</tr>
		<tr>
			<td style="text-align: center;" colspan="2">
				<aui:button cssClass="btn-small btn" name="dongy" type="submit" value="Tìm kiếm" label=""></aui:button>
			</td>
		</tr>
	</table>
</form>
<%if(listTintuc.size()>0){%>
<table class="table table-bordered">
<tr>
	<th style="text-align: center;">STT</th>	
	<th style="text-align: center;">Định danh</th>
	<th style="text-align: center;">Tiêu đề bài viết</th>
</tr>
<%
	int dem = 1;
for(int a = 0; a < listTintuc.size(); a++){%>
	<tr>
		<td><%=dem+a%></td>
		<td><%=listTintuc.get(a).getId()%></td>
		<input name='<portlet:namespace/>idarticle' type="hidden" value="<%=String.valueOf(listTintuc.get(a).getId())%>"/>
		<td>
<%-- 			<portlet:renderURL var="select_article">
				<portlet:param name="jspPage" value="/html/tintucguest/hienthitintuc/view.jsp"/>
				<portlet:param name="idarticle" value="<%=String.valueOf(listTintuc.get(a).getId())%>"/>
			</portlet:renderURL> --%>
			<portlet:actionURL name="select_article" var="select_articleURL">
				<portlet:param name="jspPage" value="/html/tintucguest/hienthitintuc/view.jsp"/>
				<portlet:param name="idarticle" value="<%=String.valueOf(listTintuc.get(a).getId())%>"/>
			</portlet:actionURL>
			<a href="<%=select_articleURL%>" onclick="return confirm('Bạn chắc chắn chọn bài viết này !');"><%=listTintuc.get(a).getTitle()%></a>
		</td>
	</tr>	
<%dem++;}%>
</table>
<div class="paginator"><liferay-ui:search-paginator searchContainer="<%= searchContainer %>" /></div>
<%}%>
