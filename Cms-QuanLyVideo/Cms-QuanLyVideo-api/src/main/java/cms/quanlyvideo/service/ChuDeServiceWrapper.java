/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChuDeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeService
 * @generated
 */
public class ChuDeServiceWrapper
	implements ChuDeService, ServiceWrapper<ChuDeService> {

	public ChuDeServiceWrapper(ChuDeService chuDeService) {
		_chuDeService = chuDeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chuDeService.getOSGiServiceIdentifier();
	}

	@Override
	public ChuDeService getWrappedService() {
		return _chuDeService;
	}

	@Override
	public void setWrappedService(ChuDeService chuDeService) {
		_chuDeService = chuDeService;
	}

	private ChuDeService _chuDeService;

}