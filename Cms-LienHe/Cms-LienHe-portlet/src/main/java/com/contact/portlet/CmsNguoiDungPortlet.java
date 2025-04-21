package com.contact.portlet;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.contact.constants.CmsNguoiDungKeys;
import com.contact.model.CanBo;
import com.contact.model.PhongBan;
import com.contact.model.ToChuc;
import com.contact.service.CanBoLocalServiceUtil;
import com.contact.service.PhongBanLocalServiceUtil;
import com.contact.service.ToChucLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;

@Component(
	property = {
		"com.liferay.portlet.display-category=DNICT",
		"com.liferay.portlet.header-portlet-css=/css/style.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Thông tin liên hệ",
//		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.config-template=/html/user/cauhinh.jsp",
		"javax.portlet.init-param.view-template=/html/user/view.jsp",
		"javax.portlet.name=" + CmsNguoiDungKeys.NGUOIDUNG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CmsNguoiDungPortlet extends MVCPortlet {
	@Override
    public void render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
            	
		// Đọc các giá trị configuration
        PortletPreferences preferences = renderRequest.getPreferences();
        
        String[] selectedPBs = preferences.getValues("selectedPBs", new String[0]);
    	String[] selectedTCs = preferences.getValues("selectedTCs", new String[0]);
    	
    	OrderByComparator<PhongBan> phongBanComparator = OrderByComparatorFactoryUtil.create("PhongBan", "sapXep", true);
    	// Lấy danh sách đầy đủ từ cơ sở dữ liệu
        List<PhongBan> danhSachPhongBan = PhongBanLocalServiceUtil.getPhongBans(-1, -1,phongBanComparator);
        List<ToChuc> danhSachToChuc = ToChucLocalServiceUtil.getToChucs(-1, -1);
        
        // Lọc danh sách dựa trên ID đã chọn
        List<PhongBan> danhSachPhongBanDaChon = danhSachPhongBan.stream()
                .filter(pb -> ArrayUtil.contains(selectedPBs, String.valueOf(pb.getPhongbanId())))
                .collect(Collectors.toList());

        List<ToChuc> danhSachToChucDaChon = danhSachToChuc.stream()
                .filter(tc -> ArrayUtil.contains(selectedTCs, String.valueOf(tc.getTochucId())))
                .collect(Collectors.toList());
        
    	DynamicQuery canBoQuery = CanBoLocalServiceUtil.dynamicQuery();
    	canBoQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
    	canBoQuery.add(RestrictionsFactoryUtil.eq("tinhTrang", 1L));
    	canBoQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
    	List<CanBo> danhsachCanBo = CanBoLocalServiceUtil.dynamicQuery(canBoQuery);       
        
        renderRequest.setAttribute("danhSachPhongBanDaChon", danhSachPhongBanDaChon);
        renderRequest.setAttribute("danhSachToChucDaChon", danhSachToChucDaChon);
        renderRequest.setAttribute("danhsachCanBo", danhsachCanBo);
//        renderRequest.setAttribute("titleText", 
//            preferences.getValue("titleText", "Default Title"));
        
        super.render(renderRequest, renderResponse);
	}
}
