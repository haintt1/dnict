/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the noiDung column in Video.
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoNoiDungBlobModel {

	public VideoNoiDungBlobModel() {
	}

	public VideoNoiDungBlobModel(long id) {
		_id = id;
	}

	public VideoNoiDungBlobModel(long id, Blob noiDungBlob) {
		_id = id;
		_noiDungBlob = noiDungBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getNoiDungBlob() {
		return _noiDungBlob;
	}

	public void setNoiDungBlob(Blob noiDungBlob) {
		_noiDungBlob = noiDungBlob;
	}

	private long _id;
	private Blob _noiDungBlob;

}