<%@page import="com.liferay.counter.kernel.service.CounterLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.Paging"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<style type="text/css">
			.item-list-article-img img {
			    width: 140px;
			    height: auto;
			}
			.item-list-article-img {
			    width: 140px;
			    height: 90px;
			    box-sizing: border-box;
			    overflow: hidden;
			}
			.item-list-article-img {
			    float: left;
			     max-width: 15%;
			}
			.item-list-article-content {
			    float: left;
			}
			.item-list-article:after {
			    clear: both;
			    display: block;
			    content: "";
			}
			.item-list-article-content {
			    padding-left: 20px;
			    width: 83%;
			}
			span.title-item-article {
			    font-weight: bold;
			    font-size: 18px;
			}
			span.createdtime-item-article {
			    display: block;
			    width: 90px;
			    font-size: 12px;
			}
			.title-category {
			    font-size: 20px;
			    font-weight: bold;
			    margin-bottom: 20px;
			}
		</style>
	</head>
		<body>	
		<%
			HttpServletRequest request2 = PortalUtil.getOriginalServletRequest(request);
			List<News_Article> listnew_article = null;
			String data_category = category_active.substring(0);	
			String[] category_id = null;
			long catid = 0;
			if(!data_category.equals("")){
				category_id = data_category.substring(1).split("_");
				catid = Long.valueOf(category_id[0]);
				int p = 1;
				if(Validator.isNotNull(request2.getParameter("p")) && Validator.isNumber(request2.getParameter("p"))){
					p = Integer.valueOf(request2.getParameter("p"));
				}
				int total 		 = TinTucAdminUtil.listTintuc(category_id, langcheck, 0, 0).size();
				int news_on_page = Integer.valueOf(sotinhienthi);
				float pg 		 = (float) total/news_on_page;
				int page_num 	 = (int) Math.ceil(pg);
				int start 		 = (p-1)*news_on_page;
				int end = (int) p*news_on_page;
				
				listnew_article = TinTucAdminUtil.listTintuc(category_id, langcheck, start, end);
				News_Categories new_category  = null;
				if(catid > 0){
					new_category  = News_CategoriesLocalServiceUtil.fetchNews_Categories(catid);
		
				}			
		%>
			<%
			if(Validator.isNotNull(listnew_article)){
				if(category_hide.equals("0")){
			%>
			<div class="category-breadcrump">
				<ul class="root">
					<li hidden="true" class="first-li"><a href="<%=themeDisplay.getURLHome()%>"><%=themeDisplay.getCompany().getName()%></a></li>
					<li class="last-li">
						<%
							String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
						%>
						<a href="<%=urlcat%>"><%=new_category.getName()%></a>
					</li>
				</ul>
			</div>
			<%}%>
			<article class="the-list-article">
			<section class="main-list-article">
			<div class="body-list-article">
			<%for(int b = 0;b<listnew_article.size();b++){
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(b).getId()+"&cat="+new_category.getId();
			%>
				<div class="item-list-article">
				<%if(newimg.equals("0")){ %>
					<div class="item-list-article-img">
					<%
						String url = listnew_article.get(b).getUrlimagesmall();
						if(!url.equals("")){
					%>
						<img alt="" src="<%=url%>">
					<%}else{
						if(donvisudung.equals("nguhanhson")){
							url = request.getContextPath()+"/css/images/nguhanhson.jpg";
						}else{
							url = request.getContextPath()+"/css/images/no_image.png";
						}
					%>
						<img alt="" src="<%=url%>">
					<%}%>
					</div>
				<%} %>
					<div class="item-list-article-content">
						<%
							String tieude = listnew_article.get(b).getTitle();
							if(tieude.length()>Integer.valueOf(dodaitieude)){
								tieude = tieude.substring(0, Integer.valueOf(dodaitieude)-1)+"...";
							}
						%>
						<a href="<%=urltitle%>"><span class="title-item-article"><%=tieude%></span></a>
						<span class="createdtime-item-article"><%=df.format(listnew_article.get(b).getNgayxuatban())%></span>
						<%
							String mota = listnew_article.get(b).getInfo();
							if(mota.equals("") || Validator.isNull(mota)){

							}else{
								if(mota.length()>Integer.valueOf(dodaimota)){
									mota = mota.substring(0, Integer.valueOf(dodaimota)-1)+"...";
								}
							}
						%>
						<p class="des-item-article"><%=mota%></p>
					</div>
				</div>
			<%}}%>
			<%Paging paging = new Paging();%>
				<%=paging.paging(p,5,page_num,"?idcat="+catid)%>
		<%} %>		
			</div>
			</section>
		</article>
		</body>			
			
</html>	

