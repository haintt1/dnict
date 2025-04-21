package com.contact.portlet;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;

import com.contact.constants.CmsQuanLyKeys;
import com.contact.model.CanBo;
import com.contact.model.PhongBan;
import com.contact.model.ToChuc;
import com.contact.service.CanBoLocalService;
import com.contact.service.PhongBanLocalService;
import com.contact.service.ToChucLocalService;
import com.contact.utils.QLLienHeConfig;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Quản lý liên hệ",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.name=" + CmsQuanLyKeys.QUANLY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CmsQuanLyLienHePortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	@Reference
	CounterLocalService counterLocalService;
	@Reference
	ToChucLocalService toChucLocalService;
	@Reference
	PhongBanLocalService phongBanLocalService;
	@Reference
	CanBoLocalService canBoLocalService;
	
	// 	Logic xử lý tổ chức	
	@ProcessAction(name = "addToChuc")
	public void addToChuc(ActionRequest actionRequest,ActionResponse actionResponse) {
		long tochucId = counterLocalService.increment(ToChuc.class.getName());
		String ten = ParamUtil.getString(actionRequest, "ten");
		String moTa = ParamUtil.getString(actionRequest, "moTa");
		long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang");
		int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
		Date ngayTao = new Date(System.currentTimeMillis());
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
			ToChuc tochuc = toChucLocalService.createToChuc(tochucId);
			tochuc.setTochucId(tochucId);
			tochuc.setGroupId(groupId);
			tochuc.setTen(ten);
			tochuc.setMoTa(moTa);
			tochuc.setTinhTrang(tinhTrang);
			tochuc.setSapXep(sapXep);
			tochuc.setNgayTao(ngayTao);
			// 0: chưa xóa, 1: khôi phục
			tochuc.setDaXoa(0);
			toChucLocalService.addToChuc(tochuc);			
			// Sử dụng setAttribute để lưu thông báo
	        actionRequest.setAttribute("themtochucthanhcong", true);
	        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			SessionErrors.add(actionRequest,"themtochucthatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/tochuc/create.jsp");
		}
	}
	
	@ProcessAction(name = "updateToChuc")
    public void updateToChuc(ActionRequest actionRequest,  ActionResponse actionResponse) {
        long tochucId = ParamUtil.getLong(actionRequest,"tochucId", GetterUtil.DEFAULT_LONG);
        String ten = ParamUtil.getString(actionRequest, "ten", GetterUtil.DEFAULT_STRING);
        String moTa = ParamUtil.getString(actionRequest, "moTa", GetterUtil.DEFAULT_STRING);
        int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
        long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang", GetterUtil.DEFAULT_LONG);
        Date ngaySua = new Date(System.currentTimeMillis());
        ToChuc tochuc = null;
        try {
        	tochuc = toChucLocalService.getToChuc(tochucId);
        	ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
        	if(Validator.isNotNull(tochuc)) {
        		tochuc.setGroupId(groupId);
            	tochuc.setTen(ten);
            	tochuc.setMoTa(moTa);
            	tochuc.setTinhTrang(tinhTrang);
            	tochuc.setSapXep(sapXep);
            	tochuc.setNgaySua(ngaySua);
            	toChucLocalService.updateToChuc(tochuc);
            }            
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("capnhattochucthanhcong", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getCause(), e);
        }
    }
	
	@ProcessAction(name = "xoamemToChuc")
    public void xoamemToChuc(ActionRequest actionRequest, ActionResponse actionResponse) {
        long tochucId = ParamUtil.getLong(actionRequest, "tochucId", GetterUtil.DEFAULT_LONG);
//        String backURL = ParamUtil.getString(actionRequest, "backURL");
        ToChuc tochuc = null;
        try {
        	tochuc = toChucLocalService.getToChuc(tochucId);
        	tochuc.setTinhTrang(0);
            tochuc.setDaXoa(1);
            toChucLocalService.updateToChuc(tochuc);
           
//          actionResponse.sendRedirect(backURL);
            actionRequest.setAttribute("xoamemtochucthanhcong", true);
            SessionMessages.add(actionRequest, "xoamemtochucthanhcong");
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
//          log.info(backURL);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "khoiphucToChuc")
    public void khoiphucToChuc(ActionRequest actionRequest, ActionResponse actionResponse){
		long tochucId = ParamUtil.getLong(actionRequest, "tochucId", GetterUtil.DEFAULT_LONG);
        ToChuc tochuc = null;
        try {
        	tochuc = toChucLocalService.getToChuc(tochucId);
        	tochuc.setDaXoa(0);
            toChucLocalService.updateToChuc(tochuc);
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("khoiphuctochucthanhcong", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "kichhoatToChuc")
    public void kichhoatToChuc(ActionRequest actionRequest, ActionResponse actionResponse){
		long tochucId = ParamUtil.getLong(actionRequest, "tochucId", GetterUtil.DEFAULT_LONG);
		ToChuc tochuc = null;
        try {
        	tochuc = toChucLocalService.getToChuc(tochucId);
        	tochuc.setTinhTrang(0);
            toChucLocalService.updateToChuc(tochuc);
         
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("kichhoattochuc", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }
	
	@ProcessAction(name = "huykichhoatToChuc")
    public void huykichhoatToChuc(ActionRequest actionRequest, ActionResponse actionResponse){
		long tochucId = ParamUtil.getLong(actionRequest, "tochucId", GetterUtil.DEFAULT_LONG);
		ToChuc tochuc = null;
        try {
        	tochuc = toChucLocalService.getToChuc(tochucId);
        	tochuc.setTinhTrang(1);
            toChucLocalService.updateToChuc(tochuc);
            
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("huykichhoattochuc", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabToChuc);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	@ProcessAction(name = "xoaToChuc")
    public void xoaToChuc(ActionRequest actionRequest, ActionResponse actionResponse) {
		long tochucId = ParamUtil.getLong(actionRequest, "tochucId", GetterUtil.DEFAULT_LONG);
        try {
        	toChucLocalService.deleteToChuc(tochucId);
        	actionResponse.setRenderParameter("mvcPath", "/html/admin/tochuc/trash.jsp");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
	
	// 	Logic xử lý tổ chức
	
	// Logic xử lý phòng ban
	
	@ProcessAction(name = "themPhong")
	public void themPhong(ActionRequest actionRequest,ActionResponse actionResponse) {
		long phongbanId = counterLocalService.increment(PhongBan.class.getName());
		String ten = ParamUtil.getString(actionRequest, "ten");
		String moTa = ParamUtil.getString(actionRequest, "moTa");
		long tochuc_id = ParamUtil.getLong(actionRequest, "tochuc_id");
		int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
		long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang");
		Date ngayTao = new Date();
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
			PhongBan phongban = phongBanLocalService.createPhongBan(phongbanId);
			phongban.setPhongbanId(phongbanId);
			phongban.setGroupId(groupId);
			phongban.setTen(ten);
			phongban.setMoTa(moTa);
			phongban.setTochuc_id(tochuc_id);
			phongban.setSapXep(sapXep);
			phongban.setTinhTrang(tinhTrang);
			phongban.setNgayTao(ngayTao);
			// 0: chưa xóa, 1: khôi phục
			phongban.setDaXoa(0);
			
			phongBanLocalService.addPhongBan(phongban);			
			// Sử dụng setAttribute để lưu thông báo
	        actionRequest.setAttribute("phongbanAddedSuccess", true);
	        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			SessionErrors.add(actionRequest,"themphongthatbai");
			log.error(e.getMessage(), e);
			actionResponse.setRenderParameter("mvcPath", "/html/admin/phongban/create.jsp");
		}
	}
	
	@ProcessAction(name = "capnhatPhong")
    public void capnhatPhong(ActionRequest actionRequest,  ActionResponse actionResponse) {
        long phongbanId = ParamUtil.getLong(actionRequest,"phongbanId", GetterUtil.DEFAULT_LONG);
        String ten = ParamUtil.getString(actionRequest, "ten", GetterUtil.DEFAULT_STRING);
        String moTa = ParamUtil.getString(actionRequest, "moTa", GetterUtil.DEFAULT_STRING);
        long tochuc_id = ParamUtil.getLong(actionRequest, "tochuc_id");
        int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
        long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang", GetterUtil.DEFAULT_LONG);
        Date ngaySua = new Date();
        
        PhongBan phongban = null;
        
        try {
        	ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
        	phongban = phongBanLocalService.getPhongBan(phongbanId);
        	if(Validator.isNotNull(phongban)) {
            	phongban.setGroupId(groupId);
    			phongban.setTen(ten);
    			phongban.setMoTa(moTa);
    			phongban.setTochuc_id(tochuc_id);
    			phongban.setSapXep(sapXep);
    			phongban.setTinhTrang(tinhTrang);
    			phongban.setNgaySua(ngaySua);

    			phongBanLocalService.updatePhongBan(phongban);
            }
            
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("capnhatphongthanhcong", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getCause(), e);
        }
    }
	
	@ProcessAction(name = "xoamemPhong")
    public void xoamemPhong(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
        long phongbanId = ParamUtil.getLong(actionRequest, "phongbanId", GetterUtil.DEFAULT_LONG);
        
        PhongBan phongban = null;
        try {
        	phongban = phongBanLocalService.getPhongBan(phongbanId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        
        phongban.setTinhTrang(0);
        phongban.setDaXoa(1);
		phongBanLocalService.updatePhongBan(phongban);
        
        SessionMessages.add(actionRequest, "xoamemphongthanhcong", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "khoiphucPhong")
    public void khoiphucPhong(ActionRequest actionRequest, ActionResponse actionResponse){
		long phongbanId = ParamUtil.getLong(actionRequest, "phongbanId", GetterUtil.DEFAULT_LONG);
        
        PhongBan phongban = null;
        try {
        	phongban = phongBanLocalService.getPhongBan(phongbanId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        phongban.setDaXoa(0);
		phongBanLocalService.updatePhongBan(phongban);
        
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("khoiphucphongthanhcong", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "kichhoatPhong")
    public void kichhoatPhong(ActionRequest actionRequest, ActionResponse actionResponse){
		long phongbanId = ParamUtil.getLong(actionRequest, "phongbanId", GetterUtil.DEFAULT_LONG);
               
        PhongBan phongban = null;
        try {
        	phongban = phongBanLocalService.getPhongBan(phongbanId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        phongban.setTinhTrang(0);
		phongBanLocalService.updatePhongBan(phongban);
        
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("kichhoatphong", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "huykichhoatPhong")
    public void huykichhoatPhong(ActionRequest actionRequest, ActionResponse actionResponse){
		long phongbanId = ParamUtil.getLong(actionRequest, "phongbanId", GetterUtil.DEFAULT_LONG);
               
        PhongBan phongban = null;
        try {
        	phongban = phongBanLocalService.getPhongBan(phongbanId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        phongban.setTinhTrang(1);
		phongBanLocalService.updatePhongBan(phongban);
        
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("huykichhoatphong", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabPhongBan);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "xoaPhong")
    public void xoaPhong(ActionRequest actionRequest, ActionResponse actionResponse) {
		long phongbanId = ParamUtil.getLong(actionRequest, "phongbanId", GetterUtil.DEFAULT_LONG);
        try {
        	phongBanLocalService.deletePhongBan(phongbanId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        actionResponse.setRenderParameter("mvcPath", "/html/admin/phongban/trash.jsp");
    }
	
	// Logic xử lý phòng ban
	
	// Logic xử lý cán bộ
	
	@ProcessAction(name = "themCanBo")
	public void themCanBo(ActionRequest actionRequest,ActionResponse actionResponse) {
		try {
			long canboId = counterLocalService.increment(CanBo.class.getName());
			String ten = ParamUtil.getString(actionRequest, "ten");
			String chucVu = ParamUtil.getString(actionRequest, "chucVu");
			long phongban_id = ParamUtil.getLong(actionRequest, "phongban_id");
			String sdt = ParamUtil.getString(actionRequest, "sdt");
			String email = ParamUtil.getString(actionRequest, "email");
			int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
			long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang");
			Date ngayTao = new Date();
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
			
			CanBo canbo = canBoLocalService.createCanBo(canboId);
			canbo.setGroupId(groupId);
			canbo.setTen(ten);
			canbo.setChucVu(chucVu);
			canbo.setPhongban_id(phongban_id);
			canbo.setSdt(sdt);
			canbo.setEmail(email);
			canbo.setSapXep(sapXep);
			canbo.setTinhTrang(tinhTrang);
			// 0: remove, 1: recovery 
			canbo.setDaXoa(0);
			canbo.setNgayTao(ngayTao);
			// Thêm phòng mới
			canBoLocalService.addCanBo(canbo);
			// Sử dụng setAttribute để lưu thông báo
	        actionRequest.setAttribute("themcanbothanhcong", true);
	        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@ProcessAction(name = "capnhatCanBo")
    public void capnhatCanBo(ActionRequest actionRequest,  ActionResponse actionResponse) {
        long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);
		String ten = ParamUtil.getString(actionRequest, "ten");
		String chucVu = ParamUtil.getString(actionRequest, "chucVu");
		long phongban_id = ParamUtil.getLong(actionRequest, "phongban_id");
		String sdt = ParamUtil.getString(actionRequest, "sdt");
		String email = ParamUtil.getString(actionRequest, "email");
		int sapXep = ParamUtil.getInteger(actionRequest, "sapXep");
		long tinhTrang = ParamUtil.getLong(actionRequest, "tinhTrang");
		Date ngaySua = new Date();
        
        CanBo canbo = null;
        
        try {
        	ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
			long groupId = serviceContext.getScopeGroupId();
        	canbo = canBoLocalService.getCanBo(canboId);
        	if(Validator.isNotNull(canbo)) {
        		canbo.setGroupId(groupId);
    			canbo.setTen(ten);
    			canbo.setChucVu(chucVu);
    			canbo.setPhongban_id(phongban_id);
    			canbo.setSdt(sdt);
    			canbo.setEmail(email);
    			canbo.setSapXep(sapXep);
    			canbo.setTinhTrang(tinhTrang);
    			canbo.setNgaySua(ngaySua);

    			canBoLocalService.updateCanBo(canbo);
            }
            
            // Sử dụng setAttribute để lưu thông báo
            actionRequest.setAttribute("capnhatcanbothanhcong", true);
            String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
		    actionResponse.setRenderParameter("tabs1", selectedTab);
        } catch (Exception e) {
            log.error(e.getCause(), e);
        }
    }
	
	@ProcessAction(name = "xoamemCanBo")
    public void xoamemCanBo(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);
        String backURL = ParamUtil.getString(actionRequest, "backURL");
        
        CanBo canbo = null;
        try {
        	canbo = canBoLocalService.getCanBo(canboId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        canbo.setTinhTrang(0);
        canbo.setDaXoa(1);
        canBoLocalService.updateCanBo(canbo);
        
     // Sử dụng setAttribute để lưu thông báo
    //  actionRequest.setAttribute("canboRemovedSuccess", true);
        SessionMessages.add(actionRequest, "dichuyencanbo", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "khoiphucCanBo")
    public void khoiphucCanBo(ActionRequest actionRequest, ActionResponse actionResponse){
		long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);  
        
        CanBo canbo = null;
        try {
        	canbo = canBoLocalService.getCanBo(canboId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        canbo.setDaXoa(0);
		canBoLocalService.updateCanBo(canbo);
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("khoiphuccanbo", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
		actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "kichhoatCanBo")
    public void kichhoatCanBo(ActionRequest actionRequest, ActionResponse actionResponse){
		long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);
               
		CanBo canbo = null;
        try {
        	canbo = canBoLocalService.getCanBo(canboId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        canbo.setTinhTrang(0);
		canBoLocalService.updateCanBo(canbo);
        
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("kichhoatcanbo", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "huykichhoatCanBo")
    public void huykichhoatCanBo(ActionRequest actionRequest, ActionResponse actionResponse){
		long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);
        
		CanBo canbo = null;
        try {
        	canbo = canBoLocalService.getCanBo(canboId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        canbo.setTinhTrang(1);
		canBoLocalService.updateCanBo(canbo);
        
        // Sử dụng setAttribute để lưu thông báo
        actionRequest.setAttribute("huykichhoatcanbo", true);
        String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QLLienHeConfig.tabCanBo);
	    actionResponse.setRenderParameter("tabs1", selectedTab);
    }
	
	@ProcessAction(name = "xoaCanBo")
    public void xoaCanBo(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException{
		long canboId = ParamUtil.getLong(actionRequest, "canboId", GetterUtil.DEFAULT_LONG);
        try {
        	canBoLocalService.deleteCanBo(canboId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        actionResponse.setRenderParameter("mvcPath", "/html/admin/canbo/trash.jsp");
    }
	
	// Logic xử lý cán bộ
	@ProcessAction(name = "resetTimKiem")
	public void resetTimKiem(ActionRequest actionRequest,ActionResponse actionResponse) throws IOException {
		actionRequest.removeAttribute("tuKhoa");
		actionRequest.removeAttribute("trangThai");
		actionRequest.removeAttribute("phongBan");
	}
}
