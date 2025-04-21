/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.contact.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchToChucException extends NoSuchModelException {

	public NoSuchToChucException() {
	}

	public NoSuchToChucException(String msg) {
		super(msg);
	}

	public NoSuchToChucException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchToChucException(Throwable throwable) {
		super(throwable);
	}

}