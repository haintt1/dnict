package vn.dnict.tintuc.portlet;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.model.News_NguonTin;
import vn.dnict.tintuc.model.News_Subcategories;
import vn.dnict.tintuc.model.News_Type;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_ActivityLocalServiceUtil;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_AttachFileLocalServiceUtil;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;
import vn.dnict.tintuc.service.News_NguonTinLocalServiceUtil;
import vn.dnict.tintuc.service.News_SubcategoriesLocalServiceUtil;
import vn.dnict.tintuc.service.News_TypeLocalServiceUtil;
import vn.dnict.tintuc.utils.DocumentUpload;
import vn.dnict.tintuc.utils.PhanQuyenAdminUtil;
import vn.dnict.tintuc.utils.TinTucAdminUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.icon=/images/",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Tin tức",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/tintucadmin/view.jsp",
		"javax.portlet.name=" + TinTucAdminPortletKeys.TINTUCADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TinTucAdminPortlet extends MVCPortlet {
	
	//private String addSubCat = "/html/tintucadmin/subcategories/add.jsp";
	//private String addCat = "/html/tintucadmin/categories/add.jsp";

	
	@SuppressWarnings("deprecation")
	public void addSubCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		//actionResponse.setRenderParameter("jspPage", addSubCat);
		SessionMessages.add(actionRequest, "");
	}
	
	@SuppressWarnings("deprecation")
	public void addCategory(ActionRequest actionRequest, ActionResponse actionResponse) {
		//actionResponse.setRenderParameter("jspPage", addCat);
		SessionMessages.add(actionRequest, "");
	}
	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveSubCategory")
	public void saveSubCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		long id = CounterLocalServiceUtil.increment(News_Subcategories.class.getName());
		String lang = actionRequest.getParameter("languages");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_Subcategories subCat = News_SubcategoriesLocalServiceUtil.createNews_Subcategories(id);
		subCat.setId(id);
		subCat.setCompanyId(themeDisplay.getCompanyId());
		subCat.setGroupId(themeDisplay.getScopeGroupId());
		subCat.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		subCat.setLanguage(lang);
		subCat.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0 );
		subCat.setOrders(ParamUtil.getInteger(actionRequest, "orders"));
		subCat.setDelete_status(0);
		News_SubcategoriesLocalServiceUtil.addNews_Subcategories(subCat);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabChuyenMuc);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	

	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveCategory")
	public void saveCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = CounterLocalServiceUtil.increment(News_CategoriesLocalServiceUtil.class.getName());
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		String lang = actionRequest.getParameter("languages");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_Categories cat = News_CategoriesLocalServiceUtil.createNews_Categories(id);
		cat.setId(id);
		cat.setCompanyId(themeDisplay.getCompanyId());
		cat.setGroupId(themeDisplay.getScopeGroupId());
		cat.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "name")));
		cat.setLanguage(lang);
		cat.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0 );
		cat.setOrders(ParamUtil.getInteger(actionRequest, "orders"));
		cat.setIdlibcat(ParamUtil.getLong(actionRequest, "thuvien"));
		cat.setDelete_status(0);
		News_CategoriesLocalServiceUtil.addNews_Categories(cat);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabChuyenMuc);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "LangCheckCategory")
	public void langCheckSubCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletPreferences prefs = actionRequest.getPreferences();
		String checkLangSubCat = ParamUtil.getString(actionRequest, "checklangcategory","vi_VN");
		String userId = ParamUtil.getString(actionRequest, "userId");
		String key = userId+"_checklangcategory";
		prefs.setValue(key, checkLangSubCat);
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabChuyenMuc);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "langCheckNews")
	public void langCheckNews(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletPreferences prefs = actionRequest.getPreferences();
		String checkLangNews = ParamUtil.getString(actionRequest, "checklangnews","vi_VN");
		
		String userId = ParamUtil.getString(actionRequest, "userId");
		String key = userId+"_checklangnews";
		prefs.setValue(key, checkLangNews);
		prefs.store();
		SessionMessages.add(actionRequest,"save-successfully");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDangTin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveNewsArticle")
	public void saveNewsArticle(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangtin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(actionRequest, "id", 0);
	    // Nếu có ID thì lấy từ DB, nếu không thì tạo mới
		News_Article article = (id > 0) ? News_ArticleLocalServiceUtil.fetchNews_Article(id)
	                             : News_ArticleLocalServiceUtil.createNews_Article(CounterLocalServiceUtil.increment(News_ArticleLocalServiceUtil.class.getName()));
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String lang = actionRequest.getParameter("languages");
		long theloaibaiviet = ParamUtil.getLong(actionRequest, "theloai");
		long tacgia = ParamUtil.getLong(actionRequest, "tacgia");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		article.setCompanyId(themeDisplay.getCompanyId());
		article.setGroupId(themeDisplay.getScopeGroupId());
		if(Validator.isNotNull(theloaibaiviet)) {
			article.setTypeid(Long.valueOf(theloaibaiviet));
		}
		article.setTitle(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
		article.setInfo(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tomtat")));
		article.setContent(ParamUtil.getString(actionRequest, "noiDung"));
		article.setCreatedby(themeDisplay.getUserId());
		
		// format theo múi giờ Việt Nam
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		article.setCreatedtime(ngayhientaiGMT);
		
		// status
		if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
			article.setStatus(1);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(1);
			objLog.setNoidungxuly("Gửi biên tập viên");			
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
			article.setStatus(2);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(2);
			objLog.setNoidungxuly("Lưu và trình phê duyệt");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
			article.setStatus(3);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(3);
			objLog.setNoidungxuly("Xuất bản");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else {
			article.setStatus(0);
		}
		article.setLanguage(lang);
		article.setVersion(1);
		article.setDelete_status(0);
		if(Validator.isNotNull(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage"))) && !ParamUtil.getString(uploadPortletRequest, "urlsmallimage").equals("")){
			article.setUrlimagesmall(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage")));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "contents"))){
				String data = ParamUtil.getString(actionRequest, "contents");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					article.setUrlimagesmall(urlimage);
				}
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isnoibat"))) {
			article.setIsnoibat(1);
		}else {
			article.setIsnoibat(0);
		}
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setNgayxuatban(df.parse(ngayxuatban));			
		}else {
			article.setNgayxuatban(ngayhientaiGMT);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";			
			article.setNgayketthuc(df.parse(ngayketthuc));			
		}
		if(Validator.isNotNull(tacgia)) {
			article.setNguontin(Long.valueOf(tacgia));
		}
		article.setCongtacvien(HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien")));
		article.setLoaitintuc(0);
		article.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
		article.setSotinanh(ParamUtil.getInteger(actionRequest, "soluonganh"));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
			article.setIsformbinhluan(1);
		}else {
			article.setIsformbinhluan(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
			article.setIsviewbinhluan(1);
		}else {
			article.setIsviewbinhluan(0);
		}
		
		// Lưu danh mục
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(article.getId());
		
		if(listarticle2Category.size() > 0) {
			for (int del = 0; del < listarticle2Category.size(); del++) {
				News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
			}
		}
		
		String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
		String[] category_id = null;
		if(!data_category.equals("")){
			category_id = data_category.substring(1).split("_");
		}
		
		if(category_id != null && category_id.length > 0){
			for(int b = 0; b<category_id.length; b++){
				News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
				article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
				article2category.setNewarticleId(article.getId());
				article2category.setNewcategoryId(Long.valueOf(category_id[b]));
				article2category.setCompanyId(themeDisplay.getCompanyId());
				article2category.setGroupId(themeDisplay.getScopeGroupId());
				News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
			}
		}
		
		// Xử lý xem trước
		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || "xuatban".equals(typeaction) ) {
			article.setContent(ParamUtil.getString(actionRequest, "contents"));
			if (id > 0) {
				News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
	    } else {
	    	if (id > 0) {
	    		News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", article.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
		
		actionRequest.setAttribute("tintucobject", article);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);		
		redirectURL.setParameter("tabs", tabDangtin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void cauhinhDanhmuc(ActionRequest request, ActionResponse response) throws Exception {
		PortletPreferences prefs = request.getPreferences();
		String chondanhmuc = ParamUtil.getBoolean(request,"chondanhmuc")==true?"checked":"";
		prefs.setValue("chondanhmuc", chondanhmuc);
		prefs.store();
		SessionMessages.add(request,"save-successfully");
		response.setRenderParameter("tabs", "Cấu hình danh mục");
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveNewsArticlePDF")
	public void saveNewsArticlePDF(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangtin = TinTucAdminField.value_tabdangtin;
		
		long id = ParamUtil.getLong(actionRequest, "id", 0);
	    
	    // Nếu có ID thì lấy từ DB, nếu không thì tạo mới
		News_Article article = (id > 0) ? News_ArticleLocalServiceUtil.fetchNews_Article(id)
	                             : News_ArticleLocalServiceUtil.createNews_Article(CounterLocalServiceUtil.increment(News_ArticleLocalServiceUtil.class.getName()));
		

		String lang = actionRequest.getParameter("languages");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		User user = themeDisplay.getUser();
		long userid = user.getUserId();

		article.setCompanyId(themeDisplay.getCompanyId());
		article.setGroupId(themeDisplay.getScopeGroupId());
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		article.setTitle(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
		article.setInfo(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tomtat")));
		
		String noidung = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "filePDF");
		
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung1");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents1");
			noidung = noidung + "</div>";
		}
		
		// Xóa file khi xem chế độ xem trước nhiều lần
		List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(article.getId(), 9, themeDisplay);
		for(News_AttachFile ldk : listDinhkem) {
			News_AttachFileLocalServiceUtil.deleteNews_AttachFile(ldk.getId());
			DocumentUpload.deleteFile(themeDisplay, ldk.getTen());
		}
		
		if(fileNamedinhkem.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileNamedinhkem.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileNamedinhkem.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String urlPDF = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				urlPDF = filedinhkem.getUrl();
			}
			noidung = noidung + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdfjs-3.8.162-dist/web/viewer.html?file="+urlPDF+"\" style=\"width:700px; height:850px;\"></embed></p>";
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "pdfcheck")) && !ParamUtil.getString(uploadPortletRequest, "pdfcheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "pdfcheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "pdfcheck"));
			String urlPDF = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				urlPDF = dk.getUrl();
			}
			noidung = noidung + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdfjs-3.8.162-dist/web/viewer.html?file="+urlPDF+"\" style=\"width:100%; height:1000px;\"></embed></p>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung2");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents2");
			noidung = noidung + "</div>";
		}
		article.setContent(noidung);
		article.setCreatedby(userid);
		
		// format date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		article.setCreatedtime(ngayhientaiGMT);
			
		if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
			article.setStatus(3);
		}else {
			article.setStatus(0);
		}
		article.setLanguage(lang);
		article.setVersion(1);
		article.setDelete_status(0);
		if(Validator.isNotNull(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage"))) && !ParamUtil.getString(actionRequest, "urlsmallimage").equals("")){
			article.setUrlimagesmall(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage")));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "noidung"))){
				String data = ParamUtil.getString(actionRequest, "noidung");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					article.setUrlimagesmall(urlimage);
				}
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isnoibat"))) {
			article.setIsnoibat(1);
		}else {
			article.setIsnoibat(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setNgayxuatban(df.parse(ngayxuatban));
		}else {
			article.setNgayxuatban(ngayhientaiGMT);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";
			article.setNgayketthuc(df.parse(ngayketthuc));
		}
		
		article.setNguontin(ParamUtil.getLong(actionRequest, "tacgia"));
		article.setCongtacvien(HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien")));
		article.setLoaitintuc(1);
		article.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
			article.setIsformbinhluan(1);
		}else {
			article.setIsformbinhluan(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
			article.setIsviewbinhluan(1);
		}else {
			article.setIsviewbinhluan(0);
		}
		
		if(ParamUtil.getString(uploadPortletRequest, "typeaction").equals("guibientapvien")){
			article.setStatus(1); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(1);
			objLog.setNoidungxuly("Gửi biên tập viên");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(uploadPortletRequest, "typeaction").equals("luuvatrinhpheduyet")) {
			article.setStatus(2); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(2);
			objLog.setNoidungxuly("Lưu và trình phê duyệt");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}
		
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(article.getId());
		
		if(listarticle2Category.size() > 0) {
			for (int del = 0; del < listarticle2Category.size(); del++) {
				News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
			}
		}
				
		String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
		String[] category_id = null;
		if(!data_category.equals("")){
			category_id = data_category.substring(1).split("_");
		}
		
		if(category_id != null && category_id.length > 0){
			for(int b = 0; b<category_id.length; b++){
					News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
					article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
					article2category.setNewarticleId(article.getId());
					article2category.setNewcategoryId(Long.valueOf(category_id[b]));
					article2category.setCompanyId(themeDisplay.getCompanyId());
					article2category.setGroupId(themeDisplay.getScopeGroupId());
					News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
			}
		}
		
		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || "xuatban".equals(typeaction)) {
			if (id > 0) {
				News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
	    } else {
	    	if (id > 0) {
	    		News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", article.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
				
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", tabDangtin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	// thêm video
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveNewsArticleVideo")
	public void saveNewsArticleVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangtin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(actionRequest, "id", 0);
		
		// Nếu có ID thì lấy từ DB, nếu không thì tạo mới
		News_Article article = (id > 0) ? News_ArticleLocalServiceUtil.fetchNews_Article(id)
	                             : News_ArticleLocalServiceUtil.createNews_Article(CounterLocalServiceUtil.increment(News_ArticleLocalServiceUtil.class.getName()));

		String lang = actionRequest.getParameter("languages");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		User user = themeDisplay.getUser();
		long userid = user.getUserId();

		article.setCompanyId(themeDisplay.getCompanyId());
		article.setGroupId(themeDisplay.getScopeGroupId());
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		article.setTitle(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
		article.setInfo(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tomtat")));
		
		String noidung = "";
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung1");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents1");
			noidung = noidung + "</div>";
		}

		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung2");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents2");
			noidung = noidung + "</div>";
		}
		article.setContent(noidung);
		article.setCreatedby(userid);
		// format date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		article.setCreatedtime(ngayhientaiGMT);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
			article.setStatus(3);
		}else {
			article.setStatus(0);
		}
		article.setLanguage(lang);
		article.setVersion(1);
		article.setDelete_status(0);
		if(Validator.isNotNull(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage"))) && !ParamUtil.getString(actionRequest, "urlsmallimage").equals("")){
			article.setUrlimagesmall(HtmlUtil.escape(ParamUtil.getString(actionRequest, "urlsmallimage")));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "noidung"))){
				String data = ParamUtil.getString(actionRequest, "noidung");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					article.setUrlimagesmall(urlimage);
				}
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isnoibat"))) {
			article.setIsnoibat(1);
		}else {
			article.setIsnoibat(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setNgayxuatban(df.parse(ngayxuatban));
		}else {
			article.setNgayxuatban(ngayhientaiGMT);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";
			article.setNgayketthuc(df.parse(ngayketthuc));
		}
		
		article.setNguontin(ParamUtil.getLong(actionRequest, "tacgia"));
		article.setCongtacvien(HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien")));
		article.setLoaitintuc(2);
		article.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
		article.setSotinanh(ParamUtil.getInteger(actionRequest, "soluonganh"));
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
			article.setIsformbinhluan(1);
		}else {
			article.setIsformbinhluan(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
			article.setIsviewbinhluan(1);
		}else {
			article.setIsviewbinhluan(0);
		}
					
		// Xóa file đính kèm tránh sinh ra khi xem trước
		List<News_AttachFile> listDinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(article.getId(), 9, themeDisplay);
		for(News_AttachFile ldk : listDinhkem) {
			boolean isTenFile = ldk.getTen().contains(".");
			if(isTenFile) {
				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(ldk.getId());
				DocumentUpload.deleteFileVideo(themeDisplay, ldk.getTen());
			} else {
				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(ldk.getId());
			}
		}
		
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadVideo(themeDisplay, uploadPortletRequest, "fileVideo");
		
		if(fileNamedinhkem.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileNamedinhkem.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileNamedinhkem.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
		}
		
		String linkVideo = ParamUtil.getString(actionRequest, "linkVideo");
		if(Validator.isNotNull(linkVideo)) {
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(linkVideo);
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
		}
		
		///////////////////////////////////
		
		if(ParamUtil.getString(uploadPortletRequest, "typeaction").equals("guibientapvien")){
			article.setStatus(1); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(1);
			objLog.setNoidungxuly("Gửi biên tập viên");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(uploadPortletRequest, "typeaction").equals("luuvatrinhpheduyet")) {
			article.setStatus(2); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(2);
			objLog.setNoidungxuly("Lưu và trình phê duyệt");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}
		
		// Xóa danh mục cho xem trước
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(article.getId());
		if(listarticle2Category.size() > 0) {
			for (int del = 0; del < listarticle2Category.size(); del++) {
				News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
			}
		}
		
		String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
		String[] category_id = null;
		if(!data_category.equals("")){
			category_id = data_category.substring(1).split("_");
		}
		
		if(category_id != null && category_id.length > 0){
			for(int b = 0; b<category_id.length; b++){
					News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
					article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
					article2category.setNewarticleId(article.getId());
					article2category.setNewcategoryId(Long.valueOf(category_id[b]));
					article2category.setCompanyId(themeDisplay.getCompanyId());
					article2category.setGroupId(themeDisplay.getScopeGroupId());
					News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
				//}
			}
		}
		
		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || "xuatban".equals(typeaction)) {
			if (id > 0) {
				News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
	    } else {
	    	if (id > 0) {
	    		News_ArticleLocalServiceUtil.updateNews_Article(article);
	        } else {
	        	News_ArticleLocalServiceUtil.addNews_Article(article);
	        }
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", article.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", tabDangtin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateNewsArticleVideo")
	public void updateNewsArticleVideo(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(actionRequest, "id");		
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		News_Article article = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		
		long currentVerSion = article.getVersion();
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		article.setTitle(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
		article.setInfo(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tomtat")));
		
		String noidung = "";
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadVideo(themeDisplay, uploadPortletRequest, "fileVideo");
		
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung1");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents1");
			noidung = noidung + "</div>";
		}
		
		if(Validator.isNull(ParamUtil.getString(uploadPortletRequest, "videocheck"))) {
			if(fileNamedinhkem.size() > 0){
				long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
				News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
				filedinhkem.setId(idFile);
				filedinhkem.setObject(9); 
				filedinhkem.setObjectId(article.getId());
				filedinhkem.setTen(fileNamedinhkem.get(0));
				filedinhkem.setCompanyId(themeDisplay.getCompanyId());
				filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
				filedinhkem.setUrl(fileNamedinhkem.get(1));
				filedinhkem.setUserId(themeDisplay.getUserId());
				News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			} 
			String linkVideo = ParamUtil.getString(actionRequest, "linkVideo");
			if (Validator.isNotNull(linkVideo)) {
				long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
				News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
				filedinhkem.setId(idFile);
				filedinhkem.setObject(9); 
				filedinhkem.setObjectId(article.getId());
				filedinhkem.setTen(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
				filedinhkem.setCompanyId(themeDisplay.getCompanyId());
				filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
				filedinhkem.setUrl(linkVideo);
				filedinhkem.setUserId(themeDisplay.getUserId());
				News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			}
		}
		
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung2");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents2");
			noidung = noidung + "</div>";
		}
		
		article.setContent(noidung);
		article.setModifiedby(themeDisplay.getUserId());
		
		// format date
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		
		article.setModifiedtime(ngayhientaiGMT);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")){
			article.setStatus(1); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(1);
			objLog.setNoidungxuly("Gửi biên tập viên");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){
			article.setStatus(2); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			article.setVersion(currentVerSion +1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(2);
			objLog.setNoidungxuly("Lưu và trình phê duyệt");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("pheduyet")){
			article.setStatus(3);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNoidungxuly("Xuất bản");
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(3);
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinh")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			article.setModifiedby(themeDisplay.getUserId());
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(themeDisplay.getUserId());
			if(article.getStatus() == 5){
				objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết theo yêu cầu");
				if(role.getRole_edit()==1){
					article.setStatus(1);
				}else if(role.getRole_add()==1){
					article.setStatus(0);
				}
			}else{
				objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết");
			}
			objLog.setStatus(objLog.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhpheduyet")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			if(article.getStatus()==5){
				objLog.setNoidungxuly("Đã hiệu chỉnh bổ nội dung bài viết và trình biên tập");
				List<News_Activity> listOldAct = TinTucAdminUtil.listNewAtivityByArticleId(article.getId());
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(listOldAct.size()>0){
					objLog.setNguoinhanid(listOldAct.get(0).getStartuserid());
				}else{
					objLog.setNguoinhanid(article.getModifiedby());
				}
			}else{
				objLog.setNguoinhanid(themeDisplay.getUserId());
			}
			if(article.getStatus() == 5){
				if(role.getRole_edit()==1){
					article.setStatus(2);
				}else if(role.getRole_add()==1) {
					article.setStatus(1);
				}
			}
			objLog.setStatus(article.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhxuatban")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			if(article.getStatus()==5){
				objLog.setNoidungxuly("Đã hiệu chỉnh bổ sung nội dung bài viết và trình phê duyệt");
				List<News_Activity> listOldAct = TinTucAdminUtil.listNewAtivityByArticleId(article.getId());
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(listOldAct.size()>0){
					objLog.setNguoinhanid(listOldAct.get(0).getStartuserid());
				}else {
					objLog.setNguoinhanid(article.getModifiedby());
				}
			}else {
				objLog.setNguoinhanid(themeDisplay.getUserId());
			}
			if(article.getStatus() == 5){
				if(role.getRole_edit()==1){
					article.setStatus(2);
				}else if(role.getRole_add()==1){
					article.setStatus(1);
				}
			}
			objLog.setStatus(article.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
//			TintucadminUtils.updateRSS(category_id, request);	
		}
		article.setLanguage(ParamUtil.getString(actionRequest, "languages"));
		article.setVersion(currentVerSion + 1);
		article.setDelete_status(0);
		article.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "urlsmallimage")) && !ParamUtil.getString(actionRequest, "urlsmallimage").equals("")){
			article.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "noidung"))){
				String data = ParamUtil.getString(actionRequest, "noidung");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					article.setUrlimagesmall(urlimage);
				}
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isnoibat"))) {
			article.setIsnoibat(1);
		}else {
			article.setIsnoibat(0);
		}
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setNgayxuatban(df.parse(ngayxuatban));
		}else {
			article.setNgayxuatban(ngayhientaiGMT);
		}
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";
			article.setNgayketthuc(df.parse(ngayketthuc));
		}else {
			article.setNgayketthuc(null);
		}
		
		article.setNguontin(ParamUtil.getLong(actionRequest, "tacgia"));
		article.setCongtacvien(HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien")));
				
		article.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
		article.setSotinanh(ParamUtil.getInteger(actionRequest, "soluonganh"));
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
			article.setIsformbinhluan(1);
		}else {
			article.setIsformbinhluan(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
			article.setIsviewbinhluan(1);
		}else {
			article.setIsviewbinhluan(0);
		}
		
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(article.getId());
		if(listarticle2Category.size() > 0) {
			for (int del = 0; del < listarticle2Category.size(); del++) {
				News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
				
			}
		}
		
		String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
		String[] category_id = null;
		if(!data_category.equals("")){
			category_id = data_category.substring(1).split("_");
		}
		
		if(category_id != null && category_id.length > 0){
			for(int b = 0; b<category_id.length; b++){
				
				if(category_id[b] != null && !category_id[b].equals("") && Validator.isNumber(category_id[0]) && Long.valueOf(category_id[b]) >0){
					
					News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
					article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
					article2category.setNewarticleId(article.getId());
					article2category.setNewcategoryId(Long.valueOf(category_id[b]));
					article2category.setCompanyId(themeDisplay.getCompanyId());
					article2category.setGroupId(themeDisplay.getScopeGroupId());
					News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
				}
			}
		}
		// Xử lý xem trước
		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || 
				"luuhieuchinh".equals(typeaction) || "pheduyet".equals(typeaction) || "luuhieuchinhxuatban".equals(typeaction) || 
				"luuhieuchinhpheduyet".equals(typeaction) ) {
			News_ArticleLocalServiceUtil.updateNews_Article(article);
	    } else {
	    	News_ArticleLocalServiceUtil.updateNews_Article(article);
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", article.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
				
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", tabDangTin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	public void deleteFileVideo(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long idFile = ParamUtil.getLong(actionRequest, "id");		
		String ten = ParamUtil.getString(actionRequest, "ten");
		boolean isTenFile = ten.contains(".");
//		if(Validator.isNotNull(idFile)){
//			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
//					.getAttribute(WebKeys.THEME_DISPLAY);
//			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(idFile);
//			boolean flag = DocumentUpload.deleteFileVideo(themeDisplay, filedinhkem.getTen());
//			//System.out.println(flag);
//			if(flag == true){
//				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(filedinhkem);
//			}
//			SessionMessages.add(actionRequest,"delete-successfully");
//			actionRequest.setAttribute("flag", flag);
//		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(idFile);
		if(isTenFile) {
			boolean flag = DocumentUpload.deleteFileVideo(themeDisplay, filedinhkem.getTen());
			//System.out.println(flag);
			if(flag == true){
				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(filedinhkem);
			}
			SessionMessages.add(actionRequest,"delete-successfully");
			actionRequest.setAttribute("flag", flag);
		} else {
			News_AttachFileLocalServiceUtil.deleteNews_AttachFile(filedinhkem);
			SessionMessages.add(actionRequest,"delete-successfully");	
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void recoveryTintucvideo(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(0);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs1",tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void softdeleteTintucVideo(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(1);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs1",tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void deleteTintucVideo(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<News_AttachFile> listdinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(id, 9, themeDisplay);
		if(listdinhkem.size() > 0){
			for(int c = 0; c < listdinhkem.size(); c++){
				boolean flag = DocumentUpload.deleteFileVideo(themeDisplay, listdinhkem.get(c).getTen());
				if(flag){
					News_AttachFileLocalServiceUtil.deleteNews_AttachFile(listdinhkem.get(c));
				}
			}
		}
		
		News_ArticleLocalServiceUtil.deleteNews_Article(id);
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateSubCategory")
	public void updateSubCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		long id = ParamUtil.getLong(actionRequest, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name"));
		String language = ParamUtil.getString(actionRequest, "language");
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		News_Subcategories subcat = null;
		subcat = News_SubcategoriesLocalServiceUtil.fetchNews_Subcategories(id);	
		if(Validator.isNotNull(id)) {
			subcat.setName(name);
			subcat.setLanguage(language);
			subcat.setStatus(status);
			subcat = News_SubcategoriesLocalServiceUtil.updateNews_Subcategories(subcat);
			actionResponse.setRenderParameter("action", "success");
			SessionMessages.add(actionRequest, "update-successfully");
			
		}else {
			actionResponse.setRenderParameter("action", "error");
		}
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
				
		actionResponse.setRenderParameter("id", ParamUtil.getString(actionRequest, "id"));	
		redirectURL.setParameter("tabs", tabChuyenMuc);
		
	}	
	
	public void upSubCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name"));
		String language = ParamUtil.getString(actionRequest, "language");
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1: 0;
		long id = ParamUtil.getLong(actionRequest, "subcatid");
		News_Subcategories subcat = null;
		subcat = News_SubcategoriesLocalServiceUtil.fetchNews_Subcategories(id);
		if(Validator.isNotNull(id)) {
			subcat.setName(name);
			subcat.setLanguage(language);
			subcat.setStatus(status);
			subcat = News_SubcategoriesLocalServiceUtil.updateNews_Subcategories(subcat);
			SessionMessages.add(actionRequest, "update-successfully");
		}	
		JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		jsonObject.put("id", id);
		jsonObject.put("name", name);
		jsonObject.put("language", language);	
		jsonObject.put("status", status);
		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonObject.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
	@SuppressWarnings({ "deprecation", "unused" })
	public void deleteSubCat(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		long id = ParamUtil.getLong(actionRequest, "subcatid");
		if(Validator.isNotNull(id)){
			News_Subcategories objSub =  News_SubcategoriesLocalServiceUtil.fetchNews_Subcategories(id);
			List<News_Categories> objcat = TinTucAdminUtil.getNews_CategoriesByIdSubCat(objSub.getId(), "", 0, 0);
			if(objcat.size() > 0) {
				SessionErrors.add(actionRequest, "cochuadanhmuccon");
			}else {
				objSub.setDelete_status(1);
				News_SubcategoriesLocalServiceUtil.updateNews_Subcategories(objSub);
				SessionMessages.add(actionRequest, "delete-successfully");
			}
			//News_SubcategoriesLocalServiceUtil.deleteNews_Subcategories(id);
		}else {
			News_Subcategories objSub;
		}
		
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabChuyenMuc);
		actionResponse.sendRedirect(redirectURL.toString());		
	}
	
	@SuppressWarnings("deprecation")
	public void deleteCategories(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabChuyenMuc = TinTucAdminField.value_tabchuyenmuc;
		long id = ParamUtil.getLong(actionRequest, "catid");
		if(Validator.isNotNull(id)){
			News_CategoriesLocalServiceUtil.deleteNews_Categories(id);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabChuyenMuc);
		actionResponse.sendRedirect(redirectURL.toString());
	}

	public void updateCategory(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {		
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "name"));
		String language = ParamUtil.getString(actionRequest, "language");
		long idlibcat = ParamUtil.getLong(actionRequest, "thuvien");
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1: 0;
		long id = ParamUtil.getLong(actionRequest, "catid");
		News_Categories cat = null;
		cat = News_CategoriesLocalServiceUtil.fetchNews_Categories(id);
		if(Validator.isNotNull(id)) {
			cat.setName(name);
			cat.setLanguage(language);
			cat.setIdlibcat(idlibcat);
			cat.setStatus(status);
			cat = News_CategoriesLocalServiceUtil.updateNews_Categories(cat);
			SessionMessages.add(actionRequest, "update-successfully");
		}	
		JSONObject jsonObject =  JSONFactoryUtil.createJSONObject();
		jsonObject.put("id", id);
		jsonObject.put("name", name);
		jsonObject.put("language", language);	
		jsonObject.put("idlibcat", idlibcat);
		jsonObject.put("status", status);
		HttpServletResponse resourceResponse = PortalUtil
				.getHttpServletResponse(actionResponse);
		resourceResponse.setContentType("application/json");
		resourceResponse.setCharacterEncoding("UTF-8");
		resourceResponse.resetBuffer();
		resourceResponse.getWriter().print(jsonObject.toString());
		resourceResponse.flushBuffer();
		resourceResponse.getWriter().close();
	}
	
	@SuppressWarnings("deprecation")
	public void updateTintuc(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		Date date = new Date();
		long id = ParamUtil.getLong(actionRequest, "id");
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		String title = HtmlUtil.escape(ParamUtil.getString(actionRequest, "title"));
		String isnoibat = ParamUtil.getString(actionRequest, "isnoibat");
		String language = ParamUtil.getString(actionRequest, "languages");
		String tomtat = HtmlUtil.escape(ParamUtil.getString(actionRequest, "mota"));
		String noidung = ParamUtil.getString(actionRequest, "noiDung");		
		long theloaibaiviet = ParamUtil.getLong(actionRequest, "theloai");
		long tacgia = ParamUtil.getLong(actionRequest, "tacgia");		
		String congtacvien = HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien"));
		
		News_Article objectNews = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		//objectNews = TinTucAdminUtil.getTintucfromRequest(uploadPortletRequest, id);
		if(Validator.isNotNull(id)) {
			objectNews.setTypeid(theloaibaiviet);
			objectNews.setTitle(title);
			objectNews.setInfo(tomtat);
			objectNews.setContent(noidung);
			
			objectNews.setModifiedby(themeDisplay.getUserId());
			// format theo múi giờ Việt Nam
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String ngayhientai = df.format(date)+":00";
			
			// Chuyển đổi thành đối tượng Date với múi giờ UTC
			SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
			Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
			objectNews.setModifiedtime(ngayhientaiGMT);
			
			if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")) {
				objectNews.setStatus(1);
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				objLog.setNguoinhanid(0);
				objLog.setStatus(1);
				objLog.setNoidungxuly("Gửi biên tập viên");			
				News_LogLocalServiceUtil.addNews_Log(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){	
				objectNews.setStatus(2);
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				objLog.setNguoinhanid(0);
				objLog.setStatus(2);
				objLog.setNoidungxuly("Lưu và trình phê duyệt");
				News_LogLocalServiceUtil.addNews_Log(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
				objectNews.setStatus(3);
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				objLog.setNguoinhanid(0);
				objLog.setStatus(3);
				objLog.setNoidungxuly("Xuất bản");
				News_LogLocalServiceUtil.addNews_Log(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinh")){
				News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
				objectNews.setVersion(objectNews.getVersion() + 1);
				//objectNews.setModifiedtime(objectNews.getModifiedtime());
				objectNews.setModifiedtime(date);
				objectNews.setModifiedby(themeDisplay.getUserId());
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				objLog.setNguoinhanid(themeDisplay.getUserId());
				if(objectNews.getStatus() == 5) {
					objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết theo yêu cầu");
					if(role.getRole_edit()==1){
						objectNews.setStatus(1);
					}else if(role.getRole_add()==1) {
						objectNews.setStatus(0);
					}
				}else {
					objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết");					
				}
				objLog.setStatus(objectNews.getStatus());
				News_LogLocalServiceUtil.addNews_Log(objLog);
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhpheduyet")){
				News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
				objectNews.setVersion(objectNews.getVersion() + 1);
				//objectNews.setModifiedtime(objectNews.getModifiedtime());
				objectNews.setModifiedtime(date);
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(objectNews.getStatus() == 5) {
					objLog.setNguoixulyid(themeDisplay.getUserId());
					objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết và trình biên tập");
					List<News_Activity> listOldActi = TinTucAdminUtil.listNewAtivityByArticleId(objectNews.getId());
					if(listOldActi.size()>0){
						objLog.setNguoinhanid(listOldActi.get(0).getStartuserid());
					}else {
						objLog.setNguoinhanid(objectNews.getModifiedby());
					}
	
				}else {
					objLog.setNguoinhanid(themeDisplay.getUserId());			
				}
				if(objectNews.getStatus() == 5){
					if(role.getRole_edit()==1){
						objectNews.setStatus(2);
					}else if(role.getRole_add()==1) {
						objectNews.setStatus(1);
					}
				}
				objLog.setStatus(objectNews.getStatus());
				News_LogLocalServiceUtil.addNews_Log(objLog);
				
			}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhxuatban")){
				News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
				objectNews.setVersion(objectNews.getVersion() + 1);
				//objectNews.setModifiedtime(objectNews.getModifiedtime());
				objectNews.setModifiedtime(date);
				News_Log objLog = TinTucAdminUtil.requestobjLog(objectNews);
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(objectNews.getStatus() == 5) {
					objLog.setNguoixulyid(themeDisplay.getUserId());
					objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết và trình phê duyệt");
					List<News_Activity> listOldActi = TinTucAdminUtil.listNewAtivityByArticleId(objectNews.getId());
					if(listOldActi.size()>0){
						objLog.setNguoinhanid(listOldActi.get(0).getStartuserid());
					}else {
						objLog.setNguoinhanid(objectNews.getModifiedby());
					}
	
				}else {
					objLog.setNguoinhanid(themeDisplay.getUserId());			
				}
				if(objectNews.getStatus() == 5){
					if(role.getRole_edit()==1){
						objectNews.setStatus(2);
					}else if(role.getRole_add()==1) {
						objectNews.setStatus(1);
					}
				}
				objLog.setStatus(objectNews.getStatus());
				News_LogLocalServiceUtil.addNews_Log(objLog);
			}
			
			objectNews.setLanguage(language);
			objectNews.setVersion(objectNews.getVersion()+1);
			objectNews.setDelete_status(0);
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "urlsmallimage")) && !ParamUtil.getString(uploadPortletRequest, "urlsmallimage").equals("")){
				objectNews.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
			}else{
				if(Validator.isNotNull(ParamUtil.getString(actionRequest, "contents"))){
					String data = ParamUtil.getString(actionRequest, "contents");
					Document doc = Jsoup.parse(data);
					Element link = doc.select("img").first();
					if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
						String urlimage = link.attr("src");
						objectNews.setUrlimagesmall(urlimage);
					}
				}
			}
			if(Validator.isNotNull(isnoibat)) {
				objectNews.setIsnoibat(1);
			}else {
				objectNews.setIsnoibat(0);
			}
			
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
				String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
				objectNews.setNgayxuatban(df.parse(ngayxuatban));
			}else {
				objectNews.setNgayxuatban(ngayhientaiGMT);
			}
			
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
				String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";
				objectNews.setNgayketthuc(df.parse(ngayketthuc));
			} else {
				objectNews.setNgayketthuc(null);
			}
			
			objectNews.setNguontin(tacgia);
			objectNews.setCongtacvien(congtacvien);
			objectNews.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));
			objectNews.setSotinanh(ParamUtil.getInteger(actionRequest, "soluonganh"));
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
				objectNews.setIsformbinhluan(1);
			}else {
				objectNews.setIsformbinhluan(0);
			}
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
				objectNews.setIsviewbinhluan(1);
			}else {
				objectNews.setIsviewbinhluan(0);
			}
			
			
			List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(objectNews.getId());
		
			if(listarticle2Category.size() > 0) {
				for (int del = 0; del < listarticle2Category.size(); del++) {
					News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
				}
			}
			String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
			String[] category_id = null;
			if(!data_category.equals("")){
				category_id = data_category.substring(1).split("_");
			}
			if(category_id != null && category_id.length > 0){
				for(int b = 0; b<category_id.length; b++){
					if(category_id[b] != null && !category_id[b].equals("") && Validator.isNumber(category_id[0]) && Long.valueOf(category_id[b]) >0){
						News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
						article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
						article2category.setNewarticleId(objectNews.getId());
						article2category.setNewcategoryId(Long.valueOf(category_id[b]));
						article2category.setCompanyId(themeDisplay.getCompanyId());
						article2category.setGroupId(themeDisplay.getScopeGroupId());
						News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
					}
				}
			}
			SessionMessages.add(actionRequest, "update-successfully");	
		}

		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luuhieuchinh".equals(typeaction) || "luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || "xuatban".equals(typeaction) ) {
			objectNews.setContent(ParamUtil.getString(actionRequest, "contents"));
			News_ArticleLocalServiceUtil.updateNews_Article(objectNews);
	    } else {
	    	News_ArticleLocalServiceUtil.updateNews_Article(objectNews);
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", objectNews.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
		
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabDangTin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "updateNewsArticlePDF")
	public void updateNewsArticlePDF(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(actionRequest, "id");		
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		News_Article article = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		long currentVerSion = article.getVersion();
		
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		article.setTitle(HtmlUtil.escape(ParamUtil.getString(actionRequest, "title")));
		article.setInfo(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tomtat")));
		
		String noidung = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "filePDF");
		
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung1");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents1"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents1");
			noidung = noidung + "</div>";
		}
		
		if(fileNamedinhkem.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileNamedinhkem.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileNamedinhkem.get(1));
			filedinhkem.setUserId(themeDisplay.getUserId());
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String urlPDF = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				urlPDF = filedinhkem.getUrl();
			}
			noidung = noidung + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdfjs-3.8.162-dist/web/viewer.html?file="+urlPDF+"\" style=\"width:700px; height:850px;\"></embed></p>";
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "pdfcheck")) && !ParamUtil.getString(uploadPortletRequest, "pdfcheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "pdfcheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "pdfcheck"));
			String urlPDF = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				urlPDF = dk.getUrl();
			}
			noidung = noidung + "<p class=\"pdfview\" style=\"text-align:center\"><embed src=\"/o/vn.dnict.tintuc/js/pdfjs-3.8.162-dist/web/viewer.html?file="+urlPDF+"\" style=\"width:100%; height:1000px;\"></embed></p>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noiDung2"))){
			
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noiDung2");
			noidung = noidung + "</div>";
		}
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "contents2"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "contents2");
			noidung = noidung + "</div>";
		}
		
		article.setContent(noidung);
		article.setModifiedby(themeDisplay.getUserId());
		
		// format theo múi giờ Việt Nam
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		
		// Chuyển đổi thành đối tượng Date với múi giờ UTC
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
		article.setModifiedtime(ngayhientaiGMT);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("guibientapvien")){
			article.setStatus(1); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(1);
			objLog.setNoidungxuly("Gửi biên tập viên");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuvatrinhpheduyet")){
			article.setStatus(2); // article status = 1 trạng thái gửi biên tập hiệu chỉnh và đợi xuất bản
			article.setVersion(currentVerSion +1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(2);
			objLog.setNoidungxuly("Lưu và trình phê duyệt");
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("pheduyet")){
			article.setStatus(3);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNoidungxuly("Xuất bản");
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(0);
			objLog.setStatus(3);
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinh")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			article.setModifiedby(themeDisplay.getUserId());
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			objLog.setNguoinhanid(themeDisplay.getUserId());
			if(article.getStatus() == 5){
				objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết theo yêu cầu");
				if(role.getRole_edit()==1){
					article.setStatus(1);
				}else if(role.getRole_add()==1){
					article.setStatus(0);
				}
			}else{
				objLog.setNoidungxuly("Đã hiệu chỉnh nội dung bài viết");
			}
			objLog.setStatus(objLog.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhpheduyet")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			if(article.getStatus()==5){
				objLog.setNoidungxuly("Đã hiệu chỉnh bổ nội dung bài viết và trình biên tập");
				List<News_Activity> listOldAct = TinTucAdminUtil.listNewAtivityByArticleId(article.getId());
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(listOldAct.size()>0){
					objLog.setNguoinhanid(listOldAct.get(0).getStartuserid());
				}else{
					objLog.setNguoinhanid(article.getModifiedby());
				}
			}else{
				objLog.setNguoinhanid(themeDisplay.getUserId());
			}
			if(article.getStatus() == 5){
				if(role.getRole_edit()==1){
					article.setStatus(2);
				}else if(role.getRole_add()==1) {
					article.setStatus(1);
				}
			}
			objLog.setStatus(article.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
		}else if(ParamUtil.getString(actionRequest, "typeaction").equals("luuhieuchinhxuatban")){
			News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
			article.setVersion(currentVerSion + 1);
			//article.setModifiedtime(article.getModifiedtime());
			article.setModifiedtime(date);
			News_Log objLog = TinTucAdminUtil.requestobjLog(article);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			if(article.getStatus()==5){
				objLog.setNoidungxuly("Đã hiệu chỉnh bổ sung nội dung bài viết và trình phê duyệt");
				List<News_Activity> listOldAct = TinTucAdminUtil.listNewAtivityByArticleId(article.getId());
				objLog.setNguoixulyid(themeDisplay.getUserId());
				if(listOldAct.size()>0){
					objLog.setNguoinhanid(listOldAct.get(0).getStartuserid());
				}else {
					objLog.setNguoinhanid(article.getModifiedby());
				}
			}else {
				objLog.setNguoinhanid(themeDisplay.getUserId());
			}
			if(article.getStatus() == 5){
				if(role.getRole_edit()==1){
					article.setStatus(2);
				}else if(role.getRole_add()==1){
					article.setStatus(1);
				}
			}
			objLog.setStatus(article.getStatus());
			News_LogLocalServiceUtil.addNews_Log(objLog);
//			TintucadminUtils.updateRSS(category_id, request);	
		}
		article.setLanguage(ParamUtil.getString(actionRequest, "languages"));
		article.setVersion(currentVerSion + 1);
		article.setDelete_status(0);
		
		article.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "urlsmallimage")) && !ParamUtil.getString(actionRequest, "urlsmallimage").equals("")){
			article.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
		}else{
			if(Validator.isNotNull(ParamUtil.getString(actionRequest, "noidung"))){
				String data = ParamUtil.getString(actionRequest, "noidung");
				Document doc = Jsoup.parse(data);
				Element link = doc.select("img").first();
				if(Validator.isNotNull(link) && Validator.isNotNull(link.attr("src"))){
					String urlimage = link.attr("src");
					article.setUrlimagesmall(urlimage);
				}
			}
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isnoibat"))) {
			article.setIsnoibat(1);
		}else {
			article.setIsnoibat(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setNgayxuatban(df.parse(ngayxuatban));
		}else {
			article.setNgayxuatban(ngayhientaiGMT);
		}
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayketthuc"))) {
			String ngayketthuc = ParamUtil.getString(actionRequest, "ngayketthuc")+":00";
			article.setNgayketthuc(df.parse(ngayketthuc));
		}else {
			article.setNgayketthuc(null);
		}
		
		article.setNguontin(ParamUtil.getLong(actionRequest, "tacgia"));
		article.setCongtacvien(HtmlUtil.escape(ParamUtil.getString(actionRequest, "congtacvien")));
		article.setLoaitintuc(1);
		article.setTukhoa(ParamUtil.getString(actionRequest, "tuKhoa"));		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isformbinhluan"))) {
			article.setIsformbinhluan(1);
		}else {
			article.setIsformbinhluan(0);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "isviewbinhluan"))) {
			article.setIsviewbinhluan(1);
		}else {
			article.setIsviewbinhluan(0);
		}
		
		List<News_Article2Category> listarticle2Category = TinTucAdminUtil.getListArticle2CategoryByArticleId(article.getId());
		if(listarticle2Category.size() > 0) {
			for (int del = 0; del < listarticle2Category.size(); del++) {
				News_Article2CategoryLocalServiceUtil.deleteNews_Article2Category(listarticle2Category.get(del));
			}
		}
		
		String data_category = ParamUtil.getString(actionRequest, "danhmuc-selected");
		String[] category_id = null;
		if(!data_category.equals("")){
			category_id = data_category.substring(1).split("_");
		}
		
		if(category_id != null && category_id.length > 0){
			for(int b = 0; b<category_id.length; b++){
				
				if(category_id[b] != null && !category_id[b].equals("") && Validator.isNumber(category_id[0]) && Long.valueOf(category_id[b]) >0){
					
					News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.createNews_Article2Category(Long.valueOf(category_id[b]));
					article2category.setId(CounterLocalServiceUtil.increment(News_Article2Category.class.getName()));		
					article2category.setNewarticleId(article.getId());
					article2category.setNewcategoryId(Long.valueOf(category_id[b]));
					article2category.setCompanyId(themeDisplay.getCompanyId());
					article2category.setGroupId(themeDisplay.getScopeGroupId());
					News_Article2CategoryLocalServiceUtil.addNews_Article2Category(article2category);
				}
			}
		}
		
		String typeaction = ParamUtil.getString(actionRequest, "typeaction");
		if ("luu".equals(typeaction) || "guibientapvien".equals(typeaction) || "luuvatrinhpheduyet".equals(typeaction) || 
				"luuhieuchinh".equals(typeaction) || "pheduyet".equals(typeaction) || "luuhieuchinhxuatban".equals(typeaction) || 
				"luuhieuchinhpheduyet".equals(typeaction) ) {
			News_ArticleLocalServiceUtil.updateNews_Article(article);
	    } else {
	    	News_ArticleLocalServiceUtil.updateNews_Article(article);
		    JSONObject json = JSONFactoryUtil.createJSONObject();
		    json.put("id", article.getId());
		    HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
		    response.setContentType("application/json");
		    PrintWriter writer = response.getWriter();
		    writer.write(json.toString());
		    writer.flush();
		    writer.close();
	    }
				
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", tabDangTin);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	public void deleteFilePDF(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long idFile = ParamUtil.getLong(actionRequest, "id");		
		
		if(Validator.isNotNull(idFile)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(idFile);
			boolean flag = DocumentUpload.deleteFile(themeDisplay, filedinhkem.getTen());
			//System.out.println(flag);
			if(flag == true){
				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(filedinhkem);
			}
			SessionMessages.add(actionRequest,"delete-successfully");
			actionRequest.setAttribute("flag", flag);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void recoveryTintuc(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(0);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		
		redirectURL.setParameter("tabs1", tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void softdeleteTintuc(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(1);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		
		redirectURL.setParameter("tabs1", tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void deleteTintuc(ActionRequest request,ActionResponse response) throws Exception{
		long id = ParamUtil.getLong(request, "id");
		News_ArticleLocalServiceUtil.deleteNews_Article(id);
	}
	
	@SuppressWarnings("deprecation")
	public static void recoveryTintucpdf(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(0);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs1",tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void softdeleteTintucPDF(ActionRequest request,ActionResponse response) throws Exception{
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		object.setDelete_status(1);
		News_ArticleLocalServiceUtil.updateNews_Article(object);
		String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(request), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs1",tabDangTin);
		response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void deleteTintucPDF(ActionRequest request,ActionResponse response) throws Exception{
		long id = ParamUtil.getLong(request, "id");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<News_AttachFile> listdinhkem = DocumentUpload.getLinkdinhkembyIdAndObject(id, 9, themeDisplay);
		if(listdinhkem.size() > 0){
			for(int c = 0; c < listdinhkem.size(); c++){
				boolean flag = DocumentUpload.deleteFile(themeDisplay, listdinhkem.get(c).getTen());
				if(flag){
					News_AttachFileLocalServiceUtil.deleteNews_AttachFile(listdinhkem.get(c));
				}
			}
		}
		
		News_ArticleLocalServiceUtil.deleteNews_Article(id);
	}
	
	@SuppressWarnings("deprecation")
	public static void saveYeuCauHieuChinh(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabDangTin = TinTucAdminField.value_tabdangtin;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = CounterLocalServiceUtil.increment(News_Activity.class.getName());
		long idNews = ParamUtil.getLong(actionRequest, "idNews");
		String noidung  = ParamUtil.getString(actionRequest, "noidung");
		News_role role = PhanQuyenAdminUtil.getUserById(themeDisplay.getUserId());
		News_Article objNews = News_ArticleLocalServiceUtil.fetchNews_Article(idNews);
		News_Activity objActive = News_ActivityLocalServiceUtil.createNews_Activity(id);
		News_Log objLog = TinTucAdminUtil.requestobjLog(objNews); 
		
		if(Validator.isNotNull(idNews) && idNews > 0){
			List<News_Activity> listOldAct = TinTucAdminUtil.listNewAtivityByArticleId(id);
			if(listOldAct.size()>0){
				for(News_Activity objAct: listOldAct){
					News_ActivityLocalServiceUtil.deleteNews_Activity(objAct);
				}
			}
			objActive.setCompanyId(themeDisplay.getCompanyId());
			objActive.setGroupId(themeDisplay.getScopeGroupId());
			objActive.setContentrequest(noidung);
			objActive.setStatusofarticle(5);
			objActive.setArticleid(idNews);
			objActive.setStartuserid(themeDisplay.getUserId());
			
			
			
			if(role.getRole_edit()==1 || role.getRole_public()==1){
				objActive.setEnduserid(objNews.getCreatedby());
			}else {
				objActive.setEnduserid(objNews.getModifiedby());
			}
			//System.out.println(objNews.getModifiedby());
			News_ActivityLocalServiceUtil.addNews_Activity(objActive);
			
			objNews.setStatus(5);
			objNews.setModifiedby(themeDisplay.getUserId());
			News_ArticleLocalServiceUtil.updateNews_Article(objNews);
			
			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("tabs", tabDangTin);
			actionResponse.sendRedirect(redirectURL.toString());
			objLog.setId(CounterLocalServiceUtil.increment(News_Log.class.getName()));
			objLog.setNoidungxuly("Yêu cầu hiệu chỉnh bài viết");
			objLog.setStatus(5);
			objLog.setNguoixulyid(themeDisplay.getUserId());
			if(role.getRole_edit()==1){
				objLog.setNguoinhanid(objNews.getCreatedby());
			}else if(role.getRole_public()==1){
				objLog.setNguoinhanid(objNews.getModifiedby());
			}
			News_LogLocalServiceUtil.addNews_Log(objLog);
			SessionMessages.add(actionRequest,"");
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void saveTheLoai(ActionRequest actionRequest, ActionResponse actionResponse) {
		String tabTheLoai = TinTucAdminField.value_tabtheloai;
		long id = CounterLocalServiceUtil.increment(News_Type.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_Type objType = News_TypeLocalServiceUtil.createNews_Type(id);
		//System.out.println(themeDisplay.getLocale());
		objType.setCompanyId(themeDisplay.getCompanyId());
		objType.setGroupId(themeDisplay.getScopeGroupId());
		objType.setLanguage(String.valueOf(themeDisplay.getLocale()));
		objType.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "theloai")));
		objType.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0 );
		objType.setDelete_status(0);
		objType = News_TypeLocalServiceUtil.addNews_Type(objType);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTheLoai);
	}

	@SuppressWarnings("deprecation")
	public void updateTheLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabTheLoai = TinTucAdminField.value_tabtheloai;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//long idNews = ParamUtil.getLong(actionRequest, "theloaiid");
		long id = ParamUtil.getLong(actionRequest, "theloaiid");
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "theloai"));
		//System.out.println(idNews+name);
		int status = ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0;
		News_Type obj = null;
		obj = News_TypeLocalServiceUtil.fetchNews_Type(Long.valueOf(id));	
		obj.setName(name);
		obj.setStatus(status);
		obj = News_TypeLocalServiceUtil.updateNews_Type(obj);
		SessionMessages.add(actionRequest, "update-successfully");
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTheLoai);
		
	}
	
	@SuppressWarnings("deprecation")
	public void deleteTheLoai(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabTheLoai = TinTucAdminField.value_tabtheloai;
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");		
		//boolean result=true;
		for(long item:checkedItem)
		{
			//System.out.println(item);
			News_Type object = News_TypeLocalServiceUtil.fetchNews_Type(item);
			//System.out.println(object);
			object.setDelete_status(1);
			News_TypeLocalServiceUtil.updateNews_Type(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTheLoai);
		actionResponse.sendRedirect(redirectURL.toString());
	}	
	
	@SuppressWarnings("deprecation")
	public void saveTacGia(ActionRequest actionRequest, ActionResponse actionResponse) {
		String tabTacGia = TinTucAdminField.value_tabtacgia;
		long id = CounterLocalServiceUtil.increment(News_NguonTin.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_NguonTin objType = News_NguonTinLocalServiceUtil.createNews_NguonTin(id);	
		objType.setCompanyId(themeDisplay.getCompanyId());
		objType.setGroupId(themeDisplay.getScopeGroupId());
		objType.setName(HtmlUtil.escape(ParamUtil.getString(actionRequest, "tacgia")));
		objType.setStatus(ParamUtil.getBoolean(actionRequest, "status") == true ? 1 : 0 );	
		objType.setDelete_status(0);
		objType = News_NguonTinLocalServiceUtil.addNews_NguonTin(objType);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTacGia);
	}
	
	@SuppressWarnings("deprecation")
	public void updateTacGia(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception{
		String tabTacGia = TinTucAdminField.value_tabtacgia;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = ParamUtil.getLong(actionRequest, "tacgiaid");
		String name = HtmlUtil.escape(ParamUtil.getString(actionRequest, "tacgia"));
		//System.out.println(idNews+name);
		int status = ParamUtil.getBoolean(actionRequest, "sudung") == true ? 1 : 0;
		News_NguonTin obj = null;
		obj = News_NguonTinLocalServiceUtil.fetchNews_NguonTin(Long.valueOf(id));	
		obj.setName(name);
		obj.setStatus(status);
		obj = News_NguonTinLocalServiceUtil.updateNews_NguonTin(obj);
		SessionMessages.add(actionRequest, "update-successfully");
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil
				.create(PortalUtil.getHttpServletRequest(actionRequest), portletName,
						themeDisplay.getLayout().getPlid(),
						PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTacGia);
		
	}
	
	@SuppressWarnings("deprecation")
	public void deleteTacGia(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String tabTacGia = TinTucAdminField.value_tabtacgia;
		long[] checkedItem = ParamUtil.getLongValues(actionRequest, "check[]");		
		//boolean result=true;
		for(long item:checkedItem)
		{
			//System.out.println(item);
			News_NguonTin object = News_NguonTinLocalServiceUtil.fetchNews_NguonTin(item);
			//System.out.println(object);
			object.setDelete_status(1);
			object.setStatus(1);
			News_NguonTinLocalServiceUtil.updateNews_NguonTin(object);
			SessionMessages.add(actionRequest, "delete-successfully");
		}
		String portletName = (String)actionRequest.getAttribute(WebKeys.PORTLET_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				 portletName,
				 themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", tabTacGia);
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	//	 Xử lý ngừng xuất bản	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date)+":00";
		SimpleDateFormat dfGMT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dfGMT.setTimeZone(TimeZone.getTimeZone("GMT-7"));
		try {
			Date ngayhientaiGMT = dfGMT.parse(ngayhientai);
			DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
//			query.add(PropertyFactoryUtil.forName("status").eq(3));
			// get news have status = 3 or = 6
			query.add(PropertyFactoryUtil.forName("status").in(new Integer[]{3, 6}));
			List<News_Article> listintucbyxuatban = News_ArticleLocalServiceUtil.dynamicQuery(query);
			for (News_Article tt : listintucbyxuatban) {
				if (tt.getNgayxuatban() != null && ngayhientaiGMT.before(tt.getNgayxuatban())) {
					tt.setStatus(6);
		        	News_Log objLog = TinTucAdminUtil.requestobjLog(tt);
					objLog.setNguoixulyid(themeDisplay.getUserId());
					objLog.setStatus(6);
					objLog.setNoidungxuly("Chờ xuất bản");			
					News_LogLocalServiceUtil.addNews_Log(objLog);
		        	News_ArticleLocalServiceUtil.updateNews_Article(tt);
				} else if (tt.getNgayketthuc() != null && ngayhientaiGMT.after(tt.getNgayketthuc())) {
		        	tt.setStatus(4);
		        	News_Log objLog = TinTucAdminUtil.requestobjLog(tt);
					objLog.setNguoixulyid(themeDisplay.getUserId());
					objLog.setStatus(4);
					objLog.setNoidungxuly("Ngừng xuất bản");			
					News_LogLocalServiceUtil.addNews_Log(objLog);
		        	News_ArticleLocalServiceUtil.updateNews_Article(tt);
		        } else if(tt.getNgayxuatban() != null && 
		        		
		        		ngayhientaiGMT.after(tt.getNgayxuatban()) 
		        		) {
		        	tt.setStatus(3);
		        	News_Log objLog = TinTucAdminUtil.requestobjLog(tt);
					objLog.setNguoixulyid(themeDisplay.getUserId());
					objLog.setStatus(3);
					objLog.setNoidungxuly("Xuất bản");			
					News_LogLocalServiceUtil.addNews_Log(objLog);
		        	News_ArticleLocalServiceUtil.updateNews_Article(tt);
		        }
		    }
		} catch (ParseException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}