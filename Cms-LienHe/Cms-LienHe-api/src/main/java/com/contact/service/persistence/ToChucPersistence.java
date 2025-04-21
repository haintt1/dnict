/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence;

import com.contact.exception.NoSuchToChucException;
import com.contact.model.ToChuc;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the to chuc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ToChucUtil
 * @generated
 */
@ProviderType
public interface ToChucPersistence extends BasePersistence<ToChuc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ToChucUtil} to access the to chuc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching to chucs
	 */
	public java.util.List<ToChuc> findByten(String ten);

	/**
	 * Returns a range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of matching to chucs
	 */
	public java.util.List<ToChuc> findByten(String ten, int start, int end);

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching to chucs
	 */
	public java.util.List<ToChuc> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the to chucs where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching to chucs
	 */
	public java.util.List<ToChuc> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	public ToChuc findByten_First(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
				orderByComparator)
		throws NoSuchToChucException;

	/**
	 * Returns the first to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	public ToChuc fetchByten_First(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator);

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc
	 * @throws NoSuchToChucException if a matching to chuc could not be found
	 */
	public ToChuc findByten_Last(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
				orderByComparator)
		throws NoSuchToChucException;

	/**
	 * Returns the last to chuc in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching to chuc, or <code>null</code> if a matching to chuc could not be found
	 */
	public ToChuc fetchByten_Last(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator);

	/**
	 * Returns the to chucs before and after the current to chuc in the ordered set where ten = &#63;.
	 *
	 * @param tochucId the primary key of the current to chuc
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public ToChuc[] findByten_PrevAndNext(
			long tochucId, String ten,
			com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
				orderByComparator)
		throws NoSuchToChucException;

	/**
	 * Removes all the to chucs where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public void removeByten(String ten);

	/**
	 * Returns the number of to chucs where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching to chucs
	 */
	public int countByten(String ten);

	/**
	 * Caches the to chuc in the entity cache if it is enabled.
	 *
	 * @param toChuc the to chuc
	 */
	public void cacheResult(ToChuc toChuc);

	/**
	 * Caches the to chucs in the entity cache if it is enabled.
	 *
	 * @param toChucs the to chucs
	 */
	public void cacheResult(java.util.List<ToChuc> toChucs);

	/**
	 * Creates a new to chuc with the primary key. Does not add the to chuc to the database.
	 *
	 * @param tochucId the primary key for the new to chuc
	 * @return the new to chuc
	 */
	public ToChuc create(long tochucId);

	/**
	 * Removes the to chuc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc that was removed
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public ToChuc remove(long tochucId) throws NoSuchToChucException;

	public ToChuc updateImpl(ToChuc toChuc);

	/**
	 * Returns the to chuc with the primary key or throws a <code>NoSuchToChucException</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc
	 * @throws NoSuchToChucException if a to chuc with the primary key could not be found
	 */
	public ToChuc findByPrimaryKey(long tochucId) throws NoSuchToChucException;

	/**
	 * Returns the to chuc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param tochucId the primary key of the to chuc
	 * @return the to chuc, or <code>null</code> if a to chuc with the primary key could not be found
	 */
	public ToChuc fetchByPrimaryKey(long tochucId);

	/**
	 * Returns all the to chucs.
	 *
	 * @return the to chucs
	 */
	public java.util.List<ToChuc> findAll();

	/**
	 * Returns a range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @return the range of to chucs
	 */
	public java.util.List<ToChuc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of to chucs
	 */
	public java.util.List<ToChuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the to chucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ToChucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of to chucs
	 * @param end the upper bound of the range of to chucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of to chucs
	 */
	public java.util.List<ToChuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ToChuc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the to chucs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of to chucs.
	 *
	 * @return the number of to chucs
	 */
	public int countAll();

}