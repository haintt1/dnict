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

import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;

/**
 * The cache model class for representing HeSoLoaiAP in entity cache.
 *
 * @author dnict
 * @generated
 */
public class HeSoLoaiAPCacheModel
	implements CacheModel<HeSoLoaiAP>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HeSoLoaiAPCacheModel)) {
			return false;
		}

		HeSoLoaiAPCacheModel heSoLoaiAPCacheModel =
			(HeSoLoaiAPCacheModel)object;

		if (id == heSoLoaiAPCacheModel.id) {
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
		StringBundler sb = new StringBundler(9);

		sb.append("{id=");
		sb.append(id);
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", minheso=");
		sb.append(minheso);
		sb.append(", maxheso=");
		sb.append(maxheso);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HeSoLoaiAP toEntityModel() {
		HeSoLoaiAPImpl heSoLoaiAPImpl = new HeSoLoaiAPImpl();

		heSoLoaiAPImpl.setId(id);
		heSoLoaiAPImpl.setLoaiId(loaiId);

		if (minheso == null) {
			heSoLoaiAPImpl.setMinheso("");
		}
		else {
			heSoLoaiAPImpl.setMinheso(minheso);
		}

		if (maxheso == null) {
			heSoLoaiAPImpl.setMaxheso("");
		}
		else {
			heSoLoaiAPImpl.setMaxheso(maxheso);
		}

		heSoLoaiAPImpl.resetOriginalValues();

		return heSoLoaiAPImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		loaiId = objectInput.readLong();
		minheso = objectInput.readUTF();
		maxheso = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(loaiId);

		if (minheso == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(minheso);
		}

		if (maxheso == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(maxheso);
		}
	}

	public long id;
	public long loaiId;
	public String minheso;
	public String maxheso;

}