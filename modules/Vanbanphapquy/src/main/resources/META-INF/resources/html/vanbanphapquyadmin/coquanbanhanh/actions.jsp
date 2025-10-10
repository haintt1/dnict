<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Coquanbanhanh cqbh =(Coquanbanhanh) row.getObject();
String name = Coquanbanhanh.class.getName();
String primKey = String.valueOf(cqbh.getPrimaryKey());
%>
    <portlet:actionURL name="editCoquanbanhanh" var="editURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editURL }"  />
    
    <portlet:actionURL name="deleteCoquanbanhanh" var="deleteURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="Cơ quan ban hành" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteURL}"/>
