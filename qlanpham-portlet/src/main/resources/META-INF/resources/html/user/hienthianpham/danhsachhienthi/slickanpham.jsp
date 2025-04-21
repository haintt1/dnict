<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="qlanpham.portlet.utils.AnPhamGuestUtil"%>
<%@page import="qlanphamdb.model.AnPham_Loai"%>
<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick/slick.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick/slick-custom.css" />
<style>
.slider div {
	outline: none; /* Bỏ viền xanh khi click */
}

.slider img {
	width: 100%; /* Kích thước ảnh */
	height: 350px;
	transition: all 900ms ease;
}

.slick-center img {
	transform: scale(1.3); /* Phóng to ảnh giữa */
}
</style>
<div class="my-4">
	<div class="slider">
		<%
        	String[] selectedCategory = preferences.getValue("selectedCategory", "").split(",");
    		List<AnPham_Loai> listTL = AnPhamGuestUtil.listTheLoai();
    		List<AnPham_Loai> listTLDachon = listTL.stream()
                    .filter(tl -> ArrayUtil.contains(selectedCategory, String.valueOf(tl.getId())))
                    .collect(Collectors.toList());
    		for (AnPham_Loai tldc : listTLDachon) {
    			long idTL = tldc.getId();
				String tenksd = tldc.getTen();
        		int cur = ParamUtil.getInteger(request,"cur",1);
        		int news_on_page = Integer.valueOf(sotinhienthi);
        		int start = (cur - 1) * news_on_page;
        	    int end = start + news_on_page;
       	    	List<AnPham_TapChi> listTinByTL = AnPhamGuestUtil.listTapChiByTheLoai(idTL, start, end);
      			for(int j = 0; j < listTinByTL.size(); j++) {
      				String urlTitle = trangchitiet+"?dinhdanh="+listTinByTL.get(j).getId();
       	%>
		<div>
			<a href="<%=urlTitle%>">
				<img
				src="<%=listTinByTL.get(j).getAnhDaiDien() %>"
				alt="<%=listTinByTL.get(j).getTen()%>">
			</a>
		</div>
		<% }} %>
	</div>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/slick/slick.min.js"></script>
<script type="text/javascript">
	var jQuery = jQuery.noConflict();
	jQuery(document).ready(function(){
		jQuery('.slider').slick({
	      slidesToShow: 3,      // Số ảnh hiển thị cùng lúc
	      slidesToScroll: 1,    // Cuộn từng ảnh một
	      autoplay: false,       // Tự động chạy
	      autoplaySpeed: 2000,  // 2 giây đổi ảnh
	      arrows: false,        // Ẩn nút điều hướng
	      dots: false,          // Ẩn dấu chấm chỉ mục
	      centerMode: true,     // Hiệu ứng focus vào ảnh giữa
	      variableWidth: true,   // Ảnh có thể có kích thước khác nhau
	    });
	});
</script>