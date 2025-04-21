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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AnPham_PhanCongSoap implements Serializable {

	public static AnPham_PhanCongSoap toSoapModel(AnPham_PhanCong model) {
		AnPham_PhanCongSoap soapModel = new AnPham_PhanCongSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setLoaiId(model.getLoaiId());
		soapModel.setDeCuongId(model.getDeCuongId());
		soapModel.setCtvId(model.getCtvId());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setGhiChu(model.getGhiChu());
		soapModel.setNgaybatdau(model.getNgaybatdau());
		soapModel.setNgayketthuc(model.getNgayketthuc());
		soapModel.setStatus(model.getStatus());
		soapModel.setIs_gui(model.getIs_gui());

		return soapModel;
	}

	public static AnPham_PhanCongSoap[] toSoapModels(AnPham_PhanCong[] models) {
		AnPham_PhanCongSoap[] soapModels =
			new AnPham_PhanCongSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AnPham_PhanCongSoap[][] toSoapModels(
		AnPham_PhanCong[][] models) {

		AnPham_PhanCongSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AnPham_PhanCongSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AnPham_PhanCongSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AnPham_PhanCongSoap[] toSoapModels(
		List<AnPham_PhanCong> models) {

		List<AnPham_PhanCongSoap> soapModels =
			new ArrayList<AnPham_PhanCongSoap>(models.size());

		for (AnPham_PhanCong model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AnPham_PhanCongSoap[soapModels.size()]);
	}

	public AnPham_PhanCongSoap() {
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

	public long getLoaiId() {
		return _loaiId;
	}

	public void setLoaiId(long loaiId) {
		_loaiId = loaiId;
	}

	public long getDeCuongId() {
		return _deCuongId;
	}

	public void setDeCuongId(long deCuongId) {
		_deCuongId = deCuongId;
	}

	public long getCtvId() {
		return _ctvId;
	}

	public void setCtvId(long ctvId) {
		_ctvId = ctvId;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public String getGhiChu() {
		return _ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		_ghiChu = ghiChu;
	}

	public Date getNgaybatdau() {
		return _ngaybatdau;
	}

	public void setNgaybatdau(Date ngaybatdau) {
		_ngaybatdau = ngaybatdau;
	}

	public Date getNgayketthuc() {
		return _ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		_ngayketthuc = ngayketthuc;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getIs_gui() {
		return _is_gui;
	}

	public void setIs_gui(int is_gui) {
		_is_gui = is_gui;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _loaiId;
	private long _deCuongId;
	private long _ctvId;
	private String _noiDung;
	private String _ghiChu;
	private Date _ngaybatdau;
	private Date _ngayketthuc;
	private int _status;
	private int _is_gui;

}