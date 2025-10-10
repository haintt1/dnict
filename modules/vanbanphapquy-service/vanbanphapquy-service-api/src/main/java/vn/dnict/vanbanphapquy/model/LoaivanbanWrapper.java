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
 * This class is a wrapper for {@link Loaivanban}.
 * </p>
 *
 * @author BinhNT
 * @see Loaivanban
 * @generated
 */
public class LoaivanbanWrapper
	extends BaseModelWrapper<Loaivanban>
	implements Loaivanban, ModelWrapper<Loaivanban> {

	public LoaivanbanWrapper(Loaivanban loaivanban) {
		super(loaivanban);
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
	 * Returns the code of this loaivanban.
	 *
	 * @return the code of this loaivanban
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the company ID of this loaivanban.
	 *
	 * @return the company ID of this loaivanban
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this loaivanban.
	 *
	 * @return the group ID of this loaivanban
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this loaivanban.
	 *
	 * @return the ID of this loaivanban
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this loaivanban.
	 *
	 * @return the name of this loaivanban
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this loaivanban.
	 *
	 * @return the primary key of this loaivanban
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this loaivanban.
	 *
	 * @return the status of this loaivanban
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
	 * Sets the code of this loaivanban.
	 *
	 * @param code the code of this loaivanban
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the company ID of this loaivanban.
	 *
	 * @param companyId the company ID of this loaivanban
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this loaivanban.
	 *
	 * @param groupId the group ID of this loaivanban
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this loaivanban.
	 *
	 * @param id the ID of this loaivanban
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this loaivanban.
	 *
	 * @param name the name of this loaivanban
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this loaivanban.
	 *
	 * @param primaryKey the primary key of this loaivanban
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this loaivanban.
	 *
	 * @param status the status of this loaivanban
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected LoaivanbanWrapper wrap(Loaivanban loaivanban) {
		return new LoaivanbanWrapper(loaivanban);
	}

}