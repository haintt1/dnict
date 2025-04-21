package com.contact.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.contact.constants.CmsNguoiDungKeys;
import com.contact.model.PhongBan;
import com.contact.model.ToChuc;
import com.contact.service.PhongBanLocalServiceUtil;
import com.contact.service.ToChucLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	    property = "javax.portlet.name=" + CmsNguoiDungKeys.NGUOIDUNG,
	    service = ConfigurationAction.class
	)

public class ConfigurationArray extends DefaultConfigurationAction {
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
        
		String[] selectedTCs = ParamUtil.getParameterValues(actionRequest, "selectedTCs");
		String[] selectedPBs = ParamUtil.getParameterValues(actionRequest, "selectedPBs");
		
		PortletPreferences preferences = actionRequest.getPreferences();
        
        // Lưu danh sách đã chọn vào preferences
        preferences.setValue("selectedTCs", StringUtil.merge(selectedTCs));
        preferences.setValue("selectedPBs", StringUtil.merge(selectedPBs));
        
        preferences.store();
           
        setPreference(actionRequest, "selectedTCs", selectedTCs);
        setPreference(actionRequest, "selectedPBs", selectedPBs);
        
//        SessionMessages.add(actionRequest, "capnhatthanhcong");
        
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
}
