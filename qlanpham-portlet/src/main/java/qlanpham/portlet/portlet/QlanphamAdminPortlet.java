package qlanpham.portlet.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanpham.portlet.utils.PhanQuyenAdminUtil;
import qlanpham.portlet.utils.QlanphamAdminUtil;
import qlanphamdb.model.AnPham_Activity;
import qlanphamdb.model.AnPham_CongTacVien;
import qlanphamdb.model.AnPham_DeCuong;
import qlanphamdb.model.AnPham_Loai;
import qlanphamdb.model.AnPham_PhanCong;
import qlanphamdb.service.AnPham_ActivityLocalServiceUtil;
import qlanphamdb.service.AnPham_CongTacVienLocalServiceUtil;
import qlanphamdb.service.AnPham_DeCuongLocalServiceUtil;
import qlanphamdb.service.AnPham_LoaiLocalServiceUtil;
import qlanphamdb.service.AnPham_PhanCongLocalServiceUtil;
import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_ActivityLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý đề cương",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.QLANPHAMADMIN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class QlanphamAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(QlanphamAdminPortlet.class);
		
	@SuppressWarnings("deprecation")
	public void saveDmLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabDmLoai = QlanphamAdminField.value_tabdmloai;
		long id = CounterLocalServiceUtil.increment(AnPham_Loai.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AnPham_Loai objDmLoai = AnPham_LoaiLocalServiceUtil.createAnPham_Loai(id);
		objDmLoai.setCompanyId(themeDisplay.getCompanyId());
		objDmLoai.setGroupId(themeDisplay.getScopeGroupId());
		objDmLoai.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
		objDmLoai.setOrders(ParamUtil.getLong(actionRequest, "orders"));
		objDmLoai.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0);
		objDmLoai.setDelete_status(0);
		objDmLoai = AnPham_LoaiLocalServiceUtil.addAnPham_Loai(objDmLoai);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDmLoai);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	public void editDmLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			AnPham_Loai dmLoai = AnPham_LoaiLocalServiceUtil.fetchAnPham_Loai(id);
			actionRequest.setAttribute("dmLoai", dmLoai);
			actionResponse.setRenderParameter("jspPage", "/html/admin/dmloai/edit.jsp");
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateDmLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabDmLoai = QlanphamAdminField.value_tabdmloai;
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String ten = HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten", GetterUtil.DEFAULT_STRING));
		int orders = ParamUtil.getInteger(actionRequest, "orders", GetterUtil.DEFAULT_INTEGER);	
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;			
		AnPham_Loai obj = null;
		try {
			obj = AnPham_LoaiLocalServiceUtil.fetchAnPham_Loai(id);
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
		if(Validator.isNotNull(id)) {
			obj.setTen(ten);
			obj.setOrders(orders);
			obj.setStatus(status);
			AnPham_LoaiLocalServiceUtil.updateAnPham_Loai(obj);
			SessionMessages.add(actionRequest, "link-update-successfully");
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDmLoai);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void deleteDmLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDmLoai = QlanphamAdminField.value_tabdmloai;
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				AnPham_LoaiLocalServiceUtil.deleteAnPham_Loai(id);
				SessionMessages.add(actionRequest, "link-delete-successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", "/html/admin/dmloai/view.jsp");
			redirectURL.setParameter("tabs", tabDmLoai);
			actionResponse.sendRedirect(redirectURL.toString());			
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void saveCTV(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabCongTacVien = QlanphamAdminField.value_tabcongtacvien;
		long id = CounterLocalServiceUtil.increment(AnPham_CongTacVien.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AnPham_CongTacVien objCongTacVien = AnPham_CongTacVienLocalServiceUtil.createAnPham_CongTacVien(id);
		objCongTacVien.setCompanyId(themeDisplay.getCompanyId());
		objCongTacVien.setGroupId(themeDisplay.getScopeGroupId());
		objCongTacVien.setHoTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "hoTen")));
		objCongTacVien.setEmail(HtmlUtil.escape(ParamUtil.getString(actionRequest, "email")));
		objCongTacVien.setThongTin(HtmlUtil.escape(ParamUtil.getString(actionRequest, "thongTin")));
		objCongTacVien.setOrders(ParamUtil.getLong(actionRequest, "orders"));
		objCongTacVien.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0);
		objCongTacVien.setDelete_status(0);
		objCongTacVien = AnPham_CongTacVienLocalServiceUtil.addAnPham_CongTacVien(objCongTacVien);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabCongTacVien);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	public void editCTV(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			AnPham_CongTacVien objCongTacVien = AnPham_CongTacVienLocalServiceUtil.fetchAnPham_CongTacVien(id);
			actionRequest.setAttribute("congTacVien", objCongTacVien);
			actionResponse.setRenderParameter("jspPage", "/html/admin/congtacvien/edit.jsp");
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateCTV(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabCongTacVien = QlanphamAdminField.value_tabcongtacvien;
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String hoTen = HtmlUtil.escape(ParamUtil.getString(actionRequest, "hoTen", GetterUtil.DEFAULT_STRING));
		String email = HtmlUtil.escape(ParamUtil.getString(actionRequest, "email", GetterUtil.DEFAULT_STRING));
		String thongTin = HtmlUtil.escape(ParamUtil.getString(actionRequest, "thongTin", GetterUtil.DEFAULT_STRING));
		int orders = ParamUtil.getInteger(actionRequest, "orders", GetterUtil.DEFAULT_INTEGER);	
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;			
		AnPham_CongTacVien obj = null;
		try {
			obj = AnPham_CongTacVienLocalServiceUtil.fetchAnPham_CongTacVien(id);
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
		if(Validator.isNotNull(id)) {
			obj.setHoTen(hoTen);
			obj.setEmail(email);
			obj.setThongTin(thongTin);
			obj.setOrders(orders);
			obj.setStatus(status);
			AnPham_CongTacVienLocalServiceUtil.updateAnPham_CongTacVien(obj);
			SessionMessages.add(actionRequest, "link-update-successfully");
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabCongTacVien);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void deleteCTV(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabCongTacVien = QlanphamAdminField.value_tabcongtacvien;
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				AnPham_CongTacVienLocalServiceUtil.deleteAnPham_CongTacVien(id);
				SessionMessages.add(actionRequest, "link-delete-successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", "/html/admin/congtacvien/view.jsp");
			redirectURL.setParameter("tabs", tabCongTacVien);
			actionResponse.sendRedirect(redirectURL.toString());			
		}	
	}
	
	@SuppressWarnings("deprecation")
	public void saveDeCuong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDeCuong = QlanphamAdminField.value_tabdecuong;
		long id = CounterLocalServiceUtil.increment(AnPham_DeCuongLocalServiceUtil.class.getName());
		long loaiId = ParamUtil.getLong(actionRequest, "loaiId");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AnPham_DeCuong objDeCuong = AnPham_DeCuongLocalServiceUtil.createAnPham_DeCuong(id);
		objDeCuong.setId(id);
		objDeCuong.setCompanyId(themeDisplay.getCompanyId());
		objDeCuong.setGroupId(themeDisplay.getScopeGroupId());
		objDeCuong.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
		objDeCuong.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
		objDeCuong.setNoiDung(ParamUtil.getString(actionRequest, "noiDung"));
		if(Validator.isNotNull(loaiId)) {
			objDeCuong.setLoaiId(Long.valueOf(loaiId));
		}
		objDeCuong.setOrders(ParamUtil.getLong(actionRequest, "orders"));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date);
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
			String ngaytao = ParamUtil.getString(actionRequest, "ngaytao")+":00";			
			objDeCuong.setNgayTao(df.parse(ngaytao));			
		}else {
			objDeCuong.setNgayTao(df.parse(ngayhientai));
		}
		objDeCuong.setNguoiTao(themeDisplay.getUserId());	
		
		// status
		if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
			objDeCuong.setStatus(1);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
			objDeCuong.setStatus(2);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
			objDeCuong.setStatus(3);
		}else {
			objDeCuong.setStatus(0);
		}
		
		objDeCuong.setDelete_status(0);
		AnPham_DeCuongLocalServiceUtil.addAnPham_DeCuong(objDeCuong);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDeCuong);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	public void editDeCuong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			AnPham_DeCuong objDeCuong = AnPham_DeCuongLocalServiceUtil.fetchAnPham_DeCuong(id);
			actionRequest.setAttribute("deCuong", objDeCuong);
			actionResponse.setRenderParameter("jspPage", "/html/admin/decuong/edit.jsp");
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void updateDeCuong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDeCuong = QlanphamAdminField.value_tabdecuong;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date date = new Date();
		long id = ParamUtil.getLong(actionRequest, "id");		
		long loaiId = ParamUtil.getLong(actionRequest, "loaiId");		
		AnPham_DeCuong objDeCuong = AnPham_DeCuongLocalServiceUtil.fetchAnPham_DeCuong(id);
		if(Validator.isNotNull(id)) {
			objDeCuong.setId(id);
			objDeCuong.setCompanyId(themeDisplay.getCompanyId());
			objDeCuong.setGroupId(themeDisplay.getScopeGroupId());
			objDeCuong.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
			objDeCuong.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
			objDeCuong.setNoiDung(ParamUtil.getString(actionRequest, "noiDung"));
			objDeCuong.setLoaiId(loaiId);
			
			if(ParamUtil.getString(actionRequest, "typeaction").equals("luu")) {
				objDeCuong.setStatus(0);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
				objDeCuong.setStatus(1);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
				objDeCuong.setStatus(2);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
				objDeCuong.setStatus(3);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhpheduyet")){
				News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
				objDeCuong.setPhienBan(objDeCuong.getPhienBan() + 1);
				//objectNews.setModifiedtime(objectNews.getModifiedtime());
				objDeCuong.setNgaySua(date);
				if(objDeCuong.getStatus() == 5){
					if(role.getRole_edit()==1){
						objDeCuong.setStatus(2);
					}else if(role.getRole_add()==1) {
						objDeCuong.setStatus(1);
					}
				}
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhxuatban")){
				News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
				objDeCuong.setPhienBan(objDeCuong.getPhienBan() + 1);
				//objectNews.setModifiedtime(objectNews.getModifiedtime());
				objDeCuong.setNgaySua(date);
				if(objDeCuong.getStatus() == 5){
					if(role.getRole_edit()==1){
						objDeCuong.setStatus(2);
					}else if(role.getRole_add()==1) {
						objDeCuong.setStatus(1);
					}
				}
			}
			objDeCuong.setDelete_status(0);
			objDeCuong.setOrders(ParamUtil.getLong(actionRequest, "orders"));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
				String ngaytao = ParamUtil.getString(actionRequest, "ngaytao")+":00";
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				objDeCuong.setNgayTao(df.parse(ngaytao));
			}else {
				objDeCuong.setNgayTao(date);
			}
			objDeCuong.setNgaySua(date);
			objDeCuong.setNguoiSua(themeDisplay.getUserId());
			objDeCuong.setPhienBan(objDeCuong.getPhienBan()+1);		
		}		
		AnPham_DeCuongLocalServiceUtil.updateAnPham_DeCuong(objDeCuong);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDeCuong);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	public static void saveYeuCauHieuChinh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDeCuong = QlanphamAdminField.value_tabdecuong;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = CounterLocalServiceUtil.increment(News_Activity.class.getName());
		long idDeCuong = ParamUtil.getLong(actionRequest, "idDeCuong");
		String noidung  = ParamUtil.getString(actionRequest, "noidung");
		News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
		AnPham_DeCuong objDeCuong = AnPham_DeCuongLocalServiceUtil.fetchAnPham_DeCuong(idDeCuong);
		AnPham_Activity objActive = AnPham_ActivityLocalServiceUtil.createAnPham_Activity(id); 
		
		if(Validator.isNotNull(idDeCuong) && idDeCuong > 0){
			List<AnPham_Activity> listOldAct = QlanphamAdminUtil.listAnPhamAtivityBydeCuongIdAndAnPhamId(idDeCuong,0);
			if(listOldAct.size()>0){
				for(AnPham_Activity objAct: listOldAct){
					AnPham_ActivityLocalServiceUtil.deleteAnPham_Activity(objAct);
				}
			}
			objActive.setCompanyId(themeDisplay.getCompanyId());
			objActive.setGroupId(themeDisplay.getScopeGroupId());
			objActive.setContentrequest(noidung);
			objActive.setStatusofarticle(5);
			objActive.setDeCuongId(idDeCuong);
			objActive.setStartuserid(themeDisplay.getUserId());
			
			
			
			if(role.getRole_edit()==1 || role.getRole_public()==1){
				objActive.setEnduserid(objDeCuong.getNguoiTao());
			}else {
				objActive.setEnduserid(objDeCuong.getNguoiSua());
			}
			//System.out.println(objNews.getModifiedby());
			AnPham_ActivityLocalServiceUtil.addAnPham_Activity(objActive);
			
			objDeCuong.setStatus(5);
			objDeCuong.setNguoiSua(themeDisplay.getUserId());
			AnPham_DeCuongLocalServiceUtil.updateAnPham_DeCuong(objDeCuong);
			
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("tabs", tabDeCuong);
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest,"");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void deleteDeCuong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDeCuong = QlanphamAdminField.value_tabdecuong;
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				AnPham_DeCuongLocalServiceUtil.deleteAnPham_DeCuong(id);
				SessionMessages.add(actionRequest, "link-delete-successfully");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", "/html/admin/decuong/view.jsp");
			redirectURL.setParameter("tabs", tabDeCuong);
			actionResponse.sendRedirect(redirectURL.toString());			
		}	
	}
	
	private void handleSendEmail(String mailnhan, String congtacvien,  String ngaybatdau, String ngayketthuc, String noidungphancong, String ghichu) {
		try {
			// Tạo mail biên tập viên
			MailMessage message = new MailMessage();
			message.setFrom(new InternetAddress("admin@example.com"));
			message.setTo(new InternetAddress(mailnhan));
			message.setSubject("Phân công công việc từ ngày " + ngaybatdau + " đến " + ngayketthuc);
			message.setBody(
					"Kính gửi anh/chị " + congtacvien + "," + 
					"<br><br>Nội dung công việc: " + noidungphancong + 
					"<br>Ghi chú: " + ghichu + 
					"<br><br>Chúng tôi gửi mail này báo cho anh/chị biết có công việc cần phải hoàn thành sắp tới." +
					"<br><strong>Ban Biên tập</strong>");
			message.setHTMLFormat(true); // Đặt định dạng email là HTML
	        
	        // Gửi mail biên tập viên
	        MailServiceUtil.sendEmail(message);
		} catch (Exception e) {
			log.error("Gửi email thất bại", e);
		}
	}
	
	@ProcessAction(name = "savePhanCong")
	public void savePhanCong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabPhanCong = QlanphamAdminField.value_tabphancong;
		long id = CounterLocalServiceUtil.increment(AnPham_DeCuongLocalServiceUtil.class.getName());
		long loaiId = ParamUtil.getLong(actionRequest, "loaiId");
		long deCuongId = ParamUtil.getLong(actionRequest, "deCuongId");
		long ctvId = ParamUtil.getLong(actionRequest, "ctvId");
		String noiDung = ParamUtil.getString(actionRequest, "noiDung");
		String ghiChu = ParamUtil.getString(actionRequest, "ghiChu");
		String ngaybatdau = ParamUtil.getString(actionRequest, "ngaybatdau");
		String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AnPham_PhanCong objPhanCong = AnPham_PhanCongLocalServiceUtil.createAnPham_PhanCong(id);
		objPhanCong.setId(id);
		objPhanCong.setCompanyId(themeDisplay.getCompanyId());
		objPhanCong.setGroupId(themeDisplay.getScopeGroupId());
		objPhanCong.setLoaiId(loaiId);
		objPhanCong.setDeCuongId(deCuongId);
		objPhanCong.setCtvId(ctvId);
		objPhanCong.setNoiDung(noiDung);
		objPhanCong.setGhiChu(ghiChu);
		
		// format date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaybatdau"))) {
			ngaybatdau +=":00";				
			objPhanCong.setNgaybatdau(df.parse(ngaybatdau));			
		}else {
			objPhanCong.setNgaybatdau(ngayhientaiGMT);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			ngayketthuc +=":00";				
			objPhanCong.setNgayketthuc(df.parse(ngayketthuc));			
		}else {
			objPhanCong.setNgayketthuc(ngayhientaiGMT);
		}
		objPhanCong.setStatus(ParamUtil.getInteger(actionRequest, "status"));
		
		// gui mail
		if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvaguiemail")){
			objPhanCong.setIs_gui(1);
			AnPham_CongTacVien ctv = AnPham_CongTacVienLocalServiceUtil.fetchAnPham_CongTacVien(objPhanCong.getCtvId());
			String emailCTV = ctv.getEmail();
			String congtacvien = ctv.getHoTen();
			handleSendEmail(emailCTV,congtacvien, ngaybatdau, ngayketthuc, noiDung, ghiChu);
		}
		
		AnPham_PhanCongLocalServiceUtil.addAnPham_PhanCong(objPhanCong);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabPhanCong);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "themphancongthanhcong");
	}
	
	@ProcessAction(name = "updatePhanCong")
	public void updatePhanCong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabPhanCong = QlanphamAdminField.value_tabphancong;
		long id = ParamUtil.getLong(actionRequest, "id");
		long loaiId = ParamUtil.getLong(actionRequest, "loaiId");
		long deCuongId = ParamUtil.getLong(actionRequest, "deCuongId");
		long ctvId = ParamUtil.getLong(actionRequest, "ctvId");
		String noiDung = ParamUtil.getString(actionRequest, "noiDung");
		String ghiChu = ParamUtil.getString(actionRequest, "ghiChu");
		String ngaybatdau = ParamUtil.getString(actionRequest, "ngaybatdau");
		String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		AnPham_PhanCong objPhanCong = AnPham_PhanCongLocalServiceUtil.fetchAnPham_PhanCong(id);
		if(Validator.isNotNull(objPhanCong)) {
			objPhanCong.setLoaiId(loaiId);
			objPhanCong.setDeCuongId(deCuongId);
			objPhanCong.setCtvId(ctvId);
			objPhanCong.setNoiDung(ParamUtil.getString(actionRequest, "noiDung"));
			objPhanCong.setGhiChu(ParamUtil.getString(actionRequest, "ghiChu"));
			
			// format date
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = df.format(date)+":00";
			
			// Chuyển đổi thành đối tượng Date với múi giờ UTC
			SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
			Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
			
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaybatdau"))) {
				ngaybatdau +=":00";			
				objPhanCong.setNgaybatdau(df.parse(ngaybatdau));			
			}else {
				objPhanCong.setNgaybatdau(ngayhientaiGMT);
			}
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
				ngayketthuc +=":00";			
				objPhanCong.setNgayketthuc(df.parse(ngayketthuc));			
			}else {
				objPhanCong.setNgayketthuc(ngayhientaiGMT);
			}
			objPhanCong.setStatus(ParamUtil.getInteger(actionRequest, "status"));
			
			// gui mail
			if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvaguiemail")){
				objPhanCong.setIs_gui(1);
				AnPham_CongTacVien ctv = AnPham_CongTacVienLocalServiceUtil.fetchAnPham_CongTacVien(objPhanCong.getCtvId());
				String emailCTV = ctv.getEmail();
				String congtacvien = ctv.getHoTen();
				handleSendEmail(emailCTV, congtacvien, ngaybatdau, ngayketthuc, noiDung, ghiChu);
			}
		}
		
		AnPham_PhanCongLocalServiceUtil.updateAnPham_PhanCong(objPhanCong);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabPhanCong);
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "suaphancongthanhcong");
	}
	
	@ProcessAction(name = "deletePhanCong")
	public void deletePhanCong(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabPhanCong = QlanphamAdminField.value_tabphancong;
		long id = ParamUtil.getLong(actionRequest, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(Validator.isNotNull(id)) {
			try {
				AnPham_PhanCongLocalServiceUtil.deleteAnPham_PhanCong(id);
				String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
				PortletURL redirectURL = PortletURLFactoryUtil
						.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
								themeDisplay.getLayout().getPlid(),
								PortletRequest.RENDER_PHASE);
				redirectURL.setParameter("tabs", tabPhanCong);
				actionResponse.sendRedirect(redirectURL.toString());
				SessionMessages.add(actionRequest, "xoaphancongthanhcong");
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "xoaphancongthatbai");
			}
		}
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		String resourceID = resourceRequest.getResourceID();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		
		if ("ajaxAction1".equals(resourceID)) {
			long loaiId = ParamUtil.getLong(resourceRequest, "loaiId");
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
			long deCuongId = ParamUtil.getLong(resourceRequest, "deCuongId");
			AnPham_DeCuong deCuong = AnPham_DeCuongLocalServiceUtil.fetchAnPham_DeCuong(deCuongId);
			String noiDung = (deCuong != null) ? deCuong.getNoiDung() : "Không có nội dung";
			resourceResponse.getWriter().write(noiDung);
		} else if("ajaxAction3".equals(resourceID)) {
			long loaiId = ParamUtil.getLong(resourceRequest, "loaiId");
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
