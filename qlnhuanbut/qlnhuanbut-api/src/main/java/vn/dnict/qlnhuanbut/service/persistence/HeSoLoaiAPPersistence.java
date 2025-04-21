/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoLoaiAPException;
import vn.dnict.qlnhuanbut.model.HeSoLoaiAP;

/**
 * The persistence interface for the he so loai ap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HeSoLoaiAPUtil
 * @generated
 */
@ProviderType
public interface HeSoLoaiAPPersistence extends BasePersistence<HeSoLoaiAP> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HeSoLoaiAPUtil} to access the he so loai ap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the he so loai ap in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAP the he so loai ap
	 */
	public void cacheResult(HeSoLoaiAP heSoLoaiAP);

	/**
	 * Caches the he so loai aps in the entity cache if it is enabled.
	 *
	 * @param heSoLoaiAPs the he so loai aps
	 */
	public void cacheResult(java.util.List<HeSoLoaiAP> heSoLoaiAPs);

	/**
	 * Creates a new he so loai ap with the primary key. Does not add the he so loai ap to the database.
	 *
	 * @param id the primary key for the new he so loai ap
	 * @return the new he so loai ap
	 */
	public HeSoLoaiAP create(long id);

	/**
	 * Removes the he so loai ap with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap that was removed
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	public HeSoLoaiAP remove(long id) throws NoSuchHeSoLoaiAPException;

	public HeSoLoaiAP updateImpl(HeSoLoaiAP heSoLoaiAP);

	/**
	 * Returns the he so loai ap with the primary key or throws a <code>NoSuchHeSoLoaiAPException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap
	 * @throws NoSuchHeSoLoaiAPException if a he so loai ap with the primary key could not be found
	 */
	public HeSoLoaiAP findByPrimaryKey(long id)
		throws NoSuchHeSoLoaiAPException;

	/**
	 * Returns the he so loai ap with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so loai ap
	 * @return the he so loai ap, or <code>null</code> if a he so loai ap with the primary key could not be found
	 */
	public HeSoLoaiAP fetchByPrimaryKey(long id);

	/**
	 * Returns all the he so loai aps.
	 *
	 * @return the he so loai aps
	 */
	public java.util.List<HeSoLoaiAP> findAll();

	/**
	 * Returns a range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @return the range of he so loai aps
	 */
	public java.util.List<HeSoLoaiAP> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so loai aps
	 */
	public java.util.List<HeSoLoaiAP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HeSoLoaiAP>
			orderByComparator);

	/**
	 * Returns an ordered range of all the he so loai aps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoLoaiAPModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so loai aps
	 * @param end the upper bound of the range of he so loai aps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so loai aps
	 */
	public java.util.List<HeSoLoaiAP> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HeSoLoaiAP>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the he so loai aps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of he so loai aps.
	 *
	 * @return the number of he so loai aps
	 */
	public int countAll();

}