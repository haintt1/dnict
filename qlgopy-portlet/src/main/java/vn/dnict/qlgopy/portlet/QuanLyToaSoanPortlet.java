package vn.dnict.qlgopy.portlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailService;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.qlgopy.constants.QuanLyTSPortletKeys;
import vn.dnict.qlgopy.model.GopY_DinhKem;
import vn.dnict.qlgopy.model.HoiDapGopY;
import vn.dnict.qlgopy.model.emailTemplate;
import vn.dnict.qlgopy.service.GopY_DinhKemLocalServiceUtil;
import vn.dnict.qlgopy.service.HoiDapGopYLocalServiceUtil;
import vn.dnict.qlgopy.service.emailTemplateLocalServiceUtil;
import vn.dnict.qlgopy.utils.DocumentUpload;
import vn.dnict.qlgopy.utils.QuanLyToaSoanConfig;


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=DNICT",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Liên hệ/Kết nối Tòa soạn",
			"javax.portlet.init-param.config-template=/html/user/configuration.jsp",
			"javax.portlet.init-param.view-template=/html/user/view.jsp",
			"javax.portlet.name=" + QuanLyTSPortletKeys.TOASOAN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)

public class QuanLyToaSoanPortlet extends MVCPortlet {
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());
		
	private void sendEmail(String[] mailbientap, String maildocgia, String tieude, String templatePathBTV, String templatePathDG) {
		try {
			InternetAddress[] bientaps = new InternetAddress[mailbientap.length];
			for (int i = 0; i < mailbientap.length; i++) {
				bientaps[i] = new InternetAddress(mailbientap[i]);
	        }
			
			String emailTemplate = templatePathBTV;
			// Load template (Assume it's stored in your portlet's resources folder)
//	        String emailTemplate = StringUtil.read(getClass().getClassLoader(), "email_template.html");
	        
	    	Map<String, String> templateVariables = new HashMap<>();
	    	templateVariables.put("maildocgia", maildocgia);
	        
	        // Replace template variables
	        for (Map.Entry<String, String> entry : templateVariables.entrySet()) {
	            emailTemplate = emailTemplate.replace("${" + entry.getKey() + "}", HtmlUtil.escape(entry.getValue()));
	        }
			
			// Tạo mail biên tập viên
			MailMessage bientapvien = new MailMessage();
			bientapvien.setFrom(new InternetAddress("your-sender@example.com","Admin"));
			bientapvien.setTo(bientaps);
			bientapvien.setSubject("Tin độc giả gửi tới - " + tieude);
//			bientapvien.setBody("Chào biên tập viên,\n\nCó tin độc giả gửi tới tòa soạn của email "+maildocgia+"\n\nVui lòng kiểm tra tin độc giả để phản hồi sớm nhất có thể nhé!");
			bientapvien.setBody(emailTemplate);
			bientapvien.setHTMLFormat(true); // Đặt định dạng email là HTML
	        
	        // Gửi mail biên tập viên
	        MailServiceUtil.sendEmail(bientapvien);
	        
	        // Load template (Assume it's stored in your portlet's resources folder)
//	        String emailTemplatedocgia = StringUtil.read(getClass().getClassLoader(), "templatedocgia.html");
	        String emailTemplatedocgia = templatePathDG;
	        
	        // Tạo mail biên tập viên
 			MailMessage docgia = new MailMessage();
 			docgia.setFrom(new InternetAddress("your-sender@example.com","Admin"));
 			docgia.setTo(new InternetAddress(maildocgia));
 			docgia.setSubject("Xác nhận gửi bài thành công - " + tieude);
// 			docgia.setBody("Chào bạn,\n\nBài viết của bạn đã được gửi thành công tới tòa soạn. Cảm ơn bạn đã đóng góp!");
 			docgia.setBody(emailTemplatedocgia);
 			docgia.setHTMLFormat(true); // Đặt định dạng email là HTML
 	        
 	        // Gửi mail biên tập viên
 	        MailServiceUtil.sendEmail(docgia);
		} catch (Exception e) {
			log.error("Gửi email thất bại", e);
		}
	}
	
	@ProcessAction(name = "addQuestion")
	public void addQuestion(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		long id = CounterLocalServiceUtil.increment(HoiDapGopY.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HoiDapGopY hoiDapGopY = HoiDapGopYLocalServiceUtil.createHoiDapGopY(id);
		hoiDapGopY.setId(id);
		hoiDapGopY.setCompanyId(themeDisplay.getCompanyId());
		hoiDapGopY.setGroupId(themeDisplay.getScopeGroupId());
		hoiDapGopY.setName(ParamUtil.getString(actionRequest,"name"));
		hoiDapGopY.setEmail(ParamUtil.getString(actionRequest,"email"));
		hoiDapGopY.setTitle(ParamUtil.getString(actionRequest,"title"));
		hoiDapGopY.setContent(ParamUtil.getString(actionRequest,"content"));
		Date ngayGuiGopY = new Date();
		df.format(ngayGuiGopY);
		hoiDapGopY.setNgay_guigopy(ngayGuiGopY);
		hoiDapGopY.setTypeForm(1);
		// 0: chua tra loi, 1: da tra loi
		hoiDapGopY.setIs_traloi(0);
		
		List<String> fileNamedinhkem = new ArrayList<String>();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {
			DocumentUpload.createFolder(actionRequest, themeDisplay);
			fileNamedinhkem = DocumentUpload.fileUpload(themeDisplay, uploadRequest,"");
			if(fileNamedinhkem.size() > 0){
				for(String filename_tmp : fileNamedinhkem){
					long idfile = CounterLocalServiceUtil.increment(GopY_DinhKem.class.getName());
					GopY_DinhKem filedinhkem = GopY_DinhKemLocalServiceUtil.createGopY_DinhKem(idfile);
					filedinhkem.setId(idfile);
					filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
					filedinhkem.setObjectId(hoiDapGopY.getId());
					filedinhkem.setTen(filename_tmp);
					filedinhkem.setCompanyId(themeDisplay.getCompanyId());
					filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
					String url = "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
							DocumentUpload.getFolderWidthDLFolder(themeDisplay).getFolderId() +  "/" +filename_tmp;
					filedinhkem.setUrl(url);
					GopY_DinhKemLocalServiceUtil.addGopY_DinhKem(filedinhkem);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HoiDapGopYLocalServiceUtil.addHoiDapGopY(hoiDapGopY);
		actionResponse.sendRedirect("/lien-he");
	}
	
	// For Doc Gia
	@ProcessAction(name = "addTinDocGia")
	public void addTinDocGia(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		long id = CounterLocalServiceUtil.increment(HoiDapGopY.class.getName());
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HoiDapGopY docgia = HoiDapGopYLocalServiceUtil.createHoiDapGopY(id);
		String maildocgia = ParamUtil.getString(actionRequest,"email");
		docgia.setId(id);
		docgia.setCompanyId(themeDisplay.getCompanyId());
		docgia.setGroupId(themeDisplay.getScopeGroupId());
		docgia.setName(ParamUtil.getString(actionRequest,"name"));
		docgia.setTencoquan(ParamUtil.getString(actionRequest,"tencoquan"));
		docgia.setPhone(ParamUtil.getString(actionRequest,"phone"));
		docgia.setEmail(maildocgia);
		docgia.setTitle(ParamUtil.getString(actionRequest,"title"));
		docgia.setContent(ParamUtil.getString(actionRequest,"content"));
		Date ngayGuiGopY = new Date();
		df.format(ngayGuiGopY);
		docgia.setNgay_guigopy(ngayGuiGopY);
		docgia.setTypeForm(2);
		// 0: chua duyet, 1: da duyet
		docgia.setIs_pheduyet(0);
		
		PortletPreferences preferences = actionRequest.getPreferences();
	    String mailthongbao1 = preferences.getValue("mailthongbao1", "");
	    String mailthongbao2 = preferences.getValue("mailthongbao2", "");
	    String mailthongbao3 = preferences.getValue("mailthongbao3", "");
	    
	    // Danh sách tạm để lưu giá trị hợp lệ
	    List<String> validMails = new ArrayList<>();

	    if (!mailthongbao1.isEmpty()) {
	        validMails.add(mailthongbao1);
	    }

	    if (!mailthongbao2.isEmpty()) {
	        validMails.add(mailthongbao2);
	    }

	    if (!mailthongbao3.isEmpty()) {
	        validMails.add(mailthongbao3);
	    }

	    // Chuyển danh sách thành mảng
	    String[] mailArray = validMails.toArray(new String[0]);
	    
		List<String> fileNamedinhkem = new ArrayList<String>();
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		try {	
			DocumentUpload.createFolder(actionRequest, themeDisplay);
			fileNamedinhkem = DocumentUpload.fileUpload(themeDisplay, uploadRequest,"");
			if(fileNamedinhkem.size() > 0){
				for(String filename_tmp : fileNamedinhkem){
					long idfile = CounterLocalServiceUtil.increment(GopY_DinhKem.class.getName());
					GopY_DinhKem filedinhkem = GopY_DinhKemLocalServiceUtil.createGopY_DinhKem(idfile);
					filedinhkem.setId(idfile);
					filedinhkem.setObject(1); // đính kèm mẫu văn bản pháp quy = 1
					filedinhkem.setObjectId(docgia.getId());
					filedinhkem.setTen(filename_tmp);
					filedinhkem.setCompanyId(themeDisplay.getCompanyId());
					filedinhkem.setGroupId(themeDisplay.getScopeGroupId());
					String url = "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
							DocumentUpload.getFolderWidthDLFolder(themeDisplay).getFolderId() +  "/" +filename_tmp;
					filedinhkem.setUrl(url);
					GopY_DinhKemLocalServiceUtil.addGopY_DinhKem(filedinhkem);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HoiDapGopYLocalServiceUtil.addHoiDapGopY(docgia);
//		sendEmail(mailArray, docgia.getEmail(), docgia.getTitle());
		List<emailTemplate> templates = emailTemplateLocalServiceUtil.getemailTemplates(-1, -1);
		String noidungthongbaoBTV = "";
		String noidungthongbaoDG = "";
		for(emailTemplate et : templates) {
			if(et.getLoai() == 3) {
				noidungthongbaoBTV = et.getNoidung();
			}
			if(et.getLoai() == 4) {
				noidungthongbaoDG = et.getNoidung();
			}
		}
		sendEmail(mailArray, docgia.getEmail(), docgia.getTitle(), noidungthongbaoBTV, noidungthongbaoDG);
		
		
		PortletSession session = actionRequest.getPortletSession();
		session.setAttribute("thongbaotindocgia", true, PortletSession.APPLICATION_SCOPE);
		actionResponse.sendRedirect("/ket-noi");
	}
}