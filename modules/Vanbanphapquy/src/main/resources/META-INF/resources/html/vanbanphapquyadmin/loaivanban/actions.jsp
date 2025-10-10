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
String tabLoaivanban = VanbanphapquyAdminField.value_tabLoaiVanBan;
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Loaivanban lvb =(Loaivanban) row.getObject();
String name = Loaivanban.class.getName();
String primKey = String.valueOf(lvb.getPrimaryKey());
%>
    <portlet:actionURL name="editLoaivanban" var="editURL">
      <portlet:param name="id" value="<%=primKey %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" url="${editURL }"  />
    
    <portlet:actionURL name="deleteLoaivanban" var="deleteURL">
      <portlet:param name="id" value="<%= primKey %>" />
      <portlet:param name="tabs" value="<%=tabLoaivanban %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="delete" url="${deleteURL}"/>
