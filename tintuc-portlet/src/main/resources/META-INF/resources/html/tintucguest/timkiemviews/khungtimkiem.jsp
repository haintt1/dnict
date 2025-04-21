<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Khung tìm kiếm</title>
</head>
<style>
.timkiem-con {
display: block;
    box-sizing: border-box;
    text-align: left;
    background: rgba(204, 204, 204, 0.14);
    color: #444 !important;
    height: 0px;
    overflow: hidden;
    line-height: 30px;
    padding-left: 6px;
    -webkit-transition: height 0.5s; /* Safari */
    transition: height 0.5s;
}

 
a.show {
    height: 30px;
    -webkit-transition: height 0.5s; /* Safari */
    transition: height 0.5s;
}
</style>
<body>
<%
String placeHolder = "Nhập từ khóa";
if(langcheck.equals("en_US")){
	placeHolder = "Search";
}
%>
<form action="<%=search_page_iframe%>" method="get" name="frmSearch" class="frmSearch">
<input type="text" name="search" id="search" style="background: none;height: 12px;width:70%" placeholder="<%=placeHolder%>">
<a class="btn-search"><%=search_text%></a>
<a title="Tìm kiếm nâng cao" href="javascript:void(0)" class="btn-timkiemnangcao icon-caret-down"></a>
<a href="<%=search_page_iframe%>" class="timkiem-con timkiemnangcao-con">Tìm kiếm nâng cao &gt;&gt;</a>

</form>
</body>
</html>
<script>
var jQuerysearch = jQuery.noConflict();
jQuerysearch(document).ready(function(){
	jQuerysearch(".btn-search").click(function(){
		jQuerysearch(".frmSearch").submit();
	});
	jQuerysearch(".btn-timkiemnangcao").click(function(){
		jQuerysearch(".timkiemnangcao-con").toggleClass("show");
	});
});
</script>