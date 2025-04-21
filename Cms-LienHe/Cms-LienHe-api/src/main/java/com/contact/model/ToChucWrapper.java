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
 * This class is a wrapper for {@link ToChuc}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ToChuc
 * @generated
 */
public class ToChucWrapper
	extends BaseModelWrapper<ToChuc> implements ModelWrapper<ToChuc>, ToChuc {

	public ToChucWrapper(ToChuc toChuc) {
		super(toChuc);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("tochucId", getTochucId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("tinhTrang", getTinhTrang());
		attributes.put("sapXep", getSapXep());
		attributes.put("daXoa", getDaXoa());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long tochucId = (Long)attributes.get("tochucId");

		if (tochucId != null) {
			setTochucId(tochucId);
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
	 * Returns the company ID of this to chuc.
	 *
	 * @return the company ID of this to chuc
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the da xoa of this to chuc.
	 *
	 * @return the da xoa of this to chuc
	 */
	@Override
	public long getDaXoa() {
		return model.getDaXoa();
	}

	/**
	 * Returns the group ID of this to chuc.
	 *
	 * @return the group ID of this to chuc
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mo ta of this to chuc.
	 *
	 * @return the mo ta of this to chuc
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this to chuc.
	 *
	 * @return the ngay sua of this to chuc
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this to chuc.
	 *
	 * @return the ngay tao of this to chuc
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the primary key of this to chuc.
	 *
	 * @return the primary key of this to chuc
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sap xep of this to chuc.
	 *
	 * @return the sap xep of this to chuc
	 */
	@Override
	public int getSapXep() {
		return model.getSapXep();
	}

	/**
	 * Returns the ten of this to chuc.
	 *
	 * @return the ten of this to chuc
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tinh trang of this to chuc.
	 *
	 * @return the tinh trang of this to chuc
	 */
	@Override
	public long getTinhTrang() {
		return model.getTinhTrang();
	}

	/**
	 * Returns the tochuc ID of this to chuc.
	 *
	 * @return the tochuc ID of this to chuc
	 */
	@Override
	public long getTochucId() {
		return model.getTochucId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this to chuc.
	 *
	 * @param companyId the company ID of this to chuc
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the da xoa of this to chuc.
	 *
	 * @param daXoa the da xoa of this to chuc
	 */
	@Override
	public void setDaXoa(long daXoa) {
		model.setDaXoa(daXoa);
	}

	/**
	 * Sets the group ID of this to chuc.
	 *
	 * @param groupId the group ID of this to chuc
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mo ta of this to chuc.
	 *
	 * @param moTa the mo ta of this to chuc
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this to chuc.
	 *
	 * @param ngaySua the ngay sua of this to chuc
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this to chuc.
	 *
	 * @param ngayTao the ngay tao of this to chuc
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the primary key of this to chuc.
	 *
	 * @param primaryKey the primary key of this to chuc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sap xep of this to chuc.
	 *
	 * @param sapXep the sap xep of this to chuc
	 */
	@Override
	public void setSapXep(int sapXep) {
		model.setSapXep(sapXep);
	}

	/**
	 * Sets the ten of this to chuc.
	 *
	 * @param ten the ten of this to chuc
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tinh trang of this to chuc.
	 *
	 * @param tinhTrang the tinh trang of this to chuc
	 */
	@Override
	public void setTinhTrang(long tinhTrang) {
		model.setTinhTrang(tinhTrang);
	}

	/**
	 * Sets the tochuc ID of this to chuc.
	 *
	 * @param tochucId the tochuc ID of this to chuc
	 */
	@Override
	public void setTochucId(long tochucId) {
		model.setTochucId(tochucId);
	}

	@Override
	protected ToChucWrapper wrap(ToChuc toChuc) {
		return new ToChucWrapper(toChuc);
	}

}