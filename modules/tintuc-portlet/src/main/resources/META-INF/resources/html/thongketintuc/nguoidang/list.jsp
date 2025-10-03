<%@page import="vn.dnict.tintuc.portlet.ThongKeTinTucField"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroup"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dnict.tintuc.portlet.TinTucAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Thống kê bài viết</title>
		<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
	</head>
	<style>
	.form-group{margin:0}
	input#reload{width:85px}
	</style>
<body>
<div class="row-fluid header smaller lighter blue">
	<h4>Thống kê bài viết theo người đăng và thể loại</h4>			
</div>
<%
	String tabtknguoidang = ThongKeTinTucField.value_tabtknguoidang;
	SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");	
	int userId = 0;
	int total=0;
	String dateBegin = "";
	String dateEnd = "";
	String status= "";
	String thang = "";	
	String nam = "";		
	if(Validator.isNotNull(ParamUtil.getString(request, "userId"))){
		if(Validator.isNumber(ParamUtil.getString(request, "userId"))){
			userId = ParamUtil.getInteger(request, "userId");
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
	//List<News_role> objRole = PhanQuyenAdminUtil.listPhanquyen();
	PortletURL pagingUrl = renderResponse.createRenderURL();
	pagingUrl.setParameter("tabs", tabtknguoidang);
	pagingUrl.setParameter("userId", String.valueOf(userId));
	pagingUrl.setParameter("dateBegin", dateBegin);
	pagingUrl.setParameter("dateEnd",dateEnd);
	pagingUrl.setParameter("status", status);
	
	PortletURL searchURL = renderResponse.createRenderURL();
	searchURL.setParameter("tabs", tabtknguoidang);	
	
%>

<form  action="<%=searchURL.toString() %>" method="post" id="frmthongke" name="frmthongke">
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
			<td class="key" valign="top" style="text-align: center;" colspan="8">
				<input type="submit" class="thongke-btn btn-primary btn inline" value="Xem thống kê"/>	
				<input class=" btn-small btn btn-light" id="reload" value="Reset" />				
				<a class="btn-small btn btn-success" href="#" id="btnReportNguoiDang" >Xuất Excel</a>
			</td>
		</tr>
	</table>
	<aui:fieldset label="Hiển thị thống kê">
		<div id="resultsTable">
			<table id="myTable" style="width: 100%;">
			<tr>
			<thead>
				<th style="text-align: center;height: 36px; width: 190px;border-bottom: 1px solid #e5e5e5;border-top: 1px solid #e5e5e5;border-left: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;background: #f9f9f9;">Họ và tên</th>
				<%
				List<News_Type> list_newtype = TinTucAdminUtil.searchNew_type("", 0, 0, 0);
				int col = list_newtype.size()+3;
				String theloaitin = "";
				if(Validator.isNull(list_newtype)){
					theloaitin = "";
				}
				if(list_newtype.size() > 0){
				int a;
				for(a = 0; a < list_newtype.size(); a++){
			%>
				<th style="text-align: center; height: 36px; width: 110px;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;background: #f9f9f9;"><%=list_newtype.get(a).getName()%></th>
			<%}}%>
			<th style="text-align: center; height: 36px; width: 110px;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;background: #f9f9f9;border-right: 1px solid #e5e5e5;">Tổng số</th>
			</tr>
			</thead>
			<tbody>
			<%
				List<UserGroup> listuserGroup = UserGroupLocalServiceUtil.getUserGroups(-1, -1);
				if(Validator.isNull(listuserGroup)){
					listuserGroup = new ArrayList<UserGroup>();
				}
				if(listuserGroup.size() > 0){
				for(int i = 0; i < listuserGroup.size(); i++){%>
				<tr>
					<th style="text-align: left;height:30px; border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5; border-left: 1px solid #e5e5e5;padding-left:10px;" colspan="<%=col%>"><%=listuserGroup.get(i).getName()%></th>
				</tr>
					<%
						List<User> listuserByUserGroupId = UserLocalServiceUtil.getUserGroupUsers(listuserGroup.get(i).getUserGroupId());
						if(Validator.isNull(listuserByUserGroupId)){
							listuserByUserGroupId = new ArrayList<User>();
						}
					if(listuserByUserGroupId.size() > 0){
						int j;
						for(j = 0 ; j<listuserByUserGroupId.size(); j++){
					%>
					<tr>
						<td style="border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;border-left: 1px solid #e5e5e5;padding-left:10px;"><%=listuserByUserGroupId.get(j).getFullName()%></td>
						<%
							long tong = 0;
							int b;
							for(b = 0; b < list_newtype.size(); b++){
						%>
						<td style="text-align: center;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;">
							<%
								long sobai = TinTucAdminUtil.listNewByDateCreateAndType(list_newtype.get(b).getId(), listuserByUserGroupId.get(j).getUserId(), dateBegin, dateEnd, 0, 0);
								tong = tong + sobai;
							%>		
							<%=sobai%>	
						</td>
						<%}%>
						<td style="text-align: center;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;border-left: 1px solid #e5e5e5;"><%=tong%></td>
						<%}%>
					</tr>			
					<%}%>
			</tbody>
			<%}%>
			<tfoot>
	<tr>
		<td style="text-align: center;height: 30px; width: 100px;border-bottom: 1px solid #e5e5e5;border-top: 1px solid #e5e5e5;border-left: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;background: #f9f9f9;"><b>Tổng số</b></td>
		<%
			String theloaitin1 = "";
			if(Validator.isNull(list_newtype)){
				theloaitin1 = "";
			}
			long demtong = 0;
			if(list_newtype.size() > 0){
			int g;
			for(g = 0; g < list_newtype.size(); g++){
		%>
			<td style="text-align: center; height: 30px; width: 110px;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;border-right: 1px solid #e5e5e5;background: #f9f9f9;">
			<% 
			long sobai = TinTucAdminUtil.listNewByDateCreateAndType(list_newtype.get(g).getId(), 0, dateBegin, dateEnd, 0, 0);
			demtong = demtong+sobai;
			%>
			<b><%=sobai%></b>
			</td>
		<%}}%>
		<td style="text-align: center; height: 30px; width: 110px;border-top: 1px solid #e5e5e5;border-bottom: 1px solid #e5e5e5;background: #f9f9f9;border-right: 1px solid #e5e5e5;"><b><%=demtong%></b></td>
	</tr>
</tfoot>
<%}else{%>
<tr>
	<td>Chưa tạo nhóm người dùng !!!</td>
</tr>
<%}%>
			</table>
		</div>
	</aui:fieldset>
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

	$j("#btnReportNguoiDang").click(function(){
		$j("#resultsTable").table2excel({
			name: "ThongKeNguoiDang",
			filename: "ThongKeNguoiDang",
			fileext: ".xls",
			exclude_img: true,
			exclude_links: true,
			exclude_inputs: true
		});
	});

	});
	

</script>