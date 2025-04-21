/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DemoDB}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemoDB
 * @generated
 */
public class DemoDBWrapper
	extends BaseModelWrapper<DemoDB> implements DemoDB, ModelWrapper<DemoDB> {

	public DemoDBWrapper(DemoDB demoDB) {
		super(demoDB);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("noiDung", getNoiDung());
		attributes.put("ngayxuatban", getNgayxuatban());
		attributes.put("ngayhethan", getNgayhethan());
		attributes.put("tinhtrang", getTinhtrang());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		Date ngayxuatban = (Date)attributes.get("ngayxuatban");

		if (ngayxuatban != null) {
			setNgayxuatban(ngayxuatban);
		}

		Date ngayhethan = (Date)attributes.get("ngayhethan");

		if (ngayhethan != null) {
			setNgayhethan(ngayhethan);
		}

		Integer tinhtrang = (Integer)attributes.get("tinhtrang");

		if (tinhtrang != null) {
			setTinhtrang(tinhtrang);
		}
	}

	/**
	 * Returns the ID of this demo db.
	 *
	 * @return the ID of this demo db
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mo ta of this demo db.
	 *
	 * @return the mo ta of this demo db
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngayhethan of this demo db.
	 *
	 * @return the ngayhethan of this demo db
	 */
	@Override
	public Date getNgayhethan() {
		return model.getNgayhethan();
	}

	/**
	 * Returns the ngayxuatban of this demo db.
	 *
	 * @return the ngayxuatban of this demo db
	 */
	@Override
	public Date getNgayxuatban() {
		return model.getNgayxuatban();
	}

	/**
	 * Returns the noi dung of this demo db.
	 *
	 * @return the noi dung of this demo db
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the primary key of this demo db.
	 *
	 * @return the primary key of this demo db
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this demo db.
	 *
	 * @return the ten of this demo db
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tinhtrang of this demo db.
	 *
	 * @return the tinhtrang of this demo db
	 */
	@Override
	public int getTinhtrang() {
		return model.getTinhtrang();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this demo db.
	 *
	 * @param id the ID of this demo db
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mo ta of this demo db.
	 *
	 * @param moTa the mo ta of this demo db
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngayhethan of this demo db.
	 *
	 * @param ngayhethan the ngayhethan of this demo db
	 */
	@Override
	public void setNgayhethan(Date ngayhethan) {
		model.setNgayhethan(ngayhethan);
	}

	/**
	 * Sets the ngayxuatban of this demo db.
	 *
	 * @param ngayxuatban the ngayxuatban of this demo db
	 */
	@Override
	public void setNgayxuatban(Date ngayxuatban) {
		model.setNgayxuatban(ngayxuatban);
	}

	/**
	 * Sets the noi dung of this demo db.
	 *
	 * @param noiDung the noi dung of this demo db
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this demo db.
	 *
	 * @param primaryKey the primary key of this demo db
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this demo db.
	 *
	 * @param ten the ten of this demo db
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tinhtrang of this demo db.
	 *
	 * @param tinhtrang the tinhtrang of this demo db
	 */
	@Override
	public void setTinhtrang(int tinhtrang) {
		model.setTinhtrang(tinhtrang);
	}

	@Override
	protected DemoDBWrapper wrap(DemoDB demoDB) {
		return new DemoDBWrapper(demoDB);
	}

}