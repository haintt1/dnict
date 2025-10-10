<%@page import="vn.dnict.vanbanphapquy.model.Linhvucvanban"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@page import="vn.dnict.vanbanphapquy.model.Loaivanban"%>
<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<portlet:defineObjects />
<%
String tabLinhvucvanban = VanbanphapquyAdminField.value_tabLinhVuc;
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Linhvucvanban lvvb =(Linhvucvanban) row.getObject();
String name = Linhvucvanban.class.getName();
String primKey = String.valueOf(lvvb.getPrimaryKey());
%>
    <portlet:actionURL name="editLinhvucvanban" var="editURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editURL }"  />
    
    <portlet:actionURL name="deleteLinhvucvanban" var="deleteURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="<%=tabLinhvucvanban %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteURL}"/>
