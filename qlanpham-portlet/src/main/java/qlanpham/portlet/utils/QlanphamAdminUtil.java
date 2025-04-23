package qlanpham.portlet.utils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import qlanphamdb.model.AnPham_Activity;
import qlanphamdb.model.AnPham_BinhLuan;
import qlanphamdb.model.AnPham_CongTacVien;
import qlanphamdb.model.AnPham_DeCuong;
import qlanphamdb.model.AnPham_DinhKemFile;
import qlanphamdb.model.AnPham_Loai;
import qlanphamdb.model.AnPham_Logs;
import qlanphamdb.model.AnPham_PhanCong;
import qlanphamdb.model.AnPham_TapChi;
import qlanphamdb.model.eMagazine;
import qlanphamdb.model.eMagazine_BinhLuan;
import qlanphamdb.model.eMagazine_template;
import qlanphamdb.service.AnPham_ActivityLocalServiceUtil;
import qlanphamdb.service.AnPham_BinhLuanLocalServiceUtil;
import qlanphamdb.service.AnPham_CongTacVienLocalServiceUtil;
import qlanphamdb.service.AnPham_DeCuongLocalServiceUtil;
import qlanphamdb.service.AnPham_DinhKemFileLocalServiceUtil;
import qlanphamdb.service.AnPham_LoaiLocalServiceUtil;
import qlanphamdb.service.AnPham_LogsLocalServiceUtil;
import qlanphamdb.service.AnPham_PhanCongLocalServiceUtil;
import qlanphamdb.service.AnPham_TapChiLocalServiceUtil;
import qlanphamdb.service.eMagazineLocalServiceUtil;
import qlanphamdb.service.eMagazine_BinhLuanLocalServiceUtil;
import qlanphamdb.service.eMagazine_templateLocalServiceUtil;
import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.service.News_ActivityLocalServiceUtil;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;

public class QlanphamAdminUtil {
	public static List<AnPham_Loai> listDmLoai(RenderRequest renderRequest, String ten, int status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = AnPham_LoaiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(ten != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("ten", "%" + ten + "%");
			query.add(name);
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.asc("orders"));
		List<AnPham_Loai> results = AnPham_LoaiLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
	public static List<AnPham_CongTacVien> listCongTacVien(RenderRequest renderRequest, String hoTen, String email, int status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = AnPham_CongTacVienLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(hoTen != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("hoTen", "%" + hoTen + "%");
			query.add(name);
		}
		if(email != null) {
			Criterion mail = RestrictionsFactoryUtil.ilike("email", "%" + email + "%");
			query.add(mail);
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.asc("orders"));
		List<AnPham_CongTacVien> results = AnPham_CongTacVienLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
	public static List<AnPham_DeCuong> listDeCuong(String ten, String loaiid, int status, int start, int end) throws Exception{
		DynamicQuery query = AnPham_DeCuongLocalServiceUtil.dynamicQuery();
		if(ten != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("ten", "%" + ten + "%");
			query.add(name);
		}
		if(!loaiid.equals("") && Integer.valueOf(loaiid) >= 0){
			query.add(PropertyFactoryUtil.forName("loaiId").eq(Long.valueOf(loaiid)));
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.asc("orders"));
		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<AnPham_DeCuong> results = AnPham_DeCuongLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
	public static List<AnPham_TapChi> listTapChiAdmin(String tenBaiViet, String dinhDanh, String anPham, String deCuong, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, 
			String trangThaiTinBai, int start, int end) throws Exception{
				
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tenBaiViet.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenBaiViet + "%" ));
		}
		if(!dinhDanh.equals("") && Validator.isNumber(dinhDanh)){
			query.add(RestrictionsFactoryUtil.eq("id", Long.valueOf(dinhDanh)));
		}
		if(!anPham.equals("") && Long.valueOf(anPham) >= 0){
			query.add(PropertyFactoryUtil.forName("loaiId").eq(Long.valueOf(anPham)));
		}
		if(!deCuong.equals("") && Long.valueOf(deCuong) >= 0){
			query.add(PropertyFactoryUtil.forName("deCuongId").eq(Long.valueOf(deCuong)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayTao").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayTao").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngaySua").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngaySua").le(df.parse(ngayhieuchinh_denngay)));
		}
		if(!trangThaiTinBai.equals("") && Integer.valueOf(trangThaiTinBai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangThaiTinBai)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.asc("orders"));
//		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.addOrder(OrderFactoryUtil.desc("id"));
		
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listTapChi = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listTapChi;
	}
	
	public static List<AnPham_TapChi> listTapChiDaXoaAdmin(String tenBaiViet, String dinhDanh, String anPham, String deCuong, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, 
			String trangThaiTinBai, int start, int end) throws Exception{
				
		DynamicQuery query = AnPham_TapChiLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tenBaiViet.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenBaiViet + "%" ));
		}
		if(!dinhDanh.equals("") && Validator.isNumber(dinhDanh)){
			query.add(RestrictionsFactoryUtil.eq("id", Long.valueOf(dinhDanh)));
		}
		if(!anPham.equals("") && Long.valueOf(anPham) >= 0){
			query.add(PropertyFactoryUtil.forName("loaiId").eq(Long.valueOf(anPham)));
		}
		if(!deCuong.equals("") && Long.valueOf(deCuong) >= 0){
			query.add(PropertyFactoryUtil.forName("deCuongId").eq(Long.valueOf(deCuong)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayTao").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayTao").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngaySua").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngaySua").le(df.parse(ngayhieuchinh_denngay)));
		}
		if(!trangThaiTinBai.equals("") && Integer.valueOf(trangThaiTinBai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangThaiTinBai)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(1));
		query.addOrder(OrderFactoryUtil.asc("orders"));
