package cms.quanlyvideo.comparator;

import cms.quanlyvideo.model.ChuDe;
import com.liferay.portal.kernel.util.OrderByComparator;

public class SapXepChuDe extends OrderByComparator<ChuDe> {

	public static String ORDER_BY_ASC = "ChuDe.ten ASC";
	public static String ORDER_BY_DESC = "ChuDe.ten DESC";

	private boolean _ascending;

	public SapXepChuDe(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(ChuDe o1, ChuDe o2) {
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
