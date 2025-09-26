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

package lichcoquan.service.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import lichcoquan.service.model.Lichcoquan;

/**
 * The cache model class for representing Lichcoquan in entity cache.
 *
 * @author BinhNT
 * @generated
 */
public class LichcoquanCacheModel
	implements CacheModel<Lichcoquan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LichcoquanCacheModel)) {
			return false;
		}

		LichcoquanCacheModel lichcoquanCacheModel =
			(LichcoquanCacheModel)object;

		if (lichCongtacId == lichcoquanCacheModel.lichCongtacId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, lichCongtacId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{lichCongtacId=");
		sb.append(lichCongtacId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", tungay=");
		sb.append(tungay);
		sb.append(", denngay=");
		sb.append(denngay);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append(", banhanh=");
		sb.append(banhanh);
		sb.append(", tuan=");
		sb.append(tuan);
		sb.append(", nam=");
		sb.append(nam);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Lichcoquan toEntityModel() {
		LichcoquanImpl lichcoquanImpl = new LichcoquanImpl();

		lichcoquanImpl.setLichCongtacId(lichCongtacId);
		lichcoquanImpl.setCompanyId(companyId);
		lichcoquanImpl.setUserId(userId);

		if (content == null) {
			lichcoquanImpl.setContent("");
		}
		else {
			lichcoquanImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			lichcoquanImpl.setCreateDate(null);
		}
		else {
			lichcoquanImpl.setCreateDate(new Date(createDate));
		}

		if (tungay == Long.MIN_VALUE) {
			lichcoquanImpl.setTungay(null);
		}
		else {
			lichcoquanImpl.setTungay(new Date(tungay));
		}

		if (denngay == Long.MIN_VALUE) {
			lichcoquanImpl.setDenngay(null);
		}
		else {
			lichcoquanImpl.setDenngay(new Date(denngay));
		}

		lichcoquanImpl.setTrangthai(trangthai);
		lichcoquanImpl.setBanhanh(banhanh);
		lichcoquanImpl.setTuan(tuan);
		lichcoquanImpl.setNam(nam);

		lichcoquanImpl.resetOriginalValues();

		return lichcoquanImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		lichCongtacId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		content = objectInput.readUTF();
		createDate = objectInput.readLong();
		tungay = objectInput.readLong();
		denngay = objectInput.readLong();

		trangthai = objectInput.readInt();

		banhanh = objectInput.readInt();

		tuan = objectInput.readInt();

		nam = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(lichCongtacId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(tungay);
		objectOutput.writeLong(denngay);

		objectOutput.writeInt(trangthai);

		objectOutput.writeInt(banhanh);

		objectOutput.writeInt(tuan);

		objectOutput.writeInt(nam);
	}

	public long lichCongtacId;
	public long companyId;
	public long userId;
	public String content;
	public long createDate;
	public long tungay;
	public long denngay;
	public int trangthai;
	public int banhanh;
	public int tuan;
	public int nam;

}