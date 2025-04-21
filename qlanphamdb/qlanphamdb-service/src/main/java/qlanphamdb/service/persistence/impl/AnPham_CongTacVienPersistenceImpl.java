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

package qlanphamdb.service.persistence.impl;

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

import qlanphamdb.exception.NoSuchAnPham_CongTacVienException;

import qlanphamdb.model.AnPham_CongTacVien;
import qlanphamdb.model.impl.AnPham_CongTacVienImpl;
import qlanphamdb.model.impl.AnPham_CongTacVienModelImpl;

import qlanphamdb.service.persistence.AnPham_CongTacVienPersistence;
import qlanphamdb.service.persistence.AnPham_CongTacVienUtil;
import qlanphamdb.service.persistence.impl.constants.cwPersistenceConstants;

/**
 * The persistence implementation for the an pham_ cong tac vien service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @generated
 */
@Component(service = AnPham_CongTacVienPersistence.class)
public class AnPham_CongTacVienPersistenceImpl
	extends BasePersistenceImpl<AnPham_CongTacVien>
	implements AnPham_CongTacVienPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AnPham_CongTacVienUtil</code> to access the an pham_ cong tac vien persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AnPham_CongTacVienImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public AnPham_CongTacVienPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AnPham_CongTacVien.class);

		setModelImplClass(AnPham_CongTacVienImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the an pham_ cong tac vien in the entity cache if it is enabled.
	 *
	 * @param anPham_CongTacVien the an pham_ cong tac vien
	 */
	@Override
	public void cacheResult(AnPham_CongTacVien anPham_CongTacVien) {
		entityCache.putResult(
			AnPham_CongTacVienImpl.class, anPham_CongTacVien.getPrimaryKey(),
			anPham_CongTacVien);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the an pham_ cong tac viens in the entity cache if it is enabled.
	 *
	 * @param anPham_CongTacViens the an pham_ cong tac viens
	 */
	@Override
	public void cacheResult(List<AnPham_CongTacVien> anPham_CongTacViens) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (anPham_CongTacViens.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AnPham_CongTacVien anPham_CongTacVien : anPham_CongTacViens) {
			if (entityCache.getResult(
					AnPham_CongTacVienImpl.class,
					anPham_CongTacVien.getPrimaryKey()) == null) {

				cacheResult(anPham_CongTacVien);
			}
		}
	}

	/**
	 * Clears the cache for all an pham_ cong tac viens.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AnPham_CongTacVienImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the an pham_ cong tac vien.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AnPham_CongTacVien anPham_CongTacVien) {
		entityCache.removeResult(
			AnPham_CongTacVienImpl.class, anPham_CongTacVien);
	}

	@Override
	public void clearCache(List<AnPham_CongTacVien> anPham_CongTacViens) {
		for (AnPham_CongTacVien anPham_CongTacVien : anPham_CongTacViens) {
			entityCache.removeResult(
				AnPham_CongTacVienImpl.class, anPham_CongTacVien);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AnPham_CongTacVienImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new an pham_ cong tac vien with the primary key. Does not add the an pham_ cong tac vien to the database.
	 *
	 * @param id the primary key for the new an pham_ cong tac vien
	 * @return the new an pham_ cong tac vien
	 */
	@Override
	public AnPham_CongTacVien create(long id) {
		AnPham_CongTacVien anPham_CongTacVien = new AnPham_CongTacVienImpl();

		anPham_CongTacVien.setNew(true);
		anPham_CongTacVien.setPrimaryKey(id);

		anPham_CongTacVien.setCompanyId(CompanyThreadLocal.getCompanyId());

		return anPham_CongTacVien;
	}

	/**
	 * Removes the an pham_ cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was removed
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public AnPham_CongTacVien remove(long id)
		throws NoSuchAnPham_CongTacVienException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the an pham_ cong tac vien with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien that was removed
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public AnPham_CongTacVien remove(Serializable primaryKey)
		throws NoSuchAnPham_CongTacVienException {

		Session session = null;

		try {
			session = openSession();

			AnPham_CongTacVien anPham_CongTacVien =
				(AnPham_CongTacVien)session.get(
					AnPham_CongTacVienImpl.class, primaryKey);

			if (anPham_CongTacVien == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAnPham_CongTacVienException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(anPham_CongTacVien);
		}
		catch (NoSuchAnPham_CongTacVienException noSuchEntityException) {
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
	protected AnPham_CongTacVien removeImpl(
		AnPham_CongTacVien anPham_CongTacVien) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(anPham_CongTacVien)) {
				anPham_CongTacVien = (AnPham_CongTacVien)session.get(
					AnPham_CongTacVienImpl.class,
					anPham_CongTacVien.getPrimaryKeyObj());
			}

			if (anPham_CongTacVien != null) {
				session.delete(anPham_CongTacVien);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (anPham_CongTacVien != null) {
			clearCache(anPham_CongTacVien);
		}

		return anPham_CongTacVien;
	}

	@Override
	public AnPham_CongTacVien updateImpl(
		AnPham_CongTacVien anPham_CongTacVien) {

		boolean isNew = anPham_CongTacVien.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(anPham_CongTacVien);
			}
			else {
				anPham_CongTacVien = (AnPham_CongTacVien)session.merge(
					anPham_CongTacVien);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AnPham_CongTacVienImpl.class, anPham_CongTacVien, false, true);

		if (isNew) {
			anPham_CongTacVien.setNew(false);
		}

		anPham_CongTacVien.resetOriginalValues();

		return anPham_CongTacVien;
	}

	/**
	 * Returns the an pham_ cong tac vien with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public AnPham_CongTacVien findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAnPham_CongTacVienException {

		AnPham_CongTacVien anPham_CongTacVien = fetchByPrimaryKey(primaryKey);

		if (anPham_CongTacVien == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAnPham_CongTacVienException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return anPham_CongTacVien;
	}

	/**
	 * Returns the an pham_ cong tac vien with the primary key or throws a <code>NoSuchAnPham_CongTacVienException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien
	 * @throws NoSuchAnPham_CongTacVienException if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public AnPham_CongTacVien findByPrimaryKey(long id)
		throws NoSuchAnPham_CongTacVienException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the an pham_ cong tac vien with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ cong tac vien
	 * @return the an pham_ cong tac vien, or <code>null</code> if a an pham_ cong tac vien with the primary key could not be found
	 */
	@Override
	public AnPham_CongTacVien fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the an pham_ cong tac viens.
	 *
	 * @return the an pham_ cong tac viens
	 */
	@Override
	public List<AnPham_CongTacVien> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @return the range of an pham_ cong tac viens
	 */
	@Override
	public List<AnPham_CongTacVien> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ cong tac viens
	 */
	@Override
	public List<AnPham_CongTacVien> findAll(
		int start, int end,
		OrderByComparator<AnPham_CongTacVien> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the an pham_ cong tac viens.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_CongTacVienModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ cong tac viens
	 * @param end the upper bound of the range of an pham_ cong tac viens (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ cong tac viens
	 */
	@Override
	public List<AnPham_CongTacVien> findAll(
		int start, int end,
		OrderByComparator<AnPham_CongTacVien> orderByComparator,
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

		List<AnPham_CongTacVien> list = null;

		if (useFinderCache) {
			list = (List<AnPham_CongTacVien>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ANPHAM_CONGTACVIEN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ANPHAM_CONGTACVIEN;

				sql = sql.concat(AnPham_CongTacVienModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AnPham_CongTacVien>)QueryUtil.list(
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
	 * Removes all the an pham_ cong tac viens from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AnPham_CongTacVien anPham_CongTacVien : findAll()) {
			remove(anPham_CongTacVien);
		}
	}

	/**
	 * Returns the number of an pham_ cong tac viens.
	 *
	 * @return the number of an pham_ cong tac viens
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ANPHAM_CONGTACVIEN);

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
		return _SQL_SELECT_ANPHAM_CONGTACVIEN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AnPham_CongTacVienModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the an pham_ cong tac vien persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new AnPham_CongTacVienModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", AnPham_CongTacVien.class.getName()));

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

		_setAnPham_CongTacVienUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setAnPham_CongTacVienUtilPersistence(null);

		entityCache.removeCache(AnPham_CongTacVienImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setAnPham_CongTacVienUtilPersistence(
		AnPham_CongTacVienPersistence anPham_CongTacVienPersistence) {

		try {
			Field field = AnPham_CongTacVienUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, anPham_CongTacVienPersistence);
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

	private static final String _SQL_SELECT_ANPHAM_CONGTACVIEN =
		"SELECT anPham_CongTacVien FROM AnPham_CongTacVien anPham_CongTacVien";

	private static final String _SQL_COUNT_ANPHAM_CONGTACVIEN =
		"SELECT COUNT(anPham_CongTacVien) FROM AnPham_CongTacVien anPham_CongTacVien";

	private static final String _ORDER_BY_ENTITY_ALIAS = "anPham_CongTacVien.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AnPham_CongTacVien exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		AnPham_CongTacVienPersistenceImpl.class);

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

	private static class AnPham_CongTacVienModelArgumentsResolver
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

			AnPham_CongTacVienModelImpl anPham_CongTacVienModelImpl =
				(AnPham_CongTacVienModelImpl)baseModel;

			long columnBitmask = anPham_CongTacVienModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					anPham_CongTacVienModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						anPham_CongTacVienModelImpl.getColumnBitmask(
							columnName);
				}

				if (finderPath.isBaseModelResult() &&
					(AnPham_CongTacVienPersistenceImpl.
						FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION ==
							finderPath.getCacheName())) {

					finderPathColumnBitmask |= _ORDER_BY_COLUMNS_BITMASK;
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					anPham_CongTacVienModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			AnPham_CongTacVienModelImpl anPham_CongTacVienModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						anPham_CongTacVienModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = anPham_CongTacVienModelImpl.getColumnValue(
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