package demoajax.portlet;

import demoajax.constants.DemoajaxPortletKeys;

import com.demo.model.DemoDB;
import com.demo.service.DemoDBLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.io.PrintWriter;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ProcessAction;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.captcha.util.CaptchaUtil;


/**
 * @author Mai Lan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Demoajax",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/SimpleCaptcha.jsp",
		"javax.portlet.name=" + DemoajaxPortletKeys.DEMOAJAX,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SendData extends MVCPortlet {
	 		
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
//	    
//	    String resourceID = resourceRequest.getResourceID();
//
//	    JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
//
//	    if ("ajaxAction1".equals(resourceID)) {
//	        String param1 = ParamUtil.getString(resourceRequest, "param1");
//	        String param2 = ParamUtil.getString(resourceRequest, "param2");
//	        
//	        System.out.println("Ajax 1: " + param1 + ", " + param2);
//	        
//	        jsonResponse.put("status", "success");
//	        jsonResponse.put("message", "Response from AJAX 1");
//	    } 
//	    else if ("ajaxAction2".equals(resourceID)) {
//	        String paramA = ParamUtil.getString(resourceRequest, "paramA");
//	        String paramB = ParamUtil.getString(resourceRequest, "paramB");
//
//	        System.out.println("Ajax 2: " + paramA + ", " + paramB);
//	        
//	        jsonResponse.put("status", "success");
//	        jsonResponse.put("message", "Response from AJAX 2");
//	    }
//
//	    // Gửi response
//	    resourceResponse.setContentType("application/json");
//	    PrintWriter writer = resourceResponse.getWriter();
//	    writer.write(jsonResponse.toString());
//	    writer.flush();
//	    writer.close();
//	}
	
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
// 
//		// Retrieving the submited data using ParamUtil.
//		double firstInput = ParamUtil.getDouble(resourceRequest, "firstInput");
//		double secondInput = ParamUtil.getDouble(resourceRequest, "secondInput");
//		
//		// Calculating the sum.
//		double sum = firstInput + secondInput;
//		
//		// Creating a JSON object which will contain the sum.
//		JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
//		jsonResponse.put("result", sum);
//		
//		// Writing the result in resourceResponse writer.
//		PrintWriter writer = resourceResponse.getWriter();
//		writer.println(jsonResponse);
//		
//	}
	
	@ProcessAction(name = "saveData")
	public void saveData(ActionRequest actionRequest, ActionResponse actionResponse) 
	        throws PortalException, IOException {

	    String typeaction = ParamUtil.getString(actionRequest, "typeaction");
	    long id = ParamUtil.getLong(actionRequest, "id", 0);
	    String ten = ParamUtil.getString(actionRequest, "ten");
	    String moTa = ParamUtil.getString(actionRequest, "moTa");

	    // Nếu có ID thì lấy từ DB, nếu không thì tạo mới
	    DemoDB demodb = (id > 0) ? DemoDBLocalServiceUtil.getDemoDB(id)
	                             : DemoDBLocalServiceUtil.createDemoDB(CounterLocalServiceUtil.increment());

	    // Gán dữ liệu
	    demodb.setTen(ten);
	    demodb.setMoTa(moTa);

	    // Nếu là "luu", cập nhật vào DB
	    if ("luu".equals(typeaction)) {
	        if (id > 0) {
	            DemoDBLocalServiceUtil.updateDemoDB(demodb);
	        } else {
	            DemoDBLocalServiceUtil.addDemoDB(demodb);
	        }
	    } 
	    // Nếu là "preview", lưu vào DB (nếu chưa có) và trả về JSON chứa ID
	    else {
	    	if (id > 0) {
	            DemoDBLocalServiceUtil.updateDemoDB(demodb);
	        } else {
	            DemoDBLocalServiceUtil.addDemoDB(demodb);
	        }

	        JSONObject json = JSONFactoryUtil.createJSONObject();
	        json.put("id", demodb.getId());

	        HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);
	        response.setContentType("application/json");
	        PrintWriter writer = response.getWriter();
	        writer.write(json.toString());
	        writer.flush();
	        writer.close();
	    }
	}
	
	private Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@ProcessAction(name = "basicFormDataWithCaptcha")
	public void basicFormDataWithCaptcha(ActionRequest actionRequest, ActionResponse actionResponse)
	    throws IOException, PortletException, CaptchaException {

	    String firstName = ParamUtil.getString(actionRequest,"firstName");
	    String lastName=ParamUtil.getString(actionRequest,"lastName");
	    log.info("First Name : " + firstName);
	    log.info("Last Name : " + lastName);

//	    try{
//	        CaptchaUtil.check(actionRequest);
//	        log.info("CAPTCHA verification successful.");
//	    }catch(Exception exception) {
//	        if(exception instanceof CaptchaTextException) {
//	            SessionErrors.add(actionRequest, exception.getClass(), exception);
//	            log.error("CAPTCHA verification failed.");
//	        }
//	    }
	    try {
	        CaptchaUtil.check(actionRequest);
	        SessionMessages.add(actionRequest, "binhluanthanhcong");
	        log.info("CAPTCHA verification successful.");
	    } catch (CaptchaTextException e) {
	        SessionErrors.add(actionRequest, CaptchaTextException.class);
	        log.error("CAPTCHA verification failed.");
//	        SessionErrors.add(actionRequest, "captcha.failed");
	    }
	}

//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//	    throws  IOException, PortletException {
//	    try {
//	        CaptchaUtil.serveImage(resourceRequest, resourceResponse);
//	    }catch(Exception exception) {
//	        log.error(exception.getMessage(), exception);
//	    }
//	}
//
//	protected boolean isCheckMethodOnProcessAction() {
//	    return _CHECK_METHOD_ON_PROCESS_ACTION;
//	}
//	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

}