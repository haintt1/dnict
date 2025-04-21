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
 * This class is a wrapper for {@link AnPham_CongTacVien}.
 * </p>
 *
 * @author dnict
 * @see AnPham_CongTacVien
 * @generated
 */
public class AnPham_CongTacVienWrapper
	extends BaseModelWrapper<AnPham_CongTacVien>
	implements AnPham_CongTacVien, ModelWrapper<AnPham_CongTacVien> {

	public AnPham_CongTacVienWrapper(AnPham_CongTacVien anPham_CongTacVien) {
		super(anPham_CongTacVien);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("hoTen", getHoTen());
		attributes.put("email", getEmail());
		attributes.put("thongTin", getThongTin());
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

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String hoTen = (String)attributes.get("hoTen");

		if (hoTen != null) {
			setHoTen(hoTen);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String thongTin = (String)attributes.get("thongTin");

		if (thongTin != null) {
			setThongTin(thongTin);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long orders = (Long)attributes.get("orders");

		if (orders != null) {
			setOrders(orders);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}
	}

	/**
	 * Returns the company ID of this an pham_ cong tac vien.
	 *
	 * @return the company ID of this an pham_ cong tac vien
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this an pham_ cong tac vien.
	 *
	 * @return the delete_status of this an pham_ cong tac vien
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the email of this an pham_ cong tac vien.
	 *
	 * @return the email of this an pham_ cong tac vien
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this an pham_ cong tac vien.
	 *
	 * @return the group ID of this an pham_ cong tac vien
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ho ten of this an pham_ cong tac vien.
	 *
	 * @return the ho ten of this an pham_ cong tac vien
	 */
	@Override
	public String getHoTen() {
		return model.getHoTen();
	}

	/**
	 * Returns the ID of this an pham_ cong tac vien.
	 *
	 * @return the ID of this an pham_ cong tac vien
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the orders of this an pham_ cong tac vien.
	 *
	 * @return the orders of this an pham_ cong tac vien
	 */
	@Override
	public long getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the primary key of this an pham_ cong tac vien.
	 *
	 * @return the primary key of this an pham_ cong tac vien
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this an pham_ cong tac vien.
	 *
	 * @return the status of this an pham_ cong tac vien
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the thong tin of this an pham_ cong tac vien.
	 *
	 * @return the thong tin of this an pham_ cong tac vien
	 */
	@Override
	public String getThongTin() {
		return model.getThongTin();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this an pham_ cong tac vien.
	 *
	 * @param companyId the company ID of this an pham_ cong tac vien
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this an pham_ cong tac vien.
	 *
	 * @param delete_status the delete_status of this an pham_ cong tac vien
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the email of this an pham_ cong tac vien.
	 *
	 * @param email the email of this an pham_ cong tac vien
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this an pham_ cong tac vien.
	 *
	 * @param groupId the group ID of this an pham_ cong tac vien
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ho ten of this an pham_ cong tac vien.
	 *
	 * @param hoTen the ho ten of this an pham_ cong tac vien
	 */
	@Override
	public void setHoTen(String hoTen) {
		model.setHoTen(hoTen);
	}

	/**
	 * Sets the ID of this an pham_ cong tac vien.
	 *
	 * @param id the ID of this an pham_ cong tac vien
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the orders of this an pham_ cong tac vien.
	 *
	 * @param orders the orders of this an pham_ cong tac vien
	 */
	@Override
	public void setOrders(long orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the primary key of this an pham_ cong tac vien.
	 *
	 * @param primaryKey the primary key of this an pham_ cong tac vien
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this an pham_ cong tac vien.
	 *
	 * @param status the status of this an pham_ cong tac vien
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the thong tin of this an pham_ cong tac vien.
	 *
	 * @param thongTin the thong tin of this an pham_ cong tac vien
	 */
	@Override
	public void setThongTin(String thongTin) {
		model.setThongTin(thongTin);
	}

	@Override
	protected AnPham_CongTacVienWrapper wrap(
		AnPham_CongTacVien anPham_CongTacVien) {

		return new AnPham_CongTacVienWrapper(anPham_CongTacVien);
	}

}