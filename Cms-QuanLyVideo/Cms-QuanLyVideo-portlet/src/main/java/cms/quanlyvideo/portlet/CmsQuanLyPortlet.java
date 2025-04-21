package cms.quanlyvideo.portlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLVersionNumberIncrease;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import cms.quanlyvideo.constants.CmsQuanLyKeys;
import cms.quanlyvideo.model.ChuDe;
import cms.quanlyvideo.model.ChuDeVideo;
import cms.quanlyvideo.model.Video;
import cms.quanlyvideo.service.ChuDeLocalService;
import cms.quanlyvideo.service.ChuDeVideoLocalService;
import cms.quanlyvideo.service.ChuDeVideoLocalServiceUtil;
import cms.quanlyvideo.service.VideoLocalService;
import cms.quanlyvideo.utils.QLVideoConfig;

/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Quản lý video",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.name=" + CmsQuanLyKeys.QUANLY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CmsQuanLyPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	CounterLocalService counterLocalService;
	@Reference
	ChuDeLocalService chuDeLocalService;
	@Reference
	ChuDeVideoLocalService chuDeVideoLocalService;
	@Reference
	VideoLocalService videoLocalService;
	@Reference
    private DLAppLocalService dlAppLocalService;
	
	@ProcessAction(name = "themChuDe")
	public void themChuDe(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			long id = counterLocalService.increment(ChuDe.class.getName());
			String ten = ParamUtil.getString(actionRequest, "ten");
			String moTa = ParamUtil.getString(actionRequest, "moTa");
			long trangThai = ParamUtil.getLong(actionRequest, "trangThai");
			Date ngayTao = new Date();

			ChuDe chude = chuDeLocalService.createChuDe(id);
			chude.setId(id);
			chude.setTen(ten);
			chude.setMoTa(moTa);
			chude.setTrangThai(trangThai);
			chude.setNgayTao(ngayTao);
			// 0: chưa xóa, 1: khôi phục
			chude.setDaXoa(0);
			chuDeLocalService.addChuDe(chude);
			// Sử dụng setAttribute để lưu thông báo
	        actionRequest.setAttribute("themchudethanhcong", true);
		} catch (Exception e) {
			SessionErrors.add(actionRequest,"themchudethatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/chude/create.jsp");
		}
	}
	
	@ProcessAction(name = "capnhatChuDe")
	public void capnhatChuDe(ActionRequest actionRequest,  ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest,"id", GetterUtil.DEFAULT_LONG);
		String ten = ParamUtil.getString(actionRequest, "ten", GetterUtil.DEFAULT_STRING);
		String moTa = ParamUtil.getString(actionRequest, "moTa", GetterUtil.DEFAULT_STRING);
		long trangThai = ParamUtil.getLong(actionRequest, "trangThai", GetterUtil.DEFAULT_LONG);
		Date ngaySua = new Date();
		ChuDe chude = null;
		try {
			chude = chuDeLocalService.getChuDe(id);
			if(Validator.isNotNull(chude)) {
				chude.setTen(ten);
				chude.setMoTa(moTa);
				chude.setTrangThai(trangThai);
				chude.setNgaySua(ngaySua);

				chuDeLocalService.updateChuDe(chude);
			}
			// Sử dụng setAttribute để lưu thông báo
			actionRequest.setAttribute("capnhatchudethanhcong", true);
		} catch (Exception e) {
			SessionErrors.add(actionRequest,"capnhatchudethatbai");
			log.error(e.getCause(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/chude/create.jsp");
		}
	}
	
	@ProcessAction(name = "xoamemChuDe")
	public void xoamemChuDe(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		ChuDe chude = null;
		try {
			chude = chuDeLocalService.getChuDe(id);
			chude.setTrangThai(0);
			chude.setDaXoa(1);
			chuDeLocalService.updateChuDe(chude);

			SessionMessages.add(actionRequest, "xoamemchudethanhcong", true);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@ProcessAction(name = "khoiphucChuDe")
	public void khoiphucChuDe(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		ChuDe chude = null;
		try {
			chude = chuDeLocalService.getChuDe(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		chude.setDaXoa(0);
		chuDeLocalService.updateChuDe(chude);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("khoiphucchudethanhcong", true);
	}
	
	@ProcessAction(name = "kichhoatChuDe")
	public void kichhoatChuDe(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		ChuDe chude = null;
		try {
			chude = chuDeLocalService.getChuDe(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		chude.setTrangThai(0);
		chuDeLocalService.updateChuDe(chude);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("kichhoatchude", true);
	}
	
	@ProcessAction(name = "huykichhoatChuDe")
	public void huykichhoatChuDe(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		ChuDe chude = null;
		try {
			chude = chuDeLocalService.getChuDe(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		chude.setTrangThai(1);
		chuDeLocalService.updateChuDe(chude);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("huykichhoatchude", true);
	}

	@ProcessAction(name = "xoaChuDe")
	public void xoaChuDe(ActionRequest actionRequest, ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		try {
			chuDeLocalService.deleteChuDe(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		actionResponse.setRenderParameter("mvcPath", "/html/admin/chude/trash.jsp");
	}
	
	@ProcessAction(name = "themVideo")
	@Transactional
	public void themVideo(ActionRequest actionRequest, ActionResponse actionResponse) {
			long id = counterLocalService.increment(Video.class.getName());
			String ten = ParamUtil.getString(actionRequest, "ten");
			String moTa = ParamUtil.getString(actionRequest, "moTa");
			String noiDung = ParamUtil.getString(actionRequest, "noiDung");
			long luotXem = ParamUtil.getLong(actionRequest, "luotXem");
			long luotThich = ParamUtil.getLong(actionRequest, "luotThich");
			String tuKhoa = ParamUtil.getString(actionRequest, "tuKhoa");
			long choBinhLuan = ParamUtil.getLong(actionRequest, "choBinhLuan");
			long trangThai = ParamUtil.getLong(actionRequest, "trangThai");
			Date ngayTao = new Date();
			
			// Thêm nhiều chủ đề
			String[] chuDeIds = ParamUtil.getParameterValues(actionRequest, "chuDeIds");
			
			// lấy request upload file gửi lên
	        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	        File fileUpload = uploadRequest.getFile("duongDanFile"); // lấy file upload
			
			Video video = videoLocalService.createVideo(id);
			
			try {
				// Thêm nhiều chủ đề
				// Kiểm tra chuDeIds có rỗng không
				if(Validator.isNotNull(chuDeIds)) {
					for(String chuDeIdStr : chuDeIds) {
						long chuDeId = Long.parseLong(chuDeIdStr);
						// Lấy các chủ đề từ request
						long videoChuDeId = counterLocalService.increment(ChuDeVideo.class.getName());
						ChuDeVideo chuDeVideo = chuDeVideoLocalService.createChuDeVideo(videoChuDeId);
						chuDeVideo.setChude_id(chuDeId);
						chuDeVideo.setVideo_id(id);
						// Thêm quan hệ giữa video và chủ đề vào bảng Video_ChuDe
						chuDeVideoLocalService.addChuDeVideo(chuDeVideo);
					}
				}
				ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
				// Lưu video
				// Nếu upload file tồn tại thì
				if(fileUpload !=null && fileUpload.exists()) {
						// Tạo folder trong Documents and Media
						long groupId = serviceContext.getScopeGroupId();
						// Tạo folder nếu chưa tồn tại
				        Folder thuMuc = createFolder(groupId, "Media", serviceContext);
				        // Trường hợp upload file trùng tên kèm với thời gian
				        String timestamp = String.valueOf(System.currentTimeMillis());
				        String tenFile = uploadRequest.getFileName("duongDanFile"); // lấy tên file
				        String loaiFile = uploadRequest.getContentType("duongDanFile"); // lấy tên đuôi file
				        String tenGiong =  timestamp + "_" + tenFile;
				        // Upload file vào Documents and Media
				        FileEntry fileEntry = addFileEntry(
					            groupId, 
					            thuMuc.getFolderId(),
					            tenGiong,
					            loaiFile,
					            fileUpload, // file upload
					            serviceContext
					        );
				        video.setDuongDan(String.valueOf(fileEntry.getFileEntryId()));
				// ko thì nhập link
		        } else {
		        	String duongDanUrl = ParamUtil.getString(actionRequest, "duongDanText");
//		        	log.info("Giá trị: " + duongDanUrl);
		        	video.setDuongDan(duongDanUrl);
		        }
				video.setTen(ten);
				video.setMoTa(moTa);
				video.setNoiDung(noiDung);
				video.setLuotXem(0);
				video.setLuotThich(0);
				video.setTuKhoa(tuKhoa);
				video.setChoBinhLuan(choBinhLuan);
				video.setTrangThai(trangThai);
				video.setUserId(serviceContext.getUserId()); // lưu userId khi login
				// 0: remove, 1: recovery
				video.setDaXoa(0);
				video.setNgayTao(ngayTao);

				// Thêm vào csdl
				videoLocalService.addVideo(video);
				// Sử dụng setAttribute để lưu thông báo
				actionRequest.setAttribute("themvideothanhcong", true);
				SessionMessages.add(actionRequest, "themvideothanhcong");
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "themvideothatbai");
				List<ChuDeVideo> chuDeVideoCu = ChuDeVideoLocalServiceUtil.findChuDeVideoByVideoId(id);
		        for (ChuDeVideo chuDeVideo : chuDeVideoCu) {
		            ChuDeVideoLocalServiceUtil.deleteChuDeVideo(chuDeVideo);
		        }
		        log.error(e.getMessage(), e);
				actionResponse.setRenderParameter("mvcPath", "/html/admin/video/create.jsp");
			}
	}

	private Folder createFolder(long groupId, String folderName, ServiceContext serviceContext) throws PortalException {
        try {
            return (Folder) DLAppLocalServiceUtil.getFolder(groupId, 0, folderName);
        } catch (NoSuchFolderException nsfe) {
            return (Folder) DLAppLocalServiceUtil.addFolder(
                serviceContext.getUserId(),
                groupId,
                0, // parentFolderId
                folderName,
                "Description",
                serviceContext
            );
        }
    }

    private FileEntry addFileEntry(
            long groupId, long folderId, String fileName, String contentType,
            File file, ServiceContext serviceContext) throws PortalException {
            
        return DLAppLocalServiceUtil.addFileEntry(
            serviceContext.getUserId(),
            groupId,
            folderId,
            fileName,
            contentType,
            fileName, // title
            "", // description
            "", // changeLog
            file,
            serviceContext
        );
    }
            
    @ProcessAction(name = "capnhatVideo")
    @Transactional
	public void capnhatVideo(ActionRequest actionRequest,  ActionResponse actionResponse) {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String ten = ParamUtil.getString(actionRequest, "ten");
		String moTa = ParamUtil.getString(actionRequest, "moTa");
		String noiDung = ParamUtil.getString(actionRequest, "noiDung");
		String tuKhoa = ParamUtil.getString(actionRequest, "tuKhoa");
		long choBinhLuan = ParamUtil.getLong(actionRequest, "choBinhLuan");
		long trangThai = ParamUtil.getLong(actionRequest, "trangThai");
		Date ngaySua = new Date();
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest); // Lấy file từ request
		// get value from input
		File duongDanFile = uploadRequest.getFile("duongDanFile");
		String duongDanText = ParamUtil.getString(actionRequest, "duongDanText");
		
		Video video = null;
		
		// Thêm nhiều chủ đề
		String[] chuDeIds = ParamUtil.getParameterValues(actionRequest, "chuDeIds");
		try {
			List<ChuDeVideo> chuDeVideoCu = ChuDeVideoLocalServiceUtil.findChuDeVideoByVideoId(id);
	        for (ChuDeVideo chuDeVideo : chuDeVideoCu) {
	            ChuDeVideoLocalServiceUtil.deleteChuDeVideo(chuDeVideo);
	        }
			if(Validator.isNotNull(chuDeIds)) {
		     // Thêm lại các chủ đề mới từ danh sách chuDeIds
		        for (String chuDeIdStr : chuDeIds) {
		            long chuDeId = Long.parseLong(chuDeIdStr);
		            long chuDeVideoId = counterLocalService.increment(ChuDeVideo.class.getName());
		            ChuDeVideo chuDeVideoMoi = chuDeVideoLocalService.createChuDeVideo(chuDeVideoId);
		            chuDeVideoMoi.setChude_id(chuDeId);
		            chuDeVideoMoi.setVideo_id(id);
		            chuDeVideoLocalService.addChuDeVideo(chuDeVideoMoi);
		        }
			}

			video = videoLocalService.getVideo(id); // Lấy video hiện tại để có duongDan
	        if (video == null) {
	            throw new Exception("Không tìm thấy video với id: " + id);
	        }
	        
	        ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
	        
	        // Xử lý đường dẫn mới
	     	String duongDanMoi = null;
	     	// Nếu có file mới upload lên
			if(duongDanFile !=null && duongDanFile.length()>0) {
				String duongDanFileMoi = uploadRequest.getFileName("duongDanFile");
				String loaiFileMoi = uploadRequest.getContentType("duongDanFile");
				if(video.getDuongDan() !=null && video.getDuongDan().matches("\\d+")) {
					// Lấy duongDan từ video hiện tại thay vì từ request
		            String currentFileEntryId = (String) video.getDuongDan();
					// Lấy thông tin folder hiện tại
			        FileEntry currentFileEntry = DLAppLocalServiceUtil.getFileEntry(Long.parseLong(currentFileEntryId));
			        // Upload file mới
		            FileEntry newFileEntry = DLAppLocalServiceUtil.updateFileEntry(
		            		serviceContext.getUserId(),
		            		Long.parseLong(currentFileEntryId),
		            		duongDanFileMoi,
		            		loaiFileMoi,
		            		duongDanFileMoi,
		            		"",
		            		"",
		            		DLVersionNumberIncrease.MINOR,
		            		duongDanFile, // file request
		            		serviceContext
		            );
		            duongDanMoi = String.valueOf(newFileEntry.getFileEntryId());
				} else {
					// Nếu chuyển nhập text sang upload file
					// Tạo folder trong Documents and Media
					long groupId = serviceContext.getScopeGroupId();
					// Tạo folder nếu chưa tồn tại
			        Folder thuMuc = createFolder(groupId, "media", serviceContext);
			        // Trường hợp tải file trùng tên
			        String timestamp = String.valueOf(System.currentTimeMillis());
			        String tenVideo = uploadRequest.getFileName("duongDanFile"); // lấy tên file
			        String dinhDangVideo = uploadRequest.getContentType("duongDanFile"); // lấy tên đuôi file
			        String tenGiong =  timestamp + "_" + tenVideo;
			        // Upload file vào Documents and Media
			        FileEntry fileEntry = addFileEntry(
				            groupId, 
				            thuMuc.getFolderId(),
				            tenGiong,
				            dinhDangVideo,
				            duongDanFile, // file upload
				            serviceContext
				        );
			        duongDanMoi = String.valueOf(fileEntry.getFileEntryId());
				}
				// Nếu chuyển từ upload file sang nhập text
			} else if (Validator.isNotNull(duongDanText)) {
				String xoaFileChuyenLink = (String) video.getDuongDan();
				// lỗi ở đây
				if(Validator.isNotNull(xoaFileChuyenLink) && Validator.isNumber(xoaFileChuyenLink)) {
					DLFileEntryLocalServiceUtil.deleteFileEntry(Long.parseLong(xoaFileChuyenLink));
				}
				duongDanMoi = duongDanText;
			}
		
			if(Validator.isNotNull(video)) {
				video.setTen(ten);
				video.setMoTa(moTa);
				video.setNoiDung(noiDung);
				video.setTuKhoa(tuKhoa);
				video.setChoBinhLuan(choBinhLuan);
				video.setTrangThai(trangThai);
				video.setNgaySua(ngaySua);
				
				// Chỉ cập nhật đường dẫn nếu có thay đổi
		        if (duongDanMoi != null) {
		            video.setDuongDan(duongDanMoi);
		        }
				
				videoLocalService.updateVideo(video);
				actionRequest.setAttribute("capnhatvideothanhcong", true);
		     	}
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "capnhatvideothatbai");
				actionResponse.setRenderParameter("mvcPath", "/html/admin/video/edit.jsp");
				log.error(e.getCause(), e);
			}
		}

	@ProcessAction(name = "xoamenVideo")
	public void xoamenVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String backURL = ParamUtil.getString(actionRequest, "backURL");

		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setTrangThai(0);
		video.setDaXoa(1);
		videoLocalService.updateVideo(video);
		// Lưu thông báo
		SessionMessages.add(actionRequest, "xoamemvideothanhcong", true);
	}

	@ProcessAction(name = "khoiphucVideo")
	public void khoiphucVideo(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setDaXoa(0);
		videoLocalService.updateVideo(video);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("khoiphucvideo", true);
	}

	@ProcessAction(name = "kichhoatVideo")
	public void kichhoatVideo(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setTrangThai(0);
		videoLocalService.updateVideo(video);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("kichhoatvideo", true);
	}

	@ProcessAction(name = "huykichhoatVideo")
	public void huykichhoatVideo(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setTrangThai(1);
		videoLocalService.updateVideo(video);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("huykichhoatvideo", true);
	}
	
	@ProcessAction(name = "batBinhLuanVideo")
	public void batBinhLuanVideo(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setChoBinhLuan(0);
		videoLocalService.updateVideo(video);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("batbinhluan", true);
	}

	@ProcessAction(name = "tatBinhLuanVideo")
	public void tatBinhLuanVideo(ActionRequest actionRequest, ActionResponse actionResponse){
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);

		Video video = null;
		try {
			video = videoLocalService.getVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		video.setChoBinhLuan(1);
		videoLocalService.updateVideo(video);

		// Sử dụng setAttribute để lưu thông báo
		actionRequest.setAttribute("tatbinhluan", true);
	}

	@ProcessAction(name = "xoaVideo")
	@Transactional
	public void xoaVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		try {
			Video video = videoLocalService.getVideo(id);
			String duongDan = (String) video.getDuongDan();
	        String currentPath = video != null ? video.getDuongDan() : "";
	        boolean isFileEntry = currentPath != null && currentPath.matches("\\d+");
			if(isFileEntry) {
				try {
					DLFileEntryLocalServiceUtil.deleteFileEntry(Long.parseLong(duongDan));
				} catch (Exception e) {
					log.error("Error deleting file entry: " + duongDan, e);
				}
			}
			List<ChuDeVideo> chuDeVideoCu = ChuDeVideoLocalServiceUtil.findChuDeVideoByVideoId(id);
	        for (ChuDeVideo chuDeVideo : chuDeVideoCu) {
	            ChuDeVideoLocalServiceUtil.deleteChuDeVideo(chuDeVideo);
	        }
			videoLocalService.deleteVideo(id);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		actionResponse.setRenderParameter("mvcPath", "/html/admin/video/trash.jsp");
	}
	
	// Logic xử lý cán bộ
	@ProcessAction(name = "resetTimKiem")
	public void resetTimKiem(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException {
		actionRequest.removeAttribute("tuKhoaTK");
		actionRequest.removeAttribute("tinhTrang");
	}
}
