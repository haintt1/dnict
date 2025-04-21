package vn.dnict.qlquangcao.portlet;

import vn.dnict.qlquangcao.constants.QLQuangCaoPortletKeys;
import vn.dnict.qlquangcao.model.BangQuangCao;
import vn.dnict.qlquangcao.model.NhomKH;
import vn.dnict.qlquangcao.model.ViTriDanhMuc;
import vn.dnict.qlquangcao.service.BangQuangCaoLocalServiceUtil;
import vn.dnict.qlquangcao.service.NhomKHLocalServiceUtil;
import vn.dnict.qlquangcao.service.ViTriDanhMucLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Quản lý quảng cáo",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.name=" + QLQuangCaoPortletKeys.QLQUANGCAO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QLQuangCaoAdminPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@ProcessAction(name = "addNhomKH")
	public void addNhomKH(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			long id = CounterLocalServiceUtil.increment(NhomKH.class.getName());
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			NhomKH nhomkh = NhomKHLocalServiceUtil.createNhomKH(id);
			nhomkh.setId(id);
			nhomkh.setCompanyId(themeDisplay.getCompanyId());
			nhomkh.setGroupId(themeDisplay.getScopeGroupId());
			nhomkh.setTen(ParamUtil.getString(actionRequest,"tennhom"));
			nhomkh.setNguoidaidien(ParamUtil.getString(actionRequest,"hoten"));
			nhomkh.setLogo(ParamUtil.getString(actionRequest,"selectedItem"));
			nhomkh.setMota(ParamUtil.getString(actionRequest,"mota"));
			nhomkh.setDiachi(ParamUtil.getString(actionRequest,"diachi"));
			nhomkh.setSdt(ParamUtil.getString(actionRequest,"phone"));
			nhomkh.setEmail(ParamUtil.getString(actionRequest,"email"));
			nhomkh.setNguoitao(themeDisplay.getUserId());
			Date date = new Date();
			String ngayhientai = df.format(date);
//			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
//				String ngaytao = ParamUtil.getString(actionRequest, "ngaytao")+":00";			
//				nhomkh.setNgaytao(df.parse(ngaytao));			
//			}else {
//				nhomkh.setNgaytao(df.parse(ngayhientai));
//			}
			nhomkh.setNgaytao(df.parse(ngayhientai));
			nhomkh.setTrangthai(1);
			SessionMessages.add(actionRequest, "themnhomthanhcong");
			NhomKHLocalServiceUtil.addNhomKH(nhomkh);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themnhomthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/nhomKH/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateNhomKH")
	public void updateNhomKH(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			NhomKH nhomkh = NhomKHLocalServiceUtil.fetchNhomKH(id);
	
			nhomkh.setTen(ParamUtil.getString(actionRequest,"tennhom"));
			nhomkh.setNguoidaidien(ParamUtil.getString(actionRequest,"hoten"));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "selectedItem"))) {
				nhomkh.setLogo(ParamUtil.getString(actionRequest,"selectedItem"));
			}
			nhomkh.setMota(ParamUtil.getString(actionRequest,"mota"));
			nhomkh.setDiachi(ParamUtil.getString(actionRequest,"diachi"));
			nhomkh.setSdt(ParamUtil.getString(actionRequest,"phone"));
			nhomkh.setEmail(ParamUtil.getString(actionRequest,"email"));
			Date date = new Date();
			String ngayhientai = df.format(date);
