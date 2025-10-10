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

import vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;
import vn.dnict.vanbanphapquy.model.impl.VanbanphapquyImpl;
import vn.dnict.vanbanphapquy.model.impl.VanbanphapquyModelImpl;
import vn.dnict.vanbanphapquy.service.persistence.VanbanphapquyPersistence;
import vn.dnict.vanbanphapquy.service.persistence.VanbanphapquyUtil;
import vn.dnict.vanbanphapquy.service.persistence.impl.constants.BinhNTPersistenceConstants;

/**
 * The persistence implementation for the vanbanphapquy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @generated
 */
@Component(service = VanbanphapquyPersistence.class)
public class VanbanphapquyPersistenceImpl
	extends BasePersistenceImpl<Vanbanphapquy>
	implements VanbanphapquyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>VanbanphapquyUtil</code> to access the vanbanphapquy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		VanbanphapquyImpl.class.getName();

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
	 * Returns all the vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of matching vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator,
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

		List<Vanbanphapquy> list = null;

		if (useFinderCache) {
			list = (List<Vanbanphapquy>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Vanbanphapquy vanbanphapquy : list) {
					if (status != vanbanphapquy.getStatus()) {
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

			sb.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(VanbanphapquyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<Vanbanphapquy>)QueryUtil.list(
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
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	@Override
	public Vanbanphapquy findByStatus_First(
			int status, OrderByComparator<Vanbanphapquy> orderByComparator)
		throws NoSuchVanbanphapquyException {

		Vanbanphapquy vanbanphapquy = fetchByStatus_First(
			status, orderByComparator);

		if (vanbanphapquy != null) {
			return vanbanphapquy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchVanbanphapquyException(sb.toString());
	}

	/**
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	@Override
	public Vanbanphapquy fetchByStatus_First(
		int status, OrderByComparator<Vanbanphapquy> orderByComparator) {

		List<Vanbanphapquy> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	@Override
	public Vanbanphapquy findByStatus_Last(
			int status, OrderByComparator<Vanbanphapquy> orderByComparator)
		throws NoSuchVanbanphapquyException {

		Vanbanphapquy vanbanphapquy = fetchByStatus_Last(
			status, orderByComparator);

		if (vanbanphapquy != null) {
			return vanbanphapquy;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchVanbanphapquyException(sb.toString());
	}

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	@Override
	public Vanbanphapquy fetchByStatus_Last(
		int status, OrderByComparator<Vanbanphapquy> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<Vanbanphapquy> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vanbanphapquys before and after the current vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current vanbanphapquy
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Vanbanphapquy> orderByComparator)
		throws NoSuchVanbanphapquyException {

		Vanbanphapquy vanbanphapquy = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Vanbanphapquy[] array = new VanbanphapquyImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, vanbanphapquy, status, orderByComparator, true);

			array[1] = vanbanphapquy;

			array[2] = getByStatus_PrevAndNext(
				session, vanbanphapquy, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Vanbanphapquy getByStatus_PrevAndNext(
		Session session, Vanbanphapquy vanbanphapquy, int status,
		OrderByComparator<Vanbanphapquy> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VANBANPHAPQUY_WHERE);

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
			sb.append(VanbanphapquyModelImpl.ORDER_BY_JPQL);
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
						vanbanphapquy)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Vanbanphapquy> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vanbanphapquys where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (Vanbanphapquy vanbanphapquy :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(vanbanphapquy);
		}
	}

	/**
	 * Returns the number of vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching vanbanphapquys
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VANBANPHAPQUY_WHERE);

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
		"vanbanphapquy.status = ?";

	public VanbanphapquyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Vanbanphapquy.class);

		setModelImplClass(VanbanphapquyImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the vanbanphapquy in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 */
	@Override
	public void cacheResult(Vanbanphapquy vanbanphapquy) {
		entityCache.putResult(
			VanbanphapquyImpl.class, vanbanphapquy.getPrimaryKey(),
			vanbanphapquy);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the vanbanphapquys in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquys the vanbanphapquys
	 */
	@Override
	public void cacheResult(List<Vanbanphapquy> vanbanphapquys) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (vanbanphapquys.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Vanbanphapquy vanbanphapquy : vanbanphapquys) {
			if (entityCache.getResult(
					VanbanphapquyImpl.class, vanbanphapquy.getPrimaryKey()) ==
						null) {

				cacheResult(vanbanphapquy);
			}
		}
	}

	/**
	 * Clears the cache for all vanbanphapquys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(VanbanphapquyImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vanbanphapquy.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Vanbanphapquy vanbanphapquy) {
		entityCache.removeResult(VanbanphapquyImpl.class, vanbanphapquy);
	}

	@Override
	public void clearCache(List<Vanbanphapquy> vanbanphapquys) {
		for (Vanbanphapquy vanbanphapquy : vanbanphapquys) {
			entityCache.removeResult(VanbanphapquyImpl.class, vanbanphapquy);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(VanbanphapquyImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new vanbanphapquy with the primary key. Does not add the vanbanphapquy to the database.
	 *
	 * @param id the primary key for the new vanbanphapquy
	 * @return the new vanbanphapquy
	 */
	@Override
	public Vanbanphapquy create(long id) {
		Vanbanphapquy vanbanphapquy = new VanbanphapquyImpl();

		vanbanphapquy.setNew(true);
		vanbanphapquy.setPrimaryKey(id);

		vanbanphapquy.setCompanyId(CompanyThreadLocal.getCompanyId());

		return vanbanphapquy;
	}

	/**
	 * Removes the vanbanphapquy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy remove(long id) throws NoSuchVanbanphapquyException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vanbanphapquy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy remove(Serializable primaryKey)
		throws NoSuchVanbanphapquyException {

		Session session = null;

		try {
			session = openSession();

			Vanbanphapquy vanbanphapquy = (Vanbanphapquy)session.get(
				VanbanphapquyImpl.class, primaryKey);

			if (vanbanphapquy == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVanbanphapquyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vanbanphapquy);
		}
		catch (NoSuchVanbanphapquyException noSuchEntityException) {
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
	protected Vanbanphapquy removeImpl(Vanbanphapquy vanbanphapquy) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vanbanphapquy)) {
				vanbanphapquy = (Vanbanphapquy)session.get(
					VanbanphapquyImpl.class, vanbanphapquy.getPrimaryKeyObj());
			}

			if (vanbanphapquy != null) {
				session.delete(vanbanphapquy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (vanbanphapquy != null) {
			clearCache(vanbanphapquy);
		}

		return vanbanphapquy;
	}

	@Override
	public Vanbanphapquy updateImpl(Vanbanphapquy vanbanphapquy) {
		boolean isNew = vanbanphapquy.isNew();

		if (!(vanbanphapquy instanceof VanbanphapquyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(vanbanphapquy.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					vanbanphapquy);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in vanbanphapquy proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Vanbanphapquy implementation " +
					vanbanphapquy.getClass());
		}

		VanbanphapquyModelImpl vanbanphapquyModelImpl =
			(VanbanphapquyModelImpl)vanbanphapquy;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(vanbanphapquy);
			}
			else {
				vanbanphapquy = (Vanbanphapquy)session.merge(vanbanphapquy);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			VanbanphapquyImpl.class, vanbanphapquyModelImpl, false, true);

		if (isNew) {
			vanbanphapquy.setNew(false);
		}

		vanbanphapquy.resetOriginalValues();

		return vanbanphapquy;
	}

	/**
	 * Returns the vanbanphapquy with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vanbanphapquy
	 * @return the vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVanbanphapquyException {

		Vanbanphapquy vanbanphapquy = fetchByPrimaryKey(primaryKey);

		if (vanbanphapquy == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVanbanphapquyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vanbanphapquy;
	}

	/**
	 * Returns the vanbanphapquy with the primary key or throws a <code>NoSuchVanbanphapquyException</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy findByPrimaryKey(long id)
		throws NoSuchVanbanphapquyException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vanbanphapquy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy, or <code>null</code> if a vanbanphapquy with the primary key could not be found
	 */
	@Override
	public Vanbanphapquy fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the vanbanphapquys.
	 *
	 * @return the vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findAll(
		int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vanbanphapquys
	 */
	@Override
	public List<Vanbanphapquy> findAll(
		int start, int end, OrderByComparator<Vanbanphapquy> orderByComparator,
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

		List<Vanbanphapquy> list = null;

		if (useFinderCache) {
			list = (List<Vanbanphapquy>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VANBANPHAPQUY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VANBANPHAPQUY;

				sql = sql.concat(VanbanphapquyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Vanbanphapquy>)QueryUtil.list(
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
	 * Removes all the vanbanphapquys from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Vanbanphapquy vanbanphapquy : findAll()) {
			remove(vanbanphapquy);
		}
	}

	/**
	 * Returns the number of vanbanphapquys.
	 *
	 * @return the number of vanbanphapquys
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VANBANPHAPQUY);

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
		return _SQL_SELECT_VANBANPHAPQUY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return VanbanphapquyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vanbanphapquy persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new VanbanphapquyModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Vanbanphapquy.class.getName()));

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

		_setVanbanphapquyUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setVanbanphapquyUtilPersistence(null);

		entityCache.removeCache(VanbanphapquyImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setVanbanphapquyUtilPersistence(
		VanbanphapquyPersistence vanbanphapquyPersistence) {

		try {
			Field field = VanbanphapquyUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, vanbanphapquyPersistence);
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

	private static final String _SQL_SELECT_VANBANPHAPQUY =
		"SELECT vanbanphapquy FROM Vanbanphapquy vanbanphapquy";

	private static final String _SQL_SELECT_VANBANPHAPQUY_WHERE =
		"SELECT vanbanphapquy FROM Vanbanphapquy vanbanphapquy WHERE ";

	private static final String _SQL_COUNT_VANBANPHAPQUY =
		"SELECT COUNT(vanbanphapquy) FROM Vanbanphapquy vanbanphapquy";

	private static final String _SQL_COUNT_VANBANPHAPQUY_WHERE =
		"SELECT COUNT(vanbanphapquy) FROM Vanbanphapquy vanbanphapquy WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vanbanphapquy.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Vanbanphapquy exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Vanbanphapquy exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		VanbanphapquyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "type"});

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

	private static class VanbanphapquyModelArgumentsResolver
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

			VanbanphapquyModelImpl vanbanphapquyModelImpl =
				(VanbanphapquyModelImpl)baseModel;

			long columnBitmask = vanbanphapquyModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(vanbanphapquyModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						vanbanphapquyModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(VanbanphapquyPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(vanbanphapquyModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			VanbanphapquyModelImpl vanbanphapquyModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						vanbanphapquyModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = vanbanphapquyModelImpl.getColumnValue(
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

			orderByColumnsBitmask |= VanbanphapquyModelImpl.getColumnBitmask(
				"ngay_xuatban");

			_ORDER_BY_COLUMNS_BITMASK = orderByColumnsBitmask;
		}

	}

}