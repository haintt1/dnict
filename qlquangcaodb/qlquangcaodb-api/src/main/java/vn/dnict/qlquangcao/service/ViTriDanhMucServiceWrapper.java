/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ViTriDanhMucService}.
 *
 * @author dnict
 * @see ViTriDanhMucService
 * @generated
 */
public class ViTriDanhMucServiceWrapper
	implements ServiceWrapper<ViTriDanhMucService>, ViTriDanhMucService {

	public ViTriDanhMucServiceWrapper(ViTriDanhMucService viTriDanhMucService) {
		_viTriDanhMucService = viTriDanhMucService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _viTriDanhMucService.getOSGiServiceIdentifier();
	}

	@Override
	public ViTriDanhMucService getWrappedService() {
		return _viTriDanhMucService;
	}

	@Override
	public void setWrappedService(ViTriDanhMucService viTriDanhMucService) {
		_viTriDanhMucService = viTriDanhMucService;
	}

	private ViTriDanhMucService _viTriDanhMucService;

}