<%@page import="java.time.LocalDate"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
</head>
<body>

<table class="table table-bordered tichhop-portal">
    <thead>
        <tr>
            <th>Số ký hiệu</th>
            <th>Ngày ban hành</th>
            <th>Hình thức</th>
            <th>Cơ quan ban hành</th>
            <th>Trích yếu</th>
            <th>Tệp đính kèm</th>
        </tr>
    </thead>
    <tbody>
        <%
            JSONArray dsVanBan = (JSONArray) renderRequest.getAttribute("dsTinTuc");
            if (dsVanBan != null) {
                for (int i = 0; i < dsVanBan.length(); i++) {
                    JSONObject vb = dsVanBan.getJSONObject(i);
                    String ngayBanHanh = vb.getString("ngayBanHanh");
                    LocalDateTime dateTime = LocalDateTime.parse(ngayBanHanh, DateTimeFormatter.ISO_DATE_TIME);
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        %>
        <tr>
            <td><%= vb.getString("soKyHieu") %></td>
            <td><%= dateTime.format(fmt) %></td>
            <td><%= vb.getString("hinhThucVanBan") %></td>
            <td><%= vb.getString("coQuanBanHanh") %></td>
            <td><%= vb.getString("trichYeu") %></td>
            <td>
                <%
                    JSONArray dsFile = vb.getJSONArray("dinhKems");
                    for (int j = 0; j < dsFile.length(); j++) {
                        JSONObject file = dsFile.getJSONObject(j);
                %>
                    <a href="<%=file.getString("fileDinhKem") %>"><%=file.getString("tenFile") %></a><br>
                <%
                    }
                %>
            </td>
        </tr>
        <%
                }
            } else {
        %>
            <tr><td colspan="6">Không có văn bản nào.</td></tr>
        <% } %>
    </tbody>
</table>

</body>
</html>