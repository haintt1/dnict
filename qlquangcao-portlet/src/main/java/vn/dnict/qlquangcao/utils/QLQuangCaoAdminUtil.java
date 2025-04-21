package vn.dnict.qlquangcao.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.qlquangcao.model.BangQuangCao;
import vn.dnict.qlquangcao.model.NhomKH;
import vn.dnict.qlquangcao.model.ViTriDanhMuc;
import vn.dnict.qlquangcao.service.BangQuangCaoLocalServiceUtil;
import vn.dnict.qlquangcao.service.NhomKHLocalServiceUtil;
import vn.dnict.qlquangcao.service.ViTriDanhMucLocalServiceUtil;


public class QLQuangCaoAdminUtil {
	public static List<NhomKH> listNhomKHAdmin(String nhomKH, String trangthai) throws Exception{
		DynamicQuery query = NhomKHLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(nhomKH) && !nhomKH.equals("")){
			Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("nguoidaidien", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("mota", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("diachi", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("sdt", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("email", "%" + nhomKH + "%"));
	        query.add(newsDis);
			
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		List<NhomKH> listnhomKH = NhomKHLocalServiceUtil.dynamicQuery(query);
		return listnhomKH.isEmpty() ? Collections.emptyList() : listnhomKH;
	}
	
	public static List<NhomKH> listNhomKH() throws Exception{
		DynamicQuery query = NhomKHLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		query.add(RestrictionsFactoryUtil.eq("trangthai", 1));
		List<NhomKH> listnhomKH = NhomKHLocalServiceUtil.dynamicQuery(query);
		return listnhomKH.isEmpty() ? Collections.emptyList() : listnhomKH;
	}
	
	public static List<NhomKH> listNhomKHAdminDaXoa(String nhomKH, String trangthai) throws Exception{
		DynamicQuery query = NhomKHLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(nhomKH) && !nhomKH.equals("")){
			Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("nguoidaidien", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("mota", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("diachi", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("sdt", "%" + nhomKH + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("email", "%" + nhomKH + "%"));
	        query.add(newsDis);
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 1));
		List<NhomKH> listnhomKH = NhomKHLocalServiceUtil.dynamicQuery(query);
		return listnhomKH;
	}
	
	public static List<ViTriDanhMuc> listViTriDM(String ten, String trangthai) throws Exception{
		DynamicQuery query = ViTriDanhMucLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(ten) && !ten.equals("")){
			Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + ten + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("cssClass", "%" + ten + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("kichthuoc", "%" + ten + "%"));
	        query.add(newsDis);
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		List<ViTriDanhMuc> listViTriDM = ViTriDanhMucLocalServiceUtil.dynamicQuery(query);
		return listViTriDM;
	}
	
	public static List<ViTriDanhMuc> listViTriDMDaXoa(String ten, String trangthai) throws Exception{
		DynamicQuery query = ViTriDanhMucLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(ten) && !ten.equals("")){
			Disjunction newsDis = RestrictionsFactoryUtil.disjunction();
	        newsDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + ten + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("cssClass", "%" + ten + "%"));
	        newsDis.add(RestrictionsFactoryUtil.ilike("kichthuoc", "%" + ten + "%"));
	        query.add(newsDis);
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 1));
		List<ViTriDanhMuc> listViTriDM = ViTriDanhMucLocalServiceUtil.dynamicQuery(query);
		return listViTriDM;
	}
	
	public static List<ViTriDanhMuc> listViTri() throws Exception{
		DynamicQuery query = ViTriDanhMucLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		query.add(RestrictionsFactoryUtil.eq("trangthai", 1));
		List<ViTriDanhMuc> listViTri = ViTriDanhMucLocalServiceUtil.dynamicQuery(query);
		return listViTri;
	}
	
	public static List<BangQuangCao> listQuangCaoByViTri(long idVT, int start, int end) throws Exception{
		DynamicQuery query = BangQuangCaoLocalServiceUtil.dynamicQuery();
		Date ngayhientai = new Date();
		query.add(RestrictionsFactoryUtil.eq("vitriQC", idVT));
		if(end!=0){
			query.setLimit(start, end);
		}
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientai));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		query.add(RestrictionsFactoryUtil.eq("trangthai", 1));
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		List<BangQuangCao> listQuangCao = BangQuangCaoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listQuangCao) || listQuangCao.size() <= 0){
			listQuangCao = new ArrayList<BangQuangCao>();
		}
		return listQuangCao;
	}
	
	public static List<BangQuangCao> listBannerQC(String tenQC, String vitri, String ngaytao_tungay, String ngayketthuc_denngay, String trangthai) throws Exception{
		DynamicQuery query = BangQuangCaoLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!tenQC.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenQC + "%" ));
		}
		if(!vitri.equals("") && Validator.isNumber(vitri)){
			query.add(RestrictionsFactoryUtil.eq("vitriQC", Long.valueOf(vitri)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngaytao").le(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngayketthuc_denngay) && !ngayketthuc_denngay.equals("")){
			ngayketthuc_denngay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngayketthuc").ge(df.parse(ngayketthuc_denngay)));
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		List<BangQuangCao> listBannerQC = BangQuangCaoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listBannerQC) || listBannerQC.size() <= 0){
			listBannerQC = new ArrayList<BangQuangCao>();
		}
		return listBannerQC;
	}
	
	public static List<BangQuangCao> listBannerQCDaXoa(String tenQC, String vitri, String ngaytao_tungay, String ngayketthuc_denngay, String trangthai) throws Exception{
		DynamicQuery query = BangQuangCaoLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!tenQC.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenQC + "%" ));
		}
		if(!vitri.equals("") && Validator.isNumber(vitri)){
			query.add(RestrictionsFactoryUtil.eq("vitriQC", Long.valueOf(vitri)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngaytao").le(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngayketthuc_denngay) && !ngayketthuc_denngay.equals("")){
			ngayketthuc_denngay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngayketthuc").ge(df.parse(ngayketthuc_denngay)));
		}
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("trangthai").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngaytao"));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 1));
		List<BangQuangCao> listBannerQC = BangQuangCaoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listBannerQC) || listBannerQC.size() <= 0){
			listBannerQC = new ArrayList<BangQuangCao>();
		}
		return listBannerQC;
	}
	
	public static List<BangQuangCao> listBannerQCGuest(String tenclass) throws Exception{
		Date ngayhientai = new Date();
		DynamicQuery query = BangQuangCaoLocalServiceUtil.dynamicQuery();
		if(!tenclass.equals("")){
			query.add(PropertyFactoryUtil.forName("vitriQC")
					.in(ViTriDanhMucLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("cssClass")
									.eq(tenclass))
							.setProjection(PropertyFactoryUtil.forName("id"))));
		}
		query.add(RestrictionsFactoryUtil.le("ngaytao", ngayhientai));
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientai));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		query.add(RestrictionsFactoryUtil.eq("trangthai", 1));
		List<BangQuangCao> listBannerQCGuest = BangQuangCaoLocalServiceUtil.dynamicQuery(query);
		return listBannerQCGuest.isEmpty() ? Collections.emptyList() : listBannerQCGuest;

//		if(Validator.isNull(listBannerQCGuest) || listBannerQCGuest.size() <= 0){
//			listBannerQCGuest = new ArrayList<BangQuangCao>();
//		}
//		return listBannerQCGuest;
	}
	
	public static List<BangQuangCao> listBannerMang(String tenclass) throws Exception{
		Date ngayhientai = new Date();
		DynamicQuery query = BangQuangCaoLocalServiceUtil.dynamicQuery();
		if(!tenclass.equals("")){
			query.add(PropertyFactoryUtil.forName("vitriQC")
					.in(ViTriDanhMucLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("cssClass")
									.eq(tenclass))
							.setProjection(PropertyFactoryUtil.forName("id"))));
		}
		query.add(RestrictionsFactoryUtil.le("ngaytao", ngayhientai));
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientai));
		query.add(RestrictionsFactoryUtil.eq("daxoa", 0));
		query.add(RestrictionsFactoryUtil.eq("trangthai", 1));
		List<BangQuangCao> listBannerQCGuest = BangQuangCaoLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listBannerQCGuest) || listBannerQCGuest.size() <= 0){
			listBannerQCGuest = new ArrayList<BangQuangCao>();
		}
		return listBannerQCGuest;
	}

}
