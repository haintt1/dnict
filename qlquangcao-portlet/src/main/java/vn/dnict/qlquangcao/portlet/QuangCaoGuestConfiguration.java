package vn.dnict.qlquangcao.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.qlquangcao.constants.QLQuangCaoPortletKeys;


@Component(
	    property = "javax.portlet.name=" + QLQuangCaoPortletKeys.QUANGCAOGUEST,
	    service = ConfigurationAction.class
	)

public class QuangCaoGuestConfiguration extends DefaultConfigurationAction {
	
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
		
		// Lấy giá trị từ form
	    PortletPreferences preferences = actionRequest.getPreferences();
	    
		String ungdung = ParamUtil.getString(actionRequest, "ungdung");
		String[] selectedPosition = ParamUtil.getParameterValues(actionRequest, "selectedPosition");
		String sopchienthi = ParamUtil.getString(actionRequest, "sopchienthi");
		String sopchienthislide = ParamUtil.getString(actionRequest, "sopchienthislide");
		String tocdoslide = ParamUtil.getString(actionRequest, "tocdoslide");
		
		// Lưu vào preferences
	    preferences.setValue("ungdung", ungdung);
	    preferences.setValue("selectedPosition", StringUtil.merge(selectedPosition));
	    preferences.setValue("sopchienthi", sopchienthi);
	    preferences.setValue("sopchienthislide", sopchienthislide);
	    preferences.setValue("tocdoslide", tocdoslide);
		 
	   
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
