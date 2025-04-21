/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ChuDe service. Represents a row in the &quot;Cms_quanlyvideo_chude&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeModel
 * @generated
 */
@ImplementationClassName("cms.quanlyvideo.model.impl.ChuDeImpl")
@ProviderType
public interface ChuDe extends ChuDeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cms.quanlyvideo.model.impl.ChuDeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ChuDe, Long> ID_ACCESSOR =
		new Accessor<ChuDe, Long>() {

			@Override
			public Long get(ChuDe chuDe) {
				return chuDe.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ChuDe> getTypeClass() {
				return ChuDe.class;
			}

		};

}