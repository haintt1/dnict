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

import vn.dnict.qlquangcao.model.BangQuangCao;

/**
 * The cache model class for representing BangQuangCao in entity cache.
 *
 * @author dnict
 * @generated
 */
public class BangQuangCaoCacheModel
	implements CacheModel<BangQuangCao>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BangQuangCaoCacheModel)) {
			return false;
		}

		BangQuangCaoCacheModel bangQuangCaoCacheModel =
			(BangQuangCaoCacheModel)object;

		if (id == bangQuangCaoCacheModel.id) {
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
		sb.append(", duongdan=");
		sb.append(duongdan);
		sb.append(", lienket=");
		sb.append(lienket);
		sb.append(", nhomKH=");
		sb.append(nhomKH);
		sb.append(", vitriQC=");
		sb.append(vitriQC);
		sb.append(", ngaytao=");
		sb.append(ngaytao);
		sb.append(", ngayketthuc=");
		sb.append(ngayketthuc);
		sb.append(", daxoa=");
		sb.append(daxoa);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", trangthaisudung=");
		sb.append(trangthaisudung);
		sb.append(", ngaysua=");
		sb.append(ngaysua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BangQuangCao toEntityModel() {
		BangQuangCaoImpl bangQuangCaoImpl = new BangQuangCaoImpl();

		bangQuangCaoImpl.setId(id);
		bangQuangCaoImpl.setCompanyId(companyId);
		bangQuangCaoImpl.setGroupId(groupId);
		bangQuangCaoImpl.setNguoitao(nguoitao);

		if (ten == null) {
			bangQuangCaoImpl.setTen("");
		}
		else {
			bangQuangCaoImpl.setTen(ten);
		}

		if (duongdan == null) {
			bangQuangCaoImpl.setDuongdan("");
		}
		else {
			bangQuangCaoImpl.setDuongdan(duongdan);
		}

		if (lienket == null) {
			bangQuangCaoImpl.setLienket("");
		}
		else {
			bangQuangCaoImpl.setLienket(lienket);
		}

		bangQuangCaoImpl.setNhomKH(nhomKH);
		bangQuangCaoImpl.setVitriQC(vitriQC);

		if (ngaytao == Long.MIN_VALUE) {
			bangQuangCaoImpl.setNgaytao(null);
		}
		else {
			bangQuangCaoImpl.setNgaytao(new Date(ngaytao));
		}

		if (ngayketthuc == Long.MIN_VALUE) {
			bangQuangCaoImpl.setNgayketthuc(null);
		}
		else {
			bangQuangCaoImpl.setNgayketthuc(new Date(ngayketthuc));
		}

		bangQuangCaoImpl.setDaxoa(daxoa);
		bangQuangCaoImpl.setTrangthai(trangthai);
		bangQuangCaoImpl.setTrangthaisudung(trangthaisudung);

		if (ngaysua == Long.MIN_VALUE) {
			bangQuangCaoImpl.setNgaysua(null);
		}
		else {
			bangQuangCaoImpl.setNgaysua(new Date(ngaysua));
		}

		bangQuangCaoImpl.resetOriginalValues();

		return bangQuangCaoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		nguoitao = objectInput.readLong();
		ten = objectInput.readUTF();
		duongdan = objectInput.readUTF();
		lienket = objectInput.readUTF();

		nhomKH = objectInput.readLong();

		vitriQC = objectInput.readLong();
		ngaytao = objectInput.readLong();
		ngayketthuc = objectInput.readLong();

		daxoa = objectInput.readInt();

		trangthai = objectInput.readInt();

		trangthaisudung = objectInput.readInt();
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

		if (duongdan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duongdan);
		}

		if (lienket == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lienket);
		}

		objectOutput.writeLong(nhomKH);

		objectOutput.writeLong(vitriQC);
		objectOutput.writeLong(ngaytao);
		objectOutput.writeLong(ngayketthuc);

		objectOutput.writeInt(daxoa);

		objectOutput.writeInt(trangthai);

		objectOutput.writeInt(trangthaisudung);
		objectOutput.writeLong(ngaysua);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long nguoitao;
	public String ten;
	public String duongdan;
	public String lienket;
	public long nhomKH;
	public long vitriQC;
	public long ngaytao;
	public long ngayketthuc;
	public int daxoa;
	public int trangthai;
	public int trangthaisudung;
	public long ngaysua;

}