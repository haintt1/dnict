<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="vn.dnict.tintuc.model.News_Type"%>
<%@page import="vn.dnict.tintuc.model.News_Activity"%>
<%@page import="vn.dnict.tintuc.model.News_AttachFile"%>
<%@page import="vn.dnict.tintuc.utils.PhanQuyenAdminUtil"%>
<%@page import="vn.dnict.tintuc.model.News_role"%>
<%@ taglib prefix="liferay-editor" uri="http://liferay.com/tld/editor" %>
<%@page import="vn.dnict.tintuc.service.News_ArticleLocalServiceUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Article2Category"%>
<%@page import="vn.dnict.tintuc.model.News_Article"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="vn.dnict.tintuc.utils.DocumentUpload"%>
<%@page import="java.util.List"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.nodes.Element"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="vn.dnict.tintuc.model.News_Subcategories"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@include file="init.jsp" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.datetimepicker.css"/>
<script src="<%=request.getContextPath() %>/js/jquery1.10.2.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.datetimepicker.full.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String noidung = "";
String noidungfirst ="";
String noidunglast ="";
String theloaibaiviet = ParamUtil.getString(request, "theloai", "-1");
String id = ParamUtil.getString(request, "id");
News_Activity objectActivity  = null;
News_Article objNews = (News_Article) News_ArticleLocalServiceUtil.fetchNews_Article(Long.valueOf(id));

if(objNews.getContent() != null){
	noidung  = objNews.getContent();
	Document doc 	= Jsoup.parse(noidung);
	Element contentDiv 	  = doc.select("div[class=contentfirst]").first();
	
	Element contentDivtwo = doc.select("div[class=contentlast]").first();
	if(Validator.isNotNull(contentDiv)){
		noidungfirst = contentDiv.html();	
	}
	if(Validator.isNotNull(contentDivtwo)){
		noidunglast  = contentDivtwo.html();								
	}
}

boolean checkYeucauHieuChinh = false;
boolean checkCategoryOfUser = false;
if(Validator.isNotNull(objNews)){
checkYeucauHieuChinh= TinTucAdminUtil.checkYeuCauHieuChinhByUserIdAnd(themeDisplay.getUserId(), objNews.getId());
//System.out.println(checkYeucauHieuChinh);

checkCategoryOfUser = TinTucAdminUtil.checkCategoryOfUser(themeDisplay.getUserId(), objNews.getId());
objectActivity 		= TinTucAdminUtil.getNewAtivityById(themeDisplay.getUserId(), objNews.getId());
}
String tomtat ="";
String tacgia = "";
String xuatban = "";

if(objNews.getInfo() != null){
	tomtat = objNews.getInfo(); 
	Document doc 	= Jsoup.parse(tomtat);
	Element contentDiv 	  = doc.select("span[class=authorinfo]").first();
	Element contentDivtwo = doc.select("span[class=publishinfo]").first();
	if(Validator.isNotNull(contentDiv)){
		tacgia = contentDiv.html();	
	}
	if(Validator.isNotNull(contentDivtwo)){
		xuatban = contentDivtwo.html();	
	}
}
//System.out.print(ParamUtil.getString(httpServletRequest, ""))
%>
<portlet:actionURL name="updateBooksPDF" var="updateBooksPDFURL">
</portlet:actionURL>
<portlet:renderURL var="checkchuyenmucURL" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="id" value="<%= String.valueOf(objNews.getId()) %>" />
	<portlet:param name="jspPage" value="/html/tintucadmin/books/chondanhmucedit.jsp" />
</portlet:renderURL>
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/tintucadmin/books/view.jsp" />
	<portlet:param name="tabs" value="Đăng tin" />
</portlet:renderURL>

