package vanbanphapquy.rest.application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import vanbanphapquy.rest.data.DinhKemData;
import vanbanphapquy.rest.data.VanBanPhapQuyData;
import vn.dnict.vanbanphapquy.model.Capbanhanh;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;
import vn.dnict.vanbanphapquy.model.Linhvucvanban;
import vn.dnict.vanbanphapquy.model.Loaivanban;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;
import vn.dnict.vanbanphapquy.model.dinhkemfile;
import vn.dnict.vanbanphapquy.service.CapbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.CoquanbanhanhLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LinhvucvanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.LoaivanbanLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.VanbanphapquyLocalServiceUtil;
import vn.dnict.vanbanphapquy.service.dinhkemfileLocalServiceUtil;


/**
 * @author Dell
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/api/v1/vanbanphapquy",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=CwVanBanPhapQuy.Rest"
	},
	service = Application.class
)
public class VanbanphapquyRestApplication extends Application {
	
	private static final Log _log = LogFactoryUtil.getLog(VanbanphapquyRestApplication.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVanBanPhapQuyList(
			@QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
	    try {
	    	
	    	int start = (page - 1) * pageSize;
	        int end = page * pageSize;
	        
	        DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
	        query.add(PropertyFactoryUtil.forName("status").eq(1));
	        
	        // Query riêng cho count
	        DynamicQuery queryCount = VanbanphapquyLocalServiceUtil.dynamicQuery();
	        queryCount.add(PropertyFactoryUtil.forName("status").eq(1));
	        
	        // Lấy total count (theo điều kiện delete_status = 0)
	        long total = VanbanphapquyLocalServiceUtil.dynamicQueryCount(queryCount);
	        
	        List<Vanbanphapquy> listVanBanPhapQuy = VanbanphapquyLocalServiceUtil.dynamicQuery(query, start, end);
	        
	        // Map sang DTO TinTucData
	        List<VanBanPhapQuyData> data = listVanBanPhapQuy.stream()
	            .map(this::toData)
	            .collect(Collectors.toList());
	        
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> result = new LinkedHashMap<>();
	        Map<String, Object> pagination = new LinkedHashMap<>();
	        pagination.put("page", page);
	        pagination.put("pageSize", pageSize);
	        pagination.put("total", total);
	        result.put("data", data);
	        result.put("pagination", pagination);

	        return Response.ok(mapper.writeValueAsString(result)).build();

	    } catch (Exception e) {
	        _log.error(e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity(Collections.singletonMap("error", e.getMessage()))
	            .build();
	    }
	}
	
	@GET
	@Path("/{vanBanPhapQuyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChiTiet(
			@PathParam("vanBanPhapQuyId") long vanBanPhapQuyId ) {
	    try {
	        
	        DynamicQuery query = VanbanphapquyLocalServiceUtil.dynamicQuery();
	        query.add(RestrictionsFactoryUtil.eq("id", vanBanPhapQuyId));
	        query.add(PropertyFactoryUtil.forName("status").eq(1));
	        
	        List<Vanbanphapquy> listVanBanPhapQuy = VanbanphapquyLocalServiceUtil.dynamicQuery(query);
	        
	        // Map sang DTO TinTucData
	        List<VanBanPhapQuyData> data = listVanBanPhapQuy.stream()
	            .map(this::toData)
	            .collect(Collectors.toList());
	        
	        ObjectMapper mapper = new ObjectMapper();
	        Map<String, Object> result = new LinkedHashMap<>();
	        result.put("data", data);

	        return Response.ok(mapper.writeValueAsString(result)).build();

	    } catch (Exception e) {
	        _log.error(e);
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	            .entity(Collections.singletonMap("error", e.getMessage()))
	            .build();
	    }
	}
	
	private VanBanPhapQuyData toData(Vanbanphapquy vanbanphapquy) {
		VanBanPhapQuyData vanBanPhapQuyData = new VanBanPhapQuyData();
		Date ngayBanHanh = vanbanphapquy.getNgay_banhanh();
	    Date ngayHieuLuc = vanbanphapquy.getNgay_hieuluc();
	    Date ngayHetHieuLuc = vanbanphapquy.getNgay_hethieuluc();
	    Date ngayXuatBan = vanbanphapquy.getNgay_xuatban();
		vanBanPhapQuyData.setId(vanbanphapquy.getId());
		vanBanPhapQuyData.setSohieu(vanbanphapquy.getSohieu());
		vanBanPhapQuyData.setTrichyeu(vanbanphapquy.getTrichyeu());
		vanBanPhapQuyData.setNoidung(vanbanphapquy.getNoidung());
		vanBanPhapQuyData.setNgaybanhanh(ngayBanHanh != null ? DATE_FORMAT.format(ngayBanHanh) : null);
		vanBanPhapQuyData.setNgayhieuluc(ngayHieuLuc != null ? DATE_FORMAT.format(ngayHieuLuc) : null);
		vanBanPhapQuyData.setNgayhethieuluc(ngayHetHieuLuc != null ? DATE_FORMAT.format(ngayHetHieuLuc) : null);
		vanBanPhapQuyData.setNgayxuatban(ngayXuatBan != null ? DATE_FORMAT.format(ngayXuatBan) : null);
		Linhvucvanban linhvucvanban = LinhvucvanbanLocalServiceUtil.fetchLinhvucvanban(vanbanphapquy.getId_linhvuc());
		Loaivanban loaivanban = LoaivanbanLocalServiceUtil.fetchLoaivanban(vanbanphapquy.getId_loaivanban());
		Capbanhanh capbanhanh = CapbanhanhLocalServiceUtil.fetchCapbanhanh(vanbanphapquy.getId_capbanhanh());
		Coquanbanhanh coquanbanhanh = CoquanbanhanhLocalServiceUtil.fetchCoquanbanhanh(vanbanphapquy.getId_coquanbanhanh());
		vanBanPhapQuyData.setLinhvuc(linhvucvanban.getName());
		vanBanPhapQuyData.setLoaivanban(loaivanban.getName());
		vanBanPhapQuyData.setCapbanhanh(capbanhanh.getName());
		vanBanPhapQuyData.setCoquanbanhanh(coquanbanhanh.getName());
		vanBanPhapQuyData.setNguoiky(vanbanphapquy.getNguoiky());
		vanBanPhapQuyData.setKieuvanban(vanbanphapquy.getType());
		
	    List<dinhkemfile> mappingFiles = dinhkemfileLocalServiceUtil.getObjectId(vanbanphapquy.getId());
		
		List<DinhKemData> fileDinhKems = mappingFiles.stream()
			    .map(f -> {
			        try {
			        	DinhKemData dk = new DinhKemData();
			            dk.setTen(f.getTen());
			            dk.setUrl(f.getUrl());
			            return dk;
			        } catch (Exception e) {
			            return null;
			        }
			    })
			    .filter(Objects::nonNull)
			    .collect(Collectors.toList());
		
		vanBanPhapQuyData.setFiledinhkem(fileDinhKems);
	    
		return vanBanPhapQuyData;
	}

}