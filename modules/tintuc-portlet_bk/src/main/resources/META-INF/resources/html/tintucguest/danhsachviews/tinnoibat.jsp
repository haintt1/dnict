<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="<%=request.getContextPath()%>/css/swiper.css" type="text/css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/css/jquery.mCustomScrollbar.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/swiper.jquery.js"></script> 
<style type="text/css">
.tinnoibat-khoahoc-congnghe:after {
    clear: both;
    display: block;
    content: "";
}
ul.tinnoibat-container li {
    list-style: none !important;
/*     position: absolute; */
    height: 300px;
    background: #fff;
    -webkit-transition:opacity 2s ease,z-index 1.6s;
	transition:opacity 2s ease, z-index 1.6s; 
}
.slider-active {
/*  	display: block !important; */
}
ul.tinnoibat-container {
    margin: 0 !important;
/*     position: relative; */
/*     height: 300px; */
}
.tinnoibat-khoahoc-congnghe {
    height: 380px;
    overflow: hidden !important;
}
.container-tnb {
    width: 60%;
    float: left;
}
ul.tinnoibat-thumb {
    margin: 0 0 0 2% ;
    float: left;
    width: 38%;
}
.tinnoibat-thumb li.item-thumb-tinnoibat img {
    width: 35%;
    float: left;
}
.des-right-thumb {
    float: left;
    width: 70%;
    margin-left: 2%;
}
.item-thumb-tinnoibat:after {
    clear: both;
    display: block;
    content: "";
}
.item-thumb-tinnoibat {
    list-style: none;
}
.tinnoibat-khcn-container:after {
    clear: both;
    display: block;
    content: "";
}
/* .item-tinnoibat { */
/*     display:  none; */
/* } */
/*test style*/
ul.tinnoibat-container li {
    position: absolute;
    opacity: 0;
    z-index: 0;
/*     left: -440px; */
}
ul.tinnoibat-container {
    position: relative;
    height: 300px;
    overflow: hidden;
}
ul.tinnoibat-container {
    position: relative;
    height: 300px;
}
ul.tinnoibat-container li.slider-active {
    left: 0 !important;
    opacity: 1;
    z-index: 1;
    -webkit-transition:opacity 2s ease,z-index 1.6s;
	transition:opacity 2s ease, z-index 1.6s;  
}
.slider-active-thumb .des-right-thumb a.des-title-thumb {
    color: #cc1314 ;
}
</style>
<div class="tinnoibat-khcn-container">
<%
	List<News_Article> listnew_article = null;
	listnew_article = TinTucAdminUtil.listTintucisNoibat(langcheck, Integer.valueOf(sotinhienthi));
	
	if(listnew_article.size()>0){
		//News_Categories new_category = null;
%>
<%if(category_hide.equals("0")){%>
	<div class="title_category">
		<h3 class="category_name"><%=tieudetintuc.equals("")?"Tin tức nổi bật":tieudetintuc%></h3>
	</div>
<%}%> 
	<div class="tinnoibat-khoahoc-congnghe">
		<div class="container-tnb">
			<ul class="tinnoibat-container">
			<%
				for(int d =0;d<listnew_article.size();d++){
				String url = listnew_article.get(d).getUrlimagesmall();
				if(url.equals("")){
					url =request.getContextPath()+"/css/images/no_image.png";
				}
				String mota = listnew_article.get(d).getInfo();
				if(mota.equals("") || Validator.isNull(mota)){
				}else {
					if(mota.length()>Integer.valueOf(dodaimota)){
						mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";
					}
				}
				String tieude = listnew_article.get(d).getTitle();
				if(tieude.length()>Integer.valueOf(dodaitieude)){
					tieude =  TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
				}
				Date date =  listnew_article.get(d).getCreatedtime();
				Date date2 = new Date();
				long d1 = date.getTime();
				long d2 = date2.getTime();
				long day = Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) + 1;
				//String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(d).getId()+"&cat="+new_category.getId();
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(d).getId();
				if(d == 0){
			%>
				<li class="item-tinnoibat slider-active cur-<%=d%>">
					<div class="bg-info">
						<img style="width:100%;" alt="" src="<%=url%>">
						<div class="des">
							<a href="<%=urltitle%>" class="des-title"><%=tieude%>
								<%if(!newimg.equals("")){
									if(day<=3){%>
									<img src="<%=request.getContextPath()%>/images/icon_active/new.gif" style="margin-top: -8px; width:33px !important; height: 16px !important;"/>
								<%}}%>							
							</a>
							<p class="des-info"><%=mota%></p>
						</div>
					</div>
				</li>
				<%}else{%>
					<li class="item-tinnoibat cur-<%=d%>">
					<div class="bg-info">
						<img style="width:100%;" alt="" src="<%=url%>">
						<div class="des">
							<a href="<%=urltitle%>" class="des-title"><%=tieude%></a>
							<p class="des-info"><%=mota%></p>
						</div>
					</div>
				</li>
			<%}}%>
			</ul>
		</div>
		<ul class="tinnoibat-thumb" style="margin-top: 0;">
			<%
			for(int d =0;d<listnew_article.size();d++){
			String url = listnew_article.get(d).getUrlimagesmall();
			if(url.equals("")){
				url =request.getContextPath()+"/css/images/no_image.png";
			}
			String mota = listnew_article.get(d).getInfo();
			if(mota.equals("") || Validator.isNull(mota)){
			}else {
				if(mota.length()>Integer.valueOf(dodaimota)){
					mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";
				}
			}
			String tieude = listnew_article.get(d).getTitle();
			if(tieude.length()>Integer.valueOf(dodaitieude)){
				tieude =  TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
			}
			Date date =  listnew_article.get(d).getCreatedtime();
			Date date2 = new Date();
			long d1 = date.getTime();
			long d2 = date2.getTime();
			long day = Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) + 1;
			//String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(d).getId()+"&cat="+new_category.getId();
			String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(d).getId();
			if(d == 0){
		%>
			<li class="item-thumb-tinnoibat slider-active-thumb" data="<%=d%>">
				<img class="left-dt" alt="" src="<%=url%>" >
				<div class="des-right-thumb">
					<a href="<%=urltitle%>" class="des-title-thumb"><%=tieude%></a>
					<span class="datecreate"><%=df.format(listnew_article.get(d).getCreatedtime())%></span>
				</div>
			</li>
		<%}else{%>
			<li class="item-thumb-tinnoibat" data="<%=d%>">
				<img class="left-dt" alt="" src="<%=url%>" >
				<div class="des-right-thumb">
					<a href="<%=urltitle%>" class="des-title-thumb"><%=tieude%></a>
					<span class="datecreate"><%=df.format(listnew_article.get(d).getCreatedtime())%></span>
				</div>
			</li>
		<%}}%>
		</ul>
	</div>
