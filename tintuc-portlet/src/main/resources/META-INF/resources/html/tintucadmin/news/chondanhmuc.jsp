<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style type="text/css" media="all">
ul.libdanhmuc {
    margin: 0;
}
ul.danhmuc {margin-left: 0 !important;}
input.checkbox_ip {
    position: absolute;
    top: 5px;
    left: 10px;
}
.lib-item {
    margin: 0 10px;
    position: relative;
}
ul.libdanhmuc li {
    list-style: none !important;
    margin-bottom: 0px !important;
}
.danhmuc > li {
    display: inline-block;
}
.lib-item label:hover {
    background: rgba(242, 239, 99, 0.54);
    border-radius: 5px;
}
.danhmuc {
    margin-top: 10px !important;
    margin-bottom: 0px !important;
}
.lib-item input {
    float: left;
	margin-right: 3px !important;
}
.lib-item label {
    float: left !important;
    font-size: 14px;
    margin-bottom: 0 !important;
    padding: 5px 12px 5px 25px;
}
.lib-item:after {
    clear: both;
    display: block;
    content: "";
}
.lib-item {
    margin: 0 !important;
}
.checkbox_multi_item {
    position: absolute;
    top: 5px;
    left: 8px;
}
.libchonnhieudanhmuc {
    list-style: none;
    margin: 0 !important;
}
</style>
<%
News_role role = null;
if(Validator.isNull(role)){
	role = PhanQuyenAdminUtil.getUserById(user.getUserId());
}
String[] category_id = null;
if(!role.getCategory_active_role().equals("")){
	category_id = role.getCategory_active_role().substring(1).split("_");
}
String saveStatus = ParamUtil.getString(request, "saveStatus");
if(saveStatus.equals("done")){
%>
<aui:script>
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
	Liferay.Util.getOpener().<portlet:namespace/>refreshPortlet();	
</aui:script>
<%
}else{
	String id = ParamUtil.getString(request, "id");
%>
<!-- 
<portlet:actionURL var="saveURL" name="saveNewCategory">
	<portlet:param name="jspPage"
		value="/html/portlets/tintucadmin/view.jsp" />
</portlet:actionURL>
<liferay-ui:error key="name-required" message="Tên bắt buộc nhập."/>
<liferay-ui:error key="name-toolong" message="Tên có độ dài quá qui định 600 kí tự."/> -->
<div class="containerlibcat">
<%

List<News_Subcategories> listlibcat = TinTucAdminUtil.getSubCatByLang(renderRequest,checkLangNews,"",0,0,0);

if(listlibcat.size() > 0){
	
	
if(chondanhmuc.equals("checked")){
%>
<ul class="libdanhmuc">
<%for(int i = 0;i< listlibcat.size(); i++){%>
	<li>
		<h5 class="thuvien-item">
			<%=listlibcat.get(i).getName()%>
		</h5>
		<%
			
			List<News_Categories> listcategory = TinTucAdminUtil.searchNewCategory("", 0,listlibcat.get(i).getId(), 0, 0);
			if(listcategory.size() > 0){
		%>
			<ul class="danhmuc">
				<%
				
				for(int a = 0; a < listcategory.size(); a++){
					String selected = "";
					if(category_id != null){
						for(int v = 0; v < category_id.length; v++){
							if(!category_id[v].equals("") && listcategory.get(a).getId() == Long.valueOf(category_id[v])){
				%>
					<li>
						<div class="lib-item">
							<input class="checkbox_ip" name="<portlet:namespace/>_checkbox" id="checkbox_<%=listcategory.get(a).getId()%>" value="<%=listcategory.get(a).getId()%>" type="radio" dataname="<%=listcategory.get(a).getName()%>" <%=selected%>/><label for="checkbox_<%=listcategory.get(a).getId()%>"><%=listcategory.get(a).getName()%></label>
						</div>
					</li>
				<%}}}}%>
			</ul>
		<%}%>
	</li>
<%}%>	
</ul>
<%}else{
%>
<ul class="libchonnhieudanhmuc">
<%for(int i = 0;i< listlibcat.size(); i++){%>
	<li>
		<h5 class="thuvien-item">
			<%=listlibcat.get(i).getName()%>
		</h5>
		<%
			List<News_Categories> listcategory = TinTucAdminUtil.searchNewCategory("", 0, Long.valueOf(listlibcat.get(i).getId()), 0, 0);
			
			if(listcategory.size() > 0){
		%>
			<ul class="danhmuc">
				<%
				
				for(int a = 0; a < listcategory.size(); a++){
					String selected = "";
					if(category_id != null){
						for(int v = 0; v < category_id.length; v++){
							if(!category_id[v].equals("") && listcategory.get(a).getId() == Long.valueOf(category_id[v])){
				%>
					<li>
						<div class="lib-item">
							<input id="checkbox_<%=listcategory.get(a).getId()%>" class="checkbox_multi_item" name="<portlet:namespace/>category_<%=listcategory.get(a).getId()%>" type="checkbox" value="<%=listcategory.get(a).getId()%>" dataname="<%=listcategory.get(a).getName()%>" <%=selected%>>
							<label for="checkbox_<%=listcategory.get(a).getId()%>"><%=listcategory.get(a).getName()%></label>
						</div>
					</li>
				<%}}}}%>
			</ul>
		<%}%>
	</li>
<%}%>	
</ul>
<%}}%>
</div>
<div style="display:center;padding: 40px;">
	<%if(chondanhmuc.equals("checked")){%>
		<button id="chonButton"  style="height:40px !important;" class="btn btn-primary">Chọn danh muc</button>
	<%}else{%>
		<button id="chonnhieuButton"  style="height:40px !important;" class="btn btn-primary">Chọn danh mục</button>
	<%}%>
	<button id="closeButton" class=" btn-danger" style="height:40px !important;">Đóng</button>
</div>
<aui:script>
$('#chonButton').click(function(){
		var data;
		var name;
		$('.checkbox_ip').each(function(){
		   if(this.checked){
		   data = "_"+this.value;
		   name = $(this).attr("dataname");
		   }
	    });
		  Liferay.Util.getOpener().listdanhmuc(data,name);
		  Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});
$('#chonnhieuButton').click(function(){
		var chk = $(".chuyenmuc-multiple-selected");
		var data ="";
		var name = "";
		var len = $('input[type="checkbox"]:checked').length;
			$('input[type="checkbox"]:checked').each(function(index, element) {
				data =  data+"_"+$(this).val();
				if(name == ""){
					name = name+$(this).attr("dataname");
				}else{
				   name = name+", "+$(this).attr("dataname");
				}
		    });	
		  Liferay.Util.getOpener().listchonnhieudanhmuc(data,name);
		  Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

$('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});
</aui:script>
<%}%>