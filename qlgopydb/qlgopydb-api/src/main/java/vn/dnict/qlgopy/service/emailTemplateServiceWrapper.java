/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link emailTemplateService}.
 *
 * @author dnict
 * @see emailTemplateService
 * @generated
 */
public class emailTemplateServiceWrapper
	implements emailTemplateService, ServiceWrapper<emailTemplateService> {

	public emailTemplateServiceWrapper(
		emailTemplateService emailTemplateService) {

		_emailTemplateService = emailTemplateService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _emailTemplateService.getOSGiServiceIdentifier();
	}

	@Override
	public emailTemplateService getWrappedService() {
		return _emailTemplateService;
	}

	@Override
	public void setWrappedService(emailTemplateService emailTemplateService) {
		_emailTemplateService = emailTemplateService;
	}

	private emailTemplateService _emailTemplateService;

}