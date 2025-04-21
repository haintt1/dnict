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
 * This class is a wrapper for {@link Video}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Video
 * @generated
 */
public class VideoWrapper
	extends BaseModelWrapper<Video> implements ModelWrapper<Video>, Video {

	public VideoWrapper(Video video) {
		super(video);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("ten", getTen());
		attributes.put("moTa", getMoTa());
		attributes.put("noiDung", getNoiDung());
		attributes.put("duongDan", getDuongDan());
		attributes.put("luotXem", getLuotXem());
		attributes.put("luotThich", getLuotThich());
		attributes.put("tuKhoa", getTuKhoa());
		attributes.put("choBinhLuan", getChoBinhLuan());
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
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

		String noiDung = (String)attributes.get("noiDung");

		if (noiDung != null) {
			setNoiDung(noiDung);
		}

		String duongDan = (String)attributes.get("duongDan");

		if (duongDan != null) {
			setDuongDan(duongDan);
		}

		Long luotXem = (Long)attributes.get("luotXem");

		if (luotXem != null) {
			setLuotXem(luotXem);
		}

		Long luotThich = (Long)attributes.get("luotThich");

		if (luotThich != null) {
			setLuotThich(luotThich);
		}

		String tuKhoa = (String)attributes.get("tuKhoa");

		if (tuKhoa != null) {
			setTuKhoa(tuKhoa);
		}

		Long choBinhLuan = (Long)attributes.get("choBinhLuan");

		if (choBinhLuan != null) {
			setChoBinhLuan(choBinhLuan);
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
	 * Returns the cho binh luan of this video.
	 *
	 * @return the cho binh luan of this video
	 */
	@Override
	public long getChoBinhLuan() {
		return model.getChoBinhLuan();
	}

	/**
	 * Returns the company ID of this video.
	 *
	 * @return the company ID of this video
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the da xoa of this video.
	 *
	 * @return the da xoa of this video
	 */
	@Override
	public long getDaXoa() {
		return model.getDaXoa();
	}

	/**
	 * Returns the duong dan of this video.
	 *
	 * @return the duong dan of this video
	 */
	@Override
	public String getDuongDan() {
		return model.getDuongDan();
	}

	/**
	 * Returns the group ID of this video.
	 *
	 * @return the group ID of this video
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this video.
	 *
	 * @return the ID of this video
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the luot thich of this video.
	 *
	 * @return the luot thich of this video
	 */
	@Override
	public long getLuotThich() {
		return model.getLuotThich();
	}

	/**
	 * Returns the luot xem of this video.
	 *
	 * @return the luot xem of this video
	 */
	@Override
	public long getLuotXem() {
		return model.getLuotXem();
	}

	/**
	 * Returns the mo ta of this video.
	 *
	 * @return the mo ta of this video
	 */
	@Override
	public String getMoTa() {
		return model.getMoTa();
	}

	/**
	 * Returns the ngay sua of this video.
	 *
	 * @return the ngay sua of this video
	 */
	@Override
	public Date getNgaySua() {
		return model.getNgaySua();
	}

	/**
	 * Returns the ngay tao of this video.
	 *
	 * @return the ngay tao of this video
	 */
	@Override
	public Date getNgayTao() {
		return model.getNgayTao();
	}

	/**
	 * Returns the noi dung of this video.
	 *
	 * @return the noi dung of this video
	 */
	@Override
	public String getNoiDung() {
		return model.getNoiDung();
	}

	/**
	 * Returns the primary key of this video.
	 *
	 * @return the primary key of this video
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ten of this video.
	 *
	 * @return the ten of this video
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the trang thai of this video.
	 *
	 * @return the trang thai of this video
	 */
	@Override
	public long getTrangThai() {
		return model.getTrangThai();
	}

	/**
	 * Returns the tu khoa of this video.
	 *
	 * @return the tu khoa of this video
	 */
	@Override
	public String getTuKhoa() {
		return model.getTuKhoa();
	}

	/**
	 * Returns the user ID of this video.
	 *
	 * @return the user ID of this video
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this video.
	 *
	 * @return the user uuid of this video
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
	 * Sets the cho binh luan of this video.
	 *
	 * @param choBinhLuan the cho binh luan of this video
	 */
	@Override
	public void setChoBinhLuan(long choBinhLuan) {
		model.setChoBinhLuan(choBinhLuan);
	}

	/**
	 * Sets the company ID of this video.
	 *
	 * @param companyId the company ID of this video
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the da xoa of this video.
	 *
	 * @param daXoa the da xoa of this video
	 */
	@Override
	public void setDaXoa(long daXoa) {
		model.setDaXoa(daXoa);
	}

	/**
	 * Sets the duong dan of this video.
	 *
	 * @param duongDan the duong dan of this video
	 */
	@Override
	public void setDuongDan(String duongDan) {
		model.setDuongDan(duongDan);
	}

	/**
	 * Sets the group ID of this video.
	 *
	 * @param groupId the group ID of this video
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this video.
	 *
	 * @param id the ID of this video
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the luot thich of this video.
	 *
	 * @param luotThich the luot thich of this video
	 */
	@Override
	public void setLuotThich(long luotThich) {
		model.setLuotThich(luotThich);
	}

	/**
	 * Sets the luot xem of this video.
	 *
	 * @param luotXem the luot xem of this video
	 */
	@Override
	public void setLuotXem(long luotXem) {
		model.setLuotXem(luotXem);
	}

	/**
	 * Sets the mo ta of this video.
	 *
	 * @param moTa the mo ta of this video
	 */
	@Override
	public void setMoTa(String moTa) {
		model.setMoTa(moTa);
	}

	/**
	 * Sets the ngay sua of this video.
	 *
	 * @param ngaySua the ngay sua of this video
	 */
	@Override
	public void setNgaySua(Date ngaySua) {
		model.setNgaySua(ngaySua);
	}

	/**
	 * Sets the ngay tao of this video.
	 *
	 * @param ngayTao the ngay tao of this video
	 */
	@Override
	public void setNgayTao(Date ngayTao) {
		model.setNgayTao(ngayTao);
	}

	/**
	 * Sets the noi dung of this video.
	 *
	 * @param noiDung the noi dung of this video
	 */
	@Override
	public void setNoiDung(String noiDung) {
		model.setNoiDung(noiDung);
	}

	/**
	 * Sets the primary key of this video.
	 *
	 * @param primaryKey the primary key of this video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ten of this video.
	 *
	 * @param ten the ten of this video
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the trang thai of this video.
	 *
	 * @param trangThai the trang thai of this video
	 */
	@Override
	public void setTrangThai(long trangThai) {
		model.setTrangThai(trangThai);
	}

	/**
	 * Sets the tu khoa of this video.
	 *
	 * @param tuKhoa the tu khoa of this video
	 */
	@Override
	public void setTuKhoa(String tuKhoa) {
		model.setTuKhoa(tuKhoa);
	}

	/**
	 * Sets the user ID of this video.
	 *
	 * @param userId the user ID of this video
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this video.
	 *
	 * @param userUuid the user uuid of this video
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected VideoWrapper wrap(Video video) {
		return new VideoWrapper(video);
	}

}