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

import java.util.Date;

import qlanphamdb.model.AnPham_BinhLuan;

/**
 * The cache model class for representing AnPham_BinhLuan in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_BinhLuanCacheModel
	implements CacheModel<AnPham_BinhLuan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_BinhLuanCacheModel)) {
			return false;
		}

		AnPham_BinhLuanCacheModel anPham_BinhLuanCacheModel =
			(AnPham_BinhLuanCacheModel)object;

		if (id == anPham_BinhLuanCacheModel.id) {
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
		StringBundler sb = new StringBundler(21);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", anPhamId=");
		sb.append(anPhamId);
		sb.append(", hoTen=");
		sb.append(hoTen);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", ngayBinhLuan=");
		sb.append(ngayBinhLuan);
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
	public AnPham_BinhLuan toEntityModel() {
		AnPham_BinhLuanImpl anPham_BinhLuanImpl = new AnPham_BinhLuanImpl();

		anPham_BinhLuanImpl.setId(id);
		anPham_BinhLuanImpl.setCompanyId(companyId);
		anPham_BinhLuanImpl.setGroupId(groupId);
		anPham_BinhLuanImpl.setAnPhamId(anPhamId);

		if (hoTen == null) {
			anPham_BinhLuanImpl.setHoTen("");
		}
		else {
			anPham_BinhLuanImpl.setHoTen(hoTen);
		}

		if (noiDung == null) {
			anPham_BinhLuanImpl.setNoiDung("");
		}
		else {
			anPham_BinhLuanImpl.setNoiDung(noiDung);
		}

		if (ngayBinhLuan == Long.MIN_VALUE) {
			anPham_BinhLuanImpl.setNgayBinhLuan(null);
		}
		else {
			anPham_BinhLuanImpl.setNgayBinhLuan(new Date(ngayBinhLuan));
		}

		anPham_BinhLuanImpl.setStatus(status);
		anPham_BinhLuanImpl.setOrders(orders);
		anPham_BinhLuanImpl.setDelete_status(delete_status);

		anPham_BinhLuanImpl.resetOriginalValues();

		return anPham_BinhLuanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		anPhamId = objectInput.readLong();
		hoTen = objectInput.readUTF();
		noiDung = objectInput.readUTF();
		ngayBinhLuan = objectInput.readLong();

		status = objectInput.readInt();

		orders = objectInput.readInt();

		delete_status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(anPhamId);

		if (hoTen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hoTen);
		}

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		objectOutput.writeLong(ngayBinhLuan);

		objectOutput.writeInt(status);

		objectOutput.writeInt(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long anPhamId;
	public String hoTen;
	public String noiDung;
	public long ngayBinhLuan;
	public int status;
	public int orders;
	public int delete_status;

}