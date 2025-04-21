/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model.impl;

import cms.quanlyvideo.model.ChuDe;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChuDe in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ChuDeCacheModel implements CacheModel<ChuDe>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ChuDeCacheModel)) {
			return false;
		}

		ChuDeCacheModel chuDeCacheModel = (ChuDeCacheModel)object;

		if (id == chuDeCacheModel.id) {
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
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ChuDe toEntityModel() {
		ChuDeImpl chuDeImpl = new ChuDeImpl();

		chuDeImpl.setId(id);
		chuDeImpl.setGroupId(groupId);
		chuDeImpl.setCompanyId(companyId);
		chuDeImpl.setUserId(userId);

		if (ten == null) {
			chuDeImpl.setTen("");
		}
		else {
			chuDeImpl.setTen(ten);
		}

		if (moTa == null) {
			chuDeImpl.setMoTa("");
		}
		else {
			chuDeImpl.setMoTa(moTa);
		}

		chuDeImpl.setTrangThai(trangThai);
		chuDeImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			chuDeImpl.setNgayTao(null);
		}
		else {
			chuDeImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			chuDeImpl.setNgaySua(null);
		}
		else {
			chuDeImpl.setNgaySua(new Date(ngaySua));
		}

		chuDeImpl.resetOriginalValues();

		return chuDeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();

		trangThai = objectInput.readLong();

		daXoa = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		objectOutput.writeLong(trangThai);

		objectOutput.writeLong(daXoa);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
	}

	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String ten;
	public String moTa;
	public long trangThai;
	public long daXoa;
	public long ngayTao;
	public long ngaySua;

}