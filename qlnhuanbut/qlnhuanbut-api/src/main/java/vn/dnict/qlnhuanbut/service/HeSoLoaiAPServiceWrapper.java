/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HeSoLoaiAPService}.
 *
 * @author dnict
 * @see HeSoLoaiAPService
 * @generated
 */
public class HeSoLoaiAPServiceWrapper
	implements HeSoLoaiAPService, ServiceWrapper<HeSoLoaiAPService> {

	public HeSoLoaiAPServiceWrapper(HeSoLoaiAPService heSoLoaiAPService) {
		_heSoLoaiAPService = heSoLoaiAPService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _heSoLoaiAPService.getOSGiServiceIdentifier();
	}

	@Override
	public HeSoLoaiAPService getWrappedService() {
		return _heSoLoaiAPService;
	}

	@Override
	public void setWrappedService(HeSoLoaiAPService heSoLoaiAPService) {
		_heSoLoaiAPService = heSoLoaiAPService;
	}

	private HeSoLoaiAPService _heSoLoaiAPService;

}