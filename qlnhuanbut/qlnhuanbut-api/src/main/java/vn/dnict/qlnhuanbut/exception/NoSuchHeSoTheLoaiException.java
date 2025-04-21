/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlnhuanbut.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchHeSoTheLoaiException extends NoSuchModelException {

	public NoSuchHeSoTheLoaiException() {
	}

	public NoSuchHeSoTheLoaiException(String msg) {
		super(msg);
	}

	public NoSuchHeSoTheLoaiException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchHeSoTheLoaiException(Throwable throwable) {
		super(throwable);
	}

}