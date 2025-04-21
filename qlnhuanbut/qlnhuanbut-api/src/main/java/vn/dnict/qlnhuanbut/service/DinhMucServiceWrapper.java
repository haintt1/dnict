/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DinhMucService}.
 *
 * @author dnict
 * @see DinhMucService
 * @generated
 */
public class DinhMucServiceWrapper
	implements DinhMucService, ServiceWrapper<DinhMucService> {

	public DinhMucServiceWrapper(DinhMucService dinhMucService) {
		_dinhMucService = dinhMucService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dinhMucService.getOSGiServiceIdentifier();
	}

	@Override
	public DinhMucService getWrappedService() {
		return _dinhMucService;
	}

	@Override
	public void setWrappedService(DinhMucService dinhMucService) {
		_dinhMucService = dinhMucService;
	}

	private DinhMucService _dinhMucService;

}