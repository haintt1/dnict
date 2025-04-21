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

import qlanphamdb.model.eMagazine_template;

/**
 * The cache model class for representing eMagazine_template in entity cache.
 *
 * @author dnict
 * @generated
 */
public class eMagazine_templateCacheModel
	implements CacheModel<eMagazine_template>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof eMagazine_templateCacheModel)) {
			return false;
		}

		eMagazine_templateCacheModel eMagazine_templateCacheModel =
			(eMagazine_templateCacheModel)object;

		if (id == eMagazine_templateCacheModel.id) {
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
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", noidung=");
		sb.append(noidung);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public eMagazine_template toEntityModel() {
		eMagazine_templateImpl eMagazine_templateImpl =
			new eMagazine_templateImpl();

		eMagazine_templateImpl.setId(id);
		eMagazine_templateImpl.setCompanyId(companyId);
		eMagazine_templateImpl.setGroupId(groupId);

		if (ten == null) {
			eMagazine_templateImpl.setTen("");
		}
		else {
			eMagazine_templateImpl.setTen(ten);
		}

		if (noidung == null) {
			eMagazine_templateImpl.setNoidung("");
		}
		else {
			eMagazine_templateImpl.setNoidung(noidung);
		}

		eMagazine_templateImpl.setStatus(status);

		eMagazine_templateImpl.resetOriginalValues();

		return eMagazine_templateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		ten = objectInput.readUTF();
		noidung = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (noidung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noidung);
		}

		objectOutput.writeInt(status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String ten;
	public String noidung;
	public int status;

}