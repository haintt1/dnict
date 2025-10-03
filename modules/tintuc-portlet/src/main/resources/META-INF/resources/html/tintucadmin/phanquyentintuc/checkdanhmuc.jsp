<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
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
String id = ParamUtil.getString(request, "iduser");
//System.out.println(id);
List<News_Subcategories> listsubcat = TinTucAdminUtil.getSubCatByLang("", 0, 0, 0);
//System.out.println("listsubcat"+listsubcat + "chondanhmuc" + prefs.getValue("chondanhmuc",""));
//if(chondanhmuc.equals("checked")){
News_role role = null;
if(Validator.isNull(role)){
	role = PhanQuyenAdminUtil.getUserById(user.getUserId());
}
String[] category_id = null;
if(!role.getCategory_active_role().equals("")){
	category_id = role.getCategory_active_role().split("_");
}
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
				
				//selected = "checked";
		%>
			<ul class="danhmuc">
				<%for(int a = 0; a < listcategory.size(); a++){
					String selected = "";
					if(category_id != null && category_id.length > 0){
						for(int g = 0; g< category_id.length; g++){
							if(!category_id[g].equals("")){
								if(listcategory.get(a).getId() == Long.valueOf(category_id[g])){
									selected = "checked";
								}
							}
						}	
					}
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
		var name = ""
		var userId = "<%=id%>";
		var len = $('input[type="checkbox"]:checked').length;
			$('input[type="checkbox"]:checked').each(function(index, element) {
				data =  data+"_"+$(this).val();
				if(name == ""){
					name = name+$(this).attr("dataname");
				}else{
				   name = name+", "+$(this).attr("dataname");
				}
		    });	
		  Liferay.Util.getOpener().listchonnhieudanhmuc(data,userId,name);
		  Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

$('#closeButton').click(function(){
	Liferay.Util.getOpener().<portlet:namespace/>closePopup('<portlet:namespace/>dialog');
});

</aui:script>
