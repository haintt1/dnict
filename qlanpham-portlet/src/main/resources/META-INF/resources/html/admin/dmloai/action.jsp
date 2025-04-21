<%@page import="qlanpham.portlet.portlet.QlanphamAdminField"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<portlet:defineObjects />
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	AnPham_Loai dmloai = (AnPham_Loai) row.getObject();
	String ten = AnPham_Loai.class.getName();
	String primKey = String.valueOf(dmloai.getPrimaryKey());
	String tabDmLoai = QlanphamAdminField.value_tabdmloai;
%>
	<portlet:actionURL name="editDmLoai" var="editDmLoaiURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editDmLoaiURL }"  />
    
    <portlet:actionURL name="deleteDmLoai" var="deleteDmLoaiURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="<%=tabDmLoai %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteDmLoaiURL}"/>