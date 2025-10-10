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
 * This class is used by SOAP remote services, specifically {@link vn.dnict.vanbanphapquy.service.http.LinhvucvanbanServiceSoap}.
 *
 * @author BinhNT
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LinhvucvanbanSoap implements Serializable {

	public static LinhvucvanbanSoap toSoapModel(Linhvucvanban model) {
		LinhvucvanbanSoap soapModel = new LinhvucvanbanSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static LinhvucvanbanSoap[] toSoapModels(Linhvucvanban[] models) {
		LinhvucvanbanSoap[] soapModels = new LinhvucvanbanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinhvucvanbanSoap[][] toSoapModels(Linhvucvanban[][] models) {
		LinhvucvanbanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinhvucvanbanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinhvucvanbanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinhvucvanbanSoap[] toSoapModels(List<Linhvucvanban> models) {
		List<LinhvucvanbanSoap> soapModels = new ArrayList<LinhvucvanbanSoap>(
			models.size());

		for (Linhvucvanban model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinhvucvanbanSoap[soapModels.size()]);
	}

	public LinhvucvanbanSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
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
	private String _name;
	private String _code;
	private int _status;

}