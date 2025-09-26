<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.portlet.ThongKeTinTucField"%>
<%@page import="java.io.Console"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article" %>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="vn.dnict.tintuc.service.News_TypeLocalServiceUtil" %>
<%@page import="vn.dnict.tintuc.utils.ThongKeTinTucUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thống kê bài viết</title>
		<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
		<style>
	.form-group{margin:0}
	input#reload{width:85px}
	</style>
	</head>
<body>

<%
String tabtkchuyenmuc = ThongKeTinTucField.value_tabtkchuyenmuc;
SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
Calendar ca = Calendar.getInstance();
int currentYear = ca.get(Calendar.YEAR);
int total=0;
long catId = 0;
String dateBegin = "";
String dateEnd = "";
String status="-1";
String theloai = "-1"; 
if(Validator.isNotNull(ParamUtil.getString(request, "catId"))){
	if(Validator.isNumber(ParamUtil.getString(request, "catId"))){
		catId = ParamUtil.getLong(request, "catId");
	}
}
if(Validator.isNotNull(ParamUtil.getString(request, "dateBegin")))
{
	dateBegin = ParamUtil.getString(request, "dateBegin");
}
if(Validator.isNotNull(ParamUtil.getString(request, "dateEnd")))
{
	dateEnd = ParamUtil.getString(request, "dateEnd");
}
if(Validator.isNotNull(ParamUtil.getString(request, "status")))
{
	status = ParamUtil.getString(request, "status");
}
if(Validator.isNotNull(ParamUtil.getString(request, "theloaibaiviet")))
{
	theloai = ParamUtil.getString(request, "theloaibaiviet");
}
PortletURL pagingUrl = renderResponse.createRenderURL();
pagingUrl.setParameter("dateBegin", dateBegin);
pagingUrl.setParameter("dateEnd",dateEnd);
pagingUrl.setParameter("status",status);
pagingUrl.setParameter("theloai",theloai);
pagingUrl.setParameter("catId", String.valueOf(catId));
pagingUrl.setParameter("jspPage", "/html/thongketintuc/chuyenmuc/chitiet.jsp");
pagingUrl.setParameter("tabs", tabtkchuyenmuc);

PortletURL searchURL = renderResponse.createRenderURL();
searchURL.setParameter("jspPage", "/html/thongketintuc/chuyenmuc/chitiet.jsp");
searchURL.setParameter("catId",String.valueOf(catId));
pagingUrl.setParameter("tabs", tabtkchuyenmuc);
SearchContainer searchContainer = null;
int currentTransPage = ParamUtil.getInteger(request,"currentTransPage");
if (currentTransPage > 0) {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			currentTransPage, 100, pagingUrl, null, null);
} else {
	searchContainer = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, 100,
			pagingUrl, null, null);
}
int start = searchContainer.getStart();
int end = searchContainer.getEnd();

List<News_Article> listArticle = ThongKeTinTucUtil.thongKeChiTietChuyenMuc(Long.valueOf(theloai), catId ,Integer.valueOf(status) , dateBegin, dateEnd, 0, 0);
total = ThongKeTinTucUtil.thongKeChiTietChuyenMuc(Long.valueOf(theloai), catId ,Integer.valueOf(status) , dateBegin, dateEnd, 0, 0).size();
searchContainer.setTotal(total);
searchContainer.setResults(listArticle);
%>

<style>
	.form-group{margin:0}
	</style>

