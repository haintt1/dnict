/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

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

import vn.dnict.qlnhuanbut.exception.NoSuchThongKeNBException;
import vn.dnict.qlnhuanbut.model.ThongKeNB;
import vn.dnict.qlnhuanbut.model.impl.ThongKeNBImpl;
import vn.dnict.qlnhuanbut.model.impl.ThongKeNBModelImpl;
import vn.dnict.qlnhuanbut.service.persistence.ThongKeNBPersistence;
import vn.dnict.qlnhuanbut.service.persistence.ThongKeNBUtil;
import vn.dnict.qlnhuanbut.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the thong ke nb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = ThongKeNBPersistence.class)
public class ThongKeNBPersistenceImpl
	extends BasePersistenceImpl<ThongKeNB> implements ThongKeNBPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ThongKeNBUtil</code> to access the thong ke nb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ThongKeNBImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ThongKeNBPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ThongKeNB.class);

		setModelImplClass(ThongKeNBImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the thong ke nb in the entity cache if it is enabled.
	 *
	 * @param thongKeNB the thong ke nb
	 */
	@Override
	public void cacheResult(ThongKeNB thongKeNB) {
		entityCache.putResult(
			ThongKeNBImpl.class, thongKeNB.getPrimaryKey(), thongKeNB);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the thong ke nbs in the entity cache if it is enabled.
	 *
	 * @param thongKeNBs the thong ke nbs
	 */
	@Override
	public void cacheResult(List<ThongKeNB> thongKeNBs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (thongKeNBs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ThongKeNB thongKeNB : thongKeNBs) {
			if (entityCache.getResult(
					ThongKeNBImpl.class, thongKeNB.getPrimaryKey()) == null) {

				cacheResult(thongKeNB);
			}
		}
	}

	/**
	 * Clears the cache for all thong ke nbs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ThongKeNBImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the thong ke nb.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ThongKeNB thongKeNB) {
		entityCache.removeResult(ThongKeNBImpl.class, thongKeNB);
	}

	@Override
	public void clearCache(List<ThongKeNB> thongKeNBs) {
		for (ThongKeNB thongKeNB : thongKeNBs) {
			entityCache.removeResult(ThongKeNBImpl.class, thongKeNB);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ThongKeNBImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new thong ke nb with the primary key. Does not add the thong ke nb to the database.
	 *
	 * @param id the primary key for the new thong ke nb
	 * @return the new thong ke nb
	 */
	@Override
	public ThongKeNB create(long id) {
		ThongKeNB thongKeNB = new ThongKeNBImpl();

		thongKeNB.setNew(true);
		thongKeNB.setPrimaryKey(id);

		return thongKeNB;
	}

	/**
	 * Removes the thong ke nb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb that was removed
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public ThongKeNB remove(long id) throws NoSuchThongKeNBException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the thong ke nb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the thong ke nb
	 * @return the thong ke nb that was removed
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public ThongKeNB remove(Serializable primaryKey)
		throws NoSuchThongKeNBException {

		Session session = null;

		try {
			session = openSession();

			ThongKeNB thongKeNB = (ThongKeNB)session.get(
				ThongKeNBImpl.class, primaryKey);

			if (thongKeNB == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchThongKeNBException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(thongKeNB);
		}
		catch (NoSuchThongKeNBException noSuchEntityException) {
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
	protected ThongKeNB removeImpl(ThongKeNB thongKeNB) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(thongKeNB)) {
				thongKeNB = (ThongKeNB)session.get(
					ThongKeNBImpl.class, thongKeNB.getPrimaryKeyObj());
			}

			if (thongKeNB != null) {
				session.delete(thongKeNB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (thongKeNB != null) {
			clearCache(thongKeNB);
		}

		return thongKeNB;
	}

	@Override
	public ThongKeNB updateImpl(ThongKeNB thongKeNB) {
		boolean isNew = thongKeNB.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(thongKeNB);
			}
			else {
				thongKeNB = (ThongKeNB)session.merge(thongKeNB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ThongKeNBImpl.class, thongKeNB, false, true);

		if (isNew) {
			thongKeNB.setNew(false);
		}

		thongKeNB.resetOriginalValues();

		return thongKeNB;
	}

	/**
	 * Returns the thong ke nb with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the thong ke nb
	 * @return the thong ke nb
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public ThongKeNB findByPrimaryKey(Serializable primaryKey)
		throws NoSuchThongKeNBException {

		ThongKeNB thongKeNB = fetchByPrimaryKey(primaryKey);

		if (thongKeNB == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchThongKeNBException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return thongKeNB;
	}

	/**
	 * Returns the thong ke nb with the primary key or throws a <code>NoSuchThongKeNBException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	@Override
	public ThongKeNB findByPrimaryKey(long id) throws NoSuchThongKeNBException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the thong ke nb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb, or <code>null</code> if a thong ke nb with the primary key could not be found
	 */
	@Override
	public ThongKeNB fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the thong ke nbs.
	 *
	 * @return the thong ke nbs
	 */
	@Override
	public List<ThongKeNB> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @return the range of thong ke nbs
	 */
	@Override
	public List<ThongKeNB> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong ke nbs
	 */
	@Override
	public List<ThongKeNB> findAll(
		int start, int end, OrderByComparator<ThongKeNB> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of thong ke nbs
	 */
	@Override
	public List<ThongKeNB> findAll(
		int start, int end, OrderByComparator<ThongKeNB> orderByComparator,
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

		List<ThongKeNB> list = null;

		if (useFinderCache) {
			list = (List<ThongKeNB>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_THONGKENB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_THONGKENB;

				sql = sql.concat(ThongKeNBModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ThongKeNB>)QueryUtil.list(
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
	 * Removes all the thong ke nbs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ThongKeNB thongKeNB : findAll()) {
			remove(thongKeNB);
		}
	}

	/**
	 * Returns the number of thong ke nbs.
	 *
	 * @return the number of thong ke nbs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_THONGKENB);

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
		return _SQL_SELECT_THONGKENB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ThongKeNBModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the thong ke nb persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ThongKeNBModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ThongKeNB.class.getName()));

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

		ThongKeNBUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ThongKeNBUtil.setPersistence(null);

		entityCache.removeCache(ThongKeNBImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = cwPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_THONGKENB =
		"SELECT thongKeNB FROM ThongKeNB thongKeNB";

	private static final String _SQL_COUNT_THONGKENB =
		"SELECT COUNT(thongKeNB) FROM ThongKeNB thongKeNB";

	private static final String _ORDER_BY_ENTITY_ALIAS = "thongKeNB.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ThongKeNB exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ThongKeNBPersistenceImpl.class);

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

	private static class ThongKeNBModelArgumentsResolver
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

			ThongKeNBModelImpl thongKeNBModelImpl =
				(ThongKeNBModelImpl)baseModel;

			long columnBitmask = thongKeNBModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(thongKeNBModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						thongKeNBModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(thongKeNBModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ThongKeNBModelImpl thongKeNBModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = thongKeNBModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = thongKeNBModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}