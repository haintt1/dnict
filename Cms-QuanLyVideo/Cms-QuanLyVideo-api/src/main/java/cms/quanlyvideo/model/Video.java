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
 * The extended model interface for the Video service. Represents a row in the &quot;cms_quanlyvideo_video&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VideoModel
 * @generated
 */
@ImplementationClassName("cms.quanlyvideo.model.impl.VideoImpl")
@ProviderType
public interface Video extends PersistedModel, VideoModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>cms.quanlyvideo.model.impl.VideoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Video, Long> ID_ACCESSOR =
		new Accessor<Video, Long>() {

			@Override
			public Long get(Video video) {
				return video.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Video> getTypeClass() {
				return Video.class;
			}

		};

}