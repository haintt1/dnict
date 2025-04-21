package com.contact.portlet;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;

import com.contact.constants.CmsNguoiDungKeys;
import com.contact.model.PhongBan;
import com.contact.model.ToChuc;
import com.contact.service.PhongBanLocalServiceUtil;
import com.contact.service.ToChucLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.ParamUtil;

//@Component(
//	    property = "javax.portlet.name=" + CmsNguoiDungKeys.NGUOIDUNG,
//	    service = ConfigurationAction.class
//	)

public class Configuration extends DefaultConfigurationAction {
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
	
	@Override
	@Transactional
    public void processAction(
        PortletConfig portletConfig, ActionRequest actionRequest,
        ActionResponse actionResponse)
        throws Exception {
        
		List<ToChuc> danhsachToChuc = ToChucLocalServiceUtil.getToChucs(-1, -1);
		String[] tinhTrangTCs = ParamUtil.getParameterValues(actionRequest, "tinhTrangTCs");
		List<PhongBan> danhsachPhongBan = PhongBanLocalServiceUtil.getPhongBans(-1, -1);
		String[] tinhTrangPBs = ParamUtil.getParameterValues(actionRequest, "tinhTrangPBs");
		
		setPreference(actionRequest, "tinhTrangPBs", tinhTrangPBs);
		setPreference(actionRequest, "tinhTrangTCs", tinhTrangTCs);
		
		
		
		try {
			for(ToChuc tochuc : danhsachToChuc) {
				boolean isChecked = false;
				if(tinhTrangTCs != null) {
					for(String checkedTC : tinhTrangTCs) {
						if(String.valueOf(tochuc.getTochucId()).equals(checkedTC)) {
							isChecked = true;
							break;
						}
					}
				}
				tochuc.setTinhTrang(isChecked ? 1 : 0);
				ToChucLocalServiceUtil.updateToChuc(tochuc);
			}
			for(PhongBan phongban : danhsachPhongBan) {
				boolean isChecked = false;
				if(tinhTrangPBs != null) {
					for(String checkedPB : tinhTrangPBs) {
						if(String.valueOf(phongban.getPhongbanId()).equals(checkedPB)) {
							isChecked = true;
							break;
						}
					}
				}
				phongban.setTinhTrang(isChecked ? 1 : 0);
				PhongBanLocalServiceUtil.updatePhongBan(phongban);
			}
			SessionMessages.add(actionRequest, "capnhatthanhcong");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
        super.processAction(portletConfig, actionRequest, actionResponse);
    }
}
