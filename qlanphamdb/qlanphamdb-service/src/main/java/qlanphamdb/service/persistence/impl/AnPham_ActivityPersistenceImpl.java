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

import qlanphamdb.exception.NoSuchAnPham_ActivityException;

import qlanphamdb.model.AnPham_Activity;
import qlanphamdb.model.impl.AnPham_ActivityImpl;
import qlanphamdb.model.impl.AnPham_ActivityModelImpl;

import qlanphamdb.service.persistence.AnPham_ActivityPersistence;
import qlanphamdb.service.persistence.AnPham_ActivityUtil;
import qlanphamdb.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the an pham_ activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = AnPham_ActivityPersistence.class)
public class AnPham_ActivityPersistenceImpl
	extends BasePersistenceImpl<AnPham_Activity>
	implements AnPham_ActivityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnPham_ActivityUtil</code> to access the an pham_ activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnPham_ActivityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AnPham_ActivityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnPham_Activity.class);

		setModelImplClass(AnPham_ActivityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the an pham_ activity in the entity cache if it is enabled.
	 *
	 * @param anPham_Activity the an pham_ activity
	 */
	@Override
	public void cacheResult(AnPham_Activity anPham_Activity) {
		entityCache.putResult(
			AnPham_ActivityImpl.class, anPham_Activity.getPrimaryKey(),
			anPham_Activity);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the an pham_ activities in the entity cache if it is enabled.
	 *
	 * @param anPham_Activities the an pham_ activities
	 */
	@Override
	public void cacheResult(List<AnPham_Activity> anPham_Activities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (anPham_Activities.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnPham_Activity anPham_Activity : anPham_Activities) {
			if (entityCache.getResult(
					AnPham_ActivityImpl.class,
					anPham_Activity.getPrimaryKey()) == null) {

				cacheResult(anPham_Activity);
			}
		}
	}

	/**
	 * Clears the cache for all an pham_ activities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnPham_ActivityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the an pham_ activity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnPham_Activity anPham_Activity) {
		entityCache.removeResult(AnPham_ActivityImpl.class, anPham_Activity);
	}

	@Override
	public void clearCache(List<AnPham_Activity> anPham_Activities) {
		for (AnPham_Activity anPham_Activity : anPham_Activities) {
			entityCache.removeResult(
				AnPham_ActivityImpl.class, anPham_Activity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnPham_ActivityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new an pham_ activity with the primary key. Does not add the an pham_ activity to the database.
	 *
	 * @param id the primary key for the new an pham_ activity
	 * @return the new an pham_ activity
	 */
	@Override
	public AnPham_Activity create(long id) {
		AnPham_Activity anPham_Activity = new AnPham_ActivityImpl();

		anPham_Activity.setNew(true);
		anPham_Activity.setPrimaryKey(id);

		anPham_Activity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return anPham_Activity;
	}

	/**
	 * Removes the an pham_ activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity that was removed
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public AnPham_Activity remove(long id)
		throws NoSuchAnPham_ActivityException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the an pham_ activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the an pham_ activity
	 * @return the an pham_ activity that was removed
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public AnPham_Activity remove(Serializable primaryKey)
		throws NoSuchAnPham_ActivityException {

		Session session = null;

		try {
			session = openSession();

			AnPham_Activity anPham_Activity = (AnPham_Activity)session.get(
				AnPham_ActivityImpl.class, primaryKey);

			if (anPham_Activity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnPham_ActivityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(anPham_Activity);
		}
		catch (NoSuchAnPham_ActivityException noSuchEntityException) {
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
	protected AnPham_Activity removeImpl(AnPham_Activity anPham_Activity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anPham_Activity)) {
				anPham_Activity = (AnPham_Activity)session.get(
					AnPham_ActivityImpl.class,
					anPham_Activity.getPrimaryKeyObj());
			}

			if (anPham_Activity != null) {
				session.delete(anPham_Activity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (anPham_Activity != null) {
			clearCache(anPham_Activity);
		}

		return anPham_Activity;
	}

	@Override
	public AnPham_Activity updateImpl(AnPham_Activity anPham_Activity) {
		boolean isNew = anPham_Activity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(anPham_Activity);
			}
			else {
				anPham_Activity = (AnPham_Activity)session.merge(
					anPham_Activity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnPham_ActivityImpl.class, anPham_Activity, false, true);

		if (isNew) {
			anPham_Activity.setNew(false);
		}

		anPham_Activity.resetOriginalValues();

		return anPham_Activity;
	}

	/**
	 * Returns the an pham_ activity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the an pham_ activity
	 * @return the an pham_ activity
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public AnPham_Activity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnPham_ActivityException {

		AnPham_Activity anPham_Activity = fetchByPrimaryKey(primaryKey);

		if (anPham_Activity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnPham_ActivityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return anPham_Activity;
	}

	/**
	 * Returns the an pham_ activity with the primary key or throws a <code>NoSuchAnPham_ActivityException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public AnPham_Activity findByPrimaryKey(long id)
		throws NoSuchAnPham_ActivityException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the an pham_ activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity, or <code>null</code> if a an pham_ activity with the primary key could not be found
	 */
	@Override
	public AnPham_Activity fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the an pham_ activities.
	 *
	 * @return the an pham_ activities
	 */
	@Override
	public List<AnPham_Activity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @return the range of an pham_ activities
	 */
	@Override
	public List<AnPham_Activity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ activities
	 */
	@Override
	public List<AnPham_Activity> findAll(
		int start, int end,
		OrderByComparator<AnPham_Activity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ activities
	 */
	@Override
	public List<AnPham_Activity> findAll(
		int start, int end,
		OrderByComparator<AnPham_Activity> orderByComparator,
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

		List<AnPham_Activity> list = null;

		if (useFinderCache) {
			list = (List<AnPham_Activity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANPHAM_ACTIVITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANPHAM_ACTIVITY;

				sql = sql.concat(AnPham_ActivityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnPham_Activity>)QueryUtil.list(
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
	 * Removes all the an pham_ activities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnPham_Activity anPham_Activity : findAll()) {
			remove(anPham_Activity);
		}
	}

	/**
	 * Returns the number of an pham_ activities.
	 *
	 * @return the number of an pham_ activities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ANPHAM_ACTIVITY);

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
		return _SQL_SELECT_ANPHAM_ACTIVITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnPham_ActivityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the an pham_ activity persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AnPham_ActivityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AnPham_Activity.class.getName()));

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

		_setAnPham_ActivityUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnPham_ActivityUtilPersistence(null);

		entityCache.removeCache(AnPham_ActivityImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAnPham_ActivityUtilPersistence(
		AnPham_ActivityPersistence anPham_ActivityPersistence) {

		try {
			Field field = AnPham_ActivityUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, anPham_ActivityPersistence);
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

	private static final String _SQL_SELECT_ANPHAM_ACTIVITY =
		"SELECT anPham_Activity FROM AnPham_Activity anPham_Activity";

	private static final String _SQL_COUNT_ANPHAM_ACTIVITY =
		"SELECT COUNT(anPham_Activity) FROM AnPham_Activity anPham_Activity";

	private static final String _ORDER_BY_ENTITY_ALIAS = "anPham_Activity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnPham_Activity exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AnPham_ActivityPersistenceImpl.class);

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

	private static class AnPham_ActivityModelArgumentsResolver
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

			AnPham_ActivityModelImpl anPham_ActivityModelImpl =
				(AnPham_ActivityModelImpl)baseModel;

			long columnBitmask = anPham_ActivityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					anPham_ActivityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						anPham_ActivityModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					anPham_ActivityModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AnPham_ActivityModelImpl anPham_ActivityModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						anPham_ActivityModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = anPham_ActivityModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}