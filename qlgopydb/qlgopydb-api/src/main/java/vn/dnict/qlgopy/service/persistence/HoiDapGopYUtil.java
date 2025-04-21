/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.qlgopy.model.HoiDapGopY;

/**
 * The persistence utility for the hoi dap gop y service. This utility wraps <code>vn.dnict.qlgopy.service.persistence.impl.HoiDapGopYPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HoiDapGopYPersistence
 * @generated
 */
public class HoiDapGopYUtil {

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
	public static void clearCache(HoiDapGopY hoiDapGopY) {
		getPersistence().clearCache(hoiDapGopY);
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
	public static Map<Serializable, HoiDapGopY> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HoiDapGopY> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HoiDapGopY> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HoiDapGopY> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HoiDapGopY> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HoiDapGopY update(HoiDapGopY hoiDapGopY) {
		return getPersistence().update(hoiDapGopY);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HoiDapGopY update(
		HoiDapGopY hoiDapGopY, ServiceContext serviceContext) {

		return getPersistence().update(hoiDapGopY, serviceContext);
	}

	/**
	 * Caches the hoi dap gop y in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 */
	public static void cacheResult(HoiDapGopY hoiDapGopY) {
		getPersistence().cacheResult(hoiDapGopY);
	}

	/**
	 * Caches the hoi dap gop ies in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopYs the hoi dap gop ies
	 */
	public static void cacheResult(List<HoiDapGopY> hoiDapGopYs) {
		getPersistence().cacheResult(hoiDapGopYs);
	}

	/**
	 * Creates a new hoi dap gop y with the primary key. Does not add the hoi dap gop y to the database.
	 *
	 * @param id the primary key for the new hoi dap gop y
	 * @return the new hoi dap gop y
	 */
	public static HoiDapGopY create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the hoi dap gop y with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	public static HoiDapGopY remove(long id)
		throws vn.dnict.qlgopy.exception.NoSuchHoiDapGopYException {

		return getPersistence().remove(id);
	}

	public static HoiDapGopY updateImpl(HoiDapGopY hoiDapGopY) {
		return getPersistence().updateImpl(hoiDapGopY);
	}

	/**
	 * Returns the hoi dap gop y with the primary key or throws a <code>NoSuchHoiDapGopYException</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	public static HoiDapGopY findByPrimaryKey(long id)
		throws vn.dnict.qlgopy.exception.NoSuchHoiDapGopYException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the hoi dap gop y with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y, or <code>null</code> if a hoi dap gop y with the primary key could not be found
	 */
	public static HoiDapGopY fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the hoi dap gop ies.
	 *
	 * @return the hoi dap gop ies
	 */
	public static List<HoiDapGopY> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @return the range of hoi dap gop ies
	 */
	public static List<HoiDapGopY> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hoi dap gop ies
	 */
	public static List<HoiDapGopY> findAll(
		int start, int end, OrderByComparator<HoiDapGopY> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hoi dap gop ies
	 */
	public static List<HoiDapGopY> findAll(
		int start, int end, OrderByComparator<HoiDapGopY> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the hoi dap gop ies from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of hoi dap gop ies.
	 *
	 * @return the number of hoi dap gop ies
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HoiDapGopYPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HoiDapGopYPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HoiDapGopYPersistence _persistence;

}