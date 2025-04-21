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

import vn.dnict.tintuc.exception.NoSuchNews_SubcategoriesException;
import vn.dnict.tintuc.model.News_Subcategories;
import vn.dnict.tintuc.model.impl.News_SubcategoriesImpl;
import vn.dnict.tintuc.model.impl.News_SubcategoriesModelImpl;
import vn.dnict.tintuc.service.persistence.News_SubcategoriesPersistence;
import vn.dnict.tintuc.service.persistence.News_SubcategoriesUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ subcategories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_SubcategoriesPersistence.class)
public class News_SubcategoriesPersistenceImpl
	extends BasePersistenceImpl<News_Subcategories>
	implements News_SubcategoriesPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_SubcategoriesUtil</code> to access the news_ subcategories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_SubcategoriesImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_SubcategoriesPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_Subcategories.class);

		setModelImplClass(News_SubcategoriesImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ subcategories in the entity cache if it is enabled.
	 *
	 * @param news_Subcategories the news_ subcategories
	 */
	@Override
	public void cacheResult(News_Subcategories news_Subcategories) {
		entityCache.putResult(
			News_SubcategoriesImpl.class, news_Subcategories.getPrimaryKey(),
			news_Subcategories);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ subcategorieses in the entity cache if it is enabled.
	 *
	 * @param news_Subcategorieses the news_ subcategorieses
	 */
	@Override
	public void cacheResult(List<News_Subcategories> news_Subcategorieses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_Subcategorieses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_Subcategories news_Subcategories : news_Subcategorieses) {
			if (entityCache.getResult(
					News_SubcategoriesImpl.class,
					news_Subcategories.getPrimaryKey()) == null) {

				cacheResult(news_Subcategories);
			}
		}
	}

	/**
	 * Clears the cache for all news_ subcategorieses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_SubcategoriesImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ subcategories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_Subcategories news_Subcategories) {
		entityCache.removeResult(
			News_SubcategoriesImpl.class, news_Subcategories);
	}

	@Override
	public void clearCache(List<News_Subcategories> news_Subcategorieses) {
		for (News_Subcategories news_Subcategories : news_Subcategorieses) {
			entityCache.removeResult(
				News_SubcategoriesImpl.class, news_Subcategories);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_SubcategoriesImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ subcategories with the primary key. Does not add the news_ subcategories to the database.
	 *
	 * @param id the primary key for the new news_ subcategories
	 * @return the new news_ subcategories
	 */
	@Override
	public News_Subcategories create(long id) {
		News_Subcategories news_Subcategories = new News_SubcategoriesImpl();

		news_Subcategories.setNew(true);
		news_Subcategories.setPrimaryKey(id);

		news_Subcategories.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_Subcategories;
	}

	/**
	 * Removes the news_ subcategories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories that was removed
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public News_Subcategories remove(long id)
		throws NoSuchNews_SubcategoriesException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ subcategories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ subcategories
	 * @return the news_ subcategories that was removed
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public News_Subcategories remove(Serializable primaryKey)
		throws NoSuchNews_SubcategoriesException {

		Session session = null;

		try {
			session = openSession();

			News_Subcategories news_Subcategories =
				(News_Subcategories)session.get(
					News_SubcategoriesImpl.class, primaryKey);

			if (news_Subcategories == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_SubcategoriesException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_Subcategories);
		}
		catch (NoSuchNews_SubcategoriesException noSuchEntityException) {
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
	protected News_Subcategories removeImpl(
		News_Subcategories news_Subcategories) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_Subcategories)) {
				news_Subcategories = (News_Subcategories)session.get(
					News_SubcategoriesImpl.class,
					news_Subcategories.getPrimaryKeyObj());
			}

			if (news_Subcategories != null) {
				session.delete(news_Subcategories);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_Subcategories != null) {
			clearCache(news_Subcategories);
		}

		return news_Subcategories;
	}

	@Override
	public News_Subcategories updateImpl(
		News_Subcategories news_Subcategories) {

		boolean isNew = news_Subcategories.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_Subcategories);
			}
			else {
				news_Subcategories = (News_Subcategories)session.merge(
					news_Subcategories);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			News_SubcategoriesImpl.class, news_Subcategories, false, true);

		if (isNew) {
			news_Subcategories.setNew(false);
		}

		news_Subcategories.resetOriginalValues();

		return news_Subcategories;
	}

	/**
	 * Returns the news_ subcategories with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ subcategories
	 * @return the news_ subcategories
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public News_Subcategories findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_SubcategoriesException {

		News_Subcategories news_Subcategories = fetchByPrimaryKey(primaryKey);

		if (news_Subcategories == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_SubcategoriesException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_Subcategories;
	}

	/**
	 * Returns the news_ subcategories with the primary key or throws a <code>NoSuchNews_SubcategoriesException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public News_Subcategories findByPrimaryKey(long id)
		throws NoSuchNews_SubcategoriesException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ subcategories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories, or <code>null</code> if a news_ subcategories with the primary key could not be found
	 */
	@Override
	public News_Subcategories fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ subcategorieses.
	 *
	 * @return the news_ subcategorieses
	 */
	@Override
	public List<News_Subcategories> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @return the range of news_ subcategorieses
	 */
	@Override
	public List<News_Subcategories> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ subcategorieses
	 */
	@Override
	public List<News_Subcategories> findAll(
		int start, int end,
		OrderByComparator<News_Subcategories> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ subcategorieses
	 */
	@Override
	public List<News_Subcategories> findAll(
		int start, int end,
		OrderByComparator<News_Subcategories> orderByComparator,
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

		List<News_Subcategories> list = null;

		if (useFinderCache) {
			list = (List<News_Subcategories>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_SUBCATEGORIES);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_SUBCATEGORIES;

				sql = sql.concat(News_SubcategoriesModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_Subcategories>)QueryUtil.list(
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
	 * Removes all the news_ subcategorieses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_Subcategories news_Subcategories : findAll()) {
			remove(news_Subcategories);
		}
	}

	/**
	 * Returns the number of news_ subcategorieses.
	 *
	 * @return the number of news_ subcategorieses
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
					_SQL_COUNT_NEWS_SUBCATEGORIES);

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
		return _SQL_SELECT_NEWS_SUBCATEGORIES;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_SubcategoriesModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ subcategories persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new News_SubcategoriesModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_Subcategories.class.getName()));

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

		_setNews_SubcategoriesUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_SubcategoriesUtilPersistence(null);

		entityCache.removeCache(News_SubcategoriesImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_SubcategoriesUtilPersistence(
		News_SubcategoriesPersistence news_SubcategoriesPersistence) {

		try {
			Field field = News_SubcategoriesUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, news_SubcategoriesPersistence);
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

	private static final String _SQL_SELECT_NEWS_SUBCATEGORIES =
		"SELECT news_Subcategories FROM News_Subcategories news_Subcategories";

	private static final String _SQL_COUNT_NEWS_SUBCATEGORIES =
		"SELECT COUNT(news_Subcategories) FROM News_Subcategories news_Subcategories";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_Subcategories.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_Subcategories exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_SubcategoriesPersistenceImpl.class);

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

	private static class News_SubcategoriesModelArgumentsResolver
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

			News_SubcategoriesModelImpl news_SubcategoriesModelImpl =
				(News_SubcategoriesModelImpl)baseModel;

			long columnBitmask = news_SubcategoriesModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					news_SubcategoriesModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_SubcategoriesModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(News_SubcategoriesPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					news_SubcategoriesModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_SubcategoriesModelImpl news_SubcategoriesModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						news_SubcategoriesModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = news_SubcategoriesModelImpl.getColumnValue(
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