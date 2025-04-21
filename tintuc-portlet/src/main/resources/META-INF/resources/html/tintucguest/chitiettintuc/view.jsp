<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="vn.dnict.tintuc.utils.SlugUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="vn.dnict.tintuc.model.News_BinhLuan"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
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
<script src="<%=request.getContextPath() %>/js/watermark/jquery.watermark.js"></script>
<script src="<%=request.getContextPath() %>/js/watermark/pdf-lib.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/fancybox/jquery.fancybox-1.3.4.css" />


<html>

<%
		String ngaydang = "Ngày đăng tin";
		String nguoidangtin = "Người đăng tin";
		String view ="Lượt xem";
		String tinlienquan = "Chuyên mục, tin tức liên quan";
		String tags = "Từ khóa";
		if(langcheck.equals("en_US")){
			ngaydang = "Updated";
			nguoidangtin = "Author";
			tinlienquan = "Category";
			tags = "Tags";
			view = "Views";
		}
		HttpServletRequest request2 = PortalUtil.getOriginalServletRequest(request);
		String idnews = request2.getParameter("dinhdanh");
		String idcat = request2.getParameter("danhmuc");
		
		String tukhoachuoi = request2.getParameter("tag");
		
		
		String cat_breakcrump = request2.getParameter("cat");
		
		if(Validator.isNotNull(idnews)){
				idnews = idnews.replaceAll("[^0-9]", "");
				long articleId = Long.valueOf(idnews);
				News_Article new_article = null;
				String title = "";
				String des = "";
				if(articleId > 0){
					new_article = News_ArticleLocalServiceUtil.fetchNews_Article(articleId);					
					title = new_article.getTitle();
				}
				String currentCompleteUrl = PortalUtil.getCurrentCompleteURL(request);
				String ipAddress = PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();	
				String url = new_article.getUrlimagesmall();				
				News_Categories ncat = null;
		%>
<head>		
<title><%=title%></title>	
			<liferay-util:html-top>
				<meta property="fb:app_id" content="184484190795" />
				<meta property="og:url"           content="<%=currentCompleteUrl %>" />
				<meta property="og:type"          content="website" />
				<meta property="og:title"         content="<%=title.toString()%>" />
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
	.chuyenmuc-lienquan a {
		font-size: 11px;
	    display: inline-block;
	    margin-right: 5px;
	    padding: 0px 10px;
	    background: rgba(204, 204, 204, 0.3);
	    border-radius: 3px;
	    margin-top: 5px;
	    color: #1b71ad;
	    text-decoration: none
	}
	
	.chuyenmuc-lienquan a:hover {
		color: rgba(213, 3, 3, 0.6);
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
	    text-decoration: none;
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
	.video-ytb {
	    width: 100%;
	    height: 100%;
	    border: none;
	    border-radius: 5px;
	    margin-bottom: 10px;
	    aspect-ratio: 16 / 9;
	}
	
	.video-upload {
	    width: 100%;
	    height: 100%;
	    border: none;
	    border-radius: 5px;
	    margin-bottom: 10px;
	}
	.video-container {
	    position: relative;
	    padding-top: 56.25%; /* 16:9 ratio (9/16 = 56.25%) */
	}

	.video-container iframe {
	    position: absolute;
	    top: 0;
	    left: 0;
	    width: 100%;
	    height: 100%;
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
				<header class="title-article"><%=HtmlUtil.unescape(new_article.getTitle())%></header>
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
					<span class="viewcount"><b><%=view%>: </b>
						<%
							long dem = 1;
							if(Validator.isNotNull(new_article.getLuotxem())){
								dem = dem + new_article.getLuotxem();
							}
							//System.out.println(new_article.getLuotxem());
						%><%=dem%></span>
	
					<!-- thêm chức năng print, share, like -->
					<div class="share-content no-print">
						<div id="fb-root"></div>
						<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v15.0"></script>
						<div class="fb-like" data-href="<%=currentCompleteUrl %>" data-width="200px" data-layout="" data-action="" data-size="" data-share="true"></div>
<!--  			 			<div class="fb-share-button" 
							data-href="<%=currentCompleteUrl %>" 
							data-layout="button_count" data-size="small" data-show-faces="true" data-share="true">
						</div>-->
					  	<div class="zalo-share-button" data-href="<%=currentCompleteUrl %>" data-oaid="579745863508352884" data-layout="1" data-color="blue" data-customize="false"></div>
				  		<span class="the-article-changeFont">
							<a href="#" onclick="changeFont(-1); return false;" title="Thu nhỏ"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTSmall.png"></a>&nbsp;
							<a href="#" onclick="changeFont(0); return false;" title="Mặc định"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTLage.png" style="width:13px;height:13px"></a>&nbsp;
							<a href="#" onclick="changeFont(1); return false;" title="Phóng to"><img border="0" src="<%=request.getContextPath()%>/images/icon_active/FontTLage.png"></a>
							<a href="javascript:void(0)" class="custom-icon" onclick="PrintElem('.the-article','<%=title.toString()%>')">
						    	<img src="<%=request.getContextPath()%>/images/icon_active/print.png">
							</a>
						</span>
					  	<%if(textToSpeech.equals("1")){ %>
					  		<button class="btn--default" id="playbutton"><img src="<%=request.getContextPath()%>/images/icon_active/icon_tatloa.png"></button>
							<button class="btn--error" id="stopbutton"><img src="<%=request.getContextPath()%>/images/icon_active/icon_loa.png"></button>
							<select id="voiceselection" style="visibility: hidden">
								<option value="Vietnamese Male">Vietnamese Male</option>
							</select>
						<%} %>
					</div>
<!--  					<div id="fb-root"></div>
					<script type="text/javascript">
					(function(d, s, id) {
						var js, fjs = d.getElementsByTagName(s)[0];
						if (d.getElementById(id)) return;
						js = d.createElement(s); js.id = id;	
						js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v14.0";
						fjs.parentNode.insertBefore(js, fjs);
						}(document, 'script', 'facebook-jssdk')
					);
					</script>-->
					<!-- thêm chức năng print, share, like -->
					
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
								String noidungchitiet = "";
								String urlPdf = "";
								String tenPdf = "";
								String urlVideo = "";
								String noidungchitietFlipBook = "" ;
								
								Document doc = Jsoup.parse(new_article.getContent());
								Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
								Element contentDivtwo = doc.select("div[class=contentlast]").first();
								if(Validator.isNotNull(contentDiv)){
									noidungfirst = contentDiv.html();								
								}
								if(Validator.isNotNull(contentDivtwo)){
									noidunglast  = contentDivtwo.html();								
								}
								// rút gọn
								if(new_article.getLoaitintuc() == 1) {
									System.out.print("tin pdf");
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(new_article.getId(), 9, themeDisplay);
									if(listDinhkem.size() > 0){
										urlPdf = listDinhkem.get(0).getUrl();
										tenPdf = listDinhkem.get(0).getTen();
										
										String urlFlipbooktest = "/flipbook?pdf="+tenPdf;
										if(kieuhienthipdf.equals("0")) {
											noidungchitiet = "<embed id=\"check_pdf_watermark\" class=\"pdf_watermark no-print\" src='"+urlPdf+"' style=\"width:100%; height:1000px;\"></embed>";
						            	} else if (kieuhienthipdf.equals("1")) {
						            		noidungchitiet = noidungchitiet + "<a style=\"display: block;text-decoration:none;margin-bottom: 10px\" class=\"xemfull-pdf\" target=\"_BLANK\" href='"+urlFlipbooktest+"'>Xem dạng lật sách ở chế độ toàn màn hình</a>";
						            	}
									}
								} else if(new_article.getLoaitintuc() == 2) {
									System.out.print("tin video");
									List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(new_article.getId(), 9, themeDisplay);
									if(listDinhkem.size() > 0){
										urlVideo = listDinhkem.get(0).getUrl();
							//			boolean isFileEntryVideo = urlVideo != null && urlVideo.contains("/documents/");
										boolean isFileEntryVideo = urlVideo != null && urlVideo.contains("iframe");
										if(isFileEntryVideo) {
											/*noidungchitiet = noidungchitiet + "<iframe class=\"video-ytb no-print\" src='"+urlVideo+"'></iframe>";*/
											noidungchitiet = "<div class=\"video-container\">"+urlVideo+"</div>";
										} else if(urlVideo != null && urlVideo.contains("/documents/")) {
											noidungchitiet = "<video class=\"video-upload no-print\" src='"+urlVideo+"' controls></video>";
										} else {
											noidungchitiet = "<video class=\"video-upload no-print\" src='"+urlVideo+"' controls></video>";
										}
									}
								}						
							%>
							<%=noidungfirst %>
							<%=noidungchitiet %>
							<%=noidunglast %>
							<%if(ctv.equals("1")){ %>
							<p class="the-article-author" style="text-align:right"><b>Tác giả: <%=new_article.getCongtacvien()%></b></p>	
							<%} %>					
						</div>
					</div>				
				</div>
			</section>
		</article>
		<%
		//check visible form binh luan
		if(binhluan.equals("1")){
			if (new_article.getIsformbinhluan() == 1) {
		%>
		<portlet:actionURL name='addComment' var="addCommentURL"></portlet:actionURL>
		<portlet:resourceURL id="captcha" var="captchaResourceURL"/>
		<div class="row formbinhluan">
		<div class="col-12 col-lg-6">
			<h3 class="titleform">Bình luận</h3>			
			<liferay-ui:success key="save-successfully" message="Gửi bình luận thành công!"/>
			<liferay-ui:error key="save-unsuccessfully" message="Đã có lỗi xảy ra!"/>
			<aui:form action="<%= addCommentURL.toString()%>" method="post" name="basicForm" id="basicForm">
				<aui:input type="hidden" name="articleId" value="<%=new_article.getId() %>"/>
				<aui:input type="text" name="hoTen" label="Nhập họ tên">
					<aui:validator name="required"></aui:validator>
				</aui:input>
	    		<aui:input type="textarea" name="noiDung" label="Nhập bình luận">
	    			<aui:validator name="required"></aui:validator>    			
	    			<aui:validator name="maxLength">500</aui:validator>
	    		</aui:input>
	    		<liferay-captcha:captcha url="<%= captchaResourceURL %>"/>
	    		<aui:input type="hidden" name="<portlet:namespace/>captchaText" value=""/>
	    		<aui:input type="hidden" name="currenturl" value="<%=currentCompleteUrl %>"/>
	    		<aui:button type="submit" id="btnGui" value="Gửi bình luận" />
			</aui:form>
			<%
			}
			// check visible list binh luan	
			if (new_article.getIsviewbinhluan() == 1) {			
			List<News_BinhLuan> objBinhLuan = TintucGuestUtil.getObjBinhLuan(new_article.getId());
			if(objBinhLuan.size() > 0) {
			%>
			<h3 class="titledanhsach">Danh sách bình luận</h3>
			<ul>
			<%
				for (int bl = 0; bl < objBinhLuan.size(); bl++) {
			%>
				<li>
					<span><%= objBinhLuan.get(bl).getHoTen() %></span>
					<p><%= objBinhLuan.get(bl).getNoiDung() %></p>
				</li>
			<% } %>
			</ul>
			<% } } %>
		</div>
		</div>
		<% } %>
		<portlet:actionURL var="updateviewerURL" name="updateViewer"></portlet:actionURL>
			<script src="https://sp.zalo.me/plugins/sdk.js"></script>
			<script type="text/javascript" src="<%=request.getContextPath()%>/js/all.js"></script>
			<!-- <script type="text/javascript" src="http://connect.facebook.net/en_US/all.js"></script> -->
			<!-- Facebook -->

			<%
				boolean isStatusValid = new_article != null && new_article.getStatus() == 3;
		    	if(isStatusValid) {
			%>
			<script>
				jQuery(document).ready(function($){			
					var viewer = function(id){					 
							$.ajax({
								type: 'POST',
								url: '<%=updateviewerURL.toString() %>',
								data : {<%=renderResponse.getNamespace()%>id: id},
								success: function(data){
									
								}
							});		
					}
						 viewer(<%=articleId%>);
						 
				});
			</script>
			<% } %>
			<script type="text/javascript">
				function changeFont(multiplier) {
					if (multiplier==0){
						jQuery('.main-article').find("span,p,div,strong").css('font-size','16px');
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
				
		<!-- Thêm từ khóa -->
		<% if (tukhoa.equals("1")) { 
			String tuKhoaString = new_article.getTukhoa();
			if(Validator.isNotNull(tuKhoaString)) {
				String[] tuKhoaArray = tuKhoaString.split(",");
		%>
		<span class="chuyenmuc-lienquan"><%=tags%>:
		<%
			for(int tk = 0; tk < tuKhoaArray.length; tk++) {
				String tag = tuKhoaArray[tk].trim();
				String urltk = trangchitiet+"?tag="+SlugUtil.convertToSlug(tag)+"-"+SlugUtil.encode(tag);
		%>
			<a href="<%=urltk%>"><%=tag %></a>
		<% }}} %>
		</span>
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
		
		
		
		
	<%} else if(Validator.isNotNull(tukhoachuoi)) { %>
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
		
		int p = 1;
		if(Validator.isNotNull(request2.getParameter("p")) && Validator.isNumber(request2.getParameter("p"))){
		 	p = Integer.valueOf(request2.getParameter("p"));
		}
		
		if(tukhoachuoi != null && !tukhoachuoi.isEmpty()) {
			int lastDashIndex = tukhoachuoi.lastIndexOf("-");
			String tukhoaencode = tukhoachuoi.substring(lastDashIndex + 1);
			String tukhoadencode = SlugUtil.decode(tukhoaencode);
			
			DynamicQuery articleQuery = News_ArticleLocalServiceUtil.dynamicQuery();
			articleQuery.add(RestrictionsFactoryUtil.like("tukhoa", "%" + tukhoadencode + "%"));
			List<News_Article> listnew_article  = News_ArticleLocalServiceUtil.dynamicQuery(articleQuery);
			int total = listnew_article.size();
			int news_on_page = Integer.valueOf(sotinhienthi);
			float pg 		 = (float) total/news_on_page;
			int page_num 	 = (int) Math.ceil(pg);
			int start 		 = (p-1)*news_on_page;
			int end = (int) p*news_on_page;
			
		%>
		<h2><%=tukhoadencode %></h2>
		<article class="the-list-article">
				<section class="main-list-article">
			<%if(Validator.isNotNull(listnew_article) && listnew_article.size() > 0){%>
			<div class="body-list-article">
			<%for(int b = 0;b<listnew_article.size();b++){
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(b).getId();
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
	<% }}%>
</html>
<script>
$('.the-article-body img').addClass('img_watermark');
if(<%=banquyen.equals("1")%>) {
	const repeatText = Array(10).fill('<%=linkbanquyen%>').join(' ');
	$(document).ready(function(){
		$('.img_watermark').watermark({
	        text: repeatText,
	        textSize: 20,
	        textColor: 'white',
	        textBg: 'black',
	        textWidth: 1000,
	        gravity: 's',
	        opacity: 0.3,
	        margin: 20
	    });
		loadPdfWatermark();
	});
	
	async function loadPdfWatermark() {
		const pdfUrl = $('.pdf_watermark').attr('src');
	 	// Tải file PDF từ URL
		const existingPdfBytes = await fetch(pdfUrl).then(res => res.arrayBuffer());
		// Tải PDF bằng PDF-Lib
		const { PDFDocument, rgb } = PDFLib;
		const pdfDoc = await PDFDocument.load(existingPdfBytes);
		// Lấy tất cả các trang
		const pages = pdfDoc.getPages();
		
		const watermarkText = '<%=linkbanquyen%>';
		pages.forEach(page => {
			const { width, height } = page.getSize();
			page.drawText(watermarkText, {
				x: width / 4,
				y: height / 2,
				size: 50,
				color: rgb(0.75, 0.75, 0.75),
				opacity: 0.3,
			});
		});
		// Lưu file PDF đã chỉnh sửa
		const pdfBytes = await pdfDoc.save();
		
		// Tạo URL Blob từ PDF đã chỉnh sửa
		const blob = new Blob([pdfBytes], { type: 'application/pdf' });
		const url = URL.createObjectURL(blob);
		$('.pdf_watermark').attr('src', url);
	}

}
</script>
<script>
	function PrintElem(elem,title)
	{
		// Lấy nội dung HTML của phần tử
	    var content = jQuery(elem).clone(); // Clone để không thay đổi nội dung gốc

	    // Loại bỏ các phần tử không cần in (dùng jQuery)
	    content.find('.no-print').remove();

	    // Gửi nội dung đã chỉnh sửa đến hàm Popup
	    Popup(content.html(), title);
	}
	function Popup(data,title) 
	{
	    var mywindow = window.open('',title, 'height=400,width=600');
	    mywindow.document.write('<html><head><title>'+title+'</title>');
	    mywindow.document.write('</head><body >');
	    mywindow.document.write(data);
	    mywindow.document.write('</body></html>');
	    
	 	// Đợi cửa sổ mới tải nội dung
        mywindow.document.close();

        // Kiểm tra hình ảnh và đảm bảo tất cả được tải xong
        const images = mywindow.document.images;
        let totalImages = images.length;
        let loadedImages = 0;

        if (totalImages === 0) {
            // Không có hình ảnh, in ngay lập tức
            mywindow.print();
            mywindow.close();
        } else {
            // Chờ tất cả hình ảnh tải xong
            for (let i = 0; i < totalImages; i++) {
                images[i].onload = images[i].onerror = function () {
                    loadedImages++;
                    if (loadedImages === totalImages) {
                    	mywindow.print();
                    	mywindow.close();
                    }
                };
            }
        }
	    return true;
	}
</script>




		