//		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.addOrder(OrderFactoryUtil.desc("id"));
		
		if(end!=0){
			query.setLimit(start, end);
		}
		List<AnPham_TapChi> listTapChi = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listTapChi;
	}
	
	public static List<AnPham_Loai> getDmLoai(RenderRequest renderRequest,int status) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = AnPham_LoaiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(status > -1) {
			
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		List<AnPham_Loai> dmLoai = new ArrayList<AnPham_Loai>();
		dmLoai = AnPham_LoaiLocalServiceUtil.dynamicQuery(query);
		return dmLoai;		
	}
	
	public static List<AnPham_DeCuong> getDmDeCuong(RenderRequest renderRequest,int status) throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = AnPham_DeCuongLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(status > -1) {
			
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		List<AnPham_DeCuong> dmDeCuong = new ArrayList<AnPham_DeCuong>();
		dmDeCuong = AnPham_DeCuongLocalServiceUtil.dynamicQuery(query);
		return dmDeCuong;		
	}
	
	public static AnPham_Logs requestobjLog(AnPham_TapChi objAnPhamLogs) {		
		long id = CounterLocalServiceUtil.increment(AnPham_LogsLocalServiceUtil.class.getName());
		AnPham_Logs objLog = AnPham_LogsLocalServiceUtil.createAnPham_Logs(id);
		objLog.setId(id);
		objLog.setGroupId(objAnPhamLogs.getGroupId());
		objLog.setCompanyId(objAnPhamLogs.getCompanyId());
		objLog.setTen(objAnPhamLogs.getTen());
		objLog.setSlug(objAnPhamLogs.getSlug());
		objLog.setMoTa(objAnPhamLogs.getMoTa());
		objLog.setAnhDaiDien(objAnPhamLogs.getAnhDaiDien());
		objLog.setLoaiId(objAnPhamLogs.getLoaiId());
		objLog.setDeCuongId(objAnPhamLogs.getDeCuongId());
		objLog.setNoiDung(objAnPhamLogs.getNoiDung());
		objLog.setTuKhoa(objAnPhamLogs.getTuKhoa());
		objLog.setPhienBan(objAnPhamLogs.getPhienBan());
		objLog.setLuotXem(objAnPhamLogs.getLuotXem());
		objLog.setAnPhamId(objAnPhamLogs.getId());
		objLog.setNguoiTao(objAnPhamLogs.getNguoiTao());
		objLog.setNgayTao(objAnPhamLogs.getNgayTao());
		objLog.setNguoiSua(objAnPhamLogs.getNguoiSua());
		objLog.setNgaySua(objAnPhamLogs.getNgaySua());
//		objLog.setNguoiNhan(objAnPhamLogs.getNguoiNhan());
		objLog.setNgayXuLy(new Date());
		objLog.setLanguage(objAnPhamLogs.getLanguage());
		objLog.setLoaiTin(objAnPhamLogs.getLoaiTin());
		objLog.setIsFormHienBinhLuan(objAnPhamLogs.getIsFormHienBinhLuan());
		objLog.setIsFormViewBinhLuan(objAnPhamLogs.getIsFormViewBinhLuan());
//		objLog.setStatus(objAnPhamLogs.getStatus());
		objLog.setOrders(objAnPhamLogs.getOrders());
		objLog.setDelete_status(objAnPhamLogs.getDelete_status());
	
		return objLog;
	}
	
	public static List<AnPham_Logs> getAnPhamLogByAnPhamId (long anPhamId) throws Exception {
		DynamicQuery query = AnPham_LogsLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId))
				.addOrder(OrderFactoryUtil.desc("ngayXuLy"));
		List<AnPham_Logs> list = AnPham_LogsLocalServiceUtil.dynamicQuery(query);
		return list;
	}
	
	public static List<AnPham_DinhKemFile> getLinkDinhKemByAnPhamId(long anPhamid) throws Exception {
		DynamicQuery query = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("ObjectId").eq(anPhamid));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<AnPham_DinhKemFile> listFiledinhkem = AnPham_DinhKemFileLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listFiledinhkem) || listFiledinhkem.size() <= 0){
			listFiledinhkem = new ArrayList<AnPham_DinhKemFile>();
		}
		return listFiledinhkem;
	}	
	
	// Đối chiếu log và hiện tại -> thông báo trường nào thay đổi
