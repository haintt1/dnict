
<%@page import="vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Vanbanphapquy"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.vanbanphapquy.model.Linhvucvanban"%>
<%@page import="java.util.List"%>
<%@page import="vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Loaivanban"%>
<%@page import="vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="vn.dnict.vanbanphapquy.actions.portlet.VanbanphapquyAdminField"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="../init.jsp" %>
  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Loại văn bản</title>
	</head>
<body>
<style>
#sohieu {
	width: 100%
}
#trichyeu{
	width: 100%
}
#tablesearch tr td .input-prepend{
	display: inline-flex;
}
#tablesearch tr td .input-prepend input{
	width: 70% !important;
	margin-left: 6px
}
#tablesearch tr td #idlv{
	width: 36%
}
#tablesearch tr td #idlvb{
	width: 36%
}
#tablesearch tr td #idcbh{
	width: 36%
}
#tablesearch tr td #idcqbh{
	width: 36%
}
.table-first-header{
	text-align: center
}
.table-last-header{
	text-align: center
}
.table .table-data tr td:nth-child(2){
	max-width: 620px;
}

</style>
<%
String tabVanbanphapquy = VanbanphapquyAdminField.value_tabQuanLyVanBan;
String name = "";
DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
int status= -1;
String trichyeu1 = ""; 
String sohieu="";
String tenchude="";
String tenloaichude="";
String nbh_tungay = ""; String nbh_denngay="";
String nhl_tungay = ""; String nhl_denngay="";
long idlv = Long.valueOf(linhvucvanban);
long idcbh = Long.valueOf(capbanhanh);
long idcqbh=0;
long idlvb =0;

List<Linhvucvanban> listlvvb = VanbanphapquyAdminUtil.getLinhvucvanbanByStatus(renderRequest, 1);
List<Capbanhanh> listcbh = VanbanphapquyAdminUtil.getCapbanhanhByStatus(renderRequest, 1);
List<Coquanbanhanh> listcqbh = VanbanphapquyAdminUtil.getCoquanbanhanhByStatus(renderRequest, 1);
List<Loaivanban> listlvb = VanbanphapquyAdminUtil.getLoaivanbanByStatus(renderRequest, 1);

if(Validator.isNotNull(ParamUtil.getString(request, "status"))){
	if(Validator.isNumber(ParamUtil.getString(request, "status"))){
		status = ParamUtil.getInteger(request, "status");
	}
}

if(Validator.isNotNull(ParamUtil.getString(request, "sohieu"))){
	sohieu = HtmlUtil.escape(ParamUtil.getString(request, "sohieu"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "trichyeu"))){
	trichyeu1 = HtmlUtil.escape(ParamUtil.getString(request, "trichyeu"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngay_banhanh_tungay"))){
	nbh_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngay_banhanh_tungay"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngay_banhanh_denngay"))){
	nbh_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngay_banhanh_denngay"));
}

if(Validator.isNotNull(ParamUtil.getString(request, "ngay_hieuluc_tungay"))){
	nhl_tungay = HtmlUtil.escape(ParamUtil.getString(request, "ngay_hieuluc_tungay"));
}
if(Validator.isNotNull(ParamUtil.getString(request, "ngay_hieuluc_denngay"))){
	nhl_denngay = HtmlUtil.escape(ParamUtil.getString(request, "ngay_hieuluc_denngay"));
}

if(Validator.isNotNull(ParamUtil.getString(request, "idlv")) && !ParamUtil.getString(request, "idlv").equals("0")){
	idlv = ParamUtil.getLong(request, "idlv");
}
if(Validator.isNotNull(ParamUtil.getString(request, "idcbh")) && !ParamUtil.getString(request, "idcbh").equals("0")){
	idcbh = ParamUtil.getLong(request, "idcbh");
}
if(Validator.isNotNull(ParamUtil.getString(request, "idcqbh")) && !ParamUtil.getString(request, "idcqbh").equals("0")){
	idcqbh = ParamUtil.getLong(request, "idcqbh");
}
if(Validator.isNotNull(ParamUtil.getString(request, "idlvb")) && !ParamUtil.getString(request, "idlvb").equals("0")){
	idlvb = ParamUtil.getLong(request, "idlvb");
}


PortletURL actionURL = renderResponse.createRenderURL();
actionURL.setParameter("tabs", tabVanbanphapquy);
actionURL.setParameter("sohieu",sohieu);
actionURL.setParameter("trichyeu",trichyeu1);
actionURL.setParameter("ngay_banhanh_tungay",nbh_tungay);
actionURL.setParameter("ngay_banhanh_denngay",nbh_denngay);
actionURL.setParameter("ngay_hieuluc_tungay",nhl_tungay);
actionURL.setParameter("ngay_hieuluc_denngay",nhl_denngay);
actionURL.setParameter("idlv",String.valueOf(idlv));
actionURL.setParameter("idcbh",String.valueOf(idcbh));
actionURL.setParameter("idcqbh",String.valueOf(idcqbh));
actionURL.setParameter("idlvb",String.valueOf(idlvb));
actionURL.setParameter("flagDisplay","");
actionURL.setParameter("status",String.valueOf(status));
PortletURL searchURL = renderResponse.createRenderURL();


