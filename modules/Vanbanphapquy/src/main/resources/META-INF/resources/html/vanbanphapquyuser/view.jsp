<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%if(giaodien.equals("home")){%>
<liferay-util:include page="/html/vanbanphapquyuser/home.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(giaodien.equals("list")){%>
<liferay-util:include page="/html/vanbanphapquyuser/view_list.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}%>


