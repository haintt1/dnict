/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DemoDB service. Represents a row in the &quot;cw_DemoDB&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DemoDBModel
 * @generated
 */
@ImplementationClassName("com.demo.model.impl.DemoDBImpl")
@ProviderType
public interface DemoDB extends DemoDBModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.demo.model.impl.DemoDBImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DemoDB, Long> ID_ACCESSOR =
		new Accessor<DemoDB, Long>() {

			@Override
			public Long get(DemoDB demoDB) {
				return demoDB.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DemoDB> getTypeClass() {
				return DemoDB.class;
			}

		};

}