PortletURL iteratorUrl = renderResponse.createRenderURL();
iteratorUrl.setParameter("jspPage", "/html/vanbanphapquyadmin/vanbanphapquy/list.jsp");



int cur = ParamUtil.getInteger(request,"cur");
int delta = ParamUtil.getInteger(request, "delta", 20);
//int total= 0;
SearchContainer searchContainer1 = null;
if (cur > 0) {
	searchContainer1 = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM,
			cur, delta, iteratorUrl, null, null);
} else {
	searchContainer1 = new SearchContainer(renderRequest, null,
			null, SearchContainer.DEFAULT_CUR_PARAM, delta,
			iteratorUrl, null, null);
}

int stt = searchContainer1.getStart() + 1;
%>
<portlet:renderURL var="addVanbanphapquyURL">
	<portlet:param name="jspPage" value="/html/vanbanphapquyadmin/vanbanphapquy/add.jsp"/>
</portlet:renderURL>
<fieldset class="fs-admin">
	<form action="<%=searchURL.toString()%>" method="post">
	<table class="table table-bordered" id="tablesearch">
		<tr>
			<th class="keycolor">Số văn bản</th>
			<td><input type="text" name="<portlet:namespace/>sohieu" value="<%=sohieu%>" id="sohieu"/></td>
			<th class="keycolor">Trích yếu</th>
			<td><input type="text" name="<portlet:namespace/>trichyeu" value="<%=trichyeu1%>" id="trichyeu"/></td>
		</tr>
		<tr>
			<th class="keycolor">Ngày ban hành</th>
			<td>
				<div class="input-prepend">
					<span class="add-on" style="float: left;">Từ ngày</span>
					<input type="text" name="<portlet:namespace/>ngay_banhanh_tungay" id="ngay_banhanh_tungay" style="width:85px" value="<%=nbh_tungay%>"/>
				</div>
				<div class="input-prepend">
					<span class="add-on" style="float: left;">Đến ngày</span>
					<input type="text" name="<portlet:namespace/>ngay_banhanh_denngay" id="ngay_banhanh_denngay" style="width:85px" value="<%=nbh_denngay%>"/>
				</div>
			</td>
			<th class="keycolor">Ngày hiệu lực</th>
			<td>
				<div class="input-prepend">
					<span class="add-on" style="float: left;">Từ ngày</span>
					<input type="text" name="<portlet:namespace/>ngay_hieuluc_tungay" id="ngay_hieuluc_tungay" style="width:85px" value="<%=nhl_tungay%>"/>
				</div>
				<div class="input-prepend">
					<span class="add-on" style="float: left;">Đến ngày</span>
					<input type="text" name="<portlet:namespace/>ngay_hieuluc_denngay" id="ngay_hieuluc_denngay" style="width:85px" value="<%=nhl_denngay%>"/>
				</div>
			</td>
		</tr>
		<tr>
			<th class="keycolor">Lĩnh vực</th>
			<td>
				<select name="<portlet:namespace/>idlv" id="idlv">
				<option value="">--Vui lòng chọn--</option>
				 <% 
				 for(int i=0; i<listlvvb.size();i++) {
				 %>
				 <option value="<%=listlvvb.get(i).getId()%>" <%=listlvvb.get(i).getId()==idlv?"selected":""%>><%=listlvvb.get(i).getName()%></option>
				 <%}%>
				</select>
			</td>
			<th class="keycolor">Loại văn bản</th>
			<td>
				<select name="<portlet:namespace/>idlvb" id="idlvb">
			    <option value="">--Vui lòng chọn--</option>
				 <% 
				 for(int i=0; i<listlvb.size();i++) {
				 %>
				 <option value="<%=listlvb.get(i).getId()%>" <%=listlvb.get(i).getId()==idlvb?"selected":""%>><%=listlvb.get(i).getName()%></option>
				 <%}%>
				</select>
			</td>
		</tr>
		<tr>
			<th class="keycolor">Cấp ban hành</th>
			<td>
				<select name="<portlet:namespace/>idcbh" id="idcbh">
			    <option value="0">--Vui lòng chọn--</option>
				 <% 
				 for(int i=0; i<listcbh.size();i++) {
				 %>
				 <option value="<%=listcbh.get(i).getId()%>" <%=listcbh.get(i).getId()==idcbh?"selected":""%>><%=listcbh.get(i).getName()%></option>
				 <%}%>
				</select>
			</td>
			<th class="keycolor">Cơ quan ban hành</th>
			<td>
				<select name="<portlet:namespace/>idcqbh" id="idcqbh">
			    <option value="">--Vui lòng chọn--</option>
				 <% 
				 for(int i=0; i<listcqbh.size();i++) {
				 %>
				 <option value="<%=listcqbh.get(i).getId()%>" <%=listcqbh.get(i).getId()==idcqbh?"selected":""%>><%=listcqbh.get(i).getName()%></option>
				 <%}%>
				</select>
			</td>
		</tr>
		<tr>
			<th class="keycolor">Trạng thái văn bản</th>
			<td>
				<aui:select name="status"  label="">
					<aui:option value="-1"></aui:option>
					<aui:option value="1" selected="<%=status==1?true:false%>">Hiển thị</aui:option>
					<aui:option value="0" selected="<%=status==0?true:false%>">Chưa hiển thị</aui:option>
				</aui:select>
			</td>
			<th></th>
			<td></td>
		</tr>
		<tr>
			<td colspan="4" style="text-align: center">
				<aui:button type="submit" value="Tìm kiếm" cssClass="btn"/>
				<a class="tmvbk" href="<%=addVanbanphapquyURL%>"><aui:button cssClass="btn btn-success"  value="Thêm mới văn bản"/></a>
			</td>
		</tr>
	</table>
	</form>