//	public static List<AnPham_Logs> getAnPhamLogByAnPhamIdAndStatus (long anPhamId) throws Exception {
//		DynamicQuery query = AnPham_LogsLocalServiceUtil.dynamicQuery()
//				.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId))
//				.addOrder(OrderFactoryUtil.desc("ngayXuLy"));
//		List<AnPham_Logs> list = AnPham_LogsLocalServiceUtil.dynamicQuery(query);
//		return list;
//	}
	
	// Hiệu chỉnh
	public static boolean checkYeuCauHieuChinhByUserIdAnd (long userId, long deCuongId, long anPhamId) throws Exception {
		boolean check = false;
		DynamicQuery query = AnPham_ActivityLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("enduserid").eq(userId));
		if(deCuongId > 0) {
			query.add(PropertyFactoryUtil.forName("deCuongId").eq(deCuongId));
		}
		
		if(anPhamId > 0) {
			query.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId));
		}	
		List<AnPham_Activity> list = AnPham_ActivityLocalServiceUtil.dynamicQuery(query);
		if(list.size()>0){
			check = true;
		}else {
			check = false;
		}
		return check; 
	}
	
	public static List<AnPham_Activity> listAnPhamAtivityBydeCuongIdAndAnPhamId (long deCuongId, long anPhamId) throws Exception {
		DynamicQuery query = AnPham_ActivityLocalServiceUtil.dynamicQuery();
		if(deCuongId > 0){
				query.add(PropertyFactoryUtil.forName("deCuongId").eq(deCuongId));
		}
		if(anPhamId > 0){
			query.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId));
	}
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<AnPham_Activity> list = AnPham_ActivityLocalServiceUtil.dynamicQuery(query);
		return list; 
	}
	
	public static AnPham_Activity getAnPhamAtivityById (long userId, long anPhamId) throws Exception {
		AnPham_Activity object = null;
		DynamicQuery query = AnPham_ActivityLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("anPhamId").eq(anPhamId))
				.add(PropertyFactoryUtil.forName("enduserid").eq(userId));
		
		List<AnPham_Activity> list = AnPham_ActivityLocalServiceUtil.dynamicQuery(query);
		if(list.size()>0){
			object = list.get(0);
		}
		return object; 
	}
	
	// Phân công công việc
	public static List<AnPham_PhanCong> listPhanCong(String noidung, String loaiId, String decuongId, String ctvId, int status, int start, int end) throws Exception{
		DynamicQuery query = AnPham_PhanCongLocalServiceUtil.dynamicQuery();
		if(noidung != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("noiDung", "%" + noidung + "%");
			query.add(name);
		}
		if(!loaiId.equals("") && Integer.valueOf(loaiId) >= 0){
			query.add(PropertyFactoryUtil.forName("loaiId").eq(Long.valueOf(loaiId)));
		}
		if(!decuongId.equals("") && Integer.valueOf(decuongId) >= 0){
			query.add(PropertyFactoryUtil.forName("deCuongId").eq(Long.valueOf(decuongId)));
		}
		if(!ctvId.equals("") && Integer.valueOf(ctvId) >= 0){
			query.add(PropertyFactoryUtil.forName("ctvId").eq(Long.valueOf(ctvId)));
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<AnPham_PhanCong> results = AnPham_PhanCongLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
	public static List<AnPham_BinhLuan> listBinhLuanAnPham(String noidung, String ngaybatdau, String ngayketthuc, String status, int start, int end) throws Exception{
		DynamicQuery query = AnPham_BinhLuanLocalServiceUtil.dynamicQuery();
		if(noidung != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("noiDung", "%" + noidung + "%");
			query.add(name);
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(Validator.isNotNull(ngaybatdau) && !ngaybatdau.equals("")){
			ngaybatdau += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayBinhLuan").ge(sf.parse(ngaybatdau)));
		}
		if(Validator.isNotNull(ngayketthuc) && !ngayketthuc.equals("")){
			ngayketthuc += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayBinhLuan").le(sf.parse(ngayketthuc)));
		}
		
		if(Validator.isNotNull(status) && !status.equals("")){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
		
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<AnPham_BinhLuan> results = AnPham_BinhLuanLocalServiceUtil.dynamicQuery(query);
		return results.isEmpty() ? Collections.emptyList() : results;
	}
	
	public static List<eMagazine_BinhLuan> listBinhLuanMagazine(String noidung, String ngaybatdau, String ngayketthuc, String status, int start, int end) throws Exception{
		DynamicQuery query = eMagazine_BinhLuanLocalServiceUtil.dynamicQuery();
		if(noidung != null) {
			Criterion name = RestrictionsFactoryUtil.ilike("noiDung", "%" + noidung + "%");
			query.add(name);
		}
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(Validator.isNotNull(ngaybatdau) && !ngaybatdau.equals("")){
			ngaybatdau += " 00:00:00";
	    	query.add(PropertyFactoryUtil.forName("ngayBinhLuan").ge(sf.parse(ngaybatdau)));
		}
		if(Validator.isNotNull(ngayketthuc) && !ngayketthuc.equals("")){
			ngayketthuc += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayBinhLuan").le(sf.parse(ngayketthuc)));
		}
		
		if(Validator.isNotNull(status) && !status.equals("")){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
		
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<eMagazine_BinhLuan> results = eMagazine_BinhLuanLocalServiceUtil.dynamicQuery(query);
		return results.isEmpty() ? Collections.emptyList() : results;
	}
	
	// E-Magazine
	public static List<eMagazine> listEMagazine(String tenEMagazine, String dinhDanh, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, 
			String trangThaiTinBai, int start, int end) throws Exception{
				
		DynamicQuery query = eMagazineLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tenEMagazine.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenEMagazine + "%" ));
		}
		if(!dinhDanh.equals("") && Validator.isNumber(dinhDanh)){
			query.add(RestrictionsFactoryUtil.eq("id", Long.valueOf(dinhDanh)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayTao").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayTao").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngaySua").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngaySua").le(df.parse(ngayhieuchinh_denngay)));
		}
		if(!trangThaiTinBai.equals("") && Integer.valueOf(trangThaiTinBai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangThaiTinBai)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.asc("orders"));
//		query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.addOrder(OrderFactoryUtil.desc("id"));
		
		if(end!=0){
			query.setLimit(start, end);
		}
		List<eMagazine> listEMagazine = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listEMagazine.isEmpty() ? Collections.emptyList() : listEMagazine;
	}
	
	// E-Magazine
	public static List<eMagazine> listEMagazineDaXoa(String tenEMagazine, String dinhDanh, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, 
			String trangThaiTinBai, int start, int end) throws Exception{
				
		DynamicQuery query = eMagazineLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tenEMagazine.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("ten", "%" + tenEMagazine + "%" ));
		}
		if(!dinhDanh.equals("") && Validator.isNumber(dinhDanh)){
			query.add(RestrictionsFactoryUtil.eq("id", Long.valueOf(dinhDanh)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
//				System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayTao").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayTao").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngaySua").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngaySua").le(df.parse(ngayhieuchinh_denngay)));
		}
		if(!trangThaiTinBai.equals("") && Integer.valueOf(trangThaiTinBai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangThaiTinBai)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(1));
		query.addOrder(OrderFactoryUtil.asc("orders"));
//			query.addOrder(OrderFactoryUtil.desc("ngayTao"));
		query.addOrder(OrderFactoryUtil.desc("id"));
		
		if(end!=0){
			query.setLimit(start, end);
		}
		List<eMagazine> listEMagazine = AnPham_TapChiLocalServiceUtil.dynamicQuery(query);
		return listEMagazine;
	}
	
	public static List<eMagazine_template> listEMagazineTemplate() throws Exception{
		DynamicQuery query = eMagazine_templateLocalServiceUtil.dynamicQuery();	
		List<eMagazine_template> listEMagazineTemplate = eMagazine_templateLocalServiceUtil.dynamicQuery(query);
		return listEMagazineTemplate.isEmpty() ? Collections.emptyList() : listEMagazineTemplate;
	}
	
	public static List<eMagazine_template> getListTemplateByTemplateId() throws Exception{
		DynamicQuery query = eMagazine_templateLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("status").eq(1));
		List<eMagazine_template> getListTemplateByTemplateId = eMagazine_templateLocalServiceUtil.dynamicQuery(query);
		return getListTemplateByTemplateId.isEmpty() ? Collections.emptyList() : getListTemplateByTemplateId;
	}

}
