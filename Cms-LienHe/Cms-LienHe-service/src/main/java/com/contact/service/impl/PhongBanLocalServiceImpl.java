/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.impl;

import com.contact.model.PhongBan;
import com.contact.service.base.PhongBanLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.contact.model.PhongBan",
	service = AopService.class
)
public class PhongBanLocalServiceImpl extends PhongBanLocalServiceBaseImpl {
	public List<PhongBan> findByTen(String ten) {
		return phongBanPersistence.findByten(ten);
	}
	public List<PhongBan> getPhongBans(int start, int end, OrderByComparator<PhongBan> comparator) {
		return phongBanPersistence.findAll(start,end,comparator);
	}
}