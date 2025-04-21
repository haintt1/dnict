package com.contact.utils;

import java.util.Comparator;
import java.util.List;

import javax.portlet.ActionRequest;

import com.contact.model.CanBo;
import com.contact.model.PhongBan;
import com.contact.model.ToChuc;
import com.contact.service.CanBoLocalServiceUtil;
import com.contact.service.PhongBanLocalServiceUtil;
import com.contact.service.ToChucLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

public class QLLienHeAdmin {
	
	public static List<ToChuc> getListTimKiemToChuc(String trangThai, String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = ToChucLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(trangThai) && !trangThai.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tinhTrang", Long.parseLong(trangThai)));
		}
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<ToChuc> listTimKiemToChuc = ToChucLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemToChuc;
	}
	
	public static List<ToChuc> getListXoaMemToChuc(String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = ToChucLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 1L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<ToChuc> listTimKiemToChuc = ToChucLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemToChuc;
	}
	
	public static List<PhongBan> getListTimKiemPhongBan(String trangThai, String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = PhongBanLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(trangThai) && !trangThai.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tinhTrang", Long.parseLong(trangThai)));
		}
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<PhongBan> listTimKiemPhongBan = PhongBanLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemPhongBan;
	}
	
	public static List<PhongBan> getListXoaMemPhongBan(String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = PhongBanLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%" ));
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 1L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<PhongBan> listTimKiemPhongBan = PhongBanLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemPhongBan;
	}
	
	public static List<CanBo> getListTimKiemCanBo(String phongBan, String trangThai, String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = CanBoLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(phongBan) && !phongBan.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("phongban_id", Long.parseLong(phongBan)));
		}
		if(Validator.isNotNull(trangThai) && !trangThai.equals("")){
			dynamicQuery.add(RestrictionsFactoryUtil.eq("tinhTrang", Long.parseLong(trangThai)));
		}
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			Disjunction CBDis = RestrictionsFactoryUtil.disjunction();
			CBDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("chucVu", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("email", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("sdt", "%" + tuKhoa + "%"));
			dynamicQuery.add(CBDis);
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 0L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<CanBo> listTimKiemCanBo = CanBoLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemCanBo;
	}
	
	public static List<CanBo> getListXoaMemCanBo(String tuKhoa) throws Exception{
		DynamicQuery dynamicQuery = CanBoLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(tuKhoa) && !tuKhoa.equals("")){
			Disjunction CBDis = RestrictionsFactoryUtil.disjunction();
			CBDis.add(RestrictionsFactoryUtil.ilike("ten", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("chucVu", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("email", "%" + tuKhoa + "%"));
			CBDis.add(RestrictionsFactoryUtil.ilike("sdt", "%" + tuKhoa + "%"));
			dynamicQuery.add(CBDis);
		}
		dynamicQuery.add(RestrictionsFactoryUtil.eq("daXoa", 1L));
		dynamicQuery.addOrder(OrderFactoryUtil.asc("sapXep"));
		List<CanBo> listTimKiemCanBo = CanBoLocalServiceUtil.dynamicQuery(dynamicQuery);
		return listTimKiemCanBo;
	}
}
