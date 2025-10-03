package vn.dnict.tintuc.congttdt.portlet;

import vn.dnict.tintuc.congttdt.constants.TinTucCongTTDTPortletKeys;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.ws.rs.core.HttpHeaders;

import org.osgi.service.component.annotations.Component;

/**
 * @author Dell
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=DNICT",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TinTucCongTTDT",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.config-template=/configuration.jsp",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TinTucCongTTDTPortletKeys.TINTUCCONGTTDT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TinTucCongTTDTPortlet extends MVCPortlet {
	private JSONObject callApi(String url_api, String token, int page, int pageSize) throws Exception {
	    
	    JSONObject bodyJson = JSONFactoryUtil.createJSONObject();
	    bodyJson.put("page", page);
	    bodyJson.put("pageSize", pageSize);
	    
	    String body = bodyJson.toString();

	    Http.Options options = new Http.Options();
	    options.setLocation(url_api);
	    options.setPost(true);
	    options.addHeader("Authorization", "Bearer " + token);
	    options.addHeader(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
	    options.setBody(body, ContentTypes.APPLICATION_JSON, StringPool.UTF8);

	    String response = HttpUtil.URLtoString(options);

	    return JSONFactoryUtil.createJSONObject(response);
	}
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		PortletPreferences preferences = renderRequest.getPreferences();
		String url_api = preferences.getValue("url_api", "");
		String token = preferences.getValue("token", "");
		if(Validator.isNotNull(token) && Validator.isNotNull(url_api)) {
			System.out.println(token);
			try {
				int page = ParamUtil.getInteger(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)), "page", 1);
				int pageSize = ParamUtil.getInteger(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest)), "pageSize", 10);
				/*
				 * int page = ParamUtil.getInteger(renderRequest, "page", 1); int pageSize =
				 * ParamUtil.getInteger(renderRequest, "pageSize", 10);
				 */
				
				JSONObject response = callApi(url_api, token, page, pageSize);
				JSONArray dsTinTuc = response.getJSONArray("items");
				renderRequest.setAttribute("dsTinTuc", dsTinTuc);
				renderRequest.setAttribute("page", response.getInt("page"));
				renderRequest.setAttribute("pageSize", response.getInt("pageSize"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.render(renderRequest, renderResponse);
	}
}