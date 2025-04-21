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

package qlanphamdb.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import qlanphamdb.model.AnPham_Activity;

/**
 * The cache model class for representing AnPham_Activity in entity cache.
 *
 * @author dnict
 * @generated
 */
public class AnPham_ActivityCacheModel
	implements CacheModel<AnPham_Activity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AnPham_ActivityCacheModel)) {
			return false;
		}

		AnPham_ActivityCacheModel anPham_ActivityCacheModel =
			(AnPham_ActivityCacheModel)object;

		if (id == anPham_ActivityCacheModel.id) {
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

		sb.append("{companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", id=");
		sb.append(id);
		sb.append(", deCuongId=");
		sb.append(deCuongId);
		sb.append(", anPhamId=");
		sb.append(anPhamId);
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
	public AnPham_Activity toEntityModel() {
		AnPham_ActivityImpl anPham_ActivityImpl = new AnPham_ActivityImpl();

		anPham_ActivityImpl.setCompanyId(companyId);
		anPham_ActivityImpl.setGroupId(groupId);
		anPham_ActivityImpl.setId(id);
		anPham_ActivityImpl.setDeCuongId(deCuongId);
		anPham_ActivityImpl.setAnPhamId(anPhamId);
		anPham_ActivityImpl.setStartuserid(startuserid);
		anPham_ActivityImpl.setEnduserid(enduserid);

		if (contentrequest == null) {
			anPham_ActivityImpl.setContentrequest("");
		}
		else {
			anPham_ActivityImpl.setContentrequest(contentrequest);
		}

		anPham_ActivityImpl.setStatusofarticle(statusofarticle);

		anPham_ActivityImpl.resetOriginalValues();

		return anPham_ActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		companyId = objectInput.readLong();

		groupId = objectInput.readLong();

		id = objectInput.readLong();

		deCuongId = objectInput.readLong();

		anPhamId = objectInput.readLong();

		startuserid = objectInput.readLong();

		enduserid = objectInput.readLong();
		contentrequest = objectInput.readUTF();

		statusofarticle = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(companyId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(id);

		objectOutput.writeLong(deCuongId);

		objectOutput.writeLong(anPhamId);

		objectOutput.writeLong(startuserid);

		objectOutput.writeLong(enduserid);

		if (contentrequest == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contentrequest);
		}

		objectOutput.writeInt(statusofarticle);
	}

	public long companyId;
	public long groupId;
	public long id;
	public long deCuongId;
	public long anPhamId;
	public long startuserid;
	public long enduserid;
	public String contentrequest;
	public int statusofarticle;

}