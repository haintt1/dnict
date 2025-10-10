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

import vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException;
import vn.dnict.vanbanphapquy.model.Capbanhanh;
import vn.dnict.vanbanphapquy.model.impl.CapbanhanhImpl;
import vn.dnict.vanbanphapquy.model.impl.CapbanhanhModelImpl;
import vn.dnict.vanbanphapquy.service.persistence.CapbanhanhPersistence;
import vn.dnict.vanbanphapquy.service.persistence.CapbanhanhUtil;
import vn.dnict.vanbanphapquy.service.persistence.impl.constants.BinhNTPersistenceConstants;

/**
 * The persistence implementation for the capbanhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @generated
 */
@Component(service = CapbanhanhPersistence.class)
public class CapbanhanhPersistenceImpl
	extends BasePersistenceImpl<Capbanhanh> implements CapbanhanhPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CapbanhanhUtil</code> to access the capbanhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CapbanhanhImpl.class.getName();

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
	 * Returns all the capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of matching capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Capbanhanh> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Capbanhanh> orderByComparator,
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

		List<Capbanhanh> list = null;

		if (useFinderCache) {
			list = (List<Capbanhanh>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Capbanhanh capbanhanh : list) {
					if (status != capbanhanh.getStatus()) {
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

			sb.append(_SQL_SELECT_CAPBANHANH_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CapbanhanhModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Capbanhanh>)QueryUtil.list(
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
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	@Override
	public Capbanhanh findByStatus_First(
			int status, OrderByComparator<Capbanhanh> orderByComparator)
		throws NoSuchCapbanhanhException {

		Capbanhanh capbanhanh = fetchByStatus_First(status, orderByComparator);

		if (capbanhanh != null) {
			return capbanhanh;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCapbanhanhException(sb.toString());
	}

	/**
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	@Override
	public Capbanhanh fetchByStatus_First(
		int status, OrderByComparator<Capbanhanh> orderByComparator) {

		List<Capbanhanh> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	@Override
	public Capbanhanh findByStatus_Last(
			int status, OrderByComparator<Capbanhanh> orderByComparator)
		throws NoSuchCapbanhanhException {

		Capbanhanh capbanhanh = fetchByStatus_Last(status, orderByComparator);

		if (capbanhanh != null) {
			return capbanhanh;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchCapbanhanhException(sb.toString());
	}

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	@Override
	public Capbanhanh fetchByStatus_Last(
		int status, OrderByComparator<Capbanhanh> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Capbanhanh> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the capbanhanhs before and after the current capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current capbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Capbanhanh> orderByComparator)
		throws NoSuchCapbanhanhException {

		Capbanhanh capbanhanh = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Capbanhanh[] array = new CapbanhanhImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, capbanhanh, status, orderByComparator, true);

			array[1] = capbanhanh;

			array[2] = getByStatus_PrevAndNext(
				session, capbanhanh, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Capbanhanh getByStatus_PrevAndNext(
		Session session, Capbanhanh capbanhanh, int status,
		OrderByComparator<Capbanhanh> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CAPBANHANH_WHERE);

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
			sb.append(CapbanhanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(capbanhanh)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Capbanhanh> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the capbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Capbanhanh capbanhanh :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(capbanhanh);
		}
	}

	/**
	 * Returns the number of capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching capbanhanhs
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CAPBANHANH_WHERE);

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
		"capbanhanh.status = ?";

	public CapbanhanhPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Capbanhanh.class);

		setModelImplClass(CapbanhanhImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the capbanhanh in the entity cache if it is enabled.
	 *
	 * @param capbanhanh the capbanhanh
	 */
	@Override
	public void cacheResult(Capbanhanh capbanhanh) {
		entityCache.putResult(
			CapbanhanhImpl.class, capbanhanh.getPrimaryKey(), capbanhanh);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the capbanhanhs in the entity cache if it is enabled.
	 *
	 * @param capbanhanhs the capbanhanhs
	 */
	@Override
	public void cacheResult(List<Capbanhanh> capbanhanhs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (capbanhanhs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Capbanhanh capbanhanh : capbanhanhs) {
			if (entityCache.getResult(
					CapbanhanhImpl.class, capbanhanh.getPrimaryKey()) == null) {

				cacheResult(capbanhanh);
			}
		}
	}

	/**
	 * Clears the cache for all capbanhanhs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CapbanhanhImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the capbanhanh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Capbanhanh capbanhanh) {
		entityCache.removeResult(CapbanhanhImpl.class, capbanhanh);
	}

	@Override
	public void clearCache(List<Capbanhanh> capbanhanhs) {
		for (Capbanhanh capbanhanh : capbanhanhs) {
			entityCache.removeResult(CapbanhanhImpl.class, capbanhanh);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CapbanhanhImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new capbanhanh with the primary key. Does not add the capbanhanh to the database.
	 *
	 * @param id the primary key for the new capbanhanh
	 * @return the new capbanhanh
	 */
	@Override
	public Capbanhanh create(long id) {
		Capbanhanh capbanhanh = new CapbanhanhImpl();

		capbanhanh.setNew(true);
		capbanhanh.setPrimaryKey(id);

		capbanhanh.setCompanyId(CompanyThreadLocal.getCompanyId());

		return capbanhanh;
	}

	/**
	 * Removes the capbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh that was removed
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh remove(long id) throws NoSuchCapbanhanhException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the capbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the capbanhanh
	 * @return the capbanhanh that was removed
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh remove(Serializable primaryKey)
		throws NoSuchCapbanhanhException {

		Session session = null;

		try {
			session = openSession();

			Capbanhanh capbanhanh = (Capbanhanh)session.get(
				CapbanhanhImpl.class, primaryKey);

			if (capbanhanh == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapbanhanhException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(capbanhanh);
		}
		catch (NoSuchCapbanhanhException noSuchEntityException) {
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
	protected Capbanhanh removeImpl(Capbanhanh capbanhanh) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(capbanhanh)) {
				capbanhanh = (Capbanhanh)session.get(
					CapbanhanhImpl.class, capbanhanh.getPrimaryKeyObj());
			}

			if (capbanhanh != null) {
				session.delete(capbanhanh);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (capbanhanh != null) {
			clearCache(capbanhanh);
		}

		return capbanhanh;
	}

	@Override
	public Capbanhanh updateImpl(Capbanhanh capbanhanh) {
		boolean isNew = capbanhanh.isNew();

		if (!(capbanhanh instanceof CapbanhanhModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(capbanhanh.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(capbanhanh);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in capbanhanh proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Capbanhanh implementation " +
					capbanhanh.getClass());
		}

		CapbanhanhModelImpl capbanhanhModelImpl =
			(CapbanhanhModelImpl)capbanhanh;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(capbanhanh);
			}
			else {
				capbanhanh = (Capbanhanh)session.merge(capbanhanh);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CapbanhanhImpl.class, capbanhanhModelImpl, false, true);

		if (isNew) {
			capbanhanh.setNew(false);
		}

		capbanhanh.resetOriginalValues();

		return capbanhanh;
	}

	/**
	 * Returns the capbanhanh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the capbanhanh
	 * @return the capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCapbanhanhException {

		Capbanhanh capbanhanh = fetchByPrimaryKey(primaryKey);

		if (capbanhanh == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCapbanhanhException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return capbanhanh;
	}

	/**
	 * Returns the capbanhanh with the primary key or throws a <code>NoSuchCapbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh findByPrimaryKey(long id)
		throws NoSuchCapbanhanhException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the capbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh, or <code>null</code> if a capbanhanh with the primary key could not be found
	 */
	@Override
	public Capbanhanh fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the capbanhanhs.
	 *
	 * @return the capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findAll(
		int start, int end, OrderByComparator<Capbanhanh> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of capbanhanhs
	 */
	@Override
	public List<Capbanhanh> findAll(
		int start, int end, OrderByComparator<Capbanhanh> orderByComparator,
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

		List<Capbanhanh> list = null;

		if (useFinderCache) {
			list = (List<Capbanhanh>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CAPBANHANH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CAPBANHANH;

				sql = sql.concat(CapbanhanhModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Capbanhanh>)QueryUtil.list(
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
	 * Removes all the capbanhanhs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Capbanhanh capbanhanh : findAll()) {
			remove(capbanhanh);
		}
	}

	/**
	 * Returns the number of capbanhanhs.
	 *
	 * @return the number of capbanhanhs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CAPBANHANH);

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
		return _SQL_SELECT_CAPBANHANH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CapbanhanhModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the capbanhanh persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CapbanhanhModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Capbanhanh.class.getName()));

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

		_setCapbanhanhUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setCapbanhanhUtilPersistence(null);

		entityCache.removeCache(CapbanhanhImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setCapbanhanhUtilPersistence(
		CapbanhanhPersistence capbanhanhPersistence) {

		try {
			Field field = CapbanhanhUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, capbanhanhPersistence);
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

	private static final String _SQL_SELECT_CAPBANHANH =
		"SELECT capbanhanh FROM Capbanhanh capbanhanh";

	private static final String _SQL_SELECT_CAPBANHANH_WHERE =
		"SELECT capbanhanh FROM Capbanhanh capbanhanh WHERE ";

	private static final String _SQL_COUNT_CAPBANHANH =
		"SELECT COUNT(capbanhanh) FROM Capbanhanh capbanhanh";

	private static final String _SQL_COUNT_CAPBANHANH_WHERE =
		"SELECT COUNT(capbanhanh) FROM Capbanhanh capbanhanh WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "capbanhanh.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Capbanhanh exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Capbanhanh exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CapbanhanhPersistenceImpl.class);

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

	private static class CapbanhanhModelArgumentsResolver
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

			CapbanhanhModelImpl capbanhanhModelImpl =
				(CapbanhanhModelImpl)baseModel;

			long columnBitmask = capbanhanhModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(capbanhanhModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						capbanhanhModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(CapbanhanhPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(capbanhanhModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CapbanhanhModelImpl capbanhanhModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = capbanhanhModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = capbanhanhModelImpl.getColumnValue(
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