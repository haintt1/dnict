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

import vn.dnict.qlquangcao.model.NhomKH;

/**
 * The cache model class for representing NhomKH in entity cache.
 *
 * @author dnict
 * @generated
 */
public class NhomKHCacheModel implements CacheModel<NhomKH>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof NhomKHCacheModel)) {
			return false;
		}

		NhomKHCacheModel nhomKHCacheModel = (NhomKHCacheModel)object;

		if (id == nhomKHCacheModel.id) {
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
		sb.append(", nguoitao=");
		sb.append(nguoitao);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", nguoidaidien=");
		sb.append(nguoidaidien);
		sb.append(", logo=");
		sb.append(logo);
		sb.append(", mota=");
		sb.append(mota);
		sb.append(", diachi=");
		sb.append(diachi);
		sb.append(", sdt=");
		sb.append(sdt);
		sb.append(", email=");
		sb.append(email);
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
	public NhomKH toEntityModel() {
		NhomKHImpl nhomKHImpl = new NhomKHImpl();

		nhomKHImpl.setId(id);
		nhomKHImpl.setCompanyId(companyId);
		nhomKHImpl.setGroupId(groupId);
		nhomKHImpl.setNguoitao(nguoitao);

		if (ten == null) {
			nhomKHImpl.setTen("");
		}
		else {
			nhomKHImpl.setTen(ten);
		}

		if (nguoidaidien == null) {
			nhomKHImpl.setNguoidaidien("");
		}
		else {
			nhomKHImpl.setNguoidaidien(nguoidaidien);
		}

		if (logo == null) {
			nhomKHImpl.setLogo("");
		}
		else {
			nhomKHImpl.setLogo(logo);
		}

		if (mota == null) {
			nhomKHImpl.setMota("");
		}
		else {
			nhomKHImpl.setMota(mota);
		}

		if (diachi == null) {
			nhomKHImpl.setDiachi("");
		}
		else {
			nhomKHImpl.setDiachi(diachi);
		}

		if (sdt == null) {
			nhomKHImpl.setSdt("");
		}
		else {
			nhomKHImpl.setSdt(sdt);
		}

		if (email == null) {
			nhomKHImpl.setEmail("");
		}
		else {
			nhomKHImpl.setEmail(email);
		}

		if (ngaytao == Long.MIN_VALUE) {
			nhomKHImpl.setNgaytao(null);
		}
		else {
			nhomKHImpl.setNgaytao(new Date(ngaytao));
		}

		nhomKHImpl.setDaxoa(daxoa);
		nhomKHImpl.setTrangthai(trangthai);

		if (ngaysua == Long.MIN_VALUE) {
			nhomKHImpl.setNgaysua(null);
		}
		else {
			nhomKHImpl.setNgaysua(new Date(ngaysua));
		}

		nhomKHImpl.resetOriginalValues();

		return nhomKHImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		nguoitao = objectInput.readLong();
		ten = objectInput.readUTF();
		nguoidaidien = objectInput.readUTF();
		logo = objectInput.readUTF();
		mota = objectInput.readUTF();
		diachi = objectInput.readUTF();
		sdt = objectInput.readUTF();
		email = objectInput.readUTF();
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

		if (nguoidaidien == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nguoidaidien);
		}

		if (logo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(logo);
		}

		if (mota == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mota);
		}

		if (diachi == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diachi);
		}

		if (sdt == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sdt);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
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
	public String nguoidaidien;
	public String logo;
	public String mota;
	public String diachi;
	public String sdt;
	public String email;
	public long ngaytao;
	public int daxoa;
	public int trangthai;
	public long ngaysua;

}