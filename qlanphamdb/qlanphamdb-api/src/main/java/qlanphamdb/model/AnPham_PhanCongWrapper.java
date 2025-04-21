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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AnPham_PhanCong}.
 * </p>
 *
 * @author dnict
 * @see AnPham_PhanCong
 * @generated
 */
public class AnPham_PhanCongWrapper
	extends BaseModelWrapper<AnPham_PhanCong>
	implements AnPham_PhanCong, ModelWrapper<AnPham_PhanCong> {

	public AnPham_PhanCongWrapper(AnPham_PhanCong anPham_PhanCong) {
		super(anPham_PhanCong);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("loaiId", getLoaiId());
		attributes.put("deCuongId", getDeCuongId());
		attributes.put("ctvId", getCtvId());
		attributes.put("noiDung", getNoiDung());
		attributes.put("ghiChu", getGhiChu());
		attributes.put("ngaybatdau", getNgaybatdau());
		attributes.put("ngayketthuc", getNgayketthuc());
		attributes.put("status", getStatus());
		attributes.put("is_gui", getIs_gui());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long loaiId = (Long)attributes.get("loaiId");

		if (loaiId != null) {
			setLoaiId(loaiId);
		}

		Long deCuongId = (Long)attributes.get("deCuongId");

		if (deCuongId != null) {
			setDeCuongId(deCuongId);
		}

		Long ctvId = (Long)attributes.get("ctvId");

		if (ctvId != null) {
			setCtvId(ctvId);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		String ghiChu = (String)attributes.get("ghiChu");

		if (ghiChu != null) {
			setGhiChu(ghiChu);
		}

		Date ngaybatdau = (Date)attributes.get("ngaybatdau");

		if (ngaybatdau != null) {
			setNgaybatdau(ngaybatdau);
		}

		Date ngayketthuc = (Date)attributes.get("ngayketthuc");

		if (ngayketthuc != null) {
			setNgayketthuc(ngayketthuc);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer is_gui = (Integer)attributes.get("is_gui");

		if (is_gui != null) {
			setIs_gui(is_gui);
		}
	}

	/**
	 * Returns the company ID of this an pham_ phan cong.
	 *
	 * @return the company ID of this an pham_ phan cong
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the ctv ID of this an pham_ phan cong.
	 *
	 * @return the ctv ID of this an pham_ phan cong
	 */
	@Override
	public long getCtvId() {
		return model.getCtvId();
	}

	/**
	 * Returns the de cuong ID of this an pham_ phan cong.
	 *
	 * @return the de cuong ID of this an pham_ phan cong
	 */
	@Override
	public long getDeCuongId() {
		return model.getDeCuongId();
	}

	/**
	 * Returns the ghi chu of this an pham_ phan cong.
	 *
	 * @return the ghi chu of this an pham_ phan cong
	 */
	@Override
	public String getGhiChu() {
		return model.getGhiChu();
	}

	/**
	 * Returns the group ID of this an pham_ phan cong.
	 *
	 * @return the group ID of this an pham_ phan cong
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this an pham_ phan cong.
	 *
	 * @return the ID of this an pham_ phan cong
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is_gui of this an pham_ phan cong.
	 *
	 * @return the is_gui of this an pham_ phan cong
	 */
	@Override
	public int getIs_gui() {
		return model.getIs_gui();
	}

	/**
	 * Returns the loai ID of this an pham_ phan cong.
	 *
	 * @return the loai ID of this an pham_ phan cong
	 */
	@Override
	public long getLoaiId() {
		return model.getLoaiId();
	}

	/**
	 * Returns the ngaybatdau of this an pham_ phan cong.
	 *
	 * @return the ngaybatdau of this an pham_ phan cong
	 */
	@Override
	public Date getNgaybatdau() {
		return model.getNgaybatdau();
	}

	/**
	 * Returns the ngayketthuc of this an pham_ phan cong.
	 *
	 * @return the ngayketthuc of this an pham_ phan cong
	 */
	@Override
	public Date getNgayketthuc() {
		return model.getNgayketthuc();
	}

	/**
	 * Returns the noi dung of this an pham_ phan cong.
	 *
	 * @return the noi dung of this an pham_ phan cong
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the primary key of this an pham_ phan cong.
	 *
	 * @return the primary key of this an pham_ phan cong
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this an pham_ phan cong.
	 *
	 * @return the status of this an pham_ phan cong
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this an pham_ phan cong.
	 *
	 * @param companyId the company ID of this an pham_ phan cong
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the ctv ID of this an pham_ phan cong.
	 *
	 * @param ctvId the ctv ID of this an pham_ phan cong
	 */
	@Override
	public void setCtvId(long ctvId) {
		model.setCtvId(ctvId);
	}

	/**
	 * Sets the de cuong ID of this an pham_ phan cong.
	 *
	 * @param deCuongId the de cuong ID of this an pham_ phan cong
	 */
	@Override
	public void setDeCuongId(long deCuongId) {
		model.setDeCuongId(deCuongId);
	}

	/**
	 * Sets the ghi chu of this an pham_ phan cong.
	 *
	 * @param ghiChu the ghi chu of this an pham_ phan cong
	 */
	@Override
	public void setGhiChu(String ghiChu) {
		model.setGhiChu(ghiChu);
	}

	/**
	 * Sets the group ID of this an pham_ phan cong.
	 *
	 * @param groupId the group ID of this an pham_ phan cong
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this an pham_ phan cong.
	 *
	 * @param id the ID of this an pham_ phan cong
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is_gui of this an pham_ phan cong.
	 *
	 * @param is_gui the is_gui of this an pham_ phan cong
	 */
	@Override
	public void setIs_gui(int is_gui) {
		model.setIs_gui(is_gui);
	}

	/**
	 * Sets the loai ID of this an pham_ phan cong.
	 *
	 * @param loaiId the loai ID of this an pham_ phan cong
	 */
	@Override
	public void setLoaiId(long loaiId) {
		model.setLoaiId(loaiId);
	}

	/**
	 * Sets the ngaybatdau of this an pham_ phan cong.
	 *
	 * @param ngaybatdau the ngaybatdau of this an pham_ phan cong
	 */
	@Override
	public void setNgaybatdau(Date ngaybatdau) {
		model.setNgaybatdau(ngaybatdau);
	}

	/**
	 * Sets the ngayketthuc of this an pham_ phan cong.
	 *
	 * @param ngayketthuc the ngayketthuc of this an pham_ phan cong
	 */
	@Override
	public void setNgayketthuc(Date ngayketthuc) {
		model.setNgayketthuc(ngayketthuc);
	}

	/**
	 * Sets the noi dung of this an pham_ phan cong.
	 *
	 * @param noiDung the noi dung of this an pham_ phan cong
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this an pham_ phan cong.
	 *
	 * @param primaryKey the primary key of this an pham_ phan cong
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this an pham_ phan cong.
	 *
	 * @param status the status of this an pham_ phan cong
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	@Override
	protected AnPham_PhanCongWrapper wrap(AnPham_PhanCong anPham_PhanCong) {
		return new AnPham_PhanCongWrapper(anPham_PhanCong);
	}

}