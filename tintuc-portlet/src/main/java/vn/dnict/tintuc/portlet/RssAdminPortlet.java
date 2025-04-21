package vn.dnict.tintuc.portlet;

import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.utils.RssUtil;
import vn.dnict.tintuc.utils.TinTucAdminUtil;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.osgi.service.component.annotations.Component;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author HueNN
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.icon=/images/",
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RSS",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/tintucadmin/rss/view.jsp",
		"javax.portlet.name=" + TinTucAdminPortletKeys.RSS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RssAdminPortlet extends MVCPortlet {


	@SuppressWarnings({ "deprecation", "unused" })
	public void createRSS(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String fileName = "";
		SimpleDateFormat Df = new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z");
		try {
			List<News_Categories> listcat = TinTucAdminUtil.getAllCate();
			for (News_Categories cate : listcat){
				fileName = RssUtil.removeAccent(cate.getName().replace(" ", "_").toLowerCase().toString()) + "-rss.xml";
				String path = PropsUtil.get("root.dir") + "/rss/";
				System.out.println(path);
				File filePath = new File(path);
				if (!filePath.exists()){
				    
				    boolean result = false;

				    try{
				    	File folder = new File(path);
				    	folder.mkdirs();
				        result = true;
				    } 
				    catch(SecurityException se){
				    	System.out.println("loi tao file ");
				    } 
				    if(result) {    
				        System.out.println("DIR created");  
				    }
				}
				
				String local = path + fileName;				
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				//System.out.println(cate.getId());
				List<News_Article> listRss = RssUtil.getListRSS(cate.getId(), 0, 20);
				for (News_Article rs : listRss) {
					String link = "";
					String trangchitiet = actionRequest.getParameter ("trangchitiet");
					
					
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Document document = documentBuilder.newDocument();
					
					Element rootElement = document.createElement("rss");
					document.appendChild(rootElement);
					
		            Attr attr2 = document.createAttribute("xmlns:dc");
		            attr2.setValue("http://purl.org/dc/elements/1.1/");
		            Attr attr = document.createAttribute("version");
		            attr.setValue("2.0");
		            rootElement.setAttributeNode(attr2);
		            rootElement.setAttributeNode(attr);
					
					
					Element child = document.createElement("channel");
					rootElement.appendChild(child);
					
					Element title0 = document.createElement("title");
					title0.appendChild(document.createTextNode(cate.getName()));
					child.appendChild(title0);
					
					Element links = document.createElement("link");
					child.appendChild(links);
					
					Element description = document.createElement("description");
					child.appendChild(description);
					for(int a=0; a < listRss.size(); a++) {
						
						link = themeDisplay.getURLHome() + trangchitiet + "?dinhdanh=" + listRss.get(a).getId() + "&cat=" + cate.getId();
						Element item = document.createElement("item");
						child.appendChild(item);
						//System.out.println("aaa"+item);
						
						
						Element title = document.createElement("title");
						title.appendChild(document.createTextNode(listRss.get(a).getTitle()));
						item.appendChild(title);
						
						Element link1 = document.createElement("link");
						link1.appendChild(document.createTextNode(link));
						item.appendChild(link1);
						
						Element description1 = document.createElement("description");
						description1.appendChild(document.createTextNode(listRss.get(a).getInfo()));
						item.appendChild(description1);
						
						Element pubDate = document.createElement("pubDate");
						pubDate.appendChild(document.createTextNode(Df.format(listRss.get(a).getCreatedtime())));
						item.appendChild(pubDate);
						
						Element guid = document.createElement("guid");
						guid.appendChild(document.createTextNode(link));
						item.appendChild(guid);
						
						Element dcdate = document.createElement("dc:date");
						dcdate.appendChild(document.createTextNode(String.valueOf(listRss.get(a).getCreatedtime())));
						item.appendChild(dcdate);
					}
					//FileOutputStream outputStream = new FileOutputStream(local);
					
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
		            Transformer transformer = transformerFactory.newTransformer();
		            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		            DOMSource source = new DOMSource(document);
					StreamResult result = new StreamResult(new FileOutputStream(local));	
					transformer.transform(source, result);
				
				}			
				SessionMessages.add(actionRequest, "success-update");
				actionResponse.setRenderParameter("jspPage", "/html/tintucadmin/rss/view.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
		}
	
	}
	
	
}