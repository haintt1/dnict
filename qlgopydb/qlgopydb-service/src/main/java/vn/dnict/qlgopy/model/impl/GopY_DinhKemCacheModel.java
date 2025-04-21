/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import vn.dnict.qlgopy.model.GopY_DinhKem;

/**
 * The cache model class for representing GopY_DinhKem in entity cache.
 *
 * @author dnict
 * @generated
 */
public class GopY_DinhKemCacheModel
	implements CacheModel<GopY_DinhKem>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof GopY_DinhKemCacheModel)) {
			return false;
		}

		GopY_DinhKemCacheModel gopY_DinhKemCacheModel =
			(GopY_DinhKemCacheModel)object;

		if (id == gopY_DinhKemCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

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
		sb.append(", ghichu=");
		sb.append(ghichu);
		sb.append(", daxoa=");
		sb.append(daxoa);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GopY_DinhKem toEntityModel() {
		GopY_DinhKemImpl gopY_DinhKemImpl = new GopY_DinhKemImpl();

		gopY_DinhKemImpl.setId(id);
		gopY_DinhKemImpl.setCompanyId(companyId);
		gopY_DinhKemImpl.setGroupId(groupId);
		gopY_DinhKemImpl.setUserId(userId);

		if (ten == null) {
			gopY_DinhKemImpl.setTen("");
		}
		else {
			gopY_DinhKemImpl.setTen(ten);
		}

		if (url == null) {
			gopY_DinhKemImpl.setUrl("");
		}
		else {
			gopY_DinhKemImpl.setUrl(url);
		}

		gopY_DinhKemImpl.setObject(Object);
		gopY_DinhKemImpl.setObjectId(ObjectId);

		if (ghichu == null) {
			gopY_DinhKemImpl.setGhichu("");
		}
		else {
			gopY_DinhKemImpl.setGhichu(ghichu);
		}

		gopY_DinhKemImpl.setDaxoa(daxoa);
		gopY_DinhKemImpl.setStatus(status);

		gopY_DinhKemImpl.resetOriginalValues();

		return gopY_DinhKemImpl;
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
		ghichu = objectInput.readUTF();

		daxoa = objectInput.readInt();

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

		if (ghichu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghichu);
		}

		objectOutput.writeInt(daxoa);

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
	public String ghichu;
	public int daxoa;
	public int status;

}