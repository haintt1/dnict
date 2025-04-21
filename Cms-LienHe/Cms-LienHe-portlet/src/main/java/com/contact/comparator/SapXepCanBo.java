package com.contact.comparator;

import com.contact.model.CanBo;
import com.liferay.portal.kernel.util.OrderByComparator;

public class SapXepCanBo extends OrderByComparator<CanBo> {
	
	public static String ORDER_BY_ASC = "CanBo.ten ASC";
	public static String ORDER_BY_DESC = "CanBo.ten DESC";
	
	private boolean _ascending;
	
	public SapXepCanBo(boolean ascending) {
        _ascending = ascending;
    }

	@Override
	public int compare(CanBo o1, CanBo o2) {
		String name1 = o1.getTen();
		String name2 = o2.getTen();
		int value = name1.compareToIgnoreCase(name2);

        if (_ascending) {
            return value;
        } else {
            return -value;
        }
	}
	
	@Override
    public String getOrderBy() {
        return _ascending ? ORDER_BY_ASC : ORDER_BY_DESC;
    }
}
