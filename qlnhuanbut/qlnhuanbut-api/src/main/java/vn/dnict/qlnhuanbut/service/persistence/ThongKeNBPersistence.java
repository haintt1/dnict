/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlnhuanbut.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlnhuanbut.exception.NoSuchThongKeNBException;
import vn.dnict.qlnhuanbut.model.ThongKeNB;

/**
 * The persistence interface for the thong ke nb service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see ThongKeNBUtil
 * @generated
 */
@ProviderType
public interface ThongKeNBPersistence extends BasePersistence<ThongKeNB> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ThongKeNBUtil} to access the thong ke nb persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the thong ke nb in the entity cache if it is enabled.
	 *
	 * @param thongKeNB the thong ke nb
	 */
	public void cacheResult(ThongKeNB thongKeNB);

	/**
	 * Caches the thong ke nbs in the entity cache if it is enabled.
	 *
	 * @param thongKeNBs the thong ke nbs
	 */
	public void cacheResult(java.util.List<ThongKeNB> thongKeNBs);

	/**
	 * Creates a new thong ke nb with the primary key. Does not add the thong ke nb to the database.
	 *
	 * @param id the primary key for the new thong ke nb
	 * @return the new thong ke nb
	 */
	public ThongKeNB create(long id);

	/**
	 * Removes the thong ke nb with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb that was removed
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	public ThongKeNB remove(long id) throws NoSuchThongKeNBException;

	public ThongKeNB updateImpl(ThongKeNB thongKeNB);

	/**
	 * Returns the thong ke nb with the primary key or throws a <code>NoSuchThongKeNBException</code> if it could not be found.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb
	 * @throws NoSuchThongKeNBException if a thong ke nb with the primary key could not be found
	 */
	public ThongKeNB findByPrimaryKey(long id) throws NoSuchThongKeNBException;

	/**
	 * Returns the thong ke nb with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the thong ke nb
	 * @return the thong ke nb, or <code>null</code> if a thong ke nb with the primary key could not be found
	 */
	public ThongKeNB fetchByPrimaryKey(long id);

	/**
	 * Returns all the thong ke nbs.
	 *
	 * @return the thong ke nbs
	 */
	public java.util.List<ThongKeNB> findAll();

	/**
	 * Returns a range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @return the range of thong ke nbs
	 */
	public java.util.List<ThongKeNB> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of thong ke nbs
	 */
	public java.util.List<ThongKeNB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongKeNB>
			orderByComparator);

	/**
	 * Returns an ordered range of all the thong ke nbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ThongKeNBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of thong ke nbs
	 * @param end the upper bound of the range of thong ke nbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of thong ke nbs
	 */
	public java.util.List<ThongKeNB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ThongKeNB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the thong ke nbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of thong ke nbs.
	 *
	 * @return the number of thong ke nbs
	 */
	public int countAll();

}