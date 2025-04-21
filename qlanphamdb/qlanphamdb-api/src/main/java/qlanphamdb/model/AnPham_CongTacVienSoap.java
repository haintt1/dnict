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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AnPham_CongTacVienSoap implements Serializable {

	public static AnPham_CongTacVienSoap toSoapModel(AnPham_CongTacVien model) {
		AnPham_CongTacVienSoap soapModel = new AnPham_CongTacVienSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setHoTen(model.getHoTen());
		soapModel.setEmail(model.getEmail());
		soapModel.setThongTin(model.getThongTin());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrders(model.getOrders());
		soapModel.setDelete_status(model.getDelete_status());

		return soapModel;
	}

	public static AnPham_CongTacVienSoap[] toSoapModels(
		AnPham_CongTacVien[] models) {

		AnPham_CongTacVienSoap[] soapModels =
			new AnPham_CongTacVienSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnPham_CongTacVienSoap[][] toSoapModels(
		AnPham_CongTacVien[][] models) {

		AnPham_CongTacVienSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AnPham_CongTacVienSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnPham_CongTacVienSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnPham_CongTacVienSoap[] toSoapModels(
		List<AnPham_CongTacVien> models) {

		List<AnPham_CongTacVienSoap> soapModels =
			new ArrayList<AnPham_CongTacVienSoap>(models.size());

		for (AnPham_CongTacVien model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AnPham_CongTacVienSoap[soapModels.size()]);
	}

	public AnPham_CongTacVienSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getHoTen() {
		return _hoTen;
	}

	public void setHoTen(String hoTen) {
		_hoTen = hoTen;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getThongTin() {
		return _thongTin;
	}

	public void setThongTin(String thongTin) {
		_thongTin = thongTin;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getOrders() {
		return _orders;
	}

	public void setOrders(long orders) {
		_orders = orders;
	}

	public int getDelete_status() {
		return _delete_status;
	}

	public void setDelete_status(int delete_status) {
		_delete_status = delete_status;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private String _hoTen;
	private String _email;
	private String _thongTin;
	private int _status;
	private long _orders;
	private int _delete_status;

}