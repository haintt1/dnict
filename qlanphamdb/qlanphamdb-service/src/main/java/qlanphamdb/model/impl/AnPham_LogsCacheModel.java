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

import qlanphamdb.model.AnPham_Logs;

/**
 * The cache model class for representing AnPham_Logs in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_LogsCacheModel
	implements CacheModel<AnPham_Logs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_LogsCacheModel)) {
			return false;
		}

		AnPham_LogsCacheModel anPham_LogsCacheModel =
			(AnPham_LogsCacheModel)object;

		if (id == anPham_LogsCacheModel.id) {
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
		StringBundler sb = new StringBundler(61);

		sb.append("{id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", activityId=");
		sb.append(activityId);
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
		sb.append(", anPhamId=");
		sb.append(anPhamId);
		sb.append(", noiDungLog=");
		sb.append(noiDungLog);
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
	public AnPham_Logs toEntityModel() {
		AnPham_LogsImpl anPham_LogsImpl = new AnPham_LogsImpl();

		anPham_LogsImpl.setId(id);
		anPham_LogsImpl.setGroupId(groupId);
		anPham_LogsImpl.setCompanyId(companyId);
		anPham_LogsImpl.setActivityId(activityId);

		if (ten == null) {
			anPham_LogsImpl.setTen("");
		}
		else {
			anPham_LogsImpl.setTen(ten);
		}

		if (slug == null) {
			anPham_LogsImpl.setSlug("");
		}
		else {
			anPham_LogsImpl.setSlug(slug);
		}

		if (moTa == null) {
			anPham_LogsImpl.setMoTa("");
		}
		else {
			anPham_LogsImpl.setMoTa(moTa);
		}

		if (anhDaiDien == null) {
			anPham_LogsImpl.setAnhDaiDien("");
		}
		else {
			anPham_LogsImpl.setAnhDaiDien(anhDaiDien);
		}

		anPham_LogsImpl.setLoaiId(loaiId);
		anPham_LogsImpl.setDeCuongId(deCuongId);

		if (noiDung == null) {
			anPham_LogsImpl.setNoiDung("");
		}
		else {
			anPham_LogsImpl.setNoiDung(noiDung);
		}

		if (tuKhoa == null) {
			anPham_LogsImpl.setTuKhoa("");
		}
		else {
			anPham_LogsImpl.setTuKhoa(tuKhoa);
		}

		anPham_LogsImpl.setPhienBan(phienBan);
		anPham_LogsImpl.setLuotXem(luotXem);
		anPham_LogsImpl.setAnPhamId(anPhamId);

		if (noiDungLog == null) {
			anPham_LogsImpl.setNoiDungLog("");
		}
		else {
			anPham_LogsImpl.setNoiDungLog(noiDungLog);
		}

		anPham_LogsImpl.setNguoiTao(nguoiTao);

		if (ngayTao == Long.MIN_VALUE) {
			anPham_LogsImpl.setNgayTao(null);
		}
		else {
			anPham_LogsImpl.setNgayTao(new Date(ngayTao));
		}

		anPham_LogsImpl.setNguoiSua(nguoiSua);

		if (ngaySua == Long.MIN_VALUE) {
			anPham_LogsImpl.setNgaySua(null);
		}
		else {
			anPham_LogsImpl.setNgaySua(new Date(ngaySua));
		}

		anPham_LogsImpl.setNguoiNhan(nguoiNhan);
		anPham_LogsImpl.setNguoiXuLy(nguoiXuLy);

		if (ngayXuLy == Long.MIN_VALUE) {
			anPham_LogsImpl.setNgayXuLy(null);
		}
		else {
			anPham_LogsImpl.setNgayXuLy(new Date(ngayXuLy));
		}

		if (language == null) {
			anPham_LogsImpl.setLanguage("");
		}
		else {
			anPham_LogsImpl.setLanguage(language);
		}

		anPham_LogsImpl.setLoaiTin(loaiTin);
		anPham_LogsImpl.setIsFormHienBinhLuan(isFormHienBinhLuan);
		anPham_LogsImpl.setIsFormViewBinhLuan(isFormViewBinhLuan);
		anPham_LogsImpl.setStatus(status);
		anPham_LogsImpl.setOrders(orders);
		anPham_LogsImpl.setDelete_status(delete_status);

		anPham_LogsImpl.resetOriginalValues();

		return anPham_LogsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		activityId = objectInput.readLong();
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

		anPhamId = objectInput.readLong();
		noiDungLog = objectInput.readUTF();

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

		objectOutput.writeLong(activityId);

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

		objectOutput.writeLong(anPhamId);

		if (noiDungLog == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDungLog);
		}

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
	public long activityId;
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
	public long anPhamId;
	public String noiDungLog;
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