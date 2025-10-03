<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.portlet.ThongKeTinTucField"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vn.dnict.tintuc.utils.ThongKeTinTucUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thống kê lượt xem tin bài</title>
		
		<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
		<style>
	.form-group{margin:0}
	input#reload{width:85px}
	</style>
	</head>
	
<body>
<div class="row-fluid header smaller lighter blue">
	<h4>Thống kê lượt xem tin bài</h4>			
</div>
<%
	String tabtkluotxem = ThongKeTinTucField.value_tabtkluotxem;
	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");	
	String dateBegin = "";
	String dateEnd = "";
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
	List<News_Article> listTinTucByViewCount = TinTucAdminUtil.listTintucAdminTKLuotXem(dateBegin, dateEnd, 0, 100);	
	
%>
<form  action="" method="post" id="frmthongke" name="frmthongke">
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
		</tr>
		<tr>
			<td class="key" valign="top" style="text-align: center;" colspan="6">
				<input type="submit" class="thongke-btn btn-primary btn inline" value="Xem thống kê"/>		
				<input class=" btn-small btn btn-light" id="reload" value="Reset" />		
				<a class="btn-small btn btn-success" href="#" id="btnReportLuotXemBaiViet" >Xuất Excel</a>				
			</td>
		</tr>
	</table>
	<table class="table2 table-bordered table-list" id="resultsTable">
		
		<tr style="text-align: center;" class="noExl">
			<th class="key" style="width:10%;text-align: center;">#</th>
			<th class="key" style="text-align: center;width: 40%;">Tiêu đề bài viết</th>
			<th class="key" style="text-align: center;width: 20%;">Lượt xem</th>
		</tr>
		<%
			int stt = 1;
			if (listTinTucByViewCount.size()>0){
				for (int i = 0; i < listTinTucByViewCount.size(); i++) {
		%>
		<tr>
			<td style="text-align: center;"><%=stt + i %></td>			
			<td><%= listTinTucByViewCount.get(i).getTitle()%></td>			
			<td style="text-align: center;"><%= listTinTucByViewCount.get(i).getLuotxem() %></td>		
		</tr>
		<%}%>		
		<%}else{%>
		<tr><td colspan="4">Chưa có dữ liệu !!!</td></tr>
		<%}%>		
	</table>
</form>
</body>

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

$j("#btnReportLuotXemBaiViet").click(function(){
	$j("#resultsTable").table2excel({
		name: "ThongKeLuotXemBaiViet",
		filename: "ThongKeLuotXemBaiViet",
		fileext: ".xls",
		exclude_img: true,
		exclude_links: true,
		exclude_inputs: true
	});
});

});


</script>
</html>