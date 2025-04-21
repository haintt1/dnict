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
 * The extended model interface for the GopY_DinhKem service. Represents a row in the &quot;cw_gopy_dinhkemfile&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see GopY_DinhKemModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlgopy.model.impl.GopY_DinhKemImpl")
@ProviderType
public interface GopY_DinhKem extends GopY_DinhKemModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlgopy.model.impl.GopY_DinhKemImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<GopY_DinhKem, Long> ID_ACCESSOR =
		new Accessor<GopY_DinhKem, Long>() {

			@Override
			public Long get(GopY_DinhKem gopY_DinhKem) {
				return gopY_DinhKem.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<GopY_DinhKem> getTypeClass() {
				return GopY_DinhKem.class;
			}

		};

}