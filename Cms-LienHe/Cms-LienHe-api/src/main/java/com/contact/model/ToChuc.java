/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ToChuc service. Represents a row in the &quot;cms_lienhe_tochuc&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ToChucModel
 * @generated
 */
@ImplementationClassName("com.contact.model.impl.ToChucImpl")
@ProviderType
public interface ToChuc extends PersistedModel, ToChucModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.contact.model.impl.ToChucImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ToChuc, Long> TOCHUC_ID_ACCESSOR =
		new Accessor<ToChuc, Long>() {

			@Override
			public Long get(ToChuc toChuc) {
				return toChuc.getTochucId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ToChuc> getTypeClass() {
				return ToChuc.class;
			}

		};

}