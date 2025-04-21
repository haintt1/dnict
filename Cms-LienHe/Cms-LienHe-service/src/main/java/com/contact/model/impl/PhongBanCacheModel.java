/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model.impl;

import com.contact.model.PhongBan;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PhongBan in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PhongBanCacheModel
	implements CacheModel<PhongBan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PhongBanCacheModel)) {
			return false;
		}

		PhongBanCacheModel phongBanCacheModel = (PhongBanCacheModel)object;

		if (phongbanId == phongBanCacheModel.phongbanId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, phongbanId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{phongbanId=");
		sb.append(phongbanId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", tochuc_id=");
		sb.append(tochuc_id);
		sb.append(", tinhTrang=");
		sb.append(tinhTrang);
		sb.append(", sapXep=");
		sb.append(sapXep);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PhongBan toEntityModel() {
		PhongBanImpl phongBanImpl = new PhongBanImpl();

		phongBanImpl.setPhongbanId(phongbanId);
		phongBanImpl.setCompanyId(companyId);
		phongBanImpl.setGroupId(groupId);

		if (ten == null) {
			phongBanImpl.setTen("");
		}
		else {
			phongBanImpl.setTen(ten);
		}

		if (moTa == null) {
			phongBanImpl.setMoTa("");
		}
		else {
			phongBanImpl.setMoTa(moTa);
		}

		phongBanImpl.setTochuc_id(tochuc_id);
		phongBanImpl.setTinhTrang(tinhTrang);
		phongBanImpl.setSapXep(sapXep);
		phongBanImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			phongBanImpl.setNgayTao(null);
		}
		else {
			phongBanImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			phongBanImpl.setNgaySua(null);
		}
		else {
			phongBanImpl.setNgaySua(new Date(ngaySua));
		}

		phongBanImpl.resetOriginalValues();

		return phongBanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		phongbanId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();

		tochuc_id = objectInput.readLong();

		tinhTrang = objectInput.readLong();

		sapXep = objectInput.readInt();

		daXoa = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(phongbanId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

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

		objectOutput.writeLong(tochuc_id);

		objectOutput.writeLong(tinhTrang);

		objectOutput.writeInt(sapXep);

		objectOutput.writeLong(daXoa);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
	}

	public long phongbanId;
	public long companyId;
	public long groupId;
	public String ten;
	public String moTa;
	public long tochuc_id;
	public long tinhTrang;
	public int sapXep;
	public long daXoa;
	public long ngayTao;
	public long ngaySua;

}