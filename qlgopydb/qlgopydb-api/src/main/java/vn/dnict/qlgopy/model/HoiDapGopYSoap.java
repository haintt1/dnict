/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.dnict.qlgopy.service.http.HoiDapGopYServiceSoap}.
 *
 * @author dnict
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class HoiDapGopYSoap implements Serializable {

	public static HoiDapGopYSoap toSoapModel(HoiDapGopY model) {
		HoiDapGopYSoap soapModel = new HoiDapGopYSoap();

		soapModel.setId(model.getId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setName(model.getName());
		soapModel.setTencoquan(model.getTencoquan());
		soapModel.setPhone(model.getPhone());
		soapModel.setEmail(model.getEmail());
		soapModel.setTitle(model.getTitle());
		soapModel.setContent(model.getContent());
		soapModel.setAnswer(model.getAnswer());
		soapModel.setNgay_guigopy(model.getNgay_guigopy());
		soapModel.setNgay_traloigopy(model.getNgay_traloigopy());
		soapModel.setTypeForm(model.getTypeForm());
		soapModel.setIs_traloi(model.getIs_traloi());
		soapModel.setIs_pheduyet(model.getIs_pheduyet());

		return soapModel;
	}

	public static HoiDapGopYSoap[] toSoapModels(HoiDapGopY[] models) {
		HoiDapGopYSoap[] soapModels = new HoiDapGopYSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HoiDapGopYSoap[][] toSoapModels(HoiDapGopY[][] models) {
		HoiDapGopYSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HoiDapGopYSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HoiDapGopYSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HoiDapGopYSoap[] toSoapModels(List<HoiDapGopY> models) {
		List<HoiDapGopYSoap> soapModels = new ArrayList<HoiDapGopYSoap>(
			models.size());

		for (HoiDapGopY model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HoiDapGopYSoap[soapModels.size()]);
	}

	public HoiDapGopYSoap() {
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTencoquan() {
		return _tencoquan;
	}

	public void setTencoquan(String tencoquan) {
		_tencoquan = tencoquan;
	}

	public String getPhone() {
		return _phone;
	}

	public void setPhone(String phone) {
		_phone = phone;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getAnswer() {
		return _answer;
	}

	public void setAnswer(String answer) {
		_answer = answer;
	}

	public Date getNgay_guigopy() {
		return _ngay_guigopy;
	}

	public void setNgay_guigopy(Date ngay_guigopy) {
		_ngay_guigopy = ngay_guigopy;
	}

	public Date getNgay_traloigopy() {
		return _ngay_traloigopy;
	}

	public void setNgay_traloigopy(Date ngay_traloigopy) {
		_ngay_traloigopy = ngay_traloigopy;
	}

	public int getTypeForm() {
		return _typeForm;
	}

	public void setTypeForm(int typeForm) {
		_typeForm = typeForm;
	}

	public int getIs_traloi() {
		return _is_traloi;
	}

	public void setIs_traloi(int is_traloi) {
		_is_traloi = is_traloi;
	}

	public int getIs_pheduyet() {
		return _is_pheduyet;
	}

	public void setIs_pheduyet(int is_pheduyet) {
		_is_pheduyet = is_pheduyet;
	}

	private long _id;
	private long _companyId;
	private long _groupId;
	private String _name;
	private String _tencoquan;
	private String _phone;
	private String _email;
	private String _title;
	private String _content;
	private String _answer;
	private Date _ngay_guigopy;
	private Date _ngay_traloigopy;
	private int _typeForm;
	private int _is_traloi;
	private int _is_pheduyet;

}