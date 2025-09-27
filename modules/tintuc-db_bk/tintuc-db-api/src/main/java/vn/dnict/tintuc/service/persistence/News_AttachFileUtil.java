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

import vn.dnict.tintuc.model.News_AttachFile;

/**
 * The persistence utility for the news_ attach file service. This utility wraps <code>vn.dnict.tintuc.service.persistence.impl.News_AttachFilePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_AttachFilePersistence
 * @generated
 */
public class News_AttachFileUtil {

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
	public static void clearCache(News_AttachFile news_AttachFile) {
		getPersistence().clearCache(news_AttachFile);
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
	public static Map<Serializable, News_AttachFile> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<News_AttachFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<News_AttachFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<News_AttachFile> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<News_AttachFile> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static News_AttachFile update(News_AttachFile news_AttachFile) {
		return getPersistence().update(news_AttachFile);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static News_AttachFile update(
		News_AttachFile news_AttachFile, ServiceContext serviceContext) {

		return getPersistence().update(news_AttachFile, serviceContext);
	}

	/**
	 * Caches the news_ attach file in the entity cache if it is enabled.
	 *
	 * @param news_AttachFile the news_ attach file
	 */
	public static void cacheResult(News_AttachFile news_AttachFile) {
		getPersistence().cacheResult(news_AttachFile);
	}

	/**
	 * Caches the news_ attach files in the entity cache if it is enabled.
	 *
	 * @param news_AttachFiles the news_ attach files
	 */
	public static void cacheResult(List<News_AttachFile> news_AttachFiles) {
		getPersistence().cacheResult(news_AttachFiles);
	}

	/**
	 * Creates a new news_ attach file with the primary key. Does not add the news_ attach file to the database.
	 *
	 * @param id the primary key for the new news_ attach file
	 * @return the new news_ attach file
	 */
	public static News_AttachFile create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the news_ attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file that was removed
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	public static News_AttachFile remove(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_AttachFileException {

		return getPersistence().remove(id);
	}

	public static News_AttachFile updateImpl(News_AttachFile news_AttachFile) {
		return getPersistence().updateImpl(news_AttachFile);
	}

	/**
	 * Returns the news_ attach file with the primary key or throws a <code>NoSuchNews_AttachFileException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	public static News_AttachFile findByPrimaryKey(long id)
		throws vn.dnict.tintuc.exception.NoSuchNews_AttachFileException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the news_ attach file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file, or <code>null</code> if a news_ attach file with the primary key could not be found
	 */
	public static News_AttachFile fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the news_ attach files.
	 *
	 * @return the news_ attach files
	 */
	public static List<News_AttachFile> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @return the range of news_ attach files
	 */
	public static List<News_AttachFile> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ attach files
	 */
	public static List<News_AttachFile> findAll(
		int start, int end,
		OrderByComparator<News_AttachFile> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the news_ attach files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_AttachFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ attach files
	 * @param end the upper bound of the range of news_ attach files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ attach files
	 */
	public static List<News_AttachFile> findAll(
		int start, int end,
		OrderByComparator<News_AttachFile> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the news_ attach files from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of news_ attach files.
	 *
	 * @return the number of news_ attach files
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static News_AttachFilePersistence getPersistence() {
		return _persistence;
	}

	private static volatile News_AttachFilePersistence _persistence;

}