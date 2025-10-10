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

package vn.dnict.vanbanphapquy.service.persistence.impl;

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

import java.lang.reflect.Field;
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

import vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;
import vn.dnict.vanbanphapquy.model.impl.CoquanbanhanhImpl;
import vn.dnict.vanbanphapquy.model.impl.CoquanbanhanhModelImpl;
import vn.dnict.vanbanphapquy.service.persistence.CoquanbanhanhPersistence;
import vn.dnict.vanbanphapquy.service.persistence.CoquanbanhanhUtil;
import vn.dnict.vanbanphapquy.service.persistence.impl.constants.BinhNTPersistenceConstants;

/**
 * The persistence implementation for the coquanbanhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @generated
 */
@Component(service = CoquanbanhanhPersistence.class)
public class CoquanbanhanhPersistenceImpl
	extends BasePersistenceImpl<Coquanbanhanh>
	implements CoquanbanhanhPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CoquanbanhanhUtil</code> to access the coquanbanhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CoquanbanhanhImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of matching coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<Coquanbanhanh> list = null;

		if (useFinderCache) {
			list = (List<Coquanbanhanh>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Coquanbanhanh coquanbanhanh : list) {
					if (status != coquanbanhanh.getStatus()) {
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

			sb.append(_SQL_SELECT_COQUANBANHANH_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CoquanbanhanhModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Coquanbanhanh>)QueryUtil.list(
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
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	@Override
	public Coquanbanhanh findByStatus_First(
			int status, OrderByComparator<Coquanbanhanh> orderByComparator)
		throws NoSuchCoquanbanhanhException {

		Coquanbanhanh coquanbanhanh = fetchByStatus_First(
			status, orderByComparator);

		if (coquanbanhanh != null) {
			return coquanbanhanh;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCoquanbanhanhException(sb.toString());
	}

	/**
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	@Override
	public Coquanbanhanh fetchByStatus_First(
		int status, OrderByComparator<Coquanbanhanh> orderByComparator) {

		List<Coquanbanhanh> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	@Override
	public Coquanbanhanh findByStatus_Last(
			int status, OrderByComparator<Coquanbanhanh> orderByComparator)
		throws NoSuchCoquanbanhanhException {

		Coquanbanhanh coquanbanhanh = fetchByStatus_Last(
			status, orderByComparator);

		if (coquanbanhanh != null) {
			return coquanbanhanh;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCoquanbanhanhException(sb.toString());
	}

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	@Override
	public Coquanbanhanh fetchByStatus_Last(
		int status, OrderByComparator<Coquanbanhanh> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Coquanbanhanh> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the coquanbanhanhs before and after the current coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current coquanbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Coquanbanhanh> orderByComparator)
		throws NoSuchCoquanbanhanhException {

		Coquanbanhanh coquanbanhanh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Coquanbanhanh[] array = new CoquanbanhanhImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, coquanbanhanh, status, orderByComparator, true);

			array[1] = coquanbanhanh;

			array[2] = getByStatus_PrevAndNext(
				session, coquanbanhanh, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Coquanbanhanh getByStatus_PrevAndNext(
		Session session, Coquanbanhanh coquanbanhanh, int status,
		OrderByComparator<Coquanbanhanh> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COQUANBANHANH_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(CoquanbanhanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						coquanbanhanh)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Coquanbanhanh> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the coquanbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Coquanbanhanh coquanbanhanh :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(coquanbanhanh);
		}
	}

	/**
	 * Returns the number of coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching coquanbanhanhs
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COQUANBANHANH_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"coquanbanhanh.status = ?";

	public CoquanbanhanhPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Coquanbanhanh.class);

		setModelImplClass(CoquanbanhanhImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the coquanbanhanh in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 */
	@Override
	public void cacheResult(Coquanbanhanh coquanbanhanh) {
		entityCache.putResult(
			CoquanbanhanhImpl.class, coquanbanhanh.getPrimaryKey(),
			coquanbanhanh);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the coquanbanhanhs in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanhs the coquanbanhanhs
	 */
	@Override
	public void cacheResult(List<Coquanbanhanh> coquanbanhanhs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (coquanbanhanhs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Coquanbanhanh coquanbanhanh : coquanbanhanhs) {
			if (entityCache.getResult(
					CoquanbanhanhImpl.class, coquanbanhanh.getPrimaryKey()) ==
						null) {

				cacheResult(coquanbanhanh);
			}
		}
	}

	/**
	 * Clears the cache for all coquanbanhanhs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CoquanbanhanhImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the coquanbanhanh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Coquanbanhanh coquanbanhanh) {
		entityCache.removeResult(CoquanbanhanhImpl.class, coquanbanhanh);
	}

	@Override
	public void clearCache(List<Coquanbanhanh> coquanbanhanhs) {
		for (Coquanbanhanh coquanbanhanh : coquanbanhanhs) {
			entityCache.removeResult(CoquanbanhanhImpl.class, coquanbanhanh);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CoquanbanhanhImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new coquanbanhanh with the primary key. Does not add the coquanbanhanh to the database.
	 *
	 * @param id the primary key for the new coquanbanhanh
	 * @return the new coquanbanhanh
	 */
	@Override
	public Coquanbanhanh create(long id) {
		Coquanbanhanh coquanbanhanh = new CoquanbanhanhImpl();

		coquanbanhanh.setNew(true);
		coquanbanhanh.setPrimaryKey(id);

		coquanbanhanh.setCompanyId(CompanyThreadLocal.getCompanyId());

		return coquanbanhanh;
	}

	/**
	 * Removes the coquanbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh remove(long id) throws NoSuchCoquanbanhanhException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the coquanbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh remove(Serializable primaryKey)
		throws NoSuchCoquanbanhanhException {

		Session session = null;

		try {
			session = openSession();

			Coquanbanhanh coquanbanhanh = (Coquanbanhanh)session.get(
				CoquanbanhanhImpl.class, primaryKey);

			if (coquanbanhanh == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCoquanbanhanhException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(coquanbanhanh);
		}
		catch (NoSuchCoquanbanhanhException noSuchEntityException) {
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
	protected Coquanbanhanh removeImpl(Coquanbanhanh coquanbanhanh) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(coquanbanhanh)) {
				coquanbanhanh = (Coquanbanhanh)session.get(
					CoquanbanhanhImpl.class, coquanbanhanh.getPrimaryKeyObj());
			}

			if (coquanbanhanh != null) {
				session.delete(coquanbanhanh);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (coquanbanhanh != null) {
			clearCache(coquanbanhanh);
		}

		return coquanbanhanh;
	}

	@Override
	public Coquanbanhanh updateImpl(Coquanbanhanh coquanbanhanh) {
		boolean isNew = coquanbanhanh.isNew();

		if (!(coquanbanhanh instanceof CoquanbanhanhModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(coquanbanhanh.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					coquanbanhanh);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in coquanbanhanh proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Coquanbanhanh implementation " +
					coquanbanhanh.getClass());
		}

		CoquanbanhanhModelImpl coquanbanhanhModelImpl =
			(CoquanbanhanhModelImpl)coquanbanhanh;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(coquanbanhanh);
			}
			else {
				coquanbanhanh = (Coquanbanhanh)session.merge(coquanbanhanh);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CoquanbanhanhImpl.class, coquanbanhanhModelImpl, false, true);

		if (isNew) {
			coquanbanhanh.setNew(false);
		}

		coquanbanhanh.resetOriginalValues();

		return coquanbanhanh;
	}

	/**
	 * Returns the coquanbanhanh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the coquanbanhanh
	 * @return the coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCoquanbanhanhException {

		Coquanbanhanh coquanbanhanh = fetchByPrimaryKey(primaryKey);

		if (coquanbanhanh == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCoquanbanhanhException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return coquanbanhanh;
	}

	/**
	 * Returns the coquanbanhanh with the primary key or throws a <code>NoSuchCoquanbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh findByPrimaryKey(long id)
		throws NoSuchCoquanbanhanhException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the coquanbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh, or <code>null</code> if a coquanbanhanh with the primary key could not be found
	 */
	@Override
	public Coquanbanhanh fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the coquanbanhanhs.
	 *
	 * @return the coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findAll(
		int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coquanbanhanhs
	 */
	@Override
	public List<Coquanbanhanh> findAll(
		int start, int end, OrderByComparator<Coquanbanhanh> orderByComparator,
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

		List<Coquanbanhanh> list = null;

		if (useFinderCache) {
			list = (List<Coquanbanhanh>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COQUANBANHANH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COQUANBANHANH;

				sql = sql.concat(CoquanbanhanhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Coquanbanhanh>)QueryUtil.list(
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
	 * Removes all the coquanbanhanhs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Coquanbanhanh coquanbanhanh : findAll()) {
			remove(coquanbanhanh);
		}
	}

	/**
	 * Returns the number of coquanbanhanhs.
	 *
	 * @return the number of coquanbanhanhs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COQUANBANHANH);

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
		return _SQL_SELECT_COQUANBANHANH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CoquanbanhanhModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the coquanbanhanh persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CoquanbanhanhModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Coquanbanhanh.class.getName()));

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

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_setCoquanbanhanhUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCoquanbanhanhUtilPersistence(null);

		entityCache.removeCache(CoquanbanhanhImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCoquanbanhanhUtilPersistence(
		CoquanbanhanhPersistence coquanbanhanhPersistence) {

		try {
			Field field = CoquanbanhanhUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, coquanbanhanhPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_COQUANBANHANH =
		"SELECT coquanbanhanh FROM Coquanbanhanh coquanbanhanh";

	private static final String _SQL_SELECT_COQUANBANHANH_WHERE =
		"SELECT coquanbanhanh FROM Coquanbanhanh coquanbanhanh WHERE ";

	private static final String _SQL_COUNT_COQUANBANHANH =
		"SELECT COUNT(coquanbanhanh) FROM Coquanbanhanh coquanbanhanh";

	private static final String _SQL_COUNT_COQUANBANHANH_WHERE =
		"SELECT COUNT(coquanbanhanh) FROM Coquanbanhanh coquanbanhanh WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "coquanbanhanh.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Coquanbanhanh exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Coquanbanhanh exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CoquanbanhanhPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "code"});

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

	private static class CoquanbanhanhModelArgumentsResolver
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

			CoquanbanhanhModelImpl coquanbanhanhModelImpl =
				(CoquanbanhanhModelImpl)baseModel;

			long columnBitmask = coquanbanhanhModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(coquanbanhanhModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						coquanbanhanhModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(CoquanbanhanhPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(coquanbanhanhModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CoquanbanhanhModelImpl coquanbanhanhModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						coquanbanhanhModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = coquanbanhanhModelImpl.getColumnValue(
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