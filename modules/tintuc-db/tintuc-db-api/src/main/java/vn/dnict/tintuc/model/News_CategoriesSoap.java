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
public class News_CategoriesSoap implements Serializable {

	public static News_CategoriesSoap toSoapModel(News_Categories model) {
		News_CategoriesSoap soapModel = new News_CategoriesSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrders(model.getOrders());
		soapModel.setIdlibcat(model.getIdlibcat());
		soapModel.setDelete_status(model.getDelete_status());

		return soapModel;
	}

	public static News_CategoriesSoap[] toSoapModels(News_Categories[] models) {
		News_CategoriesSoap[] soapModels =
			new News_CategoriesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_CategoriesSoap[][] toSoapModels(
		News_Categories[][] models) {

		News_CategoriesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new News_CategoriesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_CategoriesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_CategoriesSoap[] toSoapModels(
		List<News_Categories> models) {

		List<News_CategoriesSoap> soapModels =
			new ArrayList<News_CategoriesSoap>(models.size());

		for (News_Categories model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new News_CategoriesSoap[soapModels.size()]);
	}

	public News_CategoriesSoap() {
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

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
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

	public long getIdlibcat() {
		return _idlibcat;
	}

	public void setIdlibcat(long idlibcat) {
		_idlibcat = idlibcat;
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
	private String _name;
	private String _language;
	private int _status;
	private int _orders;
	private long _idlibcat;
	private int _delete_status;

}