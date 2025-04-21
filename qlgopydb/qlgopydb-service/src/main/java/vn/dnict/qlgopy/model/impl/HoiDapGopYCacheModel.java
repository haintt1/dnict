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

import java.util.Date;

import vn.dnict.qlgopy.model.HoiDapGopY;

/**
 * The cache model class for representing HoiDapGopY in entity cache.
 *
 * @author dnict
 * @generated
 */
public class HoiDapGopYCacheModel
	implements CacheModel<HoiDapGopY>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HoiDapGopYCacheModel)) {
			return false;
		}

		HoiDapGopYCacheModel hoiDapGopYCacheModel =
			(HoiDapGopYCacheModel)object;

		if (id == hoiDapGopYCacheModel.id) {
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
		StringBundler sb = new StringBundler(31);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", tencoquan=");
		sb.append(tencoquan);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", title=");
		sb.append(title);
		sb.append(", content=");
		sb.append(content);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", ngay_guigopy=");
		sb.append(ngay_guigopy);
		sb.append(", ngay_traloigopy=");
		sb.append(ngay_traloigopy);
		sb.append(", typeForm=");
		sb.append(typeForm);
		sb.append(", is_traloi=");
		sb.append(is_traloi);
		sb.append(", is_pheduyet=");
		sb.append(is_pheduyet);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public HoiDapGopY toEntityModel() {
		HoiDapGopYImpl hoiDapGopYImpl = new HoiDapGopYImpl();

		hoiDapGopYImpl.setId(id);
		hoiDapGopYImpl.setCompanyId(companyId);
		hoiDapGopYImpl.setGroupId(groupId);

		if (name == null) {
			hoiDapGopYImpl.setName("");
		}
		else {
			hoiDapGopYImpl.setName(name);
		}

		if (tencoquan == null) {
			hoiDapGopYImpl.setTencoquan("");
		}
		else {
			hoiDapGopYImpl.setTencoquan(tencoquan);
		}

		if (phone == null) {
			hoiDapGopYImpl.setPhone("");
		}
		else {
			hoiDapGopYImpl.setPhone(phone);
		}

		if (email == null) {
			hoiDapGopYImpl.setEmail("");
		}
		else {
			hoiDapGopYImpl.setEmail(email);
		}

		if (title == null) {
			hoiDapGopYImpl.setTitle("");
		}
		else {
			hoiDapGopYImpl.setTitle(title);
		}

		if (content == null) {
			hoiDapGopYImpl.setContent("");
		}
		else {
			hoiDapGopYImpl.setContent(content);
		}

		if (answer == null) {
			hoiDapGopYImpl.setAnswer("");
		}
		else {
			hoiDapGopYImpl.setAnswer(answer);
		}

		if (ngay_guigopy == Long.MIN_VALUE) {
			hoiDapGopYImpl.setNgay_guigopy(null);
		}
		else {
			hoiDapGopYImpl.setNgay_guigopy(new Date(ngay_guigopy));
		}

		if (ngay_traloigopy == Long.MIN_VALUE) {
			hoiDapGopYImpl.setNgay_traloigopy(null);
		}
		else {
			hoiDapGopYImpl.setNgay_traloigopy(new Date(ngay_traloigopy));
		}

		hoiDapGopYImpl.setTypeForm(typeForm);
		hoiDapGopYImpl.setIs_traloi(is_traloi);
		hoiDapGopYImpl.setIs_pheduyet(is_pheduyet);

		hoiDapGopYImpl.resetOriginalValues();

		return hoiDapGopYImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		tencoquan = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		title = objectInput.readUTF();
		content = objectInput.readUTF();
		answer = objectInput.readUTF();
		ngay_guigopy = objectInput.readLong();
		ngay_traloigopy = objectInput.readLong();

		typeForm = objectInput.readInt();

		is_traloi = objectInput.readInt();

		is_pheduyet = objectInput.readInt();
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

		if (tencoquan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tencoquan);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(answer);
		}

		objectOutput.writeLong(ngay_guigopy);
		objectOutput.writeLong(ngay_traloigopy);

		objectOutput.writeInt(typeForm);

		objectOutput.writeInt(is_traloi);

		objectOutput.writeInt(is_pheduyet);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String name;
	public String tencoquan;
	public String phone;
	public String email;
	public String title;
	public String content;
	public String answer;
	public long ngay_guigopy;
	public long ngay_traloigopy;
	public int typeForm;
	public int is_traloi;
	public int is_pheduyet;

}