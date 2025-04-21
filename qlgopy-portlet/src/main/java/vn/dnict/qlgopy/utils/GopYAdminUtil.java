package vn.dnict.qlgopy.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.qlgopy.model.HoiDapGopY;
import vn.dnict.qlgopy.service.HoiDapGopYLocalServiceUtil;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;

public class GopYAdminUtil {
	public static List<HoiDapGopY> listGopYAdmin(String cauhoi, String ngaygui_tungay, String ngaygui_denngay, int typeform, 
			String trangthai) throws Exception{
				
		DynamicQuery query = HoiDapGopYLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!cauhoi.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("title", "%" + cauhoi + "%" ));
		}
		if(Validator.isNotNull(ngaygui_tungay) && !ngaygui_tungay.equals("")){
			ngaygui_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").ge(df.parse(ngaygui_tungay)));
		}
		if(Validator.isNotNull(ngaygui_denngay) && !ngaygui_denngay.equals("")){
			ngaygui_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").le(df.parse(ngaygui_denngay)));
		}
		
		query.add(PropertyFactoryUtil.forName("typeForm").eq(Integer.valueOf(typeform)));
		
		if(!trangthai.equals("") && Integer.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("is_traloi").eq(Integer.valueOf(trangthai)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngay_guigopy"));
	
		List<HoiDapGopY> listTapChi = HoiDapGopYLocalServiceUtil.dynamicQuery(query);
		return listTapChi;
	}
	
	public static List<HoiDapGopY> listTinDocGiaAdmin(String cauhoi, String ngaygui_tungay, String ngaygui_denngay, int typeform, 
			String pheduyet) throws Exception{
				
		DynamicQuery query = HoiDapGopYLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(!cauhoi.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("title", "%" + cauhoi + "%" ));
		}
		if(Validator.isNotNull(ngaygui_tungay) && !ngaygui_tungay.equals("")){
			ngaygui_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").ge(df.parse(ngaygui_tungay)));
		}
		if(Validator.isNotNull(ngaygui_denngay) && !ngaygui_denngay.equals("")){
			ngaygui_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").le(df.parse(ngaygui_denngay)));
		}
		
		query.add(PropertyFactoryUtil.forName("typeForm").eq(typeform));
		if(!pheduyet.equals("") && Integer.valueOf(pheduyet) >= 0){
			query.add(PropertyFactoryUtil.forName("is_pheduyet").eq(Integer.valueOf(pheduyet)));
		}
		query.addOrder(OrderFactoryUtil.desc("ngay_guigopy"));
	
		List<HoiDapGopY> listTapChi = HoiDapGopYLocalServiceUtil.dynamicQuery(query);
		return listTapChi;
	}
	
	
	public static List<HoiDapGopY> listGoYUser(String cauhoi, String ngaygui_tungay, String ngaygui_denngay, int typeform, 
			int isTraLoi) throws Exception{
				
		DynamicQuery query = HoiDapGopYLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!cauhoi.equals("")) {
			query.add(RestrictionsFactoryUtil.ilike("title", "%" + cauhoi + "%" ));
		}
		if(Validator.isNotNull(ngaygui_tungay) && !ngaygui_tungay.equals("")){
			ngaygui_tungay += " 00:00:00";
//			System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").ge(df.parse(ngaygui_tungay)));
		}
		if(Validator.isNotNull(ngaygui_denngay) && !ngaygui_denngay.equals("")){
			ngaygui_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngay_guigopy").le(df.parse(ngaygui_denngay)));
		}
		
		query.add(PropertyFactoryUtil.forName("typeForm").eq(typeform));
		
		if(isTraLoi > -1){
			query.add(PropertyFactoryUtil.forName("is_traloi").eq(isTraLoi));
		}
		query.addOrder(OrderFactoryUtil.desc("ngay_guigopy"));
	
		List<HoiDapGopY> listTapChi = HoiDapGopYLocalServiceUtil.dynamicQuery(query);
		return listTapChi;
	}
	
	public static List<News_role> getListRole(int start, int end) {
		DynamicQuery query = News_roleLocalServiceUtil.dynamicQuery();
		if(end != 0){
			query.setLimit(start, end);
		}
		List<News_role> listRole = News_roleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listRole) || listRole.size() <= 0){
			listRole = new ArrayList<News_role>();
		}
		return listRole;
	}
}
