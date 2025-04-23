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
import qlanphamdb.model.AnPham_BinhLuan;
import qlanphamdb.model.eMagazine;
import qlanphamdb.model.eMagazine_template;
import qlanphamdb.service.AnPham_BinhLuanLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.eMagazine_templateLocalServiceUtil;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý bình luận ấn phẩm",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/binhluan/anpham/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.BINHLUANANPHAM,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class BinhLuanAnPhamAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(BinhLuanAnPhamAdminPortlet.class);
	protected String viewJSP = "/html/admin/binhluan/anpham/view.jsp";
	
	public void deleteBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long anPhamId = ParamUtil.getLong(actionRequest, "anPhamId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
//		String[] checkedItem = ParamUtil.getParameterValues(actionRequest, "check");
		if(anPhamId > 0) {
			AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.getAnPham_BinhLuan(anPhamId);			
			AnPham_BinhLuanLocalServiceUtil.deleteAnPham_BinhLuan(object);
		} else {
			for(long item:checkedItem)
			{
				AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.fetchAnPham_BinhLuan(item);			
				AnPham_BinhLuanLocalServiceUtil.deleteAnPham_BinhLuan(object);
			}
		}
		SessionMessages.add(actionRequest, "delete-successfully");
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		actionResponse.sendRedirect(redirectURL.toString());
	}
		
	public void publishBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long anPhamId = ParamUtil.getLong(actionRequest, "anPhamId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
		if(anPhamId > 0) {
			AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.getAnPham_BinhLuan(anPhamId);	
			object.setStatus(2);
			AnPham_BinhLuanLocalServiceUtil.updateAnPham_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		} else {
		for(long item:checkedItem)
			{
				AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.fetchAnPham_BinhLuan(item);			
				object.setStatus(2);
				AnPham_BinhLuanLocalServiceUtil.updateAnPham_BinhLuan(object);
				SessionMessages.add(actionRequest, "delete-successfully");
			}
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		actionResponse.sendRedirect(redirectURL.toString());
	}	
	
	public void nopublishBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long anPhamId = ParamUtil.getLong(actionRequest, "anPhamId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
		if(anPhamId > 0) {
			AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.getAnPham_BinhLuan(anPhamId);	
			object.setStatus(1);
			AnPham_BinhLuanLocalServiceUtil.updateAnPham_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		} else {
		for(long item:checkedItem)
			{
				AnPham_BinhLuan object = AnPham_BinhLuanLocalServiceUtil.fetchAnPham_BinhLuan(item);			
				object.setStatus(1);
				AnPham_BinhLuanLocalServiceUtil.updateAnPham_BinhLuan(object);
				SessionMessages.add(actionRequest, "delete-successfully");
			}
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
}
