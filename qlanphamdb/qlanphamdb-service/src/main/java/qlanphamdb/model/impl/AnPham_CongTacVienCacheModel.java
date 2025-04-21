/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package qlanphamdb.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import qlanphamdb.model.AnPham_CongTacVien;

/**
 * The cache model class for representing AnPham_CongTacVien in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_CongTacVienCacheModel
	implements CacheModel<AnPham_CongTacVien>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_CongTacVienCacheModel)) {
			return false;
		}

		AnPham_CongTacVienCacheModel anPham_CongTacVienCacheModel =
			(AnPham_CongTacVienCacheModel)object;

		if (id == anPham_CongTacVienCacheModel.id) {
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
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", hoTen=");
		sb.append(hoTen);
		sb.append(", email=");
		sb.append(email);
		sb.append(", thongTin=");
		sb.append(thongTin);
		sb.append(", status=");
		sb.append(status);
		sb.append(", orders=");
		sb.append(orders);
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnPham_CongTacVien toEntityModel() {
		AnPham_CongTacVienImpl anPham_CongTacVienImpl =
			new AnPham_CongTacVienImpl();

		anPham_CongTacVienImpl.setId(id);
		anPham_CongTacVienImpl.setGroupId(groupId);
		anPham_CongTacVienImpl.setCompanyId(companyId);

		if (hoTen == null) {
			anPham_CongTacVienImpl.setHoTen("");
		}
		else {
			anPham_CongTacVienImpl.setHoTen(hoTen);
		}

		if (email == null) {
			anPham_CongTacVienImpl.setEmail("");
		}
		else {
			anPham_CongTacVienImpl.setEmail(email);
		}

		if (thongTin == null) {
			anPham_CongTacVienImpl.setThongTin("");
		}
		else {
			anPham_CongTacVienImpl.setThongTin(thongTin);
		}

		anPham_CongTacVienImpl.setStatus(status);
		anPham_CongTacVienImpl.setOrders(orders);
		anPham_CongTacVienImpl.setDelete_status(delete_status);

		anPham_CongTacVienImpl.resetOriginalValues();

		return anPham_CongTacVienImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		hoTen = objectInput.readUTF();
		email = objectInput.readUTF();
		thongTin = objectInput.readUTF();

		status = objectInput.readInt();

		orders = objectInput.readLong();

		delete_status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (hoTen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hoTen);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (thongTin == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(thongTin);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long groupId;
	public long companyId;
	public String hoTen;
	public String email;
	public String thongTin;
	public int status;
	public long orders;
	public int delete_status;

}