/**
 * 
 */
package vn.dnict.tintuc.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HueNN
 *
 */
public class CoreUtil {
	private static String[] SOURCE_CHARACTERS = {"À", "Á", "Â", "Ã", "È", "É",
	        "Ê", "Ì", "Í", "Ò", "Ó", "Ô", "Õ", "Ù", "Ú", "Ý", "à", "á", "â",
	        "ã", "è", "é", "ê", "ì", "í", "ò", "ó", "ô", "õ", "ù", "ú", "ý",
	        "Ă", "ă", "Đ", "đ", "Ĩ", "ĩ", "Ũ", "ũ", "Ơ", "ơ", "Ư", "ư", "Ạ",
	        "ạ", "Ả", "ả", "Ấ", "ấ", "Ầ", "ầ", "Ẩ", "ẩ", "Ẫ", "ẫ", "Ậ", "ậ",
	        "Ắ", "ắ", "Ằ", "ằ", "Ẳ", "ẳ", "Ẵ", "ẵ", "Ặ", "ặ", "Ẹ", "ẹ", "Ẻ",
	        "ẻ", "Ẽ", "ẽ", "Ế", "ế", "Ề", "ề", "Ể", "ể", "Ễ", "ễ", "Ệ", "ệ",
	        "Ỉ", "ỉ", "Ị", "ị", "Ọ", "ọ", "Ỏ", "ỏ", "Ố", "ố", "Ồ", "ồ", "Ổ",
	        "ổ", "Ỗ", "ỗ", "Ộ", "ộ", "Ớ", "ớ", "Ờ", "ờ", "Ở", "ở", "Ỡ", "ỡ",
	        "Ợ", "ợ", "Ụ", "ụ", "Ủ", "ủ", "Ứ", "ứ", "Ừ", "ừ", "Ử", "ử", "Ữ",
	        "ữ", "Ự", "ự",};

		// Mang cac ky tu thay the khong dau
	private static String[] DESTINATION_CHARACTERS = {"A", "A", "A", "A", "E",
	        "E", "E", "I", "I", "O", "O", "O", "O", "U", "U", "Y", "a", "a",
	        "a", "a", "e", "e", "e", "i", "i", "o", "o", "o", "o", "u", "u",
	        "y", "A", "a", "D", "d", "I", "i", "U", "u", "O", "o", "U", "u",
	        "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "A",
	        "a", "A", "a", "A", "a", "A", "a", "A", "a", "A", "a", "E", "e",
	        "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "E", "e", "E",
	        "e", "I", "i", "I", "i", "O", "o", "O", "o", "O", "o", "O", "o",
	        "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O", "o", "O",
	        "o", "O", "o", "U", "u", "U", "u", "U", "u", "U", "u", "U", "u",
	        "U", "u", "U", "u",};
		
		
	public static String removeAccentChar(String ch) {
		int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
	    if (index >= 0) {
	    	ch = DESTINATION_CHARACTERS[index];
	    }
	    return ch;
	}
		 
	public static String removeAccent(String s) {
		StringBuilder sb = new StringBuilder(s);
		String newString = "";
		for (int i = 0; i < s.length(); i++) {
			newString +=  removeAccentChar(Character.toString(sb.charAt(i)));
	    }
		return newString;
	}
		 
	public static String getOnlyStrings(String s) {
		Pattern pattern = Pattern.compile("[^0-9a-zA-Z._]");
		Matcher matcher = pattern.matcher(s);
		String data = matcher.replaceAll("");
			return data;
	}
		 
	public static String getNameCoreAttachmentFinal(String name) {
		String result = "";
		result = name.trim().replaceAll("\\s+", "_");
		result = removeAccent(result);
		result = getOnlyStrings(result);
		return result;
	}
}
