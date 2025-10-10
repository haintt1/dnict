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

package vn.dnict.vanbanphapquy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.vanbanphapquy.exception.NoSuchVanbanphapquyException;
import vn.dnict.vanbanphapquy.model.Vanbanphapquy;

/**
 * The persistence interface for the vanbanphapquy service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see VanbanphapquyUtil
 * @generated
 */
@ProviderType
public interface VanbanphapquyPersistence
	extends BasePersistence<Vanbanphapquy> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VanbanphapquyUtil} to access the vanbanphapquy persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findByStatus(int status);

	/**
	 * Returns a range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of matching vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the vanbanphapquys where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	public Vanbanphapquy findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
				orderByComparator)
		throws NoSuchVanbanphapquyException;

	/**
	 * Returns the first vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	public Vanbanphapquy fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator);

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a matching vanbanphapquy could not be found
	 */
	public Vanbanphapquy findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
				orderByComparator)
		throws NoSuchVanbanphapquyException;

	/**
	 * Returns the last vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vanbanphapquy, or <code>null</code> if a matching vanbanphapquy could not be found
	 */
	public Vanbanphapquy fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator);

	/**
	 * Returns the vanbanphapquys before and after the current vanbanphapquy in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current vanbanphapquy
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public Vanbanphapquy[] findByStatus_PrevAndNext(
			long id, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
				orderByComparator)
		throws NoSuchVanbanphapquyException;

	/**
	 * Removes all the vanbanphapquys where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of vanbanphapquys where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching vanbanphapquys
	 */
	public int countByStatus(int status);

	/**
	 * Caches the vanbanphapquy in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquy the vanbanphapquy
	 */
	public void cacheResult(Vanbanphapquy vanbanphapquy);

	/**
	 * Caches the vanbanphapquys in the entity cache if it is enabled.
	 *
	 * @param vanbanphapquys the vanbanphapquys
	 */
	public void cacheResult(java.util.List<Vanbanphapquy> vanbanphapquys);

	/**
	 * Creates a new vanbanphapquy with the primary key. Does not add the vanbanphapquy to the database.
	 *
	 * @param id the primary key for the new vanbanphapquy
	 * @return the new vanbanphapquy
	 */
	public Vanbanphapquy create(long id);

	/**
	 * Removes the vanbanphapquy with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy that was removed
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public Vanbanphapquy remove(long id) throws NoSuchVanbanphapquyException;

	public Vanbanphapquy updateImpl(Vanbanphapquy vanbanphapquy);

	/**
	 * Returns the vanbanphapquy with the primary key or throws a <code>NoSuchVanbanphapquyException</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy
	 * @throws NoSuchVanbanphapquyException if a vanbanphapquy with the primary key could not be found
	 */
	public Vanbanphapquy findByPrimaryKey(long id)
		throws NoSuchVanbanphapquyException;

	/**
	 * Returns the vanbanphapquy with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vanbanphapquy
	 * @return the vanbanphapquy, or <code>null</code> if a vanbanphapquy with the primary key could not be found
	 */
	public Vanbanphapquy fetchByPrimaryKey(long id);

	/**
	 * Returns all the vanbanphapquys.
	 *
	 * @return the vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findAll();

	/**
	 * Returns a range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @return the range of vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator);

	/**
	 * Returns an ordered range of all the vanbanphapquys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>VanbanphapquyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vanbanphapquys
	 * @param end the upper bound of the range of vanbanphapquys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vanbanphapquys
	 */
	public java.util.List<Vanbanphapquy> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Vanbanphapquy>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the vanbanphapquys from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vanbanphapquys.
	 *
	 * @return the number of vanbanphapquys
	 */
	public int countAll();

}