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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.tintuc.exception.NoSuchNews_Article2CategoryException;
import vn.dnict.tintuc.model.News_Article2Category;

/**
 * The persistence interface for the news_ article2 category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_Article2CategoryUtil
 * @generated
 */
@ProviderType
public interface News_Article2CategoryPersistence
	extends BasePersistence<News_Article2Category> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_Article2CategoryUtil} to access the news_ article2 category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ article2 category in the entity cache if it is enabled.
	 *
	 * @param news_Article2Category the news_ article2 category
	 */
	public void cacheResult(News_Article2Category news_Article2Category);

	/**
	 * Caches the news_ article2 categories in the entity cache if it is enabled.
	 *
	 * @param news_Article2Categories the news_ article2 categories
	 */
	public void cacheResult(
		java.util.List<News_Article2Category> news_Article2Categories);

	/**
	 * Creates a new news_ article2 category with the primary key. Does not add the news_ article2 category to the database.
	 *
	 * @param id the primary key for the new news_ article2 category
	 * @return the new news_ article2 category
	 */
	public News_Article2Category create(long id);

	/**
	 * Removes the news_ article2 category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category that was removed
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	public News_Article2Category remove(long id)
		throws NoSuchNews_Article2CategoryException;

	public News_Article2Category updateImpl(
		News_Article2Category news_Article2Category);

	/**
	 * Returns the news_ article2 category with the primary key or throws a <code>NoSuchNews_Article2CategoryException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category
	 * @throws NoSuchNews_Article2CategoryException if a news_ article2 category with the primary key could not be found
	 */
	public News_Article2Category findByPrimaryKey(long id)
		throws NoSuchNews_Article2CategoryException;

	/**
	 * Returns the news_ article2 category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ article2 category
	 * @return the news_ article2 category, or <code>null</code> if a news_ article2 category with the primary key could not be found
	 */
	public News_Article2Category fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ article2 categories.
	 *
	 * @return the news_ article2 categories
	 */
	public java.util.List<News_Article2Category> findAll();

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
	public java.util.List<News_Article2Category> findAll(int start, int end);

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
	public java.util.List<News_Article2Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Article2Category>
			orderByComparator);

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
	public java.util.List<News_Article2Category> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Article2Category>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ article2 categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ article2 categories.
	 *
	 * @return the number of news_ article2 categories
	 */
	public int countAll();

}