<h4 style="margin-top:10px">Thống kê bài viết của 1 chuyên mục</h4>
<form  action="<%=searchURL.toString()%>" method="post" id="frmthongke" name="frmthongke">
	<table class="table table-bordered">
		<tr>			
			<th class="key label2">Từ ngày:</th>
			<td valign="top">
				<aui:input cssClass="datepicker" style="width:200px" type="text" name="dateBegin" id="dateBegin" label="" value="" readonly="true">
				</aui:input>
			</td>
			<th class="key label2">Đến ngày:</th>
			<td valign="top">
				<aui:input cssClass="datepicker" style="width:200px" type="text" name="dateEnd" id="dateEnd" label="" value="" readonly="true">
				</aui:input>
			</td>	
			<th class="key label2">Trạng  thái:</th>
			<td valign="top">
				<select name="<portlet:namespace/>status" style="width:200px" class="form-control">
					<option value="-1" <%if(status.equals("") || status.equals("-1")) out.print("selected"); %>>--Chọn trạng thái--</option>
					<option value="0" <%if(status.equals("0")) out.print("selected"); %>>Lưu nháp</option>
					<option value="1" <%if(status.equals("1")) out.print("selected"); %>>Đã gửi ban biên tập</option>
					<option value="2" <%if(status.equals("2")) out.print("selected"); %>>Đợi phê duyệt</option>
					<option value="3" <%if(status.equals("3")) out.print("selected"); %>>Đã xuất bản</option>
				</select>
			</td>		
		</tr>
		<tr>
			<th class="key label2">Quý:</th>
			<td valign="top">
				<select id="quy-thongke" style="width:200px" class="form-control">
				     <option value="-1">--- Chọn Quý ---</option>
				     <%
				      for(int i = 1; i<=4; i++){
				     %>
				      <option value="<%=i%>">Quý <%=i%></option>
				     <%}%>
			    </select>
			</td>
			<th class="key label2">Năm</th>
			   <td valign="top">
			    <select id="nam-thongke" style="width:200px" class="form-control">
			     <option value="-1">--- Chọn năm ---</option>
			     <%
			      int begin = 2015;
			      for(int i = begin; i<=2100; i++){
			     %>
			      <option value="<%=i%>">Năm <%=i%></option>
			     <%}%>
			    </select>
			   </td>	
			   <th class="key label2">Thể loại:</th>
				<td valign="top">
					<select id="theloaibaiviet" name='<portlet:namespace/>theloaibaiviet' style="width:200px" class="form-control">
			     		<option value="-1">--Chọn thể loại--</option>
			     		<%
			     		List<News_Type> objType = TinTucAdminUtil.listTheLoai("", 0, 0, 0);
			     			
			     			if(objType.size()>0){
			     				for(int hh = 0; hh < objType.size(); hh++){
			     					String selected ="";
									if(objType.get(hh).getId() == Long.valueOf(theloai)){
										selected = "selected";
									}
			     		%>
			     			<option value="<%=objType.get(hh).getId()%>" <%=selected%>><%=objType.get(hh).getName()%></option>
			     		<%	}}	%>
		     	</select>
				</td>		
		</tr>
		<tr>	
			<td class="key" valign="top" style="text-align: center;" colspan="6">
				<input type="submit" class="btn-primary btn submit_style2 thongke-btn" value="Xem thống kê"/>	
				<input class=" btn-small btn btn-light" id="reload" value="Reset" />				
				<a class="btn btn-success btn-small" href="#" id="btnReportthongketheoChuyenMuc">Xuất Excel</a>
				<portlet:renderURL var="cancelURL">
					<portlet:param name="tabs" value="<%=tabtkchuyenmuc %>"/>
					<portlet:param name="jspPage" value="/html/thongketintuc/view.jsp"/>
				</portlet:renderURL>
				<a href="<%=cancelURL%>"><aui:button cssClass="btn-pm" type="cancel" value="Quay lại"/></a>	  
			</td>
		</tr>		
	</table><br>
	<table class="table table-bordered table-list" id="resultsTable">
		<tr style="text-align: center;">
			<th class="key" style="width:5%;text-align: center;">#</th>
			<th class="key" style="text-align: center; width: 55%">Bài viết</th>
			<th class="key" style="text-align: center; width: 10%">Thể loại</th>
			<th class="key" style="text-align: center; width: 10%;">Tác giả</th>
			<th class="key" style="text-align: center;">Ngày đăng tin</th>
			<th class="key" style="text-align: center; width: 10%;">Trạng thái</th>
			<th class="key" style="width:10%;">Ghi chú</th>
		</tr>		
		<%
		News_Categories objCat = News_CategoriesLocalServiceUtil.fetchNews_Categories(catId);		
		if(listArticle.size() > 0){
		%>
		<tr>
			<th colspan="6">
				<span style="text-transform: uppercase;">TỔNG CỘNG <span style="color: #cc1314"><%=total%></span> BÀI VIẾT TRONG CHUYÊN MỤC <span style="color: #cc1314"><%=objCat.getName() %></span>
			</th>
		</tr>
		<%
		int stt =1;
		for(int j = 0;j< listArticle.size();j++){%>
		<tr>
			<td style="text-align: center;"><%=stt+j%></td>
			<td><span class="title-link-new-pm"><%=listArticle.get(j).getTitle()%></span></td>
			<%
			
			News_Type objTheLoai = News_TypeLocalServiceUtil.fetchNews_Type(listArticle.get(j).getTypeid());
			
			String theloaitin = "";
			if(Validator.isNull(objTheLoai)){
				theloaitin = "";
			}else{
				theloaitin = objTheLoai.getName();
			}
			%>
			<td style="text-align: center;"><%=theloaitin%></td>
			<td style="text-align: center;"><%=listArticle.get(j).getCongtacvien()%></td>
			<td style="text-align: center;">
			<% 
			String ngaytao = "";
			if(Validator.isNotNull(listArticle.get(j).getCreatedtime()) && !listArticle.get(j).getCreatedtime().equals("")){
				ngaytao = df2.format(listArticle.get(j).getCreatedtime());
			}%>
			<%=ngaytao%></td>
			<td>
				<%
					String trangthai ="";
					if(listArticle.get(j).getStatus() == 0){
						trangthai = "Lưu nháp";
					}else if(listArticle.get(j).getStatus() == 1){
						trangthai = "Đã gửi ban biên tập";
					}else if(listArticle.get(j).getStatus() == 2){
						trangthai = "Đợi phê duyệt";
					}else if(listArticle.get(j).getStatus() == 3){
						trangthai = "Đã xuất bản";
					}
				%>
				<%=trangthai%>
			</td>
			
			<td></td>
		</tr>
		<%}%>
		<div>
<!-- 			<liferay-ui:search-paginator searchContainer="<%= searchContainer %>" />-->
		</div>
		<%}else{%>
		<tr><td colspan="5">Không có dữ liệu !!!</td></tr>
		<%}%>
	</table>  
