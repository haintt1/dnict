/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlgopy.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchHoiDapGopYException extends NoSuchModelException {

	public NoSuchHoiDapGopYException() {
	}

	public NoSuchHoiDapGopYException(String msg) {
		super(msg);
	}

	public NoSuchHoiDapGopYException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchHoiDapGopYException(Throwable throwable) {
		super(throwable);
	}

}