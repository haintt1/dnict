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

package lichcoquan.service.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import lichcoquan.service.exception.NoSuchLichcoquanException;
import lichcoquan.service.model.Lichcoquan;
import lichcoquan.service.model.impl.LichcoquanImpl;
import lichcoquan.service.model.impl.LichcoquanModelImpl;
import lichcoquan.service.service.persistence.LichcoquanPersistence;
import lichcoquan.service.service.persistence.LichcoquanUtil;
import lichcoquan.service.service.persistence.impl.constants.BinhNTPersistenceConstants;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the lichcoquan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @generated
 */
@Component(service = LichcoquanPersistence.class)
public class LichcoquanPersistenceImpl
	extends BasePersistenceImpl<Lichcoquan> implements LichcoquanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LichcoquanUtil</code> to access the lichcoquan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LichcoquanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public LichcoquanPersistenceImpl() {
		setModelClass(Lichcoquan.class);

		setModelImplClass(LichcoquanImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the lichcoquan in the entity cache if it is enabled.
	 *
	 * @param lichcoquan the lichcoquan
	 */
	@Override
	public void cacheResult(Lichcoquan lichcoquan) {
		entityCache.putResult(
			LichcoquanImpl.class, lichcoquan.getPrimaryKey(), lichcoquan);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the lichcoquans in the entity cache if it is enabled.
	 *
	 * @param lichcoquans the lichcoquans
	 */
	@Override
	public void cacheResult(List<Lichcoquan> lichcoquans) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (lichcoquans.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Lichcoquan lichcoquan : lichcoquans) {
			if (entityCache.getResult(
					LichcoquanImpl.class, lichcoquan.getPrimaryKey()) == null) {

				cacheResult(lichcoquan);
			}
		}
	}

	/**
	 * Clears the cache for all lichcoquans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LichcoquanImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lichcoquan.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Lichcoquan lichcoquan) {
		entityCache.removeResult(LichcoquanImpl.class, lichcoquan);
	}

	@Override
	public void clearCache(List<Lichcoquan> lichcoquans) {
		for (Lichcoquan lichcoquan : lichcoquans) {
			entityCache.removeResult(LichcoquanImpl.class, lichcoquan);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LichcoquanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new lichcoquan with the primary key. Does not add the lichcoquan to the database.
	 *
	 * @param lichCongtacId the primary key for the new lichcoquan
	 * @return the new lichcoquan
	 */
	@Override
	public Lichcoquan create(long lichCongtacId) {
		Lichcoquan lichcoquan = new LichcoquanImpl();

		lichcoquan.setNew(true);
		lichcoquan.setPrimaryKey(lichCongtacId);

		lichcoquan.setCompanyId(CompanyThreadLocal.getCompanyId());

		return lichcoquan;
	}

	/**
	 * Removes the lichcoquan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan that was removed
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public Lichcoquan remove(long lichCongtacId)
		throws NoSuchLichcoquanException {

		return remove((Serializable)lichCongtacId);
	}

	/**
	 * Removes the lichcoquan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lichcoquan
	 * @return the lichcoquan that was removed
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public Lichcoquan remove(Serializable primaryKey)
		throws NoSuchLichcoquanException {

		Session session = null;

		try {
			session = openSession();

			Lichcoquan lichcoquan = (Lichcoquan)session.get(
				LichcoquanImpl.class, primaryKey);

			if (lichcoquan == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLichcoquanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lichcoquan);
		}
		catch (NoSuchLichcoquanException noSuchEntityException) {
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
	protected Lichcoquan removeImpl(Lichcoquan lichcoquan) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lichcoquan)) {
				lichcoquan = (Lichcoquan)session.get(
					LichcoquanImpl.class, lichcoquan.getPrimaryKeyObj());
			}

			if (lichcoquan != null) {
				session.delete(lichcoquan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lichcoquan != null) {
			clearCache(lichcoquan);
		}

		return lichcoquan;
	}

	@Override
	public Lichcoquan updateImpl(Lichcoquan lichcoquan) {
		boolean isNew = lichcoquan.isNew();

		if (!(lichcoquan instanceof LichcoquanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lichcoquan.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(lichcoquan);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lichcoquan proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Lichcoquan implementation " +
					lichcoquan.getClass());
		}

		LichcoquanModelImpl lichcoquanModelImpl =
			(LichcoquanModelImpl)lichcoquan;

		if (isNew && (lichcoquan.getCreateDate() == null)) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				lichcoquan.setCreateDate(date);
			}
			else {
				lichcoquan.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lichcoquan);
			}
			else {
				lichcoquan = (Lichcoquan)session.merge(lichcoquan);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(LichcoquanImpl.class, lichcoquan, false, true);

		if (isNew) {
			lichcoquan.setNew(false);
		}

		lichcoquan.resetOriginalValues();

		return lichcoquan;
	}

	/**
	 * Returns the lichcoquan with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lichcoquan
	 * @return the lichcoquan
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public Lichcoquan findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLichcoquanException {

		Lichcoquan lichcoquan = fetchByPrimaryKey(primaryKey);

		if (lichcoquan == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLichcoquanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lichcoquan;
	}

	/**
	 * Returns the lichcoquan with the primary key or throws a <code>NoSuchLichcoquanException</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	@Override
	public Lichcoquan findByPrimaryKey(long lichCongtacId)
		throws NoSuchLichcoquanException {

		return findByPrimaryKey((Serializable)lichCongtacId);
	}

	/**
	 * Returns the lichcoquan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan, or <code>null</code> if a lichcoquan with the primary key could not be found
	 */
	@Override
	public Lichcoquan fetchByPrimaryKey(long lichCongtacId) {
		return fetchByPrimaryKey((Serializable)lichCongtacId);
	}

	/**
	 * Returns all the lichcoquans.
	 *
	 * @return the lichcoquans
	 */
	@Override
	public List<Lichcoquan> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @return the range of lichcoquans
	 */
	@Override
	public List<Lichcoquan> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lichcoquans
	 */
	@Override
	public List<Lichcoquan> findAll(
		int start, int end, OrderByComparator<Lichcoquan> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lichcoquans
	 */
	@Override
	public List<Lichcoquan> findAll(
		int start, int end, OrderByComparator<Lichcoquan> orderByComparator,
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

		List<Lichcoquan> list = null;

		if (useFinderCache) {
			list = (List<Lichcoquan>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LICHCOQUAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LICHCOQUAN;

				sql = sql.concat(LichcoquanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Lichcoquan>)QueryUtil.list(
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
	 * Removes all the lichcoquans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Lichcoquan lichcoquan : findAll()) {
			remove(lichcoquan);
		}
	}

	/**
	 * Returns the number of lichcoquans.
	 *
	 * @return the number of lichcoquans
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LICHCOQUAN);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "lichCongtacId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LICHCOQUAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LichcoquanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lichcoquan persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new LichcoquanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Lichcoquan.class.getName()));

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

		_setLichcoquanUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setLichcoquanUtilPersistence(null);

		entityCache.removeCache(LichcoquanImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setLichcoquanUtilPersistence(
		LichcoquanPersistence lichcoquanPersistence) {

		try {
			Field field = LichcoquanUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, lichcoquanPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = BinhNTPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_LICHCOQUAN =
		"SELECT lichcoquan FROM Lichcoquan lichcoquan";

	private static final String _SQL_COUNT_LICHCOQUAN =
		"SELECT COUNT(lichcoquan) FROM Lichcoquan lichcoquan";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lichcoquan.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Lichcoquan exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		LichcoquanPersistenceImpl.class);

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

	private static class LichcoquanModelArgumentsResolver
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

			LichcoquanModelImpl lichcoquanModelImpl =
				(LichcoquanModelImpl)baseModel;

			long columnBitmask = lichcoquanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(lichcoquanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						lichcoquanModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(LichcoquanPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(lichcoquanModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			LichcoquanModelImpl lichcoquanModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = lichcoquanModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = lichcoquanModelImpl.getColumnValue(
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