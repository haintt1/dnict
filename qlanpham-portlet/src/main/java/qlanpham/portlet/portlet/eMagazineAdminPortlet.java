package qlanpham.portlet.portlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanpham.portlet.utils.AnPhamConfig;
import qlanphamdb.model.eMagazine;
import qlanphamdb.model.eMagazine_template;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.eMagazine_templateLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Tạp chí điện tử (eMagazine)",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/eMagazine/tab.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.EMAGAZINE,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class eMagazineAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(eMagazineAdminPortlet.class);
	
	@ProcessAction(name = "saveeMagazine")
	public void saveeMagazine(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
		    long id = ParamUtil.getLong(actionRequest, "id", 0);
		    
		    // Nếu có ID thì lấy từ DB, nếu không thì tạo mới
		    eMagazine emagazine = (id > 0) ? eMagazineLocalServiceUtil.fetcheMagazine(id)
		                             : eMagazineLocalServiceUtil.createeMagazine(CounterLocalServiceUtil.increment());
			
			Date date = new Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			emagazine.setGroupId(themeDisplay.getScopeGroupId());
			emagazine.setCompanyId(themeDisplay.getCompanyId());
			emagazine.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
			emagazine.setSlug(HtmlUtil.escape(ParamUtil.getString(actionRequest, "slug")));
			emagazine.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
			emagazine.setAnhDaiDien(ParamUtil.getString(actionRequest, "selectedItem"));
			emagazine.setMauChuDao(ParamUtil.getString(actionRequest, "mauChuDao"));
			emagazine.setHinhNen(ParamUtil.getString(actionRequest, "hinhNen"));
			emagazine.setTemplateId(ParamUtil.getLong(actionRequest, "templateId"));
			String noiDung = ParamUtil.getString(actionRequest, "noiDung");
			if(Validator.isNotNull(noiDung)){
				noiDung = "<div class=\"content\">" + noiDung + "</div>";
			}
			emagazine.setNoiDung(noiDung);
			
			emagazine.setTuKhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
			emagazine.setPhienBan(1);
			emagazine.setNguoiTao(themeDisplay.getUserId());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = df.format(date);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayTao"))) {
				String ngayTao = ParamUtil.getString(actionRequest, "ngayTao")+":00";			
				emagazine.setNgayTao(df.parse(ngayTao));			
			}else {
				emagazine.setNgayTao(df.parse(ngayhientai));
			}
			emagazine.setLanguage(ParamUtil.getString(actionRequest, "language"));
			// 0 là ko hiện bl, 1 là hiện bl
			emagazine.setIsFormHienBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormHienBinhLuan") ? 1 : 0);
			emagazine.setIsFormViewBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormViewBinhLuan") ? 1 : 0);
			if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
				emagazine.setStatus(3);
			} else emagazine.setStatus(0); //0 là lưu nháp | 1 lưu và gửi bbt | 2 lưu và gửi xuat ban | 3 xuất bản
			emagazine.setOrders(ParamUtil.getLong(actionRequest, "orders"));
			emagazine.setDelete_status(0);
			
			String typeaction = ParamUtil.getString(actionRequest, "typeaction");
			if ("luu".equals(typeaction) || "xuatban".equals(typeaction) ) {
				String noiDungEditor = ParamUtil.getString(actionRequest, "noiDungEditor");
				if(Validator.isNotNull(noiDungEditor)){
					noiDungEditor = "<div class=\"content\">" + noiDungEditor + "</div>";
				}
				emagazine.setNoiDung(noiDungEditor);
				if (id > 0) {
					eMagazineLocalServiceUtil.updateeMagazine(emagazine);
		        } else {
		        	eMagazineLocalServiceUtil.addeMagazine(emagazine);
		        	SessionMessages.add(actionRequest, "thememagazinethanhcong");
		        }
		    } else {
		    	if (id > 0) {
		    		eMagazineLocalServiceUtil.updateeMagazine(emagazine);
		        } else {
		        	eMagazineLocalServiceUtil.addeMagazine(emagazine);
		        }
			    JSONObject json = JSONFactoryUtil.createJSONObject();
			    json.put("id", emagazine.getId());
			    json.put("slug", emagazine.getSlug());
			    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
			    response.setContentType("application/json");
			    PrintWriter writer = response.getWriter();
			    writer.write(json.toString());
			    writer.flush();
			    writer.close();
		    }
			
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "thememagazinethatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/eMagazine/eMagazine/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateeMagazine")
	public void updateeMagazine(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			Date date = new Date();
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			eMagazine emagazine = eMagazineLocalServiceUtil.fetcheMagazine(id);
			emagazine.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
			emagazine.setSlug(HtmlUtil.escape(ParamUtil.getString(actionRequest, "slug")));
			emagazine.setMoTa(HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa")));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "selectedItem"))) {
				emagazine.setAnhDaiDien(ParamUtil.getString(actionRequest, "selectedItem"));
			}
			emagazine.setMauChuDao(HtmlUtil.escape(ParamUtil.getString(actionRequest, "mauChuDao")));
			emagazine.setTemplateId(ParamUtil.getLong(actionRequest, "templateId"));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "hinhNenBG"))) {
				emagazine.setHinhNen(ParamUtil.getString(actionRequest, "hinhNenBG"));
			} else {
				emagazine.setHinhNen(ParamUtil.getString(actionRequest, "hinhNenBG"));
			}
			String noiDung = ParamUtil.getString(actionRequest, "noiDung");
			if(!noiDung.startsWith("<div class=\"content\">"))
				noiDung = "<div class=\"content\">" + noiDung + "</div>";
			emagazine.setNoiDung(noiDung);
			emagazine.setTuKhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
			long currentVerSion = emagazine.getPhienBan();
			emagazine.setPhienBan(currentVerSion + 1);
			emagazine.setNguoiSua(themeDisplay.getUserId());
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = df.format(date);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayTao"))) {
				String ngayTao = ParamUtil.getString(actionRequest, "ngayTao")+":00";			
				emagazine.setNgayTao(df.parse(ngayTao));			
			}else {
				emagazine.setNgayTao(df.parse(ngayhientai));
			}
			
	        TimeZone timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh"); // Múi giờ Việt Nam
	        df.setTimeZone(timeZone);
			String ngaySua = df.format(date)+":00";
			emagazine.setNgaySua(df.parse(ngaySua));
			
			emagazine.setLanguage(ParamUtil.getString(actionRequest, "language"));
			// 0 là ko hiện bl, 1 là hiện bl
			emagazine.setIsFormHienBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormHienBinhLuan") ? 1 : 0);
			emagazine.setIsFormViewBinhLuan(ParamUtil.getBoolean(actionRequest, "isFormViewBinhLuan") ? 1 : 0);
			if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
				emagazine.setStatus(3);
			} else emagazine.setStatus(0); //0 là lưu nháp | 1 lưu và gửi bbt | 2 lưu và gửi xuat ban | 3 xuất bản
			emagazine.setOrders(ParamUtil.getLong(actionRequest, "orders"));
			
			String typeaction = ParamUtil.getString(actionRequest, "typeaction");
			
			if ("luu".equals(typeaction) || "xuatban".equals(typeaction) ) {
				String noiDungEditor = ParamUtil.getString(actionRequest, "noiDungEditor");
				if(!noiDungEditor.startsWith("<div class=\"content\">"))
					noiDungEditor = "<div class=\"content\">" + noiDungEditor + "</div>";
				emagazine.setNoiDung(noiDungEditor);
				eMagazineLocalServiceUtil.updateeMagazine(emagazine);
				SessionMessages.add(actionRequest, "suaemagazinethanhcong");
		    } else {
		    	eMagazineLocalServiceUtil.updateeMagazine(emagazine);
			    JSONObject json = JSONFactoryUtil.createJSONObject();
			    json.put("id", emagazine.getId());
			    json.put("slug", emagazine.getSlug());
			    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
			    response.setContentType("application/json");
			    PrintWriter writer = response.getWriter();
			    writer.write(json.toString());
			    writer.flush();
			    writer.close();
		    }
	
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "suaemagazinethatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/eMagazine/eMagazine/edit.jsp");
		}
	
	}
	
	@ProcessAction(name = "recycleeMagazine")
	public void recycleeMagazine(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			if(Validator.isNotNull(id)){
				eMagazine magazine = eMagazineLocalServiceUtil.fetcheMagazine(id);
				magazine.setStatus(0);
				magazine.setDelete_status(1);
				eMagazineLocalServiceUtil.updateeMagazine(magazine);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@ProcessAction(name = "recoveryeMagazine")
	public void recoveryeMagazine(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		if(Validator.isNotNull(id)){
			eMagazine emagazine = eMagazineLocalServiceUtil.fetcheMagazine(id);
			emagazine.setStatus(0);
			emagazine.setDelete_status(0);
			eMagazineLocalServiceUtil.updateeMagazine(emagazine);
			SessionMessages.add(actionRequest, "recovery_linked_success");
		}
	}
	
//	public String extractUuidFromUrl(String url) {
//	    String[] parts = url.split("/");
//	    return parts[parts.length - 2]; // Lấy UUID từ phần gần cuối URL
//	}
	
//	public String extractUuidFromUrl(String url) {
//	    String[] parts = url.split("/");
//	    for (String part : parts) {
//	        if (part.matches("^[a-f0-9\\-]{36}$")) { // Kiểm tra nếu đúng format UUID
//	            return part;
//	        }
//	    }
//	    return null;
//	}
	
	@ProcessAction(name = "deleteeMagazine")
	public void deleteeMagazine(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
//		eMagazine emagazine = eMagazineLocalServiceUtil.fetcheMagazine(id);
//		String uuid = extractUuidFromUrl(emagazine.getAnhDaiDien());
//		System.out.println(uuid);
//		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		long groupId = themeDisplay.getScopeGroupId();
//		DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntryByUuidAndGroupId(uuid, groupId);
//		if(fileEntry.getFileEntryId() > 0) {
//			 DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
//			 System.out.println("File deleted successfully!");
//		}
		if(Validator.isNotNull(id)){
			eMagazineLocalServiceUtil.deleteeMagazine(id);
			SessionMessages.add(actionRequest, "delete_linked_success");
		}
	}
	
	@ProcessAction(name = "saveGiaoDien")
	public void saveGiaoDien(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {
			long id = CounterLocalServiceUtil.increment(eMagazine_templateLocalServiceUtil.class.getName());
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			eMagazine_template template = eMagazine_templateLocalServiceUtil.createeMagazine_template(id);
			template.setGroupId(themeDisplay.getScopeGroupId());
			template.setCompanyId(themeDisplay.getCompanyId());
			template.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "ten")));
			template.setNoidung(HtmlUtil.escape(ParamUtil.getString(actionRequest, "noidung")));
			template.setStatus(1);
			eMagazine_templateLocalServiceUtil.addeMagazine_template(template);
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			actionResponse.sendRedirect(redirectURL.toString());
			SessionMessages.add(actionRequest, "themtemplatethanhcong");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "themtemplatethatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/eMagazine/template/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateGiaoDien")
	public void updateGiaoDien(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			eMagazine_template template = eMagazine_templateLocalServiceUtil.fetcheMagazine_template(id);
	
			template.setTen(ParamUtil.getString(actionRequest,"ten"));
			template.setNoidung(ParamUtil.getString(actionRequest,"noidung"));
			
			SessionMessages.add(actionRequest, "suatemplatethanhcong");
			eMagazine_templateLocalServiceUtil.updateeMagazine_template(template);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suatemplatethatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/eMagazine/template/edit.jsp");
		}
	}
	
	@ProcessAction(name = "unactiveGiaoDien")
    public void unactiveGiaoDien(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	eMagazine_template template = eMagazine_templateLocalServiceUtil.fetcheMagazine_template(id);
        	template.setStatus(0);
        	eMagazine_templateLocalServiceUtil.updateeMagazine_template(template);
        	SessionMessages.add(actionRequest, "antemplatethanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "activeGiaoDien")
    public void activeGiaoDien(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	eMagazine_template template = eMagazine_templateLocalServiceUtil.fetcheMagazine_template(id);
        	template.setStatus(1);
        	eMagazine_templateLocalServiceUtil.updateeMagazine_template(template);
        	SessionMessages.add(actionRequest, "hienthitemplatethanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "deleteGiaoDien")
	public void deleteNhomKH(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			eMagazine_templateLocalServiceUtil.deleteeMagazine_template(id);
			SessionMessages.add(actionRequest, "xoatemplatethanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
//	    
//	   
//
//	    JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
//
//	    String data = ParamUtil.getString(resourceRequest, "formData");
//      
//        
//        System.out.println("Ajax 1: " + data);
//        
//        jsonResponse.put("status", "success");
//        jsonResponse.put("message", "Response from AJAX 1");
//
//	    // Gửi response
//	    resourceResponse.setContentType("application/json");
//	    PrintWriter writer = resourceResponse.getWriter();
//	    writer.write(jsonResponse.toString());
//	    writer.flush();
//	    writer.close();
//	}
	
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
}
