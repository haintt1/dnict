/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlquangcao.exception.NoSuchNhomKHException;
import vn.dnict.qlquangcao.model.NhomKH;

/**
 * The persistence interface for the nhom kh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see NhomKHUtil
 * @generated
 */
@ProviderType
public interface NhomKHPersistence extends BasePersistence<NhomKH> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NhomKHUtil} to access the nhom kh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the nhom kh in the entity cache if it is enabled.
	 *
	 * @param nhomKH the nhom kh
	 */
	public void cacheResult(NhomKH nhomKH);

	/**
	 * Caches the nhom khs in the entity cache if it is enabled.
	 *
	 * @param nhomKHs the nhom khs
	 */
	public void cacheResult(java.util.List<NhomKH> nhomKHs);

	/**
	 * Creates a new nhom kh with the primary key. Does not add the nhom kh to the database.
	 *
	 * @param id the primary key for the new nhom kh
	 * @return the new nhom kh
	 */
	public NhomKH create(long id);

	/**
	 * Removes the nhom kh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh that was removed
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	public NhomKH remove(long id) throws NoSuchNhomKHException;

	public NhomKH updateImpl(NhomKH nhomKH);

	/**
	 * Returns the nhom kh with the primary key or throws a <code>NoSuchNhomKHException</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh
	 * @throws NoSuchNhomKHException if a nhom kh with the primary key could not be found
	 */
	public NhomKH findByPrimaryKey(long id) throws NoSuchNhomKHException;

	/**
	 * Returns the nhom kh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the nhom kh
	 * @return the nhom kh, or <code>null</code> if a nhom kh with the primary key could not be found
	 */
	public NhomKH fetchByPrimaryKey(long id);

	/**
	 * Returns all the nhom khs.
	 *
	 * @return the nhom khs
	 */
	public java.util.List<NhomKH> findAll();

	/**
	 * Returns a range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @return the range of nhom khs
	 */
	public java.util.List<NhomKH> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of nhom khs
	 */
	public java.util.List<NhomKH> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NhomKH>
			orderByComparator);

	/**
	 * Returns an ordered range of all the nhom khs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NhomKHModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of nhom khs
	 * @param end the upper bound of the range of nhom khs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of nhom khs
	 */
	public java.util.List<NhomKH> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<NhomKH>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the nhom khs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of nhom khs.
	 *
	 * @return the number of nhom khs
	 */
	public int countAll();

}