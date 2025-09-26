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

import vn.dnict.tintuc.exception.NoSuchNews_CategoriesException;
import vn.dnict.tintuc.model.News_Categories;

/**
 * The persistence interface for the news_ categories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_CategoriesUtil
 * @generated
 */
@ProviderType
public interface News_CategoriesPersistence
	extends BasePersistence<News_Categories> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_CategoriesUtil} to access the news_ categories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ categories in the entity cache if it is enabled.
	 *
	 * @param news_Categories the news_ categories
	 */
	public void cacheResult(News_Categories news_Categories);

	/**
	 * Caches the news_ categorieses in the entity cache if it is enabled.
	 *
	 * @param news_Categorieses the news_ categorieses
	 */
	public void cacheResult(java.util.List<News_Categories> news_Categorieses);

	/**
	 * Creates a new news_ categories with the primary key. Does not add the news_ categories to the database.
	 *
	 * @param id the primary key for the new news_ categories
	 * @return the new news_ categories
	 */
	public News_Categories create(long id);

	/**
	 * Removes the news_ categories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ categories
	 * @return the news_ categories that was removed
	 * @throws NoSuchNews_CategoriesException if a news_ categories with the primary key could not be found
	 */
	public News_Categories remove(long id)
		throws NoSuchNews_CategoriesException;

	public News_Categories updateImpl(News_Categories news_Categories);

	/**
	 * Returns the news_ categories with the primary key or throws a <code>NoSuchNews_CategoriesException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ categories
	 * @return the news_ categories
	 * @throws NoSuchNews_CategoriesException if a news_ categories with the primary key could not be found
	 */
	public News_Categories findByPrimaryKey(long id)
		throws NoSuchNews_CategoriesException;

	/**
	 * Returns the news_ categories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ categories
	 * @return the news_ categories, or <code>null</code> if a news_ categories with the primary key could not be found
	 */
	public News_Categories fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ categorieses.
	 *
	 * @return the news_ categorieses
	 */
	public java.util.List<News_Categories> findAll();

	/**
	 * Returns a range of all the news_ categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_CategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ categorieses
	 * @param end the upper bound of the range of news_ categorieses (not inclusive)
	 * @return the range of news_ categorieses
	 */
	public java.util.List<News_Categories> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_CategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ categorieses
	 * @param end the upper bound of the range of news_ categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ categorieses
	 */
	public java.util.List<News_Categories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Categories>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ categorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_CategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ categorieses
	 * @param end the upper bound of the range of news_ categorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ categorieses
	 */
	public java.util.List<News_Categories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Categories>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ categorieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ categorieses.
	 *
	 * @return the number of news_ categorieses
	 */
	public int countAll();

}