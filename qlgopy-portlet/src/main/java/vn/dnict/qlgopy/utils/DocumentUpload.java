package vn.dnict.qlgopy.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;

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
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.qlgopy.model.GopY_DinhKem;
import vn.dnict.qlgopy.service.GopY_DinhKemLocalServiceUtil;


//import vn.dnict.vanbanphapquy.model.Capbanhanh;
//import vn.dnict.vanbanphapquy.model.dinhkemfile;
//import vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil;
//import vn.dnict.vanbanphapquy.service.dinhkemfileLocalServiceUtil;

public class DocumentUpload extends MVCPortlet {
	
	private static String ROOT_FOLDER_NAME = "CmsDnict_Contact";
	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for HoiDap documents";
	private static long PARENT_FOLDER_ID = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	
	public static ServiceContext getServiceContext(User admin) throws Exception {
		PrincipalThreadLocal.setName(admin.getUserId());
		@SuppressWarnings("deprecation")
		PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create(admin);
		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setAddGuestPermissions(true);
		return serviceContext;
	}
	
	public static Role getRoleById(long companyId, String roleStrId) {
		try {
			return RoleLocalServiceUtil.getRole(companyId, roleStrId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static User getAdministrator(long companyId) {
		User ad = null;
		Role role = null;
		try {
			role = getRoleById(companyId, RoleConstants.ADMINISTRATOR);
			for (User admin : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
				ad = admin;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ad;
	}
	
	public static Folder createFolder(ActionRequest actionRequest,ThemeDisplay themeDisplay) throws Exception
	{
        boolean folderExist = isFolderExist(themeDisplay);
        Folder folder = null;
        User admin = getAdministrator(themeDisplay.getCompanyId());
		if (!folderExist) {
			long repositoryId = themeDisplay.getScopeGroupId();		
			try {
				ServiceContext serviceContext = getServiceContext(admin);
				DLAppLocalServiceUtil.addFolder(admin.getUserId(), repositoryId, PARENT_FOLDER_ID,ROOT_FOLDER_NAME,ROOT_FOLDER_DESCRIPTION, serviceContext);
			} catch (PortalException e1) {
				e1.printStackTrace();
			} catch (SystemException e1) {
				e1.printStackTrace();
			}			
		}
		return folder;
	}
	
	public static boolean isFolderExist(ThemeDisplay themeDisplay){
		boolean folderExist = false;
		try {
			DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
			folderExist = true;
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folderExist;
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
	public static Folder getFolder(ThemeDisplay themeDisplay, String ROOT_FOLDER_NAME){
		Folder folder = null;
		try {
			folder =DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(), PARENT_FOLDER_ID, ROOT_FOLDER_NAME);
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return folder;
		
	}	
	public static boolean isFileExist(ThemeDisplay themeDisplay, String title){
		boolean fileExist = false;
		try {
			DLAppServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), getFolder(themeDisplay).getFolderId(), title);
			fileExist = true;
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}
		return fileExist;
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
	
	@SuppressWarnings("unused")
	public static List<String> CoreFileDinhKemUpload(ThemeDisplay themeDisplay,UploadPortletRequest uploadRequest, String ROOT_FOLDER_NAME, String ROOT_FOLDER_DESCRIPTION, String nameInput) throws Exception
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
								ServiceContext serviceContext = getServiceContext(admin);
								fileEntry = DLAppLocalServiceUtil.addFileEntry(admin.getUserId(),
										themeDisplay.getScopeGroupId(), folder.getFolderId(), nameFile, mimeType,
										nameFile, nameFile, "", fileItem, serviceContext);
								String url = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/documents/" + themeDisplay.getScopeGroupId() + "/" + 
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
	
	
	
	
	@SuppressWarnings("unused")
	public static List<String> fileUpload(ThemeDisplay themeDisplay, UploadPortletRequest uploadRequest, String tenguoinop) throws Exception
	{
		DateFormat df = new SimpleDateFormat("ddMMyyyhhmmss");
		List<String> listNameFile = new ArrayList<String>();
		File[] filelist = uploadRequest.getFiles("files[]");
		String[] fileName_list = uploadRequest.getFileNames("files[]");
		if(Validator.isNotNull(filelist) && filelist.length > 0){
			for(int i = 0; i< filelist.length;i++){
				Folder folder = getFolder(themeDisplay);
				FileEntry fileEntry;
				String title, description,mimeType;
				String nameFile = "";
				File fileItem = filelist[i];
					try {
//						File fileItem = uploadRequest.getFile("uploadedFile");	
//						String sourceFileName = uploadRequest.getFileName("uploadedFile");
						if(Validator.isNotNull(fileItem)){
							title = fileName_list[i];
							description = title +" is added via programatically";
							mimeType = MimeTypesUtil.getContentType(fileItem);
							String name_ext = "";
							if(isFileExist(themeDisplay,title)){
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								if(!tenguoinop.equals("")){
									nameFile = title.replace(name_ext,"")+"_"+tenguoinop+"_"+df.format(now)+name_ext;
								}else{
									nameFile = title.replace(name_ext,"")+"_"+df.format(now)+name_ext;
								}
							}else{
								int lastDot = title.lastIndexOf(".");
								name_ext = title.substring(lastDot, title.length());
								Date now = new Date();
								if(!tenguoinop.equals("")){
									nameFile = title.replace(name_ext,"")+"_"+tenguoinop+"_"+name_ext;
								}else{
									nameFile = title;
								}
							}
					    	try {
								long companyId = themeDisplay.getCompanyId();
								User admin = getAdministrator(companyId);
								ServiceContext serviceContext = getServiceContext(admin);
								fileEntry = DLAppLocalServiceUtil.addFileEntry(admin.getUserId(),
										themeDisplay.getScopeGroupId(), folder.getFolderId(), nameFile, mimeType,
										nameFile, nameFile, "", fileItem, serviceContext);
								listNameFile.add(nameFile);
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
		}
		return listNameFile;
	}
	
	public static List<GopY_DinhKem> getLinkdinhkembyIdAndObject(long id, long Object) throws Exception {
		DynamicQuery query = GopY_DinhKemLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("daxoa").eq(0));
		query.add(PropertyFactoryUtil.forName("ObjectId").eq(id));
		query.add(PropertyFactoryUtil.forName("Object").eq(Object));
		query.addOrder(OrderFactoryUtil.desc("id"));
		List<GopY_DinhKem> listFiledinhkem = GopY_DinhKemLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listFiledinhkem) || listFiledinhkem.size() <= 0){
			listFiledinhkem = new ArrayList<GopY_DinhKem>();
		}
		return listFiledinhkem;
	}
	
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
	
}
