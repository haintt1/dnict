/**
 * 
 */
package vn.dnict.tintuc.portlet;

import java.util.List;

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
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.utils.TinTucAdminUtil;


@Component(
	    configurationPolicy = ConfigurationPolicy.OPTIONAL,
	    immediate = true,
	    property = {	
	        "javax.portlet.name=" + TinTucAdminPortletKeys.TINTUCGUEST
	    },
	    service = ConfigurationAction.class
	)
public class TintucGuestConfigurationPortlet extends DefaultConfigurationAction{

	@Override
    public void processAction(
            PortletConfig portletConfig, ActionRequest actionRequest,
            ActionResponse actionResponse)
        throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		if(!cmd.equals(Constants.UPDATE)){
			return ;
		}
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		long category = ParamUtil.getLong(actionRequest, "category");
		String category_hide  = "0";
		String newimg = "0";
		String iconnew = "0";
		String readmore_hide = "0";
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		
		prefs.setValue("ungdung",ParamUtil.getString(actionRequest, "ungdung"));
		prefs.setValue("ngonngu",ParamUtil.getString(actionRequest, "ngonngu"));
		prefs.setValue("order_category",ParamUtil.getString(actionRequest, "order_category"));
		prefs.setValue("category", String.valueOf(category));
		prefs.setValue("category_active",ParamUtil.getString(actionRequest, "category_active"));
		prefs.setValue("trangchitiet", ParamUtil.getString(actionRequest, "trangchitiet"));
		prefs.setValue("hienthixemthem", ParamUtil.getString(actionRequest, "hienthixemthem"));
		prefs.setValue("sotinhienthi", ParamUtil.getString(actionRequest, "sotinhienthi"));
		prefs.setValue("sotinlienquan", ParamUtil.getString(actionRequest, "sotinlienquan"));
		prefs.setValue("sotinhienthilienquan", ParamUtil.getString(actionRequest, "sotinhienthilienquan"));
		prefs.setValue("sotinlienquanhienthi", ParamUtil.getString(actionRequest, "sotinlienquanhienthi"));
		prefs.setValue("search_page_iframe", ParamUtil.getString(actionRequest, "search_page_iframe"));
		prefs.setValue("search_text", ParamUtil.getString(actionRequest, "search_text"));
		prefs.setValue("dodaitieude", ParamUtil.getString(actionRequest, "dodaitieude"));
		prefs.setValue("dodaimota", ParamUtil.getString(actionRequest, "dodaimota"));
		prefs.setValue("tenclass", ParamUtil.getString(actionRequest, "tenclass"));
		prefs.setValue("hienthitintuc", ParamUtil.getString(actionRequest, "hienthitintuc"));
		prefs.setValue("tocdoslide", ParamUtil.getString(actionRequest, "tocdoslide"));
		prefs.setValue("linkbanquyen", ParamUtil.getString(actionRequest, "linkbanquyen"));
		//System.out.println(ParamUtil.getString(actionRequest, "sotinlienquan"));
		
		List<News_Categories> listcategory = TinTucAdminUtil.searchNewCategory("", 0, null, 0, 0);
		String category_active = "";
		for (int i = 0; i < listcategory.size(); i++) {
			String name = "category_"+String.valueOf(listcategory.get(i).getId());
			if(com.liferay.portal.kernel.util.Validator.isNotNull(ParamUtil.getString(actionRequest,name))){
				category_active = category_active+"_"+listcategory.get(i).getId();
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "category_hide"))){
			category_hide = "1";			
		}else{
			category_hide = "0";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "newimg"))){
			newimg = "1";			
		}else{
			newimg = "0";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "readmore_hide"))){
			readmore_hide = "1";			
		}else{
			readmore_hide = "0";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "iconnew"))){
			iconnew = "1";			
		}else{
			iconnew = "0";
		}
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
		String binhluan = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "binhluan"))) {
			binhluan = "1";
		}else {
			binhluan = "0";
		}
		String banquyen = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "banquyen"))) {
			banquyen = "1";
		}else {
			banquyen = "0";
		}
		String tukhoa = "0";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tukhoa"))) {
			tukhoa = "1";
		}else {
			tukhoa = "0";
		}
		prefs.setValue("textToSpeech", textToSpeech);
		prefs.setValue("ctv", ctv);
		prefs.setValue("binhluan", binhluan);
		prefs.setValue("banquyen", banquyen);
		prefs.setValue("tukhoa", tukhoa);
		prefs.setValue("category_active", category_active);
		prefs.setValue("category_hide", category_hide);
		prefs.setValue("newimg", newimg);
		prefs.setValue("iconnew", iconnew);
		prefs.setValue("readmore_hide", readmore_hide);
		//System.out.println("DDD"+textToSpeechHT);
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
    }
	
	
	public String render(PortletConfig config, javax.portlet.RenderRequest renderRequest,
			javax.portlet.RenderResponse renderResponse) throws Exception {
		// TODO Auto-generated method stub
		return "/html/tintucguest/configuration.jsp";
	}

}
