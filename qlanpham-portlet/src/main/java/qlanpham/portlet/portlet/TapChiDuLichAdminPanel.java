package qlanpham.portlet.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import qlanpham.portlet.constants.QlanphamPortletKeys;

@Component(
		immediate = true,
		property = {
				"panel.app.order:Integer=6",
				"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
		},
		service = PanelApp.class
)

public class TapChiDuLichAdminPanel extends BasePanelApp{
	@Override
	public String getPortletId() {
		// TODO Auto-generated method stub
		return QlanphamPortletKeys.TAPCHIDULICH;
	}
	
	@Override
	@Reference(target = "(javax.portlet.name=" + QlanphamPortletKeys.TAPCHIDULICH + ")", unbind = "-")
	public void setPortlet(Portlet portlet) {	
		super.setPortlet(portlet);
	}
}
