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

package vn.dnict.tintuc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class News_BinhLuanSoap implements Serializable {

	public static News_BinhLuanSoap toSoapModel(News_BinhLuan model) {
		News_BinhLuanSoap soapModel = new News_BinhLuanSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNewarticleId(model.getNewarticleId());
		soapModel.setHoTen(model.getHoTen());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setNgayBinhLuan(model.getNgayBinhLuan());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrders(model.getOrders());
		soapModel.setDelete_status(model.getDelete_status());

		return soapModel;
	}

	public static News_BinhLuanSoap[] toSoapModels(News_BinhLuan[] models) {
		News_BinhLuanSoap[] soapModels = new News_BinhLuanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_BinhLuanSoap[][] toSoapModels(News_BinhLuan[][] models) {
		News_BinhLuanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new News_BinhLuanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_BinhLuanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_BinhLuanSoap[] toSoapModels(List<News_BinhLuan> models) {
		List<News_BinhLuanSoap> soapModels = new ArrayList<News_BinhLuanSoap>(
			models.size());

		for (News_BinhLuan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new News_BinhLuanSoap[soapModels.size()]);
	}

	public News_BinhLuanSoap() {
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

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getNewarticleId() {
		return _newarticleId;
	}

	public void setNewarticleId(long newarticleId) {
		_newarticleId = newarticleId;
	}

	public String getHoTen() {
		return _hoTen;
	}

	public void setHoTen(String hoTen) {
		_hoTen = hoTen;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public Date getNgayBinhLuan() {
		return _ngayBinhLuan;
	}

	public void setNgayBinhLuan(Date ngayBinhLuan) {
		_ngayBinhLuan = ngayBinhLuan;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getOrders() {
		return _orders;
	}

	public void setOrders(int orders) {
		_orders = orders;
	}

	public int getDelete_status() {
		return _delete_status;
	}

	public void setDelete_status(int delete_status) {
		_delete_status = delete_status;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _newarticleId;
	private String _hoTen;
	private String _noiDung;
	private Date _ngayBinhLuan;
	private int _status;
	private int _orders;
	private int _delete_status;

}