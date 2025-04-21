<%@page import="javax.portlet.PortletURL"%>
<%@page import="qlanpham.portlet.utils.AnPhamConfig"%>
<%@ include file="../init.jsp"%>

<%
	// Tạo danh sách tên tab
	String tabNames = String.join(",",
		AnPhamConfig.tabeMagazine,
		AnPhamConfig.tabMauGiaoDien
	);
	
	//set tab current
	String currentTab = ParamUtil.getString(request, "tabs1", AnPhamConfig.tabeMagazine);
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
		    	<%@ include file="/html/admin/eMagazine/eMagazine/view.jsp" %>
		    </liferay-ui:section>
		    <liferay-ui:section>
		        <%@ include file="/html/admin/eMagazine/template/view.jsp" %>
		    </liferay-ui:section>
		</liferay-ui:tabs>
  	</div>
</div>
