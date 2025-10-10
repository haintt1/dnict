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

import vn.dnict.vanbanphapquy.exception.NoSuchCoquanbanhanhException;
import vn.dnict.vanbanphapquy.model.Coquanbanhanh;

/**
 * The persistence interface for the coquanbanhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CoquanbanhanhUtil
 * @generated
 */
@ProviderType
public interface CoquanbanhanhPersistence
	extends BasePersistence<Coquanbanhanh> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CoquanbanhanhUtil} to access the coquanbanhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findByStatus(int status);

	/**
	 * Returns a range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of matching coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the coquanbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	public Coquanbanhanh findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
				orderByComparator)
		throws NoSuchCoquanbanhanhException;

	/**
	 * Returns the first coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	public Coquanbanhanh fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator);

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a matching coquanbanhanh could not be found
	 */
	public Coquanbanhanh findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
				orderByComparator)
		throws NoSuchCoquanbanhanhException;

	/**
	 * Returns the last coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching coquanbanhanh, or <code>null</code> if a matching coquanbanhanh could not be found
	 */
	public Coquanbanhanh fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator);

	/**
	 * Returns the coquanbanhanhs before and after the current coquanbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current coquanbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public Coquanbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
				orderByComparator)
		throws NoSuchCoquanbanhanhException;

	/**
	 * Removes all the coquanbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of coquanbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching coquanbanhanhs
	 */
	public int countByStatus(int status);

	/**
	 * Caches the coquanbanhanh in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanh the coquanbanhanh
	 */
	public void cacheResult(Coquanbanhanh coquanbanhanh);

	/**
	 * Caches the coquanbanhanhs in the entity cache if it is enabled.
	 *
	 * @param coquanbanhanhs the coquanbanhanhs
	 */
	public void cacheResult(java.util.List<Coquanbanhanh> coquanbanhanhs);

	/**
	 * Creates a new coquanbanhanh with the primary key. Does not add the coquanbanhanh to the database.
	 *
	 * @param id the primary key for the new coquanbanhanh
	 * @return the new coquanbanhanh
	 */
	public Coquanbanhanh create(long id);

	/**
	 * Removes the coquanbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh that was removed
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public Coquanbanhanh remove(long id) throws NoSuchCoquanbanhanhException;

	public Coquanbanhanh updateImpl(Coquanbanhanh coquanbanhanh);

	/**
	 * Returns the coquanbanhanh with the primary key or throws a <code>NoSuchCoquanbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh
	 * @throws NoSuchCoquanbanhanhException if a coquanbanhanh with the primary key could not be found
	 */
	public Coquanbanhanh findByPrimaryKey(long id)
		throws NoSuchCoquanbanhanhException;

	/**
	 * Returns the coquanbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the coquanbanhanh
	 * @return the coquanbanhanh, or <code>null</code> if a coquanbanhanh with the primary key could not be found
	 */
	public Coquanbanhanh fetchByPrimaryKey(long id);

	/**
	 * Returns all the coquanbanhanhs.
	 *
	 * @return the coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findAll();

	/**
	 * Returns a range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @return the range of coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the coquanbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CoquanbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of coquanbanhanhs
	 * @param end the upper bound of the range of coquanbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of coquanbanhanhs
	 */
	public java.util.List<Coquanbanhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Coquanbanhanh>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the coquanbanhanhs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of coquanbanhanhs.
	 *
	 * @return the number of coquanbanhanhs
	 */
	public int countAll();

}