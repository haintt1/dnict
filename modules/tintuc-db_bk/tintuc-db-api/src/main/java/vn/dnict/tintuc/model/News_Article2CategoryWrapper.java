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
 * This class is a wrapper for {@link News_Article2Category}.
 * </p>
 *
 * @author dnict
 * @see News_Article2Category
 * @generated
 */
public class News_Article2CategoryWrapper
	extends BaseModelWrapper<News_Article2Category>
	implements ModelWrapper<News_Article2Category>, News_Article2Category {

	public News_Article2CategoryWrapper(
		News_Article2Category news_Article2Category) {

		super(news_Article2Category);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("newcategoryId", getNewcategoryId());
		attributes.put("newarticleId", getNewarticleId());

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

		Long newcategoryId = (Long)attributes.get("newcategoryId");

		if (newcategoryId != null) {
			setNewcategoryId(newcategoryId);
		}

		Long newarticleId = (Long)attributes.get("newarticleId");

		if (newarticleId != null) {
			setNewarticleId(newarticleId);
		}
	}

	/**
	 * Returns the company ID of this news_ article2 category.
	 *
	 * @return the company ID of this news_ article2 category
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this news_ article2 category.
	 *
	 * @return the group ID of this news_ article2 category
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ article2 category.
	 *
	 * @return the ID of this news_ article2 category
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the newarticle ID of this news_ article2 category.
	 *
	 * @return the newarticle ID of this news_ article2 category
	 */
	@Override
	public long getNewarticleId() {
		return model.getNewarticleId();
	}

	/**
	 * Returns the newcategory ID of this news_ article2 category.
	 *
	 * @return the newcategory ID of this news_ article2 category
	 */
	@Override
	public long getNewcategoryId() {
		return model.getNewcategoryId();
	}

	/**
	 * Returns the primary key of this news_ article2 category.
	 *
	 * @return the primary key of this news_ article2 category
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this news_ article2 category.
	 *
	 * @param companyId the company ID of this news_ article2 category
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this news_ article2 category.
	 *
	 * @param groupId the group ID of this news_ article2 category
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ article2 category.
	 *
	 * @param id the ID of this news_ article2 category
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the newarticle ID of this news_ article2 category.
	 *
	 * @param newarticleId the newarticle ID of this news_ article2 category
	 */
	@Override
	public void setNewarticleId(long newarticleId) {
		model.setNewarticleId(newarticleId);
	}

	/**
	 * Sets the newcategory ID of this news_ article2 category.
	 *
	 * @param newcategoryId the newcategory ID of this news_ article2 category
	 */
	@Override
	public void setNewcategoryId(long newcategoryId) {
		model.setNewcategoryId(newcategoryId);
	}

	/**
	 * Sets the primary key of this news_ article2 category.
	 *
	 * @param primaryKey the primary key of this news_ article2 category
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected News_Article2CategoryWrapper wrap(
		News_Article2Category news_Article2Category) {

		return new News_Article2CategoryWrapper(news_Article2Category);
	}

}