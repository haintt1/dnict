package qlanpham.portlet.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;


public class ThongKeAdminUtil {
	public static List<News_role> listPhanquyen() throws Exception{
		DynamicQuery query = News_roleLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("id"));
		List<News_role> list = News_roleLocalServiceUtil.dynamicQuery(query);
		return list;
	}
	
	public static List<User> getUsersByID(long idUser){
		DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("defaultUser").eq(Boolean.FALSE));
		if(Validator.isNotNull(idUser)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("id").eq(idUser));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		List<User> results = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("re"+ results.size());
		return results;	
	}
	
	public static List<AnPham_TapChi> thongKeAnPhamByBTV(long userId, String dateStart, String dateEnd, String status) throws ParseException {
	    DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	    if(Validator.isNotNull(userId)) {
	    	query.add(RestrictionsFactoryUtil.eq("nguoiTao", userId));
	    }
	    
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
		}
		
		if(Validator.isNotNull(status) && !status.equals("")){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
	    	   
	    query.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    
	    List<AnPham_TapChi> anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
	    return anphamList.isEmpty() ? Collections.emptyList() : anphamList;
	}
	
	public static List<AnPham_TapChi> thongKeAnPhamByViews(String dateStart, String dateEnd, String status, int start, int end) throws ParseException {
	    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    
	    DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	    if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
		}
		
		if(Validator.isNotNull(status) && !status.equals("")){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
		
	    if(end!=0){
	    	query.setLimit(start, end);
	    }
	    
	    DynamicQuery fileQuery = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery();
	    fileQuery.setProjection(ProjectionFactoryUtil.property("ObjectId"));
	    fileQuery.setLimit(0, QueryUtil.ALL_POS); // Lấy tất cả ID có file
	    List<Long> anPhamIds = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery(fileQuery);

	    if (!anPhamIds.isEmpty()) {
	        query.add(PropertyFactoryUtil.forName("id").in(anPhamIds));
	    } else {
	        return Collections.emptyList(); // Không có file đính kèm -> trả về rỗng luôn ko thực hiện return dưới
	    }
	    	   
	    query.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    
	    List<AnPham_TapChi> anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
	    return anphamList.isEmpty() ? Collections.emptyList() : anphamList;
	}
	
	//list thống kê ấn phẩm by loại ấn phẩm
	public static List<AnPham_TapChi> thongKeChiTietByLoaiAnPham(long loaiId, String dateStart, String dateEnd, String status) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(loaiId)) {
			query.add(PropertyFactoryUtil.forName("loaiId").eq(loaiId));
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
		}
		
		if(Validator.isNotNull(status) && !status.equals("")){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
	    
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		List<AnPham_TapChi> listAnPham = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listAnPham.isEmpty() ? Collections.emptyList() : listAnPham;
	}
}
