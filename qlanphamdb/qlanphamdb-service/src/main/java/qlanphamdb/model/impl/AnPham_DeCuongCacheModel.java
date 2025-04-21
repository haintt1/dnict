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

import qlanphamdb.model.AnPham_DeCuong;

/**
 * The cache model class for representing AnPham_DeCuong in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_DeCuongCacheModel
	implements CacheModel<AnPham_DeCuong>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_DeCuongCacheModel)) {
			return false;
		}

		AnPham_DeCuongCacheModel anPham_DeCuongCacheModel =
			(AnPham_DeCuongCacheModel)object;

		if (id == anPham_DeCuongCacheModel.id) {
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
		StringBundler sb = new StringBundler(39);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", nguoiTao=");
		sb.append(nguoiTao);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", nguoiSua=");
		sb.append(nguoiSua);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append(", nguoiNhan=");
		sb.append(nguoiNhan);
		sb.append(", nguoiXuLy=");
		sb.append(nguoiXuLy);
		sb.append(", ngayXuLy=");
		sb.append(ngayXuLy);
		sb.append(", language=");
		sb.append(language);
		sb.append(", status=");
		sb.append(status);
		sb.append(", orders=");
		sb.append(orders);
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AnPham_DeCuong toEntityModel() {
		AnPham_DeCuongImpl anPham_DeCuongImpl = new AnPham_DeCuongImpl();

		anPham_DeCuongImpl.setId(id);
		anPham_DeCuongImpl.setGroupId(groupId);
		anPham_DeCuongImpl.setCompanyId(companyId);

		if (ten == null) {
			anPham_DeCuongImpl.setTen("");
		}
		else {
			anPham_DeCuongImpl.setTen(ten);
		}

		if (moTa == null) {
			anPham_DeCuongImpl.setMoTa("");
		}
		else {
			anPham_DeCuongImpl.setMoTa(moTa);
		}

		anPham_DeCuongImpl.setLoaiId(loaiId);

		if (noiDung == null) {
			anPham_DeCuongImpl.setNoiDung("");
		}
		else {
			anPham_DeCuongImpl.setNoiDung(noiDung);
		}

		anPham_DeCuongImpl.setPhienBan(phienBan);
		anPham_DeCuongImpl.setNguoiTao(nguoiTao);

		if (ngayTao == Long.MIN_VALUE) {
			anPham_DeCuongImpl.setNgayTao(null);
		}
		else {
			anPham_DeCuongImpl.setNgayTao(new Date(ngayTao));
		}

		anPham_DeCuongImpl.setNguoiSua(nguoiSua);

		if (ngaySua == Long.MIN_VALUE) {
			anPham_DeCuongImpl.setNgaySua(null);
		}
		else {
			anPham_DeCuongImpl.setNgaySua(new Date(ngaySua));
		}

		anPham_DeCuongImpl.setNguoiNhan(nguoiNhan);
		anPham_DeCuongImpl.setNguoiXuLy(nguoiXuLy);

		if (ngayXuLy == Long.MIN_VALUE) {
			anPham_DeCuongImpl.setNgayXuLy(null);
		}
		else {
			anPham_DeCuongImpl.setNgayXuLy(new Date(ngayXuLy));
		}

		if (language == null) {
			anPham_DeCuongImpl.setLanguage("");
		}
		else {
			anPham_DeCuongImpl.setLanguage(language);
		}

		anPham_DeCuongImpl.setStatus(status);
		anPham_DeCuongImpl.setOrders(orders);
		anPham_DeCuongImpl.setDelete_status(delete_status);

		anPham_DeCuongImpl.resetOriginalValues();

		return anPham_DeCuongImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();

		loaiId = objectInput.readLong();
		noiDung = objectInput.readUTF();

		phienBan = objectInput.readLong();

		nguoiTao = objectInput.readLong();
		ngayTao = objectInput.readLong();

		nguoiSua = objectInput.readLong();
		ngaySua = objectInput.readLong();

		nguoiNhan = objectInput.readLong();

		nguoiXuLy = objectInput.readLong();
		ngayXuLy = objectInput.readLong();
		language = objectInput.readUTF();

		status = objectInput.readInt();

		orders = objectInput.readLong();

		delete_status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

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

		objectOutput.writeLong(loaiId);

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		objectOutput.writeLong(phienBan);

		objectOutput.writeLong(nguoiTao);
		objectOutput.writeLong(ngayTao);

		objectOutput.writeLong(nguoiSua);
		objectOutput.writeLong(ngaySua);

		objectOutput.writeLong(nguoiNhan);

		objectOutput.writeLong(nguoiXuLy);
		objectOutput.writeLong(ngayXuLy);

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeInt(status);

		objectOutput.writeLong(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long groupId;
	public long companyId;
	public String ten;
	public String moTa;
	public long loaiId;
	public String noiDung;
	public long phienBan;
	public long nguoiTao;
	public long ngayTao;
	public long nguoiSua;
	public long ngaySua;
	public long nguoiNhan;
	public long nguoiXuLy;
	public long ngayXuLy;
	public String language;
	public int status;
	public long orders;
	public int delete_status;

}