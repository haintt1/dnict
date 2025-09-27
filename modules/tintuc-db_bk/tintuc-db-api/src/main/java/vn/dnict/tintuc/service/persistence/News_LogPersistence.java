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

import vn.dnict.tintuc.exception.NoSuchNews_LogException;
import vn.dnict.tintuc.model.News_Log;

/**
 * The persistence interface for the news_ log service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_LogUtil
 * @generated
 */
@ProviderType
public interface News_LogPersistence extends BasePersistence<News_Log> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_LogUtil} to access the news_ log persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ log in the entity cache if it is enabled.
	 *
	 * @param news_Log the news_ log
	 */
	public void cacheResult(News_Log news_Log);

	/**
	 * Caches the news_ logs in the entity cache if it is enabled.
	 *
	 * @param news_Logs the news_ logs
	 */
	public void cacheResult(java.util.List<News_Log> news_Logs);

	/**
	 * Creates a new news_ log with the primary key. Does not add the news_ log to the database.
	 *
	 * @param id the primary key for the new news_ log
	 * @return the new news_ log
	 */
	public News_Log create(long id);

	/**
	 * Removes the news_ log with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ log
	 * @return the news_ log that was removed
	 * @throws NoSuchNews_LogException if a news_ log with the primary key could not be found
	 */
	public News_Log remove(long id) throws NoSuchNews_LogException;

	public News_Log updateImpl(News_Log news_Log);

	/**
	 * Returns the news_ log with the primary key or throws a <code>NoSuchNews_LogException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ log
	 * @return the news_ log
	 * @throws NoSuchNews_LogException if a news_ log with the primary key could not be found
	 */
	public News_Log findByPrimaryKey(long id) throws NoSuchNews_LogException;

	/**
	 * Returns the news_ log with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ log
	 * @return the news_ log, or <code>null</code> if a news_ log with the primary key could not be found
	 */
	public News_Log fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ logs.
	 *
	 * @return the news_ logs
	 */
	public java.util.List<News_Log> findAll();

	/**
	 * Returns a range of all the news_ logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_LogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ logs
	 * @param end the upper bound of the range of news_ logs (not inclusive)
	 * @return the range of news_ logs
	 */
	public java.util.List<News_Log> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_ logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_LogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ logs
	 * @param end the upper bound of the range of news_ logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_ logs
	 */
	public java.util.List<News_Log> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Log>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_ logs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_LogModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_ logs
	 * @param end the upper bound of the range of news_ logs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_ logs
	 */
	public java.util.List<News_Log> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_Log>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ logs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ logs.
	 *
	 * @return the number of news_ logs
	 */
	public int countAll();

}