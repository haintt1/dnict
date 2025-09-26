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

package vn.dnict.tintuc.model;

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
public class News_ArticleSoap implements Serializable {

	public static News_ArticleSoap toSoapModel(News_Article model) {
		News_ArticleSoap soapModel = new News_ArticleSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTypeid(model.getTypeid());
		soapModel.setTitle(model.getTitle());
		soapModel.setInfo(model.getInfo());
		soapModel.setContent(model.getContent());
		soapModel.setCreatedby(model.getCreatedby());
		soapModel.setCreatedtime(model.getCreatedtime());
		soapModel.setModifiedby(model.getModifiedby());
		soapModel.setModifiedtime(model.getModifiedtime());
		soapModel.setNguoinhanid(model.getNguoinhanid());
		soapModel.setNguoixulyid(model.getNguoixulyid());
		soapModel.setNgayxuly(model.getNgayxuly());
		soapModel.setStatus(model.getStatus());
		soapModel.setLanguage(model.getLanguage());
		soapModel.setVersion(model.getVersion());
		soapModel.setDelete_status(model.getDelete_status());
		soapModel.setUrlimagesmall(model.getUrlimagesmall());
		soapModel.setLuotxem(model.getLuotxem());
		soapModel.setIsnoibat(model.getIsnoibat());
		soapModel.setNgayxuatban(model.getNgayxuatban());
		soapModel.setNgayketthuc(model.getNgayketthuc());
		soapModel.setIshethang(model.getIshethang());
		soapModel.setNguontin(model.getNguontin());
		soapModel.setCongtacvien(model.getCongtacvien());
		soapModel.setLoaitintuc(model.getLoaitintuc());
		soapModel.setTukhoa(model.getTukhoa());
		soapModel.setSotinanh(model.getSotinanh());
		soapModel.setIsformbinhluan(model.getIsformbinhluan());
		soapModel.setIsviewbinhluan(model.getIsviewbinhluan());

		return soapModel;
	}

	public static News_ArticleSoap[] toSoapModels(News_Article[] models) {
		News_ArticleSoap[] soapModels = new News_ArticleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static News_ArticleSoap[][] toSoapModels(News_Article[][] models) {
		News_ArticleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new News_ArticleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new News_ArticleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static News_ArticleSoap[] toSoapModels(List<News_Article> models) {
		List<News_ArticleSoap> soapModels = new ArrayList<News_ArticleSoap>(
			models.size());

		for (News_Article model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new News_ArticleSoap[soapModels.size()]);
	}

	public News_ArticleSoap() {
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

	public long getTypeid() {
		return _typeid;
	}

	public void setTypeid(long typeid) {
		_typeid = typeid;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getInfo() {
		return _info;
	}

	public void setInfo(String info) {
		_info = info;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getCreatedby() {
		return _createdby;
	}

	public void setCreatedby(long createdby) {
		_createdby = createdby;
	}

	public Date getCreatedtime() {
		return _createdtime;
	}

	public void setCreatedtime(Date createdtime) {
		_createdtime = createdtime;
	}

	public long getModifiedby() {
		return _modifiedby;
	}

	public void setModifiedby(long modifiedby) {
		_modifiedby = modifiedby;
	}

	public Date getModifiedtime() {
		return _modifiedtime;
	}

	public void setModifiedtime(Date modifiedtime) {
		_modifiedtime = modifiedtime;
	}

	public long getNguoinhanid() {
		return _nguoinhanid;
	}

	public void setNguoinhanid(long nguoinhanid) {
		_nguoinhanid = nguoinhanid;
	}

	public long getNguoixulyid() {
		return _nguoixulyid;
	}

	public void setNguoixulyid(long nguoixulyid) {
		_nguoixulyid = nguoixulyid;
	}

	public Date getNgayxuly() {
		return _ngayxuly;
	}

	public void setNgayxuly(Date ngayxuly) {
		_ngayxuly = ngayxuly;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getLanguage() {
		return _language;
	}

	public void setLanguage(String language) {
		_language = language;
	}

	public long getVersion() {
		return _version;
	}

	public void setVersion(long version) {
		_version = version;
	}

	public int getDelete_status() {
		return _delete_status;
	}

	public void setDelete_status(int delete_status) {
		_delete_status = delete_status;
	}

	public String getUrlimagesmall() {
		return _urlimagesmall;
	}

	public void setUrlimagesmall(String urlimagesmall) {
		_urlimagesmall = urlimagesmall;
	}

	public long getLuotxem() {
		return _luotxem;
	}

	public void setLuotxem(long luotxem) {
		_luotxem = luotxem;
	}

	public long getIsnoibat() {
		return _isnoibat;
	}

	public void setIsnoibat(long isnoibat) {
		_isnoibat = isnoibat;
	}

	public Date getNgayxuatban() {
		return _ngayxuatban;
	}

	public void setNgayxuatban(Date ngayxuatban) {
		_ngayxuatban = ngayxuatban;
	}

	public Date getNgayketthuc() {
		return _ngayketthuc;
	}

	public void setNgayketthuc(Date ngayketthuc) {
		_ngayketthuc = ngayketthuc;
	}

	public long getIshethang() {
		return _ishethang;
	}

	public void setIshethang(long ishethang) {
		_ishethang = ishethang;
	}

	public long getNguontin() {
		return _nguontin;
	}

	public void setNguontin(long nguontin) {
		_nguontin = nguontin;
	}

	public String getCongtacvien() {
		return _congtacvien;
	}

	public void setCongtacvien(String congtacvien) {
		_congtacvien = congtacvien;
	}

	public int getLoaitintuc() {
		return _loaitintuc;
	}

	public void setLoaitintuc(int loaitintuc) {
		_loaitintuc = loaitintuc;
	}

	public String getTukhoa() {
		return _tukhoa;
	}

	public void setTukhoa(String tukhoa) {
		_tukhoa = tukhoa;
	}

	public int getSotinanh() {
		return _sotinanh;
	}

	public void setSotinanh(int sotinanh) {
		_sotinanh = sotinanh;
	}

	public int getIsformbinhluan() {
		return _isformbinhluan;
	}

	public void setIsformbinhluan(int isformbinhluan) {
		_isformbinhluan = isformbinhluan;
	}

	public int getIsviewbinhluan() {
		return _isviewbinhluan;
	}

	public void setIsviewbinhluan(int isviewbinhluan) {
		_isviewbinhluan = isviewbinhluan;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private long _typeid;
	private String _title;
	private String _info;
	private String _content;
	private long _createdby;
	private Date _createdtime;
	private long _modifiedby;
	private Date _modifiedtime;
	private long _nguoinhanid;
	private long _nguoixulyid;
	private Date _ngayxuly;
	private int _status;
	private String _language;
	private long _version;
	private int _delete_status;
	private String _urlimagesmall;
	private long _luotxem;
	private long _isnoibat;
	private Date _ngayxuatban;
	private Date _ngayketthuc;
	private long _ishethang;
	private long _nguontin;
	private String _congtacvien;
	private int _loaitintuc;
	private String _tukhoa;
	private int _sotinanh;
	private int _isformbinhluan;
	private int _isviewbinhluan;

}