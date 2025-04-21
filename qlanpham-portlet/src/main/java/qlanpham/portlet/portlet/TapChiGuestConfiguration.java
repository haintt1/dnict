package qlanpham.portlet.portlet;

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

import qlanpham.portlet.constants.QlanphamPortletKeys;

@Component(
	    property = "javax.portlet.name=" + QlanphamPortletKeys.TAPCHIGUEST,
	    service = ConfigurationAction.class
	)

public class TapChiGuestConfiguration extends DefaultConfigurationAction {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
		
		// Lấy giá trị từ form
	    PortletPreferences preferences = actionRequest.getPreferences();
	    
	    String langcheck = ParamUtil.getString(actionRequest, "ngonngu");
		String ungdung = ParamUtil.getString(actionRequest, "ungdung");
		String[] selectedCategory = ParamUtil.getParameterValues(actionRequest, "selectedCategory");
	    String sotinhienthi = ParamUtil.getString(actionRequest, "sotinhienthi");
	    String sotinhienthiTL = ParamUtil.getString(actionRequest, "sotinhienthiTL");
	    String sotinhienthidaidien = ParamUtil.getString(actionRequest, "sotinhienthidaidien");
	    String trangchitiet = ParamUtil.getString(actionRequest, "trangchitiet");
	    String trangchitietemagazine = ParamUtil.getString(actionRequest, "trangchitietemagazine");
	    String trangsocu = ParamUtil.getString(actionRequest, "trangsocu");
	    String trangdanhmuc = ParamUtil.getString(actionRequest, "trangdanhmuc");
	    String kieuhienthipdf = ParamUtil.getString(actionRequest, "kieuhienthipdf");
		String binhluan = ParamUtil.getString(actionRequest, "binhluan");
		String textToSpeech = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "textToSpeech"))) {
			textToSpeech = "1";
		}else {
			textToSpeech = "0";
		}
		String ctv = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ctv"))) {
			ctv = "1";
		}else {
			ctv = "0";
		}
		String banquyen = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "banquyen"))) {
			banquyen = "1";
		}else {
			banquyen = "0";
		}
		String linkbanquyen = ParamUtil.getString(actionRequest, "linkbanquyen");
		String tukhoa = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tukhoa"))) {
			tukhoa = "1";
		}else {
			tukhoa = "0";
		}
   
		// Lưu vào preferences
		preferences.setValue("langcheck", langcheck);
	    preferences.setValue("ungdung", ungdung);
	    preferences.setValue("selectedCategory", StringUtil.merge(selectedCategory));
	    preferences.setValue("sotinhienthi", sotinhienthi);
	    preferences.setValue("sotinhienthiTL", sotinhienthiTL);
	    preferences.setValue("sotinhienthidaidien", sotinhienthidaidien);
	    preferences.setValue("trangchitiet", trangchitiet);
	    preferences.setValue("trangchitietemagazine", trangchitietemagazine);
	    preferences.setValue("trangsocu", trangsocu);
	    preferences.setValue("trangdanhmuc", trangdanhmuc);
	    preferences.setValue("kieuhienthipdf", kieuhienthipdf);
	    preferences.setValue("binhluan", binhluan);
	    preferences.setValue("textToSpeech", textToSpeech);
	    preferences.setValue("ctv", ctv);
	    preferences.setValue("banquyen", banquyen);
	    preferences.setValue("linkbanquyen", linkbanquyen);
	    preferences.setValue("tukhoa", tukhoa);
		    
        preferences.store();
        
        SessionMessages.add(actionRequest,"save-successfully");
        
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
	
	public String render(PortletConfig config, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/user/hienthianpham/configuration.jsp";
	}
}
