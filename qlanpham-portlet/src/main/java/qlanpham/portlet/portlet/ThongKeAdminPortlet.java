package qlanpham.portlet.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanpham.portlet.constants.QlanphamPortletKeys;
import qlanphamdb.model.AnPham_Activity;
import qlanphamdb.model.AnPham_DeCuong;
import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_Logs;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.service.AnPham_ActivityLocalServiceUtil;
import qlanphamdb.service.AnPham_DeCuongLocalServiceUtil;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_LogsLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;
import qlanpham.portlet.utils.AnPhamConfig;
import qlanpham.portlet.utils.DocumentUpload;
import qlanpham.portlet.utils.PhanQuyenAdminUtil;
import qlanpham.portlet.utils.QlanphamAdminUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Thống kê ấn phẩm",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/admin/thongke/view.jsp",
			"javax.portlet.name=" + QlanphamPortletKeys.THONGKEANPHAM,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class ThongKeAdminPortlet extends MVCPortlet{
	private Log log = LogFactoryUtil.getLog(ThongKeAdminPortlet.class);
	
}
