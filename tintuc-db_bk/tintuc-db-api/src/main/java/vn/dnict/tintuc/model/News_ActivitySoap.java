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
public class News_ActivitySoap implements Serializable {

	public static News_ActivitySoap toSoapModel(News_Activity model) {
		News_ActivitySoap soapModel = new News_ActivitySoap();

		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setId(model.getId());
		soapModel.setArticleid(model.getArticleid());
		soapModel.setStartuserid(model.getStartuserid());
		soapModel.setEnduserid(model.getEnduserid());
		soapModel.setContentrequest(model.getContentrequest());
		soapModel.setStatusofarticle(model.getStatusofarticle());

		return soapModel;
	}

	public static News_ActivitySoap[] toSoapModels(News_Activity[] models) {
		News_ActivitySoap[] soapModels = new News_ActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_ActivitySoap[][] toSoapModels(News_Activity[][] models) {
		News_ActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new News_ActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_ActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_ActivitySoap[] toSoapModels(List<News_Activity> models) {
		List<News_ActivitySoap> soapModels = new ArrayList<News_ActivitySoap>(
			models.size());

		for (News_Activity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new News_ActivitySoap[soapModels.size()]);
	}

	public News_ActivitySoap() {
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

	public long getArticleid() {
		return _articleid;
	}

	public void setArticleid(long articleid) {
		_articleid = articleid;
	}

	public long getStartuserid() {
		return _startuserid;
	}

	public void setStartuserid(long startuserid) {
		_startuserid = startuserid;
	}

	public long getEnduserid() {
		return _enduserid;
	}

	public void setEnduserid(long enduserid) {
		_enduserid = enduserid;
	}

	public String getContentrequest() {
		return _contentrequest;
	}

	public void setContentrequest(String contentrequest) {
		_contentrequest = contentrequest;
	}

	public int getStatusofarticle() {
		return _statusofarticle;
	}

	public void setStatusofarticle(int statusofarticle) {
		_statusofarticle = statusofarticle;
	}

	private long _companyId;
	private long _groupId;
	private long _id;
	private long _articleid;
	private long _startuserid;
	private long _enduserid;
	private String _contentrequest;
	private int _statusofarticle;

}