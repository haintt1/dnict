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

import vn.dnict.qlquangcao.exception.NoSuchNhomKHException;
import vn.dnict.qlquangcao.model.NhomKH;
import vn.dnict.qlquangcao.model.impl.NhomKHImpl;
import vn.dnict.qlquangcao.model.impl.NhomKHModelImpl;
import vn.dnict.qlquangcao.service.persistence.NhomKHPersistence;
import vn.dnict.qlquangcao.service.persistence.NhomKHUtil;
import vn.dnict.qlquangcao.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the nhom kh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = NhomKHPersistence.class)
public class NhomKHPersistenceImpl
	extends BasePersistenceImpl<NhomKH> implements NhomKHPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NhomKHUtil</code> to access the nhom kh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NhomKHImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public NhomKHPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(NhomKH.class);

		setModelImplClass(NhomKHImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the nhom kh in the entity cache if it is enabled.
	 *
	 * @param nhomKH the nhom kh
	 */
	@Override
	public void cacheResult(NhomKH nhomKH) {
		entityCache.putResult(NhomKHImpl.class, nhomKH.getPrimaryKey(), nhomKH);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the nhom khs in the entity cache if it is enabled.
	 *
	 * @param nhomKHs the nhom khs
	 */
	@Override
	public void cacheResult(List<NhomKH> nhomKHs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (nhomKHs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (NhomKH nhomKH : nhomKHs) {
			if (entityCache.getResult(
					NhomKHImpl.class, nhomKH.getPrimaryKey()) == null) {

				cacheResult(nhomKH);
			}
		}
	}

	/**
	 * Clears the cache for all nhom khs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NhomKHImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the nhom kh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(NhomKH nhomKH) {
		entityCache.removeResult(NhomKHImpl.class, nhomKH);
	}

	@Override
	public void clearCache(List<NhomKH> nhomKHs) {
		for (NhomKH nhomKH : nhomKHs) {
			entityCache.removeResult(NhomKHImpl.class, nhomKH);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(NhomKHImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new nhom kh with the primary key. Does not add the nhom kh to the database.
	 *
	 * @param id the primary key for the new nhom kh
	 * @return the new nhom kh
	 */
	@Override
	public NhomKH create(long id) {
		NhomKH nhomKH = new NhomKHImpl();

		nhomKH.setNew(true);
		nhomKH.setPrimaryKey(id);

		nhomKH.setCompanyId(CompanyThreadLocal.getCompanyId());

		return nhomKH;
	}

	/**
	 * Removes the nhom kh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh that was removed
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	@Override
	public NhomKH remove(long id) throws NoSuchNhomKHException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the nhom kh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the nhom kh
	 * @return the nhom kh that was removed
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	@Override
	public NhomKH remove(Serializable primaryKey) throws NoSuchNhomKHException {
		Session session = null;

		try {
			session = openSession();

			NhomKH nhomKH = (NhomKH)session.get(NhomKHImpl.class, primaryKey);

			if (nhomKH == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNhomKHException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(nhomKH);
		}
		catch (NoSuchNhomKHException noSuchEntityException) {
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
	protected NhomKH removeImpl(NhomKH nhomKH) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(nhomKH)) {
				nhomKH = (NhomKH)session.get(
					NhomKHImpl.class, nhomKH.getPrimaryKeyObj());
			}

			if (nhomKH != null) {
				session.delete(nhomKH);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (nhomKH != null) {
			clearCache(nhomKH);
		}

		return nhomKH;
	}

	@Override
	public NhomKH updateImpl(NhomKH nhomKH) {
		boolean isNew = nhomKH.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(nhomKH);
			}
			else {
				nhomKH = (NhomKH)session.merge(nhomKH);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(NhomKHImpl.class, nhomKH, false, true);

		if (isNew) {
			nhomKH.setNew(false);
		}

		nhomKH.resetOriginalValues();

		return nhomKH;
	}

	/**
	 * Returns the nhom kh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the nhom kh
	 * @return the nhom kh
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	@Override
	public NhomKH findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNhomKHException {

		NhomKH nhomKH = fetchByPrimaryKey(primaryKey);

		if (nhomKH == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNhomKHException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return nhomKH;
	}

	/**
	 * Returns the nhom kh with the primary key or throws a <code>NoSuchNhomKHException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	@Override
	public NhomKH findByPrimaryKey(long id) throws NoSuchNhomKHException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the nhom kh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh, or <code>null</code> if a nhom kh with the primary key could not be found
	 */
	@Override
	public NhomKH fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the nhom khs.
	 *
	 * @return the nhom khs
	 */
	@Override
	public List<NhomKH> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @return the range of nhom khs
	 */
	@Override
	public List<NhomKH> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhom khs
	 */
	@Override
	public List<NhomKH> findAll(
		int start, int end, OrderByComparator<NhomKH> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nhom khs
	 */
	@Override
	public List<NhomKH> findAll(
		int start, int end, OrderByComparator<NhomKH> orderByComparator,
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

		List<NhomKH> list = null;

		if (useFinderCache) {
			list = (List<NhomKH>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NHOMKH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NHOMKH;

				sql = sql.concat(NhomKHModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<NhomKH>)QueryUtil.list(
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
	 * Removes all the nhom khs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (NhomKH nhomKH : findAll()) {
			remove(nhomKH);
		}
	}

	/**
	 * Returns the number of nhom khs.
	 *
	 * @return the number of nhom khs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NHOMKH);

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
		return _SQL_SELECT_NHOMKH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NhomKHModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the nhom kh persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new NhomKHModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", NhomKH.class.getName()));

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

		NhomKHUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		NhomKHUtil.setPersistence(null);

		entityCache.removeCache(NhomKHImpl.class.getName());

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

	private static final String _SQL_SELECT_NHOMKH =
		"SELECT nhomKH FROM NhomKH nhomKH";

	private static final String _SQL_COUNT_NHOMKH =
		"SELECT COUNT(nhomKH) FROM NhomKH nhomKH";

	private static final String _ORDER_BY_ENTITY_ALIAS = "nhomKH.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No NhomKH exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		NhomKHPersistenceImpl.class);

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

	private static class NhomKHModelArgumentsResolver
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

			NhomKHModelImpl nhomKHModelImpl = (NhomKHModelImpl)baseModel;

			long columnBitmask = nhomKHModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(nhomKHModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= nhomKHModelImpl.getColumnBitmask(
						columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(NhomKHPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(nhomKHModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			NhomKHModelImpl nhomKHModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = nhomKHModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = nhomKHModelImpl.getColumnValue(columnName);
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