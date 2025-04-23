package qlanpham.portlet.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import qlanphamdb.model.AnPham_BinhLuan;
import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_Loai;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.model.eMagazine;
import qlanphamdb.model.eMagazine_BinhLuan;
import qlanphamdb.service.AnPham_BinhLuanLocalServiceUtil;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_LoaiLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.eMagazine_BinhLuanLocalServiceUtil;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.model.News_NguonTin;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil;

public class AnPhamGuestUtil {
	
	public static String subStringTotal(String str, int indx){
		String strtmp = "";
		if(Validator.isNotNull(str) && indx > 0){
			strtmp = str.substring(0, indx + 1);
			int inttmp = 0;
			inttmp = strtmp.lastIndexOf(" ");
			strtmp = strtmp.substring(0, inttmp);
		}
		return strtmp;
	}
	
	public static List<AnPham_TapChi> listTapChi(int start, int end) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listArticle = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<AnPham_TapChi>();
		}
		return listArticle;
	}
	
	public static List<AnPham_Loai> listTheLoai() throws Exception{
		DynamicQuery query = AnPham_LoaiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.asc("orders"));
		List<AnPham_Loai> listTL = AnPham_LoaiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listTL) || listTL.size() <= 0){
			listTL = new ArrayList<AnPham_Loai>();
		}
		return listTL;
	}
	
	public static List<AnPham_TapChi> listTapChiByTheLoai(long idTL, int start, int end) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("loaiId", idTL));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listArticle = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<AnPham_TapChi>();
		}
		return listArticle;
	}
	
	public static List<AnPham_TapChi> listTapChiByLuotXem(int start, int end) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("luotXem"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listArticle = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<AnPham_TapChi>();
		}
		return listArticle;
	}
	
	public static List<AnPham_TapChi> getTapChiDaiDien(long idTL, int start, int end) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("loaiId", idTL));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listArticle = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<AnPham_TapChi>();
		}
		return listArticle;
	}
	
	public static List<News_Categories> listChuyenMuc() throws Exception{
		DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("orders"));
		List<News_Categories> listChuyenMuc = News_CategoriesLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listChuyenMuc) || listChuyenMuc.size() <= 0){
			listChuyenMuc = new ArrayList<News_Categories>();
		}
		return listChuyenMuc;
	}
	
	public static List<News_NguonTin> listTacGia(int status, int delete_status) throws Exception{
		DynamicQuery query = News_NguonTinLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(delete_status));
		query.add(PropertyFactoryUtil.forName("status").eq(status));
		query.addOrder(OrderFactoryUtil.desc("orders"));
		query.setLimit(0, 10);
		List<News_NguonTin> listNguonTin = News_NguonTinLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listNguonTin) || listNguonTin.size() <= 0){
			listNguonTin = new ArrayList<News_NguonTin>();
		}
		return listNguonTin;
	}
	
	public static List<AnPham_TapChi> listTenTapChi(int status, int delete_status) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(delete_status));
		query.add(PropertyFactoryUtil.forName("status").eq(status));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.setLimit(0, 10);
		List<AnPham_TapChi> listTenTapChi = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listTenTapChi) || listTenTapChi.size() <= 0){
			listTenTapChi = new ArrayList<AnPham_TapChi>();
		}
		return listTenTapChi;
	}
	
	public static List<Long> getTinTucIdByChuyenMucId(long chuyenmucId) {
		DynamicQuery TinTucChuyenMucQuery = News_Article2CategoryLocalServiceUtil.dynamicQuery();
		TinTucChuyenMucQuery.add(RestrictionsFactoryUtil.eq("newcategoryId", chuyenmucId));
		TinTucChuyenMucQuery.setProjection(ProjectionFactoryUtil.property("newarticleId")); // Chỉ lấy newarticleId
	    return News_Article2CategoryLocalServiceUtil.dynamicQuery(TinTucChuyenMucQuery);
	}
	
	public static List<Object> getCombineTinTucAnPham(String keyword, String chuyenmuc, String slug_tapchi) {
	    List<News_Article> newsList = new ArrayList<>();
	    List<AnPham_TapChi> anphamList = new ArrayList<>();
	    List<Object> combinedList = new ArrayList<>();

	    // TH1: Chỉ có keyword -> lấy cả tin tức và ấn phẩm
	    if (Validator.isNotNull(keyword) && Validator.isNull(chuyenmuc) && Validator.isNull(slug_tapchi)) {
	        // Tìm tin tức
	        DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
	        Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("title", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("info", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("content", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("congtacvien", "%" + keyword + "%"));
	        newsQuery.add(newsDis);
	        newsQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	        newsQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	        newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);

	        // Tìm ấn phẩm
	        DynamicQuery magazineQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	        Disjunction magazineDis = RestrictionsFactoryUtil.disjunction();
	        magazineDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + keyword + "%"));
	        magazineDis.add(RestrictionsFactoryUtil.ilike("moTa", "%" + keyword + "%"));
	        magazineDis.add(RestrictionsFactoryUtil.ilike("noiDung", "%" + keyword + "%"));
	        magazineQuery.add(magazineDis);
	        magazineQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	        magazineQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	        anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(magazineQuery);
	    }
	    
	    // TH2: Có keyword và chuyên mục -> chỉ lấy tin tức
	    else if (Validator.isNotNull(keyword) && Validator.isNotNull(chuyenmuc)) {
	        DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
	        
	        // Điều kiện tìm kiếm theo keyword
	        Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("title", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("info", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("content", "%" + keyword + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("congtacvien", "%" + keyword + "%"));
	        newsQuery.add(newsDis);

	        // Lọc theo chuyên mục
	        List<Long> tintucId = AnPhamGuestUtil.getTinTucIdByChuyenMucId(Long.valueOf(chuyenmuc));
	        if (!tintucId.isEmpty()) {
	            newsQuery.add(RestrictionsFactoryUtil.in("id", tintucId));
	            newsQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	            newsQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	            newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);
	        }
	    }
	    
	    // TH3: Có keyword và ấn phẩm -> chỉ lấy ấn phẩm
	    else if (Validator.isNotNull(keyword) && Validator.isNotNull(slug_tapchi)) {
	        DynamicQuery magazineQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	        
	        // Điều kiện tìm kiếm theo keyword
	        Disjunction magazineDis = RestrictionsFactoryUtil.disjunction();
	        magazineDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + keyword + "%"));
	        magazineDis.add(RestrictionsFactoryUtil.ilike("moTa", "%" + keyword + "%"));
	        magazineDis.add(RestrictionsFactoryUtil.ilike("noiDung", "%" + keyword + "%"));
	        magazineQuery.add(magazineDis);

	        // Lọc theo loại ấn phẩm
	        if ("socuhon".equals(slug_tapchi)) {
	            magazineQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
	        } else {
	            magazineQuery.add(RestrictionsFactoryUtil.eq("slug", slug_tapchi));
	        }
	        magazineQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	        magazineQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	        anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(magazineQuery);
	    }
	    
	    else if (Validator.isNotNull(chuyenmuc)) {
	    	DynamicQuery newsQuery = News_ArticleLocalServiceUtil.dynamicQuery();
	    	// Lọc theo chuyên mục
	        List<Long> tintucId = AnPhamGuestUtil.getTinTucIdByChuyenMucId(Long.valueOf(chuyenmuc));
	        if (!tintucId.isEmpty()) {
	            newsQuery.add(RestrictionsFactoryUtil.in("id", tintucId));
	            newsQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	            newsQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	            newsList = News_ArticleLocalServiceUtil.dynamicQuery(newsQuery);
	        }
	    }
	    
	    else if (Validator.isNotNull(slug_tapchi)) {
	    	DynamicQuery magazineQuery = AnPham_TapChiLocalServiceUtil.dynamicQuery();
	    	// Lọc theo loại ấn phẩm
	        if ("socuhon".equals(slug_tapchi)) {
	            magazineQuery.addOrder(OrderFactoryUtil.desc("ngayTao"));
	        } else {
	            magazineQuery.add(RestrictionsFactoryUtil.eq("slug", slug_tapchi));
	        }
	        magazineQuery.add(RestrictionsFactoryUtil.eq("status", 3));
	        magazineQuery.add(RestrictionsFactoryUtil.eq("delete_status", 0));
	        anphamList = AnPham_TapChiLocalServiceUtil.dynamicQuery(magazineQuery);
	    }

	    // Kết hợp kết quả
	    combinedList.addAll(newsList);
	    combinedList.addAll(anphamList);
	    
	    return combinedList;
	}
	
	public static List<AnPham_TapChi> getTapChiLienQuan(long idTC, long idTL) throws Exception{
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("loaiId", idTL));
		query.add(RestrictionsFactoryUtil.ne("id", idTC));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		List<AnPham_TapChi> listArticle = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<AnPham_TapChi>();
		}
		return listArticle;
	}
	
	public static List<AnPham_DinhKemFile> getFileByAnPhamId(long anPhamId) throws Exception{
		DynamicQuery query = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("ObjectId", anPhamId));
		List<AnPham_DinhKemFile> listFile = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery(query);
		return listFile.isEmpty() ? Collections.emptyList() : listFile;
	}
	
	public static List<eMagazine> listeMagazine(int start, int end) throws Exception{
		DynamicQuery query = eMagazineLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<eMagazine> listeMagazine = eMagazineLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listeMagazine) || listeMagazine.size() <= 0){
			listeMagazine = new ArrayList<eMagazine>();
		}
		return listeMagazine;
	}
	
	public static eMagazine geteMagazineBySlug(String slug) throws Exception{
		DynamicQuery query = eMagazineLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("slug", slug));
		List<eMagazine> result = eMagazineLocalServiceUtil.dynamicQuery(query, 0, 1);
	    return result.isEmpty() ? null : result.get(0);
		
	}
	
	public static List<AnPham_BinhLuan> getObjBinhLuan(long anPhamId) throws Exception {
		DynamicQuery query = AnPham_BinhLuanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId));
		query.add(PropertyFactoryUtil.forName("status").eq(1));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("id"));
		query.setLimit(0, 5);
		List<AnPham_BinhLuan> objBinhLuan = AnPham_BinhLuanLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(objBinhLuan) || objBinhLuan.size() <= 0){
			objBinhLuan = new ArrayList<AnPham_BinhLuan>();
		}
		return objBinhLuan;
		
	}
	
	public static List<eMagazine_BinhLuan> getObjBinhLuanMagazine(long magazineId) throws Exception {
		DynamicQuery query = eMagazine_BinhLuanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("magazineId").eq(magazineId));
		query.add(PropertyFactoryUtil.forName("status").eq(1));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("id"));
		query.setLimit(0, 5);
		List<eMagazine_BinhLuan> objBinhLuan = eMagazine_BinhLuanLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(objBinhLuan) || objBinhLuan.size() <= 0){
			objBinhLuan = new ArrayList<eMagazine_BinhLuan>();
		}
		return objBinhLuan;
		
	}
}
