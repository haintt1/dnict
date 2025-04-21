package vn.dnict.qlgopy.portlet;

import vn.dnict.qlgopy.constants.QuanLyTSPortletKeys;
import vn.dnict.qlgopy.model.GopY_DinhKem;
import vn.dnict.qlgopy.model.HoiDapGopY;
import vn.dnict.qlgopy.model.emailTemplate;
import vn.dnict.qlgopy.service.GopY_DinhKemLocalServiceUtil;
import vn.dnict.qlgopy.service.HoiDapGopYLocalServiceUtil;
import vn.dnict.qlgopy.service.emailTemplateLocalService;
import vn.dnict.qlgopy.service.emailTemplateLocalServiceUtil;
import vn.dnict.qlgopy.utils.DocumentUpload;
import vn.dnict.qlgopy.utils.QuanLyToaSoanConfig;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.jsoup.Jsoup;
import org.osgi.service.component.annotations.Component;

/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=Góp ý tòa soạn",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/admin/view.jsp",
		"javax.portlet.name=" + QuanLyTSPortletKeys.QLADMIN,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QuanLyToaSoanAdminPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	private void sendEmail(String mailnhan, String tieude, String answerContent) {
		try {
			// Tạo mail biên tập viên
			MailMessage message = new MailMessage();
			message.setFrom(new InternetAddress("your-sender@example.com"));
			message.setTo(new InternetAddress(mailnhan));
			message.setSubject("Đã trả lời - " + tieude);
			message.setBody("Nội dung phản hồi\n\n" + answerContent);
			message.setHTMLFormat(false); // Đặt định dạng email là HTML
	        
	        // Gửi mail biên tập viên
	        MailServiceUtil.sendEmail(message);
		} catch (Exception e) {
			log.error("Gửi email thất bại", e);
		}
	}
	
	public void sendEmailTemplate2(String maildocgia, String tieude, String templatePath, String hoten, String cauhoi, String noidungphanhoi) {
	    try {
	        // Load template (Assume it's stored in your portlet's resources folder)
//	        String emailTemplate = StringUtil.read(getClass().getClassLoader(), templatePath);
	        String emailTemplate = templatePath;
	        
	        Map<String, String> templateVariables = new HashMap<>();
	        templateVariables.put("hoten", hoten);
	    	templateVariables.put("cauhoi", cauhoi);
	    	templateVariables.put("noidungphanhoi", noidungphanhoi);
	        
	        // Replace template variables
	        for (Map.Entry<String, String> entry : templateVariables.entrySet()) {
	            emailTemplate = emailTemplate.replace("${" + entry.getKey() + "}", HtmlUtil.escape(entry.getValue()));
	        }

	        // Create the email
	        InternetAddress from = new InternetAddress("admin@example.com", "Admin");
	        InternetAddress to = new InternetAddress(maildocgia);

	        MailMessage mailMessage = new MailMessage();
	        mailMessage.setTo(to);
	        mailMessage.setFrom(from);
	        mailMessage.setSubject("Đã trả lời - " + tieude);
	        mailMessage.setBody(emailTemplate);
	        mailMessage.setHTMLFormat(true);

	        // Send the email
	        MailServiceUtil.sendEmail(mailMessage);
	    } catch (Exception e) {
	    	log.error("Gửi email thất bại", e);
	    }
	}

	@ProcessAction(name = "traloiGopY")
	public void traloiGopY(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
			long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
			Date ngaytraGopY = new Date();
			df.format(ngaytraGopY);
			HoiDapGopY traloiGopY = HoiDapGopYLocalServiceUtil.fetchHoiDapGopY(id);
			traloiGopY.setAnswer(ParamUtil.getString(actionRequest,"answer"));
			traloiGopY.setNgay_traloigopy(ngaytraGopY);
			traloiGopY.setIs_traloi(1);
			
			HoiDapGopYLocalServiceUtil.updateHoiDapGopY(traloiGopY);
//			sendEmail(traloiGopY.getEmail(), traloiGopY.getTitle(), traloiGopY.getAnswer());
			List<emailTemplate> templates = emailTemplateLocalServiceUtil.getemailTemplates(-1, -1);
			String noidunggopy = "";
			for(emailTemplate et : templates) {
				if(et.getLoai() == 1) {
					noidunggopy = et.getNoidung();
				}
			}
			sendEmailTemplate2(traloiGopY.getEmail(), traloiGopY.getTitle(), noidunggopy, traloiGopY.getName(), traloiGopY.getTitle(), traloiGopY.getAnswer());
//			System.out.println("Gửi email phản hồi thành công!");
			SessionMessages.add(actionRequest, "reply_mail_success");
			String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QuanLyToaSoanConfig.tabLienHeToaSoan);
		    // Lưu giá trị tabs1 vào renderResponse để sử dụng sau khi action hoàn tất
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
//			System.out.println("Có lỗi xảy ra khi trả lời hoặc gửi email.");
			SessionErrors.add(actionRequest, "reply_mail_failure");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/lienheadmin/detail.jsp");
		}
	}
	
	@ProcessAction(name = "xoaGopY")
	public void xoaGopY(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				List<GopY_DinhKem> listDinhKem = DocumentUpload.getLinkdinhkembyIdAndObject(id, 1);
				if(listDinhKem.size() > 0){
					for(int c = 0; c < listDinhKem.size(); c++){
						boolean flag = DocumentUpload.deleteFile(themeDisplay, listDinhKem.get(c).getTen());
						if(flag){
							GopY_DinhKemLocalServiceUtil.deleteGopY_DinhKem(listDinhKem.get(c));
						}
					}
				}
				HoiDapGopYLocalServiceUtil.deleteHoiDapGopY(id);
				String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QuanLyToaSoanConfig.tabLienHeToaSoan);
			    // Lưu giá trị tabs1 vào renderResponse để sử dụng sau khi action hoàn tất
			    actionResponse.setRenderParameter("tabs1", selectedTab);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage(), e);
			}	
		}
	}
	
	@ProcessAction(name = "phanHoiTin")
	public void phanHoiTin(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
			long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
			Date ngayPhanHoi = new Date();
			df.format(ngayPhanHoi);
			HoiDapGopY docgia = HoiDapGopYLocalServiceUtil.fetchHoiDapGopY(id);
			docgia.setAnswer(ParamUtil.getString(actionRequest,"answer"));
			docgia.setNgay_traloigopy(ngayPhanHoi);
			docgia.setIs_pheduyet(1);
			
			HoiDapGopYLocalServiceUtil.updateHoiDapGopY(docgia);
//			sendEmail(docgia.getEmail(), docgia.getTitle(),docgia.getAnswer());
			List<emailTemplate> templates = emailTemplateLocalServiceUtil.getemailTemplates(-1, -1);
			String noidungphanhoi = "";
			for(emailTemplate et : templates) {
				if(et.getLoai() == 2) {
					noidungphanhoi = et.getNoidung();
				}
			}
			sendEmailTemplate2(docgia.getEmail(), docgia.getTitle(), noidungphanhoi, docgia.getName(), docgia.getTitle(),  docgia.getAnswer());
//			System.out.println("Gửi email phản hồi thành công!");
			SessionMessages.add(actionRequest, "send_mail_success");
			String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QuanLyToaSoanConfig.tabKetNoiToaSoan);
		    // Lưu giá trị tabs1 vào renderResponse để sử dụng sau khi action hoàn tất
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
//			System.out.println("Có lỗi xảy ra khi trả lời hoặc gửi email.");
			SessionErrors.add(actionRequest, "send_mail_failure");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/ketnoiadmin/detail.jsp");
		}
	}
	
	@ProcessAction(name = "xoaTinDocGia")
	public void xoaTinDocGia(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		if(Validator.isNotNull(id)){
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			try {
				List<GopY_DinhKem> listDinhKem = DocumentUpload.getLinkdinhkembyIdAndObject(id, 1);
				if(listDinhKem.size() > 0){
					for(int c = 0; c < listDinhKem.size(); c++){
						boolean flag = DocumentUpload.deleteFile(themeDisplay, listDinhKem.get(c).getTen());
						if(flag){
							GopY_DinhKemLocalServiceUtil.deleteGopY_DinhKem(listDinhKem.get(c));
						}
					}
				}
				HoiDapGopYLocalServiceUtil.deleteHoiDapGopY(id);
			    String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QuanLyToaSoanConfig.tabKetNoiToaSoan);
			    // Lưu giá trị tabs1 vào renderResponse để sử dụng sau khi action hoàn tất
			    actionResponse.setRenderParameter("tabs1", selectedTab);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage(), e);
			}	
		}
	}
	@ProcessAction(name = "resetTimKiem")
	public void resetTimKiem(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.removeAttribute("cauhoi");
		actionRequest.removeAttribute("ngaytao_tungay");
		actionRequest.removeAttribute("ngaytao_denngay");
		actionRequest.removeAttribute("trangthai");
		actionRequest.removeAttribute("cauhoi");
	}
	
	public void sendEmailTemplate(String toEmail, String subject, String templatePath, Map<String, String> templateVariables) {
	    try {
	        // Load template (Assume it's stored in your portlet's resources folder)
	        String emailTemplate = StringUtil.read(getClass().getClassLoader(), templatePath);

	        // Replace template variables
	        for (Map.Entry<String, String> entry : templateVariables.entrySet()) {
	            emailTemplate = emailTemplate.replace("${" + entry.getKey() + "}", HtmlUtil.escape(entry.getValue()));
	        }

	        // Create the email
	        InternetAddress from = new InternetAddress("admin@example.com", "Admin");
	        InternetAddress to = new InternetAddress(toEmail);

	        MailMessage mailMessage = new MailMessage();
	        mailMessage.setTo(to);
	        mailMessage.setFrom(from);
	        mailMessage.setSubject(subject);
	        mailMessage.setBody(emailTemplate);
	        mailMessage.setHTMLFormat(true);

	        // Send the email
	        MailServiceUtil.sendEmail(mailMessage);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		Map<String, String> variables = new HashMap<>();
//		variables.put("userName", "John Doe");
//		variables.put("companyName", "Example Corp");
//
//		sendEmailTemplate("beu123k@gmail.com", "Welcome to Example Corp!", "email_template.html", variables);
//		super.doView(renderRequest, renderResponse);
//	}
	
	public boolean isLoaiExists(int loai) {
		DynamicQuery query = emailTemplateLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("loai").eq(loai));
		List<emailTemplate> results = emailTemplateLocalServiceUtil.dynamicQuery(query);
	    return !results.isEmpty();
	}
	
	@ProcessAction(name = "saveTemplate")
	public void saveTemplate(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = CounterLocalServiceUtil.increment(emailTemplate.class.getName());
			int loaitemplate = ParamUtil.getInteger(actionRequest, "loaitemplate");
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			// Gọi service để kiểm tra loại đã tồn tại chưa
	        boolean isExists = isLoaiExists(loaitemplate);
	        
	        if (isExists) {
	            SessionErrors.add(actionRequest, "have_data_same");
	            actionResponse.setRenderParameter("mvcPath", "/html/admin/cauhinhmail/add.jsp");
	            return; // Không tiếp tục lưu
	        }
			
			emailTemplate template = emailTemplateLocalServiceUtil.createemailTemplate(id);
			template.setCompanyId(themeDisplay.getCompanyId());
			template.setGroupId(themeDisplay.getScopeGroupId());
			template.setTen(ParamUtil.getString(actionRequest,"ten"));
			template.setNoidung(ParamUtil.getString(actionRequest,"noidung"));
			template.setLoai(ParamUtil.getInteger(actionRequest, "loaitemplate"));
			
			emailTemplateLocalServiceUtil.addemailTemplate(template);
			
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "save_template_failure");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/cauhinhmail/add.jsp");
		}
	}
	
	@ProcessAction(name = "editTemplate")
	public void editTemplate(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
			emailTemplate template = emailTemplateLocalServiceUtil.fetchemailTemplate(id);
			template.setTen(ParamUtil.getString(actionRequest,"ten"));
			template.setNoidung(ParamUtil.getString(actionRequest,"noidung"));
			template.setLoai(ParamUtil.getInteger(actionRequest, "loaitemplate"));
			
			emailTemplateLocalServiceUtil.updateemailTemplate(template);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "edit_template_failure");
			actionResponse.setRenderParameter("mvcPath", "/html/admin/cauhinhmail/edit.jsp");
		}
	}
	
	@ProcessAction(name = "xoaTemplateEmail")
	public void xoaTemplateEmail(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		long id = ParamUtil.getLong(actionRequest, "id", GetterUtil.DEFAULT_LONG);
		try {
			emailTemplateLocalServiceUtil.deleteemailTemplate(id);
			String selectedTab = ParamUtil.getString(actionRequest, "tabs1", QuanLyToaSoanConfig.tabCauHinhMail);
		    // Lưu giá trị tabs1 vào renderResponse để sử dụng sau khi action hoàn tất
		    actionResponse.setRenderParameter("tabs1", selectedTab);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}