</fieldset><br>

<table>
	<liferay-ui:search-container delta="20" total="<%= VanbanphapquyAdminUtil.countVanbanphapquy(renderRequest, sohieu, trichyeu1, idlv, idcqbh, idlvb, idcbh, nbh_tungay, nbh_denngay, nhl_tungay, nhl_denngay,  status, 0, 0).size() %>" 
	emptyResultsMessage="Chưa có văn bản nào" 
	iteratorURL="<%=actionURL%>">
	<liferay-ui:search-container-results
		results="<%= VanbanphapquyAdminUtil.countVanbanphapquy(renderRequest, sohieu, trichyeu1, idlv, idcqbh, idlvb, idcbh,nbh_tungay, nbh_denngay, nhl_tungay, nhl_denngay, status, searchContainer1.getStart(), searchContainer1.getEnd())%>"
	/>

	<liferay-ui:search-container-row
		className="vn.dnict.vanbanphapquy.model.Vanbanphapquy"
		modelVar="varVanbanphapquy"
		keyProperty="id"
	>
	<%
		Vanbanphapquy vbpq = VanbanphapquyLocalServiceUtil.fetchVanbanphapquy(varVanbanphapquy.getId());
		Linhvucvanban lvvb = LinhvucvanbanLocalServiceUtil.fetchLinhvucvanban(varVanbanphapquy.getId_linhvuc());
		if(Validator.isNull(lvvb)){
			lvvb = LinhvucvanbanLocalServiceUtil.createLinhvucvanban(varVanbanphapquy.getId());
		}
		Coquanbanhanh cqbh = CoquanbanhanhLocalServiceUtil.fetchCoquanbanhanh(varVanbanphapquy.getId_coquanbanhanh());
		if(Validator.isNull(lvvb)){
			cqbh = CoquanbanhanhLocalServiceUtil.createCoquanbanhanh(varVanbanphapquy.getId());
		}
	%>
		<liferay-ui:search-container-column-text name="STT" align="center"><%=stt++ %></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Trích yếu văn bản" value="<%=vbpq.getTrichyeu() %>"/>
		<liferay-ui:search-container-column-text name="Lĩnh vực văn bản" value="<%=lvvb.getName() %>"/>
		<liferay-ui:search-container-column-text name="Cơ quan ban hành" value="<%=cqbh.getName() %>"/>
		<liferay-ui:search-container-column-text name="Số hiệu văn bản" value="<%=vbpq.getSohieu() %>"/>
		<%
	        String ngay_xuatban="";
	        if(Validator.isNotNull(vbpq.getNgay_xuatban())){
	        	ngay_xuatban = df.format(vbpq.getNgay_xuatban());
	        }
        %>
        <liferay-ui:search-container-column-text name="Ngày xuất bản" value="<%=ngay_xuatban %>"/>
		<%
			String trangthai = "";
			if(varVanbanphapquy.getStatus()== 0){
				trangthai = "<img src=\""+ request.getContextPath()+"/icon/icon_active/publish_x.png\"/>";
		       }else{	
		        trangthai = "<img src=\""+ request.getContextPath()+"/icon/icon_active/tick.png\"/>";
	        }
		%>
		<liferay-ui:search-container-column-text name="Sử dụng" value="<%=trangthai %>" align="center"/>
		<liferay-ui:search-container-column-jsp path="/html/vanbanphapquyadmin/vanbanphapquy/actions.jsp" name="Thao tác" align="center" cssClass="thaotac"/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</table>
</body>
</html>
<script type="text/javascript">
jQuery(function($){
	$("#ngay_banhanh_tungay").datepicker();
	$("#ngay_banhanh_denngay").datepicker();
	$("#ngay_hieuluc_tungay").datepicker();
	$("#ngay_hieuluc_denngay").datepicker();
});
</script>