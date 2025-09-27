package vn.dnict.tintuc.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.RenderRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
//import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.model.News_NguonTin;
import vn.dnict.tintuc.model.News_Subcategories;
import vn.dnict.tintuc.model.News_Type;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_ActivityLocalServiceUtil;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;
import vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil;
import vn.dnict.tintuc.service.News_SubcategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_TypeLocalServiceUtil;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;

public class TinTucAdminUtil{
	
	public static List<News_Categories> countNews_Categories(RenderRequest renderRequest, String name, int start, int end){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery dynamicQuery = News_CategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		if(name != null) {
			Criterion categories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(categories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Categories> results = News_CategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		return results;

	}
	
	public static List<News_Subcategories> countNews_SubCategories(RenderRequest renderRequest, String name, int start, int end){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		DynamicQuery dynamicQuery = News_SubcategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Subcategories> results = News_SubcategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		return results;

	}
	
	public static List<News_Categories> getNews_CategoriesByIdSubCat(RenderRequest renderRequest, long idlibcat, String name, int start, int end){
		//ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		DynamicQuery dynamicQuery = News_CategoriesLocalServiceUtil.dynamicQuery();
		//dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		//dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(Validator.isNotNull(idlibcat)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("idlibcat").eq(idlibcat));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Categories> results = News_CategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println(results);
		return results;

	}
	
	
	public static List<News_Categories> getNews_CategoriesByIdSubCat(long idlibcat, String name, int start, int end){
		DynamicQuery dynamicQuery = News_CategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(Validator.isNotNull(idlibcat)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("idlibcat").eq(idlibcat));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Categories> results = News_CategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		return results;

	}
	
	public static List<News_Subcategories> getNews_SubcategoriesById(RenderRequest renderRequest, String language, long idlibcat){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);		
		DynamicQuery dynamicQuery = News_SubcategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(Validator.isNotNull(idlibcat)){
			dynamicQuery.add(PropertyFactoryUtil.forName("id").eq(idlibcat));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Subcategories> results = News_SubcategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		return results;
	}
	
	public static List<News_Categories> getNews_CategoriesByIdSubCatLang(RenderRequest renderRequest, String language, Long idlibcat, String name, int start, int end){
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		DynamicQuery dynamicQuery = News_CategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(Validator.isNotNull(idlibcat)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("idlibcat").eq(idlibcat));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Categories> results = News_CategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("List du lieu Cat "+results);
		return results;

	}
	
	public static List<News_Subcategories> getSubCatByLang(RenderRequest renderRequest, String language, String name, 
			int status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		DynamicQuery dynamicQuery = News_SubcategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(status==1 || status==0) {
			dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Subcategories> results = News_SubcategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return results;
		
	}
	
	public static List<News_Subcategories> getSubCatByLanguage(RenderRequest renderRequest, String language, String name, 
			int status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		DynamicQuery dynamicQuery = News_SubcategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(status==1 || status==0) {
			dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Subcategories> results = News_SubcategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return results;
		
	}
	
	public static List<News_Subcategories> getSubCatByLang(String name, 
			int status, int start, int end) throws Exception{
		DynamicQuery dynamicQuery = News_SubcategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(status==1 || status==0) {
			dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Subcategories> results = News_SubcategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("Lang"+results);
		return results;
		
	}
	
	public static List<News_Categories> getCatByLang(RenderRequest renderRequest, String language, String name, 
		long idlibcat, int status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		DynamicQuery dynamicQuery = News_CategoriesLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(name != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + name + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(status==1 || status==0) {
			dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		if(Validator.isNotNull(idlibcat)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("idlibcat").eq(idlibcat));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Categories> results = News_CategoriesLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println(results);
		return results;
		
	}
	
	public static List<News_Article2Category> getListArticle2CategoryByArticleId(long ArticleId) throws Exception{
		DynamicQuery dynamicQuery = News_Article2CategoryLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("newarticleId").eq(ArticleId));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("id"));
		List<News_Article2Category> listarcticle2category = News_Article2CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(listarcticle2category.size() < 0){
			listarcticle2category = new ArrayList<News_Article2Category>();
		}
		return listarcticle2category;
	}
	
	public static List<News_Article2Category> getListArticle2CategoryByArticleId(long[] categoriesId) throws Exception{
		DynamicQuery dynamicQuery = News_Article2CategoryLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("newcategoryId").in(categoriesId));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("id"));
		List<News_Article2Category> listarcticle2category = News_Article2CategoryLocalServiceUtil.dynamicQuery(dynamicQuery);
		if(listarcticle2category.size() < 0){
			listarcticle2category = new ArrayList<News_Article2Category>();
		}
		return listarcticle2category;
	}
	
	public static List<News_Article> getListNews_Articles(RenderRequest renderRequest, String language, String title,
			String category, String status, int start, int end) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);	
		DynamicQuery dynamicQuery = News_ArticleLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		dynamicQuery.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(title != null) {
			Criterion subcategories = RestrictionsFactoryUtil.ilike("title", StringPool.PERCENT + title + StringPool.PERCENT);
			dynamicQuery.add(subcategories);
		}
		if(end != 0) {
			dynamicQuery.setLimit(start, end);
		}
		if(!status.equals("") && Long.valueOf(status) >= 0){
			dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(!language.equals("")){
			dynamicQuery.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		
		if(Validator.isNotNull(category)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryid").eq(category))
					.setProjection(PropertyFactoryUtil.forName("newarticleid"))));
		}
		//System.out.println("Tin tuc 2:" + title + category + status);
		
		dynamicQuery.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		
		//dynamicQuery.addOrder(OrderFactoryUtil.asc("orders"));
		List<News_Article> results = News_ArticleLocalServiceUtil.dynamicQuery(dynamicQuery);
		
		return results;
	}
	
	
	
	public static List<News_Article> listTintuc(String[] listCategoryId, String checklang, int start, int end) throws Exception{
		long[] listcategory = new long[listCategoryId.length];
		
		for(int d =0;d<listCategoryId.length;d++){
			listcategory[d] = Long.valueOf(listCategoryId[d]);
		}
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(listcategory)) {
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryId").in(listcategory))
					.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!checklang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checklang));
		}
		/*
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		query.add(RestrictionsFactoryUtil.le("ngayxuatban", ngayhientaiGMT)); // publishDate <= hôm nay
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientaiGMT));
		*/
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		//System.out.println(listArticle.size());
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintuc(String title, String dinhdanh, String chuyenmuc, String checklang, int start, int end) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(title)) {
			query.add(PropertyFactoryUtil.forName("title").like("%"+title +"%"));
		}
		if(Validator.isNotNull(dinhdanh)) {
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryId").eq(Long.valueOf(chuyenmuc)))
					.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!checklang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checklang));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintuc(String title, String dinhdanh, String chuyenmuc, int start, int end) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(title)) {
			query.add(PropertyFactoryUtil.forName("title").like("%"+title +"%"));
		}
		if(Validator.isNotNull(dinhdanh)) {
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryId").eq(Long.valueOf(chuyenmuc)))
					.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	
	public static List<News_Article> listarticlbydate(Date date, int sotinlienquan, long[] categoriesId){
		Calendar cal = Calendar.getInstance();
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(categoriesId.length > 0) {
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryId").in(categoriesId))
					.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		if(Validator.isNotNull(date)) {
			cal.setTime(date);
			cal.add(Calendar.DATE, -60);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(cal.getTime()));
		}
		if(Validator.isNotNull(date)) {
			cal.setTime(date);
			cal.add(Calendar.DATE, +60);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(cal.getTime()));
		}
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(sotinlienquan >0) {
			query.setLimit(0, sotinlienquan);
		}
		List<News_Article> news =  News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(news) || news.size() <= 0) {
			news = new ArrayList<News_Article>();
		}
		return news;
	}
	
	public static List<News_Categories> searchNewCategory(String name,int status, Long idthuvien, int start,int end)
			throws Exception{
			DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
			if(Validator.isNotNull(name)){
				query.add(PropertyFactoryUtil.forName("name").eq(name));
			}
			if(status==1 || status==0)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(Validator.isNotNull(idthuvien) && idthuvien > 0){
				query.add(PropertyFactoryUtil.forName("idlibcat").eq(idthuvien));
			}
			if(end!=0)
			{
				query.setLimit(start, end);
			}
			query.addOrder(OrderFactoryUtil.asc("id"));
			List<News_Categories> listcategory = News_CategoriesLocalServiceUtil
				.dynamicQuery(query);
			return listcategory;
		}
	
	public static List<News_Categories> searchNewCategory(String name,int status, String checkLang, Long idthuvien, int start,int end)
			throws Exception{
			DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
			if(Validator.isNotNull(name)){
				query.add(PropertyFactoryUtil.forName("name").eq(name));
			}
			
			if(status==1 || status==0)
			{//System.out.println("ab "+status);
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(Validator.isNotNull(idthuvien) && idthuvien > 0){
				query.add(PropertyFactoryUtil.forName("idlibcat").eq(idthuvien));
			}
			if(!checkLang.equals("")){
				query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
			}
			if(end!=0)
			{
				query.setLimit(start, end);
			}
			query.addOrder(OrderFactoryUtil.asc("id"));
			List<News_Categories> listcategory = News_CategoriesLocalServiceUtil
				.dynamicQuery(query);
			return listcategory;
		}
	
	public static List<News_Categories> searchCategory(String name,int status, int start,int end)
			throws Exception{
			DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
			if(Validator.isNotNull(name)){
				query.add(PropertyFactoryUtil.forName("name").eq(name));
			}
			if(status==1 || status==0)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(end!=0)
			{
				query.setLimit(start, end);
			}
			query.addOrder(OrderFactoryUtil.asc("id"));
			List<News_Categories> listcategory = News_CategoriesLocalServiceUtil
				.dynamicQuery(query);
			return listcategory;
		}
	
	public static News_Categories getAllCat(int start,int end) {
		DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
		query.setLimit(start, end);
		List<News_Categories> result = News_CategoriesLocalServiceUtil.dynamicQuery(query);									
		return (News_Categories) result; 
		
	}
	
	public static List<News_Article> searchArticle(String search, String status,String checkLang, int start, int end) throws Exception {
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		status = HtmlUtil.escape(status);
		search = HtmlUtil.escape(search);
		checkLang = HtmlUtil.escape(checkLang);
		if(status.equals("0")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("title",
						StringPool.PERCENT + search + StringPool.PERCENT);
				creterion = RestrictionsFactoryUtil.or(
						creterion,
						RestrictionsFactoryUtil.ilike("content", StringPool.PERCENT
								+ search + StringPool.PERCENT));
				query.add(creterion);
			}
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(status.equals("1")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("title",
						StringPool.PERCENT + search + StringPool.PERCENT);
				query.add(creterion);
			}
		}
		if(status.equals("2")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("content",
						StringPool.PERCENT + search + StringPool.PERCENT);
				query.add(creterion);
			}
		}
		if(status.equals("3")){
			if(!search.equals("") && Long.valueOf(search) > 0){
				query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(search)));
			}
		}
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> searchArticleById(String search, String status,String checkLang, int start, int end) throws Exception {
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		status = HtmlUtil.escape(status);
		search = HtmlUtil.escape(search);
		checkLang = HtmlUtil.escape(checkLang);
		if(status.equals("0")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("title",
						StringPool.PERCENT + search + StringPool.PERCENT);
				creterion = RestrictionsFactoryUtil.or(
						creterion,
						RestrictionsFactoryUtil.ilike("content", StringPool.PERCENT
								+ search + StringPool.PERCENT));
				query.add(creterion);
			}
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(status.equals("1")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("title",
						StringPool.PERCENT + search + StringPool.PERCENT);
				query.add(creterion);
			}
		}
		if(status.equals("2")){
			if(!search.equals("")){
				Criterion creterion = RestrictionsFactoryUtil.ilike("content",
						StringPool.PERCENT + search + StringPool.PERCENT);
				query.add(creterion);
			}
		}
		if(status.equals("3")){
			if(!search.equals("") && Long.valueOf(search) > 0){
				query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(search)));
			}
		}
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static boolean checkCategoryOfUser (long userId, long articleId) throws Exception {
		boolean check = false;
		News_role role = null;
		DynamicQuery query = News_roleLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("userid").eq(userId));
		List<News_role> list = News_roleLocalServiceUtil.dynamicQuery(query);
		
		DynamicQuery queryArticle = News_Article2CategoryLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("newarticleId").eq(articleId))
				.setProjection(PropertyFactoryUtil.forName("newcategoryId"));
		List<Long> listArticleId = News_Article2CategoryLocalServiceUtil.dynamicQuery(queryArticle);
		if(list.size()>0 && listArticleId.size() >0){
			role = list.get(0);
			String stringCategory = role.getCategory_active_role() ;
			if(stringCategory.length() >0){
				stringCategory = stringCategory.substring(1);
				String[] arrCategory = stringCategory.split("_");
				for(int i = 0; i < arrCategory.length; i++){
					for(int j=0; j <listArticleId.size();j++){
						if(arrCategory[i].equals(String.valueOf(listArticleId.get(j)))){
							check = true;
						}
						
					}
				}
			}
		}
		return check;
	}
	

	public static News_Log requestobjLog(News_Article objArticle) {		
		long id = CounterLocalServiceUtil.increment(News_LogLocalServiceUtil.class.getName());
		News_Log objLog = News_LogLocalServiceUtil.createNews_Log(id);
		objLog.setId(id);
		objLog.setCompanyId(objArticle.getCompanyId());
		objLog.setGroupId(objArticle.getGroupId());
		objLog.setIdnewactivity(objArticle.getId());
		objLog.setTitle(objArticle.getTitle());
		objLog.setInfo(objArticle.getInfo());
		objLog.setContent(objArticle.getContent());
		objLog.setCreatedby(objArticle.getCreatedby());
		objLog.setModifiedby(objArticle.getModifiedby());
		objLog.setCreatedtime(objArticle.getCreatedtime());
		objLog.setStatus(objArticle.getStatus());
		objLog.setLanguage(objArticle.getLanguage());
		objLog.setVersion(objArticle.getVersion());
		objLog.setUrlimagesmall(objArticle.getUrlimagesmall());
		objLog.setIsnoibat(objArticle.getIsnoibat());
		objLog.setLuotxem(objArticle.getLuotxem());
		objLog.setArticleid(objArticle.getId());
		objLog.setNguontin(objArticle.getNguontin());
		objLog.setModifiedtime(objArticle.getModifiedtime());
		objLog.setNgayxuly(new Date());
		return objLog;
	}
	
	public static boolean checkYeuCauHieuChinhByUserIdAnd (long userId, long articleId) throws Exception {
		boolean check = false;
		DynamicQuery query = News_ActivityLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("articleid").eq(articleId))
				.add(PropertyFactoryUtil.forName("enduserid").eq(userId));		
		List<News_Activity> list = News_ActivityLocalServiceUtil.dynamicQuery(query);
		if(list.size()>0){
			check = true;
		}else {
			check = false;
		}
		return check; 
	}
	
	public static List<News_Activity> listNewAtivityByArticleId (long articleId) throws Exception {
		DynamicQuery query = News_ActivityLocalServiceUtil.dynamicQuery();
		if(articleId > 0){
				query.add(PropertyFactoryUtil.forName("articleid").eq(articleId));
		}
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<News_Activity> list = News_ActivityLocalServiceUtil.dynamicQuery(query);
		return list; 
	}
	
	public static News_Activity getNewAtivityById (long userId, long articleId) throws Exception {
		News_Activity object = null;
		DynamicQuery query = News_ActivityLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("articleid").eq(articleId))
				.add(PropertyFactoryUtil.forName("enduserid").eq(userId));
		
		List<News_Activity> list = News_ActivityLocalServiceUtil.dynamicQuery(query);
		if(list.size()>0){
			object = list.get(0);
		}
		return object; 
	}
	
	public static List<News_Log> getNewLogByArticleId (long articleid) throws Exception {
		DynamicQuery query = News_LogLocalServiceUtil.dynamicQuery()
				.add(PropertyFactoryUtil.forName("articleid").eq(articleid))
				.addOrder(OrderFactoryUtil.asc("id"));
		List<News_Log> list = News_LogLocalServiceUtil.dynamicQuery(query);
		return list;
	}
	
	public static List<News_Article> listTintucAdmin(String checkLang, String usdangbaicheck, String tieude, String dinhdanh, String chuyenmuc, String trangthai, String theloaibaiviet, String tacgia, String userdangbai, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, int start, int end) throws Exception{
				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tieude.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("title", 
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			//System.out.println("cm " + chuyenmuc);
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(!theloaibaiviet.equals("") && Integer.valueOf(theloaibaiviet) >= 0){
			query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloaibaiviet)));
		}
		if(!tacgia.equals("") && Integer.valueOf(tacgia) > 0){
			query.add(PropertyFactoryUtil.forName("nguontin").eq(Long.valueOf(tacgia)));
		}
		if(Validator.isNull(usdangbaicheck) || usdangbaicheck.equals("") ||  usdangbaicheck.equals("0")){
			if(!userdangbai.equals("") && Long.valueOf(userdangbai) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userdangbai)));
			}
		}
		if(Validator.isNotNull(usdangbaicheck) &&  Long.valueOf(usdangbaicheck) >= 0){
			query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(usdangbaicheck)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			//System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("modifiedtime").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("modifiedtime").le(df.parse(ngayhieuchinh_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		int[] listloaitintuc = {0,1,2,3};
		query.add(PropertyFactoryUtil.forName("loaitintuc").in(listloaitintuc));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintucAdminDaXoa(String checkLang, String usdangbaicheck, String tieude, String dinhdanh, String chuyenmuc, String trangthai, String theloaibaiviet, String tacgia, String userdangbai, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, int start, int end) throws Exception{
				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tieude.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("title", 
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			//System.out.println("cm " + chuyenmuc);
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(!theloaibaiviet.equals("") && Integer.valueOf(theloaibaiviet) >= 0){
			query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloaibaiviet)));
		}
		if(!tacgia.equals("") && Integer.valueOf(tacgia) > 0){
			query.add(PropertyFactoryUtil.forName("nguontin").eq(Long.valueOf(tacgia)));
		}
		if(Validator.isNull(usdangbaicheck) || usdangbaicheck.equals("") ||  usdangbaicheck.equals("0")){
			if(!userdangbai.equals("") && Long.valueOf(userdangbai) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userdangbai)));
			}
		}
		if(Validator.isNotNull(usdangbaicheck) &&  Long.valueOf(usdangbaicheck) >= 0){
			query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(usdangbaicheck)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			//System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("modifiedtime").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("modifiedtime").le(df.parse(ngayhieuchinh_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(1));
		int[] listloaitintuc = {0,1,2,3};
		query.add(PropertyFactoryUtil.forName("loaitintuc").in(listloaitintuc));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintucAdminTK(String tieude, String dinhdanh, String chuyenmuc, String trangthai, String ngaytao_tungay, String ngaytao_denngay, int start, int end) throws Exception{
				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tieude.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("title", 
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			//System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintucAdminTKLuotXem(String ngaytao_tungay, String ngaytao_denngay, int start, int end) throws Exception{
		
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
				
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("luotxem"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintucAdminTKDate(String tieude, String dinhdanh, String chuyenmuc, String trangthai, String ngaytao, int start, int end) throws Exception{
		
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		//DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		if(!tieude.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("title", 
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		
		if(Validator.isNotNull(ngaytao) && !ngaytao.equals("")){			
			//System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").eq(ngaytao));
		}		
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listSachAdmin(String checkLang, String usdangbaicheck, String tieude, String dinhdanh, String chuyenmuc, String trangthai, String theloaibaiviet, String userdangbai, 
			String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, int start, int end) throws Exception{
				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!tieude.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("title", 
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			//System.out.println(chuyenmuc);
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(!theloaibaiviet.equals("") && Integer.valueOf(theloaibaiviet) >= 0){
			query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloaibaiviet)));
		}
		if(Validator.isNull(usdangbaicheck) || usdangbaicheck.equals("") ||  usdangbaicheck.equals("0")){
			if(!userdangbai.equals("") && Long.valueOf(userdangbai) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userdangbai)));
			}
		}
		if(Validator.isNotNull(usdangbaicheck) &&  Long.valueOf(usdangbaicheck) >= 0){
			query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(usdangbaicheck)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			//System.out.println(ngaytao_tungay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			//System.out.println(ngaytao_denngay);
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			ngayhieuchinh_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("modifiedtime").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			ngayhieuchinh_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("modifiedtime").le(df.parse(ngayhieuchinh_denngay)));
		}		
		
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		int[] listloaitintuc = {4,5,6,7};
		query.add(PropertyFactoryUtil.forName("loaitintuc").in(listloaitintuc));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(end!=0){
			query.setLimit(start, end);
		}
		
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static long listTintucAdminCount(String checkLang, String usdangbaicheck, String tieude, String dinhdanh, String chuyenmuc, 
			String trangthai, String theloaibaiviet, String userdangbai, String ngaytao_tungay, String ngaytao_denngay, String ngayhieuchinh_tungay, String ngayhieuchinh_denngay, int start, int end) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(!tieude.equals("")){
			Criterion creterion = RestrictionsFactoryUtil.ilike("title",
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(creterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
			.add(PropertyFactoryUtil.forName("newarticleId").eq(Long.valueOf(chuyenmuc)))
			.setProjection(PropertyFactoryUtil.forName("newcategoryId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(!theloaibaiviet.equals("") && Integer.valueOf(theloaibaiviet) >= 0){
			query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloaibaiviet)));
		}
		if(Validator.isNull(usdangbaicheck) || usdangbaicheck.equals("") ||  usdangbaicheck.equals("0")){
			if(!userdangbai.equals("") && Long.valueOf(userdangbai) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userdangbai)));
			}
		}
		if(Validator.isNotNull(usdangbaicheck) &&  Long.valueOf(usdangbaicheck) >= 0){
			query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(usdangbaicheck)));
		}
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_tungay) && !ngayhieuchinh_tungay.equals("")){
			query.add(PropertyFactoryUtil.forName("modifiedtime").ge(df.parse(ngayhieuchinh_tungay)));
		}
		if(Validator.isNotNull(ngayhieuchinh_denngay) && !ngayhieuchinh_denngay.equals("")){
			query.add(PropertyFactoryUtil.forName("modifiedtime").le(df.parse(ngayhieuchinh_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		long size = News_ArticleLocalServiceUtil.dynamicQueryCount(query);
		return size;
	}
	
public static List<News_Article> listTintucKieuTin(String ngaytao_tungay, String ngaytao_denngay, String status, int loaitintuc) throws Exception{
		
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");	
				
		if(Validator.isNotNull(ngaytao_tungay) && !ngaytao_tungay.equals("")){
			ngaytao_tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(ngaytao_tungay)));
		}
		if(Validator.isNotNull(ngaytao_denngay) && !ngaytao_denngay.equals("")){
			ngaytao_denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(ngaytao_denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(!status.equals("") && Long.valueOf(status) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}
		if(Integer.valueOf(loaitintuc) >= 0){
			query.add(PropertyFactoryUtil.forName("loaitintuc").eq(Integer.valueOf(loaitintuc)));
		}
				
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Type> listTheLoai(String theloai, int status, int start, int end) {
		DynamicQuery query = News_TypeLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(!theloai.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + theloai + StringPool.PERCENT);
			query.add(criterion);
		}
		if(status==1 || status==0)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0) {
			query.setLimit(start, end);
		}
		List<News_Type>  objType = News_TypeLocalServiceUtil.dynamicQuery(query);
		return objType;
			
	}
	
	public static List<News_NguonTin> listTacGia(String tacgia, int status, int start, int end) {
		DynamicQuery query = News_NguonTinLocalServiceUtil.dynamicQuery();		
		//query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		if(!tacgia.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("name", StringPool.PERCENT + tacgia + StringPool.PERCENT);
			query.add(criterion);
		}
		if(status==0)
		{
			query.add(PropertyFactoryUtil.forName("status").eq(status));
		}
		if(end != 0) {
			query.setLimit(start, end);
		}
		List<News_NguonTin>  objNguonTin = News_NguonTinLocalServiceUtil.dynamicQuery(query);
		return objNguonTin;
			
	}
	
	public static List<News_Categories> getAllCate(){
		DynamicQuery query = News_CategoriesLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		List<News_Categories> obj = News_CategoriesLocalServiceUtil.dynamicQuery(query);
		return obj;
		
	}
	
	@SuppressWarnings("null")
	public static News_Article getTintucfromRequest(UploadPortletRequest request, long id) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		News_Article objects = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		//System.out.println(ParamUtil.getString(request, "contents"));
		if(Validator.isNotNull(ParamUtil.getString(request, "title"))){
			objects.setTitle(ParamUtil.getString(request, "title"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "mota"))){
			objects.setInfo(ParamUtil.getString(request, "mota"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "contents"))){
			objects.setContent(ParamUtil.getString(request, "contents"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "theloai"))){
			objects.setTypeid(ParamUtil.getLong(request, "theloai"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "languages"))){
			objects.setLanguage(ParamUtil.getString(request, "languages"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "urlsmallimage")) && !ParamUtil.getString(request, "urlsmallimage").equals("")){
			objects.setUrlimagesmall(ParamUtil.getString(request, "urlsmallimage"));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(request, "contents"))){
				String data = ParamUtil.getString(request, "contents");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					objects.setUrlimagesmall(urlimage);
				}
			}
		}
		
		if(Validator.isNotNull(ParamUtil.getString(request, "isnoibat"))){
			objects.setIsnoibat(1);		
		}else{
			objects.setIsnoibat(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "ishethan"))){
			objects.setIshethang(1);
			if(Validator.isNotNull(ParamUtil.getString(request, "ngayhethan"))){
				
				String ngayhethan = ParamUtil.getString(request, "ngayhethan")+" 00:00:00";
				objects.setNgayketthuc(df.parse(ngayhethan));
				
			}
		}else{
			objects.setIshethang(0);
		}
		
		if(Validator.isNotNull(ParamUtil.getString(request, "nguontin"))){
			objects.setNguontin(ParamUtil.getLong(request, "nguontin"));
		}
		if(Validator.isNotNull(ParamUtil.getString(request, "lichxuatban"))){
			String datetime = ParamUtil.getString(request, "lichxuatban");
			if(Validator.isNotNull(ParamUtil.getString(request, "gio_xuatban"))){
				datetime = ParamUtil.getString(request, "lichxuatban")+" "+ParamUtil.getString(request, "gio_xuatban")+":00";
			}else{
				datetime = ParamUtil.getString(request, "lichxuatban")+" 00:00:00";
			}
			objects.setCreatedtime(df.parse(datetime));
		}else{
			objects.setCreatedtime(new Date());
		}
		
		objects.setModifiedtime(new Date());
		//System.out.println("Nội dung: " + objects);
		return objects;
	}
	
	public static List<News_Type> getAllType(String language, int status, int del_status){
		DynamicQuery query = News_TypeLocalServiceUtil.dynamicQuery();
		if(language != null) {
			query.add(PropertyFactoryUtil.forName("language").eq(language));
		}
		query.add(PropertyFactoryUtil.forName("status").eq(0));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		List<News_Type> objType = News_TypeLocalServiceUtil.dynamicQuery(query);
		return objType;
	}
	
	public static List<News_Type> listAllType(String name, int status,int del_status){
		DynamicQuery query = News_TypeLocalServiceUtil.dynamicQuery();
		if(name != null) {
			query.add(PropertyFactoryUtil.forName("name").eq(name));
		}
		query.add(PropertyFactoryUtil.forName("status").eq(0));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		List<News_Type> listType = News_TypeLocalServiceUtil.dynamicQuery(query);
		return listType;
	}
	
	//search new type
	public static List<News_Type> searchNew_type(String name,int status,int start,int end)
			throws Exception{
			DynamicQuery query = News_TypeLocalServiceUtil.dynamicQuery();
			query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
			if(Validator.isNotNull(name)){
				query.add(PropertyFactoryUtil.forName("name").eq(name));
			}
			if(status==1 || status==0)
			{
				query.add(PropertyFactoryUtil.forName("status").eq(status));
			}
			if(end!=0)
			{
				query.setLimit(start, end);
			}
			query.addOrder(OrderFactoryUtil.desc("id"));
			@SuppressWarnings("unchecked")
			List<News_Type> listtype = News_TypeLocalServiceUtil.dynamicQuery(query);
			return listtype;
		}
	
