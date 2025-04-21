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

import vn.dnict.tintuc.exception.NoSuchNews_AttachFileException;
import vn.dnict.tintuc.model.News_AttachFile;

/**
 * The persistence interface for the news_ attach file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_AttachFileUtil
 * @generated
 */
@ProviderType
public interface News_AttachFilePersistence
	extends BasePersistence<News_AttachFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_AttachFileUtil} to access the news_ attach file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_ attach file in the entity cache if it is enabled.
	 *
	 * @param news_AttachFile the news_ attach file
	 */
	public void cacheResult(News_AttachFile news_AttachFile);

	/**
	 * Caches the news_ attach files in the entity cache if it is enabled.
	 *
	 * @param news_AttachFiles the news_ attach files
	 */
	public void cacheResult(java.util.List<News_AttachFile> news_AttachFiles);

	/**
	 * Creates a new news_ attach file with the primary key. Does not add the news_ attach file to the database.
	 *
	 * @param id the primary key for the new news_ attach file
	 * @return the new news_ attach file
	 */
	public News_AttachFile create(long id);

	/**
	 * Removes the news_ attach file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file that was removed
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	public News_AttachFile remove(long id)
		throws NoSuchNews_AttachFileException;

	public News_AttachFile updateImpl(News_AttachFile news_AttachFile);

	/**
	 * Returns the news_ attach file with the primary key or throws a <code>NoSuchNews_AttachFileException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file
	 * @throws NoSuchNews_AttachFileException if a news_ attach file with the primary key could not be found
	 */
	public News_AttachFile findByPrimaryKey(long id)
		throws NoSuchNews_AttachFileException;

	/**
	 * Returns the news_ attach file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_ attach file
	 * @return the news_ attach file, or <code>null</code> if a news_ attach file with the primary key could not be found
	 */
	public News_AttachFile fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_ attach files.
	 *
	 * @return the news_ attach files
	 */
	public java.util.List<News_AttachFile> findAll();

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
	public java.util.List<News_AttachFile> findAll(int start, int end);

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
	public java.util.List<News_AttachFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_AttachFile>
			orderByComparator);

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
	public java.util.List<News_AttachFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_AttachFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_ attach files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_ attach files.
	 *
	 * @return the number of news_ attach files
	 */
	public int countAll();

}