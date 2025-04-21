/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model.impl;

import com.contact.model.CanBo;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CanBo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CanBoCacheModel implements CacheModel<CanBo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CanBoCacheModel)) {
			return false;
		}

		CanBoCacheModel canBoCacheModel = (CanBoCacheModel)object;

		if (canboId == canBoCacheModel.canboId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, canboId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{canboId=");
		sb.append(canboId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", chucVu=");
		sb.append(chucVu);
		sb.append(", phongban_id=");
		sb.append(phongban_id);
		sb.append(", sdt=");
		sb.append(sdt);
		sb.append(", email=");
		sb.append(email);
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
	public CanBo toEntityModel() {
		CanBoImpl canBoImpl = new CanBoImpl();

		canBoImpl.setCanboId(canboId);
		canBoImpl.setCompanyId(companyId);
		canBoImpl.setGroupId(groupId);

		if (ten == null) {
			canBoImpl.setTen("");
		}
		else {
			canBoImpl.setTen(ten);
		}

		if (chucVu == null) {
			canBoImpl.setChucVu("");
		}
		else {
			canBoImpl.setChucVu(chucVu);
		}

		canBoImpl.setPhongban_id(phongban_id);

		if (sdt == null) {
			canBoImpl.setSdt("");
		}
		else {
			canBoImpl.setSdt(sdt);
		}

		if (email == null) {
			canBoImpl.setEmail("");
		}
		else {
			canBoImpl.setEmail(email);
		}

		canBoImpl.setTinhTrang(tinhTrang);
		canBoImpl.setSapXep(sapXep);
		canBoImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			canBoImpl.setNgayTao(null);
		}
		else {
			canBoImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			canBoImpl.setNgaySua(null);
		}
		else {
			canBoImpl.setNgaySua(new Date(ngaySua));
		}

		canBoImpl.resetOriginalValues();

		return canBoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		canboId = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		ten = objectInput.readUTF();
		chucVu = objectInput.readUTF();

		phongban_id = objectInput.readLong();
		sdt = objectInput.readUTF();
		email = objectInput.readUTF();

		tinhTrang = objectInput.readLong();

		sapXep = objectInput.readInt();

		daXoa = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(canboId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (chucVu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(chucVu);
		}

		objectOutput.writeLong(phongban_id);

		if (sdt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sdt);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(tinhTrang);

		objectOutput.writeInt(sapXep);

		objectOutput.writeLong(daXoa);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
	}

	public long canboId;
	public long companyId;
	public long groupId;
	public String ten;
	public String chucVu;
	public long phongban_id;
	public String sdt;
	public String email;
	public long tinhTrang;
	public int sapXep;
	public long daXoa;
	public long ngayTao;
	public long ngaySua;

}