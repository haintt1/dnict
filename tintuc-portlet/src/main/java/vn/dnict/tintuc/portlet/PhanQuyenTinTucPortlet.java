/**
 * 
 */
package vn.dnict.tintuc.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;
import vn.dnict.tintuc.utils.PhanQuyenAdminUtil;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.icon=/images/",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Phân quyền tin tức",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/tintucadmin/phanquyentintuc/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.PHANQUYENADMIN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class		
)


public class PhanQuyenTinTucPortlet extends MVCPortlet{

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException {
		List<User> getUsers = PhanQuyenAdminUtil.getUsers();
		for (int i = 0; i < getUsers.size(); i++) {
			long id = CounterLocalServiceUtil.increment(News_roleLocalServiceUtil.class.getName());
			News_role phanquyen = PhanQuyenAdminUtil.getUserById(getUsers.get(i).getUserId());
			if(Validator.isNotNull(phanquyen)) {
				phanquyen.setUserid(getUsers.get(i).getUserId());
				News_roleLocalServiceUtil.updateNews_role(phanquyen);
			}else {
				News_role nr = News_roleLocalServiceUtil.createNews_role(id);
				nr.setUserid(getUsers.get(i).getUserId());
				News_roleLocalServiceUtil.addNews_role(nr);
			}
		}
		super.doView(renderRequest, renderResponse);
	}
	
	@SuppressWarnings("deprecation")
	public void saveNewsRole(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception{
		List<User> getUsers = PhanQuyenAdminUtil.getUsers();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		for (int i = 0; i < getUsers.size(); i++) {
			News_role phanquyen = PhanQuyenAdminUtil.getUserById(getUsers.get(i).getUserId());
			
			//System.out.println("phanquyen" + phanquyen);
			if(Validator.isNotNull(phanquyen)) {
				phanquyen.setUserid(getUsers.get(i).getUserId());
				phanquyen.setGroupId(themeDisplay.getScopeGroupId());
				//System.out.println(themeDisplay.getScopeGroupId());
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()).equals("dangtin")){
						phanquyen.setRole_add(1);
					}else {
						phanquyen.setRole_add(0);
					}
				}
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()).equals("bientap")){
						phanquyen.setRole_edit(1);
					}else {
						phanquyen.setRole_edit(0);
					}
				}
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen_"+getUsers.get(i).getUserId()).equals("pheduyet")){
						phanquyen.setRole_public(1);
					}else {
						phanquyen.setRole_public(0);
					}
				}
				String userid = ParamUtil.getString(actionRequest, "danhmuc-"+getUsers.get(i).getUserId());
			
				if(Validator.isNotNull(userid)) {
					phanquyen.setCategory_active_role(userid);
				}
				News_roleLocalServiceUtil.updateNews_role(phanquyen);
			}else {
				long id = CounterLocalServiceUtil.increment(News_roleLocalServiceUtil.class.getName());
				News_role nr = News_roleLocalServiceUtil.createNews_role(id);
				nr.setUserid(getUsers.get(i).getUserId());
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()).equals("dangtin")){
						nr.setRole_add(1);
					}else {
						nr.setRole_add(0);
					}
				}
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()).equals("bientap")){
						nr.setRole_edit(1);
					}else {
						nr.setRole_edit(0);
					}
				}
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()))) {
					if(ParamUtil.getString(actionRequest, "role_quyen"+getUsers.get(i).getUserId()).equals("pheduyet")){
						nr.setRole_public(1);
					}else {
						nr.setRole_public(0);
					}
				}
				String userid = ParamUtil.getString(actionRequest, "danhmuc-"+getUsers.get(i).getUserId());
				
				if(Validator.isNotNull(userid)) {
					nr.setCategory_active_role(userid);
				}
				phanquyen.setGroupId(themeDisplay.getScopeGroupId());
				News_roleLocalServiceUtil.addNews_role(nr);
			}
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectUrl = PortletURLFactoryUtil.create(PortalUtil.
					getHttpServletRequest(actionRequest), portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
			redirectUrl.setParameter("jspPage", "/html/tintucadmin/phanquyentintuc/view.jsp");		}
		
		
	}
}
