
<%@page import="vn.dnict.vanbanphapquy.utils.VanbanphapquyAdminUtil"%>
<%@page import="java.util.Date"%>
<%@page import="vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Linhvucvanban"%>
<%@page import="vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Capbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Coquanbanhanh"%>
<%@page import="vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil"%>
<%@page import="vn.dnict.vanbanphapquy.model.Loaivanban"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.vanbanphapquy.utils.DocumentUpload"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vn.dnict.vanbanphapquy.model.dinhkemfile"%>
<%@page import="java.util.List"%>
<%@page import="vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dnict.vanbanphapquy.model.Vanbanphapquy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="init.jsp"%>

<style>
table.fr_tbcore {
    width: 100%;
    border: 1px solid #ccc;
}
table.fr_tbcore th, table.fr_tbcore td {
    border: 1px solid #ccc;
    padding: 8px;
}
table.fr_tbcore th.keycolor {
    text-align: right;
    background-color: rgba(0, 239, 215, 0.03);
    margin-bottom: 10px;
}

.trichyeuvanban {
	font-size: 19px;
    border-bottom: 1px dashed #ccc;
    line-height: 45px;
}
</style>

<%
Vanbanphapquy vbpq = null;
long id = Long.valueOf(request.getParameter("id"));

if (Validator.isNotNull(request.getParameter("id"))) {
	vbpq = VanbanphapquyLocalServiceUtil.fetchVanbanphapquy(id);	
}
if (Validator.isNull(vbpq)) {
	vbpq = VanbanphapquyLocalServiceUtil.createVanbanphapquy(id);
}
DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.US);
Loaivanban lvb = LoaivanbanLocalServiceUtil.fetchLoaivanban(vbpq.getId_loaivanban());
Coquanbanhanh cqbh= CoquanbanhanhLocalServiceUtil.fetchCoquanbanhanh(vbpq.getId_coquanbanhanh());
Capbanhanh cbh= CapbanhanhLocalServiceUtil.fetchCapbanhanh(vbpq.getId_capbanhanh());
Linhvucvanban lvvb= LinhvucvanbanLocalServiceUtil.fetchLinhvucvanban(vbpq.getId_linhvuc());

String loaiVanBan = lvb.getName();
String coquanbanhanh=cqbh.getName();
String capbanhanh1= cbh.getName();
String linhvuc = lvvb.getName();
String ngay_banhanh = "";
String ngay_hieuluc = "";
String ngay_hethieuluc = "";
String ngay_xuatban="";
String hieuluc = "(Văn bản còn hiệu lực)";
if(Validator.isNotNull(vbpq.getNgay_xuatban())){
	ngay_xuatban = df.format(vbpq.getNgay_xuatban());
}
if(Validator.isNotNull(vbpq.getNgay_banhanh())){
	ngay_banhanh = df.format(vbpq.getNgay_banhanh());
}
if(Validator.isNotNull(vbpq.getNgay_hieuluc())){
	ngay_hieuluc = df.format(vbpq.getNgay_hieuluc());
}
if(Validator.isNotNull(vbpq.getNgay_hethieuluc())){
	ngay_hethieuluc = df.format(vbpq.getNgay_hethieuluc());
	Date date = new Date();
	if(date.after(vbpq.getNgay_hethieuluc())){
		hieuluc = "(Văn bản hết hiệu lực)";
	}
}

