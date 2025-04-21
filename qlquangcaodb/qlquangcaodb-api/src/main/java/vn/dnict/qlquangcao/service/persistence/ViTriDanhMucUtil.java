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

import vn.dnict.qlquangcao.model.ViTriDanhMuc;

/**
 * The persistence utility for the vi tri danh muc service. This utility wraps <code>vn.dnict.qlquangcao.service.persistence.impl.ViTriDanhMucPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see ViTriDanhMucPersistence
 * @generated
 */
public class ViTriDanhMucUtil {

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
	public static void clearCache(ViTriDanhMuc viTriDanhMuc) {
		getPersistence().clearCache(viTriDanhMuc);
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
	public static Map<Serializable, ViTriDanhMuc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ViTriDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ViTriDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ViTriDanhMuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ViTriDanhMuc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ViTriDanhMuc update(ViTriDanhMuc viTriDanhMuc) {
		return getPersistence().update(viTriDanhMuc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ViTriDanhMuc update(
		ViTriDanhMuc viTriDanhMuc, ServiceContext serviceContext) {

		return getPersistence().update(viTriDanhMuc, serviceContext);
	}

	/**
	 * Caches the vi tri danh muc in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 */
	public static void cacheResult(ViTriDanhMuc viTriDanhMuc) {
		getPersistence().cacheResult(viTriDanhMuc);
	}

	/**
	 * Caches the vi tri danh mucs in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMucs the vi tri danh mucs
	 */
	public static void cacheResult(List<ViTriDanhMuc> viTriDanhMucs) {
		getPersistence().cacheResult(viTriDanhMucs);
	}

	/**
	 * Creates a new vi tri danh muc with the primary key. Does not add the vi tri danh muc to the database.
	 *
	 * @param id the primary key for the new vi tri danh muc
	 * @return the new vi tri danh muc
	 */
	public static ViTriDanhMuc create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	public static ViTriDanhMuc remove(long id)
		throws vn.dnict.qlquangcao.exception.NoSuchViTriDanhMucException {

		return getPersistence().remove(id);
	}

	public static ViTriDanhMuc updateImpl(ViTriDanhMuc viTriDanhMuc) {
		return getPersistence().updateImpl(viTriDanhMuc);
	}

	/**
	 * Returns the vi tri danh muc with the primary key or throws a <code>NoSuchViTriDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	public static ViTriDanhMuc findByPrimaryKey(long id)
		throws vn.dnict.qlquangcao.exception.NoSuchViTriDanhMucException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the vi tri danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc, or <code>null</code> if a vi tri danh muc with the primary key could not be found
	 */
	public static ViTriDanhMuc fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the vi tri danh mucs.
	 *
	 * @return the vi tri danh mucs
	 */
	public static List<ViTriDanhMuc> findAll() {
		return getPersistence().findAll();
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
	public static List<ViTriDanhMuc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<ViTriDanhMuc> findAll(
		int start, int end, OrderByComparator<ViTriDanhMuc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<ViTriDanhMuc> findAll(
		int start, int end, OrderByComparator<ViTriDanhMuc> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the vi tri danh mucs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vi tri danh mucs.
	 *
	 * @return the number of vi tri danh mucs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ViTriDanhMucPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ViTriDanhMucPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ViTriDanhMucPersistence _persistence;

}