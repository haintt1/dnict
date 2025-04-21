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
 * This class is a wrapper for {@link News_NguonTin}.
 * </p>
 *
 * @author dnict
 * @see News_NguonTin
 * @generated
 */
public class News_NguonTinWrapper
	extends BaseModelWrapper<News_NguonTin>
	implements ModelWrapper<News_NguonTin>, News_NguonTin {

	public News_NguonTinWrapper(News_NguonTin news_NguonTin) {
		super(news_NguonTin);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
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
	 * Returns the company ID of this news_ nguon tin.
	 *
	 * @return the company ID of this news_ nguon tin
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this news_ nguon tin.
	 *
	 * @return the delete_status of this news_ nguon tin
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this news_ nguon tin.
	 *
	 * @return the group ID of this news_ nguon tin
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ nguon tin.
	 *
	 * @return the ID of this news_ nguon tin
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this news_ nguon tin.
	 *
	 * @return the name of this news_ nguon tin
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the orders of this news_ nguon tin.
	 *
	 * @return the orders of this news_ nguon tin
	 */
	@Override
	public int getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the primary key of this news_ nguon tin.
	 *
	 * @return the primary key of this news_ nguon tin
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this news_ nguon tin.
	 *
	 * @return the status of this news_ nguon tin
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
	 * Sets the company ID of this news_ nguon tin.
	 *
	 * @param companyId the company ID of this news_ nguon tin
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this news_ nguon tin.
	 *
	 * @param delete_status the delete_status of this news_ nguon tin
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this news_ nguon tin.
	 *
	 * @param groupId the group ID of this news_ nguon tin
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ nguon tin.
	 *
	 * @param id the ID of this news_ nguon tin
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this news_ nguon tin.
	 *
	 * @param name the name of this news_ nguon tin
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the orders of this news_ nguon tin.
	 *
	 * @param orders the orders of this news_ nguon tin
	 */
	@Override
	public void setOrders(int orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the primary key of this news_ nguon tin.
	 *
	 * @param primaryKey the primary key of this news_ nguon tin
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this news_ nguon tin.
	 *
	 * @param status the status of this news_ nguon tin
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected News_NguonTinWrapper wrap(News_NguonTin news_NguonTin) {
		return new News_NguonTinWrapper(news_NguonTin);
	}

}