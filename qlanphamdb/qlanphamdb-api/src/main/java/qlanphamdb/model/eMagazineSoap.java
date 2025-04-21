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
public class eMagazineSoap implements Serializable {

	public static eMagazineSoap toSoapModel(eMagazine model) {
		eMagazineSoap soapModel = new eMagazineSoap();

		soapModel.setId(model.getId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setTen(model.getTen());
		soapModel.setSlug(model.getSlug());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setAnhDaiDien(model.getAnhDaiDien());
		soapModel.setMauChuDao(model.getMauChuDao());
		soapModel.setHinhNen(model.getHinhNen());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setTuKhoa(model.getTuKhoa());
		soapModel.setPhienBan(model.getPhienBan());
		soapModel.setLuotXem(model.getLuotXem());
		soapModel.setNguoiTao(model.getNguoiTao());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNguoiSua(model.getNguoiSua());
		soapModel.setNgaySua(model.getNgaySua());
		soapModel.setNguoiNhan(model.getNguoiNhan());
		soapModel.setNguoiXuLy(model.getNguoiXuLy());
		soapModel.setNgayXuLy(model.getNgayXuLy());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setIsFormHienBinhLuan(model.getIsFormHienBinhLuan());
		soapModel.setIsFormViewBinhLuan(model.getIsFormViewBinhLuan());
		soapModel.setStatus(model.getStatus());
		soapModel.setOrders(model.getOrders());
		soapModel.setDelete_status(model.getDelete_status());

		return soapModel;
	}

	public static eMagazineSoap[] toSoapModels(eMagazine[] models) {
		eMagazineSoap[] soapModels = new eMagazineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static eMagazineSoap[][] toSoapModels(eMagazine[][] models) {
		eMagazineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new eMagazineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new eMagazineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static eMagazineSoap[] toSoapModels(List<eMagazine> models) {
		List<eMagazineSoap> soapModels = new ArrayList<eMagazineSoap>(
			models.size());

		for (eMagazine model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new eMagazineSoap[soapModels.size()]);
	}

	public eMagazineSoap() {
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

	public String getTen() {
		return _ten;
	}

	public void setTen(String ten) {
		_ten = ten;
	}

	public String getSlug() {
		return _slug;
	}

	public void setSlug(String slug) {
		_slug = slug;
	}

	public String getMoTa() {
		return _moTa;
	}

	public void setMoTa(String moTa) {
		_moTa = moTa;
	}

	public String getAnhDaiDien() {
		return _anhDaiDien;
	}

	public void setAnhDaiDien(String anhDaiDien) {
		_anhDaiDien = anhDaiDien;
	}

	public String getMauChuDao() {
		return _mauChuDao;
	}

	public void setMauChuDao(String mauChuDao) {
		_mauChuDao = mauChuDao;
	}

	public String getHinhNen() {
		return _hinhNen;
	}

	public void setHinhNen(String hinhNen) {
		_hinhNen = hinhNen;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public String getTuKhoa() {
		return _tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		_tuKhoa = tuKhoa;
	}

	public long getPhienBan() {
		return _phienBan;
	}

	public void setPhienBan(long phienBan) {
		_phienBan = phienBan;
	}

	public long getLuotXem() {
		return _luotXem;
	}

	public void setLuotXem(long luotXem) {
		_luotXem = luotXem;
	}

	public long getNguoiTao() {
		return _nguoiTao;
	}

	public void setNguoiTao(long nguoiTao) {
		_nguoiTao = nguoiTao;
	}

	public Date getNgayTao() {
		return _ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		_ngayTao = ngayTao;
	}

	public long getNguoiSua() {
		return _nguoiSua;
	}

	public void setNguoiSua(long nguoiSua) {
		_nguoiSua = nguoiSua;
	}

	public Date getNgaySua() {
		return _ngaySua;
	}

	public void setNgaySua(Date ngaySua) {
		_ngaySua = ngaySua;
	}

	public long getNguoiNhan() {
		return _nguoiNhan;
	}

	public void setNguoiNhan(long nguoiNhan) {
		_nguoiNhan = nguoiNhan;
	}

	public long getNguoiXuLy() {
		return _nguoiXuLy;
	}

	public void setNguoiXuLy(long nguoiXuLy) {
		_nguoiXuLy = nguoiXuLy;
	}

	public Date getNgayXuLy() {
		return _ngayXuLy;
	}

	public void setNgayXuLy(Date ngayXuLy) {
		_ngayXuLy = ngayXuLy;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public int getIsFormHienBinhLuan() {
		return _isFormHienBinhLuan;
	}

	public void setIsFormHienBinhLuan(int isFormHienBinhLuan) {
		_isFormHienBinhLuan = isFormHienBinhLuan;
	}

	public int getIsFormViewBinhLuan() {
		return _isFormViewBinhLuan;
	}

	public void setIsFormViewBinhLuan(int isFormViewBinhLuan) {
		_isFormViewBinhLuan = isFormViewBinhLuan;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getOrders() {
		return _orders;
	}

	public void setOrders(long orders) {
		_orders = orders;
	}

	public int getDelete_status() {
		return _delete_status;
	}

	public void setDelete_status(int delete_status) {
		_delete_status = delete_status;
	}

	private long _id;
	private long _groupId;
	private long _companyId;
	private String _ten;
	private String _slug;
	private String _moTa;
	private String _anhDaiDien;
	private String _mauChuDao;
	private String _hinhNen;
	private long _templateId;
	private String _noiDung;
	private String _tuKhoa;
	private long _phienBan;
	private long _luotXem;
	private long _nguoiTao;
	private Date _ngayTao;
	private long _nguoiSua;
	private Date _ngaySua;
	private long _nguoiNhan;
	private long _nguoiXuLy;
	private Date _ngayXuLy;
	private String _language;
	private int _isFormHienBinhLuan;
	private int _isFormViewBinhLuan;
	private int _status;
	private long _orders;
	private int _delete_status;

}