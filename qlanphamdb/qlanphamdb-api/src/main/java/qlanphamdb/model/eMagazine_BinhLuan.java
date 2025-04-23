/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package qlanphamdb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the eMagazine_BinhLuan service. Represents a row in the &quot;cw_eMagazine_BinhLuan&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see eMagazine_BinhLuanModel
 * @generated
 */
@ImplementationClassName("qlanphamdb.model.impl.eMagazine_BinhLuanImpl")
@ProviderType
public interface eMagazine_BinhLuan
	extends eMagazine_BinhLuanModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>qlanphamdb.model.impl.eMagazine_BinhLuanImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<eMagazine_BinhLuan, Long> ID_ACCESSOR =
		new Accessor<eMagazine_BinhLuan, Long>() {

			@Override
			public Long get(eMagazine_BinhLuan eMagazine_BinhLuan) {
				return eMagazine_BinhLuan.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<eMagazine_BinhLuan> getTypeClass() {
				return eMagazine_BinhLuan.class;
			}

		};

}