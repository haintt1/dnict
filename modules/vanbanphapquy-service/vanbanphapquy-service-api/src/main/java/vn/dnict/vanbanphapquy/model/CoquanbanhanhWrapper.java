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

package vn.dnict.vanbanphapquy.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Coquanbanhanh}.
 * </p>
 *
 * @author BinhNT
 * @see Coquanbanhanh
 * @generated
 */
public class CoquanbanhanhWrapper
	extends BaseModelWrapper<Coquanbanhanh>
	implements Coquanbanhanh, ModelWrapper<Coquanbanhanh> {

	public CoquanbanhanhWrapper(Coquanbanhanh coquanbanhanh) {
		super(coquanbanhanh);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the code of this coquanbanhanh.
	 *
	 * @return the code of this coquanbanhanh
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this coquanbanhanh.
	 *
	 * @return the company ID of this coquanbanhanh
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this coquanbanhanh.
	 *
	 * @return the group ID of this coquanbanhanh
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this coquanbanhanh.
	 *
	 * @return the ID of this coquanbanhanh
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this coquanbanhanh.
	 *
	 * @return the name of this coquanbanhanh
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this coquanbanhanh.
	 *
	 * @return the primary key of this coquanbanhanh
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this coquanbanhanh.
	 *
	 * @return the status of this coquanbanhanh
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
	 * Sets the code of this coquanbanhanh.
	 *
	 * @param code the code of this coquanbanhanh
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this coquanbanhanh.
	 *
	 * @param companyId the company ID of this coquanbanhanh
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this coquanbanhanh.
	 *
	 * @param groupId the group ID of this coquanbanhanh
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this coquanbanhanh.
	 *
	 * @param id the ID of this coquanbanhanh
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this coquanbanhanh.
	 *
	 * @param name the name of this coquanbanhanh
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this coquanbanhanh.
	 *
	 * @param primaryKey the primary key of this coquanbanhanh
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this coquanbanhanh.
	 *
	 * @param status the status of this coquanbanhanh
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected CoquanbanhanhWrapper wrap(Coquanbanhanh coquanbanhanh) {
		return new CoquanbanhanhWrapper(coquanbanhanh);
	}

}