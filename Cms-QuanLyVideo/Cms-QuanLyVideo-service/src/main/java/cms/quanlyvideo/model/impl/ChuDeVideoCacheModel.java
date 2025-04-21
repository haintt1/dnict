/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model.impl;

import cms.quanlyvideo.model.ChuDeVideo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ChuDeVideo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChuDeVideoCacheModel
	implements CacheModel<ChuDeVideo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChuDeVideoCacheModel)) {
			return false;
		}

		ChuDeVideoCacheModel chuDeVideoCacheModel =
			(ChuDeVideoCacheModel)object;

		if (id == chuDeVideoCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", chude_id=");
		sb.append(chude_id);
		sb.append(", video_id=");
		sb.append(video_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChuDeVideo toEntityModel() {
		ChuDeVideoImpl chuDeVideoImpl = new ChuDeVideoImpl();

		chuDeVideoImpl.setId(id);
		chuDeVideoImpl.setChude_id(chude_id);
		chuDeVideoImpl.setVideo_id(video_id);

		chuDeVideoImpl.resetOriginalValues();

		return chuDeVideoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		chude_id = objectInput.readLong();

		video_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(chude_id);

		objectOutput.writeLong(video_id);
	}

	public long id;
	public long chude_id;
	public long video_id;

}