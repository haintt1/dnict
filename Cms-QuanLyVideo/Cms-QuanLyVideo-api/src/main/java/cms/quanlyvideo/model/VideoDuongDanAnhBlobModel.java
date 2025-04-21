/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the duongDanAnh column in Video.
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoDuongDanAnhBlobModel {

	public VideoDuongDanAnhBlobModel() {
	}

	public VideoDuongDanAnhBlobModel(long id) {
		_id = id;
	}

	public VideoDuongDanAnhBlobModel(long id, Blob duongDanAnhBlob) {
		_id = id;
		_duongDanAnhBlob = duongDanAnhBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getDuongDanAnhBlob() {
		return _duongDanAnhBlob;
	}

	public void setDuongDanAnhBlob(Blob duongDanAnhBlob) {
		_duongDanAnhBlob = duongDanAnhBlob;
	}

	private long _id;
	private Blob _duongDanAnhBlob;

}