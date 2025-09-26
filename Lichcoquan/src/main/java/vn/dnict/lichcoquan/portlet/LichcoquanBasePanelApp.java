package vn.dnict.lichcoquan.portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import vn.dnict.lichcoquan.constants.LichcoquanPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=0",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT,
	        "javax.portlet.display-name=Lịch cơ quan"
	    },
	 
	    service = PanelApp.class)

public class LichcoquanBasePanelApp extends BasePanelApp {
	  @Override
	    public String getPortletId() {
	        return LichcoquanPortletKeys.LICHCOQUAN;
	    }

	    @Override
	    @Reference(target = "(javax.portlet.name=" + LichcoquanPortletKeys.LICHCOQUAN + ")", unbind = "-")
	    public void setPortlet(Portlet portlet) {
	        super.setPortlet(portlet);
	    }

}
