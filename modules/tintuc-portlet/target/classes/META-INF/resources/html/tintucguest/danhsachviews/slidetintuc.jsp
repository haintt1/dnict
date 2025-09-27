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
<link
	href="<%=request.getContextPath()%>/css/tintuc/swiper-bundle.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/tintuc/swiper-bundle.min.js"></script>

<style>
.swiper-slide {
	text-align: center;
	font-size: 20px;
}

.swiper-slide img {
	display: block;
	width: 100%;
	height: 400px;
	object-fit: cover;
}

.swiper-slide a {
	text-decoration: none;
}

.swiper-pagination {
	margin-bottom: 70px;
}

.caption {
	display: block;
	margin-top: 10px;
	font-weight: bold;
	text-transform: uppercase;
}
</style>

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

<div class="swiper slidetintuc">
	<%if(category_hide.equals("0")){%>
		<div class="title_category">
			<%
			String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
			%>
			<h3 class="category_name"><a href="<%=urlcat%>"><%=new_category.getName()%></a></h3>
		</div>
	<%}%>
	<div class="swiper-wrapper">
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
		<div class="swiper-slide">
			<a href="<%=urltitle%>">
				<img src="<%=url2 %>" /> 
				<span class="caption"><%=tieude %></span>
			</a>
		</div>
		<% } %>
	</div>
	<div class="swiper-button-next"></div>
	<div class="swiper-button-prev"></div>
	<div class="swiper-pagination"></div>
</div>

<%}}} %>

<script>
    var swiper = new Swiper(".slidetintuc", {
    	slidesPerView: 1, // Hiển thị 4 tạp chí mỗi lần
      	spaceBetween: 30,
      	loop: true,
      	centeredSlides: true,
      	autoplay: {
            delay: <%=tocdoslide%>,
            disableOnInteraction: false,
        },
	    
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
      
    });
</script>
