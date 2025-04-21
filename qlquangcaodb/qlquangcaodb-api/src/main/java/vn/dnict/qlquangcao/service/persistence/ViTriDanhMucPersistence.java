/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlquangcao.exception.NoSuchViTriDanhMucException;
import vn.dnict.qlquangcao.model.ViTriDanhMuc;

/**
 * The persistence interface for the vi tri danh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see ViTriDanhMucUtil
 * @generated
 */
@ProviderType
public interface ViTriDanhMucPersistence extends BasePersistence<ViTriDanhMuc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViTriDanhMucUtil} to access the vi tri danh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the vi tri danh muc in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMuc the vi tri danh muc
	 */
	public void cacheResult(ViTriDanhMuc viTriDanhMuc);

	/**
	 * Caches the vi tri danh mucs in the entity cache if it is enabled.
	 *
	 * @param viTriDanhMucs the vi tri danh mucs
	 */
	public void cacheResult(java.util.List<ViTriDanhMuc> viTriDanhMucs);

	/**
	 * Creates a new vi tri danh muc with the primary key. Does not add the vi tri danh muc to the database.
	 *
	 * @param id the primary key for the new vi tri danh muc
	 * @return the new vi tri danh muc
	 */
	public ViTriDanhMuc create(long id);

	/**
	 * Removes the vi tri danh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc that was removed
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	public ViTriDanhMuc remove(long id) throws NoSuchViTriDanhMucException;

	public ViTriDanhMuc updateImpl(ViTriDanhMuc viTriDanhMuc);

	/**
	 * Returns the vi tri danh muc with the primary key or throws a <code>NoSuchViTriDanhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc
	 * @throws NoSuchViTriDanhMucException if a vi tri danh muc with the primary key could not be found
	 */
	public ViTriDanhMuc findByPrimaryKey(long id)
		throws NoSuchViTriDanhMucException;

	/**
	 * Returns the vi tri danh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vi tri danh muc
	 * @return the vi tri danh muc, or <code>null</code> if a vi tri danh muc with the primary key could not be found
	 */
	public ViTriDanhMuc fetchByPrimaryKey(long id);

	/**
	 * Returns all the vi tri danh mucs.
	 *
	 * @return the vi tri danh mucs
	 */
	public java.util.List<ViTriDanhMuc> findAll();

	/**
	 * Returns a range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @return the range of vi tri danh mucs
	 */
	public java.util.List<ViTriDanhMuc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vi tri danh mucs
	 */
	public java.util.List<ViTriDanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViTriDanhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the vi tri danh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViTriDanhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of vi tri danh mucs
	 * @param end the upper bound of the range of vi tri danh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vi tri danh mucs
	 */
	public java.util.List<ViTriDanhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ViTriDanhMuc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the vi tri danh mucs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vi tri danh mucs.
	 *
	 * @return the number of vi tri danh mucs
	 */
	public int countAll();

}