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

import qlanphamdb.exception.NoSucheMagazine_BinhLuanException;

import qlanphamdb.model.eMagazine_BinhLuan;
import qlanphamdb.model.impl.eMagazine_BinhLuanImpl;
import qlanphamdb.model.impl.eMagazine_BinhLuanModelImpl;

import qlanphamdb.service.persistence.eMagazine_BinhLuanPersistence;
import qlanphamdb.service.persistence.eMagazine_BinhLuanUtil;
import qlanphamdb.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the e magazine_ binh luan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = eMagazine_BinhLuanPersistence.class)
public class eMagazine_BinhLuanPersistenceImpl
	extends BasePersistenceImpl<eMagazine_BinhLuan>
	implements eMagazine_BinhLuanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>eMagazine_BinhLuanUtil</code> to access the e magazine_ binh luan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		eMagazine_BinhLuanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public eMagazine_BinhLuanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(eMagazine_BinhLuan.class);

		setModelImplClass(eMagazine_BinhLuanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the e magazine_ binh luan in the entity cache if it is enabled.
	 *
	 * @param eMagazine_BinhLuan the e magazine_ binh luan
	 */
	@Override
	public void cacheResult(eMagazine_BinhLuan eMagazine_BinhLuan) {
		entityCache.putResult(
			eMagazine_BinhLuanImpl.class, eMagazine_BinhLuan.getPrimaryKey(),
			eMagazine_BinhLuan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the e magazine_ binh luans in the entity cache if it is enabled.
	 *
	 * @param eMagazine_BinhLuans the e magazine_ binh luans
	 */
	@Override
	public void cacheResult(List<eMagazine_BinhLuan> eMagazine_BinhLuans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (eMagazine_BinhLuans.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (eMagazine_BinhLuan eMagazine_BinhLuan : eMagazine_BinhLuans) {
			if (entityCache.getResult(
					eMagazine_BinhLuanImpl.class,
					eMagazine_BinhLuan.getPrimaryKey()) == null) {

				cacheResult(eMagazine_BinhLuan);
			}
		}
	}

	/**
	 * Clears the cache for all e magazine_ binh luans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(eMagazine_BinhLuanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e magazine_ binh luan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(eMagazine_BinhLuan eMagazine_BinhLuan) {
		entityCache.removeResult(
			eMagazine_BinhLuanImpl.class, eMagazine_BinhLuan);
	}

	@Override
	public void clearCache(List<eMagazine_BinhLuan> eMagazine_BinhLuans) {
		for (eMagazine_BinhLuan eMagazine_BinhLuan : eMagazine_BinhLuans) {
			entityCache.removeResult(
				eMagazine_BinhLuanImpl.class, eMagazine_BinhLuan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(eMagazine_BinhLuanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new e magazine_ binh luan with the primary key. Does not add the e magazine_ binh luan to the database.
	 *
	 * @param id the primary key for the new e magazine_ binh luan
	 * @return the new e magazine_ binh luan
	 */
	@Override
	public eMagazine_BinhLuan create(long id) {
		eMagazine_BinhLuan eMagazine_BinhLuan = new eMagazine_BinhLuanImpl();

		eMagazine_BinhLuan.setNew(true);
		eMagazine_BinhLuan.setPrimaryKey(id);

		eMagazine_BinhLuan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return eMagazine_BinhLuan;
	}

	/**
	 * Removes the e magazine_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was removed
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public eMagazine_BinhLuan remove(long id)
		throws NoSucheMagazine_BinhLuanException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the e magazine_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was removed
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public eMagazine_BinhLuan remove(Serializable primaryKey)
		throws NoSucheMagazine_BinhLuanException {

		Session session = null;

		try {
			session = openSession();

			eMagazine_BinhLuan eMagazine_BinhLuan =
				(eMagazine_BinhLuan)session.get(
					eMagazine_BinhLuanImpl.class, primaryKey);

			if (eMagazine_BinhLuan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSucheMagazine_BinhLuanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(eMagazine_BinhLuan);
		}
		catch (NoSucheMagazine_BinhLuanException noSuchEntityException) {
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
	protected eMagazine_BinhLuan removeImpl(
		eMagazine_BinhLuan eMagazine_BinhLuan) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eMagazine_BinhLuan)) {
				eMagazine_BinhLuan = (eMagazine_BinhLuan)session.get(
					eMagazine_BinhLuanImpl.class,
					eMagazine_BinhLuan.getPrimaryKeyObj());
			}

			if (eMagazine_BinhLuan != null) {
				session.delete(eMagazine_BinhLuan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (eMagazine_BinhLuan != null) {
			clearCache(eMagazine_BinhLuan);
		}

		return eMagazine_BinhLuan;
	}

	@Override
	public eMagazine_BinhLuan updateImpl(
		eMagazine_BinhLuan eMagazine_BinhLuan) {

		boolean isNew = eMagazine_BinhLuan.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(eMagazine_BinhLuan);
			}
			else {
				eMagazine_BinhLuan = (eMagazine_BinhLuan)session.merge(
					eMagazine_BinhLuan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			eMagazine_BinhLuanImpl.class, eMagazine_BinhLuan, false, true);

		if (isNew) {
			eMagazine_BinhLuan.setNew(false);
		}

		eMagazine_BinhLuan.resetOriginalValues();

		return eMagazine_BinhLuan;
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public eMagazine_BinhLuan findByPrimaryKey(Serializable primaryKey)
		throws NoSucheMagazine_BinhLuanException {

		eMagazine_BinhLuan eMagazine_BinhLuan = fetchByPrimaryKey(primaryKey);

		if (eMagazine_BinhLuan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSucheMagazine_BinhLuanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return eMagazine_BinhLuan;
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key or throws a <code>NoSucheMagazine_BinhLuanException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public eMagazine_BinhLuan findByPrimaryKey(long id)
		throws NoSucheMagazine_BinhLuanException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan, or <code>null</code> if a e magazine_ binh luan with the primary key could not be found
	 */
	@Override
	public eMagazine_BinhLuan fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the e magazine_ binh luans.
	 *
	 * @return the e magazine_ binh luans
	 */
	@Override
	public List<eMagazine_BinhLuan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @return the range of e magazine_ binh luans
	 */
	@Override
	public List<eMagazine_BinhLuan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazine_ binh luans
	 */
	@Override
	public List<eMagazine_BinhLuan> findAll(
		int start, int end,
		OrderByComparator<eMagazine_BinhLuan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazine_ binh luans
	 */
	@Override
	public List<eMagazine_BinhLuan> findAll(
		int start, int end,
		OrderByComparator<eMagazine_BinhLuan> orderByComparator,
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

		List<eMagazine_BinhLuan> list = null;

		if (useFinderCache) {
			list = (List<eMagazine_BinhLuan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EMAGAZINE_BINHLUAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EMAGAZINE_BINHLUAN;

				sql = sql.concat(eMagazine_BinhLuanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<eMagazine_BinhLuan>)QueryUtil.list(
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
	 * Removes all the e magazine_ binh luans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (eMagazine_BinhLuan eMagazine_BinhLuan : findAll()) {
			remove(eMagazine_BinhLuan);
		}
	}

	/**
	 * Returns the number of e magazine_ binh luans.
	 *
	 * @return the number of e magazine_ binh luans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_EMAGAZINE_BINHLUAN);

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
		return _SQL_SELECT_EMAGAZINE_BINHLUAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return eMagazine_BinhLuanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the e magazine_ binh luan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new eMagazine_BinhLuanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", eMagazine_BinhLuan.class.getName()));

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

		_seteMagazine_BinhLuanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_seteMagazine_BinhLuanUtilPersistence(null);

		entityCache.removeCache(eMagazine_BinhLuanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _seteMagazine_BinhLuanUtilPersistence(
		eMagazine_BinhLuanPersistence eMagazine_BinhLuanPersistence) {

		try {
			Field field = eMagazine_BinhLuanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, eMagazine_BinhLuanPersistence);
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

	private static final String _SQL_SELECT_EMAGAZINE_BINHLUAN =
		"SELECT eMagazine_BinhLuan FROM eMagazine_BinhLuan eMagazine_BinhLuan";

	private static final String _SQL_COUNT_EMAGAZINE_BINHLUAN =
		"SELECT COUNT(eMagazine_BinhLuan) FROM eMagazine_BinhLuan eMagazine_BinhLuan";

	private static final String _ORDER_BY_ENTITY_ALIAS = "eMagazine_BinhLuan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No eMagazine_BinhLuan exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		eMagazine_BinhLuanPersistenceImpl.class);

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

	private static class eMagazine_BinhLuanModelArgumentsResolver
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

			eMagazine_BinhLuanModelImpl eMagazine_BinhLuanModelImpl =
				(eMagazine_BinhLuanModelImpl)baseModel;

			long columnBitmask = eMagazine_BinhLuanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					eMagazine_BinhLuanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						eMagazine_BinhLuanModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					eMagazine_BinhLuanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			eMagazine_BinhLuanModelImpl eMagazine_BinhLuanModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						eMagazine_BinhLuanModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = eMagazine_BinhLuanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}