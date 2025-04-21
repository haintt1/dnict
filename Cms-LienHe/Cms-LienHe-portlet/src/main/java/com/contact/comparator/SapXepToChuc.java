package com.contact.comparator;

import com.contact.model.ToChuc;
import com.liferay.portal.kernel.util.OrderByComparator;

public class SapXepToChuc extends OrderByComparator<ToChuc> {
	
	public static String ORDER_BY_ASC = "ToChuc.ten ASC";
	public static String ORDER_BY_DESC = "ToChuc.ten DESC";
	
	private boolean _ascending;
	
	public SapXepToChuc(boolean ascending) {
        _ascending = ascending;
    }

	@Override
	public int compare(ToChuc o1, ToChuc o2) {
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
