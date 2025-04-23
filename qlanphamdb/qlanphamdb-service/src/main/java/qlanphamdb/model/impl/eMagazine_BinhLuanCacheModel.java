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

import qlanphamdb.model.eMagazine_BinhLuan;

/**
 * The cache model class for representing eMagazine_BinhLuan in entity cache.
 *
 * @author dnict
 * @generated
 */
public class eMagazine_BinhLuanCacheModel
	implements CacheModel<eMagazine_BinhLuan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof eMagazine_BinhLuanCacheModel)) {
			return false;
		}

		eMagazine_BinhLuanCacheModel eMagazine_BinhLuanCacheModel =
			(eMagazine_BinhLuanCacheModel)object;

		if (id == eMagazine_BinhLuanCacheModel.id) {
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
		sb.append(", magazineId=");
		sb.append(magazineId);
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
	public eMagazine_BinhLuan toEntityModel() {
		eMagazine_BinhLuanImpl eMagazine_BinhLuanImpl =
			new eMagazine_BinhLuanImpl();

		eMagazine_BinhLuanImpl.setId(id);
		eMagazine_BinhLuanImpl.setCompanyId(companyId);
		eMagazine_BinhLuanImpl.setGroupId(groupId);
		eMagazine_BinhLuanImpl.setMagazineId(magazineId);

		if (hoTen == null) {
			eMagazine_BinhLuanImpl.setHoTen("");
		}
		else {
			eMagazine_BinhLuanImpl.setHoTen(hoTen);
		}

		if (noiDung == null) {
			eMagazine_BinhLuanImpl.setNoiDung("");
		}
		else {
			eMagazine_BinhLuanImpl.setNoiDung(noiDung);
		}

		if (ngayBinhLuan == Long.MIN_VALUE) {
			eMagazine_BinhLuanImpl.setNgayBinhLuan(null);
		}
		else {
			eMagazine_BinhLuanImpl.setNgayBinhLuan(new Date(ngayBinhLuan));
		}

		eMagazine_BinhLuanImpl.setStatus(status);
		eMagazine_BinhLuanImpl.setOrders(orders);
		eMagazine_BinhLuanImpl.setDelete_status(delete_status);

		eMagazine_BinhLuanImpl.resetOriginalValues();

		return eMagazine_BinhLuanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		magazineId = objectInput.readLong();
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

		objectOutput.writeLong(magazineId);

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
	public long magazineId;
	public String hoTen;
	public String noiDung;
	public long ngayBinhLuan;
	public int status;
	public int orders;
	public int delete_status;

}