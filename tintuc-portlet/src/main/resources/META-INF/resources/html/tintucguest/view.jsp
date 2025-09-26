<%@include file="init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%if(ungdung.equals("chitiettintuc")){%>
<liferay-util:include page="/html/tintucguest/chitiettintuc/view.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("danhmuctintuc")){%>
<liferay-util:include page="/html/tintucguest/danhmuctintuc/view.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("danhsachchuyendong_psc")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/danhsachchuyendong_psc.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("danhsachtintucchuyendong_psc")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/danhsachtintucchuyendong_psc.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("khungtimkiem")){ %>
<liferay-util:include page="/html/tintucguest/timkiemviews/khungtimkiem.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("ketquatimkiem")){ %>
<liferay-util:include page="/html/tintucguest/timkiemviews/ketquatimkiem.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("lietketieude")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/lietketieude.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("danhsachtintuchinhanh")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/danhsachtintuc.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("viewsachmoi")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/viewsachmoi.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("tinnoibat")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/tinnoibat.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("dstinnoibatdautien")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/dstinnoibatdautien.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("slicktintuc")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/slicktintuc.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}else if(ungdung.equals("slidetintuc")){ %>
<liferay-util:include page="/html/tintucguest/danhsachviews/slidetintuc.jsp" servletContext="<%=this.getServletContext()%>"/>
<%}%>


