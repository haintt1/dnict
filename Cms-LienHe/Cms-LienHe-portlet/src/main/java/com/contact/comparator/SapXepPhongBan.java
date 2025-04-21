package com.contact.comparator;

import com.contact.model.PhongBan;
import com.liferay.portal.kernel.util.OrderByComparator;

public class SapXepPhongBan extends OrderByComparator<PhongBan> {
	
	public static String ORDER_BY_ASC = "PhongBan.ten ASC";
	public static String ORDER_BY_DESC = "PhongBan.ten DESC";
	
	private boolean _ascending;
	
	public SapXepPhongBan(boolean ascending) {
        _ascending = ascending;
    }

	@Override
	public int compare(PhongBan o1, PhongBan o2) {
		String name1 = o1.getTen();
		String name2 = o2.getTen();
		int value = name1.compareToIgnoreCase(name2);
		
//		if(value == 0) {
//			// If names are equal, compare by position
//            String desc1 = o1.getDptDesc();
//            String desc2 = o2.getDptDesc();
//            value = desc1.compareToIgnoreCase(desc2);
//		}
		
//        if (_ascending) {
//            return value;
//        } else {
//            return -value;
//        }
		return _ascending ? value: -value;
	}
	
	@Override
    public String getOrderBy() {
        return _ascending ? ORDER_BY_ASC : ORDER_BY_DESC;
    }
}
