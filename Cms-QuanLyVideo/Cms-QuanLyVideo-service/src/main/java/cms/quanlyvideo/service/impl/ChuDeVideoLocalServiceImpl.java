/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.impl;

import cms.quanlyvideo.model.ChuDe;
import cms.quanlyvideo.model.ChuDeVideo;
import cms.quanlyvideo.service.ChuDeLocalServiceUtil;
import cms.quanlyvideo.service.base.ChuDeVideoLocalServiceBaseImpl;
import cms.quanlyvideo.service.persistence.ChuDeVideoPersistence;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=cms.quanlyvideo.model.ChuDeVideo",
	service = AopService.class
)

public class ChuDeVideoLocalServiceImpl extends ChuDeVideoLocalServiceBaseImpl {
	public List<ChuDeVideo> findChuDeVideoByVideoId(long video_id) {
		return chuDeVideoPersistence.findByvideoId(video_id);
	}
	public List<ChuDeVideo> findChuDeVideoByChuDeId(long chude_id) {
		return chuDeVideoPersistence.findBychudeId(chude_id);
	}
}