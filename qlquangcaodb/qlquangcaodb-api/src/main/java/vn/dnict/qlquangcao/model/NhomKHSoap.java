/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlquangcao.service.http.NhomKHServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class NhomKHSoap implements Serializable {

	public static NhomKHSoap toSoapModel(NhomKH model) {
		NhomKHSoap soapModel = new NhomKHSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNguoitao(model.getNguoitao());
		soapModel.setTen(model.getTen());
		soapModel.setNguoidaidien(model.getNguoidaidien());
		soapModel.setLogo(model.getLogo());
		soapModel.setMota(model.getMota());
		soapModel.setDiachi(model.getDiachi());
		soapModel.setSdt(model.getSdt());
		soapModel.setEmail(model.getEmail());
		soapModel.setNgaytao(model.getNgaytao());
		soapModel.setDaxoa(model.getDaxoa());
		soapModel.setTrangthai(model.getTrangthai());
		soapModel.setNgaysua(model.getNgaysua());

		return soapModel;
	}

	public static NhomKHSoap[] toSoapModels(NhomKH[] models) {
		NhomKHSoap[] soapModels = new NhomKHSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NhomKHSoap[][] toSoapModels(NhomKH[][] models) {
		NhomKHSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NhomKHSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NhomKHSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NhomKHSoap[] toSoapModels(List<NhomKH> models) {
		List<NhomKHSoap> soapModels = new ArrayList<NhomKHSoap>(models.size());

		for (NhomKH model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NhomKHSoap[soapModels.size()]);
	}

	public NhomKHSoap() {
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

	public long getNguoitao() {
		return _nguoitao;
	}

	public void setNguoitao(long nguoitao) {
		_nguoitao = nguoitao;
	}

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getNguoidaidien() {
		return _nguoidaidien;
	}

	public void setNguoidaidien(String nguoidaidien) {
		_nguoidaidien = nguoidaidien;
	}

	public String getLogo() {
		return _logo;
	}

	public void setLogo(String logo) {
		_logo = logo;
	}

	public String getMota() {
		return _mota;
	}

	public void setMota(String mota) {
		_mota = mota;
	}

	public String getDiachi() {
		return _diachi;
	}

	public void setDiachi(String diachi) {
		_diachi = diachi;
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

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public int getDaxoa() {
		return _daxoa;
	}

	public void setDaxoa(int daxoa) {
		_daxoa = daxoa;
	}

	public int getTrangthai() {
		return _trangthai;
	}

	public void setTrangthai(int trangthai) {
		_trangthai = trangthai;
	}

	public Date getNgaysua() {
		return _ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		_ngaysua = ngaysua;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _nguoitao;
	private String _ten;
	private String _nguoidaidien;
	private String _logo;
	private String _mota;
	private String _diachi;
	private String _sdt;
	private String _email;
	private Date _ngaytao;
	private int _daxoa;
	private int _trangthai;
	private Date _ngaysua;

}