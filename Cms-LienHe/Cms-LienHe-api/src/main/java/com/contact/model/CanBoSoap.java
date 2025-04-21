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
 * This class is used by SOAP remote services, specifically {@link com.contact.service.http.CanBoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class CanBoSoap implements Serializable {

	public static CanBoSoap toSoapModel(CanBo model) {
		CanBoSoap soapModel = new CanBoSoap();

		soapModel.setCanboId(model.getCanboId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTen(model.getTen());
		soapModel.setChucVu(model.getChucVu());
		soapModel.setPhongban_id(model.getPhongban_id());
		soapModel.setSdt(model.getSdt());
		soapModel.setEmail(model.getEmail());
		soapModel.setTinhTrang(model.getTinhTrang());
		soapModel.setSapXep(model.getSapXep());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static CanBoSoap[] toSoapModels(CanBo[] models) {
		CanBoSoap[] soapModels = new CanBoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CanBoSoap[][] toSoapModels(CanBo[][] models) {
		CanBoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CanBoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CanBoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CanBoSoap[] toSoapModels(List<CanBo> models) {
		List<CanBoSoap> soapModels = new ArrayList<CanBoSoap>(models.size());

		for (CanBo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CanBoSoap[soapModels.size()]);
	}

	public CanBoSoap() {
	}

	public long getPrimaryKey() {
		return _canboId;
	}

	public void setPrimaryKey(long pk) {
		setCanboId(pk);
	}

	public long getCanboId() {
		return _canboId;
	}

	public void setCanboId(long canboId) {
		_canboId = canboId;
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

	public String getChucVu() {
		return _chucVu;
	}

	public void setChucVu(String chucVu) {
		_chucVu = chucVu;
	}

	public long getPhongban_id() {
		return _phongban_id;
	}

	public void setPhongban_id(long phongban_id) {
		_phongban_id = phongban_id;
	}

	public String getSdt() {
		return _sdt;
	}

	public void setSdt(String sdt) {
		_sdt = sdt;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
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

	private long _canboId;
	private long _companyId;
	private long _groupId;
	private String _ten;
	private String _chucVu;
	private long _phongban_id;
	private String _sdt;
	private String _email;
	private long _tinhTrang;
	private int _sapXep;
	private long _daXoa;
	private Date _ngayTao;
	private Date _ngaySua;

}