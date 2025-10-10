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

package vn.dnict.vanbanphapquy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.vanbanphapquy.service.http.VanbanphapquyServiceSoap}.
 *
 * @author BinhNT
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class VanbanphapquySoap implements Serializable {

	public static VanbanphapquySoap toSoapModel(Vanbanphapquy model) {
		VanbanphapquySoap soapModel = new VanbanphapquySoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setSohieu(model.getSohieu());
		soapModel.setTrichyeu(model.getTrichyeu());
		soapModel.setNoidung(model.getNoidung());
		soapModel.setNgay_banhanh(model.getNgay_banhanh());
		soapModel.setNgay_hieuluc(model.getNgay_hieuluc());
		soapModel.setNgay_hethieuluc(model.getNgay_hethieuluc());
		soapModel.setNgay_xuatban(model.getNgay_xuatban());
		soapModel.setId_linhvuc(model.getId_linhvuc());
		soapModel.setId_loaivanban(model.getId_loaivanban());
		soapModel.setId_capbanhanh(model.getId_capbanhanh());
		soapModel.setId_coquanbanhanh(model.getId_coquanbanhanh());
		soapModel.setNguoiky(model.getNguoiky());
		soapModel.setStatus(model.getStatus());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static VanbanphapquySoap[] toSoapModels(Vanbanphapquy[] models) {
		VanbanphapquySoap[] soapModels = new VanbanphapquySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VanbanphapquySoap[][] toSoapModels(Vanbanphapquy[][] models) {
		VanbanphapquySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VanbanphapquySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VanbanphapquySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VanbanphapquySoap[] toSoapModels(List<Vanbanphapquy> models) {
		List<VanbanphapquySoap> soapModels = new ArrayList<VanbanphapquySoap>(
			models.size());

		for (Vanbanphapquy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VanbanphapquySoap[soapModels.size()]);
	}

	public VanbanphapquySoap() {
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

	public String getSohieu() {
		return _sohieu;
	}

	public void setSohieu(String sohieu) {
		_sohieu = sohieu;
	}

	public String getTrichyeu() {
		return _trichyeu;
	}

	public void setTrichyeu(String trichyeu) {
		_trichyeu = trichyeu;
	}

	public String getNoidung() {
		return _noidung;
	}

	public void setNoidung(String noidung) {
		_noidung = noidung;
	}

	public Date getNgay_banhanh() {
		return _ngay_banhanh;
	}

	public void setNgay_banhanh(Date ngay_banhanh) {
		_ngay_banhanh = ngay_banhanh;
	}

	public Date getNgay_hieuluc() {
		return _ngay_hieuluc;
	}

	public void setNgay_hieuluc(Date ngay_hieuluc) {
		_ngay_hieuluc = ngay_hieuluc;
	}

	public Date getNgay_hethieuluc() {
		return _ngay_hethieuluc;
	}

	public void setNgay_hethieuluc(Date ngay_hethieuluc) {
		_ngay_hethieuluc = ngay_hethieuluc;
	}

	public Date getNgay_xuatban() {
		return _ngay_xuatban;
	}

	public void setNgay_xuatban(Date ngay_xuatban) {
		_ngay_xuatban = ngay_xuatban;
	}

	public long getId_linhvuc() {
		return _id_linhvuc;
	}

	public void setId_linhvuc(long id_linhvuc) {
		_id_linhvuc = id_linhvuc;
	}

	public long getId_loaivanban() {
		return _id_loaivanban;
	}

	public void setId_loaivanban(long id_loaivanban) {
		_id_loaivanban = id_loaivanban;
	}

	public long getId_capbanhanh() {
		return _id_capbanhanh;
	}

	public void setId_capbanhanh(long id_capbanhanh) {
		_id_capbanhanh = id_capbanhanh;
	}

	public long getId_coquanbanhanh() {
		return _id_coquanbanhanh;
	}

	public void setId_coquanbanhanh(long id_coquanbanhanh) {
		_id_coquanbanhanh = id_coquanbanhanh;
	}

	public String getNguoiky() {
		return _nguoiky;
	}

	public void setNguoiky(String nguoiky) {
		_nguoiky = nguoiky;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private String _sohieu;
	private String _trichyeu;
	private String _noidung;
	private Date _ngay_banhanh;
	private Date _ngay_hieuluc;
	private Date _ngay_hethieuluc;
	private Date _ngay_xuatban;
	private long _id_linhvuc;
	private long _id_loaivanban;
	private long _id_capbanhanh;
	private long _id_coquanbanhanh;
	private String _nguoiky;
	private int _status;
	private String _type;

}