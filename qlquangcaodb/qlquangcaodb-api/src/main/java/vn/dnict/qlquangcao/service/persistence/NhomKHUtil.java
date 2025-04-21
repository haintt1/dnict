/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.qlquangcao.model.NhomKH;

/**
 * The persistence utility for the nhom kh service. This utility wraps <code>vn.dnict.qlquangcao.service.persistence.impl.NhomKHPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see NhomKHPersistence
 * @generated
 */
public class NhomKHUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(NhomKH nhomKH) {
		getPersistence().clearCache(nhomKH);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, NhomKH> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NhomKH> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NhomKH> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NhomKH> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<NhomKH> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static NhomKH update(NhomKH nhomKH) {
		return getPersistence().update(nhomKH);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static NhomKH update(NhomKH nhomKH, ServiceContext serviceContext) {
		return getPersistence().update(nhomKH, serviceContext);
	}

	/**
	 * Caches the nhom kh in the entity cache if it is enabled.
	 *
	 * @param nhomKH the nhom kh
	 */
	public static void cacheResult(NhomKH nhomKH) {
		getPersistence().cacheResult(nhomKH);
	}

	/**
	 * Caches the nhom khs in the entity cache if it is enabled.
	 *
	 * @param nhomKHs the nhom khs
	 */
	public static void cacheResult(List<NhomKH> nhomKHs) {
		getPersistence().cacheResult(nhomKHs);
	}

	/**
	 * Creates a new nhom kh with the primary key. Does not add the nhom kh to the database.
	 *
	 * @param id the primary key for the new nhom kh
	 * @return the new nhom kh
	 */
	public static NhomKH create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the nhom kh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh that was removed
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	public static NhomKH remove(long id)
		throws vn.dnict.qlquangcao.exception.NoSuchNhomKHException {

		return getPersistence().remove(id);
	}

	public static NhomKH updateImpl(NhomKH nhomKH) {
		return getPersistence().updateImpl(nhomKH);
	}

	/**
	 * Returns the nhom kh with the primary key or throws a <code>NoSuchNhomKHException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	public static NhomKH findByPrimaryKey(long id)
		throws vn.dnict.qlquangcao.exception.NoSuchNhomKHException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the nhom kh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh, or <code>null</code> if a nhom kh with the primary key could not be found
	 */
	public static NhomKH fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the nhom khs.
	 *
	 * @return the nhom khs
	 */
	public static List<NhomKH> findAll() {
		return getPersistence().findAll();
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
	public static List<NhomKH> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<NhomKH> findAll(
		int start, int end, OrderByComparator<NhomKH> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<NhomKH> findAll(
		int start, int end, OrderByComparator<NhomKH> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the nhom khs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of nhom khs.
	 *
	 * @return the number of nhom khs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static NhomKHPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(NhomKHPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile NhomKHPersistence _persistence;

}