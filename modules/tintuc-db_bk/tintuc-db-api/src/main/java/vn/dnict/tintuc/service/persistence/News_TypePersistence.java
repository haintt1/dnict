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

import vn.dnict.tintuc.exception.NoSuchNews_TypeException;
import vn.dnict.tintuc.model.News_Type;

/**
 * The persistence interface for the news_ type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_TypeUtil
 * @generated
 */
@ProviderType
public interface News_TypePersistence extends BasePersistence<News_Type> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_TypeUtil} to access the news_ type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ type in the entity cache if it is enabled.
	 *
	 * @param news_Type the news_ type
	 */
	public void cacheResult(News_Type news_Type);

	/**
	 * Caches the news_ types in the entity cache if it is enabled.
	 *
	 * @param news_Types the news_ types
	 */
	public void cacheResult(java.util.List<News_Type> news_Types);

	/**
	 * Creates a new news_ type with the primary key. Does not add the news_ type to the database.
	 *
	 * @param id the primary key for the new news_ type
	 * @return the new news_ type
	 */
	public News_Type create(long id);

	/**
	 * Removes the news_ type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type that was removed
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	public News_Type remove(long id) throws NoSuchNews_TypeException;

	public News_Type updateImpl(News_Type news_Type);

	/**
	 * Returns the news_ type with the primary key or throws a <code>NoSuchNews_TypeException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type
	 * @throws NoSuchNews_TypeException if a news_ type with the primary key could not be found
	 */
	public News_Type findByPrimaryKey(long id) throws NoSuchNews_TypeException;

	/**
	 * Returns the news_ type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ type
	 * @return the news_ type, or <code>null</code> if a news_ type with the primary key could not be found
	 */
	public News_Type fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ types.
	 *
	 * @return the news_ types
	 */
	public java.util.List<News_Type> findAll();

	/**
	 * Returns a range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @return the range of news_ types
	 */
	public java.util.List<News_Type> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ types
	 */
	public java.util.List<News_Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Type>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_TypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ types
	 * @param end the upper bound of the range of news_ types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ types
	 */
	public java.util.List<News_Type> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Type>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ types.
	 *
	 * @return the number of news_ types
	 */
	public int countAll();

}