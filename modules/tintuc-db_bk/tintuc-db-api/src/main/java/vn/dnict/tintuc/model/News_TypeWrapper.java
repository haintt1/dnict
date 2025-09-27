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
 * This class is a wrapper for {@link News_Type}.
 * </p>
 *
 * @author dnict
 * @see News_Type
 * @generated
 */
public class News_TypeWrapper
	extends BaseModelWrapper<News_Type>
	implements ModelWrapper<News_Type>, News_Type {

	public News_TypeWrapper(News_Type news_Type) {
		super(news_Type);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("language", getLanguage());
		attributes.put("status", getStatus());
		attributes.put("orders", getOrders());
		attributes.put("delete_status", getDelete_status());

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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer orders = (Integer)attributes.get("orders");

		if (orders != null) {
			setOrders(orders);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}
	}

	/**
	 * Returns the company ID of this news_ type.
	 *
	 * @return the company ID of this news_ type
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this news_ type.
	 *
	 * @return the delete_status of this news_ type
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this news_ type.
	 *
	 * @return the group ID of this news_ type
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ type.
	 *
	 * @return the ID of this news_ type
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the language of this news_ type.
	 *
	 * @return the language of this news_ type
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the name of this news_ type.
	 *
	 * @return the name of this news_ type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the orders of this news_ type.
	 *
	 * @return the orders of this news_ type
	 */
	@Override
	public int getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the primary key of this news_ type.
	 *
	 * @return the primary key of this news_ type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this news_ type.
	 *
	 * @return the status of this news_ type
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this news_ type.
	 *
	 * @param companyId the company ID of this news_ type
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this news_ type.
	 *
	 * @param delete_status the delete_status of this news_ type
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this news_ type.
	 *
	 * @param groupId the group ID of this news_ type
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ type.
	 *
	 * @param id the ID of this news_ type
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the language of this news_ type.
	 *
	 * @param language the language of this news_ type
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the name of this news_ type.
	 *
	 * @param name the name of this news_ type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the orders of this news_ type.
	 *
	 * @param orders the orders of this news_ type
	 */
	@Override
	public void setOrders(int orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the primary key of this news_ type.
	 *
	 * @param primaryKey the primary key of this news_ type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this news_ type.
	 *
	 * @param status the status of this news_ type
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected News_TypeWrapper wrap(News_Type news_Type) {
		return new News_TypeWrapper(news_Type);
	}

}