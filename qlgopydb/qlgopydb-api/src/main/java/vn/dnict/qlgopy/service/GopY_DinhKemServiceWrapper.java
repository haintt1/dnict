/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GopY_DinhKemService}.
 *
 * @author dnict
 * @see GopY_DinhKemService
 * @generated
 */
public class GopY_DinhKemServiceWrapper
	implements GopY_DinhKemService, ServiceWrapper<GopY_DinhKemService> {

	public GopY_DinhKemServiceWrapper(GopY_DinhKemService gopY_DinhKemService) {
		_gopY_DinhKemService = gopY_DinhKemService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gopY_DinhKemService.getOSGiServiceIdentifier();
	}

	@Override
	public GopY_DinhKemService getWrappedService() {
		return _gopY_DinhKemService;
	}

	@Override
	public void setWrappedService(GopY_DinhKemService gopY_DinhKemService) {
		_gopY_DinhKemService = gopY_DinhKemService;
	}

	private GopY_DinhKemService _gopY_DinhKemService;

}