package vn.dnict.qlgopy.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import vn.dnict.qlgopy.constants.QuanLyTSPortletKeys;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=11",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
		},
		service = PanelApp.class
		)

public class QuanLyToaSoanAdminPanel extends BasePanelApp{
	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return QuanLyTSPortletKeys.QLADMIN;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + QuanLyTSPortletKeys.QLADMIN + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {	
		super.setPortlet(portlet);
	}
	
}