<body style="background: #f1f2f5;">
<nav class="management-bar management-bar-light navbar navbar-expand-md" style="background: #f1f2f5;">
<div class="container-fluid container-fluid-max-xl">
<div class="portlet-content-container" style="width: 100%">
	<div class="portlet-body">
		<div class="container-fluid-1280">
			<div class="card-horizontal main-content-card">
				<div aria-multiselectable="true" class="panel-group" role="tablist">
					<fieldset aria-labelledby="Title" class=" " role="group">
						<div aria-labelledby="Header" class="in  " id="Content" role="presentation">
							<div class="panel-body">
							<aui:form name="frmAddNews" action="<%=updateBooksPDFURL.toString()%>" method="post" enctype="multipart/form-data">
								<table class="tbcoreadmin" style="width: 100%">
								<tr>
									<td colspan="100">
										<label class="control-label">Tiêu đề sách</label>
										<aui:input type="hidden" name="id" value="<%=objNews.getId() %>"/>
										<input type="hidden" name="<portlet:namespace/>idNews" value="<%=objNews.getId() %>"/>
										<input type="hidden" name="<portlet:namespace/>typeaction" id="<portlet:namespace/>typeaction" value=""/>
										<aui:input name="title" value="<%=objNews.getTitle() %>" label="" type="input">
											<aui:validator name="required"></aui:validator>
											<aui:validator name="maxLength">500</aui:validator>
										</aui:input>
									</td>
								</tr>
								<tr>
										<%
											String check = "";
											String check_flipbook = "";
											if(objNews.getLoaitintuc() == 5 ){
												check = "checked";
											}
											if(objNews.getLoaitintuc() == 7){
												check_flipbook =  "checked";
											}else{
												check_flipbook = "";
											}
										
										%>
										<td colspan="100">
									<!-- 		<div class="form-group-pm" style="padding-bottom: 15px;">
												<input id="chukyso" class="check_chukyso"  name="<portlet:namespace/>loaitintuc" type="checkbox" <%=check%>> <label class="chukyso" style="display: initial;" for="chukyso">PDF ký số</label>
												</div> -->
												<div class="form-group-pm" style="padding-bottom: 15px;">
													<input id="flipbook" class="check_flipbook"  name="<portlet:namespace/>flipbook" type="checkbox" <%=check_flipbook%>> </input><label class="flipbook" style="display: initial;" for="flipbook">Đăng tin PDF dạng lật sách</label>
											</div>
										</td>
									</tr>
								<%	
										List<News_AttachFile> listImage = DocumentUpload.getLinkImagebyIdAndObject(objNews.getId(), 10);															
										String  idimage = "";
										String urlDomain="";
										if(listImage.size() > 0){
										 	for(int i = 0; i< listImage.size(); i++){									 			
										 			idimage = String.valueOf(listImage.get(i).getId());
										 			String[] arStr = listImage.get(i).getUrl().split("documents");
											 		if(arStr[0].toString().length()<3){
												 		urlDomain=themeDisplay.getPortalURL() + themeDisplay.getPathContext();												 		
											 		}else{
											 			urlDomain="";
											 		}
										%>
										<portlet:actionURL name="deleteImage" var="deleteImageURL">
 											<portlet:param name="id" value="<%=String.valueOf(listImage.get(i).getId()) %>"/>
											<portlet:param name="idNews" value="<%=String.valueOf(objNews.getId()) %>"/>
										</portlet:actionURL>
								<tr>
									<td colspan="100" style="padding-top:10px">	
										<label class="control-label">Ảnh đại diện của sách</label>										
										<div id="loading">
											<aui:input name="idfile" type="hidden" value="<%=listImage.get(i).getId()%>"></aui:input>
											<aui:input name="idnews" type="hidden" value="<%=objNews.getId()%>"></aui:input>
											<aui:input name="flag" type="hidden" value="<%=request.getAttribute("flag")%>"></aui:input>			 								
											<img style="height:100px" src="<%=urlDomain + listImage.get(i).getUrl()%>"/>
											<a id="btndelete" href="javascript:void(0)" att-url="<%=deleteImageURL %>" class="fa fa-delete"><img style="width: 14px;" alt="" src="<%= request.getContextPath()%>/images/delete.ico"/></a>
											<aui-spinner size="small"></aui-spinner>
										</div>
									</td>
								</tr>
										<%}}else{%>		
								<tr><td>	
										<label class="control-label">Ảnh đại diện của sách</label>				
										<input type="file" name="<portlet:namespace/>fileimage" id="fileimage" onchange="ValidateImage(this);"/>
									</td>
								</tr>	
								<%}%>
								<aui:input type="hidden" name="<portlet:namespace/>imagecheck" value="<%=idimage%>"></aui:input>
								<tr>
									<td colspan="100">											
										<div class="twocolumn1">
											<label class="control-label">Tác giả</label>
											<aui:input name="tacgia" label="" value="<%= tacgia%>" type="input"></aui:input>
										</div>
										<div class="twocolumn2">
											<label class="control-label">Nhà xuất bản</label>
											<aui:input name="xuatban" label="" value="<%= xuatban%>" type="input"></aui:input>
										</div>	
									</td>
								</tr>
											
									<tr>
										<td colspan="100" style="padding-bottom: 20px;">
												<label for="danhmuc-multiple-selected">Danh mục sách</label>
												<a class="btn btn-primary" id="btnChuyenmuc"><i class="icon-plus"></i> Chọn danh mục</a>
												<span class="listdanhmuc">
													<%
													String data_category = "";
													News_Categories cats=null;
													List<News_Article2Category> listart2Cat = TinTucAdminUtil.getListArticle2CategoryByArticleId(objNews.getId());
													
													if(listart2Cat.size() > 0){
														String listname = "";
														for(int c = 0; c < listart2Cat.size(); c++){
															News_Categories cat = News_CategoriesLocalServiceUtil.fetchNews_Categories(listart2Cat.get(c).getNewcategoryId());
															if(Validator.isNull(cat)){
																cat = cats;
															}
															data_category = data_category+"_"+cat.getId();
															if(listname.equals("")){
																listname = listname+cat.getName();
															}else{
																listname = listname+", "+cat.getName();;
															}
														}%>
														<div style="background: rgba(179,225,249,0.47); padding: 10px;margin-top: 5px;">
														<%=listname%>
														</div>	
													<%}else{%>
														Chưa chọn chuyên mục
													<%}%>
												</span>
												<input class="data_category" type="hidden" name="<portlet:namespace/>danhmuc-selected" value="<%=data_category%>"/>
										</td>	
									</tr>
									 
									<tr>
										<td>
											<label class="control-label">Giới thiệu về sách</label>
											<liferay-ui:input-editor toolbarSet="slimmed" editorImpl="editor.wysiwyg.default" name="noidung" initMethod="initEditor"></liferay-ui:input-editor>
										</td>
									</tr>
									<%
									
										
										List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(objNews.getId(), 9);
										String  idpdf = "";
										String urlDomainPDF="";
										if(listDinhkem.size() > 0){
										 	for(int i = 0; i< listDinhkem.size(); i++){		
										 			idpdf = String.valueOf(listDinhkem.get(i).getId());
										 			String[] arStr = listDinhkem.get(i).getUrl().split("documents");										 		
											 		if(arStr[0].toString().length()<3){
											 			urlDomainPDF=themeDisplay.getPortalURL() + themeDisplay.getPathContext();
											 		}else{
											 			urlDomainPDF="";
											 		}
										%>
										<portlet:actionURL name="deleteFilePDF" var="deleteFilePDFURL">
 											<portlet:param name="id" value="<%=String.valueOf(listDinhkem.get(i).getId()) %>"/>
											<portlet:param name="idNews" value="<%=String.valueOf(objNews.getId()) %>"/>
										</portlet:actionURL>
									 <tr>
											<td colspan="100">
												<label class="control-label">Đính kèm sách điện tử (file PDF):</label>
												<div id="loading">
												<aui:input name="idfile" type="hidden" value="<%=listDinhkem.get(i).getId()%>"></aui:input>
												<aui:input name="idnews" type="hidden" value="<%=objNews.getId()%>"></aui:input>
												<aui:input name="flag" type="hidden" value="<%=request.getAttribute("flag")%>"></aui:input>
												<a class="filedinhkem" href="<%= urlDomainPDF + listDinhkem.get(i).getUrl()%> "><%=listDinhkem.get(i).getTen()%></a> 
												- <a id="btndeletepdf" href="javascript:void(0)" att-url="<%=deleteFilePDFURL %>" class="fa fa-delete"><img style="width: 14px;" alt="" src="<%= request.getContextPath()%>/images/delete.ico"/></a>
												<aui-spinner size="small"></aui-spinner>
												</div>							
											</td>
										</tr>	
										<%}}  else{%>
								<tr>
									<td colspan="100" style="padding-bottom: 20px;">
									<label class="control-label">Đính kèm sách điện tử (file PDF):</label>
									<input type="file" name="<portlet:namespace/>filePDF" id="filePDF" multiple="multiple" onchange="ValidateSingleInputPDF(this);"/>
									</td>
									
								</tr>
							<%}%>
									<input type="hidden" name="<portlet:namespace/>pdfcheck" value="<%=idpdf%>"/>
									<tr>
										<td>
											<label class="control-label">Giới thiệu thêm về sách</label>
											<liferay-ui:input-editor toolbarSet="slimmed" editorImpl="editor.wysiwyg.default" name="noidunglast" initMethod="initEditorLast"></liferay-ui:input-editor>
										</td>
									</tr>
									<tr>
										<td>
										<div class="twocolumn1">											
												<label class="control-label">Thể loại</label>
												<select class="form-control"  id="theloai" name='<portlet:namespace/>theloai'>
												<option value="-1">---Chọn thể loại---</option>
									     		<%
									     			List<News_Type> objType = TinTucAdminUtil.listTheLoai("", 0, 0, 0);
									     			if(objType.size() > 0){
									     				for(int s=0; s < objType.size(); s++){
									     					String selected = "";
									     					if(objNews.getTypeid() == objType.get(s).getId()){
									     						selected = "selected";
									     					}
									     		%>
									     		<option value="<%=objType.get(s).getId()%>" <%=selected %>><%=objType.get(s).getName()%></option>
									     		<%
									     				}
									     			}
									     		%>
												</select>
											
										</div>
										<div class="twocolumn2">					
											<label class="control-label">Ngày đăng</label>
											<%DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); %>
											<input name='<portlet:namespace/>ngayxuatban' id="ngayxuatban" value="<%=df.format(objNews.getCreatedtime())  %>"  type="text" class="form-control"></input>
										</div>
										</td>	
									</tr> 
									 
									<tr>
										<td>
											<label class="control-label">Ngôn ngữ</label>
											<select class="form-control"  id="languages" name='<portlet:namespace/>languages'>
									     		<option value="vi_VN" <%=checkLangNews.equals("vi_VN")?"selected":""%>>Tiếng việt (Mặc định)</option>
									     		<option value="en_US" <%=checkLangNews.equals("en_US")?"selected":""%>>Tiếng Anh</option>
									     	</select>
											
										</td>	
									</tr>
									<tr style="margin-top: 5px !important;display: grid;">
										<td colspan="2" class="key" style="text-align: center; margin-top: 5px;">
											<aui:button cssClass="btn-pm btn-submit-pm" name="pheduyet" type="submit" value="Xuất bản" label=""></aui:button>
											<a href="<%=cancelURL.toString()%>"><aui:button type="cancel" value="Quay lại" /></a>										
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
</div>
</nav>	
</body>
</html>
<style>
	.addhtml{background: }
	.dropbtn{margin: 0; padding: 0}
	.dropdown-content{margin: 0; padding: 0;}
	
