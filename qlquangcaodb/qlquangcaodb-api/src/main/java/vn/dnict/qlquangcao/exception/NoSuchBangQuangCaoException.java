/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlquangcao.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchBangQuangCaoException extends NoSuchModelException {

	public NoSuchBangQuangCaoException() {
	}

	public NoSuchBangQuangCaoException(String msg) {
		super(msg);
	}

	public NoSuchBangQuangCaoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchBangQuangCaoException(Throwable throwable) {
		super(throwable);
	}

}