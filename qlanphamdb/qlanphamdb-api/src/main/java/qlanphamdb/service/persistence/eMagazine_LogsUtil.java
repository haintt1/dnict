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

package qlanphamdb.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import qlanphamdb.model.eMagazine_Logs;

/**
 * The persistence utility for the e magazine_ logs service. This utility wraps <code>qlanphamdb.service.persistence.impl.eMagazine_LogsPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see eMagazine_LogsPersistence
 * @generated
 */
public class eMagazine_LogsUtil {

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
	public static void clearCache(eMagazine_Logs eMagazine_Logs) {
		getPersistence().clearCache(eMagazine_Logs);
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
	public static Map<Serializable, eMagazine_Logs> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<eMagazine_Logs> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<eMagazine_Logs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<eMagazine_Logs> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<eMagazine_Logs> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static eMagazine_Logs update(eMagazine_Logs eMagazine_Logs) {
		return getPersistence().update(eMagazine_Logs);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static eMagazine_Logs update(
		eMagazine_Logs eMagazine_Logs, ServiceContext serviceContext) {

		return getPersistence().update(eMagazine_Logs, serviceContext);
	}

	/**
	 * Caches the e magazine_ logs in the entity cache if it is enabled.
	 *
	 * @param eMagazine_Logs the e magazine_ logs
	 */
	public static void cacheResult(eMagazine_Logs eMagazine_Logs) {
		getPersistence().cacheResult(eMagazine_Logs);
	}

	/**
	 * Caches the e magazine_ logses in the entity cache if it is enabled.
	 *
	 * @param eMagazine_Logses the e magazine_ logses
	 */
	public static void cacheResult(List<eMagazine_Logs> eMagazine_Logses) {
		getPersistence().cacheResult(eMagazine_Logses);
	}

	/**
	 * Creates a new e magazine_ logs with the primary key. Does not add the e magazine_ logs to the database.
	 *
	 * @param id the primary key for the new e magazine_ logs
	 * @return the new e magazine_ logs
	 */
	public static eMagazine_Logs create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the e magazine_ logs with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine_ logs
	 * @return the e magazine_ logs that was removed
	 * @throws NoSucheMagazine_LogsException if a e magazine_ logs with the primary key could not be found
	 */
	public static eMagazine_Logs remove(long id)
		throws qlanphamdb.exception.NoSucheMagazine_LogsException {

		return getPersistence().remove(id);
	}

	public static eMagazine_Logs updateImpl(eMagazine_Logs eMagazine_Logs) {
		return getPersistence().updateImpl(eMagazine_Logs);
	}

	/**
	 * Returns the e magazine_ logs with the primary key or throws a <code>NoSucheMagazine_LogsException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ logs
	 * @return the e magazine_ logs
	 * @throws NoSucheMagazine_LogsException if a e magazine_ logs with the primary key could not be found
	 */
	public static eMagazine_Logs findByPrimaryKey(long id)
		throws qlanphamdb.exception.NoSucheMagazine_LogsException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the e magazine_ logs with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ logs
	 * @return the e magazine_ logs, or <code>null</code> if a e magazine_ logs with the primary key could not be found
	 */
	public static eMagazine_Logs fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the e magazine_ logses.
	 *
	 * @return the e magazine_ logses
	 */
	public static List<eMagazine_Logs> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the e magazine_ logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_LogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ logses
	 * @param end the upper bound of the range of e magazine_ logses (not inclusive)
	 * @return the range of e magazine_ logses
	 */
	public static List<eMagazine_Logs> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the e magazine_ logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_LogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ logses
	 * @param end the upper bound of the range of e magazine_ logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazine_ logses
	 */
	public static List<eMagazine_Logs> findAll(
		int start, int end,
		OrderByComparator<eMagazine_Logs> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e magazine_ logses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_LogsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ logses
	 * @param end the upper bound of the range of e magazine_ logses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazine_ logses
	 */
	public static List<eMagazine_Logs> findAll(
		int start, int end, OrderByComparator<eMagazine_Logs> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the e magazine_ logses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of e magazine_ logses.
	 *
	 * @return the number of e magazine_ logses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static eMagazine_LogsPersistence getPersistence() {
		return _persistence;
	}

	private static volatile eMagazine_LogsPersistence _persistence;

}