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
 * The extended model interface for the ChuDeVideo service. Represents a row in the &quot;cms_quanlyvideo_chudevideo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideoModel
 * @generated
 */
@ImplementationClassName("cms.quanlyvideo.model.impl.ChuDeVideoImpl")
@ProviderType
public interface ChuDeVideo extends ChuDeVideoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cms.quanlyvideo.model.impl.ChuDeVideoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ChuDeVideo, Long> ID_ACCESSOR =
		new Accessor<ChuDeVideo, Long>() {

			@Override
			public Long get(ChuDeVideo chuDeVideo) {
				return chuDeVideo.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ChuDeVideo> getTypeClass() {
				return ChuDeVideo.class;
			}

		};

}