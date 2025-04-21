/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlgopy.exception.NoSuchHoiDapGopYException;
import vn.dnict.qlgopy.model.HoiDapGopY;

/**
 * The persistence interface for the hoi dap gop y service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HoiDapGopYUtil
 * @generated
 */
@ProviderType
public interface HoiDapGopYPersistence extends BasePersistence<HoiDapGopY> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HoiDapGopYUtil} to access the hoi dap gop y persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the hoi dap gop y in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopY the hoi dap gop y
	 */
	public void cacheResult(HoiDapGopY hoiDapGopY);

	/**
	 * Caches the hoi dap gop ies in the entity cache if it is enabled.
	 *
	 * @param hoiDapGopYs the hoi dap gop ies
	 */
	public void cacheResult(java.util.List<HoiDapGopY> hoiDapGopYs);

	/**
	 * Creates a new hoi dap gop y with the primary key. Does not add the hoi dap gop y to the database.
	 *
	 * @param id the primary key for the new hoi dap gop y
	 * @return the new hoi dap gop y
	 */
	public HoiDapGopY create(long id);

	/**
	 * Removes the hoi dap gop y with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y that was removed
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	public HoiDapGopY remove(long id) throws NoSuchHoiDapGopYException;

	public HoiDapGopY updateImpl(HoiDapGopY hoiDapGopY);

	/**
	 * Returns the hoi dap gop y with the primary key or throws a <code>NoSuchHoiDapGopYException</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y
	 * @throws NoSuchHoiDapGopYException if a hoi dap gop y with the primary key could not be found
	 */
	public HoiDapGopY findByPrimaryKey(long id)
		throws NoSuchHoiDapGopYException;

	/**
	 * Returns the hoi dap gop y with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the hoi dap gop y
	 * @return the hoi dap gop y, or <code>null</code> if a hoi dap gop y with the primary key could not be found
	 */
	public HoiDapGopY fetchByPrimaryKey(long id);

	/**
	 * Returns all the hoi dap gop ies.
	 *
	 * @return the hoi dap gop ies
	 */
	public java.util.List<HoiDapGopY> findAll();

	/**
	 * Returns a range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @return the range of hoi dap gop ies
	 */
	public java.util.List<HoiDapGopY> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hoi dap gop ies
	 */
	public java.util.List<HoiDapGopY> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HoiDapGopY>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hoi dap gop ies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HoiDapGopYModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hoi dap gop ies
	 * @param end the upper bound of the range of hoi dap gop ies (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hoi dap gop ies
	 */
	public java.util.List<HoiDapGopY> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HoiDapGopY>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the hoi dap gop ies from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hoi dap gop ies.
	 *
	 * @return the number of hoi dap gop ies
	 */
	public int countAll();

}