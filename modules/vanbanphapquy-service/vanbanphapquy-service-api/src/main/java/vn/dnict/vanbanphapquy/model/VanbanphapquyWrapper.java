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

package vn.dnict.vanbanphapquy.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vanbanphapquy}.
 * </p>
 *
 * @author BinhNT
 * @see Vanbanphapquy
 * @generated
 */
public class VanbanphapquyWrapper
	extends BaseModelWrapper<Vanbanphapquy>
	implements ModelWrapper<Vanbanphapquy>, Vanbanphapquy {

	public VanbanphapquyWrapper(Vanbanphapquy vanbanphapquy) {
		super(vanbanphapquy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("sohieu", getSohieu());
		attributes.put("trichyeu", getTrichyeu());
		attributes.put("noidung", getNoidung());
		attributes.put("ngay_banhanh", getNgay_banhanh());
		attributes.put("ngay_hieuluc", getNgay_hieuluc());
		attributes.put("ngay_hethieuluc", getNgay_hethieuluc());
		attributes.put("ngay_xuatban", getNgay_xuatban());
		attributes.put("id_linhvuc", getId_linhvuc());
		attributes.put("id_loaivanban", getId_loaivanban());
		attributes.put("id_capbanhanh", getId_capbanhanh());
		attributes.put("id_coquanbanhanh", getId_coquanbanhanh());
		attributes.put("nguoiky", getNguoiky());
		attributes.put("status", getStatus());
		attributes.put("type", getType());

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

		String sohieu = (String)attributes.get("sohieu");

		if (sohieu != null) {
			setSohieu(sohieu);
		}

		String trichyeu = (String)attributes.get("trichyeu");

		if (trichyeu != null) {
			setTrichyeu(trichyeu);
		}

		String noidung = (String)attributes.get("noidung");

		if (noidung != null) {
			setNoidung(noidung);
		}

		Date ngay_banhanh = (Date)attributes.get("ngay_banhanh");

		if (ngay_banhanh != null) {
			setNgay_banhanh(ngay_banhanh);
		}

		Date ngay_hieuluc = (Date)attributes.get("ngay_hieuluc");

		if (ngay_hieuluc != null) {
			setNgay_hieuluc(ngay_hieuluc);
		}

		Date ngay_hethieuluc = (Date)attributes.get("ngay_hethieuluc");

		if (ngay_hethieuluc != null) {
			setNgay_hethieuluc(ngay_hethieuluc);
		}

		Date ngay_xuatban = (Date)attributes.get("ngay_xuatban");

		if (ngay_xuatban != null) {
			setNgay_xuatban(ngay_xuatban);
		}

		Long id_linhvuc = (Long)attributes.get("id_linhvuc");

		if (id_linhvuc != null) {
			setId_linhvuc(id_linhvuc);
		}

		Long id_loaivanban = (Long)attributes.get("id_loaivanban");

		if (id_loaivanban != null) {
			setId_loaivanban(id_loaivanban);
		}

		Long id_capbanhanh = (Long)attributes.get("id_capbanhanh");

		if (id_capbanhanh != null) {
			setId_capbanhanh(id_capbanhanh);
		}

		Long id_coquanbanhanh = (Long)attributes.get("id_coquanbanhanh");

		if (id_coquanbanhanh != null) {
			setId_coquanbanhanh(id_coquanbanhanh);
		}

		String nguoiky = (String)attributes.get("nguoiky");

		if (nguoiky != null) {
			setNguoiky(nguoiky);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	 * Returns the company ID of this vanbanphapquy.
	 *
	 * @return the company ID of this vanbanphapquy
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the group ID of this vanbanphapquy.
	 *
	 * @return the group ID of this vanbanphapquy
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this vanbanphapquy.
	 *
	 * @return the ID of this vanbanphapquy
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id_capbanhanh of this vanbanphapquy.
	 *
	 * @return the id_capbanhanh of this vanbanphapquy
	 */
	@Override
	public long getId_capbanhanh() {
		return model.getId_capbanhanh();
	}

	/**
	 * Returns the id_coquanbanhanh of this vanbanphapquy.
	 *
	 * @return the id_coquanbanhanh of this vanbanphapquy
	 */
	@Override
	public long getId_coquanbanhanh() {
		return model.getId_coquanbanhanh();
	}

	/**
	 * Returns the id_linhvuc of this vanbanphapquy.
	 *
	 * @return the id_linhvuc of this vanbanphapquy
	 */
	@Override
	public long getId_linhvuc() {
		return model.getId_linhvuc();
	}

	/**
	 * Returns the id_loaivanban of this vanbanphapquy.
	 *
	 * @return the id_loaivanban of this vanbanphapquy
	 */
	@Override
	public long getId_loaivanban() {
		return model.getId_loaivanban();
	}

	/**
	 * Returns the ngay_banhanh of this vanbanphapquy.
	 *
	 * @return the ngay_banhanh of this vanbanphapquy
	 */
	@Override
	public Date getNgay_banhanh() {
		return model.getNgay_banhanh();
	}

	/**
	 * Returns the ngay_hethieuluc of this vanbanphapquy.
	 *
	 * @return the ngay_hethieuluc of this vanbanphapquy
	 */
	@Override
	public Date getNgay_hethieuluc() {
		return model.getNgay_hethieuluc();
	}

	/**
	 * Returns the ngay_hieuluc of this vanbanphapquy.
	 *
	 * @return the ngay_hieuluc of this vanbanphapquy
	 */
	@Override
	public Date getNgay_hieuluc() {
		return model.getNgay_hieuluc();
	}

	/**
	 * Returns the ngay_xuatban of this vanbanphapquy.
	 *
	 * @return the ngay_xuatban of this vanbanphapquy
	 */
	@Override
	public Date getNgay_xuatban() {
		return model.getNgay_xuatban();
	}

	/**
	 * Returns the nguoiky of this vanbanphapquy.
	 *
	 * @return the nguoiky of this vanbanphapquy
	 */
	@Override
	public String getNguoiky() {
		return model.getNguoiky();
	}

	/**
	 * Returns the noidung of this vanbanphapquy.
	 *
	 * @return the noidung of this vanbanphapquy
	 */
	@Override
	public String getNoidung() {
		return model.getNoidung();
	}

	/**
	 * Returns the primary key of this vanbanphapquy.
	 *
	 * @return the primary key of this vanbanphapquy
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sohieu of this vanbanphapquy.
	 *
	 * @return the sohieu of this vanbanphapquy
	 */
	@Override
	public String getSohieu() {
		return model.getSohieu();
	}

	/**
	 * Returns the status of this vanbanphapquy.
	 *
	 * @return the status of this vanbanphapquy
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the trichyeu of this vanbanphapquy.
	 *
	 * @return the trichyeu of this vanbanphapquy
	 */
	@Override
	public String getTrichyeu() {
		return model.getTrichyeu();
	}

	/**
	 * Returns the type of this vanbanphapquy.
	 *
	 * @return the type of this vanbanphapquy
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this vanbanphapquy.
	 *
	 * @param companyId the company ID of this vanbanphapquy
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the group ID of this vanbanphapquy.
	 *
	 * @param groupId the group ID of this vanbanphapquy
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this vanbanphapquy.
	 *
	 * @param id the ID of this vanbanphapquy
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id_capbanhanh of this vanbanphapquy.
	 *
	 * @param id_capbanhanh the id_capbanhanh of this vanbanphapquy
	 */
	@Override
	public void setId_capbanhanh(long id_capbanhanh) {
		model.setId_capbanhanh(id_capbanhanh);
	}

	/**
	 * Sets the id_coquanbanhanh of this vanbanphapquy.
	 *
	 * @param id_coquanbanhanh the id_coquanbanhanh of this vanbanphapquy
	 */
	@Override
	public void setId_coquanbanhanh(long id_coquanbanhanh) {
		model.setId_coquanbanhanh(id_coquanbanhanh);
	}

	/**
	 * Sets the id_linhvuc of this vanbanphapquy.
	 *
	 * @param id_linhvuc the id_linhvuc of this vanbanphapquy
	 */
	@Override
	public void setId_linhvuc(long id_linhvuc) {
		model.setId_linhvuc(id_linhvuc);
	}

	/**
	 * Sets the id_loaivanban of this vanbanphapquy.
	 *
	 * @param id_loaivanban the id_loaivanban of this vanbanphapquy
	 */
	@Override
	public void setId_loaivanban(long id_loaivanban) {
		model.setId_loaivanban(id_loaivanban);
	}

	/**
	 * Sets the ngay_banhanh of this vanbanphapquy.
	 *
	 * @param ngay_banhanh the ngay_banhanh of this vanbanphapquy
	 */
	@Override
	public void setNgay_banhanh(Date ngay_banhanh) {
		model.setNgay_banhanh(ngay_banhanh);
	}

	/**
	 * Sets the ngay_hethieuluc of this vanbanphapquy.
	 *
	 * @param ngay_hethieuluc the ngay_hethieuluc of this vanbanphapquy
	 */
	@Override
	public void setNgay_hethieuluc(Date ngay_hethieuluc) {
		model.setNgay_hethieuluc(ngay_hethieuluc);
	}

	/**
	 * Sets the ngay_hieuluc of this vanbanphapquy.
	 *
	 * @param ngay_hieuluc the ngay_hieuluc of this vanbanphapquy
	 */
	@Override
	public void setNgay_hieuluc(Date ngay_hieuluc) {
		model.setNgay_hieuluc(ngay_hieuluc);
	}

	/**
	 * Sets the ngay_xuatban of this vanbanphapquy.
	 *
	 * @param ngay_xuatban the ngay_xuatban of this vanbanphapquy
	 */
	@Override
	public void setNgay_xuatban(Date ngay_xuatban) {
		model.setNgay_xuatban(ngay_xuatban);
	}

	/**
	 * Sets the nguoiky of this vanbanphapquy.
	 *
	 * @param nguoiky the nguoiky of this vanbanphapquy
	 */
	@Override
	public void setNguoiky(String nguoiky) {
		model.setNguoiky(nguoiky);
	}

	/**
	 * Sets the noidung of this vanbanphapquy.
	 *
	 * @param noidung the noidung of this vanbanphapquy
	 */
	@Override
	public void setNoidung(String noidung) {
		model.setNoidung(noidung);
	}

	/**
	 * Sets the primary key of this vanbanphapquy.
	 *
	 * @param primaryKey the primary key of this vanbanphapquy
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sohieu of this vanbanphapquy.
	 *
	 * @param sohieu the sohieu of this vanbanphapquy
	 */
	@Override
	public void setSohieu(String sohieu) {
		model.setSohieu(sohieu);
	}

	/**
	 * Sets the status of this vanbanphapquy.
	 *
	 * @param status the status of this vanbanphapquy
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the trichyeu of this vanbanphapquy.
	 *
	 * @param trichyeu the trichyeu of this vanbanphapquy
	 */
	@Override
	public void setTrichyeu(String trichyeu) {
		model.setTrichyeu(trichyeu);
	}

	/**
	 * Sets the type of this vanbanphapquy.
	 *
	 * @param type the type of this vanbanphapquy
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	@Override
	protected VanbanphapquyWrapper wrap(Vanbanphapquy vanbanphapquy) {
		return new VanbanphapquyWrapper(vanbanphapquy);
	}

}