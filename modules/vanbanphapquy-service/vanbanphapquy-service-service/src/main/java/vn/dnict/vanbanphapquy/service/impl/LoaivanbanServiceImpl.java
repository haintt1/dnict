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

package vn.dnict.vanbanphapquy.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import vn.dnict.vanbanphapquy.service.base.LoaivanbanServiceBaseImpl;

/**
 * @author BinhNT
 */
@Component(
	property = {
		"json.web.service.context.name=binhnt",
		"json.web.service.context.path=Loaivanban"
	},
	service = AopService.class
)
public class LoaivanbanServiceImpl extends LoaivanbanServiceBaseImpl {
}