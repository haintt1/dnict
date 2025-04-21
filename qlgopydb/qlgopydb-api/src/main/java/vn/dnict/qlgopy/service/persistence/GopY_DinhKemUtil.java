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

import vn.dnict.qlgopy.model.GopY_DinhKem;

/**
 * The persistence utility for the gop y_ dinh kem service. This utility wraps <code>vn.dnict.qlgopy.service.persistence.impl.GopY_DinhKemPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see GopY_DinhKemPersistence
 * @generated
 */
public class GopY_DinhKemUtil {

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
	public static void clearCache(GopY_DinhKem gopY_DinhKem) {
		getPersistence().clearCache(gopY_DinhKem);
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
	public static Map<Serializable, GopY_DinhKem> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<GopY_DinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<GopY_DinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<GopY_DinhKem> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<GopY_DinhKem> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static GopY_DinhKem update(GopY_DinhKem gopY_DinhKem) {
		return getPersistence().update(gopY_DinhKem);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static GopY_DinhKem update(
		GopY_DinhKem gopY_DinhKem, ServiceContext serviceContext) {

		return getPersistence().update(gopY_DinhKem, serviceContext);
	}

	/**
	 * Caches the gop y_ dinh kem in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 */
	public static void cacheResult(GopY_DinhKem gopY_DinhKem) {
		getPersistence().cacheResult(gopY_DinhKem);
	}

	/**
	 * Caches the gop y_ dinh kems in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKems the gop y_ dinh kems
	 */
	public static void cacheResult(List<GopY_DinhKem> gopY_DinhKems) {
		getPersistence().cacheResult(gopY_DinhKems);
	}

	/**
	 * Creates a new gop y_ dinh kem with the primary key. Does not add the gop y_ dinh kem to the database.
	 *
	 * @param id the primary key for the new gop y_ dinh kem
	 * @return the new gop y_ dinh kem
	 */
	public static GopY_DinhKem create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	public static GopY_DinhKem remove(long id)
		throws vn.dnict.qlgopy.exception.NoSuchGopY_DinhKemException {

		return getPersistence().remove(id);
	}

	public static GopY_DinhKem updateImpl(GopY_DinhKem gopY_DinhKem) {
		return getPersistence().updateImpl(gopY_DinhKem);
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key or throws a <code>NoSuchGopY_DinhKemException</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	public static GopY_DinhKem findByPrimaryKey(long id)
		throws vn.dnict.qlgopy.exception.NoSuchGopY_DinhKemException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the gop y_ dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem, or <code>null</code> if a gop y_ dinh kem with the primary key could not be found
	 */
	public static GopY_DinhKem fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the gop y_ dinh kems.
	 *
	 * @return the gop y_ dinh kems
	 */
	public static List<GopY_DinhKem> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @return the range of gop y_ dinh kems
	 */
	public static List<GopY_DinhKem> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gop y_ dinh kems
	 */
	public static List<GopY_DinhKem> findAll(
		int start, int end, OrderByComparator<GopY_DinhKem> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gop y_ dinh kems
	 */
	public static List<GopY_DinhKem> findAll(
		int start, int end, OrderByComparator<GopY_DinhKem> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the gop y_ dinh kems from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of gop y_ dinh kems.
	 *
	 * @return the number of gop y_ dinh kems
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GopY_DinhKemPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(GopY_DinhKemPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile GopY_DinhKemPersistence _persistence;

}