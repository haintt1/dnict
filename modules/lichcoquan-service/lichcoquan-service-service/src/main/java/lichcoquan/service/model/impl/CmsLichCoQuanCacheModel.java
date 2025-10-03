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

import lichcoquan.service.model.CmsLichCoQuan;

/**
 * The cache model class for representing CmsLichCoQuan in entity cache.
 *
 * @author BinhNT
 * @generated
 */
public class CmsLichCoQuanCacheModel
	implements CacheModel<CmsLichCoQuan>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CmsLichCoQuanCacheModel)) {
			return false;
		}

		CmsLichCoQuanCacheModel cmsLichCoQuanCacheModel =
			(CmsLichCoQuanCacheModel)object;

		if (lichCongtacId == cmsLichCoQuanCacheModel.lichCongtacId) {
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
	public CmsLichCoQuan toEntityModel() {
		CmsLichCoQuanImpl cmsLichCoQuanImpl = new CmsLichCoQuanImpl();

		cmsLichCoQuanImpl.setLichCongtacId(lichCongtacId);
		cmsLichCoQuanImpl.setCompanyId(companyId);
		cmsLichCoQuanImpl.setUserId(userId);

		if (content == null) {
			cmsLichCoQuanImpl.setContent("");
		}
		else {
			cmsLichCoQuanImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			cmsLichCoQuanImpl.setCreateDate(null);
		}
		else {
			cmsLichCoQuanImpl.setCreateDate(new Date(createDate));
		}

		if (tungay == Long.MIN_VALUE) {
			cmsLichCoQuanImpl.setTungay(null);
		}
		else {
			cmsLichCoQuanImpl.setTungay(new Date(tungay));
		}

		if (denngay == Long.MIN_VALUE) {
			cmsLichCoQuanImpl.setDenngay(null);
		}
		else {
			cmsLichCoQuanImpl.setDenngay(new Date(denngay));
		}

		cmsLichCoQuanImpl.setTrangthai(trangthai);
		cmsLichCoQuanImpl.setBanhanh(banhanh);
		cmsLichCoQuanImpl.setTuan(tuan);
		cmsLichCoQuanImpl.setNam(nam);

		cmsLichCoQuanImpl.resetOriginalValues();

		return cmsLichCoQuanImpl;
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