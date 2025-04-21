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

import vn.dnict.tintuc.exception.NoSuchNews_BinhLuanException;
import vn.dnict.tintuc.model.News_BinhLuan;

/**
 * The persistence interface for the news_ binh luan service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_BinhLuanUtil
 * @generated
 */
@ProviderType
public interface News_BinhLuanPersistence
	extends BasePersistence<News_BinhLuan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_BinhLuanUtil} to access the news_ binh luan persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ binh luan in the entity cache if it is enabled.
	 *
	 * @param news_BinhLuan the news_ binh luan
	 */
	public void cacheResult(News_BinhLuan news_BinhLuan);

	/**
	 * Caches the news_ binh luans in the entity cache if it is enabled.
	 *
	 * @param news_BinhLuans the news_ binh luans
	 */
	public void cacheResult(java.util.List<News_BinhLuan> news_BinhLuans);

	/**
	 * Creates a new news_ binh luan with the primary key. Does not add the news_ binh luan to the database.
	 *
	 * @param id the primary key for the new news_ binh luan
	 * @return the new news_ binh luan
	 */
	public News_BinhLuan create(long id);

	/**
	 * Removes the news_ binh luan with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan that was removed
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	public News_BinhLuan remove(long id) throws NoSuchNews_BinhLuanException;

	public News_BinhLuan updateImpl(News_BinhLuan news_BinhLuan);

	/**
	 * Returns the news_ binh luan with the primary key or throws a <code>NoSuchNews_BinhLuanException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan
	 * @throws NoSuchNews_BinhLuanException if a news_ binh luan with the primary key could not be found
	 */
	public News_BinhLuan findByPrimaryKey(long id)
		throws NoSuchNews_BinhLuanException;

	/**
	 * Returns the news_ binh luan with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ binh luan
	 * @return the news_ binh luan, or <code>null</code> if a news_ binh luan with the primary key could not be found
	 */
	public News_BinhLuan fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ binh luans.
	 *
	 * @return the news_ binh luans
	 */
	public java.util.List<News_BinhLuan> findAll();

	/**
	 * Returns a range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @return the range of news_ binh luans
	 */
	public java.util.List<News_BinhLuan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ binh luans
	 */
	public java.util.List<News_BinhLuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_BinhLuan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ binh luans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_BinhLuanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ binh luans
	 * @param end the upper bound of the range of news_ binh luans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ binh luans
	 */
	public java.util.List<News_BinhLuan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_BinhLuan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ binh luans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ binh luans.
	 *
	 * @return the number of news_ binh luans
	 */
	public int countAll();

}