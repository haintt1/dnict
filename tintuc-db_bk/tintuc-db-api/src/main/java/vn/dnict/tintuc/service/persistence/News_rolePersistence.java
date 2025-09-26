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

import vn.dnict.tintuc.exception.NoSuchNews_roleException;
import vn.dnict.tintuc.model.News_role;

/**
 * The persistence interface for the news_role service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see News_roleUtil
 * @generated
 */
@ProviderType
public interface News_rolePersistence extends BasePersistence<News_role> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link News_roleUtil} to access the news_role persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the news_role in the entity cache if it is enabled.
	 *
	 * @param news_role the news_role
	 */
	public void cacheResult(News_role news_role);

	/**
	 * Caches the news_roles in the entity cache if it is enabled.
	 *
	 * @param news_roles the news_roles
	 */
	public void cacheResult(java.util.List<News_role> news_roles);

	/**
	 * Creates a new news_role with the primary key. Does not add the news_role to the database.
	 *
	 * @param id the primary key for the new news_role
	 * @return the new news_role
	 */
	public News_role create(long id);

	/**
	 * Removes the news_role with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role that was removed
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	public News_role remove(long id) throws NoSuchNews_roleException;

	public News_role updateImpl(News_role news_role);

	/**
	 * Returns the news_role with the primary key or throws a <code>NoSuchNews_roleException</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role
	 * @throws NoSuchNews_roleException if a news_role with the primary key could not be found
	 */
	public News_role findByPrimaryKey(long id) throws NoSuchNews_roleException;

	/**
	 * Returns the news_role with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the news_role
	 * @return the news_role, or <code>null</code> if a news_role with the primary key could not be found
	 */
	public News_role fetchByPrimaryKey(long id);

	/**
	 * Returns all the news_roles.
	 *
	 * @return the news_roles
	 */
	public java.util.List<News_role> findAll();

	/**
	 * Returns a range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @return the range of news_roles
	 */
	public java.util.List<News_role> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of news_roles
	 */
	public java.util.List<News_role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_role>
			orderByComparator);

	/**
	 * Returns an ordered range of all the news_roles.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>News_roleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of news_roles
	 * @param end the upper bound of the range of news_roles (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of news_roles
	 */
	public java.util.List<News_role> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<News_role>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the news_roles from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of news_roles.
	 *
	 * @return the number of news_roles
	 */
	public int countAll();

}