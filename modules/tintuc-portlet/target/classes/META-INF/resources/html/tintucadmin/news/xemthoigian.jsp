<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
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
	Date date = new Date();
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	String ngayhientai = df.format(date)+":00";
	SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
	Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
	
	String timeId = ParamUtil.getString(request, "timeId");
	News_Article listtintuc = News_ArticleLocalServiceUtil.fetchNews_Article(Long.valueOf(timeId));
%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th style="text-align: center;">Thời gian tạo</th>
			<th style="text-align: center;">Thời gian xuất bản</th>
			<th style="text-align: center;">Thời gian kết thúc</th>
			<th style="text-align: center;">Trạng thái</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<b><%=df.format(listtintuc.getCreatedtime()) %></b>
			</td>
			<td>
				<b><%=df.format(listtintuc.getNgayxuatban()) %></b>
			</td>
			<td>
				<b><%= (listtintuc.getNgayketthuc() != null) ? df.format(listtintuc.getNgayketthuc()) : "" %></b>
			</td>
			<td>
				<%
				String trangthai = "";
				if (listtintuc.getNgayxuatban() != null && ngayhientaiGMT.before(listtintuc.getNgayxuatban())) {
					trangthai = "Bài viết đang chờ xuất bản";
				}
				else if (listtintuc.getNgayketthuc() != null && ngayhientaiGMT.after(listtintuc.getNgayketthuc())) {
					trangthai = "Bài viết đã kết thúc";
				} else {
					trangthai = "Bài viết đang hoạt động";
				}
				out.print(trangthai);
				%>
			</td>
		</tr>
	</tbody>
</table>
