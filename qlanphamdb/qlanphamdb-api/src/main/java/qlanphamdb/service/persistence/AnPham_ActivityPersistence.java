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

import qlanphamdb.exception.NoSuchAnPham_ActivityException;

import qlanphamdb.model.AnPham_Activity;

/**
 * The persistence interface for the an pham_ activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_ActivityUtil
 * @generated
 */
@ProviderType
public interface AnPham_ActivityPersistence
	extends BasePersistence<AnPham_Activity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnPham_ActivityUtil} to access the an pham_ activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the an pham_ activity in the entity cache if it is enabled.
	 *
	 * @param anPham_Activity the an pham_ activity
	 */
	public void cacheResult(AnPham_Activity anPham_Activity);

	/**
	 * Caches the an pham_ activities in the entity cache if it is enabled.
	 *
	 * @param anPham_Activities the an pham_ activities
	 */
	public void cacheResult(java.util.List<AnPham_Activity> anPham_Activities);

	/**
	 * Creates a new an pham_ activity with the primary key. Does not add the an pham_ activity to the database.
	 *
	 * @param id the primary key for the new an pham_ activity
	 * @return the new an pham_ activity
	 */
	public AnPham_Activity create(long id);

	/**
	 * Removes the an pham_ activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity that was removed
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	public AnPham_Activity remove(long id)
		throws NoSuchAnPham_ActivityException;

	public AnPham_Activity updateImpl(AnPham_Activity anPham_Activity);

	/**
	 * Returns the an pham_ activity with the primary key or throws a <code>NoSuchAnPham_ActivityException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity
	 * @throws NoSuchAnPham_ActivityException if a an pham_ activity with the primary key could not be found
	 */
	public AnPham_Activity findByPrimaryKey(long id)
		throws NoSuchAnPham_ActivityException;

	/**
	 * Returns the an pham_ activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ activity
	 * @return the an pham_ activity, or <code>null</code> if a an pham_ activity with the primary key could not be found
	 */
	public AnPham_Activity fetchByPrimaryKey(long id);

	/**
	 * Returns all the an pham_ activities.
	 *
	 * @return the an pham_ activities
	 */
	public java.util.List<AnPham_Activity> findAll();

	/**
	 * Returns a range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @return the range of an pham_ activities
	 */
	public java.util.List<AnPham_Activity> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ activities
	 */
	public java.util.List<AnPham_Activity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_Activity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the an pham_ activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_ActivityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ activities
	 * @param end the upper bound of the range of an pham_ activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ activities
	 */
	public java.util.List<AnPham_Activity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_Activity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the an pham_ activities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of an pham_ activities.
	 *
	 * @return the number of an pham_ activities
	 */
	public int countAll();

}