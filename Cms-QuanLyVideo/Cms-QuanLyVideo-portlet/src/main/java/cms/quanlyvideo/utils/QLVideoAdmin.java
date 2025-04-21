package cms.quanlyvideo.utils;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import cms.quanlyvideo.model.ChuDe;
import cms.quanlyvideo.model.Video;
import cms.quanlyvideo.service.ChuDeLocalServiceUtil;
import cms.quanlyvideo.service.ChuDeVideoLocalServiceUtil;
import cms.quanlyvideo.service.VideoLocalServiceUtil;

public class QLVideoAdmin {
	
	public static List<ChuDe> getListTimKiemChuDe(String trangThai, String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = ChuDeLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(trangThai) && !trangThai.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", Long.valueOf(trangThai)));
		}
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
		List<ChuDe> listTimKiemChuDe = ChuDeLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemChuDe;
	}
	
	public static List<ChuDe> getListXoaMemChuDe(String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = ChuDeLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 1L));
		List<ChuDe> listTimKiemToChuc = ChuDeLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemToChuc;
	}
	
	public static List<Video> getListTimKiemVideo(String trangThai, String chude, String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = VideoLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(trangThai) && !trangThai.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("trangThai", Long.parseLong(trangThai)));
		}
		if(!chude.equals("") && Long.valueOf(chude) > 0){
			dynamicQuery.add(PropertyFactoryUtil.forName("id")
					.in(ChuDeVideoLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("chude_id")
									.eq(Long.valueOf(chude)))
							.setProjection(PropertyFactoryUtil.forName("video_id"))));
		}
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
		List<Video> listTimKiemVideo = VideoLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemVideo;
	}
	
	public static List<Video> getListXoaMemVideo(String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = VideoLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 1L));
		List<Video> listTimKiemVideo = VideoLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemVideo;
	}
}
