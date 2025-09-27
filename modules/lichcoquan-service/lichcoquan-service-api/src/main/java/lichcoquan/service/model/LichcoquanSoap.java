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

package lichcoquan.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link lichcoquan.service.service.http.LichcoquanServiceSoap}.
 *
 * @author BinhNT
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LichcoquanSoap implements Serializable {

	public static LichcoquanSoap toSoapModel(Lichcoquan model) {
		LichcoquanSoap soapModel = new LichcoquanSoap();

		soapModel.setLichCongtacId(model.getLichCongtacId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setContent(model.getContent());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setTungay(model.getTungay());
		soapModel.setDenngay(model.getDenngay());
		soapModel.setTrangthai(model.getTrangthai());
		soapModel.setBanhanh(model.getBanhanh());
		soapModel.setTuan(model.getTuan());
		soapModel.setNam(model.getNam());

		return soapModel;
	}

	public static LichcoquanSoap[] toSoapModels(Lichcoquan[] models) {
		LichcoquanSoap[] soapModels = new LichcoquanSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LichcoquanSoap[][] toSoapModels(Lichcoquan[][] models) {
		LichcoquanSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LichcoquanSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LichcoquanSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LichcoquanSoap[] toSoapModels(List<Lichcoquan> models) {
		List<LichcoquanSoap> soapModels = new ArrayList<LichcoquanSoap>(
			models.size());

		for (Lichcoquan model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LichcoquanSoap[soapModels.size()]);
	}

	public LichcoquanSoap() {
	}

	public long getPrimaryKey() {
		return _lichCongtacId;
	}

	public void setPrimaryKey(long pk) {
		setLichCongtacId(pk);
	}

	public long getLichCongtacId() {
		return _lichCongtacId;
	}

	public void setLichCongtacId(long lichCongtacId) {
		_lichCongtacId = lichCongtacId;
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getTungay() {
		return _tungay;
	}

	public void setTungay(Date tungay) {
		_tungay = tungay;
	}

	public Date getDenngay() {
		return _denngay;
	}

	public void setDenngay(Date denngay) {
		_denngay = denngay;
	}

	public int getTrangthai() {
		return _trangthai;
	}

	public void setTrangthai(int trangthai) {
		_trangthai = trangthai;
	}

	public int getBanhanh() {
		return _banhanh;
	}

	public void setBanhanh(int banhanh) {
		_banhanh = banhanh;
	}

	public int getTuan() {
		return _tuan;
	}

	public void setTuan(int tuan) {
		_tuan = tuan;
	}

	public int getNam() {
		return _nam;
	}

	public void setNam(int nam) {
		_nam = nam;
	}

	private long _lichCongtacId;
	private long _companyId;
	private long _userId;
	private String _content;
	private Date _createDate;
	private Date _tungay;
	private Date _denngay;
	private int _trangthai;
	private int _banhanh;
	private int _tuan;
	private int _nam;

}