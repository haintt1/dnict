package vn.dnict.tintuc.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_TypeLocalServiceUtil;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_Categories;

public class ThongKeTinTucUtil {

	@SuppressWarnings("deprecation")
	public static List<News_Article> listNews(Long userId, String dateStart, String dateEnd, String thang, Date nam, String quy, String trangthai, int start, int end){
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		SimpleDateFormat sf = new SimpleDateFormat("MM");
		query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userId)));
		if(!thang.equals("") && Long.valueOf(thang) >= 0) {
			query.add(PropertyFactoryUtil.forName("createdtime").eq(sf.format(thang)));
		}
		if(!nam.equals("") && Long.valueOf(nam.getMonth()) >= 0) {
			query.add(PropertyFactoryUtil.forName("createdtime").eq(nam.getYear()));
		}
//		if(!quy.equals("") && Long.valueOf(quy) >= 0) {
//			
//		}
//		if(end !=0) {
//			
//		}
		query.addOrder(OrderFactoryUtil.asc("createdtime"));
		List<News_Article> obj = News_ArticleLocalServiceUtil.dynamicQuery(query);
		//System.out.println(obj);
		return obj;
	}
	
	public static List<News_Article> listTintucAdmin(String checkLang, String userId, String dateStart, String dateEnd, String trangthai, int start, int end) throws Exception{				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!userId.equals("") && Long.valueOf(userId) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userId)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(Validator.isNotNull(dateStart) && !dateStart.equals("")){
			dateStart += " 00:00:00";
			query.add(PropertyFactoryUtil.forName("createdtime").ge(sf.parse(dateStart)));
		}
		if(Validator.isNotNull(dateEnd) && !dateEnd.equals("")){
			dateEnd += " 23:59:59";
			query.add(PropertyFactoryUtil.forName("createdtime").le(sf.parse(dateEnd)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("createdtime"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		//System.out.println(listArticle);
		return listArticle;
	}
	
	public static List<News_Article> listTintucAdminDate(String checkLang, String userId, String date, String trangthai, int start, int end) throws Exception{				
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if(!trangthai.equals("") && Long.valueOf(trangthai) >= 0){
			query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(trangthai)));
		}
		if(!userId.equals("") && Long.valueOf(userId) >= 0){
				query.add(PropertyFactoryUtil.forName("createdby").eq(Long.valueOf(userId)));
		}
		if(!checkLang.equals("")){
			query.add(PropertyFactoryUtil.forName("language").eq(checkLang));
		}
		if(Validator.isNotNull(date) && !date.equals("")){			
			query.add(PropertyFactoryUtil.forName("createdtime").ge(sf.parse(date)));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("createdtime"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		//System.out.println(listArticle);
		return listArticle;
	}
	
	//list Danh sách bài thống kê chi tiết
			public static List<News_Article> thongKeChiTiet(long theloai, long userId,int status, String dateBegin,String dateEnd,int start,int end) throws Exception{
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				if(Validator.isNotNull(userId)){
					query.add(PropertyFactoryUtil.forName("createdby").eq(userId));
				}
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(Validator.isNotNull(theloai) && theloai >= 0){
					query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloai)));
				}
				
				if(end!=0){query.setLimit(start, end);}
				if(status >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(status));
				}
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.addOrder(OrderFactoryUtil.desc("id"));
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			//list Danh sách bài viêt by UserId
			public static List<News_Article> thongKeChiTietByUserId(long userId) throws Exception{
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				if(Validator.isNotNull(userId)){
					query.add(PropertyFactoryUtil.forName("createdby").eq(userId));
				}
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				@SuppressWarnings("unchecked")
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			//list thống kê bài viêt by chuyên mục
		 public static List<HashMap<String, String>> thongKeTheoChuyenMuc(String dateBegin, String dateEnd, String status, int start, int end) throws Exception{
			 
			 List<News_Categories> listnewcategory = TinTucAdminUtil.searchNewCategory("", 0, (long) 0, 0, 0);			 
			 List<HashMap<String, String>> listthongke = new ArrayList<HashMap<String, String>>();			 
			 if(listnewcategory.size()>0){
					for(int i=0;i<listnewcategory.size();i++){ 
						HashMap<String, String> _item = new HashMap<String, String>();
						long coutArticle = TinTucAdminUtil.listTintucByChuyenmuc(listnewcategory.get(i).getId(), status, dateBegin, dateEnd, start, end);
						//System.out.println("anc:" + coutArticle);
						_item.put(String.valueOf(listnewcategory.get(i).getId()),String.valueOf(coutArticle));
						listthongke.add(_item);
					}
				}
				return listthongke;			 
		 }	
		 
		 //list Danh sách bài thống kê chi tiết theo chuyên mục
			public static List<News_Article> thongKeChiTietChuyenMuc(long theloai, long catId,int status, String dateBegin,String dateEnd,int start,int end) throws Exception{
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				if(catId > 0){
					query.add(PropertyFactoryUtil.forName("id")
							.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
									.add(PropertyFactoryUtil.forName("newcategoryId")
											.eq(catId))
									.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
				}
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(Validator.isNotNull(theloai) && theloai >= 0){
					query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloai)));
				}
				
				if(end!=0){query.setLimit(start, end);}
				if(status >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(status));
				}
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.addOrder(OrderFactoryUtil.desc("createdtime"));
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
		
		 
		//list thống kê bài viêt by thể loại
			public static List<News_Article> thongKeChiTietByTheLoai(String dateBegin,String dateEnd, String status, long typeid) throws Exception{
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.add(PropertyFactoryUtil.forName("typeid").eq(typeid));
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(!status.equals("") && Long.valueOf(status) >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
				}
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			
			//list Danh sách bài thống kê chi tiết theo thể loại
			public static List<News_Article> thongKeChiTietTheLoai(long theloai, int status, String dateBegin,String dateEnd,int start,int end) throws Exception{
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");				
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(Validator.isNotNull(theloai) && theloai >= 0){
					query.add(PropertyFactoryUtil.forName("typeid").eq(Long.valueOf(theloai)));
				}				
				if(end!=0){query.setLimit(start, end);}
				if(status >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(status));
				}
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.addOrder(OrderFactoryUtil.desc("createdtime"));
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			
			//list thống kê bài viêt by Tác giả
			public static List<News_Article> thongKeSoLuongByTacGia(String dateBegin,String dateEnd, String status, long nguontin) throws Exception{
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.add(PropertyFactoryUtil.forName("nguontin").eq(nguontin));
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(!status.equals("") && Long.valueOf(status) >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
				}
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			
			//list Danh sách bài thống kê chi tiết theo nguồn tin
			public static List<News_Article> thongKeChiTietNguonTin(long nguontin, int status, String dateBegin,String dateEnd,int start,int end) throws Exception{
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");				
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(Validator.isNotNull(nguontin) && nguontin >= 0){
					query.add(PropertyFactoryUtil.forName("nguontin").eq(Long.valueOf(nguontin)));
				}				
				if(end!=0){query.setLimit(start, end);}
				if(status >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(status));
				}
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.addOrder(OrderFactoryUtil.desc("id"));
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
			
			//list thống kê bài viêt by Kiểu tin
			public static List<News_Article> thongKeSoLuongByKieuTin(int loaitintuc, int status, String dateBegin,String dateEnd, int start, int end ) throws Exception{
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
				query.add(PropertyFactoryUtil.forName("loaitintuc").eq(loaitintuc));
				if(!dateBegin.equals("")){
					dateBegin += " 00:00:00";
					query.add(PropertyFactoryUtil.forName("createdtime").ge(df.parse(dateBegin)));
				}
				if(!dateEnd.equals("")){
					dateEnd += " 23:59:59";
					query.add(PropertyFactoryUtil.forName("createdtime").le(df.parse(dateEnd)));
				}
				if(Long.valueOf(status) >= 0){
					query.add(PropertyFactoryUtil.forName("status").eq(Integer.valueOf(status)));
				}
				List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
				return listArticle;
			}
	
}
