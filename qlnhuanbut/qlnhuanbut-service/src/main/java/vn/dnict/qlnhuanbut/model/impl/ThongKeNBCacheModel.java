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

import java.util.Date;

import vn.dnict.qlnhuanbut.model.ThongKeNB;

/**
 * The cache model class for representing ThongKeNB in entity cache.
 *
 * @author dnict
 * @generated
 */
public class ThongKeNBCacheModel
	implements CacheModel<ThongKeNB>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ThongKeNBCacheModel)) {
			return false;
		}

		ThongKeNBCacheModel thongKeNBCacheModel = (ThongKeNBCacheModel)object;

		if (id == thongKeNBCacheModel.id) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", nguoixuly=");
		sb.append(nguoixuly);
		sb.append(", newarticleId=");
		sb.append(newarticleId);
		sb.append(", anphamId=");
		sb.append(anphamId);
		sb.append(", heso=");
		sb.append(heso);
		sb.append(", tongtien=");
		sb.append(tongtien);
		sb.append(", status=");
		sb.append(status);
		sb.append(", ngaytao=");
		sb.append(ngaytao);
		sb.append(", ngaysua=");
		sb.append(ngaysua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ThongKeNB toEntityModel() {
		ThongKeNBImpl thongKeNBImpl = new ThongKeNBImpl();

		thongKeNBImpl.setId(id);
		thongKeNBImpl.setNguoixuly(nguoixuly);
		thongKeNBImpl.setNewarticleId(newarticleId);
		thongKeNBImpl.setAnphamId(anphamId);

		if (heso == null) {
			thongKeNBImpl.setHeso("");
		}
		else {
			thongKeNBImpl.setHeso(heso);
		}

		thongKeNBImpl.setTongtien(tongtien);
		thongKeNBImpl.setStatus(status);

		if (ngaytao == Long.MIN_VALUE) {
			thongKeNBImpl.setNgaytao(null);
		}
		else {
			thongKeNBImpl.setNgaytao(new Date(ngaytao));
		}

		if (ngaysua == Long.MIN_VALUE) {
			thongKeNBImpl.setNgaysua(null);
		}
		else {
			thongKeNBImpl.setNgaysua(new Date(ngaysua));
		}

		thongKeNBImpl.resetOriginalValues();

		return thongKeNBImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		nguoixuly = objectInput.readLong();

		newarticleId = objectInput.readLong();

		anphamId = objectInput.readLong();
		heso = objectInput.readUTF();

		tongtien = objectInput.readDouble();

		status = objectInput.readInt();
		ngaytao = objectInput.readLong();
		ngaysua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(nguoixuly);

		objectOutput.writeLong(newarticleId);

		objectOutput.writeLong(anphamId);

		if (heso == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(heso);
		}

		objectOutput.writeDouble(tongtien);

		objectOutput.writeInt(status);
		objectOutput.writeLong(ngaytao);
		objectOutput.writeLong(ngaysua);
	}

	public long id;
	public long nguoixuly;
	public long newarticleId;
	public long anphamId;
	public String heso;
	public double tongtien;
	public int status;
	public long ngaytao;
	public long ngaysua;

}