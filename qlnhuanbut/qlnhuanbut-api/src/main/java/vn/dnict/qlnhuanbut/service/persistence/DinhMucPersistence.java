/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlnhuanbut.exception.NoSuchDinhMucException;
import vn.dnict.qlnhuanbut.model.DinhMuc;

/**
 * The persistence interface for the dinh muc service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see DinhMucUtil
 * @generated
 */
@ProviderType
public interface DinhMucPersistence extends BasePersistence<DinhMuc> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DinhMucUtil} to access the dinh muc persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the dinh muc in the entity cache if it is enabled.
	 *
	 * @param dinhMuc the dinh muc
	 */
	public void cacheResult(DinhMuc dinhMuc);

	/**
	 * Caches the dinh mucs in the entity cache if it is enabled.
	 *
	 * @param dinhMucs the dinh mucs
	 */
	public void cacheResult(java.util.List<DinhMuc> dinhMucs);

	/**
	 * Creates a new dinh muc with the primary key. Does not add the dinh muc to the database.
	 *
	 * @param id the primary key for the new dinh muc
	 * @return the new dinh muc
	 */
	public DinhMuc create(long id);

	/**
	 * Removes the dinh muc with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc that was removed
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	public DinhMuc remove(long id) throws NoSuchDinhMucException;

	public DinhMuc updateImpl(DinhMuc dinhMuc);

	/**
	 * Returns the dinh muc with the primary key or throws a <code>NoSuchDinhMucException</code> if it could not be found.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc
	 * @throws NoSuchDinhMucException if a dinh muc with the primary key could not be found
	 */
	public DinhMuc findByPrimaryKey(long id) throws NoSuchDinhMucException;

	/**
	 * Returns the dinh muc with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the dinh muc
	 * @return the dinh muc, or <code>null</code> if a dinh muc with the primary key could not be found
	 */
	public DinhMuc fetchByPrimaryKey(long id);

	/**
	 * Returns all the dinh mucs.
	 *
	 * @return the dinh mucs
	 */
	public java.util.List<DinhMuc> findAll();

	/**
	 * Returns a range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @return the range of dinh mucs
	 */
	public java.util.List<DinhMuc> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of dinh mucs
	 */
	public java.util.List<DinhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DinhMuc>
			orderByComparator);

	/**
	 * Returns an ordered range of all the dinh mucs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DinhMucModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of dinh mucs
	 * @param end the upper bound of the range of dinh mucs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of dinh mucs
	 */
	public java.util.List<DinhMuc> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DinhMuc>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the dinh mucs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of dinh mucs.
	 *
	 * @return the number of dinh mucs
	 */
	public int countAll();

}