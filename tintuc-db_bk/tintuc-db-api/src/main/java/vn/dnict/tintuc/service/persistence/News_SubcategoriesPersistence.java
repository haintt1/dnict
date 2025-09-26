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

import vn.dnict.tintuc.exception.NoSuchNews_SubcategoriesException;
import vn.dnict.tintuc.model.News_Subcategories;

/**
 * The persistence interface for the news_ subcategories service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_SubcategoriesUtil
 * @generated
 */
@ProviderType
public interface News_SubcategoriesPersistence
	extends BasePersistence<News_Subcategories> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_SubcategoriesUtil} to access the news_ subcategories persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ subcategories in the entity cache if it is enabled.
	 *
	 * @param news_Subcategories the news_ subcategories
	 */
	public void cacheResult(News_Subcategories news_Subcategories);

	/**
	 * Caches the news_ subcategorieses in the entity cache if it is enabled.
	 *
	 * @param news_Subcategorieses the news_ subcategorieses
	 */
	public void cacheResult(
		java.util.List<News_Subcategories> news_Subcategorieses);

	/**
	 * Creates a new news_ subcategories with the primary key. Does not add the news_ subcategories to the database.
	 *
	 * @param id the primary key for the new news_ subcategories
	 * @return the new news_ subcategories
	 */
	public News_Subcategories create(long id);

	/**
	 * Removes the news_ subcategories with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories that was removed
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	public News_Subcategories remove(long id)
		throws NoSuchNews_SubcategoriesException;

	public News_Subcategories updateImpl(News_Subcategories news_Subcategories);

	/**
	 * Returns the news_ subcategories with the primary key or throws a <code>NoSuchNews_SubcategoriesException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories
	 * @throws NoSuchNews_SubcategoriesException if a news_ subcategories with the primary key could not be found
	 */
	public News_Subcategories findByPrimaryKey(long id)
		throws NoSuchNews_SubcategoriesException;

	/**
	 * Returns the news_ subcategories with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ subcategories
	 * @return the news_ subcategories, or <code>null</code> if a news_ subcategories with the primary key could not be found
	 */
	public News_Subcategories fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ subcategorieses.
	 *
	 * @return the news_ subcategorieses
	 */
	public java.util.List<News_Subcategories> findAll();

	/**
	 * Returns a range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @return the range of news_ subcategorieses
	 */
	public java.util.List<News_Subcategories> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ subcategorieses
	 */
	public java.util.List<News_Subcategories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Subcategories>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ subcategorieses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_SubcategoriesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ subcategorieses
	 * @param end the upper bound of the range of news_ subcategorieses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ subcategorieses
	 */
	public java.util.List<News_Subcategories> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Subcategories>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ subcategorieses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ subcategorieses.
	 *
	 * @return the number of news_ subcategorieses
	 */
	public int countAll();

}