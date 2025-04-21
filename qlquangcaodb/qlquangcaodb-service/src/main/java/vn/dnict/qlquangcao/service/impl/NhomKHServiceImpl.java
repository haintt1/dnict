/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import vn.dnict.qlquangcao.service.base.NhomKHServiceBaseImpl;

/**
 * @author dnict
 */
@Component(
	property = {
		"json.web.service.context.name=cw",
		"json.web.service.context.path=NhomKH"
	},
	service = AopService.class
)
public class NhomKHServiceImpl extends NhomKHServiceBaseImpl {
}