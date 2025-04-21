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
			List<AnPham_DinhKemFile> listDinhKem = QlanphamAdminUtil.getLinkDinhKemByAnPhamId(anPhamId);
  			String url = listDinhKem.size() > 0 ? listDinhKem.get(0).getUrl() : "" ;
	%>
	<button class="accordion">► Phiên bản <%=lg.getPhienBan() %></button>
	<div class="panel-version">
		<p id="title"><span class="field-label">Tiêu đề:</span> <%=lg.getTen() %></p>
		<p id="anhdaidien"><span class="field-label">Ảnh đại diện:</span> <%=lg.getAnhDaiDien() %></p>
		<p id="mota"><span class="field-label">Mô tả:</span> <%=lg.getMoTa() %></p>
		<p id="noidung"><span class="field-label">Nội dung:</span> <%=lg.getNoiDung() %></p>
		<p id="filedinhkem"><span class="field-label">File đính kèm:</span> <%=url %></p>
		<p id="tukhoa"><span class="field-label">Từ khóa:</span> <%=lg.getTuKhoa() %></p>
		<p id="ngayxuatban"><span class="field-label">Ngày xuất bản:</span> <%=df.format(lg.getNgayTao()) %></p>
		<% if (j == 1) { %>
				<p><span id="diff-content"></span></p>
		<% } %>
	</div>
	<% } %>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jsdiff/5.1.0/diff.min.js"></script>
<script>
	// Hàm trích xuất văn bản từ HTML    
	function stripHTML(html) {
	    const temp = document.createElement("div");
	    temp.innerHTML = html;
	    return temp.textContent || temp.innerText || "";
	   
	}
	
	const oldTitle = `<%= secondLog.getTen()%>`;
	const newTitle = `<%= firstLog.getTen()%>`;
	
	const oldContent = `<%= secondLog.getNoiDung()%>`;
	const newContent = `<%= firstLog.getNoiDung()%>`;
	
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
            	
            	const titleDiff = Diff.diffWords(oldTitle, newTitle);
                
                const contentDiff = Diff.diffWords(stripHTML(oldContent), stripHTML(newContent));
                
                const titleHTML = titleDiff.map(part => {
                    const color = part.added ? 'lightgreen' :
                        part.removed ? 'salmon' : 'transparent';
                    return '<span style="background-color:' + color + '">' + part.value + '</span>';
                }).join('');
                
                
                const contentHTML = contentDiff.map(part => {
                    const color = part.added ? 'lightgreen' :
                        part.removed ? 'salmon' : 'transparent';
                    return '<span style="background-color:' + color + '">' + part.value + '</span>';
                }).join('');
    			
                document.getElementById("diff-content").innerHTML =
            		"<span class='field-label'>So sánh tiêu đề:</span><p>" + titleHTML + "</p>" +
            		"<span class='field-label'>So sánh nội dung:</span><p>" + contentHTML + "</p>";
            	
                document.getElementById("title").style.display = "none";
            }
            
            
        });
    }
</script>