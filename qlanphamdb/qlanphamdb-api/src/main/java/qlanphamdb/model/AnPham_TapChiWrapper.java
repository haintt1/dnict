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
 * This class is a wrapper for {@link AnPham_TapChi}.
 * </p>
 *
 * @author dnict
 * @see AnPham_TapChi
 * @generated
 */
public class AnPham_TapChiWrapper
	extends BaseModelWrapper<AnPham_TapChi>
	implements AnPham_TapChi, ModelWrapper<AnPham_TapChi> {

	public AnPham_TapChiWrapper(AnPham_TapChi anPham_TapChi) {
		super(anPham_TapChi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("ten", getTen());
		attributes.put("slug", getSlug());
		attributes.put("moTa", getMoTa());
		attributes.put("anhDaiDien", getAnhDaiDien());
		attributes.put("loaiId", getLoaiId());
		attributes.put("deCuongId", getDeCuongId());
		attributes.put("noiDung", getNoiDung());
		attributes.put("tuKhoa", getTuKhoa());
		attributes.put("phienBan", getPhienBan());
		attributes.put("luotXem", getLuotXem());
		attributes.put("nguoiTao", getNguoiTao());
		attributes.put("ngayTao", getNgayTao());
		attributes.put("nguoiSua", getNguoiSua());
		attributes.put("ngaySua", getNgaySua());
		attributes.put("nguoiNhan", getNguoiNhan());
		attributes.put("nguoiXuLy", getNguoiXuLy());
		attributes.put("ngayXuLy", getNgayXuLy());
		attributes.put("language", getLanguage());
		attributes.put("loaiTin", getLoaiTin());
		attributes.put("isFormHienBinhLuan", getIsFormHienBinhLuan());
		attributes.put("isFormViewBinhLuan", getIsFormViewBinhLuan());
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

		String slug = (String)attributes.get("slug");

		if (slug != null) {
			setSlug(slug);
		}

		String moTa = (String)attributes.get("moTa");

		if (moTa != null) {
			setMoTa(moTa);
		}

		String anhDaiDien = (String)attributes.get("anhDaiDien");

		if (anhDaiDien != null) {
			setAnhDaiDien(anhDaiDien);
		}

		Long loaiId = (Long)attributes.get("loaiId");

		if (loaiId != null) {
			setLoaiId(loaiId);
		}

		Long deCuongId = (Long)attributes.get("deCuongId");

		if (deCuongId != null) {
			setDeCuongId(deCuongId);
		}

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		String tuKhoa = (String)attributes.get("tuKhoa");

		if (tuKhoa != null) {
			setTuKhoa(tuKhoa);
		}

		Long phienBan = (Long)attributes.get("phienBan");

		if (phienBan != null) {
			setPhienBan(phienBan);
		}

		Long luotXem = (Long)attributes.get("luotXem");

		if (luotXem != null) {
			setLuotXem(luotXem);
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

		Integer loaiTin = (Integer)attributes.get("loaiTin");

		if (loaiTin != null) {
			setLoaiTin(loaiTin);
		}

		Integer isFormHienBinhLuan = (Integer)attributes.get(
			"isFormHienBinhLuan");

		if (isFormHienBinhLuan != null) {
			setIsFormHienBinhLuan(isFormHienBinhLuan);
		}

		Integer isFormViewBinhLuan = (Integer)attributes.get(
			"isFormViewBinhLuan");

		if (isFormViewBinhLuan != null) {
			setIsFormViewBinhLuan(isFormViewBinhLuan);
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
	 * Returns the anh dai dien of this an pham_ tap chi.
	 *
	 * @return the anh dai dien of this an pham_ tap chi
	 */
	@Override
	public String getAnhDaiDien() {
		return model.getAnhDaiDien();
	}

	/**
	 * Returns the company ID of this an pham_ tap chi.
	 *
	 * @return the company ID of this an pham_ tap chi
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the de cuong ID of this an pham_ tap chi.
	 *
	 * @return the de cuong ID of this an pham_ tap chi
	 */
	@Override
	public long getDeCuongId() {
		return model.getDeCuongId();
	}

	/**
	 * Returns the delete_status of this an pham_ tap chi.
	 *
	 * @return the delete_status of this an pham_ tap chi
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this an pham_ tap chi.
	 *
	 * @return the group ID of this an pham_ tap chi
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this an pham_ tap chi.
	 *
	 * @return the ID of this an pham_ tap chi
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is form hien binh luan of this an pham_ tap chi.
	 *
	 * @return the is form hien binh luan of this an pham_ tap chi
	 */
	@Override
	public int getIsFormHienBinhLuan() {
		return model.getIsFormHienBinhLuan();
	}

	/**
	 * Returns the is form view binh luan of this an pham_ tap chi.
	 *
	 * @return the is form view binh luan of this an pham_ tap chi
	 */
	@Override
	public int getIsFormViewBinhLuan() {
		return model.getIsFormViewBinhLuan();
	}

	/**
	 * Returns the language of this an pham_ tap chi.
	 *
	 * @return the language of this an pham_ tap chi
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the loai ID of this an pham_ tap chi.
	 *
	 * @return the loai ID of this an pham_ tap chi
	 */
	@Override
	public long getLoaiId() {
		return model.getLoaiId();
	}

	/**
	 * Returns the loai tin of this an pham_ tap chi.
	 *
	 * @return the loai tin of this an pham_ tap chi
	 */
	@Override
	public int getLoaiTin() {
		return model.getLoaiTin();
	}

	/**
	 * Returns the luot xem of this an pham_ tap chi.
	 *
	 * @return the luot xem of this an pham_ tap chi
	 */
	@Override
	public long getLuotXem() {
		return model.getLuotXem();
	}

	/**
	 * Returns the mo ta of this an pham_ tap chi.
	 *
	 * @return the mo ta of this an pham_ tap chi
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this an pham_ tap chi.
	 *
	 * @return the ngay sua of this an pham_ tap chi
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this an pham_ tap chi.
	 *
	 * @return the ngay tao of this an pham_ tap chi
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the ngay xu ly of this an pham_ tap chi.
	 *
	 * @return the ngay xu ly of this an pham_ tap chi
	 */
	@Override
	public Date getNgayXuLy() {
		return model.getNgayXuLy();
	}

	/**
	 * Returns the nguoi nhan of this an pham_ tap chi.
	 *
	 * @return the nguoi nhan of this an pham_ tap chi
	 */
	@Override
	public long getNguoiNhan() {
		return model.getNguoiNhan();
	}

	/**
	 * Returns the nguoi sua of this an pham_ tap chi.
	 *
	 * @return the nguoi sua of this an pham_ tap chi
	 */
	@Override
	public long getNguoiSua() {
		return model.getNguoiSua();
	}

	/**
	 * Returns the nguoi tao of this an pham_ tap chi.
	 *
	 * @return the nguoi tao of this an pham_ tap chi
	 */
	@Override
	public long getNguoiTao() {
		return model.getNguoiTao();
	}

	/**
	 * Returns the nguoi xu ly of this an pham_ tap chi.
	 *
	 * @return the nguoi xu ly of this an pham_ tap chi
	 */
	@Override
	public long getNguoiXuLy() {
		return model.getNguoiXuLy();
	}

	/**
	 * Returns the noi dung of this an pham_ tap chi.
	 *
	 * @return the noi dung of this an pham_ tap chi
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the orders of this an pham_ tap chi.
	 *
	 * @return the orders of this an pham_ tap chi
	 */
	@Override
	public long getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the phien ban of this an pham_ tap chi.
	 *
	 * @return the phien ban of this an pham_ tap chi
	 */
	@Override
	public long getPhienBan() {
		return model.getPhienBan();
	}

	/**
	 * Returns the primary key of this an pham_ tap chi.
	 *
	 * @return the primary key of this an pham_ tap chi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the slug of this an pham_ tap chi.
	 *
	 * @return the slug of this an pham_ tap chi
	 */
	@Override
	public String getSlug() {
		return model.getSlug();
	}

	/**
	 * Returns the status of this an pham_ tap chi.
	 *
	 * @return the status of this an pham_ tap chi
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this an pham_ tap chi.
	 *
	 * @return the ten of this an pham_ tap chi
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tu khoa of this an pham_ tap chi.
	 *
	 * @return the tu khoa of this an pham_ tap chi
	 */
	@Override
	public String getTuKhoa() {
		return model.getTuKhoa();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the anh dai dien of this an pham_ tap chi.
	 *
	 * @param anhDaiDien the anh dai dien of this an pham_ tap chi
	 */
	@Override
	public void setAnhDaiDien(String anhDaiDien) {
		model.setAnhDaiDien(anhDaiDien);
	}

	/**
	 * Sets the company ID of this an pham_ tap chi.
	 *
	 * @param companyId the company ID of this an pham_ tap chi
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the de cuong ID of this an pham_ tap chi.
	 *
	 * @param deCuongId the de cuong ID of this an pham_ tap chi
	 */
	@Override
	public void setDeCuongId(long deCuongId) {
		model.setDeCuongId(deCuongId);
	}

	/**
	 * Sets the delete_status of this an pham_ tap chi.
	 *
	 * @param delete_status the delete_status of this an pham_ tap chi
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this an pham_ tap chi.
	 *
	 * @param groupId the group ID of this an pham_ tap chi
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this an pham_ tap chi.
	 *
	 * @param id the ID of this an pham_ tap chi
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is form hien binh luan of this an pham_ tap chi.
	 *
	 * @param isFormHienBinhLuan the is form hien binh luan of this an pham_ tap chi
	 */
	@Override
	public void setIsFormHienBinhLuan(int isFormHienBinhLuan) {
		model.setIsFormHienBinhLuan(isFormHienBinhLuan);
	}

	/**
	 * Sets the is form view binh luan of this an pham_ tap chi.
	 *
	 * @param isFormViewBinhLuan the is form view binh luan of this an pham_ tap chi
	 */
	@Override
	public void setIsFormViewBinhLuan(int isFormViewBinhLuan) {
		model.setIsFormViewBinhLuan(isFormViewBinhLuan);
	}

	/**
	 * Sets the language of this an pham_ tap chi.
	 *
	 * @param language the language of this an pham_ tap chi
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the loai ID of this an pham_ tap chi.
	 *
	 * @param loaiId the loai ID of this an pham_ tap chi
	 */
	@Override
	public void setLoaiId(long loaiId) {
		model.setLoaiId(loaiId);
	}

	/**
	 * Sets the loai tin of this an pham_ tap chi.
	 *
	 * @param loaiTin the loai tin of this an pham_ tap chi
	 */
	@Override
	public void setLoaiTin(int loaiTin) {
		model.setLoaiTin(loaiTin);
	}

	/**
	 * Sets the luot xem of this an pham_ tap chi.
	 *
	 * @param luotXem the luot xem of this an pham_ tap chi
	 */
	@Override
	public void setLuotXem(long luotXem) {
		model.setLuotXem(luotXem);
	}

	/**
	 * Sets the mo ta of this an pham_ tap chi.
	 *
	 * @param moTa the mo ta of this an pham_ tap chi
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this an pham_ tap chi.
	 *
	 * @param ngaySua the ngay sua of this an pham_ tap chi
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this an pham_ tap chi.
	 *
	 * @param ngayTao the ngay tao of this an pham_ tap chi
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the ngay xu ly of this an pham_ tap chi.
	 *
	 * @param ngayXuLy the ngay xu ly of this an pham_ tap chi
	 */
	@Override
	public void setNgayXuLy(Date ngayXuLy) {
		model.setNgayXuLy(ngayXuLy);
	}

	/**
	 * Sets the nguoi nhan of this an pham_ tap chi.
	 *
	 * @param nguoiNhan the nguoi nhan of this an pham_ tap chi
	 */
	@Override
	public void setNguoiNhan(long nguoiNhan) {
		model.setNguoiNhan(nguoiNhan);
	}

	/**
	 * Sets the nguoi sua of this an pham_ tap chi.
	 *
	 * @param nguoiSua the nguoi sua of this an pham_ tap chi
	 */
	@Override
	public void setNguoiSua(long nguoiSua) {
		model.setNguoiSua(nguoiSua);
	}

	/**
	 * Sets the nguoi tao of this an pham_ tap chi.
	 *
	 * @param nguoiTao the nguoi tao of this an pham_ tap chi
	 */
	@Override
	public void setNguoiTao(long nguoiTao) {
		model.setNguoiTao(nguoiTao);
	}

	/**
	 * Sets the nguoi xu ly of this an pham_ tap chi.
	 *
	 * @param nguoiXuLy the nguoi xu ly of this an pham_ tap chi
	 */
	@Override
	public void setNguoiXuLy(long nguoiXuLy) {
		model.setNguoiXuLy(nguoiXuLy);
	}

	/**
	 * Sets the noi dung of this an pham_ tap chi.
	 *
	 * @param noiDung the noi dung of this an pham_ tap chi
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the orders of this an pham_ tap chi.
	 *
	 * @param orders the orders of this an pham_ tap chi
	 */
	@Override
	public void setOrders(long orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the phien ban of this an pham_ tap chi.
	 *
	 * @param phienBan the phien ban of this an pham_ tap chi
	 */
	@Override
	public void setPhienBan(long phienBan) {
		model.setPhienBan(phienBan);
	}

	/**
	 * Sets the primary key of this an pham_ tap chi.
	 *
	 * @param primaryKey the primary key of this an pham_ tap chi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the slug of this an pham_ tap chi.
	 *
	 * @param slug the slug of this an pham_ tap chi
	 */
	@Override
	public void setSlug(String slug) {
		model.setSlug(slug);
	}

	/**
	 * Sets the status of this an pham_ tap chi.
	 *
	 * @param status the status of this an pham_ tap chi
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this an pham_ tap chi.
	 *
	 * @param ten the ten of this an pham_ tap chi
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tu khoa of this an pham_ tap chi.
	 *
	 * @param tuKhoa the tu khoa of this an pham_ tap chi
	 */
	@Override
	public void setTuKhoa(String tuKhoa) {
		model.setTuKhoa(tuKhoa);
	}

	@Override
	protected AnPham_TapChiWrapper wrap(AnPham_TapChi anPham_TapChi) {
		return new AnPham_TapChiWrapper(anPham_TapChi);
	}

}