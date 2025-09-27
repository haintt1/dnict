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

import vn.dnict.tintuc.exception.NoSuchNews_NguonTinException;
import vn.dnict.tintuc.model.News_NguonTin;

/**
 * The persistence interface for the news_ nguon tin service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_NguonTinUtil
 * @generated
 */
@ProviderType
public interface News_NguonTinPersistence
	extends BasePersistence<News_NguonTin> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_NguonTinUtil} to access the news_ nguon tin persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ nguon tin in the entity cache if it is enabled.
	 *
	 * @param news_NguonTin the news_ nguon tin
	 */
	public void cacheResult(News_NguonTin news_NguonTin);

	/**
	 * Caches the news_ nguon tins in the entity cache if it is enabled.
	 *
	 * @param news_NguonTins the news_ nguon tins
	 */
	public void cacheResult(java.util.List<News_NguonTin> news_NguonTins);

	/**
	 * Creates a new news_ nguon tin with the primary key. Does not add the news_ nguon tin to the database.
	 *
	 * @param id the primary key for the new news_ nguon tin
	 * @return the new news_ nguon tin
	 */
	public News_NguonTin create(long id);

	/**
	 * Removes the news_ nguon tin with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ nguon tin
	 * @return the news_ nguon tin that was removed
	 * @throws NoSuchNews_NguonTinException if a news_ nguon tin with the primary key could not be found
	 */
	public News_NguonTin remove(long id) throws NoSuchNews_NguonTinException;

	public News_NguonTin updateImpl(News_NguonTin news_NguonTin);

	/**
	 * Returns the news_ nguon tin with the primary key or throws a <code>NoSuchNews_NguonTinException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ nguon tin
	 * @return the news_ nguon tin
	 * @throws NoSuchNews_NguonTinException if a news_ nguon tin with the primary key could not be found
	 */
	public News_NguonTin findByPrimaryKey(long id)
		throws NoSuchNews_NguonTinException;

	/**
	 * Returns the news_ nguon tin with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ nguon tin
	 * @return the news_ nguon tin, or <code>null</code> if a news_ nguon tin with the primary key could not be found
	 */
	public News_NguonTin fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ nguon tins.
	 *
	 * @return the news_ nguon tins
	 */
	public java.util.List<News_NguonTin> findAll();

	/**
	 * Returns a range of all the news_ nguon tins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_NguonTinModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ nguon tins
	 * @param end the upper bound of the range of news_ nguon tins (not inclusive)
	 * @return the range of news_ nguon tins
	 */
	public java.util.List<News_NguonTin> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ nguon tins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_NguonTinModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ nguon tins
	 * @param end the upper bound of the range of news_ nguon tins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ nguon tins
	 */
	public java.util.List<News_NguonTin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_NguonTin>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ nguon tins.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_NguonTinModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ nguon tins
	 * @param end the upper bound of the range of news_ nguon tins (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ nguon tins
	 */
	public java.util.List<News_NguonTin> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_NguonTin>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ nguon tins from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ nguon tins.
	 *
	 * @return the number of news_ nguon tins
	 */
	public int countAll();

}