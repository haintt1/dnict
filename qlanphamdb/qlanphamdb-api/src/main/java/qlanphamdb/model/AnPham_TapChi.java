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
 * The extended model interface for the AnPham_TapChi service. Represents a row in the &quot;cw_AnPham_TapChi&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see AnPham_TapChiModel
 * @generated
 */
@ImplementationClassName("qlanphamdb.model.impl.AnPham_TapChiImpl")
@ProviderType
public interface AnPham_TapChi extends AnPham_TapChiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>qlanphamdb.model.impl.AnPham_TapChiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AnPham_TapChi, Long> ID_ACCESSOR =
		new Accessor<AnPham_TapChi, Long>() {

			@Override
			public Long get(AnPham_TapChi anPham_TapChi) {
				return anPham_TapChi.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AnPham_TapChi> getTypeClass() {
				return AnPham_TapChi.class;
			}

		};

}