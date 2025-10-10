package vn.dnict.vanbanphapquy.actions.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
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

import vn.dnict.vanbanphapquy.actions.constants.VanbanphapquyUserPortletKeys;

@Component(
	    configurationPolicy = ConfigurationPolicy.OPTIONAL,
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + VanbanphapquyUserPortletKeys.VANBANPHAPQUYUSER
	    },
	    service = ConfigurationAction.class
	)

public class VanbanphapquyConfig extends DefaultConfigurationAction {
	
	@Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		if(!cmd.equals(Constants.UPDATE)){
			return ;
		}
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValues("giaodien",ParamUtil.getParameterValues(actionRequest, "giaodien"));
		prefs.setValues("hienthipdf",ParamUtil.getParameterValues(actionRequest, "hienthipdf"));
		prefs.setValues("cauhinhrieng",ParamUtil.getParameterValues(actionRequest, "cauhinhrieng"));
		prefs.setValues("linhvucvanban",ParamUtil.getParameterValues(actionRequest, "linhvucvanban"));
		prefs.setValues("capbanhanh",ParamUtil.getParameterValues(actionRequest, "capbanhanh"));
		prefs.setValues("giaodien",ParamUtil.getParameterValues(actionRequest, "giaodien"));
		prefs.setValues("vanbanlienquan",ParamUtil.getParameterValues(actionRequest, "vanbanlienquan"));
		prefs.setValues("lienquantheo",ParamUtil.getParameterValues(actionRequest, "lienquantheo"));
		prefs.setValues("limit_vblq",ParamUtil.getParameterValues(actionRequest, "limit_vblq"));
		prefs.setValues("limit_row",ParamUtil.getParameterValues(actionRequest, "limit_row"));
		String vbqppl = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "vbqppl"))) {
			vbqppl = "1";
		}else {
			vbqppl = "0";
		}
		prefs.setValue("vbqppl", vbqppl);
		String vbcddh = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "vbcddh"))) {
			vbcddh = "1";
		}else {
			vbcddh = "0";
		}
		prefs.setValue("vbcddh", vbcddh);
		String vbmoi = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "vbmoi"))) {
			vbmoi = "1";
		}else {
			vbmoi = "0";
		}
		prefs.setValue("vbmoi", vbmoi);
		String vbbaucu = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "vbbaucu"))) {
			vbbaucu = "1";
		}else {
			vbbaucu = "0";
		}
		prefs.setValue("vbbaucu", vbbaucu);
		String vbkhac = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "vbkhac"))) {
			vbkhac = "1";
		}else {
			vbkhac = "0";
		}
		prefs.setValue("vbkhac", vbkhac);
		prefs.store();
		actionResponse.setPortletMode(PortletMode.VIEW);
		SessionMessages.add(actionRequest,"save-successfully");
		
    }
	
	
	public String render(PortletConfig config, javax.portlet.RenderRequest renderRequest,
			javax.portlet.RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/vanbanphapquyuser/config.jsp";
	}

}
