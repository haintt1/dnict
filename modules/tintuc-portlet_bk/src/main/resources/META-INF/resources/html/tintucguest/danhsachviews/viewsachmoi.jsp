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
<!-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css"/>-->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" type="text/css"/>


<style type="text/css">
		@media (max-width: 767px) {
			#featureContainer .carousel-inner .carousel-item > div {
				display: none;
			}
			#featureContainer .carousel-inner .carousel-item > div:first-child {
				display: block;
			}
		}

		#featureContainer .carousel-inner .carousel-item.active,
		#featureContainer .carousel-inner .carousel-item-next,
		#featureContainer .carousel-inner .carousel-item-prev {
			display: flex;
		}

		/* medium and up screens */
		@media (min-width: 768px) {
			
			#featureContainer .carousel-inner .carousel-item-end.active,
			#featureContainer .carousel-inner .carousel-item-next {
				transform: translateX(25%);
			}
			
			#featureContainer .carousel-inner .carousel-item-start.active, 
			#featureContainer .carousel-inner .carousel-item-prev {
				transform: translateX(-25%);
			}
			#featureContainer .card img{
				width: 90%;
				height: 40vh;
			}
			#featureContainer .carousel-item{
				justify-content: space-between;background:#fff;
			}
		}
		@media (max-width: 767px) {
			#featureContainer .card img{
				width: 100%;
				height: 75vh;
			}
		}
		#featureContainer .carousel-inner .carousel-item-end,
		#featureContainer .carousel-inner .carousel-item-start { 
		transform: translateX(0);
		}
		#featureContainer .card{
			border: 0;
		}
		#featureContainer .card{
			position: relative;
		}
		#featureContainer .card .card-img-overlays{
			position: absolute;
			bottom: 15%;
			left: 10%;
			color: #fff;
			font-weight: bolder;
		}
		#featureContainer a{
			text-decoration: none;
		}
		#featureContainer .indicator{
			border: 1px solid rgb(202, 202, 202);
			padding: 3px 6px 3px 6px;
		}
		#featureContainer .indicator:hover{
			background-color: blue;
			border: 1px solid blue;
			transition: 200ms;
		}
		#featureContainer .indicator:hover{
			color: white;
			transition: 200ms;
		}
		#featureContainer .indicator {
			color: lightgray;
		}
		#featureContainer .float-end{
			padding-top: 10px;
		}
		.indicator{position: absolute; display: flex; top: 0;  align-items: center;}
</style>
<%
	String xemthem = "Xem thêm";
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
<div class="view_newbooks_container <%=tenclass %>">
		<div class="books_slider " id="featureContainer" style="margin:0 auto">
		<%if(category_hide.equals("0")){%>
			<div class="books_category">
				<%
				String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
				%>
				<h3 class="category_name"><a href="<%=urlcat%>"><%=new_category.getName()%></a></h3>
			</div>
		<%}%>
		<div class="<%=tenclass %>">
			<div id="featureCarousel<%=tenclass %>" class="carousel slide" data-bs-ride="carousel" >								
				<div class="carousel-inner <%=tenclass %>" role="listbox">
				<%
				for(int i =0;i<listnew_article.size();i++){
					String tieude = listnew_article.get(i).getTitle();
					if(tieude.length()>Integer.valueOf(dodaitieude)){
						tieude = TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
					}
					String tomtat = listnew_article.get(i).getInfo();
					String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(i).getId()+"&cat="+new_category.getId();		
					String url2 = listnew_article.get(i).getUrlimagesmall();	
					if (Integer.valueOf(sotinlienquanhienthi) == 4) {
					if(i==0){
				%>
					<div class="carousel-item active" data-bs-interval="<%=tocdoslide %>">					
						<div class="col-md-3">
						<a href="<%=urltitle%>" class="link-book">
							<div class="card">
								<div class="card-img">
									<img src="<%=url2 %>" class="img-fluid" title="<%=tieude %>">
								</div>
								<div class="card-img-overlays">
									<span class="card-img-title"><%=tieude %></span>
									<div class="card-img-info"><%=tomtat %></div>
								</div>
							</div>
						</a>
						</div>
					</div>
					<% } else { %>
					<div class="carousel-item" data-bs-interval="<%=tocdoslide %>">
						<div class="col-md-3">
						<a href="<%=urltitle%>" class="link-book">
							<div class="card">
								<div class="card-img">
									<img src="<%=url2 %>" class="img-fluid" title="<%=tieude %>">
								</div>
								<div class="card-img-overlays">
									<span class="card-img-title"><%=tieude %></span>
									<div class="card-img-info"><%=tomtat %></div>
								</div>
							</div>
						</a>
						</div>
					</div>
					<%} } else if (Integer.valueOf(sotinlienquanhienthi) == 3){ 
						if(i==0){
					%>
					 <div class="carousel-item active" data-bs-interval="<%=tocdoslide %>">
						<div class="col-md-4">
						<a href="<%=urltitle%>" class="link-book">
							<div class="card">
								<div class="card-img">
									<img src="<%=url2 %>" class="img-fluid" title="<%=tieude %>">
								</div>
								<div class="card-img-overlays">
									<span class="card-img-title"><%=tieude %></span>
									<div class="card-img-info"><%=tomtat %></div>
								</div>
							</div>
						</a>
						</div>
					</div>
						<% } else { %>					
					<div class="carousel-item" data-bs-interval="<%=tocdoslide %>">
						<div class="col-md-4">
						<a href="<%=urltitle%>" class="link-book">
							<div class="card">
								<div class="card-img">
									<img src="<%=url2 %>" class="img-fluid" title="<%=tieude %>">
								</div>
								<div class="card-img-overlays">
									<span class="card-img-title"><%=tieude %></span>
									<div class="card-img-info"><%=tomtat %></div>
								</div>
							</div>
						</a>
						</div>
					</div>
					<% } } }%>
				</div>
				<a class="indicator" href="#featureCarousel<%=tenclass %>" role="button" data-bs-slide="prev">
					<span class="fas fa-chevron-left" aria-hidden="true"></span>
				</a>
				<a class="w-aut indicator" href="#featureCarousel<%=tenclass %>" role="button" data-bs-slide="next">
					<span class="fas fa-chevron-right" aria-hidden="true"></span>
				</a>
			</div>
			</div>
</div>
</div>
<% } } } %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.slim.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.bundle.min.js"></script>
<script>

let items<%=tenclass %> = document.querySelectorAll('#featureContainer .<%=tenclass %> .carousel .carousel-item');
items<%=tenclass %>.forEach((el) => {
  const minPerSlide = <%=sotinlienquanhienthi %>
  let next = el.nextElementSibling
  for (var i=1; i<minPerSlide; i++) {
    if (!next) {
      // wrap carousel by using first child
      next = items<%=tenclass %>[0]
    }
    let cloneChild = next.cloneNode(true)
    el.appendChild(cloneChild.children[0])
    next = next.nextElementSibling
  }
})


	</script>