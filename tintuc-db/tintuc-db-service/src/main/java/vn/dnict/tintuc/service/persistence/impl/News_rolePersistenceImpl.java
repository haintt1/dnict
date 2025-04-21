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

package vn.dnict.tintuc.service.persistence.impl;

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

import vn.dnict.tintuc.exception.NoSuchNews_roleException;
import vn.dnict.tintuc.model.News_role;
import vn.dnict.tintuc.model.impl.News_roleImpl;
import vn.dnict.tintuc.model.impl.News_roleModelImpl;
import vn.dnict.tintuc.service.persistence.News_rolePersistence;
import vn.dnict.tintuc.service.persistence.News_roleUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_rolePersistence.class)
public class News_rolePersistenceImpl
	extends BasePersistenceImpl<News_role> implements News_rolePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_roleUtil</code> to access the news_role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_roleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_rolePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_role.class);

		setModelImplClass(News_roleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_role in the entity cache if it is enabled.
	 *
	 * @param news_role the news_role
	 */
	@Override
	public void cacheResult(News_role news_role) {
		entityCache.putResult(
			News_roleImpl.class, news_role.getPrimaryKey(), news_role);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_roles in the entity cache if it is enabled.
	 *
	 * @param news_roles the news_roles
	 */
	@Override
	public void cacheResult(List<News_role> news_roles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_roles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_role news_role : news_roles) {
			if (entityCache.getResult(
					News_roleImpl.class, news_role.getPrimaryKey()) == null) {

				cacheResult(news_role);
			}
		}
	}

	/**
	 * Clears the cache for all news_roles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_roleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_role.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_role news_role) {
		entityCache.removeResult(News_roleImpl.class, news_role);
	}

	@Override
	public void clearCache(List<News_role> news_roles) {
		for (News_role news_role : news_roles) {
			entityCache.removeResult(News_roleImpl.class, news_role);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_roleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_role with the primary key. Does not add the news_role to the database.
	 *
	 * @param id the primary key for the new news_role
	 * @return the new news_role
	 */
	@Override
	public News_role create(long id) {
		News_role news_role = new News_roleImpl();

		news_role.setNew(true);
		news_role.setPrimaryKey(id);

		news_role.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_role;
	}

	/**
	 * Removes the news_role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role that was removed
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	@Override
	public News_role remove(long id) throws NoSuchNews_roleException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the news_role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_role
	 * @return the news_role that was removed
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	@Override
	public News_role remove(Serializable primaryKey)
		throws NoSuchNews_roleException {

		Session session = null;

		try {
			session = openSession();

			News_role news_role = (News_role)session.get(
				News_roleImpl.class, primaryKey);

			if (news_role == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_roleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_role);
		}
		catch (NoSuchNews_roleException noSuchEntityException) {
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
	protected News_role removeImpl(News_role news_role) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_role)) {
				news_role = (News_role)session.get(
					News_roleImpl.class, news_role.getPrimaryKeyObj());
			}

			if (news_role != null) {
				session.delete(news_role);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_role != null) {
			clearCache(news_role);
		}

		return news_role;
	}

	@Override
	public News_role updateImpl(News_role news_role) {
		boolean isNew = news_role.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_role);
			}
			else {
				news_role = (News_role)session.merge(news_role);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(News_roleImpl.class, news_role, false, true);

		if (isNew) {
			news_role.setNew(false);
		}

		news_role.resetOriginalValues();

		return news_role;
	}

	/**
	 * Returns the news_role with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_role
	 * @return the news_role
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	@Override
	public News_role findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_roleException {

		News_role news_role = fetchByPrimaryKey(primaryKey);

		if (news_role == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_roleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_role;
	}

	/**
	 * Returns the news_role with the primary key or throws a <code>NoSuchNews_roleException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	@Override
	public News_role findByPrimaryKey(long id) throws NoSuchNews_roleException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role, or <code>null</code> if a news_role with the primary key could not be found
	 */
	@Override
	public News_role fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_roles.
	 *
	 * @return the news_roles
	 */
	@Override
	public List<News_role> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @return the range of news_roles
	 */
	@Override
	public List<News_role> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_roles
	 */
	@Override
	public List<News_role> findAll(
		int start, int end, OrderByComparator<News_role> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_roles
	 */
	@Override
	public List<News_role> findAll(
		int start, int end, OrderByComparator<News_role> orderByComparator,
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

		List<News_role> list = null;

		if (useFinderCache) {
			list = (List<News_role>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_ROLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_ROLE;

				sql = sql.concat(News_roleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_role>)QueryUtil.list(
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
	 * Removes all the news_roles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_role news_role : findAll()) {
			remove(news_role);
		}
	}

	/**
	 * Returns the number of news_roles.
	 *
	 * @return the number of news_roles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWS_ROLE);

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
		return _SQL_SELECT_NEWS_ROLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_roleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_role persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new News_roleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_role.class.getName()));

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

		_setNews_roleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_roleUtilPersistence(null);

		entityCache.removeCache(News_roleImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_roleUtilPersistence(
		News_rolePersistence news_rolePersistence) {

		try {
			Field field = News_roleUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, news_rolePersistence);
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

	private static final String _SQL_SELECT_NEWS_ROLE =
		"SELECT news_role FROM News_role news_role";

	private static final String _SQL_COUNT_NEWS_ROLE =
		"SELECT COUNT(news_role) FROM News_role news_role";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_role.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_role exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_rolePersistenceImpl.class);

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

	private static class News_roleModelArgumentsResolver
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

			News_roleModelImpl news_roleModelImpl =
				(News_roleModelImpl)baseModel;

			long columnBitmask = news_roleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(news_roleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_roleModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(news_roleModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_roleModelImpl news_roleModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = news_roleModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = news_roleModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}