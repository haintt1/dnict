/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GopY_DinhKem}.
 * </p>
 *
 * @author dnict
 * @see GopY_DinhKem
 * @generated
 */
public class GopY_DinhKemWrapper
	extends BaseModelWrapper<GopY_DinhKem>
	implements GopY_DinhKem, ModelWrapper<GopY_DinhKem> {

	public GopY_DinhKemWrapper(GopY_DinhKem gopY_DinhKem) {
		super(gopY_DinhKem);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("ten", getTen());
		attributes.put("url", getUrl());
		attributes.put("Object", getObject());
		attributes.put("ObjectId", getObjectId());
		attributes.put("ghichu", getGhichu());
		attributes.put("daxoa", getDaxoa());
		attributes.put("status", getStatus());

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

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long Object = (Long)attributes.get("Object");

		if (Object != null) {
			setObject(Object);
		}

		Long ObjectId = (Long)attributes.get("ObjectId");

		if (ObjectId != null) {
			setObjectId(ObjectId);
		}

		String ghichu = (String)attributes.get("ghichu");

		if (ghichu != null) {
			setGhichu(ghichu);
		}

		Integer daxoa = (Integer)attributes.get("daxoa");

		if (daxoa != null) {
			setDaxoa(daxoa);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this gop y_ dinh kem.
	 *
	 * @return the company ID of this gop y_ dinh kem
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the daxoa of this gop y_ dinh kem.
	 *
	 * @return the daxoa of this gop y_ dinh kem
	 */
	@Override
	public int getDaxoa() {
		return model.getDaxoa();
	}

	/**
	 * Returns the ghichu of this gop y_ dinh kem.
	 *
	 * @return the ghichu of this gop y_ dinh kem
	 */
	@Override
	public String getGhichu() {
		return model.getGhichu();
	}

	/**
	 * Returns the group ID of this gop y_ dinh kem.
	 *
	 * @return the group ID of this gop y_ dinh kem
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this gop y_ dinh kem.
	 *
	 * @return the ID of this gop y_ dinh kem
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the object of this gop y_ dinh kem.
	 *
	 * @return the object of this gop y_ dinh kem
	 */
	@Override
	public long getObject() {
		return model.getObject();
	}

	/**
	 * Returns the object ID of this gop y_ dinh kem.
	 *
	 * @return the object ID of this gop y_ dinh kem
	 */
	@Override
	public long getObjectId() {
		return model.getObjectId();
	}

	/**
	 * Returns the primary key of this gop y_ dinh kem.
	 *
	 * @return the primary key of this gop y_ dinh kem
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this gop y_ dinh kem.
	 *
	 * @return the status of this gop y_ dinh kem
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ten of this gop y_ dinh kem.
	 *
	 * @return the ten of this gop y_ dinh kem
	 */
	@Override
	public String getTen() {
		return model.getTen();
	}

	/**
	 * Returns the url of this gop y_ dinh kem.
	 *
	 * @return the url of this gop y_ dinh kem
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this gop y_ dinh kem.
	 *
	 * @return the user ID of this gop y_ dinh kem
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this gop y_ dinh kem.
	 *
	 * @return the user uuid of this gop y_ dinh kem
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
	 * Sets the company ID of this gop y_ dinh kem.
	 *
	 * @param companyId the company ID of this gop y_ dinh kem
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the daxoa of this gop y_ dinh kem.
	 *
	 * @param daxoa the daxoa of this gop y_ dinh kem
	 */
	@Override
	public void setDaxoa(int daxoa) {
		model.setDaxoa(daxoa);
	}

	/**
	 * Sets the ghichu of this gop y_ dinh kem.
	 *
	 * @param ghichu the ghichu of this gop y_ dinh kem
	 */
	@Override
	public void setGhichu(String ghichu) {
		model.setGhichu(ghichu);
	}

	/**
	 * Sets the group ID of this gop y_ dinh kem.
	 *
	 * @param groupId the group ID of this gop y_ dinh kem
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this gop y_ dinh kem.
	 *
	 * @param id the ID of this gop y_ dinh kem
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the object of this gop y_ dinh kem.
	 *
	 * @param Object the object of this gop y_ dinh kem
	 */
	@Override
	public void setObject(long Object) {
		model.setObject(Object);
	}

	/**
	 * Sets the object ID of this gop y_ dinh kem.
	 *
	 * @param ObjectId the object ID of this gop y_ dinh kem
	 */
	@Override
	public void setObjectId(long ObjectId) {
		model.setObjectId(ObjectId);
	}

	/**
	 * Sets the primary key of this gop y_ dinh kem.
	 *
	 * @param primaryKey the primary key of this gop y_ dinh kem
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this gop y_ dinh kem.
	 *
	 * @param status the status of this gop y_ dinh kem
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ten of this gop y_ dinh kem.
	 *
	 * @param ten the ten of this gop y_ dinh kem
	 */
	@Override
	public void setTen(String ten) {
		model.setTen(ten);
	}

	/**
	 * Sets the url of this gop y_ dinh kem.
	 *
	 * @param url the url of this gop y_ dinh kem
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this gop y_ dinh kem.
	 *
	 * @param userId the user ID of this gop y_ dinh kem
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this gop y_ dinh kem.
	 *
	 * @param userUuid the user uuid of this gop y_ dinh kem
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected GopY_DinhKemWrapper wrap(GopY_DinhKem gopY_DinhKem) {
		return new GopY_DinhKemWrapper(gopY_DinhKem);
	}

}