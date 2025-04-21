package qlanpham.portlet.utils;

import java.text.Normalizer;
import java.util.Map;
import java.util.HashMap;

public class SlugUtil {
    public static String convertToSlug(String input) {
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        String noDiacritics = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        String hyphenated = noDiacritics.replaceAll("\\s+", "-");
        return hyphenated.replaceAll("[^a-zA-Z0-9-]", "").toLowerCase();
    }
    
//    public static String encodeBase64(String input) throws UnsupportedEncodingException {
//    	String encoded = Base64.getEncoder().encodeToString(input.getBytes("UTF-8"));
//    	return encoded.substring(0,6);
//    }
//    
//    public static String decodeBase64(String input) throws UnsupportedEncodingException {
//    	String decoded = new String(Base64.getDecoder().decode(input.getBytes("UTF-8")));
//    	return decoded;
//    }
    
    private static final Map<String, String> lookupTable = new HashMap<>();
    
    // Phương thức mã hóa chuỗi gốc thành mã rút gọn
    public static String encode(String input) {
        // Tạo mã rút gọn (6 ký tự) từ chuỗi gốc
        String shortCode = Long.toHexString(input.hashCode()).substring(0, 6);
        // Lưu ánh xạ vào bảng tra cứu
        lookupTable.put(shortCode, input);
        return shortCode;
    }
    
    // Phương thức giải mã chuỗi gốc từ mã rút gọn
    public static String decode(String shortCode) {
        // Lấy chuỗi gốc từ bảng tra cứu
        return lookupTable.get(shortCode);
    }
}