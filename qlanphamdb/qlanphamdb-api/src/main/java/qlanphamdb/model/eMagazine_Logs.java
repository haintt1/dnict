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
 * The extended model interface for the eMagazine_Logs service. Represents a row in the &quot;cw_eMagazine_Logs&quot; database table, with each column mapped to a property of this class.
 *
 * @author dnict
 * @see eMagazine_LogsModel
 * @generated
 */
@ImplementationClassName("qlanphamdb.model.impl.eMagazine_LogsImpl")
@ProviderType
public interface eMagazine_Logs extends eMagazine_LogsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>qlanphamdb.model.impl.eMagazine_LogsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<eMagazine_Logs, Long> ID_ACCESSOR =
		new Accessor<eMagazine_Logs, Long>() {

			@Override
			public Long get(eMagazine_Logs eMagazine_Logs) {
				return eMagazine_Logs.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<eMagazine_Logs> getTypeClass() {
				return eMagazine_Logs.class;
			}

		};

}