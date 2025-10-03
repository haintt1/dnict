<%@page import="java.util.Date"%>
<%@page import="vn.dnict.tintuc.utils.TintucGuestUtil"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.petra.string.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easy-ticker.min.js"></script>
<style type="text/css">
	.time-container-view2_dt09 {
	    width: 30%;
	    height: 80px;
	    float: left;
	}
	.right-container_dt09 {
	    float: left;
	    width: 60%;
	    margin-left: 3%;
	}
	li.danhsachtin-li_dt09:after {
	    clear: both;
	    display: block;
	    content: "";
	}
	.createdate {
	    display: block;
	}
	.title-danhsach-tin_dt09 {
		display: block;
	}
</style>

<%
String thang = "Tháng", xemthem = "Xem thêm";
if(langcheck.equals("en_US")){
	thang = "Month";
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
		//}
		
	//}
	
%>
<div class="view_tinnoibat_dt09">
<%if(category_hide.equals("0")){%>
	<div class="title_category_dt09">
		<%
		String urlcat = trangchitiet+"?danhmuc="+new_category.getId();
		%>
		<h3 class="category_name_dt09"><a href="<%=urlcat%>"><%=new_category.getName()%></a></h3>
	</div>
<%}%>
<div class="vticker">
	<ul class="danhsach-ul_dt09">
		<%for(int i =0;i<listnew_article.size();i++){
				String tieude = listnew_article.get(i).getTitle();
				if(tieude.length()>Integer.valueOf(dodaitieude)){
					tieude =  TintucGuestUtil.subStringTotal(tieude, Integer.valueOf(dodaitieude)-1)+"...";
				}
				String urltitle = trangchitiet+"?dinhdanh="+listnew_article.get(i).getId()+"&cat="+new_category.getId();
				String mota = listnew_article.get(i).getInfo();
// 				String noidung = listnew_article.get(i).getContent();
				if(mota.equals("") || Validator.isNull(mota)){
// 					noidung = noidung.replaceAll("\\<.*?>","");
// 					if(noidung.length()>Integer.valueOf(dodaimota)){
// 						mota = StringUtil.subStringTotal(noidung, Integer.valueOf(dodaimota)-1) + "...";
// 					}else {
// 						mota = noidung;
// 					}
				}else {
					if(mota.length()>Integer.valueOf(dodaimota)){
						mota = TintucGuestUtil.subStringTotal(mota, Integer.valueOf(dodaimota)-1) + "...";
					}
				}
		%>
			<li class="danhsachtin-li_dt09">
				<div class="time-container-view2_dt09">
					<%
					Date date1 =  listnew_article.get(i).getCreatedtime();
					Date date2 = new Date();
					long d1 = date1.getTime();
					long d2 = date2.getTime();
					long day = Math.abs((d2 - d1) / (1000 * 60 * 60 * 24)) + 1;
						DateFormat dfday   = new SimpleDateFormat("dd");
						DateFormat dfmonth = new SimpleDateFormat("MM");
						DateFormat dfyear  = new SimpleDateFormat("yyyy");
						String date  =dfday.format(listnew_article.get(i).getCreatedtime());
						String month =dfmonth.format(listnew_article.get(i).getCreatedtime());
						String year  =dfyear.format(listnew_article.get(i).getCreatedtime());
					%>
					<span class="createdate_dt09">
						<span class="crdate_dt09"><%=date %></span>
						<span class="crdatemonth-dt09"><b class="month-str_dt09"><%=thang%> </b><%=month%></span>
					</span>
				</div>
				<div class="right-container_dt09">
					<span class="title-danhsach-tin_dt09">
					<a href="<%=urltitle%>" title="<%=tieude%>"><%=tieude%>
					<%if(!newimg.equals("")){
						if(day<=3){%>
						<img src="<%=request.getContextPath()%>/images/icon_active/new.gif" style="margin-top: -8px; width:33px !important; height: 16px !important;"/>
					<%}}%>
					</a>					
					</span>
					<span class="mota-danhsach-tin_dt09"><a href="<%=urltitle%>"><%=mota%></a></span>
				</div>
			</li>
		<%}}%>
	</ul>
</div>
<%if(hienthixemthem.equals("on")){
	
	String urlcat2 = trangchitiet+"?danhmuc="+new_category.getId();
%>
<a class="xemthem-link" href="<%=urlcat2%>"><%=xemthem%></a>
<%}%>	
</div>
<%}}%>
<script>
var jQuerytb = jQuery.noConflict();
jQuerytb(document).ready(function(){
	jQuerytb('.vticker').easyTicker({
 		speed: 'slow',
 		interval: <%=tocdoslide%>
 	});
});
</script>	