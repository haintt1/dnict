<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="init.jsp"%>

<body style="background: #f1f2f5;">
<div class="containerlibcat">
<%
List<News_Subcategories> listsubcat = TinTucAdminUtil.getSubCatByLang(renderRequest, checkLangNews, "", 0, 0, 0);
//System.out.println("listsubcat"+listsubcat + "chondanhmuc" + prefs.getValue("chondanhmuc",""));
//if(chondanhmuc.equals("checked")){
%>
<ul class="libdanhmuc">
<%for(int i = 0;i< listsubcat.size(); i++){%>
	<li>
		<h5 class="thuvien-item">
			<%=listsubcat.get(i).getName()%>
		</h5>
		<%
			List<News_Categories> listcategory = TinTucAdminUtil.getNews_CategoriesByIdSubCat(renderRequest, listsubcat.get(i).getId(), "", 0, 0);
			if(listcategory.size() > 0){
				String selected = "";
				//selected = "checked";
		%>
			<ul class="danhmuc">
				<%for(int a = 0; a < listcategory.size(); a++){
					
				%>
					
				
					<li>
						<div class="lib-item">
							<input class="checkbox_ip" name="<portlet:namespace/>_checkbox" id="checkbox_<%=listcategory.get(a).getId()%>" value="<%=listcategory.get(a).getId()%>" type="checkbox" dataname="<%=listcategory.get(a).getName()%>" <%=selected%>/>
							<label for="checkbox_<%=listcategory.get(a).getId()%>"><%=listcategory.get(a).getName()%></label>
						</div>
					</li>
				<%}%>
			</ul>
		
			
		<%} %>
	</li>
	
<%}%>
</ul>
<tr>
			
	<td colspan="2" class="key" style="text-align: center;">
		<div style="display:center;">
			<button id="btnChondanhmuc" type="submit">Chọn danh mục</button>
			<button id="closeButton" class=" btn-danger" style="height:40px !important;">Đóng</button>
		</div>
	</td>
				
</tr>
</div>
</body>
<!-- For Closing -->
<aui:script>
$('#btnChondanhmuc').click(function(){
		var chk = $(".chuyenmuc-multiple-selected");
		var data ="";
		var name = "";
		var len = $('input[type="checkbox"]:checked').length;
			$('input[type="checkbox"]:checked').each(function(index, element) {
				data =  data+"_"+$(this).val();
				if(name == ""){
					name = name+$(this).attr("dataname");
				}else{
				   name = name+", "+$(this).attr("dataname");
				}
		    });	
		  Liferay.Util.getOpener().listchonnhieudanhmuc(data,name);
		  Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

$('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});
</aui:script>
