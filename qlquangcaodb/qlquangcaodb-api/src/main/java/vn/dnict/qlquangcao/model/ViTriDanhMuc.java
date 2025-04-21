/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ViTriDanhMuc service. Represents a row in the &quot;cw_quangcao_vitridanhmuc&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see ViTriDanhMucModel
 * @generated
 */
@ImplementationClassName("vn.dnict.qlquangcao.model.impl.ViTriDanhMucImpl")
@ProviderType
public interface ViTriDanhMuc extends PersistedModel, ViTriDanhMucModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>vn.dnict.qlquangcao.model.impl.ViTriDanhMucImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ViTriDanhMuc, Long> ID_ACCESSOR =
		new Accessor<ViTriDanhMuc, Long>() {

			@Override
			public Long get(ViTriDanhMuc viTriDanhMuc) {
				return viTriDanhMuc.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ViTriDanhMuc> getTypeClass() {
				return ViTriDanhMuc.class;
			}

		};

}