#languages {
    background-repeat: no-repeat;
    background-image: url("/o/vn.dnict.tintuc/images/flag/vi_VN.png");
    padding-right: 20px;
}
#languages option:nth-child(1) {
    background: url(/o/vn.dnict.tintuc/images/flag/vi_VN.png) no-repeat right center;  
}
#languages option:nth-child(2) {
    background: url(/o/vn.dnict.tintuc/images/flag/en_US.png) no-repeat right center;  
}
#languages option:nth-child(3) {
    background: url(/o/vn.dnict.tintuc/images/flag/ja_JP.png) no-repeat right center;  
}
#languages option:nth-child(4) {
    background: url(/o/vn.dnict.tintuc/images/flag/ko_KR.png) no-repeat right center;  
}
.mota{height: 125px !important;}
.tinnoibat{
	margin-top: 15px !important;
}
a.cke_combo_button{
margin: 0px !important;
padding: 0px !important;
padding-top: 8px !important;
    margin-left: 10px !important;
}
.twocolumn1{
	width: 50%;
	display: block;
	float: left;
	padding-right: 5px;
}
.twocolumn2{
	width: 50%;
	display: block;
	float: left;
	padding-left: 5px;
}
</style>
<script type="text/javascript">
function <portlet:namespace />initEditor(){
    return "<%=UnicodeFormatter.toString(noidungfirst)%>";
}
function <portlet:namespace />initEditorLast(){
    return "<%=UnicodeFormatter.toString(noidunglast)%>";
}
function setTypeAction(value){
	var obj = $("#<portlet:namespace/>typeaction");
	obj.val(value);
}

