package vn.dnict.qlnhuanbut.utils;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import qlanphamdb.model.AnPham_Loai;
import qlanphamdb.service.AnPham_LoaiLocalServiceUtil;
import vn.dnict.qlnhuanbut.model.DinhMuc;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;
import vn.dnict.qlnhuanbut.model.ThongKeNB;
import vn.dnict.qlnhuanbut.service.DinhMucLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoLoaiAPLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.HeSoTheLoaiLocalServiceUtil;
import vn.dnict.qlnhuanbut.service.ThongKeNBLocalServiceUtil;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Type;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_TypeLocalServiceUtil;


public class QLNhuanButAdminUtil {
	public static List<News_Type> listTheLoai() throws Exception{
		DynamicQuery query = News_TypeLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("status", 0));
		query.add(RestrictionsFactoryUtil.eq("delete_status", 0));
		List<News_Type> listTheLoai = News_TypeLocalServiceUtil.dynamicQuery(query);
		return listTheLoai.isEmpty() ? Collections.emptyList() : listTheLoai;
	}
	public static List<AnPham_Loai> listLoaiAnPham() throws Exception{
		DynamicQuery query = AnPham_LoaiLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("status", 1));
		query.add(RestrictionsFactoryUtil.eq("delete_status", 0));
		List<AnPham_Loai> listLoaiAnPham = AnPham_LoaiLocalServiceUtil.dynamicQuery(query);
		return listLoaiAnPham.isEmpty() ? Collections.emptyList() : listLoaiAnPham;
	}
	public static List<HeSoTheLoai> listHeSoTheLoai() throws Exception{
		DynamicQuery query = HeSoTheLoaiLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("typeId"));
		List<HeSoTheLoai> listHeSoTheLoai = HeSoTheLoaiLocalServiceUtil.dynamicQuery(query);
		return listHeSoTheLoai.isEmpty() ? Collections.emptyList() : listHeSoTheLoai;
	}
	public static List<HeSoLoaiAP> listHeSoLoaiAP() throws Exception{
		DynamicQuery query = HeSoLoaiAPLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("loaiId"));
		List<HeSoLoaiAP> listHeSoLoaiAP = HeSoLoaiAPLocalServiceUtil.dynamicQuery(query);
		return listHeSoLoaiAP.isEmpty() ? Collections.emptyList() : listHeSoLoaiAP;
	}
	public static List<DinhMuc> listDinhMuc() throws Exception{
		DynamicQuery query = DinhMucLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("loaidinhmuc"));
		List<DinhMuc> listDinhMuc = DinhMucLocalServiceUtil.dynamicQuery(query);
		return listDinhMuc.isEmpty() ? Collections.emptyList() : listDinhMuc;
	}
	
	//get hệ số by thể loại
	public static List<HeSoTheLoai> getHeSoByTheLoai(long typeid) throws Exception{
		DynamicQuery query = HeSoTheLoaiLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("typeId").eq(typeid));
		List<HeSoTheLoai> getHeSoByTheLoai = HeSoTheLoaiLocalServiceUtil.dynamicQuery(query);
		return getHeSoByTheLoai;
	}
	
	//get hệ số by loại ấn phẩm
	public static List<HeSoLoaiAP> getHeSoByLoaiId(long loaiId) throws Exception{
		DynamicQuery query = HeSoLoaiAPLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("loaiId").eq(loaiId));
		List<HeSoLoaiAP> getHeSoByLoaiId = HeSoLoaiAPLocalServiceUtil.dynamicQuery(query);
		return getHeSoByLoaiId;
	}
	
	//get hệ số by thể loại
	public static List<ThongKeNB> getThongKeNBByIdNew(long idnew) throws Exception{
		DynamicQuery query = ThongKeNBLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("newarticleId").eq(idnew));
		List<ThongKeNB> getThongKeNBByIdNew = ThongKeNBLocalServiceUtil.dynamicQuery(query);
		return getThongKeNBByIdNew;
	}
}
