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

import vn.dnict.vanbanphapquy.model.Capbanhanh;

/**
 * The persistence utility for the capbanhanh service. This utility wraps <code>vn.dnict.vanbanphapquy.service.persistence.impl.CapbanhanhPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CapbanhanhPersistence
 * @generated
 */
public class CapbanhanhUtil {

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
	public static void clearCache(Capbanhanh capbanhanh) {
		getPersistence().clearCache(capbanhanh);
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
	public static Map<Serializable, Capbanhanh> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Capbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Capbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Capbanhanh> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Capbanhanh> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Capbanhanh update(Capbanhanh capbanhanh) {
		return getPersistence().update(capbanhanh);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Capbanhanh update(
		Capbanhanh capbanhanh, ServiceContext serviceContext) {

		return getPersistence().update(capbanhanh, serviceContext);
	}

	/**
	 * Returns all the capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching capbanhanhs
	 */
	public static List<Capbanhanh> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of matching capbanhanhs
	 */
	public static List<Capbanhanh> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching capbanhanhs
	 */
	public static List<Capbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Capbanhanh> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching capbanhanhs
	 */
	public static List<Capbanhanh> findByStatus(
		int status, int start, int end,
		OrderByComparator<Capbanhanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	public static Capbanhanh findByStatus_First(
			int status, OrderByComparator<Capbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	public static Capbanhanh fetchByStatus_First(
		int status, OrderByComparator<Capbanhanh> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	public static Capbanhanh findByStatus_Last(
			int status, OrderByComparator<Capbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	public static Capbanhanh fetchByStatus_Last(
		int status, OrderByComparator<Capbanhanh> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the capbanhanhs before and after the current capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current capbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public static Capbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Capbanhanh> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the capbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching capbanhanhs
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the capbanhanh in the entity cache if it is enabled.
	 *
	 * @param capbanhanh the capbanhanh
	 */
	public static void cacheResult(Capbanhanh capbanhanh) {
		getPersistence().cacheResult(capbanhanh);
	}

	/**
	 * Caches the capbanhanhs in the entity cache if it is enabled.
	 *
	 * @param capbanhanhs the capbanhanhs
	 */
	public static void cacheResult(List<Capbanhanh> capbanhanhs) {
		getPersistence().cacheResult(capbanhanhs);
	}

	/**
	 * Creates a new capbanhanh with the primary key. Does not add the capbanhanh to the database.
	 *
	 * @param id the primary key for the new capbanhanh
	 * @return the new capbanhanh
	 */
	public static Capbanhanh create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the capbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh that was removed
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public static Capbanhanh remove(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException {

		return getPersistence().remove(id);
	}

	public static Capbanhanh updateImpl(Capbanhanh capbanhanh) {
		return getPersistence().updateImpl(capbanhanh);
	}

	/**
	 * Returns the capbanhanh with the primary key or throws a <code>NoSuchCapbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public static Capbanhanh findByPrimaryKey(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the capbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh, or <code>null</code> if a capbanhanh with the primary key could not be found
	 */
	public static Capbanhanh fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the capbanhanhs.
	 *
	 * @return the capbanhanhs
	 */
	public static List<Capbanhanh> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of capbanhanhs
	 */
	public static List<Capbanhanh> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of capbanhanhs
	 */
	public static List<Capbanhanh> findAll(
		int start, int end, OrderByComparator<Capbanhanh> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of capbanhanhs
	 */
	public static List<Capbanhanh> findAll(
		int start, int end, OrderByComparator<Capbanhanh> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the capbanhanhs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of capbanhanhs.
	 *
	 * @return the number of capbanhanhs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CapbanhanhPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CapbanhanhPersistence _persistence;

}