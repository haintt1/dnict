<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<link href="<%=request.getContextPath()%>/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/datepicker.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskedinput.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.maskMoney.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.ui.datepicker-vi.min.js"></script>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
	.search-content {
	    width: 70%;
	    float: left;
	}
	.result-content {
	    width: 30%;
	    float: left;
	}
		.search-row {
		    clear: both;width: 96%;
		    position: relative;margin-bottom: 10px;
		}
		#search form input#s_keyword {
		    float: left;
		    width: 100%;
		    height: 26px;
		    padding: 4px 5px 4px 30px;
		    border: 1px solid #c9c9c9;
		    background: #fff;
		    line-height: 28px;
		    color: #0099cc;
		    font-family: Arial, sans-serif;
		    font-size: 18px;
		    margin-bottom: 5px;
		}
		.input-prepend {
		    width: 40%;
		    float: left;
		}
		input#ngaytao_tungay, input#ngaytao_denngay {
		    height: 20px !important;width:70%;border: 1px solid #c9c9c9;border-radius: 0;
		}
		#search form ul.options:after {
		    clear: both;
		    display: block;
		    content: "";
		}
		#search form ul.options {
		    padding: 0;
    		margin: 0;
		}
		#search form button {
		    float: left;
		    position: relative;
		    left: -1px;
		    font-family: Arial, sans-serif;
		    font-size: 11px;
		    font-weight: bold;
		    color: #ffffff;
		    text-transform: uppercase;
		    line-height: 20px;
		    margin: 0;
		    padding: 0 5px;
		    border: 1px solid #3498db;
		    cursor: pointer;
		    height: 28px;
		    width: 50%;
		    background: #3498db;
		}
		#search form ul.options {
		    clear: both;
		    display: block;
		}
		#search form .options li {
		    margin-right: 10px;
		    float: left;
		}
		#search form .options input {
		    width: auto;
		    height: auto;
		    padding: 0;
		    margin: 0 5px 0 0;
		    line-height: auto;
		}
		#search form .options label, #search form span {
		    font-size: 14px;
		    height: 14px;
		    margin: 2px 5px;
		    padding: 0;
		    line-height: 22px;
		    font-weight: normal;
		}
		form#searh-form:after, .container-article:after {
		    clear: both;
		    display: block;
		    content: "";
		}
		form#searh-form {
		    width: 100%;
		    position: relative;
		    margin-bottom: 15px;
		}
		i.icon-search {
		    position: absolute;
		    left: 7px;
		    top: 8px;
		    font-size: 20px;
		    color: #ccc;
		}
		section.content-wrap header {
		    background: #0099cc;
		    padding: 4px 5px;
		    border: 0;
		    height: 26px;
		    overflow: hidden;
		    box-sizing: border-box;
		    margin-bottom: 8px;
		}
		section.content-wrap header h3 {
		    color: #fff;
		    font-size: 12px;
		    display: block;
		    line-height: 21px;
		    margin: 0;
		    float: left;
		}
		section.content-wrap header p {
		    margin: 0 !important;
		    color: #fff;
		    float: right;
		    font-size: 12px;
		}
		.small-img-pm {
		    width: 110px;
		    height: 65px;
		    overflow: hidden;
		    float: left;
		    box-sizing: border-box;
		    margin-top: 3px;
		}
		.new-name-info-content-pm {
		    float: left;
		    width: 80%;
		    margin-left: 10px;
		    text-align: justify;
		}
		.content-item:after {
		    clear: both;
		    display: block;
		    content: "";
		}
		.content-item {
		    margin-bottom: 10px;
		}
		.new-name-info-content-pm a.title-link-new-pm {
		    font-weight: bold;
		    font-size: 16px;
		}
		#search form button:hover {
		    background: #1f6ed6;
		    border: 1px solid #1f6ed6;
		}
	</style>

