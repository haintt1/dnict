/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.impl;

import cms.quanlyvideo.exception.NoSuchChuDeVideoException;
import cms.quanlyvideo.model.ChuDeVideo;
import cms.quanlyvideo.model.impl.ChuDeVideoImpl;
import cms.quanlyvideo.model.impl.ChuDeVideoModelImpl;
import cms.quanlyvideo.service.persistence.ChuDeVideoPersistence;
import cms.quanlyvideo.service.persistence.ChuDeVideoUtil;
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
 * The persistence implementation for the chu de video service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChuDeVideoPersistence.class)
public class ChuDeVideoPersistenceImpl
	extends BasePersistenceImpl<ChuDeVideo> implements ChuDeVideoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChuDeVideoUtil</code> to access the chu de video persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChuDeVideoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByvideoId;
	private FinderPath _finderPathWithoutPaginationFindByvideoId;
	private FinderPath _finderPathCountByvideoId;

	/**
	 * Returns all the chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the matching chu de videos
	 */
	@Override
	public List<ChuDeVideo> findByvideoId(long video_id) {
		return findByvideoId(
			video_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChuDeVideo> findByvideoId(long video_id, int start, int end) {
		return findByvideoId(video_id, start, end, null);
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
	@Override
	public List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator) {

		return findByvideoId(video_id, start, end, orderByComparator, true);
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
	@Override
	public List<ChuDeVideo> findByvideoId(
		long video_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByvideoId;
				finderArgs = new Object[] {video_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByvideoId;
			finderArgs = new Object[] {video_id, start, end, orderByComparator};
		}

		List<ChuDeVideo> list = null;

		if (useFinderCache) {
			list = (List<ChuDeVideo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChuDeVideo chuDeVideo : list) {
					if (video_id != chuDeVideo.getVideo_id()) {
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

			sb.append(_SQL_SELECT_CHUDEVIDEO_WHERE);

			sb.append(_FINDER_COLUMN_VIDEOID_VIDEO_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChuDeVideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(video_id);

				list = (List<ChuDeVideo>)QueryUtil.list(
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
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo findByvideoId_First(
			long video_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = fetchByvideoId_First(
			video_id, orderByComparator);

		if (chuDeVideo != null) {
			return chuDeVideo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("video_id=");
		sb.append(video_id);

		sb.append("}");

		throw new NoSuchChuDeVideoException(sb.toString());
	}

	/**
	 * Returns the first chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo fetchByvideoId_First(
		long video_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		List<ChuDeVideo> list = findByvideoId(
			video_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo findByvideoId_Last(
			long video_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = fetchByvideoId_Last(
			video_id, orderByComparator);

		if (chuDeVideo != null) {
			return chuDeVideo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("video_id=");
		sb.append(video_id);

		sb.append("}");

		throw new NoSuchChuDeVideoException(sb.toString());
	}

	/**
	 * Returns the last chu de video in the ordered set where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo fetchByvideoId_Last(
		long video_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		int count = countByvideoId(video_id);

		if (count == 0) {
			return null;
		}

		List<ChuDeVideo> list = findByvideoId(
			video_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ChuDeVideo[] findByvideoId_PrevAndNext(
			long id, long video_id,
			OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChuDeVideo[] array = new ChuDeVideoImpl[3];

			array[0] = getByvideoId_PrevAndNext(
				session, chuDeVideo, video_id, orderByComparator, true);

			array[1] = chuDeVideo;

			array[2] = getByvideoId_PrevAndNext(
				session, chuDeVideo, video_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChuDeVideo getByvideoId_PrevAndNext(
		Session session, ChuDeVideo chuDeVideo, long video_id,
		OrderByComparator<ChuDeVideo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHUDEVIDEO_WHERE);

		sb.append(_FINDER_COLUMN_VIDEOID_VIDEO_ID_2);

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
			sb.append(ChuDeVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(video_id);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chuDeVideo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChuDeVideo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chu de videos where video_id = &#63; from the database.
	 *
	 * @param video_id the video_id
	 */
	@Override
	public void removeByvideoId(long video_id) {
		for (ChuDeVideo chuDeVideo :
				findByvideoId(
					video_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chuDeVideo);
		}
	}

	/**
	 * Returns the number of chu de videos where video_id = &#63;.
	 *
	 * @param video_id the video_id
	 * @return the number of matching chu de videos
	 */
	@Override
	public int countByvideoId(long video_id) {
		FinderPath finderPath = _finderPathCountByvideoId;

		Object[] finderArgs = new Object[] {video_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHUDEVIDEO_WHERE);

			sb.append(_FINDER_COLUMN_VIDEOID_VIDEO_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(video_id);

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

	private static final String _FINDER_COLUMN_VIDEOID_VIDEO_ID_2 =
		"chuDeVideo.video_id = ?";

	private FinderPath _finderPathWithPaginationFindBychudeId;
	private FinderPath _finderPathWithoutPaginationFindBychudeId;
	private FinderPath _finderPathCountBychudeId;

	/**
	 * Returns all the chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the matching chu de videos
	 */
	@Override
	public List<ChuDeVideo> findBychudeId(long chude_id) {
		return findBychudeId(
			chude_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChuDeVideo> findBychudeId(long chude_id, int start, int end) {
		return findBychudeId(chude_id, start, end, null);
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
	@Override
	public List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator) {

		return findBychudeId(chude_id, start, end, orderByComparator, true);
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
	@Override
	public List<ChuDeVideo> findBychudeId(
		long chude_id, int start, int end,
		OrderByComparator<ChuDeVideo> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBychudeId;
				finderArgs = new Object[] {chude_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBychudeId;
			finderArgs = new Object[] {chude_id, start, end, orderByComparator};
		}

		List<ChuDeVideo> list = null;

		if (useFinderCache) {
			list = (List<ChuDeVideo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChuDeVideo chuDeVideo : list) {
					if (chude_id != chuDeVideo.getChude_id()) {
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

			sb.append(_SQL_SELECT_CHUDEVIDEO_WHERE);

			sb.append(_FINDER_COLUMN_CHUDEID_CHUDE_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ChuDeVideoModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(chude_id);

				list = (List<ChuDeVideo>)QueryUtil.list(
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
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo findBychudeId_First(
			long chude_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = fetchBychudeId_First(
			chude_id, orderByComparator);

		if (chuDeVideo != null) {
			return chuDeVideo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("chude_id=");
		sb.append(chude_id);

		sb.append("}");

		throw new NoSuchChuDeVideoException(sb.toString());
	}

	/**
	 * Returns the first chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo fetchBychudeId_First(
		long chude_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		List<ChuDeVideo> list = findBychudeId(
			chude_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video
	 * @throws NoSuchChuDeVideoException if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo findBychudeId_Last(
			long chude_id, OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = fetchBychudeId_Last(
			chude_id, orderByComparator);

		if (chuDeVideo != null) {
			return chuDeVideo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("chude_id=");
		sb.append(chude_id);

		sb.append("}");

		throw new NoSuchChuDeVideoException(sb.toString());
	}

	/**
	 * Returns the last chu de video in the ordered set where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de video, or <code>null</code> if a matching chu de video could not be found
	 */
	@Override
	public ChuDeVideo fetchBychudeId_Last(
		long chude_id, OrderByComparator<ChuDeVideo> orderByComparator) {

		int count = countBychudeId(chude_id);

		if (count == 0) {
			return null;
		}

		List<ChuDeVideo> list = findBychudeId(
			chude_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ChuDeVideo[] findBychudeId_PrevAndNext(
			long id, long chude_id,
			OrderByComparator<ChuDeVideo> orderByComparator)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChuDeVideo[] array = new ChuDeVideoImpl[3];

			array[0] = getBychudeId_PrevAndNext(
				session, chuDeVideo, chude_id, orderByComparator, true);

			array[1] = chuDeVideo;

			array[2] = getBychudeId_PrevAndNext(
				session, chuDeVideo, chude_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChuDeVideo getBychudeId_PrevAndNext(
		Session session, ChuDeVideo chuDeVideo, long chude_id,
		OrderByComparator<ChuDeVideo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHUDEVIDEO_WHERE);

		sb.append(_FINDER_COLUMN_CHUDEID_CHUDE_ID_2);

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
			sb.append(ChuDeVideoModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(chude_id);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(chuDeVideo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChuDeVideo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chu de videos where chude_id = &#63; from the database.
	 *
	 * @param chude_id the chude_id
	 */
	@Override
	public void removeBychudeId(long chude_id) {
		for (ChuDeVideo chuDeVideo :
				findBychudeId(
					chude_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chuDeVideo);
		}
	}

	/**
	 * Returns the number of chu de videos where chude_id = &#63;.
	 *
	 * @param chude_id the chude_id
	 * @return the number of matching chu de videos
	 */
	@Override
	public int countBychudeId(long chude_id) {
		FinderPath finderPath = _finderPathCountBychudeId;

		Object[] finderArgs = new Object[] {chude_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHUDEVIDEO_WHERE);

			sb.append(_FINDER_COLUMN_CHUDEID_CHUDE_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(chude_id);

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

	private static final String _FINDER_COLUMN_CHUDEID_CHUDE_ID_2 =
		"chuDeVideo.chude_id = ?";

	public ChuDeVideoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChuDeVideo.class);

		setModelImplClass(ChuDeVideoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the chu de video in the entity cache if it is enabled.
	 *
	 * @param chuDeVideo the chu de video
	 */
	@Override
	public void cacheResult(ChuDeVideo chuDeVideo) {
		entityCache.putResult(
			ChuDeVideoImpl.class, chuDeVideo.getPrimaryKey(), chuDeVideo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chu de videos in the entity cache if it is enabled.
	 *
	 * @param chuDeVideos the chu de videos
	 */
	@Override
	public void cacheResult(List<ChuDeVideo> chuDeVideos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chuDeVideos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChuDeVideo chuDeVideo : chuDeVideos) {
			if (entityCache.getResult(
					ChuDeVideoImpl.class, chuDeVideo.getPrimaryKey()) == null) {

				cacheResult(chuDeVideo);
			}
		}
	}

	/**
	 * Clears the cache for all chu de videos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChuDeVideoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chu de video.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChuDeVideo chuDeVideo) {
		entityCache.removeResult(ChuDeVideoImpl.class, chuDeVideo);
	}

	@Override
	public void clearCache(List<ChuDeVideo> chuDeVideos) {
		for (ChuDeVideo chuDeVideo : chuDeVideos) {
			entityCache.removeResult(ChuDeVideoImpl.class, chuDeVideo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChuDeVideoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chu de video with the primary key. Does not add the chu de video to the database.
	 *
	 * @param id the primary key for the new chu de video
	 * @return the new chu de video
	 */
	@Override
	public ChuDeVideo create(long id) {
		ChuDeVideo chuDeVideo = new ChuDeVideoImpl();

		chuDeVideo.setNew(true);
		chuDeVideo.setPrimaryKey(id);

		return chuDeVideo;
	}

	/**
	 * Removes the chu de video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video that was removed
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	@Override
	public ChuDeVideo remove(long id) throws NoSuchChuDeVideoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chu de video with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chu de video
	 * @return the chu de video that was removed
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	@Override
	public ChuDeVideo remove(Serializable primaryKey)
		throws NoSuchChuDeVideoException {

		Session session = null;

		try {
			session = openSession();

			ChuDeVideo chuDeVideo = (ChuDeVideo)session.get(
				ChuDeVideoImpl.class, primaryKey);

			if (chuDeVideo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChuDeVideoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chuDeVideo);
		}
		catch (NoSuchChuDeVideoException noSuchEntityException) {
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
	protected ChuDeVideo removeImpl(ChuDeVideo chuDeVideo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chuDeVideo)) {
				chuDeVideo = (ChuDeVideo)session.get(
					ChuDeVideoImpl.class, chuDeVideo.getPrimaryKeyObj());
			}

			if (chuDeVideo != null) {
				session.delete(chuDeVideo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chuDeVideo != null) {
			clearCache(chuDeVideo);
		}

		return chuDeVideo;
	}

	@Override
	public ChuDeVideo updateImpl(ChuDeVideo chuDeVideo) {
		boolean isNew = chuDeVideo.isNew();

		if (!(chuDeVideo instanceof ChuDeVideoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chuDeVideo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chuDeVideo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chuDeVideo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChuDeVideo implementation " +
					chuDeVideo.getClass());
		}

		ChuDeVideoModelImpl chuDeVideoModelImpl =
			(ChuDeVideoModelImpl)chuDeVideo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chuDeVideo);
			}
			else {
				chuDeVideo = (ChuDeVideo)session.merge(chuDeVideo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ChuDeVideoImpl.class, chuDeVideoModelImpl, false, true);

		if (isNew) {
			chuDeVideo.setNew(false);
		}

		chuDeVideo.resetOriginalValues();

		return chuDeVideo;
	}

	/**
	 * Returns the chu de video with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chu de video
	 * @return the chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	@Override
	public ChuDeVideo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChuDeVideoException {

		ChuDeVideo chuDeVideo = fetchByPrimaryKey(primaryKey);

		if (chuDeVideo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChuDeVideoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chuDeVideo;
	}

	/**
	 * Returns the chu de video with the primary key or throws a <code>NoSuchChuDeVideoException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video
	 * @throws NoSuchChuDeVideoException if a chu de video with the primary key could not be found
	 */
	@Override
	public ChuDeVideo findByPrimaryKey(long id)
		throws NoSuchChuDeVideoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chu de video with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de video
	 * @return the chu de video, or <code>null</code> if a chu de video with the primary key could not be found
	 */
	@Override
	public ChuDeVideo fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chu de videos.
	 *
	 * @return the chu de videos
	 */
	@Override
	public List<ChuDeVideo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ChuDeVideo> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ChuDeVideo> findAll(
		int start, int end, OrderByComparator<ChuDeVideo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ChuDeVideo> findAll(
		int start, int end, OrderByComparator<ChuDeVideo> orderByComparator,
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

		List<ChuDeVideo> list = null;

		if (useFinderCache) {
			list = (List<ChuDeVideo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHUDEVIDEO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHUDEVIDEO;

				sql = sql.concat(ChuDeVideoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChuDeVideo>)QueryUtil.list(
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
	 * Removes all the chu de videos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChuDeVideo chuDeVideo : findAll()) {
			remove(chuDeVideo);
		}
	}

	/**
	 * Returns the number of chu de videos.
	 *
	 * @return the number of chu de videos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHUDEVIDEO);

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
		return _SQL_SELECT_CHUDEVIDEO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChuDeVideoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chu de video persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ChuDeVideoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ChuDeVideo.class.getName()));

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

		_finderPathWithPaginationFindByvideoId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByvideoId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"video_id"}, true);

		_finderPathWithoutPaginationFindByvideoId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByvideoId",
			new String[] {Long.class.getName()}, new String[] {"video_id"},
			true);

		_finderPathCountByvideoId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByvideoId",
			new String[] {Long.class.getName()}, new String[] {"video_id"},
			false);

		_finderPathWithPaginationFindBychudeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBychudeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"chude_id"}, true);

		_finderPathWithoutPaginationFindBychudeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBychudeId",
			new String[] {Long.class.getName()}, new String[] {"chude_id"},
			true);

		_finderPathCountBychudeId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBychudeId",
			new String[] {Long.class.getName()}, new String[] {"chude_id"},
			false);

		ChuDeVideoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ChuDeVideoUtil.setPersistence(null);

		entityCache.removeCache(ChuDeVideoImpl.class.getName());

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

	private static final String _SQL_SELECT_CHUDEVIDEO =
		"SELECT chuDeVideo FROM ChuDeVideo chuDeVideo";

	private static final String _SQL_SELECT_CHUDEVIDEO_WHERE =
		"SELECT chuDeVideo FROM ChuDeVideo chuDeVideo WHERE ";

	private static final String _SQL_COUNT_CHUDEVIDEO =
		"SELECT COUNT(chuDeVideo) FROM ChuDeVideo chuDeVideo";

	private static final String _SQL_COUNT_CHUDEVIDEO_WHERE =
		"SELECT COUNT(chuDeVideo) FROM ChuDeVideo chuDeVideo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chuDeVideo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChuDeVideo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChuDeVideo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChuDeVideoPersistenceImpl.class);

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

	private static class ChuDeVideoModelArgumentsResolver
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

			ChuDeVideoModelImpl chuDeVideoModelImpl =
				(ChuDeVideoModelImpl)baseModel;

			long columnBitmask = chuDeVideoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(chuDeVideoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						chuDeVideoModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(ChuDeVideoPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(chuDeVideoModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ChuDeVideoModelImpl chuDeVideoModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = chuDeVideoModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = chuDeVideoModelImpl.getColumnValue(
						columnName);
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