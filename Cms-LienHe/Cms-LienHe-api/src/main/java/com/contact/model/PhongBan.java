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
 * The extended model interface for the PhongBan service. Represents a row in the &quot;cms_lienhe_phongban&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PhongBanModel
 * @generated
 */
@ImplementationClassName("com.contact.model.impl.PhongBanImpl")
@ProviderType
public interface PhongBan extends PersistedModel, PhongBanModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.contact.model.impl.PhongBanImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PhongBan, Long> PHONGBAN_ID_ACCESSOR =
		new Accessor<PhongBan, Long>() {

			@Override
			public Long get(PhongBan phongBan) {
				return phongBan.getPhongbanId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<PhongBan> getTypeClass() {
				return PhongBan.class;
			}

		};

}