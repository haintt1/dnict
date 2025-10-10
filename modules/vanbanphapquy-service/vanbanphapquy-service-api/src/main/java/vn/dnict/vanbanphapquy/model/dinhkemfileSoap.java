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

package vn.dnict.vanbanphapquy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.vanbanphapquy.service.http.dinhkemfileServiceSoap}.
 *
 * @author BinhNT
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class dinhkemfileSoap implements Serializable {

	public static dinhkemfileSoap toSoapModel(dinhkemfile model) {
		dinhkemfileSoap soapModel = new dinhkemfileSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTen(model.getTen());
		soapModel.setUrl(model.getUrl());
		soapModel.setObject(model.getObject());
		soapModel.setObjectId(model.getObjectId());
		soapModel.setGhichu(model.getGhichu());
		soapModel.setDaxoa(model.getDaxoa());
		soapModel.setTrangthai(model.getTrangthai());

		return soapModel;
	}

	public static dinhkemfileSoap[] toSoapModels(dinhkemfile[] models) {
		dinhkemfileSoap[] soapModels = new dinhkemfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static dinhkemfileSoap[][] toSoapModels(dinhkemfile[][] models) {
		dinhkemfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new dinhkemfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new dinhkemfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static dinhkemfileSoap[] toSoapModels(List<dinhkemfile> models) {
		List<dinhkemfileSoap> soapModels = new ArrayList<dinhkemfileSoap>(
			models.size());

		for (dinhkemfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new dinhkemfileSoap[soapModels.size()]);
	}

	public dinhkemfileSoap() {
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

	public String getGhichu() {
		return _ghichu;
	}

	public void setGhichu(String ghichu) {
		_ghichu = ghichu;
	}

	public int getDaxoa() {
		return _daxoa;
	}

	public void setDaxoa(int daxoa) {
		_daxoa = daxoa;
	}

	public int getTrangthai() {
		return _trangthai;
	}

	public void setTrangthai(int trangthai) {
		_trangthai = trangthai;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _ten;
	private String _url;
	private long _Object;
	private long _ObjectId;
	private String _ghichu;
	private int _daxoa;
	private int _trangthai;

}