/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlnhuanbut.service.http.HeSoLoaiAPServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HeSoLoaiAPSoap implements Serializable {

	public static HeSoLoaiAPSoap toSoapModel(HeSoLoaiAP model) {
		HeSoLoaiAPSoap soapModel = new HeSoLoaiAPSoap();

		soapModel.setId(model.getId());
		soapModel.setLoaiId(model.getLoaiId());
		soapModel.setMinheso(model.getMinheso());
		soapModel.setMaxheso(model.getMaxheso());

		return soapModel;
	}

	public static HeSoLoaiAPSoap[] toSoapModels(HeSoLoaiAP[] models) {
		HeSoLoaiAPSoap[] soapModels = new HeSoLoaiAPSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeSoLoaiAPSoap[][] toSoapModels(HeSoLoaiAP[][] models) {
		HeSoLoaiAPSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeSoLoaiAPSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeSoLoaiAPSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeSoLoaiAPSoap[] toSoapModels(List<HeSoLoaiAP> models) {
		List<HeSoLoaiAPSoap> soapModels = new ArrayList<HeSoLoaiAPSoap>(
			models.size());

		for (HeSoLoaiAP model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeSoLoaiAPSoap[soapModels.size()]);
	}

	public HeSoLoaiAPSoap() {
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

	public long getLoaiId() {
		return _loaiId;
	}

	public void setLoaiId(long loaiId) {
		_loaiId = loaiId;
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
	private long _loaiId;
	private String _minheso;
	private String _maxheso;

}