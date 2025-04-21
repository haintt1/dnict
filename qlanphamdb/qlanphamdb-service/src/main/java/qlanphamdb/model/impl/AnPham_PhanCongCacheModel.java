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

import java.util.Date;

import qlanphamdb.model.AnPham_PhanCong;

/**
 * The cache model class for representing AnPham_PhanCong in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_PhanCongCacheModel
	implements CacheModel<AnPham_PhanCong>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_PhanCongCacheModel)) {
			return false;
		}

		AnPham_PhanCongCacheModel anPham_PhanCongCacheModel =
			(AnPham_PhanCongCacheModel)object;

		if (id == anPham_PhanCongCacheModel.id) {
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
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", deCuongId=");
		sb.append(deCuongId);
		sb.append(", ctvId=");
		sb.append(ctvId);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", ghiChu=");
		sb.append(ghiChu);
		sb.append(", ngaybatdau=");
		sb.append(ngaybatdau);
		sb.append(", ngayketthuc=");
		sb.append(ngayketthuc);
		sb.append(", status=");
		sb.append(status);
		sb.append(", is_gui=");
		sb.append(is_gui);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnPham_PhanCong toEntityModel() {
		AnPham_PhanCongImpl anPham_PhanCongImpl = new AnPham_PhanCongImpl();

		anPham_PhanCongImpl.setId(id);
		anPham_PhanCongImpl.setCompanyId(companyId);
		anPham_PhanCongImpl.setGroupId(groupId);
		anPham_PhanCongImpl.setLoaiId(loaiId);
		anPham_PhanCongImpl.setDeCuongId(deCuongId);
		anPham_PhanCongImpl.setCtvId(ctvId);

		if (noiDung == null) {
			anPham_PhanCongImpl.setNoiDung("");
		}
		else {
			anPham_PhanCongImpl.setNoiDung(noiDung);
		}

		if (ghiChu == null) {
			anPham_PhanCongImpl.setGhiChu("");
		}
		else {
			anPham_PhanCongImpl.setGhiChu(ghiChu);
		}

		if (ngaybatdau == Long.MIN_VALUE) {
			anPham_PhanCongImpl.setNgaybatdau(null);
		}
		else {
			anPham_PhanCongImpl.setNgaybatdau(new Date(ngaybatdau));
		}

		if (ngayketthuc == Long.MIN_VALUE) {
			anPham_PhanCongImpl.setNgayketthuc(null);
		}
		else {
			anPham_PhanCongImpl.setNgayketthuc(new Date(ngayketthuc));
		}

		anPham_PhanCongImpl.setStatus(status);
		anPham_PhanCongImpl.setIs_gui(is_gui);

		anPham_PhanCongImpl.resetOriginalValues();

		return anPham_PhanCongImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		loaiId = objectInput.readLong();

		deCuongId = objectInput.readLong();

		ctvId = objectInput.readLong();
		noiDung = objectInput.readUTF();
		ghiChu = objectInput.readUTF();
		ngaybatdau = objectInput.readLong();
		ngayketthuc = objectInput.readLong();

		status = objectInput.readInt();

		is_gui = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(loaiId);

		objectOutput.writeLong(deCuongId);

		objectOutput.writeLong(ctvId);

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		if (ghiChu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghiChu);
		}

		objectOutput.writeLong(ngaybatdau);
		objectOutput.writeLong(ngayketthuc);

		objectOutput.writeInt(status);

		objectOutput.writeInt(is_gui);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long loaiId;
	public long deCuongId;
	public long ctvId;
	public String noiDung;
	public String ghiChu;
	public long ngaybatdau;
	public long ngayketthuc;
	public int status;
	public int is_gui;

}