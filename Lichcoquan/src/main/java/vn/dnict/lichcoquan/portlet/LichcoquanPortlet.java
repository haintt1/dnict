package vn.dnict.lichcoquan.portlet;

import vn.dnict.lichcoquan.constants.LichcoquanPortletKeys;
import vn.dnict.lichcoquan.utils.LichcoquanUtils;
import vn.dnict.lichcoquan.utils.LichcoquanValidator;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import lichcoquan.service.model.Lichcoquan;
import lichcoquan.service.model.impl.LichcoquanImpl;
import lichcoquan.service.service.LichcoquanLocalServiceUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author BinhNT
 */
@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.render-weight=50",
			"javax.portlet.expiration-cache=0",
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.info.title= Lịch cơ quan",
			"javax.portlet.info.short-title= Lịch cơ quan",
			"javax.portlet.display-name= Lịch cơ quan",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/lichcoquanadmin/view.jsp",
			"javax.portlet.name=" + LichcoquanPortletKeys.LICHCOQUAN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LichcoquanPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(LichcoquanPortlet.class);
	protected String viewJSP = "/html/lichcoquanadmin/view.jsp";
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "cauhinhMacoQuan")
	public void cauhinhMacoQuan(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		PortletPreferences prefs = actionRequest.getPreferences();
		String macoquan = ParamUtil.getString(actionRequest, "macoquanadmin","");
		String dongbo 	= ParamUtil.getBoolean(actionRequest,"dongbo")==true?"checked":"";
		String tudongdongbo = ParamUtil.getBoolean(actionRequest,"tudongdongbo")==true?"checked":"";
		prefs.setValue("macoquanadmin",macoquan);
		prefs.setValue("dongbo", dongbo);
		prefs.setValue("tudongdongbo", tudongdongbo);
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
		actionResponse.setRenderParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
	}
	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "cauhinhtheoNgay")
	public void cauhinhtheoNgay(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		PortletPreferences prefs = actionRequest.getPreferences();
		String tungay = ParamUtil.getString(actionRequest, "tungay");
		String denngay = ParamUtil.getString(actionRequest, "denngay");
		DateFormat dfnam  = new SimpleDateFormat("yyyy");
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String macoquanadmin = prefs.getValue("macoquanadmin",StringPool.BLANK);
		String url = "http://egov.danang.gov.vn/widget/web/guest/ttqlvbdh/-/thongtinlichcoquanmanagement_WAR_qlvbdhappportlet";
		Date date_now = new Date();
		long songay = LichcoquanUtils.daysBetween2Dates(df.format(date_now),tungay);
		if(songay <= 0){
			int Week   = LichcoquanUtils.ConvertDateTuan(df.parse(tungay));
			String nam = dfnam.format(df.parse(tungay));
			String result = "";
			result = LichcoquanUtils.getContent(url, macoquanadmin,tungay);
			Lichcoquan lcq = LichcoquanLocalServiceUtil.createLichcoquan(2);
			lcq.setLichCongtacId(CounterLocalServiceUtil.increment(Lichcoquan.class.getName()));
			if(Week>0){
				lcq.setTuan(Week);
			}
			if(!nam.equals("")){
				lcq.setNam(Integer.valueOf(nam));
			}
			lcq.setBanhanh(0);
			lcq.setTrangthai(0);
			lcq.setCreateDate(new Date());
			if(Validator.isNotNull(tungay)){
				lcq.setTungay(df.parse(tungay));
			}
			lcq.setContent(result);
			LichcoquanLocalServiceUtil.updateLichcoquan(lcq);
			SessionMessages.add(actionRequest,"save-successfully");
			actionResponse.setRenderParameter("tabs", ParamUtil.getString(actionRequest, "tabs"));
		}
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "dongboAllAction")
	public void dongboAllAction (ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tungay = ParamUtil.getString(actionRequest, "tungay");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dfnam  = new SimpleDateFormat("yyyy");
		PortletPreferences prefs = actionRequest.getPreferences();
		String macoquanadmin = prefs.getValue("macoquanadmin",StringPool.BLANK);
		String date_string = tungay;
		String url = "http://egov.danang.gov.vn/widget/web/guest/ttqlvbdh/-/thongtinlichcoquanmanagement_WAR_qlvbdhappportlet";
		Date date = sdf.parse(date_string);
		List<String> arrDate = new ArrayList<String>(); 
		arrDate = LichcoquanUtils.getlisttuesday(date);
		List<Lichcoquan> listlcqOld = LichcoquanLocalServiceUtil.getLichcoquans(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(listlcqOld.size()<0){
			listlcqOld = new ArrayList<Lichcoquan>();
		}else{
			for(Lichcoquan lcq1 : listlcqOld){
				LichcoquanLocalServiceUtil.deleteLichcoquan(lcq1);
			}
		}
		for(String date_batdau : arrDate){
			String result = LichcoquanUtils.getContent(url, macoquanadmin, date_batdau);
			int Week   = LichcoquanUtils.ConvertDateTuan(sdf.parse(date_batdau));
			String nam = dfnam.format(sdf.parse(date_batdau));
			if(!result.equals("")){
				LichcoquanUtils.saveLichCoQuan(result, Week, Integer.valueOf(nam), sdf.parse(date_batdau));
			}
		}
	}
	

	@SuppressWarnings("deprecation")
	@ProcessAction(name = "editLichcoquan")
	public void editLichcoquan(ActionRequest request, ActionResponse response) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		long id = ParamUtil.getLong(request, "id", 0L);
		String content = ParamUtil.getString(request, "content");
		int tuan = ParamUtil.getInteger(request, "tuan");
		int nam = ParamUtil.getInteger(request, "nam");
		
		Lichcoquan results = null;
			try {
				results = LichcoquanLocalServiceUtil.fetchLichcoquan(id);
				results.setContent(content);
				results.setTuan(tuan);
				results.setNam(nam);
				LichcoquanLocalServiceUtil.updateLichcoquan(results);
				SessionMessages.add(request, "link-update-successfully");
			} catch (Exception e) {
				log.error(e.getCause(), e);
			}
		String portletName = (String)request.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request),
					 portletName,
					 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("jspPage", viewJSP);
		redirectURL.setParameter("tabs", ParamUtil.getString(request, "tabs"));
		response.sendRedirect(redirectURL.toString());			

	}	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "deleteAction")
	public void deleteAction(ActionRequest request, ActionResponse response)
			throws Exception {
		long id = ParamUtil.getLong(request, "Lichcoquanid");
		Lichcoquan lcq = LichcoquanLocalServiceUtil.fetchLichcoquan(id);
		LichcoquanLocalServiceUtil.deleteLichcoquan(lcq);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", ParamUtil.getString(request, "tabs"));
		redirectURL.setParameter("jspPage", viewJSP);
		response.sendRedirect(redirectURL.toString());
	}
	
}