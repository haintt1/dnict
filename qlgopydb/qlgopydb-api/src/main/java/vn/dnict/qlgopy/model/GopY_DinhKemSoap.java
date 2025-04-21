/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlgopy.service.http.GopY_DinhKemServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class GopY_DinhKemSoap implements Serializable {

	public static GopY_DinhKemSoap toSoapModel(GopY_DinhKem model) {
		GopY_DinhKemSoap soapModel = new GopY_DinhKemSoap();

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
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static GopY_DinhKemSoap[] toSoapModels(GopY_DinhKem[] models) {
		GopY_DinhKemSoap[] soapModels = new GopY_DinhKemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GopY_DinhKemSoap[][] toSoapModels(GopY_DinhKem[][] models) {
		GopY_DinhKemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GopY_DinhKemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GopY_DinhKemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GopY_DinhKemSoap[] toSoapModels(List<GopY_DinhKem> models) {
		List<GopY_DinhKemSoap> soapModels = new ArrayList<GopY_DinhKemSoap>(
			models.size());

		for (GopY_DinhKem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GopY_DinhKemSoap[soapModels.size()]);
	}

	public GopY_DinhKemSoap() {
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
	private String _ghichu;
	private int _daxoa;
	private int _status;

}