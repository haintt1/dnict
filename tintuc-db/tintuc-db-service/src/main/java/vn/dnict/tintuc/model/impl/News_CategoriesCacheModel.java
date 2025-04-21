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

import vn.dnict.tintuc.model.News_Categories;

/**
 * The cache model class for representing News_Categories in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_CategoriesCacheModel
	implements CacheModel<News_Categories>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_CategoriesCacheModel)) {
			return false;
		}

		News_CategoriesCacheModel news_CategoriesCacheModel =
			(News_CategoriesCacheModel)object;

		if (id == news_CategoriesCacheModel.id) {
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
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", language=");
		sb.append(language);
		sb.append(", status=");
		sb.append(status);
		sb.append(", orders=");
		sb.append(orders);
		sb.append(", idlibcat=");
		sb.append(idlibcat);
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_Categories toEntityModel() {
		News_CategoriesImpl news_CategoriesImpl = new News_CategoriesImpl();

		news_CategoriesImpl.setId(id);
		news_CategoriesImpl.setCompanyId(companyId);
		news_CategoriesImpl.setGroupId(groupId);

		if (name == null) {
			news_CategoriesImpl.setName("");
		}
		else {
			news_CategoriesImpl.setName(name);
		}

		if (language == null) {
			news_CategoriesImpl.setLanguage("");
		}
		else {
			news_CategoriesImpl.setLanguage(language);
		}

		news_CategoriesImpl.setStatus(status);
		news_CategoriesImpl.setOrders(orders);
		news_CategoriesImpl.setIdlibcat(idlibcat);
		news_CategoriesImpl.setDelete_status(delete_status);

		news_CategoriesImpl.resetOriginalValues();

		return news_CategoriesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();
		name = objectInput.readUTF();
		language = objectInput.readUTF();

		status = objectInput.readInt();

		orders = objectInput.readInt();

		idlibcat = objectInput.readLong();

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

		if (language == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(language);
		}

		objectOutput.writeInt(status);

		objectOutput.writeInt(orders);

		objectOutput.writeLong(idlibcat);

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String name;
	public String language;
	public int status;
	public int orders;
	public long idlibcat;
	public int delete_status;

}