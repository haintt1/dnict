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

import lichcoquan.service.model.CmsLichCoQuan;

/**
 * The persistence utility for the cms lich co quan service. This utility wraps <code>lichcoquan.service.service.persistence.impl.CmsLichCoQuanPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CmsLichCoQuanPersistence
 * @generated
 */
public class CmsLichCoQuanUtil {

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
	public static void clearCache(CmsLichCoQuan cmsLichCoQuan) {
		getPersistence().clearCache(cmsLichCoQuan);
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
	public static Map<Serializable, CmsLichCoQuan> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CmsLichCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CmsLichCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CmsLichCoQuan> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CmsLichCoQuan> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CmsLichCoQuan update(CmsLichCoQuan cmsLichCoQuan) {
		return getPersistence().update(cmsLichCoQuan);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CmsLichCoQuan update(
		CmsLichCoQuan cmsLichCoQuan, ServiceContext serviceContext) {

		return getPersistence().update(cmsLichCoQuan, serviceContext);
	}

	/**
	 * Caches the cms lich co quan in the entity cache if it is enabled.
	 *
	 * @param cmsLichCoQuan the cms lich co quan
	 */
	public static void cacheResult(CmsLichCoQuan cmsLichCoQuan) {
		getPersistence().cacheResult(cmsLichCoQuan);
	}

	/**
	 * Caches the cms lich co quans in the entity cache if it is enabled.
	 *
	 * @param cmsLichCoQuans the cms lich co quans
	 */
	public static void cacheResult(List<CmsLichCoQuan> cmsLichCoQuans) {
		getPersistence().cacheResult(cmsLichCoQuans);
	}

	/**
	 * Creates a new cms lich co quan with the primary key. Does not add the cms lich co quan to the database.
	 *
	 * @param lichCongtacId the primary key for the new cms lich co quan
	 * @return the new cms lich co quan
	 */
	public static CmsLichCoQuan create(long lichCongtacId) {
		return getPersistence().create(lichCongtacId);
	}

	/**
	 * Removes the cms lich co quan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan that was removed
	 * @throws NoSuchCmsLichCoQuanException if a cms lich co quan with the primary key could not be found
	 */
	public static CmsLichCoQuan remove(long lichCongtacId)
		throws lichcoquan.service.exception.NoSuchCmsLichCoQuanException {

		return getPersistence().remove(lichCongtacId);
	}

	public static CmsLichCoQuan updateImpl(CmsLichCoQuan cmsLichCoQuan) {
		return getPersistence().updateImpl(cmsLichCoQuan);
	}

	/**
	 * Returns the cms lich co quan with the primary key or throws a <code>NoSuchCmsLichCoQuanException</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan
	 * @throws NoSuchCmsLichCoQuanException if a cms lich co quan with the primary key could not be found
	 */
	public static CmsLichCoQuan findByPrimaryKey(long lichCongtacId)
		throws lichcoquan.service.exception.NoSuchCmsLichCoQuanException {

		return getPersistence().findByPrimaryKey(lichCongtacId);
	}

	/**
	 * Returns the cms lich co quan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param lichCongtacId the primary key of the cms lich co quan
	 * @return the cms lich co quan, or <code>null</code> if a cms lich co quan with the primary key could not be found
	 */
	public static CmsLichCoQuan fetchByPrimaryKey(long lichCongtacId) {
		return getPersistence().fetchByPrimaryKey(lichCongtacId);
	}

	/**
	 * Returns all the cms lich co quans.
	 *
	 * @return the cms lich co quans
	 */
	public static List<CmsLichCoQuan> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @return the range of cms lich co quans
	 */
	public static List<CmsLichCoQuan> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of cms lich co quans
	 */
	public static List<CmsLichCoQuan> findAll(
		int start, int end,
		OrderByComparator<CmsLichCoQuan> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the cms lich co quans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CmsLichCoQuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cms lich co quans
	 * @param end the upper bound of the range of cms lich co quans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of cms lich co quans
	 */
	public static List<CmsLichCoQuan> findAll(
		int start, int end, OrderByComparator<CmsLichCoQuan> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the cms lich co quans from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of cms lich co quans.
	 *
	 * @return the number of cms lich co quans
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CmsLichCoQuanPersistence getPersistence() {
		return _persistence;
	}

	private static volatile CmsLichCoQuanPersistence _persistence;

}