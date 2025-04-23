package qlanpham.portlet.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanphamdb.model.eMagazine_BinhLuan;
import qlanphamdb.service.eMagazine_BinhLuanLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý bình luận eMagazine",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/binhluan/eMagazine/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.BINHLUANEMAGAZINE,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class BinhLuanMagazineAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(BinhLuanMagazineAdminPortlet.class);
	protected String viewJSP = "/html/admin/binhluan/eMagazine/view.jsp";
	
	public void deleteBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long magazineId = ParamUtil.getLong(actionRequest, "magazineId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
//		String[] checkedItem = ParamUtil.getParameterValues(actionRequest, "check");
		if(magazineId > 0) {
			eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.geteMagazine_BinhLuan(magazineId);			
			eMagazine_BinhLuanLocalServiceUtil.deleteeMagazine_BinhLuan(object);
		} else {
			for(long item:checkedItem)
			{
				eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.fetcheMagazine_BinhLuan(item);			
				eMagazine_BinhLuanLocalServiceUtil.deleteeMagazine_BinhLuan(object);
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
		long magazineId = ParamUtil.getLong(actionRequest, "magazineId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
		if(magazineId > 0) {
			eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.geteMagazine_BinhLuan(magazineId);	
			object.setStatus(2);
			eMagazine_BinhLuanLocalServiceUtil.updateeMagazine_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		} else {
		for(long item:checkedItem)
			{
				eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.fetcheMagazine_BinhLuan(item);			
				object.setStatus(2);
				eMagazine_BinhLuanLocalServiceUtil.updateeMagazine_BinhLuan(object);
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
		long magazineId = ParamUtil.getLong(actionRequest, "magazineId", 0);
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");
		if(magazineId > 0) {
			eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.geteMagazine_BinhLuan(magazineId);	
			object.setStatus(1);
			eMagazine_BinhLuanLocalServiceUtil.updateeMagazine_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		} else {
		for(long item:checkedItem)
			{
				eMagazine_BinhLuan object = eMagazine_BinhLuanLocalServiceUtil.fetcheMagazine_BinhLuan(item);			
				object.setStatus(1);
				eMagazine_BinhLuanLocalServiceUtil.updateeMagazine_BinhLuan(object);
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
