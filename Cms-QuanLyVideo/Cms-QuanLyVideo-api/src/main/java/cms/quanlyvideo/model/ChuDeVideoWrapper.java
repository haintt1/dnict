/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ChuDeVideo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideo
 * @generated
 */
public class ChuDeVideoWrapper
	extends BaseModelWrapper<ChuDeVideo>
	implements ChuDeVideo, ModelWrapper<ChuDeVideo> {

	public ChuDeVideoWrapper(ChuDeVideo chuDeVideo) {
		super(chuDeVideo);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("chude_id", getChude_id());
		attributes.put("video_id", getVideo_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long chude_id = (Long)attributes.get("chude_id");

		if (chude_id != null) {
			setChude_id(chude_id);
		}

		Long video_id = (Long)attributes.get("video_id");

		if (video_id != null) {
			setVideo_id(video_id);
		}
	}

	/**
	 * Returns the chude_id of this chu de video.
	 *
	 * @return the chude_id of this chu de video
	 */
	@Override
	public long getChude_id() {
		return model.getChude_id();
	}

	/**
	 * Returns the ID of this chu de video.
	 *
	 * @return the ID of this chu de video
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this chu de video.
	 *
	 * @return the primary key of this chu de video
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the video_id of this chu de video.
	 *
	 * @return the video_id of this chu de video
	 */
	@Override
	public long getVideo_id() {
		return model.getVideo_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the chude_id of this chu de video.
	 *
	 * @param chude_id the chude_id of this chu de video
	 */
	@Override
	public void setChude_id(long chude_id) {
		model.setChude_id(chude_id);
	}

	/**
	 * Sets the ID of this chu de video.
	 *
	 * @param id the ID of this chu de video
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this chu de video.
	 *
	 * @param primaryKey the primary key of this chu de video
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the video_id of this chu de video.
	 *
	 * @param video_id the video_id of this chu de video
	 */
	@Override
	public void setVideo_id(long video_id) {
		model.setVideo_id(video_id);
	}

	@Override
	protected ChuDeVideoWrapper wrap(ChuDeVideo chuDeVideo) {
		return new ChuDeVideoWrapper(chuDeVideo);
	}

}