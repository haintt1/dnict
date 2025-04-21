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
 * This class is a wrapper for {@link CanBo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanBo
 * @generated
 */
public class CanBoWrapper
	extends BaseModelWrapper<CanBo> implements CanBo, ModelWrapper<CanBo> {

	public CanBoWrapper(CanBo canBo) {
		super(canBo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("canboId", getCanboId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("ten", getTen());
		attributes.put("chucVu", getChucVu());
		attributes.put("phongban_id", getPhongban_id());
		attributes.put("sdt", getSdt());
		attributes.put("email", getEmail());
		attributes.put("tinhTrang", getTinhTrang());
		attributes.put("sapXep", getSapXep());
		attributes.put("daXoa", getDaXoa());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long canboId = (Long)attributes.get("canboId");

		if (canboId != null) {
			setCanboId(canboId);
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

		String chucVu = (String)attributes.get("chucVu");

		if (chucVu != null) {
			setChucVu(chucVu);
		}

		Long phongban_id = (Long)attributes.get("phongban_id");

		if (phongban_id != null) {
			setPhongban_id(phongban_id);
		}

		String sdt = (String)attributes.get("sdt");

		if (sdt != null) {
			setSdt(sdt);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
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
	 * Returns the canbo ID of this can bo.
	 *
	 * @return the canbo ID of this can bo
	 */
	@Override
	public long getCanboId() {
		return model.getCanboId();
	}

	/**
	 * Returns the chuc vu of this can bo.
	 *
	 * @return the chuc vu of this can bo
	 */
	@Override
	public String getChucVu() {
		return model.getChucVu();
	}

	/**
	 * Returns the company ID of this can bo.
	 *
	 * @return the company ID of this can bo
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the da xoa of this can bo.
	 *
	 * @return the da xoa of this can bo
	 */
	@Override
	public long getDaXoa() {
		return model.getDaXoa();
	}

	/**
	 * Returns the email of this can bo.
	 *
	 * @return the email of this can bo
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this can bo.
	 *
	 * @return the group ID of this can bo
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ngay sua of this can bo.
	 *
	 * @return the ngay sua of this can bo
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this can bo.
	 *
	 * @return the ngay tao of this can bo
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the phongban_id of this can bo.
	 *
	 * @return the phongban_id of this can bo
	 */
	@Override
	public long getPhongban_id() {
		return model.getPhongban_id();
	}

	/**
	 * Returns the primary key of this can bo.
	 *
	 * @return the primary key of this can bo
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sap xep of this can bo.
	 *
	 * @return the sap xep of this can bo
	 */
	@Override
	public int getSapXep() {
		return model.getSapXep();
	}

	/**
	 * Returns the sdt of this can bo.
	 *
	 * @return the sdt of this can bo
	 */
	@Override
	public String getSdt() {
		return model.getSdt();
	}

	/**
	 * Returns the ten of this can bo.
	 *
	 * @return the ten of this can bo
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tinh trang of this can bo.
	 *
	 * @return the tinh trang of this can bo
	 */
	@Override
	public long getTinhTrang() {
		return model.getTinhTrang();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the canbo ID of this can bo.
	 *
	 * @param canboId the canbo ID of this can bo
	 */
	@Override
	public void setCanboId(long canboId) {
		model.setCanboId(canboId);
	}

	/**
	 * Sets the chuc vu of this can bo.
	 *
	 * @param chucVu the chuc vu of this can bo
	 */
	@Override
	public void setChucVu(String chucVu) {
		model.setChucVu(chucVu);
	}

	/**
	 * Sets the company ID of this can bo.
	 *
	 * @param companyId the company ID of this can bo
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the da xoa of this can bo.
	 *
	 * @param daXoa the da xoa of this can bo
	 */
	@Override
	public void setDaXoa(long daXoa) {
		model.setDaXoa(daXoa);
	}

	/**
	 * Sets the email of this can bo.
	 *
	 * @param email the email of this can bo
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this can bo.
	 *
	 * @param groupId the group ID of this can bo
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ngay sua of this can bo.
	 *
	 * @param ngaySua the ngay sua of this can bo
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this can bo.
	 *
	 * @param ngayTao the ngay tao of this can bo
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the phongban_id of this can bo.
	 *
	 * @param phongban_id the phongban_id of this can bo
	 */
	@Override
	public void setPhongban_id(long phongban_id) {
		model.setPhongban_id(phongban_id);
	}

	/**
	 * Sets the primary key of this can bo.
	 *
	 * @param primaryKey the primary key of this can bo
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sap xep of this can bo.
	 *
	 * @param sapXep the sap xep of this can bo
	 */
	@Override
	public void setSapXep(int sapXep) {
		model.setSapXep(sapXep);
	}

	/**
	 * Sets the sdt of this can bo.
	 *
	 * @param sdt the sdt of this can bo
	 */
	@Override
	public void setSdt(String sdt) {
		model.setSdt(sdt);
	}

	/**
	 * Sets the ten of this can bo.
	 *
	 * @param ten the ten of this can bo
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tinh trang of this can bo.
	 *
	 * @param tinhTrang the tinh trang of this can bo
	 */
	@Override
	public void setTinhTrang(long tinhTrang) {
		model.setTinhTrang(tinhTrang);
	}

	@Override
	protected CanBoWrapper wrap(CanBo canBo) {
		return new CanBoWrapper(canBo);
	}

}