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
public class AnPham_DinhKemFileSoap implements Serializable {

	public static AnPham_DinhKemFileSoap toSoapModel(AnPham_DinhKemFile model) {
		AnPham_DinhKemFileSoap soapModel = new AnPham_DinhKemFileSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTen(model.getTen());
		soapModel.setUrl(model.getUrl());
		soapModel.setObject(model.getObject());
		soapModel.setObjectId(model.getObjectId());
		soapModel.setLuotTai(model.getLuotTai());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setDelete_status(model.getDelete_status());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static AnPham_DinhKemFileSoap[] toSoapModels(
		AnPham_DinhKemFile[] models) {

		AnPham_DinhKemFileSoap[] soapModels =
			new AnPham_DinhKemFileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnPham_DinhKemFileSoap[][] toSoapModels(
		AnPham_DinhKemFile[][] models) {

		AnPham_DinhKemFileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AnPham_DinhKemFileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnPham_DinhKemFileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnPham_DinhKemFileSoap[] toSoapModels(
		List<AnPham_DinhKemFile> models) {

		List<AnPham_DinhKemFileSoap> soapModels =
			new ArrayList<AnPham_DinhKemFileSoap>(models.size());

		for (AnPham_DinhKemFile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AnPham_DinhKemFileSoap[soapModels.size()]);
	}

	public AnPham_DinhKemFileSoap() {
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public long getObject() {
		return _Object;
	}

	public void setObject(long Object) {
		_Object = Object;
	}

	public long getObjectId() {
		return _ObjectId;
	}

	public void setObjectId(long ObjectId) {
		_ObjectId = ObjectId;
	}

	public long getLuotTai() {
		return _luotTai;
	}

	public void setLuotTai(long luotTai) {
		_luotTai = luotTai;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public int getDelete_status() {
		return _delete_status;
	}

	public void setDelete_status(int delete_status) {
		_delete_status = delete_status;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _ten;
	private String _url;
	private long _Object;
	private long _ObjectId;
	private long _luotTai;
	private String _ghiChu;
	private int _delete_status;
	private int _status;

}