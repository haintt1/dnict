package vn.dnict.vanbanphapquy.utils;

import java.text.SimpleDateFormat;
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

import vn.dnict.vanbanphapquy.model.Capbanhanh;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;
import vn.dnict.vanbanphapquy.model.Linhvucvanban;
import vn.dnict.vanbanphapquy.model.Loaivanban;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;
import vn.dnict.vanbanphapquy.model.dinhkemfile;
import vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.dinhkemfileLocalServiceUtil;



public class VanbanphapquyAdminUtil {
	
	public static List<Capbanhanh> countCapbanhanhByKeyword(RenderRequest renderRequest, String name, int status, int start, int end) throws Exception {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			DynamicQuery query = CapbanhanhLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
			query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			if(name != null) {
				Criterion tencapbanhanh = RestrictionsFactoryUtil.ilike("name",  "%" + name + "%");
				query.add(tencapbanhanh);
			}
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(end != 0){
				query.setLimit(start, end);
			}
			List<Capbanhanh> results = CapbanhanhLocalServiceUtil.dynamicQuery(query);
			return results;
	}
	
	public static List<Coquanbanhanh> countCoquanbanhanhByKeyword(RenderRequest renderRequest, String name, int status, int start, int end) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = CoquanbanhanhLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(name != null) {
			Criterion tencoquanbanhanh = RestrictionsFactoryUtil.ilike("name",  "%" + name + "%");
			query.add(tencoquanbanhanh);
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		List<Coquanbanhanh> results = CoquanbanhanhLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
	public static List<Loaivanban> countLoaivanbanByKeyword(RenderRequest renderRequest, String name, int status, int start, int end) throws Exception {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			DynamicQuery query = LoaivanbanLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
			query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			if(name != null) {
				Criterion tenloaivanban = RestrictionsFactoryUtil.ilike("name",  "%" + name + "%");
				query.add(tenloaivanban);
			}
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(end != 0){
				query.setLimit(start, end);
			}
			List<Loaivanban> results = LoaivanbanLocalServiceUtil.dynamicQuery(query);
			return results;
	}
	
	public static List<Linhvucvanban> countLinhvucByKeyword(RenderRequest renderRequest, String name, int status, int start, int end) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery query = LinhvucvanbanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(name != null) {
			Criterion tenlinhvuc = RestrictionsFactoryUtil.ilike("name",  "%" + name + "%");
			query.add(tenlinhvuc);
		}
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		List<Linhvucvanban> results = LinhvucvanbanLocalServiceUtil.dynamicQuery(query);
		return results;
	}

		public static List<Vanbanphapquy> countVanbanphapquy(RenderRequest renderRequest, String sohieu, String trichyeu, long linhvuc, long coquanbanhanh,
		long loaivanban, long capbanhanh, String nbh_tungay, String nbh_denngay, String nhl_tungay, String nhl_denngay, int status, int start, int end) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(sohieu != null) {
			Criterion sohieuvanban = RestrictionsFactoryUtil.ilike("sohieu",  "%" + sohieu + "%");
			query.add(sohieuvanban);
		}
		if(trichyeu != null) {
			Criterion trichyeuvanban = RestrictionsFactoryUtil.ilike("trichyeu",  "%" + trichyeu + "%");
			query.add(trichyeuvanban);
		}
		
		if(linhvuc != 0)
		{
			query.add(PropertyFactoryUtil.forName("id_linhvuc").eq(linhvuc));
		}
		
		if(coquanbanhanh != 0)
		{
			query.add(PropertyFactoryUtil.forName("id_coquanbanhanh").eq(coquanbanhanh));
		}
		if(loaivanban != 0)
		{
			query.add(PropertyFactoryUtil.forName("id_loaivanban").eq(loaivanban));
		}
		
