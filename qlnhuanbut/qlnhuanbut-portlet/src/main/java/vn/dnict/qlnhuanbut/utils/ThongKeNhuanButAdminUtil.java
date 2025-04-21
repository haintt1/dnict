package vn.dnict.qlnhuanbut.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import vn.dnict.qlnhuanbut.model.ThongKeNB;
import vn.dnict.qlnhuanbut.service.ThongKeNBLocalServiceUtil;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;


public class ThongKeNhuanButAdminUtil {
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
	
	//list thống kê bài viêt by thể loại
	public static List<News_Article> thongKeChiTietByTheLoai(long typeid, String dateStart, String dateEnd) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(typeid)) {
			query.add(PropertyFactoryUtil.forName("typeid").eq(typeid));
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(sf.parse(dateEnd)));
		}
	    	    
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		return listArticle.isEmpty() ? Collections.emptyList() : listArticle;
	}
	
	//list thống kê ấn phẩm by loại ấn phẩm
	public static List<AnPham_TapChi> thongKeChiTietByLoaiAnPham(long loaiId, String dateStart, String dateEnd) throws Exception{
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
	    
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		List<AnPham_TapChi> listAnPham = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listAnPham.isEmpty() ? Collections.emptyList() : listAnPham;
	}
	
	public static List<Object> getCombineTinTucAnPham(long userId, String dateStart, String dateEnd) throws ParseException {
	    List<News_Article> newsList = new ArrayList<>();
	    List<AnPham_TapChi> anphamList = new ArrayList<>();
	    List<Object> combinedList = new ArrayList<>();
	    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
	    DynamicQuery magazineQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	    if(Validator.isNotNull(userId)) {
	    	newsQuery.add(RestrictionsFactoryUtil.eq("createdby", userId));
	    	magazineQuery.add(RestrictionsFactoryUtil.eq("nguoiTao", userId));
	    }
	    
	    if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").ge(sf.parse(dateStart)));
	    	magazineQuery.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").le(sf.parse(dateEnd)));
	    	magazineQuery.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
		}
	    	   
//	    if(end!=0){
//	    	newsQuery.setLimit(start, end);
//	    	magazineQuery.setLimit(start, end);
//		}
		
		newsQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	    magazineQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	    newsQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    magazineQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    
	    newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);
	    anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(magazineQuery);
	    
	    // Kết hợp kết quả
	    combinedList.addAll(newsList);
	    combinedList.addAll(anphamList);
	    
	    return combinedList;
	}
	
	public static List<Object> getCombineTinTucAnPhamThongKeNB(long userId, String dateStart, String dateEnd) throws ParseException {
	    List<News_Article> newsList = new ArrayList<>();
	    List<AnPham_TapChi> anphamList = new ArrayList<>();
	    List<ThongKeNB> thongkeList = new ArrayList<>();
	    List<Object> combinedList = new ArrayList<>();
	    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
	    DynamicQuery magazineQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	    DynamicQuery thongkeQuery = ThongKeNBLocalServiceUtil.dynamicQuery();
	    if(Validator.isNotNull(userId)) {
	    	newsQuery.add(RestrictionsFactoryUtil.eq("createdby", userId));
	    	magazineQuery.add(RestrictionsFactoryUtil.eq("nguoiTao", userId));
	    }
	    
	    if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").ge(sf.parse(dateStart)));
	    	magazineQuery.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").le(sf.parse(dateEnd)));
	    	magazineQuery.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").le(sf.parse(dateEnd)));
		}
	    	    
		newsQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	    magazineQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	    newsQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    magazineQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	    newsQuery.addOrder(OrderFactoryUtil.desc("createdtime"));
	    magazineQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
	    
	    newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);
	    anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(magazineQuery);
	    thongkeList = ThongKeNBLocalServiceUtil.dynamicQuery(thongkeQuery);
	    
	    // Kết hợp kết quả
	    combinedList.addAll(newsList);
	    combinedList.addAll(anphamList);
	    combinedList.addAll(thongkeList);
	    
	    return combinedList;
	}
	
	//list thống kê bài viêt by thể loại và thống kê
	public static List<Object> thongKeTinTucVaThongKeByTheLoai(long typeid, String dateStart, String dateEnd) throws Exception{
		List<News_Article> newsList = new ArrayList<>();
		List<ThongKeNB> thongkeList = new ArrayList<>();
		List<Object> combinedListTinTucVaThongKe = new ArrayList<>();
	    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
		DynamicQuery thongkeQuery = ThongKeNBLocalServiceUtil.dynamicQuery();
		
		if(Validator.isNotNull(typeid)) {
			newsQuery.add(PropertyFactoryUtil.forName("typeid").eq(typeid));
	    }
	    
	    if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").ge(sf.parse(dateStart)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			newsQuery.add(PropertyFactoryUtil.forName("ngayxuatban").le(sf.parse(dateEnd)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").le(sf.parse(dateEnd)));
		}
	    	    
		newsQuery.add(PropertyFactoryUtil.forName("status").eq(3));
		newsQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		newsQuery.addOrder(OrderFactoryUtil.desc("createdtime"));
		thongkeQuery.addOrder(OrderFactoryUtil.desc("ngaytao"));
		newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);
		thongkeList = ThongKeNBLocalServiceUtil.dynamicQuery(thongkeQuery);
		combinedListTinTucVaThongKe.addAll(newsList);
		combinedListTinTucVaThongKe.addAll(thongkeList);
		
		return combinedListTinTucVaThongKe;
	}
	
	//list thống kê bài viêt by ấn phẩm và thống kê
	public static List<Object> thongKeAnPhamVaThongKeByLoaiId(long loaiId, String dateStart, String dateEnd) throws Exception{
		List<AnPham_TapChi> anphamList = new ArrayList<>();
		List<ThongKeNB> thongkeList = new ArrayList<>();
		List<Object> combinedListAnPhamVaThongKe = new ArrayList<>();
	    SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DynamicQuery anphamQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		DynamicQuery thongkeQuery = ThongKeNBLocalServiceUtil.dynamicQuery();
		
		if(Validator.isNotNull(loaiId)) {
			anphamQuery.add(PropertyFactoryUtil.forName("loaiId").eq(loaiId));
	    }
	    
	    if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
	    	dateStart += " 00:00:00";
	    	anphamQuery.add(PropertyFactoryUtil.forName("ngayTao").ge(sf.parse(dateStart)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			anphamQuery.add(PropertyFactoryUtil.forName("ngayTao").le(sf.parse(dateEnd)));
	    	thongkeQuery.add(PropertyFactoryUtil.forName("ngaytao").le(sf.parse(dateEnd)));
		}
	    	    
		anphamQuery.add(PropertyFactoryUtil.forName("status").eq(3));
		anphamQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		anphamQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
		thongkeQuery.addOrder(OrderFactoryUtil.desc("ngaytao"));
		anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(anphamQuery);
		thongkeList = ThongKeNBLocalServiceUtil.dynamicQuery(thongkeQuery);
		combinedListAnPhamVaThongKe.addAll(anphamList);
		combinedListAnPhamVaThongKe.addAll(thongkeList);
		
		return combinedListAnPhamVaThongKe;
	}
	
	//get thống kê by loại ấn phẩm
	public static List<ThongKeNB> getThongKeNBByAnPhamId(long anphamId) throws Exception{
		DynamicQuery query = ThongKeNBLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("anphamId").eq(anphamId));
		List<ThongKeNB> getThongKeNBByAnPhamId = ThongKeNBLocalServiceUtil.dynamicQuery(query);
		return getThongKeNBByAnPhamId;
	}
}
