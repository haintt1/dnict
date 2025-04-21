/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChuDe}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDe
 * @generated
 */
public class ChuDeWrapper
	extends BaseModelWrapper<ChuDe> implements ChuDe, ModelWrapper<ChuDe> {

	public ChuDeWrapper(ChuDe chuDe) {
		super(chuDe);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("trangThai", getTrangThai());
		attributes.put("daXoa", getDaXoa());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("ngaySua", getNgaySua());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Long trangThai = (Long)attributes.get("trangThai");

		if (trangThai != null) {
			setTrangThai(trangThai);
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
	 * Returns the company ID of this chu de.
	 *
	 * @return the company ID of this chu de
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the da xoa of this chu de.
	 *
	 * @return the da xoa of this chu de
	 */
	@Override
	public long getDaXoa() {
		return model.getDaXoa();
	}

	/**
	 * Returns the group ID of this chu de.
	 *
	 * @return the group ID of this chu de
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this chu de.
	 *
	 * @return the ID of this chu de
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the mo ta of this chu de.
	 *
	 * @return the mo ta of this chu de
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this chu de.
	 *
	 * @return the ngay sua of this chu de
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this chu de.
	 *
	 * @return the ngay tao of this chu de
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the primary key of this chu de.
	 *
	 * @return the primary key of this chu de
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this chu de.
	 *
	 * @return the ten of this chu de
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trang thai of this chu de.
	 *
	 * @return the trang thai of this chu de
	 */
	@Override
	public long getTrangThai() {
		return model.getTrangThai();
	}

	/**
	 * Returns the user ID of this chu de.
	 *
	 * @return the user ID of this chu de
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this chu de.
	 *
	 * @return the user uuid of this chu de
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this chu de.
	 *
	 * @param companyId the company ID of this chu de
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the da xoa of this chu de.
	 *
	 * @param daXoa the da xoa of this chu de
	 */
	@Override
	public void setDaXoa(long daXoa) {
		model.setDaXoa(daXoa);
	}

	/**
	 * Sets the group ID of this chu de.
	 *
	 * @param groupId the group ID of this chu de
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this chu de.
	 *
	 * @param id the ID of this chu de
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the mo ta of this chu de.
	 *
	 * @param moTa the mo ta of this chu de
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this chu de.
	 *
	 * @param ngaySua the ngay sua of this chu de
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this chu de.
	 *
	 * @param ngayTao the ngay tao of this chu de
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the primary key of this chu de.
	 *
	 * @param primaryKey the primary key of this chu de
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this chu de.
	 *
	 * @param ten the ten of this chu de
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trang thai of this chu de.
	 *
	 * @param trangThai the trang thai of this chu de
	 */
	@Override
	public void setTrangThai(long trangThai) {
		model.setTrangThai(trangThai);
	}

	/**
	 * Sets the user ID of this chu de.
	 *
	 * @param userId the user ID of this chu de
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this chu de.
	 *
	 * @param userUuid the user uuid of this chu de
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected ChuDeWrapper wrap(ChuDe chuDe) {
		return new ChuDeWrapper(chuDe);
	}

}