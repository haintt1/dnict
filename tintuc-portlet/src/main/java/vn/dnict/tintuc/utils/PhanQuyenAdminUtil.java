package vn.dnict.tintuc.utils;

import java.util.List;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;

import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.service.News_roleLocalServiceUtil;

public class PhanQuyenAdminUtil {

	public static List<User> getUsers(){
		DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("defaultUser").eq(Boolean.FALSE));
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		List<User> results = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("re"+ results.size());
		return results;	
	}
	
	public static List<User> getUsersByID(long idUser){
		DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
		dynamicQuery.add(PropertyFactoryUtil.forName("defaultUser").eq(Boolean.FALSE));
		if(Validator.isNotNull(idUser)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("id").eq(idUser));
		}
		dynamicQuery.add(PropertyFactoryUtil.forName("status").eq(0));
		List<User> results = UserLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println("re"+ results.size());
		return results;	
	}
	
	public static List<News_role> listPhanquyen() throws Exception{
		DynamicQuery query = News_roleLocalServiceUtil.dynamicQuery();
		query.addOrder(OrderFactoryUtil.asc("id"));
		List<News_role> list = News_roleLocalServiceUtil.dynamicQuery(query);
		return list;
	}
	
	public static News_role getUserById(long idUser){
		News_role new_role = null;
		DynamicQuery dynamicQuery = News_roleLocalServiceUtil.dynamicQuery();
		if(Validator.isNotNull(idUser)) {
			dynamicQuery.add(PropertyFactoryUtil.forName("userid").eq(idUser));
		}
		dynamicQuery.addOrder(OrderFactoryUtil.asc("id"));
		
		List<News_role> results = News_roleLocalServiceUtil.dynamicQuery(dynamicQuery);
		//System.out.println(results);
		if(results.size() > 0)
		{
			new_role = results.get(0);
		}
		return new_role;
		
	}
}
