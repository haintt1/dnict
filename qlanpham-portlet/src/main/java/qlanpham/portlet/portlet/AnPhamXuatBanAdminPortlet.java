package qlanpham.portlet.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanphamdb.model.AnPham_Activity;
import qlanphamdb.model.AnPham_CongTacVien;
import qlanphamdb.model.AnPham_DeCuong;
import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_Loai;
import qlanphamdb.model.AnPham_Logs;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.service.AnPham_ActivityLocalServiceUtil;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_LogsLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import vn.dnict.tintuc.model.News_role;
import qlanpham.portlet.utils.DocumentUpload;
import qlanpham.portlet.utils.PhanQuyenAdminUtil;
import qlanpham.portlet.utils.QlanphamAdminUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Ấn phẩm xuất bản",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/anphamxuatban/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.ANPHAMXUATBAN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class AnPhamXuatBanAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(AnPhamXuatBanAdminPortlet.class);
	
	@ProcessAction(name = "saveAnPhamXuatBan")
	public void saveAnPhamXuatBan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			long id = CounterLocalServiceUtil.increment(AnPham_TapChiLocalServiceUtil.class.getName());
			Date date = new Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.createAnPham_TapChi(id);
			objTapChi.setId(id);
			objTapChi.setGroupId(themeDisplay.getScopeGroupId());
			objTapChi.setCompanyId(themeDisplay.getCompanyId());
			objTapChi.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
			objTapChi.setSlug(HtmlUtil.escape(ParamUtil.getString(actionRequest, "slug")));
			objTapChi.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
			objTapChi.setAnhDaiDien(ParamUtil.getString(actionRequest, "selectedItem"));
			objTapChi.setLoaiId(ParamUtil.getLong(actionRequest, "loaiId"));
			objTapChi.setDeCuongId(ParamUtil.getLong(actionRequest, "deCuongId"));
			String noiDung = ParamUtil.getString(actionRequest, "noiDung");
			if(Validator.isNotNull(noiDung)){
				noiDung = "<div class=\"content\">" + noiDung + "</div>";
			}
			objTapChi.setNoiDung(noiDung);
			
