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

package vn.dnict.tintuc.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vn.dnict.tintuc.model.News_role;

/**
 * The persistence utility for the news_role service. This utility wraps <code>vn.dnict.tintuc.service.persistence.impl.News_rolePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_rolePersistence
 * @generated
 */
public class News_roleUtil {

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
	public static void clearCache(News_role news_role) {
		getPersistence().clearCache(news_role);
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
	public static Map<Serializable, News_role> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<News_role> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<News_role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<News_role> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<News_role> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static News_role update(News_role news_role) {
		return getPersistence().update(news_role);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static News_role update(
		News_role news_role, ServiceContext serviceContext) {

		return getPersistence().update(news_role, serviceContext);
	}

	/**
	 * Caches the news_role in the entity cache if it is enabled.
	 *
	 * @param news_role the news_role
	 */
	public static void cacheResult(News_role news_role) {
		getPersistence().cacheResult(news_role);
	}

	/**
	 * Caches the news_roles in the entity cache if it is enabled.
	 *
	 * @param news_roles the news_roles
	 */
	public static void cacheResult(List<News_role> news_roles) {
		getPersistence().cacheResult(news_roles);
	}

	/**
	 * Creates a new news_role with the primary key. Does not add the news_role to the database.
	 *
	 * @param id the primary key for the new news_role
	 * @return the new news_role
	 */
	public static News_role create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the news_role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role that was removed
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	public static News_role remove(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_roleException {

		return getPersistence().remove(id);
	}

	public static News_role updateImpl(News_role news_role) {
		return getPersistence().updateImpl(news_role);
	}

	/**
	 * Returns the news_role with the primary key or throws a <code>NoSuchNews_roleException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	public static News_role findByPrimaryKey(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_roleException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the news_role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role, or <code>null</code> if a news_role with the primary key could not be found
	 */
	public static News_role fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the news_roles.
	 *
	 * @return the news_roles
	 */
	public static List<News_role> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @return the range of news_roles
	 */
	public static List<News_role> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_roles
	 */
	public static List<News_role> findAll(
		int start, int end, OrderByComparator<News_role> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_roles
	 */
	public static List<News_role> findAll(
		int start, int end, OrderByComparator<News_role> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the news_roles from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of news_roles.
	 *
	 * @return the number of news_roles
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static News_rolePersistence getPersistence() {
		return _persistence;
	}

	private static volatile News_rolePersistence _persistence;

}