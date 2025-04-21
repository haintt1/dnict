/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PhongBan}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhongBan
 * @generated
 */
public class PhongBanWrapper
	extends BaseModelWrapper<PhongBan>
	implements ModelWrapper<PhongBan>, PhongBan {

	public PhongBanWrapper(PhongBan phongBan) {
		super(phongBan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("phongbanId", getPhongbanId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("tochuc_id", getTochuc_id());
		attributes.put("tinhTrang", getTinhTrang());
		attributes.put("sapXep", getSapXep());
		attributes.put("daXoa", getDaXoa());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long phongbanId = (Long)attributes.get("phongbanId");

		if (phongbanId != null) {
			setPhongbanId(phongbanId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Long tochuc_id = (Long)attributes.get("tochuc_id");

		if (tochuc_id != null) {
			setTochuc_id(tochuc_id);
		}

		Long tinhTrang = (Long)attributes.get("tinhTrang");

		if (tinhTrang != null) {
			setTinhTrang(tinhTrang);
		}

		Integer sapXep = (Integer)attributes.get("sapXep");

		if (sapXep != null) {
			setSapXep(sapXep);
		}

		Long daXoa = (Long)attributes.get("daXoa");

		if (daXoa != null) {
			setDaXoa(daXoa);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}
	}

	/**
	 * Returns the company ID of this phong ban.
	 *
	 * @return the company ID of this phong ban
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the da xoa of this phong ban.
	 *
	 * @return the da xoa of this phong ban
	 */
	@Override
	public long getDaXoa() {
		return model.getDaXoa();
	}

	/**
	 * Returns the group ID of this phong ban.
	 *
	 * @return the group ID of this phong ban
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mo ta of this phong ban.
	 *
	 * @return the mo ta of this phong ban
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this phong ban.
	 *
	 * @return the ngay sua of this phong ban
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this phong ban.
	 *
	 * @return the ngay tao of this phong ban
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the phongban ID of this phong ban.
	 *
	 * @return the phongban ID of this phong ban
	 */
	@Override
	public long getPhongbanId() {
		return model.getPhongbanId();
	}

	/**
	 * Returns the primary key of this phong ban.
	 *
	 * @return the primary key of this phong ban
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sap xep of this phong ban.
	 *
	 * @return the sap xep of this phong ban
	 */
	@Override
	public int getSapXep() {
		return model.getSapXep();
	}

	/**
	 * Returns the ten of this phong ban.
	 *
	 * @return the ten of this phong ban
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tinh trang of this phong ban.
	 *
	 * @return the tinh trang of this phong ban
	 */
	@Override
	public long getTinhTrang() {
		return model.getTinhTrang();
	}

	/**
	 * Returns the tochuc_id of this phong ban.
	 *
	 * @return the tochuc_id of this phong ban
	 */
	@Override
	public long getTochuc_id() {
		return model.getTochuc_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this phong ban.
	 *
	 * @param companyId the company ID of this phong ban
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the da xoa of this phong ban.
	 *
	 * @param daXoa the da xoa of this phong ban
	 */
	@Override
	public void setDaXoa(long daXoa) {
		model.setDaXoa(daXoa);
	}

	/**
	 * Sets the group ID of this phong ban.
	 *
	 * @param groupId the group ID of this phong ban
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mo ta of this phong ban.
	 *
	 * @param moTa the mo ta of this phong ban
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this phong ban.
	 *
	 * @param ngaySua the ngay sua of this phong ban
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this phong ban.
	 *
	 * @param ngayTao the ngay tao of this phong ban
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the phongban ID of this phong ban.
	 *
	 * @param phongbanId the phongban ID of this phong ban
	 */
	@Override
	public void setPhongbanId(long phongbanId) {
		model.setPhongbanId(phongbanId);
	}

	/**
	 * Sets the primary key of this phong ban.
	 *
	 * @param primaryKey the primary key of this phong ban
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sap xep of this phong ban.
	 *
	 * @param sapXep the sap xep of this phong ban
	 */
	@Override
	public void setSapXep(int sapXep) {
		model.setSapXep(sapXep);
	}

	/**
	 * Sets the ten of this phong ban.
	 *
	 * @param ten the ten of this phong ban
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tinh trang of this phong ban.
	 *
	 * @param tinhTrang the tinh trang of this phong ban
	 */
	@Override
	public void setTinhTrang(long tinhTrang) {
		model.setTinhTrang(tinhTrang);
	}

	/**
	 * Sets the tochuc_id of this phong ban.
	 *
	 * @param tochuc_id the tochuc_id of this phong ban
	 */
	@Override
	public void setTochuc_id(long tochuc_id) {
		model.setTochuc_id(tochuc_id);
	}

	@Override
	protected PhongBanWrapper wrap(PhongBan phongBan) {
		return new PhongBanWrapper(phongBan);
	}

}