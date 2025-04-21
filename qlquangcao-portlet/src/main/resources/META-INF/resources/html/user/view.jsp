<%@page import="java.util.HashMap"%>
<%@page import="vn.dnict.qlquangcao.utils.QLQuangCaoAdminUtil"%>
<%@page import="vn.dnict.qlquangcao.model.BangQuangCao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ include file="init.jsp" %>

<%
	Map<String, List<BangQuangCao>> banners = new HashMap<>();
	String[] positions = {"banner_top", "banner_left", "banner_center", "banner_right", "banner_bottom"};
	for (String pos : positions) {
	    banners.put(pos, QLQuangCaoAdminUtil.listBannerQCGuest(pos));
	}
	request.setAttribute("banners", banners);
%>

<% if(ungdung.equals("viewdemo")) { %>
<jsp:include page="/html/user/danhsachhienthi/viewdemo.jsp"></jsp:include>
<% } else if(ungdung.equals("viewdemo2")) { %>
<jsp:include page="/html/user/danhsachhienthi/viewtest.jsp"></jsp:include>
<% } else if(ungdung.equals("qcdangdanhsach")) { %>
<jsp:include page="/html/user/danhsachhienthi/qcdangdanhsach.jsp"></jsp:include>
<% } else if(ungdung.equals("qcdangslide")) { %>
<jsp:include page="/html/user/danhsachhienthi/qcdangslide.jsp"></jsp:include>
<% } %>

