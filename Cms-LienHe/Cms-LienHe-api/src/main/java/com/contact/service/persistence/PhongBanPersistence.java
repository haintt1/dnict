/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.contact.service.persistence;

import com.contact.exception.NoSuchPhongBanException;
import com.contact.model.PhongBan;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the phong ban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PhongBanUtil
 * @generated
 */
@ProviderType
public interface PhongBanPersistence extends BasePersistence<PhongBan> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PhongBanUtil} to access the phong ban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the matching phong bans
	 */
	public java.util.List<PhongBan> findByten(String ten);

	/**
	 * Returns a range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of matching phong bans
	 */
	public java.util.List<PhongBan> findByten(String ten, int start, int end);

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching phong bans
	 */
	public java.util.List<PhongBan> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phong bans where ten = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param ten the ten
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching phong bans
	 */
	public java.util.List<PhongBan> findByten(
		String ten, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	public PhongBan findByten_First(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
				orderByComparator)
		throws NoSuchPhongBanException;

	/**
	 * Returns the first phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	public PhongBan fetchByten_First(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator);

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban
	 * @throws NoSuchPhongBanException if a matching phong ban could not be found
	 */
	public PhongBan findByten_Last(
			String ten,
			com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
				orderByComparator)
		throws NoSuchPhongBanException;

	/**
	 * Returns the last phong ban in the ordered set where ten = &#63;.
	 *
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching phong ban, or <code>null</code> if a matching phong ban could not be found
	 */
	public PhongBan fetchByten_Last(
		String ten,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator);

	/**
	 * Returns the phong bans before and after the current phong ban in the ordered set where ten = &#63;.
	 *
	 * @param phongbanId the primary key of the current phong ban
	 * @param ten the ten
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public PhongBan[] findByten_PrevAndNext(
			long phongbanId, String ten,
			com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
				orderByComparator)
		throws NoSuchPhongBanException;

	/**
	 * Removes all the phong bans where ten = &#63; from the database.
	 *
	 * @param ten the ten
	 */
	public void removeByten(String ten);

	/**
	 * Returns the number of phong bans where ten = &#63;.
	 *
	 * @param ten the ten
	 * @return the number of matching phong bans
	 */
	public int countByten(String ten);

	/**
	 * Caches the phong ban in the entity cache if it is enabled.
	 *
	 * @param phongBan the phong ban
	 */
	public void cacheResult(PhongBan phongBan);

	/**
	 * Caches the phong bans in the entity cache if it is enabled.
	 *
	 * @param phongBans the phong bans
	 */
	public void cacheResult(java.util.List<PhongBan> phongBans);

	/**
	 * Creates a new phong ban with the primary key. Does not add the phong ban to the database.
	 *
	 * @param phongbanId the primary key for the new phong ban
	 * @return the new phong ban
	 */
	public PhongBan create(long phongbanId);

	/**
	 * Removes the phong ban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban that was removed
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public PhongBan remove(long phongbanId) throws NoSuchPhongBanException;

	public PhongBan updateImpl(PhongBan phongBan);

	/**
	 * Returns the phong ban with the primary key or throws a <code>NoSuchPhongBanException</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban
	 * @throws NoSuchPhongBanException if a phong ban with the primary key could not be found
	 */
	public PhongBan findByPrimaryKey(long phongbanId)
		throws NoSuchPhongBanException;

	/**
	 * Returns the phong ban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param phongbanId the primary key of the phong ban
	 * @return the phong ban, or <code>null</code> if a phong ban with the primary key could not be found
	 */
	public PhongBan fetchByPrimaryKey(long phongbanId);

	/**
	 * Returns all the phong bans.
	 *
	 * @return the phong bans
	 */
	public java.util.List<PhongBan> findAll();

	/**
	 * Returns a range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @return the range of phong bans
	 */
	public java.util.List<PhongBan> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of phong bans
	 */
	public java.util.List<PhongBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator);

	/**
	 * Returns an ordered range of all the phong bans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PhongBanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of phong bans
	 * @param end the upper bound of the range of phong bans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of phong bans
	 */
	public java.util.List<PhongBan> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PhongBan>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the phong bans from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of phong bans.
	 *
	 * @return the number of phong bans
	 */
	public int countAll();

}