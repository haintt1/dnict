/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link cms.quanlyvideo.service.http.ChuDeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChuDeSoap implements Serializable {

	public static ChuDeSoap toSoapModel(ChuDe model) {
		ChuDeSoap soapModel = new ChuDeSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static ChuDeSoap[] toSoapModels(ChuDe[] models) {
		ChuDeSoap[] soapModels = new ChuDeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChuDeSoap[][] toSoapModels(ChuDe[][] models) {
		ChuDeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChuDeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChuDeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChuDeSoap[] toSoapModels(List<ChuDe> models) {
		List<ChuDeSoap> soapModels = new ArrayList<ChuDeSoap>(models.size());

		for (ChuDe model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChuDeSoap[soapModels.size()]);
	}

	public ChuDeSoap() {
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

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public long getTrangThai() {
		return _trangThai;
	}

	public void setTrangThai(long trangThai) {
		_trangThai = trangThai;
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

	private long _id;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _ten;
	private String _moTa;
	private long _trangThai;
	private long _daXoa;
	private Date _ngayTao;
	private Date _ngaySua;

}