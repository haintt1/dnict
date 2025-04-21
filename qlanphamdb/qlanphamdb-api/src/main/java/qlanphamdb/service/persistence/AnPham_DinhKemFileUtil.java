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

import qlanphamdb.model.AnPham_DinhKemFile;

/**
 * The persistence utility for the an pham_ dinh kem file service. This utility wraps <code>qlanphamdb.service.persistence.impl.AnPham_DinhKemFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_DinhKemFilePersistence
 * @generated
 */
public class AnPham_DinhKemFileUtil {

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
	public static void clearCache(AnPham_DinhKemFile anPham_DinhKemFile) {
		getPersistence().clearCache(anPham_DinhKemFile);
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
	public static Map<Serializable, AnPham_DinhKemFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AnPham_DinhKemFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AnPham_DinhKemFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AnPham_DinhKemFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AnPham_DinhKemFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AnPham_DinhKemFile update(
		AnPham_DinhKemFile anPham_DinhKemFile) {

		return getPersistence().update(anPham_DinhKemFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AnPham_DinhKemFile update(
		AnPham_DinhKemFile anPham_DinhKemFile, ServiceContext serviceContext) {

		return getPersistence().update(anPham_DinhKemFile, serviceContext);
	}

	/**
	 * Caches the an pham_ dinh kem file in the entity cache if it is enabled.
	 *
	 * @param anPham_DinhKemFile the an pham_ dinh kem file
	 */
	public static void cacheResult(AnPham_DinhKemFile anPham_DinhKemFile) {
		getPersistence().cacheResult(anPham_DinhKemFile);
	}

	/**
	 * Caches the an pham_ dinh kem files in the entity cache if it is enabled.
	 *
	 * @param anPham_DinhKemFiles the an pham_ dinh kem files
	 */
	public static void cacheResult(
		List<AnPham_DinhKemFile> anPham_DinhKemFiles) {

		getPersistence().cacheResult(anPham_DinhKemFiles);
	}

	/**
	 * Creates a new an pham_ dinh kem file with the primary key. Does not add the an pham_ dinh kem file to the database.
	 *
	 * @param id the primary key for the new an pham_ dinh kem file
	 * @return the new an pham_ dinh kem file
	 */
	public static AnPham_DinhKemFile create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the an pham_ dinh kem file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was removed
	 * @throws NoSuchAnPham_DinhKemFileException if a an pham_ dinh kem file with the primary key could not be found
	 */
	public static AnPham_DinhKemFile remove(long id)
		throws qlanphamdb.exception.NoSuchAnPham_DinhKemFileException {

		return getPersistence().remove(id);
	}

	public static AnPham_DinhKemFile updateImpl(
		AnPham_DinhKemFile anPham_DinhKemFile) {

		return getPersistence().updateImpl(anPham_DinhKemFile);
	}

	/**
	 * Returns the an pham_ dinh kem file with the primary key or throws a <code>NoSuchAnPham_DinhKemFileException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file
	 * @throws NoSuchAnPham_DinhKemFileException if a an pham_ dinh kem file with the primary key could not be found
	 */
	public static AnPham_DinhKemFile findByPrimaryKey(long id)
		throws qlanphamdb.exception.NoSuchAnPham_DinhKemFileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the an pham_ dinh kem file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file, or <code>null</code> if a an pham_ dinh kem file with the primary key could not be found
	 */
	public static AnPham_DinhKemFile fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the an pham_ dinh kem files.
	 *
	 * @return the an pham_ dinh kem files
	 */
	public static List<AnPham_DinhKemFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @return the range of an pham_ dinh kem files
	 */
	public static List<AnPham_DinhKemFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ dinh kem files
	 */
	public static List<AnPham_DinhKemFile> findAll(
		int start, int end,
		OrderByComparator<AnPham_DinhKemFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ dinh kem files
	 */
	public static List<AnPham_DinhKemFile> findAll(
		int start, int end,
		OrderByComparator<AnPham_DinhKemFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the an pham_ dinh kem files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of an pham_ dinh kem files.
	 *
	 * @return the number of an pham_ dinh kem files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AnPham_DinhKemFilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile AnPham_DinhKemFilePersistence _persistence;

}