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

package vn.dnict.tintuc.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link News_AttachFile}.
 * </p>
 *
 * @author dnict
 * @see News_AttachFile
 * @generated
 */
public class News_AttachFileWrapper
	extends BaseModelWrapper<News_AttachFile>
	implements ModelWrapper<News_AttachFile>, News_AttachFile {

	public News_AttachFileWrapper(News_AttachFile news_AttachFile) {
		super(news_AttachFile);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("ten", getTen());
		attributes.put("url", getUrl());
		attributes.put("Object", getObject());
		attributes.put("ObjectId", getObjectId());
		attributes.put("ghichu", getGhichu());
		attributes.put("daxoa", getDaxoa());
		attributes.put("trangthai", getTrangthai());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long Object = (Long)attributes.get("Object");

		if (Object != null) {
			setObject(Object);
		}

		Long ObjectId = (Long)attributes.get("ObjectId");

		if (ObjectId != null) {
			setObjectId(ObjectId);
		}

		String ghichu = (String)attributes.get("ghichu");

		if (ghichu != null) {
			setGhichu(ghichu);
		}

		Integer daxoa = (Integer)attributes.get("daxoa");

		if (daxoa != null) {
			setDaxoa(daxoa);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}
	}

	/**
	 * Returns the company ID of this news_ attach file.
	 *
	 * @return the company ID of this news_ attach file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the daxoa of this news_ attach file.
	 *
	 * @return the daxoa of this news_ attach file
	 */
	@Override
	public int getDaxoa() {
		return model.getDaxoa();
	}

	/**
	 * Returns the ghichu of this news_ attach file.
	 *
	 * @return the ghichu of this news_ attach file
	 */
	@Override
	public String getGhichu() {
		return model.getGhichu();
	}

	/**
	 * Returns the group ID of this news_ attach file.
	 *
	 * @return the group ID of this news_ attach file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ attach file.
	 *
	 * @return the ID of this news_ attach file
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the object of this news_ attach file.
	 *
	 * @return the object of this news_ attach file
	 */
	@Override
	public long getObject() {
		return model.getObject();
	}

	/**
	 * Returns the object ID of this news_ attach file.
	 *
	 * @return the object ID of this news_ attach file
	 */
	@Override
	public long getObjectId() {
		return model.getObjectId();
	}

	/**
	 * Returns the primary key of this news_ attach file.
	 *
	 * @return the primary key of this news_ attach file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this news_ attach file.
	 *
	 * @return the ten of this news_ attach file
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trangthai of this news_ attach file.
	 *
	 * @return the trangthai of this news_ attach file
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the url of this news_ attach file.
	 *
	 * @return the url of this news_ attach file
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this news_ attach file.
	 *
	 * @return the user ID of this news_ attach file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this news_ attach file.
	 *
	 * @return the user uuid of this news_ attach file
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this news_ attach file.
	 *
	 * @param companyId the company ID of this news_ attach file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the daxoa of this news_ attach file.
	 *
	 * @param daxoa the daxoa of this news_ attach file
	 */
	@Override
	public void setDaxoa(int daxoa) {
		model.setDaxoa(daxoa);
	}

	/**
	 * Sets the ghichu of this news_ attach file.
	 *
	 * @param ghichu the ghichu of this news_ attach file
	 */
	@Override
	public void setGhichu(String ghichu) {
		model.setGhichu(ghichu);
	}

	/**
	 * Sets the group ID of this news_ attach file.
	 *
	 * @param groupId the group ID of this news_ attach file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ attach file.
	 *
	 * @param id the ID of this news_ attach file
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the object of this news_ attach file.
	 *
	 * @param Object the object of this news_ attach file
	 */
	@Override
	public void setObject(long Object) {
		model.setObject(Object);
	}

	/**
	 * Sets the object ID of this news_ attach file.
	 *
	 * @param ObjectId the object ID of this news_ attach file
	 */
	@Override
	public void setObjectId(long ObjectId) {
		model.setObjectId(ObjectId);
	}

	/**
	 * Sets the primary key of this news_ attach file.
	 *
	 * @param primaryKey the primary key of this news_ attach file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this news_ attach file.
	 *
	 * @param ten the ten of this news_ attach file
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trangthai of this news_ attach file.
	 *
	 * @param trangthai the trangthai of this news_ attach file
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the url of this news_ attach file.
	 *
	 * @param url the url of this news_ attach file
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this news_ attach file.
	 *
	 * @param userId the user ID of this news_ attach file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this news_ attach file.
	 *
	 * @param userUuid the user uuid of this news_ attach file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected News_AttachFileWrapper wrap(News_AttachFile news_AttachFile) {
		return new News_AttachFileWrapper(news_AttachFile);
	}

}