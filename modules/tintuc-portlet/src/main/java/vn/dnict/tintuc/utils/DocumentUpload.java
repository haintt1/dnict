/**
 * 
 */
package vn.dnict.tintuc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import com.liferay.document.library.kernel.exception.NoSuchFolderException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.service.News_AttachFileLocalServiceUtil;

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.display-category=category.hidden",
				"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
				"com.liferay.portlet.header-portlet-css=/css/main.css",
				"com.liferay.portlet.icon=/images/",
				"com.liferay.portlet.add-default-resource=true",
				"com.liferay.portlet.instanceable=true",
				"javax.portlet.security-role-ref=administrator,user"
		},
		service = Portlet.class
)
public class DocumentUpload extends MVCPortlet{
	
	       

	
	private static String ROOT_FOLDER_NAME =  PropsUtil.get("fileupload.cmsdnict.folder.name"); 
	private static String ROOT_FOLDER_DESCRIPTION =PropsUtil.get("fileupload.cmsdnict.folder.description");
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;   
	
	
	
	public static ServiceContext getServiceContext(User admin) throws Exception {
		
		if (admin == null) {
	        throw new IllegalArgumentException("User admin không được null");
	    }

		//System.out.println("admin: "+ admin);
		PrincipalThreadLocal.setName(admin.getUserId());
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(admin);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);
		
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setUserId(admin.getUserId());
		
