package demoajax.portlet;

import java.util.Arrays;
import java.util.List;

public class QuanLyToaSoanConfig {
	public static String tabLienHeToaSoan = "Liên hệ tòa soạn";
	public static String tabKetNoiToaSoan = "Kết nối tòa soạn";

	public static String value_tabLienHeToaSoan = "lienhetoasoan";
	public static String value_tabKetNoiToaSoan = "ketnoitoasoan";
	
	public static final List<String> tabNames = Arrays.asList(
        "Liên hệ tòa soạn", 
        "Kết nối tòa soạn",
        "Tin tức nội bộ",
        "Hỗ trợ kỹ thuật"
    );

    public static final List<String> tabValues = Arrays.asList(
        "lienhetoasoan", 
        "ketnoitoasoan",
        "tintucnoibo",
        "hotrokithuat"
    );
}
