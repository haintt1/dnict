/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package cms.quanlyvideo.service.persistence.impl;

import cms.quanlyvideo.exception.NoSuchChuDeException;
import cms.quanlyvideo.model.ChuDe;
import cms.quanlyvideo.model.impl.ChuDeImpl;
import cms.quanlyvideo.model.impl.ChuDeModelImpl;
import cms.quanlyvideo.service.persistence.ChuDePersistence;
import cms.quanlyvideo.service.persistence.ChuDeUtil;
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
 * The persistence implementation for the chu de service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ChuDePersistence.class)
public class ChuDePersistenceImpl
	extends BasePersistenceImpl<ChuDe> implements ChuDePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ChuDeUtil</code> to access the chu de persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ChuDeImpl.class.getName();

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
	 * Returns all the chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching chu des
	 */
	@Override
	public List<ChuDe> findByten(String ten) {
		return findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @return the range of matching chu des
	 */
	@Override
	public List<ChuDe> findByten(String ten, int start, int end) {
		return findByten(ten, start, end, null);
	}

	/**
	 * Returns an ordered range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching chu des
	 */
	@Override
	public List<ChuDe> findByten(
		String ten, int start, int end,
		OrderByComparator<ChuDe> orderByComparator) {

		return findByten(ten, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chu des where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching chu des
	 */
	@Override
	public List<ChuDe> findByten(
		String ten, int start, int end,
		OrderByComparator<ChuDe> orderByComparator, boolean useFinderCache) {

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

		List<ChuDe> list = null;

		if (useFinderCache) {
			list = (List<ChuDe>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ChuDe chuDe : list) {
					if (!ten.equals(chuDe.getTen())) {
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

			sb.append(_SQL_SELECT_CHUDE_WHERE);

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
				sb.append(ChuDeModelImpl.ORDER_BY_JPQL);
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

				list = (List<ChuDe>)QueryUtil.list(
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
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	@Override
	public ChuDe findByten_First(
			String ten, OrderByComparator<ChuDe> orderByComparator)
		throws NoSuchChuDeException {

		ChuDe chuDe = fetchByten_First(ten, orderByComparator);

		if (chuDe != null) {
			return chuDe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchChuDeException(sb.toString());
	}

	/**
	 * Returns the first chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	@Override
	public ChuDe fetchByten_First(
		String ten, OrderByComparator<ChuDe> orderByComparator) {

		List<ChuDe> list = findByten(ten, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de
	 * @throws NoSuchChuDeException if a matching chu de could not be found
	 */
	@Override
	public ChuDe findByten_Last(
			String ten, OrderByComparator<ChuDe> orderByComparator)
		throws NoSuchChuDeException {

		ChuDe chuDe = fetchByten_Last(ten, orderByComparator);

		if (chuDe != null) {
			return chuDe;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ten=");
		sb.append(ten);

		sb.append("}");

		throw new NoSuchChuDeException(sb.toString());
	}

	/**
	 * Returns the last chu de in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching chu de, or <code>null</code> if a matching chu de could not be found
	 */
	@Override
	public ChuDe fetchByten_Last(
		String ten, OrderByComparator<ChuDe> orderByComparator) {

		int count = countByten(ten);

		if (count == 0) {
			return null;
		}

		List<ChuDe> list = findByten(ten, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the chu des before and after the current chu de in the ordered set where ten = &#63;.
	 *
	 * @param id the primary key of the current chu de
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe[] findByten_PrevAndNext(
			long id, String ten, OrderByComparator<ChuDe> orderByComparator)
		throws NoSuchChuDeException {

		ten = Objects.toString(ten, "");

		ChuDe chuDe = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ChuDe[] array = new ChuDeImpl[3];

			array[0] = getByten_PrevAndNext(
				session, chuDe, ten, orderByComparator, true);

			array[1] = chuDe;

			array[2] = getByten_PrevAndNext(
				session, chuDe, ten, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ChuDe getByten_PrevAndNext(
		Session session, ChuDe chuDe, String ten,
		OrderByComparator<ChuDe> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CHUDE_WHERE);

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
			sb.append(ChuDeModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(chuDe)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ChuDe> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the chu des where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	@Override
	public void removeByten(String ten) {
		for (ChuDe chuDe :
				findByten(ten, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(chuDe);
		}
	}

	/**
	 * Returns the number of chu des where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching chu des
	 */
	@Override
	public int countByten(String ten) {
		ten = Objects.toString(ten, "");

		FinderPath finderPath = _finderPathCountByten;

		Object[] finderArgs = new Object[] {ten};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CHUDE_WHERE);

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

	private static final String _FINDER_COLUMN_TEN_TEN_2 = "chuDe.ten = ?";

	private static final String _FINDER_COLUMN_TEN_TEN_3 =
		"(chuDe.ten IS NULL OR chuDe.ten = '')";

	public ChuDePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ChuDe.class);

		setModelImplClass(ChuDeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the chu de in the entity cache if it is enabled.
	 *
	 * @param chuDe the chu de
	 */
	@Override
	public void cacheResult(ChuDe chuDe) {
		entityCache.putResult(ChuDeImpl.class, chuDe.getPrimaryKey(), chuDe);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the chu des in the entity cache if it is enabled.
	 *
	 * @param chuDes the chu des
	 */
	@Override
	public void cacheResult(List<ChuDe> chuDes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (chuDes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ChuDe chuDe : chuDes) {
			if (entityCache.getResult(ChuDeImpl.class, chuDe.getPrimaryKey()) ==
					null) {

				cacheResult(chuDe);
			}
		}
	}

	/**
	 * Clears the cache for all chu des.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ChuDeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the chu de.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ChuDe chuDe) {
		entityCache.removeResult(ChuDeImpl.class, chuDe);
	}

	@Override
	public void clearCache(List<ChuDe> chuDes) {
		for (ChuDe chuDe : chuDes) {
			entityCache.removeResult(ChuDeImpl.class, chuDe);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ChuDeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new chu de with the primary key. Does not add the chu de to the database.
	 *
	 * @param id the primary key for the new chu de
	 * @return the new chu de
	 */
	@Override
	public ChuDe create(long id) {
		ChuDe chuDe = new ChuDeImpl();

		chuDe.setNew(true);
		chuDe.setPrimaryKey(id);

		chuDe.setCompanyId(CompanyThreadLocal.getCompanyId());

		return chuDe;
	}

	/**
	 * Removes the chu de with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de that was removed
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe remove(long id) throws NoSuchChuDeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the chu de with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the chu de
	 * @return the chu de that was removed
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe remove(Serializable primaryKey) throws NoSuchChuDeException {
		Session session = null;

		try {
			session = openSession();

			ChuDe chuDe = (ChuDe)session.get(ChuDeImpl.class, primaryKey);

			if (chuDe == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchChuDeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(chuDe);
		}
		catch (NoSuchChuDeException noSuchEntityException) {
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
	protected ChuDe removeImpl(ChuDe chuDe) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(chuDe)) {
				chuDe = (ChuDe)session.get(
					ChuDeImpl.class, chuDe.getPrimaryKeyObj());
			}

			if (chuDe != null) {
				session.delete(chuDe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (chuDe != null) {
			clearCache(chuDe);
		}

		return chuDe;
	}

	@Override
	public ChuDe updateImpl(ChuDe chuDe) {
		boolean isNew = chuDe.isNew();

		if (!(chuDe instanceof ChuDeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(chuDe.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(chuDe);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in chuDe proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ChuDe implementation " +
					chuDe.getClass());
		}

		ChuDeModelImpl chuDeModelImpl = (ChuDeModelImpl)chuDe;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(chuDe);
			}
			else {
				chuDe = (ChuDe)session.merge(chuDe);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ChuDeImpl.class, chuDeModelImpl, false, true);

		if (isNew) {
			chuDe.setNew(false);
		}

		chuDe.resetOriginalValues();

		return chuDe;
	}

	/**
	 * Returns the chu de with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the chu de
	 * @return the chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe findByPrimaryKey(Serializable primaryKey)
		throws NoSuchChuDeException {

		ChuDe chuDe = fetchByPrimaryKey(primaryKey);

		if (chuDe == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchChuDeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return chuDe;
	}

	/**
	 * Returns the chu de with the primary key or throws a <code>NoSuchChuDeException</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de
	 * @throws NoSuchChuDeException if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe findByPrimaryKey(long id) throws NoSuchChuDeException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the chu de with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the chu de
	 * @return the chu de, or <code>null</code> if a chu de with the primary key could not be found
	 */
	@Override
	public ChuDe fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the chu des.
	 *
	 * @return the chu des
	 */
	@Override
	public List<ChuDe> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @return the range of chu des
	 */
	@Override
	public List<ChuDe> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of chu des
	 */
	@Override
	public List<ChuDe> findAll(
		int start, int end, OrderByComparator<ChuDe> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the chu des.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ChuDeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of chu des
	 * @param end the upper bound of the range of chu des (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of chu des
	 */
	@Override
	public List<ChuDe> findAll(
		int start, int end, OrderByComparator<ChuDe> orderByComparator,
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

		List<ChuDe> list = null;

		if (useFinderCache) {
			list = (List<ChuDe>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CHUDE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CHUDE;

				sql = sql.concat(ChuDeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ChuDe>)QueryUtil.list(
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
	 * Removes all the chu des from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ChuDe chuDe : findAll()) {
			remove(chuDe);
		}
	}

	/**
	 * Returns the number of chu des.
	 *
	 * @return the number of chu des
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CHUDE);

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
		return _SQL_SELECT_CHUDE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ChuDeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the chu de persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ChuDeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ChuDe.class.getName()));

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

		ChuDeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ChuDeUtil.setPersistence(null);

		entityCache.removeCache(ChuDeImpl.class.getName());

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

	private static final String _SQL_SELECT_CHUDE =
		"SELECT chuDe FROM ChuDe chuDe";

	private static final String _SQL_SELECT_CHUDE_WHERE =
		"SELECT chuDe FROM ChuDe chuDe WHERE ";

	private static final String _SQL_COUNT_CHUDE =
		"SELECT COUNT(chuDe) FROM ChuDe chuDe";

	private static final String _SQL_COUNT_CHUDE_WHERE =
		"SELECT COUNT(chuDe) FROM ChuDe chuDe WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "chuDe.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ChuDe exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ChuDe exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ChuDePersistenceImpl.class);

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

	private static class ChuDeModelArgumentsResolver
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

			ChuDeModelImpl chuDeModelImpl = (ChuDeModelImpl)baseModel;

			long columnBitmask = chuDeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(chuDeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= chuDeModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(ChuDePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(chuDeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ChuDeModelImpl chuDeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = chuDeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = chuDeModelImpl.getColumnValue(columnName);
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