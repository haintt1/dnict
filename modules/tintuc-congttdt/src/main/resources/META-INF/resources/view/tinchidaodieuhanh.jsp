<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
	<style type="text/css">
		.item-list-article-img img {
			width: 140px;
			height: auto;
		}

		.item-list-article-img {
			width: 140px;
			height: 90px;
			box-sizing: border-box;
			overflow: hidden;
		}

		.item-list-article-img {
			float: left;
			max-width: 15%;
		}

		.item-list-article-content {
			float: left;
		}

		.item-list-article:after {
			clear: both;
			display: block;
			content: "";
		}

		.item-list-article-content {
			padding-left: 20px;
			width: 83%;
		}

		span.title-item-article {
			font-weight: bold;
			font-size: 18px;
		}

		span.createdtime-item-article {
			display: block;
			font-size: 12px;
		}

	</style>
</head>
<body>
<%
    JSONArray dsTinTuc = (JSONArray) renderRequest.getAttribute("dsTinTuc");
%>

<% if (dsTinTuc != null && dsTinTuc.length() > 0) { %>
    <% for (int i = 0; i < dsTinTuc.length(); i++) {
        JSONObject tin = dsTinTuc.getJSONObject(i);
        String pubDate = tin.getString("pubDate");
        LocalDateTime dateTime = null;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        if (Validator.isNotNull(pubDate)) {
            dateTime = LocalDateTime.parse(pubDate, DateTimeFormatter.ISO_DATE_TIME);
        }
    %>
    <article class="the-list-article tichhop-portal">
        <section class="main-list-article">
            <div class="body-list-article">
                <div class="item-list-article" style="margin-top: 10px">
                    <div class="item-list-article-img">
                        <%
                            String hinhanh = tin.getString("image");
                            if (Validator.isNull(hinhanh)) {
                        %>
                            <img alt="" src="<%=request.getContextPath() + "/images/no_image.png" %>">
                        <% } else { %>
                            <img alt="" src="<%=hinhanh %>">
                        <% } %>
                    </div>
                    <div class="item-list-article-content">
                        <a href="<%=tin.getString("url")%>">
                            <span class="title-item-article"><%=tin.getString("title") %></span>
                        </a>
                        <% if (dateTime != null) { %>
                            <span class="createdtime-item-article"><%=dateTime.format(fmt)%></span>
                        <% } %>
                        <%
                            String mota = tin.getString("content");
                            if (mota.length() > 150) {
                                mota = mota.substring(0, 149) + "...";
                            }
                        %>
                        <%-- <p class="des-item-article"><%=mota %></p> --%>
                    </div>
                </div>
            </div>
        </section>
    </article>
    <% } %>

    <!-- Phân trang -->
    <div class="pagination">
        <%
	        int page1 = ParamUtil.getInteger(request, "page", 1);
	        int pageSize = ParamUtil.getInteger(request, "pageSize", 10);
	        int pagehientai = (Integer) renderRequest.getAttribute("page");

	        // Lấy URL hiện tại (có query string)
	        String currentUrl = PortalUtil.getCurrentURL(request);
	        // Cắt bỏ query string để giữ base URL
	        String baseUrl = currentUrl.split("\\?")[0];

	        String urlPrev = baseUrl + "?page=" + (page1 - 1 > 0 ? page1 - 1 : 1) + "&pageSize=" + pageSize;
	        String urlNext = baseUrl + "?page=" + (page1 + 1) + "&pageSize=" + pageSize;
        %>

        <a href="<%= urlPrev %>">Trang trước</a>
    	<span>Trang <%= pagehientai %></span>
    	<a href="<%= urlNext %>">Trang sau</a>
    </div>
<% } else { %>
    <p>Không có tin tức nào.</p>
<% } %>

</body>
</html>