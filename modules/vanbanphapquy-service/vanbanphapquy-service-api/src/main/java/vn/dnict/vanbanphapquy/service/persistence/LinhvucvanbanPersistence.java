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

import vn.dnict.vanbanphapquy.exception.NoSuchLinhvucvanbanException;
import vn.dnict.vanbanphapquy.model.Linhvucvanban;

/**
 * The persistence interface for the linhvucvanban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LinhvucvanbanUtil
 * @generated
 */
@ProviderType
public interface LinhvucvanbanPersistence
	extends BasePersistence<Linhvucvanban> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinhvucvanbanUtil} to access the linhvucvanban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the linhvucvanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findByStatus(int status);

	/**
	 * Returns a range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @return the range of matching linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator);

	/**
	 * Returns an ordered range of all the linhvucvanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a matching linhvucvanban could not be found
	 */
	public Linhvucvanban findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
				orderByComparator)
		throws NoSuchLinhvucvanbanException;

	/**
	 * Returns the first linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching linhvucvanban, or <code>null</code> if a matching linhvucvanban could not be found
	 */
	public Linhvucvanban fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator);

	/**
	 * Returns the last linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a matching linhvucvanban could not be found
	 */
	public Linhvucvanban findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
				orderByComparator)
		throws NoSuchLinhvucvanbanException;

	/**
	 * Returns the last linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching linhvucvanban, or <code>null</code> if a matching linhvucvanban could not be found
	 */
	public Linhvucvanban fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator);

	/**
	 * Returns the linhvucvanbans before and after the current linhvucvanban in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current linhvucvanban
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public Linhvucvanban[] findByStatus_PrevAndNext(
			long id, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
				orderByComparator)
		throws NoSuchLinhvucvanbanException;

	/**
	 * Removes all the linhvucvanbans where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of linhvucvanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching linhvucvanbans
	 */
	public int countByStatus(int status);

	/**
	 * Caches the linhvucvanban in the entity cache if it is enabled.
	 *
	 * @param linhvucvanban the linhvucvanban
	 */
	public void cacheResult(Linhvucvanban linhvucvanban);

	/**
	 * Caches the linhvucvanbans in the entity cache if it is enabled.
	 *
	 * @param linhvucvanbans the linhvucvanbans
	 */
	public void cacheResult(java.util.List<Linhvucvanban> linhvucvanbans);

	/**
	 * Creates a new linhvucvanban with the primary key. Does not add the linhvucvanban to the database.
	 *
	 * @param id the primary key for the new linhvucvanban
	 * @return the new linhvucvanban
	 */
	public Linhvucvanban create(long id);

	/**
	 * Removes the linhvucvanban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban that was removed
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public Linhvucvanban remove(long id) throws NoSuchLinhvucvanbanException;

	public Linhvucvanban updateImpl(Linhvucvanban linhvucvanban);

	/**
	 * Returns the linhvucvanban with the primary key or throws a <code>NoSuchLinhvucvanbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban
	 * @throws NoSuchLinhvucvanbanException if a linhvucvanban with the primary key could not be found
	 */
	public Linhvucvanban findByPrimaryKey(long id)
		throws NoSuchLinhvucvanbanException;

	/**
	 * Returns the linhvucvanban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the linhvucvanban
	 * @return the linhvucvanban, or <code>null</code> if a linhvucvanban with the primary key could not be found
	 */
	public Linhvucvanban fetchByPrimaryKey(long id);

	/**
	 * Returns all the linhvucvanbans.
	 *
	 * @return the linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findAll();

	/**
	 * Returns a range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @return the range of linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator);

	/**
	 * Returns an ordered range of all the linhvucvanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LinhvucvanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of linhvucvanbans
	 * @param end the upper bound of the range of linhvucvanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of linhvucvanbans
	 */
	public java.util.List<Linhvucvanban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Linhvucvanban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the linhvucvanbans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of linhvucvanbans.
	 *
	 * @return the number of linhvucvanbans
	 */
	public int countAll();

}