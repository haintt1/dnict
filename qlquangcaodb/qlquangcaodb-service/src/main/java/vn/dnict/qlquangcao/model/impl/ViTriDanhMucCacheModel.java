/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import vn.dnict.qlquangcao.model.ViTriDanhMuc;

/**
 * The cache model class for representing ViTriDanhMuc in entity cache.
 *
 * @author dnict
 * @generated
 */
public class ViTriDanhMucCacheModel
	implements CacheModel<ViTriDanhMuc>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ViTriDanhMucCacheModel)) {
			return false;
		}

		ViTriDanhMucCacheModel viTriDanhMucCacheModel =
			(ViTriDanhMucCacheModel)object;

		if (id == viTriDanhMucCacheModel.id) {
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
		sb.append(", nguoitao=");
		sb.append(nguoitao);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", cssClass=");
		sb.append(cssClass);
		sb.append(", kichthuoc=");
		sb.append(kichthuoc);
		sb.append(", ngaytao=");
		sb.append(ngaytao);
		sb.append(", daxoa=");
		sb.append(daxoa);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", ngaysua=");
		sb.append(ngaysua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ViTriDanhMuc toEntityModel() {
		ViTriDanhMucImpl viTriDanhMucImpl = new ViTriDanhMucImpl();

		viTriDanhMucImpl.setId(id);
		viTriDanhMucImpl.setCompanyId(companyId);
		viTriDanhMucImpl.setGroupId(groupId);
		viTriDanhMucImpl.setNguoitao(nguoitao);

		if (ten == null) {
			viTriDanhMucImpl.setTen("");
		}
		else {
			viTriDanhMucImpl.setTen(ten);
		}

		if (cssClass == null) {
			viTriDanhMucImpl.setCssClass("");
		}
		else {
			viTriDanhMucImpl.setCssClass(cssClass);
		}

		if (kichthuoc == null) {
			viTriDanhMucImpl.setKichthuoc("");
		}
		else {
			viTriDanhMucImpl.setKichthuoc(kichthuoc);
		}

		if (ngaytao == Long.MIN_VALUE) {
			viTriDanhMucImpl.setNgaytao(null);
		}
		else {
			viTriDanhMucImpl.setNgaytao(new Date(ngaytao));
		}

		viTriDanhMucImpl.setDaxoa(daxoa);
		viTriDanhMucImpl.setTrangthai(trangthai);

		if (ngaysua == Long.MIN_VALUE) {
			viTriDanhMucImpl.setNgaysua(null);
		}
		else {
			viTriDanhMucImpl.setNgaysua(new Date(ngaysua));
		}

		viTriDanhMucImpl.resetOriginalValues();

		return viTriDanhMucImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		nguoitao = objectInput.readLong();
		ten = objectInput.readUTF();
		cssClass = objectInput.readUTF();
		kichthuoc = objectInput.readUTF();
		ngaytao = objectInput.readLong();

		daxoa = objectInput.readInt();

		trangthai = objectInput.readInt();
		ngaysua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(nguoitao);

		if (ten == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ten);
		}

		if (cssClass == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cssClass);
		}

		if (kichthuoc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(kichthuoc);
		}

		objectOutput.writeLong(ngaytao);

		objectOutput.writeInt(daxoa);

		objectOutput.writeInt(trangthai);
		objectOutput.writeLong(ngaysua);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long nguoitao;
	public String ten;
	public String cssClass;
	public String kichthuoc;
	public long ngaytao;
	public int daxoa;
	public int trangthai;
	public long ngaysua;

}