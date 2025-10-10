package vn.dnict.vanbanphapquy.actions.portlet;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import vn.dnict.vanbanphapquy.actions.constants.VanbanphapquyPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=0",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
	        "javax.portlet.display-name=Quản lý văn bản"
	    },
	 
	    service = PanelApp.class)

public class VanbanphapquyBasePanelApp extends BasePanelApp {
	  @Override
	    public String getPortletId() {
	        return VanbanphapquyPortletKeys.VANBANPHAPQUY;
	    }

	    @Override
	    @Reference(target = "(javax.portlet.name=" + VanbanphapquyPortletKeys.VANBANPHAPQUY + ")", unbind = "-")
	    public void setPortlet(Portlet portlet) {
	        super.setPortlet(portlet);
	    }
}
