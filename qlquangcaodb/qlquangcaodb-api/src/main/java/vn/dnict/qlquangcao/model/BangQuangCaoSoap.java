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
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlquangcao.service.http.BangQuangCaoServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BangQuangCaoSoap implements Serializable {

	public static BangQuangCaoSoap toSoapModel(BangQuangCao model) {
		BangQuangCaoSoap soapModel = new BangQuangCaoSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNguoitao(model.getNguoitao());
		soapModel.setTen(model.getTen());
		soapModel.setDuongdan(model.getDuongdan());
		soapModel.setLienket(model.getLienket());
		soapModel.setNhomKH(model.getNhomKH());
		soapModel.setVitriQC(model.getVitriQC());
		soapModel.setNgaytao(model.getNgaytao());
		soapModel.setNgayketthuc(model.getNgayketthuc());
		soapModel.setDaxoa(model.getDaxoa());
		soapModel.setTrangthai(model.getTrangthai());
		soapModel.setTrangthaisudung(model.getTrangthaisudung());
		soapModel.setNgaysua(model.getNgaysua());

		return soapModel;
	}

	public static BangQuangCaoSoap[] toSoapModels(BangQuangCao[] models) {
		BangQuangCaoSoap[] soapModels = new BangQuangCaoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BangQuangCaoSoap[][] toSoapModels(BangQuangCao[][] models) {
		BangQuangCaoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BangQuangCaoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BangQuangCaoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BangQuangCaoSoap[] toSoapModels(List<BangQuangCao> models) {
		List<BangQuangCaoSoap> soapModels = new ArrayList<BangQuangCaoSoap>(
			models.size());

		for (BangQuangCao model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BangQuangCaoSoap[soapModels.size()]);
	}

	public BangQuangCaoSoap() {
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

	public String getDuongdan() {
		return _duongdan;
	}

	public void setDuongdan(String duongdan) {
		_duongdan = duongdan;
	}

	public String getLienket() {
		return _lienket;
	}

	public void setLienket(String lienket) {
		_lienket = lienket;
	}

	public long getNhomKH() {
		return _nhomKH;
	}

	public void setNhomKH(long nhomKH) {
		_nhomKH = nhomKH;
	}

	public long getVitriQC() {
		return _vitriQC;
	}

	public void setVitriQC(long vitriQC) {
		_vitriQC = vitriQC;
	}

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public Date getNgayketthuc() {
		return _ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		_ngayketthuc = ngayketthuc;
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

	public int getTrangthaisudung() {
		return _trangthaisudung;
	}

	public void setTrangthaisudung(int trangthaisudung) {
		_trangthaisudung = trangthaisudung;
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
	private String _duongdan;
	private String _lienket;
	private long _nhomKH;
	private long _vitriQC;
	private Date _ngaytao;
	private Date _ngayketthuc;
	private int _daxoa;
	private int _trangthai;
	private int _trangthaisudung;
	private Date _ngaysua;

}