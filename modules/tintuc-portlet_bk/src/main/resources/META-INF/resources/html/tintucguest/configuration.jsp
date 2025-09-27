<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="vn.dnict.tintuc.model.News_Categories"%>
<%@page import="java.util.List"%>
<%@page import="vn.dnict.tintuc.utils.TinTucAdminUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@include file="init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<liferay-ui:success key="save-successfully" message="Đã lưu ! Sẽ có hiệu lực sau khi Refresh trang"></liferay-ui:success>

<form action="<liferay-portlet:actionURL portletConfiguration="true"/>" method="post" name='<portlet:namespace/>fm'>
 	<input name='<portlet:namespace/><%=Constants.CMD%>' type="hidden" value="<%=Constants.UPDATE%>"/>
	<table class="table table-bordered">
		<tr>
		 	<th class="keycolor">Ngôn ngữ</th>
			<td colspan="3">
 				<label for="ngonngu">Ngôn ngữ bài viết</label>
 				<select id="ngonngu" name='<portlet:namespace/>ngonngu'>
 	     			<option value="vi_VN" <%=langcheck.equals("vi_VN")?"selected":""%>>Việt Nam</option>
 	     			<option value="en_US" <%=langcheck.equals("en_US")?"selected":""%>>Tiếng Anh</option> 	     
	 	     	</select>
			</td>
		</tr>
		<tr>
		    <th class="keycolor">Ứng dụng</th>
		     <td colspan="3">
		     	<select name='<portlet:namespace/>ungdung'>
		     		<option value="-1">--Chọn ứng dụng--</option>
		     		<option value="chitiettintuc" <%=ungdung.equals("chitiettintuc")?"selected":""%>>Chi tiết tin tức</option>
		     		<option value="danhmuctintuc" <%=ungdung.equals("danhmuctintuc")?"selected":""%>>Danh sách tin tức</option>
		     		<option value="tinnoibat" <%=ungdung.equals("tinnoibat")?"selected":""%>>Tin nổi bật</option>
		     		<option value="dstinnoibatdautien" <%=ungdung.equals("dstinnoibatdautien")?"selected":""%>>Danh sách tin tức (nổi bật tin đầu tiên)</option>
		     		<option value="slicktintuc" <%=ungdung.equals("slicktintuc")?"selected":""%>>Danh sách tin dạng slick</option>
		     		<option value="slidetintuc" <%=ungdung.equals("slidetintuc")?"selected":""%>>Danh sách tin dạng slide</option>
		     		<option value="lietketieude" <%=ungdung.equals("lietketieude")?"selected":""%>>Danh sách tiêu đề tin tức</option>
		     		<option value="danhsachtintuchinhanh" <%=ungdung.equals("danhsachtintuchinhanh")?"selected":""%>>Danh sách tin tức hình ảnh</option>
		     		<option value="danhsachchuyendong_psc" <%=ungdung.equals("danhsachchuyendong_psc")?"selected":""%>>Danh sách tin tức chuyển động (ngày tháng)</option>
		     		<option value="danhsachtintucchuyendong_psc" <%=ungdung.equals("danhsachtintucchuyendong_psc")?"selected":""%>>Danh sách tin tức hình ảnh chuyển động</option>
		     		<option value="viewsachmoi" <%=ungdung.equals("viewsachmoi")?"selected":""%>>Danh sách sách mới</option>
		     		<option value="hienthilatsach" <%=ungdung.equals("hienthilatsach")?"selected":""%>>Hiển thị lật sách</option>
		     		<option value="khungtimkiem" <%=ungdung.equals("khungtimkiem")?"selected":""%>>Khung tìm kiếm</option>
		     		<option value="ketquatimkiem" <%=ungdung.equals("ketquatimkiem")?"selected":""%>>Kết quả tìm kiếm</option>
		     	</select>
		    </td>
		</tr>
		<tr>
			<td colspan="4">
				<%
					List<News_Categories> list_category = TinTucAdminUtil.getNews_CategoriesByIdSubCatLang(renderRequest, langcheck, null, "", 0, 0);
					String[] listCategoryId = category_active.split("_");
					//System.out.print(request.getContextPath());
					for(int c = 0;c<list_category.size();c++){
						String checked = "";
						for(int g = 1; g< listCategoryId.length;g++){
							if(Long.valueOf(listCategoryId[g])==list_category.get(c).getId()){
								checked = "checked";
							}
						}
				%>
					<span class="check_item" style="margin-right: 5px;">
						<input class="check_in" name="<portlet:namespace/>category_<%=list_category.get(c).getId()%>" data="<%=list_category.get(c).getId()%>" type="checkbox" <%=checked%>/> <%=list_category.get(c).getName()%>
					</span>
				<%}%>
			</td>
		</tr>
		<tr>
			<th class="keycolor">Ẩn/Hiện Tên danh mục (danh sách tin tức)</th>
			<%
				String hide_category_checked = "";
				if(category_hide.equals("1")){
					hide_category_checked = "checked";
				}
			%>
			<td><input name="<portlet:namespace/>category_hide" type="checkbox" <%=hide_category_checked%>/></td>
			<th class="keycolor">Hiện chức năng xem thêm (danh sách tin tức hình ảnh)</th>
			<%
				String hienthixemthem_check = "";
				if(hienthixemthem.equals("on")){
					hienthixemthem_check = "checked";
				}
			%>
			<td><input name="<portlet:namespace/>hienthixemthem" type="checkbox" <%=hienthixemthem_check%>/></td>
		</tr>
		<tr>
			<th class="keycolor">Số tin liên quan hiển thị</th>
		    <td><input type="text" name="<portlet:namespace/>sotinlienquanhienthi" value="<%=sotinlienquanhienthi%>"/></td>
			<th class="keycolor">Ẩn/hiện hình ảnh nhỏ</th>
			<%
				String newimg_check = "";
				if(newimg.equals("1")){
					newimg_check = "checked";
				}
			%>
			<td colspan="3"><input name="<portlet:namespace/>newimg" type="checkbox" <%=newimg_check%>/></td>
			
		</tr>
		<tr>
		    <th class="keycolor">Số lượng tin hiển thị (danh sách tin tức)</th>
		     <td>
		     	<input type="text" name="<portlet:namespace/>sotinhienthi" value="<%=sotinhienthi%>"/>
		    </td>
		    <th class="keycolor">Tốc độ chạy slider</th>
		     <td>
		     	<input type="text" name="<portlet:namespace/>tocdoslide" value="<%=tocdoslide%>"/>
		    </td>
		</tr>
		<tr>
			<th class="keycolor">Độ dài tiêu đề</th>
			<td><input type="text" name="<portlet:namespace/>dodaitieude" value="<%=dodaitieude%>"/></td>
			<!-- code 2/1/2017 -->
			<th class="keycolor">Tiêu đề tin tức (TA,ĐIỂM TIN)</th>
			<td><input type="text" name="<portlet:namespace/>tieudetintuc" value="<%=tieudetintuc%>"/></td>
			<!-- end code 2/1/2017 -->
		</tr>
		<tr>
			<th class="keycolor">Độ dài tiêu đề tin liên quan</th>
			<td><input type="text" name="<portlet:namespace/>dodaitieudetinlienquan" value="<%=dodaitieudetinlienquan%>"/></td>
			<th class="keycolor">Chiều cao khung tin nổi bật (KHCN)</th>
			<td><input type="text" name="<portlet:namespace/>chieucaokhungnoibat" value="<%=chieucaokhungnoibat%>"/></td>
		</tr>
		<tr>
			<th class="keycolor">Độ dài mô tả</th>
			<td><input type="text" name="<portlet:namespace/>dodaimota" value="<%=dodaimota%>"/></td>
			<th class="keycolor">Ẩn/ hiện icon tin mới</th>
		    <%
				String iconnew_check = "";
				if(iconnew.equals("1")){
					iconnew_check = "checked";
				}
			%>
			<td colspan="3"><input name="<portlet:namespace/>iconnew" type="checkbox" <%=iconnew_check%>/></td>
		</tr>
		<tr>
			<th class="keycolor">Độ dài mô tả tin liên quan</th>
			<td><input type="text" name="<portlet:namespace/>dodaimotatinlienquan" value="<%=dodaimotatinlienquan%>"/></td>
			<th class="keycolor">Ẩn/ hiện link xem tiếp</th>
			<%
				String hide_readmore_checked = "";
				if(readmore_hide.equals("1")){
					hide_readmore_checked = "checked";
				}
			%>
			<td><input name="<portlet:namespace/>readmore_hide" type="checkbox" <%=hide_readmore_checked%>/></td>
		</tr>
		<tr>
			<th class="keycolor">Trang hiển thị chi tiết</th>
			<td><input type="text" name="<portlet:namespace/>trangchitiet" value="<%=trangchitiet%>"/></td>
