package vn.dnict.lichcoquan.portlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import vn.dnict.lichcoquan.constants.LichcoquanUserPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.footer-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Lịch cơ quan",
			"javax.portlet.init-param.config-template=/html/lichcoquanuser/config.jsp",
			"javax.portlet.init-param.view-template=/html/lichcoquanuser/view.jsp",
			"javax.portlet.name=" + LichcoquanUserPortletKeys.LICHCOQUANUSER,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class LichcoquanUserPortlet extends MVCPortlet {

}
