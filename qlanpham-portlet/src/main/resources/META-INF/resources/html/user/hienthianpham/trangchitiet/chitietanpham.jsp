<%@page import="java.net.URLEncoder"%>
<%@page import="qlanpham.portlet.utils.AnPhamGuestUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="qlanpham.portlet.utils.DocumentUpload"%>
<%@page import="qlanphamdb.model.AnPham_DinhKemFile"%>
<%@page import="java.util.List"%>
<%@page import="qlanpham.portlet.utils.SlugUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="qlanphamdb.service.AnPham_TapChiLocalServiceUtil"%>
<%@page import="qlanphamdb.model.AnPham_TapChi"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	HttpServletRequest httpServletRequest = PortalUtil.getOriginalServletRequest(request);
	String httpDDId = httpServletRequest.getParameter("dinhdanh");
	if(Validator.isNotNull(httpDDId)) {
		AnPham_TapChi anPham_TapChi = null;
		long dinhdanhId = Long.valueOf(httpDDId);
		anPham_TapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(dinhdanhId);
    String currentCompleteUrl = PortalUtil.getCurrentCompleteURL(request);
    String encodedUrl = java.net.URLEncoder.encode(currentCompleteUrl, "UTF-8");
	String title = "";
%>
<portlet:actionURL var="updateviewerURL" name="updateViewer"></portlet:actionURL>
<portlet:resourceURL var="resourceURL"></portlet:resourceURL>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta property="og:url"           content="<%=currentCompleteUrl %>" />
	<meta property="og:type"          content="website" />
	<meta property="og:title"         content="<%=anPham_TapChi.getTen().toString() %>" />
	<meta property="og:description"   content="<%=anPham_TapChi.getMoTa()%>" />
	<meta property="og:image"         content="<%=anPham_TapChi.getAnhDaiDien() %>" />
    <title><%=anPham_TapChi.getTen() %></title>
    <!-- font awesome -->
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/all.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/swiper/swiper-bundle.min.css" />
    <style>
    	.social-share {
            position: sticky;
            top: 80px; /* Cách cạnh trên của viewport 10px */
            height: fit-content;
        }
        .social-share .btn {
            width: 2rem;
            height: 2rem;
            text-align: center;
            padding: 0;
            line-height: 30px;
        }
        .social-share ul {
            display: flex;
            flex-direction: column;
            justify-content: center; /* Căn giữa các phần tử */
            padding: 0;
            margin: 0;
            list-style: none;
        }   
        .social-share ul li {
            margin: 5px; /* Khoảng cách giữa các icon */
        }
        .social-share ul li a {
            display: flex;
            align-items: center;
            justify-content: center;
        }
        /* Chỉ chỉnh sửa khi ở chế độ mobile */
        @media (max-width: 768px) {
            .social-share {
                position: fixed; /* Đặt vị trí cố định để luôn ở bên trái */
                left: 0;
                top: 0;
                height: 100%; /* Chiều cao full màn hình */
                display: flex;
                justify-content: center;
                flex-direction: column;
            }

            #news-content {
                padding-left: 80px; /* Chừa khoảng trống để nội dung không đè lên icon */
            }
        }
        #news-content {
            line-height: 1.6; /* Đảm bảo khoảng cách giữa các dòng đủ lớn */
            transition: font-size 0.3s ease; /* Hiệu ứng mượt khi thay đổi font */
        }
        #news-content h1 {
            font-size: 2em;
        }
        #news-content h2 {
            font-size: 1.75em;
        }
        #news-content h3 {
            font-size: 1.2em;
        }
        #news-content h5 {
            font-size: 0.83em;
        }
		.content img {
			max-width: 100%;
			height: auto;
		}
		.tagText {
        	margin-bottom: 1rem;
        }
		.tagText a {
            border-width: 5px;
            font-size: 100%
        }
        a.badge.badge-light:hover {
        	color: red;
		}
        .select-wrapper {
            position: relative;
            display: inline-block;
        }
        
        .custom-select-btn {
            background-color: #f8f9fa;
            border: 1px solid #dee2e6;
            border-radius: 20px;
            padding: 6px 15px;
            display: inline-flex;
            align-items: center;
            gap: 8px;
            cursor: pointer;
        }
        .custom-select-btn:hover {
            background-color: #e9ecef;
        }
        
        .mic-icon {
            color: #6c757d;
            font-size: 14px;
        }
        
        .select-text {
            color: #212529;
            font-size: 14px;
        }
        
        .region-select {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            opacity: 0;
            cursor: pointer;
        }
        .detail_social {
            margin-bottom: 1rem;
            padding: 1rem 0;
            border-bottom: 1px solid #e0e0e0;
            border-top: 1px solid #e0e0e0;
            display: flex;
            align-items: center;
        }
        .anphamlienquan {
            border-top: 1px solid #e0e0e0;
        }
        .section-title {
            margin: 20px 0;
            border-bottom: 2px solid #000;
            font-size: 24px;
            font-weight: bold;
            text-transform: uppercase;
        }
        .section-title a {
        	text-decoration: none;
        }
        .section-title a:hover {
        	color: red;
        }
        .swiper-slide {
            text-align: center;
            font-size: 14px;
        }

        .swiper-slide img {
            width: 150px;
            height: 200px;
        }
        .swiper-slide a {
            display: block;
		    color: black;
		    text-decoration: none;
		    font-weight: bold;
        }
        .swiper-slide a:hover {
        	color: red;
        }
    </style>