<!-- 		<th class="keycolor">Ẩn tóm tắt tin tức đầu tiên (Tin hình ảnh tab TT KHCN)</th>
			<%
				String hide_tomtat_dt_checked = "";
				if(des_hide_dt.equals("1")){
					hide_tomtat_dt_checked = "checked";
				}
			%>
			<td><input name="<portlet:namespace/>des_hide_dt" type="checkbox" <%=hide_tomtat_dt_checked%>/></td> -->
			<th class="keycolor">Tên class (danh sách tin tức HA)</th>
			<td><input type="text" name="<portlet:namespace/>tenclass" value="<%=tenclass%>"/></td>
		</tr>
		
		
		
		
		<tr>
			<th colspan="4">
				<h3>Cấu hình chức năng chi tiết tin tức</h3>
			</th>
		</tr>
		<tr>
			<th class="keycolor">Kiểu hiển thị định dạng PDF trong chi tiết tin tức</th>
			<td> 
		     	<select id="kieuhienthipdf" name='<portlet:namespace/>kieuhienthipdf'>
 	     			<option value="">--Kiểu hiển thị--</option>
 	     			<option value="0" <%=kieuhienthipdf.equals("0")?"selected":""%>>Kiểu mặc định</option>
 	     			<option value="1" <%=kieuhienthipdf.equals("1")?"selected":""%>>Kiểu lật trang</option>
	 	     	</select>
			</td>
			<th class="keycolor">Hiển thị chức năng Bình luận</th>
				<%
				
					String check_binhluan= "";
					if(binhluan.equals("1")){
						check_binhluan = "checked";
					}
					
				%>
				
			<td><input name="<portlet:namespace/>binhluan" type="checkbox" <%=check_binhluan %> /></td>
		</tr>
		<tr>
			<th class="keycolor">Text to Speech</th>
				<%
				
					String check_texttospeed= "";
					if(textToSpeech.equals("1")){
						check_texttospeed = "checked";
						//System.out.println("View"+check_texttospeed);
					}
					
				%>
				
			<td><input name="<portlet:namespace/>textToSpeech" type="checkbox" <%=check_texttospeed %> /></td>
			<th class="keycolor">Hiện/ Ẩn tên tác giả</th>
				<%
				
					String check_congtacvien= "";
					if(ctv.equals("1")){
						check_congtacvien = "checked";
						//System.out.println("View"+check_texttospeed);
					}
					
				%>
				
			<td><input name="<portlet:namespace/>ctv" type="checkbox" <%=check_congtacvien %> /></td>
		</tr>
		
		<!-- Ẩn/hiện bản quyền/từ khóa -->
		<tr>
			<th class="keycolor">Hiện/ Ẩn bản quyền</th>
				<%
				
					String check_banquyen= "";
					if(banquyen.equals("1")){
						check_banquyen = "checked";
					}
					
				%>
				
			<td>
				<input name="<portlet:namespace/>banquyen" type="checkbox" <%=check_banquyen %> />
				<input type="text" name="<portlet:namespace/>linkbanquyen" value="<%=linkbanquyen%>"/>
			</td>
			<th class="keycolor">Hiện/ Ẩn từ khóa</th>
				<%
				
					String check_tukhoa= "";
					if(tukhoa.equals("1")){
						check_tukhoa = "checked";
					}
					
				%>
				
			<td><input name="<portlet:namespace/>tukhoa" type="checkbox" <%=check_tukhoa %> /></td>
		</tr>
		
		<tr>
			<th colspan="4">
				<h3>Cấu hình chức năng tìm kiếm tin tức</h3>
			</th>
		</tr>
		<tr>
			<th class="keycolor">Trang kết quả tìm kiếm</th>
			<td colspan="3"><input type="text" name="<portlet:namespace/>search_page_iframe" value="<%=search_page_iframe%>"/></td>
		</tr>
		<tr>
			<th class="keycolor">Tiêu đề nút tìm kiếm</th>
			<td colspan="3"><input type="text" name="<portlet:namespace/>search_text" value="<%=search_text%>"/></td>
		</tr>
		
		<tr>
			<td colspan="4">
				<input type="hidden" name="<portlet:namespace/>data_category" id="data_category" value="<%=order_category%>">
				<input type="button" value="save" onClick="submitForm(document.<portlet:namespace />fm);" />
			</td>
		</tr>		
		
	</table>
</form>
</body>
</html>
<script>
$.noConflict();
jQuery(document).ready(function($){
	var data = "";
	$('.check_item input[type=checkbox]').click(function(){
		console.log('11');
		
		if($(this).prop('checked') == true){
		    data = data+"_"+ $(this).attr("data");
		    
		    $("#data_category").val(data);
		    
		}else{
			data_old = $("#data_category").val();
			data_old_item = "_"+$(this).attr("data");
			console.log(data_oldata_oldd_item)
			data = data_old.replace(data_old_item,"");
			
			$("#data_category").val(data);
		}
	});
});
</script>