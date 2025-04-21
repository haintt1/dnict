/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HoiDapGopYService}.
 *
 * @author dnict
 * @see HoiDapGopYService
 * @generated
 */
public class HoiDapGopYServiceWrapper
	implements HoiDapGopYService, ServiceWrapper<HoiDapGopYService> {

	public HoiDapGopYServiceWrapper(HoiDapGopYService hoiDapGopYService) {
		_hoiDapGopYService = hoiDapGopYService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hoiDapGopYService.getOSGiServiceIdentifier();
	}

	@Override
	public HoiDapGopYService getWrappedService() {
		return _hoiDapGopYService;
	}

	@Override
	public void setWrappedService(HoiDapGopYService hoiDapGopYService) {
		_hoiDapGopYService = hoiDapGopYService;
	}

	private HoiDapGopYService _hoiDapGopYService;

}