//	listTintucByChuyenmuc
	public static long listTintucByChuyenmuc(long chuyenmuc, String trangthai, String dateBegin, String dateEnd, int start, int end) throws Exception{
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		//System.out.println("chuyenmuc: " + chuyenmuc);
		if(chuyenmuc > 0){
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(chuyenmuc))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}else{
			query.add(PropertyFactoryUtil.forName("status").eq(3));
		}
		if(!dateBegin.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(dateBegin)));
		}
		if(!dateEnd.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(dateEnd)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("id"));
		if(end!=0){
			query.setLimit(start, end);
		}
		long listArticle = News_ArticleLocalServiceUtil.dynamicQueryCount(query);//System.out.println("anc11:" + listArticle);
		return listArticle;
	}
	//list news by date and type
	public static long listNewByDateCreateAndType(long theloaibaiviet, long userdangbai, String tungay, String denngay, int start, int end) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		query.add(PropertyFactoryUtil.forName("typeid").eq(theloaibaiviet));
		if(userdangbai > 0){
			query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userdangbai)));
		}
		if(Validator.isNotNull(tungay) && !tungay.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").ge(df.parse(tungay)));
		}
		if(Validator.isNotNull(denngay) && !denngay.equals("")){
			query.add(PropertyFactoryUtil.forName("ngayxuatban").le(df.parse(denngay)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		long size = News_ArticleLocalServiceUtil.dynamicQueryCount(query);
		return size;
	}	
	
	//	lọc các tin tức isnoibat
	public static List<News_Article> listTintucisNoibat(String lang, int limit) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		/*
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		query.add(RestrictionsFactoryUtil.le("ngayxuatban", ngayhientaiGMT)); // publishDate <= hôm nay
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientaiGMT));
		*/
		query.add(PropertyFactoryUtil.forName("isnoibat").eq(Long.valueOf(1)));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("language").eq(lang));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		if(limit > 0){
			query.setLimit(0, limit);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_Article> listTintucisNoibatby5(String chuyenmuc, int limit) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			query.add(PropertyFactoryUtil.forName("id").in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
					.add(PropertyFactoryUtil.forName("newcategoryId").eq(Long.valueOf(chuyenmuc)))
					.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		/*
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		query.add(RestrictionsFactoryUtil.le("ngayxuatban", ngayhientaiGMT)); // publishDate <= hôm nay
		query.add(RestrictionsFactoryUtil.ge("ngayketthuc", ngayhientaiGMT));
		*/
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.addOrder(OrderFactoryUtil.desc("ngayxuatban"));
		query.addOrder(OrderFactoryUtil.desc("luotxem"));
		if(limit > 0){
			query.setLimit(0, limit);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static List<News_BinhLuan> listBinhLuans(String dinhdanh, String hoten, String tungay, String denngay, String noidung, int status, int start, int end) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DynamicQuery query = News_BinhLuanLocalServiceUtil.dynamicQuery();		
		if(!hoten.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("hoten", 
					StringPool.PERCENT + hoten + StringPool.PERCENT);
			query.add(criterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("newarticleId").eq(Long.valueOf(dinhdanh)));
		}
		if(Validator.isNotNull(tungay) && !tungay.equals("")){
			tungay += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("ngayBinhLuan").ge(df.parse(tungay)));
		}
		if(Validator.isNotNull(denngay) && !denngay.equals("")){
			denngay += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("ngayBinhLuan").le(df.parse(denngay)));
		}
		if(!noidung.equals("")) {
			Criterion criterion = RestrictionsFactoryUtil.ilike("noiDung", 
					StringPool.PERCENT + noidung + StringPool.PERCENT);
			query.add(criterion);
		}
		if(Long.valueOf(status) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
		}		
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("id"));	
		if(end!=0)
		{
			query.setLimit(start, end);
		}
		List<News_BinhLuan> listObjBinhLuan = News_BinhLuanLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listObjBinhLuan) || listObjBinhLuan.size() <= 0){
			listObjBinhLuan = new ArrayList<News_BinhLuan>();
		}
		return listObjBinhLuan;		
	}
	
}