package vn.dnict.qlnhuanbut.portlet;

import vn.dnict.qlnhuanbut.constants.QLNhuanButPortletKeys;
import vn.dnict.qlnhuanbut.model.DinhMuc;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;
import vn.dnict.qlnhuanbut.service.DinhMucLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoLoaiAPLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoTheLoaiLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
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
import java.util.List;

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
		"javax.portlet.display-name=Quản lý nhuận bút",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.name=" + QLNhuanButPortletKeys.QLNHUANBUT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QLNhuanButAdminPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	public boolean isHeSoTLExists(long typeId) {
		DynamicQuery query = HeSoTheLoaiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("typeId").eq(typeId));
		List<HeSoTheLoai> results = HeSoTheLoaiLocalServiceUtil.dynamicQuery(query);
	    return !results.isEmpty();
	}
	
	@ProcessAction(name = "addHeSoTL")
	public void addHeSoTL(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = CounterLocalServiceUtil.increment(HeSoTheLoai.class.getName());
			long theLoai = ParamUtil.getLong(actionRequest, "theLoai");
			
			// Gọi service để kiểm tra loại đã tồn tại chưa
	        boolean isExists = isHeSoTLExists(theLoai);
	        
	        if (isExists) {
	            SessionErrors.add(actionRequest, "hesotltrung");
	            actionResponse.setRenderParameter("mvcPath", "/html/admin/hesotheloai/add.jsp");
	            return; // Không tiếp tục lưu
	        }
			
			HeSoTheLoai heso = HeSoTheLoaiLocalServiceUtil.createHeSoTheLoai(id);
			heso.setId(id);
			heso.setTypeId(theLoai);
			heso.setMinheso(ParamUtil.getString(actionRequest, "minheso"));
			heso.setMaxheso(ParamUtil.getString(actionRequest, "maxheso"));
			
			SessionMessages.add(actionRequest, "themhesotheloaithanhcong");
			HeSoTheLoaiLocalServiceUtil.addHeSoTheLoai(heso);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themhesotheloaithatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/hesotheloai/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateHeSoTL")
	public void updateHeSoTL(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			HeSoTheLoai heso = HeSoTheLoaiLocalServiceUtil.fetchHeSoTheLoai(id);
	
			heso.setMinheso(ParamUtil.getString(actionRequest, "minheso"));
			heso.setMaxheso(ParamUtil.getString(actionRequest, "maxheso"));
			
			HeSoTheLoaiLocalServiceUtil.updateHeSoTheLoai(heso);
			SessionMessages.add(actionRequest, "suahesotheloaithanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suahesotheloaithatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/hesotheloai/edit.jsp");
		}
	}
	
	@ProcessAction(name = "deleteHeSoTL")
	public void deleteHeSoTL(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			HeSoTheLoaiLocalServiceUtil.deleteHeSoTheLoai(id);
			
			SessionMessages.add(actionRequest, "xoahesotheloaithanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public boolean isHeSoAPExists(long loaiId) {
		DynamicQuery query = HeSoLoaiAPLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("loaiId").eq(loaiId));
		List<HeSoLoaiAP> results = HeSoLoaiAPLocalServiceUtil.dynamicQuery(query);
	    return !results.isEmpty();
	}
	
	@ProcessAction(name = "addHeSoLoaiAP")
	public void addHeSoLoaiAP(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = CounterLocalServiceUtil.increment(HeSoTheLoai.class.getName());
			long loaiAP = ParamUtil.getLong(actionRequest, "loaiAP");
			
			// Gọi service để kiểm tra loại đã tồn tại chưa
	        boolean isExists = isHeSoAPExists(loaiAP);
	        
	        if (isExists) {
	            SessionErrors.add(actionRequest, "hesoaptrung");
	            actionResponse.setRenderParameter("mvcPath", "/html/admin/hesoanpham/add.jsp");
	            return; // Không tiếp tục lưu
	        }
			
			HeSoLoaiAP hesoloai = HeSoLoaiAPLocalServiceUtil.createHeSoLoaiAP(id);
			hesoloai.setLoaiId(ParamUtil.getLong(actionRequest, "loaiAP"));
			hesoloai.setMinheso(ParamUtil.getString(actionRequest, "minheso"));
			hesoloai.setMaxheso(ParamUtil.getString(actionRequest, "maxheso"));
			
			SessionMessages.add(actionRequest, "themhesoapthanhcong");
			HeSoLoaiAPLocalServiceUtil.addHeSoLoaiAP(hesoloai);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themhesoapthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/hesoanpham/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateHeSoLoaiAP")
	public void updateHeSoLoaiAP(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			HeSoLoaiAP hesoloai = HeSoLoaiAPLocalServiceUtil.fetchHeSoLoaiAP(id);
			hesoloai.setMinheso(ParamUtil.getString(actionRequest, "minheso"));
			hesoloai.setMaxheso(ParamUtil.getString(actionRequest, "maxheso"));
			SessionMessages.add(actionRequest, "suahesoapthanhcong");
			HeSoLoaiAPLocalServiceUtil.updateHeSoLoaiAP(hesoloai);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suahesoapthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/hesoanpham/edit.jsp");
		}
	}
	
	@ProcessAction(name = "deleteHeSoLoaiAP")
	public void deleteHeSoLoaiAP(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			HeSoLoaiAPLocalServiceUtil.deleteHeSoLoaiAP(id);
			
			SessionMessages.add(actionRequest, "xoahesoloaiapthanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public boolean isDinhMucExists(int loaidinhmuc) {
		DynamicQuery query = DinhMucLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("loaidinhmuc").eq(loaidinhmuc));
		List<DinhMuc> results = DinhMucLocalServiceUtil.dynamicQuery(query);
	    return !results.isEmpty();
	}
	
	@ProcessAction(name = "addDinhMuc")
	public void addDinhMuc(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = CounterLocalServiceUtil.increment(DinhMuc.class.getName());
			int loaidinhmuc = ParamUtil.getInteger(actionRequest, "loaidinhmuc");
			
			// Gọi service để kiểm tra loại đã tồn tại chưa
	        boolean isExists = isDinhMucExists(loaidinhmuc);
	        
	        if (isExists) {
	            SessionErrors.add(actionRequest, "dinhmuctrung");
	            actionResponse.setRenderParameter("mvcPath", "/html/admin/dinhmuc/add.jsp");
	            return; // Không tiếp tục lưu
	        }
			
			DinhMuc dinhmuc = DinhMucLocalServiceUtil.createDinhMuc(id);
			dinhmuc.setId(id);
			dinhmuc.setLoaidinhmuc(loaidinhmuc);
			dinhmuc.setGia(ParamUtil.getString(actionRequest, "gia"));
			
			SessionMessages.add(actionRequest, "themdinhmucthanhcong");
			DinhMucLocalServiceUtil.addDinhMuc(dinhmuc);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themdinhmucthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/dinhmuc/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateDinhMuc")
	public void updateDinhMuc(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			DinhMuc dinhmuc = DinhMucLocalServiceUtil.fetchDinhMuc(id);
			if(Validator.isNotNull(dinhmuc)) {
				dinhmuc.setGia(ParamUtil.getString(actionRequest, "gia"));
			}
			
			DinhMucLocalServiceUtil.updateDinhMuc(dinhmuc);
			SessionMessages.add(actionRequest, "suadinhmucthanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suadinhmucthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/dinhmuc/edit.jsp");
		}
	}
	
	@ProcessAction(name = "deleteDinhMuc")
	public void deleteDinhMuc(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			DinhMucLocalServiceUtil.deleteDinhMuc(id);
			
			SessionMessages.add(actionRequest, "xoadinhmucthanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}