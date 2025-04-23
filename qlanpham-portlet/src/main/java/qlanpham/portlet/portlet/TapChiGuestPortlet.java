/**
 * 
 */
package qlanpham.portlet.portlet;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanpham.portlet.utils.AnPhamGuestUtil;
import qlanphamdb.model.AnPham_BinhLuan;
import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.model.eMagazine;
import qlanphamdb.model.eMagazine_BinhLuan;
import qlanphamdb.service.AnPham_BinhLuanLocalServiceUtil;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.eMagazine_BinhLuanLocalServiceUtil;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;

/**
 * @author HueNN
 *
 */
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-css=/css/style.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Hiển thị tạp chí",
			"javax.portlet.init-param.config-template=/html/user/hienthianpham/configuration.jsp",
			"javax.portlet.init-param.view-template=/html/user/hienthianpham/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.TAPCHIGUEST,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class TapChiGuestPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	public void updateViewer(ActionRequest request,
			ActionResponse response) throws NumberFormatException, Exception {
		String id = ParamUtil.getString(request, "id");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		
		AnPham_TapChi tapChi = AnPham_TapChiLocalServiceUtil.fetchAnPham_TapChi(Long.valueOf(id));
		long dem = tapChi.getLuotXem();
		if(Validator.isNull(dem)){
			dem = 0;
		}
		dem = dem +1;
		
		tapChi.setLuotXem(dem);		
		AnPham_TapChiLocalServiceUtil.updateAnPham_TapChi(tapChi);
		jsonFeed.put("dem", dem);
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(response);
		SessionMessages.add(request, "");
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonFeed.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
	public void updateViewereMagazine(ActionRequest request, ActionResponse response) throws NumberFormatException, Exception {
		long id = ParamUtil.getLong(request, "id");
		// Process Jason feed
		JSONObject jsonFeed = JSONFactoryUtil.createJSONObject();
		
		eMagazine emagazine = eMagazineLocalServiceUtil.fetcheMagazine(id);
		long dem = emagazine.getLuotXem();
		if(Validator.isNull(dem)){
			dem = 0;
		}
		dem = dem +1;
		
		emagazine.setLuotXem(dem);		
		eMagazineLocalServiceUtil.updateeMagazine(emagazine);
		jsonFeed.put("dem", dem);
		HttpServletResponse resourceResponse = PortalUtil.getHttpServletResponse(response);
		SessionMessages.add(request, "");
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonFeed.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws java.io.IOException, PortletException {
		long anPhamId = ParamUtil.getLong(resourceRequest, "anPhamId");
		try {
			List<AnPham_DinhKemFile> listFile = AnPhamGuestUtil.getFileByAnPhamId(anPhamId);
			// Mỗi lần tải về sẽ cập nhật luotTai
			AnPham_DinhKemFile fileDinhKem = AnPham_DinhKemFileLocalServiceUtil.getAnPham_DinhKemFile(listFile.get(0).getId());
			fileDinhKem.setLuotTai(fileDinhKem.getLuotTai() + 1);
			AnPham_DinhKemFileLocalServiceUtil.updateAnPham_DinhKemFile(fileDinhKem);
			
			// gửi dữ liệu về client
			JSONObject jsonResponse  = JSONFactoryUtil.createJSONObject();
			jsonResponse.put("ten", listFile.get(0).getTen());
			jsonResponse.put("url", listFile.get(0).getUrl());

			resourceResponse.setContentType("application/json");
			PrintWriter writer = resourceResponse.getWriter();
			writer.println(jsonResponse);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	public void addComment(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, Exception {
		String currentURL = ParamUtil.getString(actionRequest, "currenturl");
		long id = CounterLocalServiceUtil.increment(AnPham_BinhLuanLocalServiceUtil.class.getName());
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			AnPham_BinhLuan objBinhLuan = AnPham_BinhLuanLocalServiceUtil.createAnPham_BinhLuan(id);
			objBinhLuan.setGroupId(themeDisplay.getScopeGroupId());
			objBinhLuan.setCompanyId(themeDisplay.getCompanyId());
			objBinhLuan.setAnPhamId(ParamUtil.getLong(actionRequest, "anPhamId"));
			objBinhLuan.setHoTen(ParamUtil.getString(actionRequest, "hoTen"));
			objBinhLuan.setNoiDung(ParamUtil.getString(actionRequest, "noiDung"));
			objBinhLuan.setNgayBinhLuan(date);
			
			AnPham_BinhLuanLocalServiceUtil.addAnPham_BinhLuan(objBinhLuan);
			actionResponse.sendRedirect(currentURL);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}  
	}
	
	public void addCommentMagazine(ActionRequest actionRequest, ActionResponse actionResponse) throws NumberFormatException, Exception {
		String currentURL = ParamUtil.getString(actionRequest, "currenturl");
		long id = CounterLocalServiceUtil.increment(eMagazine_BinhLuanLocalServiceUtil.class.getName());
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			eMagazine_BinhLuan objBinhLuan = eMagazine_BinhLuanLocalServiceUtil.createeMagazine_BinhLuan(id);
			objBinhLuan.setGroupId(themeDisplay.getScopeGroupId());
			objBinhLuan.setCompanyId(themeDisplay.getCompanyId());
			objBinhLuan.setMagazineId(ParamUtil.getLong(actionRequest, "magazineId"));
			objBinhLuan.setHoTen(ParamUtil.getString(actionRequest, "hoTen"));
			objBinhLuan.setNoiDung(ParamUtil.getString(actionRequest, "noiDung"));
			objBinhLuan.setNgayBinhLuan(date);
			
			eMagazine_BinhLuanLocalServiceUtil.addeMagazine_BinhLuan(objBinhLuan);
			actionResponse.sendRedirect(currentURL);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}  
	}
	
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws java.io.IOException, PortletException {
//		PortletPreferences preferences = renderRequest.getPreferences();
//		String[] selectedCategory = preferences.getValues("selectedCategory", new String[0]);
//		List<AnPham_Loai> danhsachLoaiAnPham = danhSachPhongBan.stream()
//                .filter(pb -> ArrayUtil.contains(selectedPBs, String.valueOf(pb.getPhongbanId())))
//                .collect(Collectors.toList());
//		super.doView(renderRequest, renderResponse);
//	}
}
