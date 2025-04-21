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

import qlanphamdb.model.AnPham_DinhKemFile;

/**
 * The cache model class for representing AnPham_DinhKemFile in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_DinhKemFileCacheModel
	implements CacheModel<AnPham_DinhKemFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_DinhKemFileCacheModel)) {
			return false;
		}

		AnPham_DinhKemFileCacheModel anPham_DinhKemFileCacheModel =
			(AnPham_DinhKemFileCacheModel)object;

		if (id == anPham_DinhKemFileCacheModel.id) {
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
		StringBundler sb = new StringBundler(25);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", url=");
		sb.append(url);
		sb.append(", Object=");
		sb.append(Object);
		sb.append(", ObjectId=");
		sb.append(ObjectId);
		sb.append(", luotTai=");
		sb.append(luotTai);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnPham_DinhKemFile toEntityModel() {
		AnPham_DinhKemFileImpl anPham_DinhKemFileImpl =
			new AnPham_DinhKemFileImpl();

		anPham_DinhKemFileImpl.setId(id);
		anPham_DinhKemFileImpl.setCompanyId(companyId);
		anPham_DinhKemFileImpl.setGroupId(groupId);
		anPham_DinhKemFileImpl.setUserId(userId);

		if (ten == null) {
			anPham_DinhKemFileImpl.setTen("");
		}
		else {
			anPham_DinhKemFileImpl.setTen(ten);
		}

		if (url == null) {
			anPham_DinhKemFileImpl.setUrl("");
		}
		else {
			anPham_DinhKemFileImpl.setUrl(url);
		}

		anPham_DinhKemFileImpl.setObject(Object);
		anPham_DinhKemFileImpl.setObjectId(ObjectId);
		anPham_DinhKemFileImpl.setLuotTai(luotTai);

		if (ghiChu == null) {
			anPham_DinhKemFileImpl.setGhiChu("");
		}
		else {
			anPham_DinhKemFileImpl.setGhiChu(ghiChu);
		}

		anPham_DinhKemFileImpl.setDelete_status(delete_status);
		anPham_DinhKemFileImpl.setStatus(status);

		anPham_DinhKemFileImpl.resetOriginalValues();

		return anPham_DinhKemFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		ten = objectInput.readUTF();
		url = objectInput.readUTF();

		Object = objectInput.readLong();

		ObjectId = objectInput.readLong();

		luotTai = objectInput.readLong();
		ghiChu = objectInput.readUTF();

		delete_status = objectInput.readInt();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(Object);

		objectOutput.writeLong(ObjectId);

		objectOutput.writeLong(luotTai);

		if (ghiChu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghiChu);
		}

		objectOutput.writeInt(delete_status);

		objectOutput.writeInt(status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long userId;
	public String ten;
	public String url;
	public long Object;
	public long ObjectId;
	public long luotTai;
	public String ghiChu;
	public int delete_status;
	public int status;

}