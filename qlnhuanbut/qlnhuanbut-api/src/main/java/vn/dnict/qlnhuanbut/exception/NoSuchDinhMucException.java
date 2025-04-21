/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlnhuanbut.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchDinhMucException extends NoSuchModelException {

	public NoSuchDinhMucException() {
	}

	public NoSuchDinhMucException(String msg) {
		super(msg);
	}

	public NoSuchDinhMucException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchDinhMucException(Throwable throwable) {
		super(throwable);
	}

}