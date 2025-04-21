/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.impl;

import com.contact.model.CanBo;
import com.contact.service.base.CanBoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.contact.model.CanBo",
	service = AopService.class
)
public class CanBoLocalServiceImpl extends CanBoLocalServiceBaseImpl {
	public List<CanBo> findByten(String ten) {
		return canBoPersistence.findByten(ten);
	}
	public List<CanBo> getCanBos(int start, int end, OrderByComparator<CanBo> comparator) {
		return canBoPersistence.findAll(start,end,comparator);
	}
}