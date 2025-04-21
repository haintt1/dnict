/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HeSoTheLoaiService}.
 *
 * @author dnict
 * @see HeSoTheLoaiService
 * @generated
 */
public class HeSoTheLoaiServiceWrapper
	implements HeSoTheLoaiService, ServiceWrapper<HeSoTheLoaiService> {

	public HeSoTheLoaiServiceWrapper(HeSoTheLoaiService heSoTheLoaiService) {
		_heSoTheLoaiService = heSoTheLoaiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _heSoTheLoaiService.getOSGiServiceIdentifier();
	}

	@Override
	public HeSoTheLoaiService getWrappedService() {
		return _heSoTheLoaiService;
	}

	@Override
	public void setWrappedService(HeSoTheLoaiService heSoTheLoaiService) {
		_heSoTheLoaiService = heSoTheLoaiService;
	}

	private HeSoTheLoaiService _heSoTheLoaiService;

}