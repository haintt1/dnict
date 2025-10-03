package vn.dnict.tintuc.portlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_Activity;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.model.News_Log;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_AttachFileLocalServiceUtil;
import vn.dnict.tintuc.service.News_LogLocalServiceUtil;
import vn.dnict.tintuc.utils.DocumentUpload;
import vn.dnict.tintuc.utils.PhanQuyenAdminUtil;
import vn.dnict.tintuc.utils.TinTucAdminUtil;
@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.icon=/images/",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Quản lý sách",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/tintucadmin/books/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.QUANLYSACH,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)
public class QuanLySachPortlet extends MVCPortlet{
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveBooks")
	public void saveBooks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = CounterLocalServiceUtil.increment(News_ArticleLocalServiceUtil.class.getName());
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String lang = actionRequest.getParameter("languages");
		long theloaibaiviet = ParamUtil.getLong(actionRequest, "theloai");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article article = News_ArticleLocalServiceUtil.createNews_Article(id);
		article.setId(id);
		article.setCompanyId(themeDisplay.getCompanyId());
		article.setGroupId(themeDisplay.getScopeGroupId());
		article.setTitle(ParamUtil.getString(actionRequest, "title"));
		article.setContent(ParamUtil.getString(actionRequest, "contents"));
		article.setVersion(1);
		article.setIsnoibat(0);
		article.setLoaitintuc(4);
		
