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
		<title>Thống kê bài viết</title>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
		<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
		<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
		<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
	</head>
	<style>
	.form-group{margin:0}
	</style>
<body>
<div class="row-fluid header smaller lighter blue">
	<h4>Thống kê bài viết theo biên tập viên</h4>			
</div>
<%
	String tabtkbaiviet = TinTucAdminField.value_tabtkbaiviet;
	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");	
	String dateBegin = "";
	String dateEnd = "";
	String status= "";
	String thang = "";	
	String nam = "";
	String date = "";
	if(Validator.isNotNull(ParamUtil.getString(request, "date")))
	{
		date = ParamUtil.getString(request, "date");
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
	List<News_role> objRole = PhanQuyenAdminUtil.listPhanquyen();
	List<News_Article> listnewtotal = TinTucAdminUtil.listTintucAdminTKDate("", "", "", status, date, 0, 0);
	
	
%>
<form  action="" method="post" id="frmthongke" name="frmthongke">
	<table class="table table-bordered">
		<tr>
			<th class="key label2">Từ ngày:</th>
			<td valign="top">
				<aui:input cssClass="datepicker" style="width:200px" type="text" name="date" id="date" label="" value="">
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
			<td class="key" valign="top" style="text-align: center;" colspan="6">
				<input type="submit" class="thongke-btn btn-primary btn inline" value="Xem thống kê"/>				
				<span class="btn-group inline">				
					<a class="btn-small btn btn-success" href="#" id="btnReportSoLuongBaiViet" >Xuất Excel</a>
				</span>
			</td>
		</tr>
	</table>
	<table class="table2 table-bordered table-list" id="resultsTable">
		
		<tr style="text-align: center;" class="noExl">
			<th class="key" style="width:35px;text-align: center;">#</th>
			<th class="key" style="width: 40%;">Người đăng tin</th>
			<th class="key" style="text-align: center;width: 20%;">Số bài viết</th>
			<th class="key" style="text-align: center; width: 20%;">Xem danh sách chi tiết</th>
		</tr>
		<%
			int stt = 0;
			if(objRole.size() >0){
			for(int i =0; i < objRole.size(); i++){
				List<User> objUser = PhanQuyenAdminUtil.getUsersByID(objRole.get(i).getUserid());
				if(objUser!=null) {					
				//Calendar cal = new Calendar.getInstance();
				//cal.setTime(nam)
				//List<News_Article> objNews = TinTucAdminUtil.listTintucAdmin("", "", "", "", "", "", "-1", String.valueOf(objRole.get(i).getUserid()), "", "", "", "", 0, 0);
				List<News_Article> objNews = ThongKeTinTucUtil.listTintucAdminDate("", String.valueOf(objRole.get(i).getUserid()), date, status, 0, 0);
				for(int s =0; s < objUser.size(); s++){
					if(!objUser.get(s).getFullName().equals("")){
						stt = stt+1;
					}
			%>
		<tr>
			<td style="text-align: center;"><%=stt %></td>
			
			<td><%=objUser.get(s).getFullName() %></td>
			
			<td style="text-align: center;"><%=objNews.size() %></td>
			<td style="text-align: center; width: 200px;">
				<portlet:renderURL  var="danhsachchitietURL">
					<portlet:param name="jspPage" value="/html/thongketintuc/baiviet/chitiet.jsp" />
					<portlet:param name="userId" value="<%=String.valueOf(objRole.get(i).getUserid()) %>" />
					<portlet:param name="dateBegin" value="<%=dateBegin%>"/>
					<portlet:param name="dateEnd" value="<%=dateEnd%>"/>
				</portlet:renderURL>
				<a class="btn btn-success" href="<%=danhsachchitietURL.toString()%>">Xem danh sách chi tiết</a>
			</td>
		</tr>
		<%}} }%>
		<tr><th style="text-align: left;" colspan="4">Tổng số bài viết: <%=listnewtotal.size() %></th></tr>
		<%}else{%>
		<tr><td colspan="4">Chưa có dữ liệu !!!</td></tr>
		<%}%>		
	</table>
</form>
</body>

<script type="text/javascript">
var $j = jQuery.noConflict();
$j(document).ready(function(){
	$j( "#<portlet:namespace />date" ).daterangepicker({
	    opens: 'left',
	    locale: {
	        format: 'DD/MM/YYYY'
	    }
	  });
	

$j("#btnReportSoLuongBaiViet").click(function(){
	$j("#resultsTable").table2excel({
		name: "ThongKebaiviet",
		filename: "ThongKebaiviet",
		fileext: ".xls",
		exclude_img: true,
		exclude_links: true,
		exclude_inputs: true
	});
});

});


</script>
</html>