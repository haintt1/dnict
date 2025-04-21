/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package vn.dnict.qlgopy.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author dnict
 */
public class NoSuchemailTemplateException extends NoSuchModelException {

	public NoSuchemailTemplateException() {
	}

	public NoSuchemailTemplateException(String msg) {
		super(msg);
	}

	public NoSuchemailTemplateException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchemailTemplateException(Throwable throwable) {
		super(throwable);
	}

}