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
	width: 120px;
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
	%>
	<button class="accordion">► Phiên bản <%=lg.getPhienBan() %></button>
	<div class="panel-version">
		<p class="title"><span class="field-label">Tiêu đề:</span> <%=lg.getTen() %></p>	
		<p class="content"><span class="field-label">Nội dung:</span> <%=lg.getNoiDung() %></p>
		<p class="content-log"><span class="field-label">Nội dung xử lý:</span> <%=lg.getNoiDungLog() %></p>
		<% if (j == 1) { %>
				<p><span id="diff-content"></span></p>
		<% } %>
	</div>
	<% } %>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jsdiff/5.1.0/diff.min.js"></script>
<script>
    const panels = document.querySelectorAll(".panel");
    const versions = [];
    
    panels.forEach(panel => {
        const titleLine = panel.querySelector("p:nth-of-type(1)");
        const contentLine = panel.querySelector("p:nth-of-type(4)");
           	
    	console.log(titleLine);
    	console.log(contentLine);
    	
        const title = titleLine ? titleLine.textContent.replace("Tiêu đề:", "").trim() : "";
        const content = contentLine ? contentLine.textContent.replace("Nội dung:", "").trim() : "";    
        versions.push({ title, content });
    });
    
    const acc = document.getElementsByClassName("accordion");
    for (let i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            this.textContent = this.textContent.startsWith("►")
                ? this.textContent.replace("►", "▼")
                : this.textContent.replace("▼", "►");
    
            const panel = this.nextElementSibling;
            panel.style.display = panel.style.display === "block" ? "none" : "block";
    
            if (i > 0) {
                const oldVersion = versions[i - 1];
                const newVersion = versions[i];
    
                const titleDiff = Diff.diffWords(oldVersion.title, newVersion.title);
                const contentDiff = Diff.diffWords(oldVersion.content, newVersion.content);
    
                const titleHTML = titleDiff.map(part => {
                    const color = part.added ? 'lightgreen' :
                        part.removed ? 'salmon' : 'transparent';
                    return `<span style="background-color:${color}">${part.value}</span>`;
                }).join('');
    
                const contentHTML = contentDiff.map(part => {
                    const color = part.added ? 'lightgreen' :
                        part.removed ? 'salmon' : 'transparent';
                    return `<span style="background-color:${color}">${part.value}</span>`;
                }).join('');
                
                console.log(titleHTML);
                console.log(contentHTML);
    
                const diffDiv = document.getElementById(`diff-${i + 1}`);
                if (diffDiv) {
                    diffDiv.innerHTML = `
                        <p><strong>So sánh tiêu đề:</strong><br>${titleHTML}</p>
                        <p><strong>So sánh nội dung:</strong><br>${contentHTML}</p>
                    `;
                }
            }
        });
    }
</script>