<%	
	String chuyenmuc = ParamUtil.getString(request, "chuyenmuc");
	String key = user.getUserId()+"_checkLang";
	String checkLang   = prefs.getValue(key,"vi_VN");
	
	DateFormat dft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String tungay = ""; String denngay="";
	String search = "";
	String status = "0", tags = "0"; int total = 0;
	HttpServletRequest request2 = PortalUtil.getOriginalServletRequest(request);
	if(Validator.isNotNull(ParamUtil.getString(request2, "search"))){
		search = request2.getParameter("search");
		search = HtmlUtil.escape(search);
	}
	if(Validator.isNotNull(ParamUtil.getString(request2, "tags"))){
		tags = request2.getParameter("tags");
	}
	if(Validator.isNotNull(ParamUtil.getString(request2,"status"))){
		status = request2.getParameter("status");
	}
	if(Validator.isNotNull(ParamUtil.getString(request2, "ngaytao_tungay"))){
		tungay = HtmlUtil.escape(ParamUtil.getString(request2, "ngaytao_tungay"));
	}
	if(Validator.isNotNull(ParamUtil.getString(request2, "ngaytao_denngay"))){
		denngay = HtmlUtil.escape(ParamUtil.getString(request2, "ngaytao_denngay"));
	}
	
	if(Validator.isNotNull(ParamUtil.getString(request, "search"))){
		search = request.getParameter("search");
		search = HtmlUtil.escape(search);
	}
	
	if(Validator.isNotNull(ParamUtil.getString(request, "tags"))){
		tags = request.getParameter("tags");
	}
	
	if(Validator.isNotNull(ParamUtil.getString(request,"status"))){
		status = request.getParameter("status");
	}
	
	if(Validator.isNotNull(ParamUtil.getString(request, "ngaytao_tungay"))){
		tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_tungay"));
	}
	if(Validator.isNotNull(ParamUtil.getString(request, "ngaytao_denngay"))){
		denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngaytao_denngay"));
	}	
	PortletURL pagingUrl = renderResponse.createRenderURL();
	pagingUrl.setParameter("tags", tags);
	pagingUrl.setParameter("search", search);
	pagingUrl.setParameter("status", String.valueOf(status));
	pagingUrl.setParameter("ngaytao_tungay",tungay);
	pagingUrl.setParameter("ngaytao_denngay",denngay);
	pagingUrl.setParameter("chuyenmuc",chuyenmuc);

	PortletURL searchURL = renderResponse.createRenderURL();
	
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
	List<News_Article> listObj = new ArrayList<News_Article>();
	listObj = TinTucAdminUtil.searchArticle(search, status, checkLang, start, end);
	total =(int) TinTucAdminUtil.searchArticle(search, status, langcheck, 0, 0).size();
	
	searchContainer.setTotal(total);
	searchContainer.setResults(listObj);
	String timtheotags ="Tìm theo tags";
	String timkiem = "Tìm kiếm"; String timtatca = "Tìm tất cả"; String timtheotieude = "Tìm theo tiêu đề"; String timtheonoidung = "Tìm theo nội dung"; String timtheodinhdanh = "Tìm theo định danh";
	String tukhoa = "Từ khóa:"; String hienthi = "Hiển thị"; String ketqua = "Kết quả";
	if(langcheck.equals("en_US")){
		 timkiem = "Search";  timtatca = "Search all";  timtheotieude = "Search title";  timtheonoidung = "Search content"; 
		 timtheodinhdanh = "Search code";tukhoa = "Key words:";  hienthi = "Show";  ketqua = "result";
		 timtheotags = "Tags";
	}
	if(listObj.size()==0){
		search = "";
	}
%>	
	
