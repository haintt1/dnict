/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.exception.NoSuchChuDeVideoException;
import cms.quanlyvideo.model.ChuDeVideo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the chu de video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ChuDeVideoUtil
 * @generated
 */
@ProviderType
public interface ChuDeVideoPersistence extends BasePersistence<ChuDeVideo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ChuDeVideoUtil} to access the chu de video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the matching chu de videos
	 */
	public java.util.List<ChuDeVideo> findByvideoId(long video_id);

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
	public java.util.List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end);

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
	public java.util.List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

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
	public java.util.List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public ChuDeVideo findByvideoId_First(
			long video_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public ChuDeVideo fetchByvideoId_First(
		long video_id,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public ChuDeVideo findByvideoId_Last(
			long video_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public ChuDeVideo fetchByvideoId_Last(
		long video_id,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

	/**
	 * Returns the chu de videos before and after the current chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param id the primary key of the current chu de video
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public ChuDeVideo[] findByvideoId_PrevAndNext(
			long id, long video_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Removes all the chu de videos where video_id = &#63; from the database.
	 *
	 * @param video_id the video_id
	 */
	public void removeByvideoId(long video_id);

	/**
	 * Returns the number of chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the number of matching chu de videos
	 */
	public int countByvideoId(long video_id);

	/**
	 * Returns all the chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the matching chu de videos
	 */
	public java.util.List<ChuDeVideo> findBychudeId(long chude_id);

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
	public java.util.List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end);

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
	public java.util.List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

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
	public java.util.List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public ChuDeVideo findBychudeId_First(
			long chude_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public ChuDeVideo fetchBychudeId_First(
		long chude_id,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	public ChuDeVideo findBychudeId_Last(
			long chude_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	public ChuDeVideo fetchBychudeId_Last(
		long chude_id,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

	/**
	 * Returns the chu de videos before and after the current chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param id the primary key of the current chu de video
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public ChuDeVideo[] findBychudeId_PrevAndNext(
			long id, long chude_id,
			com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
				orderByComparator)
		throws NoSuchChuDeVideoException;

	/**
	 * Removes all the chu de videos where chude_id = &#63; from the database.
	 *
	 * @param chude_id the chude_id
	 */
	public void removeBychudeId(long chude_id);

	/**
	 * Returns the number of chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the number of matching chu de videos
	 */
	public int countBychudeId(long chude_id);

	/**
	 * Caches the chu de video in the entity cache if it is enabled.
	 *
	 * @param chuDeVideo the chu de video
	 */
	public void cacheResult(ChuDeVideo chuDeVideo);

	/**
	 * Caches the chu de videos in the entity cache if it is enabled.
	 *
	 * @param chuDeVideos the chu de videos
	 */
	public void cacheResult(java.util.List<ChuDeVideo> chuDeVideos);

	/**
	 * Creates a new chu de video with the primary key. Does not add the chu de video to the database.
	 *
	 * @param id the primary key for the new chu de video
	 * @return the new chu de video
	 */
	public ChuDeVideo create(long id);

	/**
	 * Removes the chu de video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video that was removed
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public ChuDeVideo remove(long id) throws NoSuchChuDeVideoException;

	public ChuDeVideo updateImpl(ChuDeVideo chuDeVideo);

	/**
	 * Returns the chu de video with the primary key or throws a <code>NoSuchChuDeVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	public ChuDeVideo findByPrimaryKey(long id)
		throws NoSuchChuDeVideoException;

	/**
	 * Returns the chu de video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video, or <code>null</code> if a chu de video with the primary key could not be found
	 */
	public ChuDeVideo fetchByPrimaryKey(long id);

	/**
	 * Returns all the chu de videos.
	 *
	 * @return the chu de videos
	 */
	public java.util.List<ChuDeVideo> findAll();

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
	public java.util.List<ChuDeVideo> findAll(int start, int end);

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
	public java.util.List<ChuDeVideo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator);

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
	public java.util.List<ChuDeVideo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ChuDeVideo>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the chu de videos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of chu de videos.
	 *
	 * @return the number of chu de videos
	 */
	public int countAll();

}