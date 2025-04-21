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

import vn.dnict.qlgopy.exception.NoSuchHoiDapGopYException;
import vn.dnict.qlgopy.model.HoiDapGopY;
import vn.dnict.qlgopy.model.impl.HoiDapGopYImpl;
import vn.dnict.qlgopy.model.impl.HoiDapGopYModelImpl;
import vn.dnict.qlgopy.service.persistence.HoiDapGopYPersistence;
import vn.dnict.qlgopy.service.persistence.HoiDapGopYUtil;
import vn.dnict.qlgopy.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the hoi dap gop y service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = HoiDapGopYPersistence.class)
public class HoiDapGopYPersistenceImpl
	extends BasePersistenceImpl<HoiDapGopY> implements HoiDapGopYPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HoiDapGopYUtil</code> to access the hoi dap gop y persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HoiDapGopYImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HoiDapGopYPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HoiDapGopY.class);

		setModelImplClass(HoiDapGopYImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the hoi dap gop y in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 */
	@Override
	public void cacheResult(HoiDapGopY hoiDapGopY) {
		entityCache.putResult(
			HoiDapGopYImpl.class, hoiDapGopY.getPrimaryKey(), hoiDapGopY);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the hoi dap gop ies in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopYs the hoi dap gop ies
	 */
	@Override
	public void cacheResult(List<HoiDapGopY> hoiDapGopYs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (hoiDapGopYs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HoiDapGopY hoiDapGopY : hoiDapGopYs) {
			if (entityCache.getResult(
					HoiDapGopYImpl.class, hoiDapGopY.getPrimaryKey()) == null) {

				cacheResult(hoiDapGopY);
			}
		}
	}

	/**
	 * Clears the cache for all hoi dap gop ies.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HoiDapGopYImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the hoi dap gop y.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HoiDapGopY hoiDapGopY) {
		entityCache.removeResult(HoiDapGopYImpl.class, hoiDapGopY);
	}

	@Override
	public void clearCache(List<HoiDapGopY> hoiDapGopYs) {
		for (HoiDapGopY hoiDapGopY : hoiDapGopYs) {
			entityCache.removeResult(HoiDapGopYImpl.class, hoiDapGopY);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HoiDapGopYImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new hoi dap gop y with the primary key. Does not add the hoi dap gop y to the database.
	 *
	 * @param id the primary key for the new hoi dap gop y
	 * @return the new hoi dap gop y
	 */
	@Override
	public HoiDapGopY create(long id) {
		HoiDapGopY hoiDapGopY = new HoiDapGopYImpl();

		hoiDapGopY.setNew(true);
		hoiDapGopY.setPrimaryKey(id);

		hoiDapGopY.setCompanyId(CompanyThreadLocal.getCompanyId());

		return hoiDapGopY;
	}

	/**
	 * Removes the hoi dap gop y with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public HoiDapGopY remove(long id) throws NoSuchHoiDapGopYException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the hoi dap gop y with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public HoiDapGopY remove(Serializable primaryKey)
		throws NoSuchHoiDapGopYException {

		Session session = null;

		try {
			session = openSession();

			HoiDapGopY hoiDapGopY = (HoiDapGopY)session.get(
				HoiDapGopYImpl.class, primaryKey);

			if (hoiDapGopY == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHoiDapGopYException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(hoiDapGopY);
		}
		catch (NoSuchHoiDapGopYException noSuchEntityException) {
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
	protected HoiDapGopY removeImpl(HoiDapGopY hoiDapGopY) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(hoiDapGopY)) {
				hoiDapGopY = (HoiDapGopY)session.get(
					HoiDapGopYImpl.class, hoiDapGopY.getPrimaryKeyObj());
			}

			if (hoiDapGopY != null) {
				session.delete(hoiDapGopY);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (hoiDapGopY != null) {
			clearCache(hoiDapGopY);
		}

		return hoiDapGopY;
	}

	@Override
	public HoiDapGopY updateImpl(HoiDapGopY hoiDapGopY) {
		boolean isNew = hoiDapGopY.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(hoiDapGopY);
			}
			else {
				hoiDapGopY = (HoiDapGopY)session.merge(hoiDapGopY);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HoiDapGopYImpl.class, hoiDapGopY, false, true);

		if (isNew) {
			hoiDapGopY.setNew(false);
		}

		hoiDapGopY.resetOriginalValues();

		return hoiDapGopY;
	}

	/**
	 * Returns the hoi dap gop y with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the hoi dap gop y
	 * @return the hoi dap gop y
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public HoiDapGopY findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHoiDapGopYException {

		HoiDapGopY hoiDapGopY = fetchByPrimaryKey(primaryKey);

		if (hoiDapGopY == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHoiDapGopYException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return hoiDapGopY;
	}

	/**
	 * Returns the hoi dap gop y with the primary key or throws a <code>NoSuchHoiDapGopYException</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public HoiDapGopY findByPrimaryKey(long id)
		throws NoSuchHoiDapGopYException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the hoi dap gop y with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y, or <code>null</code> if a hoi dap gop y with the primary key could not be found
	 */
	@Override
	public HoiDapGopY fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the hoi dap gop ies.
	 *
	 * @return the hoi dap gop ies
	 */
	@Override
	public List<HoiDapGopY> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @return the range of hoi dap gop ies
	 */
	@Override
	public List<HoiDapGopY> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hoi dap gop ies
	 */
	@Override
	public List<HoiDapGopY> findAll(
		int start, int end, OrderByComparator<HoiDapGopY> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hoi dap gop ies
	 */
	@Override
	public List<HoiDapGopY> findAll(
		int start, int end, OrderByComparator<HoiDapGopY> orderByComparator,
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

		List<HoiDapGopY> list = null;

		if (useFinderCache) {
			list = (List<HoiDapGopY>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HOIDAPGOPY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HOIDAPGOPY;

				sql = sql.concat(HoiDapGopYModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HoiDapGopY>)QueryUtil.list(
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
	 * Removes all the hoi dap gop ies from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HoiDapGopY hoiDapGopY : findAll()) {
			remove(hoiDapGopY);
		}
	}

	/**
	 * Returns the number of hoi dap gop ies.
	 *
	 * @return the number of hoi dap gop ies
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HOIDAPGOPY);

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
		return _SQL_SELECT_HOIDAPGOPY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HoiDapGopYModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the hoi dap gop y persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HoiDapGopYModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HoiDapGopY.class.getName()));

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

		HoiDapGopYUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		HoiDapGopYUtil.setPersistence(null);

		entityCache.removeCache(HoiDapGopYImpl.class.getName());

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

	private static final String _SQL_SELECT_HOIDAPGOPY =
		"SELECT hoiDapGopY FROM HoiDapGopY hoiDapGopY";

	private static final String _SQL_COUNT_HOIDAPGOPY =
		"SELECT COUNT(hoiDapGopY) FROM HoiDapGopY hoiDapGopY";

	private static final String _ORDER_BY_ENTITY_ALIAS = "hoiDapGopY.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HoiDapGopY exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HoiDapGopYPersistenceImpl.class);

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

	private static class HoiDapGopYModelArgumentsResolver
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

			HoiDapGopYModelImpl hoiDapGopYModelImpl =
				(HoiDapGopYModelImpl)baseModel;

			long columnBitmask = hoiDapGopYModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(hoiDapGopYModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						hoiDapGopYModelImpl.getColumnBitmask(columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(HoiDapGopYPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(hoiDapGopYModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HoiDapGopYModelImpl hoiDapGopYModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = hoiDapGopYModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = hoiDapGopYModelImpl.getColumnValue(
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