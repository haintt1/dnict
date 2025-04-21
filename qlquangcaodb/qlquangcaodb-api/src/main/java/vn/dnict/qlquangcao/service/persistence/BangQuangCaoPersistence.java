/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlquangcao.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlquangcao.exception.NoSuchBangQuangCaoException;
import vn.dnict.qlquangcao.model.BangQuangCao;

/**
 * The persistence interface for the bang quang cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see BangQuangCaoUtil
 * @generated
 */
@ProviderType
public interface BangQuangCaoPersistence extends BasePersistence<BangQuangCao> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BangQuangCaoUtil} to access the bang quang cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the bang quang cao in the entity cache if it is enabled.
	 *
	 * @param bangQuangCao the bang quang cao
	 */
	public void cacheResult(BangQuangCao bangQuangCao);

	/**
	 * Caches the bang quang caos in the entity cache if it is enabled.
	 *
	 * @param bangQuangCaos the bang quang caos
	 */
	public void cacheResult(java.util.List<BangQuangCao> bangQuangCaos);

	/**
	 * Creates a new bang quang cao with the primary key. Does not add the bang quang cao to the database.
	 *
	 * @param id the primary key for the new bang quang cao
	 * @return the new bang quang cao
	 */
	public BangQuangCao create(long id);

	/**
	 * Removes the bang quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao that was removed
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	public BangQuangCao remove(long id) throws NoSuchBangQuangCaoException;

	public BangQuangCao updateImpl(BangQuangCao bangQuangCao);

	/**
	 * Returns the bang quang cao with the primary key or throws a <code>NoSuchBangQuangCaoException</code> if it could not be found.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao
	 * @throws NoSuchBangQuangCaoException if a bang quang cao with the primary key could not be found
	 */
	public BangQuangCao findByPrimaryKey(long id)
		throws NoSuchBangQuangCaoException;

	/**
	 * Returns the bang quang cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the bang quang cao
	 * @return the bang quang cao, or <code>null</code> if a bang quang cao with the primary key could not be found
	 */
	public BangQuangCao fetchByPrimaryKey(long id);

	/**
	 * Returns all the bang quang caos.
	 *
	 * @return the bang quang caos
	 */
	public java.util.List<BangQuangCao> findAll();

	/**
	 * Returns a range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @return the range of bang quang caos
	 */
	public java.util.List<BangQuangCao> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bang quang caos
	 */
	public java.util.List<BangQuangCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BangQuangCao>
			orderByComparator);

	/**
	 * Returns an ordered range of all the bang quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BangQuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of bang quang caos
	 * @param end the upper bound of the range of bang quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of bang quang caos
	 */
	public java.util.List<BangQuangCao> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BangQuangCao>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the bang quang caos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of bang quang caos.
	 *
	 * @return the number of bang quang caos
	 */
	public int countAll();

}