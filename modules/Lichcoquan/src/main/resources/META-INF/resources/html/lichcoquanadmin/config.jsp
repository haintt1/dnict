<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<portlet:defineObjects />

<portlet:actionURL var="cauhinhmaCoquanURL" name="cauhinhMacoQuan">
</portlet:actionURL>
<portlet:actionURL var="cauhinhtheoNgayURL" name="cauhinhtheoNgay">
</portlet:actionURL>
<portlet:actionURL var="dongboAllActionURL" name="dongboAllAction"/>

<div class="portlet-content-container">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in" id="Content" role="presentation">
							<div class="panel-body">
								<aui:form action="${cauhinhmaCoquanURL }" name="linkForm" method="POST">
									<table class="tbcoreadmin table table-bordered">
										<tr>
											<th  class="key label2">Mã cơ quan</th>
											<td>
												<input name="<portlet:namespace/>macoquanadmin" size="40" label="" value="<%=macoquanadmin%>">
													<validator name="required"></validator>
												</input>
											</td>
										</tr>
										<tr>
											<th  class="key label2">Key đơn vị</th>
											<td>
												<input name="<portlet:namespace/>organKey" size="40" label="" value="<%=organKey%>">
													<validator name="required"></validator>
												</input>
											</td>
										</tr>
										<tr>
											<td class="key label2">Cấu hình hiển thị đồng bộ dữ liệu</td>
											<td><input type="checkbox" name="<portlet:namespace/>dongbo" <%=dongbo%>></td>
										</tr>
										<tr>
											<th class="key label2">Không chạy chức năng tự động đồng bộ</th>
											<td><input type="checkbox" name="<portlet:namespace/>tudongdongbo" <%=tudongdongbo%>></td>
										</tr>
										<tr>
											<td class="key label2">
												<aui:button type="submit" value="Cấu hình"/>
											</td>
										</tr>
									</table>
								</aui:form>
								<aui:form action="${cauhinhtheoNgayURL }" name="linkForm" method="POST">
									<h3 class="row-fluid header smaller lighter blue" style="margin-bottom: 10px; margin-top: 10px">
										<span class="span7">Đồng bộ dữ liệu thủ công</span>
									</h3>
									<table class="tbcoreadmin table table-bordered">
										<tr>
											<th>Ngày cập nhật</th>
											<td>
												<div class="input-prepend">
												<%
													DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
													String tungay = "";
													Date now = new Date();
													tungay = df.format(now);
												%>
													<span class="add-on">Từ ngày</span>
													<input name="<portlet:namespace/>tungay" class="datepicker input-small"  value="<%=tungay%>"  type="text"></input>
												</div>
											</td>
										</tr>
										<tr>
											<td class="key label2">
												<aui:button type="submit" value="Đồng bộ"/>
											</td>
										</tr>
									</table>
								</aui:form>
								<aui:form action="${dongboAllActionURL }" name="linkForm" method="POST">
									<h3 class="row-fluid header smaller lighter blue" style="margin-bottom: 10px; margin-top: 10px">
										<span class="span7">Đồng bộ tất cả</span>
									</h3>
									<table class="tbcoreadmin table table-bordered">
										<tr>
											<th>Ngày cập nhật</th>
											<td>
												<div class="input-prepend">
												<%
													DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
													String tungay = "";
													Date now = new Date();
													tungay = df.format(now);
												%>
													<span class="add-on">Từ ngày</span>
													<input name="<portlet:namespace/>tungay" class="datepicker input-small"  value="<%=tungay%>"  type="text"></input>
												</div>
											</td>
										</tr>
										<tr>
											<td class="key label2">
												<%-- <aui:button type="submit" value="Đồng bộ tất cả"/> --%>
												<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
												<aui:button-row>
													<aui:button type="submit" name="dongBoSo" value="Đồng bộ cấp Sở"/>
    												<aui:button type="submit" name="dongBoPhuong" value="Đồng bộ cấp Phường"/>
												</aui:button-row>
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
<script type="text/javascript">
	$(document).ready(function($){
		$(".datepicker").datepicker({
			yearRange: '-80:+10'
		});
		$(".datepicker").mask("99/99/9999",{placeholder:"dd/mm/yyyy"});
	});
	function setTypeAction(value){
		var obj = $("#<portlet:namespace/>typeaction");
		obj.val(value);
	}
	var btnDongBoSo = $("#<portlet:namespace/>dongBoSo");
	btnDongBoSo.on('click',function(event){
		setTypeAction("dongBoSo");
	
	});
	var btnDongBoPhuong = $("#<portlet:namespace/>dongBoPhuong");
	btnDongBoPhuong.on('click',function(event){
		setTypeAction("dongBoPhuong");
	
	});
</script>