$('#ngayxuatban').datetimepicker({
	formatTime:'H:i',
	format:'d/m/Y H:i',
	formatDate:'Y/m/d',
	timepickerScrollbar:true
});

$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
$("select#languages").change(function(){
$("select#languages").css("background-image",'url(/o/vn.dnict.tintuc/images/flag/'+$("select#languages").val()+'.png)');
});
</script>
<aui:script>
$('#btndelete').click(function(){
	var A = AUI();
	
	var url = $(this).attr('att-url')
	AUI().use('aui-io-request','aui-loading-mask-deprecated', function(A){
		var loadingMask = new A.LoadingMask({
				'strings.loading' : 'This is my custom loading message',
				target : A.getBody()
		});
		loadingMask.show();	
		alert("Xóa file đính kèm. Hệ thống sẽ hiển thị thông báo nếu xóa thành công");
		A.io.request(
	    url,
	      {
	        on: {  
	          success: function() {
	          		loadingMask.hide();
	          		alert("Xóa thành công");
	          		Liferay.Util.getOpener().<portlet:namespace/>refreshPortlet();
	          }
	        }
	      }
	    )
	});
});
$('#btndeletepdf').click(function(){
	var A = AUI();
	
	var url = $(this).attr('att-url')
	AUI().use('aui-io-request','aui-loading-mask-deprecated', function(A){
		var loadingMask = new A.LoadingMask({
				'strings.loading' : 'This is my custom loading message',
				target : A.getBody()
		});
		loadingMask.show();	
		alert("Xóa file đính kèm. Hệ thống sẽ hiển thị thông báo nếu xóa thành công");
		A.io.request(
	    url,
	      {
	        on: {  
	          success: function() {
	          		loadingMask.hide();
	          		alert("Xóa thành công");
	          		Liferay.Util.getOpener().<portlet:namespace/>refreshPortlet();
	          }
	        }
	      }
	    )
	});
});

