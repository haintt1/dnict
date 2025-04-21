/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link cms.quanlyvideo.service.http.ChuDeVideoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ChuDeVideoSoap implements Serializable {

	public static ChuDeVideoSoap toSoapModel(ChuDeVideo model) {
		ChuDeVideoSoap soapModel = new ChuDeVideoSoap();

		soapModel.setId(model.getId());
		soapModel.setChude_id(model.getChude_id());
		soapModel.setVideo_id(model.getVideo_id());

		return soapModel;
	}

	public static ChuDeVideoSoap[] toSoapModels(ChuDeVideo[] models) {
		ChuDeVideoSoap[] soapModels = new ChuDeVideoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChuDeVideoSoap[][] toSoapModels(ChuDeVideo[][] models) {
		ChuDeVideoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChuDeVideoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChuDeVideoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChuDeVideoSoap[] toSoapModels(List<ChuDeVideo> models) {
		List<ChuDeVideoSoap> soapModels = new ArrayList<ChuDeVideoSoap>(
			models.size());

		for (ChuDeVideo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChuDeVideoSoap[soapModels.size()]);
	}

	public ChuDeVideoSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getChude_id() {
		return _chude_id;
	}

	public void setChude_id(long chude_id) {
		_chude_id = chude_id;
	}

	public long getVideo_id() {
		return _video_id;
	}

	public void setVideo_id(long video_id) {
		_video_id = video_id;
	}

	private long _id;
	private long _chude_id;
	private long _video_id;

}