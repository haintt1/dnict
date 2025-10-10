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

import vn.dnict.vanbanphapquy.model.Linhvucvanban;

/**
 * The persistence utility for the linhvucvanban service. This utility wraps <code>vn.dnict.vanbanphapquy.service.persistence.impl.LinhvucvanbanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LinhvucvanbanPersistence
 * @generated
 */
public class LinhvucvanbanUtil {

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
	public static void clearCache(Linhvucvanban linhvucvanban) {
		getPersistence().clearCache(linhvucvanban);
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
	public static Map<Serializable, Linhvucvanban> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Linhvucvanban> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Linhvucvanban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Linhvucvanban> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Linhvucvanban> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Linhvucvanban update(Linhvucvanban linhvucvanban) {
		return getPersistence().update(linhvucvanban);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Linhvucvanban update(
		Linhvucvanban linhvucvanban, ServiceContext serviceContext) {

		return getPersistence().update(linhvucvanban, serviceContext);
	}

	/**
	 * Returns all the linhvucvanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching linhvucvanbans
	 */
	public static List<Linhvucvanban> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @return the range of matching linhvucvanbans
	 */
	public static List<Linhvucvanban> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linhvucvanbans
	 */
	public static List<Linhvucvanban> findByStatus(
		int status, int start, int end,
		OrderByComparator<Linhvucvanban> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching linhvucvanbans
	 */
	public static List<Linhvucvanban> findByStatus(
		int status, int start, int end,
		OrderByComparator<Linhvucvanban> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a matching linhvucvanban could not be found
	 */
	public static Linhvucvanban findByStatus_First(
			int status, OrderByComparator<Linhvucvanban> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linhvucvanban, or <code>null</code> if a matching linhvucvanban could not be found
	 */
	public static Linhvucvanban fetchByStatus_First(
		int status, OrderByComparator<Linhvucvanban> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a matching linhvucvanban could not be found
	 */
	public static Linhvucvanban findByStatus_Last(
			int status, OrderByComparator<Linhvucvanban> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linhvucvanban, or <code>null</code> if a matching linhvucvanban could not be found
	 */
	public static Linhvucvanban fetchByStatus_Last(
		int status, OrderByComparator<Linhvucvanban> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the linhvucvanbans before and after the current linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current linhvucvanban
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public static Linhvucvanban[] findByStatus_PrevAndNext(
			long id, int status,
			OrderByComparator<Linhvucvanban> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException {

		return getPersistence().findByStatus_PrevAndNext(
			id, status, orderByComparator);
	}

	/**
	 * Removes all the linhvucvanbans where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of linhvucvanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching linhvucvanbans
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the linhvucvanban in the entity cache if it is enabled.
	 *
	 * @param linhvucvanban the linhvucvanban
	 */
	public static void cacheResult(Linhvucvanban linhvucvanban) {
		getPersistence().cacheResult(linhvucvanban);
	}

	/**
	 * Caches the linhvucvanbans in the entity cache if it is enabled.
	 *
	 * @param linhvucvanbans the linhvucvanbans
	 */
	public static void cacheResult(List<Linhvucvanban> linhvucvanbans) {
		getPersistence().cacheResult(linhvucvanbans);
	}

	/**
	 * Creates a new linhvucvanban with the primary key. Does not add the linhvucvanban to the database.
	 *
	 * @param id the primary key for the new linhvucvanban
	 * @return the new linhvucvanban
	 */
	public static Linhvucvanban create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the linhvucvanban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban that was removed
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public static Linhvucvanban remove(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException {

		return getPersistence().remove(id);
	}

	public static Linhvucvanban updateImpl(Linhvucvanban linhvucvanban) {
		return getPersistence().updateImpl(linhvucvanban);
	}

	/**
	 * Returns the linhvucvanban with the primary key or throws a <code>NoSuchLinhvucvanbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public static Linhvucvanban findByPrimaryKey(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the linhvucvanban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban, or <code>null</code> if a linhvucvanban with the primary key could not be found
	 */
	public static Linhvucvanban fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the linhvucvanbans.
	 *
	 * @return the linhvucvanbans
	 */
	public static List<Linhvucvanban> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @return the range of linhvucvanbans
	 */
	public static List<Linhvucvanban> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of linhvucvanbans
	 */
	public static List<Linhvucvanban> findAll(
		int start, int end,
		OrderByComparator<Linhvucvanban> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of linhvucvanbans
	 */
	public static List<Linhvucvanban> findAll(
		int start, int end, OrderByComparator<Linhvucvanban> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the linhvucvanbans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of linhvucvanbans.
	 *
	 * @return the number of linhvucvanbans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LinhvucvanbanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LinhvucvanbanPersistence _persistence;

}