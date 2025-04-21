/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlnhuanbut.service.http.DinhMucServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DinhMucSoap implements Serializable {

	public static DinhMucSoap toSoapModel(DinhMuc model) {
		DinhMucSoap soapModel = new DinhMucSoap();

		soapModel.setId(model.getId());
		soapModel.setLoaidinhmuc(model.getLoaidinhmuc());
		soapModel.setGia(model.getGia());

		return soapModel;
	}

	public static DinhMucSoap[] toSoapModels(DinhMuc[] models) {
		DinhMucSoap[] soapModels = new DinhMucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DinhMucSoap[][] toSoapModels(DinhMuc[][] models) {
		DinhMucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DinhMucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DinhMucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DinhMucSoap[] toSoapModels(List<DinhMuc> models) {
		List<DinhMucSoap> soapModels = new ArrayList<DinhMucSoap>(
			models.size());

		for (DinhMuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DinhMucSoap[soapModels.size()]);
	}

	public DinhMucSoap() {
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

	public int getLoaidinhmuc() {
		return _loaidinhmuc;
	}

	public void setLoaidinhmuc(int loaidinhmuc) {
		_loaidinhmuc = loaidinhmuc;
	}

	public String getGia() {
		return _gia;
	}

	public void setGia(String gia) {
		_gia = gia;
	}

	private long _id;
	private int _loaidinhmuc;
	private String _gia;

}