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
 * This class is a wrapper for {@link DinhMuc}.
 * </p>
 *
 * @author dnict
 * @see DinhMuc
 * @generated
 */
public class DinhMucWrapper
	extends BaseModelWrapper<DinhMuc>
	implements DinhMuc, ModelWrapper<DinhMuc> {

	public DinhMucWrapper(DinhMuc dinhMuc) {
		super(dinhMuc);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("loaidinhmuc", getLoaidinhmuc());
		attributes.put("gia", getGia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Integer loaidinhmuc = (Integer)attributes.get("loaidinhmuc");

		if (loaidinhmuc != null) {
			setLoaidinhmuc(loaidinhmuc);
		}

		String gia = (String)attributes.get("gia");

		if (gia != null) {
			setGia(gia);
		}
	}

	/**
	 * Returns the gia of this dinh muc.
	 *
	 * @return the gia of this dinh muc
	 */
	@Override
	public String getGia() {
		return model.getGia();
	}

	/**
	 * Returns the ID of this dinh muc.
	 *
	 * @return the ID of this dinh muc
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the loaidinhmuc of this dinh muc.
	 *
	 * @return the loaidinhmuc of this dinh muc
	 */
	@Override
	public int getLoaidinhmuc() {
		return model.getLoaidinhmuc();
	}

	/**
	 * Returns the primary key of this dinh muc.
	 *
	 * @return the primary key of this dinh muc
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
	 * Sets the gia of this dinh muc.
	 *
	 * @param gia the gia of this dinh muc
	 */
	@Override
	public void setGia(String gia) {
		model.setGia(gia);
	}

	/**
	 * Sets the ID of this dinh muc.
	 *
	 * @param id the ID of this dinh muc
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the loaidinhmuc of this dinh muc.
	 *
	 * @param loaidinhmuc the loaidinhmuc of this dinh muc
	 */
	@Override
	public void setLoaidinhmuc(int loaidinhmuc) {
		model.setLoaidinhmuc(loaidinhmuc);
	}

	/**
	 * Sets the primary key of this dinh muc.
	 *
	 * @param primaryKey the primary key of this dinh muc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected DinhMucWrapper wrap(DinhMuc dinhMuc) {
		return new DinhMucWrapper(dinhMuc);
	}

}