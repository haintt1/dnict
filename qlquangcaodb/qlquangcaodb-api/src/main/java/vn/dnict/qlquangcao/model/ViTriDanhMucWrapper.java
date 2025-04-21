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
 * This class is a wrapper for {@link ViTriDanhMuc}.
 * </p>
 *
 * @author dnict
 * @see ViTriDanhMuc
 * @generated
 */
public class ViTriDanhMucWrapper
	extends BaseModelWrapper<ViTriDanhMuc>
	implements ModelWrapper<ViTriDanhMuc>, ViTriDanhMuc {

	public ViTriDanhMucWrapper(ViTriDanhMuc viTriDanhMuc) {
		super(viTriDanhMuc);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("nguoitao", getNguoitao());
		attributes.put("ten", getTen());
		attributes.put("cssClass", getCssClass());
		attributes.put("kichthuoc", getKichthuoc());
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

		String cssClass = (String)attributes.get("cssClass");

		if (cssClass != null) {
			setCssClass(cssClass);
		}

		String kichthuoc = (String)attributes.get("kichthuoc");

		if (kichthuoc != null) {
			setKichthuoc(kichthuoc);
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
	 * Returns the company ID of this vi tri danh muc.
	 *
	 * @return the company ID of this vi tri danh muc
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the css class of this vi tri danh muc.
	 *
	 * @return the css class of this vi tri danh muc
	 */
	@Override
	public String getCssClass() {
		return model.getCssClass();
	}

	/**
	 * Returns the daxoa of this vi tri danh muc.
	 *
	 * @return the daxoa of this vi tri danh muc
	 */
	@Override
	public int getDaxoa() {
		return model.getDaxoa();
	}

	/**
	 * Returns the group ID of this vi tri danh muc.
	 *
	 * @return the group ID of this vi tri danh muc
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this vi tri danh muc.
	 *
	 * @return the ID of this vi tri danh muc
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the kichthuoc of this vi tri danh muc.
	 *
	 * @return the kichthuoc of this vi tri danh muc
	 */
	@Override
	public String getKichthuoc() {
		return model.getKichthuoc();
	}

	/**
	 * Returns the ngaysua of this vi tri danh muc.
	 *
	 * @return the ngaysua of this vi tri danh muc
	 */
	@Override
	public Date getNgaysua() {
		return model.getNgaysua();
	}

	/**
	 * Returns the ngaytao of this vi tri danh muc.
	 *
	 * @return the ngaytao of this vi tri danh muc
	 */
	@Override
	public Date getNgaytao() {
		return model.getNgaytao();
	}

	/**
	 * Returns the nguoitao of this vi tri danh muc.
	 *
	 * @return the nguoitao of this vi tri danh muc
	 */
	@Override
	public long getNguoitao() {
		return model.getNguoitao();
	}

	/**
	 * Returns the primary key of this vi tri danh muc.
	 *
	 * @return the primary key of this vi tri danh muc
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this vi tri danh muc.
	 *
	 * @return the ten of this vi tri danh muc
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trangthai of this vi tri danh muc.
	 *
	 * @return the trangthai of this vi tri danh muc
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
	 * Sets the company ID of this vi tri danh muc.
	 *
	 * @param companyId the company ID of this vi tri danh muc
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the css class of this vi tri danh muc.
	 *
	 * @param cssClass the css class of this vi tri danh muc
	 */
	@Override
	public void setCssClass(String cssClass) {
		model.setCssClass(cssClass);
	}

	/**
	 * Sets the daxoa of this vi tri danh muc.
	 *
	 * @param daxoa the daxoa of this vi tri danh muc
	 */
	@Override
	public void setDaxoa(int daxoa) {
		model.setDaxoa(daxoa);
	}

	/**
	 * Sets the group ID of this vi tri danh muc.
	 *
	 * @param groupId the group ID of this vi tri danh muc
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this vi tri danh muc.
	 *
	 * @param id the ID of this vi tri danh muc
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the kichthuoc of this vi tri danh muc.
	 *
	 * @param kichthuoc the kichthuoc of this vi tri danh muc
	 */
	@Override
	public void setKichthuoc(String kichthuoc) {
		model.setKichthuoc(kichthuoc);
	}

	/**
	 * Sets the ngaysua of this vi tri danh muc.
	 *
	 * @param ngaysua the ngaysua of this vi tri danh muc
	 */
	@Override
	public void setNgaysua(Date ngaysua) {
		model.setNgaysua(ngaysua);
	}

	/**
	 * Sets the ngaytao of this vi tri danh muc.
	 *
	 * @param ngaytao the ngaytao of this vi tri danh muc
	 */
	@Override
	public void setNgaytao(Date ngaytao) {
		model.setNgaytao(ngaytao);
	}

	/**
	 * Sets the nguoitao of this vi tri danh muc.
	 *
	 * @param nguoitao the nguoitao of this vi tri danh muc
	 */
	@Override
	public void setNguoitao(long nguoitao) {
		model.setNguoitao(nguoitao);
	}

	/**
	 * Sets the primary key of this vi tri danh muc.
	 *
	 * @param primaryKey the primary key of this vi tri danh muc
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this vi tri danh muc.
	 *
	 * @param ten the ten of this vi tri danh muc
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trangthai of this vi tri danh muc.
	 *
	 * @param trangthai the trangthai of this vi tri danh muc
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	@Override
	protected ViTriDanhMucWrapper wrap(ViTriDanhMuc viTriDanhMuc) {
		return new ViTriDanhMucWrapper(viTriDanhMuc);
	}

}