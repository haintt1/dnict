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

package qlanphamdb.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import qlanphamdb.exception.NoSucheMagazineException;

import qlanphamdb.model.eMagazine;

/**
 * The persistence interface for the e magazine service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see eMagazineUtil
 * @generated
 */
@ProviderType
public interface eMagazinePersistence extends BasePersistence<eMagazine> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link eMagazineUtil} to access the e magazine persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the e magazine in the entity cache if it is enabled.
	 *
	 * @param eMagazine the e magazine
	 */
	public void cacheResult(eMagazine eMagazine);

	/**
	 * Caches the e magazines in the entity cache if it is enabled.
	 *
	 * @param eMagazines the e magazines
	 */
	public void cacheResult(java.util.List<eMagazine> eMagazines);

	/**
	 * Creates a new e magazine with the primary key. Does not add the e magazine to the database.
	 *
	 * @param id the primary key for the new e magazine
	 * @return the new e magazine
	 */
	public eMagazine create(long id);

	/**
	 * Removes the e magazine with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine that was removed
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	public eMagazine remove(long id) throws NoSucheMagazineException;

	public eMagazine updateImpl(eMagazine eMagazine);

	/**
	 * Returns the e magazine with the primary key or throws a <code>NoSucheMagazineException</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine
	 * @throws NoSucheMagazineException if a e magazine with the primary key could not be found
	 */
	public eMagazine findByPrimaryKey(long id) throws NoSucheMagazineException;

	/**
	 * Returns the e magazine with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the e magazine
	 * @return the e magazine, or <code>null</code> if a e magazine with the primary key could not be found
	 */
	public eMagazine fetchByPrimaryKey(long id);

	/**
	 * Returns all the e magazines.
	 *
	 * @return the e magazines
	 */
	public java.util.List<eMagazine> findAll();

	/**
	 * Returns a range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @return the range of e magazines
	 */
	public java.util.List<eMagazine> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e magazines
	 */
	public java.util.List<eMagazine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<eMagazine>
			orderByComparator);

	/**
	 * Returns an ordered range of all the e magazines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eMagazineModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of e magazines
	 * @param end the upper bound of the range of e magazines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of e magazines
	 */
	public java.util.List<eMagazine> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<eMagazine>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the e magazines from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of e magazines.
	 *
	 * @return the number of e magazines
	 */
	public int countAll();

}