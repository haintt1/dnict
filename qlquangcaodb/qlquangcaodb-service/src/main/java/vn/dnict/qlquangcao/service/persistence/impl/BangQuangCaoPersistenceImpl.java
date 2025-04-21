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

import vn.dnict.qlquangcao.exception.NoSuchBangQuangCaoException;
import vn.dnict.qlquangcao.model.BangQuangCao;
import vn.dnict.qlquangcao.model.impl.BangQuangCaoImpl;
import vn.dnict.qlquangcao.model.impl.BangQuangCaoModelImpl;
import vn.dnict.qlquangcao.service.persistence.BangQuangCaoPersistence;
import vn.dnict.qlquangcao.service.persistence.BangQuangCaoUtil;
import vn.dnict.qlquangcao.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the bang quang cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = BangQuangCaoPersistence.class)
public class BangQuangCaoPersistenceImpl
	extends BasePersistenceImpl<BangQuangCao>
	implements BangQuangCaoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BangQuangCaoUtil</code> to access the bang quang cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BangQuangCaoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public BangQuangCaoPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BangQuangCao.class);

		setModelImplClass(BangQuangCaoImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the bang quang cao in the entity cache if it is enabled.
	 *
	 * @param bangQuangCao the bang quang cao
	 */
	@Override
	public void cacheResult(BangQuangCao bangQuangCao) {
		entityCache.putResult(
			BangQuangCaoImpl.class, bangQuangCao.getPrimaryKey(), bangQuangCao);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the bang quang caos in the entity cache if it is enabled.
	 *
	 * @param bangQuangCaos the bang quang caos
	 */
	@Override
	public void cacheResult(List<BangQuangCao> bangQuangCaos) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bangQuangCaos.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BangQuangCao bangQuangCao : bangQuangCaos) {
			if (entityCache.getResult(
					BangQuangCaoImpl.class, bangQuangCao.getPrimaryKey()) ==
						null) {

				cacheResult(bangQuangCao);
			}
		}
	}

	/**
	 * Clears the cache for all bang quang caos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BangQuangCaoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bang quang cao.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BangQuangCao bangQuangCao) {
		entityCache.removeResult(BangQuangCaoImpl.class, bangQuangCao);
	}

	@Override
	public void clearCache(List<BangQuangCao> bangQuangCaos) {
		for (BangQuangCao bangQuangCao : bangQuangCaos) {
			entityCache.removeResult(BangQuangCaoImpl.class, bangQuangCao);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BangQuangCaoImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new bang quang cao with the primary key. Does not add the bang quang cao to the database.
	 *
	 * @param id the primary key for the new bang quang cao
	 * @return the new bang quang cao
	 */
	@Override
	public BangQuangCao create(long id) {
		BangQuangCao bangQuangCao = new BangQuangCaoImpl();

		bangQuangCao.setNew(true);
		bangQuangCao.setPrimaryKey(id);

		bangQuangCao.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bangQuangCao;
	}

	/**
	 * Removes the bang quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao that was removed
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public BangQuangCao remove(long id) throws NoSuchBangQuangCaoException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the bang quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bang quang cao
	 * @return the bang quang cao that was removed
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public BangQuangCao remove(Serializable primaryKey)
		throws NoSuchBangQuangCaoException {

		Session session = null;

		try {
			session = openSession();

			BangQuangCao bangQuangCao = (BangQuangCao)session.get(
				BangQuangCaoImpl.class, primaryKey);

			if (bangQuangCao == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBangQuangCaoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bangQuangCao);
		}
		catch (NoSuchBangQuangCaoException noSuchEntityException) {
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
	protected BangQuangCao removeImpl(BangQuangCao bangQuangCao) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bangQuangCao)) {
				bangQuangCao = (BangQuangCao)session.get(
					BangQuangCaoImpl.class, bangQuangCao.getPrimaryKeyObj());
			}

			if (bangQuangCao != null) {
				session.delete(bangQuangCao);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bangQuangCao != null) {
			clearCache(bangQuangCao);
		}

		return bangQuangCao;
	}

	@Override
	public BangQuangCao updateImpl(BangQuangCao bangQuangCao) {
		boolean isNew = bangQuangCao.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bangQuangCao);
			}
			else {
				bangQuangCao = (BangQuangCao)session.merge(bangQuangCao);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BangQuangCaoImpl.class, bangQuangCao, false, true);

		if (isNew) {
			bangQuangCao.setNew(false);
		}

		bangQuangCao.resetOriginalValues();

		return bangQuangCao;
	}

	/**
	 * Returns the bang quang cao with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bang quang cao
	 * @return the bang quang cao
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public BangQuangCao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBangQuangCaoException {

		BangQuangCao bangQuangCao = fetchByPrimaryKey(primaryKey);

		if (bangQuangCao == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBangQuangCaoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bangQuangCao;
	}

	/**
	 * Returns the bang quang cao with the primary key or throws a <code>NoSuchBangQuangCaoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	@Override
	public BangQuangCao findByPrimaryKey(long id)
		throws NoSuchBangQuangCaoException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the bang quang cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao, or <code>null</code> if a bang quang cao with the primary key could not be found
	 */
	@Override
	public BangQuangCao fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the bang quang caos.
	 *
	 * @return the bang quang caos
	 */
	@Override
	public List<BangQuangCao> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @return the range of bang quang caos
	 */
	@Override
	public List<BangQuangCao> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bang quang caos
	 */
	@Override
	public List<BangQuangCao> findAll(
		int start, int end, OrderByComparator<BangQuangCao> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bang quang caos
	 */
	@Override
	public List<BangQuangCao> findAll(
		int start, int end, OrderByComparator<BangQuangCao> orderByComparator,
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

		List<BangQuangCao> list = null;

		if (useFinderCache) {
			list = (List<BangQuangCao>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BANGQUANGCAO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BANGQUANGCAO;

				sql = sql.concat(BangQuangCaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BangQuangCao>)QueryUtil.list(
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
	 * Removes all the bang quang caos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BangQuangCao bangQuangCao : findAll()) {
			remove(bangQuangCao);
		}
	}

	/**
	 * Returns the number of bang quang caos.
	 *
	 * @return the number of bang quang caos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BANGQUANGCAO);

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
		return _SQL_SELECT_BANGQUANGCAO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BangQuangCaoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the bang quang cao persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new BangQuangCaoModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", BangQuangCao.class.getName()));

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

		BangQuangCaoUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BangQuangCaoUtil.setPersistence(null);

		entityCache.removeCache(BangQuangCaoImpl.class.getName());

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

	private static final String _SQL_SELECT_BANGQUANGCAO =
		"SELECT bangQuangCao FROM BangQuangCao bangQuangCao";

	private static final String _SQL_COUNT_BANGQUANGCAO =
		"SELECT COUNT(bangQuangCao) FROM BangQuangCao bangQuangCao";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bangQuangCao.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BangQuangCao exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		BangQuangCaoPersistenceImpl.class);

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

	private static class BangQuangCaoModelArgumentsResolver
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

			BangQuangCaoModelImpl bangQuangCaoModelImpl =
				(BangQuangCaoModelImpl)baseModel;

			long columnBitmask = bangQuangCaoModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(bangQuangCaoModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						bangQuangCaoModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(BangQuangCaoPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(bangQuangCaoModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			BangQuangCaoModelImpl bangQuangCaoModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = bangQuangCaoModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = bangQuangCaoModelImpl.getColumnValue(
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