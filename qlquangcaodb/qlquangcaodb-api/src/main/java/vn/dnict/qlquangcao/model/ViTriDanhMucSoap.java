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
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlquangcao.service.http.ViTriDanhMucServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ViTriDanhMucSoap implements Serializable {

	public static ViTriDanhMucSoap toSoapModel(ViTriDanhMuc model) {
		ViTriDanhMucSoap soapModel = new ViTriDanhMucSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setNguoitao(model.getNguoitao());
		soapModel.setTen(model.getTen());
		soapModel.setCssClass(model.getCssClass());
		soapModel.setKichthuoc(model.getKichthuoc());
		soapModel.setNgaytao(model.getNgaytao());
		soapModel.setDaxoa(model.getDaxoa());
		soapModel.setTrangthai(model.getTrangthai());
		soapModel.setNgaysua(model.getNgaysua());

		return soapModel;
	}

	public static ViTriDanhMucSoap[] toSoapModels(ViTriDanhMuc[] models) {
		ViTriDanhMucSoap[] soapModels = new ViTriDanhMucSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ViTriDanhMucSoap[][] toSoapModels(ViTriDanhMuc[][] models) {
		ViTriDanhMucSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ViTriDanhMucSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ViTriDanhMucSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ViTriDanhMucSoap[] toSoapModels(List<ViTriDanhMuc> models) {
		List<ViTriDanhMucSoap> soapModels = new ArrayList<ViTriDanhMucSoap>(
			models.size());

		for (ViTriDanhMuc model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ViTriDanhMucSoap[soapModels.size()]);
	}

	public ViTriDanhMucSoap() {
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

	public String getCssClass() {
		return _cssClass;
	}

	public void setCssClass(String cssClass) {
		_cssClass = cssClass;
	}

	public String getKichthuoc() {
		return _kichthuoc;
	}

	public void setKichthuoc(String kichthuoc) {
		_kichthuoc = kichthuoc;
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
	private String _cssClass;
	private String _kichthuoc;
	private Date _ngaytao;
	private int _daxoa;
	private int _trangthai;
	private Date _ngaysua;

}