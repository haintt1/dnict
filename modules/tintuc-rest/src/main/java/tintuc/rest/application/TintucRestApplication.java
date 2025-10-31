package tintuc.rest.application;

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
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import tintuc.rest.data.ChuyenMucData;
import tintuc.rest.data.DinhKemData;
import tintuc.rest.data.TinTucData;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.model.News_Categories;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalService;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_AttachFileLocalServiceUtil;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;

/**
 * @author Dell
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/cms-api",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=CmsTinTuc.Rest"
	},
	service = Application.class
)
public class TintucRestApplication extends Application {

	private static final Log _log = LogFactoryUtil.getLog(TintucRestApplication.class);
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Reference
	private News_ArticleLocalService  news_ArticleLocalService;

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}
	
	// Lấy danh sách chuyên mục
	@GET
	@Path("/chuyenmuc/{chuyenMucId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getChuyenMucList(
			@PathParam("chuyenMucId") long chuyenMucId,
			@QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
	    try {
	    	
	    	int start = (page - 1) * pageSize;
	        int end = page * pageSize;
	        
	        DynamicQuery subQuery = News_Article2CategoryLocalServiceUtil.dynamicQuery()
	                .add(PropertyFactoryUtil.forName("newcategoryId").eq(chuyenMucId))
	                .setProjection(ProjectionFactoryUtil.property("newarticleId"));
	        
	        DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery()
	        		.add(PropertyFactoryUtil.forName("id").in(subQuery));
	        
	        query.add(PropertyFactoryUtil.forName("status").eq(3));
	        query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
	        
	        // Query riêng cho count
	        DynamicQuery queryCount = News_ArticleLocalServiceUtil.dynamicQuery()
	        		.add(PropertyFactoryUtil.forName("id").in(subQuery));
	        queryCount.add(PropertyFactoryUtil.forName("delete_status").eq(0));
	        
	        // Lấy total count (theo điều kiện delete_status = 0)
	        long total = News_ArticleLocalServiceUtil.dynamicQueryCount(queryCount);
	        
	        List<News_Article> listTinTuc = News_ArticleLocalServiceUtil.dynamicQuery(query, start, end);
	        
	        // Map sang DTO TinTucData
	        List<TinTucData> data = listTinTuc.stream()
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
	@Path("/tintuc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTintucList(
			@QueryParam("isNoiBat") Long isNoiBat,
			@QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("pageSize") @DefaultValue("10") int pageSize) {
	    try {
	    	
	    	int start = (page - 1) * pageSize;
	        int end = page * pageSize;
	        
//	        List<News_Article> listTinTuc = news_ArticleLocalService.getNews_Articles(start, end);
//	        int total = news_ArticleLocalService.getNews_ArticlesCount();
	        
	        DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
	        if (isNoiBat != null) {
	        	query.add(RestrictionsFactoryUtil.eq("isnoibat", isNoiBat));
	        }
	        query.add(PropertyFactoryUtil.forName("status").eq(3));
	        query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
	        
	        // Query riêng cho count
	        DynamicQuery queryCount = News_ArticleLocalServiceUtil.dynamicQuery();
	        if (isNoiBat != null) {
	        	queryCount.add(RestrictionsFactoryUtil.eq("isnoibat", isNoiBat));
	        }
	        queryCount.add(PropertyFactoryUtil.forName("delete_status").eq(0));
	        
	        // Lấy total count (theo điều kiện delete_status = 0)
	        long total = News_ArticleLocalServiceUtil.dynamicQueryCount(queryCount);
	        
	        List<News_Article> listTinTuc = News_ArticleLocalServiceUtil.dynamicQuery(query, start, end);
	        
	        // Map sang DTO TinTucData
	        List<TinTucData> data = listTinTuc.stream()
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
	@Path("/tintuc/{tinTucId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTinTucBaiViet(
			@PathParam("tinTucId") long tinTucId ) {
	    try {
	        
	        DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
	        query.add(RestrictionsFactoryUtil.eq("id", tinTucId));
	        query.add(PropertyFactoryUtil.forName("status").eq(3));
	        query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
	        
	        List<News_Article> listTinTuc = News_ArticleLocalServiceUtil.dynamicQuery(query);
	        
	        // Map sang DTO TinTucData
	        List<TinTucData> data = listTinTuc.stream()
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
	
	private TinTucData toData(News_Article news_Article) {
		TinTucData tinTucData = new TinTucData();
		tinTucData.setId(news_Article.getId());
		tinTucData.setTitle(news_Article.getTitle());
		tinTucData.setInfo(news_Article.getInfo());
		tinTucData.setContent(news_Article.getContent());
		tinTucData.setLanguage(news_Article.getLanguage());
		tinTucData.setUrlimagesmall(news_Article.getUrlimagesmall());
		tinTucData.setLuotxem(news_Article.getLuotxem());
		tinTucData.setIsnoibat(news_Article.getIsnoibat());
		Date ngayXuatBan = news_Article.getNgayxuatban();
	    Date ngayKetThuc = news_Article.getNgayketthuc();
	    tinTucData.setNgayxuatban(
	            ngayXuatBan != null ? DATE_FORMAT.format(ngayXuatBan) : null
	        );
	        tinTucData.setNgayketthuc(
	            ngayKetThuc != null ? DATE_FORMAT.format(ngayKetThuc) : null
	        );
//		tinTucData.setNgayxuatban(DATE_FORMAT.format(news_Article.getNgayxuatban()));
//		tinTucData.setNgayketthuc(news_Article.getNgayketthuc());
		tinTucData.setNguontin(news_Article.getNguontin());
		tinTucData.setCongtacvien(news_Article.getCongtacvien());
		tinTucData.setTukhoa(news_Article.getTukhoa());
		tinTucData.setLoaitintuc(news_Article.getLoaitintuc());
		
		List<News_Article2Category> mappings = News_Article2CategoryLocalServiceUtil.getTinTucId(news_Article.getId());
		
		List<ChuyenMucData> chuyenMucs = mappings.stream()
			    .map(m -> {
			        try {
			            News_Categories cm = News_CategoriesLocalServiceUtil.getNews_Categories(m.getNewcategoryId());
			            ChuyenMucData cmd = new ChuyenMucData();
			            cmd.setId(cm.getId());
			            cmd.setName(cm.getName());
			            cmd.setLanguage(cm.getLanguage());
			            return cmd;
			        } catch (Exception e) {
			            return null;
			        }
			    })
			    .filter(Objects::nonNull)
			    .collect(Collectors.toList());
		

	    tinTucData.setChuyenmuc(chuyenMucs);
	    
	    List<News_AttachFile> mappingFiles = News_AttachFileLocalServiceUtil.getObjectId(news_Article.getId());
		
		List<DinhKemData> fileDinhKems = mappingFiles.stream()
			    .map(f -> {
			        try {
			        	DinhKemData dk = new DinhKemData();
			        	dk.setId(f.getId());
			            dk.setTen(f.getTen());
			            dk.setUrl(f.getUrl());
			            return dk;
			        } catch (Exception e) {
			            return null;
			        }
			    })
			    .filter(Objects::nonNull)
			    .collect(Collectors.toList());
		

	    tinTucData.setFiledinhkem(fileDinhKems);
	    
		return tinTucData;
	}
}