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

import vn.dnict.vanbanphapquy.model.dinhkemfile;

/**
 * The persistence utility for the dinhkemfile service. This utility wraps <code>vn.dnict.vanbanphapquy.service.persistence.impl.dinhkemfilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see dinhkemfilePersistence
 * @generated
 */
public class dinhkemfileUtil {

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
	public static void clearCache(dinhkemfile dinhkemfile) {
		getPersistence().clearCache(dinhkemfile);
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
	public static Map<Serializable, dinhkemfile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<dinhkemfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<dinhkemfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<dinhkemfile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<dinhkemfile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static dinhkemfile update(dinhkemfile dinhkemfile) {
		return getPersistence().update(dinhkemfile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static dinhkemfile update(
		dinhkemfile dinhkemfile, ServiceContext serviceContext) {

		return getPersistence().update(dinhkemfile, serviceContext);
	}

	/**
	 * Returns all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @return the matching dinhkemfiles
	 */
	public static List<dinhkemfile> findByObjectId(long ObjectId) {
		return getPersistence().findByObjectId(ObjectId);
	}

	/**
	 * Returns a range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of matching dinhkemfiles
	 */
	public static List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end) {

		return getPersistence().findByObjectId(ObjectId, start, end);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching dinhkemfiles
	 */
	public static List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end,
		OrderByComparator<dinhkemfile> orderByComparator) {

		return getPersistence().findByObjectId(
			ObjectId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles where ObjectId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param ObjectId the object ID
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching dinhkemfiles
	 */
	public static List<dinhkemfile> findByObjectId(
		long ObjectId, int start, int end,
		OrderByComparator<dinhkemfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByObjectId(
			ObjectId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dinhkemfile
	 * @throws NoSuchdinhkemfileException if a matching dinhkemfile could not be found
	 */
	public static dinhkemfile findByObjectId_First(
			long ObjectId, OrderByComparator<dinhkemfile> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException {

		return getPersistence().findByObjectId_First(
			ObjectId, orderByComparator);
	}

	/**
	 * Returns the first dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching dinhkemfile, or <code>null</code> if a matching dinhkemfile could not be found
	 */
	public static dinhkemfile fetchByObjectId_First(
		long ObjectId, OrderByComparator<dinhkemfile> orderByComparator) {

		return getPersistence().fetchByObjectId_First(
			ObjectId, orderByComparator);
	}

	/**
	 * Returns the last dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dinhkemfile
	 * @throws NoSuchdinhkemfileException if a matching dinhkemfile could not be found
	 */
	public static dinhkemfile findByObjectId_Last(
			long ObjectId, OrderByComparator<dinhkemfile> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException {

		return getPersistence().findByObjectId_Last(
			ObjectId, orderByComparator);
	}

	/**
	 * Returns the last dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching dinhkemfile, or <code>null</code> if a matching dinhkemfile could not be found
	 */
	public static dinhkemfile fetchByObjectId_Last(
		long ObjectId, OrderByComparator<dinhkemfile> orderByComparator) {

		return getPersistence().fetchByObjectId_Last(
			ObjectId, orderByComparator);
	}

	/**
	 * Returns the dinhkemfiles before and after the current dinhkemfile in the ordered set where ObjectId = &#63;.
	 *
	 * @param id the primary key of the current dinhkemfile
	 * @param ObjectId the object ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public static dinhkemfile[] findByObjectId_PrevAndNext(
			long id, long ObjectId,
			OrderByComparator<dinhkemfile> orderByComparator)
		throws vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException {

		return getPersistence().findByObjectId_PrevAndNext(
			id, ObjectId, orderByComparator);
	}

	/**
	 * Removes all the dinhkemfiles where ObjectId = &#63; from the database.
	 *
	 * @param ObjectId the object ID
	 */
	public static void removeByObjectId(long ObjectId) {
		getPersistence().removeByObjectId(ObjectId);
	}

	/**
	 * Returns the number of dinhkemfiles where ObjectId = &#63;.
	 *
	 * @param ObjectId the object ID
	 * @return the number of matching dinhkemfiles
	 */
	public static int countByObjectId(long ObjectId) {
		return getPersistence().countByObjectId(ObjectId);
	}

	/**
	 * Caches the dinhkemfile in the entity cache if it is enabled.
	 *
	 * @param dinhkemfile the dinhkemfile
	 */
	public static void cacheResult(dinhkemfile dinhkemfile) {
		getPersistence().cacheResult(dinhkemfile);
	}

	/**
	 * Caches the dinhkemfiles in the entity cache if it is enabled.
	 *
	 * @param dinhkemfiles the dinhkemfiles
	 */
	public static void cacheResult(List<dinhkemfile> dinhkemfiles) {
		getPersistence().cacheResult(dinhkemfiles);
	}

	/**
	 * Creates a new dinhkemfile with the primary key. Does not add the dinhkemfile to the database.
	 *
	 * @param id the primary key for the new dinhkemfile
	 * @return the new dinhkemfile
	 */
	public static dinhkemfile create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the dinhkemfile with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile that was removed
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public static dinhkemfile remove(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException {

		return getPersistence().remove(id);
	}

	public static dinhkemfile updateImpl(dinhkemfile dinhkemfile) {
		return getPersistence().updateImpl(dinhkemfile);
	}

	/**
	 * Returns the dinhkemfile with the primary key or throws a <code>NoSuchdinhkemfileException</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile
	 * @throws NoSuchdinhkemfileException if a dinhkemfile with the primary key could not be found
	 */
	public static dinhkemfile findByPrimaryKey(long id)
		throws vn.dnict.vanbanphapquy.exception.NoSuchdinhkemfileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the dinhkemfile with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dinhkemfile
	 * @return the dinhkemfile, or <code>null</code> if a dinhkemfile with the primary key could not be found
	 */
	public static dinhkemfile fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the dinhkemfiles.
	 *
	 * @return the dinhkemfiles
	 */
	public static List<dinhkemfile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @return the range of dinhkemfiles
	 */
	public static List<dinhkemfile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dinhkemfiles
	 */
	public static List<dinhkemfile> findAll(
		int start, int end, OrderByComparator<dinhkemfile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the dinhkemfiles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>dinhkemfileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinhkemfiles
	 * @param end the upper bound of the range of dinhkemfiles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dinhkemfiles
	 */
	public static List<dinhkemfile> findAll(
		int start, int end, OrderByComparator<dinhkemfile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the dinhkemfiles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of dinhkemfiles.
	 *
	 * @return the number of dinhkemfiles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static dinhkemfilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile dinhkemfilePersistence _persistence;

}