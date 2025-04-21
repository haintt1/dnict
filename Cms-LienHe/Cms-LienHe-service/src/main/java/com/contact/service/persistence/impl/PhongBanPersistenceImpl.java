/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.impl;

import com.contact.exception.NoSuchPhongBanException;
import com.contact.model.PhongBan;
import com.contact.model.impl.PhongBanImpl;
import com.contact.model.impl.PhongBanModelImpl;
import com.contact.service.persistence.PhongBanPersistence;
import com.contact.service.persistence.PhongBanUtil;
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
 * The persistence implementation for the phong ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PhongBanPersistence.class)
public class PhongBanPersistenceImpl
	extends BasePersistenceImpl<PhongBan> implements PhongBanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PhongBanUtil</code> to access the phong ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PhongBanImpl.class.getName();

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
	 * Returns all the phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching phong bans
	 */
	@Override
	public List<PhongBan> findByten(String ten) {
		return findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 */
	@Override
	public List<PhongBan> findByten(String ten, int start, int end) {
		return findByten(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 */
	@Override
	public List<PhongBan> findByten(
		String ten, int start, int end,
		OrderByComparator<PhongBan> orderByComparator) {

		return findByten(ten, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phong bans
	 */
	@Override
	public List<PhongBan> findByten(
		String ten, int start, int end,
		OrderByComparator<PhongBan> orderByComparator, boolean useFinderCache) {

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

		List<PhongBan> list = null;

		if (useFinderCache) {
			list = (List<PhongBan>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PhongBan phongBan : list) {
					if (!ten.equals(phongBan.getTen())) {
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

			sb.append(_SQL_SELECT_PHONGBAN_WHERE);

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
				sb.append(PhongBanModelImpl.ORDER_BY_JPQL);
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

				list = (List<PhongBan>)QueryUtil.list(
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
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	@Override
	public PhongBan findByten_First(
			String ten, OrderByComparator<PhongBan> orderByComparator)
		throws NoSuchPhongBanException {

		PhongBan phongBan = fetchByten_First(ten, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchPhongBanException(sb.toString());
	}

	/**
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	@Override
	public PhongBan fetchByten_First(
		String ten, OrderByComparator<PhongBan> orderByComparator) {

		List<PhongBan> list = findByten(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	@Override
	public PhongBan findByten_Last(
			String ten, OrderByComparator<PhongBan> orderByComparator)
		throws NoSuchPhongBanException {

		PhongBan phongBan = fetchByten_Last(ten, orderByComparator);

		if (phongBan != null) {
			return phongBan;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchPhongBanException(sb.toString());
	}

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	@Override
	public PhongBan fetchByten_Last(
		String ten, OrderByComparator<PhongBan> orderByComparator) {

		int count = countByten(ten);

		if (count == 0) {
			return null;
		}

		List<PhongBan> list = findByten(
			ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where ten = &#63;.
	 *
	 * @param phongbanId the primary key of the current phong ban
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan[] findByten_PrevAndNext(
			long phongbanId, String ten,
			OrderByComparator<PhongBan> orderByComparator)
		throws NoSuchPhongBanException {

		ten = Objects.toString(ten, "");

		PhongBan phongBan = findByPrimaryKey(phongbanId);

		Session session = null;

		try {
			session = openSession();

			PhongBan[] array = new PhongBanImpl[3];

			array[0] = getByten_PrevAndNext(
				session, phongBan, ten, orderByComparator, true);

			array[1] = phongBan;

			array[2] = getByten_PrevAndNext(
				session, phongBan, ten, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PhongBan getByten_PrevAndNext(
		Session session, PhongBan phongBan, String ten,
		OrderByComparator<PhongBan> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PHONGBAN_WHERE);

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
			sb.append(PhongBanModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(phongBan)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PhongBan> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the phong bans where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByten(String ten) {
		for (PhongBan phongBan :
				findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching phong bans
	 */
	@Override
	public int countByten(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByten;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PHONGBAN_WHERE);

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

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "phongBan.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(phongBan.ten IS NULL OR phongBan.ten = '')";

	public PhongBanPersistenceImpl() {
		setModelClass(PhongBan.class);

		setModelImplClass(PhongBanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the phong ban in the entity cache if it is enabled.
	 *
	 * @param phongBan the phong ban
	 */
	@Override
	public void cacheResult(PhongBan phongBan) {
		entityCache.putResult(
			PhongBanImpl.class, phongBan.getPrimaryKey(), phongBan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the phong bans in the entity cache if it is enabled.
	 *
	 * @param phongBans the phong bans
	 */
	@Override
	public void cacheResult(List<PhongBan> phongBans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (phongBans.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (PhongBan phongBan : phongBans) {
			if (entityCache.getResult(
					PhongBanImpl.class, phongBan.getPrimaryKey()) == null) {

				cacheResult(phongBan);
			}
		}
	}

	/**
	 * Clears the cache for all phong bans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PhongBanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the phong ban.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PhongBan phongBan) {
		entityCache.removeResult(PhongBanImpl.class, phongBan);
	}

	@Override
	public void clearCache(List<PhongBan> phongBans) {
		for (PhongBan phongBan : phongBans) {
			entityCache.removeResult(PhongBanImpl.class, phongBan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PhongBanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param phongbanId the primary key for the new phong ban
	 * @return the new phong ban
	 */
	@Override
	public PhongBan create(long phongbanId) {
		PhongBan phongBan = new PhongBanImpl();

		phongBan.setNew(true);
		phongBan.setPrimaryKey(phongbanId);

		phongBan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return phongBan;
	}

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan remove(long phongbanId) throws NoSuchPhongBanException {
		return remove((Serializable)phongbanId);
	}

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan remove(Serializable primaryKey)
		throws NoSuchPhongBanException {

		Session session = null;

		try {
			session = openSession();

			PhongBan phongBan = (PhongBan)session.get(
				PhongBanImpl.class, primaryKey);

			if (phongBan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPhongBanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(phongBan);
		}
		catch (NoSuchPhongBanException noSuchEntityException) {
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
	protected PhongBan removeImpl(PhongBan phongBan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(phongBan)) {
				phongBan = (PhongBan)session.get(
					PhongBanImpl.class, phongBan.getPrimaryKeyObj());
			}

			if (phongBan != null) {
				session.delete(phongBan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (phongBan != null) {
			clearCache(phongBan);
		}

		return phongBan;
	}

	@Override
	public PhongBan updateImpl(PhongBan phongBan) {
		boolean isNew = phongBan.isNew();

		if (!(phongBan instanceof PhongBanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(phongBan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(phongBan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in phongBan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PhongBan implementation " +
					phongBan.getClass());
		}

		PhongBanModelImpl phongBanModelImpl = (PhongBanModelImpl)phongBan;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(phongBan);
			}
			else {
				phongBan = (PhongBan)session.merge(phongBan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PhongBanImpl.class, phongBanModelImpl, false, true);

		if (isNew) {
			phongBan.setNew(false);
		}

		phongBan.resetOriginalValues();

		return phongBan;
	}

	/**
	 * Returns the phong ban with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the phong ban
	 * @return the phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPhongBanException {

		PhongBan phongBan = fetchByPrimaryKey(primaryKey);

		if (phongBan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPhongBanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return phongBan;
	}

	/**
	 * Returns the phong ban with the primary key or throws a <code>NoSuchPhongBanException</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan findByPrimaryKey(long phongbanId)
		throws NoSuchPhongBanException {

		return findByPrimaryKey((Serializable)phongbanId);
	}

	/**
	 * Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	 */
	@Override
	public PhongBan fetchByPrimaryKey(long phongbanId) {
		return fetchByPrimaryKey((Serializable)phongbanId);
	}

	/**
	 * Returns all the phong bans.
	 *
	 * @return the phong bans
	 */
	@Override
	public List<PhongBan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 */
	@Override
	public List<PhongBan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong bans
	 */
	@Override
	public List<PhongBan> findAll(
		int start, int end, OrderByComparator<PhongBan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phong bans
	 */
	@Override
	public List<PhongBan> findAll(
		int start, int end, OrderByComparator<PhongBan> orderByComparator,
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

		List<PhongBan> list = null;

		if (useFinderCache) {
			list = (List<PhongBan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PHONGBAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PHONGBAN;

				sql = sql.concat(PhongBanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PhongBan>)QueryUtil.list(
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
	 * Removes all the phong bans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PhongBan phongBan : findAll()) {
			remove(phongBan);
		}
	}

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PHONGBAN);

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
		return "phongbanId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PHONGBAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PhongBanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the phong ban persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PhongBanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PhongBan.class.getName()));

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

		PhongBanUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PhongBanUtil.setPersistence(null);

		entityCache.removeCache(PhongBanImpl.class.getName());

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

	private static final String _SQL_SELECT_PHONGBAN =
		"SELECT phongBan FROM PhongBan phongBan";

	private static final String _SQL_SELECT_PHONGBAN_WHERE =
		"SELECT phongBan FROM PhongBan phongBan WHERE ";

	private static final String _SQL_COUNT_PHONGBAN =
		"SELECT COUNT(phongBan) FROM PhongBan phongBan";

	private static final String _SQL_COUNT_PHONGBAN_WHERE =
		"SELECT COUNT(phongBan) FROM PhongBan phongBan WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "phongBan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PhongBan exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PhongBan exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PhongBanPersistenceImpl.class);

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

	private static class PhongBanModelArgumentsResolver
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

			PhongBanModelImpl phongBanModelImpl = (PhongBanModelImpl)baseModel;

			long columnBitmask = phongBanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(phongBanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						phongBanModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(PhongBanPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(phongBanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			PhongBanModelImpl phongBanModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = phongBanModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = phongBanModelImpl.getColumnValue(columnName);
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