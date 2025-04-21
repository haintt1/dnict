/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.model.impl;

import com.demo.model.DemoDB;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DemoDB in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DemoDBCacheModel implements CacheModel<DemoDB>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DemoDBCacheModel)) {
			return false;
		}

		DemoDBCacheModel demoDBCacheModel = (DemoDBCacheModel)object;

		if (id == demoDBCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", ngayxuatban=");
		sb.append(ngayxuatban);
		sb.append(", ngayhethan=");
		sb.append(ngayhethan);
		sb.append(", tinhtrang=");
		sb.append(tinhtrang);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DemoDB toEntityModel() {
		DemoDBImpl demoDBImpl = new DemoDBImpl();

		demoDBImpl.setId(id);

		if (ten == null) {
			demoDBImpl.setTen("");
		}
		else {
			demoDBImpl.setTen(ten);
		}

		if (moTa == null) {
			demoDBImpl.setMoTa("");
		}
		else {
			demoDBImpl.setMoTa(moTa);
		}

		if (noiDung == null) {
			demoDBImpl.setNoiDung("");
		}
		else {
			demoDBImpl.setNoiDung(noiDung);
		}

		if (ngayxuatban == Long.MIN_VALUE) {
			demoDBImpl.setNgayxuatban(null);
		}
		else {
			demoDBImpl.setNgayxuatban(new Date(ngayxuatban));
		}

		if (ngayhethan == Long.MIN_VALUE) {
			demoDBImpl.setNgayhethan(null);
		}
		else {
			demoDBImpl.setNgayhethan(new Date(ngayhethan));
		}

		demoDBImpl.setTinhtrang(tinhtrang);

		demoDBImpl.resetOriginalValues();

		return demoDBImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();
		noiDung = objectInput.readUTF();
		ngayxuatban = objectInput.readLong();
		ngayhethan = objectInput.readLong();

		tinhtrang = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		objectOutput.writeLong(ngayxuatban);
		objectOutput.writeLong(ngayhethan);

		objectOutput.writeInt(tinhtrang);
	}

	public long id;
	public String ten;
	public String moTa;
	public String noiDung;
	public long ngayxuatban;
	public long ngayhethan;
	public int tinhtrang;

}