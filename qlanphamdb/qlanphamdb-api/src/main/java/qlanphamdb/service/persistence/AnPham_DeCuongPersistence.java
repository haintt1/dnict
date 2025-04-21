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

import qlanphamdb.exception.NoSuchAnPham_DeCuongException;

import qlanphamdb.model.AnPham_DeCuong;

/**
 * The persistence interface for the an pham_ de cuong service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author dnict
 * @see AnPham_DeCuongUtil
 * @generated
 */
@ProviderType
public interface AnPham_DeCuongPersistence
	extends BasePersistence<AnPham_DeCuong> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AnPham_DeCuongUtil} to access the an pham_ de cuong persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the an pham_ de cuong in the entity cache if it is enabled.
	 *
	 * @param anPham_DeCuong the an pham_ de cuong
	 */
	public void cacheResult(AnPham_DeCuong anPham_DeCuong);

	/**
	 * Caches the an pham_ de cuongs in the entity cache if it is enabled.
	 *
	 * @param anPham_DeCuongs the an pham_ de cuongs
	 */
	public void cacheResult(java.util.List<AnPham_DeCuong> anPham_DeCuongs);

	/**
	 * Creates a new an pham_ de cuong with the primary key. Does not add the an pham_ de cuong to the database.
	 *
	 * @param id the primary key for the new an pham_ de cuong
	 * @return the new an pham_ de cuong
	 */
	public AnPham_DeCuong create(long id);

	/**
	 * Removes the an pham_ de cuong with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the an pham_ de cuong
	 * @return the an pham_ de cuong that was removed
	 * @throws NoSuchAnPham_DeCuongException if a an pham_ de cuong with the primary key could not be found
	 */
	public AnPham_DeCuong remove(long id) throws NoSuchAnPham_DeCuongException;

	public AnPham_DeCuong updateImpl(AnPham_DeCuong anPham_DeCuong);

	/**
	 * Returns the an pham_ de cuong with the primary key or throws a <code>NoSuchAnPham_DeCuongException</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ de cuong
	 * @return the an pham_ de cuong
	 * @throws NoSuchAnPham_DeCuongException if a an pham_ de cuong with the primary key could not be found
	 */
	public AnPham_DeCuong findByPrimaryKey(long id)
		throws NoSuchAnPham_DeCuongException;

	/**
	 * Returns the an pham_ de cuong with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the an pham_ de cuong
	 * @return the an pham_ de cuong, or <code>null</code> if a an pham_ de cuong with the primary key could not be found
	 */
	public AnPham_DeCuong fetchByPrimaryKey(long id);

	/**
	 * Returns all the an pham_ de cuongs.
	 *
	 * @return the an pham_ de cuongs
	 */
	public java.util.List<AnPham_DeCuong> findAll();

	/**
	 * Returns a range of all the an pham_ de cuongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DeCuongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ de cuongs
	 * @param end the upper bound of the range of an pham_ de cuongs (not inclusive)
	 * @return the range of an pham_ de cuongs
	 */
	public java.util.List<AnPham_DeCuong> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the an pham_ de cuongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DeCuongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ de cuongs
	 * @param end the upper bound of the range of an pham_ de cuongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of an pham_ de cuongs
	 */
	public java.util.List<AnPham_DeCuong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_DeCuong>
			orderByComparator);

	/**
	 * Returns an ordered range of all the an pham_ de cuongs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AnPham_DeCuongModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of an pham_ de cuongs
	 * @param end the upper bound of the range of an pham_ de cuongs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of an pham_ de cuongs
	 */
	public java.util.List<AnPham_DeCuong> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AnPham_DeCuong>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the an pham_ de cuongs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of an pham_ de cuongs.
	 *
	 * @return the number of an pham_ de cuongs
	 */
	public int countAll();

}