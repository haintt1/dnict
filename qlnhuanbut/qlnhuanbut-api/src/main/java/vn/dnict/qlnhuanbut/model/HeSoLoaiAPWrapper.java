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
 * This class is a wrapper for {@link HeSoLoaiAP}.
 * </p>
 *
 * @author dnict
 * @see HeSoLoaiAP
 * @generated
 */
public class HeSoLoaiAPWrapper
	extends BaseModelWrapper<HeSoLoaiAP>
	implements HeSoLoaiAP, ModelWrapper<HeSoLoaiAP> {

	public HeSoLoaiAPWrapper(HeSoLoaiAP heSoLoaiAP) {
		super(heSoLoaiAP);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("loaiId", getLoaiId());
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

		Long loaiId = (Long)attributes.get("loaiId");

		if (loaiId != null) {
			setLoaiId(loaiId);
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
	 * Returns the ID of this he so loai ap.
	 *
	 * @return the ID of this he so loai ap
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the loai ID of this he so loai ap.
	 *
	 * @return the loai ID of this he so loai ap
	 */
	@Override
	public long getLoaiId() {
		return model.getLoaiId();
	}

	/**
	 * Returns the maxheso of this he so loai ap.
	 *
	 * @return the maxheso of this he so loai ap
	 */
	@Override
	public String getMaxheso() {
		return model.getMaxheso();
	}

	/**
	 * Returns the minheso of this he so loai ap.
	 *
	 * @return the minheso of this he so loai ap
	 */
	@Override
	public String getMinheso() {
		return model.getMinheso();
	}

	/**
	 * Returns the primary key of this he so loai ap.
	 *
	 * @return the primary key of this he so loai ap
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
	 * Sets the ID of this he so loai ap.
	 *
	 * @param id the ID of this he so loai ap
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the loai ID of this he so loai ap.
	 *
	 * @param loaiId the loai ID of this he so loai ap
	 */
	@Override
	public void setLoaiId(long loaiId) {
		model.setLoaiId(loaiId);
	}

	/**
	 * Sets the maxheso of this he so loai ap.
	 *
	 * @param maxheso the maxheso of this he so loai ap
	 */
	@Override
	public void setMaxheso(String maxheso) {
		model.setMaxheso(maxheso);
	}

	/**
	 * Sets the minheso of this he so loai ap.
	 *
	 * @param minheso the minheso of this he so loai ap
	 */
	@Override
	public void setMinheso(String minheso) {
		model.setMinheso(minheso);
	}

	/**
	 * Sets the primary key of this he so loai ap.
	 *
	 * @param primaryKey the primary key of this he so loai ap
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected HeSoLoaiAPWrapper wrap(HeSoLoaiAP heSoLoaiAP) {
		return new HeSoLoaiAPWrapper(heSoLoaiAP);
	}

}