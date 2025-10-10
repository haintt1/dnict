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

import vn.dnict.vanbanphapquy.model.Coquanbanhanh;

/**
 * The persistence utility for the coquanbanhanh service. This utility wraps <code>vn.dnict.vanbanphapquy.service.persistence.impl.CoquanbanhanhPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CoquanbanhanhPersistence
 * @generated
 */
public class CoquanbanhanhUtil {

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
	public static void clearCache(Coquanbanhanh coquanbanhanh) {
		getPersistence().clearCache(coquanbanhanh);
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
	public static Map<Serializable, Coquanbanhanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Coquanbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Coquanbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Coquanbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Coquanbanhanh update(Coquanbanhanh coquanbanhanh) {
		return getPersistence().update(coquanbanhanh);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Coquanbanhanh update(
		Coquanbanhanh coquanbanhanh, ServiceContext serviceContext) {

		return getPersistence().update(coquanbanhanh, serviceContext);
	}

	/**
	 * Returns all the coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of matching coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	public static Coquanbanhanh findByStatus_First(
			int status, OrderByComparator<Coquanbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	public static Coquanbanhanh fetchByStatus_First(
		int status, OrderByComparator<Coquanbanhanh> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	public static Coquanbanhanh findByStatus_Last(
			int status, OrderByComparator<Coquanbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	public static Coquanbanhanh fetchByStatus_Last(
		int status, OrderByComparator<Coquanbanhanh> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the coquanbanhanhs before and after the current coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current coquanbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public static Coquanbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Coquanbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the coquanbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching coquanbanhanhs
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the coquanbanhanh in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 */
	public static void cacheResult(Coquanbanhanh coquanbanhanh) {
		getPersistence().cacheResult(coquanbanhanh);
	}

	/**
	 * Caches the coquanbanhanhs in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanhs the coquanbanhanhs
	 */
	public static void cacheResult(List<Coquanbanhanh> coquanbanhanhs) {
		getPersistence().cacheResult(coquanbanhanhs);
	}

	/**
	 * Creates a new coquanbanhanh with the primary key. Does not add the coquanbanhanh to the database.
	 *
	 * @param id the primary key for the new coquanbanhanh
	 * @return the new coquanbanhanh
	 */
	public static Coquanbanhanh create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the coquanbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public static Coquanbanhanh remove(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException {

		return getPersistence().remove(id);
	}

	public static Coquanbanhanh updateImpl(Coquanbanhanh coquanbanhanh) {
		return getPersistence().updateImpl(coquanbanhanh);
	}

	/**
	 * Returns the coquanbanhanh with the primary key or throws a <code>NoSuchCoquanbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public static Coquanbanhanh findByPrimaryKey(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the coquanbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh, or <code>null</code> if a coquanbanhanh with the primary key could not be found
	 */
	public static Coquanbanhanh fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the coquanbanhanhs.
	 *
	 * @return the coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findAll(
		int start, int end,
		OrderByComparator<Coquanbanhanh> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coquanbanhanhs
	 */
	public static List<Coquanbanhanh> findAll(
		int start, int end, OrderByComparator<Coquanbanhanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the coquanbanhanhs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of coquanbanhanhs.
	 *
	 * @return the number of coquanbanhanhs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CoquanbanhanhPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CoquanbanhanhPersistence _persistence;

}