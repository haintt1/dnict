/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;

/**
 * The persistence utility for the he so loai ap service. This utility wraps <code>vn.dnict.qlnhuanbut.service.persistence.impl.HeSoLoaiAPPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HeSoLoaiAPPersistence
 * @generated
 */
public class HeSoLoaiAPUtil {

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
	public static void clearCache(HeSoLoaiAP heSoLoaiAP) {
		getPersistence().clearCache(heSoLoaiAP);
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
	public static Map<Serializable, HeSoLoaiAP> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HeSoLoaiAP> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HeSoLoaiAP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HeSoLoaiAP> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HeSoLoaiAP> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HeSoLoaiAP update(HeSoLoaiAP heSoLoaiAP) {
		return getPersistence().update(heSoLoaiAP);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HeSoLoaiAP update(
		HeSoLoaiAP heSoLoaiAP, ServiceContext serviceContext) {

		return getPersistence().update(heSoLoaiAP, serviceContext);
	}

	/**
	 * Caches the he so loai ap in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAP the he so loai ap
	 */
	public static void cacheResult(HeSoLoaiAP heSoLoaiAP) {
		getPersistence().cacheResult(heSoLoaiAP);
	}

	/**
	 * Caches the he so loai aps in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAPs the he so loai aps
	 */
	public static void cacheResult(List<HeSoLoaiAP> heSoLoaiAPs) {
		getPersistence().cacheResult(heSoLoaiAPs);
	}

	/**
	 * Creates a new he so loai ap with the primary key. Does not add the he so loai ap to the database.
	 *
	 * @param id the primary key for the new he so loai ap
	 * @return the new he so loai ap
	 */
	public static HeSoLoaiAP create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the he so loai ap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap that was removed
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	public static HeSoLoaiAP remove(long id)
		throws vn.dnict.qlnhuanbut.exception.NoSuchHeSoLoaiAPException {

		return getPersistence().remove(id);
	}

	public static HeSoLoaiAP updateImpl(HeSoLoaiAP heSoLoaiAP) {
		return getPersistence().updateImpl(heSoLoaiAP);
	}

	/**
	 * Returns the he so loai ap with the primary key or throws a <code>NoSuchHeSoLoaiAPException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	public static HeSoLoaiAP findByPrimaryKey(long id)
		throws vn.dnict.qlnhuanbut.exception.NoSuchHeSoLoaiAPException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the he so loai ap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap, or <code>null</code> if a he so loai ap with the primary key could not be found
	 */
	public static HeSoLoaiAP fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the he so loai aps.
	 *
	 * @return the he so loai aps
	 */
	public static List<HeSoLoaiAP> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @return the range of he so loai aps
	 */
	public static List<HeSoLoaiAP> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so loai aps
	 */
	public static List<HeSoLoaiAP> findAll(
		int start, int end, OrderByComparator<HeSoLoaiAP> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so loai aps
	 */
	public static List<HeSoLoaiAP> findAll(
		int start, int end, OrderByComparator<HeSoLoaiAP> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the he so loai aps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of he so loai aps.
	 *
	 * @return the number of he so loai aps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HeSoLoaiAPPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HeSoLoaiAPPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HeSoLoaiAPPersistence _persistence;

}