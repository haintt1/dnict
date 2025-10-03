/**
 * 
 */
package vn.dnict.tintuc.portlet;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.adaptive.media.exception.AMRuntimeException.IOException;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;

/**
 * @author HueNN
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.footer-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Tin tức",
			"javax.portlet.init-param.config-template=/html/tintucguest/configuration.jsp",
			"javax.portlet.init-param.view-template=/html/tintucguest/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.TINTUCGUEST,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class TintucGuestPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

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
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(response);
		SessionMessages.add(request, "");
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonFeed.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
	public void addComment(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		String currentURL = ParamUtil.getString(request, "currenturl");	       
		/*
		try {			
			CaptchaUtil.check(request);
			System.out.println("captcha đúng");			
		} catch (Exception exception) {
			if (exception instanceof CaptchaTextException) {
				SessionErrors.add(request, exception.getClass(), exception);
				System.out.println("captcha sai");
			}
		}
		*/
		if(checkCaptcha(request)){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
			long id = CounterLocalServiceUtil.increment(News_BinhLuan.class.getName());
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);			
			News_BinhLuan ttbinhluan = News_BinhLuanLocalServiceUtil.createNews_BinhLuan(id);
			ttbinhluan.setId(id);
			ttbinhluan.setCompanyId(themeDisplay.getCompanyId());
			ttbinhluan.setGroupId(themeDisplay.getScopeGroupId());
			ttbinhluan.setNewarticleId(ParamUtil.getLong(request, "articleId"));
			ttbinhluan.setHoTen(ParamUtil.getString(request, "hoTen"));
			ttbinhluan.setNoiDung(ParamUtil.getString(request, "noiDung"));
	        Date date = new Date();
	        df.format(date);
	        ttbinhluan.setNgayBinhLuan(date);
	        ttbinhluan.setOrders(0);
	        ttbinhluan.setStatus(-1);
	        ttbinhluan.setDelete_status(0);
	        
	        News_BinhLuanLocalServiceUtil.addNews_BinhLuan(ttbinhluan);	         
			SessionMessages.add(request, "save-successfully");			
		} else{
			
        	SessionErrors.add(request, "save-unsuccessfully");
		}
		//response.setPortletMode(PortletMode.VIEW);
		try {
			response.sendRedirect(currentURL);
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private boolean checkCaptcha(PortletRequest request) throws PortletException {
		PortletSession session = request.getPortletSession();
		String captchaTextValue = getCaptchaValueFromSession(session);
		String captcha = ParamUtil.getString(request, "captchaText");
		boolean isValid = true;
		if (Validator.isNull(captchaTextValue)) {
            //System.out.println("Internal Error! Captcha text not found in session");
            isValid = false;
        }
        if (!captchaTextValue.equals(captcha)) {
        	String error = "Mã xác nhận sai";
        	SessionErrors.add(request, error);
        	//System.out.println("Invalid captcha text. Please reenter.");
            isValid = false;
        }
		return isValid;
	}
	
	private String getCaptchaValueFromSession(PortletSession session) {
		// TODO Auto-generated method stub
		Enumeration<String> atNames = session.getAttributeNames();
        while (atNames.hasMoreElements()) {
            String name = atNames.nextElement();
            if (name.contains("CAPTCHA_TEXT")) {
                return (String) session.getAttribute(name);
            }
        }
        return null;
	}

	@Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
        throws  IOException, PortletException {
        try {
            CaptchaUtil.serveImage(resourceRequest, resourceResponse);
        }catch(Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
    protected boolean isCheckMethodOnProcessAction() {
        return _CHECK_METHOD_ON_PROCESS_ACTION;
    }
    private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}
