/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NhomKHService}.
 *
 * @author dnict
 * @see NhomKHService
 * @generated
 */
public class NhomKHServiceWrapper
	implements NhomKHService, ServiceWrapper<NhomKHService> {

	public NhomKHServiceWrapper(NhomKHService nhomKHService) {
		_nhomKHService = nhomKHService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _nhomKHService.getOSGiServiceIdentifier();
	}

	@Override
	public NhomKHService getWrappedService() {
		return _nhomKHService;
	}

	@Override
	public void setWrappedService(NhomKHService nhomKHService) {
		_nhomKHService = nhomKHService;
	}

	private NhomKHService _nhomKHService;

}