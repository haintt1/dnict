/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.service.persistence.impl;

import com.demo.exception.NoSuchDemoDBException;
import com.demo.model.DemoDB;
import com.demo.model.impl.DemoDBImpl;
import com.demo.model.impl.DemoDBModelImpl;
import com.demo.service.persistence.DemoDBPersistence;
import com.demo.service.persistence.DemoDBUtil;
import com.demo.service.persistence.impl.constants.cwPersistenceConstants;

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

/**
 * The persistence implementation for the demo db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DemoDBPersistence.class)
public class DemoDBPersistenceImpl
	extends BasePersistenceImpl<DemoDB> implements DemoDBPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DemoDBUtil</code> to access the demo db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DemoDBImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DemoDBPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DemoDB.class);

		setModelImplClass(DemoDBImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the demo db in the entity cache if it is enabled.
	 *
	 * @param demoDB the demo db
	 */
	@Override
	public void cacheResult(DemoDB demoDB) {
		entityCache.putResult(DemoDBImpl.class, demoDB.getPrimaryKey(), demoDB);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the demo dbs in the entity cache if it is enabled.
	 *
	 * @param demoDBs the demo dbs
	 */
	@Override
	public void cacheResult(List<DemoDB> demoDBs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (demoDBs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DemoDB demoDB : demoDBs) {
			if (entityCache.getResult(
					DemoDBImpl.class, demoDB.getPrimaryKey()) == null) {

				cacheResult(demoDB);
			}
		}
	}

	/**
	 * Clears the cache for all demo dbs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DemoDBImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the demo db.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DemoDB demoDB) {
		entityCache.removeResult(DemoDBImpl.class, demoDB);
	}

	@Override
	public void clearCache(List<DemoDB> demoDBs) {
		for (DemoDB demoDB : demoDBs) {
			entityCache.removeResult(DemoDBImpl.class, demoDB);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DemoDBImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new demo db with the primary key. Does not add the demo db to the database.
	 *
	 * @param id the primary key for the new demo db
	 * @return the new demo db
	 */
	@Override
	public DemoDB create(long id) {
		DemoDB demoDB = new DemoDBImpl();

		demoDB.setNew(true);
		demoDB.setPrimaryKey(id);

		return demoDB;
	}

	/**
	 * Removes the demo db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db that was removed
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	@Override
	public DemoDB remove(long id) throws NoSuchDemoDBException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the demo db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the demo db
	 * @return the demo db that was removed
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	@Override
	public DemoDB remove(Serializable primaryKey) throws NoSuchDemoDBException {
		Session session = null;

		try {
			session = openSession();

			DemoDB demoDB = (DemoDB)session.get(DemoDBImpl.class, primaryKey);

			if (demoDB == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDemoDBException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(demoDB);
		}
		catch (NoSuchDemoDBException noSuchEntityException) {
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
	protected DemoDB removeImpl(DemoDB demoDB) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(demoDB)) {
				demoDB = (DemoDB)session.get(
					DemoDBImpl.class, demoDB.getPrimaryKeyObj());
			}

			if (demoDB != null) {
				session.delete(demoDB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (demoDB != null) {
			clearCache(demoDB);
		}

		return demoDB;
	}

	@Override
	public DemoDB updateImpl(DemoDB demoDB) {
		boolean isNew = demoDB.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(demoDB);
			}
			else {
				demoDB = (DemoDB)session.merge(demoDB);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DemoDBImpl.class, demoDB, false, true);

		if (isNew) {
			demoDB.setNew(false);
		}

		demoDB.resetOriginalValues();

		return demoDB;
	}

	/**
	 * Returns the demo db with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the demo db
	 * @return the demo db
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	@Override
	public DemoDB findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDemoDBException {

		DemoDB demoDB = fetchByPrimaryKey(primaryKey);

		if (demoDB == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDemoDBException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return demoDB;
	}

	/**
	 * Returns the demo db with the primary key or throws a <code>NoSuchDemoDBException</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	@Override
	public DemoDB findByPrimaryKey(long id) throws NoSuchDemoDBException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the demo db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db, or <code>null</code> if a demo db with the primary key could not be found
	 */
	@Override
	public DemoDB fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the demo dbs.
	 *
	 * @return the demo dbs
	 */
	@Override
	public List<DemoDB> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @return the range of demo dbs
	 */
	@Override
	public List<DemoDB> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demo dbs
	 */
	@Override
	public List<DemoDB> findAll(
		int start, int end, OrderByComparator<DemoDB> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of demo dbs
	 */
	@Override
	public List<DemoDB> findAll(
		int start, int end, OrderByComparator<DemoDB> orderByComparator,
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

		List<DemoDB> list = null;

		if (useFinderCache) {
			list = (List<DemoDB>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DEMODB);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DEMODB;

				sql = sql.concat(DemoDBModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DemoDB>)QueryUtil.list(
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
	 * Removes all the demo dbs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DemoDB demoDB : findAll()) {
			remove(demoDB);
		}
	}

	/**
	 * Returns the number of demo dbs.
	 *
	 * @return the number of demo dbs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DEMODB);

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
		return _SQL_SELECT_DEMODB;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DemoDBModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the demo db persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DemoDBModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DemoDB.class.getName()));

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

		DemoDBUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DemoDBUtil.setPersistence(null);

		entityCache.removeCache(DemoDBImpl.class.getName());

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

	private static final String _SQL_SELECT_DEMODB =
		"SELECT demoDB FROM DemoDB demoDB";

	private static final String _SQL_COUNT_DEMODB =
		"SELECT COUNT(demoDB) FROM DemoDB demoDB";

	private static final String _ORDER_BY_ENTITY_ALIAS = "demoDB.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DemoDB exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DemoDBPersistenceImpl.class);

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

	private static class DemoDBModelArgumentsResolver
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

			DemoDBModelImpl demoDBModelImpl = (DemoDBModelImpl)baseModel;

			long columnBitmask = demoDBModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(demoDBModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= demoDBModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(demoDBModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DemoDBModelImpl demoDBModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = demoDBModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = demoDBModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}