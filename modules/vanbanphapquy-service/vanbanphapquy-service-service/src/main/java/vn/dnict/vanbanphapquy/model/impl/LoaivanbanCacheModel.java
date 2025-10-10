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

package vn.dnict.vanbanphapquy.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import vn.dnict.vanbanphapquy.model.Loaivanban;

/**
 * The cache model class for representing Loaivanban in entity cache.
 *
 * @author BinhNT
 * @generated
 */
public class LoaivanbanCacheModel
	implements CacheModel<Loaivanban>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LoaivanbanCacheModel)) {
			return false;
		}

		LoaivanbanCacheModel loaivanbanCacheModel =
			(LoaivanbanCacheModel)object;

		if (id == loaivanbanCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", code=");
		sb.append(code);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Loaivanban toEntityModel() {
		LoaivanbanImpl loaivanbanImpl = new LoaivanbanImpl();

		loaivanbanImpl.setId(id);
		loaivanbanImpl.setCompanyId(companyId);
		loaivanbanImpl.setGroupId(groupId);

		if (name == null) {
			loaivanbanImpl.setName("");
		}
		else {
			loaivanbanImpl.setName(name);
		}

		if (code == null) {
			loaivanbanImpl.setCode("");
		}
		else {
			loaivanbanImpl.setCode(code);
		}

		loaivanbanImpl.setStatus(status);

		loaivanbanImpl.resetOriginalValues();

		return loaivanbanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		code = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (code == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(code);
		}

		objectOutput.writeInt(status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String name;
	public String code;
	public int status;

}