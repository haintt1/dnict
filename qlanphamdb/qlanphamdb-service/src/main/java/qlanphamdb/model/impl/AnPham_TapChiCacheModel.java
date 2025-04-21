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

import qlanphamdb.model.AnPham_TapChi;

/**
 * The cache model class for representing AnPham_TapChi in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_TapChiCacheModel
	implements CacheModel<AnPham_TapChi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_TapChiCacheModel)) {
			return false;
		}

		AnPham_TapChiCacheModel anPham_TapChiCacheModel =
			(AnPham_TapChiCacheModel)object;

		if (id == anPham_TapChiCacheModel.id) {
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
		StringBundler sb = new StringBundler(55);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", slug=");
		sb.append(slug);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", anhDaiDien=");
		sb.append(anhDaiDien);
		sb.append(", loaiId=");
		sb.append(loaiId);
		sb.append(", deCuongId=");
		sb.append(deCuongId);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", tuKhoa=");
		sb.append(tuKhoa);
		sb.append(", phienBan=");
		sb.append(phienBan);
		sb.append(", luotXem=");
		sb.append(luotXem);
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
		sb.append(", loaiTin=");
		sb.append(loaiTin);
		sb.append(", isFormHienBinhLuan=");
		sb.append(isFormHienBinhLuan);
		sb.append(", isFormViewBinhLuan=");
		sb.append(isFormViewBinhLuan);
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
	public AnPham_TapChi toEntityModel() {
		AnPham_TapChiImpl anPham_TapChiImpl = new AnPham_TapChiImpl();

		anPham_TapChiImpl.setId(id);
		anPham_TapChiImpl.setGroupId(groupId);
		anPham_TapChiImpl.setCompanyId(companyId);

		if (ten == null) {
			anPham_TapChiImpl.setTen("");
		}
		else {
			anPham_TapChiImpl.setTen(ten);
		}

		if (slug == null) {
			anPham_TapChiImpl.setSlug("");
		}
		else {
			anPham_TapChiImpl.setSlug(slug);
		}

		if (moTa == null) {
			anPham_TapChiImpl.setMoTa("");
		}
		else {
			anPham_TapChiImpl.setMoTa(moTa);
		}

		if (anhDaiDien == null) {
			anPham_TapChiImpl.setAnhDaiDien("");
		}
		else {
			anPham_TapChiImpl.setAnhDaiDien(anhDaiDien);
		}

		anPham_TapChiImpl.setLoaiId(loaiId);
		anPham_TapChiImpl.setDeCuongId(deCuongId);

		if (noiDung == null) {
			anPham_TapChiImpl.setNoiDung("");
		}
		else {
			anPham_TapChiImpl.setNoiDung(noiDung);
		}

		if (tuKhoa == null) {
			anPham_TapChiImpl.setTuKhoa("");
		}
		else {
			anPham_TapChiImpl.setTuKhoa(tuKhoa);
		}

		anPham_TapChiImpl.setPhienBan(phienBan);
		anPham_TapChiImpl.setLuotXem(luotXem);
		anPham_TapChiImpl.setNguoiTao(nguoiTao);

		if (ngayTao == Long.MIN_VALUE) {
			anPham_TapChiImpl.setNgayTao(null);
		}
		else {
			anPham_TapChiImpl.setNgayTao(new Date(ngayTao));
		}

		anPham_TapChiImpl.setNguoiSua(nguoiSua);

		if (ngaySua == Long.MIN_VALUE) {
			anPham_TapChiImpl.setNgaySua(null);
		}
		else {
			anPham_TapChiImpl.setNgaySua(new Date(ngaySua));
		}

		anPham_TapChiImpl.setNguoiNhan(nguoiNhan);
		anPham_TapChiImpl.setNguoiXuLy(nguoiXuLy);

		if (ngayXuLy == Long.MIN_VALUE) {
			anPham_TapChiImpl.setNgayXuLy(null);
		}
		else {
			anPham_TapChiImpl.setNgayXuLy(new Date(ngayXuLy));
		}

		if (language == null) {
			anPham_TapChiImpl.setLanguage("");
		}
		else {
			anPham_TapChiImpl.setLanguage(language);
		}

		anPham_TapChiImpl.setLoaiTin(loaiTin);
		anPham_TapChiImpl.setIsFormHienBinhLuan(isFormHienBinhLuan);
		anPham_TapChiImpl.setIsFormViewBinhLuan(isFormViewBinhLuan);
		anPham_TapChiImpl.setStatus(status);
		anPham_TapChiImpl.setOrders(orders);
		anPham_TapChiImpl.setDelete_status(delete_status);

		anPham_TapChiImpl.resetOriginalValues();

		return anPham_TapChiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		ten = objectInput.readUTF();
		slug = objectInput.readUTF();
		moTa = objectInput.readUTF();
		anhDaiDien = objectInput.readUTF();

		loaiId = objectInput.readLong();

		deCuongId = objectInput.readLong();
		noiDung = objectInput.readUTF();
		tuKhoa = objectInput.readUTF();

		phienBan = objectInput.readLong();

		luotXem = objectInput.readLong();

		nguoiTao = objectInput.readLong();
		ngayTao = objectInput.readLong();

		nguoiSua = objectInput.readLong();
		ngaySua = objectInput.readLong();

		nguoiNhan = objectInput.readLong();

		nguoiXuLy = objectInput.readLong();
		ngayXuLy = objectInput.readLong();
		language = objectInput.readUTF();

		loaiTin = objectInput.readInt();

		isFormHienBinhLuan = objectInput.readInt();

		isFormViewBinhLuan = objectInput.readInt();

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

		if (slug == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(slug);
		}

		if (moTa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(moTa);
		}

		if (anhDaiDien == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(anhDaiDien);
		}

		objectOutput.writeLong(loaiId);

		objectOutput.writeLong(deCuongId);

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		if (tuKhoa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tuKhoa);
		}

		objectOutput.writeLong(phienBan);

		objectOutput.writeLong(luotXem);

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

		objectOutput.writeInt(loaiTin);

		objectOutput.writeInt(isFormHienBinhLuan);

		objectOutput.writeInt(isFormViewBinhLuan);

		objectOutput.writeInt(status);

		objectOutput.writeLong(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long groupId;
	public long companyId;
	public String ten;
	public String slug;
	public String moTa;
	public String anhDaiDien;
	public long loaiId;
	public long deCuongId;
	public String noiDung;
	public String tuKhoa;
	public long phienBan;
	public long luotXem;
	public long nguoiTao;
	public long ngayTao;
	public long nguoiSua;
	public long ngaySua;
	public long nguoiNhan;
	public long nguoiXuLy;
	public long ngayXuLy;
	public String language;
	public int loaiTin;
	public int isFormHienBinhLuan;
	public int isFormViewBinhLuan;
	public int status;
	public long orders;
	public int delete_status;

}