</head>
<body>
    <div class="detail-anpham-container" id="news-content">
    	<div class="row">
    		<div class="col-2 col-md-1 social-share">
    			<ul>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-outline-dark rounded-circle" title="Share on Facebook" onclick="shareOnFacebook('<%= encodedUrl %>')"><i class="fab fa-facebook"></i></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="zalo-share-button btn btn-default rounded-circle" data-href="<%=currentCompleteUrl %>" data-oaid="579745863508352884" data-layout="1" data-customize="true"><img src="<%=request.getContextPath()%>/images/zalo.png" alt="Zalo" class="img-fluid"></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-outline-dark rounded-circle print-article" onclick="PrintElem('.content','<%=title.toString()%>')"><i class="fas fa-print"></i></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-outline-dark rounded-circle" title="Copy link" onclick="Copy()"><i class="fas fa-link"></i></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-default rounded-circle" onclick="changeFont(-1); return false;"><img src="<%=request.getContextPath()%>/images/textsmall.png" alt="" class="img-fluid"></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-default rounded-circle" onclick="changeFont(1); return false;"><img src="<%=request.getContextPath()%>/images/textlarge.png" alt="" class="img-fluid"></a></li>
                    <li class="nav-item"><a href="javascript:void(0)" class="btn btn-outline-dark rounded-circle" onclick="taiBaiViet()" title="Tải về"><i class="fas fa-download"></i></a></li>
                </ul> 
    		</div>
    		<div class="col-10 col-md-11 card p-4 shadow-sm detail_anpham">
    			<h3 id="tieude" class="card-title font-weight-bold" style="font-size: 1.75rem;"><%=anPham_TapChi.getTen() %></h3>
	            <div class="d-flex align-items-center text-muted mb-2 user_anpham">
	            	<%if(ctv.equals("1")) { %>
	                <span class="mr-3">
	                    <i class="far fa-user"></i> 
	                    <%
		                	User us = UserLocalServiceUtil.fetchUser(anPham_TapChi.getNguoiTao());
							if(Validator.isNotNull(us)){
								out.print(us.getFullName());
							}
	                	%>
	                </span>
	                <span class="mr-3">
	                    <i class="far fa-clock"></i> <%=df.format(anPham_TapChi.getNgayTao())%>
	                </span>
	                <% } %>
	            </div>
	            <%if(textToSpeech.equals("1")){ %>
	            <div class="mb-2 speech_anpham">
                    <a id="playButton" href="javascript:void(0)" style="margin-right: 0.5rem;"><i class="fas fa-volume-up"></i></a>
                    <a id="stopButton" href="javascript:void(0)" style="margin-right: 0.5rem;"><i class="fas fa-volume-mute"></i></a>
                    <div class="select-wrapper">
                        <div class="custom-select-btn">
                            <i class="fas fa-microphone mic-icon"></i>
                            <span class="select-text" id="selectedText">Giọng nam</span>
                        </div>
                        <select class="region-select" id="regionSelect">
                            <option value="Vietnamese Male">Giọng nam</option>
                            <option value="Vietnamese Female">Giọng nữ</option>
                        </select>
                    </div>
                </div>
                <% } %>
	            <div id="mota" class="card-text desc_anpham">
	            	<h2><%=anPham_TapChi.getMoTa() %></h2>
	            </div>
	            <%
	            	String noidungchitiet = anPham_TapChi.getNoiDung();
	            	String urlPdf = "";
	            	String tenPdf = "";
	            	List<AnPham_DinhKemFile> listDinhKem = DocumentUpload.getLinkdinhkembyIdAndObject(anPham_TapChi.getId(),9);
	            	if(listDinhKem.size() > 0) {
	            		urlPdf = listDinhKem.get(0).getUrl();
	            		tenPdf = listDinhKem.get(0).getTen();
	            	}
	            	String urlFlipbooktest = "/pdfbook?pdf="+tenPdf;
	            	String urlFlipbook = request.getContextPath()+"/html/pdfbook/index.html?pdf="+urlPdf;
	            	if(kieuhienthipdf.equals("0")) {
	            		String pdfview = request.getContextPath()+"/html/pdfjs/web/viewer.html?file="+urlPdf;
	            		noidungchitiet = noidungchitiet + "<iframe class=\"pdf_watermark no-print\" src='"+pdfview+"' style=\"width:100%; height:1000px; border: none;\"></iframe>";
	            	//	noidungchitiet = noidungchitiet + "<embed id=\"check_pdf_watermark\" class=\"pdf_watermark no-print\" src='"+urlPdf+"' style=\"width:100%; height:1000px;\"></embed>";
	            	} else if (kieuhienthipdf.equals("1")) {
	            		noidungchitiet = noidungchitiet + "<a style=\"display: block;text-decoration:none;margin-bottom: 10px\" class=\"xemfull-pdf\" target=\"_BLANK\" href='"+urlFlipbooktest+"'>Xem dạng lật sách ở chế độ toàn màn hình</a>";
	            	} else {
	            		noidungchitiet = noidungchitiet + "<a style=\"display: block;text-decoration:none;margin-bottom: 10px\" class=\"xemfull-pdf\" target=\"_BLANK\" href='"+urlFlipbooktest+"'>Xem dạng lật sách ở chế độ toàn màn hình</a>";
		            	// noidungchitiet = noidungchitiet + "<a style=\"display: block;text-decoration:none;margin-bottom: 10px\" class=\"xemfull-pdf\" target=\"_BLANK\" href='"+urlFlipbook+"'>Xem file ở chế độ toàn màn hình</a>";
		            	noidungchitiet = noidungchitiet + "<embed id=\"check_pdf_watermark\" class=\"pdf_watermark no-print\" src='"+urlPdf+"' style=\"width:100%; height:1000px;\"></embed>";	
	            	}
	            %>
	            <div id="noidung" class="card-text content_anpham">
	            	<%=noidungchitiet %>
	            </div>
	            <div class="detail_social fb-like" 
		            data-href="<%=currentCompleteUrl %>" 
		            data-width=""
		            data-layout="standard" 
		            data-action="like" 
		            data-size="small"  
		            data-share="true">
		        </div>
		        <%
			    	if (tukhoa.equals("1")) {
			    %>
			    <div class="tagText">
			        <i class="fas fa-tags"></i>
			        <%
				        String tuKhoaString = anPham_TapChi.getTuKhoa();
			        	if(Validator.isNotNull(tuKhoaString)) {
							String[] tuKhoaArray = tuKhoaString.split(",");
							for(int tk = 0; tk < tuKhoaArray.length; tk++) {
								String tag = tuKhoaArray[tk].trim();
								String urltk = tagtukhoa+"?tag="+SlugUtil.convertToSlug(tag)+"-"+SlugUtil.encode(tag);
					%>
			        <a href="<%=urltk %>" class="badge badge-light"><%=tag %></a>
			        <% }} %>
			    </div>
			    <% } %>
			    <div class="anphamlienquan">
			        <div class="swiper anphamlq">
			        	<%
			        		String urldanhmuc = trangdanhmuc+"?danhmuc="+anPham_TapChi.getLoaiId();
			        		long idTL = anPham_TapChi.getLoaiId();
			        		long idTC = anPham_TapChi.getId();
			        	%>
			        	<div class="col-12 section-title"><a href="<%=urldanhmuc%>">Tạp chí liên quan</a></div>
			            <div class="swiper-wrapper">
			            	<%
			            		List<AnPham_TapChi> listTCLienQuan = AnPhamGuestUtil.getTapChiLienQuan(idTC, idTL);
			            		if(listTCLienQuan.size() > 0) {
				            		for(AnPham_TapChi lq : listTCLienQuan) {
				            			String urlTitle = trangchitiet+"?dinhdanh="+lq.getId();
			            	%>
			                <div class="swiper-slide">
			                	<a href="<%=urlTitle%>">
			                		<img src="<%=lq.getAnhDaiDien() %>" class="img-fluid" alt="Tạp chí">
			                		<p><%=lq.getTen() %></p>
			                	</a>
			                </div>
			                <% }} else {%>
			                <span style="text-align: center;">Tạp chí đang được cập nhật!...</span>
			                <% } %>
			            </div>
			            <!-- Pagination -->
			            <div class="swiper-pagination"></div>
			            <!-- Navigation Buttons -->
			            <div class="swiper-button-prev"></div>
			            <div class="swiper-button-next"></div>
			        </div>
			    </div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/text-to-speech/text-to-speech.js"></script>
    <script src="<%=request.getContextPath() %>/js/watermark/jquery.watermark.js"></script>
	<script src="<%=request.getContextPath() %>/js/watermark/pdf-lib.min.js"></script>
	<script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v21.0&appId=661068294858359"></script>
    <script src="https://sp.zalo.me/plugins/sdk.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/swiper/swiper-bundle.min.js"></script>
    <!-- Xử lý bản quyền ảnh và pdf -->
    <script type="text/javascript">
    	var $ = jQuery.noConflict();
    	$('.content img').addClass('img_watermark');
    	if(<%=banquyen.equals("1")%>) {
    		const repeatText = Array(10).fill('<%=linkbanquyen%>').join(' ');
    		$(document).ready(function(){
    			$('.img_watermark').watermark({
    		        text: repeatText,
    		        textSize: 20,
    		        textColor: 'white',
    		        textBg: 'black',
    		        textWidth: 1000,
    		        gravity: 's',
    		        opacity: 0.3,
    		        margin: 20
    		    });
    			const pdfUrl = $('.pdf_watermark');
    			if(pdfUrl) {
    				loadPdfWatermark();
    			}
    		});		
    		async function loadPdfWatermark() {
    			const pdfUrl = $('.pdf_watermark').attr('src');
    			if(pdfUrl && pdfUrl.includes('file=')) {
    				const urlParams = new URLSearchParams(pdfUrl.split('?')[1]);
    			    const fileParam = urlParams.get('file');
    			//    console.log(fileParam); // in ra đường dẫn file sau "file="
    			    
    				// Tải file PDF từ URL
        			const existingPdfBytes = await fetch(fileParam).then(res => res.arrayBuffer());
        			// Tải PDF bằng PDF-Lib
        			const { PDFDocument, rgb } = PDFLib;
        			const pdfDoc = await PDFDocument.load(existingPdfBytes);
        			// Lấy tất cả các trang
        			const pages = pdfDoc.getPages();
        			
        			const watermarkText = '<%=linkbanquyen%>';
        			pages.forEach(page => {
        				const { width, height } = page.getSize();
        				page.drawText(watermarkText, {
        					x: width / 4,
        					y: height / 2,
        					size: 50,
        					color: rgb(0.75, 0.75, 0.75),
        					opacity: 0.3,
        				});
        			});
        			// Lưu file PDF đã chỉnh sửa
        			const pdfBytes = await pdfDoc.save();
        			
        			// Tạo URL Blob từ PDF đã chỉnh sửa
        			const blob = new Blob([pdfBytes], { type: 'application/pdf' });
        			const blobUrl = URL.createObjectURL(blob);
        			
        			const baseUrl = '<%=request.getContextPath()+"/html/pdfjs/web/viewer.html"%>';
        			const newUrl = baseUrl + '?file=' + encodeURIComponent(blobUrl);
        			
        			$('.pdf_watermark').attr('src', newUrl);
    			}
    		}
    	}
    </script>
    <!-- Xử lý các nút icon -->
    <script>
	    jQuery(document).ready(function($){	
			var viewer = function(id){					 
				$.ajax({
					type: 'POST',
					url: '<%=updateviewerURL.toString() %>',
					data : {<%=renderResponse.getNamespace()%>id: id},
					success: function(data){
					}
				});		
			}
				viewer(<%=Long.valueOf(httpDDId)%>);
		});
	    function shareOnFacebook(url) {
	        const shareUrl = `https://www.facebook.com/sharer/sharer.php?u=${url}`;
	        window.open(shareUrl, '_blank', 'width=600,height=400');
	    };
		function PrintElem(elem,title)
		{
			// Lấy nội dung HTML của phần tử
		    var content = jQuery(elem).clone(); // Clone để không thay đổi nội dung gốc
	
		    // Loại bỏ các phần tử không cần in (dùng jQuery)
		    content.find('.no-print').remove();
	
		    // Gửi nội dung đã chỉnh sửa đến hàm Popup
		    Popup(content.html(), title);
		}
		function Popup(data,title) 
		{
		    var mywindow = window.open('',title, 'height=400,width=600');
		    mywindow.document.write('<html><head><title>'+title+'</title>');
		    mywindow.document.write('</head><body >');
		    mywindow.document.write(data);
		    mywindow.document.write('</body></html>');
		    
		 	// Đợi cửa sổ mới tải nội dung
	        mywindow.document.close();
	
	        // Kiểm tra hình ảnh và đảm bảo tất cả được tải xong
	        const images = mywindow.document.images;
	        let totalImages = images.length;
	        let loadedImages = 0;
	
	        if (totalImages === 0) {
	            // Không có hình ảnh, in ngay lập tức
	            mywindow.print();
	            mywindow.close();
	        } else {
	            // Chờ tất cả hình ảnh tải xong
	            for (let i = 0; i < totalImages; i++) {
	                images[i].onload = images[i].onerror = function () {
	                    loadedImages++;
	                    if (loadedImages === totalImages) {
	                    	mywindow.print();
	                    	mywindow.close();
	                    }
	                };
	            }
	        }
		    return true;
		}
		
		// Xử lý copy link
		function Copy() {
			let url = document.location.href;
		    let tempInput = document.createElement('input');
		    tempInput.value = url;
		    document.body.appendChild(tempInput);
		    tempInput.select();
		    try {
		        document.execCommand('copy');
		        alert('URL đã được sao chép!');
		    } catch (err) {
		        console.error('Lỗi khi sao chép: ', err);
		        alert('Không thể sao chép URL');
		    }
		    document.body.removeChild(tempInput);
		}
		
		// Xử lý tăng giảm chữ bài viết
		function getDefaultFontSize() {
            const content = document.getElementById('news-content');
            const style = window.getComputedStyle(content, null);
            const fontSize = style.getPropertyValue('font-size');
            console.log('Kích thước mặc định của chữ:', fontSize);
            return fontSize; // Lấy size default của bài viết
        }
		var defaultFontSize = getDefaultFontSize(); // Gọi hàm để lấy size default
		var currentFontSize = parseFloat(defaultFontSize); // chuyển về dạng số
        function changeFont(step) {
            // Lấy phần tử nội dung
            const content = document.getElementById('news-content');

            // Tăng hoặc giảm kích thước font
            currentFontSize += step;

            // Giới hạn kích thước font (ví dụ: tối thiểu 12px, tối đa 30px)
            if (currentFontSize < 12) currentFontSize = 12;
            if (currentFontSize > 30) currentFontSize = 30;

            // Áp dụng kích thước mới
            content.style.fontSize = currentFontSize + 'px';
        }
		function taiBaiViet() {
			var anPhamId = '<%= httpDDId %>';
			$.ajax({
				 url: '<%=resourceURL %>',
				 type: 'POST',
				 data:{<portlet:namespace />anPhamId:anPhamId},
				 success: function (data) {
					const pdfUrl = $('.pdf_watermark').attr('src');
					const urlParams = new URLSearchParams(pdfUrl.split('?')[1]);
					const fileParam = urlParams.get('file');
					console.log("hello " + fileParam);
					var link = document.createElement("a");
					link.href = fileParam;
					link.download = data.ten;
					link.click();
				 },
				 error: function (data) {
				 	alert("Lỗi dữ liệu từ server");
				 }
			})
		}
	</script>
	<script type="text/javascript">
		const playButton = document.getElementById('playButton');
		const stopButton = document.getElementById('stopButton');
		const regionSelect = document.getElementById('regionSelect');
		const selectedText = document.getElementById('selectedText');
		
		regionSelect.addEventListener('change', function() {
		    selectedText.textContent = this.options[this.selectedIndex].text;
		});
		const tieude = document.getElementById("tieude").textContent;
		const mota = document.getElementById("mota").textContent;
		const noidung = document.getElementById("noidung").textContent;
		const tieudeHTML = tieude.replace(/(\r?\n|\r)/gm, '');
		const noidungHTML = noidung.replace(/[\u0000-\u001F\u007F-\u009F]/g, " ");
		const contentHTML = tieudeHTML + mota + noidungHTML;
		// Khi nhấn nút "Phát âm thanh"
		playButton.addEventListener("click", () => {
		    const selectedVoice = regionSelect.value; // Lấy giọng được chọn
		    responsiveVoice.speak(contentHTML, selectedVoice); // Sử dụng ResponsiveVoice để đọc
		});
		// Khi nhấn nút "Tắt âm thanh"
		stopButton.addEventListener("click", () => {
		    responsiveVoice.cancel(); // Dừng phát âm thanh
		});
	</script>
	<!-- Initialize Swiper -->
	<script>
	    var swiper = new Swiper(".anphamlq", {
	        slidesPerView: 1, // Hiển thị 4 tạp chí mỗi lần
	        spaceBetween: 10, // Khoảng cách giữa các slide
	        pagination: {
	            el: ".swiper-pagination",
	            clickable: true,
	        },
	        navigation: {
	            nextEl: ".swiper-button-next",
	            prevEl: ".swiper-button-prev",
	        },
	        breakpoints: {
	            640: {
	                slidesPerView: 2,
	                spaceBetween: 10,
	            },
	            768: {
	                slidesPerView: 3,
	                spaceBetween: 15,
	            },
	            1024: {
	                slidesPerView: 5,
	                spaceBetween: 20,
	            },
	        },
	    });
	</script>
</body>
</html>
<% } %>
