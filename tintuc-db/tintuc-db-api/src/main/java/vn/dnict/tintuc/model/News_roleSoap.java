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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class News_roleSoap implements Serializable {

	public static News_roleSoap toSoapModel(News_role model) {
		News_roleSoap soapModel = new News_roleSoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setId(model.getId());
		soapModel.setUserid(model.getUserid());
		soapModel.setRole_add(model.getRole_add());
		soapModel.setRole_edit(model.getRole_edit());
		soapModel.setRole_public(model.getRole_public());
		soapModel.setCategory_active_role(model.getCategory_active_role());

		return soapModel;
	}

	public static News_roleSoap[] toSoapModels(News_role[] models) {
		News_roleSoap[] soapModels = new News_roleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_roleSoap[][] toSoapModels(News_role[][] models) {
		News_roleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new News_roleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_roleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_roleSoap[] toSoapModels(List<News_role> models) {
		List<News_roleSoap> soapModels = new ArrayList<News_roleSoap>(
			models.size());

		for (News_role model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new News_roleSoap[soapModels.size()]);
	}

	public News_roleSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
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

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getUserid() {
		return _userid;
	}

	public void setUserid(long userid) {
		_userid = userid;
	}

	public int getRole_add() {
		return _role_add;
	}

	public void setRole_add(int role_add) {
		_role_add = role_add;
	}

	public int getRole_edit() {
		return _role_edit;
	}

	public void setRole_edit(int role_edit) {
		_role_edit = role_edit;
	}

	public int getRole_public() {
		return _role_public;
	}

	public void setRole_public(int role_public) {
		_role_public = role_public;
	}

	public String getCategory_active_role() {
		return _category_active_role;
	}

	public void setCategory_active_role(String category_active_role) {
		_category_active_role = category_active_role;
	}

	private long _companyId;
	private long _groupId;
	private long _id;
	private long _userid;
	private int _role_add;
	private int _role_edit;
	private int _role_public;
	private String _category_active_role;

}