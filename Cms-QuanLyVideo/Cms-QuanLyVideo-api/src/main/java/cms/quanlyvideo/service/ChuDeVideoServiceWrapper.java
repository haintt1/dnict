/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ChuDeVideoService}.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideoService
 * @generated
 */
public class ChuDeVideoServiceWrapper
	implements ChuDeVideoService, ServiceWrapper<ChuDeVideoService> {

	public ChuDeVideoServiceWrapper(ChuDeVideoService chuDeVideoService) {
		_chuDeVideoService = chuDeVideoService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _chuDeVideoService.getOSGiServiceIdentifier();
	}

	@Override
	public ChuDeVideoService getWrappedService() {
		return _chuDeVideoService;
	}

	@Override
	public void setWrappedService(ChuDeVideoService chuDeVideoService) {
		_chuDeVideoService = chuDeVideoService;
	}

	private ChuDeVideoService _chuDeVideoService;

}