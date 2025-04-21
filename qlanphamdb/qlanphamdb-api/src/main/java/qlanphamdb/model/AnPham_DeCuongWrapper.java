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
 * This class is a wrapper for {@link AnPham_DeCuong}.
 * </p>
 *
 * @author dnict
 * @see AnPham_DeCuong
 * @generated
 */
public class AnPham_DeCuongWrapper
	extends BaseModelWrapper<AnPham_DeCuong>
	implements AnPham_DeCuong, ModelWrapper<AnPham_DeCuong> {

	public AnPham_DeCuongWrapper(AnPham_DeCuong anPham_DeCuong) {
		super(anPham_DeCuong);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("loaiId", getLoaiId());
		attributes.put("noiDung", getNoiDung());
		attributes.put("phienBan", getPhienBan());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiNhan", getNguoiNhan());
		attributes.put("nguoiXuLy", getNguoiXuLy());
		attributes.put("ngayXuLy", getNgayXuLy());
		attributes.put("language", getLanguage());
		attributes.put("status", getStatus());
		attributes.put("orders", getOrders());
		attributes.put("delete_status", getDelete_status());

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

		String ten = (String)attributes.get("ten");

		if (ten != null) {
			setTen(ten);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		Long loaiId = (Long)attributes.get("loaiId");

		if (loaiId != null) {
			setLoaiId(loaiId);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		Long phienBan = (Long)attributes.get("phienBan");

		if (phienBan != null) {
			setPhienBan(phienBan);
		}

		Long nguoiTao = (Long)attributes.get("nguoiTao");

		if (nguoiTao != null) {
			setNguoiTao(nguoiTao);
		}

		Date ngayTao = (Date)attributes.get("ngayTao");

		if (ngayTao != null) {
			setNgayTao(ngayTao);
		}

		Long nguoiSua = (Long)attributes.get("nguoiSua");

		if (nguoiSua != null) {
			setNguoiSua(nguoiSua);
		}

		Date ngaySua = (Date)attributes.get("ngaySua");

		if (ngaySua != null) {
			setNgaySua(ngaySua);
		}

		Long nguoiNhan = (Long)attributes.get("nguoiNhan");

		if (nguoiNhan != null) {
			setNguoiNhan(nguoiNhan);
		}

		Long nguoiXuLy = (Long)attributes.get("nguoiXuLy");

		if (nguoiXuLy != null) {
			setNguoiXuLy(nguoiXuLy);
		}

		Date ngayXuLy = (Date)attributes.get("ngayXuLy");

		if (ngayXuLy != null) {
			setNgayXuLy(ngayXuLy);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long orders = (Long)attributes.get("orders");

		if (orders != null) {
			setOrders(orders);
		}

		Integer delete_status = (Integer)attributes.get("delete_status");

		if (delete_status != null) {
			setDelete_status(delete_status);
		}
	}

	/**
	 * Returns the company ID of this an pham_ de cuong.
	 *
	 * @return the company ID of this an pham_ de cuong
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this an pham_ de cuong.
	 *
	 * @return the delete_status of this an pham_ de cuong
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this an pham_ de cuong.
	 *
	 * @return the group ID of this an pham_ de cuong
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this an pham_ de cuong.
	 *
	 * @return the ID of this an pham_ de cuong
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the language of this an pham_ de cuong.
	 *
	 * @return the language of this an pham_ de cuong
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the loai ID of this an pham_ de cuong.
	 *
	 * @return the loai ID of this an pham_ de cuong
	 */
	@Override
	public long getLoaiId() {
		return model.getLoaiId();
	}

	/**
	 * Returns the mo ta of this an pham_ de cuong.
	 *
	 * @return the mo ta of this an pham_ de cuong
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this an pham_ de cuong.
	 *
	 * @return the ngay sua of this an pham_ de cuong
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this an pham_ de cuong.
	 *
	 * @return the ngay tao of this an pham_ de cuong
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the ngay xu ly of this an pham_ de cuong.
	 *
	 * @return the ngay xu ly of this an pham_ de cuong
	 */
	@Override
	public Date getNgayXuLy() {
		return model.getNgayXuLy();
	}

	/**
	 * Returns the nguoi nhan of this an pham_ de cuong.
	 *
	 * @return the nguoi nhan of this an pham_ de cuong
	 */
	@Override
	public long getNguoiNhan() {
		return model.getNguoiNhan();
	}

	/**
	 * Returns the nguoi sua of this an pham_ de cuong.
	 *
	 * @return the nguoi sua of this an pham_ de cuong
	 */
	@Override
	public long getNguoiSua() {
		return model.getNguoiSua();
	}

	/**
	 * Returns the nguoi tao of this an pham_ de cuong.
	 *
	 * @return the nguoi tao of this an pham_ de cuong
	 */
	@Override
	public long getNguoiTao() {
		return model.getNguoiTao();
	}

	/**
	 * Returns the nguoi xu ly of this an pham_ de cuong.
	 *
	 * @return the nguoi xu ly of this an pham_ de cuong
	 */
	@Override
	public long getNguoiXuLy() {
		return model.getNguoiXuLy();
	}

	/**
	 * Returns the noi dung of this an pham_ de cuong.
	 *
	 * @return the noi dung of this an pham_ de cuong
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the orders of this an pham_ de cuong.
	 *
	 * @return the orders of this an pham_ de cuong
	 */
	@Override
	public long getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the phien ban of this an pham_ de cuong.
	 *
	 * @return the phien ban of this an pham_ de cuong
	 */
	@Override
	public long getPhienBan() {
		return model.getPhienBan();
	}

	/**
	 * Returns the primary key of this an pham_ de cuong.
	 *
	 * @return the primary key of this an pham_ de cuong
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this an pham_ de cuong.
	 *
	 * @return the status of this an pham_ de cuong
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this an pham_ de cuong.
	 *
	 * @return the ten of this an pham_ de cuong
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this an pham_ de cuong.
	 *
	 * @param companyId the company ID of this an pham_ de cuong
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this an pham_ de cuong.
	 *
	 * @param delete_status the delete_status of this an pham_ de cuong
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this an pham_ de cuong.
	 *
	 * @param groupId the group ID of this an pham_ de cuong
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this an pham_ de cuong.
	 *
	 * @param id the ID of this an pham_ de cuong
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the language of this an pham_ de cuong.
	 *
	 * @param language the language of this an pham_ de cuong
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the loai ID of this an pham_ de cuong.
	 *
	 * @param loaiId the loai ID of this an pham_ de cuong
	 */
	@Override
	public void setLoaiId(long loaiId) {
		model.setLoaiId(loaiId);
	}

	/**
	 * Sets the mo ta of this an pham_ de cuong.
	 *
	 * @param moTa the mo ta of this an pham_ de cuong
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this an pham_ de cuong.
	 *
	 * @param ngaySua the ngay sua of this an pham_ de cuong
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this an pham_ de cuong.
	 *
	 * @param ngayTao the ngay tao of this an pham_ de cuong
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the ngay xu ly of this an pham_ de cuong.
	 *
	 * @param ngayXuLy the ngay xu ly of this an pham_ de cuong
	 */
	@Override
	public void setNgayXuLy(Date ngayXuLy) {
		model.setNgayXuLy(ngayXuLy);
	}

	/**
	 * Sets the nguoi nhan of this an pham_ de cuong.
	 *
	 * @param nguoiNhan the nguoi nhan of this an pham_ de cuong
	 */
	@Override
	public void setNguoiNhan(long nguoiNhan) {
		model.setNguoiNhan(nguoiNhan);
	}

	/**
	 * Sets the nguoi sua of this an pham_ de cuong.
	 *
	 * @param nguoiSua the nguoi sua of this an pham_ de cuong
	 */
	@Override
	public void setNguoiSua(long nguoiSua) {
		model.setNguoiSua(nguoiSua);
	}

	/**
	 * Sets the nguoi tao of this an pham_ de cuong.
	 *
	 * @param nguoiTao the nguoi tao of this an pham_ de cuong
	 */
	@Override
	public void setNguoiTao(long nguoiTao) {
		model.setNguoiTao(nguoiTao);
	}

	/**
	 * Sets the nguoi xu ly of this an pham_ de cuong.
	 *
	 * @param nguoiXuLy the nguoi xu ly of this an pham_ de cuong
	 */
	@Override
	public void setNguoiXuLy(long nguoiXuLy) {
		model.setNguoiXuLy(nguoiXuLy);
	}

	/**
	 * Sets the noi dung of this an pham_ de cuong.
	 *
	 * @param noiDung the noi dung of this an pham_ de cuong
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the orders of this an pham_ de cuong.
	 *
	 * @param orders the orders of this an pham_ de cuong
	 */
	@Override
	public void setOrders(long orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the phien ban of this an pham_ de cuong.
	 *
	 * @param phienBan the phien ban of this an pham_ de cuong
	 */
	@Override
	public void setPhienBan(long phienBan) {
		model.setPhienBan(phienBan);
	}

	/**
	 * Sets the primary key of this an pham_ de cuong.
	 *
	 * @param primaryKey the primary key of this an pham_ de cuong
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this an pham_ de cuong.
	 *
	 * @param status the status of this an pham_ de cuong
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this an pham_ de cuong.
	 *
	 * @param ten the ten of this an pham_ de cuong
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	@Override
	protected AnPham_DeCuongWrapper wrap(AnPham_DeCuong anPham_DeCuong) {
		return new AnPham_DeCuongWrapper(anPham_DeCuong);
	}

}