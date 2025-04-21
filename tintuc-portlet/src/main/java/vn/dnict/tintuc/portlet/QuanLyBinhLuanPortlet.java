package vn.dnict.tintuc.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.icon=/images/",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý bình luận",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/quanlybinhluan/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.QUANLYBINHLUAN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class QuanLyBinhLuanPortlet extends MVCPortlet{
	
	protected String viewJSP = "/html/quanlybinhluan/view.jsp";
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "deleteBinhLuan")
	public void deleteBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");	
		for(long item:checkedItem)
		{
			News_BinhLuan object = News_BinhLuanLocalServiceUtil.fetchNews_BinhLuan(item);			
			object.setDelete_status(1);
			News_BinhLuanLocalServiceUtil.updateNews_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		actionResponse.sendRedirect(redirectURL.toString());
	}
		
	public void publishBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");	
		for(long item:checkedItem)
		{
			News_BinhLuan object = News_BinhLuanLocalServiceUtil.fetchNews_BinhLuan(item);			
			object.setStatus(1);
			News_BinhLuanLocalServiceUtil.updateNews_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		actionResponse.sendRedirect(redirectURL.toString());
	}	
	
	public void nopublishBinhLuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {		
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");	
		for(long item:checkedItem)
		{
			News_BinhLuan object = News_BinhLuanLocalServiceUtil.fetchNews_BinhLuan(item);			
			object.setStatus(0);
			News_BinhLuanLocalServiceUtil.updateNews_BinhLuan(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
    
}
