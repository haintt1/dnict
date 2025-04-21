/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence;

import com.contact.model.PhongBan;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the phong ban service. This utility wraps <code>com.contact.service.persistence.impl.PhongBanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhongBanPersistence
 * @generated
 */
public class PhongBanUtil {

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
	public static void clearCache(PhongBan phongBan) {
		getPersistence().clearCache(phongBan);
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
	public static Map<Serializable, PhongBan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PhongBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PhongBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PhongBan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PhongBan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PhongBan update(PhongBan phongBan) {
		return getPersistence().update(phongBan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PhongBan update(
		PhongBan phongBan, ServiceContext serviceContext) {

		return getPersistence().update(phongBan, serviceContext);
	}

	/**
	 * Returns all the phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching phong bans
	 */
	public static List<PhongBan> findByten(String ten) {
		return getPersistence().findByten(ten);
	}

	/**
	 * Returns a range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 */
	public static List<PhongBan> findByten(String ten, int start, int end) {
		return getPersistence().findByten(ten, start, end);
	}

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 */
	public static List<PhongBan> findByten(
		String ten, int start, int end,
		OrderByComparator<PhongBan> orderByComparator) {

		return getPersistence().findByten(ten, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phong bans
	 */
	public static List<PhongBan> findByten(
		String ten, int start, int end,
		OrderByComparator<PhongBan> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByten(
			ten, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	public static PhongBan findByten_First(
			String ten, OrderByComparator<PhongBan> orderByComparator)
		throws com.contact.exception.NoSuchPhongBanException {

		return getPersistence().findByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	public static PhongBan fetchByten_First(
		String ten, OrderByComparator<PhongBan> orderByComparator) {

		return getPersistence().fetchByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	public static PhongBan findByten_Last(
			String ten, OrderByComparator<PhongBan> orderByComparator)
		throws com.contact.exception.NoSuchPhongBanException {

		return getPersistence().findByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	public static PhongBan fetchByten_Last(
		String ten, OrderByComparator<PhongBan> orderByComparator) {

		return getPersistence().fetchByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where ten = &#63;.
	 *
	 * @param phongbanId the primary key of the current phong ban
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public static PhongBan[] findByten_PrevAndNext(
			long phongbanId, String ten,
			OrderByComparator<PhongBan> orderByComparator)
		throws com.contact.exception.NoSuchPhongBanException {

		return getPersistence().findByten_PrevAndNext(
			phongbanId, ten, orderByComparator);
	}

	/**
	 * Removes all the phong bans where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByten(String ten) {
		getPersistence().removeByten(ten);
	}

	/**
	 * Returns the number of phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching phong bans
	 */
	public static int countByten(String ten) {
		return getPersistence().countByten(ten);
	}

	/**
	 * Caches the phong ban in the entity cache if it is enabled.
	 *
	 * @param phongBan the phong ban
	 */
	public static void cacheResult(PhongBan phongBan) {
		getPersistence().cacheResult(phongBan);
	}

	/**
	 * Caches the phong bans in the entity cache if it is enabled.
	 *
	 * @param phongBans the phong bans
	 */
	public static void cacheResult(List<PhongBan> phongBans) {
		getPersistence().cacheResult(phongBans);
	}

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param phongbanId the primary key for the new phong ban
	 * @return the new phong ban
	 */
	public static PhongBan create(long phongbanId) {
		return getPersistence().create(phongbanId);
	}

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public static PhongBan remove(long phongbanId)
		throws com.contact.exception.NoSuchPhongBanException {

		return getPersistence().remove(phongbanId);
	}

	public static PhongBan updateImpl(PhongBan phongBan) {
		return getPersistence().updateImpl(phongBan);
	}

	/**
	 * Returns the phong ban with the primary key or throws a <code>NoSuchPhongBanException</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public static PhongBan findByPrimaryKey(long phongbanId)
		throws com.contact.exception.NoSuchPhongBanException {

		return getPersistence().findByPrimaryKey(phongbanId);
	}

	/**
	 * Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	 */
	public static PhongBan fetchByPrimaryKey(long phongbanId) {
		return getPersistence().fetchByPrimaryKey(phongbanId);
	}

	/**
	 * Returns all the phong bans.
	 *
	 * @return the phong bans
	 */
	public static List<PhongBan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 */
	public static List<PhongBan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong bans
	 */
	public static List<PhongBan> findAll(
		int start, int end, OrderByComparator<PhongBan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phong bans
	 */
	public static List<PhongBan> findAll(
		int start, int end, OrderByComparator<PhongBan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the phong bans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PhongBanPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(PhongBanPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile PhongBanPersistence _persistence;

}