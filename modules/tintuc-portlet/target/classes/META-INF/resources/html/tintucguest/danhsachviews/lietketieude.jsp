<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style type="text/css">	
	li.danhsachtin-khcn-li:after {
	    clear: both;
	    display: block;
	    content: "";
	}
	.createdate {
	    display: block;
	}
</style>

<%
	String xemthem = "Xem tất cả";
	if(langcheck.equals("en_US")){
		xemthem = "View all";
	}
	List<News_Article> listnew_article = null;
	String[] listCategoryId = category_active.substring(1).split("_");
	long idCategory = 0;
	if(listCategoryId.length > 0){
		idCategory = Long.valueOf(listCategoryId[0]);
	}
	listnew_article = TinTucAdminUtil.listTintuc(listCategoryId, langcheck, 0, Integer.valueOf(sotinhienthi));
	//System.out.println("ao tin"+sotinlienquanhienthi);
	News_Categories new_category = null;
	new_category = News_CategoriesLocalServiceUtil.fetchNews_Categories(idCategory);
	
%>
<div class="view_list_container_title <%=tenclass%>">
<%if(category_hide.equals("0")){%>
	<div class="title_category">
		<%
		String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
		%>
		<h3 class="category_name"><a href="<%=urlcat%>"><%=new_category.getName()%></a></h3>
	</div>
<%}
if(listnew_article.size()>0){
%>
<ul class="list-title-ul">
	<%for(int i =0;i<listnew_article.size();i++){
			String tieude = listnew_article.get(i).getTitle();
			if(tieude.length()>Integer.valueOf(dodaitieude)){
				tieude = TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
			}
			String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(i).getId()+"&cat="+new_category.getId();
			String mota = listnew_article.get(i).getInfo();
			if(mota.equals("") || Validator.isNull(mota)){
			}else {
				if(mota.length()>Integer.valueOf(dodaimota)){
					mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";
				}
			}
			
			Date date =  listnew_article.get(i).getCreatedtime();
			Date date2 = new Date();
			long d1 = date.getTime();
			long d2 = date2.getTime();
			long day = Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) + 1;
	%>
		<li class="list-title-li">			
			<div class="title-container">
				<span class="title-news"><a href="<%=urltitle%>" title="<%=tieude%>"><%=tieude%>
				<%if(iconnew.equals("1")){
					if(day<=3){%>
						<img src="<%=request.getContextPath()%>/images/icon_active/new.gif" style="margin-top: -8px; width:33px; height: 16px;"/>
				<%}}%>
				</a></span>
				<span class="mota"><%=mota%></span>
				<span class="createdate"><%=df.format(listnew_article.get(i).getCreatedtime())%></span>
				<%if(readmore_hide.equals("1")){%>
				<a class="readmore" href="<%=urltitle%>">Xem tiếp</a>
				<% } %>
			</div>
		</li>
	<%}%>
	<% 
if(hienthixemthem.equals("on")){
	String urlcat2 = trangchitiet+"?danhmuc="+new_category.getId();
%>
<a class="xemthem-link" href="<%=urlcat2%>">Xem thêm</a>
<%}%>	
</ul>

</div>
<%}%>
