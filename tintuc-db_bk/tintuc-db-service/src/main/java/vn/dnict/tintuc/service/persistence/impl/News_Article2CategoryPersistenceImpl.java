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

import vn.dnict.tintuc.exception.NoSuchNews_Article2CategoryException;
import vn.dnict.tintuc.model.News_Article2Category;
import vn.dnict.tintuc.model.impl.News_Article2CategoryImpl;
import vn.dnict.tintuc.model.impl.News_Article2CategoryModelImpl;
import vn.dnict.tintuc.service.persistence.News_Article2CategoryPersistence;
import vn.dnict.tintuc.service.persistence.News_Article2CategoryUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ article2 category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_Article2CategoryPersistence.class)
public class News_Article2CategoryPersistenceImpl
	extends BasePersistenceImpl<News_Article2Category>
	implements News_Article2CategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_Article2CategoryUtil</code> to access the news_ article2 category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_Article2CategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_Article2CategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_Article2Category.class);

		setModelImplClass(News_Article2CategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ article2 category in the entity cache if it is enabled.
	 *
	 * @param news_Article2Category the news_ article2 category
	 */
	@Override
	public void cacheResult(News_Article2Category news_Article2Category) {
		entityCache.putResult(
			News_Article2CategoryImpl.class,
			news_Article2Category.getPrimaryKey(), news_Article2Category);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ article2 categories in the entity cache if it is enabled.
	 *
	 * @param news_Article2Categories the news_ article2 categories
	 */
	@Override
	public void cacheResult(
		List<News_Article2Category> news_Article2Categories) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_Article2Categories.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_Article2Category news_Article2Category :
				news_Article2Categories) {

			if (entityCache.getResult(
					News_Article2CategoryImpl.class,
					news_Article2Category.getPrimaryKey()) == null) {

				cacheResult(news_Article2Category);
			}
		}
	}

	/**
	 * Clears the cache for all news_ article2 categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_Article2CategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ article2 category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_Article2Category news_Article2Category) {
		entityCache.removeResult(
			News_Article2CategoryImpl.class, news_Article2Category);
	}

	@Override
	public void clearCache(
		List<News_Article2Category> news_Article2Categories) {

		for (News_Article2Category news_Article2Category :
				news_Article2Categories) {

			entityCache.removeResult(
				News_Article2CategoryImpl.class, news_Article2Category);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				News_Article2CategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ article2 category with the primary key. Does not add the news_ article2 category to the database.
	 *
	 * @param id the primary key for the new news_ article2 category
	 * @return the new news_ article2 category
	 */
	@Override
	public News_Article2Category create(long id) {
		News_Article2Category news_Article2Category =
			new News_Article2CategoryImpl();

		news_Article2Category.setNew(true);
		news_Article2Category.setPrimaryKey(id);

		news_Article2Category.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_Article2Category;
	}

	/**
	 * Removes the news_ article2 category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category that was removed
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public News_Article2Category remove(long id)
		throws NoSuchNews_Article2CategoryException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ article2 category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ article2 category
	 * @return the news_ article2 category that was removed
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public News_Article2Category remove(Serializable primaryKey)
		throws NoSuchNews_Article2CategoryException {

		Session session = null;

		try {
			session = openSession();

			News_Article2Category news_Article2Category =
				(News_Article2Category)session.get(
					News_Article2CategoryImpl.class, primaryKey);

			if (news_Article2Category == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_Article2CategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_Article2Category);
		}
		catch (NoSuchNews_Article2CategoryException noSuchEntityException) {
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
	protected News_Article2Category removeImpl(
		News_Article2Category news_Article2Category) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_Article2Category)) {
				news_Article2Category = (News_Article2Category)session.get(
					News_Article2CategoryImpl.class,
					news_Article2Category.getPrimaryKeyObj());
			}

			if (news_Article2Category != null) {
				session.delete(news_Article2Category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_Article2Category != null) {
			clearCache(news_Article2Category);
		}

		return news_Article2Category;
	}

	@Override
	public News_Article2Category updateImpl(
		News_Article2Category news_Article2Category) {

		boolean isNew = news_Article2Category.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_Article2Category);
			}
			else {
				news_Article2Category = (News_Article2Category)session.merge(
					news_Article2Category);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			News_Article2CategoryImpl.class, news_Article2Category, false,
			true);

		if (isNew) {
			news_Article2Category.setNew(false);
		}

		news_Article2Category.resetOriginalValues();

		return news_Article2Category;
	}

	/**
	 * Returns the news_ article2 category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ article2 category
	 * @return the news_ article2 category
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public News_Article2Category findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_Article2CategoryException {

		News_Article2Category news_Article2Category = fetchByPrimaryKey(
			primaryKey);

		if (news_Article2Category == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_Article2CategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_Article2Category;
	}

	/**
	 * Returns the news_ article2 category with the primary key or throws a <code>NoSuchNews_Article2CategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public News_Article2Category findByPrimaryKey(long id)
		throws NoSuchNews_Article2CategoryException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ article2 category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category, or <code>null</code> if a news_ article2 category with the primary key could not be found
	 */
	@Override
	public News_Article2Category fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ article2 categories.
	 *
	 * @return the news_ article2 categories
	 */
	@Override
	public List<News_Article2Category> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @return the range of news_ article2 categories
	 */
	@Override
	public List<News_Article2Category> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ article2 categories
	 */
	@Override
	public List<News_Article2Category> findAll(
		int start, int end,
		OrderByComparator<News_Article2Category> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ article2 categories
	 */
	@Override
	public List<News_Article2Category> findAll(
		int start, int end,
		OrderByComparator<News_Article2Category> orderByComparator,
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

		List<News_Article2Category> list = null;

		if (useFinderCache) {
			list = (List<News_Article2Category>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_ARTICLE2CATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_ARTICLE2CATEGORY;

				sql = sql.concat(News_Article2CategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_Article2Category>)QueryUtil.list(
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
	 * Removes all the news_ article2 categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_Article2Category news_Article2Category : findAll()) {
			remove(news_Article2Category);
		}
	}

	/**
	 * Returns the number of news_ article2 categories.
	 *
	 * @return the number of news_ article2 categories
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
					_SQL_COUNT_NEWS_ARTICLE2CATEGORY);

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
		return _SQL_SELECT_NEWS_ARTICLE2CATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_Article2CategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ article2 category persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new News_Article2CategoryModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_Article2Category.class.getName()));

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

		_setNews_Article2CategoryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_Article2CategoryUtilPersistence(null);

		entityCache.removeCache(News_Article2CategoryImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_Article2CategoryUtilPersistence(
		News_Article2CategoryPersistence news_Article2CategoryPersistence) {

		try {
			Field field = News_Article2CategoryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, news_Article2CategoryPersistence);
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

	private static final String _SQL_SELECT_NEWS_ARTICLE2CATEGORY =
		"SELECT news_Article2Category FROM News_Article2Category news_Article2Category";

	private static final String _SQL_COUNT_NEWS_ARTICLE2CATEGORY =
		"SELECT COUNT(news_Article2Category) FROM News_Article2Category news_Article2Category";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"news_Article2Category.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_Article2Category exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_Article2CategoryPersistenceImpl.class);

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

	private static class News_Article2CategoryModelArgumentsResolver
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

			News_Article2CategoryModelImpl news_Article2CategoryModelImpl =
				(News_Article2CategoryModelImpl)baseModel;

			long columnBitmask =
				news_Article2CategoryModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					news_Article2CategoryModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_Article2CategoryModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(News_Article2CategoryPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					news_Article2CategoryModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_Article2CategoryModelImpl news_Article2CategoryModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						news_Article2CategoryModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						news_Article2CategoryModelImpl.getColumnValue(
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