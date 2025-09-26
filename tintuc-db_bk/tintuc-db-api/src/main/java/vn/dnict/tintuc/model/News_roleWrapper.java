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
 * This class is a wrapper for {@link News_role}.
 * </p>
 *
 * @author dnict
 * @see News_role
 * @generated
 */
public class News_roleWrapper
	extends BaseModelWrapper<News_role>
	implements ModelWrapper<News_role>, News_role {

	public News_roleWrapper(News_role news_role) {
		super(news_role);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("id", getId());
		attributes.put("userid", getUserid());
		attributes.put("role_add", getRole_add());
		attributes.put("role_edit", getRole_edit());
		attributes.put("role_public", getRole_public());
		attributes.put("category_active_role", getCategory_active_role());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long userid = (Long)attributes.get("userid");

		if (userid != null) {
			setUserid(userid);
		}

		Integer role_add = (Integer)attributes.get("role_add");

		if (role_add != null) {
			setRole_add(role_add);
		}

		Integer role_edit = (Integer)attributes.get("role_edit");

		if (role_edit != null) {
			setRole_edit(role_edit);
		}

		Integer role_public = (Integer)attributes.get("role_public");

		if (role_public != null) {
			setRole_public(role_public);
		}

		String category_active_role = (String)attributes.get(
			"category_active_role");

		if (category_active_role != null) {
			setCategory_active_role(category_active_role);
		}
	}

	/**
	 * Returns the category_active_role of this news_role.
	 *
	 * @return the category_active_role of this news_role
	 */
	@Override
	public String getCategory_active_role() {
		return model.getCategory_active_role();
	}

	/**
	 * Returns the company ID of this news_role.
	 *
	 * @return the company ID of this news_role
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this news_role.
	 *
	 * @return the group ID of this news_role
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_role.
	 *
	 * @return the ID of this news_role
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this news_role.
	 *
	 * @return the primary key of this news_role
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role_add of this news_role.
	 *
	 * @return the role_add of this news_role
	 */
	@Override
	public int getRole_add() {
		return model.getRole_add();
	}

	/**
	 * Returns the role_edit of this news_role.
	 *
	 * @return the role_edit of this news_role
	 */
	@Override
	public int getRole_edit() {
		return model.getRole_edit();
	}

	/**
	 * Returns the role_public of this news_role.
	 *
	 * @return the role_public of this news_role
	 */
	@Override
	public int getRole_public() {
		return model.getRole_public();
	}

	/**
	 * Returns the userid of this news_role.
	 *
	 * @return the userid of this news_role
	 */
	@Override
	public long getUserid() {
		return model.getUserid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the category_active_role of this news_role.
	 *
	 * @param category_active_role the category_active_role of this news_role
	 */
	@Override
	public void setCategory_active_role(String category_active_role) {
		model.setCategory_active_role(category_active_role);
	}

	/**
	 * Sets the company ID of this news_role.
	 *
	 * @param companyId the company ID of this news_role
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this news_role.
	 *
	 * @param groupId the group ID of this news_role
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_role.
	 *
	 * @param id the ID of this news_role
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this news_role.
	 *
	 * @param primaryKey the primary key of this news_role
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role_add of this news_role.
	 *
	 * @param role_add the role_add of this news_role
	 */
	@Override
	public void setRole_add(int role_add) {
		model.setRole_add(role_add);
	}

	/**
	 * Sets the role_edit of this news_role.
	 *
	 * @param role_edit the role_edit of this news_role
	 */
	@Override
	public void setRole_edit(int role_edit) {
		model.setRole_edit(role_edit);
	}

	/**
	 * Sets the role_public of this news_role.
	 *
	 * @param role_public the role_public of this news_role
	 */
	@Override
	public void setRole_public(int role_public) {
		model.setRole_public(role_public);
	}

	/**
	 * Sets the userid of this news_role.
	 *
	 * @param userid the userid of this news_role
	 */
	@Override
	public void setUserid(long userid) {
		model.setUserid(userid);
	}

	@Override
	protected News_roleWrapper wrap(News_role news_role) {
		return new News_roleWrapper(news_role);
	}

}