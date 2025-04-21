package vn.dnict.qlgopy.portlet;

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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.qlgopy.constants.QuanLyTSPortletKeys;

@Component(
	    property = "javax.portlet.name=" + QuanLyTSPortletKeys.TOASOAN,
	    service = ConfigurationAction.class
	)

public class QuanLyToaSoanConfiguration extends DefaultConfigurationAction {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
		
		// Lấy giá trị từ form
	    PortletPreferences preferences = actionRequest.getPreferences();
	    
		String ungdung = ParamUtil.getString(actionRequest, "ungdung");
		String mailthongbao1 = ParamUtil.getString(actionRequest, "mailthongbao1");
		String mailthongbao2 = ParamUtil.getString(actionRequest, "mailthongbao2");
		String mailthongbao3 = ParamUtil.getString(actionRequest, "mailthongbao3");
	    
   
		// Lưu vào preferences
	    preferences.setValue("ungdung", ungdung);
	    preferences.setValue("mailthongbao1", mailthongbao1);
	    preferences.setValue("mailthongbao2", mailthongbao2);
	    preferences.setValue("mailthongbao3", mailthongbao3);
		    
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
