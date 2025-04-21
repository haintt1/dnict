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
 * This class is a wrapper for {@link BangQuangCao}.
 * </p>
 *
 * @author dnict
 * @see BangQuangCao
 * @generated
 */
public class BangQuangCaoWrapper
	extends BaseModelWrapper<BangQuangCao>
	implements BangQuangCao, ModelWrapper<BangQuangCao> {

	public BangQuangCaoWrapper(BangQuangCao bangQuangCao) {
		super(bangQuangCao);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("nguoitao", getNguoitao());
		attributes.put("ten", getTen());
		attributes.put("duongdan", getDuongdan());
		attributes.put("lienket", getLienket());
		attributes.put("nhomKH", getNhomKH());
		attributes.put("vitriQC", getVitriQC());
		attributes.put("ngaytao", getNgaytao());
		attributes.put("ngayketthuc", getNgayketthuc());
		attributes.put("daxoa", getDaxoa());
		attributes.put("trangthai", getTrangthai());
		attributes.put("trangthaisudung", getTrangthaisudung());
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

		String duongdan = (String)attributes.get("duongdan");

		if (duongdan != null) {
			setDuongdan(duongdan);
		}

		String lienket = (String)attributes.get("lienket");

		if (lienket != null) {
			setLienket(lienket);
		}

		Long nhomKH = (Long)attributes.get("nhomKH");

		if (nhomKH != null) {
			setNhomKH(nhomKH);
		}

		Long vitriQC = (Long)attributes.get("vitriQC");

		if (vitriQC != null) {
			setVitriQC(vitriQC);
		}

		Date ngaytao = (Date)attributes.get("ngaytao");

		if (ngaytao != null) {
			setNgaytao(ngaytao);
		}

		Date ngayketthuc = (Date)attributes.get("ngayketthuc");

		if (ngayketthuc != null) {
			setNgayketthuc(ngayketthuc);
		}

		Integer daxoa = (Integer)attributes.get("daxoa");

		if (daxoa != null) {
			setDaxoa(daxoa);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Integer trangthaisudung = (Integer)attributes.get("trangthaisudung");

		if (trangthaisudung != null) {
			setTrangthaisudung(trangthaisudung);
		}

		Date ngaysua = (Date)attributes.get("ngaysua");

		if (ngaysua != null) {
			setNgaysua(ngaysua);
		}
	}

	/**
	 * Returns the company ID of this bang quang cao.
	 *
	 * @return the company ID of this bang quang cao
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the daxoa of this bang quang cao.
	 *
	 * @return the daxoa of this bang quang cao
	 */
	@Override
	public int getDaxoa() {
		return model.getDaxoa();
	}

	/**
	 * Returns the duongdan of this bang quang cao.
	 *
	 * @return the duongdan of this bang quang cao
	 */
	@Override
	public String getDuongdan() {
		return model.getDuongdan();
	}

	/**
	 * Returns the group ID of this bang quang cao.
	 *
	 * @return the group ID of this bang quang cao
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this bang quang cao.
	 *
	 * @return the ID of this bang quang cao
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the lienket of this bang quang cao.
	 *
	 * @return the lienket of this bang quang cao
	 */
	@Override
	public String getLienket() {
		return model.getLienket();
	}

	/**
	 * Returns the ngayketthuc of this bang quang cao.
	 *
	 * @return the ngayketthuc of this bang quang cao
	 */
	@Override
	public Date getNgayketthuc() {
		return model.getNgayketthuc();
	}

	/**
	 * Returns the ngaysua of this bang quang cao.
	 *
	 * @return the ngaysua of this bang quang cao
	 */
	@Override
	public Date getNgaysua() {
		return model.getNgaysua();
	}

	/**
	 * Returns the ngaytao of this bang quang cao.
	 *
	 * @return the ngaytao of this bang quang cao
	 */
	@Override
	public Date getNgaytao() {
		return model.getNgaytao();
	}

	/**
	 * Returns the nguoitao of this bang quang cao.
	 *
	 * @return the nguoitao of this bang quang cao
	 */
	@Override
	public long getNguoitao() {
		return model.getNguoitao();
	}

	/**
	 * Returns the nhom kh of this bang quang cao.
	 *
	 * @return the nhom kh of this bang quang cao
	 */
	@Override
	public long getNhomKH() {
		return model.getNhomKH();
	}

	/**
	 * Returns the primary key of this bang quang cao.
	 *
	 * @return the primary key of this bang quang cao
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this bang quang cao.
	 *
	 * @return the ten of this bang quang cao
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trangthai of this bang quang cao.
	 *
	 * @return the trangthai of this bang quang cao
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the trangthaisudung of this bang quang cao.
	 *
	 * @return the trangthaisudung of this bang quang cao
	 */
	@Override
	public int getTrangthaisudung() {
		return model.getTrangthaisudung();
	}

	/**
	 * Returns the vitri qc of this bang quang cao.
	 *
	 * @return the vitri qc of this bang quang cao
	 */
	@Override
	public long getVitriQC() {
		return model.getVitriQC();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this bang quang cao.
	 *
	 * @param companyId the company ID of this bang quang cao
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the daxoa of this bang quang cao.
	 *
	 * @param daxoa the daxoa of this bang quang cao
	 */
	@Override
	public void setDaxoa(int daxoa) {
		model.setDaxoa(daxoa);
	}

	/**
	 * Sets the duongdan of this bang quang cao.
	 *
	 * @param duongdan the duongdan of this bang quang cao
	 */
	@Override
	public void setDuongdan(String duongdan) {
		model.setDuongdan(duongdan);
	}

	/**
	 * Sets the group ID of this bang quang cao.
	 *
	 * @param groupId the group ID of this bang quang cao
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this bang quang cao.
	 *
	 * @param id the ID of this bang quang cao
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the lienket of this bang quang cao.
	 *
	 * @param lienket the lienket of this bang quang cao
	 */
	@Override
	public void setLienket(String lienket) {
		model.setLienket(lienket);
	}

	/**
	 * Sets the ngayketthuc of this bang quang cao.
	 *
	 * @param ngayketthuc the ngayketthuc of this bang quang cao
	 */
	@Override
	public void setNgayketthuc(Date ngayketthuc) {
		model.setNgayketthuc(ngayketthuc);
	}

	/**
	 * Sets the ngaysua of this bang quang cao.
	 *
	 * @param ngaysua the ngaysua of this bang quang cao
	 */
	@Override
	public void setNgaysua(Date ngaysua) {
		model.setNgaysua(ngaysua);
	}

	/**
	 * Sets the ngaytao of this bang quang cao.
	 *
	 * @param ngaytao the ngaytao of this bang quang cao
	 */
	@Override
	public void setNgaytao(Date ngaytao) {
		model.setNgaytao(ngaytao);
	}

	/**
	 * Sets the nguoitao of this bang quang cao.
	 *
	 * @param nguoitao the nguoitao of this bang quang cao
	 */
	@Override
	public void setNguoitao(long nguoitao) {
		model.setNguoitao(nguoitao);
	}

	/**
	 * Sets the nhom kh of this bang quang cao.
	 *
	 * @param nhomKH the nhom kh of this bang quang cao
	 */
	@Override
	public void setNhomKH(long nhomKH) {
		model.setNhomKH(nhomKH);
	}

	/**
	 * Sets the primary key of this bang quang cao.
	 *
	 * @param primaryKey the primary key of this bang quang cao
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this bang quang cao.
	 *
	 * @param ten the ten of this bang quang cao
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trangthai of this bang quang cao.
	 *
	 * @param trangthai the trangthai of this bang quang cao
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the trangthaisudung of this bang quang cao.
	 *
	 * @param trangthaisudung the trangthaisudung of this bang quang cao
	 */
	@Override
	public void setTrangthaisudung(int trangthaisudung) {
		model.setTrangthaisudung(trangthaisudung);
	}

	/**
	 * Sets the vitri qc of this bang quang cao.
	 *
	 * @param vitriQC the vitri qc of this bang quang cao
	 */
	@Override
	public void setVitriQC(long vitriQC) {
		model.setVitriQC(vitriQC);
	}

	@Override
	protected BangQuangCaoWrapper wrap(BangQuangCao bangQuangCao) {
		return new BangQuangCaoWrapper(bangQuangCao);
	}

}