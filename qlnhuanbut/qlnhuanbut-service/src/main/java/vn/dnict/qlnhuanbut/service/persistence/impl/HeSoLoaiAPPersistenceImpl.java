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

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoLoaiAPException;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;
import vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPImpl;
import vn.dnict.qlnhuanbut.model.impl.HeSoLoaiAPModelImpl;
import vn.dnict.qlnhuanbut.service.persistence.HeSoLoaiAPPersistence;
import vn.dnict.qlnhuanbut.service.persistence.HeSoLoaiAPUtil;
import vn.dnict.qlnhuanbut.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the he so loai ap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = HeSoLoaiAPPersistence.class)
public class HeSoLoaiAPPersistenceImpl
	extends BasePersistenceImpl<HeSoLoaiAP> implements HeSoLoaiAPPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HeSoLoaiAPUtil</code> to access the he so loai ap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HeSoLoaiAPImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HeSoLoaiAPPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HeSoLoaiAP.class);

		setModelImplClass(HeSoLoaiAPImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the he so loai ap in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAP the he so loai ap
	 */
	@Override
	public void cacheResult(HeSoLoaiAP heSoLoaiAP) {
		entityCache.putResult(
			HeSoLoaiAPImpl.class, heSoLoaiAP.getPrimaryKey(), heSoLoaiAP);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the he so loai aps in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAPs the he so loai aps
	 */
	@Override
	public void cacheResult(List<HeSoLoaiAP> heSoLoaiAPs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (heSoLoaiAPs.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HeSoLoaiAP heSoLoaiAP : heSoLoaiAPs) {
			if (entityCache.getResult(
					HeSoLoaiAPImpl.class, heSoLoaiAP.getPrimaryKey()) == null) {

				cacheResult(heSoLoaiAP);
			}
		}
	}

	/**
	 * Clears the cache for all he so loai aps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HeSoLoaiAPImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the he so loai ap.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HeSoLoaiAP heSoLoaiAP) {
		entityCache.removeResult(HeSoLoaiAPImpl.class, heSoLoaiAP);
	}

	@Override
	public void clearCache(List<HeSoLoaiAP> heSoLoaiAPs) {
		for (HeSoLoaiAP heSoLoaiAP : heSoLoaiAPs) {
			entityCache.removeResult(HeSoLoaiAPImpl.class, heSoLoaiAP);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HeSoLoaiAPImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new he so loai ap with the primary key. Does not add the he so loai ap to the database.
	 *
	 * @param id the primary key for the new he so loai ap
	 * @return the new he so loai ap
	 */
	@Override
	public HeSoLoaiAP create(long id) {
		HeSoLoaiAP heSoLoaiAP = new HeSoLoaiAPImpl();

		heSoLoaiAP.setNew(true);
		heSoLoaiAP.setPrimaryKey(id);

		return heSoLoaiAP;
	}

	/**
	 * Removes the he so loai ap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap that was removed
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public HeSoLoaiAP remove(long id) throws NoSuchHeSoLoaiAPException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the he so loai ap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the he so loai ap
	 * @return the he so loai ap that was removed
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public HeSoLoaiAP remove(Serializable primaryKey)
		throws NoSuchHeSoLoaiAPException {

		Session session = null;

		try {
			session = openSession();

			HeSoLoaiAP heSoLoaiAP = (HeSoLoaiAP)session.get(
				HeSoLoaiAPImpl.class, primaryKey);

			if (heSoLoaiAP == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeSoLoaiAPException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(heSoLoaiAP);
		}
		catch (NoSuchHeSoLoaiAPException noSuchEntityException) {
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
	protected HeSoLoaiAP removeImpl(HeSoLoaiAP heSoLoaiAP) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(heSoLoaiAP)) {
				heSoLoaiAP = (HeSoLoaiAP)session.get(
					HeSoLoaiAPImpl.class, heSoLoaiAP.getPrimaryKeyObj());
			}

			if (heSoLoaiAP != null) {
				session.delete(heSoLoaiAP);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (heSoLoaiAP != null) {
			clearCache(heSoLoaiAP);
		}

		return heSoLoaiAP;
	}

	@Override
	public HeSoLoaiAP updateImpl(HeSoLoaiAP heSoLoaiAP) {
		boolean isNew = heSoLoaiAP.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(heSoLoaiAP);
			}
			else {
				heSoLoaiAP = (HeSoLoaiAP)session.merge(heSoLoaiAP);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HeSoLoaiAPImpl.class, heSoLoaiAP, false, true);

		if (isNew) {
			heSoLoaiAP.setNew(false);
		}

		heSoLoaiAP.resetOriginalValues();

		return heSoLoaiAP;
	}

	/**
	 * Returns the he so loai ap with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the he so loai ap
	 * @return the he so loai ap
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public HeSoLoaiAP findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHeSoLoaiAPException {

		HeSoLoaiAP heSoLoaiAP = fetchByPrimaryKey(primaryKey);

		if (heSoLoaiAP == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHeSoLoaiAPException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return heSoLoaiAP;
	}

	/**
	 * Returns the he so loai ap with the primary key or throws a <code>NoSuchHeSoLoaiAPException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	@Override
	public HeSoLoaiAP findByPrimaryKey(long id)
		throws NoSuchHeSoLoaiAPException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the he so loai ap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap, or <code>null</code> if a he so loai ap with the primary key could not be found
	 */
	@Override
	public HeSoLoaiAP fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the he so loai aps.
	 *
	 * @return the he so loai aps
	 */
	@Override
	public List<HeSoLoaiAP> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @return the range of he so loai aps
	 */
	@Override
	public List<HeSoLoaiAP> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so loai aps
	 */
	@Override
	public List<HeSoLoaiAP> findAll(
		int start, int end, OrderByComparator<HeSoLoaiAP> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so loai aps
	 */
	@Override
	public List<HeSoLoaiAP> findAll(
		int start, int end, OrderByComparator<HeSoLoaiAP> orderByComparator,
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

		List<HeSoLoaiAP> list = null;

		if (useFinderCache) {
			list = (List<HeSoLoaiAP>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HESOLOAIAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HESOLOAIAP;

				sql = sql.concat(HeSoLoaiAPModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HeSoLoaiAP>)QueryUtil.list(
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
	 * Removes all the he so loai aps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HeSoLoaiAP heSoLoaiAP : findAll()) {
			remove(heSoLoaiAP);
		}
	}

	/**
	 * Returns the number of he so loai aps.
	 *
	 * @return the number of he so loai aps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HESOLOAIAP);

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
		return _SQL_SELECT_HESOLOAIAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HeSoLoaiAPModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the he so loai ap persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HeSoLoaiAPModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HeSoLoaiAP.class.getName()));

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

		HeSoLoaiAPUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		HeSoLoaiAPUtil.setPersistence(null);

		entityCache.removeCache(HeSoLoaiAPImpl.class.getName());

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

	private static final String _SQL_SELECT_HESOLOAIAP =
		"SELECT heSoLoaiAP FROM HeSoLoaiAP heSoLoaiAP";

	private static final String _SQL_COUNT_HESOLOAIAP =
		"SELECT COUNT(heSoLoaiAP) FROM HeSoLoaiAP heSoLoaiAP";

	private static final String _ORDER_BY_ENTITY_ALIAS = "heSoLoaiAP.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HeSoLoaiAP exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HeSoLoaiAPPersistenceImpl.class);

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

	private static class HeSoLoaiAPModelArgumentsResolver
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

			HeSoLoaiAPModelImpl heSoLoaiAPModelImpl =
				(HeSoLoaiAPModelImpl)baseModel;

			long columnBitmask = heSoLoaiAPModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(heSoLoaiAPModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						heSoLoaiAPModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(heSoLoaiAPModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HeSoLoaiAPModelImpl heSoLoaiAPModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = heSoLoaiAPModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = heSoLoaiAPModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}