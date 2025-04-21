/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.impl;

import cms.quanlyvideo.exception.NoSuchVideoException;
import cms.quanlyvideo.model.Video;
import cms.quanlyvideo.model.impl.VideoImpl;
import cms.quanlyvideo.model.impl.VideoModelImpl;
import cms.quanlyvideo.service.persistence.VideoPersistence;
import cms.quanlyvideo.service.persistence.VideoUtil;
import cms.quanlyvideo.service.persistence.impl.constants.CmsPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = VideoPersistence.class)
public class VideoPersistenceImpl
	extends BasePersistenceImpl<Video> implements VideoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VideoUtil</code> to access the video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VideoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByten;
	private FinderPath _finderPathWithoutPaginationFindByten;
	private FinderPath _finderPathCountByten;

	/**
	 * Returns all the videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching videos
	 */
	@Override
	public List<Video> findByten(String ten) {
		return findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findByten(String ten, int start, int end) {
		return findByten(ten, start, end, null);
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
	@Override
	public List<Video> findByten(
		String ten, int start, int end,
		OrderByComparator<Video> orderByComparator) {

		return findByten(ten, start, end, orderByComparator, true);
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
	@Override
	public List<Video> findByten(
		String ten, int start, int end,
		OrderByComparator<Video> orderByComparator, boolean useFinderCache) {

		ten = Objects.toString(ten, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByten;
				finderArgs = new Object[] {ten};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByten;
			finderArgs = new Object[] {ten, start, end, orderByComparator};
		}

		List<Video> list = null;

		if (useFinderCache) {
			list = (List<Video>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video video : list) {
					if (!ten.equals(video.getTen())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIDEO_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				sb.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				bindTen = true;

				sb.append(_FINDER_COLUMN_TEN_TEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTen) {
					queryPos.add(ten);
				}

				list = (List<Video>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByten_First(
			String ten, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByten_First(ten, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchVideoException(sb.toString());
	}

	/**
	 * Returns the first video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByten_First(
		String ten, OrderByComparator<Video> orderByComparator) {

		List<Video> list = findByten(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video
	 * @throws NoSuchVideoException if a matching video could not be found
	 */
	@Override
	public Video findByten_Last(
			String ten, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		Video video = fetchByten_Last(ten, orderByComparator);

		if (video != null) {
			return video;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchVideoException(sb.toString());
	}

	/**
	 * Returns the last video in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video, or <code>null</code> if a matching video could not be found
	 */
	@Override
	public Video fetchByten_Last(
		String ten, OrderByComparator<Video> orderByComparator) {

		int count = countByten(ten);

		if (count == 0) {
			return null;
		}

		List<Video> list = findByten(ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Video[] findByten_PrevAndNext(
			long id, String ten, OrderByComparator<Video> orderByComparator)
		throws NoSuchVideoException {

		ten = Objects.toString(ten, "");

		Video video = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Video[] array = new VideoImpl[3];

			array[0] = getByten_PrevAndNext(
				session, video, ten, orderByComparator, true);

			array[1] = video;

			array[2] = getByten_PrevAndNext(
				session, video, ten, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video getByten_PrevAndNext(
		Session session, Video video, String ten,
		OrderByComparator<Video> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIDEO_WHERE);

		boolean bindTen = false;

		if (ten.isEmpty()) {
			sb.append(_FINDER_COLUMN_TEN_TEN_3);
		}
		else {
			bindTen = true;

			sb.append(_FINDER_COLUMN_TEN_TEN_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(VideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTen) {
			queryPos.add(ten);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(video)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Video> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the videos where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByten(String ten) {
		for (Video video :
				findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(video);
		}
	}

	/**
	 * Returns the number of videos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching videos
	 */
	@Override
	public int countByten(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByten;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIDEO_WHERE);

			boolean bindTen = false;

			if (ten.isEmpty()) {
				sb.append(_FINDER_COLUMN_TEN_TEN_3);
			}
			else {
				bindTen = true;

				sb.append(_FINDER_COLUMN_TEN_TEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTen) {
					queryPos.add(ten);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "video.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(video.ten IS NULL OR video.ten = '')";

	public VideoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Video.class);

		setModelImplClass(VideoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the video in the entity cache if it is enabled.
	 *
	 * @param video the video
	 */
	@Override
	public void cacheResult(Video video) {
		entityCache.putResult(VideoImpl.class, video.getPrimaryKey(), video);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the videos in the entity cache if it is enabled.
	 *
	 * @param videos the videos
	 */
	@Override
	public void cacheResult(List<Video> videos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (videos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Video video : videos) {
			if (entityCache.getResult(VideoImpl.class, video.getPrimaryKey()) ==
					null) {

				cacheResult(video);
			}
		}
	}

	/**
	 * Clears the cache for all videos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VideoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video video) {
		entityCache.removeResult(VideoImpl.class, video);
	}

	@Override
	public void clearCache(List<Video> videos) {
		for (Video video : videos) {
			entityCache.removeResult(VideoImpl.class, video);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VideoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new video with the primary key. Does not add the video to the database.
	 *
	 * @param id the primary key for the new video
	 * @return the new video
	 */
	@Override
	public Video create(long id) {
		Video video = new VideoImpl();

		video.setNew(true);
		video.setPrimaryKey(id);

		video.setCompanyId(CompanyThreadLocal.getCompanyId());

		return video;
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(long id) throws NoSuchVideoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video that was removed
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video remove(Serializable primaryKey) throws NoSuchVideoException {
		Session session = null;

		try {
			session = openSession();

			Video video = (Video)session.get(VideoImpl.class, primaryKey);

			if (video == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(video);
		}
		catch (NoSuchVideoException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Video removeImpl(Video video) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video)) {
				video = (Video)session.get(
					VideoImpl.class, video.getPrimaryKeyObj());
			}

			if (video != null) {
				session.delete(video);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (video != null) {
			clearCache(video);
		}

		return video;
	}

	@Override
	public Video updateImpl(Video video) {
		boolean isNew = video.isNew();

		if (!(video instanceof VideoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(video.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(video);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in video proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Video implementation " +
					video.getClass());
		}

		VideoModelImpl videoModelImpl = (VideoModelImpl)video;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(video);
			}
			else {
				video = (Video)session.merge(video);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(VideoImpl.class, videoModelImpl, false, true);

		if (isNew) {
			video.setNew(false);
		}

		video.resetOriginalValues();

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideoException {

		Video video = fetchByPrimaryKey(primaryKey);

		if (video == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return video;
	}

	/**
	 * Returns the video with the primary key or throws a <code>NoSuchVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video
	 * @throws NoSuchVideoException if a video with the primary key could not be found
	 */
	@Override
	public Video findByPrimaryKey(long id) throws NoSuchVideoException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the video
	 * @return the video, or <code>null</code> if a video with the primary key could not be found
	 */
	@Override
	public Video fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the videos.
	 *
	 * @return the videos
	 */
	@Override
	public List<Video> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Video> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Video> findAll(
		int start, int end, OrderByComparator<Video> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Video> list = null;

		if (useFinderCache) {
			list = (List<Video>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VIDEO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO;

				sql = sql.concat(VideoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Video>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the videos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video video : findAll()) {
			remove(video);
		}
	}

	/**
	 * Returns the number of videos.
	 *
	 * @return the number of videos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VIDEO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIDEO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VideoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new VideoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Video.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByten = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByten",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ten"}, true);

		_finderPathWithoutPaginationFindByten = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByten",
			new String[] {String.class.getName()}, new String[] {"ten"}, true);

		_finderPathCountByten = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByten",
			new String[] {String.class.getName()}, new String[] {"ten"}, false);

		VideoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		VideoUtil.setPersistence(null);

		entityCache.removeCache(VideoImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = CmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIDEO =
		"SELECT video FROM Video video";

	private static final String _SQL_SELECT_VIDEO_WHERE =
		"SELECT video FROM Video video WHERE ";

	private static final String _SQL_COUNT_VIDEO =
		"SELECT COUNT(video) FROM Video video";

	private static final String _SQL_COUNT_VIDEO_WHERE =
		"SELECT COUNT(video) FROM Video video WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "video.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Video exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Video exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VideoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class VideoModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			VideoModelImpl videoModelImpl = (VideoModelImpl)baseModel;

			long columnBitmask = videoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(videoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= videoModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(VideoPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(videoModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			VideoModelImpl videoModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = videoModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = videoModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

		private static final long _ORDER_BY_COLUMNS_BITMASK;

		static {
			long orderByColumnsBitmask = 0;

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}