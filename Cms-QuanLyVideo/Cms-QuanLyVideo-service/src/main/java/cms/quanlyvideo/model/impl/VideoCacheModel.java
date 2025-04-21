/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model.impl;

import cms.quanlyvideo.model.Video;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Video in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class VideoCacheModel implements CacheModel<Video>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof VideoCacheModel)) {
			return false;
		}

		VideoCacheModel videoCacheModel = (VideoCacheModel)object;

		if (id == videoCacheModel.id) {
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
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ten=");
		sb.append(ten);
		sb.append(", moTa=");
		sb.append(moTa);
		sb.append(", noiDung=");
		sb.append(noiDung);
		sb.append(", duongDan=");
		sb.append(duongDan);
		sb.append(", luotXem=");
		sb.append(luotXem);
		sb.append(", luotThich=");
		sb.append(luotThich);
		sb.append(", tuKhoa=");
		sb.append(tuKhoa);
		sb.append(", choBinhLuan=");
		sb.append(choBinhLuan);
		sb.append(", trangThai=");
		sb.append(trangThai);
		sb.append(", daXoa=");
		sb.append(daXoa);
		sb.append(", ngayTao=");
		sb.append(ngayTao);
		sb.append(", ngaySua=");
		sb.append(ngaySua);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Video toEntityModel() {
		VideoImpl videoImpl = new VideoImpl();

		videoImpl.setId(id);
		videoImpl.setCompanyId(companyId);
		videoImpl.setGroupId(groupId);
		videoImpl.setUserId(userId);

		if (ten == null) {
			videoImpl.setTen("");
		}
		else {
			videoImpl.setTen(ten);
		}

		if (moTa == null) {
			videoImpl.setMoTa("");
		}
		else {
			videoImpl.setMoTa(moTa);
		}

		if (noiDung == null) {
			videoImpl.setNoiDung("");
		}
		else {
			videoImpl.setNoiDung(noiDung);
		}

		if (duongDan == null) {
			videoImpl.setDuongDan("");
		}
		else {
			videoImpl.setDuongDan(duongDan);
		}

		videoImpl.setLuotXem(luotXem);
		videoImpl.setLuotThich(luotThich);

		if (tuKhoa == null) {
			videoImpl.setTuKhoa("");
		}
		else {
			videoImpl.setTuKhoa(tuKhoa);
		}

		videoImpl.setChoBinhLuan(choBinhLuan);
		videoImpl.setTrangThai(trangThai);
		videoImpl.setDaXoa(daXoa);

		if (ngayTao == Long.MIN_VALUE) {
			videoImpl.setNgayTao(null);
		}
		else {
			videoImpl.setNgayTao(new Date(ngayTao));
		}

		if (ngaySua == Long.MIN_VALUE) {
			videoImpl.setNgaySua(null);
		}
		else {
			videoImpl.setNgaySua(new Date(ngaySua));
		}

		videoImpl.resetOriginalValues();

		return videoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		ten = objectInput.readUTF();
		moTa = objectInput.readUTF();
		noiDung = objectInput.readUTF();
		duongDan = objectInput.readUTF();

		luotXem = objectInput.readLong();

		luotThich = objectInput.readLong();
		tuKhoa = objectInput.readUTF();

		choBinhLuan = objectInput.readLong();

		trangThai = objectInput.readLong();

		daXoa = objectInput.readLong();
		ngayTao = objectInput.readLong();
		ngaySua = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(userId);

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

		if (noiDung == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(noiDung);
		}

		if (duongDan == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(duongDan);
		}

		objectOutput.writeLong(luotXem);

		objectOutput.writeLong(luotThich);

		if (tuKhoa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tuKhoa);
		}

		objectOutput.writeLong(choBinhLuan);

		objectOutput.writeLong(trangThai);

		objectOutput.writeLong(daXoa);
		objectOutput.writeLong(ngayTao);
		objectOutput.writeLong(ngaySua);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long userId;
	public String ten;
	public String moTa;
	public String noiDung;
	public String duongDan;
	public long luotXem;
	public long luotThich;
	public String tuKhoa;
	public long choBinhLuan;
	public long trangThai;
	public long daXoa;
	public long ngayTao;
	public long ngaySua;

}