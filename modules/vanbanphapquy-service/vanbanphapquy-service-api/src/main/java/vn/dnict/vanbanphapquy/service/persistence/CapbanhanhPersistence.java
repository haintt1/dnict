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

import vn.dnict.vanbanphapquy.exception.NoSuchCapbanhanhException;
import vn.dnict.vanbanphapquy.model.Capbanhanh;

/**
 * The persistence interface for the capbanhanh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see CapbanhanhUtil
 * @generated
 */
@ProviderType
public interface CapbanhanhPersistence extends BasePersistence<Capbanhanh> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapbanhanhUtil} to access the capbanhanh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching capbanhanhs
	 */
	public java.util.List<Capbanhanh> findByStatus(int status);

	/**
	 * Returns a range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of matching capbanhanhs
	 */
	public java.util.List<Capbanhanh> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching capbanhanhs
	 */
	public java.util.List<Capbanhanh> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the capbanhanhs where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching capbanhanhs
	 */
	public java.util.List<Capbanhanh> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	public Capbanhanh findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
				orderByComparator)
		throws NoSuchCapbanhanhException;

	/**
	 * Returns the first capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	public Capbanhanh fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator);

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh
	 * @throws NoSuchCapbanhanhException if a matching capbanhanh could not be found
	 */
	public Capbanhanh findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
				orderByComparator)
		throws NoSuchCapbanhanhException;

	/**
	 * Returns the last capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capbanhanh, or <code>null</code> if a matching capbanhanh could not be found
	 */
	public Capbanhanh fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator);

	/**
	 * Returns the capbanhanhs before and after the current capbanhanh in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current capbanhanh
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public Capbanhanh[] findByStatus_PrevAndNext(
			long id, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
				orderByComparator)
		throws NoSuchCapbanhanhException;

	/**
	 * Removes all the capbanhanhs where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of capbanhanhs where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching capbanhanhs
	 */
	public int countByStatus(int status);

	/**
	 * Caches the capbanhanh in the entity cache if it is enabled.
	 *
	 * @param capbanhanh the capbanhanh
	 */
	public void cacheResult(Capbanhanh capbanhanh);

	/**
	 * Caches the capbanhanhs in the entity cache if it is enabled.
	 *
	 * @param capbanhanhs the capbanhanhs
	 */
	public void cacheResult(java.util.List<Capbanhanh> capbanhanhs);

	/**
	 * Creates a new capbanhanh with the primary key. Does not add the capbanhanh to the database.
	 *
	 * @param id the primary key for the new capbanhanh
	 * @return the new capbanhanh
	 */
	public Capbanhanh create(long id);

	/**
	 * Removes the capbanhanh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh that was removed
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public Capbanhanh remove(long id) throws NoSuchCapbanhanhException;

	public Capbanhanh updateImpl(Capbanhanh capbanhanh);

	/**
	 * Returns the capbanhanh with the primary key or throws a <code>NoSuchCapbanhanhException</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh
	 * @throws NoSuchCapbanhanhException if a capbanhanh with the primary key could not be found
	 */
	public Capbanhanh findByPrimaryKey(long id)
		throws NoSuchCapbanhanhException;

	/**
	 * Returns the capbanhanh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the capbanhanh
	 * @return the capbanhanh, or <code>null</code> if a capbanhanh with the primary key could not be found
	 */
	public Capbanhanh fetchByPrimaryKey(long id);

	/**
	 * Returns all the capbanhanhs.
	 *
	 * @return the capbanhanhs
	 */
	public java.util.List<Capbanhanh> findAll();

	/**
	 * Returns a range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @return the range of capbanhanhs
	 */
	public java.util.List<Capbanhanh> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of capbanhanhs
	 */
	public java.util.List<Capbanhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator);

	/**
	 * Returns an ordered range of all the capbanhanhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CapbanhanhModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of capbanhanhs
	 * @param end the upper bound of the range of capbanhanhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of capbanhanhs
	 */
	public java.util.List<Capbanhanh> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Capbanhanh>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the capbanhanhs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of capbanhanhs.
	 *
	 * @return the number of capbanhanhs
	 */
	public int countAll();

}