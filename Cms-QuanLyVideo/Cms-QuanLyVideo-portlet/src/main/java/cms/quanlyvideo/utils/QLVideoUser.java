package cms.quanlyvideo.utils;

import java.util.ArrayList;
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

public class QLVideoUser {
	
	public static List<ChuDe> listChuDe() throws Exception{
		DynamicQuery query = ChuDeLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		query.add(RestrictionsFactoryUtil.eq("trangThai", 1L));
		List<ChuDe> listChuDe = ChuDeLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listChuDe) || listChuDe.size() <= 0){
			listChuDe = new ArrayList<ChuDe>();
		}
		return listChuDe;
	}
	
	public static List<Video> listVideo(int start, int end) throws Exception{
		DynamicQuery query = VideoLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		query.add(RestrictionsFactoryUtil.eq("trangThai", 1L));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<Video> listVideo = VideoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listVideo) || listVideo.size() <= 0){
			listVideo = new ArrayList<Video>();
		}
		return listVideo;
	}
	
	public static List<Video> listVideoByChuDe(String chude, int start, int end) throws Exception{
		DynamicQuery query = VideoLocalServiceUtil.dynamicQuery();
		if(!chude.equals("") && Long.valueOf(chude) > 0){
			query.add(PropertyFactoryUtil.forName("id")
					.in(ChuDeVideoLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("chude_id")
									.eq(Long.valueOf(chude)))
							.setProjection(PropertyFactoryUtil.forName("video_id"))));
		}
		query.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		query.add(RestrictionsFactoryUtil.eq("trangThai", 1L));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<Video> listVideo = VideoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listVideo) || listVideo.size() <= 0){
			listVideo = new ArrayList<Video>();
		}
		return listVideo;
	}
}
