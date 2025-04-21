<%@page import="qlanphamdb.model.AnPham_CongTacVien"%>
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
	AnPham_CongTacVien congTacVien = (AnPham_CongTacVien) row.getObject();
	String ten = AnPham_CongTacVien.class.getName();
	String primKey = String.valueOf(congTacVien.getPrimaryKey());
	String tabCongTacVien = QlanphamAdminField.value_tabcongtacvien;
%>
	<portlet:actionURL name="editCTV" var="editCTVURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editCTVURL }"  />
    
    <portlet:actionURL name="deleteCTV" var="deleteCTVURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="<%=tabCongTacVien %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteCTVURL}"/>