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

package vn.dnict.vanbanphapquy.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.vanbanphapquy.model.Vanbanphapquy;

/**
 * The persistence utility for the vanbanphapquy service. This utility wraps <code>vn.dnict.vanbanphapquy.service.persistence.impl.VanbanphapquyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see VanbanphapquyPersistence
 * @generated
 */
public class VanbanphapquyUtil {

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
	public static void clearCache(Vanbanphapquy vanbanphapquy) {
		getPersistence().clearCache(vanbanphapquy);
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
	public static Map<Serializable, Vanbanphapquy> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Vanbanphapquy> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Vanbanphapquy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Vanbanphapquy> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Vanbanphapquy update(Vanbanphapquy vanbanphapquy) {
		return getPersistence().update(vanbanphapquy);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Vanbanphapquy update(
		Vanbanphapquy vanbanphapquy, ServiceContext serviceContext) {

		return getPersistence().update(vanbanphapquy, serviceContext);
	}

	/**
	 * Returns all the vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching vanbanphapquys
	 */
	public static List<Vanbanphapquy> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of matching vanbanphapquys
	 */
	public static List<Vanbanphapquy> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vanbanphapquys
	 */
	public static List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vanbanphapquys
	 */
	public static List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	public static Vanbanphapquy findByStatus_First(
			int status, OrderByComparator<Vanbanphapquy> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	public static Vanbanphapquy fetchByStatus_First(
		int status, OrderByComparator<Vanbanphapquy> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	public static Vanbanphapquy findByStatus_Last(
			int status, OrderByComparator<Vanbanphapquy> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	public static Vanbanphapquy fetchByStatus_Last(
		int status, OrderByComparator<Vanbanphapquy> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the vanbanphapquys before and after the current vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current vanbanphapquy
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public static Vanbanphapquy[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Vanbanphapquy> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the vanbanphapquys where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching vanbanphapquys
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the vanbanphapquy in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 */
	public static void cacheResult(Vanbanphapquy vanbanphapquy) {
		getPersistence().cacheResult(vanbanphapquy);
	}

	/**
	 * Caches the vanbanphapquys in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquys the vanbanphapquys
	 */
	public static void cacheResult(List<Vanbanphapquy> vanbanphapquys) {
		getPersistence().cacheResult(vanbanphapquys);
	}

	/**
	 * Creates a new vanbanphapquy with the primary key. Does not add the vanbanphapquy to the database.
	 *
	 * @param id the primary key for the new vanbanphapquy
	 * @return the new vanbanphapquy
	 */
	public static Vanbanphapquy create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the vanbanphapquy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public static Vanbanphapquy remove(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException {

		return getPersistence().remove(id);
	}

	public static Vanbanphapquy updateImpl(Vanbanphapquy vanbanphapquy) {
		return getPersistence().updateImpl(vanbanphapquy);
	}

	/**
	 * Returns the vanbanphapquy with the primary key or throws a <code>NoSuchVanbanphapquyException</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public static Vanbanphapquy findByPrimaryKey(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the vanbanphapquy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy, or <code>null</code> if a vanbanphapquy with the primary key could not be found
	 */
	public static Vanbanphapquy fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the vanbanphapquys.
	 *
	 * @return the vanbanphapquys
	 */
	public static List<Vanbanphapquy> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of vanbanphapquys
	 */
	public static List<Vanbanphapquy> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vanbanphapquys
	 */
	public static List<Vanbanphapquy> findAll(
		int start, int end,
		OrderByComparator<Vanbanphapquy> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vanbanphapquys
	 */
	public static List<Vanbanphapquy> findAll(
		int start, int end, OrderByComparator<Vanbanphapquy> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the vanbanphapquys from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vanbanphapquys.
	 *
	 * @return the number of vanbanphapquys
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static VanbanphapquyPersistence getPersistence() {
		return _persistence;
	}

	private static volatile VanbanphapquyPersistence _persistence;

}