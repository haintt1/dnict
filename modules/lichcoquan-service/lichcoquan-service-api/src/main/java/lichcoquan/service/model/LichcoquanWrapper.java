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

package lichcoquan.service.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Lichcoquan}.
 * </p>
 *
 * @author BinhNT
 * @see Lichcoquan
 * @generated
 */
public class LichcoquanWrapper
	extends BaseModelWrapper<Lichcoquan>
	implements Lichcoquan, ModelWrapper<Lichcoquan> {

	public LichcoquanWrapper(Lichcoquan lichcoquan) {
		super(lichcoquan);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lichCongtacId", getLichCongtacId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("content", getContent());
		attributes.put("createDate", getCreateDate());
		attributes.put("tungay", getTungay());
		attributes.put("denngay", getDenngay());
		attributes.put("trangthai", getTrangthai());
		attributes.put("banhanh", getBanhanh());
		attributes.put("tuan", getTuan());
		attributes.put("nam", getNam());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long lichCongtacId = (Long)attributes.get("lichCongtacId");

		if (lichCongtacId != null) {
			setLichCongtacId(lichCongtacId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date tungay = (Date)attributes.get("tungay");

		if (tungay != null) {
			setTungay(tungay);
		}

		Date denngay = (Date)attributes.get("denngay");

		if (denngay != null) {
			setDenngay(denngay);
		}

		Integer trangthai = (Integer)attributes.get("trangthai");

		if (trangthai != null) {
			setTrangthai(trangthai);
		}

		Integer banhanh = (Integer)attributes.get("banhanh");

		if (banhanh != null) {
			setBanhanh(banhanh);
		}

		Integer tuan = (Integer)attributes.get("tuan");

		if (tuan != null) {
			setTuan(tuan);
		}

		Integer nam = (Integer)attributes.get("nam");

		if (nam != null) {
			setNam(nam);
		}
	}

	/**
	 * Returns the banhanh of this lichcoquan.
	 *
	 * @return the banhanh of this lichcoquan
	 */
	@Override
	public int getBanhanh() {
		return model.getBanhanh();
	}

	/**
	 * Returns the company ID of this lichcoquan.
	 *
	 * @return the company ID of this lichcoquan
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this lichcoquan.
	 *
	 * @return the content of this lichcoquan
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this lichcoquan.
	 *
	 * @return the create date of this lichcoquan
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the denngay of this lichcoquan.
	 *
	 * @return the denngay of this lichcoquan
	 */
	@Override
	public Date getDenngay() {
		return model.getDenngay();
	}

	/**
	 * Returns the lich congtac ID of this lichcoquan.
	 *
	 * @return the lich congtac ID of this lichcoquan
	 */
	@Override
	public long getLichCongtacId() {
		return model.getLichCongtacId();
	}

	/**
	 * Returns the nam of this lichcoquan.
	 *
	 * @return the nam of this lichcoquan
	 */
	@Override
	public int getNam() {
		return model.getNam();
	}

	/**
	 * Returns the primary key of this lichcoquan.
	 *
	 * @return the primary key of this lichcoquan
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the trangthai of this lichcoquan.
	 *
	 * @return the trangthai of this lichcoquan
	 */
	@Override
	public int getTrangthai() {
		return model.getTrangthai();
	}

	/**
	 * Returns the tuan of this lichcoquan.
	 *
	 * @return the tuan of this lichcoquan
	 */
	@Override
	public int getTuan() {
		return model.getTuan();
	}

	/**
	 * Returns the tungay of this lichcoquan.
	 *
	 * @return the tungay of this lichcoquan
	 */
	@Override
	public Date getTungay() {
		return model.getTungay();
	}

	/**
	 * Returns the user ID of this lichcoquan.
	 *
	 * @return the user ID of this lichcoquan
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this lichcoquan.
	 *
	 * @return the user uuid of this lichcoquan
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
	 * Sets the banhanh of this lichcoquan.
	 *
	 * @param banhanh the banhanh of this lichcoquan
	 */
	@Override
	public void setBanhanh(int banhanh) {
		model.setBanhanh(banhanh);
	}

	/**
	 * Sets the company ID of this lichcoquan.
	 *
	 * @param companyId the company ID of this lichcoquan
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this lichcoquan.
	 *
	 * @param content the content of this lichcoquan
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this lichcoquan.
	 *
	 * @param createDate the create date of this lichcoquan
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the denngay of this lichcoquan.
	 *
	 * @param denngay the denngay of this lichcoquan
	 */
	@Override
	public void setDenngay(Date denngay) {
		model.setDenngay(denngay);
	}

	/**
	 * Sets the lich congtac ID of this lichcoquan.
	 *
	 * @param lichCongtacId the lich congtac ID of this lichcoquan
	 */
	@Override
	public void setLichCongtacId(long lichCongtacId) {
		model.setLichCongtacId(lichCongtacId);
	}

	/**
	 * Sets the nam of this lichcoquan.
	 *
	 * @param nam the nam of this lichcoquan
	 */
	@Override
	public void setNam(int nam) {
		model.setNam(nam);
	}

	/**
	 * Sets the primary key of this lichcoquan.
	 *
	 * @param primaryKey the primary key of this lichcoquan
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the trangthai of this lichcoquan.
	 *
	 * @param trangthai the trangthai of this lichcoquan
	 */
	@Override
	public void setTrangthai(int trangthai) {
		model.setTrangthai(trangthai);
	}

	/**
	 * Sets the tuan of this lichcoquan.
	 *
	 * @param tuan the tuan of this lichcoquan
	 */
	@Override
	public void setTuan(int tuan) {
		model.setTuan(tuan);
	}

	/**
	 * Sets the tungay of this lichcoquan.
	 *
	 * @param tungay the tungay of this lichcoquan
	 */
	@Override
	public void setTungay(Date tungay) {
		model.setTungay(tungay);
	}

	/**
	 * Sets the user ID of this lichcoquan.
	 *
	 * @param userId the user ID of this lichcoquan
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this lichcoquan.
	 *
	 * @param userUuid the user uuid of this lichcoquan
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected LichcoquanWrapper wrap(Lichcoquan lichcoquan) {
		return new LichcoquanWrapper(lichcoquan);
	}

}