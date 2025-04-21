/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence.impl;

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

import vn.dnict.qlnhuanbut.exception.NoSuchDinhMucException;
import vn.dnict.qlnhuanbut.model.DinhMuc;
import vn.dnict.qlnhuanbut.model.impl.DinhMucImpl;
import vn.dnict.qlnhuanbut.model.impl.DinhMucModelImpl;
import vn.dnict.qlnhuanbut.service.persistence.DinhMucPersistence;
import vn.dnict.qlnhuanbut.service.persistence.DinhMucUtil;
import vn.dnict.qlnhuanbut.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the dinh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = DinhMucPersistence.class)
public class DinhMucPersistenceImpl
	extends BasePersistenceImpl<DinhMuc> implements DinhMucPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DinhMucUtil</code> to access the dinh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DinhMucImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public DinhMucPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(DinhMuc.class);

		setModelImplClass(DinhMucImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the dinh muc in the entity cache if it is enabled.
	 *
	 * @param dinhMuc the dinh muc
	 */
	@Override
	public void cacheResult(DinhMuc dinhMuc) {
		entityCache.putResult(
			DinhMucImpl.class, dinhMuc.getPrimaryKey(), dinhMuc);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the dinh mucs in the entity cache if it is enabled.
	 *
	 * @param dinhMucs the dinh mucs
	 */
	@Override
	public void cacheResult(List<DinhMuc> dinhMucs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (dinhMucs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (DinhMuc dinhMuc : dinhMucs) {
			if (entityCache.getResult(
					DinhMucImpl.class, dinhMuc.getPrimaryKey()) == null) {

				cacheResult(dinhMuc);
			}
		}
	}

	/**
	 * Clears the cache for all dinh mucs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DinhMucImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the dinh muc.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DinhMuc dinhMuc) {
		entityCache.removeResult(DinhMucImpl.class, dinhMuc);
	}

	@Override
	public void clearCache(List<DinhMuc> dinhMucs) {
		for (DinhMuc dinhMuc : dinhMucs) {
			entityCache.removeResult(DinhMucImpl.class, dinhMuc);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DinhMucImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new dinh muc with the primary key. Does not add the dinh muc to the database.
	 *
	 * @param id the primary key for the new dinh muc
	 * @return the new dinh muc
	 */
	@Override
	public DinhMuc create(long id) {
		DinhMuc dinhMuc = new DinhMucImpl();

		dinhMuc.setNew(true);
		dinhMuc.setPrimaryKey(id);

		return dinhMuc;
	}

	/**
	 * Removes the dinh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc that was removed
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	@Override
	public DinhMuc remove(long id) throws NoSuchDinhMucException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the dinh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the dinh muc
	 * @return the dinh muc that was removed
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	@Override
	public DinhMuc remove(Serializable primaryKey)
		throws NoSuchDinhMucException {

		Session session = null;

		try {
			session = openSession();

			DinhMuc dinhMuc = (DinhMuc)session.get(
				DinhMucImpl.class, primaryKey);

			if (dinhMuc == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDinhMucException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(dinhMuc);
		}
		catch (NoSuchDinhMucException noSuchEntityException) {
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
	protected DinhMuc removeImpl(DinhMuc dinhMuc) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(dinhMuc)) {
				dinhMuc = (DinhMuc)session.get(
					DinhMucImpl.class, dinhMuc.getPrimaryKeyObj());
			}

			if (dinhMuc != null) {
				session.delete(dinhMuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (dinhMuc != null) {
			clearCache(dinhMuc);
		}

		return dinhMuc;
	}

	@Override
	public DinhMuc updateImpl(DinhMuc dinhMuc) {
		boolean isNew = dinhMuc.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(dinhMuc);
			}
			else {
				dinhMuc = (DinhMuc)session.merge(dinhMuc);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DinhMucImpl.class, dinhMuc, false, true);

		if (isNew) {
			dinhMuc.setNew(false);
		}

		dinhMuc.resetOriginalValues();

		return dinhMuc;
	}

	/**
	 * Returns the dinh muc with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the dinh muc
	 * @return the dinh muc
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	@Override
	public DinhMuc findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDinhMucException {

		DinhMuc dinhMuc = fetchByPrimaryKey(primaryKey);

		if (dinhMuc == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDinhMucException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return dinhMuc;
	}

	/**
	 * Returns the dinh muc with the primary key or throws a <code>NoSuchDinhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	@Override
	public DinhMuc findByPrimaryKey(long id) throws NoSuchDinhMucException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the dinh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc, or <code>null</code> if a dinh muc with the primary key could not be found
	 */
	@Override
	public DinhMuc fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the dinh mucs.
	 *
	 * @return the dinh mucs
	 */
	@Override
	public List<DinhMuc> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @return the range of dinh mucs
	 */
	@Override
	public List<DinhMuc> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dinh mucs
	 */
	@Override
	public List<DinhMuc> findAll(
		int start, int end, OrderByComparator<DinhMuc> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dinh mucs
	 */
	@Override
	public List<DinhMuc> findAll(
		int start, int end, OrderByComparator<DinhMuc> orderByComparator,
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

		List<DinhMuc> list = null;

		if (useFinderCache) {
			list = (List<DinhMuc>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DINHMUC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DINHMUC;

				sql = sql.concat(DinhMucModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<DinhMuc>)QueryUtil.list(
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
	 * Removes all the dinh mucs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (DinhMuc dinhMuc : findAll()) {
			remove(dinhMuc);
		}
	}

	/**
	 * Returns the number of dinh mucs.
	 *
	 * @return the number of dinh mucs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DINHMUC);

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
		return _SQL_SELECT_DINHMUC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DinhMucModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the dinh muc persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new DinhMucModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", DinhMuc.class.getName()));

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

		DinhMucUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DinhMucUtil.setPersistence(null);

		entityCache.removeCache(DinhMucImpl.class.getName());

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

	private static final String _SQL_SELECT_DINHMUC =
		"SELECT dinhMuc FROM DinhMuc dinhMuc";

	private static final String _SQL_COUNT_DINHMUC =
		"SELECT COUNT(dinhMuc) FROM DinhMuc dinhMuc";

	private static final String _ORDER_BY_ENTITY_ALIAS = "dinhMuc.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No DinhMuc exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		DinhMucPersistenceImpl.class);

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

	private static class DinhMucModelArgumentsResolver
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

			DinhMucModelImpl dinhMucModelImpl = (DinhMucModelImpl)baseModel;

			long columnBitmask = dinhMucModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(dinhMucModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						dinhMucModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(dinhMucModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			DinhMucModelImpl dinhMucModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = dinhMucModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = dinhMucModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}