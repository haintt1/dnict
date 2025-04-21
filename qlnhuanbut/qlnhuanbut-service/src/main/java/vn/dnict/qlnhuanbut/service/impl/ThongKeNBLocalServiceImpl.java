/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import vn.dnict.qlnhuanbut.service.base.ThongKeNBLocalServiceBaseImpl;

/**
 * @author dnict
 */
@Component(
	property = "model.class.name=vn.dnict.qlnhuanbut.model.ThongKeNB",
	service = AopService.class
)
public class ThongKeNBLocalServiceImpl extends ThongKeNBLocalServiceBaseImpl {
}