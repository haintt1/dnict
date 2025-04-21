/**
 * 
 */

package vn.dnict.tintuc.portlet;


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
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;


@Component(
	    configurationPolicy = ConfigurationPolicy.OPTIONAL,
	    immediate = true,
	    property = {	
	        "javax.portlet.name=" + TinTucAdminPortletKeys.HIENTHITINTUC
	    },
	    service = ConfigurationAction.class
	)
public class HienThiTintucConfigurationPortlet extends DefaultConfigurationAction{

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
		
		prefs.setValue("trangchitiet", ParamUtil.getString(actionRequest, "trangchitiet"));
		prefs.setValue("hienthixemthem", ParamUtil.getString(actionRequest, "hienthixemthem"));
		prefs.setValue("sotinhienthi", ParamUtil.getString(actionRequest, "sotinhienthi"));
		prefs.setValue("sotinlienquan", ParamUtil.getString(actionRequest, "sotinlienquan"));
		prefs.setValue("sotinhienthilienquan", ParamUtil.getString(actionRequest, "sotinhienthilienquan"));
		prefs.setValue("order_article",ParamUtil.getString(actionRequest, "order_article"));
		prefs.setValue("idarticle",ParamUtil.getString(actionRequest, "data_aricle"));
		prefs.setValue("start",ParamUtil.getString(actionRequest, "start"));
		prefs.setValue("end",ParamUtil.getString(actionRequest, "end"));
		String textToSpeechHT = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "textToSpeechHT"))) {
			textToSpeechHT = "1";
		}else {
			textToSpeechHT = "0";
		}
		prefs.setValue("textToSpeechHT", textToSpeechHT);
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
    }
	
	
	
	public String render(PortletConfig config, javax.portlet.RenderRequest renderRequest,
			javax.portlet.RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/tintucguest/hienthitintuc/configuration.jsp";
	}

}
