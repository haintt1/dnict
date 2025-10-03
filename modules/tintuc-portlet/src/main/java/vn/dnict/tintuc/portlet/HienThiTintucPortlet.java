/**
 * 
 */


package vn.dnict.tintuc.portlet;


import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.footer-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Hiển Thị Tin tức",
			"javax.portlet.init-param.config-template=/html/tintucguest/hienthitintuc/configuration.jsp",
			"javax.portlet.init-param.view-template=/html/tintucguest/hienthitintuc/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.HIENTHITINTUC,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class HienThiTintucPortlet extends MVCPortlet {
	
	public void updateViewer(ActionRequest request,
			ActionResponse response) throws NumberFormatException, Exception {
		String id = ParamUtil.getString(request, "id");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		
		News_Article article = News_ArticleLocalServiceUtil.fetchNews_Article(Long.valueOf(id));
		long dem = article.getLuotxem();
		if(Validator.isNull(dem)){
			dem = 0;
		}
		dem = dem +1;
		article.setLuotxem(dem);
		News_ArticleLocalServiceUtil.updateNews_Article(article);
		jsonFeed.put("dem", dem);
		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(response);
		SessionMessages.add(request, "");
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonFeed.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
//	@SuppressWarnings("deprecation")
//	public void searchBaiviet(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//		actionResponse.setRenderParameter("jspPage", "/html/tintucguest/hienthitintuc/searchNews.jsp");
//		PortletPreferences prefs = actionRequest.getPreferences();
//		String idarticle = ParamUtil.getString(actionRequest, "idarticle");
//
////		//String chondanhmuc = ParamUtil.getBoolean(actionRequest,"chondanhmuc")==true?"checked":"";
////		prefs.setValue("idarticle", idarticle);
////		prefs.store();
//		SessionMessages.add(actionRequest,"save-successfully");
//	}
	
	@SuppressWarnings("deprecation")
	public void select_article(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		actionResponse.setRenderParameter("jspPage", "/html/tintucguest/hienthitintuc/onearticle.jsp");
		PortletPreferences prefs = actionRequest.getPreferences();
		String idarticle = ParamUtil.getString(actionRequest, "idarticle");
		prefs.setValue("idarticle", idarticle);
		prefs.store();
		SessionMessages.add(actionRequest,"");
	}
}
