/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.contact.service.http.ToChucServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ToChucSoap implements Serializable {

	public static ToChucSoap toSoapModel(ToChuc model) {
		ToChucSoap soapModel = new ToChucSoap();

		soapModel.setTochucId(model.getTochucId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTinhTrang(model.getTinhTrang());
		soapModel.setSapXep(model.getSapXep());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static ToChucSoap[] toSoapModels(ToChuc[] models) {
		ToChucSoap[] soapModels = new ToChucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ToChucSoap[][] toSoapModels(ToChuc[][] models) {
		ToChucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ToChucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ToChucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ToChucSoap[] toSoapModels(List<ToChuc> models) {
		List<ToChucSoap> soapModels = new ArrayList<ToChucSoap>(models.size());

		for (ToChuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ToChucSoap[soapModels.size()]);
	}

	public ToChucSoap() {
	}

	public long getPrimaryKey() {
		return _tochucId;
	}

	public void setPrimaryKey(long pk) {
		setTochucId(pk);
	}

	public long getTochucId() {
		return _tochucId;
	}

	public void setTochucId(long tochucId) {
		_tochucId = tochucId;
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

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public long getTinhTrang() {
		return _tinhTrang;
	}

	public void setTinhTrang(long tinhTrang) {
		_tinhTrang = tinhTrang;
	}

	public int getSapXep() {
		return _sapXep;
	}

	public void setSapXep(int sapXep) {
		_sapXep = sapXep;
	}

	public long getDaXoa() {
		return _daXoa;
	}

	public void setDaXoa(long daXoa) {
		_daXoa = daXoa;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	private long _tochucId;
	private long _companyId;
	private long _groupId;
	private String _ten;
	private String _moTa;
	private long _tinhTrang;
	private int _sapXep;
	private long _daXoa;
	private Date _ngayTao;
	private Date _ngaySua;

}