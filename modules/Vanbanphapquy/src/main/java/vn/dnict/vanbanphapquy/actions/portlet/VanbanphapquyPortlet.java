package vn.dnict.vanbanphapquy.actions.portlet;


import vn.dnict.vanbanphapquy.actions.constants.VanbanphapquyPortletKeys;
import vn.dnict.vanbanphapquy.model.Capbanhanh;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;
import vn.dnict.vanbanphapquy.model.Linhvucvanban;
import vn.dnict.vanbanphapquy.model.Loaivanban;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;
import vn.dnict.vanbanphapquy.model.dinhkemfile;
import vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.dinhkemfileLocalServiceUtil;
import vn.dnict.vanbanphapquy.utils.DocumentUpload;

import javax.portlet.ProcessAction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

/**
 * @author BinhNT
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name= Quản lý văn bản",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/vanbanphapquyadmin/view.jsp",
		"javax.portlet.name=" + VanbanphapquyPortletKeys.VANBANPHAPQUY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class VanbanphapquyPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(VanbanphapquyPortlet.class);
	protected String editCapbanhanhJSP = "/html/vanbanphapquyadmin/capbanhanh/edit.jsp";
	protected String editCoquanbanhanhJSP = "/html/vanbanphapquyadmin/coquanbanhanh/edit.jsp";
	protected String editLoaivanbanJSP = "/html/vanbanphapquyadmin/loaivanban/edit.jsp";
	protected String editLinhvucvanbanJSP = "/html/vanbanphapquyadmin/linhvuc/edit.jsp";
	protected String editVanbanphapquyJSP = "/html/vanbanphapquyadmin/vanbanphapquy/edit.jsp";
	protected String viewJSP = "/html/vanbanphapquyadmin/view.jsp";
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "addCapbanhanh")
	public void addCapbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		long id = CounterLocalServiceUtil.increment(Capbanhanh.class.getName());	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		Capbanhanh capbanhanh = CapbanhanhLocalServiceUtil.createCapbanhanh(id); 
		capbanhanh.setId(id);
		capbanhanh.setCompanyId(themeDisplay.getCompanyId());
		capbanhanh.setGroupId(themeDisplay.getScopeGroupId());
		capbanhanh.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		capbanhanh.setCode(HtmlUtil.escape(ParamUtil.getString(actionRequest, "code")));
		capbanhanh.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0); 
		CapbanhanhLocalServiceUtil.addCapbanhanh(capbanhanh);
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editCapbanhanh")
	public void editCapbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			Capbanhanh editCapbanhanh = CapbanhanhLocalServiceUtil.fetchCapbanhanh(id);
			actionRequest.setAttribute("editCapbanhanh", editCapbanhanh);
			actionResponse.setRenderParameter("jspPage", editCapbanhanhJSP);
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateCapbanhanh")
	public void updateCapbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name", GetterUtil.DEFAULT_STRING));	
		String code = HtmlUtil.escape(ParamUtil.getString(actionRequest, "code", GetterUtil.DEFAULT_STRING));
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		Capbanhanh results = null;
		try {
			results = CapbanhanhLocalServiceUtil.fetchCapbanhanh(id);	
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
			if(Validator.isNotNull(id)) {
				results.setName(name);
				results.setCode(code);
				results.setStatus(status);
				CapbanhanhLocalServiceUtil.updateCapbanhanh(results);
				SessionMessages.add(actionRequest, "link-update-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());			

	}
	
	@SuppressWarnings("deprecation")
	public void deleteCapbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				CapbanhanhLocalServiceUtil.deleteCapbanhanh(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", viewJSP);
			redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs1"));
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-delete-successfully");
		}	
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "addCoquanbanhanh")
	public void addCoquanbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		long id = CounterLocalServiceUtil.increment(Capbanhanh.class.getName());	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		Coquanbanhanh cqbh = CoquanbanhanhLocalServiceUtil.createCoquanbanhanh(id); 
		cqbh.setId(id);
		cqbh.setCompanyId(themeDisplay.getCompanyId());
		cqbh.setGroupId(themeDisplay.getScopeGroupId());
		cqbh.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		cqbh.setCode(HtmlUtil.escape(ParamUtil.getString(actionRequest, "code")));
		cqbh.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0); 
		CoquanbanhanhLocalServiceUtil.addCoquanbanhanh(cqbh);
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editCoquanbanhanh")
	public void editCoquanbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			Coquanbanhanh editCoquanbanhanh = CoquanbanhanhLocalServiceUtil.fetchCoquanbanhanh(id);
			actionRequest.setAttribute("editCoquanbanhanh", editCoquanbanhanh);
			actionResponse.setRenderParameter("jspPage", editCoquanbanhanhJSP);
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateCoquanbanhanh")
	public void updateCoquanbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name", GetterUtil.DEFAULT_STRING));	
		String code = HtmlUtil.escape(ParamUtil.getString(actionRequest, "code", GetterUtil.DEFAULT_STRING));
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		Coquanbanhanh results = null;
		try {
			results = CoquanbanhanhLocalServiceUtil.fetchCoquanbanhanh(id);	
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
			if(Validator.isNotNull(id)) {
				results.setName(name);
				results.setCode(code);
				results.setStatus(status);
				CoquanbanhanhLocalServiceUtil.updateCoquanbanhanh(results);
				SessionMessages.add(actionRequest, "link-update-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());			

	}
	
	@SuppressWarnings("deprecation")
	public void deleteCoquanbanhanh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				CoquanbanhanhLocalServiceUtil.deleteCoquanbanhanh(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", viewJSP);
			redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs1"));
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-delete-successfully");
		}	
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "addLoaivanban")
	public void addLoaivanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		long id = CounterLocalServiceUtil.increment(Capbanhanh.class.getName());	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		Loaivanban lvb = LoaivanbanLocalServiceUtil.createLoaivanban(id); 
		lvb.setId(id);
		lvb.setCompanyId(themeDisplay.getCompanyId());
		lvb.setGroupId(themeDisplay.getScopeGroupId());
		lvb.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		lvb.setCode(HtmlUtil.escape(ParamUtil.getString(actionRequest, "code")));
		lvb.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0); 
		LoaivanbanLocalServiceUtil.addLoaivanban(lvb);
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editLoaivanban")
	public void editLoaivanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			Loaivanban editLoaivanban = LoaivanbanLocalServiceUtil.fetchLoaivanban(id);
			actionRequest.setAttribute("editLoaivanban", editLoaivanban);
			actionResponse.setRenderParameter("jspPage", editLoaivanbanJSP);
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateLoaivanban")
	public void updateLoaivanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name", GetterUtil.DEFAULT_STRING));	
		String code = HtmlUtil.escape(ParamUtil.getString(actionRequest, "code", GetterUtil.DEFAULT_STRING));
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		Loaivanban results = null;
		try {
			results = LoaivanbanLocalServiceUtil.fetchLoaivanban(id);	
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
			if(Validator.isNotNull(id)) {
				results.setName(name);
				results.setCode(code);
				results.setStatus(status);
				LoaivanbanLocalServiceUtil.updateLoaivanban(results);
				SessionMessages.add(actionRequest, "link-update-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());			

	}
	
	@SuppressWarnings("deprecation")
	public void deleteLoaivanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		if(Validator.isNotNull(id)){
			try {
				LoaivanbanLocalServiceUtil.deleteLoaivanban(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", viewJSP);
			redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs1"));
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-delete-successfully");
		}	
	}
	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "addLoaivanban")
	public void addLinhvucvanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		long id = CounterLocalServiceUtil.increment(Capbanhanh.class.getName());	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		Linhvucvanban lvvb = LinhvucvanbanLocalServiceUtil.createLinhvucvanban(id); 
		lvvb.setId(id);
		lvvb.setCompanyId(themeDisplay.getCompanyId());
		lvvb.setGroupId(themeDisplay.getScopeGroupId());
		lvvb.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		lvvb.setCode(HtmlUtil.escape(ParamUtil.getString(actionRequest, "code")));
		lvvb.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0); 
		LinhvucvanbanLocalServiceUtil.addLinhvucvanban(lvvb);
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editLinhvucvanban")
	public void editLinhvucvanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			Linhvucvanban editLinhvucvanban = LinhvucvanbanLocalServiceUtil.fetchLinhvucvanban(id);
			actionRequest.setAttribute("editLinhvucvanban", editLinhvucvanban);
			actionResponse.setRenderParameter("jspPage", editLinhvucvanbanJSP);
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateLoaivanban")
	public void updateLinhvucvanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name", GetterUtil.DEFAULT_STRING));	
		String code = HtmlUtil.escape(ParamUtil.getString(actionRequest, "code", GetterUtil.DEFAULT_STRING));
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		Linhvucvanban results = null;
		try {
			results = LinhvucvanbanLocalServiceUtil.fetchLinhvucvanban(id);	
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
			if(Validator.isNotNull(id)) {
				results.setName(name);
				results.setCode(code);
				results.setStatus(status);
				LinhvucvanbanLocalServiceUtil.updateLinhvucvanban(results);
				SessionMessages.add(actionRequest, "link-update-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());			

	}
	
	@SuppressWarnings("deprecation")
	public void deleteLinhvucvanban(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				LinhvucvanbanLocalServiceUtil.deleteLinhvucvanban(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", viewJSP);
			redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs1"));
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-delete-successfully");
		}	
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "addVanbanphapquy")
	public void addVanbanphapquy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception { 
		long id = CounterLocalServiceUtil.increment(Vanbanphapquy.class.getName());
		List<String> fileNamedinhkem = new ArrayList<String>();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		Vanbanphapquy vbpq = VanbanphapquyLocalServiceUtil.createVanbanphapquy(id); 
		vbpq.setId(id);
		vbpq.setCompanyId(themeDisplay.getCompanyId());
		vbpq.setGroupId(themeDisplay.getScopeGroupId());
		vbpq.setSohieu(HtmlUtil.escape(ParamUtil.getString(actionRequest, "sohieu")));
		vbpq.setTrichyeu(HtmlUtil.escape(ParamUtil.getString(actionRequest, "trichyeu")));
		String noidung = HtmlUtil.escape(ParamUtil.getString(actionRequest, "noidung"));
		vbpq.setNoidung(noidung);
		vbpq.setNguoiky(HtmlUtil.escape(ParamUtil.getString(actionRequest, "nguoiky")));
		vbpq.setId_linhvuc(ParamUtil.getInteger(actionRequest, "id_linhvuc"));
		vbpq.setId_loaivanban(ParamUtil.getInteger(actionRequest, "id_loaivanban"));
		vbpq.setId_capbanhanh(ParamUtil.getInteger(actionRequest, "id_capbanhanh"));
		vbpq.setId_coquanbanhanh(ParamUtil.getInteger(actionRequest, "id_coquanbanhanh"));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		String ngaybanhanh = ParamUtil.getString(actionRequest, "ngay_banhanh");
		String ngayhieuluc = ParamUtil.getString(actionRequest, "ngay_hieuluc");
		String ngayhethieuluc = ParamUtil.getString(actionRequest,"ngay_hethieuluc");
		String ngayxuatban = ParamUtil.getString(actionRequest, "ngay_xuatban");
		Date date_ngaybanhanh = null;
		Date date_ngayhieuluc = null;
		Date date_ngayhethieuluc = null;
		Date date_xuatban = null;
		if (!ngaybanhanh.equals("")) {
			date_ngaybanhanh = ParamUtil.getDate(actionRequest, "ngay_banhanh", df);
		}
		if (!ngayhieuluc.equals("")) {
			date_ngayhieuluc = ParamUtil.getDate(actionRequest, "ngay_hieuluc", df);
		}
		if (!ngayhethieuluc.equals("")) {
			date_ngayhethieuluc = ParamUtil.getDate(actionRequest,"ngay_hethieuluc", df);
		}
		if (!ngayxuatban.equals("")) {
			date_xuatban = ParamUtil.getDate(actionRequest, "ngay_xuatban", df);
		}
		vbpq.setNgay_banhanh(date_ngaybanhanh);
		vbpq.setNgay_hieuluc(date_ngayhieuluc);
		vbpq.setNgay_hethieuluc(date_ngayhethieuluc);
		vbpq.setNgay_xuatban(date_xuatban);
		vbpq.setType(ParamUtil.getString(actionRequest, "kieuvanban"));
		vbpq.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0);
		
		
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		fileNamedinhkem = DocumentUpload.fileUpload(themeDisplay, uploadRequest,"");
		List<String> PDFlink = DocumentUpload.CoreFileDinhKemUpload(themeDisplay, uploadRequest, "CmsDnict_Upload", "This folder is create for Vanbanphapquy documents", "filePDF");
		if(PDFlink.size() > 0){
			dinhkemfile filedinhkem = dinhkemfileLocalServiceUtil.createdinhkemfile(id);
//			dinhkemfile filedinhkem = new dinhkemfileImpl();
			filedinhkem.setId(CounterLocalServiceUtil.increment(dinhkemfile.class.getName()));
			filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
			filedinhkem.setObjectId(vbpq.getId());
			filedinhkem.setTen(PDFlink.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			String urlPDF = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				urlPDF = PDFlink.get(1).substring(url_temp2.length());
			}
			filedinhkem.setUrl(urlPDF);
			dinhkemfileLocalServiceUtil.adddinhkemfile(filedinhkem);
			String noidungfile = vbpq.getNoidung()+"&&_phancach_&&"+urlPDF;
			vbpq.setNoidung(noidungfile);
		}
		if(fileNamedinhkem.size() > 0){
			for(String filename_tmp : fileNamedinhkem){
				dinhkemfile filedinhkem = dinhkemfileLocalServiceUtil.createdinhkemfile(id);
				filedinhkem.setId(CounterLocalServiceUtil.increment(dinhkemfile.class.getName()));
				filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
				filedinhkem.setObjectId(vbpq.getId());
				filedinhkem.setTen(filename_tmp);
				filedinhkem.setCompanyId(themeDisplay.getCompanyId());
				filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
				String url = "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
						DocumentUpload.getFolderWidthDLFolder(themeDisplay).getFolderId() +  "/" +filename_tmp;
				filedinhkem.setUrl(url);
				dinhkemfileLocalServiceUtil.adddinhkemfile(filedinhkem);
			}
		}
		
		
		VanbanphapquyLocalServiceUtil.addVanbanphapquy(vbpq);
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());
		SessionMessages.add(actionRequest, "link-saved-successfully");
	}
	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editVanbanphapquy")
	public void editVanbanphapquy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if (Validator.isNotNull(id)) {
			Vanbanphapquy editVanbanphapquy = VanbanphapquyLocalServiceUtil.fetchVanbanphapquy(id);
			actionRequest.setAttribute("editVanbanphapquy", editVanbanphapquy);
			actionResponse.setRenderParameter("jspPage", editVanbanphapquyJSP);
			SessionMessages.add(actionRequest,"");
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateVanbanphapquy")
	public void updateVanbanphapquy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> fileNamedinhkem = new ArrayList<String>();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		String sohieu = HtmlUtil.escape(ParamUtil.getString(actionRequest, "sohieu", GetterUtil.DEFAULT_STRING));	
		String trichyeu = HtmlUtil.escape(ParamUtil.getString(actionRequest, "trichyeu", GetterUtil.DEFAULT_STRING));
		String noidung = HtmlUtil.escape(ParamUtil.getString(actionRequest, "noidung", GetterUtil.DEFAULT_STRING));
		String nguoiky = HtmlUtil.escape(ParamUtil.getString(actionRequest, "nguoiky", GetterUtil.DEFAULT_STRING));
		int id_linhvuc = ParamUtil.getInteger(actionRequest, "id_linhvuc", GetterUtil.DEFAULT_INTEGER);
		int id_loaivanban = ParamUtil.getInteger(actionRequest, "id_loaivanban", GetterUtil.DEFAULT_INTEGER);
		int id_capbanhanh = ParamUtil.getInteger(actionRequest, "id_capbanhanh", GetterUtil.DEFAULT_INTEGER);
		int id_coquanbanhanh = ParamUtil.getInteger(actionRequest, "id_coquanbanhanh", GetterUtil.DEFAULT_INTEGER);
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		String ngaybanhanh = ParamUtil.getString(actionRequest, "ngay_banhanh", GetterUtil.DEFAULT_STRING);
		String ngayhieuluc = ParamUtil.getString(actionRequest, "ngay_hieuluc", GetterUtil.DEFAULT_STRING);
		String ngayhethieuluc = ParamUtil.getString(actionRequest,"ngay_hethieuluc", GetterUtil.DEFAULT_STRING);
		String ngayxuatban = ParamUtil.getString(actionRequest, "ngay_xuatban", GetterUtil.DEFAULT_STRING);
		Date date_ngaybanhanh = null;
		Date date_ngayhieuluc = null;
		Date date_ngayhethieuluc = null;
		Date date_xuatban = null;
		if (!ngaybanhanh.equals("")) {
			date_ngaybanhanh = ParamUtil.getDate(actionRequest, "ngay_banhanh", df);
		}
		if (!ngayhieuluc.equals("")) {
			date_ngayhieuluc = ParamUtil.getDate(actionRequest, "ngay_hieuluc", df);
		}
		if (!ngayhethieuluc.equals("")) {
			date_ngayhethieuluc = ParamUtil.getDate(actionRequest,"ngay_hethieuluc", df);
		}
		if (!ngayxuatban.equals("")) {
			date_xuatban = ParamUtil.getDate(actionRequest, "ngay_xuatban", df);
		}
		
		Vanbanphapquy results = null;
		try {
			results = VanbanphapquyLocalServiceUtil.fetchVanbanphapquy(id);	
		} catch (Exception e) {
			
			log.error(e.getCause(), e);
		}
			if(Validator.isNotNull(id)) {
				results.setSohieu(sohieu);
				results.setTrichyeu(trichyeu);
				results.setNoidung(noidung);
				results.setNguoiky(nguoiky);
				results.setId_linhvuc(id_linhvuc);
				results.setId_loaivanban(id_loaivanban);
				results.setId_capbanhanh(id_capbanhanh);
				results.setId_coquanbanhanh(id_coquanbanhanh);
				results.setNgay_banhanh(date_ngaybanhanh);
				results.setNgay_hieuluc(date_ngayhieuluc);
				results.setNgay_hethieuluc(date_ngayhethieuluc);
				results.setNgay_xuatban(date_xuatban);
				results.setStatus(status);
				
				
				DocumentUpload.createFolder(actionRequest, themeDisplay);
				fileNamedinhkem = DocumentUpload.fileUpload(themeDisplay, uploadRequest,"");
				List<String> PDFlink = DocumentUpload.CoreFileDinhKemUpload(themeDisplay, uploadRequest, "CmsDnict_Upload", "This folder is create for Vanbanphapquy documents", "filePDF");
				if(PDFlink.size() > 0){
					dinhkemfile filedinhkem = dinhkemfileLocalServiceUtil.createdinhkemfile(id);
//					dinhkemfile filedinhkem = new dinhkemfileImpl();
					filedinhkem.setId(CounterLocalServiceUtil.increment(dinhkemfile.class.getName()));
					filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
					filedinhkem.setObjectId(results.getId());
					filedinhkem.setTen(PDFlink.get(0));
					filedinhkem.setCompanyId(themeDisplay.getCompanyId());
					filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
					String urlPDF = "";
					String url_temp2 = themeDisplay.getPortalURL();
					if(url_temp2.length() > 0){
						urlPDF = PDFlink.get(1).substring(url_temp2.length());
					}
					filedinhkem.setUrl(urlPDF);
					dinhkemfileLocalServiceUtil.adddinhkemfile(filedinhkem);
					String noidungfile = results.getNoidung()+"&&_phancach_&&"+urlPDF;
					results.setNoidung(noidungfile);
				}
				if(fileNamedinhkem.size() > 0){
					for(String filename_tmp : fileNamedinhkem){
						dinhkemfile filedinhkem = dinhkemfileLocalServiceUtil.createdinhkemfile(id);
						filedinhkem.setId(CounterLocalServiceUtil.increment(dinhkemfile.class.getName()));
						filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
						filedinhkem.setObjectId(results.getId());
						filedinhkem.setTen(filename_tmp);
						filedinhkem.setCompanyId(themeDisplay.getCompanyId());
						filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
						String url = "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
								DocumentUpload.getFolderWidthDLFolder(themeDisplay).getFolderId() +  "/" +filename_tmp;
						filedinhkem.setUrl(url);
						dinhkemfileLocalServiceUtil.adddinhkemfile(filedinhkem);
					}
				}
				
				
				VanbanphapquyLocalServiceUtil.updateVanbanphapquy(results);
				SessionMessages.add(actionRequest, "link-update-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		actionResponse.sendRedirect(redirectURL.toString());			

	}
	
	@SuppressWarnings("deprecation")
	public void deleteVanbanphapquy(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			try {
				VanbanphapquyLocalServiceUtil.deleteVanbanphapquy(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("jspPage", viewJSP);
			redirectURL.setParameter("tabs", ParamUtil.getString(actionRequest, "tabs1"));
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "link-delete-successfully");
		}	
	}
	
	public void deleteFileAtt(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long idFile = ParamUtil.getLong(actionRequest, "id");		
		
		if(Validator.isNotNull(idFile)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			dinhkemfile filedinhkem = dinhkemfileLocalServiceUtil.fetchdinhkemfile(idFile);
			boolean flag = DocumentUpload.deleteFile(themeDisplay, filedinhkem.getTen());
			//System.out.println(flag);
			if(flag == true){
				dinhkemfileLocalServiceUtil.deletedinhkemfile(filedinhkem);
			}
			SessionMessages.add(actionRequest,"delete-successfully");
			actionRequest.setAttribute("flag", flag);
		}
	}
	
}