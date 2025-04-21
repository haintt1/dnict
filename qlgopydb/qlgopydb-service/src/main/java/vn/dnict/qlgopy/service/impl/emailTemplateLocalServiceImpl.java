/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import vn.dnict.qlgopy.model.emailTemplate;
import vn.dnict.qlgopy.service.base.emailTemplateLocalServiceBaseImpl;

/**
 * @author dnict
 */
@Component(
	property = "model.class.name=vn.dnict.qlgopy.model.emailTemplate",
	service = AopService.class
)
public class emailTemplateLocalServiceImpl
	extends emailTemplateLocalServiceBaseImpl {
	public List<emailTemplate> findByloai(int loai) {
		return emailTemplatePersistence.findByloai(loai);
	}
}