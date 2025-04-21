<%@page import="qlanpham.portlet.utils.AnPhamConfig"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
//Tạo danh sách tên tab
	String tabNames = String.join(",",
		AnPhamConfig.tabThongKeBTV,
		AnPhamConfig.tabThongKeLoaiAnPham,
		AnPhamConfig.tabThongKeLuotXemVaLuotTai
	);
	
	//set tab current
	String currentTab = ParamUtil.getString(request, "tabs1", AnPhamConfig.tabThongKeBTV);
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tabs1", currentTab);
%>

<div class="container">
	<div class="tab-content">
	  	<liferay-ui:tabs 
	  		names="<%=tabNames %>" 
	  		tabsValues="<%=tabNames %>" 
	  		refresh="true"
	  		type="tabs"
	  		url="<%=portletURL.toString() %>"
	  		value="<%=currentTab %>"
	  		>
	  		<liferay-ui:section>
		        <%@ include file="/html/admin/thongke/thongkebtv/view.jsp" %>
		    </liferay-ui:section>
		    <liferay-ui:section>
		        <%@ include file="/html/admin/thongke/thongkeloaiap/view.jsp" %>
		    </liferay-ui:section>
		    <liferay-ui:section>
		        <%@ include file="/html/admin/thongke/thongkeluotxemvaluottai/view.jsp" %>
		    </liferay-ui:section>
		</liferay-ui:tabs>
  	</div>
</div>