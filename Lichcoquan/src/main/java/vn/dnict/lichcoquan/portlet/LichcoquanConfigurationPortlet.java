package vn.dnict.lichcoquan.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

import vn.dnict.lichcoquan.constants.LichcoquanUserPortletKeys;
@Component(
	    configurationPolicy = ConfigurationPolicy.OPTIONAL,
	    immediate = true,
	    property = {
	    	"javax.portlet.portlet-mode=text/html;edit",	
	        "javax.portlet.name=" + LichcoquanUserPortletKeys.LICHCOQUANUSER
	    },
	    service = ConfigurationAction.class
	)

public class LichcoquanConfigurationPortlet extends DefaultConfigurationAction{
	public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		if(!cmd.equals(Constants.UPDATE)){
			return ;
		}
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("soluonghienthi",ParamUtil.getString(actionRequest, "soluonghienthi"));
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
		
    }
	public String render(PortletConfig config, javax.portlet.RenderRequest renderRequest,
			javax.portlet.RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/lichcoquanuser/config.jsp";
	}
}
