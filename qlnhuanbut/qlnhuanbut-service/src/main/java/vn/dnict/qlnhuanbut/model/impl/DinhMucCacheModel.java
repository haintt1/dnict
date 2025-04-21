/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import vn.dnict.qlnhuanbut.model.DinhMuc;

/**
 * The cache model class for representing DinhMuc in entity cache.
 *
 * @author dnict
 * @generated
 */
public class DinhMucCacheModel implements CacheModel<DinhMuc>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DinhMucCacheModel)) {
			return false;
		}

		DinhMucCacheModel dinhMucCacheModel = (DinhMucCacheModel)object;

		if (id == dinhMucCacheModel.id) {
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
		sb.append(", loaidinhmuc=");
		sb.append(loaidinhmuc);
		sb.append(", gia=");
		sb.append(gia);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DinhMuc toEntityModel() {
		DinhMucImpl dinhMucImpl = new DinhMucImpl();

		dinhMucImpl.setId(id);
		dinhMucImpl.setLoaidinhmuc(loaidinhmuc);

		if (gia == null) {
			dinhMucImpl.setGia("");
		}
		else {
			dinhMucImpl.setGia(gia);
		}

		dinhMucImpl.resetOriginalValues();

		return dinhMucImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		loaidinhmuc = objectInput.readInt();
		gia = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeInt(loaidinhmuc);

		if (gia == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gia);
		}
	}

	public long id;
	public int loaidinhmuc;
	public String gia;

}