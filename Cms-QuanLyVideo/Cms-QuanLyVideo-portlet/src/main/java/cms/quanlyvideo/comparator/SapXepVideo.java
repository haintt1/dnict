package cms.quanlyvideo.comparator;

import cms.quanlyvideo.model.Video;
import com.liferay.portal.kernel.util.OrderByComparator;

public class SapXepVideo extends OrderByComparator<Video> {

	public static String ORDER_BY_ASC = "Video.ten ASC";
	public static String ORDER_BY_DESC = "Video.ten DESC";

	private boolean _ascending;

	public SapXepVideo(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Video o1, Video o2) {
		String name1 = o1.getTen();
		String name2 = o2.getTen();
		int value = name1.compareToIgnoreCase(name2);

		return _ascending ? value: -value;
	}

	@Override
	public String getOrderBy() {
		return _ascending ? ORDER_BY_ASC : ORDER_BY_DESC;
	}
}
