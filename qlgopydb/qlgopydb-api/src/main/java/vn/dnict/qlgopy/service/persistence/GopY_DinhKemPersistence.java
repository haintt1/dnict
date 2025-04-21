/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package vn.dnict.qlgopy.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import vn.dnict.qlgopy.exception.NoSuchGopY_DinhKemException;
import vn.dnict.qlgopy.model.GopY_DinhKem;

/**
 * The persistence interface for the gop y_ dinh kem service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see GopY_DinhKemUtil
 * @generated
 */
@ProviderType
public interface GopY_DinhKemPersistence extends BasePersistence<GopY_DinhKem> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GopY_DinhKemUtil} to access the gop y_ dinh kem persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the gop y_ dinh kem in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKem the gop y_ dinh kem
	 */
	public void cacheResult(GopY_DinhKem gopY_DinhKem);

	/**
	 * Caches the gop y_ dinh kems in the entity cache if it is enabled.
	 *
	 * @param gopY_DinhKems the gop y_ dinh kems
	 */
	public void cacheResult(java.util.List<GopY_DinhKem> gopY_DinhKems);

	/**
	 * Creates a new gop y_ dinh kem with the primary key. Does not add the gop y_ dinh kem to the database.
	 *
	 * @param id the primary key for the new gop y_ dinh kem
	 * @return the new gop y_ dinh kem
	 */
	public GopY_DinhKem create(long id);

	/**
	 * Removes the gop y_ dinh kem with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem that was removed
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	public GopY_DinhKem remove(long id) throws NoSuchGopY_DinhKemException;

	public GopY_DinhKem updateImpl(GopY_DinhKem gopY_DinhKem);

	/**
	 * Returns the gop y_ dinh kem with the primary key or throws a <code>NoSuchGopY_DinhKemException</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem
	 * @throws NoSuchGopY_DinhKemException if a gop y_ dinh kem with the primary key could not be found
	 */
	public GopY_DinhKem findByPrimaryKey(long id)
		throws NoSuchGopY_DinhKemException;

	/**
	 * Returns the gop y_ dinh kem with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the gop y_ dinh kem
	 * @return the gop y_ dinh kem, or <code>null</code> if a gop y_ dinh kem with the primary key could not be found
	 */
	public GopY_DinhKem fetchByPrimaryKey(long id);

	/**
	 * Returns all the gop y_ dinh kems.
	 *
	 * @return the gop y_ dinh kems
	 */
	public java.util.List<GopY_DinhKem> findAll();

	/**
	 * Returns a range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @return the range of gop y_ dinh kems
	 */
	public java.util.List<GopY_DinhKem> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of gop y_ dinh kems
	 */
	public java.util.List<GopY_DinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GopY_DinhKem>
			orderByComparator);

	/**
	 * Returns an ordered range of all the gop y_ dinh kems.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GopY_DinhKemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of gop y_ dinh kems
	 * @param end the upper bound of the range of gop y_ dinh kems (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of gop y_ dinh kems
	 */
	public java.util.List<GopY_DinhKem> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<GopY_DinhKem>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the gop y_ dinh kems from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of gop y_ dinh kems.
	 *
	 * @return the number of gop y_ dinh kems
	 */
	public int countAll();

}