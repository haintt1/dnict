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

import qlanphamdb.model.AnPham_TapChi;

/**
 * The persistence utility for the an pham_ tap chi service. This utility wraps <code>qlanphamdb.service.persistence.impl.AnPham_TapChiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_TapChiPersistence
 * @generated
 */
public class AnPham_TapChiUtil {

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
	public static void clearCache(AnPham_TapChi anPham_TapChi) {
		getPersistence().clearCache(anPham_TapChi);
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
	public static Map<Serializable, AnPham_TapChi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnPham_TapChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnPham_TapChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnPham_TapChi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnPham_TapChi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnPham_TapChi update(AnPham_TapChi anPham_TapChi) {
		return getPersistence().update(anPham_TapChi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnPham_TapChi update(
		AnPham_TapChi anPham_TapChi, ServiceContext serviceContext) {

		return getPersistence().update(anPham_TapChi, serviceContext);
	}

	/**
	 * Caches the an pham_ tap chi in the entity cache if it is enabled.
	 *
	 * @param anPham_TapChi the an pham_ tap chi
	 */
	public static void cacheResult(AnPham_TapChi anPham_TapChi) {
		getPersistence().cacheResult(anPham_TapChi);
	}

	/**
	 * Caches the an pham_ tap chis in the entity cache if it is enabled.
	 *
	 * @param anPham_TapChis the an pham_ tap chis
	 */
	public static void cacheResult(List<AnPham_TapChi> anPham_TapChis) {
		getPersistence().cacheResult(anPham_TapChis);
	}

	/**
	 * Creates a new an pham_ tap chi with the primary key. Does not add the an pham_ tap chi to the database.
	 *
	 * @param id the primary key for the new an pham_ tap chi
	 * @return the new an pham_ tap chi
	 */
	public static AnPham_TapChi create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the an pham_ tap chi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ tap chi
	 * @return the an pham_ tap chi that was removed
	 * @throws NoSuchAnPham_TapChiException if a an pham_ tap chi with the primary key could not be found
	 */
	public static AnPham_TapChi remove(long id)
		throws qlanphamdb.exception.NoSuchAnPham_TapChiException {

		return getPersistence().remove(id);
	}

	public static AnPham_TapChi updateImpl(AnPham_TapChi anPham_TapChi) {
		return getPersistence().updateImpl(anPham_TapChi);
	}

	/**
	 * Returns the an pham_ tap chi with the primary key or throws a <code>NoSuchAnPham_TapChiException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ tap chi
	 * @return the an pham_ tap chi
	 * @throws NoSuchAnPham_TapChiException if a an pham_ tap chi with the primary key could not be found
	 */
	public static AnPham_TapChi findByPrimaryKey(long id)
		throws qlanphamdb.exception.NoSuchAnPham_TapChiException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the an pham_ tap chi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ tap chi
	 * @return the an pham_ tap chi, or <code>null</code> if a an pham_ tap chi with the primary key could not be found
	 */
	public static AnPham_TapChi fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the an pham_ tap chis.
	 *
	 * @return the an pham_ tap chis
	 */
	public static List<AnPham_TapChi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the an pham_ tap chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_TapChiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ tap chis
	 * @param end the upper bound of the range of an pham_ tap chis (not inclusive)
	 * @return the range of an pham_ tap chis
	 */
	public static List<AnPham_TapChi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the an pham_ tap chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_TapChiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ tap chis
	 * @param end the upper bound of the range of an pham_ tap chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ tap chis
	 */
	public static List<AnPham_TapChi> findAll(
		int start, int end,
		OrderByComparator<AnPham_TapChi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the an pham_ tap chis.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_TapChiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ tap chis
	 * @param end the upper bound of the range of an pham_ tap chis (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ tap chis
	 */
	public static List<AnPham_TapChi> findAll(
		int start, int end, OrderByComparator<AnPham_TapChi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the an pham_ tap chis from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of an pham_ tap chis.
	 *
	 * @return the number of an pham_ tap chis
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnPham_TapChiPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AnPham_TapChiPersistence _persistence;

}