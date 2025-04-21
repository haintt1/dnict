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
 * The extended model interface for the ThongKeNB service. Represents a row in the &quot;cw_nhuanbut_thongke&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see ThongKeNBModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlnhuanbut.model.impl.ThongKeNBImpl")
@ProviderType
public interface ThongKeNB extends PersistedModel, ThongKeNBModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlnhuanbut.model.impl.ThongKeNBImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ThongKeNB, Long> ID_ACCESSOR =
		new Accessor<ThongKeNB, Long>() {

			@Override
			public Long get(ThongKeNB thongKeNB) {
				return thongKeNB.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ThongKeNB> getTypeClass() {
				return ThongKeNB.class;
			}

		};

}