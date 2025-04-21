<%@ include file="../init.jsp" %>

<div class="col-auto">
    <select class="form-control" id="sotapchi">
        <option value="">Số tạp chí</option>
        <%
       		List<AnPham_TapChi> listTenTapChi = AnPhamGuestUtil.listTenTapChi(3, 0);
        	for (AnPham_TapChi ttc : listTenTapChi) {
        %>
        <option value="<%=ttc.getId()%>" data-name="<%=ttc.getTen()%>"><%=ttc.getTen() %></option>
        <% } %>
        <option value="">Số cũ hơn</option>
    </select>
</div>
<div class="col-auto">
	<button id="btnSearch" class="btn search-btn">Tìm kiếm</button>
</div>

<script type="text/javascript">
   $('#btnSearch').click(function(){
		const sotapchi = document.getElementById("sotapchi").value
   		if(sotapchi) {
        	url += '?sotapchi=' + sotapchi;
    	}
		window.location.href = url;
	});
</script>

<!-- output: http://localhost:9090/tim-kiem?sotapchi=101 -->

<%
	HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(request);
	String sotapchi = httpServletRequest.getParameter("sotapchi");
%>

<!-- output: 101 -->