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
 * The extended model interface for the HeSoLoaiAP service. Represents a row in the &quot;cw_nhuanbut_hesoloaiAP&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see HeSoLoaiAPModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPImpl")
@ProviderType
public interface HeSoLoaiAP extends HeSoLoaiAPModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<HeSoLoaiAP, Long> ID_ACCESSOR =
		new Accessor<HeSoLoaiAP, Long>() {

			@Override
			public Long get(HeSoLoaiAP heSoLoaiAP) {
				return heSoLoaiAP.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<HeSoLoaiAP> getTypeClass() {
				return HeSoLoaiAP.class;
			}

		};

}