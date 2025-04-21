/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ToChucService}.
 *
 * @author Brian Wing Shun Chan
 * @see ToChucService
 * @generated
 */
public class ToChucServiceWrapper
	implements ServiceWrapper<ToChucService>, ToChucService {

	public ToChucServiceWrapper(ToChucService toChucService) {
		_toChucService = toChucService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _toChucService.getOSGiServiceIdentifier();
	}

	@Override
	public ToChucService getWrappedService() {
		return _toChucService;
	}

	@Override
	public void setWrappedService(ToChucService toChucService) {
		_toChucService = toChucService;
	}

	private ToChucService _toChucService;

}