%>
<h3 class="trichyeuvanban"><%=vbpq.getTrichyeu()%></h3>
<h4 class="thuoctinh">Thuộc tính văn bản</h4>
	<table class="fr_tbcore" style="margin:bottom:20px;">
			<tbody>
				<tr>
					<th class="keycolor">Số kí hiệu</th>
					<td><%=vbpq.getSohieu()%></td>
					<th class="keycolor">Người ký</th>
					<td style="width: 25%"><%=vbpq.getNguoiky()%></td>
				</tr>
				<tr>
					<th class="keycolor">Ngày ban hành</th>
					<td><%=ngay_banhanh%></td>
					<th class="keycolor">Ngày xuất bản</th>
					<td><%=ngay_xuatban%></td>
				</tr>
				<tr>
					<th class="keycolor">Ngày hiệu lực</th>
					<td><%=ngay_hieuluc%></td>
					<th class="keycolor">Ngày hết hiệu lực</th>
					<td><%=ngay_hethieuluc%></td>
				</tr>
				<tr>
					<th class="keycolor">Lĩnh vực</th>
					<td><%=linhvuc%></td>
					<th class="keycolor">Loại văn bản</th>
					<td><%=loaiVanBan%></td>
				</tr>
				<tr>
					<th class="keycolor">Cấp ban hành</th>
					<td><%=capbanhanh1%></td>
					<th class="keycolor">Cơ quan ban hành</th>
					<td><%=coquanbanhanh%></td>
				</tr>
				<tr>
					<th class="keycolor">Nội dung</th>
					<td colspan="3">
					<%
						String noidungchitiet = "";
						String result_split[] = null;
						if(Validator.isNotNull(vbpq.getNoidung()) && !vbpq.getNoidung().equals("")){
							result_split = vbpq.getNoidung().split("&&_phancach_&&");
						}
						if(Validator.isNotNull(result_split) && result_split.length >0){
							noidungchitiet = result_split[0];
						}
					%>	
					<%=noidungchitiet%>
					</td>
				</tr>
				<tr>
				<th class="keycolor"><strong>Đính kèm:</strong></th>
				<td colspan="3">
						<%
							List<dinhkemfile> listfileDinhkem = new ArrayList<dinhkemfile>();
							listfileDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(vbpq.getId(), 1, themeDisplay);
							if(listfileDinhkem.size() > 0){
								int dem = 1;
								for(dinhkemfile file: listfileDinhkem){
						%>
							<a class="link_dow" href="<%=file.getUrl()%>" target="blank"><%=dem%>. <%=file.getTen()%></a><br>
						<%dem++;}}%>
					</td>
				</tr>
			</tbody>
		</table>
		<table style="width: 100%">
			<%
				if (prefs_vanbanlienquan.equals("yes")) {
			%>
			<tr class="vanbanlienquan">
				<td>
					<%
						List<Vanbanphapquy> listvbpq = null;
							String lienquantheo = "";
							String kieuvanban = "";
							if (vbqppl.equals("1")){kieuvanban = "0";}
							if (vbcddh.equals("1")){kieuvanban = "1";}
							if (vbmoi.equals("1")){kieuvanban = "2";}
							if (vbbaucu.equals("1")){kieuvanban = "3";}
							if (vbkhac.equals("1")){kieuvanban = "4";}
							if (prefs_lienquantheo.equals("lvvb")) {
								listvbpq = VanbanphapquyAdminUtil.getVBPQByIdCategory(kieuvanban, vbpq.getId_linhvuc(), "linhvucvanban");
								lienquantheo = "Lĩnh vực";
							}
							if (prefs_lienquantheo.equals("lvb")) {
								listvbpq = VanbanphapquyAdminUtil.getVBPQByIdCategory(kieuvanban,
										vbpq.getId_loaivanban(), "loaivanban");
								lienquantheo = "Loại văn bản";
							}
							if (prefs_lienquantheo.equals("cbh")) {
								listvbpq = VanbanphapquyAdminUtil.getVBPQByIdCategory(kieuvanban,
										vbpq.getId_capbanhanh(), "capbanhanh");
								lienquantheo = "Cấp ban hành";
							}
							if (prefs_lienquantheo.equals("cqbh")) {
								listvbpq = VanbanphapquyAdminUtil.getVBPQByIdCategory(kieuvanban,
										vbpq.getId_coquanbanhanh(), "coquanbanhanh");
								lienquantheo = "Cơ quan ban hành";
							}
					%> 
				<strong class="title">
					Văn bản liên quan theo <%=lienquantheo %>: 
				</strong>
				
					<ol>
						<%
							if (Validator.isNotNull(listvbpq)) {
									for (int i = 0; i < listvbpq.size(); i++) {
										if (listvbpq.get(i).getId() != vbpq.getId()
												&& i < Integer.valueOf(prefs_limit_vblq)) {
						%>
						<portlet:renderURL var="detailVanbanphapquyURL">
							<portlet:param name="id"
								value="<%=String.valueOf(listvbpq.get(i)
										.getId())%>" />
							<portlet:param name="jspPage"
								value="/html/vanbanphapquyuser/homedetail.jsp" />
						</portlet:renderURL>
						<li><a href="<%=detailVanbanphapquyURL.toString()%>"><%=listvbpq.get(i).getTrichyeu()%></a></li>
						<%}}}%>
					</ol> 
					<%
					 	}
					 %>
				</td>
			</tr>
		</table>