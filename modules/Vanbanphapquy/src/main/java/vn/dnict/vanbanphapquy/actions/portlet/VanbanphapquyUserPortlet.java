package vn.dnict.vanbanphapquy.actions.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import javax.portlet.Portlet;
import org.osgi.service.component.annotations.Component;
import vn.dnict.vanbanphapquy.actions.constants.VanbanphapquyUserPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.footer-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý văn bản pháp quy",
			"javax.portlet.init-param.config-template=/html/vanbanphapquyuser/config.jsp",
			"javax.portlet.init-param.view-template=/html/vanbanphapquyuser/view.jsp",
			"javax.portlet.name=" + VanbanphapquyUserPortletKeys.VANBANPHAPQUYUSER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class VanbanphapquyUserPortlet extends MVCPortlet {
	

}
