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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link eMagazine_BinhLuan}.
 * </p>
 *
 * @author dnict
 * @see eMagazine_BinhLuan
 * @generated
 */
public class eMagazine_BinhLuanWrapper
	extends BaseModelWrapper<eMagazine_BinhLuan>
	implements eMagazine_BinhLuan, ModelWrapper<eMagazine_BinhLuan> {

	public eMagazine_BinhLuanWrapper(eMagazine_BinhLuan eMagazine_BinhLuan) {
		super(eMagazine_BinhLuan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("magazineId", getMagazineId());
		attributes.put("hoTen", getHoTen());
		attributes.put("noiDung", getNoiDung());
		attributes.put("ngayBinhLuan", getNgayBinhLuan());
		attributes.put("status", getStatus());
		attributes.put("orders", getOrders());
		attributes.put("delete_status", getDelete_status());

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

		Long magazineId = (Long)attributes.get("magazineId");

		if (magazineId != null) {
			setMagazineId(magazineId);
		}

		String hoTen = (String)attributes.get("hoTen");

		if (hoTen != null) {
			setHoTen(hoTen);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		Date ngayBinhLuan = (Date)attributes.get("ngayBinhLuan");

		if (ngayBinhLuan != null) {
			setNgayBinhLuan(ngayBinhLuan);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer orders = (Integer)attributes.get("orders");

		if (orders != null) {
			setOrders(orders);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}
	}

	/**
	 * Returns the company ID of this e magazine_ binh luan.
	 *
	 * @return the company ID of this e magazine_ binh luan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this e magazine_ binh luan.
	 *
	 * @return the delete_status of this e magazine_ binh luan
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this e magazine_ binh luan.
	 *
	 * @return the group ID of this e magazine_ binh luan
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ho ten of this e magazine_ binh luan.
	 *
	 * @return the ho ten of this e magazine_ binh luan
	 */
	@Override
	public String getHoTen() {
		return model.getHoTen();
	}

	/**
	 * Returns the ID of this e magazine_ binh luan.
	 *
	 * @return the ID of this e magazine_ binh luan
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the magazine ID of this e magazine_ binh luan.
	 *
	 * @return the magazine ID of this e magazine_ binh luan
	 */
	@Override
	public long getMagazineId() {
		return model.getMagazineId();
	}

	/**
	 * Returns the ngay binh luan of this e magazine_ binh luan.
	 *
	 * @return the ngay binh luan of this e magazine_ binh luan
	 */
	@Override
	public Date getNgayBinhLuan() {
		return model.getNgayBinhLuan();
	}

	/**
	 * Returns the noi dung of this e magazine_ binh luan.
	 *
	 * @return the noi dung of this e magazine_ binh luan
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the orders of this e magazine_ binh luan.
	 *
	 * @return the orders of this e magazine_ binh luan
	 */
	@Override
	public int getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the primary key of this e magazine_ binh luan.
	 *
	 * @return the primary key of this e magazine_ binh luan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this e magazine_ binh luan.
	 *
	 * @return the status of this e magazine_ binh luan
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
	 * Sets the company ID of this e magazine_ binh luan.
	 *
	 * @param companyId the company ID of this e magazine_ binh luan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this e magazine_ binh luan.
	 *
	 * @param delete_status the delete_status of this e magazine_ binh luan
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this e magazine_ binh luan.
	 *
	 * @param groupId the group ID of this e magazine_ binh luan
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ho ten of this e magazine_ binh luan.
	 *
	 * @param hoTen the ho ten of this e magazine_ binh luan
	 */
	@Override
	public void setHoTen(String hoTen) {
		model.setHoTen(hoTen);
	}

	/**
	 * Sets the ID of this e magazine_ binh luan.
	 *
	 * @param id the ID of this e magazine_ binh luan
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the magazine ID of this e magazine_ binh luan.
	 *
	 * @param magazineId the magazine ID of this e magazine_ binh luan
	 */
	@Override
	public void setMagazineId(long magazineId) {
		model.setMagazineId(magazineId);
	}

	/**
	 * Sets the ngay binh luan of this e magazine_ binh luan.
	 *
	 * @param ngayBinhLuan the ngay binh luan of this e magazine_ binh luan
	 */
	@Override
	public void setNgayBinhLuan(Date ngayBinhLuan) {
		model.setNgayBinhLuan(ngayBinhLuan);
	}

	/**
	 * Sets the noi dung of this e magazine_ binh luan.
	 *
	 * @param noiDung the noi dung of this e magazine_ binh luan
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the orders of this e magazine_ binh luan.
	 *
	 * @param orders the orders of this e magazine_ binh luan
	 */
	@Override
	public void setOrders(int orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the primary key of this e magazine_ binh luan.
	 *
	 * @param primaryKey the primary key of this e magazine_ binh luan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this e magazine_ binh luan.
	 *
	 * @param status the status of this e magazine_ binh luan
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected eMagazine_BinhLuanWrapper wrap(
		eMagazine_BinhLuan eMagazine_BinhLuan) {

		return new eMagazine_BinhLuanWrapper(eMagazine_BinhLuan);
	}

}