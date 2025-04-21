/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HeSoTheLoai}.
 * </p>
 *
 * @author dnict
 * @see HeSoTheLoai
 * @generated
 */
public class HeSoTheLoaiWrapper
	extends BaseModelWrapper<HeSoTheLoai>
	implements HeSoTheLoai, ModelWrapper<HeSoTheLoai> {

	public HeSoTheLoaiWrapper(HeSoTheLoai heSoTheLoai) {
		super(heSoTheLoai);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("typeId", getTypeId());
		attributes.put("minheso", getMinheso());
		attributes.put("maxheso", getMaxheso());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
		}

		String minheso = (String)attributes.get("minheso");

		if (minheso != null) {
			setMinheso(minheso);
		}

		String maxheso = (String)attributes.get("maxheso");

		if (maxheso != null) {
			setMaxheso(maxheso);
		}
	}

	/**
	 * Returns the ID of this he so the loai.
	 *
	 * @return the ID of this he so the loai
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the maxheso of this he so the loai.
	 *
	 * @return the maxheso of this he so the loai
	 */
	@Override
	public String getMaxheso() {
		return model.getMaxheso();
	}

	/**
	 * Returns the minheso of this he so the loai.
	 *
	 * @return the minheso of this he so the loai
	 */
	@Override
	public String getMinheso() {
		return model.getMinheso();
	}

	/**
	 * Returns the primary key of this he so the loai.
	 *
	 * @return the primary key of this he so the loai
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the type ID of this he so the loai.
	 *
	 * @return the type ID of this he so the loai
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this he so the loai.
	 *
	 * @param id the ID of this he so the loai
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the maxheso of this he so the loai.
	 *
	 * @param maxheso the maxheso of this he so the loai
	 */
	@Override
	public void setMaxheso(String maxheso) {
		model.setMaxheso(maxheso);
	}

	/**
	 * Sets the minheso of this he so the loai.
	 *
	 * @param minheso the minheso of this he so the loai
	 */
	@Override
	public void setMinheso(String minheso) {
		model.setMinheso(minheso);
	}

	/**
	 * Sets the primary key of this he so the loai.
	 *
	 * @param primaryKey the primary key of this he so the loai
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the type ID of this he so the loai.
	 *
	 * @param typeId the type ID of this he so the loai
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	@Override
	protected HeSoTheLoaiWrapper wrap(HeSoTheLoai heSoTheLoai) {
		return new HeSoTheLoaiWrapper(heSoTheLoai);
	}

}