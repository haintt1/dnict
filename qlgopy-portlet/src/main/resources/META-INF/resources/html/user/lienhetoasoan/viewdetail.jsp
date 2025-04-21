<%@page import="vn.dnict.qlgopy.utils.DocumentUpload"%>
<%@page import="vn.dnict.qlgopy.model.GopY_DinhKem"%>
<%@page import="vn.dnict.qlgopy.service.HoiDapGopYLocalServiceUtil"%>
<%@page import="vn.dnict.qlgopy.model.HoiDapGopY"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@include file="../init.jsp" %>

<style>
.label2{
	width: 20%
}
</style>

<%
	long id = Long.valueOf(request.getParameter("id"));
	HoiDapGopY gopY = HoiDapGopYLocalServiceUtil.fetchHoiDapGopY(id);
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
%>
<portlet:renderURL var="backURL">
	<portlet:param name="jspPage" value="/html/user/lienhetoasoan/view.jsp"/>
</portlet:renderURL>

<div class="portlet-content-container">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
								<aui:form name="linkForm" method="POST" enctype="multipart/form-data">
									<h3>Nội dung câu hỏi</h3>
									<table class="tbcoreadmin table table-bordered">  
									  	<tr>
											<th class="key label2">Họ tên</th>
											<td colspan="3">
												<%=gopY.getName() %>
											</td>
											<aui:input name="id" type="hidden" value="<%=gopY.getId() %>"/>
										</tr>  	
										<tr>
											<th class="key label2">Email</th>
											<td colspan="3">
												<%=gopY.getEmail() %>
											</td>
										</tr>
										<tr>
											<th class="key label2">Ngày gửi</th>
											<td colspan="3">
												<%=df.format(gopY.getNgay_guigopy()) %>
											</td>
										</tr>
										<tr>
											<th class="key label2">Câu hỏi</th>
											<td colspan="3">
												<%=gopY.getTitle() %>
											</td>
										</tr>
										
										<tr>
									  		<th class="key">File đính kèm</th>
									  		<td class="pdflinktd" colspan="3">
												<%
													List<GopY_DinhKem> listfileDinhkem = new ArrayList<GopY_DinhKem>();
													listfileDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(gopY.getId(), 1);
													if(listfileDinhkem.size() > 0){
														int dem = 1;
														for(GopY_DinhKem file: listfileDinhkem){
												%>
													<a class="link_dow" href="<%=file.getUrl()%>" target="blank"><%=dem%>. <%=file.getTen()%></a><br/>
												<%dem++;
												}} %>
									  		</td>
									  	</tr>
									</table>
									<h3 style="margin-top: 40px">Nội dung trả lời</h3>
									<table class="tbcoreadmin table table-bordered">
										<tr>
											<th class="key label2">Ngày trả lời</th>
											<td colspan="3">
												<%=df.format(gopY.getNgay_traloigopy()) %>
											</td>
										</tr>
										<tr>
											<th class="key label2">Nội dung trả lời</th>
											<td colspan="3">
												<%=gopY.getAnswer() %>
											</td>
										</tr>
										<tr>
									  		<td colspan="4" style="text-align: center" class="key">
									  		<%
									  			String buttonBack = "Quay lại";
									  		%>
												<a href="<%=backURL%>"><aui:button value="<%=buttonBack %>"/></a>
									  		</td>
									  	</tr>
									</table>
								</aui:form>
							</div>
						</div>	
					</fieldset>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>