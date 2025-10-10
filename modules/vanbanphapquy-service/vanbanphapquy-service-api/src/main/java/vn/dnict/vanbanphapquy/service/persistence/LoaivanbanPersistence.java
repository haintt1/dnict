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

import vn.dnict.vanbanphapquy.exception.NoSuchLoaivanbanException;
import vn.dnict.vanbanphapquy.model.Loaivanban;

/**
 * The persistence interface for the loaivanban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BinhNT
 * @see LoaivanbanUtil
 * @generated
 */
@ProviderType
public interface LoaivanbanPersistence extends BasePersistence<Loaivanban> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LoaivanbanUtil} to access the loaivanban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the loaivanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching loaivanbans
	 */
	public java.util.List<Loaivanban> findByStatus(int status);

	/**
	 * Returns a range of all the loaivanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @return the range of matching loaivanbans
	 */
	public java.util.List<Loaivanban> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the loaivanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching loaivanbans
	 */
	public java.util.List<Loaivanban> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loaivanbans where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching loaivanbans
	 */
	public java.util.List<Loaivanban> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first loaivanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loaivanban
	 * @throws NoSuchLoaivanbanException if a matching loaivanban could not be found
	 */
	public Loaivanban findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
				orderByComparator)
		throws NoSuchLoaivanbanException;

	/**
	 * Returns the first loaivanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching loaivanban, or <code>null</code> if a matching loaivanban could not be found
	 */
	public Loaivanban fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator);

	/**
	 * Returns the last loaivanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loaivanban
	 * @throws NoSuchLoaivanbanException if a matching loaivanban could not be found
	 */
	public Loaivanban findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
				orderByComparator)
		throws NoSuchLoaivanbanException;

	/**
	 * Returns the last loaivanban in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching loaivanban, or <code>null</code> if a matching loaivanban could not be found
	 */
	public Loaivanban fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator);

	/**
	 * Returns the loaivanbans before and after the current loaivanban in the ordered set where status = &#63;.
	 *
	 * @param id the primary key of the current loaivanban
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next loaivanban
	 * @throws NoSuchLoaivanbanException if a loaivanban with the primary key could not be found
	 */
	public Loaivanban[] findByStatus_PrevAndNext(
			long id, int status,
			com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
				orderByComparator)
		throws NoSuchLoaivanbanException;

	/**
	 * Removes all the loaivanbans where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of loaivanbans where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching loaivanbans
	 */
	public int countByStatus(int status);

	/**
	 * Caches the loaivanban in the entity cache if it is enabled.
	 *
	 * @param loaivanban the loaivanban
	 */
	public void cacheResult(Loaivanban loaivanban);

	/**
	 * Caches the loaivanbans in the entity cache if it is enabled.
	 *
	 * @param loaivanbans the loaivanbans
	 */
	public void cacheResult(java.util.List<Loaivanban> loaivanbans);

	/**
	 * Creates a new loaivanban with the primary key. Does not add the loaivanban to the database.
	 *
	 * @param id the primary key for the new loaivanban
	 * @return the new loaivanban
	 */
	public Loaivanban create(long id);

	/**
	 * Removes the loaivanban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the loaivanban
	 * @return the loaivanban that was removed
	 * @throws NoSuchLoaivanbanException if a loaivanban with the primary key could not be found
	 */
	public Loaivanban remove(long id) throws NoSuchLoaivanbanException;

	public Loaivanban updateImpl(Loaivanban loaivanban);

	/**
	 * Returns the loaivanban with the primary key or throws a <code>NoSuchLoaivanbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the loaivanban
	 * @return the loaivanban
	 * @throws NoSuchLoaivanbanException if a loaivanban with the primary key could not be found
	 */
	public Loaivanban findByPrimaryKey(long id)
		throws NoSuchLoaivanbanException;

	/**
	 * Returns the loaivanban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the loaivanban
	 * @return the loaivanban, or <code>null</code> if a loaivanban with the primary key could not be found
	 */
	public Loaivanban fetchByPrimaryKey(long id);

	/**
	 * Returns all the loaivanbans.
	 *
	 * @return the loaivanbans
	 */
	public java.util.List<Loaivanban> findAll();

	/**
	 * Returns a range of all the loaivanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @return the range of loaivanbans
	 */
	public java.util.List<Loaivanban> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the loaivanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of loaivanbans
	 */
	public java.util.List<Loaivanban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator);

	/**
	 * Returns an ordered range of all the loaivanbans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LoaivanbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of loaivanbans
	 * @param end the upper bound of the range of loaivanbans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of loaivanbans
	 */
	public java.util.List<Loaivanban> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Loaivanban>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the loaivanbans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of loaivanbans.
	 *
	 * @return the number of loaivanbans
	 */
	public int countAll();

}