		String info = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tacgia"))){
			info = info + "<span class=\"authorinfo\">";
			info = info + ParamUtil.getString(actionRequest, "tacgia");
			info = info + "</span>";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "xuatban"))){
			info = info + "<span class=\"publishinfo\">";
			info = info + ParamUtil.getString(actionRequest, "xuatban");
			info = info + "</span>";
		}
		article.setInfo(info);
		
		String urlimage = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileimage = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "fileimage");
		if(fileimage.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(9); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileimage.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileimage.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = filedinhkem.getUrl();
			}
			urlimage = urlimage + linkimage;
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "imagecheck")) && !ParamUtil.getString(uploadPortletRequest, "imagecheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "imagecheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "imagecheck"));
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = dk.getUrl();
			}
			urlimage = urlimage + linkimage;
		}
		article.setUrlimagesmall(urlimage);		
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date);
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setCreatedtime(df.parse(ngayxuatban));			
		}else {
			article.setCreatedtime(df.parse(ngayhientai));
		}
		
		article.setCreatedby(themeDisplay.getUserId());
		article.setLanguage(lang);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
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
		article.setDelete_status(0);
		if(Validator.isNotNull(theloaibaiviet)) {
			article.setTypeid(Long.valueOf(theloaibaiviet));
		}
		News_ArticleLocalServiceUtil.addNews_Article(article);		
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
		
		actionRequest.setAttribute("tintucobject", article);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", "Đăng tin");
		redirectURL.setParameter("jspPage", "/html/tintucadmin/books/view.jsp");
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void updateBooks(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		News_Article article = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		long currentVerSion = article.getVersion();		
		
		article.setTitle(ParamUtil.getString(actionRequest, "title"));	
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		article.setContent(ParamUtil.getString(actionRequest, "contents"));
		article.setIsnoibat(0);
		article.setLoaitintuc(4);
		//article.setUrlimagesmall(ParamUtil.getString(actionRequest, "urlsmallimage"));
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			article.setCreatedtime(df.parse(ngayxuatban));
		}else {
			article.setCreatedtime(date);
		}
		String info = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tacgia"))){
			info = info + "<span class=\"authorinfo\">";
			info = info + ParamUtil.getString(actionRequest, "tacgia");
			info = info + "</span>";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "xuatban"))){
			info = info + "<span class=\"publishinfo\">";
			info = info + ParamUtil.getString(actionRequest, "xuatban");
			info = info + "</span>";
		}
		article.setInfo(info);
		
		article.setModifiedtime(date);
		article.setLanguage(ParamUtil.getString(actionRequest, "languages"));
		article.setVersion(currentVerSion + 1);
		/*String urlsmallimage = article.getUrlimagesmall();
		if(urlsmallimage!= null && urlsmallimage !="") {		
			System.out.println("abc " + urlsmallimage);
			article.setUrlimagesmall(urlsmallimage);
		} else { */
		String urlimage = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileimage = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "fileimage");
		if(fileimage.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(10); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileimage.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileimage.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = filedinhkem.getUrl();
			}
			urlimage = urlimage + linkimage;
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "imagecheck")) && !ParamUtil.getString(uploadPortletRequest, "imagecheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "imagecheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "imagecheck"));
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = dk.getUrl();
			}
			urlimage = urlimage + linkimage;
		}
		article.setUrlimagesmall(urlimage);	
		//}
		article.setDelete_status(0);
		
		article.setModifiedby(themeDisplay.getUserId());
		article.setStatus(3);
		News_Log objLog = TinTucAdminUtil.requestobjLog(article);
		objLog.setNoidungxuly("Xuất bản");
		objLog.setNguoixulyid(themeDisplay.getUserId());
		objLog.setNguoinhanid(0);
		objLog.setStatus(3);
		News_LogLocalServiceUtil.addNews_Log(objLog);
		
		News_ArticleLocalServiceUtil.updateNews_Article(article);
		
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
					//News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.fetchNews_Article2Category(Long.valueOf(category_id[b]));
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
		
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", "Đăng tin");
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	public void deleteImage(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception {
		long idFile = ParamUtil.getLong(actionRequest, "id");		
		
		if(Validator.isNotNull(idFile)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(idFile);
			boolean flag = DocumentUpload.deleteFile(themeDisplay, filedinhkem.getTen());
			
			if(flag == true){
				News_AttachFileLocalServiceUtil.deleteNews_AttachFile(filedinhkem);
			}
			SessionMessages.add(actionRequest,"delete-successfully");
			actionRequest.setAttribute("flag", flag);
		}
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
	public static void deleteBooks(ActionRequest request,ActionResponse response)
			throws Exception{
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
			
			redirectURL.setParameter("tabs1", "Đăng tin");
			response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public static void deleteBooksPDF(ActionRequest request,ActionResponse response)
			throws Exception{
			long id = ParamUtil.getLong(request, "id");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			News_Article object = News_ArticleLocalServiceUtil.fetchNews_Article(id);
			object.setDelete_status(1);
			List<News_AttachFile> listimage = DocumentUpload.getLinkdinhkembyIdAndObject(id, 9, themeDisplay);
			if(listimage.size() > 0){
				for(int c = 0; c < listimage.size(); c++){
					boolean flag = DocumentUpload.deleteFile(themeDisplay, listimage.get(c).getTen());
					if(flag){
						News_AttachFileLocalServiceUtil.deleteNews_AttachFile(listimage.get(c));
					}
				}
			}
			
			News_ArticleLocalServiceUtil.updateNews_Article(object);
			String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
			PortletURL redirectURL = PortletURLFactoryUtil
					.create(PortalUtil.getHttpServletRequest(request), portletName,
							themeDisplay.getLayout().getPlid(),
							PortletRequest.RENDER_PHASE);
			redirectURL.setParameter("tabs1", "Đăng tin");
			response.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	@ProcessAction(name = "saveBooksPDF")
	public void saveBooksPDF(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = CounterLocalServiceUtil.increment(News_ArticleLocalServiceUtil.class.getName());
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String lang = actionRequest.getParameter("languages");
		long theloaibaiviet = ParamUtil.getLong(actionRequest, "theloai");
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		News_Article article = News_ArticleLocalServiceUtil.createNews_Article(id);
		article.setId(id);
		article.setCompanyId(themeDisplay.getCompanyId());
		article.setGroupId(themeDisplay.getScopeGroupId());
		article.setTitle(ParamUtil.getString(actionRequest, "title"));
		//article.setContent(ParamUtil.getString(actionRequest, "contents"));
		article.setVersion(1);
		article.setIsnoibat(0);
		if(ParamUtil.getBoolean(actionRequest, "loaitintuc") == true){
			article.setLoaitintuc(5);
		}else{
			article.setLoaitintuc(6);
		}
		if(ParamUtil.getBoolean(actionRequest, "flipbook")==true){
			article.setLoaitintuc(7);
		}
		
		String info = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tacgia"))){
			info = info + "<span class=\"authorinfo\">";
			info = info + ParamUtil.getString(actionRequest, "tacgia");
			info = info + "</span>";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "xuatban"))){
			info = info + "<span class=\"publishinfo\">";
			info = info + ParamUtil.getString(actionRequest, "xuatban");
			info = info + "</span>";
		}
		article.setInfo(info);
		
		String urlimage = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileimage = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "fileimage");
		if(fileimage.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(10); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileimage.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileimage.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = filedinhkem.getUrl();
			}
			urlimage = urlimage + linkimage;
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "imagecheck")) && !ParamUtil.getString(uploadPortletRequest, "imagecheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "imagecheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "imagecheck"));
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = dk.getUrl();
			}
			urlimage = urlimage + linkimage;
		}
		article.setUrlimagesmall(urlimage);		
		
		String noidung = "";
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "filePDF");
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noidung"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noidung");
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
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noidunglast"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noidunglast");
			noidung = noidung + "</div>";
		}
		article.setContent(noidung);
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String ngayhientai = df.format(date);
		
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			article.setCreatedtime(df.parse(ngayxuatban));			
		}else {
			article.setCreatedtime(df.parse(ngayhientai));
		}
		
		article.setCreatedby(themeDisplay.getUserId());
		article.setLanguage(lang);
		
		if(ParamUtil.getString(actionRequest, "typeaction").equals("xuatban")) {
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
		article.setDelete_status(0);
		if(Validator.isNotNull(theloaibaiviet)) {
			article.setTypeid(Long.valueOf(theloaibaiviet));
		}
		News_ArticleLocalServiceUtil.addNews_Article(article);		
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
		
		actionRequest.setAttribute("tintucobject", article);
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		redirectURL.setParameter("tabs", "Đăng tin");
		redirectURL.setParameter("jspPage", "/html/tintucadmin/books/view.jsp");
		actionResponse.sendRedirect(redirectURL.toString());
	}
	
	@SuppressWarnings("deprecation")
	public void updateBooksPDF(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		long id = ParamUtil.getLong(actionRequest, "id");
		
		Date date = new Date();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		News_Article article = News_ArticleLocalServiceUtil.fetchNews_Article(id);
		long currentVerSion = article.getVersion();		
		
		article.setTitle(ParamUtil.getString(actionRequest, "title"));	
		article.setTypeid(ParamUtil.getLong(actionRequest, "theloai"));
		//article.setContent(ParamUtil.getString(actionRequest, "contents"));
		article.setIsnoibat(0);
		if(ParamUtil.getBoolean(actionRequest, "loaitintuc") == true){
			article.setLoaitintuc(5);
		}else{
			article.setLoaitintuc(6);
		}
		if(ParamUtil.getBoolean(actionRequest, "flipbook")==true){
			article.setLoaitintuc(7);
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "ngayxuatban"))) {
			String ngayxuatban = ParamUtil.getString(actionRequest, "ngayxuatban")+":00";
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			article.setCreatedtime(df.parse(ngayxuatban));
		}else {
			article.setCreatedtime(date);
		}
		String info = "";
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "tacgia"))){
			info = info + "<span class=\"authorinfo\">";
			info = info + ParamUtil.getString(actionRequest, "tacgia");
			info = info + "</span>";
		}
		if(Validator.isNotNull(ParamUtil.getString(actionRequest, "xuatban"))){
			info = info + "<span class=\"publishinfo\">";
			info = info + ParamUtil.getString(actionRequest, "xuatban");
			info = info + "</span>";
		}
		article.setInfo(info);
		
		article.setModifiedtime(date);
		article.setLanguage(ParamUtil.getString(actionRequest, "languages"));
		article.setVersion(currentVerSion + 1);
		String urlimage = "";
		DocumentUpload.createFolder(actionRequest, themeDisplay);
		List<String> fileimage = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "fileimage");
		if(fileimage.size() > 0){
			long idFile = CounterLocalServiceUtil.increment(News_AttachFile.class.getName());
			News_AttachFile filedinhkem = News_AttachFileLocalServiceUtil.createNews_AttachFile(idFile);
			filedinhkem.setId(idFile);
			filedinhkem.setObject(10); 
			filedinhkem.setObjectId(article.getId());
			filedinhkem.setTen(fileimage.get(0));
			filedinhkem.setCompanyId(themeDisplay.getCompanyId());
			filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
			filedinhkem.setUrl(fileimage.get(1));
			News_AttachFileLocalServiceUtil.addNews_AttachFile(filedinhkem);
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = filedinhkem.getUrl();
			}
			urlimage = urlimage + linkimage;
		}else if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "imagecheck")) && !ParamUtil.getString(uploadPortletRequest, "imagecheck").equals("") && Integer.valueOf(ParamUtil.getString(uploadPortletRequest, "imagecheck")) > 0)
		{
			News_AttachFile dk = News_AttachFileLocalServiceUtil.fetchNews_AttachFile(ParamUtil.getLong(uploadPortletRequest, "imagecheck"));
			String linkimage = "";
			String url_temp2 = themeDisplay.getPortalURL();
			if(url_temp2.length() > 0){
				linkimage = dk.getUrl();
			}
			urlimage = urlimage + linkimage;
		}
		article.setUrlimagesmall(urlimage);	
		
		String noidung = "";
		List<String> fileNamedinhkem = DocumentUpload.CoreFileDinhKemUploadPDF(themeDisplay, uploadPortletRequest, "CmsDnict_Upload", "This folder is create for CMS documents", "filePDF");
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noidung"))){
			noidung = noidung + "<div class=\"contentfirst\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noidung");
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
		if(Validator.isNotNull(ParamUtil.getString(uploadPortletRequest, "noidunglast"))){
			noidung = noidung + "<div class=\"contentlast\">";
			noidung = noidung + ParamUtil.getString(uploadPortletRequest, "noidunglast");
			noidung = noidung + "</div>";
		}
		article.setContent(noidung);
		
		article.setDelete_status(0);
		
		article.setModifiedby(themeDisplay.getUserId());
		article.setStatus(3);
		News_Log objLog = TinTucAdminUtil.requestobjLog(article);
		objLog.setNoidungxuly("Xuất bản");
		objLog.setNguoixulyid(themeDisplay.getUserId());
		objLog.setNguoinhanid(0);
		objLog.setStatus(3);
		News_LogLocalServiceUtil.addNews_Log(objLog);
		
		News_ArticleLocalServiceUtil.updateNews_Article(article);
		
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
					//News_Article2Category article2category = News_Article2CategoryLocalServiceUtil.fetchNews_Article2Category(Long.valueOf(category_id[b]));
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
		
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);
		PortletURL redirectURL = PortletURLFactoryUtil.create(
				PortalUtil.getHttpServletRequest(actionRequest), portletName,
				themeDisplay.getLayout().getPlid(),
				PortletRequest.RENDER_PHASE);
		actionRequest.setAttribute("tintucobject", article);
		redirectURL.setParameter("tabs", "Đăng tin");
		actionResponse.sendRedirect(redirectURL.toString());
	}
}
