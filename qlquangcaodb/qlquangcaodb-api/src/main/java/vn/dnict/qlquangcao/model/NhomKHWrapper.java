/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NhomKH}.
 * </p>
 *
 * @author dnict
 * @see NhomKH
 * @generated
 */
public class NhomKHWrapper
	extends BaseModelWrapper<NhomKH> implements ModelWrapper<NhomKH>, NhomKH {

	public NhomKHWrapper(NhomKH nhomKH) {
		super(nhomKH);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("nguoitao", getNguoitao());
		attributes.put("ten", getTen());
		attributes.put("nguoidaidien", getNguoidaidien());
		attributes.put("logo", getLogo());
		attributes.put("mota", getMota());
		attributes.put("diachi", getDiachi());
		attributes.put("sdt", getSdt());
		attributes.put("email", getEmail());
		attributes.put("ngaytao", getNgaytao());
		attributes.put("daxoa", getDaxoa());
		attributes.put("trangthai", getTrangthai());
		attributes.put("ngaysua", getNgaysua());

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

		Long nguoitao = (Long)attributes.get("nguoitao");

		if (nguoitao != null) {
			setNguoitao(nguoitao);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String nguoidaidien = (String)attributes.get("nguoidaidien");

		if (nguoidaidien != null) {
			setNguoidaidien(nguoidaidien);
		}

		String logo = (String)attributes.get("logo");

		if (logo != null) {
			setLogo(logo);
		}

		String mota = (String)attributes.get("mota");

		if (mota != null) {
			setMota(mota);
		}

		String diachi = (String)attributes.get("diachi");

		if (diachi != null) {
			setDiachi(diachi);
		}

		String sdt = (String)attributes.get("sdt");

		if (sdt != null) {
			setSdt(sdt);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Date ngaytao = (Date)attributes.get("ngaytao");

		if (ngaytao != null) {
			setNgaytao(ngaytao);
		}

		Integer daxoa = (Integer)attributes.get("daxoa");

		if (daxoa != null) {
			setDaxoa(daxoa);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Date ngaysua = (Date)attributes.get("ngaysua");

		if (ngaysua != null) {
			setNgaysua(ngaysua);
		}
	}

	/**
	 * Returns the company ID of this nhom kh.
	 *
	 * @return the company ID of this nhom kh
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the daxoa of this nhom kh.
	 *
	 * @return the daxoa of this nhom kh
	 */
	@Override
	public int getDaxoa() {
		return model.getDaxoa();
	}

	/**
	 * Returns the diachi of this nhom kh.
	 *
	 * @return the diachi of this nhom kh
	 */
	@Override
	public String getDiachi() {
		return model.getDiachi();
	}

	/**
	 * Returns the email of this nhom kh.
	 *
	 * @return the email of this nhom kh
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this nhom kh.
	 *
	 * @return the group ID of this nhom kh
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this nhom kh.
	 *
	 * @return the ID of this nhom kh
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the logo of this nhom kh.
	 *
	 * @return the logo of this nhom kh
	 */
	@Override
	public String getLogo() {
		return model.getLogo();
	}

	/**
	 * Returns the mota of this nhom kh.
	 *
	 * @return the mota of this nhom kh
	 */
	@Override
	public String getMota() {
		return model.getMota();
	}

	/**
	 * Returns the ngaysua of this nhom kh.
	 *
	 * @return the ngaysua of this nhom kh
	 */
	@Override
	public Date getNgaysua() {
		return model.getNgaysua();
	}

	/**
	 * Returns the ngaytao of this nhom kh.
	 *
	 * @return the ngaytao of this nhom kh
	 */
	@Override
	public Date getNgaytao() {
		return model.getNgaytao();
	}

	/**
	 * Returns the nguoidaidien of this nhom kh.
	 *
	 * @return the nguoidaidien of this nhom kh
	 */
	@Override
	public String getNguoidaidien() {
		return model.getNguoidaidien();
	}

	/**
	 * Returns the nguoitao of this nhom kh.
	 *
	 * @return the nguoitao of this nhom kh
	 */
	@Override
	public long getNguoitao() {
		return model.getNguoitao();
	}

	/**
	 * Returns the primary key of this nhom kh.
	 *
	 * @return the primary key of this nhom kh
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sdt of this nhom kh.
	 *
	 * @return the sdt of this nhom kh
	 */
	@Override
	public String getSdt() {
		return model.getSdt();
	}

	/**
	 * Returns the ten of this nhom kh.
	 *
	 * @return the ten of this nhom kh
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trangthai of this nhom kh.
	 *
	 * @return the trangthai of this nhom kh
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this nhom kh.
	 *
	 * @param companyId the company ID of this nhom kh
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the daxoa of this nhom kh.
	 *
	 * @param daxoa the daxoa of this nhom kh
	 */
	@Override
	public void setDaxoa(int daxoa) {
		model.setDaxoa(daxoa);
	}

	/**
	 * Sets the diachi of this nhom kh.
	 *
	 * @param diachi the diachi of this nhom kh
	 */
	@Override
	public void setDiachi(String diachi) {
		model.setDiachi(diachi);
	}

	/**
	 * Sets the email of this nhom kh.
	 *
	 * @param email the email of this nhom kh
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this nhom kh.
	 *
	 * @param groupId the group ID of this nhom kh
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this nhom kh.
	 *
	 * @param id the ID of this nhom kh
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the logo of this nhom kh.
	 *
	 * @param logo the logo of this nhom kh
	 */
	@Override
	public void setLogo(String logo) {
		model.setLogo(logo);
	}

	/**
	 * Sets the mota of this nhom kh.
	 *
	 * @param mota the mota of this nhom kh
	 */
	@Override
	public void setMota(String mota) {
		model.setMota(mota);
	}

	/**
	 * Sets the ngaysua of this nhom kh.
	 *
	 * @param ngaysua the ngaysua of this nhom kh
	 */
	@Override
	public void setNgaysua(Date ngaysua) {
		model.setNgaysua(ngaysua);
	}

	/**
	 * Sets the ngaytao of this nhom kh.
	 *
	 * @param ngaytao the ngaytao of this nhom kh
	 */
	@Override
	public void setNgaytao(Date ngaytao) {
		model.setNgaytao(ngaytao);
	}

	/**
	 * Sets the nguoidaidien of this nhom kh.
	 *
	 * @param nguoidaidien the nguoidaidien of this nhom kh
	 */
	@Override
	public void setNguoidaidien(String nguoidaidien) {
		model.setNguoidaidien(nguoidaidien);
	}

	/**
	 * Sets the nguoitao of this nhom kh.
	 *
	 * @param nguoitao the nguoitao of this nhom kh
	 */
	@Override
	public void setNguoitao(long nguoitao) {
		model.setNguoitao(nguoitao);
	}

	/**
	 * Sets the primary key of this nhom kh.
	 *
	 * @param primaryKey the primary key of this nhom kh
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sdt of this nhom kh.
	 *
	 * @param sdt the sdt of this nhom kh
	 */
	@Override
	public void setSdt(String sdt) {
		model.setSdt(sdt);
	}

	/**
	 * Sets the ten of this nhom kh.
	 *
	 * @param ten the ten of this nhom kh
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trangthai of this nhom kh.
	 *
	 * @param trangthai the trangthai of this nhom kh
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	@Override
	protected NhomKHWrapper wrap(NhomKH nhomKH) {
		return new NhomKHWrapper(nhomKH);
	}

}