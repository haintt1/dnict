/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class DemoDBSoap implements Serializable {

	public static DemoDBSoap toSoapModel(DemoDB model) {
		DemoDBSoap soapModel = new DemoDBSoap();

		soapModel.setId(model.getId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setNgayxuatban(model.getNgayxuatban());
		soapModel.setNgayhethan(model.getNgayhethan());
		soapModel.setTinhtrang(model.getTinhtrang());

		return soapModel;
	}

	public static DemoDBSoap[] toSoapModels(DemoDB[] models) {
		DemoDBSoap[] soapModels = new DemoDBSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DemoDBSoap[][] toSoapModels(DemoDB[][] models) {
		DemoDBSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DemoDBSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DemoDBSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DemoDBSoap[] toSoapModels(List<DemoDB> models) {
		List<DemoDBSoap> soapModels = new ArrayList<DemoDBSoap>(models.size());

		for (DemoDB model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DemoDBSoap[soapModels.size()]);
	}

	public DemoDBSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public Date getNgayxuatban() {
		return _ngayxuatban;
	}

	public void setNgayxuatban(Date ngayxuatban) {
		_ngayxuatban = ngayxuatban;
	}

	public Date getNgayhethan() {
		return _ngayhethan;
	}

	public void setNgayhethan(Date ngayhethan) {
		_ngayhethan = ngayhethan;
	}

	public int getTinhtrang() {
		return _tinhtrang;
	}

	public void setTinhtrang(int tinhtrang) {
		_tinhtrang = tinhtrang;
	}

	private long _id;
	private String _ten;
	private String _moTa;
	private String _noiDung;
	private Date _ngayxuatban;
	private Date _ngayhethan;
	private int _tinhtrang;

}