package vn.dnict.lichcoquan.portlet;

import vn.dnict.lichcoquan.constants.LichcoquanPortletKeys;
import vn.dnict.lichcoquan.utils.LichcoquanUtils;
import vn.dnict.lichcoquan.utils.LichcoquanValidator;


import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;

import lichcoquan.service.model.Lichcoquan;
import lichcoquan.service.model.impl.LichcoquanImpl;
import lichcoquan.service.service.LichcoquanLocalServiceUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
		String organKey = ParamUtil.getString(actionRequest, "organKey","");
		String dongbo 	= ParamUtil.getBoolean(actionRequest,"dongbo")==true?"checked":"";
		String tudongdongbo = ParamUtil.getBoolean(actionRequest,"tudongdongbo")==true?"checked":"";
		prefs.setValue("macoquanadmin",macoquan);
		prefs.setValue("organKey",organKey);
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
	
	private String getToken() throws IOException, JSONException {
		
		Http.Options options = new Http.Options();
	    options.setLocation(LichcoquanPortletKeys.URL_LGSP_TOKEN);
	    options.setPost(true);
	    options.setBody(LichcoquanPortletKeys.AUTHORIZATION, ContentTypes.APPLICATION_X_WWW_FORM_URLENCODED, StringPool.UTF8);

	    String response = HttpUtil.URLtoString(options);

	    JSONObject json = JSONFactoryUtil.createJSONObject(response);
	    return json.getString("access_token");
	}
	
	private JSONObject callApiDongBo(String token, String maDonVi, String organKey, String tuNgay, String denNgay) throws Exception {
	    
		JSONObject params = JSONFactoryUtil.createJSONObject();
	    params.put("kieuLCT", 3);
	    params.put("username", "");
	    params.put("maPhongBan", "");

	    JSONObject bodyJson = JSONFactoryUtil.createJSONObject();
	    bodyJson.put("actionName", "LichCongTac");
	    bodyJson.put("organId", maDonVi);
	    bodyJson.put("organKey", organKey);
	    bodyJson.put("startDate", tuNgay);
	    bodyJson.put("endDate", denNgay);
	    bodyJson.put("params", params);
	    
	    String body = bodyJson.toString();

	    Http.Options options = new Http.Options();
	    options.setLocation(LichcoquanPortletKeys.URL_LGSP);
	    options.setPost(true);
	    options.addHeader("Authorization", "Bearer " + token);
	    options.addHeader(HttpHeaders.CONTENT_TYPE, ContentTypes.APPLICATION_JSON);
	    options.setBody(body, ContentTypes.APPLICATION_JSON, StringPool.UTF8);

	    String response = HttpUtil.URLtoString(options);

	    return JSONFactoryUtil.createJSONObject(response);
	}
	
	public String buildHeaderNoiDung(int tuan, String tuNgay, String denNgay) {
		StringBuilder sb = new StringBuilder();
	    
	    sb.append("<table class='display-none header-smallscreen' style='width:100%;'>");
	    sb.append("<tr><td style='text-align:center;'><strong>LỊCH CÔNG TÁC TUẦN ").append(tuan).append("</strong></td></tr>");
	    sb.append("<tr><td style='text-align:center;'><i class='date'>(Từ ngày: ").append(tuNgay).append(" đến ngày: ").append(denNgay).append(")</i></td></tr>");
	    sb.append("</table>");
	    sb.append("<table style='width:100%;border-top:1px solid #ccc;border-left:1px solid #ccc;color:#00F'>");
	    sb.append("<tr style='background:#5DB1E9;height:35px;color:#fff;text-align:center'>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Ngày</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Buổi</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Thời gian</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:45%;text-align:center'> <strong>Nội dung</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Người chủ trì</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Thành phần</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Địa điểm</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%;text-align:center'><strong>Đơn vị chuẩn bị</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;width:10%; text-align:center'><strong>Ghi chú</strong></td>");
	    sb.append("</tr>");
	    
	    return sb.toString();
	}
	
	public String buildRowNoiDung(JSONObject lich) {
		StringBuilder sb = new StringBuilder();
		
	    sb.append("<tr>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;color:#0062a6; text-align:center'><strong>").append(lich.getString("NGAY")).append("</strong></td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("BUOI")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("THOIGIAN")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("NOIDUNG")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("CHUTRI")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("THANHPHAN")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("DIADIEM")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("DONVICHUANBI")).append("</td>");
	    sb.append("<td style='border-right:1px solid #ccc;border-bottom:1px solid #ccc;'>").append(lich.getString("GHICHU")).append("</td>");
	    sb.append("</tr>");

	    return sb.toString();
	}
	
	public String buildFooterNoiDung() {
	    return "</table>";
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "dongboAllAction")
	public void dongboAllAction (ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String tungay = ParamUtil.getString(actionRequest, "tungay");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dfnam  = new SimpleDateFormat("yyyy");
		PortletPreferences prefs = actionRequest.getPreferences();
		String macoquanadmin = prefs.getValue("macoquanadmin",StringPool.BLANK);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("dongBoSo")) {
			String date_string = tungay;
			String url = "http://egov.danang.gov.vn/widget/web/guest/ttqlvbdh/-/thongtinlichcoquanmanagement_WAR_qlvbdhappportlet";
			Date date = sdf.parse(date_string);
			List<String> arrDate = new ArrayList<String>(); 
			arrDate = LichcoquanUtils.getDates(date);
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
		} else if (ParamUtil.getString(actionRequest, "typeaction").equals("dongBoPhuong")) {
			String token = getToken();
			String organKey = prefs.getValue("organKey", "");
			Date date = new Date();
			String now = sdf.format(date);
			
			JSONObject response = callApiDongBo(token, macoquanadmin, organKey, tungay, now);
		    JSONObject data = response.getJSONObject("data");
		    if (data.has("104")) {
		    	log.warn("Dữ liệu đầu vào không hợp lệ: " + data.getString("104"));
		        return;
		    }
		    
		    JSONArray dsLich = response.getJSONObject("data")
	                .getJSONObject("resultList")
	                .getJSONArray("dsLichCoQuan");
		    
		    WeekFields weekFields = WeekFields.of(Locale.FRANCE);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			List<Lichcoquan> listlcqOld = LichcoquanLocalServiceUtil.getLichcoquans(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(listlcqOld.size()<0){
				listlcqOld = new ArrayList<Lichcoquan>();
			}else{
				for(Lichcoquan lcq1 : listlcqOld){
					LichcoquanLocalServiceUtil.deleteLichcoquan(lcq1);
				}
			}
			
			// Map tuần -> list object của tuần
			Map<String, List<JSONObject>> lichTheoTuan = new HashMap<>();
			int year = 0;
			for (int i = 0; i < dsLich.length(); i++) {
				JSONObject lich = dsLich.getJSONObject(i);
				
				String ngayStr = lich.getString("NGAY"); // ví dụ: "15/09/2025"
				LocalDate ngay = LocalDate.parse(ngayStr, dtf);
				
				int week = ngay.get(weekFields.weekOfYear());
				year = ngay.getYear();
				String key = week + "-" + year;
				
				lichTheoTuan.computeIfAbsent(key, k -> new ArrayList<>()).add(lich);
			}
			
			// Xử lý từng tuần
			for (Map.Entry<String, List<JSONObject>> entry : lichTheoTuan.entrySet()) {
				String key = entry.getKey();
				List<JSONObject> lichTrongTuan = entry.getValue();
				
				// Lấy 1 ngày trong tuần để xác định tuần (ở đây lấy ngày đầu tiên)
				String ngayStr = lichTrongTuan.get(0).getString("NGAY");
				LocalDate ngayDongBo = LocalDate.parse(ngayStr, dtf);
				
				int tuan = ngayDongBo.get(weekFields.weekOfYear());
				
				LocalDate ngayDauTuan = ngayDongBo.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
			    LocalDate ngayCuoiTuan = ngayDauTuan.plusDays(6);
			    
			    String tuNgay = ngayDauTuan.format(dtf);
			    String denNgay = ngayCuoiTuan.format(dtf);
				
				// Gom nội dung HTML cho tuần
				StringBuilder sb = new StringBuilder();
				// tạo header cho tuần
				sb.append(buildHeaderNoiDung(tuan, tuNgay, denNgay));
				for (JSONObject lich : lichTrongTuan) {
				sb.append(buildRowNoiDung(lich));
				}
				
				// đóng table
				sb.append(buildFooterNoiDung());
				
				// Gọi saveDongBo để lưu vào DB
//				saveDongBo(sb.toString(), ngayDongBo, maDonVi);
				LichcoquanUtils.saveLichCoQuan(sb.toString(), tuan, year, sdf.parse(ngayStr));
				
//				System.out.println("Đã lưu tuần " + key + " cho đơn vị " + maDonVi);
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