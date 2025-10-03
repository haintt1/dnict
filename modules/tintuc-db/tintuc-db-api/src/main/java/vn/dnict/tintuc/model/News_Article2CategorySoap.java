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
public class News_Article2CategorySoap implements Serializable {

	public static News_Article2CategorySoap toSoapModel(
		News_Article2Category model) {

		News_Article2CategorySoap soapModel = new News_Article2CategorySoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNewcategoryId(model.getNewcategoryId());
		soapModel.setNewarticleId(model.getNewarticleId());

		return soapModel;
	}

	public static News_Article2CategorySoap[] toSoapModels(
		News_Article2Category[] models) {

		News_Article2CategorySoap[] soapModels =
			new News_Article2CategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_Article2CategorySoap[][] toSoapModels(
		News_Article2Category[][] models) {

		News_Article2CategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new News_Article2CategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_Article2CategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_Article2CategorySoap[] toSoapModels(
		List<News_Article2Category> models) {

		List<News_Article2CategorySoap> soapModels =
			new ArrayList<News_Article2CategorySoap>(models.size());

		for (News_Article2Category model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new News_Article2CategorySoap[soapModels.size()]);
	}

	public News_Article2CategorySoap() {
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

	public long getNewcategoryId() {
		return _newcategoryId;
	}

	public void setNewcategoryId(long newcategoryId) {
		_newcategoryId = newcategoryId;
	}

	public long getNewarticleId() {
		return _newarticleId;
	}

	public void setNewarticleId(long newarticleId) {
		_newarticleId = newarticleId;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _newcategoryId;
	private long _newarticleId;

}