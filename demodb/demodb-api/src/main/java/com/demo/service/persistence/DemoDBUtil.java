/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.service.persistence;

import com.demo.model.DemoDB;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the demo db service. This utility wraps <code>com.demo.service.persistence.impl.DemoDBPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemoDBPersistence
 * @generated
 */
public class DemoDBUtil {

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
	public static void clearCache(DemoDB demoDB) {
		getPersistence().clearCache(demoDB);
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
	public static Map<Serializable, DemoDB> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<DemoDB> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DemoDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DemoDB> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<DemoDB> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static DemoDB update(DemoDB demoDB) {
		return getPersistence().update(demoDB);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static DemoDB update(DemoDB demoDB, ServiceContext serviceContext) {
		return getPersistence().update(demoDB, serviceContext);
	}

	/**
	 * Caches the demo db in the entity cache if it is enabled.
	 *
	 * @param demoDB the demo db
	 */
	public static void cacheResult(DemoDB demoDB) {
		getPersistence().cacheResult(demoDB);
	}

	/**
	 * Caches the demo dbs in the entity cache if it is enabled.
	 *
	 * @param demoDBs the demo dbs
	 */
	public static void cacheResult(List<DemoDB> demoDBs) {
		getPersistence().cacheResult(demoDBs);
	}

	/**
	 * Creates a new demo db with the primary key. Does not add the demo db to the database.
	 *
	 * @param id the primary key for the new demo db
	 * @return the new demo db
	 */
	public static DemoDB create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the demo db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db that was removed
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	public static DemoDB remove(long id)
		throws com.demo.exception.NoSuchDemoDBException {

		return getPersistence().remove(id);
	}

	public static DemoDB updateImpl(DemoDB demoDB) {
		return getPersistence().updateImpl(demoDB);
	}

	/**
	 * Returns the demo db with the primary key or throws a <code>NoSuchDemoDBException</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	public static DemoDB findByPrimaryKey(long id)
		throws com.demo.exception.NoSuchDemoDBException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the demo db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db, or <code>null</code> if a demo db with the primary key could not be found
	 */
	public static DemoDB fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the demo dbs.
	 *
	 * @return the demo dbs
	 */
	public static List<DemoDB> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @return the range of demo dbs
	 */
	public static List<DemoDB> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demo dbs
	 */
	public static List<DemoDB> findAll(
		int start, int end, OrderByComparator<DemoDB> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of demo dbs
	 */
	public static List<DemoDB> findAll(
		int start, int end, OrderByComparator<DemoDB> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the demo dbs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of demo dbs.
	 *
	 * @return the number of demo dbs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DemoDBPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DemoDBPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DemoDBPersistence _persistence;

}