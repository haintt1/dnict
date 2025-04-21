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
public class eMagazine_templateSoap implements Serializable {

	public static eMagazine_templateSoap toSoapModel(eMagazine_template model) {
		eMagazine_templateSoap soapModel = new eMagazine_templateSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTen(model.getTen());
		soapModel.setNoidung(model.getNoidung());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static eMagazine_templateSoap[] toSoapModels(
		eMagazine_template[] models) {

		eMagazine_templateSoap[] soapModels =
			new eMagazine_templateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static eMagazine_templateSoap[][] toSoapModels(
		eMagazine_template[][] models) {

		eMagazine_templateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new eMagazine_templateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new eMagazine_templateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static eMagazine_templateSoap[] toSoapModels(
		List<eMagazine_template> models) {

		List<eMagazine_templateSoap> soapModels =
			new ArrayList<eMagazine_templateSoap>(models.size());

		for (eMagazine_template model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new eMagazine_templateSoap[soapModels.size()]);
	}

	public eMagazine_templateSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getNoidung() {
		return _noidung;
	}

	public void setNoidung(String noidung) {
		_noidung = noidung;
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
	private String _ten;
	private String _noidung;
	private int _status;

}