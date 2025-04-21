/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlgopy.service.http.emailTemplateServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class emailTemplateSoap implements Serializable {

	public static emailTemplateSoap toSoapModel(emailTemplate model) {
		emailTemplateSoap soapModel = new emailTemplateSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTen(model.getTen());
		soapModel.setNoidung(model.getNoidung());
		soapModel.setLoai(model.getLoai());

		return soapModel;
	}

	public static emailTemplateSoap[] toSoapModels(emailTemplate[] models) {
		emailTemplateSoap[] soapModels = new emailTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static emailTemplateSoap[][] toSoapModels(emailTemplate[][] models) {
		emailTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new emailTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new emailTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static emailTemplateSoap[] toSoapModels(List<emailTemplate> models) {
		List<emailTemplateSoap> soapModels = new ArrayList<emailTemplateSoap>(
			models.size());

		for (emailTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new emailTemplateSoap[soapModels.size()]);
	}

	public emailTemplateSoap() {
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

	public int getLoai() {
		return _loai;
	}

	public void setLoai(int loai) {
		_loai = loai;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private String _ten;
	private String _noidung;
	private int _loai;

}