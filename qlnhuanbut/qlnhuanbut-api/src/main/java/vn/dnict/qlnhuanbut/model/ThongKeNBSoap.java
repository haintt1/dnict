/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlnhuanbut.service.http.ThongKeNBServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ThongKeNBSoap implements Serializable {

	public static ThongKeNBSoap toSoapModel(ThongKeNB model) {
		ThongKeNBSoap soapModel = new ThongKeNBSoap();

		soapModel.setId(model.getId());
		soapModel.setNguoixuly(model.getNguoixuly());
		soapModel.setNewarticleId(model.getNewarticleId());
		soapModel.setAnphamId(model.getAnphamId());
		soapModel.setHeso(model.getHeso());
		soapModel.setTongtien(model.getTongtien());
		soapModel.setStatus(model.getStatus());
		soapModel.setNgaytao(model.getNgaytao());
		soapModel.setNgaysua(model.getNgaysua());

		return soapModel;
	}

	public static ThongKeNBSoap[] toSoapModels(ThongKeNB[] models) {
		ThongKeNBSoap[] soapModels = new ThongKeNBSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ThongKeNBSoap[][] toSoapModels(ThongKeNB[][] models) {
		ThongKeNBSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ThongKeNBSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ThongKeNBSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ThongKeNBSoap[] toSoapModels(List<ThongKeNB> models) {
		List<ThongKeNBSoap> soapModels = new ArrayList<ThongKeNBSoap>(
			models.size());

		for (ThongKeNB model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ThongKeNBSoap[soapModels.size()]);
	}

	public ThongKeNBSoap() {
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

	public long getNguoixuly() {
		return _nguoixuly;
	}

	public void setNguoixuly(long nguoixuly) {
		_nguoixuly = nguoixuly;
	}

	public long getNewarticleId() {
		return _newarticleId;
	}

	public void setNewarticleId(long newarticleId) {
		_newarticleId = newarticleId;
	}

	public long getAnphamId() {
		return _anphamId;
	}

	public void setAnphamId(long anphamId) {
		_anphamId = anphamId;
	}

	public String getHeso() {
		return _heso;
	}

	public void setHeso(String heso) {
		_heso = heso;
	}

	public double getTongtien() {
		return _tongtien;
	}

	public void setTongtien(double tongtien) {
		_tongtien = tongtien;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public Date getNgaytao() {
		return _ngaytao;
	}

	public void setNgaytao(Date ngaytao) {
		_ngaytao = ngaytao;
	}

	public Date getNgaysua() {
		return _ngaysua;
	}

	public void setNgaysua(Date ngaysua) {
		_ngaysua = ngaysua;
	}

	private long _id;
	private long _nguoixuly;
	private long _newarticleId;
	private long _anphamId;
	private String _heso;
	private double _tongtien;
	private int _status;
	private Date _ngaytao;
	private Date _ngaysua;

}