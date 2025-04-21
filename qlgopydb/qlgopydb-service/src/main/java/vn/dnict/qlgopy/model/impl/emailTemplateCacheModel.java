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

import vn.dnict.qlgopy.model.emailTemplate;

/**
 * The cache model class for representing emailTemplate in entity cache.
 *
 * @author dnict
 * @generated
 */
public class emailTemplateCacheModel
	implements CacheModel<emailTemplate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof emailTemplateCacheModel)) {
			return false;
		}

		emailTemplateCacheModel emailTemplateCacheModel =
			(emailTemplateCacheModel)object;

		if (id == emailTemplateCacheModel.id) {
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
		sb.append(", loai=");
		sb.append(loai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public emailTemplate toEntityModel() {
		emailTemplateImpl emailTemplateImpl = new emailTemplateImpl();

		emailTemplateImpl.setId(id);
		emailTemplateImpl.setCompanyId(companyId);
		emailTemplateImpl.setGroupId(groupId);

		if (ten == null) {
			emailTemplateImpl.setTen("");
		}
		else {
			emailTemplateImpl.setTen(ten);
		}

		if (noidung == null) {
			emailTemplateImpl.setNoidung("");
		}
		else {
			emailTemplateImpl.setNoidung(noidung);
		}

		emailTemplateImpl.setLoai(loai);

		emailTemplateImpl.resetOriginalValues();

		return emailTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		ten = objectInput.readUTF();
		noidung = objectInput.readUTF();

		loai = objectInput.readInt();
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

		objectOutput.writeInt(loai);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String ten;
	public String noidung;
	public int loai;

}