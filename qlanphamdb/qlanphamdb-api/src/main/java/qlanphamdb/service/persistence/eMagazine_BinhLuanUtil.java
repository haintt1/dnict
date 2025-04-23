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

import qlanphamdb.model.eMagazine_BinhLuan;

/**
 * The persistence utility for the e magazine_ binh luan service. This utility wraps <code>qlanphamdb.service.persistence.impl.eMagazine_BinhLuanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see eMagazine_BinhLuanPersistence
 * @generated
 */
public class eMagazine_BinhLuanUtil {

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
	public static void clearCache(eMagazine_BinhLuan eMagazine_BinhLuan) {
		getPersistence().clearCache(eMagazine_BinhLuan);
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
	public static Map<Serializable, eMagazine_BinhLuan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<eMagazine_BinhLuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<eMagazine_BinhLuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<eMagazine_BinhLuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<eMagazine_BinhLuan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static eMagazine_BinhLuan update(
		eMagazine_BinhLuan eMagazine_BinhLuan) {

		return getPersistence().update(eMagazine_BinhLuan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static eMagazine_BinhLuan update(
		eMagazine_BinhLuan eMagazine_BinhLuan, ServiceContext serviceContext) {

		return getPersistence().update(eMagazine_BinhLuan, serviceContext);
	}

	/**
	 * Caches the e magazine_ binh luan in the entity cache if it is enabled.
	 *
	 * @param eMagazine_BinhLuan the e magazine_ binh luan
	 */
	public static void cacheResult(eMagazine_BinhLuan eMagazine_BinhLuan) {
		getPersistence().cacheResult(eMagazine_BinhLuan);
	}

	/**
	 * Caches the e magazine_ binh luans in the entity cache if it is enabled.
	 *
	 * @param eMagazine_BinhLuans the e magazine_ binh luans
	 */
	public static void cacheResult(
		List<eMagazine_BinhLuan> eMagazine_BinhLuans) {

		getPersistence().cacheResult(eMagazine_BinhLuans);
	}

	/**
	 * Creates a new e magazine_ binh luan with the primary key. Does not add the e magazine_ binh luan to the database.
	 *
	 * @param id the primary key for the new e magazine_ binh luan
	 * @return the new e magazine_ binh luan
	 */
	public static eMagazine_BinhLuan create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the e magazine_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan that was removed
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	public static eMagazine_BinhLuan remove(long id)
		throws qlanphamdb.exception.NoSucheMagazine_BinhLuanException {

		return getPersistence().remove(id);
	}

	public static eMagazine_BinhLuan updateImpl(
		eMagazine_BinhLuan eMagazine_BinhLuan) {

		return getPersistence().updateImpl(eMagazine_BinhLuan);
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key or throws a <code>NoSucheMagazine_BinhLuanException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan
	 * @throws NoSucheMagazine_BinhLuanException if a e magazine_ binh luan with the primary key could not be found
	 */
	public static eMagazine_BinhLuan findByPrimaryKey(long id)
		throws qlanphamdb.exception.NoSucheMagazine_BinhLuanException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the e magazine_ binh luan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine_ binh luan
	 * @return the e magazine_ binh luan, or <code>null</code> if a e magazine_ binh luan with the primary key could not be found
	 */
	public static eMagazine_BinhLuan fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the e magazine_ binh luans.
	 *
	 * @return the e magazine_ binh luans
	 */
	public static List<eMagazine_BinhLuan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @return the range of e magazine_ binh luans
	 */
	public static List<eMagazine_BinhLuan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazine_ binh luans
	 */
	public static List<eMagazine_BinhLuan> findAll(
		int start, int end,
		OrderByComparator<eMagazine_BinhLuan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the e magazine_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazine_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazine_ binh luans
	 * @param end the upper bound of the range of e magazine_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazine_ binh luans
	 */
	public static List<eMagazine_BinhLuan> findAll(
		int start, int end,
		OrderByComparator<eMagazine_BinhLuan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the e magazine_ binh luans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of e magazine_ binh luans.
	 *
	 * @return the number of e magazine_ binh luans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static eMagazine_BinhLuanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile eMagazine_BinhLuanPersistence _persistence;

}