package cms.quanlyvideo.portlet;

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
import com.liferay.portal.kernel.util.StringUtil;

import cms.quanlyvideo.constants.CmsGiaoDienKeys;


@Component(
	    property = "javax.portlet.name=" + CmsGiaoDienKeys.GIAODIEN,
	    service = ConfigurationAction.class
	)

public class VideoConfiguration extends DefaultConfigurationAction {
	
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
		
		// Lấy giá trị từ form
	    PortletPreferences preferences = actionRequest.getPreferences();
	    
		String ungdung = ParamUtil.getString(actionRequest, "ungdung");
		String[] selectedCategory = ParamUtil.getParameterValues(actionRequest, "selectedCategory");
	    String sovideohienthi = ParamUtil.getString(actionRequest, "sovideohienthi");
	    String sovideohienthiCD = ParamUtil.getString(actionRequest, "sovideohienthiCD");
	   
		// Lưu vào preferences
		
	    preferences.setValue("ungdung", ungdung);
	    preferences.setValue("selectedCategory", StringUtil.merge(selectedCategory));
	    preferences.setValue("sovideohienthi", sovideohienthi);
	    preferences.setValue("sovideohienthiCD", sovideohienthiCD);
	    
        preferences.store();
        
        SessionMessages.add(actionRequest,"save-successfully");
        
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
	
	public String render(PortletConfig config, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/user/configuration.jsp";
	}
}
