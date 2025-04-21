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

import qlanphamdb.exception.NoSuchAnPham_PhanCongException;

import qlanphamdb.model.AnPham_PhanCong;
import qlanphamdb.model.impl.AnPham_PhanCongImpl;
import qlanphamdb.model.impl.AnPham_PhanCongModelImpl;

import qlanphamdb.service.persistence.AnPham_PhanCongPersistence;
import qlanphamdb.service.persistence.AnPham_PhanCongUtil;
import qlanphamdb.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the an pham_ phan cong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = AnPham_PhanCongPersistence.class)
public class AnPham_PhanCongPersistenceImpl
	extends BasePersistenceImpl<AnPham_PhanCong>
	implements AnPham_PhanCongPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnPham_PhanCongUtil</code> to access the an pham_ phan cong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnPham_PhanCongImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AnPham_PhanCongPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnPham_PhanCong.class);

		setModelImplClass(AnPham_PhanCongImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the an pham_ phan cong in the entity cache if it is enabled.
	 *
	 * @param anPham_PhanCong the an pham_ phan cong
	 */
	@Override
	public void cacheResult(AnPham_PhanCong anPham_PhanCong) {
		entityCache.putResult(
			AnPham_PhanCongImpl.class, anPham_PhanCong.getPrimaryKey(),
			anPham_PhanCong);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the an pham_ phan congs in the entity cache if it is enabled.
	 *
	 * @param anPham_PhanCongs the an pham_ phan congs
	 */
	@Override
	public void cacheResult(List<AnPham_PhanCong> anPham_PhanCongs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (anPham_PhanCongs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnPham_PhanCong anPham_PhanCong : anPham_PhanCongs) {
			if (entityCache.getResult(
					AnPham_PhanCongImpl.class,
					anPham_PhanCong.getPrimaryKey()) == null) {

				cacheResult(anPham_PhanCong);
			}
		}
	}

	/**
	 * Clears the cache for all an pham_ phan congs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnPham_PhanCongImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the an pham_ phan cong.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnPham_PhanCong anPham_PhanCong) {
		entityCache.removeResult(AnPham_PhanCongImpl.class, anPham_PhanCong);
	}

	@Override
	public void clearCache(List<AnPham_PhanCong> anPham_PhanCongs) {
		for (AnPham_PhanCong anPham_PhanCong : anPham_PhanCongs) {
			entityCache.removeResult(
				AnPham_PhanCongImpl.class, anPham_PhanCong);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnPham_PhanCongImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new an pham_ phan cong with the primary key. Does not add the an pham_ phan cong to the database.
	 *
	 * @param id the primary key for the new an pham_ phan cong
	 * @return the new an pham_ phan cong
	 */
	@Override
	public AnPham_PhanCong create(long id) {
		AnPham_PhanCong anPham_PhanCong = new AnPham_PhanCongImpl();

		anPham_PhanCong.setNew(true);
		anPham_PhanCong.setPrimaryKey(id);

		anPham_PhanCong.setCompanyId(CompanyThreadLocal.getCompanyId());

		return anPham_PhanCong;
	}

	/**
	 * Removes the an pham_ phan cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ phan cong
	 * @return the an pham_ phan cong that was removed
	 * @throws NoSuchAnPham_PhanCongException if a an pham_ phan cong with the primary key could not be found
	 */
	@Override
	public AnPham_PhanCong remove(long id)
		throws NoSuchAnPham_PhanCongException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the an pham_ phan cong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the an pham_ phan cong
	 * @return the an pham_ phan cong that was removed
	 * @throws NoSuchAnPham_PhanCongException if a an pham_ phan cong with the primary key could not be found
	 */
	@Override
	public AnPham_PhanCong remove(Serializable primaryKey)
		throws NoSuchAnPham_PhanCongException {

		Session session = null;

		try {
			session = openSession();

			AnPham_PhanCong anPham_PhanCong = (AnPham_PhanCong)session.get(
				AnPham_PhanCongImpl.class, primaryKey);

			if (anPham_PhanCong == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnPham_PhanCongException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(anPham_PhanCong);
		}
		catch (NoSuchAnPham_PhanCongException noSuchEntityException) {
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
	protected AnPham_PhanCong removeImpl(AnPham_PhanCong anPham_PhanCong) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anPham_PhanCong)) {
				anPham_PhanCong = (AnPham_PhanCong)session.get(
					AnPham_PhanCongImpl.class,
					anPham_PhanCong.getPrimaryKeyObj());
			}

			if (anPham_PhanCong != null) {
				session.delete(anPham_PhanCong);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (anPham_PhanCong != null) {
			clearCache(anPham_PhanCong);
		}

		return anPham_PhanCong;
	}

	@Override
	public AnPham_PhanCong updateImpl(AnPham_PhanCong anPham_PhanCong) {
		boolean isNew = anPham_PhanCong.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(anPham_PhanCong);
			}
			else {
				anPham_PhanCong = (AnPham_PhanCong)session.merge(
					anPham_PhanCong);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnPham_PhanCongImpl.class, anPham_PhanCong, false, true);

		if (isNew) {
			anPham_PhanCong.setNew(false);
		}

		anPham_PhanCong.resetOriginalValues();

		return anPham_PhanCong;
	}

	/**
	 * Returns the an pham_ phan cong with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the an pham_ phan cong
	 * @return the an pham_ phan cong
	 * @throws NoSuchAnPham_PhanCongException if a an pham_ phan cong with the primary key could not be found
	 */
	@Override
	public AnPham_PhanCong findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnPham_PhanCongException {

		AnPham_PhanCong anPham_PhanCong = fetchByPrimaryKey(primaryKey);

		if (anPham_PhanCong == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnPham_PhanCongException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return anPham_PhanCong;
	}

	/**
	 * Returns the an pham_ phan cong with the primary key or throws a <code>NoSuchAnPham_PhanCongException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ phan cong
	 * @return the an pham_ phan cong
	 * @throws NoSuchAnPham_PhanCongException if a an pham_ phan cong with the primary key could not be found
	 */
	@Override
	public AnPham_PhanCong findByPrimaryKey(long id)
		throws NoSuchAnPham_PhanCongException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the an pham_ phan cong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ phan cong
	 * @return the an pham_ phan cong, or <code>null</code> if a an pham_ phan cong with the primary key could not be found
	 */
	@Override
	public AnPham_PhanCong fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the an pham_ phan congs.
	 *
	 * @return the an pham_ phan congs
	 */
	@Override
	public List<AnPham_PhanCong> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the an pham_ phan congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_PhanCongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ phan congs
	 * @param end the upper bound of the range of an pham_ phan congs (not inclusive)
	 * @return the range of an pham_ phan congs
	 */
	@Override
	public List<AnPham_PhanCong> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the an pham_ phan congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_PhanCongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ phan congs
	 * @param end the upper bound of the range of an pham_ phan congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ phan congs
	 */
	@Override
	public List<AnPham_PhanCong> findAll(
		int start, int end,
		OrderByComparator<AnPham_PhanCong> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the an pham_ phan congs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_PhanCongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ phan congs
	 * @param end the upper bound of the range of an pham_ phan congs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ phan congs
	 */
	@Override
	public List<AnPham_PhanCong> findAll(
		int start, int end,
		OrderByComparator<AnPham_PhanCong> orderByComparator,
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

		List<AnPham_PhanCong> list = null;

		if (useFinderCache) {
			list = (List<AnPham_PhanCong>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANPHAM_PHANCONG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANPHAM_PHANCONG;

				sql = sql.concat(AnPham_PhanCongModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnPham_PhanCong>)QueryUtil.list(
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
	 * Removes all the an pham_ phan congs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnPham_PhanCong anPham_PhanCong : findAll()) {
			remove(anPham_PhanCong);
		}
	}

	/**
	 * Returns the number of an pham_ phan congs.
	 *
	 * @return the number of an pham_ phan congs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANPHAM_PHANCONG);

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
		return _SQL_SELECT_ANPHAM_PHANCONG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnPham_PhanCongModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the an pham_ phan cong persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AnPham_PhanCongModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AnPham_PhanCong.class.getName()));

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

		_setAnPham_PhanCongUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnPham_PhanCongUtilPersistence(null);

		entityCache.removeCache(AnPham_PhanCongImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAnPham_PhanCongUtilPersistence(
		AnPham_PhanCongPersistence anPham_PhanCongPersistence) {

		try {
			Field field = AnPham_PhanCongUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, anPham_PhanCongPersistence);
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

	private static final String _SQL_SELECT_ANPHAM_PHANCONG =
		"SELECT anPham_PhanCong FROM AnPham_PhanCong anPham_PhanCong";

	private static final String _SQL_COUNT_ANPHAM_PHANCONG =
		"SELECT COUNT(anPham_PhanCong) FROM AnPham_PhanCong anPham_PhanCong";

	private static final String _ORDER_BY_ENTITY_ALIAS = "anPham_PhanCong.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnPham_PhanCong exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AnPham_PhanCongPersistenceImpl.class);

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

	private static class AnPham_PhanCongModelArgumentsResolver
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

			AnPham_PhanCongModelImpl anPham_PhanCongModelImpl =
				(AnPham_PhanCongModelImpl)baseModel;

			long columnBitmask = anPham_PhanCongModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					anPham_PhanCongModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						anPham_PhanCongModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					anPham_PhanCongModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AnPham_PhanCongModelImpl anPham_PhanCongModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						anPham_PhanCongModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = anPham_PhanCongModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}