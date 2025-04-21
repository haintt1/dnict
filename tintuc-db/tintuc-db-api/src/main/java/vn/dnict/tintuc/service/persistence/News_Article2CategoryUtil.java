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

import vn.dnict.tintuc.model.News_Article2Category;

/**
 * The persistence utility for the news_ article2 category service. This utility wraps <code>vn.dnict.tintuc.service.persistence.impl.News_Article2CategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_Article2CategoryPersistence
 * @generated
 */
public class News_Article2CategoryUtil {

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
	public static void clearCache(News_Article2Category news_Article2Category) {
		getPersistence().clearCache(news_Article2Category);
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
	public static Map<Serializable, News_Article2Category> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<News_Article2Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<News_Article2Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<News_Article2Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<News_Article2Category> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static News_Article2Category update(
		News_Article2Category news_Article2Category) {

		return getPersistence().update(news_Article2Category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static News_Article2Category update(
		News_Article2Category news_Article2Category,
		ServiceContext serviceContext) {

		return getPersistence().update(news_Article2Category, serviceContext);
	}

	/**
	 * Caches the news_ article2 category in the entity cache if it is enabled.
	 *
	 * @param news_Article2Category the news_ article2 category
	 */
	public static void cacheResult(
		News_Article2Category news_Article2Category) {

		getPersistence().cacheResult(news_Article2Category);
	}

	/**
	 * Caches the news_ article2 categories in the entity cache if it is enabled.
	 *
	 * @param news_Article2Categories the news_ article2 categories
	 */
	public static void cacheResult(
		List<News_Article2Category> news_Article2Categories) {

		getPersistence().cacheResult(news_Article2Categories);
	}

	/**
	 * Creates a new news_ article2 category with the primary key. Does not add the news_ article2 category to the database.
	 *
	 * @param id the primary key for the new news_ article2 category
	 * @return the new news_ article2 category
	 */
	public static News_Article2Category create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the news_ article2 category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category that was removed
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	public static News_Article2Category remove(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_Article2CategoryException {

		return getPersistence().remove(id);
	}

	public static News_Article2Category updateImpl(
		News_Article2Category news_Article2Category) {

		return getPersistence().updateImpl(news_Article2Category);
	}

	/**
	 * Returns the news_ article2 category with the primary key or throws a <code>NoSuchNews_Article2CategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	public static News_Article2Category findByPrimaryKey(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_Article2CategoryException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the news_ article2 category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category, or <code>null</code> if a news_ article2 category with the primary key could not be found
	 */
	public static News_Article2Category fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the news_ article2 categories.
	 *
	 * @return the news_ article2 categories
	 */
	public static List<News_Article2Category> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @return the range of news_ article2 categories
	 */
	public static List<News_Article2Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ article2 categories
	 */
	public static List<News_Article2Category> findAll(
		int start, int end,
		OrderByComparator<News_Article2Category> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the news_ article2 categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_Article2CategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ article2 categories
	 * @param end the upper bound of the range of news_ article2 categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ article2 categories
	 */
	public static List<News_Article2Category> findAll(
		int start, int end,
		OrderByComparator<News_Article2Category> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the news_ article2 categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of news_ article2 categories.
	 *
	 * @return the number of news_ article2 categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static News_Article2CategoryPersistence getPersistence() {
		return _persistence;
	}

	private static volatile News_Article2CategoryPersistence _persistence;

}