		return serviceContext;
	}
		
	public static User getAdministrator(final long companyId) {
	    try {
	        Role role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
	        List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
	        
	        if (!adminUsers.isEmpty()) {
	            // Return the first admin user, or you might want to add more specific selection logic
	            return adminUsers.get(0);
	        }
	    } catch (Exception e) {

	    }
	    
	    // If no admin is found, throw an exception instead of returning null
	    throw new IllegalStateException("No administrator found for company ID: " + companyId);
	}
	
	 public static Role getRoleById(final long companyId, final String roleStrId) {
	        try {
	            return RoleLocalServiceUtil.getRole(companyId, roleStrId);
	        } catch (final Exception e) {
	        	System.out.println(e.getMessage());
	        }
	        return null;
	    }


	public static boolean isFolderExist(ThemeDisplay themeDisplay){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
			//System.out.println("Folder is already Exist");
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
	}
	
	public static Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay)
	{
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
				folder = DLAppServiceUtil.addFolder(repositoryId,PARENT_FOLDER_ID, ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		}
		return folder;
	}
	
	public static Folder getFolder(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
		
	}
	
	public static Folder getFolder(ThemeDisplay themeDisplay){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
		
	}
	
	public static boolean isFileExist(ThemeDisplay themeDisplay, String title, String ROOT_FOLDER_NAME){
		boolean fileExist = false;
		try {
			DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), getFolder(themeDisplay, ROOT_FOLDER_NAME).getFolderId(), title);
			fileExist = true;
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return fileExist;
	}
	
	public static DLFolder getFolderWidthDLFolder(ThemeDisplay themeDisplay){
		DLFolder folder = null;
		try {
//			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			List<DLFolder> dlFolders = DLFolderLocalServiceUtil.getDLFolders(0, DLFolderLocalServiceUtil.getDLFoldersCount());
			for (DLFolder folder_tmp : dlFolders) {
				if(folder_tmp.getName().equals(ROOT_FOLDER_NAME)){
					folder = folder_tmp;
				}
			}
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
	}
	
	public static List<News_AttachFile> getLinkdinhkembyIdAndObject(long id, long Object, ThemeDisplay themeDisplay) throws Exception {
		DynamicQuery query = News_AttachFileLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("daxoa").eq(0));
		query.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
		query.add(PropertyFactoryUtil.forName("companyId").eq(themeDisplay.getCompanyId()));
		query.add(PropertyFactoryUtil.forName("ObjectId").eq(id));
		query.add(PropertyFactoryUtil.forName("Object").eq(Object));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<News_AttachFile> listFiledinhkem = News_AttachFileLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listFiledinhkem) || listFiledinhkem.size() <= 0){
			listFiledinhkem = new ArrayList<News_AttachFile>();
		}
		if(listFiledinhkem.size() > 0){
			for(int i = 0;i<listFiledinhkem.size();i++) {
				if(listFiledinhkem.get(i).equals("")){
					String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
							getFolderWidthDLFolder(themeDisplay).getFolderId() +  "/" +listFiledinhkem.get(i).getTen();
					listFiledinhkem.get(i).setUrl(url);					
				}
			}
		}
		return listFiledinhkem;
	}
	
	public static List<News_AttachFile> getLinkImagebyIdAndObject(long id, long Object) throws Exception {
		DynamicQuery query = News_AttachFileLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("daxoa").eq(0));
		query.add(PropertyFactoryUtil.forName("ObjectId").eq(id));
		query.add(PropertyFactoryUtil.forName("Object").eq(Object));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<News_AttachFile> listFiledinhkem = News_AttachFileLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listFiledinhkem) || listFiledinhkem.size() <= 0){
			listFiledinhkem = new ArrayList<News_AttachFile>();
		}
		return listFiledinhkem;
	}	
	
	public static List<News_AttachFile> getLinkdinhkembyIdAndObject(long id, long Object) throws Exception {
		DynamicQuery query = News_AttachFileLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("daxoa").eq(0));
		query.add(PropertyFactoryUtil.forName("ObjectId").eq(id));
		query.add(PropertyFactoryUtil.forName("Object").eq(Object));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<News_AttachFile> listFiledinhkem = News_AttachFileLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listFiledinhkem) || listFiledinhkem.size() <= 0){
			listFiledinhkem = new ArrayList<News_AttachFile>();
		}
		return listFiledinhkem;
	}	
	
	@SuppressWarnings("unused")
	public static List<String> CoreFileDinhKemUploadPDF(ThemeDisplay themeDisplay, UploadPortletRequest uploadRequest, String ROOT_FOLDER_NAME, String ROOT_FOLDER_DESCRIPTION, String nameInput) throws Exception
	{		
		DateFormat df = new SimpleDateFormat("ddMMyyyhhmmss");
		List<String> result = new ArrayList<String>();
		File file = uploadRequest.getFile(nameInput);
		String fileName = uploadRequest.getFileName(nameInput);		
		
		Folder folder = getFolder(themeDisplay, ROOT_FOLDER_NAME);
		if(Validator.isNotNull(file)){
				FileEntry fileEntry;
				String title, description, mimeType;
				String nameFile = "";
					try {
						File fileItem = file;
						
						if(Validator.isNotNull(fileItem) && fileItem.isFile()){
							title = fileName;
							description = title +" is added via programatically";
							mimeType = MimeTypesUtil.getContentType(fileItem);
							String name_ext = "";
							
							if(isFileExist(themeDisplay,title, ROOT_FOLDER_NAME)){
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								nameFile = title.replace(name_ext,"")+"_"+df.format(now)+name_ext;								
							}else{
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								nameFile = title;
							}
					    	try {
								long companyId = themeDisplay.getCompanyId();
								
								User admin = getAdministrator(companyId);
								//System.out.println(companyId);
								ServiceContext serviceContext = getServiceContext(admin);
								fileEntry = DLAppLocalServiceUtil.addFileEntry(admin.getUserId(),
										themeDisplay.getScopeGroupId(), folder.getFolderId(), nameFile, mimeType,
										nameFile, nameFile, "", fileItem, serviceContext);
								String url ="/documents/" + themeDisplay.getScopeGroupId() + "/" + 
										folder.getFolderId() +  "/" +nameFile;
								
								result.add(nameFile);
								result.add(url);
								result.add(String.valueOf(folder.getFolderId()));
					    	} catch (PortalException e) {
								e.printStackTrace();
							} catch (SystemException e) {
								e.printStackTrace();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		}
		return result;
	}
	
	////////////////////////
	
	public static Folder createFolderMedia(long groupId, String folderName, ServiceContext serviceContext) throws PortalException
	{
		try {
            return (Folder) DLAppLocalServiceUtil.getFolder(groupId, 0, folderName);
        } catch (NoSuchFolderException nsfe) {
            return (Folder) DLAppLocalServiceUtil.addFolder(
            	serviceContext.getUserId(),
                groupId,
                0, // parentFolderId
                folderName,
                "This folder is create for CmsDnict documents",
                serviceContext
            );
        }
	}
	
	@SuppressWarnings("unused")
	public static List<String> CoreFileDinhKemUploadVideo(ThemeDisplay themeDisplay, UploadPortletRequest uploadRequest, String nameInput) throws Exception
	{		
		DateFormat df = new SimpleDateFormat("ddMMyyyhhmmss");
		List<String> result = new ArrayList<String>();
		File file = uploadRequest.getFile(nameInput);
		String fileName = uploadRequest.getFileName(nameInput);
		
		if(Validator.isNotNull(file)){
				FileEntry fileEntry;
				String title, description, mimeType;
				String nameFile = "";
					try {
						File fileItem = file;
						
						if(Validator.isNotNull(fileItem) && fileItem.isFile()){
							title = fileName;
							description = title +" is added via programatically";
							mimeType = MimeTypesUtil.getContentType(fileItem);
							String name_ext = "";
							
							if(fileItem.exists()){
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								nameFile = title.replace(name_ext,"")+"_"+df.format(now)+name_ext;								
							}else{
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								nameFile = title;
							}
					    	try {
								long companyId = themeDisplay.getCompanyId();
								
								User admin = getAdministrator(companyId);
								if (admin == null) {
						            throw new IllegalStateException("No administrator found for company ID: " + companyId);
						        }
								//System.out.println(companyId);
								ServiceContext serviceContext = getServiceContext(admin);
								
								Folder folder = createFolderMedia(themeDisplay.getScopeGroupId(), "CmsDnict_Media", serviceContext);
								
								fileEntry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), themeDisplay.getScopeGroupId(), 
										folder.getFolderId(), nameFile, mimeType, nameFile, nameFile, "", fileItem, serviceContext);
								
								String url ="/documents/" + themeDisplay.getScopeGroupId() + "/" + 
										folder.getFolderId() +  "/" +nameFile;
								
								result.add(nameFile);
								result.add(url);
								result.add(String.valueOf(folder.getFolderId()));
					    	} catch (PortalException e) {
								e.printStackTrace();
							} catch (SystemException e) {
								e.printStackTrace();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
		}
		return result;
	}
	
	public static boolean deleteFileVideo(ThemeDisplay themeDisplay, String title) throws Exception{
		Folder folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, "CmsDnict_Media");
		long repositoryId;
		boolean flag = false;
		repositoryId = themeDisplay.getScopeGroupId();
		//System.out.println("repositoryId: "+repositoryId);
		try {
			DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), title);
			flag = true;
		}catch (PortalException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	/////////////////////////
	
	public static boolean deleteFile(ThemeDisplay themeDisplay, String title) throws Exception{
		Folder folder = getFolder(themeDisplay);
		long repositoryId;
		boolean flag = false;
		repositoryId = themeDisplay.getScopeGroupId();
		//System.out.println("repositoryId: "+repositoryId);
		try {
			DLAppServiceUtil.deleteFileEntryByTitle(repositoryId, folder.getFolderId(), title);
			flag = true;
		}catch (PortalException e) {
			e.printStackTrace();
		}
		return flag;
		
	}
	
	public static void uploadDocument(ActionRequest actionRequest) throws IOException,PortletException, PortalException, SystemException 
	{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		createFolder(actionRequest, themeDisplay);
		fileUpload(themeDisplay, actionRequest);
	}
	
	public static void fileUpload(ThemeDisplay themeDisplay,ActionRequest actionRequest)
	{
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
      
		String fileName=uploadPortletRequest.getFileName("uploadedFile");		 			
		File file = uploadPortletRequest.getFile("uploadedFile");
		String mimeType = uploadPortletRequest.getContentType("uploadedFile");
                    String title = fileName;
		String description = "This file is added via programatically";
		long repositoryId = themeDisplay.getScopeGroupId();
		//System.out.println("Title=>"+title);
	    try
	    {  
	    	Folder folder = getFolder(themeDisplay);
	    	ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    	InputStream is = new FileInputStream( file );
	    	DLAppServiceUtil.addFileEntry(repositoryId, folder.getFolderId(), fileName, mimeType, 
	    			title, description, "", is, file.getTotalSpace(), serviceContext);
	    	
	     } catch (Exception e)
	    {
	       System.out.println(e.getMessage());
	    	e.printStackTrace();
	    }

	}
	
}
