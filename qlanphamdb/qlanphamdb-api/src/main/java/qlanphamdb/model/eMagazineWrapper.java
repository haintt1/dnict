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
 * This class is a wrapper for {@link eMagazine}.
 * </p>
 *
 * @author dnict
 * @see eMagazine
 * @generated
 */
public class eMagazineWrapper
	extends BaseModelWrapper<eMagazine>
	implements eMagazine, ModelWrapper<eMagazine> {

	public eMagazineWrapper(eMagazine eMagazine) {
		super(eMagazine);
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
		attributes.put("mauChuDao", getMauChuDao());
		attributes.put("hinhNen", getHinhNen());
		attributes.put("templateId", getTemplateId());
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

		String mauChuDao = (String)attributes.get("mauChuDao");

		if (mauChuDao != null) {
			setMauChuDao(mauChuDao);
		}

		String hinhNen = (String)attributes.get("hinhNen");

		if (hinhNen != null) {
			setHinhNen(hinhNen);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
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
	 * Returns the anh dai dien of this e magazine.
	 *
	 * @return the anh dai dien of this e magazine
	 */
	@Override
	public String getAnhDaiDien() {
		return model.getAnhDaiDien();
	}

	/**
	 * Returns the company ID of this e magazine.
	 *
	 * @return the company ID of this e magazine
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the delete_status of this e magazine.
	 *
	 * @return the delete_status of this e magazine
	 */
	@Override
	public int getDelete_status() {
		return model.getDelete_status();
	}

	/**
	 * Returns the group ID of this e magazine.
	 *
	 * @return the group ID of this e magazine
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hinh nen of this e magazine.
	 *
	 * @return the hinh nen of this e magazine
	 */
	@Override
	public String getHinhNen() {
		return model.getHinhNen();
	}

	/**
	 * Returns the ID of this e magazine.
	 *
	 * @return the ID of this e magazine
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is form hien binh luan of this e magazine.
	 *
	 * @return the is form hien binh luan of this e magazine
	 */
	@Override
	public int getIsFormHienBinhLuan() {
		return model.getIsFormHienBinhLuan();
	}

	/**
	 * Returns the is form view binh luan of this e magazine.
	 *
	 * @return the is form view binh luan of this e magazine
	 */
	@Override
	public int getIsFormViewBinhLuan() {
		return model.getIsFormViewBinhLuan();
	}

	/**
	 * Returns the language of this e magazine.
	 *
	 * @return the language of this e magazine
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the luot xem of this e magazine.
	 *
	 * @return the luot xem of this e magazine
	 */
	@Override
	public long getLuotXem() {
		return model.getLuotXem();
	}

	/**
	 * Returns the mau chu dao of this e magazine.
	 *
	 * @return the mau chu dao of this e magazine
	 */
	@Override
	public String getMauChuDao() {
		return model.getMauChuDao();
	}

	/**
	 * Returns the mo ta of this e magazine.
	 *
	 * @return the mo ta of this e magazine
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this e magazine.
	 *
	 * @return the ngay sua of this e magazine
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this e magazine.
	 *
	 * @return the ngay tao of this e magazine
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the ngay xu ly of this e magazine.
	 *
	 * @return the ngay xu ly of this e magazine
	 */
	@Override
	public Date getNgayXuLy() {
		return model.getNgayXuLy();
	}

	/**
	 * Returns the nguoi nhan of this e magazine.
	 *
	 * @return the nguoi nhan of this e magazine
	 */
	@Override
	public long getNguoiNhan() {
		return model.getNguoiNhan();
	}

	/**
	 * Returns the nguoi sua of this e magazine.
	 *
	 * @return the nguoi sua of this e magazine
	 */
	@Override
	public long getNguoiSua() {
		return model.getNguoiSua();
	}

	/**
	 * Returns the nguoi tao of this e magazine.
	 *
	 * @return the nguoi tao of this e magazine
	 */
	@Override
	public long getNguoiTao() {
		return model.getNguoiTao();
	}

	/**
	 * Returns the nguoi xu ly of this e magazine.
	 *
	 * @return the nguoi xu ly of this e magazine
	 */
	@Override
	public long getNguoiXuLy() {
		return model.getNguoiXuLy();
	}

	/**
	 * Returns the noi dung of this e magazine.
	 *
	 * @return the noi dung of this e magazine
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the orders of this e magazine.
	 *
	 * @return the orders of this e magazine
	 */
	@Override
	public long getOrders() {
		return model.getOrders();
	}

	/**
	 * Returns the phien ban of this e magazine.
	 *
	 * @return the phien ban of this e magazine
	 */
	@Override
	public long getPhienBan() {
		return model.getPhienBan();
	}

	/**
	 * Returns the primary key of this e magazine.
	 *
	 * @return the primary key of this e magazine
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the slug of this e magazine.
	 *
	 * @return the slug of this e magazine
	 */
	@Override
	public String getSlug() {
		return model.getSlug();
	}

	/**
	 * Returns the status of this e magazine.
	 *
	 * @return the status of this e magazine
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the template ID of this e magazine.
	 *
	 * @return the template ID of this e magazine
	 */
	@Override
	public long getTemplateId() {
		return model.getTemplateId();
	}

	/**
	 * Returns the ten of this e magazine.
	 *
	 * @return the ten of this e magazine
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the tu khoa of this e magazine.
	 *
	 * @return the tu khoa of this e magazine
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
	 * Sets the anh dai dien of this e magazine.
	 *
	 * @param anhDaiDien the anh dai dien of this e magazine
	 */
	@Override
	public void setAnhDaiDien(String anhDaiDien) {
		model.setAnhDaiDien(anhDaiDien);
	}

	/**
	 * Sets the company ID of this e magazine.
	 *
	 * @param companyId the company ID of this e magazine
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the delete_status of this e magazine.
	 *
	 * @param delete_status the delete_status of this e magazine
	 */
	@Override
	public void setDelete_status(int delete_status) {
		model.setDelete_status(delete_status);
	}

	/**
	 * Sets the group ID of this e magazine.
	 *
	 * @param groupId the group ID of this e magazine
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hinh nen of this e magazine.
	 *
	 * @param hinhNen the hinh nen of this e magazine
	 */
	@Override
	public void setHinhNen(String hinhNen) {
		model.setHinhNen(hinhNen);
	}

	/**
	 * Sets the ID of this e magazine.
	 *
	 * @param id the ID of this e magazine
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is form hien binh luan of this e magazine.
	 *
	 * @param isFormHienBinhLuan the is form hien binh luan of this e magazine
	 */
	@Override
	public void setIsFormHienBinhLuan(int isFormHienBinhLuan) {
		model.setIsFormHienBinhLuan(isFormHienBinhLuan);
	}

	/**
	 * Sets the is form view binh luan of this e magazine.
	 *
	 * @param isFormViewBinhLuan the is form view binh luan of this e magazine
	 */
	@Override
	public void setIsFormViewBinhLuan(int isFormViewBinhLuan) {
		model.setIsFormViewBinhLuan(isFormViewBinhLuan);
	}

	/**
	 * Sets the language of this e magazine.
	 *
	 * @param language the language of this e magazine
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the luot xem of this e magazine.
	 *
	 * @param luotXem the luot xem of this e magazine
	 */
	@Override
	public void setLuotXem(long luotXem) {
		model.setLuotXem(luotXem);
	}

	/**
	 * Sets the mau chu dao of this e magazine.
	 *
	 * @param mauChuDao the mau chu dao of this e magazine
	 */
	@Override
	public void setMauChuDao(String mauChuDao) {
		model.setMauChuDao(mauChuDao);
	}

	/**
	 * Sets the mo ta of this e magazine.
	 *
	 * @param moTa the mo ta of this e magazine
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this e magazine.
	 *
	 * @param ngaySua the ngay sua of this e magazine
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this e magazine.
	 *
	 * @param ngayTao the ngay tao of this e magazine
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the ngay xu ly of this e magazine.
	 *
	 * @param ngayXuLy the ngay xu ly of this e magazine
	 */
	@Override
	public void setNgayXuLy(Date ngayXuLy) {
		model.setNgayXuLy(ngayXuLy);
	}

	/**
	 * Sets the nguoi nhan of this e magazine.
	 *
	 * @param nguoiNhan the nguoi nhan of this e magazine
	 */
	@Override
	public void setNguoiNhan(long nguoiNhan) {
		model.setNguoiNhan(nguoiNhan);
	}

	/**
	 * Sets the nguoi sua of this e magazine.
	 *
	 * @param nguoiSua the nguoi sua of this e magazine
	 */
	@Override
	public void setNguoiSua(long nguoiSua) {
		model.setNguoiSua(nguoiSua);
	}

	/**
	 * Sets the nguoi tao of this e magazine.
	 *
	 * @param nguoiTao the nguoi tao of this e magazine
	 */
	@Override
	public void setNguoiTao(long nguoiTao) {
		model.setNguoiTao(nguoiTao);
	}

	/**
	 * Sets the nguoi xu ly of this e magazine.
	 *
	 * @param nguoiXuLy the nguoi xu ly of this e magazine
	 */
	@Override
	public void setNguoiXuLy(long nguoiXuLy) {
		model.setNguoiXuLy(nguoiXuLy);
	}

	/**
	 * Sets the noi dung of this e magazine.
	 *
	 * @param noiDung the noi dung of this e magazine
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the orders of this e magazine.
	 *
	 * @param orders the orders of this e magazine
	 */
	@Override
	public void setOrders(long orders) {
		model.setOrders(orders);
	}

	/**
	 * Sets the phien ban of this e magazine.
	 *
	 * @param phienBan the phien ban of this e magazine
	 */
	@Override
	public void setPhienBan(long phienBan) {
		model.setPhienBan(phienBan);
	}

	/**
	 * Sets the primary key of this e magazine.
	 *
	 * @param primaryKey the primary key of this e magazine
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the slug of this e magazine.
	 *
	 * @param slug the slug of this e magazine
	 */
	@Override
	public void setSlug(String slug) {
		model.setSlug(slug);
	}

	/**
	 * Sets the status of this e magazine.
	 *
	 * @param status the status of this e magazine
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the template ID of this e magazine.
	 *
	 * @param templateId the template ID of this e magazine
	 */
	@Override
	public void setTemplateId(long templateId) {
		model.setTemplateId(templateId);
	}

	/**
	 * Sets the ten of this e magazine.
	 *
	 * @param ten the ten of this e magazine
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the tu khoa of this e magazine.
	 *
	 * @param tuKhoa the tu khoa of this e magazine
	 */
	@Override
	public void setTuKhoa(String tuKhoa) {
		model.setTuKhoa(tuKhoa);
	}

	@Override
	protected eMagazineWrapper wrap(eMagazine eMagazine) {
		return new eMagazineWrapper(eMagazine);
	}

}