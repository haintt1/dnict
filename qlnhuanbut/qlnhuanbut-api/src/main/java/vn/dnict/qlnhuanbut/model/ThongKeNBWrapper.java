/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ThongKeNB}.
 * </p>
 *
 * @author dnict
 * @see ThongKeNB
 * @generated
 */
public class ThongKeNBWrapper
	extends BaseModelWrapper<ThongKeNB>
	implements ModelWrapper<ThongKeNB>, ThongKeNB {

	public ThongKeNBWrapper(ThongKeNB thongKeNB) {
		super(thongKeNB);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("nguoixuly", getNguoixuly());
		attributes.put("newarticleId", getNewarticleId());
		attributes.put("anphamId", getAnphamId());
		attributes.put("heso", getHeso());
		attributes.put("tongtien", getTongtien());
		attributes.put("status", getStatus());
		attributes.put("ngaytao", getNgaytao());
		attributes.put("ngaysua", getNgaysua());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long nguoixuly = (Long)attributes.get("nguoixuly");

		if (nguoixuly != null) {
			setNguoixuly(nguoixuly);
		}

		Long newarticleId = (Long)attributes.get("newarticleId");

		if (newarticleId != null) {
			setNewarticleId(newarticleId);
		}

		Long anphamId = (Long)attributes.get("anphamId");

		if (anphamId != null) {
			setAnphamId(anphamId);
		}

		String heso = (String)attributes.get("heso");

		if (heso != null) {
			setHeso(heso);
		}

		Double tongtien = (Double)attributes.get("tongtien");

		if (tongtien != null) {
			setTongtien(tongtien);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date ngaytao = (Date)attributes.get("ngaytao");

		if (ngaytao != null) {
			setNgaytao(ngaytao);
		}

		Date ngaysua = (Date)attributes.get("ngaysua");

		if (ngaysua != null) {
			setNgaysua(ngaysua);
		}
	}

	/**
	 * Returns the anpham ID of this thong ke nb.
	 *
	 * @return the anpham ID of this thong ke nb
	 */
	@Override
	public long getAnphamId() {
		return model.getAnphamId();
	}

	/**
	 * Returns the heso of this thong ke nb.
	 *
	 * @return the heso of this thong ke nb
	 */
	@Override
	public String getHeso() {
		return model.getHeso();
	}

	/**
	 * Returns the ID of this thong ke nb.
	 *
	 * @return the ID of this thong ke nb
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the newarticle ID of this thong ke nb.
	 *
	 * @return the newarticle ID of this thong ke nb
	 */
	@Override
	public long getNewarticleId() {
		return model.getNewarticleId();
	}

	/**
	 * Returns the ngaysua of this thong ke nb.
	 *
	 * @return the ngaysua of this thong ke nb
	 */
	@Override
	public Date getNgaysua() {
		return model.getNgaysua();
	}

	/**
	 * Returns the ngaytao of this thong ke nb.
	 *
	 * @return the ngaytao of this thong ke nb
	 */
	@Override
	public Date getNgaytao() {
		return model.getNgaytao();
	}

	/**
	 * Returns the nguoixuly of this thong ke nb.
	 *
	 * @return the nguoixuly of this thong ke nb
	 */
	@Override
	public long getNguoixuly() {
		return model.getNguoixuly();
	}

	/**
	 * Returns the primary key of this thong ke nb.
	 *
	 * @return the primary key of this thong ke nb
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this thong ke nb.
	 *
	 * @return the status of this thong ke nb
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the tongtien of this thong ke nb.
	 *
	 * @return the tongtien of this thong ke nb
	 */
	@Override
	public double getTongtien() {
		return model.getTongtien();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the anpham ID of this thong ke nb.
	 *
	 * @param anphamId the anpham ID of this thong ke nb
	 */
	@Override
	public void setAnphamId(long anphamId) {
		model.setAnphamId(anphamId);
	}

	/**
	 * Sets the heso of this thong ke nb.
	 *
	 * @param heso the heso of this thong ke nb
	 */
	@Override
	public void setHeso(String heso) {
		model.setHeso(heso);
	}

	/**
	 * Sets the ID of this thong ke nb.
	 *
	 * @param id the ID of this thong ke nb
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the newarticle ID of this thong ke nb.
	 *
	 * @param newarticleId the newarticle ID of this thong ke nb
	 */
	@Override
	public void setNewarticleId(long newarticleId) {
		model.setNewarticleId(newarticleId);
	}

	/**
	 * Sets the ngaysua of this thong ke nb.
	 *
	 * @param ngaysua the ngaysua of this thong ke nb
	 */
	@Override
	public void setNgaysua(Date ngaysua) {
		model.setNgaysua(ngaysua);
	}

	/**
	 * Sets the ngaytao of this thong ke nb.
	 *
	 * @param ngaytao the ngaytao of this thong ke nb
	 */
	@Override
	public void setNgaytao(Date ngaytao) {
		model.setNgaytao(ngaytao);
	}

	/**
	 * Sets the nguoixuly of this thong ke nb.
	 *
	 * @param nguoixuly the nguoixuly of this thong ke nb
	 */
	@Override
	public void setNguoixuly(long nguoixuly) {
		model.setNguoixuly(nguoixuly);
	}

	/**
	 * Sets the primary key of this thong ke nb.
	 *
	 * @param primaryKey the primary key of this thong ke nb
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this thong ke nb.
	 *
	 * @param status the status of this thong ke nb
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the tongtien of this thong ke nb.
	 *
	 * @param tongtien the tongtien of this thong ke nb
	 */
	@Override
	public void setTongtien(double tongtien) {
		model.setTongtien(tongtien);
	}

	@Override
	protected ThongKeNBWrapper wrap(ThongKeNB thongKeNB) {
		return new ThongKeNBWrapper(thongKeNB);
	}

}