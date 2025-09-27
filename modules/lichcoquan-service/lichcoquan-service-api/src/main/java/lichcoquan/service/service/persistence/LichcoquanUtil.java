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

package lichcoquan.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lichcoquan.service.model.Lichcoquan;

/**
 * The persistence utility for the lichcoquan service. This utility wraps <code>lichcoquan.service.service.persistence.impl.LichcoquanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LichcoquanPersistence
 * @generated
 */
public class LichcoquanUtil {

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
	public static void clearCache(Lichcoquan lichcoquan) {
		getPersistence().clearCache(lichcoquan);
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
	public static Map<Serializable, Lichcoquan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lichcoquan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lichcoquan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lichcoquan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lichcoquan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lichcoquan update(Lichcoquan lichcoquan) {
		return getPersistence().update(lichcoquan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lichcoquan update(
		Lichcoquan lichcoquan, ServiceContext serviceContext) {

		return getPersistence().update(lichcoquan, serviceContext);
	}

	/**
	 * Caches the lichcoquan in the entity cache if it is enabled.
	 *
	 * @param lichcoquan the lichcoquan
	 */
	public static void cacheResult(Lichcoquan lichcoquan) {
		getPersistence().cacheResult(lichcoquan);
	}

	/**
	 * Caches the lichcoquans in the entity cache if it is enabled.
	 *
	 * @param lichcoquans the lichcoquans
	 */
	public static void cacheResult(List<Lichcoquan> lichcoquans) {
		getPersistence().cacheResult(lichcoquans);
	}

	/**
	 * Creates a new lichcoquan with the primary key. Does not add the lichcoquan to the database.
	 *
	 * @param lichCongtacId the primary key for the new lichcoquan
	 * @return the new lichcoquan
	 */
	public static Lichcoquan create(long lichCongtacId) {
		return getPersistence().create(lichCongtacId);
	}

	/**
	 * Removes the lichcoquan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan that was removed
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	public static Lichcoquan remove(long lichCongtacId)
		throws lichcoquan.service.exception.NoSuchLichcoquanException {

		return getPersistence().remove(lichCongtacId);
	}

	public static Lichcoquan updateImpl(Lichcoquan lichcoquan) {
		return getPersistence().updateImpl(lichcoquan);
	}

	/**
	 * Returns the lichcoquan with the primary key or throws a <code>NoSuchLichcoquanException</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan
	 * @throws NoSuchLichcoquanException if a lichcoquan with the primary key could not be found
	 */
	public static Lichcoquan findByPrimaryKey(long lichCongtacId)
		throws lichcoquan.service.exception.NoSuchLichcoquanException {

		return getPersistence().findByPrimaryKey(lichCongtacId);
	}

	/**
	 * Returns the lichcoquan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the lichcoquan
	 * @return the lichcoquan, or <code>null</code> if a lichcoquan with the primary key could not be found
	 */
	public static Lichcoquan fetchByPrimaryKey(long lichCongtacId) {
		return getPersistence().fetchByPrimaryKey(lichCongtacId);
	}

	/**
	 * Returns all the lichcoquans.
	 *
	 * @return the lichcoquans
	 */
	public static List<Lichcoquan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @return the range of lichcoquans
	 */
	public static List<Lichcoquan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lichcoquans
	 */
	public static List<Lichcoquan> findAll(
		int start, int end, OrderByComparator<Lichcoquan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the lichcoquans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LichcoquanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lichcoquans
	 * @param end the upper bound of the range of lichcoquans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lichcoquans
	 */
	public static List<Lichcoquan> findAll(
		int start, int end, OrderByComparator<Lichcoquan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the lichcoquans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of lichcoquans.
	 *
	 * @return the number of lichcoquans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LichcoquanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile LichcoquanPersistence _persistence;

}