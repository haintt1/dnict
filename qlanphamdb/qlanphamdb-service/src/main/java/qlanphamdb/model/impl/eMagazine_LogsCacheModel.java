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

import qlanphamdb.model.eMagazine_Logs;

/**
 * The cache model class for representing eMagazine_Logs in entity cache.
 *
 * @author dnict
 * @generated
 */
public class eMagazine_LogsCacheModel
	implements CacheModel<eMagazine_Logs>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof eMagazine_LogsCacheModel)) {
			return false;
		}

		eMagazine_LogsCacheModel eMagazine_LogsCacheModel =
			(eMagazine_LogsCacheModel)object;

		if (id == eMagazine_LogsCacheModel.id) {
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
		sb.append(", mauChuDao=");
		sb.append(mauChuDao);
		sb.append(", hinhNen=");
		sb.append(hinhNen);
		sb.append(", templateId=");
		sb.append(templateId);
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
	public eMagazine_Logs toEntityModel() {
		eMagazine_LogsImpl eMagazine_LogsImpl = new eMagazine_LogsImpl();

		eMagazine_LogsImpl.setId(id);
		eMagazine_LogsImpl.setGroupId(groupId);
		eMagazine_LogsImpl.setCompanyId(companyId);

		if (ten == null) {
			eMagazine_LogsImpl.setTen("");
		}
		else {
			eMagazine_LogsImpl.setTen(ten);
		}

		if (slug == null) {
			eMagazine_LogsImpl.setSlug("");
		}
		else {
			eMagazine_LogsImpl.setSlug(slug);
		}

		if (moTa == null) {
			eMagazine_LogsImpl.setMoTa("");
		}
		else {
			eMagazine_LogsImpl.setMoTa(moTa);
		}

		if (anhDaiDien == null) {
			eMagazine_LogsImpl.setAnhDaiDien("");
		}
		else {
			eMagazine_LogsImpl.setAnhDaiDien(anhDaiDien);
		}

		if (mauChuDao == null) {
			eMagazine_LogsImpl.setMauChuDao("");
		}
		else {
			eMagazine_LogsImpl.setMauChuDao(mauChuDao);
		}

		if (hinhNen == null) {
			eMagazine_LogsImpl.setHinhNen("");
		}
		else {
			eMagazine_LogsImpl.setHinhNen(hinhNen);
		}

		eMagazine_LogsImpl.setTemplateId(templateId);

		if (noiDung == null) {
			eMagazine_LogsImpl.setNoiDung("");
		}
		else {
			eMagazine_LogsImpl.setNoiDung(noiDung);
		}

		if (tuKhoa == null) {
			eMagazine_LogsImpl.setTuKhoa("");
		}
		else {
			eMagazine_LogsImpl.setTuKhoa(tuKhoa);
		}

		eMagazine_LogsImpl.setPhienBan(phienBan);
		eMagazine_LogsImpl.setLuotXem(luotXem);
		eMagazine_LogsImpl.setNguoiTao(nguoiTao);

		if (ngayTao == Long.MIN_VALUE) {
			eMagazine_LogsImpl.setNgayTao(null);
		}
		else {
			eMagazine_LogsImpl.setNgayTao(new Date(ngayTao));
		}

		eMagazine_LogsImpl.setNguoiSua(nguoiSua);

		if (ngaySua == Long.MIN_VALUE) {
			eMagazine_LogsImpl.setNgaySua(null);
		}
		else {
			eMagazine_LogsImpl.setNgaySua(new Date(ngaySua));
		}

		eMagazine_LogsImpl.setNguoiNhan(nguoiNhan);
		eMagazine_LogsImpl.setNguoiXuLy(nguoiXuLy);

		if (ngayXuLy == Long.MIN_VALUE) {
			eMagazine_LogsImpl.setNgayXuLy(null);
		}
		else {
			eMagazine_LogsImpl.setNgayXuLy(new Date(ngayXuLy));
		}

		if (language == null) {
			eMagazine_LogsImpl.setLanguage("");
		}
		else {
			eMagazine_LogsImpl.setLanguage(language);
		}

		eMagazine_LogsImpl.setIsFormHienBinhLuan(isFormHienBinhLuan);
		eMagazine_LogsImpl.setIsFormViewBinhLuan(isFormViewBinhLuan);
		eMagazine_LogsImpl.setStatus(status);
		eMagazine_LogsImpl.setOrders(orders);
		eMagazine_LogsImpl.setDelete_status(delete_status);

		eMagazine_LogsImpl.resetOriginalValues();

		return eMagazine_LogsImpl;
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
		mauChuDao = objectInput.readUTF();
		hinhNen = objectInput.readUTF();

		templateId = objectInput.readLong();
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

		if (mauChuDao == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mauChuDao);
		}

		if (hinhNen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hinhNen);
		}

		objectOutput.writeLong(templateId);

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
	public String mauChuDao;
	public String hinhNen;
	public long templateId;
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
	public int isFormHienBinhLuan;
	public int isFormViewBinhLuan;
	public int status;
	public long orders;
	public int delete_status;

}