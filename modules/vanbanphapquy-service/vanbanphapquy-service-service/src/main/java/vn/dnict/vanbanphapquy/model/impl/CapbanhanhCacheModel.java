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

import vn.dnict.vanbanphapquy.model.Capbanhanh;

/**
 * The cache model class for representing Capbanhanh in entity cache.
 *
 * @author BinhNT
 * @generated
 */
public class CapbanhanhCacheModel
	implements CacheModel<Capbanhanh>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CapbanhanhCacheModel)) {
			return false;
		}

		CapbanhanhCacheModel capbanhanhCacheModel =
			(CapbanhanhCacheModel)object;

		if (id == capbanhanhCacheModel.id) {
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
	public Capbanhanh toEntityModel() {
		CapbanhanhImpl capbanhanhImpl = new CapbanhanhImpl();

		capbanhanhImpl.setId(id);
		capbanhanhImpl.setCompanyId(companyId);
		capbanhanhImpl.setGroupId(groupId);

		if (name == null) {
			capbanhanhImpl.setName("");
		}
		else {
			capbanhanhImpl.setName(name);
		}

		if (code == null) {
			capbanhanhImpl.setCode("");
		}
		else {
			capbanhanhImpl.setCode(code);
		}

		capbanhanhImpl.setStatus(status);

		capbanhanhImpl.resetOriginalValues();

		return capbanhanhImpl;
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