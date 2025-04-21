/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence.impl;

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

import vn.dnict.qlgopy.exception.NoSuchGopY_DinhKemException;
import vn.dnict.qlgopy.model.GopY_DinhKem;
import vn.dnict.qlgopy.model.impl.GopY_DinhKemImpl;
import vn.dnict.qlgopy.model.impl.GopY_DinhKemModelImpl;
import vn.dnict.qlgopy.service.persistence.GopY_DinhKemPersistence;
import vn.dnict.qlgopy.service.persistence.GopY_DinhKemUtil;
import vn.dnict.qlgopy.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the gop y_ dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = GopY_DinhKemPersistence.class)
public class GopY_DinhKemPersistenceImpl
	extends BasePersistenceImpl<GopY_DinhKem>
	implements GopY_DinhKemPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GopY_DinhKemUtil</code> to access the gop y_ dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GopY_DinhKemImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GopY_DinhKemPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(GopY_DinhKem.class);

		setModelImplClass(GopY_DinhKemImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the gop y_ dinh kem in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 */
	@Override
	public void cacheResult(GopY_DinhKem gopY_DinhKem) {
		entityCache.putResult(
			GopY_DinhKemImpl.class, gopY_DinhKem.getPrimaryKey(), gopY_DinhKem);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the gop y_ dinh kems in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKems the gop y_ dinh kems
	 */
	@Override
	public void cacheResult(List<GopY_DinhKem> gopY_DinhKems) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (gopY_DinhKems.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (GopY_DinhKem gopY_DinhKem : gopY_DinhKems) {
			if (entityCache.getResult(
					GopY_DinhKemImpl.class, gopY_DinhKem.getPrimaryKey()) ==
						null) {

				cacheResult(gopY_DinhKem);
			}
		}
	}

	/**
	 * Clears the cache for all gop y_ dinh kems.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GopY_DinhKemImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the gop y_ dinh kem.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GopY_DinhKem gopY_DinhKem) {
		entityCache.removeResult(GopY_DinhKemImpl.class, gopY_DinhKem);
	}

	@Override
	public void clearCache(List<GopY_DinhKem> gopY_DinhKems) {
		for (GopY_DinhKem gopY_DinhKem : gopY_DinhKems) {
			entityCache.removeResult(GopY_DinhKemImpl.class, gopY_DinhKem);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GopY_DinhKemImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new gop y_ dinh kem with the primary key. Does not add the gop y_ dinh kem to the database.
	 *
	 * @param id the primary key for the new gop y_ dinh kem
	 * @return the new gop y_ dinh kem
	 */
	@Override
	public GopY_DinhKem create(long id) {
		GopY_DinhKem gopY_DinhKem = new GopY_DinhKemImpl();

		gopY_DinhKem.setNew(true);
		gopY_DinhKem.setPrimaryKey(id);

		gopY_DinhKem.setCompanyId(CompanyThreadLocal.getCompanyId());

		return gopY_DinhKem;
	}

	/**
	 * Removes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public GopY_DinhKem remove(long id) throws NoSuchGopY_DinhKemException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public GopY_DinhKem remove(Serializable primaryKey)
		throws NoSuchGopY_DinhKemException {

		Session session = null;

		try {
			session = openSession();

			GopY_DinhKem gopY_DinhKem = (GopY_DinhKem)session.get(
				GopY_DinhKemImpl.class, primaryKey);

			if (gopY_DinhKem == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGopY_DinhKemException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(gopY_DinhKem);
		}
		catch (NoSuchGopY_DinhKemException noSuchEntityException) {
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
	protected GopY_DinhKem removeImpl(GopY_DinhKem gopY_DinhKem) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(gopY_DinhKem)) {
				gopY_DinhKem = (GopY_DinhKem)session.get(
					GopY_DinhKemImpl.class, gopY_DinhKem.getPrimaryKeyObj());
			}

			if (gopY_DinhKem != null) {
				session.delete(gopY_DinhKem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (gopY_DinhKem != null) {
			clearCache(gopY_DinhKem);
		}

		return gopY_DinhKem;
	}

	@Override
	public GopY_DinhKem updateImpl(GopY_DinhKem gopY_DinhKem) {
		boolean isNew = gopY_DinhKem.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(gopY_DinhKem);
			}
			else {
				gopY_DinhKem = (GopY_DinhKem)session.merge(gopY_DinhKem);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			GopY_DinhKemImpl.class, gopY_DinhKem, false, true);

		if (isNew) {
			gopY_DinhKem.setNew(false);
		}

		gopY_DinhKem.resetOriginalValues();

		return gopY_DinhKem;
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public GopY_DinhKem findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGopY_DinhKemException {

		GopY_DinhKem gopY_DinhKem = fetchByPrimaryKey(primaryKey);

		if (gopY_DinhKem == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGopY_DinhKemException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return gopY_DinhKem;
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key or throws a <code>NoSuchGopY_DinhKemException</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public GopY_DinhKem findByPrimaryKey(long id)
		throws NoSuchGopY_DinhKemException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem, or <code>null</code> if a gop y_ dinh kem with the primary key could not be found
	 */
	@Override
	public GopY_DinhKem fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the gop y_ dinh kems.
	 *
	 * @return the gop y_ dinh kems
	 */
	@Override
	public List<GopY_DinhKem> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @return the range of gop y_ dinh kems
	 */
	@Override
	public List<GopY_DinhKem> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gop y_ dinh kems
	 */
	@Override
	public List<GopY_DinhKem> findAll(
		int start, int end, OrderByComparator<GopY_DinhKem> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gop y_ dinh kems
	 */
	@Override
	public List<GopY_DinhKem> findAll(
		int start, int end, OrderByComparator<GopY_DinhKem> orderByComparator,
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

		List<GopY_DinhKem> list = null;

		if (useFinderCache) {
			list = (List<GopY_DinhKem>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GOPY_DINHKEM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GOPY_DINHKEM;

				sql = sql.concat(GopY_DinhKemModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GopY_DinhKem>)QueryUtil.list(
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
	 * Removes all the gop y_ dinh kems from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GopY_DinhKem gopY_DinhKem : findAll()) {
			remove(gopY_DinhKem);
		}
	}

	/**
	 * Returns the number of gop y_ dinh kems.
	 *
	 * @return the number of gop y_ dinh kems
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GOPY_DINHKEM);

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
		return _SQL_SELECT_GOPY_DINHKEM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GopY_DinhKemModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the gop y_ dinh kem persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new GopY_DinhKemModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", GopY_DinhKem.class.getName()));

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

		GopY_DinhKemUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		GopY_DinhKemUtil.setPersistence(null);

		entityCache.removeCache(GopY_DinhKemImpl.class.getName());

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

	private static final String _SQL_SELECT_GOPY_DINHKEM =
		"SELECT gopY_DinhKem FROM GopY_DinhKem gopY_DinhKem";

	private static final String _SQL_COUNT_GOPY_DINHKEM =
		"SELECT COUNT(gopY_DinhKem) FROM GopY_DinhKem gopY_DinhKem";

	private static final String _ORDER_BY_ENTITY_ALIAS = "gopY_DinhKem.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GopY_DinhKem exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GopY_DinhKemPersistenceImpl.class);

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

	private static class GopY_DinhKemModelArgumentsResolver
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

			GopY_DinhKemModelImpl gopY_DinhKemModelImpl =
				(GopY_DinhKemModelImpl)baseModel;

			long columnBitmask = gopY_DinhKemModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(gopY_DinhKemModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						gopY_DinhKemModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(gopY_DinhKemModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			GopY_DinhKemModelImpl gopY_DinhKemModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = gopY_DinhKemModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = gopY_DinhKemModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}