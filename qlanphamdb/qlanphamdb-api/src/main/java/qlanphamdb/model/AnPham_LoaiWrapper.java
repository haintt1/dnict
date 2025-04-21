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
 * This class is a wrapper for {@link AnPham_Loai}.
 * </p>
 *
 * @author dnict
 * @see AnPham_Loai
 * @generated
 */
public class AnPham_LoaiWrapper
	extends BaseModelWrapper<AnPham_Loai>
	implements AnPham_Loai, ModelWrapper<AnPham_Loai> {

	public AnPham_LoaiWrapper(AnPham_Loai anPham_Loai) {
		super(anPham_Loai);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("ten", getTen());
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long orders = (Long)attributes.get("orders");

		if (orders != null) {
			setOrders(orders);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}
	}

	/**
	 * Returns the company ID of this an pham_ loai.
	 *
	 * @return the company ID of this an pham_ loai
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this an pham_ loai.
	 *
	 * @return the delete_status of this an pham_ loai
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this an pham_ loai.
	 *
	 * @return the group ID of this an pham_ loai
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this an pham_ loai.
	 *
	 * @return the ID of this an pham_ loai
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the orders of this an pham_ loai.
	 *
	 * @return the orders of this an pham_ loai
	 */
	@Override
	public long getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the primary key of this an pham_ loai.
	 *
	 * @return the primary key of this an pham_ loai
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this an pham_ loai.
	 *
	 * @return the status of this an pham_ loai
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this an pham_ loai.
	 *
	 * @return the ten of this an pham_ loai
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this an pham_ loai.
	 *
	 * @param companyId the company ID of this an pham_ loai
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this an pham_ loai.
	 *
	 * @param delete_status the delete_status of this an pham_ loai
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this an pham_ loai.
	 *
	 * @param groupId the group ID of this an pham_ loai
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this an pham_ loai.
	 *
	 * @param id the ID of this an pham_ loai
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the orders of this an pham_ loai.
	 *
	 * @param orders the orders of this an pham_ loai
	 */
	@Override
	public void setOrders(long orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the primary key of this an pham_ loai.
	 *
	 * @param primaryKey the primary key of this an pham_ loai
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this an pham_ loai.
	 *
	 * @param status the status of this an pham_ loai
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this an pham_ loai.
	 *
	 * @param ten the ten of this an pham_ loai
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	@Override
	protected AnPham_LoaiWrapper wrap(AnPham_Loai anPham_Loai) {
		return new AnPham_LoaiWrapper(anPham_Loai);
	}

}