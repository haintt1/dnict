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

import qlanphamdb.model.eMagazine;

/**
 * The cache model class for representing eMagazine in entity cache.
 *
 * @author dnict
 * @generated
 */
public class eMagazineCacheModel
	implements CacheModel<eMagazine>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof eMagazineCacheModel)) {
			return false;
		}

		eMagazineCacheModel eMagazineCacheModel = (eMagazineCacheModel)object;

		if (id == eMagazineCacheModel.id) {
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
	public eMagazine toEntityModel() {
		eMagazineImpl eMagazineImpl = new eMagazineImpl();

		eMagazineImpl.setId(id);
		eMagazineImpl.setGroupId(groupId);
		eMagazineImpl.setCompanyId(companyId);

		if (ten == null) {
			eMagazineImpl.setTen("");
		}
		else {
			eMagazineImpl.setTen(ten);
		}

		if (slug == null) {
			eMagazineImpl.setSlug("");
		}
		else {
			eMagazineImpl.setSlug(slug);
		}

		if (moTa == null) {
			eMagazineImpl.setMoTa("");
		}
		else {
			eMagazineImpl.setMoTa(moTa);
		}

		if (anhDaiDien == null) {
			eMagazineImpl.setAnhDaiDien("");
		}
		else {
			eMagazineImpl.setAnhDaiDien(anhDaiDien);
		}

		if (mauChuDao == null) {
			eMagazineImpl.setMauChuDao("");
		}
		else {
			eMagazineImpl.setMauChuDao(mauChuDao);
		}

		if (hinhNen == null) {
			eMagazineImpl.setHinhNen("");
		}
		else {
			eMagazineImpl.setHinhNen(hinhNen);
		}

		eMagazineImpl.setTemplateId(templateId);

		if (noiDung == null) {
			eMagazineImpl.setNoiDung("");
		}
		else {
			eMagazineImpl.setNoiDung(noiDung);
		}

		if (tuKhoa == null) {
			eMagazineImpl.setTuKhoa("");
		}
		else {
			eMagazineImpl.setTuKhoa(tuKhoa);
		}

		eMagazineImpl.setPhienBan(phienBan);
		eMagazineImpl.setLuotXem(luotXem);
		eMagazineImpl.setNguoiTao(nguoiTao);

		if (ngayTao == Long.MIN_VALUE) {
			eMagazineImpl.setNgayTao(null);
		}
		else {
			eMagazineImpl.setNgayTao(new Date(ngayTao));
		}

		eMagazineImpl.setNguoiSua(nguoiSua);

		if (ngaySua == Long.MIN_VALUE) {
			eMagazineImpl.setNgaySua(null);
		}
		else {
			eMagazineImpl.setNgaySua(new Date(ngaySua));
		}

		eMagazineImpl.setNguoiNhan(nguoiNhan);
		eMagazineImpl.setNguoiXuLy(nguoiXuLy);

		if (ngayXuLy == Long.MIN_VALUE) {
			eMagazineImpl.setNgayXuLy(null);
		}
		else {
			eMagazineImpl.setNgayXuLy(new Date(ngayXuLy));
		}

		if (language == null) {
			eMagazineImpl.setLanguage("");
		}
		else {
			eMagazineImpl.setLanguage(language);
		}

		eMagazineImpl.setIsFormHienBinhLuan(isFormHienBinhLuan);
		eMagazineImpl.setIsFormViewBinhLuan(isFormViewBinhLuan);
		eMagazineImpl.setStatus(status);
		eMagazineImpl.setOrders(orders);
		eMagazineImpl.setDelete_status(delete_status);

		eMagazineImpl.resetOriginalValues();

		return eMagazineImpl;
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