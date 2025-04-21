/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package cms.quanlyvideo.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchVideoException extends NoSuchModelException {

	public NoSuchVideoException() {
	}

	public NoSuchVideoException(String msg) {
		super(msg);
	}

	public NoSuchVideoException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchVideoException(Throwable throwable) {
		super(throwable);
	}

}