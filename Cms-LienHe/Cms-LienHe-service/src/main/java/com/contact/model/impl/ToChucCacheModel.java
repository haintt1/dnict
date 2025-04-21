/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model.impl;

import com.contact.model.ToChuc;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ToChuc in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ToChucCacheModel implements CacheModel<ToChuc>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ToChucCacheModel)) {
			return false;
		}

		ToChucCacheModel toChucCacheModel = (ToChucCacheModel)object;

		if (tochucId == toChucCacheModel.tochucId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, tochucId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{tochucId=");
		sb.append(tochucId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
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
	public ToChuc toEntityModel() {
		ToChucImpl toChucImpl = new ToChucImpl();

		toChucImpl.setTochucId(tochucId);
		toChucImpl.setCompanyId(companyId);
		toChucImpl.setGroupId(groupId);

		if (ten == null) {
			toChucImpl.setTen("");
		}
		else {
			toChucImpl.setTen(ten);
		}

		if (moTa == null) {
			toChucImpl.setMoTa("");
		}
		else {
			toChucImpl.setMoTa(moTa);
		}

		toChucImpl.setTinhTrang(tinhTrang);
		toChucImpl.setSapXep(sapXep);
		toChucImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			toChucImpl.setNgayTao(null);
		}
		else {
			toChucImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			toChucImpl.setNgaySua(null);
		}
		else {
			toChucImpl.setNgaySua(new Date(ngaySua));
		}

		toChucImpl.resetOriginalValues();

		return toChucImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		tochucId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();

		tinhTrang = objectInput.readLong();

		sapXep = objectInput.readInt();

		daXoa = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(tochucId);

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

		objectOutput.writeLong(tinhTrang);

		objectOutput.writeInt(sapXep);

		objectOutput.writeLong(daXoa);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
	}

	public long tochucId;
	public long companyId;
	public long groupId;
	public String ten;
	public String moTa;
	public long tinhTrang;
	public int sapXep;
	public long daXoa;
	public long ngayTao;
	public long ngaySua;

}