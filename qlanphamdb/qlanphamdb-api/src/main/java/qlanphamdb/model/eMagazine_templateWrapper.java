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
 * This class is a wrapper for {@link eMagazine_template}.
 * </p>
 *
 * @author dnict
 * @see eMagazine_template
 * @generated
 */
public class eMagazine_templateWrapper
	extends BaseModelWrapper<eMagazine_template>
	implements eMagazine_template, ModelWrapper<eMagazine_template> {

	public eMagazine_templateWrapper(eMagazine_template eMagazine_template) {
		super(eMagazine_template);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("ten", getTen());
		attributes.put("noidung", getNoidung());
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

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String noidung = (String)attributes.get("noidung");

		if (noidung != null) {
			setNoidung(noidung);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this e magazine_template.
	 *
	 * @return the company ID of this e magazine_template
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this e magazine_template.
	 *
	 * @return the group ID of this e magazine_template
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this e magazine_template.
	 *
	 * @return the ID of this e magazine_template
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the noidung of this e magazine_template.
	 *
	 * @return the noidung of this e magazine_template
	 */
	@Override
	public String getNoidung() {
		return model.getNoidung();
	}

	/**
	 * Returns the primary key of this e magazine_template.
	 *
	 * @return the primary key of this e magazine_template
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this e magazine_template.
	 *
	 * @return the status of this e magazine_template
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this e magazine_template.
	 *
	 * @return the ten of this e magazine_template
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
	 * Sets the company ID of this e magazine_template.
	 *
	 * @param companyId the company ID of this e magazine_template
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this e magazine_template.
	 *
	 * @param groupId the group ID of this e magazine_template
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this e magazine_template.
	 *
	 * @param id the ID of this e magazine_template
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the noidung of this e magazine_template.
	 *
	 * @param noidung the noidung of this e magazine_template
	 */
	@Override
	public void setNoidung(String noidung) {
		model.setNoidung(noidung);
	}

	/**
	 * Sets the primary key of this e magazine_template.
	 *
	 * @param primaryKey the primary key of this e magazine_template
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this e magazine_template.
	 *
	 * @param status the status of this e magazine_template
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this e magazine_template.
	 *
	 * @param ten the ten of this e magazine_template
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	@Override
	protected eMagazine_templateWrapper wrap(
		eMagazine_template eMagazine_template) {

		return new eMagazine_templateWrapper(eMagazine_template);
	}

}