/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link emailTemplate}.
 * </p>
 *
 * @author dnict
 * @see emailTemplate
 * @generated
 */
public class emailTemplateWrapper
	extends BaseModelWrapper<emailTemplate>
	implements emailTemplate, ModelWrapper<emailTemplate> {

	public emailTemplateWrapper(emailTemplate emailTemplate) {
		super(emailTemplate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("ten", getTen());
		attributes.put("noidung", getNoidung());
		attributes.put("loai", getLoai());

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

		Integer loai = (Integer)attributes.get("loai");

		if (loai != null) {
			setLoai(loai);
		}
	}

	/**
	 * Returns the company ID of this email template.
	 *
	 * @return the company ID of this email template
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this email template.
	 *
	 * @return the group ID of this email template
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this email template.
	 *
	 * @return the ID of this email template
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the loai of this email template.
	 *
	 * @return the loai of this email template
	 */
	@Override
	public int getLoai() {
		return model.getLoai();
	}

	/**
	 * Returns the noidung of this email template.
	 *
	 * @return the noidung of this email template
	 */
	@Override
	public String getNoidung() {
		return model.getNoidung();
	}

	/**
	 * Returns the primary key of this email template.
	 *
	 * @return the primary key of this email template
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this email template.
	 *
	 * @return the ten of this email template
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
	 * Sets the company ID of this email template.
	 *
	 * @param companyId the company ID of this email template
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this email template.
	 *
	 * @param groupId the group ID of this email template
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this email template.
	 *
	 * @param id the ID of this email template
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the loai of this email template.
	 *
	 * @param loai the loai of this email template
	 */
	@Override
	public void setLoai(int loai) {
		model.setLoai(loai);
	}

	/**
	 * Sets the noidung of this email template.
	 *
	 * @param noidung the noidung of this email template
	 */
	@Override
	public void setNoidung(String noidung) {
		model.setNoidung(noidung);
	}

	/**
	 * Sets the primary key of this email template.
	 *
	 * @param primaryKey the primary key of this email template
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this email template.
	 *
	 * @param ten the ten of this email template
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	@Override
	protected emailTemplateWrapper wrap(emailTemplate emailTemplate) {
		return new emailTemplateWrapper(emailTemplate);
	}

}