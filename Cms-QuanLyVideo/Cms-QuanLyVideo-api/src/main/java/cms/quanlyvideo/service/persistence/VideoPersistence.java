/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence;

import cms.quanlyvideo.exception.NoSuchVideoException;
import cms.quanlyvideo.model.Video;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VideoUtil
 * @generated
 */
@ProviderType
public interface VideoPersistence extends BasePersistence<Video> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VideoUtil} to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching videos
	 */
	public java.util.List<Video> findByten(String ten);

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
	public java.util.List<Video> findByten(String ten, int start, int end);

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
	public java.util.List<Video> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator);

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
	public java.util.List<Video> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public Video findByten_First(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<Video>
				orderByComparator)
		throws NoSuchVideoException;

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	public Video fetchByten_First(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator);

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	public Video findByten_Last(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<Video>
				orderByComparator)
		throws NoSuchVideoException;

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	public Video fetchByten_Last(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator);

	/**
	 * Returns the videos before and after the current video in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current video
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public Video[] findByten_PrevAndNext(
			long id, String ten,
			com.liferay.portal.kernel.util.OrderByComparator<Video>
				orderByComparator)
		throws NoSuchVideoException;

	/**
	 * Removes all the videos where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public void removeByten(String ten);

	/**
	 * Returns the number of videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching videos
	 */
	public int countByten(String ten);

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	public void cacheResult(Video video);

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	public void cacheResult(java.util.List<Video> videos);

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param id the primary key for the new video
	 * @return the new video
	 */
	public Video create(long id);

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public Video remove(long id) throws NoSuchVideoException;

	public Video updateImpl(Video video);

	/**
	 * Returns the video with the primary key or throws a <code>NoSuchVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	public Video findByPrimaryKey(long id) throws NoSuchVideoException;

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	public Video fetchByPrimaryKey(long id);

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	public java.util.List<Video> findAll();

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
	public java.util.List<Video> findAll(int start, int end);

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
	public java.util.List<Video> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator);

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
	public java.util.List<Video> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Video>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the videos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	public int countAll();

}