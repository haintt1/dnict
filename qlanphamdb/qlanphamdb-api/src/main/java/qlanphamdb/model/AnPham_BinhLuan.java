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
 * The extended model interface for the AnPham_BinhLuan service. Represents a row in the &quot;cw_AnPham_BinhLuan&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see AnPham_BinhLuanModel
 * @generated
 */
@ImplementationClassName("qlanphamdb.model.impl.AnPham_BinhLuanImpl")
@ProviderType
public interface AnPham_BinhLuan extends AnPham_BinhLuanModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>qlanphamdb.model.impl.AnPham_BinhLuanImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnPham_BinhLuan, Long> ID_ACCESSOR =
		new Accessor<AnPham_BinhLuan, Long>() {

			@Override
			public Long get(AnPham_BinhLuan anPham_BinhLuan) {
				return anPham_BinhLuan.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnPham_BinhLuan> getTypeClass() {
				return AnPham_BinhLuan.class;
			}

		};

}