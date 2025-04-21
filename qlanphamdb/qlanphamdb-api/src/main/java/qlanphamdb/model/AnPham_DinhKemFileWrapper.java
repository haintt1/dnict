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

package qlanphamdb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnPham_DinhKemFile}.
 * </p>
 *
 * @author dnict
 * @see AnPham_DinhKemFile
 * @generated
 */
public class AnPham_DinhKemFileWrapper
	extends BaseModelWrapper<AnPham_DinhKemFile>
	implements AnPham_DinhKemFile, ModelWrapper<AnPham_DinhKemFile> {

	public AnPham_DinhKemFileWrapper(AnPham_DinhKemFile anPham_DinhKemFile) {
		super(anPham_DinhKemFile);
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
		attributes.put("luotTai", getLuotTai());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("delete_status", getDelete_status());
		attributes.put("status", getStatus());

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

		Long luotTai = (Long)attributes.get("luotTai");

		if (luotTai != null) {
			setLuotTai(luotTai);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this an pham_ dinh kem file.
	 *
	 * @return the company ID of this an pham_ dinh kem file
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this an pham_ dinh kem file.
	 *
	 * @return the delete_status of this an pham_ dinh kem file
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the ghi chu of this an pham_ dinh kem file.
	 *
	 * @return the ghi chu of this an pham_ dinh kem file
	 */
	@Override
	public String getGhiChu() {
		return model.getGhiChu();
	}

	/**
	 * Returns the group ID of this an pham_ dinh kem file.
	 *
	 * @return the group ID of this an pham_ dinh kem file
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this an pham_ dinh kem file.
	 *
	 * @return the ID of this an pham_ dinh kem file
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the luot tai of this an pham_ dinh kem file.
	 *
	 * @return the luot tai of this an pham_ dinh kem file
	 */
	@Override
	public long getLuotTai() {
		return model.getLuotTai();
	}

	/**
	 * Returns the object of this an pham_ dinh kem file.
	 *
	 * @return the object of this an pham_ dinh kem file
	 */
	@Override
	public long getObject() {
		return model.getObject();
	}

	/**
	 * Returns the object ID of this an pham_ dinh kem file.
	 *
	 * @return the object ID of this an pham_ dinh kem file
	 */
	@Override
	public long getObjectId() {
		return model.getObjectId();
	}

	/**
	 * Returns the primary key of this an pham_ dinh kem file.
	 *
	 * @return the primary key of this an pham_ dinh kem file
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this an pham_ dinh kem file.
	 *
	 * @return the status of this an pham_ dinh kem file
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this an pham_ dinh kem file.
	 *
	 * @return the ten of this an pham_ dinh kem file
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the url of this an pham_ dinh kem file.
	 *
	 * @return the url of this an pham_ dinh kem file
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this an pham_ dinh kem file.
	 *
	 * @return the user ID of this an pham_ dinh kem file
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this an pham_ dinh kem file.
	 *
	 * @return the user uuid of this an pham_ dinh kem file
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
	 * Sets the company ID of this an pham_ dinh kem file.
	 *
	 * @param companyId the company ID of this an pham_ dinh kem file
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this an pham_ dinh kem file.
	 *
	 * @param delete_status the delete_status of this an pham_ dinh kem file
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the ghi chu of this an pham_ dinh kem file.
	 *
	 * @param ghiChu the ghi chu of this an pham_ dinh kem file
	 */
	@Override
	public void setGhiChu(String ghiChu) {
		model.setGhiChu(ghiChu);
	}

	/**
	 * Sets the group ID of this an pham_ dinh kem file.
	 *
	 * @param groupId the group ID of this an pham_ dinh kem file
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this an pham_ dinh kem file.
	 *
	 * @param id the ID of this an pham_ dinh kem file
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the luot tai of this an pham_ dinh kem file.
	 *
	 * @param luotTai the luot tai of this an pham_ dinh kem file
	 */
	@Override
	public void setLuotTai(long luotTai) {
		model.setLuotTai(luotTai);
	}

	/**
	 * Sets the object of this an pham_ dinh kem file.
	 *
	 * @param Object the object of this an pham_ dinh kem file
	 */
	@Override
	public void setObject(long Object) {
		model.setObject(Object);
	}

	/**
	 * Sets the object ID of this an pham_ dinh kem file.
	 *
	 * @param ObjectId the object ID of this an pham_ dinh kem file
	 */
	@Override
	public void setObjectId(long ObjectId) {
		model.setObjectId(ObjectId);
	}

	/**
	 * Sets the primary key of this an pham_ dinh kem file.
	 *
	 * @param primaryKey the primary key of this an pham_ dinh kem file
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this an pham_ dinh kem file.
	 *
	 * @param status the status of this an pham_ dinh kem file
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this an pham_ dinh kem file.
	 *
	 * @param ten the ten of this an pham_ dinh kem file
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the url of this an pham_ dinh kem file.
	 *
	 * @param url the url of this an pham_ dinh kem file
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this an pham_ dinh kem file.
	 *
	 * @param userId the user ID of this an pham_ dinh kem file
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this an pham_ dinh kem file.
	 *
	 * @param userUuid the user uuid of this an pham_ dinh kem file
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AnPham_DinhKemFileWrapper wrap(
		AnPham_DinhKemFile anPham_DinhKemFile) {

		return new AnPham_DinhKemFileWrapper(anPham_DinhKemFile);
	}

}