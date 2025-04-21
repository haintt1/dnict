package vn.dnict.qlquangcao.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import vn.dnict.qlquangcao.constants.QLQuangCaoPortletKeys;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=12",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
		},
		service = PanelApp.class
		)

public class QLQuangCaoAdminPanel extends BasePanelApp{
	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return QLQuangCaoPortletKeys.QLQUANGCAO;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + QLQuangCaoPortletKeys.QLQUANGCAO + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {	
		super.setPortlet(portlet);
	}
	
}
