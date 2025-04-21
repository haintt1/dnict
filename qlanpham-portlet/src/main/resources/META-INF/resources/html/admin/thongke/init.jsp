<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />
<portlet:defineObjects />

<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/excel/tableExport.min.js"></script>
<script src="https://cdn.rawgit.com/rainabba/jquery-table2excel/1.1.0/dist/jquery.table2excel.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>

<script>
	AUI().use('aui-datepicker', function(A) {
	    new A.DatePicker({
	        trigger: '.auiDate',
	        mask: '%d/%m/%Y',
	        popover: {
	            zIndex: 1
	        }
	    });
	});
</script>

<script>
	$(document).ready(function(){
		$(".quy-thongke").on('change',function(){
			var ngaybatdau = "";
			var ngayketthuc = "";
			namthongke = $('.nam-thongke').val();
			quythongke = $(this).val();
			var currentTime = new Date()
			var year = currentTime.getFullYear()
			if(quythongke == 1){
				if(namthongke != -1){
					ngaybatdau = "01/01/" + namthongke; 
					ngayketthuc = "31/03/" + namthongke; 
				}else{
					ngaybatdau = "01/01/" + year; 
					ngayketthuc = "31/03/" + year; 
				}
			}
			if(quythongke == 2){
				if(namthongke != -1){
					ngaybatdau = "01/04/" + namthongke; 
					ngayketthuc = "30/06/" + namthongke; 
				}else{
					ngaybatdau = "01/04/" + year; 
					ngayketthuc = "30/06/" + year; 
				}
			}
			if(quythongke == 3){
				if(namthongke != -1){
					ngaybatdau = "01/07/" + namthongke; 
					ngayketthuc = "30/09/" + namthongke; 
				}else{
					ngaybatdau = "01/07/" + year; 
					ngayketthuc = "30/09/" + year; 
				}
			}
			if(quythongke == 4){
				if(namthongke != -1){
					ngaybatdau = "01/10/" + namthongke; 
					ngayketthuc = "31/12/" + namthongke; 
				}else{
					ngaybatdau = "01/10/" + year; 
					ngayketthuc = "31/12/" + year;
				}
			}
			$(".ngaybatdau").val(ngaybatdau);
			$(".ngayketthuc").val(ngayketthuc);	
		});
		$(".nam-thongke").on('change',function(){
			var ngaybatdau = "";
			var ngayketthuc = "";
			namthongke = $(this).val();
			quythongke = $('.quy-thongke').val();
			var currentTime = new Date()
			var year = currentTime.getFullYear()
			
			if(namthongke != -1){
				if (quythongke != -1) {
					if(quythongke == 1){
						ngaybatdau = "01/01/" + namthongke; 
						ngayketthuc = "31/03/" + namthongke; 			
					}
					if(quythongke == 2){			
						ngaybatdau = "01/04/" + namthongke; 
						ngayketthuc = "30/06/" + namthongke; 			
					}
					if(quythongke == 3){			
						ngaybatdau = "01/07/" + namthongke; 
						ngayketthuc = "30/09/" + namthongke; 			
					}
					if(quythongke == 4){			
						ngaybatdau = "01/10/" + namthongke; 
						ngayketthuc = "31/12/" + namthongke; 			
					}
				}else{
				ngaybatdau = "01/01/" + namthongke; 
				ngayketthuc = "31/12/" + namthongke; 
				}
				//alert(ngaybatdau);
				
			}else{
				if (quythongke != -1) {
					if(quythongke == 1){
						ngaybatdau = "01/01/" + namthongke; 
						ngayketthuc = "31/03/" + namthongke; 			
					}
					if(quythongke == 2){			
						ngaybatdau = "01/04/" + namthongke; 
						ngayketthuc = "30/06/" + namthongke; 			
					}
					if(quythongke == 3){			
						ngaybatdau = "01/07/" + namthongke; 
						ngayketthuc = "30/09/" + namthongke; 			
					}
					if(quythongke == 4){			
						ngaybatdau = "01/10/" + namthongke; 
						ngayketthuc = "31/12/" + namthongke; 			
					}
				} else{
				ngaybatdau = "01/01/" + year; 
				ngayketthuc = "31/12/" + year; 
				}
			}
			$(".ngaybatdau").val(ngaybatdau);
			$(".ngayketthuc").val(ngayketthuc);
		});	
	});
</script>