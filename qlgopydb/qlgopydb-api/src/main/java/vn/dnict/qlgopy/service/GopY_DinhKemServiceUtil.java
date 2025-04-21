/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service;

/**
 * Provides the remote service utility for GopY_DinhKem. This utility wraps
 * <code>vn.dnict.qlgopy.service.impl.GopY_DinhKemServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author dnict
 * @see GopY_DinhKemService
 * @generated
 */
public class GopY_DinhKemServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>vn.dnict.qlgopy.service.impl.GopY_DinhKemServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static GopY_DinhKemService getService() {
		return _service;
	}

	public static void setService(GopY_DinhKemService service) {
		_service = service;
	}

	private static volatile GopY_DinhKemService _service;

}