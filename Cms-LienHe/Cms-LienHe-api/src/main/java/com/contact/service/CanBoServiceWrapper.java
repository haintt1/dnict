/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CanBoService}.
 *
 * @author Brian Wing Shun Chan
 * @see CanBoService
 * @generated
 */
public class CanBoServiceWrapper
	implements CanBoService, ServiceWrapper<CanBoService> {

	public CanBoServiceWrapper(CanBoService canBoService) {
		_canBoService = canBoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _canBoService.getOSGiServiceIdentifier();
	}

	@Override
	public CanBoService getWrappedService() {
		return _canBoService;
	}

	@Override
	public void setWrappedService(CanBoService canBoService) {
		_canBoService = canBoService;
	}

	private CanBoService _canBoService;

}