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

import vn.dnict.tintuc.model.News_Subcategories;

/**
 * The cache model class for representing News_Subcategories in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_SubcategoriesCacheModel
	implements CacheModel<News_Subcategories>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_SubcategoriesCacheModel)) {
			return false;
		}

		News_SubcategoriesCacheModel news_SubcategoriesCacheModel =
			(News_SubcategoriesCacheModel)object;

		if (id == news_SubcategoriesCacheModel.id) {
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
		sb.append(", delete_status=");
		sb.append(delete_status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_Subcategories toEntityModel() {
		News_SubcategoriesImpl news_SubcategoriesImpl =
			new News_SubcategoriesImpl();

		news_SubcategoriesImpl.setId(id);
		news_SubcategoriesImpl.setCompanyId(companyId);
		news_SubcategoriesImpl.setGroupId(groupId);

		if (name == null) {
			news_SubcategoriesImpl.setName("");
		}
		else {
			news_SubcategoriesImpl.setName(name);
		}

		if (language == null) {
			news_SubcategoriesImpl.setLanguage("");
		}
		else {
			news_SubcategoriesImpl.setLanguage(language);
		}

		news_SubcategoriesImpl.setStatus(status);
		news_SubcategoriesImpl.setOrders(orders);
		news_SubcategoriesImpl.setDelete_status(delete_status);

		news_SubcategoriesImpl.resetOriginalValues();

		return news_SubcategoriesImpl;
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

		objectOutput.writeInt(delete_status);
	}

	public long id;
	public long companyId;
	public long groupId;
	public String name;
	public String language;
	public int status;
	public int orders;
	public int delete_status;

}