/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the DinhMuc service. Represents a row in the &quot;cw_nhuanbut_dinhmuc&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see DinhMucModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlnhuanbut.model.impl.DinhMucImpl")
@ProviderType
public interface DinhMuc extends DinhMucModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlnhuanbut.model.impl.DinhMucImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DinhMuc, Long> ID_ACCESSOR =
		new Accessor<DinhMuc, Long>() {

			@Override
			public Long get(DinhMuc dinhMuc) {
				return dinhMuc.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DinhMuc> getTypeClass() {
				return DinhMuc.class;
			}

		};

}