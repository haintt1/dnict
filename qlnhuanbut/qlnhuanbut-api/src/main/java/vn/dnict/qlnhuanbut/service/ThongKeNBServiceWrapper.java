/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ThongKeNBService}.
 *
 * @author dnict
 * @see ThongKeNBService
 * @generated
 */
public class ThongKeNBServiceWrapper
	implements ServiceWrapper<ThongKeNBService>, ThongKeNBService {

	public ThongKeNBServiceWrapper(ThongKeNBService thongKeNBService) {
		_thongKeNBService = thongKeNBService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _thongKeNBService.getOSGiServiceIdentifier();
	}

	@Override
	public ThongKeNBService getWrappedService() {
		return _thongKeNBService;
	}

	@Override
	public void setWrappedService(ThongKeNBService thongKeNBService) {
		_thongKeNBService = thongKeNBService;
	}

	private ThongKeNBService _thongKeNBService;

}