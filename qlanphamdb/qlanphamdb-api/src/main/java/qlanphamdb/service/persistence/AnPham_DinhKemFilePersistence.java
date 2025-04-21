/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package qlanphamdb.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import qlanphamdb.exception.NoSuchAnPham_DinhKemFileException;

import qlanphamdb.model.AnPham_DinhKemFile;

/**
 * The persistence interface for the an pham_ dinh kem file service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_DinhKemFileUtil
 * @generated
 */
@ProviderType
public interface AnPham_DinhKemFilePersistence
	extends BasePersistence<AnPham_DinhKemFile> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnPham_DinhKemFileUtil} to access the an pham_ dinh kem file persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the an pham_ dinh kem file in the entity cache if it is enabled.
	 *
	 * @param anPham_DinhKemFile the an pham_ dinh kem file
	 */
	public void cacheResult(AnPham_DinhKemFile anPham_DinhKemFile);

	/**
	 * Caches the an pham_ dinh kem files in the entity cache if it is enabled.
	 *
	 * @param anPham_DinhKemFiles the an pham_ dinh kem files
	 */
	public void cacheResult(
		java.util.List<AnPham_DinhKemFile> anPham_DinhKemFiles);

	/**
	 * Creates a new an pham_ dinh kem file with the primary key. Does not add the an pham_ dinh kem file to the database.
	 *
	 * @param id the primary key for the new an pham_ dinh kem file
	 * @return the new an pham_ dinh kem file
	 */
	public AnPham_DinhKemFile create(long id);

	/**
	 * Removes the an pham_ dinh kem file with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file that was removed
	 * @throws NoSuchAnPham_DinhKemFileException if a an pham_ dinh kem file with the primary key could not be found
	 */
	public AnPham_DinhKemFile remove(long id)
		throws NoSuchAnPham_DinhKemFileException;

	public AnPham_DinhKemFile updateImpl(AnPham_DinhKemFile anPham_DinhKemFile);

	/**
	 * Returns the an pham_ dinh kem file with the primary key or throws a <code>NoSuchAnPham_DinhKemFileException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file
	 * @throws NoSuchAnPham_DinhKemFileException if a an pham_ dinh kem file with the primary key could not be found
	 */
	public AnPham_DinhKemFile findByPrimaryKey(long id)
		throws NoSuchAnPham_DinhKemFileException;

	/**
	 * Returns the an pham_ dinh kem file with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ dinh kem file
	 * @return the an pham_ dinh kem file, or <code>null</code> if a an pham_ dinh kem file with the primary key could not be found
	 */
	public AnPham_DinhKemFile fetchByPrimaryKey(long id);

	/**
	 * Returns all the an pham_ dinh kem files.
	 *
	 * @return the an pham_ dinh kem files
	 */
	public java.util.List<AnPham_DinhKemFile> findAll();

	/**
	 * Returns a range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @return the range of an pham_ dinh kem files
	 */
	public java.util.List<AnPham_DinhKemFile> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ dinh kem files
	 */
	public java.util.List<AnPham_DinhKemFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_DinhKemFile>
			orderByComparator);

	/**
	 * Returns an ordered range of all the an pham_ dinh kem files.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DinhKemFileModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ dinh kem files
	 * @param end the upper bound of the range of an pham_ dinh kem files (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ dinh kem files
	 */
	public java.util.List<AnPham_DinhKemFile> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_DinhKemFile>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the an pham_ dinh kem files from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of an pham_ dinh kem files.
	 *
	 * @return the number of an pham_ dinh kem files
	 */
	public int countAll();

}