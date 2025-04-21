package cms.quanlyvideo.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import cms.quanlyvideo.comparator.SapXepVideo;
import cms.quanlyvideo.constants.CmsGiaoDienKeys;
import cms.quanlyvideo.model.ChuDeVideo;
import cms.quanlyvideo.model.Video;
import cms.quanlyvideo.service.ChuDeVideoLocalServiceUtil;
import cms.quanlyvideo.service.VideoLocalService;
import cms.quanlyvideo.service.VideoLocalServiceUtil;

/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=DNICT",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Hiển thị video",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.config-template=/html/user/configuration.jsp",
		"javax.portlet.init-param.view-template=/html/user/view.jsp",
		"javax.portlet.name=" + CmsGiaoDienKeys.GIAODIEN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)

public class CmsGiaoDienVideoPortlet extends MVCPortlet {
	@Reference
	VideoLocalService videoLocalService ;
	
//	public List<Long> getVideoIdsByChuDeId(long chudeId) {
//	    DynamicQuery chuDeVideoQuery = ChuDeVideoLocalServiceUtil.dynamicQuery();
//	    chuDeVideoQuery.add(RestrictionsFactoryUtil.eq("chude_id", chudeId));
//	    chuDeVideoQuery.setProjection(ProjectionFactoryUtil.property("video_id")); // Chỉ lấy videoId
//	    return ChuDeVideoLocalServiceUtil.dynamicQuery(chuDeVideoQuery);
//	}
//	
//	public void xulyChuDe(RenderRequest renderRequest, RenderResponse renderResponse) {
//		
//		String chuDeId = ParamUtil.getString(renderRequest, "chuDeId");
//		// Tạo truy vấn động
//		DynamicQuery dynamicQuery = VideoLocalServiceUtil.dynamicQuery();
//		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
//		List<Long> videoIds = null;
//		if(Validator.isNotNull(chuDeId)) {
//			videoIds = getVideoIdsByChuDeId(Long.parseLong(chuDeId));
//		} else {
//			System.out.println("Video đang được cập nhật, làm ơn hãy hãy chọn chủ đề khác...");
//		}
//		
//		dynamicQuery.add(RestrictionsFactoryUtil.in("id", videoIds));
//		List<Video> danhsachChuDeVideo = VideoLocalServiceUtil.dynamicQuery(dynamicQuery);
//		renderRequest.setAttribute("danhsachChuDeVideo", danhsachChuDeVideo);
//	}
	
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		DynamicQuery query = VideoLocalServiceUtil.dynamicQuery();
//		query.add(RestrictionsFactoryUtil.eq("trangThai", 1L));
//		query.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
//		List<Video> danhsachVideo = VideoLocalServiceUtil.dynamicQuery(query);
//		
//		renderRequest.setAttribute("danhsachVideo", danhsachVideo);
//		System.out.println("---------start frondend-----------");
//		super.doView(renderRequest, renderResponse);
//	}
}
