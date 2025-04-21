/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence.impl;

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

import vn.dnict.qlquangcao.exception.NoSuchViTriDanhMucException;
import vn.dnict.qlquangcao.model.ViTriDanhMuc;
import vn.dnict.qlquangcao.model.impl.ViTriDanhMucImpl;
import vn.dnict.qlquangcao.model.impl.ViTriDanhMucModelImpl;
import vn.dnict.qlquangcao.service.persistence.ViTriDanhMucPersistence;
import vn.dnict.qlquangcao.service.persistence.ViTriDanhMucUtil;
import vn.dnict.qlquangcao.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the vi tri danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = ViTriDanhMucPersistence.class)
public class ViTriDanhMucPersistenceImpl
	extends BasePersistenceImpl<ViTriDanhMuc>
	implements ViTriDanhMucPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ViTriDanhMucUtil</code> to access the vi tri danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ViTriDanhMucImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ViTriDanhMucPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ViTriDanhMuc.class);

		setModelImplClass(ViTriDanhMucImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the vi tri danh muc in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 */
	@Override
	public void cacheResult(ViTriDanhMuc viTriDanhMuc) {
		entityCache.putResult(
			ViTriDanhMucImpl.class, viTriDanhMuc.getPrimaryKey(), viTriDanhMuc);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the vi tri danh mucs in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMucs the vi tri danh mucs
	 */
	@Override
	public void cacheResult(List<ViTriDanhMuc> viTriDanhMucs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (viTriDanhMucs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ViTriDanhMuc viTriDanhMuc : viTriDanhMucs) {
			if (entityCache.getResult(
					ViTriDanhMucImpl.class, viTriDanhMuc.getPrimaryKey()) ==
						null) {

				cacheResult(viTriDanhMuc);
			}
		}
	}

	/**
	 * Clears the cache for all vi tri danh mucs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ViTriDanhMucImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vi tri danh muc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ViTriDanhMuc viTriDanhMuc) {
		entityCache.removeResult(ViTriDanhMucImpl.class, viTriDanhMuc);
	}

	@Override
	public void clearCache(List<ViTriDanhMuc> viTriDanhMucs) {
		for (ViTriDanhMuc viTriDanhMuc : viTriDanhMucs) {
			entityCache.removeResult(ViTriDanhMucImpl.class, viTriDanhMuc);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ViTriDanhMucImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new vi tri danh muc with the primary key. Does not add the vi tri danh muc to the database.
	 *
	 * @param id the primary key for the new vi tri danh muc
	 * @return the new vi tri danh muc
	 */
	@Override
	public ViTriDanhMuc create(long id) {
		ViTriDanhMuc viTriDanhMuc = new ViTriDanhMucImpl();

		viTriDanhMuc.setNew(true);
		viTriDanhMuc.setPrimaryKey(id);

		viTriDanhMuc.setCompanyId(CompanyThreadLocal.getCompanyId());

		return viTriDanhMuc;
	}

	/**
	 * Removes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public ViTriDanhMuc remove(long id) throws NoSuchViTriDanhMucException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public ViTriDanhMuc remove(Serializable primaryKey)
		throws NoSuchViTriDanhMucException {

		Session session = null;

		try {
			session = openSession();

			ViTriDanhMuc viTriDanhMuc = (ViTriDanhMuc)session.get(
				ViTriDanhMucImpl.class, primaryKey);

			if (viTriDanhMuc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViTriDanhMucException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(viTriDanhMuc);
		}
		catch (NoSuchViTriDanhMucException noSuchEntityException) {
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
	protected ViTriDanhMuc removeImpl(ViTriDanhMuc viTriDanhMuc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(viTriDanhMuc)) {
				viTriDanhMuc = (ViTriDanhMuc)session.get(
					ViTriDanhMucImpl.class, viTriDanhMuc.getPrimaryKeyObj());
			}

			if (viTriDanhMuc != null) {
				session.delete(viTriDanhMuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (viTriDanhMuc != null) {
			clearCache(viTriDanhMuc);
		}

		return viTriDanhMuc;
	}

	@Override
	public ViTriDanhMuc updateImpl(ViTriDanhMuc viTriDanhMuc) {
		boolean isNew = viTriDanhMuc.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(viTriDanhMuc);
			}
			else {
				viTriDanhMuc = (ViTriDanhMuc)session.merge(viTriDanhMuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ViTriDanhMucImpl.class, viTriDanhMuc, false, true);

		if (isNew) {
			viTriDanhMuc.setNew(false);
		}

		viTriDanhMuc.resetOriginalValues();

		return viTriDanhMuc;
	}

	/**
	 * Returns the vi tri danh muc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public ViTriDanhMuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchViTriDanhMucException {

		ViTriDanhMuc viTriDanhMuc = fetchByPrimaryKey(primaryKey);

		if (viTriDanhMuc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchViTriDanhMucException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return viTriDanhMuc;
	}

	/**
	 * Returns the vi tri danh muc with the primary key or throws a <code>NoSuchViTriDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public ViTriDanhMuc findByPrimaryKey(long id)
		throws NoSuchViTriDanhMucException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vi tri danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc, or <code>null</code> if a vi tri danh muc with the primary key could not be found
	 */
	@Override
	public ViTriDanhMuc fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the vi tri danh mucs.
	 *
	 * @return the vi tri danh mucs
	 */
	@Override
	public List<ViTriDanhMuc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @return the range of vi tri danh mucs
	 */
	@Override
	public List<ViTriDanhMuc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vi tri danh mucs
	 */
	@Override
	public List<ViTriDanhMuc> findAll(
		int start, int end, OrderByComparator<ViTriDanhMuc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vi tri danh mucs
	 */
	@Override
	public List<ViTriDanhMuc> findAll(
		int start, int end, OrderByComparator<ViTriDanhMuc> orderByComparator,
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

		List<ViTriDanhMuc> list = null;

		if (useFinderCache) {
			list = (List<ViTriDanhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VITRIDANHMUC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VITRIDANHMUC;

				sql = sql.concat(ViTriDanhMucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ViTriDanhMuc>)QueryUtil.list(
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
	 * Removes all the vi tri danh mucs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ViTriDanhMuc viTriDanhMuc : findAll()) {
			remove(viTriDanhMuc);
		}
	}

	/**
	 * Returns the number of vi tri danh mucs.
	 *
	 * @return the number of vi tri danh mucs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VITRIDANHMUC);

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
		return _SQL_SELECT_VITRIDANHMUC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ViTriDanhMucModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vi tri danh muc persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ViTriDanhMucModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ViTriDanhMuc.class.getName()));

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

		ViTriDanhMucUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ViTriDanhMucUtil.setPersistence(null);

		entityCache.removeCache(ViTriDanhMucImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
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

	private static final String _SQL_SELECT_VITRIDANHMUC =
		"SELECT viTriDanhMuc FROM ViTriDanhMuc viTriDanhMuc";

	private static final String _SQL_COUNT_VITRIDANHMUC =
		"SELECT COUNT(viTriDanhMuc) FROM ViTriDanhMuc viTriDanhMuc";

	private static final String _ORDER_BY_ENTITY_ALIAS = "viTriDanhMuc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ViTriDanhMuc exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ViTriDanhMucPersistenceImpl.class);

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

	private static class ViTriDanhMucModelArgumentsResolver
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

			ViTriDanhMucModelImpl viTriDanhMucModelImpl =
				(ViTriDanhMucModelImpl)baseModel;

			long columnBitmask = viTriDanhMucModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(viTriDanhMucModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						viTriDanhMucModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(viTriDanhMucModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ViTriDanhMucModelImpl viTriDanhMucModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = viTriDanhMucModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = viTriDanhMucModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}