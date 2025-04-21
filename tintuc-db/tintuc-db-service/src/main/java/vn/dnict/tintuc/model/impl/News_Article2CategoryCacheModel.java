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

import vn.dnict.tintuc.model.News_Article2Category;

/**
 * The cache model class for representing News_Article2Category in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_Article2CategoryCacheModel
	implements CacheModel<News_Article2Category>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_Article2CategoryCacheModel)) {
			return false;
		}

		News_Article2CategoryCacheModel news_Article2CategoryCacheModel =
			(News_Article2CategoryCacheModel)object;

		if (id == news_Article2CategoryCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", newcategoryId=");
		sb.append(newcategoryId);
		sb.append(", newarticleId=");
		sb.append(newarticleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_Article2Category toEntityModel() {
		News_Article2CategoryImpl news_Article2CategoryImpl =
			new News_Article2CategoryImpl();

		news_Article2CategoryImpl.setId(id);
		news_Article2CategoryImpl.setCompanyId(companyId);
		news_Article2CategoryImpl.setGroupId(groupId);
		news_Article2CategoryImpl.setNewcategoryId(newcategoryId);
		news_Article2CategoryImpl.setNewarticleId(newarticleId);

		news_Article2CategoryImpl.resetOriginalValues();

		return news_Article2CategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		newcategoryId = objectInput.readLong();

		newarticleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(newcategoryId);

		objectOutput.writeLong(newarticleId);
	}

	public long id;
	public long companyId;
	public long groupId;
	public long newcategoryId;
	public long newarticleId;

}