</aui:script>
<aui:script position="inline">
$('#btnChuyenmuc').click(function(){
		Liferay.Util.openWindow(
			{
			dialog: {
	           centered: true,
	           height: 600,
	           modal: true,
	           width: 870
	        },
	        id: '<portlet:namespace/>dialog',
	        title: 'Chọn chuyên mục hiển thị',
	        uri: '<%= checkchuyenmucURL.toString()%>'
			});
	});
	

Liferay.provide(window, '<portlet:namespace/>refreshPortlet', function() {
        var curPortlet = '#p_p_id<portlet:namespace/>';
        Liferay.Portlet.refresh(curPortlet);
    },['aui-dialog','aui-dialog-iframe']);
    
Liferay.provide(window, '<portlet:namespace/>closePopup', function(dialogId) {
		var A = AUI();
		var dialog = Liferay.Util.Window.getById(dialogId);
			dialog.destroy();
	},['liferay-util-window']);	
	<!-- Truyen bien tu popup sang view chinh -->
Liferay.provide(window, 'listchonnhieudanhmuc', function(data, name) {
        $(".data_category").val(data);
        $(".listdanhmuc").html(name);
	},['liferay-util-window']);

Liferay.provide(window, 'yeucauhieuchinh', function() {
		window.location.href = '<%=cancelURL%>'		
	},['liferay-util-window']);
	
AUI().ready('aui-form-validator', 'aui-overlay-context-panel','aui-node', function(A) {
	
    var btnPheduyet = $("#<portlet:namespace/>pheduyet");
	btnPheduyet.on('click',function(event){
    		setTypeAction("xuatban");
    });
    
});
Liferay.on('form:registered', function(event) {
	window.validator<portlet:namespace /> = event.form.formValidator;});
</aui:script>


