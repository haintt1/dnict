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

package vn.dnict.tintuc.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link News_Activity}.
 * </p>
 *
 * @author dnict
 * @see News_Activity
 * @generated
 */
public class News_ActivityWrapper
	extends BaseModelWrapper<News_Activity>
	implements ModelWrapper<News_Activity>, News_Activity {

	public News_ActivityWrapper(News_Activity news_Activity) {
		super(news_Activity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("id", getId());
		attributes.put("articleid", getArticleid());
		attributes.put("startuserid", getStartuserid());
		attributes.put("enduserid", getEnduserid());
		attributes.put("contentrequest", getContentrequest());
		attributes.put("statusofarticle", getStatusofarticle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long articleid = (Long)attributes.get("articleid");

		if (articleid != null) {
			setArticleid(articleid);
		}

		Long startuserid = (Long)attributes.get("startuserid");

		if (startuserid != null) {
			setStartuserid(startuserid);
		}

		Long enduserid = (Long)attributes.get("enduserid");

		if (enduserid != null) {
			setEnduserid(enduserid);
		}

		String contentrequest = (String)attributes.get("contentrequest");

		if (contentrequest != null) {
			setContentrequest(contentrequest);
		}

		Integer statusofarticle = (Integer)attributes.get("statusofarticle");

		if (statusofarticle != null) {
			setStatusofarticle(statusofarticle);
		}
	}

	/**
	 * Returns the articleid of this news_ activity.
	 *
	 * @return the articleid of this news_ activity
	 */
	@Override
	public long getArticleid() {
		return model.getArticleid();
	}

	/**
	 * Returns the company ID of this news_ activity.
	 *
	 * @return the company ID of this news_ activity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contentrequest of this news_ activity.
	 *
	 * @return the contentrequest of this news_ activity
	 */
	@Override
	public String getContentrequest() {
		return model.getContentrequest();
	}

	/**
	 * Returns the enduserid of this news_ activity.
	 *
	 * @return the enduserid of this news_ activity
	 */
	@Override
	public long getEnduserid() {
		return model.getEnduserid();
	}

	/**
	 * Returns the group ID of this news_ activity.
	 *
	 * @return the group ID of this news_ activity
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this news_ activity.
	 *
	 * @return the ID of this news_ activity
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this news_ activity.
	 *
	 * @return the primary key of this news_ activity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the startuserid of this news_ activity.
	 *
	 * @return the startuserid of this news_ activity
	 */
	@Override
	public long getStartuserid() {
		return model.getStartuserid();
	}

	/**
	 * Returns the statusofarticle of this news_ activity.
	 *
	 * @return the statusofarticle of this news_ activity
	 */
	@Override
	public int getStatusofarticle() {
		return model.getStatusofarticle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the articleid of this news_ activity.
	 *
	 * @param articleid the articleid of this news_ activity
	 */
	@Override
	public void setArticleid(long articleid) {
		model.setArticleid(articleid);
	}

	/**
	 * Sets the company ID of this news_ activity.
	 *
	 * @param companyId the company ID of this news_ activity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contentrequest of this news_ activity.
	 *
	 * @param contentrequest the contentrequest of this news_ activity
	 */
	@Override
	public void setContentrequest(String contentrequest) {
		model.setContentrequest(contentrequest);
	}

	/**
	 * Sets the enduserid of this news_ activity.
	 *
	 * @param enduserid the enduserid of this news_ activity
	 */
	@Override
	public void setEnduserid(long enduserid) {
		model.setEnduserid(enduserid);
	}

	/**
	 * Sets the group ID of this news_ activity.
	 *
	 * @param groupId the group ID of this news_ activity
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this news_ activity.
	 *
	 * @param id the ID of this news_ activity
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this news_ activity.
	 *
	 * @param primaryKey the primary key of this news_ activity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the startuserid of this news_ activity.
	 *
	 * @param startuserid the startuserid of this news_ activity
	 */
	@Override
	public void setStartuserid(long startuserid) {
		model.setStartuserid(startuserid);
	}

	/**
	 * Sets the statusofarticle of this news_ activity.
	 *
	 * @param statusofarticle the statusofarticle of this news_ activity
	 */
	@Override
	public void setStatusofarticle(int statusofarticle) {
		model.setStatusofarticle(statusofarticle);
	}

	@Override
	protected News_ActivityWrapper wrap(News_Activity news_Activity) {
		return new News_ActivityWrapper(news_Activity);
	}

}