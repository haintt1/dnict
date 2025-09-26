<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//dinhdanh = request.getParameter("dinhdanh");
idarticle = prefs.getValue("idarticle",StringPool.BLANK);
//System.out.println(dinhdanh);
%>
<%
if(idarticle.equals("") || idarticle.equals("0")){
%>
<liferay-util:include page="/html/tintucguest/hienthitintuc/searchNews.jsp" servletContext="<%=this.getServletContext() %>"/>
<%}else if(!idarticle.equals("")){%>
<liferay-util:include page="/html/tintucguest/hienthitintuc/onearticle.jsp" servletContext="<%=this.getServletContext() %>"/>
<%}%>