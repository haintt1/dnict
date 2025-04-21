/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence;

import com.contact.model.ToChuc;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the to chuc service. This utility wraps <code>com.contact.service.persistence.impl.ToChucPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ToChucPersistence
 * @generated
 */
public class ToChucUtil {

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
	public static void clearCache(ToChuc toChuc) {
		getPersistence().clearCache(toChuc);
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
	public static Map<Serializable, ToChuc> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ToChuc> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ToChuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ToChuc> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ToChuc> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ToChuc update(ToChuc toChuc) {
		return getPersistence().update(toChuc);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ToChuc update(ToChuc toChuc, ServiceContext serviceContext) {
		return getPersistence().update(toChuc, serviceContext);
	}

	/**
	 * Returns all the to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching to chucs
	 */
	public static List<ToChuc> findByten(String ten) {
		return getPersistence().findByten(ten);
	}

	/**
	 * Returns a range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of matching to chucs
	 */
	public static List<ToChuc> findByten(String ten, int start, int end) {
		return getPersistence().findByten(ten, start, end);
	}

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching to chucs
	 */
	public static List<ToChuc> findByten(
		String ten, int start, int end,
		OrderByComparator<ToChuc> orderByComparator) {

		return getPersistence().findByten(ten, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching to chucs
	 */
	public static List<ToChuc> findByten(
		String ten, int start, int end,
		OrderByComparator<ToChuc> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByten(
			ten, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	public static ToChuc findByten_First(
			String ten, OrderByComparator<ToChuc> orderByComparator)
		throws com.contact.exception.NoSuchToChucException {

		return getPersistence().findByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	public static ToChuc fetchByten_First(
		String ten, OrderByComparator<ToChuc> orderByComparator) {

		return getPersistence().fetchByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	public static ToChuc findByten_Last(
			String ten, OrderByComparator<ToChuc> orderByComparator)
		throws com.contact.exception.NoSuchToChucException {

		return getPersistence().findByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	public static ToChuc fetchByten_Last(
		String ten, OrderByComparator<ToChuc> orderByComparator) {

		return getPersistence().fetchByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the to chucs before and after the current to chuc in the ordered set where ten = &#63;.
	 *
	 * @param tochucId the primary key of the current to chuc
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public static ToChuc[] findByten_PrevAndNext(
			long tochucId, String ten,
			OrderByComparator<ToChuc> orderByComparator)
		throws com.contact.exception.NoSuchToChucException {

		return getPersistence().findByten_PrevAndNext(
			tochucId, ten, orderByComparator);
	}

	/**
	 * Removes all the to chucs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByten(String ten) {
		getPersistence().removeByten(ten);
	}

	/**
	 * Returns the number of to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching to chucs
	 */
	public static int countByten(String ten) {
		return getPersistence().countByten(ten);
	}

	/**
	 * Caches the to chuc in the entity cache if it is enabled.
	 *
	 * @param toChuc the to chuc
	 */
	public static void cacheResult(ToChuc toChuc) {
		getPersistence().cacheResult(toChuc);
	}

	/**
	 * Caches the to chucs in the entity cache if it is enabled.
	 *
	 * @param toChucs the to chucs
	 */
	public static void cacheResult(List<ToChuc> toChucs) {
		getPersistence().cacheResult(toChucs);
	}

	/**
	 * Creates a new to chuc with the primary key. Does not add the to chuc to the database.
	 *
	 * @param tochucId the primary key for the new to chuc
	 * @return the new to chuc
	 */
	public static ToChuc create(long tochucId) {
		return getPersistence().create(tochucId);
	}

	/**
	 * Removes the to chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc that was removed
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public static ToChuc remove(long tochucId)
		throws com.contact.exception.NoSuchToChucException {

		return getPersistence().remove(tochucId);
	}

	public static ToChuc updateImpl(ToChuc toChuc) {
		return getPersistence().updateImpl(toChuc);
	}

	/**
	 * Returns the to chuc with the primary key or throws a <code>NoSuchToChucException</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public static ToChuc findByPrimaryKey(long tochucId)
		throws com.contact.exception.NoSuchToChucException {

		return getPersistence().findByPrimaryKey(tochucId);
	}

	/**
	 * Returns the to chuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc, or <code>null</code> if a to chuc with the primary key could not be found
	 */
	public static ToChuc fetchByPrimaryKey(long tochucId) {
		return getPersistence().fetchByPrimaryKey(tochucId);
	}

	/**
	 * Returns all the to chucs.
	 *
	 * @return the to chucs
	 */
	public static List<ToChuc> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of to chucs
	 */
	public static List<ToChuc> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of to chucs
	 */
	public static List<ToChuc> findAll(
		int start, int end, OrderByComparator<ToChuc> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of to chucs
	 */
	public static List<ToChuc> findAll(
		int start, int end, OrderByComparator<ToChuc> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the to chucs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of to chucs.
	 *
	 * @return the number of to chucs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ToChucPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ToChucPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ToChucPersistence _persistence;

}