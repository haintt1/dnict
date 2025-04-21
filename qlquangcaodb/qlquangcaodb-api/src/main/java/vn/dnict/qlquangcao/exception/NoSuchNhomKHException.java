/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlquangcao.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchNhomKHException extends NoSuchModelException {

	public NoSuchNhomKHException() {
	}

	public NoSuchNhomKHException(String msg) {
		super(msg);
	}

	public NoSuchNhomKHException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchNhomKHException(Throwable throwable) {
		super(throwable);
	}

}