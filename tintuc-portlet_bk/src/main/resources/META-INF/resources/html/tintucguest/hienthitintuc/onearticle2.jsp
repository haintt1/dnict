<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.utils.DocumentUpload"%>
<%@page import="vn.dnict.tintuc.model.News_AttachFile"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/rating.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tintuc/rating.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/tintuc/tintuc-main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/text-to-speech.js"></script>
<html>
<%

String ngaydang = "Updated";
String nguoidangtin = "Author";
String tinlienquan = "Category";
String view = "Views";
if(LanguageUtil.getLanguageId(request).equals("vi_VN")){
	ngaydang = "Ngày đăng tin";
	nguoidangtin = "Người đăng tin";
	view ="Lượt xem";
	tinlienquan = "Chuyên mục, tin tức liên quan";
}

String idnews = request.getParameter("idarticle");
if(Validator.isNotNull(idnews)){
		long articleId = Long.valueOf(idnews);
		News_Article news_article = null;
		String title = "";
		String des = "";
		if(articleId > 0){
			news_article = News_ArticleLocalServiceUtil.fetchNews_Article(articleId);
			title = news_article.getTitle();
			des   = news_article.getInfo();
		}
		String currentCompleteUrl = PortalUtil.getCurrentCompleteURL(request);
		
// 		New_smallimage image = TintucadminUtils.getNewsmallimageByArticleId(articleId); 
// 		String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
// 				image.getFolderId() +  "/" +image.getName();
		String ipAddress = PortalUtil.getHttpServletRequest(renderRequest).getRemoteAddr();	
		String url = news_article.getUrlimagesmall();
		News_Categories ncat = null;
		%>
			<meta property="og:url"           content="<%=currentCompleteUrl%>" />
			<meta property="og:type"          content="website" />
			<meta property="og:title"         content="<%=title%>" />
			<meta property="og:description"   content="<%=des%>" />
			<meta property="og:image"         content="<%=url%>" />
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
			</style>
	<%if(Validator.isNotNull(news_article)){%>
			<article class="the-article">
				<portlet:resourceURL var="exportPDF">
					<portlet:param name="exportPDF" value="true"/>
					<portlet:param name="articleId" value="<%=idnews%>"/>
				</portlet:resourceURL>
				<portlet:resourceURL var="ratingURL"></portlet:resourceURL>
				<section class="main-article">
					<header class="title-article"><%=news_article.getTitle()%></header>
					<div class="author-createtime-viewcount">
						<span class="the-article-createby"><b><%=nguoidangtin%>: </b>
						<%
							User us = UserLocalServiceUtil.fetchUser(news_article.getCreatedby());
						%>
						<%=us.getFullName()%>
						</span>
						<span class="the-article-timecreate"><b><%=ngaydang%>: </b><%=df.format(news_article.getCreatedtime())%></span>
						<span class="viewcount"><b><%=view%>: </b>
						<%
							long dem = 1;
							if(Validator.isNotNull(news_article.getLuotxem())){
								dem = dem + news_article.getLuotxem();
							}
						%><%=dem%></span>
						<div class="text-to-speech">
							<%if(textToSpeech.equals("1")){ %>
							<button class="btn--default" id="playbutton"><img src="<%=request.getContextPath()%>/icon/icon_active/icon_loa.png"></button>
							<button class="btn--error" id="stopbutton"><img src="<%=request.getContextPath()%>/icon/icon_active/icon_tatloa.png"></button>
							<%} %>
							<select id="voiceselection" style="visibility: hidden">
								<option value="Vietnamese Male">Vietnamese Male</option>
							</select>
						</div>
					</div>
					<p class="the-article-summary"><%=news_article.getInfo()%></p>
					
					<div class="the-article-body" id="textToSpeech">
					<%
					String noidungfirst = "", noidunglast = "", noidungchitiet = news_article.getContent(), urlPdf = "", noidungchitietFlipBook = "" ;
					Document doc 	= Jsoup.parse(news_article.getContent());
					if(news_article.getLoaitintuc() ==3 ){
						Document docfirst = Jsoup.parse(news_article.getContent());
						Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
						Element contentDivtwo = doc.select("div[class=contentlast]").first();
						if(Validator.isNotNull(contentDiv)){
							noidungfirst = contentDiv.html();								
						}
						if(Validator.isNotNull(contentDivtwo)){
							noidunglast  = contentDivtwo.html();								
						}
					
					List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(news_article.getId(), 9, themeDisplay);
					if(listDinhkem.size() > 0){
						urlPdf = listDinhkem.get(0).getUrl();
							for(News_AttachFile file: listDinhkem){
								noidungchitietFlipBook = noidungchitietFlipBook + "<a style=\"display: block;\" class=\"xemfull-pdf\" target=\"_BLANK\" href=\"/TinTuc-portlet/js/pdf-flipbook-master/index.html?file="+urlPdf+"\">Xem file ở chế độ toàn màn hình</a>";
								noidungchitietFlipBook = noidungchitietFlipBook + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/TinTuc-portlet/js/pdf-flipbook-master/index.html?file="+urlPdf+"\" style=\"width:100%; height:600px;\"></embed></p>";
						}
					}
					}%>
					<%if(news_article.getLoaitintuc() ==3){%>
					<%=noidungchitietFlipBook%><br>	
					<%}else{%>
					<%=news_article.getContent()%><br>
					<%} %>
					</div>
					<script>
						$('.btn--default').show();
					 	$('.btn--error').hide();
						playbutton.onclick = function() {
							var contentHTML = document.getElementById('textToSpeech').textContent;
							  responsiveVoice.cancel();
							  responsiveVoice.speak(contentHTML, document.getElementById('voiceselection').value);
							  $('.btn--default').hide();
							  $('.btn--error').show();
							};
							stopbutton.onclick = function() {
							  responsiveVoice.cancel();
							  $('.btn--default').show();
							  $('.btn--error').hide();
							};
					</script>
					
					<div class="the-article-footer">
						<div class="the-article-share">
<%-- 							<a href="javascript:PrintElem('.the-article','<%=new_article.getTitle()%>')"> --%>
<%-- 								<img src="<%=request.getContextPath()%>/icon/icon_active/print.png"> --%>
<!-- 							</a> -->
							<a href="javascript:void(0)" onclick="PrintElem('.the-article','<%=news_article.getTitle()%>')">
								<img src="<%=request.getContextPath()%>/icon/icon_active/print.png">
							</a>
							
							<a href="<%=exportPDF.toString()%>" target="_blank"><img src="<%=request.getContextPath()%>/icon/icon_active/pdficon.png"></a>
						</div>
						<span class="the-article-changeFont">
						
							<a href="#" onclick="changeFont(-1); return false;" title="Thu nhỏ"><img border="0" src="<%=request.getContextPath()%>/icon/icon_active/FontTSmall.png"></a>&nbsp;
							<a href="#" onclick="changeFont(0); return false;" title="Mặc định"><img border="0" src="<%=request.getContextPath()%>/icon/icon_active/FontTLage.png" style="width:13px;height:13px"></a>&nbsp;
							<a href="#" onclick="changeFont(1); return false;" title="Phóng to"><img border="0" src="<%=request.getContextPath()%>/icon/icon_active/FontTLage.png"></a>
						</span>
						<div class="binhchon" style="float: left;width: 100%">
							<%if(!rating.equals("")){%>
							<div class="asset-ratings" style="width:100%">
								<input type="hidden" id="ipaddress" value="<%=ipAddress%>"/>
								<input type="hidden" id="newsid" value="<%= idnews %>"/>
								<div id="rating-stars" class="rating" style="margin: 15px 0 5px;"></div>
								<div id ="rating-average"></div>	
							</div>	
							<%}%>
						</div>
						<a class="the-article-goback" href="javascript:history.back(-1)"><img src="<%=request.getContextPath()%>/icon/icon_active/backicon.png"></a>
					</div>
					<%
						List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(news_article.getId());
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
				
					<%}%>
					<div class="the-article-more-info">
						<ul>
							<%
								if(listarticle2Category.size()>0){
									long[] listcategory = new long[listarticle2Category.size()];
									for(int d =0;d<listarticle2Category.size();d++){
										listcategory[d] = listarticle2Category.get(d).getNewcategoryId();
									}
								List<News_Article> more_article = TinTucAdminUtil.listarticlbydate(news_article.getCreatedtime(), Integer.valueOf(sotinlienquan), listcategory);
								if(more_article.size() > 0){
								for(int i=0;i<more_article.size();i++){
									if(i< Integer.valueOf(sotinlienquan)){
									String urltitle = trangchitiet+"?dinhdanh="+more_article.get(i).getId()+"&cat="+ncat.getId();
							%>
								<li><a href="<%=urltitle%>" class="info-new"><%=more_article.get(i).getTitle()%></a></li>
							<%}else{
								break;
							}}}}%>
						</ul>
					</div>
				</section>
			</article>
			<div id="fb-root"></div>
			<portlet:actionURL var="updateviewerURL" name="updateViewer"></portlet:actionURL>
			<script>
			(function(d, s, id) {
			  var js, fjs = d.getElementsByTagName(s)[0];
			  if (d.getElementById(id)) return;
			  js = d.createElement(s); js.id = id;
			  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.7";
			  fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
			 jQuery(document).ready(function($){
					var myip = $("#ipaddress").val();
					$.ajax({
						url: '<%=ratingURL%>&<portlet:namespace/>type=1&<portlet:namespace/>newsid=<%=idnews%>&<portlet:namespace/>ipaddress='+myip,   
						cache: true,             
						type: "GET",
						dataType: "json",
						success: function(data)
						{	
							var html = "";
							if(data.average=="0"){
								html = "Chưa có bình chọn nào";
							}else{
								html = "Trung bình "+data.average+"/5 sao. Tổng số lượt bình chọn: "+data.ipaddress;
							}
							if(data.rating=="0"){
								$('#rating-stars').rating('<%=ratingURL%>&<portlet:namespace/>type=2&<portlet:namespace/>newsid=<%=idnews%>&<portlet:namespace/>ipaddress='+myip, {maxvalue:5},'<portlet:namespace/>');
							}else{
								$('#rating-stars').rating('<%=ratingURL%>&<portlet:namespace/>type=2&<portlet:namespace/>newsid=<%=idnews%>&<portlet:namespace/>ipaddress='+myip, {maxvalue:5, curvalue:data.rating},'<portlet:namespace/>');
							}
							$("#rating-average").html(html);
						},
						error: function(data)
						{
							console.log("Can not get data now!");
						}
					});
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
			 function changeFont(multiplier) {
				if (multiplier==0){
					jQuery('.main-article').find("span,p,div,strong").css('font-size','13px');
				}else{
			 		var font_size_ht = parseFloat(jQuery('.main-article').find("span,p,div").css('font-size'));
			 		font_size_ht = font_size_ht +  (multiplier * 2);
			 		jQuery('.main-article').find("span,p,div,strong").css('font-size',font_size_ht+'px');
				}
			}
			 function PrintElem(elem,title)
			 {
			     Popup(jQuery(elem).html(),title);
			 }

			 function Popup(data,title) 
			 {
			     var mywindow = window.open('',title, 'height=400,width=600');
			     mywindow.document.write('<html><head><title>'+title+'</title>');
			     mywindow.document.write('</head><body >');
			     mywindow.document.write(data);
			     mywindow.document.write('</body></html>');
			     mywindow.print();
			     mywindow.close();
			     return true;
			 }
			</script>
		<%}else{
			String khongcobaiviet = "Non article !!!";
			if(LanguageUtil.getLanguageId(request).equals("vi_VN")){
				khongcobaiviet = "Không có bài viết tương ứng ...";
			}
		%>
		<h3><%=khongcobaiviet%></h3>
		<%}%>
<%}else{%>
	<div class="info-error-pm">
		<h3>Không có dữ liệu ...</h3>
	</div>
<%}%>
