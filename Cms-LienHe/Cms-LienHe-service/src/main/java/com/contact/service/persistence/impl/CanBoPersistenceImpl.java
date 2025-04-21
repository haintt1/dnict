/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence.impl;

import com.contact.exception.NoSuchCanBoException;
import com.contact.model.CanBo;
import com.contact.model.impl.CanBoImpl;
import com.contact.model.impl.CanBoModelImpl;
import com.contact.service.persistence.CanBoPersistence;
import com.contact.service.persistence.CanBoUtil;
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
 * The persistence implementation for the can bo service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CanBoPersistence.class)
public class CanBoPersistenceImpl
	extends BasePersistenceImpl<CanBo> implements CanBoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CanBoUtil</code> to access the can bo persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CanBoImpl.class.getName();

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
	 * Returns all the can bos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching can bos
	 */
	@Override
	public List<CanBo> findByten(String ten) {
		return findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @return the range of matching can bos
	 */
	@Override
	public List<CanBo> findByten(String ten, int start, int end) {
		return findByten(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching can bos
	 */
	@Override
	public List<CanBo> findByten(
		String ten, int start, int end,
		OrderByComparator<CanBo> orderByComparator) {

		return findByten(ten, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching can bos
	 */
	@Override
	public List<CanBo> findByten(
		String ten, int start, int end,
		OrderByComparator<CanBo> orderByComparator, boolean useFinderCache) {

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

		List<CanBo> list = null;

		if (useFinderCache) {
			list = (List<CanBo>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CanBo canBo : list) {
					if (!ten.equals(canBo.getTen())) {
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

			sb.append(_SQL_SELECT_CANBO_WHERE);

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
				sb.append(CanBoModelImpl.ORDER_BY_JPQL);
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

				list = (List<CanBo>)QueryUtil.list(
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
	 * Returns the first can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching can bo
	 * @throws NoSuchCanBoException if a matching can bo could not be found
	 */
	@Override
	public CanBo findByten_First(
			String ten, OrderByComparator<CanBo> orderByComparator)
		throws NoSuchCanBoException {

		CanBo canBo = fetchByten_First(ten, orderByComparator);

		if (canBo != null) {
			return canBo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchCanBoException(sb.toString());
	}

	/**
	 * Returns the first can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching can bo, or <code>null</code> if a matching can bo could not be found
	 */
	@Override
	public CanBo fetchByten_First(
		String ten, OrderByComparator<CanBo> orderByComparator) {

		List<CanBo> list = findByten(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching can bo
	 * @throws NoSuchCanBoException if a matching can bo could not be found
	 */
	@Override
	public CanBo findByten_Last(
			String ten, OrderByComparator<CanBo> orderByComparator)
		throws NoSuchCanBoException {

		CanBo canBo = fetchByten_Last(ten, orderByComparator);

		if (canBo != null) {
			return canBo;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchCanBoException(sb.toString());
	}

	/**
	 * Returns the last can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching can bo, or <code>null</code> if a matching can bo could not be found
	 */
	@Override
	public CanBo fetchByten_Last(
		String ten, OrderByComparator<CanBo> orderByComparator) {

		int count = countByten(ten);

		if (count == 0) {
			return null;
		}

		List<CanBo> list = findByten(ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the can bos before and after the current can bo in the ordered set where ten = &#63;.
	 *
	 * @param canboId the primary key of the current can bo
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next can bo
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo[] findByten_PrevAndNext(
			long canboId, String ten,
			OrderByComparator<CanBo> orderByComparator)
		throws NoSuchCanBoException {

		ten = Objects.toString(ten, "");

		CanBo canBo = findByPrimaryKey(canboId);

		Session session = null;

		try {
			session = openSession();

			CanBo[] array = new CanBoImpl[3];

			array[0] = getByten_PrevAndNext(
				session, canBo, ten, orderByComparator, true);

			array[1] = canBo;

			array[2] = getByten_PrevAndNext(
				session, canBo, ten, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CanBo getByten_PrevAndNext(
		Session session, CanBo canBo, String ten,
		OrderByComparator<CanBo> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CANBO_WHERE);

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
			sb.append(CanBoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(canBo)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CanBo> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the can bos where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByten(String ten) {
		for (CanBo canBo :
				findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(canBo);
		}
	}

	/**
	 * Returns the number of can bos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching can bos
	 */
	@Override
	public int countByten(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByten;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CANBO_WHERE);

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

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "canBo.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(canBo.ten IS NULL OR canBo.ten = '')";

	public CanBoPersistenceImpl() {
		setModelClass(CanBo.class);

		setModelImplClass(CanBoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the can bo in the entity cache if it is enabled.
	 *
	 * @param canBo the can bo
	 */
	@Override
	public void cacheResult(CanBo canBo) {
		entityCache.putResult(CanBoImpl.class, canBo.getPrimaryKey(), canBo);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the can bos in the entity cache if it is enabled.
	 *
	 * @param canBos the can bos
	 */
	@Override
	public void cacheResult(List<CanBo> canBos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (canBos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CanBo canBo : canBos) {
			if (entityCache.getResult(CanBoImpl.class, canBo.getPrimaryKey()) ==
					null) {

				cacheResult(canBo);
			}
		}
	}

	/**
	 * Clears the cache for all can bos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CanBoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the can bo.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CanBo canBo) {
		entityCache.removeResult(CanBoImpl.class, canBo);
	}

	@Override
	public void clearCache(List<CanBo> canBos) {
		for (CanBo canBo : canBos) {
			entityCache.removeResult(CanBoImpl.class, canBo);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CanBoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new can bo with the primary key. Does not add the can bo to the database.
	 *
	 * @param canboId the primary key for the new can bo
	 * @return the new can bo
	 */
	@Override
	public CanBo create(long canboId) {
		CanBo canBo = new CanBoImpl();

		canBo.setNew(true);
		canBo.setPrimaryKey(canboId);

		canBo.setCompanyId(CompanyThreadLocal.getCompanyId());

		return canBo;
	}

	/**
	 * Removes the can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo that was removed
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo remove(long canboId) throws NoSuchCanBoException {
		return remove((Serializable)canboId);
	}

	/**
	 * Removes the can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the can bo
	 * @return the can bo that was removed
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo remove(Serializable primaryKey) throws NoSuchCanBoException {
		Session session = null;

		try {
			session = openSession();

			CanBo canBo = (CanBo)session.get(CanBoImpl.class, primaryKey);

			if (canBo == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCanBoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(canBo);
		}
		catch (NoSuchCanBoException noSuchEntityException) {
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
	protected CanBo removeImpl(CanBo canBo) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(canBo)) {
				canBo = (CanBo)session.get(
					CanBoImpl.class, canBo.getPrimaryKeyObj());
			}

			if (canBo != null) {
				session.delete(canBo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (canBo != null) {
			clearCache(canBo);
		}

		return canBo;
	}

	@Override
	public CanBo updateImpl(CanBo canBo) {
		boolean isNew = canBo.isNew();

		if (!(canBo instanceof CanBoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(canBo.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(canBo);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in canBo proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CanBo implementation " +
					canBo.getClass());
		}

		CanBoModelImpl canBoModelImpl = (CanBoModelImpl)canBo;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(canBo);
			}
			else {
				canBo = (CanBo)session.merge(canBo);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(CanBoImpl.class, canBoModelImpl, false, true);

		if (isNew) {
			canBo.setNew(false);
		}

		canBo.resetOriginalValues();

		return canBo;
	}

	/**
	 * Returns the can bo with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the can bo
	 * @return the can bo
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCanBoException {

		CanBo canBo = fetchByPrimaryKey(primaryKey);

		if (canBo == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCanBoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return canBo;
	}

	/**
	 * Returns the can bo with the primary key or throws a <code>NoSuchCanBoException</code> if it could not be found.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo findByPrimaryKey(long canboId) throws NoSuchCanBoException {
		return findByPrimaryKey((Serializable)canboId);
	}

	/**
	 * Returns the can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo, or <code>null</code> if a can bo with the primary key could not be found
	 */
	@Override
	public CanBo fetchByPrimaryKey(long canboId) {
		return fetchByPrimaryKey((Serializable)canboId);
	}

	/**
	 * Returns all the can bos.
	 *
	 * @return the can bos
	 */
	@Override
	public List<CanBo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @return the range of can bos
	 */
	@Override
	public List<CanBo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of can bos
	 */
	@Override
	public List<CanBo> findAll(
		int start, int end, OrderByComparator<CanBo> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of can bos
	 */
	@Override
	public List<CanBo> findAll(
		int start, int end, OrderByComparator<CanBo> orderByComparator,
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

		List<CanBo> list = null;

		if (useFinderCache) {
			list = (List<CanBo>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CANBO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CANBO;

				sql = sql.concat(CanBoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CanBo>)QueryUtil.list(
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
	 * Removes all the can bos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CanBo canBo : findAll()) {
			remove(canBo);
		}
	}

	/**
	 * Returns the number of can bos.
	 *
	 * @return the number of can bos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CANBO);

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
		return "canboId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CANBO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CanBoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the can bo persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CanBoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CanBo.class.getName()));

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

		CanBoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CanBoUtil.setPersistence(null);

		entityCache.removeCache(CanBoImpl.class.getName());

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

	private static final String _SQL_SELECT_CANBO =
		"SELECT canBo FROM CanBo canBo";

	private static final String _SQL_SELECT_CANBO_WHERE =
		"SELECT canBo FROM CanBo canBo WHERE ";

	private static final String _SQL_COUNT_CANBO =
		"SELECT COUNT(canBo) FROM CanBo canBo";

	private static final String _SQL_COUNT_CANBO_WHERE =
		"SELECT COUNT(canBo) FROM CanBo canBo WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "canBo.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CanBo exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CanBo exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CanBoPersistenceImpl.class);

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

	private static class CanBoModelArgumentsResolver
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

			CanBoModelImpl canBoModelImpl = (CanBoModelImpl)baseModel;

			long columnBitmask = canBoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(canBoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= canBoModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(CanBoPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(canBoModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			CanBoModelImpl canBoModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = canBoModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = canBoModelImpl.getColumnValue(columnName);
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