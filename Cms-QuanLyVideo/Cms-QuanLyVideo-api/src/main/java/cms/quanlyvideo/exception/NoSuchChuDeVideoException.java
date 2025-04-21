/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package cms.quanlyvideo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchChuDeVideoException extends NoSuchModelException {

	public NoSuchChuDeVideoException() {
	}

	public NoSuchChuDeVideoException(String msg) {
		super(msg);
	}

	public NoSuchChuDeVideoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchChuDeVideoException(Throwable throwable) {
		super(throwable);
	}

}