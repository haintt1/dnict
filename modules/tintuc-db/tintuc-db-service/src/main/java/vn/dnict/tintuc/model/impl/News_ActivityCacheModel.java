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

import vn.dnict.tintuc.model.News_Activity;

/**
 * The cache model class for representing News_Activity in entity cache.
 *
 * @author dnict
 * @generated
 */
public class News_ActivityCacheModel
	implements CacheModel<News_Activity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof News_ActivityCacheModel)) {
			return false;
		}

		News_ActivityCacheModel news_ActivityCacheModel =
			(News_ActivityCacheModel)object;

		if (id == news_ActivityCacheModel.id) {
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
		sb.append(", articleid=");
		sb.append(articleid);
		sb.append(", startuserid=");
		sb.append(startuserid);
		sb.append(", enduserid=");
		sb.append(enduserid);
		sb.append(", contentrequest=");
		sb.append(contentrequest);
		sb.append(", statusofarticle=");
		sb.append(statusofarticle);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public News_Activity toEntityModel() {
		News_ActivityImpl news_ActivityImpl = new News_ActivityImpl();

		news_ActivityImpl.setCompanyId(companyId);
		news_ActivityImpl.setGroupId(groupId);
		news_ActivityImpl.setId(id);
		news_ActivityImpl.setArticleid(articleid);
		news_ActivityImpl.setStartuserid(startuserid);
		news_ActivityImpl.setEnduserid(enduserid);

		if (contentrequest == null) {
			news_ActivityImpl.setContentrequest("");
		}
		else {
			news_ActivityImpl.setContentrequest(contentrequest);
		}

		news_ActivityImpl.setStatusofarticle(statusofarticle);

		news_ActivityImpl.resetOriginalValues();

		return news_ActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		id = objectInput.readLong();

		articleid = objectInput.readLong();

		startuserid = objectInput.readLong();

		enduserid = objectInput.readLong();
		contentrequest = (String)objectInput.readObject();

		statusofarticle = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(id);

		objectOutput.writeLong(articleid);

		objectOutput.writeLong(startuserid);

		objectOutput.writeLong(enduserid);

		if (contentrequest == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(contentrequest);
		}

		objectOutput.writeInt(statusofarticle);
	}

	public long companyId;
	public long groupId;
	public long id;
	public long articleid;
	public long startuserid;
	public long enduserid;
	public String contentrequest;
	public int statusofarticle;

}