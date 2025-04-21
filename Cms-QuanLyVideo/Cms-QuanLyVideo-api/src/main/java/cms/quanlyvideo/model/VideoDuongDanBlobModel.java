/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the duongDan column in Video.
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoDuongDanBlobModel {

	public VideoDuongDanBlobModel() {
	}

	public VideoDuongDanBlobModel(long id) {
		_id = id;
	}

	public VideoDuongDanBlobModel(long id, Blob duongDanBlob) {
		_id = id;
		_duongDanBlob = duongDanBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getDuongDanBlob() {
		return _duongDanBlob;
	}

	public void setDuongDanBlob(Blob duongDanBlob) {
		_duongDanBlob = duongDanBlob;
	}

	private long _id;
	private Blob _duongDanBlob;

}