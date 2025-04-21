<%@page import="qlanphamdb.model.AnPham_DinhKemFile"%>
<%@page import="qlanpham.portlet.utils.QlanphamAdminUtil"%>
<%@page import="qlanphamdb.model.AnPham_Logs"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="qlanphamdb.service.AnPham_TapChiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	long anPhamId = ParamUtil.getLong(request, "id");
	List<AnPham_Logs> listAnPhamLog = QlanphamAdminUtil.getAnPhamLogByAnPhamId(anPhamId);
%>
<style>

.accordion {
	cursor: pointer;
	padding: 10px;
	border: none;
	outline: none;
	width: 100%;
	text-align: left;
	background-color: #f1f1f1;
	transition: background-color 0.3s ease;
	font-weight: bold;
	margin-top: 5px;
}

.accordion.active, .accordion:hover {
	background-color: #ccc;
}

.panel-version {
	padding: 0 15px;
	display: none;
	background-color: #fafafa;
	border-left: 2px solid #ddd;
	border-right: 2px solid #ddd;
	border-bottom: 2px solid #ddd;
	margin-bottom: 10px;
}

.panel-version p {
	margin: 8px 0;
}

.field-label {
	font-weight: bold;
	display: inline-block;
}
</style>

<%
	if(listAnPhamLog.size() >= 2) {
%>

<div class="container-fluid">
	<h3>Danh sách các phiên bản</h3>
	<%
		int j = 0;
		AnPham_Logs firstLog = null;
		AnPham_Logs secondLog = null;
		for(AnPham_Logs lg : listAnPhamLog) {
			j++;
			if(j == 1) {
				firstLog = lg;
			} else if (j == 2) {
				secondLog = lg;
			}
	%>
	<button class="accordion">► Phiên bản <%=lg.getPhienBan() %></button>
	<div class="panel-version">
		<p id="title"><span class="field-label">Tiêu đề:</span> <%=lg.getTen() %></p>
		<p id="anhdaidien"><span class="field-label">Ảnh đại diện:</span> <%=lg.getAnhDaiDien() %></p>
		<p id="mota"><span class="field-label">Mô tả:</span> <%=lg.getMoTa() %></p>
		<div id="noidung"><span class="field-label">Nội dung:</span> <%=lg.getNoiDung() %></div>
		<p id="tukhoa"><span class="field-label">Từ khóa:</span> <%=lg.getTuKhoa() %></p>
		<p id="ngayxuatban"><span class="field-label">Ngày xuất bản:</span> <%=df.format(lg.getNgayTao()) %></p>
		<% if (j == 1) { %>
				<p><span id="diff-content"></span></p>
		<% } %>
	</div>
	<% } %>
</div>

<script>
	// Hàm trích xuất văn bản từ HTML    
	function stripHTML(html) {
	    const temp = document.createElement("div");
	    temp.innerHTML = html;
	    return temp.textContent || temp.innerText || "";
	   
	}
	
	function khoiTaoDiff() {
		const oldVersion = {
	        title: `<%= secondLog.getTen() %>`,
	        anh: `<%= secondLog.getAnhDaiDien() %>`,
	        mota: `<%= secondLog.getMoTa() %>`,
	        noidung: stripHTML(`<%= secondLog.getNoiDung() %>`),
	        tukhoa: `<%= secondLog.getTuKhoa() %>`,
	        ngayxuatban: `<%= df.format(secondLog.getNgayTao()) %>`
	    };
		
		const newVersion = {
	        title: `<%= firstLog.getTen() %>`,
	        anh: `<%= firstLog.getAnhDaiDien() %>`,
	        mota: `<%= firstLog.getMoTa() %>`,
	        noidung: stripHTML(`<%= firstLog.getNoiDung() %>`),
	        tukhoa: `<%= firstLog.getTuKhoa() %>`,
	        ngayxuatban: `<%= df.format(firstLog.getNgayTao()) %>`
	    };
			
		// Hàm tạo HTML diff cho một trường
	    function createDiffHTML(oldText, newText, label) {
	        const diff = Diff.diffWords(oldText, newText);
	        const html = diff.map(part => {
	            const color = part.added ? 'lightgreen' :
	                          part.removed ? 'salmon' : 'transparent';
	            return '<span style="background-color:' + color + '">' + part.value + '</span>';
	        }).join('');
	        return '<span class="field-label">' + label + ':</span><p>' + html + '</p>';
	    }
			
	    const acc = document.getElementsByClassName("accordion");
	    for (let i = 0; i < acc.length; i++) {
	        acc[i].addEventListener("click", function () {
	            this.classList.toggle("active");
	            this.textContent = this.textContent.startsWith("►")
	                ? this.textContent.replace("►", "▼")
	                : this.textContent.replace("▼", "►");
	    
	            const panel = this.nextElementSibling;
	            panel.style.display = panel.style.display === "block" ? "none" : "block";
	            // diffWords : so sánh từ
	            // diffLines: so sánh đoạn văn
	            
	            if(i === 0) {
	            	
	            	// Tạo diff cho tất cả các trường
	                let diffHTML = '';
	                diffHTML += createDiffHTML(oldVersion.title, newVersion.title, "Tiêu đề");
	                diffHTML += createDiffHTML(oldVersion.anh, newVersion.anh, "Ảnh đại diện");
	                diffHTML += createDiffHTML(oldVersion.mota, newVersion.mota, "Mô tả");
	                diffHTML += createDiffHTML(oldVersion.noidung, newVersion.noidung, "Nội dung");
	                diffHTML += createDiffHTML(oldVersion.tukhoa, newVersion.tukhoa, "Từ khóa");
	                diffHTML += createDiffHTML(oldVersion.ngayxuatban, newVersion.ngayxuatban, "Ngày xuất bản");

	                document.getElementById("diff-content").innerHTML = diffHTML;

	                // Ẩn các trường gốc
	                ["title", "anhdaidien", "mota", "noidung", "tukhoa", "ngayxuatban"]
	                    .forEach(id => document.getElementById(id).style.display = "none");
	            }
	        });
	    }	
	}
	// Gọi hàm khởi tạo
    khoiTaoDiff();
</script>

<% } else { %>
<div class="alert alert-primary" role="alert">Phải trên 2 phiên bản mới xem được chức năng này!</div>
<% } %>