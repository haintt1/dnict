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
 * This class is used by SOAP remote services, specifically {@link com.contact.service.http.PhongBanServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PhongBanSoap implements Serializable {

	public static PhongBanSoap toSoapModel(PhongBan model) {
		PhongBanSoap soapModel = new PhongBanSoap();

		soapModel.setPhongbanId(model.getPhongbanId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTochuc_id(model.getTochuc_id());
		soapModel.setTinhTrang(model.getTinhTrang());
		soapModel.setSapXep(model.getSapXep());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static PhongBanSoap[] toSoapModels(PhongBan[] models) {
		PhongBanSoap[] soapModels = new PhongBanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PhongBanSoap[][] toSoapModels(PhongBan[][] models) {
		PhongBanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PhongBanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PhongBanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PhongBanSoap[] toSoapModels(List<PhongBan> models) {
		List<PhongBanSoap> soapModels = new ArrayList<PhongBanSoap>(
			models.size());

		for (PhongBan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PhongBanSoap[soapModels.size()]);
	}

	public PhongBanSoap() {
	}

	public long getPrimaryKey() {
		return _phongbanId;
	}

	public void setPrimaryKey(long pk) {
		setPhongbanId(pk);
	}

	public long getPhongbanId() {
		return _phongbanId;
	}

	public void setPhongbanId(long phongbanId) {
		_phongbanId = phongbanId;
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

	public long getTochuc_id() {
		return _tochuc_id;
	}

	public void setTochuc_id(long tochuc_id) {
		_tochuc_id = tochuc_id;
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

	private long _phongbanId;
	private long _companyId;
	private long _groupId;
	private String _ten;
	private String _moTa;
	private long _tochuc_id;
	private long _tinhTrang;
	private int _sapXep;
	private long _daXoa;
	private Date _ngayTao;
	private Date _ngaySua;

}