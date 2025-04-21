/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.impl;

import com.contact.exception.NoSuchToChucException;
import com.contact.model.ToChuc;
import com.contact.model.impl.ToChucImpl;
import com.contact.model.impl.ToChucModelImpl;
import com.contact.service.persistence.ToChucPersistence;
import com.contact.service.persistence.ToChucUtil;
import com.contact.service.persistence.impl.constants.CmsLienHePersistenceConstants;

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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the to chuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ToChucPersistence.class)
public class ToChucPersistenceImpl
	extends BasePersistenceImpl<ToChuc> implements ToChucPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ToChucUtil</code> to access the to chuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ToChucImpl.class.getName();

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
	 * Returns all the to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching to chucs
	 */
	@Override
	public List<ToChuc> findByten(String ten) {
		return findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of matching to chucs
	 */
	@Override
	public List<ToChuc> findByten(String ten, int start, int end) {
		return findByten(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching to chucs
	 */
	@Override
	public List<ToChuc> findByten(
		String ten, int start, int end,
		OrderByComparator<ToChuc> orderByComparator) {

		return findByten(ten, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching to chucs
	 */
	@Override
	public List<ToChuc> findByten(
		String ten, int start, int end,
		OrderByComparator<ToChuc> orderByComparator, boolean useFinderCache) {

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

		List<ToChuc> list = null;

		if (useFinderCache) {
			list = (List<ToChuc>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ToChuc toChuc : list) {
					if (!ten.equals(toChuc.getTen())) {
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

			sb.append(_SQL_SELECT_TOCHUC_WHERE);

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
				sb.append(ToChucModelImpl.ORDER_BY_JPQL);
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

				list = (List<ToChuc>)QueryUtil.list(
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
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	@Override
	public ToChuc findByten_First(
			String ten, OrderByComparator<ToChuc> orderByComparator)
		throws NoSuchToChucException {

		ToChuc toChuc = fetchByten_First(ten, orderByComparator);

		if (toChuc != null) {
			return toChuc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchToChucException(sb.toString());
	}

	/**
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	@Override
	public ToChuc fetchByten_First(
		String ten, OrderByComparator<ToChuc> orderByComparator) {

		List<ToChuc> list = findByten(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	@Override
	public ToChuc findByten_Last(
			String ten, OrderByComparator<ToChuc> orderByComparator)
		throws NoSuchToChucException {

		ToChuc toChuc = fetchByten_Last(ten, orderByComparator);

		if (toChuc != null) {
			return toChuc;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchToChucException(sb.toString());
	}

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	@Override
	public ToChuc fetchByten_Last(
		String ten, OrderByComparator<ToChuc> orderByComparator) {

		int count = countByten(ten);

		if (count == 0) {
			return null;
		}

		List<ToChuc> list = findByten(ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the to chucs before and after the current to chuc in the ordered set where ten = &#63;.
	 *
	 * @param tochucId the primary key of the current to chuc
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc[] findByten_PrevAndNext(
			long tochucId, String ten,
			OrderByComparator<ToChuc> orderByComparator)
		throws NoSuchToChucException {

		ten = Objects.toString(ten, "");

		ToChuc toChuc = findByPrimaryKey(tochucId);

		Session session = null;

		try {
			session = openSession();

			ToChuc[] array = new ToChucImpl[3];

			array[0] = getByten_PrevAndNext(
				session, toChuc, ten, orderByComparator, true);

			array[1] = toChuc;

			array[2] = getByten_PrevAndNext(
				session, toChuc, ten, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ToChuc getByten_PrevAndNext(
		Session session, ToChuc toChuc, String ten,
		OrderByComparator<ToChuc> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TOCHUC_WHERE);

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
			sb.append(ToChucModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(toChuc)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ToChuc> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the to chucs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByten(String ten) {
		for (ToChuc toChuc :
				findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(toChuc);
		}
	}

	/**
	 * Returns the number of to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching to chucs
	 */
	@Override
	public int countByten(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByten;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TOCHUC_WHERE);

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

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "toChuc.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(toChuc.ten IS NULL OR toChuc.ten = '')";

	public ToChucPersistenceImpl() {
		setModelClass(ToChuc.class);

		setModelImplClass(ToChucImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the to chuc in the entity cache if it is enabled.
	 *
	 * @param toChuc the to chuc
	 */
	@Override
	public void cacheResult(ToChuc toChuc) {
		entityCache.putResult(ToChucImpl.class, toChuc.getPrimaryKey(), toChuc);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the to chucs in the entity cache if it is enabled.
	 *
	 * @param toChucs the to chucs
	 */
	@Override
	public void cacheResult(List<ToChuc> toChucs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (toChucs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ToChuc toChuc : toChucs) {
			if (entityCache.getResult(
					ToChucImpl.class, toChuc.getPrimaryKey()) == null) {

				cacheResult(toChuc);
			}
		}
	}

	/**
	 * Clears the cache for all to chucs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ToChucImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the to chuc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ToChuc toChuc) {
		entityCache.removeResult(ToChucImpl.class, toChuc);
	}

	@Override
	public void clearCache(List<ToChuc> toChucs) {
		for (ToChuc toChuc : toChucs) {
			entityCache.removeResult(ToChucImpl.class, toChuc);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ToChucImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new to chuc with the primary key. Does not add the to chuc to the database.
	 *
	 * @param tochucId the primary key for the new to chuc
	 * @return the new to chuc
	 */
	@Override
	public ToChuc create(long tochucId) {
		ToChuc toChuc = new ToChucImpl();

		toChuc.setNew(true);
		toChuc.setPrimaryKey(tochucId);

		toChuc.setCompanyId(CompanyThreadLocal.getCompanyId());

		return toChuc;
	}

	/**
	 * Removes the to chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc that was removed
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc remove(long tochucId) throws NoSuchToChucException {
		return remove((Serializable)tochucId);
	}

	/**
	 * Removes the to chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the to chuc
	 * @return the to chuc that was removed
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc remove(Serializable primaryKey) throws NoSuchToChucException {
		Session session = null;

		try {
			session = openSession();

			ToChuc toChuc = (ToChuc)session.get(ToChucImpl.class, primaryKey);

			if (toChuc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchToChucException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(toChuc);
		}
		catch (NoSuchToChucException noSuchEntityException) {
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
	protected ToChuc removeImpl(ToChuc toChuc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(toChuc)) {
				toChuc = (ToChuc)session.get(
					ToChucImpl.class, toChuc.getPrimaryKeyObj());
			}

			if (toChuc != null) {
				session.delete(toChuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (toChuc != null) {
			clearCache(toChuc);
		}

		return toChuc;
	}

	@Override
	public ToChuc updateImpl(ToChuc toChuc) {
		boolean isNew = toChuc.isNew();

		if (!(toChuc instanceof ToChucModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(toChuc.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(toChuc);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in toChuc proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ToChuc implementation " +
					toChuc.getClass());
		}

		ToChucModelImpl toChucModelImpl = (ToChucModelImpl)toChuc;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(toChuc);
			}
			else {
				toChuc = (ToChuc)session.merge(toChuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ToChucImpl.class, toChucModelImpl, false, true);

		if (isNew) {
			toChuc.setNew(false);
		}

		toChuc.resetOriginalValues();

		return toChuc;
	}

	/**
	 * Returns the to chuc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the to chuc
	 * @return the to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchToChucException {

		ToChuc toChuc = fetchByPrimaryKey(primaryKey);

		if (toChuc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchToChucException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return toChuc;
	}

	/**
	 * Returns the to chuc with the primary key or throws a <code>NoSuchToChucException</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc findByPrimaryKey(long tochucId) throws NoSuchToChucException {
		return findByPrimaryKey((Serializable)tochucId);
	}

	/**
	 * Returns the to chuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc, or <code>null</code> if a to chuc with the primary key could not be found
	 */
	@Override
	public ToChuc fetchByPrimaryKey(long tochucId) {
		return fetchByPrimaryKey((Serializable)tochucId);
	}

	/**
	 * Returns all the to chucs.
	 *
	 * @return the to chucs
	 */
	@Override
	public List<ToChuc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of to chucs
	 */
	@Override
	public List<ToChuc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of to chucs
	 */
	@Override
	public List<ToChuc> findAll(
		int start, int end, OrderByComparator<ToChuc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of to chucs
	 */
	@Override
	public List<ToChuc> findAll(
		int start, int end, OrderByComparator<ToChuc> orderByComparator,
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

		List<ToChuc> list = null;

		if (useFinderCache) {
			list = (List<ToChuc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TOCHUC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TOCHUC;

				sql = sql.concat(ToChucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ToChuc>)QueryUtil.list(
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
	 * Removes all the to chucs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ToChuc toChuc : findAll()) {
			remove(toChuc);
		}
	}

	/**
	 * Returns the number of to chucs.
	 *
	 * @return the number of to chucs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TOCHUC);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "tochucId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TOCHUC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ToChucModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the to chuc persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ToChucModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ToChuc.class.getName()));

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

		ToChucUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ToChucUtil.setPersistence(null);

		entityCache.removeCache(ToChucImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = CmsLienHePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CmsLienHePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CmsLienHePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_TOCHUC =
		"SELECT toChuc FROM ToChuc toChuc";

	private static final String _SQL_SELECT_TOCHUC_WHERE =
		"SELECT toChuc FROM ToChuc toChuc WHERE ";

	private static final String _SQL_COUNT_TOCHUC =
		"SELECT COUNT(toChuc) FROM ToChuc toChuc";

	private static final String _SQL_COUNT_TOCHUC_WHERE =
		"SELECT COUNT(toChuc) FROM ToChuc toChuc WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "toChuc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ToChuc exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ToChuc exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ToChucPersistenceImpl.class);

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

	private static class ToChucModelArgumentsResolver
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

			ToChucModelImpl toChucModelImpl = (ToChucModelImpl)baseModel;

			long columnBitmask = toChucModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(toChucModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= toChucModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(ToChucPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(toChucModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ToChucModelImpl toChucModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = toChucModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = toChucModelImpl.getColumnValue(columnName);
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