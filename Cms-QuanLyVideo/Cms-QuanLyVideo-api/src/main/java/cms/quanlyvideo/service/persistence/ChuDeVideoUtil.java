/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.model.ChuDeVideo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the chu de video service. This utility wraps <code>cms.quanlyvideo.service.persistence.impl.ChuDeVideoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideoPersistence
 * @generated
 */
public class ChuDeVideoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ChuDeVideo chuDeVideo) {
		getPersistence().clearCache(chuDeVideo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ChuDeVideo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ChuDeVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ChuDeVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ChuDeVideo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ChuDeVideo update(ChuDeVideo chuDeVideo) {
		return getPersistence().update(chuDeVideo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ChuDeVideo update(
		ChuDeVideo chuDeVideo, ServiceContext serviceContext) {

		return getPersistence().update(chuDeVideo, serviceContext);
	}

	/**
	 * Returns all the chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the matching chu de videos
	 */
	public static List<ChuDeVideo> findByvideoId(long video_id) {
		return getPersistence().findByvideoId(video_id);
	}

	/**
	 * Returns a range of all the chu de videos where video_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param video_id the video_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @return the range of matching chu de videos
	 */
	public static List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end) {

		return getPersistence().findByvideoId(video_id, start, end);
	}

	/**
	 * Returns an ordered range of all the chu de videos where video_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param video_id the video_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chu de videos
	 */
	public static List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().findByvideoId(
			video_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chu de videos where video_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param video_id the video_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chu de videos
	 */
	public static List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByvideoId(
			video_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public static ChuDeVideo findByvideoId_First(
			long video_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findByvideoId_First(
			video_id, orderByComparator);
	}

	/**
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public static ChuDeVideo fetchByvideoId_First(
		long video_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().fetchByvideoId_First(
			video_id, orderByComparator);
	}

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public static ChuDeVideo findByvideoId_Last(
			long video_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findByvideoId_Last(video_id, orderByComparator);
	}

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public static ChuDeVideo fetchByvideoId_Last(
		long video_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().fetchByvideoId_Last(
			video_id, orderByComparator);
	}

	/**
	 * Returns the chu de videos before and after the current chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param id the primary key of the current chu de video
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public static ChuDeVideo[] findByvideoId_PrevAndNext(
			long id, long video_id,
			OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findByvideoId_PrevAndNext(
			id, video_id, orderByComparator);
	}

	/**
	 * Removes all the chu de videos where video_id = &#63; from the database.
	 *
	 * @param video_id the video_id
	 */
	public static void removeByvideoId(long video_id) {
		getPersistence().removeByvideoId(video_id);
	}

	/**
	 * Returns the number of chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the number of matching chu de videos
	 */
	public static int countByvideoId(long video_id) {
		return getPersistence().countByvideoId(video_id);
	}

	/**
	 * Returns all the chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the matching chu de videos
	 */
	public static List<ChuDeVideo> findBychudeId(long chude_id) {
		return getPersistence().findBychudeId(chude_id);
	}

	/**
	 * Returns a range of all the chu de videos where chude_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param chude_id the chude_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @return the range of matching chu de videos
	 */
	public static List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end) {

		return getPersistence().findBychudeId(chude_id, start, end);
	}

	/**
	 * Returns an ordered range of all the chu de videos where chude_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param chude_id the chude_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chu de videos
	 */
	public static List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().findBychudeId(
			chude_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chu de videos where chude_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param chude_id the chude_id
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chu de videos
	 */
	public static List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBychudeId(
			chude_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public static ChuDeVideo findBychudeId_First(
			long chude_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findBychudeId_First(
			chude_id, orderByComparator);
	}

	/**
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public static ChuDeVideo fetchBychudeId_First(
		long chude_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().fetchBychudeId_First(
			chude_id, orderByComparator);
	}

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public static ChuDeVideo findBychudeId_Last(
			long chude_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findBychudeId_Last(chude_id, orderByComparator);
	}

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public static ChuDeVideo fetchBychudeId_Last(
		long chude_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().fetchBychudeId_Last(
			chude_id, orderByComparator);
	}

	/**
	 * Returns the chu de videos before and after the current chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param id the primary key of the current chu de video
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public static ChuDeVideo[] findBychudeId_PrevAndNext(
			long id, long chude_id,
			OrderByComparator<ChuDeVideo> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findBychudeId_PrevAndNext(
			id, chude_id, orderByComparator);
	}

	/**
	 * Removes all the chu de videos where chude_id = &#63; from the database.
	 *
	 * @param chude_id the chude_id
	 */
	public static void removeBychudeId(long chude_id) {
		getPersistence().removeBychudeId(chude_id);
	}

	/**
	 * Returns the number of chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the number of matching chu de videos
	 */
	public static int countBychudeId(long chude_id) {
		return getPersistence().countBychudeId(chude_id);
	}

	/**
	 * Caches the chu de video in the entity cache if it is enabled.
	 *
	 * @param chuDeVideo the chu de video
	 */
	public static void cacheResult(ChuDeVideo chuDeVideo) {
		getPersistence().cacheResult(chuDeVideo);
	}

	/**
	 * Caches the chu de videos in the entity cache if it is enabled.
	 *
	 * @param chuDeVideos the chu de videos
	 */
	public static void cacheResult(List<ChuDeVideo> chuDeVideos) {
		getPersistence().cacheResult(chuDeVideos);
	}

	/**
	 * Creates a new chu de video with the primary key. Does not add the chu de video to the database.
	 *
	 * @param id the primary key for the new chu de video
	 * @return the new chu de video
	 */
	public static ChuDeVideo create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the chu de video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video that was removed
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public static ChuDeVideo remove(long id)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().remove(id);
	}

	public static ChuDeVideo updateImpl(ChuDeVideo chuDeVideo) {
		return getPersistence().updateImpl(chuDeVideo);
	}

	/**
	 * Returns the chu de video with the primary key or throws a <code>NoSuchChuDeVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public static ChuDeVideo findByPrimaryKey(long id)
		throws cms.quanlyvideo.exception.NoSuchChuDeVideoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the chu de video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video, or <code>null</code> if a chu de video with the primary key could not be found
	 */
	public static ChuDeVideo fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the chu de videos.
	 *
	 * @return the chu de videos
	 */
	public static List<ChuDeVideo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the chu de videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @return the range of chu de videos
	 */
	public static List<ChuDeVideo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the chu de videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chu de videos
	 */
	public static List<ChuDeVideo> findAll(
		int start, int end, OrderByComparator<ChuDeVideo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the chu de videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeVideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu de videos
	 * @param end the upper bound of the range of chu de videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chu de videos
	 */
	public static List<ChuDeVideo> findAll(
		int start, int end, OrderByComparator<ChuDeVideo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the chu de videos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of chu de videos.
	 *
	 * @return the number of chu de videos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ChuDeVideoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ChuDeVideoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ChuDeVideoPersistence _persistence;

}