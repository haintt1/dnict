<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<portlet:defineObjects />
<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Capbanhanh cbh =(Capbanhanh) row.getObject();
String name = Capbanhanh.class.getName();
String primKey = String.valueOf(cbh.getPrimaryKey());
%>
    <portlet:actionURL name="editCapbanhanh" var="editURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editURL }"  />
    
    <portlet:actionURL name="deleteCapbanhanh" var="deleteURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="Cấp ban hành" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteURL}"/>
