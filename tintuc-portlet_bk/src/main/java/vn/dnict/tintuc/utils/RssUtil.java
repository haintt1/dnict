package vn.dnict.tintuc.utils;

import java.util.Arrays;
import java.util.List;



import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;

import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.service.News_Article2CategoryLocalServiceUtil;
import vn.dnict.tintuc.service.News_ArticleLocalServiceUtil;
import vn.dnict.tintuc.service.News_CategoriesLocalServiceUtil;

public class RssUtil {
	
	private static char[] SPECIAL_CHARACTERS = { ' ', '!', '"', '#', '$', '%',
	        '*', '+', ',', ':', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
	        '`', '|', '~', };

	private static char[] REPLACEMENTS = { '-', '\0', '\0', '\0', '\0', '\0',
	        '\0', '_', '\0', '_', '\0', '\0', '\0', '\0', '\0', '\0', '_',
	        '\0', '\0', '\0', '\0', '\0', 'A', 'A', 'A', 'A', 'E', 'E', 'E',
	        'I', 'I', 'O', 'O', 'O', 'O', 'U', 'U', 'Y', 'a', 'a', 'a', 'a',
	        'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u', 'y', 'A',
	        'a', 'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u', 'A', 'a',
	        'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
	        'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e', 'E', 'e',
	        'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'I',
	        'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o',
	        'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
	        'o', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u',
	        'U', 'u', };
		 
	 public static String toUrlFriendly(String s) {
			    int maxLength = Math.min(s.length(), 236);
			    char[] buffer = new char[maxLength];
			    int n = 0;
			    for (int i = 0; i < maxLength; i++) {
			        char ch = s.charAt(i);
			        buffer[n] = removeAccent(ch);
			        // skip not printable characters
			        if (buffer[n] > 31) {
			            n++;
			        }
			    }
			    // skip trailing slashes
			    while (n > 0 && buffer[n - 1] == '/') {
			        n--;
			    }
			    return String.valueOf(buffer, 0, n);
	}

	public static char removeAccent(char ch) {
			    int index = Arrays.binarySearch(SPECIAL_CHARACTERS, ch);
			    if (index >= 0) {
			        ch = REPLACEMENTS[index];
			    }
			    return ch;
	}
			 
	public static String removeAccent(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, removeAccent(sb.charAt(i)));
		}
		return sb.toString();
	}

	public static List<News_Article> getListRSS(long categoryId, int start, int end) throws Exception {
		DynamicQuery query  = News_ArticleLocalServiceUtil.dynamicQuery();
		DynamicQuery query2 = News_CategoriesLocalServiceUtil.dynamicQuery();
		DynamicQuery query3 = News_Article2CategoryLocalServiceUtil.dynamicQuery();
		if(categoryId >0){
			query2.add(PropertyFactoryUtil.forName("id").eq(categoryId));
		}
		query2.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query2.setProjection(PropertyFactoryUtil.forName("id"));
		
		query3.add(PropertyFactoryUtil.forName("newcategoryId").in(query2));

		query3.setProjection(PropertyFactoryUtil.forName("newarticleId"));
		
		query.add(PropertyFactoryUtil.forName("id").in(query3));
		//query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.add(PropertyFactoryUtil.forName("status").eq(3));
		query.add(PropertyFactoryUtil.forName("delete_status").eq(0));
		query.addOrder(OrderFactoryUtil.desc("modifiedtime"));
		if(end !=0){
			query.setLimit(start, end);
		}

		List<News_Article> list = News_ArticleLocalServiceUtil.dynamicQuery(query);
		return list;
	}
}
