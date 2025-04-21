<%@page import="qlanphamdb.model.AnPham_DeCuong"%>
<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<portlet:defineObjects />
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AnPham_DeCuong deCuong = (AnPham_DeCuong) row.getObject();
	String ten = AnPham_DeCuong.class.getName();
	String primKey = String.valueOf(deCuong.getPrimaryKey());
	String tabDeCuong = QlanphamAdminField.value_tabdecuong;
%>
	<portlet:actionURL name="editDeCuong" var="editDeCuongURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editDeCuongURL }"  />
    
    <portlet:actionURL name="deleteDeCuong" var="deleteDeCuongURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="<%=tabDeCuong %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteDeCuongURL}"/>