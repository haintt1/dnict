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

import vn.dnict.qlnhuanbut.model.HeSoTheLoai;

/**
 * The persistence utility for the he so the loai service. This utility wraps <code>vn.dnict.qlnhuanbut.service.persistence.impl.HeSoTheLoaiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HeSoTheLoaiPersistence
 * @generated
 */
public class HeSoTheLoaiUtil {

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
	public static void clearCache(HeSoTheLoai heSoTheLoai) {
		getPersistence().clearCache(heSoTheLoai);
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
	public static Map<Serializable, HeSoTheLoai> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<HeSoTheLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<HeSoTheLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<HeSoTheLoai> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<HeSoTheLoai> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static HeSoTheLoai update(HeSoTheLoai heSoTheLoai) {
		return getPersistence().update(heSoTheLoai);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static HeSoTheLoai update(
		HeSoTheLoai heSoTheLoai, ServiceContext serviceContext) {

		return getPersistence().update(heSoTheLoai, serviceContext);
	}

	/**
	 * Caches the he so the loai in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoai the he so the loai
	 */
	public static void cacheResult(HeSoTheLoai heSoTheLoai) {
		getPersistence().cacheResult(heSoTheLoai);
	}

	/**
	 * Caches the he so the loais in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoais the he so the loais
	 */
	public static void cacheResult(List<HeSoTheLoai> heSoTheLoais) {
		getPersistence().cacheResult(heSoTheLoais);
	}

	/**
	 * Creates a new he so the loai with the primary key. Does not add the he so the loai to the database.
	 *
	 * @param id the primary key for the new he so the loai
	 * @return the new he so the loai
	 */
	public static HeSoTheLoai create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the he so the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai that was removed
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	public static HeSoTheLoai remove(long id)
		throws vn.dnict.qlnhuanbut.exception.NoSuchHeSoTheLoaiException {

		return getPersistence().remove(id);
	}

	public static HeSoTheLoai updateImpl(HeSoTheLoai heSoTheLoai) {
		return getPersistence().updateImpl(heSoTheLoai);
	}

	/**
	 * Returns the he so the loai with the primary key or throws a <code>NoSuchHeSoTheLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	public static HeSoTheLoai findByPrimaryKey(long id)
		throws vn.dnict.qlnhuanbut.exception.NoSuchHeSoTheLoaiException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the he so the loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai, or <code>null</code> if a he so the loai with the primary key could not be found
	 */
	public static HeSoTheLoai fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the he so the loais.
	 *
	 * @return the he so the loais
	 */
	public static List<HeSoTheLoai> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @return the range of he so the loais
	 */
	public static List<HeSoTheLoai> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so the loais
	 */
	public static List<HeSoTheLoai> findAll(
		int start, int end, OrderByComparator<HeSoTheLoai> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so the loais
	 */
	public static List<HeSoTheLoai> findAll(
		int start, int end, OrderByComparator<HeSoTheLoai> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the he so the loais from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of he so the loais.
	 *
	 * @return the number of he so the loais
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static HeSoTheLoaiPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(HeSoTheLoaiPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile HeSoTheLoaiPersistence _persistence;

}