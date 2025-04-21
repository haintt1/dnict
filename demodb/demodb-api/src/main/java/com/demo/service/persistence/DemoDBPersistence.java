/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.service.persistence;

import com.demo.exception.NoSuchDemoDBException;
import com.demo.model.DemoDB;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the demo db service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DemoDBUtil
 * @generated
 */
@ProviderType
public interface DemoDBPersistence extends BasePersistence<DemoDB> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DemoDBUtil} to access the demo db persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the demo db in the entity cache if it is enabled.
	 *
	 * @param demoDB the demo db
	 */
	public void cacheResult(DemoDB demoDB);

	/**
	 * Caches the demo dbs in the entity cache if it is enabled.
	 *
	 * @param demoDBs the demo dbs
	 */
	public void cacheResult(java.util.List<DemoDB> demoDBs);

	/**
	 * Creates a new demo db with the primary key. Does not add the demo db to the database.
	 *
	 * @param id the primary key for the new demo db
	 * @return the new demo db
	 */
	public DemoDB create(long id);

	/**
	 * Removes the demo db with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db that was removed
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	public DemoDB remove(long id) throws NoSuchDemoDBException;

	public DemoDB updateImpl(DemoDB demoDB);

	/**
	 * Returns the demo db with the primary key or throws a <code>NoSuchDemoDBException</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db
	 * @throws NoSuchDemoDBException if a demo db with the primary key could not be found
	 */
	public DemoDB findByPrimaryKey(long id) throws NoSuchDemoDBException;

	/**
	 * Returns the demo db with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the demo db
	 * @return the demo db, or <code>null</code> if a demo db with the primary key could not be found
	 */
	public DemoDB fetchByPrimaryKey(long id);

	/**
	 * Returns all the demo dbs.
	 *
	 * @return the demo dbs
	 */
	public java.util.List<DemoDB> findAll();

	/**
	 * Returns a range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @return the range of demo dbs
	 */
	public java.util.List<DemoDB> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of demo dbs
	 */
	public java.util.List<DemoDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DemoDB>
			orderByComparator);

	/**
	 * Returns an ordered range of all the demo dbs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DemoDBModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of demo dbs
	 * @param end the upper bound of the range of demo dbs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of demo dbs
	 */
	public java.util.List<DemoDB> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DemoDB>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the demo dbs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of demo dbs.
	 *
	 * @return the number of demo dbs
	 */
	public int countAll();

}