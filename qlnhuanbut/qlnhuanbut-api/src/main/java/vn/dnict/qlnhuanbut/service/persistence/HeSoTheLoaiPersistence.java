/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlnhuanbut.exception.NoSuchHeSoTheLoaiException;
import vn.dnict.qlnhuanbut.model.HeSoTheLoai;

/**
 * The persistence interface for the he so the loai service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see HeSoTheLoaiUtil
 * @generated
 */
@ProviderType
public interface HeSoTheLoaiPersistence extends BasePersistence<HeSoTheLoai> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HeSoTheLoaiUtil} to access the he so the loai persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the he so the loai in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoai the he so the loai
	 */
	public void cacheResult(HeSoTheLoai heSoTheLoai);

	/**
	 * Caches the he so the loais in the entity cache if it is enabled.
	 *
	 * @param heSoTheLoais the he so the loais
	 */
	public void cacheResult(java.util.List<HeSoTheLoai> heSoTheLoais);

	/**
	 * Creates a new he so the loai with the primary key. Does not add the he so the loai to the database.
	 *
	 * @param id the primary key for the new he so the loai
	 * @return the new he so the loai
	 */
	public HeSoTheLoai create(long id);

	/**
	 * Removes the he so the loai with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai that was removed
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	public HeSoTheLoai remove(long id) throws NoSuchHeSoTheLoaiException;

	public HeSoTheLoai updateImpl(HeSoTheLoai heSoTheLoai);

	/**
	 * Returns the he so the loai with the primary key or throws a <code>NoSuchHeSoTheLoaiException</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai
	 * @throws NoSuchHeSoTheLoaiException if a he so the loai with the primary key could not be found
	 */
	public HeSoTheLoai findByPrimaryKey(long id)
		throws NoSuchHeSoTheLoaiException;

	/**
	 * Returns the he so the loai with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the he so the loai
	 * @return the he so the loai, or <code>null</code> if a he so the loai with the primary key could not be found
	 */
	public HeSoTheLoai fetchByPrimaryKey(long id);

	/**
	 * Returns all the he so the loais.
	 *
	 * @return the he so the loais
	 */
	public java.util.List<HeSoTheLoai> findAll();

	/**
	 * Returns a range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @return the range of he so the loais
	 */
	public java.util.List<HeSoTheLoai> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of he so the loais
	 */
	public java.util.List<HeSoTheLoai> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HeSoTheLoai>
			orderByComparator);

	/**
	 * Returns an ordered range of all the he so the loais.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HeSoTheLoaiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of he so the loais
	 * @param end the upper bound of the range of he so the loais (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of he so the loais
	 */
	public java.util.List<HeSoTheLoai> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<HeSoTheLoai>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the he so the loais from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of he so the loais.
	 *
	 * @return the number of he so the loais
	 */
	public int countAll();

}