<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Vanbanphapquy"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
 <%@include file="init.jsp" %> 

<%
String tabVanbanphapquy = VanbanphapquyAdminField.value_tabQuanLyVanBan;
String name = "";
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
int status= -1;
//String vbpq_portletid = prefs.getValue("vbpq_portletid", "0");
//String vbpq_portletname= prefs.getValue("vbpq_portletname", "chitiet");
String limit_vb = prefs.getValue("limit_row", "5");
if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
	if(Validator.isNumber(ParamUtil.getString(request, "status"))){
		status = ParamUtil.getInteger(request, "status");
	}
}
PortletURL actionURL = renderResponse.createRenderURL();
actionURL.setParameter("tabs", tabVanbanphapquy);
actionURL.setParameter("status",String.valueOf(status));

List<Vanbanphapquy> listvbpq = VanbanphapquyAdminUtil.getVanBanHome(renderRequest, status, limit_vb);

%>
<div style="width: 100%;position: relative;overflow: hidden;" class="vbpq-home">
<ul>
	<%
		for (int i=0; i< listvbpq.size(); i++) {
			PortletURL url = null;
			url = PortletURLFactoryUtil.create(request, vbpq_portletname, Long.valueOf(vbpq_portletid), "0");
			url.setParameter("id", String.valueOf(listvbpq.get(i).getId()));
			String trichyeu = listvbpq.get(i).getTrichyeu();
			String sohieu = listvbpq.get(i).getSohieu();
			Date ngaybanhanh = listvbpq.get(i).getNgay_banhanh();
			
	%>
	<portlet:renderURL var="viewdetailURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
		 	<portlet:param name="id" value="<%=String.valueOf(listvbpq.get(i).getId())%>"/>
		 	<portlet:param name="jspPage" value="/html/vanbanphapquyuser/homedetail.jsp"/>
		 </portlet:renderURL>
		 <li>
		 <span class="sohieu">
		 	<a class="chitiet-sh" att-url="<%=viewdetailURL%>" href="#" class="btnChiTiet"><%=sohieu %></a>
		 </span>
		 <% if(Validator.isNotNull(ngaybanhanh)) { %>
		 <span class="ngaybh"><%=df.format(ngaybanhanh) %> </span>
		 <% } %>
		 <span class="trichyeu">
		 	<a class="chitiet-ty" att-url="<%=viewdetailURL%>" href="#" class="btnChiTiet"><%=trichyeu %></a>
		 </span>		 
		 </li>
	<% } %>
</ul>

</div>
<script use="liferay-util-window,aui-base">	
var <portlet:namespace/>_jquery = jQuery.noConflict(true);
		<portlet:namespace/>_jquery('.btnChiTiet').click(function(e){
			e.preventDefault();
			var viewdetailURL = <portlet:namespace/>_jquery(this).attr('att-url');
			Liferay.Util.openWindow({
		        dialog: {
		           cache: false,
		           centered: true,
		           height: 750,
		           modal: true,
		           width: 900,
		           destroyOnClose: true
		        },
		        id: '<portlet:namespace/>dialog',
		        title: 'Xem chi tiết',
		        uri: viewdetailURL
	    	});
    	});
	
	Liferay.provide(window, '<portlet:namespace/>refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },['aui-dialog','aui-dialog-iframe']);
    
	Liferay.provide(window, '<portlet:namespace/>closePopup', function(dialogId) {
		var A = AUI();
		var dialog = Liferay.Util.Window.getById(dialogId);
			dialog.destroy();
	},['liferay-util-window']);
</script>