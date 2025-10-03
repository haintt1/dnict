<%@page import="java.util.ArrayList"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.portlet.ThongKeTinTucField"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="vn.dnict.tintuc.utils.ThongKeTinTucUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.portlet.ThongKeTinTucPortlet"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thống kê bài viết theo chuyên mục</title>
		<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
	</head>
	<style>
	.form-group{margin:0}
	input#reload{width:85px}
	</style>
<body>
<div class="row-fluid header smaller lighter blue">
	<h4>Thống kê bài viết theo chuyên mục</h4>			
</div>
<%
	String tabtkchuyenmuc = ThongKeTinTucField.value_tabtkchuyenmuc;
	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");	
	String dateBegin = "";
	String dateEnd = "";
	String status= "";
	String thang = "";	
	String nam = "";		
	
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
	PortletURL pagingUrl = renderResponse.createRenderURL();
	pagingUrl.setParameter("tabs", tabtkchuyenmuc);
	pagingUrl.setParameter("dateBegin", dateBegin);
	pagingUrl.setParameter("dateEnd",dateEnd);
	pagingUrl.setParameter("status", status);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("tabs", tabtkchuyenmuc);
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
	List<News_Categories> objCat = TinTucAdminUtil.getAllCate(); 
	List<HashMap<String, String>> listArticle = ThongKeTinTucUtil.thongKeTheoChuyenMuc(dateBegin, dateEnd, status, start, end);
	
%>
<form  action="" method="post" id="frmthongke" name="frmthongke">
	<table class="table table-bordered">
		<tr>
			<th class="key label2">Từ ngày:</th>
			<td valign="top">
				<aui:input cssClass="datepicker" style="width:200px" type="text" name="dateBegin" id="dateBegin" label="" value="">
				</aui:input>
			</td>
			<th class="key label2">Đến ngày:</th>
			<td valign="top">
				<aui:input cssClass="datepicker" style="width:200px" type="text" name="dateEnd" id="dateEnd" label="" value="">
				</aui:input>
			</td>
			<th class="key label2">Trạng thái:</th>
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
			   <td></td>		
		</tr>
		<tr>
			<td class="key" valign="top" style="text-align: center;" colspan="6">
				<input type="submit" class="thongke-btn btn-primary btn inline" value="Xem thống kê"/>	
				<input class=" btn-small btn btn-light" id="reload" value="Reset" />				
				<a class="btn-small btn btn-success" href="#" id="btnReportSLChuyenMuc" >Xuất Excel</a>
			</td>
		</tr>
	</table>
	
	<table class="table table-bordered table-list" id="resultsTable">
		<tr style="text-align: center;">
			<th class="key" style="width:35px;text-align: center;">#</th>
			<th class="key" style="width:50%">Chuyên mục</th>
			<th class="key" style="text-align: center;width: 20%;">Số bài viết</th>
			<th class="key" style="text-align: center; width:20%;">Xem danh sách chi tiết</th>
		</tr>
		<%
		long libid = 0;
		int stt = 0;
		int demcat = 0;
		if(listArticle.size()>0){
			for(int i=0;i<listArticle.size();i++){
				for (Map.Entry<String, String> entry: listArticle.get(i).entrySet()) {
					stt=stt+1;
		%>
		<tr>
			<td style="text-align: center;"><%=stt%></td>
			<td>
			<%
				News_Categories listCat = News_CategoriesLocalServiceUtil.fetchNews_Categories(Long.valueOf(entry.getKey()));	
			%>
			<%=listCat.getName() %>
			</td>
			<td style="text-align: center;">
			<%=entry.getValue() %>
			</td>
			<td style="text-align: center; width: 250px;">
				<portlet:renderURL var="danhsachchitietURL">
					<portlet:param name="jspPage" value="/html/thongketintuc/chuyenmuc/chitiet.jsp" />
					<portlet:param name="catId" value="<%=entry.getKey()%>" />
					<portlet:param name="dateBegin" value="<%=dateBegin%>"/>
					<portlet:param name="dateEnd" value="<%=dateEnd%>"/>
				</portlet:renderURL>
				<a class="btn btn-success" href="<%=danhsachchitietURL.toString()%>">Xem danh sách chi tiết</a>
			</td>
			<%}} %>
		</tr>
		<tr><th style="text-align: left;" colspan="4">Tổng số chuyên mục: <%=listArticle.size()%></th></tr>
		<%}else{%>
		<tr><td colspan="4">Chưa có dữ liệu !!!</td></tr>
		<%} %>	
	</table>
</form>
	<script type="text/javascript">
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

	$j("#btnReportSLChuyenMuc").click(function(){
		$j("#resultsTable").table2excel({
			name: "ThongKeSLChuyenmuc",
			filename: "ThongKeSLChuyenmuc",
			fileext: ".xls",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});

	});
	

</script>
</body>
</html>