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

package qlanphamdb.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.Field;

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

import qlanphamdb.exception.NoSucheMagazineException;

import qlanphamdb.model.eMagazine;
import qlanphamdb.model.impl.eMagazineImpl;
import qlanphamdb.model.impl.eMagazineModelImpl;

import qlanphamdb.service.persistence.eMagazinePersistence;
import qlanphamdb.service.persistence.eMagazineUtil;
import qlanphamdb.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the e magazine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = eMagazinePersistence.class)
public class eMagazinePersistenceImpl
	extends BasePersistenceImpl<eMagazine> implements eMagazinePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>eMagazineUtil</code> to access the e magazine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		eMagazineImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public eMagazinePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(eMagazine.class);

		setModelImplClass(eMagazineImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the e magazine in the entity cache if it is enabled.
	 *
	 * @param eMagazine the e magazine
	 */
	@Override
	public void cacheResult(eMagazine eMagazine) {
		entityCache.putResult(
			eMagazineImpl.class, eMagazine.getPrimaryKey(), eMagazine);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the e magazines in the entity cache if it is enabled.
	 *
	 * @param eMagazines the e magazines
	 */
	@Override
	public void cacheResult(List<eMagazine> eMagazines) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (eMagazines.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (eMagazine eMagazine : eMagazines) {
			if (entityCache.getResult(
					eMagazineImpl.class, eMagazine.getPrimaryKey()) == null) {

				cacheResult(eMagazine);
			}
		}
	}

	/**
	 * Clears the cache for all e magazines.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(eMagazineImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e magazine.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(eMagazine eMagazine) {
		entityCache.removeResult(eMagazineImpl.class, eMagazine);
	}

	@Override
	public void clearCache(List<eMagazine> eMagazines) {
		for (eMagazine eMagazine : eMagazines) {
			entityCache.removeResult(eMagazineImpl.class, eMagazine);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(eMagazineImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new e magazine with the primary key. Does not add the e magazine to the database.
	 *
	 * @param id the primary key for the new e magazine
	 * @return the new e magazine
	 */
	@Override
	public eMagazine create(long id) {
		eMagazine eMagazine = new eMagazineImpl();

		eMagazine.setNew(true);
		eMagazine.setPrimaryKey(id);

		eMagazine.setCompanyId(CompanyThreadLocal.getCompanyId());

		return eMagazine;
	}

	/**
	 * Removes the e magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine that was removed
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	@Override
	public eMagazine remove(long id) throws NoSucheMagazineException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the e magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e magazine
	 * @return the e magazine that was removed
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	@Override
	public eMagazine remove(Serializable primaryKey)
		throws NoSucheMagazineException {

		Session session = null;

		try {
			session = openSession();

			eMagazine eMagazine = (eMagazine)session.get(
				eMagazineImpl.class, primaryKey);

			if (eMagazine == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSucheMagazineException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eMagazine);
		}
		catch (NoSucheMagazineException noSuchEntityException) {
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
	protected eMagazine removeImpl(eMagazine eMagazine) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eMagazine)) {
				eMagazine = (eMagazine)session.get(
					eMagazineImpl.class, eMagazine.getPrimaryKeyObj());
			}

			if (eMagazine != null) {
				session.delete(eMagazine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eMagazine != null) {
			clearCache(eMagazine);
		}

		return eMagazine;
	}

	@Override
	public eMagazine updateImpl(eMagazine eMagazine) {
		boolean isNew = eMagazine.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eMagazine);
			}
			else {
				eMagazine = (eMagazine)session.merge(eMagazine);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(eMagazineImpl.class, eMagazine, false, true);

		if (isNew) {
			eMagazine.setNew(false);
		}

		eMagazine.resetOriginalValues();

		return eMagazine;
	}

	/**
	 * Returns the e magazine with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e magazine
	 * @return the e magazine
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	@Override
	public eMagazine findByPrimaryKey(Serializable primaryKey)
		throws NoSucheMagazineException {

		eMagazine eMagazine = fetchByPrimaryKey(primaryKey);

		if (eMagazine == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSucheMagazineException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eMagazine;
	}

	/**
	 * Returns the e magazine with the primary key or throws a <code>NoSucheMagazineException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	@Override
	public eMagazine findByPrimaryKey(long id) throws NoSucheMagazineException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the e magazine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine, or <code>null</code> if a e magazine with the primary key could not be found
	 */
	@Override
	public eMagazine fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the e magazines.
	 *
	 * @return the e magazines
	 */
	@Override
	public List<eMagazine> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @return the range of e magazines
	 */
	@Override
	public List<eMagazine> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazines
	 */
	@Override
	public List<eMagazine> findAll(
		int start, int end, OrderByComparator<eMagazine> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazines
	 */
	@Override
	public List<eMagazine> findAll(
		int start, int end, OrderByComparator<eMagazine> orderByComparator,
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

		List<eMagazine> list = null;

		if (useFinderCache) {
			list = (List<eMagazine>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAGAZINE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAGAZINE;

				sql = sql.concat(eMagazineModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<eMagazine>)QueryUtil.list(
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
	 * Removes all the e magazines from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (eMagazine eMagazine : findAll()) {
			remove(eMagazine);
		}
	}

	/**
	 * Returns the number of e magazines.
	 *
	 * @return the number of e magazines
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EMAGAZINE);

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
		return _SQL_SELECT_EMAGAZINE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return eMagazineModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the e magazine persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new eMagazineModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", eMagazine.class.getName()));

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

		_seteMagazineUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_seteMagazineUtilPersistence(null);

		entityCache.removeCache(eMagazineImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _seteMagazineUtilPersistence(
		eMagazinePersistence eMagazinePersistence) {

		try {
			Field field = eMagazineUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, eMagazinePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
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

	private static final String _SQL_SELECT_EMAGAZINE =
		"SELECT eMagazine FROM eMagazine eMagazine";

	private static final String _SQL_COUNT_EMAGAZINE =
		"SELECT COUNT(eMagazine) FROM eMagazine eMagazine";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eMagazine.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No eMagazine exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		eMagazinePersistenceImpl.class);

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

	private static class eMagazineModelArgumentsResolver
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

			eMagazineModelImpl eMagazineModelImpl =
				(eMagazineModelImpl)baseModel;

			long columnBitmask = eMagazineModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(eMagazineModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						eMagazineModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(eMagazinePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(eMagazineModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			eMagazineModelImpl eMagazineModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = eMagazineModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = eMagazineModelImpl.getColumnValue(
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