</form>
</body>

<script>
var $j = jQuery.noConflict();

$j(document).ready(function(){
	const reloadButton = document.querySelector("input#reload");

	  reloadButton.addEventListener("click", () => {
	    // Replace the current page with the same page, but with the new JavaScript files.
	    window.location.replace(window.location.href);
	  });
	  
	$j( "#<portlet:namespace />dateBegin" ).datepicker({
		minDate: new Date(1999, 10 - 1, 25),
		dateFormat: 'dd/mm/yy',
		changeMonth: true,
		changeYear: true,
		ignoreReadonly: true,
	    allowInputToggle: true,
		onClose: function(selectedDate) {
			$j("#<portlet:namespace />dateEnd").datepicker("option", "minDate", selectedDate);
		}
	});
	$j( "#<portlet:namespace />dateEnd" ).datepicker({
		minDate: new Date(1999, 10 - 1, 25),
		dateFormat: 'dd/mm/yy',
		changeMonth: true,
		changeYear: true,
		ignoreReadonly: true,
	    allowInputToggle: true
	});	
	
	$j("#quy-thongke").on('change',function(){
		var dateBeginresult = "";
		var dateEndresult = "";
		namthongke = $j('#nam-thongke').val();
		quythongke = $j(this).val();
		var currentTime = new Date()
		var year = currentTime.getFullYear()
		if(quythongke == 1){
			if(namthongke != -1){
				dateBeginresult = "01/01/" + namthongke; 
				dateEndresult = "31/03/" + namthongke; 
			}else{
				dateBeginresult = "01/01/" + year; 
				dateEndresult = "31/03/" + year; 
			}
		}
		if(quythongke == 2){
			if(namthongke != -1){
				dateBeginresult = "01/04/" + namthongke; 
				dateEndresult = "30/06/" + namthongke; 
			}else{
				dateBeginresult = "01/04/" + year; 
				dateEndresult = "30/06/" + year; 
			}
		}
		if(quythongke == 3){
			if(namthongke != -1){
				dateBeginresult = "01/07/" + namthongke; 
				dateEndresult = "30/09/" + namthongke; 
			}else{
				dateBeginresult = "01/07/" + year; 
				dateEndresult = "30/09/" + year; 
			}
		}
		if(quythongke == 4){
			if(namthongke != -1){
				dateBeginresult = "01/10/" + namthongke; 
				dateEndresult = "31/12/" + namthongke; 
			}else{
				dateBeginresult = "01/10/" + year; 
				dateEndresult = "31/12/" + year;
			}
		}
		$j("#<portlet:namespace />dateBegin").val(dateBeginresult);
		$j("#<portlet:namespace />dateEnd").val(dateEndresult);	
	});

	$j("#nam-thongke").on('change',function(){
		var dateBeginresult = "";
		var dateEndresult = "";
		namthongke = $j(this).val();
		quythongke = $j('#quy-thongke').val();
		var currentTime = new Date()
		var year = currentTime.getFullYear()
		
		if(namthongke != -1){
			if (quythongke != -1) {
				if(quythongke == 1){
					dateBeginresult = "01/01/" + namthongke; 
					dateEndresult = "31/03/" + namthongke; 			
				}
				if(quythongke == 2){			
					dateBeginresult = "01/04/" + namthongke; 
					dateEndresult = "30/06/" + namthongke; 			
				}
				if(quythongke == 3){			
					dateBeginresult = "01/07/" + namthongke; 
					dateEndresult = "30/09/" + namthongke; 			
				}
				if(quythongke == 4){			
					dateBeginresult = "01/10/" + namthongke; 
					dateEndresult = "31/12/" + namthongke; 			
				}
			}else{
			dateBeginresult = "01/01/" + namthongke; 
			dateEndresult = "31/12/" + namthongke; 
			}
			//alert(dateBeginresult);
			
		}else{
			if (quythongke != -1) {
				if(quythongke == 1){
					dateBeginresult = "01/01/" + namthongke; 
					dateEndresult = "31/03/" + namthongke; 			
				}
				if(quythongke == 2){			
					dateBeginresult = "01/04/" + namthongke; 
					dateEndresult = "30/06/" + namthongke; 			
				}
				if(quythongke == 3){			
					dateBeginresult = "01/07/" + namthongke; 
					dateEndresult = "30/09/" + namthongke; 			
				}
				if(quythongke == 4){			
					dateBeginresult = "01/10/" + namthongke; 
					dateEndresult = "31/12/" + namthongke; 			
				}
			} else{
			dateBeginresult = "01/01/" + year; 
			dateEndresult = "31/12/" + year; 
			}
		}
		$j("#<portlet:namespace />dateBegin").val(dateBeginresult);
		$j("#<portlet:namespace />dateEnd").val(dateEndresult);	
	});

	$j("#btnReportthongketheoChuyenMuc").click(function(){
		$j("#resultsTable").table2excel({
			name: "ThongKebaivietchitietChuyenMuc",
			filename: "ThongKebaivietchitietChuyenMuc",
			fileext: ".xls",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});
	
});




	 
</script>
</html>