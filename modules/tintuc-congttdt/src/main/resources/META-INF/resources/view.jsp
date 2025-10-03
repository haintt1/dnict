<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<% if(ungdung.equals("vanbandieuhanh")) { %>
<jsp:include page="/view/vanbandieuhanh.jsp"></jsp:include>
<% } else if(ungdung.equals("tinchidaodieuhanh")) { %>
<jsp:include page="/view/tinchidaodieuhanh.jsp"></jsp:include>
<% } else if(ungdung.equals("tinhoatdonglanhdao")) { %>
<jsp:include page="/view/tinhoatdonglanhdao.jsp"></jsp:include>
<% } %>