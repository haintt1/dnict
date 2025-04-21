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
public class AnPham_LoaiSoap implements Serializable {

	public static AnPham_LoaiSoap toSoapModel(AnPham_Loai model) {
		AnPham_LoaiSoap soapModel = new AnPham_LoaiSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTen(model.getTen());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrders(model.getOrders());
		soapModel.setDelete_status(model.getDelete_status());

		return soapModel;
	}

	public static AnPham_LoaiSoap[] toSoapModels(AnPham_Loai[] models) {
		AnPham_LoaiSoap[] soapModels = new AnPham_LoaiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnPham_LoaiSoap[][] toSoapModels(AnPham_Loai[][] models) {
		AnPham_LoaiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AnPham_LoaiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnPham_LoaiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnPham_LoaiSoap[] toSoapModels(List<AnPham_Loai> models) {
		List<AnPham_LoaiSoap> soapModels = new ArrayList<AnPham_LoaiSoap>(
			models.size());

		for (AnPham_Loai model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnPham_LoaiSoap[soapModels.size()]);
	}

	public AnPham_LoaiSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
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
	private String _ten;
	private int _status;
	private long _orders;
	private int _delete_status;

}