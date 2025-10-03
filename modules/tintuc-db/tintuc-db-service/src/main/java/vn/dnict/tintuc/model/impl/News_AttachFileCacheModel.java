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

package vn.dnict.tintuc.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import vn.dnict.tintuc.model.News_AttachFile;

/**
 * The cache model class for representing News_AttachFile in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_AttachFileCacheModel
	implements CacheModel<News_AttachFile>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_AttachFileCacheModel)) {
			return false;
		}

		News_AttachFileCacheModel news_AttachFileCacheModel =
			(News_AttachFileCacheModel)object;

		if (id == news_AttachFileCacheModel.id) {
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
		StringBundler sb = new StringBundler(23);

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
		sb.append(", url=");
		sb.append(url);
		sb.append(", Object=");
		sb.append(Object);
		sb.append(", ObjectId=");
		sb.append(ObjectId);
		sb.append(", ghichu=");
		sb.append(ghichu);
		sb.append(", daxoa=");
		sb.append(daxoa);
		sb.append(", trangthai=");
		sb.append(trangthai);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_AttachFile toEntityModel() {
		News_AttachFileImpl news_AttachFileImpl = new News_AttachFileImpl();

		news_AttachFileImpl.setId(id);
		news_AttachFileImpl.setCompanyId(companyId);
		news_AttachFileImpl.setGroupId(groupId);
		news_AttachFileImpl.setUserId(userId);

		if (ten == null) {
			news_AttachFileImpl.setTen("");
		}
		else {
			news_AttachFileImpl.setTen(ten);
		}

		if (url == null) {
			news_AttachFileImpl.setUrl("");
		}
		else {
			news_AttachFileImpl.setUrl(url);
		}

		news_AttachFileImpl.setObject(Object);
		news_AttachFileImpl.setObjectId(ObjectId);

		if (ghichu == null) {
			news_AttachFileImpl.setGhichu("");
		}
		else {
			news_AttachFileImpl.setGhichu(ghichu);
		}

		news_AttachFileImpl.setDaxoa(daxoa);
		news_AttachFileImpl.setTrangthai(trangthai);

		news_AttachFileImpl.resetOriginalValues();

		return news_AttachFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		userId = objectInput.readLong();
		ten = objectInput.readUTF();
		url = objectInput.readUTF();

		Object = objectInput.readLong();

		ObjectId = objectInput.readLong();
		ghichu = objectInput.readUTF();

		daxoa = objectInput.readInt();

		trangthai = objectInput.readInt();
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

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(Object);

		objectOutput.writeLong(ObjectId);

		if (ghichu == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ghichu);
		}

		objectOutput.writeInt(daxoa);

		objectOutput.writeInt(trangthai);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long userId;
	public String ten;
	public String url;
	public long Object;
	public long ObjectId;
	public String ghichu;
	public int daxoa;
	public int trangthai;

}