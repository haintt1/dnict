package vn.dnict.tintuc.utils;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_BinhLuanLocalServiceUtil;

public class TintucGuestUtil {
	
	public static String subStringTotal(String str, int indx){
		String strtmp = "";
		if(Validator.isNotNull(str) && indx > 0){
			strtmp = str.substring(0, indx + 1);
			int inttmp = 0;
			inttmp = strtmp.lastIndexOf(" ");
			strtmp = strtmp.substring(0, inttmp);
		}
		return strtmp;
	}
	
	public static List<News_Article> listTintuc(String tieude, String dinhdanh, String chuyenmuc, int start, int end) throws Exception{
		DynamicQuery query = News_ArticleLocalServiceUtil.dynamicQuery();
		if(!tieude.equals("")){
			Criterion creterion = RestrictionsFactoryUtil.ilike("title",
					StringPool.PERCENT + tieude + StringPool.PERCENT);
			query.add(creterion);
		}
		if(!dinhdanh.equals("") && Validator.isNumber(dinhdanh)){
			query.add(PropertyFactoryUtil.forName("id").eq(Long.valueOf(dinhdanh)));
		}		
		if(!chuyenmuc.equals("") && Long.valueOf(chuyenmuc) > 0){
			query.add(PropertyFactoryUtil.forName("id")
					.in(News_Article2CategoryLocalServiceUtil.dynamicQuery()
							.add(PropertyFactoryUtil.forName("newcategoryId")
									.eq(Long.valueOf(chuyenmuc)))
							.setProjection(PropertyFactoryUtil.forName("newarticleId"))));
		}
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
//		query.addOrder(OrderFactoryUtil.desc("id"));
		query.addOrder(OrderFactoryUtil.desc("createdtime"));
		if(end!=0){
			query.setLimit(start, end);
		}
		List<News_Article> listArticle = News_ArticleLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(listArticle) || listArticle.size() <= 0){
			listArticle = new ArrayList<News_Article>();
		}
		return listArticle;
	}
	
	public static int getCur(ActionRequest actionRequest, ActionResponse actionResponse) {
		int cur = ParamUtil.getInteger(actionRequest, "cur");
		actionRequest.setAttribute("cur", cur);
		//System.out.println(cur);
		return cur;
	}
	
	public static List<News_BinhLuan> getObjBinhLuan(long ArticleId) throws Exception {
		DynamicQuery query = News_BinhLuanLocalServiceUtil.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("newarticleId").eq(ArticleId));
		query.add(PropertyFactoryUtil.forName("status").eq(1));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("id"));
		query.setLimit(0, 5);
		List<News_BinhLuan> objBinhLuan = News_BinhLuanLocalServiceUtil.dynamicQuery(query);
		if(Validator.isNull(objBinhLuan) || objBinhLuan.size() <= 0){
			objBinhLuan = new ArrayList<News_BinhLuan>();
		}
		return objBinhLuan;
		
	}
	
}
