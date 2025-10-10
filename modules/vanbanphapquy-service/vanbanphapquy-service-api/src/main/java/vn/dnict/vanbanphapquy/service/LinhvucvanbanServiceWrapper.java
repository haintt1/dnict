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
 * Provides a wrapper for {@link LinhvucvanbanService}.
 *
 * @author BinhNT
 * @see LinhvucvanbanService
 * @generated
 */
public class LinhvucvanbanServiceWrapper
	implements LinhvucvanbanService, ServiceWrapper<LinhvucvanbanService> {

	public LinhvucvanbanServiceWrapper(
		LinhvucvanbanService linhvucvanbanService) {

		_linhvucvanbanService = linhvucvanbanService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linhvucvanbanService.getOSGiServiceIdentifier();
	}

	@Override
	public LinhvucvanbanService getWrappedService() {
		return _linhvucvanbanService;
	}

	@Override
	public void setWrappedService(LinhvucvanbanService linhvucvanbanService) {
		_linhvucvanbanService = linhvucvanbanService;
	}

	private LinhvucvanbanService _linhvucvanbanService;

}