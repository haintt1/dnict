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

import vn.dnict.tintuc.model.News_role;

/**
 * The cache model class for representing News_role in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_roleCacheModel
	implements CacheModel<News_role>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_roleCacheModel)) {
			return false;
		}

		News_roleCacheModel news_roleCacheModel = (News_roleCacheModel)object;

		if (id == news_roleCacheModel.id) {
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
		StringBundler sb = new StringBundler(17);

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", userid=");
		sb.append(userid);
		sb.append(", role_add=");
		sb.append(role_add);
		sb.append(", role_edit=");
		sb.append(role_edit);
		sb.append(", role_public=");
		sb.append(role_public);
		sb.append(", category_active_role=");
		sb.append(category_active_role);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_role toEntityModel() {
		News_roleImpl news_roleImpl = new News_roleImpl();

		news_roleImpl.setCompanyId(companyId);
		news_roleImpl.setGroupId(groupId);
		news_roleImpl.setId(id);
		news_roleImpl.setUserid(userid);
		news_roleImpl.setRole_add(role_add);
		news_roleImpl.setRole_edit(role_edit);
		news_roleImpl.setRole_public(role_public);

		if (category_active_role == null) {
			news_roleImpl.setCategory_active_role("");
		}
		else {
			news_roleImpl.setCategory_active_role(category_active_role);
		}

		news_roleImpl.resetOriginalValues();

		return news_roleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		id = objectInput.readLong();

		userid = objectInput.readLong();

		role_add = objectInput.readInt();

		role_edit = objectInput.readInt();

		role_public = objectInput.readInt();
		category_active_role = (String)objectInput.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(id);

		objectOutput.writeLong(userid);

		objectOutput.writeInt(role_add);

		objectOutput.writeInt(role_edit);

		objectOutput.writeInt(role_public);

		if (category_active_role == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(category_active_role);
		}
	}

	public long companyId;
	public long groupId;
	public long id;
	public long userid;
	public int role_add;
	public int role_edit;
	public int role_public;
	public String category_active_role;

}