//			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaysua"))) {
//				String ngaysua = ParamUtil.getString(actionRequest, "ngaysua")+":00";			
//				nhomkh.setNgaysua(df.parse(ngaysua));			
//			}else {
//				nhomkh.setNgaysua(df.parse(ngayhientai));
//			}
			nhomkh.setNgaysua(df.parse(ngayhientai));
			SessionMessages.add(actionRequest, "suanhomthanhcong");
			NhomKHLocalServiceUtil.updateNhomKH(nhomkh);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suanhomthatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/nhomKH/edit.jsp");
		}
	}
	
	@ProcessAction(name = "recycleKH")
    public void recycleKH(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	NhomKH nhomkh = NhomKHLocalServiceUtil.fetchNhomKH(id);
        	nhomkh.setDaxoa(1);
        	nhomkh.setTrangthai(0);
        	NhomKHLocalServiceUtil.updateNhomKH(nhomkh);
        	SessionMessages.add(actionRequest, "dichuyennhomthanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "unactiveKH")
    public void unactiveKH(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	NhomKH nhomkh = NhomKHLocalServiceUtil.fetchNhomKH(id);
        	nhomkh.setTrangthai(0);
        	NhomKHLocalServiceUtil.updateNhomKH(nhomkh);
        	SessionMessages.add(actionRequest, "annhomthanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "activeKH")
    public void activeKH(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	NhomKH nhomkh = NhomKHLocalServiceUtil.fetchNhomKH(id);
        	nhomkh.setTrangthai(1);
        	NhomKHLocalServiceUtil.updateNhomKH(nhomkh);
        	SessionMessages.add(actionRequest, "hienthinhomthanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "undoKH")
    public void undoKH(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	NhomKH nhomkh = NhomKHLocalServiceUtil.fetchNhomKH(id);
        	nhomkh.setTrangthai(0);
        	nhomkh.setDaxoa(0);
        	NhomKHLocalServiceUtil.updateNhomKH(nhomkh);
        	SessionMessages.add(actionRequest, "khoiphucnhomthanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "deleteNhomKH")
	public void deleteNhomKH(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			NhomKHLocalServiceUtil.deleteNhomKH(id);
			SessionMessages.add(actionRequest, "xoanhomthanhcong");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/nhomKH/trash.jsp");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	//////////// Xử lý vị trí danh mục ///////////////
	@ProcessAction(name = "addViTri")
	public void addViTri(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			long id = CounterLocalServiceUtil.increment(ViTriDanhMuc.class.getName());
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.createViTriDanhMuc(id);
			vitri.setCompanyId(themeDisplay.getCompanyId());
			vitri.setGroupId(themeDisplay.getScopeGroupId());
			vitri.setTen(ParamUtil.getString(actionRequest,"tenvitri"));
			vitri.setCssClass(ParamUtil.getString(actionRequest,"cssClass"));
			vitri.setKichthuoc(ParamUtil.getString(actionRequest,"kichthuoc"));
			Date date = new Date();
			String ngayhientai = df.format(date);
//			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
//				String ngaytao = ParamUtil.getString(actionRequest, "ngaytao")+":00";			
//				vitri.setNgaytao(df.parse(ngaytao));			
//			}else {
//				vitri.setNgaytao(df.parse(ngayhientai));
//			}
			vitri.setNgaytao(df.parse(ngayhientai));
			vitri.setTrangthai(1);
			SessionMessages.add(actionRequest, "themvitrithanhcong");
			ViTriDanhMucLocalServiceUtil.addViTriDanhMuc(vitri);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themvitrithatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/vitridanhmuc/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateViTri")
	public void updateViTri(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.fetchViTriDanhMuc(id);
			vitri.setTen(ParamUtil.getString(actionRequest,"tenvitri"));
			vitri.setCssClass(ParamUtil.getString(actionRequest,"cssClass"));
			vitri.setKichthuoc(ParamUtil.getString(actionRequest,"kichthuoc"));
			Date date = new Date();
			String ngayhientai = df.format(date);
//			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaySua"))) {
//				String ngaysua = ParamUtil.getString(actionRequest, "ngaySua")+":00";			
//				vitri.setNgaysua(df.parse(ngaysua));			
//			}else {
//				vitri.setNgaysua(df.parse(ngayhientai));
//			}
			vitri.setNgaysua(df.parse(ngayhientai));
			SessionMessages.add(actionRequest, "suavitrithanhcong");
			ViTriDanhMucLocalServiceUtil.updateViTriDanhMuc(vitri);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suavitrithatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/vitridanhmuc/edit.jsp");
		}
	}
	
	@ProcessAction(name = "recycleViTri")
    public void recycleViTri(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.fetchViTriDanhMuc(id);
        	vitri.setDaxoa(1);
        	vitri.setTrangthai(0);
        	ViTriDanhMucLocalServiceUtil.updateViTriDanhMuc(vitri);
        	SessionMessages.add(actionRequest, "dichuyenvitrithanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "unactiveViTri")
    public void unactiveViTri(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.fetchViTriDanhMuc(id);
        	vitri.setTrangthai(0);
        	ViTriDanhMucLocalServiceUtil.updateViTriDanhMuc(vitri);
        	SessionMessages.add(actionRequest, "anvitrithanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "activeViTri")
    public void activeViTri(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.fetchViTriDanhMuc(id);
        	vitri.setTrangthai(1);
        	ViTriDanhMucLocalServiceUtil.updateViTriDanhMuc(vitri);
        	SessionMessages.add(actionRequest, "hienthivitrithanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "undoViTri")
    public void undoViTri(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	ViTriDanhMuc vitri = ViTriDanhMucLocalServiceUtil.fetchViTriDanhMuc(id);
        	vitri.setDaxoa(0);
        	vitri.setTrangthai(0);
        	ViTriDanhMucLocalServiceUtil.updateViTriDanhMuc(vitri);
        	SessionMessages.add(actionRequest, "khoiphucvitrithanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "deleteViTri")
	public void deleteViTri(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			ViTriDanhMucLocalServiceUtil.deleteViTriDanhMuc(id);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/vitridanhmuc/trash.jsp");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	//////////////// Xử lý quảng cáo
	@ProcessAction(name = "addQuangCao")
	public void addQuangCao(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			long id = CounterLocalServiceUtil.increment(BangQuangCao.class.getName());
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.createBangQuangCao(id);
			quangcao.setCompanyId(themeDisplay.getCompanyId());
			quangcao.setGroupId(themeDisplay.getScopeGroupId());
			quangcao.setNguoitao(themeDisplay.getUserId());
			quangcao.setTen(ParamUtil.getString(actionRequest,"ten"));
			quangcao.setDuongdan(ParamUtil.getString(actionRequest,"selectedItem"));
			quangcao.setLienket(ParamUtil.getString(actionRequest,"lienket"));
			quangcao.setNhomKH(ParamUtil.getLong(actionRequest,"nhomKH"));
			quangcao.setVitriQC(ParamUtil.getLong(actionRequest,"vitriQC"));
			Date date = new Date();
			String ngayhientai = df.format(date);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
				String ngayhienthi = ParamUtil.getString(actionRequest, "ngaytao")+":00";			
				quangcao.setNgaytao(df.parse(ngayhienthi));
			}else {
				quangcao.setNgaytao(df.parse(ngayhientai));
			}
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
				String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";			
				quangcao.setNgayketthuc(df.parse(ngayketthuc));
			}else {
				quangcao.setNgayketthuc(df.parse(ngayhientai));
			}
			quangcao.setTrangthai(1);
			quangcao.setTrangthaisudung(1);
			SessionMessages.add(actionRequest, "themquangcaothanhcong");
			BangQuangCaoLocalServiceUtil.addBangQuangCao(quangcao);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "themquangcaothatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/bannerquangcao/add.jsp");
		}
	}
	
	@ProcessAction(name = "updateQuangCao")
	public void updateQuangCao(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.fetchBangQuangCao(id);
			quangcao.setTen(ParamUtil.getString(actionRequest,"ten"));
			quangcao.setLienket(ParamUtil.getString(actionRequest,"lienket"));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "selectedItem"))) {
				quangcao.setDuongdan(ParamUtil.getString(actionRequest,"selectedItem"));
			}
			quangcao.setNhomKH(ParamUtil.getLong(actionRequest,"nhomKH"));
			quangcao.setVitriQC(ParamUtil.getLong(actionRequest,"vitriQC"));
			Date date = new Date();
			String ngayhientai = df.format(date);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngaytao"))) {
				String ngayhienthi = ParamUtil.getString(actionRequest, "ngaytao")+":00";			
				quangcao.setNgaytao(df.parse(ngayhienthi));
			}else {
				quangcao.setNgaytao(df.parse(ngayhientai));
			}
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
				String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";			
				quangcao.setNgayketthuc(df.parse(ngayketthuc));
			}else {
				quangcao.setNgayketthuc(df.parse(ngayhientai));
			}
			quangcao.setNgaysua(df.parse(ngayhientai));
			SessionMessages.add(actionRequest, "suaquangcaothanhcong");
			BangQuangCaoLocalServiceUtil.updateBangQuangCao(quangcao);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "suaquangcaothatbai");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/bannerquangcao/edit.jsp");
		}
	}
	
	@ProcessAction(name = "recycleQuangCao")
    public void recycleQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.fetchBangQuangCao(id);
        	quangcao.setDaxoa(1);
        	quangcao.setTrangthai(0);
        	BangQuangCaoLocalServiceUtil.updateBangQuangCao(quangcao);
        	SessionMessages.add(actionRequest, "dichuyenquangcaothanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "activeQuangCao")
    public void unactiveQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.fetchBangQuangCao(id);
        	quangcao.setTrangthai(0);
        	BangQuangCaoLocalServiceUtil.updateBangQuangCao(quangcao);
        	SessionMessages.add(actionRequest, "hienthiquangcaothanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "unactiveQuangCao")
    public void activeQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.fetchBangQuangCao(id);
        	quangcao.setTrangthai(1);
        	BangQuangCaoLocalServiceUtil.updateBangQuangCao(quangcao);
        	SessionMessages.add(actionRequest, "anquangcaothanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "undoQuangCao")
    public void undoQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
        	long id = ParamUtil.getLong(actionRequest, "id");
        	BangQuangCao quangcao = BangQuangCaoLocalServiceUtil.fetchBangQuangCao(id);
        	quangcao.setDaxoa(0);
        	quangcao.setTrangthai(0);
        	BangQuangCaoLocalServiceUtil.updateBangQuangCao(quangcao);
        	SessionMessages.add(actionRequest, "khoiphucquangcaothanhcong");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "deleteQuangCao")
	public void deleteQuangCao(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id");
			BangQuangCaoLocalServiceUtil.deleteBangQuangCao(id);
			SessionMessages.add(actionRequest, "xoaquangcaothanhcong");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/bannerquangcao/trash.jsp");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	@ProcessAction(name = "resetTK")
	public void resetTK(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		actionRequest.removeAttribute("nhomKH");
		actionRequest.removeAttribute("tenvitri");
		actionRequest.removeAttribute("tenQC");
		actionRequest.removeAttribute("ngaytao_tungay");
		actionRequest.removeAttribute("ngayketthuc_denngay");
		actionRequest.removeAttribute("vitri");
		actionRequest.removeAttribute("trangthai");
	}
	
	@Reference
    private ItemSelector itemSelector;

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        ImageItemSelectorCriterion imageItemSelectorCriterion =
        	    new ImageItemSelectorCriterion();
        
        List<ItemSelectorReturnType> desiredItemSelectorReturnTypes = new ArrayList<>();
        desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
    	imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
    		    desiredItemSelectorReturnTypes);
        
        PortletURL itemSelectorURL = itemSelector.getItemSelectorURL(
            RequestBackedPortletURLFactoryUtil.create(renderRequest),
            "itemSelectedEventName", 
            imageItemSelectorCriterion
        );

        renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());

        super.doView(renderRequest, renderResponse);
    }
}