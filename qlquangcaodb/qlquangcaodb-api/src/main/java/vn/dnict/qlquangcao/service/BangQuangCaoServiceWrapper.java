/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BangQuangCaoService}.
 *
 * @author dnict
 * @see BangQuangCaoService
 * @generated
 */
public class BangQuangCaoServiceWrapper
	implements BangQuangCaoService, ServiceWrapper<BangQuangCaoService> {

	public BangQuangCaoServiceWrapper(BangQuangCaoService bangQuangCaoService) {
		_bangQuangCaoService = bangQuangCaoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bangQuangCaoService.getOSGiServiceIdentifier();
	}

	@Override
	public BangQuangCaoService getWrappedService() {
		return _bangQuangCaoService;
	}

	@Override
	public void setWrappedService(BangQuangCaoService bangQuangCaoService) {
		_bangQuangCaoService = bangQuangCaoService;
	}

	private BangQuangCaoService _bangQuangCaoService;

}