<div class="container-article">
	<section id="search">
		<form name="search" id="searh-form" action="<%=searchURL%>" method="post">
			<div class="search-content">
				<div class="search-row">
					<i class="icon-search"></i>
					<input name="search" type="text" id="s_keyword" value="<%=search%>">
				</div>
			
				<div class="search-row">
					<div class="input-prepend">
						<span class="add-on" style="float: left;">Từ ngày</span>
						<input type="text" class="datepicker" name="ngaytao_tungay" id="ngaytao_tungay" value="<%=tungay%>"/>
					</div>
					<div class="input-prepend">
						<span class="add-on" style="float: left;">Đến ngày</span>
						<input type="text" class="datepicker" name="ngaytao_denngay" id="ngaytao_denngay" value="<%=denngay%>"/>
					</div>
				</div>
				<div class="search-row">
					<ul class="options">
						<li>
						<label>
						<input name="status" type="radio" value="0" <%=status.equals("0")?"checked":"" %>>
						<%=timtatca%></label></li>
						<li>
						<label>
						<input name="status" type="radio" value="1" <%=status.equals("1")?"checked":"" %>>
						<%=timtheotieude%></label></li>
						<li>
						<label>
						<input name="status" type="radio" value="2" <%=status.equals("2")?"checked":"" %>>
						<%=timtheonoidung%></label></li>
						<li>
						<label>
						<input name="status" type="radio" value="3" <%=status.equals("3")?"checked":"" %>>
						<%=timtheodinhdanh%></label></li>
					</ul>			
				</div>
			</div>
			<div class="result-content">
				<button type="submit"><%=timkiem%></button>
			</div>
		</form>
	</section>
	<section class="content-wrap">
		<header>
			<h3><%=tukhoa %> <b><%=search.toString()%></b></h3>
			<p><%=hienthi %> <%=total%> <%=ketqua%></p>
		</header>
		<%if(listObj.size()>0){%>
		<div class="content-list">
			<%for(int i = 0;i<listObj.size();i++){
				List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(listObj.get(i).getId());
			%>
				<div class="content-item">
					<div class="small-img-pm">
						<%
							String url = listObj.get(i).getUrlimagesmall();
							if(!url.equals("")){
						%>
							<img alt="" src="<%=url%>">
						<%}else{
							if(donvisudung.equals("nguhanhson")){
								url = request.getContextPath()+"/images/nguhanhson.jpg";
							}else{
								url = request.getContextPath()+"/images/no_image.png";
							}
						%>
							<img style="height: 65px;" alt="" src="<%=url%>">
						<%}%>
					</div>
					<div class="new-name-info-content-pm">
						<%
						News_Categories new_category1 = null;
						if(listarticle2Category.size()>0){
							new_category1 = News_CategoriesLocalServiceUtil.fetchNews_Categories(listarticle2Category.get(0).getNewcategoryId());							
						}
						String urltitle = trangchitiet+"?dinhdanh="+listObj.get(i).getId();
						String tieude = listObj.get(i).getTitle();
 						if(tieude.length()>Integer.valueOf(dodaitieude)){
							tieude = TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
						}
						String mota = listObj.get(i).getInfo();
 							if(mota.length()>Integer.valueOf(dodaimota)){
								mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1)+"...";	
							} 
						%>
						<a class="title-link-new-pm" href="<%=urltitle%>"><span class="new-name-pm"><%=tieude%></span></a>
						<p class="new-info-pm"><%=mota%></p>
						<span class="new-version-pm"><b class="title-pm">Phiên bản: </b><%=listObj.get(i).getVersion()%></span>
						<%
							String ngaytao = "";
							if(Validator.isNotNull(listObj.get(i)) && Validator.isNotNull(listObj.get(i).getCreatedtime())){
								ngaytao = df.format(listObj.get(i).getCreatedtime());
							}
						%>
						<span class="new-public-pm"><b class="title-pm">Ngày đăng tin: </b><%=ngaytao%></span>
						<span class="new-category-pm"><b class="title-pm">Chuyên mục: </b>
							<%
								for(int ab = 0;ab<listarticle2Category.size();ab++){
									News_Categories new_category = News_CategoriesLocalServiceUtil.fetchNews_Categories(listarticle2Category.get(ab).getNewcategoryId());
									String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
							%>
								<span class="category-info-pm"><a href="<%=urlcat%>"><%=new_category.getName()%></a></span>
							<%}%>
						</span>
					</div>
				</div>
			<%}%>
			
		</div>
		<div class="paginator"><liferay-ui:search-paginator searchContainer="<%=searchContainer%>"/></div>
		<%}%>
	</section>
</div>

<script>
$(document).ready(function(){
	$(".datepicker").datepicker({
		  yearRange: '-80:+10',
	});
	$(".datepicker").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
})
</script>