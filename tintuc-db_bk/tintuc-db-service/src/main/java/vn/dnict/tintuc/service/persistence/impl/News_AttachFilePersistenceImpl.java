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

import vn.dnict.tintuc.exception.NoSuchNews_AttachFileException;
import vn.dnict.tintuc.model.News_AttachFile;
import vn.dnict.tintuc.model.impl.News_AttachFileImpl;
import vn.dnict.tintuc.model.impl.News_AttachFileModelImpl;
import vn.dnict.tintuc.service.persistence.News_AttachFilePersistence;
import vn.dnict.tintuc.service.persistence.News_AttachFileUtil;
import vn.dnict.tintuc.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the news_ attach file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = News_AttachFilePersistence.class)
public class News_AttachFilePersistenceImpl
	extends BasePersistenceImpl<News_AttachFile>
	implements News_AttachFilePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>News_AttachFileUtil</code> to access the news_ attach file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		News_AttachFileImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public News_AttachFilePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(News_AttachFile.class);

		setModelImplClass(News_AttachFileImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the news_ attach file in the entity cache if it is enabled.
	 *
	 * @param news_AttachFile the news_ attach file
	 */
	@Override
	public void cacheResult(News_AttachFile news_AttachFile) {
		entityCache.putResult(
			News_AttachFileImpl.class, news_AttachFile.getPrimaryKey(),
			news_AttachFile);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the news_ attach files in the entity cache if it is enabled.
	 *
	 * @param news_AttachFiles the news_ attach files
	 */
	@Override
	public void cacheResult(List<News_AttachFile> news_AttachFiles) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (news_AttachFiles.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (News_AttachFile news_AttachFile : news_AttachFiles) {
			if (entityCache.getResult(
					News_AttachFileImpl.class,
					news_AttachFile.getPrimaryKey()) == null) {

				cacheResult(news_AttachFile);
			}
		}
	}

	/**
	 * Clears the cache for all news_ attach files.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(News_AttachFileImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the news_ attach file.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(News_AttachFile news_AttachFile) {
		entityCache.removeResult(News_AttachFileImpl.class, news_AttachFile);
	}

	@Override
	public void clearCache(List<News_AttachFile> news_AttachFiles) {
		for (News_AttachFile news_AttachFile : news_AttachFiles) {
			entityCache.removeResult(
				News_AttachFileImpl.class, news_AttachFile);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(News_AttachFileImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new news_ attach file with the primary key. Does not add the news_ attach file to the database.
	 *
	 * @param id the primary key for the new news_ attach file
	 * @return the new news_ attach file
	 */
	@Override
	public News_AttachFile create(long id) {
		News_AttachFile news_AttachFile = new News_AttachFileImpl();

		news_AttachFile.setNew(true);
		news_AttachFile.setPrimaryKey(id);

		news_AttachFile.setCompanyId(CompanyThreadLocal.getCompanyId());

		return news_AttachFile;
	}

	/**
	 * Removes the news_ attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file that was removed
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public News_AttachFile remove(long id)
		throws NoSuchNews_AttachFileException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the news_ attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the news_ attach file
	 * @return the news_ attach file that was removed
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public News_AttachFile remove(Serializable primaryKey)
		throws NoSuchNews_AttachFileException {

		Session session = null;

		try {
			session = openSession();

			News_AttachFile news_AttachFile = (News_AttachFile)session.get(
				News_AttachFileImpl.class, primaryKey);

			if (news_AttachFile == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNews_AttachFileException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(news_AttachFile);
		}
		catch (NoSuchNews_AttachFileException noSuchEntityException) {
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
	protected News_AttachFile removeImpl(News_AttachFile news_AttachFile) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(news_AttachFile)) {
				news_AttachFile = (News_AttachFile)session.get(
					News_AttachFileImpl.class,
					news_AttachFile.getPrimaryKeyObj());
			}

			if (news_AttachFile != null) {
				session.delete(news_AttachFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (news_AttachFile != null) {
			clearCache(news_AttachFile);
		}

		return news_AttachFile;
	}

	@Override
	public News_AttachFile updateImpl(News_AttachFile news_AttachFile) {
		boolean isNew = news_AttachFile.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(news_AttachFile);
			}
			else {
				news_AttachFile = (News_AttachFile)session.merge(
					news_AttachFile);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			News_AttachFileImpl.class, news_AttachFile, false, true);

		if (isNew) {
			news_AttachFile.setNew(false);
		}

		news_AttachFile.resetOriginalValues();

		return news_AttachFile;
	}

	/**
	 * Returns the news_ attach file with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the news_ attach file
	 * @return the news_ attach file
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public News_AttachFile findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNews_AttachFileException {

		News_AttachFile news_AttachFile = fetchByPrimaryKey(primaryKey);

		if (news_AttachFile == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNews_AttachFileException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return news_AttachFile;
	}

	/**
	 * Returns the news_ attach file with the primary key or throws a <code>NoSuchNews_AttachFileException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	@Override
	public News_AttachFile findByPrimaryKey(long id)
		throws NoSuchNews_AttachFileException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the news_ attach file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file, or <code>null</code> if a news_ attach file with the primary key could not be found
	 */
	@Override
	public News_AttachFile fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the news_ attach files.
	 *
	 * @return the news_ attach files
	 */
	@Override
	public List<News_AttachFile> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @return the range of news_ attach files
	 */
	@Override
	public List<News_AttachFile> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ attach files
	 */
	@Override
	public List<News_AttachFile> findAll(
		int start, int end,
		OrderByComparator<News_AttachFile> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ attach files
	 */
	@Override
	public List<News_AttachFile> findAll(
		int start, int end,
		OrderByComparator<News_AttachFile> orderByComparator,
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

		List<News_AttachFile> list = null;

		if (useFinderCache) {
			list = (List<News_AttachFile>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NEWS_ATTACHFILE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NEWS_ATTACHFILE;

				sql = sql.concat(News_AttachFileModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<News_AttachFile>)QueryUtil.list(
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
	 * Removes all the news_ attach files from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (News_AttachFile news_AttachFile : findAll()) {
			remove(news_AttachFile);
		}
	}

	/**
	 * Returns the number of news_ attach files.
	 *
	 * @return the number of news_ attach files
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NEWS_ATTACHFILE);

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
		return _SQL_SELECT_NEWS_ATTACHFILE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return News_AttachFileModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the news_ attach file persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new News_AttachFileModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", News_AttachFile.class.getName()));

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

		_setNews_AttachFileUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setNews_AttachFileUtilPersistence(null);

		entityCache.removeCache(News_AttachFileImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setNews_AttachFileUtilPersistence(
		News_AttachFilePersistence news_AttachFilePersistence) {

		try {
			Field field = News_AttachFileUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, news_AttachFilePersistence);
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

	private static final String _SQL_SELECT_NEWS_ATTACHFILE =
		"SELECT news_AttachFile FROM News_AttachFile news_AttachFile";

	private static final String _SQL_COUNT_NEWS_ATTACHFILE =
		"SELECT COUNT(news_AttachFile) FROM News_AttachFile news_AttachFile";

	private static final String _ORDER_BY_ENTITY_ALIAS = "news_AttachFile.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No News_AttachFile exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		News_AttachFilePersistenceImpl.class);

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

	private static class News_AttachFileModelArgumentsResolver
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

			News_AttachFileModelImpl news_AttachFileModelImpl =
				(News_AttachFileModelImpl)baseModel;

			long columnBitmask = news_AttachFileModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					news_AttachFileModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						news_AttachFileModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					news_AttachFileModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			News_AttachFileModelImpl news_AttachFileModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						news_AttachFileModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = news_AttachFileModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}