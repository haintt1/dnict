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

import vn.dnict.tintuc.exception.NoSuchNews_BinhLuanException;
import vn.dnict.tintuc.model.News_BinhLuan;
import vn.dnict.tintuc.model.impl.News_BinhLuanImpl;
import vn.dnict.tintuc.model.impl.News_BinhLuanModelImpl;
import vn.dnict.tintuc.service.persistence.News_BinhLuanPersistence;
import vn.dnict.tintuc.service.persistence.News_BinhLuanUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ binh luan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_BinhLuanPersistence.class)
public class News_BinhLuanPersistenceImpl
	extends BasePersistenceImpl<News_BinhLuan>
	implements News_BinhLuanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_BinhLuanUtil</code> to access the news_ binh luan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_BinhLuanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_BinhLuanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_BinhLuan.class);

		setModelImplClass(News_BinhLuanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ binh luan in the entity cache if it is enabled.
	 *
	 * @param news_BinhLuan the news_ binh luan
	 */
	@Override
	public void cacheResult(News_BinhLuan news_BinhLuan) {
		entityCache.putResult(
			News_BinhLuanImpl.class, news_BinhLuan.getPrimaryKey(),
			news_BinhLuan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ binh luans in the entity cache if it is enabled.
	 *
	 * @param news_BinhLuans the news_ binh luans
	 */
	@Override
	public void cacheResult(List<News_BinhLuan> news_BinhLuans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_BinhLuans.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_BinhLuan news_BinhLuan : news_BinhLuans) {
			if (entityCache.getResult(
					News_BinhLuanImpl.class, news_BinhLuan.getPrimaryKey()) ==
						null) {

				cacheResult(news_BinhLuan);
			}
		}
	}

	/**
	 * Clears the cache for all news_ binh luans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_BinhLuanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ binh luan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_BinhLuan news_BinhLuan) {
		entityCache.removeResult(News_BinhLuanImpl.class, news_BinhLuan);
	}

	@Override
	public void clearCache(List<News_BinhLuan> news_BinhLuans) {
		for (News_BinhLuan news_BinhLuan : news_BinhLuans) {
			entityCache.removeResult(News_BinhLuanImpl.class, news_BinhLuan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_BinhLuanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ binh luan with the primary key. Does not add the news_ binh luan to the database.
	 *
	 * @param id the primary key for the new news_ binh luan
	 * @return the new news_ binh luan
	 */
	@Override
	public News_BinhLuan create(long id) {
		News_BinhLuan news_BinhLuan = new News_BinhLuanImpl();

		news_BinhLuan.setNew(true);
		news_BinhLuan.setPrimaryKey(id);

		news_BinhLuan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_BinhLuan;
	}

	/**
	 * Removes the news_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan that was removed
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public News_BinhLuan remove(long id) throws NoSuchNews_BinhLuanException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ binh luan
	 * @return the news_ binh luan that was removed
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public News_BinhLuan remove(Serializable primaryKey)
		throws NoSuchNews_BinhLuanException {

		Session session = null;

		try {
			session = openSession();

			News_BinhLuan news_BinhLuan = (News_BinhLuan)session.get(
				News_BinhLuanImpl.class, primaryKey);

			if (news_BinhLuan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_BinhLuanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_BinhLuan);
		}
		catch (NoSuchNews_BinhLuanException noSuchEntityException) {
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
	protected News_BinhLuan removeImpl(News_BinhLuan news_BinhLuan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_BinhLuan)) {
				news_BinhLuan = (News_BinhLuan)session.get(
					News_BinhLuanImpl.class, news_BinhLuan.getPrimaryKeyObj());
			}

			if (news_BinhLuan != null) {
				session.delete(news_BinhLuan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_BinhLuan != null) {
			clearCache(news_BinhLuan);
		}

		return news_BinhLuan;
	}

	@Override
	public News_BinhLuan updateImpl(News_BinhLuan news_BinhLuan) {
		boolean isNew = news_BinhLuan.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_BinhLuan);
			}
			else {
				news_BinhLuan = (News_BinhLuan)session.merge(news_BinhLuan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			News_BinhLuanImpl.class, news_BinhLuan, false, true);

		if (isNew) {
			news_BinhLuan.setNew(false);
		}

		news_BinhLuan.resetOriginalValues();

		return news_BinhLuan;
	}

	/**
	 * Returns the news_ binh luan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ binh luan
	 * @return the news_ binh luan
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public News_BinhLuan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_BinhLuanException {

		News_BinhLuan news_BinhLuan = fetchByPrimaryKey(primaryKey);

		if (news_BinhLuan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_BinhLuanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_BinhLuan;
	}

	/**
	 * Returns the news_ binh luan with the primary key or throws a <code>NoSuchNews_BinhLuanException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public News_BinhLuan findByPrimaryKey(long id)
		throws NoSuchNews_BinhLuanException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ binh luan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan, or <code>null</code> if a news_ binh luan with the primary key could not be found
	 */
	@Override
	public News_BinhLuan fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ binh luans.
	 *
	 * @return the news_ binh luans
	 */
	@Override
	public List<News_BinhLuan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @return the range of news_ binh luans
	 */
	@Override
	public List<News_BinhLuan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ binh luans
	 */
	@Override
	public List<News_BinhLuan> findAll(
		int start, int end,
		OrderByComparator<News_BinhLuan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ binh luans
	 */
	@Override
	public List<News_BinhLuan> findAll(
		int start, int end, OrderByComparator<News_BinhLuan> orderByComparator,
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

		List<News_BinhLuan> list = null;

		if (useFinderCache) {
			list = (List<News_BinhLuan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_BINHLUAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_BINHLUAN;

				sql = sql.concat(News_BinhLuanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_BinhLuan>)QueryUtil.list(
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
	 * Removes all the news_ binh luans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_BinhLuan news_BinhLuan : findAll()) {
			remove(news_BinhLuan);
		}
	}

	/**
	 * Returns the number of news_ binh luans.
	 *
	 * @return the number of news_ binh luans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWS_BINHLUAN);

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
		return _SQL_SELECT_NEWS_BINHLUAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_BinhLuanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ binh luan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new News_BinhLuanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_BinhLuan.class.getName()));

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

		_setNews_BinhLuanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_BinhLuanUtilPersistence(null);

		entityCache.removeCache(News_BinhLuanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_BinhLuanUtilPersistence(
		News_BinhLuanPersistence news_BinhLuanPersistence) {

		try {
			Field field = News_BinhLuanUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, news_BinhLuanPersistence);
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

	private static final String _SQL_SELECT_NEWS_BINHLUAN =
		"SELECT news_BinhLuan FROM News_BinhLuan news_BinhLuan";

	private static final String _SQL_COUNT_NEWS_BINHLUAN =
		"SELECT COUNT(news_BinhLuan) FROM News_BinhLuan news_BinhLuan";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_BinhLuan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_BinhLuan exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_BinhLuanPersistenceImpl.class);

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

	private static class News_BinhLuanModelArgumentsResolver
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

			News_BinhLuanModelImpl news_BinhLuanModelImpl =
				(News_BinhLuanModelImpl)baseModel;

			long columnBitmask = news_BinhLuanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(news_BinhLuanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_BinhLuanModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(news_BinhLuanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_BinhLuanModelImpl news_BinhLuanModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						news_BinhLuanModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = news_BinhLuanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}