<% } %>
</div>
<script type="text/javascript">
var jQuery2 = jQuery.noConflict();
jQuery2(document).ready(function(){
	setInterval("jQuery2.fn.slidetitleRotace()",<%=tocdoslide%>);
});
jQuery2.fn.slidetitleRotace = function (){
	var curli = jQuery2("ul.tinnoibat-container li.slider-active");
	var curlileft  = jQuery2('ul.tinnoibat-thumb li.slider-active-thumb');
	var nextli 	   = curli.next();
	var nextlileft = curlileft.next();
	if(nextli.length == 0){
		nextli = jQuery2("ul.tinnoibat-container li:first-child");
	}
	if(nextlileft.length == 0){
		nextlileft = jQuery2("ul.tinnoibat-thumb li:first-child");
	}
	curli.removeClass("slider-active");
	nextli.addClass("slider-active");
	curlileft.removeClass("slider-active-thumb");
	nextlileft.addClass("slider-active-thumb");
}
jQuery2(".item-thumb-tinnoibat").hover(function(){
	$(".tinnoibat-khcn-container").children().off();
	var pastThumbActive = jQuery2('ul.tinnoibat-thumb li.slider-active-thumb');
	var pastContainerActive = jQuery2("ul.tinnoibat-container li.slider-active");
	pastThumbActive.removeClass("slider-active-thumb");
	pastContainerActive.removeClass("slider-active");
	
	jQuery2(this).addClass("slider-active-thumb");
	var index = jQuery2(this).attr("data");
	var currentContainerActive = jQuery2("ul.tinnoibat-container li.cur-"+index);
	var curThumbActive = jQuery2('ul.tinnoibat-thumb li.slider-active-thumb');
	currentContainerActive.addClass("slider-active");
});
</script>