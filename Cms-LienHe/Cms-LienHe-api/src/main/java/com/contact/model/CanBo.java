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
 * The extended model interface for the CanBo service. Represents a row in the &quot;cms_lienhe_canbo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CanBoModel
 * @generated
 */
@ImplementationClassName("com.contact.model.impl.CanBoImpl")
@ProviderType
public interface CanBo extends CanBoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.contact.model.impl.CanBoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CanBo, Long> CANBO_ID_ACCESSOR =
		new Accessor<CanBo, Long>() {

			@Override
			public Long get(CanBo canBo) {
				return canBo.getCanboId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CanBo> getTypeClass() {
				return CanBo.class;
			}

		};

}