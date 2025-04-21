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

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoTheLoaiException;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;
import vn.dnict.qlnhuanbut.model.impl.HeSoTheLoaiImpl;
import vn.dnict.qlnhuanbut.model.impl.HeSoTheLoaiModelImpl;
import vn.dnict.qlnhuanbut.service.persistence.HeSoTheLoaiPersistence;
import vn.dnict.qlnhuanbut.service.persistence.HeSoTheLoaiUtil;
import vn.dnict.qlnhuanbut.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the he so the loai service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = HeSoTheLoaiPersistence.class)
public class HeSoTheLoaiPersistenceImpl
	extends BasePersistenceImpl<HeSoTheLoai> implements HeSoTheLoaiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>HeSoTheLoaiUtil</code> to access the he so the loai persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		HeSoTheLoaiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public HeSoTheLoaiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(HeSoTheLoai.class);

		setModelImplClass(HeSoTheLoaiImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the he so the loai in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoai the he so the loai
	 */
	@Override
	public void cacheResult(HeSoTheLoai heSoTheLoai) {
		entityCache.putResult(
			HeSoTheLoaiImpl.class, heSoTheLoai.getPrimaryKey(), heSoTheLoai);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the he so the loais in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoais the he so the loais
	 */
	@Override
	public void cacheResult(List<HeSoTheLoai> heSoTheLoais) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (heSoTheLoais.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (HeSoTheLoai heSoTheLoai : heSoTheLoais) {
			if (entityCache.getResult(
					HeSoTheLoaiImpl.class, heSoTheLoai.getPrimaryKey()) ==
						null) {

				cacheResult(heSoTheLoai);
			}
		}
	}

	/**
	 * Clears the cache for all he so the loais.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(HeSoTheLoaiImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the he so the loai.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(HeSoTheLoai heSoTheLoai) {
		entityCache.removeResult(HeSoTheLoaiImpl.class, heSoTheLoai);
	}

	@Override
	public void clearCache(List<HeSoTheLoai> heSoTheLoais) {
		for (HeSoTheLoai heSoTheLoai : heSoTheLoais) {
			entityCache.removeResult(HeSoTheLoaiImpl.class, heSoTheLoai);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(HeSoTheLoaiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new he so the loai with the primary key. Does not add the he so the loai to the database.
	 *
	 * @param id the primary key for the new he so the loai
	 * @return the new he so the loai
	 */
	@Override
	public HeSoTheLoai create(long id) {
		HeSoTheLoai heSoTheLoai = new HeSoTheLoaiImpl();

		heSoTheLoai.setNew(true);
		heSoTheLoai.setPrimaryKey(id);

		return heSoTheLoai;
	}

	/**
	 * Removes the he so the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai that was removed
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	@Override
	public HeSoTheLoai remove(long id) throws NoSuchHeSoTheLoaiException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the he so the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the he so the loai
	 * @return the he so the loai that was removed
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	@Override
	public HeSoTheLoai remove(Serializable primaryKey)
		throws NoSuchHeSoTheLoaiException {

		Session session = null;

		try {
			session = openSession();

			HeSoTheLoai heSoTheLoai = (HeSoTheLoai)session.get(
				HeSoTheLoaiImpl.class, primaryKey);

			if (heSoTheLoai == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchHeSoTheLoaiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(heSoTheLoai);
		}
		catch (NoSuchHeSoTheLoaiException noSuchEntityException) {
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
	protected HeSoTheLoai removeImpl(HeSoTheLoai heSoTheLoai) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(heSoTheLoai)) {
				heSoTheLoai = (HeSoTheLoai)session.get(
					HeSoTheLoaiImpl.class, heSoTheLoai.getPrimaryKeyObj());
			}

			if (heSoTheLoai != null) {
				session.delete(heSoTheLoai);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (heSoTheLoai != null) {
			clearCache(heSoTheLoai);
		}

		return heSoTheLoai;
	}

	@Override
	public HeSoTheLoai updateImpl(HeSoTheLoai heSoTheLoai) {
		boolean isNew = heSoTheLoai.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(heSoTheLoai);
			}
			else {
				heSoTheLoai = (HeSoTheLoai)session.merge(heSoTheLoai);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(HeSoTheLoaiImpl.class, heSoTheLoai, false, true);

		if (isNew) {
			heSoTheLoai.setNew(false);
		}

		heSoTheLoai.resetOriginalValues();

		return heSoTheLoai;
	}

	/**
	 * Returns the he so the loai with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the he so the loai
	 * @return the he so the loai
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	@Override
	public HeSoTheLoai findByPrimaryKey(Serializable primaryKey)
		throws NoSuchHeSoTheLoaiException {

		HeSoTheLoai heSoTheLoai = fetchByPrimaryKey(primaryKey);

		if (heSoTheLoai == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchHeSoTheLoaiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return heSoTheLoai;
	}

	/**
	 * Returns the he so the loai with the primary key or throws a <code>NoSuchHeSoTheLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	@Override
	public HeSoTheLoai findByPrimaryKey(long id)
		throws NoSuchHeSoTheLoaiException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the he so the loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai, or <code>null</code> if a he so the loai with the primary key could not be found
	 */
	@Override
	public HeSoTheLoai fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the he so the loais.
	 *
	 * @return the he so the loais
	 */
	@Override
	public List<HeSoTheLoai> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @return the range of he so the loais
	 */
	@Override
	public List<HeSoTheLoai> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so the loais
	 */
	@Override
	public List<HeSoTheLoai> findAll(
		int start, int end, OrderByComparator<HeSoTheLoai> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so the loais
	 */
	@Override
	public List<HeSoTheLoai> findAll(
		int start, int end, OrderByComparator<HeSoTheLoai> orderByComparator,
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

		List<HeSoTheLoai> list = null;

		if (useFinderCache) {
			list = (List<HeSoTheLoai>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_HESOTHELOAI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_HESOTHELOAI;

				sql = sql.concat(HeSoTheLoaiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<HeSoTheLoai>)QueryUtil.list(
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
	 * Removes all the he so the loais from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (HeSoTheLoai heSoTheLoai : findAll()) {
			remove(heSoTheLoai);
		}
	}

	/**
	 * Returns the number of he so the loais.
	 *
	 * @return the number of he so the loais
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_HESOTHELOAI);

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
		return _SQL_SELECT_HESOTHELOAI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return HeSoTheLoaiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the he so the loai persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new HeSoTheLoaiModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", HeSoTheLoai.class.getName()));

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

		HeSoTheLoaiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		HeSoTheLoaiUtil.setPersistence(null);

		entityCache.removeCache(HeSoTheLoaiImpl.class.getName());

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

	private static final String _SQL_SELECT_HESOTHELOAI =
		"SELECT heSoTheLoai FROM HeSoTheLoai heSoTheLoai";

	private static final String _SQL_COUNT_HESOTHELOAI =
		"SELECT COUNT(heSoTheLoai) FROM HeSoTheLoai heSoTheLoai";

	private static final String _ORDER_BY_ENTITY_ALIAS = "heSoTheLoai.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No HeSoTheLoai exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		HeSoTheLoaiPersistenceImpl.class);

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

	private static class HeSoTheLoaiModelArgumentsResolver
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

			HeSoTheLoaiModelImpl heSoTheLoaiModelImpl =
				(HeSoTheLoaiModelImpl)baseModel;

			long columnBitmask = heSoTheLoaiModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(heSoTheLoaiModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						heSoTheLoaiModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(heSoTheLoaiModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			HeSoTheLoaiModelImpl heSoTheLoaiModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = heSoTheLoaiModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = heSoTheLoaiModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}