//			DocumentUpload.createFolder(actionRequest, themeDisplay);
			List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF2(themeDisplay, uploadPortletRequest, "fileDinhKem");
			if(fileNamedinhkem.size() > 0){
				long idFile = CounterLocalServiceUtil.increment(AnPham_DinhKemFile.class.getName());
				AnPham_DinhKemFile filedinhkem = AnPham_DinhKemFileLocalServiceUtil.createAnPham_DinhKemFile(idFile);
				filedinhkem.setId(idFile);
				filedinhkem.setObject(9); 
				filedinhkem.setObjectId(objTapChi.getId());
				filedinhkem.setTen(fileNamedinhkem.get(0));
				filedinhkem.setCompanyId(themeDisplay.getCompanyId());
				filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
				filedinhkem.setUrl(fileNamedinhkem.get(1));
				AnPham_DinhKemFileLocalServiceUtil.addAnPham_DinhKemFile(filedinhkem);
			}
			objTapChi.setTuKhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
			objTapChi.setPhienBan(1);
			objTapChi.setNguoiTao(themeDisplay.getUserId());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = df.format(date);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayTao"))) {
				String ngayTao = ParamUtil.getString(actionRequest, "ngayTao")+":00";			
				objTapChi.setNgayTao(df.parse(ngayTao));			
			}else {
				objTapChi.setNgayTao(df.parse(ngayhientai));
			}
			objTapChi.setLanguage(ParamUtil.getString(actionRequest, "language"));
			// 0 là dạng bt, 1 là dạng lật sách
			objTapChi.setLoaiTin(ParamUtil.getBoolean(actionRequest, "loaiTin") ? 1 : 0);
			// 0 là ko hiện bl, 1 là hiện bl
			objTapChi.setIsFormHienBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormHienBinhLuan") ? 1 : 0);
			objTapChi.setIsFormViewBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormViewBinhLuan") ? 1 : 0);
			
			// status: 0 là lưu nháp | 1 lưu và gửi bbt | 2 lưu và gửi xuat ban | 3 xuất bản
			if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
				objTapChi.setStatus(1);
				AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(objTapChi);
				objLog.setNguoiXuLy(themeDisplay.getUserId());
				objLog.setNguoiNhan(0);
				objLog.setStatus(1);
				objLog.setNoiDungLog("Gửi biên tập viên");			
				AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
				objTapChi.setStatus(2);
				AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(objTapChi);
				objLog.setNguoiXuLy(themeDisplay.getUserId());
				objLog.setNguoiNhan(0);
				objLog.setStatus(2);
				objLog.setNoiDungLog("Lưu và trình phê duyệt");			
				AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
				objTapChi.setStatus(3);
				AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(objTapChi);
				objLog.setNguoiXuLy(themeDisplay.getUserId());
				objLog.setNguoiNhan(0);
				objLog.setStatus(3);
				objLog.setNoiDungLog("Xuất bản");
				AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
			}else {
				objTapChi.setStatus(0);
			}
			
			objTapChi.setOrders(ParamUtil.getLong(actionRequest, "orders"));
			objTapChi.setDelete_status(0);
			AnPham_TapChiLocalServiceUtil.addAnPham_TapChi(objTapChi);
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-saved-successfully");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "link-saved-failure");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/anphamxuatban/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateAnPhamXuatBan")
	public void updateAnPhamXuatBan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		AnPham_TapChi tapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(id);
		tapChi.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
		tapChi.setSlug(HtmlUtil.escape(ParamUtil.getString(actionRequest, "slug")));
		tapChi.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "selectedItem"))) {
			tapChi.setAnhDaiDien(ParamUtil.getString(actionRequest, "selectedItem"));
		}
		tapChi.setLoaiId(ParamUtil.getLong(actionRequest, "loaiId"));
		tapChi.setDeCuongId(ParamUtil.getLong(actionRequest, "deCuongId"));
		String noiDung = ParamUtil.getString(actionRequest, "noiDung");
		if(Validator.isNotNull(noiDung)){
			if(!noiDung.startsWith("<div class=\"content\">"))
			noiDung = "<div class=\"content\">" + noiDung + "</div>";
		}
		tapChi.setNoiDung(noiDung);
		tapChi.setNoiDung(noiDung);
		tapChi.setTuKhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
		long currentVerSion = tapChi.getPhienBan();
		tapChi.setPhienBan(currentVerSion + 1);
		tapChi.setNguoiSua(themeDisplay.getUserId());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date);
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayTao"))) {
			String ngayTao = ParamUtil.getString(actionRequest, "ngayTao")+":00";			
			tapChi.setNgayTao(df.parse(ngayTao));			
		}else {
			tapChi.setNgayTao(df.parse(ngayhientai));
		}
		
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh"); // Múi giờ Việt Nam
        df.setTimeZone(timeZone);
		String ngaySua = df.format(date)+":00";
		tapChi.setNgaySua(df.parse(ngaySua));
		tapChi.setLanguage(ParamUtil.getString(actionRequest, "language"));
		// 0 là dạng bt, 1 là dạng lật sách
		tapChi.setLoaiTin(ParamUtil.getBoolean(actionRequest, "loaiTin") ? 1 : 0);
		// 0 là ko hiện bl, 1 là hiện bl
		tapChi.setIsFormHienBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormHienBinhLuan") ? 1 : 0);
		tapChi.setIsFormViewBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormViewBinhLuan") ? 1 : 0);
		
		//0 là lưu nháp | 1 lưu và gửi bbt | 2 lưu và gửi xuat ban | 3 xuất bản
		if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
			tapChi.setStatus(1);
			AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(tapChi);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			objLog.setNguoiNhan(0);
			objLog.setStatus(1);
			objLog.setNoiDungLog("Gửi biên tập viên");			
			AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
			tapChi.setStatus(2);
			AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(tapChi);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			objLog.setNguoiNhan(0);
			objLog.setStatus(2);
			objLog.setNoiDungLog("Lưu và trình phê duyệt");			
			AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
			tapChi.setStatus(3);
			AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(tapChi);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			objLog.setNguoiNhan(0);
			objLog.setStatus(3);
			objLog.setNoiDungLog("Xuất bản");
			AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhpheduyet")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			tapChi.setPhienBan(tapChi.getPhienBan() + 1);
			//objectNews.setModifiedtime(objectNews.getModifiedtime());
			tapChi.setNgaySua(date);
			AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(tapChi);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			if(tapChi.getStatus() == 5) {
				objLog.setNguoiXuLy(themeDisplay.getUserId());
				objLog.setNoiDungLog("Đã hiệu chỉnh nội dung ấn phẩm và trình biên tập");
				List<AnPham_Activity> listOldActi = QlanphamAdminUtil.listAnPhamAtivityBydeCuongIdAndAnPhamId(0, tapChi.getId());
				if(listOldActi.size()>0){
					objLog.setNguoiNhan(listOldActi.get(0).getStartuserid());
				}else {
					objLog.setNguoiNhan(tapChi.getNguoiSua());
				}

			}else {
				objLog.setNguoiNhan(themeDisplay.getUserId());			
			}
			if(tapChi.getStatus() == 5){
				if(role.getRole_edit()==1){
					tapChi.setStatus(2);
				}else if(role.getRole_add()==1) {
					tapChi.setStatus(1);
				}
			}
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhxuatban")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			tapChi.setPhienBan(tapChi.getPhienBan() + 1);
			//objectNews.setModifiedtime(objectNews.getModifiedtime());
			tapChi.setNgaySua(date);
			AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(tapChi);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			if(tapChi.getStatus() == 5) {
				objLog.setNguoiXuLy(themeDisplay.getUserId());
				objLog.setNoiDungLog("Đã hiệu chỉnh nội dung ấn phẩm và trình phê duyệt");
				List<AnPham_Activity> listOldActi = QlanphamAdminUtil.listAnPhamAtivityBydeCuongIdAndAnPhamId(0, tapChi.getId());
				if(listOldActi.size()>0){
					objLog.setNguoiNhan(listOldActi.get(0).getStartuserid());
				}else {
					objLog.setNguoiNhan(tapChi.getNguoiSua());
				}

			}else {
				objLog.setNguoiNhan(themeDisplay.getUserId());			
			}
			if(tapChi.getStatus() == 5){
				if(role.getRole_edit()==1){
					tapChi.setStatus(2);
				}else if(role.getRole_add()==1) {
					tapChi.setStatus(1);
				}
			}
			objLog.setStatus(tapChi.getStatus());
			AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
		}
		
		tapChi.setOrders(ParamUtil.getLong(actionRequest, "orders"));
		
