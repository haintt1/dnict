package vn.dnict.tintuc.portlet;

import java.io.OutputStream;

import javax.portlet.Portlet;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.PropsUtil;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import vn.dnict.tintuc.constants.TinTucAdminPortletKeys;

@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.hidden",
			"com.liferay.portlet.header-portlet-javascript=/js/jquery.js",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.icon=/images/",
			"com.liferay.portlet.add-default-resource=true",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=Thống kê tin tức",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/html/thongketintuc/view.jsp",
			"javax.portlet.name=" + TinTucAdminPortletKeys.THONGKETINTUCADMIN,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class		
)
public class ThongKeTinTucPortlet extends MVCPortlet{
	
	public void thongkesoluongtheouser(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		String path = PropsUtil.get("root.dir") + "/attachment/";	
//		String local = path + "soluongbaiviettheouser.xlsx";	
		resourceResponse.setContentType("application/vnd.ms-excel;charset=UTF-8");
		resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL,
				"max-age=3600, must-revalidate");
		resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=SoLuongBaivietTheochuyenmuc.xls");
		OutputStream outputStream = resourceResponse.getPortletOutputStream();
		WritableWorkbook wb = Workbook.createWorkbook(outputStream);
		WritableSheet sheet = wb.createSheet("Sheet 1", 0);
		WritableCellFormat headerFormat = new WritableCellFormat();
		WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
		headerFormat.setFont(font);
		headerFormat.setAlignment(Alignment.CENTRE);
		headerFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
		headerFormat.getBorder(Border.ALL);
		headerFormat.setWrap(true);
		Label headerLabel = new Label(0,0,"THỐNG KÊ SỐ LƯỢNG BÀI VIẾT THEO USER", headerFormat);
		sheet.mergeCells(0, 0, 10, 0);
		sheet.setColumnView(0, 60);		
		sheet.addCell(headerLabel);
		headerLabel = new Label(0, 2, "Stt");
		sheet.setColumnView(0, 60);
		sheet.addCell(headerLabel);
		headerLabel = new Label(1, 2, "Người đăng tin");
		sheet.setColumnView(0, 40);
		sheet.addCell(headerLabel);
		headerLabel = new Label(2, 2, "Số lượng bài viết");
		sheet.setColumnView(0, 40);
		sheet.addCell(headerLabel);
		
		wb.write();
		outputStream.flush();
		//wb.close();
	}
}
