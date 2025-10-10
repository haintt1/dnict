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

import vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException;
import vn.dnict.vanbanphapquy.model.dinhkemfile;
import vn.dnict.vanbanphapquy.model.impl.dinhkemfileImpl;
import vn.dnict.vanbanphapquy.model.impl.dinhkemfileModelImpl;
import vn.dnict.vanbanphapquy.service.persistence.dinhkemfilePersistence;
import vn.dnict.vanbanphapquy.service.persistence.dinhkemfileUtil;
import vn.dnict.vanbanphapquy.service.persistence.impl.constants.BinhNTPersistenceConstants;

/**
 * The persistence implementation for the dinhkemfile service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @generated
 */
@Component(service = dinhkemfilePersistence.class)
public class dinhkemfilePersistenceImpl
	extends BasePersistenceImpl<dinhkemfile> implements dinhkemfilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>dinhkemfileUtil</code> to access the dinhkemfile persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		dinhkemfileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public dinhkemfilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(dinhkemfile.class);

		setModelImplClass(dinhkemfileImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the dinhkemfile in the entity cache if it is enabled.
	 *
	 * @param dinhkemfile the dinhkemfile
	 */
	@Override
	public void cacheResult(dinhkemfile dinhkemfile) {
		entityCache.putResult(
			dinhkemfileImpl.class, dinhkemfile.getPrimaryKey(), dinhkemfile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dinhkemfiles in the entity cache if it is enabled.
	 *
	 * @param dinhkemfiles the dinhkemfiles
	 */
	@Override
	public void cacheResult(List<dinhkemfile> dinhkemfiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dinhkemfiles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (dinhkemfile dinhkemfile : dinhkemfiles) {
			if (entityCache.getResult(
					dinhkemfileImpl.class, dinhkemfile.getPrimaryKey()) ==
						null) {

				cacheResult(dinhkemfile);
			}
		}
	}

	/**
	 * Clears the cache for all dinhkemfiles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(dinhkemfileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dinhkemfile.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(dinhkemfile dinhkemfile) {
		entityCache.removeResult(dinhkemfileImpl.class, dinhkemfile);
	}

	@Override
	public void clearCache(List<dinhkemfile> dinhkemfiles) {
		for (dinhkemfile dinhkemfile : dinhkemfiles) {
			entityCache.removeResult(dinhkemfileImpl.class, dinhkemfile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(dinhkemfileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dinhkemfile with the primary key. Does not add the dinhkemfile to the database.
	 *
	 * @param id the primary key for the new dinhkemfile
	 * @return the new dinhkemfile
	 */
	@Override
	public dinhkemfile create(long id) {
		dinhkemfile dinhkemfile = new dinhkemfileImpl();

		dinhkemfile.setNew(true);
		dinhkemfile.setPrimaryKey(id);

		dinhkemfile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return dinhkemfile;
	}

	/**
	 * Removes the dinhkemfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile that was removed
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public dinhkemfile remove(long id) throws NoSuchdinhkemfileException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dinhkemfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dinhkemfile
	 * @return the dinhkemfile that was removed
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public dinhkemfile remove(Serializable primaryKey)
		throws NoSuchdinhkemfileException {

		Session session = null;

		try {
			session = openSession();

			dinhkemfile dinhkemfile = (dinhkemfile)session.get(
				dinhkemfileImpl.class, primaryKey);

			if (dinhkemfile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchdinhkemfileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dinhkemfile);
		}
		catch (NoSuchdinhkemfileException noSuchEntityException) {
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
	protected dinhkemfile removeImpl(dinhkemfile dinhkemfile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dinhkemfile)) {
				dinhkemfile = (dinhkemfile)session.get(
					dinhkemfileImpl.class, dinhkemfile.getPrimaryKeyObj());
			}

			if (dinhkemfile != null) {
				session.delete(dinhkemfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dinhkemfile != null) {
			clearCache(dinhkemfile);
		}

		return dinhkemfile;
	}

	@Override
	public dinhkemfile updateImpl(dinhkemfile dinhkemfile) {
		boolean isNew = dinhkemfile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dinhkemfile);
			}
			else {
				dinhkemfile = (dinhkemfile)session.merge(dinhkemfile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(dinhkemfileImpl.class, dinhkemfile, false, true);

		if (isNew) {
			dinhkemfile.setNew(false);
		}

		dinhkemfile.resetOriginalValues();

		return dinhkemfile;
	}

	/**
	 * Returns the dinhkemfile with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dinhkemfile
	 * @return the dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public dinhkemfile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchdinhkemfileException {

		dinhkemfile dinhkemfile = fetchByPrimaryKey(primaryKey);

		if (dinhkemfile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchdinhkemfileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dinhkemfile;
	}

	/**
	 * Returns the dinhkemfile with the primary key or throws a <code>NoSuchdinhkemfileException</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public dinhkemfile findByPrimaryKey(long id)
		throws NoSuchdinhkemfileException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dinhkemfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile, or <code>null</code> if a dinhkemfile with the primary key could not be found
	 */
	@Override
	public dinhkemfile fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dinhkemfiles.
	 *
	 * @return the dinhkemfiles
	 */
	@Override
	public List<dinhkemfile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of dinhkemfiles
	 */
	@Override
	public List<dinhkemfile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dinhkemfiles
	 */
	@Override
	public List<dinhkemfile> findAll(
		int start, int end, OrderByComparator<dinhkemfile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dinhkemfiles
	 */
	@Override
	public List<dinhkemfile> findAll(
		int start, int end, OrderByComparator<dinhkemfile> orderByComparator,
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

		List<dinhkemfile> list = null;

		if (useFinderCache) {
			list = (List<dinhkemfile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DINHKEMFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DINHKEMFILE;

				sql = sql.concat(dinhkemfileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<dinhkemfile>)QueryUtil.list(
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
	 * Removes all the dinhkemfiles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (dinhkemfile dinhkemfile : findAll()) {
			remove(dinhkemfile);
		}
	}

	/**
	 * Returns the number of dinhkemfiles.
	 *
	 * @return the number of dinhkemfiles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DINHKEMFILE);

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
		return _SQL_SELECT_DINHKEMFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return dinhkemfileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dinhkemfile persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new dinhkemfileModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", dinhkemfile.class.getName()));

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

		_setdinhkemfileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setdinhkemfileUtilPersistence(null);

		entityCache.removeCache(dinhkemfileImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setdinhkemfileUtilPersistence(
		dinhkemfilePersistence dinhkemfilePersistence) {

		try {
			Field field = dinhkemfileUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, dinhkemfilePersistence);
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

	private static final String _SQL_SELECT_DINHKEMFILE =
		"SELECT dinhkemfile FROM dinhkemfile dinhkemfile";

	private static final String _SQL_COUNT_DINHKEMFILE =
		"SELECT COUNT(dinhkemfile) FROM dinhkemfile dinhkemfile";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dinhkemfile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No dinhkemfile exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		dinhkemfilePersistenceImpl.class);

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

	private static class dinhkemfileModelArgumentsResolver
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

			dinhkemfileModelImpl dinhkemfileModelImpl =
				(dinhkemfileModelImpl)baseModel;

			long columnBitmask = dinhkemfileModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(dinhkemfileModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						dinhkemfileModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(dinhkemfileModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			dinhkemfileModelImpl dinhkemfileModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = dinhkemfileModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = dinhkemfileModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}