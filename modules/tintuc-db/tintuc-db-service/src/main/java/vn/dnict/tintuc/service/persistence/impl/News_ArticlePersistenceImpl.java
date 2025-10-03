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

import vn.dnict.tintuc.exception.NoSuchNews_ArticleException;
import vn.dnict.tintuc.model.News_Article;
import vn.dnict.tintuc.model.impl.News_ArticleImpl;
import vn.dnict.tintuc.model.impl.News_ArticleModelImpl;
import vn.dnict.tintuc.service.persistence.News_ArticlePersistence;
import vn.dnict.tintuc.service.persistence.News_ArticleUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ article service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_ArticlePersistence.class)
public class News_ArticlePersistenceImpl
	extends BasePersistenceImpl<News_Article>
	implements News_ArticlePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_ArticleUtil</code> to access the news_ article persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_ArticleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_ArticlePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_Article.class);

		setModelImplClass(News_ArticleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ article in the entity cache if it is enabled.
	 *
	 * @param news_Article the news_ article
	 */
	@Override
	public void cacheResult(News_Article news_Article) {
		entityCache.putResult(
			News_ArticleImpl.class, news_Article.getPrimaryKey(), news_Article);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ articles in the entity cache if it is enabled.
	 *
	 * @param news_Articles the news_ articles
	 */
	@Override
	public void cacheResult(List<News_Article> news_Articles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_Articles.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_Article news_Article : news_Articles) {
			if (entityCache.getResult(
					News_ArticleImpl.class, news_Article.getPrimaryKey()) ==
						null) {

				cacheResult(news_Article);
			}
		}
	}

	/**
	 * Clears the cache for all news_ articles.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_ArticleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ article.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_Article news_Article) {
		entityCache.removeResult(News_ArticleImpl.class, news_Article);
	}

	@Override
	public void clearCache(List<News_Article> news_Articles) {
		for (News_Article news_Article : news_Articles) {
			entityCache.removeResult(News_ArticleImpl.class, news_Article);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_ArticleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ article with the primary key. Does not add the news_ article to the database.
	 *
	 * @param id the primary key for the new news_ article
	 * @return the new news_ article
	 */
	@Override
	public News_Article create(long id) {
		News_Article news_Article = new News_ArticleImpl();

		news_Article.setNew(true);
		news_Article.setPrimaryKey(id);

		news_Article.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_Article;
	}

	/**
	 * Removes the news_ article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article that was removed
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	@Override
	public News_Article remove(long id) throws NoSuchNews_ArticleException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ article with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ article
	 * @return the news_ article that was removed
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	@Override
	public News_Article remove(Serializable primaryKey)
		throws NoSuchNews_ArticleException {

		Session session = null;

		try {
			session = openSession();

			News_Article news_Article = (News_Article)session.get(
				News_ArticleImpl.class, primaryKey);

			if (news_Article == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_ArticleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_Article);
		}
		catch (NoSuchNews_ArticleException noSuchEntityException) {
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
	protected News_Article removeImpl(News_Article news_Article) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_Article)) {
				news_Article = (News_Article)session.get(
					News_ArticleImpl.class, news_Article.getPrimaryKeyObj());
			}

			if (news_Article != null) {
				session.delete(news_Article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_Article != null) {
			clearCache(news_Article);
		}

		return news_Article;
	}

	@Override
	public News_Article updateImpl(News_Article news_Article) {
		boolean isNew = news_Article.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_Article);
			}
			else {
				news_Article = (News_Article)session.merge(news_Article);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			News_ArticleImpl.class, news_Article, false, true);

		if (isNew) {
			news_Article.setNew(false);
		}

		news_Article.resetOriginalValues();

		return news_Article;
	}

	/**
	 * Returns the news_ article with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ article
	 * @return the news_ article
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	@Override
	public News_Article findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_ArticleException {

		News_Article news_Article = fetchByPrimaryKey(primaryKey);

		if (news_Article == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_ArticleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_Article;
	}

	/**
	 * Returns the news_ article with the primary key or throws a <code>NoSuchNews_ArticleException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article
	 * @throws NoSuchNews_ArticleException if a news_ article with the primary key could not be found
	 */
	@Override
	public News_Article findByPrimaryKey(long id)
		throws NoSuchNews_ArticleException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ article with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article
	 * @return the news_ article, or <code>null</code> if a news_ article with the primary key could not be found
	 */
	@Override
	public News_Article fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ articles.
	 *
	 * @return the news_ articles
	 */
	@Override
	public List<News_Article> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @return the range of news_ articles
	 */
	@Override
	public List<News_Article> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ articles
	 */
	@Override
	public List<News_Article> findAll(
		int start, int end, OrderByComparator<News_Article> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ articles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_ArticleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ articles
	 * @param end the upper bound of the range of news_ articles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ articles
	 */
	@Override
	public List<News_Article> findAll(
		int start, int end, OrderByComparator<News_Article> orderByComparator,
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

		List<News_Article> list = null;

		if (useFinderCache) {
			list = (List<News_Article>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_ARTICLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_ARTICLE;

				sql = sql.concat(News_ArticleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_Article>)QueryUtil.list(
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
	 * Removes all the news_ articles from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_Article news_Article : findAll()) {
			remove(news_Article);
		}
	}

	/**
	 * Returns the number of news_ articles.
	 *
	 * @return the number of news_ articles
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWS_ARTICLE);

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
		return _SQL_SELECT_NEWS_ARTICLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_ArticleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ article persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new News_ArticleModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_Article.class.getName()));

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

		_setNews_ArticleUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_ArticleUtilPersistence(null);

		entityCache.removeCache(News_ArticleImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_ArticleUtilPersistence(
		News_ArticlePersistence news_ArticlePersistence) {

		try {
			Field field = News_ArticleUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, news_ArticlePersistence);
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

	private static final String _SQL_SELECT_NEWS_ARTICLE =
		"SELECT news_Article FROM News_Article news_Article";

	private static final String _SQL_COUNT_NEWS_ARTICLE =
		"SELECT COUNT(news_Article) FROM News_Article news_Article";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_Article.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_Article exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_ArticlePersistenceImpl.class);

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

	private static class News_ArticleModelArgumentsResolver
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

			News_ArticleModelImpl news_ArticleModelImpl =
				(News_ArticleModelImpl)baseModel;

			long columnBitmask = news_ArticleModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(news_ArticleModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_ArticleModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(News_ArticlePersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(news_ArticleModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_ArticleModelImpl news_ArticleModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = news_ArticleModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = news_ArticleModelImpl.getColumnValue(
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