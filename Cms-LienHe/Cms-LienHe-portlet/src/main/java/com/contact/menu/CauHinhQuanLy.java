package com.contact.menu;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.contact.constants.CmsQuanLyKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=0",  // Vị trí hiển thị trong menu, 0 hiển thị trên đầu
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT   // Đưa vào mục Control Panel Apps
	    },
	    service = PanelApp.class
	)

public class CauHinhQuanLy extends BasePanelApp {
	
	@Override
    public String getPortletId() {
		return CmsQuanLyKeys.QUANLY; // Tên portlet
    }

    @Override
    @Reference(
        target = "(javax.portlet.name=" + CmsQuanLyKeys.QUANLY + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
	
}