		if(capbanhanh != 0)
		{
			query.add(PropertyFactoryUtil.forName("id_capbanhanh").eq(capbanhanh));
		}
		if(Validator.isNotNull(nbh_tungay) && !nbh_tungay.equals("")){
			nbh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngay_banhanh").ge(df.parse(nbh_tungay)));
		}
		if(Validator.isNotNull(nbh_denngay) && !nbh_denngay.equals("")){
			nbh_denngay +=  " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngay_banhanh").le(df.parse(nbh_denngay)));
		}
		
		if(Validator.isNotNull(nhl_tungay) && !nhl_tungay.equals("")){
			nhl_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngay_hieuluc").ge(df.parse(nhl_tungay)));
		}
		if(Validator.isNotNull(nhl_denngay) && !nhl_denngay.equals("")){
			nhl_denngay +=  " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngay_hieuluc").le(df.parse(nhl_denngay)));
		}
		
		if(status > -1)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0){
			query.setLimit(start, end);
		}
		query.addOrder(OrderFactoryUtil.desc("ngay_banhanh"));
		List<Vanbanphapquy> results = VanbanphapquyLocalServiceUtil.dynamicQuery(query);
		return results;
	}
	
		public static List<Vanbanphapquy> countVanbanphapquyUser(RenderRequest renderRequest, String type, String sohieu, String trichyeu, long linhvuc, long coquanbanhanh,
				long loaivanban, long capbanhanh, String nbh_tungay, String nbh_denngay, String nhl_tungay, String nhl_denngay, int status, int start, int end) throws Exception {
				
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
				query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				if(sohieu != null) {
					Criterion sohieuvanban = RestrictionsFactoryUtil.ilike("sohieu",  "%" + sohieu + "%");
					query.add(sohieuvanban);
				}
				if(trichyeu != null) {
					Criterion trichyeuvanban = RestrictionsFactoryUtil.ilike("trichyeu",  "%" + trichyeu + "%");
					query.add(trichyeuvanban);
				}
				
				if(type != null) {
					query.add(PropertyFactoryUtil.forName("type").eq(type));
				}
				
				if(linhvuc != 0)
				{
					query.add(PropertyFactoryUtil.forName("id_linhvuc").eq(linhvuc));
				}
				
				if(coquanbanhanh != 0)
				{
					query.add(PropertyFactoryUtil.forName("id_coquanbanhanh").eq(coquanbanhanh));
				}
				if(loaivanban != 0)
				{
					query.add(PropertyFactoryUtil.forName("id_loaivanban").eq(loaivanban));
				}
				
				if(capbanhanh != 0)
				{
					query.add(PropertyFactoryUtil.forName("id_capbanhanh").eq(capbanhanh));
				}
				if(Validator.isNotNull(nbh_tungay) && !nbh_tungay.equals("")){
					nbh_tungay += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("ngay_banhanh").ge(df.parse(nbh_tungay)));
				}
				if(Validator.isNotNull(nbh_denngay) && !nbh_denngay.equals("")){
					nbh_denngay +=  " 23:59:59";
					query.add(PropertyFactoryUtil.forName("ngay_banhanh").le(df.parse(nbh_denngay)));
				}
				
				if(Validator.isNotNull(nhl_tungay) && !nhl_tungay.equals("")){
					nhl_tungay += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("ngay_hieuluc").ge(df.parse(nhl_tungay)));
				}
				if(Validator.isNotNull(nhl_denngay) && !nhl_denngay.equals("")){
					nhl_denngay +=  " 23:59:59";
					query.add(PropertyFactoryUtil.forName("ngay_hieuluc").le(df.parse(nhl_denngay)));
				}
				
				if(status > -1)
				{
					query.add(PropertyFactoryUtil.forName("status").eq(status));
				}
				if(end != 0){
					query.setLimit(start, end);
				}
				query.addOrder(OrderFactoryUtil.desc("ngay_banhanh"));
				List<Vanbanphapquy> results = VanbanphapquyLocalServiceUtil.dynamicQuery(query);
				return results;
			}
		
		@SuppressWarnings("unchecked")
		public static List<Linhvucvanban> getLinhvucvanbanByStatus(RenderRequest renderRequest, int status) throws Exception {
			DynamicQuery query = LinhvucvanbanLocalServiceUtil.dynamicQuery();
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			List<Linhvucvanban> results = LinhvucvanbanLocalServiceUtil.dynamicQuery(query);
			return results;
		}
		
		@SuppressWarnings("unchecked")
		public static List<Capbanhanh> getCapbanhanhByStatus(RenderRequest renderRequest, int status) throws Exception {
			DynamicQuery query = CapbanhanhLocalServiceUtil.dynamicQuery();
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			List<Capbanhanh> results = CapbanhanhLocalServiceUtil.dynamicQuery(query);
			return results;
		}
		
		@SuppressWarnings("unchecked")
		public static List<Coquanbanhanh> getCoquanbanhanhByStatus(RenderRequest renderRequest, int status) throws Exception {
			DynamicQuery query = CoquanbanhanhLocalServiceUtil.dynamicQuery();
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			List<Coquanbanhanh> results = CoquanbanhanhLocalServiceUtil.dynamicQuery(query);
			return results;
		}
		
		@SuppressWarnings("unchecked")
		public static List<Loaivanban> getLoaivanbanByStatus(RenderRequest renderRequest, int status) throws Exception {
			DynamicQuery query = LoaivanbanLocalServiceUtil.dynamicQuery();
			if(status > -1)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			List<Loaivanban> results = LoaivanbanLocalServiceUtil.dynamicQuery(query);
			return results;
		}
		
		@SuppressWarnings("unchecked")
		public static List<Vanbanphapquy> getVBPQByIdCategory(String kieuvanban, long categoryId, String categoryName) throws Exception {
			DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
			if(!kieuvanban.equals("")){
				query.add(PropertyFactoryUtil.forName("type").eq(kieuvanban));
			}
			if (categoryName.equals("loaivanban")) {
				query.add(PropertyFactoryUtil.forName("id_loaivanban").eq(categoryId));
			}
			if (categoryName.equals("linhvucvanban")) {
				query.add(PropertyFactoryUtil.forName("id_linhvuc").eq(categoryId));
			}
			if (categoryName.equals("capbanhanh")) {
				query.add(PropertyFactoryUtil.forName("id_capbanhanh").eq(categoryId));
			}
			if (categoryName.equals("coquanbanhanh")) {
				query.add(PropertyFactoryUtil.forName("id_coquanbanhanh").eq(categoryId));
			}
			query.add(PropertyFactoryUtil.forName("status").eq(1));
			query.addOrder(OrderFactoryUtil.desc("ngay_banhanh"));
			List<Vanbanphapquy> results = VanbanphapquyLocalServiceUtil.dynamicQuery(query);
			return results;
		}
		
		public static List<Vanbanphapquy> getVanBanHome(RenderRequest renderRequest, int status, String limit_vb) throws Exception {
			DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("status").eq(1));
			if(!limit_vb.equals("0")){
				query.setLimit(0,Integer.valueOf(limit_vb));
			}
			query.addOrder(OrderFactoryUtil.desc("ngay_banhanh"));
			List<Vanbanphapquy> results = VanbanphapquyLocalServiceUtil.dynamicQuery(query);
			return results;
			
		}
		

}
