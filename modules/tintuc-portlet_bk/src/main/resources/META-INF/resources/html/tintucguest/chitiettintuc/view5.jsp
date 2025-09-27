<%@page import="vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.Paging"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.utils.DocumentUpload"%>
<%@page import="vn.dnict.tintuc.model.News_AttachFile"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="javax.portlet.MimeResponse"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/rating.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/mobile.css" />
<!-- <script src="https://apis.google.com/js/platform.js" async defer></script> -->

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tintuc/rating.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tintuc/tintuc-main.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/fancybox/jquery.fancybox-1.3.4.pack.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/fancybox/jquery.easing-1.3.pack.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/fancybox/jquery.mousewheel-3.0.4.pack.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/text-to-speech.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/fancybox/jquery.fancybox-1.3.4.css" />

<html>

<%
		String ngaydang = "Ngày đăng tin";
		String nguoidangtin = "Người đăng tin";
		String view ="Lượt xem";
		String tinlienquan = "Chuyên mục, tin tức liên quan";
		if(langcheck.equals("en_US")){
			ngaydang = "Updated";
			nguoidangtin = "Author";
			tinlienquan = "Category";
			view = "Views";
		}
		HttpServletRequest request2 = PortalUtil.getOriginalServletRequest(request);
		String idnews = request2.getParameter("dinhdanh");
		String idcat = request2.getParameter("danhmuc");
		
		String cat_breakcrump = request2.getParameter("cat");
		//System.out.print(cat_breakcrump);
		
		//System.out.println(idnews + idcat + cat_breakcrump);
		
		if(Validator.isNotNull(idnews)){
				idnews = idnews.replaceAll("[^0-9]", "");
				long articleId = Long.valueOf(idnews);
				News_Article new_article = null;
				String title = "";
				String des = "";
				if(articleId > 0){
					new_article = News_ArticleLocalServiceUtil.fetchNews_Article(articleId);
					
					title = new_article.getTitle();
					des   = new_article.getInfo();
				}
				String currentCompleteUrl = PortalUtil.getCurrentCompleteURL(request);
				String ipAddress = PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();	
				String url = new_article.getUrlimagesmall();
				
				
				News_Categories ncat = null;
				//System.out.println(currentCompleteUrl + title + des + url);
		%>
<head>
<title>Your Website Title</title>
<!-- You can use Open Graph tags to customize link previews.
Learn more: https://developers.facebook.com/docs/sharing/webmasters -->
<%-- <meta property="og:url"           content="<%=currentCompleteUrl %>" />
<meta property="og:type"          content="website" />
<meta property="og:title"         content="<%=title.toString()%>" />
<meta property="og:description"   content="<%=des.toString()%>" />
<meta property="og:image"         content="<%=url.toString()%>" />
<meta property="og:image:width" content="640" />
<meta property="og:image:height" content="442" />
</head>	 --%>	
<head>		
			<liferay-util:html-top>
				<meta property="fb:app_id" content="184484190795" />
				<meta property="og:url"           content="<%=currentCompleteUrl %>" />
				<meta property="og:type"          content="website" />
				<meta property="og:title"         content="<%=title%>" />
				<meta property="og:description"   content="<%=des%>" />
				<meta property="og:image"         content="<%=url%>" />
				<meta property="og:image:width" content="640" />
				<meta property="og:image:height" content="442" />
			</liferay-util:html-top>
</head>				
			<style type="text/css">
				
				.the-article-footer {
				    clear: both;
				}
				.the-article:after {
				    clear: both;
				    content: "";
				    display: block;
				}
				span.the-article-changeFont {
				    display: block;
				    float: left;
				    margin-right: 10px;
				}
				.the-article-share {
				    float: left;
				    margin-right: 10px;
				}
				header.title-article {
				    font-size: 2rem;
				    line-height: 1.2em;
				}
				p.the-article-summary {
				    font-weight: bold;
				}
				.the-article-more-info {
				    padding-top: 20px;
				}
				.the-article-more-info ul {
					list-style: none !important;
				}
				ul.root {
				    margin: 0 !important;
				}
				.cat-lienquan {
				    margin: 0 !important;
				}
				.cat-lienquan li {
				    font-size: 11px;
				    display: inline-block;
				    margin-right: 5px;
				    padding: 0px 10px;
				    background: rgba(204, 204, 204, 0.3);
				    border-radius: 3px;
				    margin-top: 5px;
				}
				.chuyenmuc-lienquan {
					margin-top: 10px;
				    font-size: 13px;
				    font-weight: bold;
				    margin-bottom: 5px !important;
				    display: block;
				}
				.cat-lienquan li a {
				    color: #1b71ad;
				}
				.cat-lienquan li a:hover {
				    color: rgba(213, 3, 3, 0.6);
				}
				span.share-facebook {
				    display: block;
				    float: left;
				    margin-right: 5px;
				}
				.share-content:after {
				    clear: both;
				    display: block;
				    content: "";
				}
				
				
			</style>
<body>

	<%if(Validator.isNotNull(new_article)&&new_article.getDelete_status()==0&&new_article.getStatus()==4){ %>
		<h3>Bài viết ngừng xuất bản</h3>
	<%} else if(Validator.isNotNull(new_article)&&new_article.getDelete_status()==0){ 
		
	%>
		<%if(category_hide.equals("0")){%>
			<div class="category-breadcrump">
				<ul class="root">
					<li class="first-li"><a href="<%=themeDisplay.getURLHome()%>"><%=themeDisplay.getCompany().getName()%></a></li>
				</ul>
			</div>
		<% } %>
		<article class="the-article">
			<portlet:resourceURL var="exportPDF">
					<portlet:param name="exportPDF" value="true"/>
					<portlet:param name="articleId" value="<%=idnews%>"/>
			</portlet:resourceURL>
			<portlet:resourceURL var="ratingURL"></portlet:resourceURL>
			<section class="main-article">
			<div id="title">
				<header  class="title-article"><%=new_article.getTitle()%></header>
			</div>
				<div class="author-createtime-viewcount">
					<span class="the-article-createby"><b><%=nguoidangtin%>: </b>
					<%
						//System.out.println(currentCompleteUrl);
						User us = UserLocalServiceUtil.fetchUser(new_article.getCreatedby());
						if(Validator.isNotNull(us)){
							out.print(us.getFullName());
							
						}
					%>
					</span>
					<span class="the-article-timecreate"><b><%=ngaydang%>: </b><%=df.format(new_article.getCreatedtime())%></span>
					<span class="viewcount"><b><%=view%>: </b><%=1 + new_article.getLuotxem() %>
					
					<div class="share-content">
								<div class="fb-share-button" 
									data-href="<%=currentCompleteUrl %>" 
									data-layout="button_count" data-size="small" data-show-faces="true" data-share="true">
								</div>
<%-- 								<div class="fb-share-button" 
							    	data-href="<%=currentCompleteUrl%>" 
							    	data-type="button_count">
							  	</div> --%>
							  	<div class="zalo-share-button" data-href="<%=currentCompleteUrl %>" data-oaid="579745863508352884" data-layout="1" data-color="blue" data-customize="false"></div>
							  	<%if(textToSpeech.equals("1")){ %>
							  		<button class="btn--default" id="playbutton"><img src="<%=request.getContextPath()%>/images/icon_active/icon_loa.png"></button>
									<button class="btn--error" id="stopbutton"><img src="<%=request.getContextPath()%>/images/icon_active/icon_tatloa.png"></button>
									<select id="voiceselection" style="visibility: hidden">
										<option value="Vietnamese Male">Vietnamese Male</option>
									</select>
								<%} %>
					</div>
					<div id="fb-root"></div>
					<script type="text/javascript">
					(function(d, s, id) {
						var js, fjs = d.getElementsByTagName(s)[0];
						//alert(js, fjs);
						if (d.getElementById(id)) return;
						js = d.createElement(s); js.id = id;	
						js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v14.0";
						//js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v14.0";
						fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk'
					));
					</script>
				</div>
				<div id=tomtat>
					<p class="the-article-summary"><%=new_article.getInfo()%></p>
				</div>
				<div id="textToSpeech" >
					<div class="the-article-body grid"  style="margin-top: 0px">
						<div class="grid__col--12">
							<%
								String noidungfirst = "";
								String noidunglast = "";
								String noidungchitiet = new_article.getContent();
								String urlPdf = "";
								String noidungchitietFlipBook = "" ;
								
								
								Document doc 	= Jsoup.parse(new_article.getContent());
								//System.out.println(new_article.getLoaitintuc());
								if(new_article.getLoaitintuc() == 2 && kieuhienthipdf.equals("lattrang")){
									Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
									Element contentDivtwo = doc.select("div[class=contentlast]").first();
									if(Validator.isNotNull(contentDiv)){
										noidungfirst = contentDiv.html();								
									}
									if(Validator.isNotNull(contentDivtwo)){
										noidunglast  = contentDivtwo.html();								
									}
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(new_article.getId(), 9);
									if(listDinhkem.size() > 0){
										urlPdf = listDinhkem.get(0).getUrl();
									}
									noidungchitiet = noidungfirst;
									noidungchitiet = noidungchitiet + "<a style=\"display: block;\" class=\"xemfull-pdf\" target=\"_BLANK\" href=\"/o/vn.dnict.tintuc/js/pdf-flipbook-master/index.html?file="+urlPdf+"\">Xem file ở chế độ toàn màn hình</a>";
									noidungchitiet = noidungchitiet + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdf-flipbook-master/index.html?file="+urlPdf+"\" style=\"width:80%; height:1000px;\"></embed></p>";
									noidungchitiet = noidungchitiet + noidunglast;
								}
								
								if(new_article.getLoaitintuc() ==1 ){
									Document docfirst = Jsoup.parse(new_article.getContent());
										Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
										Element contentDivtwo = doc.select("div[class=contentlast]").first();
										if(Validator.isNotNull(contentDiv)){
											noidungfirst = contentDiv.html();								
										}
										if(Validator.isNotNull(contentDivtwo)){
											noidunglast  = contentDivtwo.html();								
										}
									
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(new_article.getId(), 9, themeDisplay);
									if(listDinhkem.size() > 0){
		 								for(News_AttachFile file: listDinhkem){
		 									noidungchitiet =  "<a href= '"+file.getUrl()+"'>"+file.getTen()+"</a>";
		 									noidungchitiet =  "<div>"+new_article.getContent()+"</div>";
										}
									}
								}
								if(new_article.getLoaitintuc() ==3 ){
									Document docfirst = Jsoup.parse(new_article.getContent());
										Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
										Element contentDivtwo = doc.select("div[class=contentlast]").first();
										if(Validator.isNotNull(contentDiv)){
											noidungfirst = contentDiv.html();								
										}
										if(Validator.isNotNull(contentDivtwo)){
											noidunglast  = contentDivtwo.html();								
										}
									
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(new_article.getId(), 9, themeDisplay);
									if(listDinhkem.size() > 0){
										urlPdf = listDinhkem.get(0).getUrl();
		 								for(News_AttachFile file: listDinhkem){
		 									noidungchitietFlipBook = noidungchitietFlipBook + "<a style=\"display: block;\" class=\"xemfull-pdf\" target=\"_BLANK\" href=\"/o/vn.dnict.tintuc/js/pdf-flipbook-master/index.html?file="+urlPdf+"\">Xem file ở chế độ toàn màn hình</a>";
		 									noidungchitietFlipBook = noidungchitietFlipBook + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdf-flipbook-master/index.html?file="+urlPdf+"\" style=\"width:100%; height:600px;\"></embed></p>";
										}
									}
								}
								Document docNoiDung 	= Jsoup.parse(noidungchitiet);
								Elements newsTable = docNoiDung.getElementsByTag("table");
								int check=0;
								for (Element headline : newsTable) {
									Document docTable 	= Jsoup.parse(headline.toString());
									Elements newsB = docTable.getElementsByTag("b");
									for(Element  item : newsB){
										if(item.toString().equals("<b> 1022 </b>")){
											check++;
										}
										if(item.toString().equals("<b> 3 881 888 </b>")){
											check++;
										}
									}
									if(check==2){
										headline.remove();
										noidungchitiet=docNoiDung.toString();
										break;
									}
									
								}
							
								if(checkChuKy.equals("1")){
									noidungchitiet +=noiDungChKy;
								}
							
							%>
							<%=noidungfirst %><br>
							<%if(new_article.getLoaitintuc() ==3){%>
								<%=noidungchitietFlipBook%><br>	
							<%}else{%>
								<%=noidungchitiet%><br>
							<%} %>
							<%=noidunglast %>							
						</div>
					</div>				
				</div>
			</section>
		</article>
		
		<portlet:actionURL var="updateviewerURL" name="updateViewer"></portlet:actionURL>
			<script src="https://sp.zalo.me/plugins/sdk.js"></script>
			<script type="text/javascript" src="<%=request.getContextPath()%>/js/all.js"></script>
			<!-- <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script> -->
			<!-- Facebook -->

			
			<script type="text/javascript">
				function changeFont(multiplier) {
					if (multiplier==0){
						jQuery('.main-article').find("span,p,div,strong").css('font-size','13px');
					}else{
				 		var font_size_ht = parseFloat(jQuery('.main-article').find("span,p,div").css('font-size'));
				 		font_size_ht = font_size_ht +  (multiplier * 2);
				 		jQuery('.main-article').find("span,p,div,strong").css('font-size',font_size_ht+'px');
					}
				};
				$('.btn--default').show();
				$('.btn--error').hide();
				$('#playbutton').click(function(){
					var noidung = document.getElementById("textToSpeech").textContent;
					var mota = document.getElementById("tomtat").textContent;
					var title = document.getElementById("title").textContent;
					//var noidungHTML = noidung.replace(/(\r?\n|\r\w)/gm, ' ');
					//var motaHTML = mota.replace(/(\r?\n|\r)/gm, ' ');
					var titleHTML = title.replace(/(\r?\n|\r)/gm, '');
					//var noidungHTML = noidung.replace(/[`~!@#$%^&*()_|+\-=?;:'",.<>\{\}\[\]\\\/]/gi, '');
					var noidungHTML = noidung.replace(/[\u0000-\u001F\u007F-\u009F]/g, " ")
					//alert(noidungHTML);
					contentHTML = titleHTML + mota + noidungHTML;
					responsiveVoice.cancel();
					responsiveVoice.speak(contentHTML,'Vietnamese Male');					  
					$('.btn--default').hide();
					$('.btn--error').show();
				});
				$('#stopbutton').click(function(){
					responsiveVoice.cancel();
					$('.btn--default').show();
					$('.btn--error').hide();
				});
				
				</script>
		<div class="the-article-footer">
			<div class="the-article-share">
				<a href="javascript:void(0)" onclick="PrintElem('.the-article','<%=new_article.getTitle()%>')">
					<img src="<%=request.getContextPath()%>/images/icon_active/print.png">
				</a>
				<a href="<%=exportPDF.toString()%>" target="_blank"><img src="<%=request.getContextPath()%>/images/icon_active/pdficon.png"></a>
						
				<span class="the-article-changeFont">
					<a href="#" onclick="changeFont(-1); return false;" title="Thu nhỏ"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTSmall.png"></a>&nbsp;
					<a href="#" onclick="changeFont(0); return false;" title="Mặc định"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTLage.png" style="width:13px;height:13px"></a>&nbsp;
					<a href="#" onclick="changeFont(1); return false;" title="Phóng to"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTLage.png"></a>
				</span>
				
				<div class="binhchon" style="float: left;width: 100%">
					<%if(!rating.equals("")){%>
						<div class="asset-ratings" style="width:100%">
							<input type="hidden" id="ipaddress" value="<%=ipAddress%>"/>
							<input type="hidden" id="newsid" value="<%= idnews %>"/>
							<div id="rating-stars" class="rating" style="margin: 10px 0px 5px !important;"></div>
							<div id ="rating-average"></div>	
						</div>	
					<%}%>
				</div>
				<a class="the-article-goback" href="javascript:history.back(-1)"><img src="<%=request.getContextPath()%>/images/icon_active/backicon.png"></a>
			</div>
		</div>
		
		<%
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(new_article.getId());
		if(listarticle2Category.size() > 0){
		%>
			<span class="chuyenmuc-lienquan"><%=tinlienquan%>:</span>
			<ul class="cat-lienquan">
				<%for(int g = 0; g< listarticle2Category.size(); g++){%>
				<li>
					<%
						News_Categories cat = null;
						News_Categories newcate = News_CategoriesLocalServiceUtil.fetchNews_Categories(listarticle2Category.get(g).getNewcategoryId());
						if(Validator.isNull(newcate)){
							newcate = cat;
						}
						String urlcat = trangchitiet+"?danhmuc="+newcate.getId();
					%>
					<a href="<%=urlcat%>"><%=newcate.getName()%></a>								
				</li>
				<%}%>
			</ul>
			
			<div class="the-article-more-info">
				<ul>
					<%
					
						if(listarticle2Category.size()>0){
							
							long[] listcategory = new long[listarticle2Category.size()];
							
							
							for(int d =0;d<listarticle2Category.size();d++){
								listcategory[d] = listarticle2Category.get(d).getNewcategoryId();
								
							}
							//Đang lỗi lấy số lượng tin hiển thị liên quan
							//String sotinlienquan1 = ParamUtil.getString(request, "sotinlienquan");
							//System.out.println("1: "+sotinlienquanhienthi);
							//System.out.println("2: "+sotinlienquan);
							List<News_Article> more_article = TinTucAdminUtil.listarticlbydate(new_article.getCreatedtime(), Integer.valueOf(sotinlienquanhienthi), listcategory);
							//System.out.print("more_article: "+more_article);
							
							if(more_article.size() > 0){
								for(int i=0;i<more_article.size();i++){
									List<News_Article2Category> cat = TinTucAdminUtil.getListArticle2CategoryByArticleId(listcategory);	
									if(i < Integer.valueOf(sotinlienquanhienthi)){
										
										String urltitle = trangchitiet+"?dinhdanh="+more_article.get(i).getId()+"&cat="+cat.get(i).getNewcategoryId();	
					%>		
										<li><a href="<%=urltitle%>" class="info-new"><%=more_article.get(i).getTitle()%></a></li>
					<%		
									}else{
										
										break;
									}
								}
							}						
						}					
					%>
				</ul>
			</div>
			<%}else if(new_article.getDelete_status()==1){%>
				<h3>Bài viết đã bị gỡ.</h3>
			
			<%}else{ %>
				<h3>Không có bài viết với định danh trên</h3>
			<%} %>
			
			
			
			
			
		
	
			
</body>
<%  }}else if(Validator.isNotNull(idcat) && Validator.isNumber(idcat) && Long.valueOf(idcat) > 0){ %>
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
		<%
			//System.out.print("danh sách theo danh muc ? danhmuc=201");
			long idCategory = Long.valueOf(idcat);
			
			int p = 1;
			if(Validator.isNotNull(request2.getParameter("p")) && Validator.isNumber(request2.getParameter("p"))){
			 	p = Integer.valueOf(request2.getParameter("p"));
			}
			List<News_Article> obj  = TintucGuestUtil.listTintuc("", "", idcat, 0, 0);
			int total = obj.size();
			int news_on_page = Integer.valueOf(sotinhienthi);
			float pg 		 = (float) total/news_on_page;
			int page_num 	 = (int) Math.ceil(pg);
			int start 		 = (p-1)*news_on_page;
			int end = (int) p*news_on_page;
			List<News_Article> listnew_article  = TintucGuestUtil.listTintuc("", "", idcat, start, end);
			//System.out.print("listnew_article: "+listnew_article);
			News_Categories new_cat = null;
			new_cat 	 = News_CategoriesLocalServiceUtil.fetchNews_Categories(idCategory);
			if(category_hide.equals("0")){
		%>
		
			<div class="category-breadcrump">
				<ul class="root">
					<li class="first-li"><a href="<%=themeDisplay.getURLHome()%>"><%=themeDisplay.getCompany().getName()%></a></li>
					<li class="last-li">
						<%
							String urlcat = trangchitiet+"?danhmuc="+new_cat.getId();
						%>
						<a href="<%=urlcat%>"><%=new_cat.getName()%></a>
					</li>
				</ul>
			</div>
		
		<%} %>
		
		<article class="the-list-article">
				<section class="main-list-article">
			<%if(Validator.isNotNull(listnew_article) && listnew_article.size() > 0){%>
			<div class="body-list-article">
			<%for(int b = 0;b<listnew_article.size();b++){
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(b).getId()+"&cat="+new_cat.getId();
			%>
				<div class="item-list-article">
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
					<div class="item-list-article-content">
						<%
							
							String tieude = listnew_article.get(b).getTitle();
							if(tieude.length()>Integer.valueOf(dodaitieude)){
								tieude =  TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
							}
						%>
						<a href="<%=urltitle%>"><span class="title-item-article"><%=tieude%></span></a>
						<span class="createdtime-item-article"><%=df.format(listnew_article.get(b).getCreatedtime())%></span>
						<%
							String mota = listnew_article.get(b).getInfo();
							
							if(mota.length()>Integer.valueOf(dodaimota)){
								mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";
							}
							
						%>
						<p class="des-item-article"><%=mota%></p>
					</div>
				</div>
			<%}%>
			<%Paging paging = new Paging();%>
				<%=paging.paging(p,5,page_num,"?danhmuc="+idcat)%>
			</div>
			<%}%>
			</section>
		</article>
		
		
		
		
	<%} %>

</html>		
		
