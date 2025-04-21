/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link HoiDapGopY}.
 * </p>
 *
 * @author dnict
 * @see HoiDapGopY
 * @generated
 */
public class HoiDapGopYWrapper
	extends BaseModelWrapper<HoiDapGopY>
	implements HoiDapGopY, ModelWrapper<HoiDapGopY> {

	public HoiDapGopYWrapper(HoiDapGopY hoiDapGopY) {
		super(hoiDapGopY);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("name", getName());
		attributes.put("tencoquan", getTencoquan());
		attributes.put("phone", getPhone());
		attributes.put("email", getEmail());
		attributes.put("title", getTitle());
		attributes.put("content", getContent());
		attributes.put("answer", getAnswer());
		attributes.put("ngay_guigopy", getNgay_guigopy());
		attributes.put("ngay_traloigopy", getNgay_traloigopy());
		attributes.put("typeForm", getTypeForm());
		attributes.put("is_traloi", getIs_traloi());
		attributes.put("is_pheduyet", getIs_pheduyet());

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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String tencoquan = (String)attributes.get("tencoquan");

		if (tencoquan != null) {
			setTencoquan(tencoquan);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String answer = (String)attributes.get("answer");

		if (answer != null) {
			setAnswer(answer);
		}

		Date ngay_guigopy = (Date)attributes.get("ngay_guigopy");

		if (ngay_guigopy != null) {
			setNgay_guigopy(ngay_guigopy);
		}

		Date ngay_traloigopy = (Date)attributes.get("ngay_traloigopy");

		if (ngay_traloigopy != null) {
			setNgay_traloigopy(ngay_traloigopy);
		}

		Integer typeForm = (Integer)attributes.get("typeForm");

		if (typeForm != null) {
			setTypeForm(typeForm);
		}

		Integer is_traloi = (Integer)attributes.get("is_traloi");

		if (is_traloi != null) {
			setIs_traloi(is_traloi);
		}

		Integer is_pheduyet = (Integer)attributes.get("is_pheduyet");

		if (is_pheduyet != null) {
			setIs_pheduyet(is_pheduyet);
		}
	}

	/**
	 * Returns the answer of this hoi dap gop y.
	 *
	 * @return the answer of this hoi dap gop y
	 */
	@Override
	public String getAnswer() {
		return model.getAnswer();
	}

	/**
	 * Returns the company ID of this hoi dap gop y.
	 *
	 * @return the company ID of this hoi dap gop y
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this hoi dap gop y.
	 *
	 * @return the content of this hoi dap gop y
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the email of this hoi dap gop y.
	 *
	 * @return the email of this hoi dap gop y
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this hoi dap gop y.
	 *
	 * @return the group ID of this hoi dap gop y
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this hoi dap gop y.
	 *
	 * @return the ID of this hoi dap gop y
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the is_pheduyet of this hoi dap gop y.
	 *
	 * @return the is_pheduyet of this hoi dap gop y
	 */
	@Override
	public int getIs_pheduyet() {
		return model.getIs_pheduyet();
	}

	/**
	 * Returns the is_traloi of this hoi dap gop y.
	 *
	 * @return the is_traloi of this hoi dap gop y
	 */
	@Override
	public int getIs_traloi() {
		return model.getIs_traloi();
	}

	/**
	 * Returns the name of this hoi dap gop y.
	 *
	 * @return the name of this hoi dap gop y
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the ngay_guigopy of this hoi dap gop y.
	 *
	 * @return the ngay_guigopy of this hoi dap gop y
	 */
	@Override
	public Date getNgay_guigopy() {
		return model.getNgay_guigopy();
	}

	/**
	 * Returns the ngay_traloigopy of this hoi dap gop y.
	 *
	 * @return the ngay_traloigopy of this hoi dap gop y
	 */
	@Override
	public Date getNgay_traloigopy() {
		return model.getNgay_traloigopy();
	}

	/**
	 * Returns the phone of this hoi dap gop y.
	 *
	 * @return the phone of this hoi dap gop y
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the primary key of this hoi dap gop y.
	 *
	 * @return the primary key of this hoi dap gop y
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the tencoquan of this hoi dap gop y.
	 *
	 * @return the tencoquan of this hoi dap gop y
	 */
	@Override
	public String getTencoquan() {
		return model.getTencoquan();
	}

	/**
	 * Returns the title of this hoi dap gop y.
	 *
	 * @return the title of this hoi dap gop y
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the type form of this hoi dap gop y.
	 *
	 * @return the type form of this hoi dap gop y
	 */
	@Override
	public int getTypeForm() {
		return model.getTypeForm();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the answer of this hoi dap gop y.
	 *
	 * @param answer the answer of this hoi dap gop y
	 */
	@Override
	public void setAnswer(String answer) {
		model.setAnswer(answer);
	}

	/**
	 * Sets the company ID of this hoi dap gop y.
	 *
	 * @param companyId the company ID of this hoi dap gop y
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this hoi dap gop y.
	 *
	 * @param content the content of this hoi dap gop y
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the email of this hoi dap gop y.
	 *
	 * @param email the email of this hoi dap gop y
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this hoi dap gop y.
	 *
	 * @param groupId the group ID of this hoi dap gop y
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this hoi dap gop y.
	 *
	 * @param id the ID of this hoi dap gop y
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the is_pheduyet of this hoi dap gop y.
	 *
	 * @param is_pheduyet the is_pheduyet of this hoi dap gop y
	 */
	@Override
	public void setIs_pheduyet(int is_pheduyet) {
		model.setIs_pheduyet(is_pheduyet);
	}

	/**
	 * Sets the is_traloi of this hoi dap gop y.
	 *
	 * @param is_traloi the is_traloi of this hoi dap gop y
	 */
	@Override
	public void setIs_traloi(int is_traloi) {
		model.setIs_traloi(is_traloi);
	}

	/**
	 * Sets the name of this hoi dap gop y.
	 *
	 * @param name the name of this hoi dap gop y
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the ngay_guigopy of this hoi dap gop y.
	 *
	 * @param ngay_guigopy the ngay_guigopy of this hoi dap gop y
	 */
	@Override
	public void setNgay_guigopy(Date ngay_guigopy) {
		model.setNgay_guigopy(ngay_guigopy);
	}

	/**
	 * Sets the ngay_traloigopy of this hoi dap gop y.
	 *
	 * @param ngay_traloigopy the ngay_traloigopy of this hoi dap gop y
	 */
	@Override
	public void setNgay_traloigopy(Date ngay_traloigopy) {
		model.setNgay_traloigopy(ngay_traloigopy);
	}

	/**
	 * Sets the phone of this hoi dap gop y.
	 *
	 * @param phone the phone of this hoi dap gop y
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the primary key of this hoi dap gop y.
	 *
	 * @param primaryKey the primary key of this hoi dap gop y
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the tencoquan of this hoi dap gop y.
	 *
	 * @param tencoquan the tencoquan of this hoi dap gop y
	 */
	@Override
	public void setTencoquan(String tencoquan) {
		model.setTencoquan(tencoquan);
	}

	/**
	 * Sets the title of this hoi dap gop y.
	 *
	 * @param title the title of this hoi dap gop y
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the type form of this hoi dap gop y.
	 *
	 * @param typeForm the type form of this hoi dap gop y
	 */
	@Override
	public void setTypeForm(int typeForm) {
		model.setTypeForm(typeForm);
	}

	@Override
	protected HoiDapGopYWrapper wrap(HoiDapGopY hoiDapGopY) {
		return new HoiDapGopYWrapper(hoiDapGopY);
	}

}