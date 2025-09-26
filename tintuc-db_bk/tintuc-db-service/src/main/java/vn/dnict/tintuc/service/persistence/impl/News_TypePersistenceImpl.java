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

import vn.dnict.tintuc.exception.NoSuchNews_TypeException;
import vn.dnict.tintuc.model.News_Type;
import vn.dnict.tintuc.model.impl.News_TypeImpl;
import vn.dnict.tintuc.model.impl.News_TypeModelImpl;
import vn.dnict.tintuc.service.persistence.News_TypePersistence;
import vn.dnict.tintuc.service.persistence.News_TypeUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_TypePersistence.class)
public class News_TypePersistenceImpl
	extends BasePersistenceImpl<News_Type> implements News_TypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_TypeUtil</code> to access the news_ type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_TypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_TypePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_Type.class);

		setModelImplClass(News_TypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ type in the entity cache if it is enabled.
	 *
	 * @param news_Type the news_ type
	 */
	@Override
	public void cacheResult(News_Type news_Type) {
		entityCache.putResult(
			News_TypeImpl.class, news_Type.getPrimaryKey(), news_Type);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ types in the entity cache if it is enabled.
	 *
	 * @param news_Types the news_ types
	 */
	@Override
	public void cacheResult(List<News_Type> news_Types) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_Types.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_Type news_Type : news_Types) {
			if (entityCache.getResult(
					News_TypeImpl.class, news_Type.getPrimaryKey()) == null) {

				cacheResult(news_Type);
			}
		}
	}

	/**
	 * Clears the cache for all news_ types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_TypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_Type news_Type) {
		entityCache.removeResult(News_TypeImpl.class, news_Type);
	}

	@Override
	public void clearCache(List<News_Type> news_Types) {
		for (News_Type news_Type : news_Types) {
			entityCache.removeResult(News_TypeImpl.class, news_Type);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_TypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ type with the primary key. Does not add the news_ type to the database.
	 *
	 * @param id the primary key for the new news_ type
	 * @return the new news_ type
	 */
	@Override
	public News_Type create(long id) {
		News_Type news_Type = new News_TypeImpl();

		news_Type.setNew(true);
		news_Type.setPrimaryKey(id);

		news_Type.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_Type;
	}

	/**
	 * Removes the news_ type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type that was removed
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	@Override
	public News_Type remove(long id) throws NoSuchNews_TypeException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ type
	 * @return the news_ type that was removed
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	@Override
	public News_Type remove(Serializable primaryKey)
		throws NoSuchNews_TypeException {

		Session session = null;

		try {
			session = openSession();

			News_Type news_Type = (News_Type)session.get(
				News_TypeImpl.class, primaryKey);

			if (news_Type == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_TypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_Type);
		}
		catch (NoSuchNews_TypeException noSuchEntityException) {
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
	protected News_Type removeImpl(News_Type news_Type) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_Type)) {
				news_Type = (News_Type)session.get(
					News_TypeImpl.class, news_Type.getPrimaryKeyObj());
			}

			if (news_Type != null) {
				session.delete(news_Type);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_Type != null) {
			clearCache(news_Type);
		}

		return news_Type;
	}

	@Override
	public News_Type updateImpl(News_Type news_Type) {
		boolean isNew = news_Type.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_Type);
			}
			else {
				news_Type = (News_Type)session.merge(news_Type);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(News_TypeImpl.class, news_Type, false, true);

		if (isNew) {
			news_Type.setNew(false);
		}

		news_Type.resetOriginalValues();

		return news_Type;
	}

	/**
	 * Returns the news_ type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ type
	 * @return the news_ type
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	@Override
	public News_Type findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_TypeException {

		News_Type news_Type = fetchByPrimaryKey(primaryKey);

		if (news_Type == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_TypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_Type;
	}

	/**
	 * Returns the news_ type with the primary key or throws a <code>NoSuchNews_TypeException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	@Override
	public News_Type findByPrimaryKey(long id) throws NoSuchNews_TypeException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type, or <code>null</code> if a news_ type with the primary key could not be found
	 */
	@Override
	public News_Type fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ types.
	 *
	 * @return the news_ types
	 */
	@Override
	public List<News_Type> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @return the range of news_ types
	 */
	@Override
	public List<News_Type> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ types
	 */
	@Override
	public List<News_Type> findAll(
		int start, int end, OrderByComparator<News_Type> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ types
	 */
	@Override
	public List<News_Type> findAll(
		int start, int end, OrderByComparator<News_Type> orderByComparator,
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

		List<News_Type> list = null;

		if (useFinderCache) {
			list = (List<News_Type>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_TYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_TYPE;

				sql = sql.concat(News_TypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_Type>)QueryUtil.list(
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
	 * Removes all the news_ types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_Type news_Type : findAll()) {
			remove(news_Type);
		}
	}

	/**
	 * Returns the number of news_ types.
	 *
	 * @return the number of news_ types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWS_TYPE);

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
		return _SQL_SELECT_NEWS_TYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_TypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new News_TypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_Type.class.getName()));

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

		_setNews_TypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_TypeUtilPersistence(null);

		entityCache.removeCache(News_TypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_TypeUtilPersistence(
		News_TypePersistence news_TypePersistence) {

		try {
			Field field = News_TypeUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, news_TypePersistence);
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

	private static final String _SQL_SELECT_NEWS_TYPE =
		"SELECT news_Type FROM News_Type news_Type";

	private static final String _SQL_COUNT_NEWS_TYPE =
		"SELECT COUNT(news_Type) FROM News_Type news_Type";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_Type.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_Type exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_TypePersistenceImpl.class);

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

	private static class News_TypeModelArgumentsResolver
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

			News_TypeModelImpl news_TypeModelImpl =
				(News_TypeModelImpl)baseModel;

			long columnBitmask = news_TypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(news_TypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_TypeModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(News_TypePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(news_TypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_TypeModelImpl news_TypeModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = news_TypeModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = news_TypeModelImpl.getColumnValue(
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