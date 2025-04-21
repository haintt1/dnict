package vn.dnict.qlnhuanbut.portlet;

import vn.dnict.qlnhuanbut.constants.QLNhuanButPortletKeys;
import vn.dnict.qlnhuanbut.model.DinhMuc;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;
import vn.dnict.qlnhuanbut.model.ThongKeNB;
import vn.dnict.qlnhuanbut.service.DinhMucLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoLoaiAPLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoTheLoaiLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.ThongKeNBLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Thống kê nhuận bút",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/thongke/view.jsp",
		"javax.portlet.name=" + QLNhuanButPortletKeys.THONGKE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ThongKeNhuanButAdminPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		
	    String resourceID = resourceRequest.getResourceID();

	    JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();

	    if ("ajaxAction1".equals(resourceID)) {
	   
	    	// Retrieving the submited data using ParamUtil.
			String heSoValue = ParamUtil.getString(resourceRequest, "heSoValue");
			long idnewValue = ParamUtil.getLong(resourceRequest, "idnewValue");
			long anphamValue = ParamUtil.getLong(resourceRequest, "idanphamValue");
			double thanhTien = ParamUtil.getDouble(resourceRequest, "thanhTien");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Date date = new Date();
			long id = CounterLocalServiceUtil.increment(ThongKeNB.class.getName());
			ThongKeNB nb = ThongKeNBLocalServiceUtil.createThongKeNB(id);
			nb.setNguoixuly(themeDisplay.getUserId());
			nb.setNewarticleId(idnewValue);
			nb.setAnphamId(anphamValue);
			nb.setHeso(heSoValue);
			nb.setTongtien(thanhTien);
			nb.setStatus(1);
			nb.setNgaytao(date);
			ThongKeNBLocalServiceUtil.addThongKeNB(nb);
			
			// Creating a JSON object which will contain the sum.
			jsonResponse.put("heSoValue", heSoValue);
			jsonResponse.put("idnewValue", idnewValue);
			jsonResponse.put("anphamValue", anphamValue);
			jsonResponse.put("thanhTien", thanhTien);
			jsonResponse.put("status", "success");
	    	
	    } else if("ajaxAction2".equals(resourceID)) {
	    	// Retrieving the submited data using ParamUtil.
			long idnewValueNot = ParamUtil.getLong(resourceRequest, "idnewValueNot");
			long idanphamValueNot = ParamUtil.getLong(resourceRequest, "idanphamValueNot");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Date date = new Date();
			
			long id = CounterLocalServiceUtil.increment(ThongKeNB.class.getName());
			ThongKeNB nb = ThongKeNBLocalServiceUtil.createThongKeNB(id);
			nb.setNguoixuly(themeDisplay.getUserId());
			nb.setNewarticleId(idnewValueNot);
			nb.setAnphamId(idanphamValueNot);
			nb.setHeso(null);
			nb.setStatus(0);
			nb.setNgaytao(date);
			ThongKeNBLocalServiceUtil.addThongKeNB(nb);
			
			// Creating a JSON object which will contain the sum.
			jsonResponse.put("idnewValueNot", idnewValueNot);
			jsonResponse.put("status", "success");
			
	    } else if("ajaxAction3".equals(resourceID)) {
	    	// Retrieving the submited data using ParamUtil.
			String heSoEdit = ParamUtil.getString(resourceRequest, "heSoEdit");
			long idthongkeValue = ParamUtil.getLong(resourceRequest, "idthongkeValue");
			double thanhTienEdit = ParamUtil.getDouble(resourceRequest, "thanhTienEdit");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Date date = new Date();
			
			ThongKeNB thongke = ThongKeNBLocalServiceUtil.fetchThongKeNB(idthongkeValue);
			thongke.setNguoixuly(themeDisplay.getUserId());
			thongke.setHeso(heSoEdit);
			thongke.setStatus(1);
			thongke.setTongtien(thanhTienEdit);
			thongke.setNgaysua(date);
			
			ThongKeNBLocalServiceUtil.updateThongKeNB(thongke);
			
			// Creating a JSON object which will contain the sum.
			jsonResponse.put("heSoEdit", heSoEdit);
			jsonResponse.put("idthongkeValue", idthongkeValue);
			jsonResponse.put("thanhTienEdit", thanhTienEdit);
			jsonResponse.put("status", "success");
	    }
		
	    // Gửi response
	    resourceResponse.setContentType("application/json");
	    PrintWriter writer = resourceResponse.getWriter();
	    writer.write(jsonResponse.toString());
	    writer.flush();
	    writer.close();
	}
	
	@ProcessAction(name = "deleteThongKe")
	public void deleteThongKe(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long thongkeId = ParamUtil.getLong(actionRequest, "thongkeId");
			ThongKeNBLocalServiceUtil.deleteThongKeNB(thongkeId);
			
			SessionMessages.add(actionRequest, "xoathongkethanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
}