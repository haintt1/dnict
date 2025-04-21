/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlnhuanbut.service.http.HeSoTheLoaiServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HeSoTheLoaiSoap implements Serializable {

	public static HeSoTheLoaiSoap toSoapModel(HeSoTheLoai model) {
		HeSoTheLoaiSoap soapModel = new HeSoTheLoaiSoap();

		soapModel.setId(model.getId());
		soapModel.setTypeId(model.getTypeId());
		soapModel.setMinheso(model.getMinheso());
		soapModel.setMaxheso(model.getMaxheso());

		return soapModel;
	}

	public static HeSoTheLoaiSoap[] toSoapModels(HeSoTheLoai[] models) {
		HeSoTheLoaiSoap[] soapModels = new HeSoTheLoaiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeSoTheLoaiSoap[][] toSoapModels(HeSoTheLoai[][] models) {
		HeSoTheLoaiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeSoTheLoaiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeSoTheLoaiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeSoTheLoaiSoap[] toSoapModels(List<HeSoTheLoai> models) {
		List<HeSoTheLoaiSoap> soapModels = new ArrayList<HeSoTheLoaiSoap>(
			models.size());

		for (HeSoTheLoai model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeSoTheLoaiSoap[soapModels.size()]);
	}

	public HeSoTheLoaiSoap() {
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

	public long getTypeId() {
		return _typeId;
	}

	public void setTypeId(long typeId) {
		_typeId = typeId;
	}

	public String getMinheso() {
		return _minheso;
	}

	public void setMinheso(String minheso) {
		_minheso = minheso;
	}

	public String getMaxheso() {
		return _maxheso;
	}

	public void setMaxheso(String maxheso) {
		_maxheso = maxheso;
	}

	private long _id;
	private long _typeId;
	private String _minheso;
	private String _maxheso;

}