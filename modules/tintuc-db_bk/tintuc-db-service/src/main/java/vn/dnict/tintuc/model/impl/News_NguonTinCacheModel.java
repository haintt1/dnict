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

import vn.dnict.tintuc.model.News_NguonTin;

/**
 * The cache model class for representing News_NguonTin in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_NguonTinCacheModel
	implements CacheModel<News_NguonTin>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_NguonTinCacheModel)) {
			return false;
		}

		News_NguonTinCacheModel news_NguonTinCacheModel =
			(News_NguonTinCacheModel)object;

		if (id == news_NguonTinCacheModel.id) {
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
		StringBundler sb = new StringBundler(15);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
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
	public News_NguonTin toEntityModel() {
		News_NguonTinImpl news_NguonTinImpl = new News_NguonTinImpl();

		news_NguonTinImpl.setId(id);
		news_NguonTinImpl.setCompanyId(companyId);
		news_NguonTinImpl.setGroupId(groupId);

		if (name == null) {
			news_NguonTinImpl.setName("");
		}
		else {
			news_NguonTinImpl.setName(name);
		}

		news_NguonTinImpl.setStatus(status);
		news_NguonTinImpl.setOrders(orders);
		news_NguonTinImpl.setDelete_status(delete_status);

		news_NguonTinImpl.resetOriginalValues();

		return news_NguonTinImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();

		status = objectInput.readInt();

		orders = objectInput.readInt();

		delete_status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(orders);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String name;
	public int status;
	public int orders;
	public int delete_status;

}