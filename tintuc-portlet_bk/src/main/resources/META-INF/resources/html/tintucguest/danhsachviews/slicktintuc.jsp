<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/css/tintuc/slick.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/tintuc/slick-custom.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tintuc/slick.js"></script>

<%
	String xemthem = "Xem thêm";
	if(langcheck.equals("en_US")){
		xemthem = "View all";
	}
	List<News_Article> listnew_article = null;
	String data_category = category_active.substring(0);
	long idCategory = 0;
	if(!data_category.equals("")){
		String[] listCategoryId = data_category.substring(1).split("_");
		
		if(listCategoryId.length > 0){
			idCategory = Long.valueOf(listCategoryId[0]);
			listnew_article = TinTucAdminUtil.listTintuc(listCategoryId, langcheck, 0, Integer.valueOf(sotinhienthi));
			News_Categories new_category = null;
			new_category = News_CategoriesLocalServiceUtil.fetchNews_Categories(idCategory);
			if(listnew_article.size()>0){
%>
<div class="slick-slider-container">
<%if(category_hide.equals("0")){%>
	<div class="title_category">
		<%
		String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
		%>
		<h3 class="category_name"><a href="<%=urlcat%>"><%=new_category.getName()%></a></h3>
	</div>
<%}%>
<div class="slider center slick-slider slick-container-block">
		<%for(int i =0;i<listnew_article.size();i++){
				String tieude = listnew_article.get(i).getTitle();
				if(tieude.length()>Integer.valueOf(dodaitieude)){
					tieude = TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
				}
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(i).getId()+"&cat="+new_category.getId();	
				String url2 = listnew_article.get(i).getUrlimagesmall();
				if(url2.equals("")){
					if(donvisudung.equals("nguhanhson")){
						url2 = request.getContextPath()+"/images/nguhanhson.jpg";
					}else if(donvisudung.equals("dastic")){
						url2 = request.getContextPath()+"/images/no_image_dastic.jpg";
					}else if(donvisudung.equals("psc")){
						url2 = request.getContextPath()+"/images/psc.jpg";
					}else{
						url2 = request.getContextPath()+"/images/no_image.png";
					}
				}
				
				String mota = listnew_article.get(i).getInfo();
				if(mota.equals("") || Validator.isNull(mota)){
				}else {
					if(mota.length()>Integer.valueOf(dodaimota)){
						mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";
					}
				}
		%>
		<div class="container-news">
			<div class="container-news-inner">
				<div class="img-container-view" style="background-image: url(<%=url2%>)">
					<img src="<%=url2%>" />
					<span></span>
				</div>
				<span class="title-content"><%=tieude%></span>
				<div class="info-container-view">
					<div class="info-container-inner">
						<a href="<%=urltitle%>" title="<%=tieude%>" class="info-link"><span></span></a>
						<p class="title-content"><a href="<%=urltitle%>"><%=tieude%></a></p>
						<p class="info-content"><%=mota%></p>
					</div>
				</div>
			</div>
		</div>
		<%}%>
</div>
</div>
<%}}}%>

<script>
var jQuery = jQuery.noConflict();
jQuery(document).ready(function($){
	$('.center').slick({
		  centerMode: true,
		  centerPadding: '0px',
		  slidesToShow: 1,
		  dots: true
		});
});
</script>	
