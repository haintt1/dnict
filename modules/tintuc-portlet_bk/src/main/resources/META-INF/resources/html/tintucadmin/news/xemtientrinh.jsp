<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Log"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/formForAdminCMS.css" type="text/css"/>
</head>
<%
	DateFormat dformat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	long articleid = 0;
	if(Validator.isNotNull(ParamUtil.getString(request, "id"))){
		articleid = ParamUtil.getLong(request, "id");
	}
	List<News_Log> listNewLog = TinTucAdminUtil.getNewLogByArticleId(articleid);
%>
<table class="table table-bordered">
	<thead>
		
		<tr>
			<th style="text-align: center;">#</th>
			<th style="text-align: center;">Thời gian</th>
			<th style="text-align: center;">Người xử lý</th>
			<th style="text-align: center;">Người nhận</th>
			<th style="text-align: center;">Trạng thái</th>
		</tr>
	</thead>
	<tbody>
		<% for(int i =0 ; i <listNewLog.size(); i++) {
			News_Log log = listNewLog.get(i);
		%>
		<tr>
			<td rowspan="2" style="vertical-align: middle; text-align: center"><%= i+1%></td>
			<td rowspan="2" style="vertical-align: middle; text-align: center"><%=log.getNgayxuly()==null?"":dformat.format(log.getNgayxuly())%></td>
			<td><b><%
			if(log.getNguoixulyid()!=0 && Validator.isNotNull(UserLocalServiceUtil.fetchUser(log.getNguoixulyid()))){
				out.print(UserLocalServiceUtil.fetchUser(log.getNguoixulyid()).getFullName());	
			}
			%></b></td>
			<td><b><%
				if(log.getNguoinhanid()!=0 && Validator.isNotNull(UserLocalServiceUtil.fetchUser(log.getNguoinhanid()))){
					out.print(UserLocalServiceUtil.fetchUser(log.getNguoinhanid()).getFullName());	
				}else {
					if(log.getStatus()==1){
						out.print("Biên tập viên");
					}else if(log.getStatus()==2){
						out.print("Lãnh đạo");
					}else if(log.getStatus()==3){
						out.print("");
					}
				}
				%>
				</b>
			</td>
			<td>
			<%
			int status = log.getStatus();
			String trangthai = "";
			if(status==0){
				trangthai = "Bài viết mới đăng (Bản nháp)";
			}else if(status == 1){
				trangthai = "Bài viết đã gửi biên tập";
			}else if(status == 2){
				trangthai = "Bài viết đã trình phê duyệt và chờ xuất bản";
			}else if(status == 3){
				trangthai = "Bài viết đã xuất bản";
			}else if(status == 4){
				trangthai = "Bài viết ngừng xuất bản";
			}else if(status == 5){
				trangthai = "Bài viết đang chờ hiệu chỉnh bổ sung";
			}
			out.print(trangthai);
			%></td>
		</tr>
		<tr>
			<td colspan="3">Nội dung xử lý: <%=log.getNoidungxuly()%></td>
		</tr>
		<%} %>
	</tbody>

</table>
