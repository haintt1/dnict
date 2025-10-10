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

package vn.dnict.vanbanphapquy.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import vn.dnict.vanbanphapquy.model.Vanbanphapquy;

/**
 * The cache model class for representing Vanbanphapquy in entity cache.
 *
 * @author BinhNT
 * @generated
 */
public class VanbanphapquyCacheModel
	implements CacheModel<Vanbanphapquy>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VanbanphapquyCacheModel)) {
			return false;
		}

		VanbanphapquyCacheModel vanbanphapquyCacheModel =
			(VanbanphapquyCacheModel)object;

		if (id == vanbanphapquyCacheModel.id) {
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
		StringBundler sb = new StringBundler(35);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", sohieu=");
		sb.append(sohieu);
		sb.append(", trichyeu=");
		sb.append(trichyeu);
		sb.append(", noidung=");
		sb.append(noidung);
		sb.append(", ngay_banhanh=");
		sb.append(ngay_banhanh);
		sb.append(", ngay_hieuluc=");
		sb.append(ngay_hieuluc);
		sb.append(", ngay_hethieuluc=");
		sb.append(ngay_hethieuluc);
		sb.append(", ngay_xuatban=");
		sb.append(ngay_xuatban);
		sb.append(", id_linhvuc=");
		sb.append(id_linhvuc);
		sb.append(", id_loaivanban=");
		sb.append(id_loaivanban);
		sb.append(", id_capbanhanh=");
		sb.append(id_capbanhanh);
		sb.append(", id_coquanbanhanh=");
		sb.append(id_coquanbanhanh);
		sb.append(", nguoiky=");
		sb.append(nguoiky);
		sb.append(", status=");
		sb.append(status);
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vanbanphapquy toEntityModel() {
		VanbanphapquyImpl vanbanphapquyImpl = new VanbanphapquyImpl();

		vanbanphapquyImpl.setId(id);
		vanbanphapquyImpl.setCompanyId(companyId);
		vanbanphapquyImpl.setGroupId(groupId);

		if (sohieu == null) {
			vanbanphapquyImpl.setSohieu("");
		}
		else {
			vanbanphapquyImpl.setSohieu(sohieu);
		}

		if (trichyeu == null) {
			vanbanphapquyImpl.setTrichyeu("");
		}
		else {
			vanbanphapquyImpl.setTrichyeu(trichyeu);
		}

		if (noidung == null) {
			vanbanphapquyImpl.setNoidung("");
		}
		else {
			vanbanphapquyImpl.setNoidung(noidung);
		}

		if (ngay_banhanh == Long.MIN_VALUE) {
			vanbanphapquyImpl.setNgay_banhanh(null);
		}
		else {
			vanbanphapquyImpl.setNgay_banhanh(new Date(ngay_banhanh));
		}

		if (ngay_hieuluc == Long.MIN_VALUE) {
			vanbanphapquyImpl.setNgay_hieuluc(null);
		}
		else {
			vanbanphapquyImpl.setNgay_hieuluc(new Date(ngay_hieuluc));
		}

		if (ngay_hethieuluc == Long.MIN_VALUE) {
			vanbanphapquyImpl.setNgay_hethieuluc(null);
		}
		else {
			vanbanphapquyImpl.setNgay_hethieuluc(new Date(ngay_hethieuluc));
		}

		if (ngay_xuatban == Long.MIN_VALUE) {
			vanbanphapquyImpl.setNgay_xuatban(null);
		}
		else {
			vanbanphapquyImpl.setNgay_xuatban(new Date(ngay_xuatban));
		}

		vanbanphapquyImpl.setId_linhvuc(id_linhvuc);
		vanbanphapquyImpl.setId_loaivanban(id_loaivanban);
		vanbanphapquyImpl.setId_capbanhanh(id_capbanhanh);
		vanbanphapquyImpl.setId_coquanbanhanh(id_coquanbanhanh);

		if (nguoiky == null) {
			vanbanphapquyImpl.setNguoiky("");
		}
		else {
			vanbanphapquyImpl.setNguoiky(nguoiky);
		}

		vanbanphapquyImpl.setStatus(status);

		if (type == null) {
			vanbanphapquyImpl.setType("");
		}
		else {
			vanbanphapquyImpl.setType(type);
		}

		vanbanphapquyImpl.resetOriginalValues();

		return vanbanphapquyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		sohieu = objectInput.readUTF();
		trichyeu = objectInput.readUTF();
		noidung = objectInput.readUTF();
		ngay_banhanh = objectInput.readLong();
		ngay_hieuluc = objectInput.readLong();
		ngay_hethieuluc = objectInput.readLong();
		ngay_xuatban = objectInput.readLong();

		id_linhvuc = objectInput.readLong();

		id_loaivanban = objectInput.readLong();

		id_capbanhanh = objectInput.readLong();

		id_coquanbanhanh = objectInput.readLong();
		nguoiky = objectInput.readUTF();

		status = objectInput.readInt();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (sohieu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sohieu);
		}

		if (trichyeu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(trichyeu);
		}

		if (noidung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noidung);
		}

		objectOutput.writeLong(ngay_banhanh);
		objectOutput.writeLong(ngay_hieuluc);
		objectOutput.writeLong(ngay_hethieuluc);
		objectOutput.writeLong(ngay_xuatban);

		objectOutput.writeLong(id_linhvuc);

		objectOutput.writeLong(id_loaivanban);

		objectOutput.writeLong(id_capbanhanh);

		objectOutput.writeLong(id_coquanbanhanh);

		if (nguoiky == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoiky);
		}

		objectOutput.writeInt(status);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long id;
	public long companyId;
	public long groupId;
	public String sohieu;
	public String trichyeu;
	public String noidung;
	public long ngay_banhanh;
	public long ngay_hieuluc;
	public long ngay_hethieuluc;
	public long ngay_xuatban;
	public long id_linhvuc;
	public long id_loaivanban;
	public long id_capbanhanh;
	public long id_coquanbanhanh;
	public String nguoiky;
	public int status;
	public String type;

}