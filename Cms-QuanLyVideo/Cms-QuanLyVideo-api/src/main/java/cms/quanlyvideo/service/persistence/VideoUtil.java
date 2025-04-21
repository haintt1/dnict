/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.model.Video;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the video service. This utility wraps <code>cms.quanlyvideo.service.persistence.impl.VideoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoPersistence
 * @generated
 */
public class VideoUtil {

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
	public static void clearCache(Video video) {
		getPersistence().clearCache(video);
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
	public static Map<Serializable, Video> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Video> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Video> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Video update(Video video) {
		return getPersistence().update(video);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Video update(Video video, ServiceContext serviceContext) {
		return getPersistence().update(video, serviceContext);
	}

	/**
	 * Returns all the videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching videos
	 */
	public static List<Video> findByten(String ten) {
		return getPersistence().findByten(ten);
	}

	/**
	 * Returns a range of all the videos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of matching videos
	 */
	public static List<Video> findByten(String ten, int start, int end) {
		return getPersistence().findByten(ten, start, end);
	}

	/**
	 * Returns an ordered range of all the videos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByten(
		String ten, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return getPersistence().findByten(ten, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching videos
	 */
	public static List<Video> findByten(
		String ten, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByten(
			ten, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByten_First(
			String ten, OrderByComparator<Video> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchVideoException {

		return getPersistence().findByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByten_First(
		String ten, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public static Video findByten_Last(
			String ten, OrderByComparator<Video> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchVideoException {

		return getPersistence().findByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public static Video fetchByten_Last(
		String ten, OrderByComparator<Video> orderByComparator) {

		return getPersistence().fetchByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the videos before and after the current video in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current video
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video[] findByten_PrevAndNext(
			long id, String ten, OrderByComparator<Video> orderByComparator)
		throws cms.quanlyvideo.exception.NoSuchVideoException {

		return getPersistence().findByten_PrevAndNext(
			id, ten, orderByComparator);
	}

	/**
	 * Removes all the videos where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByten(String ten) {
		getPersistence().removeByten(ten);
	}

	/**
	 * Returns the number of videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching videos
	 */
	public static int countByten(String ten) {
		return getPersistence().countByten(ten);
	}

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	public static void cacheResult(Video video) {
		getPersistence().cacheResult(video);
	}

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	public static void cacheResult(List<Video> videos) {
		getPersistence().cacheResult(videos);
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param id the primary key for the new video
	 * @return the new video
	 */
	public static Video create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video remove(long id)
		throws cms.quanlyvideo.exception.NoSuchVideoException {

		return getPersistence().remove(id);
	}

	public static Video updateImpl(Video video) {
		return getPersistence().updateImpl(video);
	}

	/**
	 * Returns the video with the primary key or throws a <code>NoSuchVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public static Video findByPrimaryKey(long id)
		throws cms.quanlyvideo.exception.NoSuchVideoException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	public static Video fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	public static List<Video> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @return the range of videos
	 */
	public static List<Video> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of videos
	 */
	public static List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the videos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VideoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of videos
	 * @param end the upper bound of the range of videos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of videos
	 */
	public static List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the videos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VideoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(VideoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile VideoPersistence _persistence;

}