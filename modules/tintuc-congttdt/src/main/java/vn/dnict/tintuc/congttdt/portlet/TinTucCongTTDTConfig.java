package vn.dnict.tintuc.congttdt.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import vn.dnict.tintuc.congttdt.constants.TinTucCongTTDTPortletKeys;

@Component(
	    property = "javax.portlet.name=" + TinTucCongTTDTPortletKeys.TINTUCCONGTTDT,
	    service = ConfigurationAction.class
	)

public class TinTucCongTTDTConfig extends DefaultConfigurationAction {
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
		
		// Lấy giá trị từ form
	    PortletPreferences preferences = actionRequest.getPreferences();
	    
	    String ungdung = ParamUtil.getString(actionRequest, "ungdung");
	    String url_api = ParamUtil.getString(actionRequest, "url_api");
	    String token = ParamUtil.getString(actionRequest, "token");
	    
	   
		// Lưu vào preferences
	    preferences.setValue("ungdung", ungdung);
	    preferences.setValue("url_api", url_api);
	    preferences.setValue("token", token);
	    
	    
        preferences.store();
        
        SessionMessages.add(actionRequest,"save-successfully");
        
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
	
	public String render(PortletConfig config, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/configuration.jsp";
	}
}
