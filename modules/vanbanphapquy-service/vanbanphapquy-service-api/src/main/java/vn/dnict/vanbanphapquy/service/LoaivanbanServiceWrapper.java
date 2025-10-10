/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.dnict.vanbanphapquy.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LoaivanbanService}.
 *
 * @author BinhNT
 * @see LoaivanbanService
 * @generated
 */
public class LoaivanbanServiceWrapper
	implements LoaivanbanService, ServiceWrapper<LoaivanbanService> {

	public LoaivanbanServiceWrapper(LoaivanbanService loaivanbanService) {
		_loaivanbanService = loaivanbanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _loaivanbanService.getOSGiServiceIdentifier();
	}

	@Override
	public LoaivanbanService getWrappedService() {
		return _loaivanbanService;
	}

	@Override
	public void setWrappedService(LoaivanbanService loaivanbanService) {
		_loaivanbanService = loaivanbanService;
	}

	private LoaivanbanService _loaivanbanService;

}