//		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF2(themeDisplay, uploadPortletRequest, "fileDinhKem");
		
		if(fileNamedinhkem.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(AnPham_DinhKemFile.class.getName());
			AnPham_DinhKemFile filedinhkem = AnPham_DinhKemFileLocalServiceUtil.createAnPham_DinhKemFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(tapChi.getId());
			filedinhkem.setTen(fileNamedinhkem.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileNamedinhkem.get(1));
			filedinhkem.setUserId(themeDisplay.getUserId());
			AnPham_DinhKemFileLocalServiceUtil.addAnPham_DinhKemFile(filedinhkem);
		}		
		AnPham_TapChiLocalServiceUtil.updateAnPham_TapChi(tapChi);
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", tapChi);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	public void saveYeuCauHieuChinh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = CounterLocalServiceUtil.increment(AnPham_Activity.class.getName());
		long idTapChi = ParamUtil.getLong(actionRequest, "idTapChi");
		String noidung  = ParamUtil.getString(actionRequest, "noidung");
		News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
		AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.getAnPham_TapChi(idTapChi);
		AnPham_Activity objActive = AnPham_ActivityLocalServiceUtil.createAnPham_Activity(id);
		AnPham_Logs objLog = QlanphamAdminUtil.requestobjLog(objTapChi); 
		
		if(Validator.isNotNull(idTapChi) && idTapChi > 0){
			List<AnPham_Activity> listOldAct = QlanphamAdminUtil.listAnPhamAtivityBydeCuongIdAndAnPhamId(0,idTapChi);
			if(listOldAct.size()>0){
				for(AnPham_Activity objAct: listOldAct){
					AnPham_ActivityLocalServiceUtil.deleteAnPham_Activity(objAct);
				}
			}
			objActive.setCompanyId(themeDisplay.getCompanyId());
			objActive.setGroupId(themeDisplay.getScopeGroupId());
			objActive.setContentrequest(noidung);
			objActive.setStatusofarticle(5);
			objActive.setAnPhamId(idTapChi);
			objActive.setStartuserid(themeDisplay.getUserId());
				
			if(role.getRole_edit()==1 || role.getRole_public()==1){
				objActive.setEnduserid(objTapChi.getNguoiTao());
			}else {
				objActive.setEnduserid(objTapChi.getNguoiSua());
			}
			//System.out.println(objNews.getModifiedby());
			AnPham_ActivityLocalServiceUtil.addAnPham_Activity(objActive);
			objTapChi.setPhienBan(objTapChi.getPhienBan() + 1);
			objTapChi.setStatus(5);
			objTapChi.setNguoiSua(themeDisplay.getUserId());
			AnPham_TapChiLocalServiceUtil.updateAnPham_TapChi(objTapChi);
			
			// Lưu log khi hiệu chỉnh
			objLog.setPhienBan(objTapChi.getPhienBan());
			objLog.setNoiDungLog("Yêu cầu hiệu chỉnh bài viết");
			objLog.setStatus(5);
			objLog.setNguoiXuLy(themeDisplay.getUserId());
			if(role.getRole_edit()==1){
				objLog.setNguoiNhan(objTapChi.getNguoiTao());
			}else if(role.getRole_public()==1){
				objLog.setNguoiNhan(objTapChi.getNguoiTao());
			}
			AnPham_LogsLocalServiceUtil.addAnPham_Logs(objLog);
			SessionMessages.add(actionRequest,"");
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(redirectURL.toString());
		}
	}
	
	public void deleteFileDinhKem(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long idFile = ParamUtil.getLong(actionRequest, "id");		
		
		if(Validator.isNotNull(idFile)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			AnPham_DinhKemFile filedinhkem = AnPham_DinhKemFileLocalServiceUtil.fetchAnPham_DinhKemFile(idFile);
			boolean flag = DocumentUpload.deleteFile(themeDisplay, filedinhkem.getTen());
			if(flag == true){
				AnPham_DinhKemFileLocalServiceUtil.deleteAnPham_DinhKemFile(filedinhkem);
			}
			SessionMessages.add(actionRequest,"delete-successfully");
			actionRequest.setAttribute("flag", flag);
		}
	}
	
	@ProcessAction(name = "deleteAnPhamXuatBan")
	public void deleteAnPhamXuatBan(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		if(Validator.isNotNull(id)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(id);
			objTapChi.setStatus(0);
			objTapChi.setDelete_status(1);
			AnPham_TapChiLocalServiceUtil.updateAnPham_TapChi(objTapChi);
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(redirectURL.toString());
		}
	}
	
	@ProcessAction(name = "recoveryAnPhamXB")
	public void recoveryAnPhamXB(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		if(Validator.isNotNull(id)){
			AnPham_TapChi objTapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(id);
			objTapChi.setStatus(0);
			objTapChi.setDelete_status(0);
			AnPham_TapChiLocalServiceUtil.updateAnPham_TapChi(objTapChi);
			SessionMessages.add(actionRequest, "recoveryAnPhamXB");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/anphamxuatban/trash.jsp");
		}
	}
	
	@ProcessAction(name = "xoaVinhVienAnPhamXB")
	public void xoaVinhVienAnPhamXB(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(Validator.isNotNull(id)){
			List<AnPham_Activity> objActivity = QlanphamAdminUtil.listAnPhamAtivityBydeCuongIdAndAnPhamId(0, id);
			for(AnPham_Activity ac : objActivity) {
				AnPham_ActivityLocalServiceUtil.deleteAnPham_Activity(ac);
			}
			List<AnPham_Logs> objLog = QlanphamAdminUtil.getAnPhamLogByAnPhamId(id);
			for(AnPham_Logs log : objLog) {
				AnPham_LogsLocalServiceUtil.deleteAnPham_Logs(log);
			}
			List<AnPham_DinhKemFile> listDinhKem = DocumentUpload.getLinkdinhkembyIdAndObject(id, 9);
			if(listDinhKem.size() > 0){
				for(int c = 0; c < listDinhKem.size(); c++){
					boolean flag = DocumentUpload.deleteFile(themeDisplay, listDinhKem.get(c).getTen());
					if(flag){
						AnPham_DinhKemFileLocalServiceUtil.deleteAnPham_DinhKemFile(listDinhKem.get(c));
					}
				}
			}
			AnPham_TapChiLocalServiceUtil.deleteAnPham_TapChi(id);
			SessionMessages.add(actionRequest, "xoaVinhVienTapChi");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/tapchiktxh/trash.jsp");
		}
	}
	
	@Reference
    private ItemSelector itemSelector;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        ImageItemSelectorCriterion imageItemSelectorCriterion =
        	    new ImageItemSelectorCriterion();
        
        List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();
        desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
    	imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
    		    desiredItemSelectorReturnTypes);
        
        PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(
            RequestBackedPortletURLFactoryUtil.create(renderRequest),
            "itemSelectedEventName", 
            imageItemSelectorCriterion
        );

        renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());

        super.doView(renderRequest, renderResponse);
    }
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
    		throws IOException, PortletException {
    	String resourceID = resourceRequest.getResourceID();
    	JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
    	long loaiId = ParamUtil.getLong(resourceRequest, "loaiId");
    	if ("ajaxAction1".equals(resourceID)) {
			try {
				List<AnPham_DeCuong> listDeCuong = QlanphamAdminUtil.listDeCuong("", String.valueOf(loaiId), 3, 0, 0);
				for (AnPham_DeCuong dc : listDeCuong) {
					JSONObject jsonDeCuong = JSONFactoryUtil.createJSONObject();
					jsonDeCuong.put("id", dc.getId());
					jsonDeCuong.put("ten", dc.getTen());
					jsonArray.put(jsonDeCuong);
				}
				resourceResponse.getWriter().write(jsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if("ajaxAction2".equals(resourceID)) {
			try {
				List<AnPham_DeCuong> listDeCuong = QlanphamAdminUtil.listDeCuong("", String.valueOf(loaiId), 3, 0, 0);
				for (AnPham_DeCuong dc : listDeCuong) {
					JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
					jsonResponse.put("id", dc.getId());
					jsonResponse.put("ten", dc.getTen());
					jsonArray.put(jsonResponse);
				}
				resourceResponse.getWriter().write(jsonArray.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
}
