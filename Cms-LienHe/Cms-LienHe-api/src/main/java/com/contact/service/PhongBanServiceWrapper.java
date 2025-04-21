/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PhongBanService}.
 *
 * @author Brian Wing Shun Chan
 * @see PhongBanService
 * @generated
 */
public class PhongBanServiceWrapper
	implements PhongBanService, ServiceWrapper<PhongBanService> {

	public PhongBanServiceWrapper(PhongBanService phongBanService) {
		_phongBanService = phongBanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _phongBanService.getOSGiServiceIdentifier();
	}

	@Override
	public PhongBanService getWrappedService() {
		return _phongBanService;
	}

	@Override
	public void setWrappedService(PhongBanService phongBanService) {
		_phongBanService = phongBanService;
	}

	private PhongBanService _phongBanService;

}