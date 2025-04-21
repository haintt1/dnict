package vn.dnict.qlnhuanbut.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import vn.dnict.qlnhuanbut.constants.QLNhuanButPortletKeys;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=14",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
		},
		service = PanelApp.class
		)

public class ThongKeNhuanButAdminPanel extends BasePanelApp{
	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return QLNhuanButPortletKeys.THONGKE;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + QLNhuanButPortletKeys.THONGKE + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {	
		super.setPortlet(portlet);
	}
	
}
