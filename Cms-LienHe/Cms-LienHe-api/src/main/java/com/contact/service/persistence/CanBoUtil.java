/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence;

import com.contact.model.CanBo;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the can bo service. This utility wraps <code>com.contact.service.persistence.impl.CanBoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CanBoPersistence
 * @generated
 */
public class CanBoUtil {

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
	public static void clearCache(CanBo canBo) {
		getPersistence().clearCache(canBo);
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
	public static Map<Serializable, CanBo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CanBo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CanBo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CanBo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CanBo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CanBo update(CanBo canBo) {
		return getPersistence().update(canBo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CanBo update(CanBo canBo, ServiceContext serviceContext) {
		return getPersistence().update(canBo, serviceContext);
	}

	/**
	 * Returns all the can bos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching can bos
	 */
	public static List<CanBo> findByten(String ten) {
		return getPersistence().findByten(ten);
	}

	/**
	 * Returns a range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @return the range of matching can bos
	 */
	public static List<CanBo> findByten(String ten, int start, int end) {
		return getPersistence().findByten(ten, start, end);
	}

	/**
	 * Returns an ordered range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching can bos
	 */
	public static List<CanBo> findByten(
		String ten, int start, int end,
		OrderByComparator<CanBo> orderByComparator) {

		return getPersistence().findByten(ten, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the can bos where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching can bos
	 */
	public static List<CanBo> findByten(
		String ten, int start, int end,
		OrderByComparator<CanBo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByten(
			ten, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching can bo
	 * @throws NoSuchCanBoException if a matching can bo could not be found
	 */
	public static CanBo findByten_First(
			String ten, OrderByComparator<CanBo> orderByComparator)
		throws com.contact.exception.NoSuchCanBoException {

		return getPersistence().findByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the first can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching can bo, or <code>null</code> if a matching can bo could not be found
	 */
	public static CanBo fetchByten_First(
		String ten, OrderByComparator<CanBo> orderByComparator) {

		return getPersistence().fetchByten_First(ten, orderByComparator);
	}

	/**
	 * Returns the last can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching can bo
	 * @throws NoSuchCanBoException if a matching can bo could not be found
	 */
	public static CanBo findByten_Last(
			String ten, OrderByComparator<CanBo> orderByComparator)
		throws com.contact.exception.NoSuchCanBoException {

		return getPersistence().findByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the last can bo in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching can bo, or <code>null</code> if a matching can bo could not be found
	 */
	public static CanBo fetchByten_Last(
		String ten, OrderByComparator<CanBo> orderByComparator) {

		return getPersistence().fetchByten_Last(ten, orderByComparator);
	}

	/**
	 * Returns the can bos before and after the current can bo in the ordered set where ten = &#63;.
	 *
	 * @param canboId the primary key of the current can bo
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next can bo
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	public static CanBo[] findByten_PrevAndNext(
			long canboId, String ten,
			OrderByComparator<CanBo> orderByComparator)
		throws com.contact.exception.NoSuchCanBoException {

		return getPersistence().findByten_PrevAndNext(
			canboId, ten, orderByComparator);
	}

	/**
	 * Removes all the can bos where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public static void removeByten(String ten) {
		getPersistence().removeByten(ten);
	}

	/**
	 * Returns the number of can bos where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching can bos
	 */
	public static int countByten(String ten) {
		return getPersistence().countByten(ten);
	}

	/**
	 * Caches the can bo in the entity cache if it is enabled.
	 *
	 * @param canBo the can bo
	 */
	public static void cacheResult(CanBo canBo) {
		getPersistence().cacheResult(canBo);
	}

	/**
	 * Caches the can bos in the entity cache if it is enabled.
	 *
	 * @param canBos the can bos
	 */
	public static void cacheResult(List<CanBo> canBos) {
		getPersistence().cacheResult(canBos);
	}

	/**
	 * Creates a new can bo with the primary key. Does not add the can bo to the database.
	 *
	 * @param canboId the primary key for the new can bo
	 * @return the new can bo
	 */
	public static CanBo create(long canboId) {
		return getPersistence().create(canboId);
	}

	/**
	 * Removes the can bo with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo that was removed
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	public static CanBo remove(long canboId)
		throws com.contact.exception.NoSuchCanBoException {

		return getPersistence().remove(canboId);
	}

	public static CanBo updateImpl(CanBo canBo) {
		return getPersistence().updateImpl(canBo);
	}

	/**
	 * Returns the can bo with the primary key or throws a <code>NoSuchCanBoException</code> if it could not be found.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo
	 * @throws NoSuchCanBoException if a can bo with the primary key could not be found
	 */
	public static CanBo findByPrimaryKey(long canboId)
		throws com.contact.exception.NoSuchCanBoException {

		return getPersistence().findByPrimaryKey(canboId);
	}

	/**
	 * Returns the can bo with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param canboId the primary key of the can bo
	 * @return the can bo, or <code>null</code> if a can bo with the primary key could not be found
	 */
	public static CanBo fetchByPrimaryKey(long canboId) {
		return getPersistence().fetchByPrimaryKey(canboId);
	}

	/**
	 * Returns all the can bos.
	 *
	 * @return the can bos
	 */
	public static List<CanBo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @return the range of can bos
	 */
	public static List<CanBo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of can bos
	 */
	public static List<CanBo> findAll(
		int start, int end, OrderByComparator<CanBo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the can bos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CanBoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of can bos
	 * @param end the upper bound of the range of can bos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of can bos
	 */
	public static List<CanBo> findAll(
		int start, int end, OrderByComparator<CanBo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the can bos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of can bos.
	 *
	 * @return the number of can bos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CanBoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CanBoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CanBoPersistence _persistence;

}