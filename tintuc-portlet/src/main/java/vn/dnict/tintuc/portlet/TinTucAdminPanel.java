package vn.dnict.tintuc.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=3",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
		},
		service = PanelApp.class
)
public class TinTucAdminPanel extends BasePanelApp{

	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return TinTucAdminPortletKeys.TINTUCADMIN;
	}

	
	@Override
	@Reference(target = "(javax.portlet.name=" + TinTucAdminPortletKeys.TINTUCADMIN + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {	
		super.setPortlet(portlet);
	}
	
	
}
