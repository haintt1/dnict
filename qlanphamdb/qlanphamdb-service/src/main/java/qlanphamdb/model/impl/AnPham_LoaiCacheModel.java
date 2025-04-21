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

import qlanphamdb.model.AnPham_Loai;

/**
 * The cache model class for representing AnPham_Loai in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_LoaiCacheModel
	implements CacheModel<AnPham_Loai>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_LoaiCacheModel)) {
			return false;
		}

		AnPham_LoaiCacheModel anPham_LoaiCacheModel =
			(AnPham_LoaiCacheModel)object;

		if (id == anPham_LoaiCacheModel.id) {
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
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", ten=");
		sb.append(ten);
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
	public AnPham_Loai toEntityModel() {
		AnPham_LoaiImpl anPham_LoaiImpl = new AnPham_LoaiImpl();

		anPham_LoaiImpl.setId(id);
		anPham_LoaiImpl.setGroupId(groupId);
		anPham_LoaiImpl.setCompanyId(companyId);

		if (ten == null) {
			anPham_LoaiImpl.setTen("");
		}
		else {
			anPham_LoaiImpl.setTen(ten);
		}

		anPham_LoaiImpl.setStatus(status);
		anPham_LoaiImpl.setOrders(orders);
		anPham_LoaiImpl.setDelete_status(delete_status);

		anPham_LoaiImpl.resetOriginalValues();

		return anPham_LoaiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		ten = objectInput.readUTF();

		status = objectInput.readInt();

		orders = objectInput.readLong();

		delete_status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long groupId;
	public long companyId;
	public String ten;
	public int status;
	public long orders;
	public int delete_status;

}