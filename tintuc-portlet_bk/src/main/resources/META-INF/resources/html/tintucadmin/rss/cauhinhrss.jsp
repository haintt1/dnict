
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.utils.CoreUtil"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.ArrayList"%>

<%@page import="javax.portlet.PortletRequest"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<%@ page import="java.util.List"%>
<%@ page import="javax.portlet.ActionRequest"%>


<%@ include file="init.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<portlet:defineObjects />
<portlet:actionURL var="createRSSURL" name="createRSS">
	<portlet:param name="trangchitiet" value="<%=trangchitiet%>" />
</portlet:actionURL>
<portlet:renderURL var="viewRss">
	<portlet:param name="jspPage" value="/html/portlets/rss/rss.jsp" />
</portlet:renderURL>
<portlet:renderURL var="configRss">
	<portlet:param name="jspPage" value="/html/portlets/rss/configDanhmuc.jsp" />
</portlet:renderURL>
<liferay-ui:success key="success-update" message="Cập nhật RSS thành công" />
<style>
	.line_mid_670 {
   	 background: url(../docroot/images/row.gif) repeat-y 50% 0;
	}
	.list_item_rss {
	    width: 49%;float: left;
	}
	ul, li {
    list-style-type: none;
	}
	
	.list_item_rss li {
	    float: left;
	    padding: 0 0 5px;
	    margin: 0 0 5px;
	    border-bottom: 1px dotted #e2e2e3;
	    width: 100%;	   
	}
	.list_left{
		float: left;
		/* border-left: 1px dotted #e2e2e3; */
	}
	
</style>
<div class="tab-content">
	<portlet:actionURL var="cauhinhdanhmucURL" name="trangchitiet"/>
	<form action="<%=cauhinhdanhmucURL%>" method="post" name='<portlet:namespace/>fm'>
		<table class="table table-bordered">
			<tr>
				<th class="keycolor">Trang chi tiết</th>
				<td><input type="text" name="<portlet:namespace/>trangchitiet" value="<%=trangchitiet%>"></td>
			</tr>
			<tr>
				<td colspan="2">
				    <aui:button cssClass="btn-small" name="dongy" type="submit" value="Cấu hình" label=""></aui:button>
				    <a href="<%=createRSSURL.toString()%>" class="btn btn-info">Update RSS</a>
				</td>
			</tr>
		</table>
	</form>
	<div class="row-fluid span12">
		<h3 class="row-fluid header smaller lighter blue">
			<span class="span3">Danh sách tin tức:</span>
		</h3>
	</div>
	<div class="content_block">
		<div>
		<%
			if(Validator.isNotNull(multicategory)){
				int num=0;
				num=multicategory.length/2;
				for(int i=0; i<num;i++){
					News_Categories category = News_CategoriesLocalServiceUtil.fetchNews_Categories(Long.valueOf(multicategory[i]));
					String cateName = CoreUtil.getNameCoreAttachmentFinal(category.getName()) + "-rss.xml";
					String rssUrl = "#"; 
					rssUrl = PortalUtil.getPortalURL(request) + "/rss/" +  cateName;
			
		%>
		<div class="list_item_rss list_left">
            
             <ul>
           		  <li>
           		  	<a href="<%= rssUrl%>"><%=category.getName()%></a>
           		  	<a href="<%= rssUrl%>"><img alt="" src="<%=baseURL%>/images/RSS.png" width="20px" style="float:right;"></a>     		  	
           		  </li>               
             </ul>
          </div>
         <%}}else{
        	 int num=0;
 			List<News_Categories> listCate = TinTucAdminUtil.getAllCate();
 			num=listCate.size()/2;
 			for(int i=0; i<num;i++){
 				//String cateName = rssAction.removeAccent(listCate.get(i).getName().replace(" ", "_").toLowerCase().toString()) + "-rss.xml";
 				String cateName = CoreUtil.getNameCoreAttachmentFinal(listCate.get(i).getName()) + "-rss.xml";
 				String rssUrl = "#"; 
 				rssUrl = PortalUtil.getPortalURL(request) + "/rss/" +  cateName;
       	 %>
       	 	<div class="list_item_rss list_left">
            
             <ul>
           		  <li>
           		  	<a href="<%= rssUrl%>"><%=listCate.get(i).getName()%></a>
           		  	<a href="<%= rssUrl%>"><img alt="" src="<%=baseURL%>/images/RSS.png" width="20px" style="float:right;"></a>     		  	
           		  </li>               
             </ul>
          </div>
       	 
         <%
 			}}
         %>

		<%
			if(Validator.isNotNull(multicategory)){
				int num2=0;
				for(num2=multicategory.length/2; num2<multicategory.length;num2++){
					News_Categories category = News_CategoriesLocalServiceUtil.fetchNews_Categories(Long.valueOf(multicategory[num2]));
				//	String cateName = rssAction.removeAccent(category.getName().replace(" ", "_").toLowerCase().toString()) + "-rss.xml";
					String cateName = CoreUtil.getNameCoreAttachmentFinal(category.getName()) + "-rss.xml";
					String rssUrl = "#"; 
					rssUrl = PortalUtil.getPortalURL(request) + "/rss/" +  cateName;
			
		%>
          <div class="list_item_rss list_right">  
              <ul>
                  <li>
                 		<a href="<%= rssUrl%>"><%=category.getName()%></a>
           		  		<a href="<%= rssUrl%>"><img alt="" src="<%=baseURL%>/images/RSS.png" width="20px" style="float:right;"></a>   
                  </li>
              </ul>
          </div>  
         <%}}else{
        	 int num2=0;
 			List<News_Categories> listCate2 = TinTucAdminUtil.getAllCate();
 			for(num2=listCate2.size()/2; num2<listCate2.size();num2++){
 				String cateName = CoreUtil.removeAccents(listCate2.get(num2).getName().replace(" ", "_").toLowerCase().toString()) + "-rss.xml";
 				String rssUrl = "#"; 
 				rssUrl = PortalUtil.getPortalURL(request) + "/rss/" +  cateName;
        	 
       	 %>
         
         	<div class="list_item_rss list_right">  
              <ul>
                  <li>
                 		<a href="<%= rssUrl%>"><%=listCate2.get(num2).getName()%></a>
           		  		<a href="<%= rssUrl%>"><img alt="" src="<%=baseURL%>/images/RSS.png" width="20px" style="float:right;"></a> 
                  </li>
              </ul>
          </div>  
         
         <%
         }}
         %>
         
        </div>
     </div>	
	
</div>
<%-- <p><%if(multicategory.length<0){
	out.println("Chưa có dữ liệu !");
	}%></p> --%>