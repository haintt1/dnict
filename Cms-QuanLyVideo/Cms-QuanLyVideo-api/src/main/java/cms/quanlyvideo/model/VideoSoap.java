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
 * This class is used by SOAP remote services, specifically {@link cms.quanlyvideo.service.http.VideoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class VideoSoap implements Serializable {

	public static VideoSoap toSoapModel(Video model) {
		VideoSoap soapModel = new VideoSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setTen(model.getTen());
		soapModel.setMoTa(model.getMoTa());
		soapModel.setNoiDung(model.getNoiDung());
		soapModel.setDuongDan(model.getDuongDan());
		soapModel.setLuotXem(model.getLuotXem());
		soapModel.setLuotThich(model.getLuotThich());
		soapModel.setTuKhoa(model.getTuKhoa());
		soapModel.setChoBinhLuan(model.getChoBinhLuan());
		soapModel.setTrangThai(model.getTrangThai());
		soapModel.setDaXoa(model.getDaXoa());
		soapModel.setNgayTao(model.getNgayTao());
		soapModel.setNgaySua(model.getNgaySua());

		return soapModel;
	}

	public static VideoSoap[] toSoapModels(Video[] models) {
		VideoSoap[] soapModels = new VideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoSoap[][] toSoapModels(Video[][] models) {
		VideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoSoap[] toSoapModels(List<Video> models) {
		List<VideoSoap> soapModels = new ArrayList<VideoSoap>(models.size());

		for (Video model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoSoap[soapModels.size()]);
	}

	public VideoSoap() {
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

	public String getNoiDung() {
		return _noiDung;
	}

	public void setNoiDung(String noiDung) {
		_noiDung = noiDung;
	}

	public String getDuongDan() {
		return _duongDan;
	}

	public void setDuongDan(String duongDan) {
		_duongDan = duongDan;
	}

	public long getLuotXem() {
		return _luotXem;
	}

	public void setLuotXem(long luotXem) {
		_luotXem = luotXem;
	}

	public long getLuotThich() {
		return _luotThich;
	}

	public void setLuotThich(long luotThich) {
		_luotThich = luotThich;
	}

	public String getTuKhoa() {
		return _tuKhoa;
	}

	public void setTuKhoa(String tuKhoa) {
		_tuKhoa = tuKhoa;
	}

	public long getChoBinhLuan() {
		return _choBinhLuan;
	}

	public void setChoBinhLuan(long choBinhLuan) {
		_choBinhLuan = choBinhLuan;
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
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _ten;
	private String _moTa;
	private String _noiDung;
	private String _duongDan;
	private long _luotXem;
	private long _luotThich;
	private String _tuKhoa;
	private long _choBinhLuan;
	private long _trangThai;
	private long _daXoa;
	private Date _ngayTao;
	private Date _ngaySua;

}