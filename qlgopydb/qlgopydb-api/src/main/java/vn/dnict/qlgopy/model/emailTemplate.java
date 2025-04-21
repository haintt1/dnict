/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the emailTemplate service. Represents a row in the &quot;cw_gopy_emailTemplate&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see emailTemplateModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlgopy.model.impl.emailTemplateImpl")
@ProviderType
public interface emailTemplate extends emailTemplateModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlgopy.model.impl.emailTemplateImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<emailTemplate, Long> ID_ACCESSOR =
		new Accessor<emailTemplate, Long>() {

			@Override
			public Long get(emailTemplate emailTemplate) {
				return emailTemplate.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<emailTemplate> getTypeClass() {
				return emailTemplate.class;
			}

		};

}